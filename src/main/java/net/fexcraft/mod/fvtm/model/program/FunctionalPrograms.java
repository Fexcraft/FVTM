package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.mod.fvtm.model.Program.FunctionalProgram;

public class FunctionalPrograms {
	
	public static class EngineOn extends FunctionalProgram {

		public EngineOn(){
			super(ProgramConditions.ENGINE_ON);
		}
		
	}
	
	public static class EngineOff extends FunctionalProgram {

		public EngineOff(){
			super(ProgramConditions.ENGINE_OFF);
		}
		
	}
	
}
