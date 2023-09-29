package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.construct.ConstConInterface;
import net.fexcraft.mod.fvtm.gui.construct.ConstContainer;
import net.fexcraft.mod.fvtm.model.block.ConstructorLiftModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private ContainerData cdata;
	private VehicleData vdata;
	private PartData pdata;
	private BlockData bdata;
	private BlockPos center;
	public float liftstate;
	
	public ConstructorEntity(){}

	public void processGUIPacket(Side side, NBTTagCompound packet, EntityPlayer player, ConstConInterface container){
		switch(packet.getString("cargo")){
			case "constructor_connect":{
				boolean auto = packet.getBoolean("Auto");
				if(!auto){
					BlockPos pos = BlockPos.fromLong(packet.getLong("BlockPos"));
					TileEntity tile = world.getTileEntity(pos);
					if(tile == null){
						container.setTitleText("tile.fvtm.constructor.constructor_connect.no_tile", RGB.RED); return;
					}
					if(tile instanceof ConstCenterEntity == false){
						container.setTitleText("tile.fvtm.constructor.constructor_connect.wrong_type", RGB.RED); return;
					}
					ConstCenterEntity centerlift = (ConstCenterEntity)tile;
					if(centerlift.getLinkPos() != null){
						container.setTitleText("tile.fvtm.constructor.constructor_connect.already_connected", RGB.BLUE); return;
					}
					else{
						centerlift.setLinkPos(this.getPos(), true); this.setCenterPos(pos);
						container.setTitleText("tile.fvtm.constructor.constructor_connect.connected", RGB.BLACK); return;
					}
				}
				else{
					boolean found = false;
					BlockPos searchpos;
					TileEntity searchtile;
					ConstCenterEntity centertile = null;
					for(int x = -8; x < 9; x++){ if(found) break;
						for(int z = -8; z < 9; z++){ if(found) break;
							for(int y = -1; y < 2; y++){ if(found) break;
								if(x == 0 && y == 0 && z == 0) continue; searchpos = pos.add(x, y, z);
								if((searchtile = world.getTileEntity(searchpos)) != null && searchtile instanceof ConstCenterEntity){
									if((centertile = (ConstCenterEntity)searchtile).getLinkPos() != null) continue;
									else{
										found = true;
										break;
									}
								}
							}
						}
					}
					if(found && centertile != null){
						centertile.setLinkPos(pos, true);
						this.setCenterPos(centertile.getPos());
						container.setTitleText("tile.fvtm.constructor.constructor_connect.connected", RGB.BLACK);
						return;
					}
					else{
						container.setTitleText("tile.fvtm.constructor.constructor_connect.no_tile_found" + (centertile == null ? "_null" : ""), RGB.RED);
						return;
					}
				}
			}
			case "constructor_disconnect":{
				if(this.center != null){
					ConstCenterEntity tile = (ConstCenterEntity)world.getTileEntity(center);
					if(tile != null) tile.setLinkPos(null, true);
				} this.setCenterPos(null);
				container.setTitleText("tile.fvtm.constructor.constructor_disconnect.disconnected", RGB.BLACK);
				return;
			}
			case "part_install":{
				if(nopar(container)) return; if(noveh(container)) return;
				boolean bool = packet.getBoolean("custom_category");
				PartData data = this.getPartData(); String cat = packet.getString("category");
				if(bool && !data.getType().getInstallHandler().allowsCustomCategory(data)){
					container.setTitleText("tile.fvtm.constructor.part_install.custom_cat_not_allowed", null); return;
				}
				/*if(data.getType().getInstallationHandler().allowInstall(container.getCommandSender(), data, cat, getVehicleData())){
					if(data.getType().getInstallationHandler().processInstall(container.getCommandSender(), data, cat, getVehicleData())){
						this.pdata = null; this.updateClient(null);
					}
				} return;*/
				//TODO data = getVehicleData().installPart(container.getCommandSender(), data, cat, false);
				data = getVehicleData().installPart(null, data, cat, false);
				if(data == null) pdata = null; this.updateClient(null); return;
			}
			case "part_remove":{
				if(noveh(container)) return;
				String cat = packet.getString("category"); PartData data = this.getVehicleData().getPart(cat);
				if(data == null){ container.setTitleText("tile.fvtm.constructor.part_remove.not_found_server", null); return; }
				/*if(data.getType().getInstallationHandler().allowUninstall(container.getCommandSender(), data, cat, getVehicleData())){
					if(data.getType().getInstallationHandler().processUninstall(container.getCommandSender(), data, cat, getVehicleData())){
						this.dropItem(data.newItemStack()); this.updateClient(null);
					}
				} return;*/
				//TODO if(getVehicleData().deinstallPart(container.getCommandSender(), cat, false)){
				if(getVehicleData().deinstallPart(null, cat, false)){
					dropItem(data.getNewStack().local());
					updateClient(null);
				}
				return;
			}
			case "part_cache_drop":{
				this.dropPart(true);
				return;
			}
			case "tm_supplied":{
				if(nocon(container) && noveh(container) && noblk(container)) return;
				int i = packet.getInteger("value");
				TextureUser textur = packet.hasKey("part") ? this.getVehicleData().getPart(packet.getString("part")) : cdata == null ? bdata == null ? this.getVehicleData() : this.getBlockData() : this.getContainerData();
				if(textur == null && packet.hasKey("part")){
					container.setTitleText("tile.fvtm.constructor.texture.invalid_part", RGB.RED);
					return;
				}
				if(i < 0 || i >= textur.getTexHolder().getDefaultTextures().size()){
					container.setTitleText("tile.fvtm.constructor.texture.invalid_supplied_id", RGB.RED);
					return;
				}
				textur.getTexture().setSelectedTexture(i, null, false);
				container.setTitleText("tile.fvtm.constructor.texture.applied", null);
				this.updateClient(cdata == null ? bdata == null ? "vehicle" : "block" : "container"); return;
			}
			case "tm_custom":{
				if(nocon(container) && noveh(container) && noblk(container)) return;
				String value = packet.getString("value");
				boolean external = packet.getBoolean("external");
				TextureUser textur = packet.hasKey("part") ? this.getVehicleData().getPart(packet.getString("part")) : cdata == null ? bdata == null ? this.getVehicleData() : this.getBlockData() : this.getContainerData();
				if(textur == null && packet.hasKey("part")){
					container.setTitleText("tile.fvtm.constructor.texture.invalid_part", RGB.RED);
					return;
				}
				//TODO check if custom textures are allowed;
				textur.getTexture().setSelectedTexture(-1, value, external);
				container.setTitleText("tile.fvtm.constructor.texture.applied", null);
				this.updateClient(cdata == null ? bdata == null ? "vehicle" : "block" : "container"); return;
			}
			case "color_update":{
				if(nocon(container) && noveh(container) && noblk(container)) return;
				String channel = packet.getString("channel");
				int rgb = packet.getInteger("rgb");
				if(bdata != null){
					bdata.getColorChannel(channel).packed = rgb;
				}
				else if(cdata == null){
					vdata.getColorChannel(channel).packed = rgb;
				}
				else{
					cdata.getColorChannel(channel).packed = rgb;
				}
				container.setTitleText("tile.fvtm.constructor.color.applied", null);
				this.updateClient("color"); return;
			}
			case "drop":{
				String kind = packet.getString("what");
				switch(kind){
					case "container": this.dropContainer(true); container.setTitleText("tile.fvtm.constructor.drop.container", null); break;
					case "vehicle": this.dropVehicle(true); container.setTitleText("tile.fvtm.constructor.drop.vehicle", null); break;
					case "block": this.dropBlock(true); container.setTitleText("tile.fvtm.constructor.drop.block", null); break;
					case "part": this.dropPart(true); container.setTitleText("tile.fvtm.constructor.drop.part", null); break;
					case "any": {
						this.dropContainer(true); this.dropVehicle(true); this.dropBlock(true); this.dropPart(true);
						container.setTitleText("tile.fvtm.constructor.drop.all", null); break;
					}
				} return;
			}
			case "veh_name_change":{
				if(noveh(container)) return;
				vdata.setDisplayName(packet.hasKey("reset") && packet.getBoolean("reset") ? null : packet.getString("value"));
				container.setTitleText("tile.fvtm.constructor.name.changed", null);
				this.updateClient("vehicle");
				return;
			}
			case "lift":{
				if(noveh(container)) return;
				liftstate += packet.getInteger("dir") * 0.5f;
				if(liftstate < -3) liftstate = -3;
				if(liftstate > 0) liftstate = 0;
				this.updateClient("lift");
				container.setTitleText("tile.fvtm.constructor.lift.adjusted", null);
				return;
			}
			//
			default: return;
		}
	}
	
	private boolean nocon(ConstConInterface container){
		if(this.getContainerData() == null){
			container.setTitleText("tile.fvtm.constructor.no_container", null);
			return true;
		}
		return false;
	}
	
	private boolean noveh(ConstConInterface container){
		if(this.getVehicleData() == null){
			container.setTitleText("tile.fvtm.constructor.no_vehicle", null);
			return true;
		}
		return false;
	}
	
	private boolean nopar(ConstConInterface container){
		if(this.getPartData() == null){
			container.setTitleText("tile.fvtm.constructor.no_part", null);
			return true;
		}
		return false;
	}
	
	private boolean noblk(ConstConInterface container){
		if(this.getBlockData() == null){
			container.setTitleText("tile.fvtm.constructor.no_block", null);
			return true;
		}
		return false;
	}

	private void setCenterPos(BlockPos pos){
		this.center = pos; if(world.isRemote) return;
		NBTTagCompound compound = new NBTTagCompound();
		if(center != null) compound.setLong("CenterPos", center.toLong());
		if(center == null) compound.setBoolean("CenterReset", true);
		ApiUtil.sendTileEntityUpdatePacket(world, this.pos, compound);
	}

	public ContainerData getContainerData(){
		return cdata;
	}

	public VehicleData getVehicleData(){
		return vdata;
	}

	public BlockData getBlockData(){
		return bdata;
	}
	
	public PartData getPartData(){
		return pdata;
	}
	
	//

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
    	//Print.debug(packet.nbt);
        if(packet.nbt.hasKey("PartData")){
        	pdata = FvtmResources.INSTANCE.getPartData(new TagCWI(packet.nbt.getCompoundTag("PartData")));
        }
        else if(packet.nbt.hasKey("PartDataReset") && packet.nbt.getBoolean("PartDataReset")){
        	pdata = null;
        }
        //
        if(packet.nbt.hasKey("VehicleData")){
        	vdata = FvtmResources.INSTANCE.getVehicleData(new TagCWI(packet.nbt.getCompoundTag("VehicleData")));
        	resetCenterModels();
        }
        else if(packet.nbt.hasKey("VehicleDataReset") && packet.nbt.getBoolean("VehicleDataReset")){
        	vdata = null;
        	resetCenterModels();
        }
        //
        if(packet.nbt.hasKey("ContainerData")){
        	this.cdata = Resources.getContainerData(packet.nbt.getCompoundTag("ContainerData"));
        }
        else if(packet.nbt.hasKey("ContainerDataReset") && packet.nbt.getBoolean("ContainerDataReset")){
        	this.cdata = null;
        }
        //
        if(packet.nbt.hasKey("BlockData")){
        	this.bdata = Resources.getBlockData(packet.nbt.getCompoundTag("BlockData"));
        }
        else if(packet.nbt.hasKey("BlockDataReset") && packet.nbt.getBoolean("BlockDataReset")){
        	this.bdata = null;
        }
        //
        if(packet.nbt.hasKey("RGBUpdate") && packet.nbt.getBoolean("RGBUpdate")){
        	Colorable colorable = cdata == null ? bdata == null ? vdata : bdata : cdata;
    		for(String str : colorable.getColorChannels().keySet()){
    			if(packet.nbt.hasKey("RGB_" + str)){
    				colorable.getColorChannels().get(str).packed = packet.nbt.getInteger("RGB_" + str);
    			}
    		}
        }
        //Print.debug(vdata.getPrimaryColor().packed, vdata.getSecondaryColor().packed);
        if(packet.nbt.hasKey("LiftState")){
        	this.liftstate = packet.nbt.getFloat("LiftState");
        }
        //
        if(packet.nbt.hasKey("CenterPos")){
        	this.center = BlockPos.fromLong(packet.nbt.getLong("CenterPos"));
        }
        else if(packet.nbt.hasKey("CenterReset") && packet.nbt.getBoolean("CenterReset")){
        	this.center = null;
        }
        if(net.minecraft.client.Minecraft.getMinecraft().player.openContainer instanceof ConstContainer){
        	((ConstContainer)net.minecraft.client.Minecraft.getMinecraft().player.openContainer).gui.onClientPacket(packet.nbt);
        }
    }
    
    private void resetCenterModels(){
		if(center == null) return;
		TileEntity center = world.getTileEntity(this.center);
		if(center == null) return;
		if(center instanceof ConstCenterEntity == false) return;
		ConstCenterEntity cent = (ConstCenterEntity)center;
		if(cent.track != null){
			if(cent.track.railmodel != null) cent.track.railmodel.clearDisplayLists();
			if(cent.track.restmodel != null) cent.track.restmodel.clearDisplayLists();
			cent.track.railmodel = cent.track.restmodel = null;
			cent.track.gauge = null;
		}
		if(cent.models != null){
			for(ConstructorLiftModel model : cent.models){
				model.clearGLData();
			}
			cent.models = null;
		}
	}

	public void updateClient(String type){
    	if(type == null){
        	ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
        	return;
    	}
    	NBTTagCompound compound = new NBTTagCompound();
    	switch(type){
			case "containerdata": case "container": case "con": {
				if(cdata != null) compound.setTag("ContainerData", cdata.write(new NBTTagCompound()));
				else compound.setBoolean("ContainerDataReset", true); break;
			}
    		case "vehicledata": case "vehicle": case "veh": {
    			if(vdata != null) compound.setTag("VehicleData", vdata.write(TagCW.create()).local());
    			else compound.setBoolean("VehicleDataReset", true); break;
    		}
    		case "blockdata": case "block": {
    			if(pdata != null) compound.setTag("BlockData", bdata.write(new NBTTagCompound()));
    			else compound.setBoolean("BlockDataReset", true); break;
    		}
    		case "partdata": case "part": {
    			if(pdata != null) compound.setTag("PartData", pdata.write(null).local());
    			else compound.setBoolean("PartDataReset", true); break;
    		}
    		case "color": case "rgb":{
    			if(vdata == null && cdata == null && bdata == null){ Print.debug("no veh in const # color"); return; }
    			Colorable colorable = cdata == null ? bdata == null ? vdata : bdata : cdata;
    			for(String str : colorable.getColorChannels().keySet()){
    				compound.setInteger("RGB_" + str, colorable.getColorChannels().get(str).packed);
    			}
    			compound.setBoolean("RGBUpdate", true);
    			break;
    		}
    		case "liftstate": case "lift":{
    			compound.setFloat("LiftState", liftstate);
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
        if(cdata != null) compound.setTag("ContainerData", cdata.write(new NBTTagCompound()));
			else compound.setBoolean("ContainerDataReset", true);
        if(vdata != null) compound.setTag("VehicleData", vdata.write(TagCW.create()).local());
			else compound.setBoolean("VehicleDataReset", true);
		if(pdata != null) compound.setTag("PartData", pdata.write(null).local());
			else compound.setBoolean("PartDataReset", true);
		if(bdata != null) compound.setTag("BlockData", bdata.write(new NBTTagCompound()));
		else compound.setBoolean("BlockDataReset", true);
        if(center != null){ compound.setLong("Center", center.toLong()); }
        compound.setFloat("LiftState", liftstate);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("PartData")){
        	pdata = FvtmResources.INSTANCE.getPartData(new TagCWI(compound.getCompoundTag("PartData")));
        }
        else if(compound.hasKey("PartDataReset") && compound.getBoolean("PartDataReset")){
        	pdata = null;
        }
        if(compound.hasKey("VehicleData")){
        	vdata = FvtmResources.INSTANCE.getVehicleData(new TagCWI(compound.getCompoundTag("VehicleData")));
        }
        else if(compound.hasKey("VehicleDataReset") && compound.getBoolean("VehicleDataReset")){
        	vdata = null;
        }
        if(compound.hasKey("ContainerData")){
        	this.cdata = Resources.getContainerData(compound.getCompoundTag("ContainerData"));
        }
        else if(compound.hasKey("ContainerDataReset") && compound.getBoolean("ContainerDataReset")){
        	this.cdata = null;
        }
        if(compound.hasKey("BlockData")){
        	this.bdata = Resources.getBlockData(compound.getCompoundTag("BlockData"));
        }
        else if(compound.hasKey("BlockDataReset") && compound.getBoolean("BlockDataReset")){
        	this.bdata = null;
        }
        if(compound.hasKey("Center")){
            this.center = BlockPos.fromLong(compound.getLong("Center"));
        }
        if(compound.hasKey("LiftState")){
        	this.liftstate = compound.getFloat("LiftState");
        }
    }
    
    //
    
    public void dropItem(ItemStack stack){
    	EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
    	item.setItem(stack); world.spawnEntity(item);
    }

	public void dropContainer(boolean update){
		if(cdata == null) return; this.dropItem(cdata.newItemStack());
		this.cdata = null; if(update) this.updateClient("containerdata");
	}

	public void dropVehicle(boolean update){
		if(vdata == null) return; this.dropItem(vdata.newItemStack());
		this.vdata = null; if(update) this.updateClient("vehicledata");
	}

	public void dropBlock(boolean update){
		if(bdata == null) return; this.dropItem(bdata.newItemStack());
		this.bdata = null; if(update) this.updateClient("blockdata");
	}

	public void dropPart(boolean update){
		if(pdata == null) return;
		dropItem(pdata.getNewStack().local());
		pdata = null;
		if(update) updateClient("partdata");
	}

	public void setContainerData(ContainerData data, boolean send){
		this.cdata = data; if(send) this.updateClient("container");
	}

	public void setVehicleData(VehicleData data, boolean send){
		this.vdata = data; if(send) this.updateClient("vehicle");
	}

	public void setBlockData(BlockData data, boolean send){
		this.bdata = data; if(send) this.updateClient("block");
	}

	public void setPartData(PartData data, boolean send){
		this.pdata = data; if(send) this.updateClient("part");
	}

	public BlockPos getCenterPos(){
		return center;
	}

	public void dropIfContainsAnyThing(){
		if(getContainerData() != null) dropContainer(true);
    	if(getVehicleData() != null) dropVehicle(true);
    	if(getBlockData() != null) dropBlock(true);
    	if(getPartData() != null) dropPart(true);
	}

}
