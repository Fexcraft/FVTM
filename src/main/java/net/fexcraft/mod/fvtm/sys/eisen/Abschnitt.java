package net.fexcraft.mod.fvtm.sys.eisen;

import java.util.ArrayList;

public class Abschnitt {

	public ArrayList<Gleis> gleise = new ArrayList<>();
	public final long id;
	
	public Abschnitt(long id){
		this.id = id;
	}

}
