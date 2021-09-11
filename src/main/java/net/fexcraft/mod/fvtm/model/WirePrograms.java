package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.fvtm.model.TurboList.Program;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		TurboList.PROGRAMS.add(AT_START);
		TurboList.PROGRAMS.add(AT_BOTH);
		TurboList.PROGRAMS.add(AT_END);
	}

	public static final Program AT_START = new Program(){ public String getId(){ return "fvtm:wire_at_start"; } };
	public static final Program AT_BOTH = new Program(){ public String getId(){ return "fvtm:wire_at_both"; } };
	public static final Program AT_END = new Program(){ public String getId(){ return "fvtm:wire_at_end"; } };
	
}