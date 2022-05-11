package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorContainer;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class ConstructorCommandSender implements ICommandSender {
	
	private ConstructorContainer container;
	
	public ConstructorCommandSender(ConstructorContainer con){
		this.container = con;
	}

	@Override
	public String getName(){
		return "CCS";
	}
	
	@Override
	public void sendMessage(ITextComponent component){
		if(container == null || container.getTileEntity() == null
			|| container.getTileEntity().getWorld() == null
			|| container.getTileEntity().getWorld().isRemote) return;
		container.setTitleText(component.getUnformattedText(), RGB.WHITE.packed);
    }

	@Override
	public boolean canUseCommand(int permLevel, String commandName){
		return false;
	}

	@Override
	public World getEntityWorld(){
		return this.getServer().getEntityWorld();
	}

	@Override
	public MinecraftServer getServer(){
		return Static.getServer();
	}

}
