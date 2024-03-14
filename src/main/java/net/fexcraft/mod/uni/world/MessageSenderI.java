package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.utils.Formatter;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class MessageSenderI implements MessageSender {

	private final ICommandSender sender;

	public MessageSenderI(ICommandSender sender){
		this.sender = sender;
	}

	@Override
	public void send(String s){
		sender.sendMessage(new TextComponentString(Formatter.format(s)));
	}

	@Override
	public void send(String str, Object... args){
		sender.sendMessage(new TextComponentString(Formatter.format(str, args)));
	}

	@Override
	public void bar(String s){
		if(sender instanceof EntityPlayer){
			((EntityPlayer)sender.getCommandSenderEntity()).sendStatusMessage(new TextComponentString(Formatter.format(s)), true);
		}
		else send(s);
	}

	@Override
	public void dismount(){
		if(sender.getCommandSenderEntity() != null){
			sender.getCommandSenderEntity().dismountRidingEntity();
		}
	}

}
