package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.TreeMap;

import net.minecraft.util.math.BlockPos;

public class LineSection {
	
	public String id;
	public ArrayList<RailEntity> entities = new ArrayList<>();
	public TreeMap<BlockPos, Junction> junctions = new TreeMap<>();
	
	public LineSection(String id){
		this.id = id;
	}
	
	public boolean isOccupied(){
		return !isFree();
	}

	private boolean isFree(){
		return entities.isEmpty();
	}
	
	@Override
	public boolean equals(Object obj){
		return obj instanceof LineSection ? ((LineSection)obj).id.equals(id) : false;
	}
	
}