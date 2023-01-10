package net.fexcraft.mod.uni.impl;

import java.util.HashMap;

import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 * 
 */
public class IDLManagerImpl implements IDLManager {
	
	private static final HashMap<String, IDL> CACHE = new HashMap<>();

	@Override
	public IDL get(String idl, boolean cache, boolean named){
		if(cache){
			if(CACHE.containsKey(idl)) return CACHE.get(idl);
			CACHE.put(idl, named ? new IDLNImpl(idl) : new IDLImpl(idl));
			return CACHE.get(idl);
		}
		return named ? new IDLNImpl(idl) : new IDLImpl(idl);
	}

}
