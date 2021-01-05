package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class GuiCommandSender implements ICommandSender {
	
	public EntityPlayer player;
	
	public GuiCommandSender(EntityPlayer player){
		this.player = player;
	}

	@Override
	public String getName(){
		return player.getName();
	}

	@Override
	public boolean canUseCommand(int permLevel, String commandName){
		return player.canUseCommand(permLevel, commandName);
	}

	@Override
	public World getEntityWorld(){
		return player.world;
	}

	@Override
	public MinecraftServer getServer(){
		return Static.getServer();
	}
	
	@Override
	public void sendMessage(ITextComponent component){
		//player.sendMessage(component);
		if(player instanceof EntityPlayerMP){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", GuiHandler.LISTENERID);
			compound.setString("task", "gui:cmd:msg");
			compound.setString("msg", component.getFormattedText());
			PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), (EntityPlayerMP)player);
		}
		else{
			ClientReceiver.LAST_MSG = component.getFormattedText();
		}
    }

}
