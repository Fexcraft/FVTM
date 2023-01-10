package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.uni.IDL;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class IDLImpl implements IDL {
	
	protected final ResourceLocation loc;

	public IDLImpl(String idl){
		loc = new ResourceLocation(idl);
	}

	public IDLImpl(ResourceLocation resloc){
		loc = resloc;
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
	public boolean equals(Object o){
		if(o instanceof IDLImpl) return ((IDLImpl)o).loc.equals(loc);
		if(o instanceof IDLNImpl) return ((IDLNImpl)o).loc.equals(loc);
		if(o instanceof ResourceLocation) return ((ResourceLocation)o).equals(loc);
		return o.toString().equals(this.toString());
	}
}
