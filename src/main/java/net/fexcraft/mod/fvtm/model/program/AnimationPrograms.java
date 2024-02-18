package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.model.Program.FunctionalProgram;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static net.fexcraft.mod.fvtm.model.ProgramUtils.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AnimationPrograms {

	public static void init(){
		ModelGroup.PROGRAMS.add(new AttrBoolAnimation(null, 0));
	}

	public static interface AnimationRoot {

		public void addProgram(int offset, int dur, Program prog);

	}
	
	public static class AttrBoolAnimation extends DefaultPrograms.AttributeBased implements AnimationRoot {

		private HashMap<int[], Program> tpro = new HashMap<>();
		private HashMap<int[], Program> fpro = new HashMap<>();
		private ArrayList<Program> active = new ArrayList<>();
		private FloatBool passed;
		private int time;

		public AttrBoolAnimation(String attr, int tt){
			super(attr);
			time = tt;
		}

		@Override
		public String id(){
			return "fvtm:attribute_bool_animation";
		}

		@Override
		public void addProgram(int offset, int dur, Program prog){
			if(prog == null) return;
			tpro.put(new int[]{ offset, dur }, prog);
			fpro.put(new int[]{ time - offset, time - dur }, prog.mirror());
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			passed = data.cache.get(this, FLOAT_BOOL_SUPP);
			if(attr.asBoolean() != passed.bl){
				passed.bl = attr.asBoolean();
				passed.fl = 0;
				data.cache.set(this, passed);
				for(Program prog : tpro.values()) prog.reset(data);
				for(Program prog : fpro.values()) prog.reset(data);
			}
			if(passed.fl < time){
				passed.fl += data.partialticks;
				data.cache.set(this, passed);
			}
			active.clear();
			if(passed.bl){
				for(Map.Entry<int[], Program> entry : tpro.entrySet()){
					if(entry.getKey()[0] > passed.fl) continue;
					if(entry.getKey()[1] > 0 && entry.getKey()[1] < passed.fl) continue;
					active.add(entry.getValue());
				}
			}
			else{
				for(Map.Entry<int[], Program> entry : fpro.entrySet()){
					if(entry.getKey()[0] > passed.fl) continue;
					if(entry.getKey()[1] > 0 && entry.getKey()[1] < passed.fl) continue;
					active.add(entry.getValue());
				}
			}
			for(Program program : active){
				program.pre(list, data);
			}
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			for(Program program : active){
				program.post(list, data);
			}
		}


		@Override
		public Program parse(String[] args){
			return new AttrBoolAnimation(args[0], Integer.parseInt(args[1]));
		}

	}
	
}
