package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class DecoEditorContainer extends GenericContainer {

	public DecoEditorContainer(EntityPlayer player, World world, int entid){
		super(player);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		// TODO Auto-generated method stub
		
	}

}
