package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;

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

	public TurboList(String name, ModelRendererTurbo mrt){
		this(name); this.add(mrt);
	}

	public void render(Entity ent, VehicleData data, Colorable color, String part, RenderCache cache){
		/*GL11.glPushMatrix();
		if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(offX, offY, offZ);
		if(rotX != 0f) GL11.glRotatef(rotX, 1, 0, 0); if(rotY != 0f) GL11.glRotatef(rotY, 0, 1, 0); if(rotZ != 0f) GL11.glRotatef(rotZ, 0, 0, 1);*/
		if(hasprog) for(Program program : programs) program.preRender(this, ent, data, color, part, cache);
		if(visible) for(ModelRendererTurbo turbo : this) turbo.render(scale);
		if(hasprog) for(Program program : programs) program.postRender(this, ent, data, color, part, cache);
		/*if(offX != 0f || offY != 0f || offZ != 0f) GL11.glTranslatef(-offX, -offY, -offZ);
		GL11.glPopMatrix();*/
	}

	public void renderBlock(TileEntity tile, BlockData data, RenderCache cache){
		if(hasprog) for(Program program : programs) program.preRender(this, tile, data, cache);
		if(visible) for(ModelRendererTurbo turbo : this) turbo.render(scale);
		if(hasprog) for(Program program : programs) program.postRender(this, tile, data, cache);
	}

	public void renderPlain(){
		for(ModelRendererTurbo turbo : this) turbo.render(scale);
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

		/** For creating instances from JTMT/OBJ/FMF if necessary. */
		public default Program parse(JsonElement elm){ return this; }
		
		/** For creating instances from JTMT/OBJ/FMF if necessary. */
		public default Program parse(String[] args){ return this; }
		
		public default <T extends Program> T register(){
			TurboList.PROGRAMS.add(this);
			return (T)this;
		}

		/** Called when a turbolist is added into the model, preload program data here if neccessary. */
		public default void init(TurboList list){}
		
	}
	
	public static class ConditionalProgram implements Program {
		
		protected ArrayList<Program> programs = new ArrayList<>(), opposite = new ArrayList<>();
		protected boolean passed;

		/** General Purpose */
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return true;
		}
		
		@Override
		public void preRender(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			if(passed = test(list, ent, data, color, part, cache)){
				for(Program prog : programs) prog.preRender(list, ent, data, color, part, cache);
			}
			else{
				for(Program prog : opposite) prog.preRender(list, ent, data, color, part, cache);
			}
		}
		
		@Override
		public void postRender(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			if(passed){
				for(Program prog : programs) prog.postRender(list, ent, data, color, part, cache);
			}
			else{
				for(Program prog : opposite) prog.postRender(list, ent, data, color, part, cache);
			}
		}
		
		//

		/** Block Specific */
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return true;
		}
		
		@Override
		public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			if(passed = test(list, tile, data, cache)){
				for(Program prog : programs) prog.preRender(list, tile, data, cache);
			}
			else{
				for(Program prog : opposite) prog.preRender(list, tile, data, cache);
			}
		}
		
		@Override
		public void postRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			if(passed){
				for(Program prog : programs) prog.postRender(list, tile, data, cache);
			}
			else{
				for(Program prog : opposite) prog.postRender(list, tile, data, cache);
			}
		}
		
		//
		
		public ConditionalProgram add(Program... programs){
			for(Program prog : programs) this.programs.add(prog);
			return this;
		}
		
		public ConditionalProgram addElse(Program... programs){
			for(Program prog : programs) this.opposite.add(prog);
			return this;
		}
		
		public ConditionalProgram addNegative(Program... programs){
			return addElse(programs);
		}
		
		public ConditionalProgram addOpposite(Program... programs){
			return addElse(programs);
		}
		
	}
	
	public static class FunctionalProgram extends ConditionalProgram {
		
		protected Predicate<GeneralProgramObject> general;
		protected Predicate<BlockProgramObject> block;
		
		public FunctionalProgram(Predicate<?> pred, int index){
			switch(index){
				case 0: general = (Predicate<GeneralProgramObject>)pred; break;
				case 1: block = (Predicate<BlockProgramObject>)pred; break;
			}
		}

		/** General Purpose */
		@Override
		public boolean test(TurboList list, @Nullable Entity ent, VehicleData data, @Nullable Colorable color, @Nullable String part, @Nullable RenderCache cache){
			return general.test(GeneralProgramObject.INST.set(list, ent, data, color, part, cache));
		}

		/** Block Specific */
		@Override
		public boolean test(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			return block.test(BlockProgramObject.INST.set(list, tile, data, cache));
		}
		
	}
	
	/* Application ONLY internally. */
	public static class GeneralProgramObject {
		
		public static final GeneralProgramObject INST = new GeneralProgramObject();
		
		public TurboList list;
		public Entity ent;
		public VehicleData data;
		public Colorable color;
		public String part;
		public RenderCache cache;
		
		public GeneralProgramObject set(TurboList list2, Entity ent2, VehicleData data2, Colorable color2, String part2, RenderCache cache2){
			list = list2;
			ent = ent2;
			data = data2;
			color = color2;
			part = part2;
			cache = cache2;
			return this;
		}
		
	}

	/* Application ONLY internally. */
	public static class BlockProgramObject {
		
		public static final BlockProgramObject INST = new BlockProgramObject();
		
		public TurboList list;
		public TileEntity tile;
		public BlockData data;
		public RenderCache cache;
		
		public BlockProgramObject set(TurboList list2, TileEntity tile2, BlockData data2, RenderCache cache2){
			list = list2;
			tile = tile2;
			data = data2;
			cache = cache2;
			return this;
		}
		
	}
	
	public static class ProgramMap extends TreeMap<String, Program> {
		
		public void add(Program prog){ this.put(prog.getId(), prog); }
		
	}

	public void initPrograms(){
		for(Program prog : programs) prog.init(this);
	}
	
}