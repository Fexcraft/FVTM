package net.fexcraft.mod.fvtm.gui.tsign;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class TrafficSignEditorContainer extends GenericContainer {
	
	protected GenericGui<TrafficSignEditorContainer> gui;
	
	public TrafficSignEditorContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		//
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		//
	}

	@Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
