/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.fexcraft.mod.addons.hcp.scripts;

import java.util.TreeMap;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.addons.gep.attributes.FontRendererAttribute.FontData;
import net.fexcraft.mod.addons.gep.attributes.FontRendererAttribute.FontRendererAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.blocks.ContainerBlock;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.fvtm.entities.ContainerWrapper;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.container.GenericContainerItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class ContainerCraneScript implements VehicleScript {
	
    private ContainerData data;
    private boolean xmove, ymove, zmove, stepwise;
	public boolean searchbox;
    private int xdir, ydir, zdir, xsteptime, ysteptime, zsteptime;
	public int xpos, ypos, zpos, length = 15;
	private int speed = 10;

    @Override
    public ResourceLocation getId(){
        return new ResourceLocation("hcp:container_crane");
    }

    @Override
    public void onDataPacket(Entity entity, Vehicle.VehicleData data, NBTTagCompound compound, Side side){
        this.readFromNBT(compound);
    }

    @Override
    public void onCreated(Entity entity, Vehicle.VehicleData data){
        //
    }

    @Override
    public boolean onInteract(Entity entity, Vehicle.VehicleData data, EntityPlayer player, EnumHand hand){
    	if(player.getHeldItem(hand).getItem() instanceof PartItem){
    		PartData partdata = ((PartItem)player.getHeldItem(hand).getItem()).getPart(player.getHeldItem(hand));
    		if(partdata.getPart().getScripts().contains(ContainerCraneScript.class)){
    			player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_SCRIPTSGUI, entity.world, entity.getEntityId(), -1, 0);
    			return true;
    		}
    	}
        return false;
    }

    private boolean moved;

    @Override
    public void onUpdate(Entity entity, Vehicle.VehicleData data){
    	VehicleEntity ent = (VehicleEntity)entity;
    	ent.setThrottle(0);
    	if(ent.getAxes().getRadianYaw() % 90 != 0){
			ent.getAxes().setRotation(Math.toRadians(round(ent.getAxes().getYaw())), ent.getAxes().getPitch(), ent.getAxes().getRoll());
    	}
    	moved = false;
        if(xmove && xdir != 0){
        	if(stepwise && xsteptime > 0){
        		xsteptime--;
        	}
        	else{
        		int leng = (length * 1000) - 5000;
        		xpos += xdir * speed;
            	if(xpos > leng){ xpos = leng; xmove = false; }
            	if(xpos < -leng){ xpos = -leng; xmove = false; }
            	moved = true;
            	if(xpos % 1000 == 0 && stepwise){
        			xsteptime = 40;
            	}
        	}
        }
        if(ymove && ydir != 0){
        	if(stepwise && ysteptime > 0){
        		ysteptime--;
        	}
        	else{
	        	ypos += ydir * speed;
	        	if(ypos > 0){ ypos = 0; ymove = false; }
	        	if(ypos < -6000){ ypos = -6000; ymove = false; }
	        	moved = true;
            	if(ypos % 1000 == 0 && stepwise){
        			ysteptime = 40;
            	}
        	}
        }
        if(zmove && zdir != 0){
        	if(stepwise && zsteptime > 0){
        		zsteptime--;
        	}
        	else{
	        	zpos += zdir * speed;
	        	if(zpos > 4000){ zpos = 4000; zmove = false; }
	        	if(zpos < -4000){ zpos = -4000; zmove = false; }
	        	moved = true;
            	if(zpos % 1000 == 0 && stepwise){
        			zsteptime = 40;
            	}
        	}
        }
        //
        FontRendererAttributeData attr = data.getPart("controller") == null ? null : data.getPart("controller").getAttributeData(FontRendererAttributeData.class);
        if(attr != null){
        	for(FontData font : attr.getLocations().values()){
        		switch(font.getId()){
	        		case "x_pos":{
	        			font.setString("x: " + xpos);
	        			break;
	        		}
					case "y_pos":{
	        			font.setString("y: " + ypos);		
						break;
					}
					case "z_pos":{
	        			font.setString("z: " + zpos);
						break;
					}
        		}
        	}
        }
        //TODO Y/Z
        //
        if(moved && !ent.getEntity().world.isRemote && ent.getEntity().ticksExisted % 10 == 0){
        	this.sendPacketToAllAround(entity, this.writeToNBT(null)); moved = false;
        }
    }

    private double round(double x){
		if(x > -360 && x <= -315){ return    0; }
		if(x > -315 && x <= -225){ return -270; }
		if(x > -225 && x <= -135){ return -180; }
		if(x > -135 && x <=  -45){ return  -90; }
		if(x >  -45 && x <=   45){ return    0; }
		if(x >   45 && x <=  135){ return   90; }
		if(x >  135 && x <=  225){ return  180; }
		if(x >  225 && x <=  315){ return  270; }
		if(x >  315 && x <=  360){ return    0; }
		return 0;
	}

	@Override
    public void onRemove(Entity entity, Vehicle.VehicleData data){
        data = null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound = compound == null ? new NBTTagCompound() : compound;
        if(data != null){
            data.writeToNBT(compound);
        }
        else{
        	compound.setBoolean("reset_container", true);
        }
        compound.setBoolean("xmove", xmove);
        compound.setBoolean("ymove", ymove);
        compound.setBoolean("zmove", zmove);
        compound.setInteger("xdir", xdir);
        compound.setInteger("ydir", ydir);
        compound.setInteger("zdir", zdir);
        compound.setInteger("xpos", xpos);
        compound.setInteger("ypos", ypos);
        compound.setInteger("zpos", zpos);
        compound.setInteger("speed", speed);
        compound.setBoolean("stepwise", stepwise);
        compound.setIntArray("steptime", new int[]{ xsteptime, ysteptime, zsteptime });
        compound.setBoolean("searchbox", searchbox);
        compound.setInteger("length", length);
        return compound;
    }

    @Override
    public VehicleScript readFromNBT(NBTTagCompound compound){
        if(compound.hasKey(ContainerItem.NBTKEY)){
            data = Resources.getContainerData(compound);
        }
        if(compound.hasKey("reset_container") && compound.getBoolean("reset_container")){
        	data = null;
        }
        xmove = compound.getBoolean("xmove");
        ymove = compound.getBoolean("ymove");
        zmove = compound.getBoolean("zmove");
        xdir = compound.getInteger("xdir");
        ydir = compound.getInteger("ydir");
        zdir = compound.getInteger("zdir");
        xpos = compound.getInteger("xpos");
        ypos = compound.getInteger("ypos");
        zpos = compound.getInteger("zpos");
        speed = compound.getInteger("speed");
        stepwise = compound.getBoolean("stepwise");
        int[] steptime = compound.getIntArray("steptime");
        if(steptime != null && steptime.length >= 3){
        	xsteptime = steptime[0]; ysteptime = steptime[1]; zsteptime = steptime[2];
        }
        searchbox = compound.getBoolean("searchbox");
        length = compound.getInteger("length");
        if(length == 0){ length = 15; }
        return this;
    }

	@Override
	public Object getSettingsValue(String setting){
		switch(setting){
			case "x-move": return xmove;
			case "y-move": return ymove;
			case "z-move": return zmove;
			case "x-direction": return xdir;
			case "y-direction": return ydir;
			case "z-direction": return zdir;
			case "trycatch": return "> > > >";
			case "release": return "< < < <";
			case "speed": return speed;
			case "stepwise": return stepwise;
			case "searchbox": return searchbox;
			case "length": return length;
		}
		return "";
	}

	@Override
	public ScriptSetting<?, ?>[] getSettings(int seat){
		if(seat > 0){ return null; }
		return new ScriptSetting[]{
			new ScriptSetting<ContainerCraneScript, Entity>(this, "trycatch", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.tryCatch(player, (VehicleEntity)ent);
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "release", ScriptSetting.Type.BUTTON){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.tryRelease(player, (VehicleEntity)ent);
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "x-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.xmove = i == 0 ? false : i == 1 ? true : holder.xmove;
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "y-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.ymove = i == 0 ? false : i == 1 ? true : holder.ymove;
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "z-move", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.zmove = i == 0 ? false : i == 1 ? true : holder.zmove;
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "x-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.xdir += i;
					if(holder.xdir > 1){ holder.xdir = 1; }
					if(holder.xdir < -1){ holder.xdir = -1; }
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "y-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.ydir += i;
					if(holder.ydir > 1){ holder.ydir = 1; }
					if(holder.ydir < -1){ holder.ydir = -1; }
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "z-direction", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity ent, int i, Object... objects){
					holder.zdir += i;
					if(holder.zdir > 1){ holder.zdir = 1; }
					if(holder.zdir < -1){ holder.zdir = -1; }
					holder.updateClient(player, ent);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "speed", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
					if(i > 0){
						switch(speed){
							case  0: speed = 10; break;
							case 10: speed = 20; break;
							case 20: speed = 50; break;
							default: speed = 50; break;
						}
					}
					else{
						switch(speed){
							case 10: speed =  0; break;
							case 20: speed = 10; break;
							case 50: speed = 20; break;
							default: speed =  0; break;
						}
					}
					holder.updateClient(player, entity);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "stepwise", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
					stepwise = i == 0 ? false : i == 1 ? true : stepwise;
					holder.updateClient(player, entity);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "searchbox", ScriptSetting.Type.BOOLEAN){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objs) {
					holder.searchbox = i == 0 ? false : i == 1 ? true : holder.searchbox;
					holder.updateClient(player, entity);
				}
			},
			new ScriptSetting<ContainerCraneScript, Entity>(this, "length", ScriptSetting.Type.INTEGER){
				@Override
				public void onChange(EntityPlayer player, Entity entity, int i, Object... objects){
					holder.length += i;
					if(holder.length < 8){ holder.length = 8; }
					if(holder.length > 64){ holder.length = 64; }
					holder.updateClient(player, entity);
				}
			}
		};
	}

	protected void updateClient(EntityPlayer player, Entity ent){
		this.sendPacketToClient(ent, player, this.writeToNBT(null));
	}

	protected void tryRelease(EntityPlayer player, VehicleEntity ent){
		xmove = ymove = zmove = false;
		if(data == null){
			Print.chat(player, "Not holding a Container.");
			return;
		}
		Vec3d pos = getSearchPosition(ent);
		BlockPos blkpos = new BlockPos(pos);
		if((xpos % 1000 == 0) && (ypos % 1000 == 0) && (zpos % 1000 == 0)){
			EnumFacing facing = EnumFacing.fromAngle(ent.getAxes().getRadianYaw()/* + 90*/);
			//IBlockState state = ent.getEntity().world.getBlockState(blkpos);
			if(GenericContainerItem.isValidPostitionForContainer(ent.getEntity().world, player, blkpos, facing, data)){
				try{
					ItemStack stack = data.getContainer().getItemStack(data);
		            stack.getTagCompound().setLong("PlacedPos", blkpos.toLong());
		            ContainerBlock.getPositions(data, blkpos, facing).forEach(bp -> {
		                IBlockState state = ContainerBlock.INSTANCE.getDefaultState();
		                state.getBlock().onBlockPlacedBy(ent.getEntity().world, bp, state.withProperty(ContainerBlock.FACING, facing), player, stack);
		            });
		            this.data = null;
		            Print.chat(player, "Container Placed.");
				}
				catch(Exception e){
					e.printStackTrace();
					Print.chat(player, "ERROR: See Console/Log.");
				}
			}
			else{
				Print.chat(player, "Invalid position for a container.");
			}
		}
		else{
			ContainerHolder holder = null;
			AxisAlignedBB aabb = new AxisAlignedBB(blkpos);
			for(Entity e : ent.getEntity().world.loadedEntityList){
				if(e instanceof ContainerHolder && e.getEntityBoundingBox().intersects(aabb)){
					holder = (ContainerHolder)e;
				}
				else if(e instanceof VehicleEntity){
					TreeMap<String, ContainerHolder> str = ((VehicleEntity)e).getContainers();
					if(str == null) continue; for(ContainerHolder obj : str.values()){
						if(obj instanceof ContainerWrapper && ((ContainerWrapper)obj).intersects(aabb)){
							holder = obj;
						}
					}
				}
			}
			if(holder != null){
				if(holder.getContainerData() != null){
					Print.chat(player, "Vehicle's Container isn't empty.");
				}
				if(holder.setContainerData(data)){
					data = null;
					Print.chat(player, "Container loaded into vehicle.");
				}
				else{
					Print.chat(player, "Vehicle didn't agree to take Container.");
				}
			}
			else{
				Print.chat(player, "No Container Holder Entity found at position.");
			}
		}
		return;
	}

	protected void tryCatch(EntityPlayer player, VehicleEntity ent){
		xmove = ymove = zmove = false;
		if(data != null){
			Print.chat(player, "Already holding a Container.");
			return;
		}
		Vec3d pos = getSearchPosition(ent);
		BlockPos blkpos = new BlockPos(pos);
		if((xpos % 1000 == 0) && (ypos % 1000 == 0) && (zpos % 1000 == 0)){
			IBlockState state = ent.getEntity().world.getBlockState(blkpos);
			if(state.getBlock() instanceof ContainerBlock){
				ContainerTileEntity te = (ContainerTileEntity)ent.getEntity().world.getTileEntity(blkpos);
				if(te.isCore()){
					this.data = te.getContainerData();
					te.notifyBreak(ent.getEntity().world, blkpos, state, false);
					Print.chat(player, "Container: " + data.getContainer().getName());
				}
				else{
					Print.chat(player, "Not the Container core.");
				}
			}
			else{
				Print.chat(player, "No Container at position found.");
			}
		}
		else{
			ContainerHolder holder = null;
			AxisAlignedBB aabb = new AxisAlignedBB(blkpos);
			for(Entity e : ent.getEntity().world.loadedEntityList){
				if(e instanceof ContainerHolder && e.getEntityBoundingBox().intersects(aabb)){
					holder = (ContainerHolder)e;
				}
				else if(e instanceof VehicleEntity){
					for(ContainerHolder obj : ((VehicleEntity)e).getContainers().values()){
						if(obj instanceof ContainerWrapper && ((ContainerWrapper)obj).intersects(aabb)){
							holder = obj;
						}
					}
				}
			}
			if(holder != null){
				ContainerData condata = holder.getContainerData();
				if(condata == null){
					Print.chat(player, "No container in Vehicle at position.");
					return;
				}
				if(holder.setContainerData(null)){
					this.data = condata;
					Print.chat(player, "Container: " + data.getContainer().getName());
				}
				else{
					Print.chat(player, "Vehicle didn't agree to give the Container.");
				}
			}
			else{
				Print.chat(player, "No Container Entity found at position.");
			}
		}
		//ent.getEntity().world.setBlockState(blkpos, Blocks.ANVIL.getDefaultState(), 2);
		Print.debug(pos, blkpos);
		return;
	}

	private Vec3d getSearchPosition(VehicleEntity ent){
		Vec3d pos = ent.getAxes().getRelativeVector(new Vec3d(0.5 + (xpos / 1000D), -(ypos / 1000D), -7 - (zpos / 1000D)));
		return new Vec3d(ent.getEntity().posX + pos.x, ent.getEntity().posY + pos.y, ent.getEntity().posZ + pos.z);
	}

	public ContainerData getContainerData(){
		return data;
	}
    
}
