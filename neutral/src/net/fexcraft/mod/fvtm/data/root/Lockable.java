package net.fexcraft.mod.fvtm.data.root;

import java.util.UUID;

import net.fexcraft.mod.fvtm.data.Saveable;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.item.ItemWrapper;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Lockable implements Saveable {

	private String code;
	private boolean locked;

	public static final IDL DEFAULT_KEY = IDLManager.getIDLCached("gep:key");

	public boolean isLocked(){
		return locked;
	}

	public String getCode(){
		return code;
	}

	public void setLocked(Boolean bool){
		locked = bool == null ? !locked : bool;
	}

	public static String newCode(){
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public static boolean isKey(ItemWrapper item){
		return item.local() instanceof LockableItem;
	}

	public void toggle(MessageSender sender, StackWrapper stack){
		boolean valid = stack.getItem().direct() instanceof LockableItem;
		if(!valid || ((LockableItem)stack.getItem().local()).getLockCode(stack) == null){
			sender.send("&cThis is not a key.");
			return;
		}
		String icode = ((LockableItem)stack.getItem().local()).getLockCode(stack);
		if(icode.equals(getCode())){
			setLocked(null);
			sender.bar(isLocked() ? "&cLocked." : "&aUnlocked.");
		}
		else{
			sender.bar("&cKey code does not match.");
		}
	}

	@Override
	public void save(TagCW com){
		com.set("Locked", locked);
		if(code != null) com.set("LockCode", code);
	}

	@Override
	public void load(TagCW com){
		locked = com.getBoolean("Locked");
		code = com.has("LockCode") ? com.getString("LockCode") : newCode();
	}

	public static interface LockableItem {

		public String getLockCode(StackWrapper stack);

	}

}
