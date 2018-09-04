package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public abstract class GenericGuiContainer extends Container {
	
	protected EntityPlayer player;
	
	public GenericGuiContainer(){}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return !(player == null);
    }

	public void setPlayer(EntityPlayer player){
		this.player = player;
	}
	
	protected void send(Side side, NBTTagCompound packet){
        packet.setString("target_listener", "fvtm"); packet.setString("task", "generic_gui");
    	if(side.isClient()){
    		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(packet));
    	}
    	else{
    		PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(packet), (EntityPlayerMP)player);
    	}
	}
	
	protected abstract void packet(Side side, NBTTagCompound packet, EntityPlayer player);
	
	public static class DefImpl extends GenericGuiContainer {

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			//
		}
		
	}

}
