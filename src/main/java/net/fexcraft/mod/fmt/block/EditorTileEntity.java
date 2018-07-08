package net.fexcraft.mod.fmt.block;

import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fmt.FMT;
import net.fexcraft.mod.fmt.data.EditorInput;
import net.fexcraft.mod.fmt.data.ModelCompound;
import net.fexcraft.mod.fmt.data.Polygon;
import net.fexcraft.mod.fmt.data.Polygon.PolygonType;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EditorTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	public ModelCompound modeldata = new ModelCompound(new JsonObject());
	public String group = "main", mode;
	public int selected, amount = 1;
	
	public EditorTileEntity(){
		mode = modes[0];
	}
	
	@Override
	public String toString(){
		return this.getPos().toString();
	}
	
    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
        this.readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        try{
            if(modeldata != null){
            	compound.setTag("ModelCompound", modeldata.toNBTTagCompound());
            }
        }
        catch(Exception e){
			e.printStackTrace();
		}
        if(Static.dev()){
            Print.log("WRITING " + compound.toString());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(Static.dev()){
        	Print.log("READING " + compound.toString());
        }
        try{
        	modeldata = ModelCompound.fromNBTTagCompound(compound.getCompoundTag("ModelCompound"));
        }
        catch(Exception e){
        	e.printStackTrace();
        	Static.stop();
        }
    }

    @Override
    public void processServerPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("task")){
            switch(packet.nbt.getString("task")){
	            case "input":{
	            	this.onKeyPress(EditorInput.valueOf(packet.nbt.getString("input")), false);
	            	this.markDirty();
	            	break;
	            }
	            case "open_gui":{
	            	EntityPlayer player = Static.getServer().getPlayerList().getPlayerByUUID(UUID.fromString(packet.nbt.getString("player")));
	            	int i = 0;
	            	for(int j = 0; j < modes.length; j++){
	            		if(modes[j].equals(mode)){ i = j; }
	            	}
	            	if(player != null){
	            		player.openGui(FMT.INSTANCE, i, world, pos.getX(), pos.getY(), pos.getZ());
	            	}
	            	break;
	            }
			}
        }
        return;
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
    	if(packet.nbt.hasKey("mode")){
    		mode = packet.nbt.getString("mode");
    		return;
    	}
        if(packet.nbt.hasKey("task")){
        	group = packet.nbt.getString("group");
        	if(!modeldata.polygons.containsKey(group)){
        		modeldata.polygons.put(group, new ArrayList<>());
        	}
        	selected = packet.nbt.getInteger("selected");
            switch(packet.nbt.getString("task")){
	            case "new":{
            		modeldata.polygons.get(group).add(new Polygon(modeldata));
            		selected = modeldata.polygons.size() - 1;
	            	break;
	            }
	            case "update_polygon":{
	            	String group = packet.nbt.getString("group");
	            	if(!modeldata.polygons.containsKey(group)){
	            		modeldata.polygons.put(group, new ArrayList<>());
	            	}
            		modeldata.polygons.get(group).set(selected, new Polygon(modeldata, JsonUtil.getObjectFromString(packet.nbt.getString("polygon"))));
	            	break;
	            }
	            case "remove": case "rem": case "delete":
	            case "del":{
            		modeldata.polygons.get(group).remove(selected);
	            	break;
	            }
            }
            modeldata.refreshTMT(group, selected);
        }
        else{
            this.readFromNBT(packet.nbt);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public boolean canRenderBreaking(){
        return true;
    }
    
    private NBTTagCompound getCompoundPacket(String string, EditorInput input){
    	NBTTagCompound compound = new NBTTagCompound();
    	compound.setString("task", string);
    	if(input != null){
    		compound.setString("input", input.name());
    	}
    	return compound;
    }

	public void onKeyPress(EditorInput input, boolean remote){
		if(remote){
			PacketHandler.getInstance().sendToServer(new PacketTileEntityUpdate(world.provider.getDimension(), pos, getCompoundPacket("input", input)));
			return;
		}
		if(group != null && !modeldata.polygons.containsKey(group)){ group = null; }
		if(group == null){
			if(modeldata.polygons.size() <= 0){
				group = "body";
				modeldata.polygons.put("body", new ArrayList<>());
			}
			else{
				group = modeldata.polygons.firstEntry().getKey();
			}
		}
		if(selected > modeldata.polygons.get(group).size()){
			selected = modeldata.polygons.get(group).size() - 1;
			selected = selected < 0 ? 0 : selected;
		}
		Polygon pol = getPolygon();
		switch(input){
			case ADD_X: move(Axis.X,  amount, pol); break;
			case ADD_Y: move(Axis.Y,  amount, pol); break;
			case ADD_Z: move(Axis.Z,  amount, pol); break;
			case SUB_X: move(Axis.X, -amount, pol); break;
			case SUB_Y: move(Axis.Y, -amount, pol); break;
			case SUB_Z: move(Axis.Z, -amount, pol); break;
			case ARROW_DOWN: moveArrow(EnumFacing.DOWN, pol); break;
			case ARROW_LEFT: moveArrow(EnumFacing.WEST, pol); break;
			case ARROW_RIGHT: moveArrow(EnumFacing.EAST, pol); break;
			case ARROW_UP: moveArrow(EnumFacing.UP, pol); break;
			case NEW:
				modeldata.polygons.get(group).add(new Polygon(modeldata));
				this.sendUpdate("new", group, selected = modeldata.polygons.get(group).size() - 1, null);
				break;
			case DEL:
				modeldata.polygons.get(group).remove(selected);
				this.sendUpdate("del", group, selected, null);
				break;
			default:
				break;
		}
	}
	
	public static final String[] modes = new String[]{ "move", "offset", "resize", "rotation", "texture", "type", "bools", "cylinder", "cylinder2",
		"shapebox_corner_0", "shapebox_corner_1", "shapebox_corner_2", "shapebox_corner_3",
		"shapebox_corner_4", "shapebox_corner_5", "shapebox_corner_6", "shapebox_corner_7"};

	private void moveArrow(EnumFacing dir, Polygon pol){
		if(!dir.getAxis().isVertical()){
			boolean bool = dir == EnumFacing.WEST;
			switch(mode){
				case "move":{
					if(!bool){
						mode = "offset";
					}
					else{
						if(pol.type.isCylinder()){
							mode = "cylinder2";
						}
						else if(pol.type.isShapebox()){
							mode = "shapebox_corner_7";
						}
						else{
							mode = "bools";
						}
					}
					break;
				}
				case "offset":{
					mode = bool ? "move" : "resize";
					break;
				}
				case "resize":{
					mode = bool ? "offset" : "rotation";
					break;
				}
				case "rotation":{
					mode = bool ? "resize" : "texture";
					break;
				}
				case "texture":{
					mode = bool ? "rotation" : "type";
					break;
				}
				case "type":{
					mode = bool ? "texture" : "bools";
					break;
				}
				case "bools":{
					if(bool){
						mode = "type";
					}
					else{
						if(pol.type.isCylinder()){
							mode = "cylinder";
						}
						else if(pol.type.isShapebox()){
							mode = "shapebox_corner_0";
						}
						else{
							mode = "move";
						}
					}
					break;
				}
				case "cylinder":{
					mode = bool ? "bools" : pol.type.isCylinder() ? "cylinder2" : pol.type.isBox() ? "move" : "shapebox_corner_0";
					break;
				}
				case "cylinder2":{
					mode = bool ? (pol.type.isCylinder() ? "cylinder" : "bools") : "move";
					break;
				}
				case "shapebox_corner_0":{
					mode = bool ? "bools" : "shapebox_corner_1";
					break;
				}
				case "shapebox_corner_1":{
					mode = bool ? "shapebox_corner_0" : "shapebox_corner_2";
					break;
				}
				case "shapebox_corner_2":{
					mode = bool ? "shapebox_corner_1" : "shapebox_corner_3";
					break;
				}
				case "shapebox_corner_3":{
					mode = bool ? "shapebox_corner_2" : "shapebox_corner_4";
					break;
				}
				case "shapebox_corner_4":{
					mode = bool ? "shapebox_corner_3" : "shapebox_corner_5";
					break;
				}
				case "shapebox_corner_5":{
					mode = bool ? "shapebox_corner_4" : "shapebox_corner_6";
					break;
				}
				case "shapebox_corner_6":{
					mode = bool ? "shapebox_corner_5" : "shapebox_corner_7";
					break;
				}
				case "shapebox_corner_7":{
					mode = bool ? "shapebox_corner_6" : "move";
					break;
				}
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("mode", mode);
			ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
		}
		else{
			selected += dir == EnumFacing.UP ? -1 : 1;
			selected = selected >= modeldata.polygons.get(group).size() ? modeldata.polygons.get(group).size() - 1 : selected < 0 ? 0 : selected;
			this.sendUpdate("update_selection", group, selected, null);
		}
	}

	public String getModeLine(int i, Polygon pol){
		String a = i == 0 ? "X" : i == 1 ? "Y" : i == 2 ? "Z" : "XYZ";
		String s = getModeValue(i, pol).toString();
		switch(mode){
			case "move":{
				return "Pos-" + a + ": " + s;
			}
			case "offset":{
				return "Offset-" + a + ": " + s;
			}
			case "rotation":{
				float f = Float.parseFloat(s);
				return "Rotation-" + a + ": " + f + "rad (" + (int)Math.toDegrees(f) + "deg)";
			}
			case "resize":{
				switch(i){ case 0:{ return "Width: " + s; } case 1:{ return "Height: " + s; } case 2:{ return "Depth: " + s; } }
			}
			case "texture":{
				return "Texture-" + a + ": " + (i < 2 ? s : "-");
			}
			case "type":{
				return i == 0 ? "Type: " + s : i == 2 ? "Scale: " + s : "Name: " + s;
			}
			case "bools":{
				switch(i){ case 0:{ return "LegOldRot: " + s; } case 1:{ return "Mirror: " + s; } case 2:{ return "Flip: " + s; } }
				break;
			}
			case "cylinder":{
				switch(i){ case 0:{ return "Radius: " + s; } case 1:{ return "Length: " + s; } case 2:{ return "Segments: " + s; } }
				break;
			}
			case "cylinder2":{
				switch(i){ case 0:{ return "Direction: " + s; } case 1:{ return "TopScale: " + s; } case 2:{ return "BaseScale: " + s; } }
				break;
			}
		}
		if(mode.startsWith("shapebox_corner")){
			int j = Integer.parseInt(mode.replace("shapebox_corner_", ""));
			switch(i){
				case 0: { return "Corner " + j + "X: " + s; }
				case 1: { return "Corner " + j + "Y: " + s; }
				case 2: { return "Corner " + j + "Z: " + s; }
			}
		}
		return null;
	}
	
	public Object getModeValue(int i, Polygon pol){
		switch(mode){
			case "move":{
				return i == 0 ? pol.rotationpoint.x : i == 1 ? pol.rotationpoint.y : pol.rotationpoint.z;
			}
			case "offset":{
				return i == 0 ? pol.offset.x : i == 1 ? pol.offset.y : pol.offset.z;
			}
			case "rotation":{
				return i == 0 ? pol.rotationangle.x : i == 1 ? pol.rotationangle.y : pol.rotationangle.z;
			}
			case "resize":{
				switch(i){ case 0:{ return pol.width; } case 1:{ return pol.height; } case 2:{ return pol.depth; } }
			}
			case "texture":{
				return i == 0 ? pol.texturex : i == 1 ? pol.texturey : "-";
			}
			case "type":{
				return i == 0 ? pol.type.name() : i == 2 ? pol.scale : pol.boxname == null ? "" : pol.boxname;
			}
			case "bools":{
				switch(i){ case 0:{ return pol.oldrot; } case 1:{ return pol.mirror; } case 2:{ return pol.flip; } }
				break;
			}
			case "cylinder":{
				switch(i){ case 0:{ return pol.radius; } case 1:{ return pol.length; } case 2:{ return pol.segments; } }
				break;
			}
			case "cylinder2":{
				switch(i){ case 0:{ return pol.direction; } case 1:{ return pol.topscale; } case 2:{ return pol.basescale; } }
				break;
			}
		}
		if(mode.startsWith("shapebox_corner")){
			int j = Integer.parseInt(mode.replace("shapebox_corner_", ""));
			switch(i){ case 0: { return pol.corners[j].x; } case 1: { return pol.corners[j].y; } case 2: { return pol.corners[j].z; } }
		}
		return null;
	}

	private void move(Axis axis, int i, Polygon pol){
		switch(mode){
			case "move":{
				switch(axis){
					case X: pol.rotationpoint.x -= i; break;
					case Y: pol.rotationpoint.y -= i; break;
					case Z: pol.rotationpoint.z -= i; break;
				}
				break;
			}
			case "offset":{
				switch(axis){
					case X: pol.offset.x += i; break;
					case Y: pol.offset.y += i; break;
					case Z: pol.offset.z += i; break;
				}
				break;
			}
			case "resize":{
				switch(axis){
					case X: pol.width += i; break;
					case Y: pol.height += i; break;
					case Z: pol.depth += i; break;
				}
				pol.width = pol.width < 0 ? 0 : pol.width;
				pol.height = pol.height < 0 ? 0 : pol.height;
				pol.depth = pol.depth < 0 ? 0 : pol.depth;
				break;
			}
			case "texture":{
				switch(axis){
					case X: pol.texturex += i; break;
					case Y: pol.texturex += i; break;
					default: break;
				}
				break;
			}
			case "rotation":{
				float f = 0;
				switch(axis){
					case X: f = pol.rotationangle.x + (i * Static.rad1); break;
					case Y: f = pol.rotationangle.y + (i * Static.rad1); break;
					case Z: f = pol.rotationangle.z + (i * Static.rad1); break;
				}
				f = (int)Math.toDegrees(f);
				switch(axis){
					case X: pol.rotationangle.x = (float)(f / 180.0 * Math.PI); break;
					case Y: pol.rotationangle.y = (float)(f / 180.0 * Math.PI); break;
					case Z: pol.rotationangle.z = (float)(f / 180.0 * Math.PI); break;
				}
				break;
			}
			case "type":{
				switch(pol.type){
					case BOX:{ pol.type = i > 0 ? PolygonType.SHAPEBOX : PolygonType.CYLINDER; break; }
					case SHAPEBOX:{ pol.type = i > 0 ? PolygonType.CYLINDER : PolygonType.BOX; break; }
					case CYLINDER:{ pol.type = i > 0 ? PolygonType.BOX : PolygonType.SHAPEBOX; break; }
				}
				break;
			}
			case "bools":{
				switch(axis){
					case X: pol.oldrot = i > 0 ? false : true; break;
					case Y: pol.mirror = i > 0 ? false : true; break;
					case Z: pol.flip = i > 0 ? false : true; break;
				}
				break;
			}
			case "cylinder":{
				switch(axis){
					case X:{ pol.radius += i; break; }
					case Y:{ pol.length += i; break; }
					case Z:{ pol.segments += i; break; }
				}
				break;
			}
			case "cylinder2":{
				switch(axis){
					case X:{ pol.direction += i; break; }
					case Y:{ pol.topscale += i; break; }
					case Z:{ pol.basescale += i; break; }
				}
				pol.direction = pol.direction > 5 ? 5 : pol.direction < 0 ? 0 : pol.direction;
				break;
			}
		}
		if(mode.startsWith("shapebox_corner")){
			int j = Integer.parseInt(mode.replace("shapebox_corner_", ""));
			switch(axis){
				case X: { pol.corners[j].x += i; break; }
				case Y: { pol.corners[j].y += i; break; }
				case Z: { pol.corners[j].z += i; break; }
			}
		}
		//
		this.sendUpdate("update_polygon", group, selected, pol.toJTMT());
	}

	public Polygon getPolygon(){
		if(group == null || !modeldata.polygons.containsKey(group) || modeldata.polygons.get(group).size() <= selected || selected < 0){
			return null;
		}
		return modeldata.polygons.get(group).get(selected);
	}

	public void sendUpdate(String string, String group, int selected, JsonObject polygon){
		if(string.equals("all")){
			ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
			return;
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("task", string);
		compound.setString("group", group);
		compound.setInteger("selected", selected);
		if(polygon != null){
			compound.setString("polygon", polygon.toString());
		}
		ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
	}
	
}