package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.ConstructorContainer;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private VehicleData vdata;
	private PartData pdata;
	private BlockPos center;
	
	public ConstructorEntity(){}

	public void processGUIPacket(Side side, NBTTagCompound packet, EntityPlayer player, ConstructorContainer container){
		switch(packet.getString("cargo")){
			case "constructor_connect":{
				boolean auto = packet.getBoolean("Auto");
				if(!auto){
					BlockPos pos = BlockPos.fromLong(packet.getLong("BlockPos"));
					TileEntity tile = world.getTileEntity(pos);
					if(tile == null){
						container.setTitleText("No TileEntity at selected position. [SERVER]", RGB.RED.packed); return;
					}
					if(tile instanceof ConstructorCenterEntity == false){
						container.setTitleText("Tile at position is of wrong type.", RGB.RED.packed); return;
					}
					ConstructorCenterEntity centerlift = (ConstructorCenterEntity)tile;
					if(centerlift.getLinkPos() != null){
						container.setTitleText("Tile at position has already connection data.", RGB.BLUE.packed); return;
					}
					else{
						centerlift.setLinkPos(this.getPos(), true); this.setCenterPos(pos);
						container.setTitleText("Tile connected.", RGB.BLACK.packed); return;
					}
				}
				else{
					boolean found = false; BlockPos searchpos; TileEntity searchtile; ConstructorCenterEntity centertile = null;
					for(int x = -8; x < 9; x++){ if(found) break;
						for(int z = -8; z < 9; z++){ if(found) break;
							for(int y = -1; y < 2; y++){ if(found) break;
								if(x == 0 && y == 0 && z == 0) continue; searchpos = pos.add(x, y, z);
								if((searchtile = world.getTileEntity(searchpos)) != null && searchtile instanceof ConstructorCenterEntity){
									if((centertile = (ConstructorCenterEntity)searchtile).getLinkPos() != null) continue;
									else{ found = true; break; }
								}
							}
						}
					}
					if(found && centertile != null){
						centertile.setLinkPos(pos, true); this.setCenterPos(centertile.getPos());
						container.setTitleText("Tile connected.", RGB.BLACK.packed); return;
					}
					else{
						container.setTitleText("No suitable TileEntity found. " + (centertile == null ? "[tilenull]" : "[]"), RGB.RED.packed); return;
					}
				}
			}
			case "constructor_disconnect":{
				if(this.center != null){
					ConstructorCenterEntity tile = (ConstructorCenterEntity)world.getTileEntity(center);
					if(tile != null) tile.setLinkPos(null, true);
				} this.setCenterPos(null);
				container.setTitleText("Tile connection reset.", RGB.BLACK.packed);
				return;
			}
			case "part_install":{
				if(nopar(container)) return; if(noveh(container)) return;
				boolean bool = packet.getBoolean("custom_category");
				PartData data = this.getPartData(); String cat = packet.getString("category");
				if(bool && !data.getType().getInstallationHandler().allowsCustomCategory(data)){
					container.setTitleText("Custom Category not allowed for this part.", null); return;
				}
				/*if(data.getType().getInstallationHandler().allowInstall(container.getCommandSender(), data, cat, getVehicleData())){
					if(data.getType().getInstallationHandler().processInstall(container.getCommandSender(), data, cat, getVehicleData())){
						this.pdata = null; this.updateClient(null);
					}
				} return;*/
				data = getVehicleData().installPart(container.getCommandSender(), data, cat);
				if(data == null) pdata = null; this.updateClient(null); return;
			}
			case "part_remove":{
				if(noveh(container)) return;
				String cat = packet.getString("category"); PartData data = this.getVehicleData().getPart(cat);
				if(data == null){ container.setTitleText("Selected Part not found (on server).", null); return; }
				/*if(data.getType().getInstallationHandler().allowUninstall(container.getCommandSender(), data, cat, getVehicleData())){
					if(data.getType().getInstallationHandler().processUninstall(container.getCommandSender(), data, cat, getVehicleData())){
						this.dropItem(data.newItemStack()); this.updateClient(null);
					}
				} return;*/
				if(getVehicleData().deinstallPart(container.getCommandSender(), cat)){
					this.dropItem(data.newItemStack()); this.updateClient(null);
				} return;
			}
			case "part_cache_drop":{ this.dropPart(true); return; }
			case "vtm_supplied":{
				if(noveh(container)) return;
				int i = packet.getInteger("value");
				Textureable textur = packet.hasKey("part") ? this.getVehicleData().getPart(packet.getString("part")) : this.getVehicleData();
				if(textur == null && packet.hasKey("part")){ container.setTitleText("Invalid Part Request.", RGB.RED.packed); return; }
				if(i < 0 || i >= textur.getHolder().getDefaultTextures().size()){
					container.setTitleText("Invalid SUPPLIED ID.", RGB.RED.packed); return;
				} textur.setSelectedTexture(i, null, false);
				container.setTitleText("Texture Applied.", null);
				this.updateClient("vehicle"); return;
			}
			case "vtm_custom":{
				if(noveh(container)) return; String value = packet.getString("value"); boolean external = packet.getBoolean("external");
				Textureable textur = packet.hasKey("part") ? this.getVehicleData().getPart(packet.getString("part")) : this.getVehicleData();
				if(textur == null && packet.hasKey("part")){ container.setTitleText("Invalid Part Request.", RGB.RED.packed); return; }
				//TODO check if custom textures are allowed;
				textur.setSelectedTexture(-1, value, external);
				container.setTitleText("Texture Applied.", null);
				this.updateClient("vehicle"); return;
			}
			case "color_update":{
				if(noveh(container)) return; boolean primary = packet.getBoolean("primary"); int rgb = packet.getInteger("rgb");
				(primary ? vdata.getPrimaryColor() : vdata.getSecondaryColor()).packed = rgb;
				container.setTitleText("Color Applied.", null); this.updateClient("color"); return;
			}
			case "drop":{
				String kind = packet.getString("what");
				switch(kind){
					case "vehicle": this.dropVehicle(true); container.setTitleText("Vehicle Dropped.", null); break;
					case "part": this.dropPart(true); container.setTitleText("Part Cache Emptied.", null); break;
				} return;
			}
			//
			default: return;
		}
	}
	
	private boolean noveh(ConstructorContainer container){
		if(this.getVehicleData() == null){ container.setTitleText("No Vehicle in Constructor.", null); return true; } return false;
	}
	
	private boolean nopar(ConstructorContainer container){
		if(this.getPartData() == null){ container.setTitleText("No Part in Constructor.", null); return true; } return false;
	}

	private void setCenterPos(BlockPos pos){
		this.center = pos; if(world.isRemote) return;
		NBTTagCompound compound = new NBTTagCompound();
		if(center != null) compound.setLong("CenterPos", center.toLong());
		if(center == null) compound.setBoolean("CenterReset", true);
		ApiUtil.sendTileEntityUpdatePacket(world, this.pos, compound);
	}

	public VehicleData getVehicleData(){
		return vdata;
	}
	
	public PartData getPartData(){
		return pdata;
	}
	
	//

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
    	Print.debug(packet.nbt);
        if(packet.nbt.hasKey("PartData")){
        	this.pdata = Resources.getPartData(packet.nbt.getCompoundTag("PartData"));
        }
        else if(packet.nbt.hasKey("PartDataReset") && packet.nbt.getBoolean("PartDataReset")){
        	this.pdata = null;
        }
        //
        if(packet.nbt.hasKey("VehicleData")){
        	this.vdata = Resources.getVehicleData(packet.nbt.getCompoundTag("VehicleData"));
        }
        else if(packet.nbt.hasKey("VehicleDataReset") && packet.nbt.getBoolean("VehicleDataReset")){
        	this.vdata = null;
        }
        //
        if(packet.nbt.hasKey("RGBPrimary") && vdata != null) vdata.getPrimaryColor().packed = packet.nbt.getInteger("RGBPrimary"); 
        if(packet.nbt.hasKey("RGBSecondary") && vdata != null) vdata.getSecondaryColor().packed = packet.nbt.getInteger("RGBSecondary");
        //Print.debug(vdata.getPrimaryColor().packed, vdata.getSecondaryColor().packed);
        //
        if(packet.nbt.hasKey("CenterPos")){
        	this.center = BlockPos.fromLong(packet.nbt.getLong("CenterPos"));
        }
        else if(packet.nbt.hasKey("CenterReset") && packet.nbt.getBoolean("CenterReset")){
        	this.center = null;
        }
    }
    
    public void updateClient(String type){
    	if(type == null){
        	ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
        	return;
    	}
    	NBTTagCompound compound = new NBTTagCompound();
    	switch(type){
    		case "vehicledata": case "vehicle": case "veh": {
    			if(vdata != null) compound.setTag("VehicleData", vdata.write(new NBTTagCompound()));
    			else compound.setBoolean("VehicleDataReset", true); break;
    		}
    		case "partdata": case "part": {
    			if(pdata != null) compound.setTag("PartData", pdata.write(new NBTTagCompound()));
    			else compound.setBoolean("PartDataReset", true); break;
    		}
    		case "color": case "rgb":{
    			if(vdata == null){ Print.debug("no veh in const # color"); return; }
    			compound.setInteger("RGBPrimary", vdata.getPrimaryColor().packed);
    			compound.setInteger("RGBSecondary", vdata.getSecondaryColor().packed);
    			break;
    		}
    		//
    		default: return;
    	} this.markDirty();//checking stuff
    	ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
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
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(vdata != null) compound.setTag("VehicleData", vdata.write(new NBTTagCompound()));
			else compound.setBoolean("VehicleDataReset", true);
		if(pdata != null) compound.setTag("PartData", pdata.write(new NBTTagCompound()));
			else compound.setBoolean("PartDataReset", true);
        if(center != null){ compound.setLong("Center", center.toLong()); }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("PartData")){
        	this.pdata = Resources.getPartData(compound.getCompoundTag("PartData"));
        }
        else if(compound.hasKey("PartDataReset") && compound.getBoolean("PartDataReset")){
        	this.pdata = null;
        }
        if(compound.hasKey("VehicleData")){
        	this.vdata = Resources.getVehicleData(compound.getCompoundTag("VehicleData"));
        }
        else if(compound.hasKey("PartDataReset") && compound.getBoolean("PartDataReset")){
        	this.pdata = null;
        }
        if(compound.hasKey("Center")){
            this.center = BlockPos.fromLong(compound.getLong("Center"));
        }
    }
    
    //
    
    public void dropItem(ItemStack stack){
    	EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
    	item.setItem(stack); world.spawnEntity(item);
    }

	public void dropVehicle(boolean update){
		if(vdata == null) return; this.dropItem(vdata.newItemStack());
		this.vdata = null; if(update) this.updateClient("vehicledata");
	}

	public void dropPart(boolean update){
		if(pdata == null) return; this.dropItem(pdata.newItemStack());
		this.pdata = null; if(update) this.updateClient("partdata");
	}

	public void setVehicleData(VehicleData data, boolean send){
		this.vdata = data; if(send) this.updateClient("vehicle");
	}

	public void setPartData(PartData data, boolean send){
		this.pdata = data; if(send) this.updateClient("part");
	}

	public BlockPos getCenterPos(){
		return center;
	}

}
