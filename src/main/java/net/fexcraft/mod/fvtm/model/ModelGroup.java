package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.BiPredicate;

import com.google.gson.JsonElement;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.root.Model.ModelRenderData;

/**
 * Similar concept as the TurboList inside FMT-Standalone
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ModelGroup extends ArrayList<ModelRendererTurbo> {
	
	public static final ModelGroup EMPTY = new ModelGroup("fvtm:empty");
	public static final ProgramMap PROGRAMS = new ProgramMap();
	//
	private ArrayList<Program> all_programs = new ArrayList<>();
	private ArrayList<Program> pre_programs = new ArrayList<>();
	private ArrayList<Program> pst_programs = new ArrayList<>();
	public float /*rotX, rotY, rotZ, offX, offY, offZ,*/ scale = 0.0625F;
	public boolean visible = true, has_pre_prog = false, has_pst_prog;
	private boolean hasinit = false;
	public String name;
	
	public ModelGroup(String name){
		super();
		this.name = name;
	}
	
	public ModelGroup(String name, ModelRendererTurbo[] mrts){
		this(name);
		for(ModelRendererTurbo mrt : mrts) this.add(mrt);
	}

	public ModelGroup(String name, ModelRendererTurbo mrt){
		this(name);
		this.add(mrt);
	}

	public void render(ModelRenderData data){
		if(has_pre_prog) for(Program program : pre_programs) program.preRender(this, data);
		if(visible) for(ModelRendererTurbo turbo : this) turbo.render(scale);
		if(has_pst_prog) for(Program program : pst_programs) program.postRender(this, data);
	}

	public void render(){
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
		addProgram(PROGRAMS.get(str));
	}
	
	public void addPrograms(String... strs){
		for(String str : strs) addProgram(str);
	}
	
	public void addProgram(Program program){
		if(program == null || hasinit) return;
		if(program.isPreRender()) pre_programs.add(program);
		if(program.isPostRender()) pst_programs.add(program);
		all_programs.add(program);
	}
	
	public void addPrograms(Program... programs){
		for(Program program : programs) addProgram(program);
	}
	
	/** @author Ferdinand Calo' (FEX___96) */
	public static interface Program {
		
		public default String getId(){ return "idless"; }

		public default void preRender(ModelGroup list, ModelRenderData data){}
		
		public default void postRender(ModelGroup list, ModelRenderData data){}

		/** For creating instances from JTMT/OBJ/FMF if necessary. */
		public default Program parse(JsonElement elm){ return this; }
		
		/** For creating instances from JTMT/OBJ/FMF if necessary. */
		public default Program parse(String[] args){ return this; }
		
		public default <T extends Program> T register(){
			ModelGroup.PROGRAMS.add(this);
			return (T)this;
		}

		/** Called when a turbolist is added into the model, preload program data here if neccessary. */
		public default void init(ModelGroup list){}
		
		public default boolean isPreRender(){ return true; }
		
		public default boolean isPostRender(){ return true; }
		
	}
	
	public static class ConditionalProgram implements Program {
		
		protected ArrayList<Program> programs = new ArrayList<>(), opposite = new ArrayList<>();
		protected boolean passed;

		public boolean test(ModelGroup list, ModelRenderData data){
			return true;
		}
		
		@Override
		public void preRender(ModelGroup list, ModelRenderData data){
			if(passed = test(list, data)){
				for(Program prog : programs) prog.preRender(list, data);
			}
			else{
				for(Program prog : opposite) prog.preRender(list, data);
			}
		}
		
		@Override
		public void postRender(ModelGroup list, ModelRenderData data){
			if(passed){
				for(Program prog : programs) prog.postRender(list, data);
			}
			else{
				for(Program prog : opposite) prog.postRender(list, data);
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
		
		protected BiPredicate<ModelGroup, ModelRenderData> predicate;
		
		public FunctionalProgram(BiPredicate<ModelGroup, ModelRenderData> pred){
			predicate = pred;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return predicate.test(list, data);
		}
		
	}
	
	public static class ProgramMap extends TreeMap<String, Program> {
		
		public void add(Program prog){
			put(prog.getId(), prog);
		}
		
	}

	public void initPrograms(){
		for(Program prog : all_programs) prog.init(this);
		has_pre_prog = pre_programs.size() > 0;
		has_pst_prog = pst_programs.size() > 0;
		hasinit = true;
	}
	
}