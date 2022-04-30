package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class DecoEditorContainer extends GenericContainer {
	
	protected Decoration deco;
	protected DecorationData selected;

	public DecoEditorContainer(EntityPlayer player, World world, int entid){
		super(player);
		deco = (Decoration)world.getEntityByID(entid);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//
	}

}
