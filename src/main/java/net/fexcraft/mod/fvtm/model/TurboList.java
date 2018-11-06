package net.fexcraft.mod.fvtm.model;

import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.lang.ArrayList;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;

/**
 * Similar concept as the TurboList inside FMT-Standalone
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TurboList extends ArrayList<ModelRendererTurbo> {
	
	private static final long serialVersionUID = 1L;
	protected static final TurboList EMPTY = new TurboList("fvtm:empty");
	public static final ProgramMap PROGRAMS = new ProgramMap();
	//
	public ArrayList<Program> programs = new ArrayList<>();
	//public float rotX, rotY, rotZ, offX, offY, offZ;
	protected RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	public String name;
	
	public TurboList(String name){ super(); this.name = name; }
	
	public TurboList(String name, ModelRendererTurbo[] mrts){
		this(name); for(ModelRendererTurbo mrt : mrts){ this.add(mrt); }
	}

	public void render(VehicleData data){
		render(null, data, data, null);
	}

	public void render(VehicleData data, String part){
		render(null, data, data, part);
	}

	public void render(VehicleEntity entity, VehicleData data){
		render(entity, data, data, null);
	}

	public void render(VehicleEntity ent, VehicleData data, String part){
		render(ent, data, data, part);
	}

	public void render(VehicleEntity ent, VehicleData data, Colorable color, String part){
		/*GL11.glPushMatrix();
		if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(offX, offY, offZ);
		if(rotX != 0f) GL11.glRotatef(rotX, 1, 0, 0);
		if(rotY != 0f) GL11.glRotatef(rotY, 0, 1, 0);
		if(rotZ != 0f) GL11.glRotatef(rotZ, 0, 0, 1);*/
		if(programs.size() > 0) for(Program program : programs) program.preRender(this, ent, data, color, part);
		for(ModelRendererTurbo turbo : this){ turbo.render(); }
		if(programs.size() > 0) for(Program program : programs) program.postRender(this, ent, data, color, part);
		/*if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(offX, offY, offZ);
		GL11.glPopMatrix();*/
	}

	public void translate(float x, float y, float z){
		for(ModelRendererTurbo mrt : this){ mrt.rotationPointX += x; mrt.rotationPointY += y; mrt.rotationPointZ += z; }
	}
	
	public void rotate(float x, float y, float z){
		rotate(x, y, z, false);
	}

	public void rotate(float x, float y, float z, boolean apply){
		if(apply){
			for(ModelRendererTurbo mrt : this){ mrt.rotateAngleX = x; mrt.rotateAngleY = y; mrt.rotateAngleZ = z; }
		}
		else {
			for(ModelRendererTurbo mrt : this){ mrt.rotateAngleX += x; mrt.rotateAngleY += y; mrt.rotateAngleZ += z; }
		}
	}
	
	public void addProgram(String str){
		Program prog = PROGRAMS.get(str); if(prog != null) programs.add(prog); else return;
	}
	
	public void addPrograms(String[] strs){
		for(String str : strs) addProgram(str);
	}
	
	public void addProgram(Program program){
		this.programs.add(program);
	}
	
	public void addPrograms(Program[] programs){
		for(Program program : programs) addProgram(program);
	}
	
	public static interface Program {
		
		public String getId();
		
		public void preRender(TurboList list, @Nullable VehicleEntity ent, VehicleData data, @Nullable Colorable color, @Nullable String Part);
		
		public void postRender(TurboList list, @Nullable VehicleEntity ent, VehicleData data, @Nullable Colorable color, @Nullable String Part);
		
	}
	
	public static class ProgramMap extends TreeMap<String, Program> {
		
		public void add(Program prog){ this.put(prog.getId(), prog); }
		
	}
	
	/*@FunctionalInterface
	public static interface ProgramEx<P, T, E, V, S> {
		public void execute(P prog, T list, E ent, V data, S part);
	}*/
	
}