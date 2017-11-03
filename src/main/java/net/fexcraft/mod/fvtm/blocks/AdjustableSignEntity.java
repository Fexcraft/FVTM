package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.blocks.AdjustableSign.AdjSignItem;
import net.fexcraft.mod.fvtm.model.block.AdjSignModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.registry.UCResourceLocation;
import net.fexcraft.mod.lib.util.render.ExternalTextureHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdjustableSignEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private byte width, height;
	private UCResourceLocation texture = new UCResourceLocation(Resources.NULL_TEXTURE);
	
	@SideOnly(Side.CLIENT)
	private AdjSignModel model;
	
	public AdjustableSignEntity(){
		width = 1;
		height = 1;
		if(Static.side().isClient()){
			model = AdjSignModel.getModel(width, height);
		}
	}
	
	public final AdjSignModel getModel(){
		return model;
	}
	
	public final ResourceLocation getTexture(){
		return texture;
	}
	
	public final int getWidth(){
		return this.width;
	}
	
	public final int getHeight(){
		return this.height;
	}

	public void enlarge(EnumFacing facing, int i){
		facing = facing.getOpposite();//heh...
		if(facing == EnumFacing.UP){
			this.height += 1;
		}
		else if(facing == EnumFacing.DOWN){
			this.width += 1;
		}
		this.sendUpdate();
	}

	public void setTexture(ItemStack stack){
		if(stack == null){
			this.texture = new UCResourceLocation(Resources.NULL_TEXTURE);
		}
		if(stack != null && stack.hasTagCompound() && stack.getTagCompound().hasKey(AdjSignItem.NBT)){
			this.texture = new UCResourceLocation("", stack.getTagCompound().getString(AdjSignItem.NBT));
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
		compound.setByte("width", width);
		compound.setByte("height", height);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		if(compound.hasKey("texture")){
			this.texture = new UCResourceLocation("", compound.getString("texture"));
		}
		if(compound.hasKey("width")){
			this.width = compound.getByte("width");
		}
		if(compound.hasKey("height")){
			this.height = compound.getByte("height");
		}
		//
		if(Static.side().isClient()){
			if(texture.toString().contains("fcl:remote/")){
				texture = new UCResourceLocation("", texture.toString().replace("fcl:remote/", ""));
			}
			model = AdjSignModel.getModel(width, height);
			texture = ExternalTextureHelper.get(texture.getResourcePath());
		}
	}
	
}
