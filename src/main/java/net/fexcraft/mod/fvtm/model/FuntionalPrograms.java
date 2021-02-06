package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.fvtm.model.TurboList.FunctionalProgram;

public class FuntionalPrograms {
	
	public static class EngineOn extends FunctionalProgram {

		public EngineOn(){
			super(ProgramConditions.ENGINE_ON, 0);
		}
		
	}
	
	public static class EngineOff extends FunctionalProgram {

		public EngineOff(){
			super(ProgramConditions.ENGINE_OFF, 0);
		}
		
	}
	
}
