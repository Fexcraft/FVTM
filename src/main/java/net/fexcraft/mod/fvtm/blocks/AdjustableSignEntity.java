package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.model.block.AdjSignModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdjustableSignEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
	
	private int width, height;
	private ResourceLocation texture = Resources.NULL_TEXTURE;
	
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
	
}
