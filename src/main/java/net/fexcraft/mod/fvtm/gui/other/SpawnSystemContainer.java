package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class SpawnSystemContainer extends GenericContainer {
	
	protected GenericGui<SpawnSystemContainer> gui;

	public SpawnSystemContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }

}
