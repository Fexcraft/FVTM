package net.fexcraft.mod.fvtm.model.program;

import java.util.function.BiPredicate;

import net.fexcraft.mod.fvtm.function.part.EngineFunction;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;

/** Some Predefined Conditions, to be used with custom FunctionalProgram extensions. */
public class ProgramConditions {
	
	private static EngineFunction enginefunc;
	
	public static final BiPredicate<ModelGroup, ModelRenderData> ENGINE_ON = (group, data) -> {
		if(data.entity == null || !data.vehicle.hasPart("engine")) return false;
		enginefunc = data.vehicle.getPart("engine").getFunction("fvtm:engine");
		return enginefunc != null && enginefunc.isOn();
	};
	
	public static final BiPredicate<ModelGroup, ModelRenderData> ENGINE_OFF = (group, data) -> {
		if(data.entity == null || !data.vehicle.hasPart("engine")) return false;
		enginefunc = data.vehicle.getPart("engine").getFunction("fvtm:engine");
		return enginefunc == null || !enginefunc.isOn();
	};
	
}
