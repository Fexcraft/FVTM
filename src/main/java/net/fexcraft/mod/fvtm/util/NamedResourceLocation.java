package net.fexcraft.mod.fvtm.util;

import net.minecraft.resources.ResourceLocation;

/** 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class NamedResourceLocation extends ResourceLocation {
	
	private static final String defname = "Unnamed";
	private String name;

	public NamedResourceLocation(String name, String domain, String path){
		super(domain, path); if(name == null) name = defname; this.name = name;
    }

	public NamedResourceLocation(String name, ResourceLocation rs){
		this(name, rs.getNamespace(), rs.getPath());
	}
	
	public NamedResourceLocation(String onestring){
		super(onestring.contains(";") ? onestring.split(";")[1] : onestring);
		name = onestring.contains(";") ? onestring.split(";")[0] : defname;
	}

	public String getName(){
		return name;
	}
	
	public NamedResourceLocation setName(String newname){
		this.name = newname; return this;
	}
	
}