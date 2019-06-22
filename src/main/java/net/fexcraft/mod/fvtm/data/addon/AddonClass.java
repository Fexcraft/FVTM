package net.fexcraft.mod.fvtm.data.addon;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddonClass {
	
	public String registryname();
	
	/** If this hasn't a json, it is expected that the file with this annotation extends net.fexcraft.mod.fvtm.data.Addon.class */
	public boolean hasJson() default true;

}
