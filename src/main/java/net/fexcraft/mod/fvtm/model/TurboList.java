package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

/**
 * Similar concept as the TurboList inside FMT-Standalone
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TurboList extends ArrayList<ModelRendererTurbo> {
	
	public static final TurboList EMPTY = new TurboList("fvtm:empty");
	public static final ProgramMap PROGRAMS = new ProgramMap();
	//
	public ArrayList<Program> programs = new ArrayList<>();
	public float /*rotX, rotY, rotZ, offX, offY, offZ,*/ scale = 0.0625F;
	public boolean visible = true, hasprog = false;
	public String name;
	
	public TurboList(String name){ super(); this.name = name; }
	
	public TurboList(String name, ModelRendererTurbo[] mrts){
		this(name); for(ModelRendererTurbo mrt : mrts){ this.add(mrt); }
	}

	public void render(Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
		/*GL11.glPushMatrix();
		if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(offX, offY, offZ);
		if(rotX != 0f) GL11.glRotatef(rotX, 1, 0, 0); if(rotY != 0f) GL11.glRotatef(rotY, 0, 1, 0); if(rotZ != 0f) GL11.glRotatef(rotZ, 0, 0, 1);*/
		if(hasprog) for(Program program : programs) program.preRender(this, ent, data, color, part, cache);
		if(visible) for(ModelRendererTurbo turbo : this){ turbo.render(scale); }
		if(hasprog) for(Program program : programs) program.postRender(this, ent, data, color, part, cache);
		/*if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(-offX, -offY, -offZ);
		GL11.glPopMatrix();*/
	}

	public void renderBlock(TileEntity tile, BlockData data, RenderCache cache){
		if(hasprog) for(Program program : programs) program.preRender(this, tile, data, cache);
		if(visible) for(ModelRendererTurbo turbo : this){ turbo.render(scale); }
		if(hasprog) for(Program program : programs) program.postRender(this, tile, data, cache);
	}
	
	public void renderPlain(){
		for(ModelRendererTurbo turbo : this){ turbo.render(scale); }
	}

	public void translate(float x, float y, float z){
		for(ModelRendererTurbo mrt : this){ mrt.rotationPointX += x; mrt.rotationPointY += y; mrt.rotationPointZ += z; }
	}

	public void scale(float flt){
		this.scale = flt;
	}
	
	public void rotate(float x, float y, float z){ rotate(x, y, z, false); }

	public void rotate(float x, float y, float z, boolean apply){
		if(apply){
			for(ModelRendererTurbo mrt : this){ mrt.rotationAngleX = x; mrt.rotationAngleY = y; mrt.rotationAngleZ = z; }
		}
		else {
			for(ModelRendererTurbo mrt : this){ mrt.rotationAngleX += x; mrt.rotationAngleY += y; mrt.rotationAngleZ += z; }
		}
	}

	public void rotateAxis(float value, int axis, boolean apply){
		switch(axis){
			case 0: {
				if(apply){ for(ModelRendererTurbo mrt : this) mrt.rotationAngleX = value; }
				else{ for(ModelRendererTurbo mrt : this) mrt.rotationAngleX += value; } return;
			}
			case 1: {
				if(apply){ for(ModelRendererTurbo mrt : this) mrt.rotationAngleY = value; }
				else{ for(ModelRendererTurbo mrt : this) mrt.rotationAngleY += value; } return;
			}
			case 2: {
				if(apply){ for(ModelRendererTurbo mrt : this) mrt.rotationAngleZ = value; }
				else{ for(ModelRendererTurbo mrt : this) mrt.rotationAngleZ += value; } return;
			}
			default: return;
		}
	}
	
	public void addProgram(String str){
		Program prog = PROGRAMS.get(str);
		if(prog != null) programs.add(prog);
		else return;
		hasPrograms();
	}
	
	public void addPrograms(String... strs){
		for(String str : strs) addProgram(str); hasPrograms();
	}
	
	public void addProgram(Program program){
		this.programs.add(program); hasPrograms();
	}
	
	public void addPrograms(Program... programs){
		for(Program program : programs) addProgram(program); hasPrograms();
	}
	
	public boolean hasPrograms(){
		return this.hasprog = this.programs.size() > 0;
	}
	
	/** @author Ferdinand Calo' (FEX___96) */
	public static interface Program {
		
		public default String getId(){ return "idless"; }

		/** General Purpose */
		public default void preRender(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){}
		
		/** General Purpose */
		public default void postRender(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){}

		/** Block Specific */
		public default void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){}
		
		/** Block Specific */
		public default void postRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){}
		
	}
	
	public static class ProgramMap extends TreeMap<String, Program> {
		
		public void add(Program prog){ this.put(prog.getId(), prog); }
		
	}
	
}