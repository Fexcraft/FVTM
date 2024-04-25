package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	public static abstract class AttrAnimation extends DefaultPrograms12.AttributeBased implements AnimationRoot {

		protected HashMap<V3I, Program> progs = new HashMap<>();
		protected ArrayList<Program> active = new ArrayList<>();
		protected FloatBool passed;
		protected int time;

		public AttrAnimation(String attr, int tt){
			super(attr);
			time = tt;
		}

		@Override
		public void addProgram(int offset, int dur, Program prog){
			if(prog == null) return;
			if(dur <= 0) dur = time;
			progs.put(new V3I(offset, dur, prog.ticktime()), prog);
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			if(data.cache == null) return;
			if((attr = data.vehicle.getAttribute(attribute)) == null) return;
			active.clear();
			collectActive(list, data);
			for(Program program : active){
				program.pre(list, data);
			}
		}

		public void collectActive(ModelGroup group, ModelRenderData data){}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			if(data.cache == null || attr == null) return;
			for(Program program : active){
				program.post(list, data);
			}
		}

	}


	public static class AttrBoolAnimation extends AttrAnimation {

		public AttrBoolAnimation(String attr, int tt){
			super(attr, tt);
		}

		@Override
		public String id(){
			return "fvtm:attribute_bool_animation";
		}

		@Override
		public void collectActive(ModelGroup group, ModelRenderData data){
			passed = data.cache.get(this, FLOAT_BOOL_SUPP);
			if(attr.asBoolean() != passed.bl){
				passed.bl = attr.asBoolean();
				for(Program prog : progs.values()) prog.reverse(data, passed.bl);
			}
			if(passed.bl){
				if(passed.fl > 0){
					passed.fl -= data.partialticks;
					if(passed.fl < 0) passed.fl = 0;
				}
			}
			else{
				if(passed.fl < time){
					passed.fl += data.partialticks;
					if(passed.fl > time) passed.fl = time;
				}
			}
			for(Map.Entry<V3I, Program> entry : progs.entrySet()){
				if(passed.fl < entry.getKey().x || passed.fl > entry.getKey().y) continue;
				active.add(entry.getValue().pause(data, passed.fl > entry.getKey().x + entry.getKey().z));
			}
		}

		@Override
		public Program parse(String[] args){
			return new AttrBoolAnimation(args[0], Integer.parseInt(args[1]));
		}

	}

}
