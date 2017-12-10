package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.blocks.CylinderSign.CylSignItem;
import net.fexcraft.mod.fvtm.model.block.CylSignModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.UCResourceLocation;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CylinderSignEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>{
	
	private byte segments, scale;
	private UCResourceLocation texture = new UCResourceLocation(Resources.NULL_TEXTURE);
	
	@SideOnly(Side.CLIENT)
	private CylSignModel model;
	
	public CylinderSignEntity(){
		segments = 8;
		scale = 10;
		if(Static.side().isClient()){
			model = CylSignModel.getModel(segments, scale);
		}
	}
	
	public final CylSignModel getModel(){
		return model;
	}
	
	public final ResourceLocation getTexture(){
		return texture;
	}
	
	public final int getSegments(){
		return this.segments;
	}
	
	public final int getScale(){
		return this.scale;
	}
	
	public void enlarge(){
		this.scale += 1;
		if(scale > 80){
			scale = 80;
		}
		this.sendUpdate();
	}

	public void addSegment(){
		this.segments += 1;
		if(segments > 64){
			segments = 64;
		}
		this.sendUpdate();
	}

	public void setTexture(ItemStack stack, EntityPlayer player){
		if(stack == null){
			this.texture = new UCResourceLocation(Resources.NULL_TEXTURE);
			Print.chat(player, "Resseting texture.");
		}
		if(stack != null && stack.hasTagCompound() && stack.getTagCompound().hasKey(CylSignItem.NBT)){
			this.texture = new UCResourceLocation("", stack.getTagCompound().getString(CylSignItem.NBT));
			Print.chat(player, "Texture set to: " + this.texture.getResourcePath());
		}
		this.sendUpdate();
	}

	public final void sendUpdate(){
		ApiUtil.sendTileEntityUpdatePacket(world, pos, this.getUpdateTag());
	}
	
	@Override
	public final void processClientPacket(PacketTileEntityUpdate pkt){
		this.readFromNBT(pkt.nbt);
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
		super.readFromNBT(pkt.getNbtCompound());
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setString("texture", this.texture.getResourcePath());
		compound.setByte("segments", segments);
		compound.setByte("scale", scale);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		if(compound.hasKey("texture")){
			this.texture = new UCResourceLocation("", compound.getString("texture"));
		}
		if(compound.hasKey("segments")){
			this.segments = compound.getByte("segments");
		}
		if(compound.hasKey("scale")){
			this.scale = compound.getByte("scale");
		}
		//
		if(Static.side().isClient()){
			if(texture.toString().contains("fcl:remote/")){
				texture = new UCResourceLocation("", texture.toString().replace("fcl:remote/", ""));
			}
			model = CylSignModel.getModel(segments, scale);
			texture = ExternalTextureHelper.get(texture.getResourcePath());
		}
	}
	
	@SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared(){
        return 512D;
    }

}
