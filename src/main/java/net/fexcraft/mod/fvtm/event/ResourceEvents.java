package net.fexcraft.mod.fvtm.event;


import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.Modifier;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ResourceEvents extends Event {
	
	private Resources resources;
	
	public ResourceEvents(Resources resources){
		this.resources = resources;
	}
	
	public Resources getResources(){
		return resources;
	}

	public static class RegisterFunctions extends ResourceEvents {
		
		public RegisterFunctions(Resources resources){
			super(resources);
		}
		
		public void registerFunction(String regname, Class<? extends Function> function){
			Resources.registerFunction(regname, function, false);
		}
		
		public void registerFunction(ResourceLocation regname, Class<? extends Function> function){
			Resources.registerFunction(regname, function, false);
		}

		public void registerBlockFunction(String regname, Class<? extends BlockFunction> function){
			Resources.registerBlockFunction(regname, function, false);
		}

		public void registerBlockFunction(ResourceLocation regname, Class<? extends BlockFunction> function){
			Resources.registerBlockFunction(regname, function, false);
		}
		
	}
	
	public static class RegisterAttributeTypes extends ResourceEvents {
		
		public RegisterAttributeTypes(Resources resources){
			super(resources);
		}
		
		public void registerAttrType(String regname, Class<? extends Attribute<?>> attr_type){
			Resources.registerAttributeType(regname, attr_type, false);
		}
		
		public void registerAttrType(ResourceLocation regname, Class<? extends Attribute<?>> attr_type){
			Resources.registerAttributeType(regname, attr_type, false);
		}
		
	}
	
	public static class RegisterModifierImpls extends ResourceEvents {
		
		public RegisterModifierImpls(Resources resources){
			super(resources);
		}
		
		public void registerModifierImpl(String regname, Class<? extends Modifier<?>> attr_type){
			Resources.registerModifierImpl(regname, attr_type, false);
		}
		
		public void registerModifierImpl(ResourceLocation regname, Class<? extends Modifier<?>> attr_type){
			Resources.registerModifierImpl(regname, attr_type, false);
		}
		
	}

}
