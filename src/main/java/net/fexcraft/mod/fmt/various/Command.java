package net.fexcraft.mod.fmt.various;

import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

@fCommand
public class Command extends CommandBase {

	@Override
	public String getName(){
		return "fmt";
	}

	@Override
	public String getUsage(ICommandSender sender){
		return "fmt.command";
	}
	
	@Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
        return true;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer){
			EditorPlayerDataContainerCapability cap = sender.getCommandSenderEntity().getCapability(EPDCCU.CAPABILITY, null);
			Print.chat(sender, cap == null ? "No Capability Attached" : cap.geEditorTileEntity() == null ? "No Editor Selected" : cap.geEditorTileEntity().toString());
		}
		else{
			Print.chat(sender, "Not a player.");
		}
		//Print.chat(sender, sender instanceof EntityPlayer ? sender.getCommandSenderEntity().getCapability(EPDCCU.CAPABILITY, null).geEditorTileEntity() : "Not a Player.");
	}
	
}