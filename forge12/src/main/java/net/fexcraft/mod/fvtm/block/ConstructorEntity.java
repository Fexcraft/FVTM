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
import net.fexcraft.mod.uni.world.MessageSenderI;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.MessageSender;
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
	private BlockData bdata;
	private BlockPos center;
	public float liftstate;
	
	public ConstructorEntity(){}

	public void processGUIPacket(Side side, NBTTagCompound packet, EntityPlayer player, ConstConInterface container){
		switch(packet.getString("cargo")){
			case "part_install":{
				//TODO if(noveh(container)) return;
				/*PartData data = this.getPartData();
				String cat = packet.getString("category");
				data = getVehicleData().installPart(new MessageSenderI(container.getCommandSender()), data, cat, false);
				if(data == null) pdata = null; this.updateClient(null); return;*/
			}
			case "part_remove":{
				//TODO if(noveh(container)) return;
				String cat = packet.getString("category"); PartData data = this.getVehicleData().getPart(cat);
				if(data == null){ container.setTitleText("tile.fvtm.constructor.part_remove.not_found_server", null); return; }
				if(getVehicleData().deinstallPart(new MessageSenderI(container.getCommandSender()), cat, false)){
					dropItem(data.getNewStack().local());
					updateClient(null);
				}
				return;
			}
			case "tm_supplied":{
				//TODO if(nocon(container) && noveh(container) && noblk(container)) return;
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
				//TODO if(nocon(container) && noveh(container) && noblk(container)) return;
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
				//TODO if(nocon(container) && noveh(container) && noblk(container)) return;
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
					case "container":{
						dropContainer(true);
						container.setTitleText("tile.fvtm.constructor.drop.container", null);
						break;
					}
					case "vehicle":{
						dropVehicle(true);
						container.setTitleText("tile.fvtm.constructor.drop.vehicle", null);
						break;
					}
					case "block":{
						dropBlock(true);
						container.setTitleText("tile.fvtm.constructor.drop.block", null);
						break;
					}
					case "any": {
						dropContainer(true);
						dropVehicle(true);
						dropBlock(true);
						container.setTitleText("tile.fvtm.constructor.drop.all", null);
						break;
					}
				}
				return;
			}
			case "veh_name_change":{
				//TODO if(noveh(container)) return;
				vdata.setDisplayName(packet.hasKey("reset") && packet.getBoolean("reset") ? null : packet.getString("value"));
				container.setTitleText("tile.fvtm.constructor.name.changed", null);
				this.updateClient("vehicle");
				return;
			}
			default: return;
		}
	}

	public boolean nocon(MessageSender sender){
		if(getContainerData() == null){
			sender.bar("interact.fvtm.constructor.no_container");
			return true;
		}
		return false;
	}
	
	public boolean noveh(MessageSender sender){
		if(getVehicleData() == null){
			sender.bar("interact.fvtm.constructor.no_vehicle");
			return true;
		}
		return false;
	}

	public boolean noblk(MessageSender sender){
		if(getBlockData() == null){
			sender.bar("interact.fvtm.constructor.no_block");
			return true;
		}
		return false;
	}

	public void setLiftPos(BlockPos pos){
		center = pos;
		if(world.isRemote) return;
		NBTTagCompound compound = new NBTTagCompound();
		if(center != null) compound.setLong("CenterPos", center.toLong());
		if(center == null) compound.setBoolean("CenterReset", true);
		ApiUtil.sendTileEntityUpdatePacket(world, this.pos, compound);
	}

	public BlockPos getLiftPos(){
		return center;
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
	
	//

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
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
        	this.cdata = FvtmResources.getContainerData(packet.nbt.getCompoundTag("ContainerData"));
        }
        else if(packet.nbt.hasKey("ContainerDataReset") && packet.nbt.getBoolean("ContainerDataReset")){
        	this.cdata = null;
        }
        //
        if(packet.nbt.hasKey("BlockData")){
        	this.bdata = FvtmResources.getBlockData(packet.nbt.getCompoundTag("BlockData"));
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
		/*if(center instanceof ConstCenterEntity == false) return;
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
		}*/
	}

	public void updateClient(String type){
		markDirty();
    	if(type == null){
        	ApiUtil.sendTileEntityUpdatePacket(world, pos, writeToNBT(new NBTTagCompound()));
        	return;
    	}
    	NBTTagCompound compound = new NBTTagCompound();
    	switch(type){
			case "containerdata": case "container": case "con": {
				if(cdata != null) compound.setTag("ContainerData", cdata.write(null).local());
				else compound.setBoolean("ContainerDataReset", true); break;
			}
    		case "vehicledata": case "vehicle": case "veh": {
    			if(vdata != null) compound.setTag("VehicleData", vdata.write(TagCW.create()).local());
    			else compound.setBoolean("VehicleDataReset", true); break;
    		}
    		case "blockdata": case "block": {
    			if(bdata != null) compound.setTag("BlockData", bdata.write(new NBTTagCompound()).local());
    			else compound.setBoolean("BlockDataReset", true); break;
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
    	}
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
        if(cdata != null) compound.setTag("ContainerData", cdata.write(null).local());
			else compound.setBoolean("ContainerDataReset", true);
        if(vdata != null) compound.setTag("VehicleData", vdata.write(TagCW.create()).local());
			else compound.setBoolean("VehicleDataReset", true);
		if(bdata != null) compound.setTag("BlockData", bdata.write(new NBTTagCompound()).local());
		else compound.setBoolean("BlockDataReset", true);
        if(center != null){
			compound.setLong("Center", center.toLong());
		}
        compound.setFloat("LiftState", liftstate);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("VehicleData")){
        	vdata = FvtmResources.INSTANCE.getVehicleData(new TagCWI(compound.getCompoundTag("VehicleData")));
        }
        else if(compound.hasKey("VehicleDataReset") && compound.getBoolean("VehicleDataReset")){
        	vdata = null;
        }
        if(compound.hasKey("ContainerData")){
        	this.cdata = FvtmResources.getContainerData(compound.getCompoundTag("ContainerData"));
        }
        else if(compound.hasKey("ContainerDataReset") && compound.getBoolean("ContainerDataReset")){
        	this.cdata = null;
        }
        if(compound.hasKey("BlockData")){
        	this.bdata = FvtmResources.getBlockData(compound.getCompoundTag("BlockData"));
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
		if(cdata == null) return;
		dropItem(cdata.getNewStack().local());
		cdata = null;
		if(update) updateClient("containerdata");
	}

	public void dropVehicle(boolean update){
		if(vdata == null) return;
		dropItem(vdata.newItemStack().local());
		vdata = null;
		if(update)updateClient("vehicledata");
	}

	public void dropBlock(boolean update){
		if(bdata == null) return;
		dropItem(bdata.getNewStack().local());
		bdata = null;
		if(update) updateClient("blockdata");
	}

	public void setContainerData(ContainerData data, boolean send){
		cdata = data;
		if(send) updateClient("container");
	}

	public void setVehicleData(VehicleData data, boolean send){
		vdata = data;
		if(send) updateClient("vehicle");
	}

	public void setBlockData(BlockData data, boolean send){
		bdata = data;
		if(send) updateClient("block");
	}

	public void dropIfContainsAnyThing(){
		if(getContainerData() != null) dropContainer(true);
    	if(getVehicleData() != null) dropVehicle(true);
    	if(getBlockData() != null) dropBlock(true);
	}

}
