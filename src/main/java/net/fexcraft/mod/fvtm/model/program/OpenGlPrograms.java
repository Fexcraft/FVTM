package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.fexcraft.mod.fvtm.model.ProgramUtils.FLOAT_BOOL_SUPP;
import static net.fexcraft.mod.fvtm.model.ProgramUtils.FloatBool;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class OpenGlPrograms {

	public static void init(){
		ModelGroup.PROGRAMS.add(new Program() {
			public String id(){
				return "fvtm:no_cullface";
			}
			public void pre(ModelGroup list, ModelRenderData data){
				GL11.glDisable(GL11.GL_CULL_FACE);
			}
			public void post(ModelGroup list, ModelRenderData data){
				GL11.glEnable(GL11.GL_CULL_FACE);
			}
		});
		ModelGroup.PROGRAMS.add(new AlphaFunc());
	}

	public static class AlphaFunc implements Program {

		private int func;
		private float ref;

		public AlphaFunc(){}

		public AlphaFunc(int func, float ref){
			this.func = func;
			this.ref = ref;
		}

		@Override
		public String id(){
			return "opengl:alpha_func";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glAlphaFunc(func, ref);
		}

		@Override
		public void post(ModelGroup list, ModelRenderData data){
			//
		}

		@Override
		public Program parse(String[] args){
			return new AlphaFunc(Integer.parseInt(args[0]), Float.parseFloat(args[1]));
		}

	}

}
