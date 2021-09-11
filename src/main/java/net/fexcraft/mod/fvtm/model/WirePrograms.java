package net.fexcraft.mod.fvtm.model;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonElement;

import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		TurboList.PROGRAMS.add(AT_START);
		TurboList.PROGRAMS.add(AT_BOTH);
		TurboList.PROGRAMS.add(AT_END);
		//
		TurboList.PROGRAMS.add(new RotateY(0));
	}

	public static final Program AT_START = new Program(){ public String getId(){ return "fvtm:wire_at_start"; } };
	public static final Program AT_BOTH = new Program(){ public String getId(){ return "fvtm:wire_at_both"; } };
	public static final Program AT_END = new Program(){ public String getId(){ return "fvtm:wire_at_end"; } };
	
	public static class RotateY implements Program {
		
		private float deg;
		
		public RotateY(float angle){
			deg = angle;
		}

		public String getId(){
			return "fvtm:wire_rotate_y";
		}
		
		public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			GL11.glRotatef(deg, 0, 1, 0);
		}

		public Program parse(JsonElement elm){
			return new RotateY(elm.getAsJsonArray().get(0).getAsFloat());
		}
		
		public Program parse(String[] args){
			return args.length > 0 ? new RotateY(Float.parseFloat(args[0])) : this;
		}
		
	};
	
}