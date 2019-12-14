package net.fexcraft.mod.fvtm.sys.railplus;

import java.util.ArrayList;

public class Section {

	public ArrayList<Gleis> gleise = new ArrayList<>();
	public final long id;
	
	public Section(long id){
		this.id = id;
	}

}
