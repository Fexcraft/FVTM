package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class PipeContainer extends GenericContainer {
	
	protected MultiblockTileEntity tile;
	protected InvHandler handler;
	protected String id;

	public PipeContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
		if(tile == null) player.closeScreen();
		NBTTagCompound com = GuiHandler.validate(player, null, player.world.isRemote);
		if(com == null){
			player.closeScreen();
			return;
		}
		id = com.getString("inventory");
		handler = tile.getMultiBlockData().getInventory(id);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//
	}

}
