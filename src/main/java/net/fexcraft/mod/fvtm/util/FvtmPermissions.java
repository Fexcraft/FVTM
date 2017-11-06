package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.PermissionNode;

public class FvtmPermissions {
	
	public static final String SPAWN_CMD = "fvtm.command.spawn-vehicle";
	
	public static final void register(){
		PermManager.add(SPAWN_CMD, PermissionNode.Type.BOOLEAN, false, true);
	}
	
}