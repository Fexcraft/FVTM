package net.fexcraft.mod.uni.impl;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class IDLNImpl implements IDL {
	
	protected final NamedResourceLocation loc;

	public IDLNImpl(String idl){
		loc = new NamedResourceLocation(idl);
	}

	public IDLNImpl(String name, ResourceLocation resloc){
		loc = new NamedResourceLocation(name, resloc);
	}

	@Override
	public String domain(){
		return loc.getNamespace();
	}

	@Override
	public String id(){
		return loc.getPath();
	}

	@Override
	public String path(){
		return loc.getPath();
	}
	
	@Override
	public String toString(){
		return loc.toString();
	}

	@Override
	public String name(){
		return loc.getName();
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof IDLImpl) return ((IDLImpl)o).loc.equals(loc);
		if(o instanceof IDLNImpl) return ((IDLNImpl)o).loc.equals(loc);
		if(o instanceof ResourceLocation) return ((ResourceLocation)o).equals(loc);
		return o.toString().equals(this.toString());
	}

}
