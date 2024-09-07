package net.fexcraft.mod.fvtm.model;

import java.util.LinkedHashMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ProgramRegistry extends LinkedHashMap<String, Program> {

	public void add(Program prog){
		put(prog.id(), prog);
	}

}
