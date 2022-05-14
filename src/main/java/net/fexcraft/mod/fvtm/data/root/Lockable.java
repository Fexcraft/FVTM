package net.fexcraft.mod.fvtm.data.root;

import java.util.UUID;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public interface Lockable {
	
	public static final ResourceLocation DEFAULT_KEY = new ResourceLocation("gep:key");
	
	public boolean isLocked();
	
	public String getLockCode();
	
	public void setLocked(Boolean bool);

	public static String newCode(){
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public static boolean isKey(Item item){
		return false;//TODO material items // item instanceof MaterialItem && ((MaterialItem)item).getType().isVehicleKey();
	}

	/*public static void toggle(Lockable lockable, ICommandSender sender, ItemStack stack){
		boolean invalid = stack.getItem() instanceof MaterialItem == false;
		MaterialItem item = invalid ? null : (MaterialItem)stack.getItem();
		if(invalid || item.getLockCode(stack) == null){//returns null when not a vehicle key
			Print.chatbar(sender, "&cThis item isn't a key.");
			return;
		}
		String code = item.getLockCode(stack);
		if(code.equals(lockable.getLockCode())){
			lockable.setLocked(null);
			Print.chatbar(sender, lockable.isLocked() ? "&cLocked." : "&aUnlocked.");
		}
		else{
			Print.chatbar(sender, "&cKey code does not match.");
		}
		
	}*///TODO locking

}
