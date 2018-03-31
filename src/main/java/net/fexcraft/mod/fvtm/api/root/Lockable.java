package net.fexcraft.mod.fvtm.api.root;

import javax.annotation.Nullable;

public interface Lockable {
	
	public boolean isLocked();
	
	public boolean setLocked(@Nullable Boolean lock);

	public String getLockCode();
	
	public default boolean allowsLocking(){
		return true;
	}
	
}