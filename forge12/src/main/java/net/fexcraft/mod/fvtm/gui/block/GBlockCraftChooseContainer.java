package net.fexcraft.mod.fvtm.gui.block;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.MULTIBLOCK_CRAFT_MAIN;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraftChooseContainer extends GenericContainer {

	protected GenericGui<GBlockCraftChooseContainer> gui;
	protected MultiblockTileEntity tile;
	public int page;

	public GBlockCraftChooseContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			switch(packet.getString("cargo")){
				case "choose":{
					//TODO ((CraftBlockScript)tile.getMultiBlockData().getScript()).setSelectedRecipe(tile, packet.getString("recipe"));
					player.openGui(FVTM.getInstance(), MULTIBLOCK_CRAFT_MAIN, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					break;
				}
				default: return;
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
	}

}
