package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.model.ModelGroup.PROGRAMS;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.BiPredicate;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface Program {

	public String id();

	public default void pre(ModelGroup group, ModelRenderData data){}

	public default void post(ModelGroup group, ModelRenderData data){}

	/** For creating instances from String arguments if necessary. */
	public default Program parse(String[] args){ return this; }

	public default <T extends Program> T register(){
		PROGRAMS.add(this);
		return (T)this;
	}

	/** Called when a polyhedron is added into the model, preload program data here if neccessary. */
	public default void init(ModelGroup list){}

	public default boolean pre(){ return true; }

	public default boolean post(){ return true; }

	public default RenderOrder order(){ return RenderOrder.NORMAL; }

	//public default Program mirror(){ return this; }

	public default int ticktime(){ return 0; }

	public default void reverse(ModelRenderData data, boolean bool){}

	public default Program pause(ModelRenderData data, boolean pause){ return this; }

	public default void reset(ModelRenderData data){
		data.cache.set(this, null);
	}

	//

	public static class BlankProgram implements Program {

		private String id;

		public BlankProgram(String pid){
			id = pid;
		}

		@Override
		public String id(){
			return id;
		}
	}

	public static class ConditionalProgram implements Program {

		protected ArrayList<Program> programs = new ArrayList<>(), opposite = new ArrayList<>();
		protected boolean passed;

		public boolean test(ModelGroup group, ModelRenderData data){
			return true;
		}

		@Override
		public String id(){
			return "conditional";
		}

		@Override
		public void pre(ModelGroup group, ModelRenderData data){
			if(passed = test(group, data)){
				for(Program prog : programs) prog.pre(group, data);
			}
			else{
				for(Program prog : opposite) prog.pre(group, data);
			}
		}

		@Override
		public void post(ModelGroup group, ModelRenderData data){
			if(passed){
				for(Program prog : programs) prog.post(group, data);
			}
			else{
				for(Program prog : opposite) prog.post(group, data);
			}
		}

		//

		public ConditionalProgram addIf(Program... progs){
			for(Program prog : progs){
				if(prog == null) continue;
				programs.add(prog);
			}
			return this;
		}

		public ConditionalProgram addElse(Program... progs){
			for(Program prog : progs){
				if(prog == null) continue;
				opposite.add(prog);
			}
			return this;
		}

		public ConditionalProgram transfer(ConditionalProgram other){
			this.programs.addAll(other.programs);
			this.opposite.addAll(other.opposite);
			other.programs.clear();
			other.opposite.clear();
			return this;
		}

		public ConditionalProgram copy(){
			try{
				return this.getClass().getConstructor().newInstance();
			}
			catch(InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
				e.printStackTrace();
				return null;
			}
		}

	}

	public static class FunctionalProgram extends ConditionalProgram {

		protected BiPredicate<ModelGroup, ModelRenderData> predicate;

		public FunctionalProgram(BiPredicate<ModelGroup, ModelRenderData> pred){
			predicate = pred;
		}

		@Override
		public boolean test(ModelGroup group, ModelRenderData data){
			return predicate.test(group, data);
		}

		@Override
		public String id(){
			return "functional";
		}
	}

}
