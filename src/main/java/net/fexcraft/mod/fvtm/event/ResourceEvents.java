package net.fexcraft.mod.fvtm.event;


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
		
	}

}
