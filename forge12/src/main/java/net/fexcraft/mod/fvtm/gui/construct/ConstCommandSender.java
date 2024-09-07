package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class ConstCommandSender implements ICommandSender {
	
	private ConstContainer container;
	
	public ConstCommandSender(ConstContainer con){
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
		container.setTitleText(component.getUnformattedText(), RGB.WHITE);
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
