package net.fexcraft.mod.fvtm.util;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface CTab {

	public static LinkedHashMap<IDL, CTab> TABS = new LinkedHashMap<>();
	public static final String DEFAULT = "default";
	public static Class<? extends CTab>[] IMPL = new Class[1];

	public static CTab create(Addon addon, String id, String icon){
		IDL aid = IDLManager.getIDLCached(addon.getID().id() + ":" + id);
		if(TABS.containsKey(aid)) return TABS.get(aid);
		try {
			TABS.put(aid, IMPL[0].getConstructor(Addon.class, String.class, String.class).newInstance(addon, id, icon));
		}
		catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return TABS.get(aid);
	}

}
