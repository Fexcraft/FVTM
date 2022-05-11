package net.fexcraft.mod.fvtm.model;

import java.util.function.Predicate;

import net.fexcraft.mod.fvtm.model.TurboList.GeneralProgramObject;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;

/** Some Predefined Conditions, to be used with custom FunctionalProgram extensions. */
public class ProgramConditions {
	
	private static EngineFunction enginefunc;
	
	public static final Predicate<GeneralProgramObject> ENGINE_ON = obj -> {
		if(obj.ent == null || !obj.data.hasPart("engine")) return false;
		enginefunc = obj.data.getPart("engine").getFunction("fvtm:engine");
		return enginefunc != null && enginefunc.isOn();
	};
	
	public static final Predicate<GeneralProgramObject> ENGINE_OFF = obj -> {
		if(obj.ent == null || !obj.data.hasPart("engine")) return false;
		enginefunc = obj.data.getPart("engine").getFunction("fvtm:engine");
		return enginefunc == null || !enginefunc.isOn();
	};
	
}
