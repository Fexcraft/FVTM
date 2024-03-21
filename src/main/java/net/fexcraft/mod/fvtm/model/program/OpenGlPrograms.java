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
		ModelGroup.PROGRAMS.add(new Program(){
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
	}

}
