package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.lib.common.Static.sixteenth;

import java.util.ArrayList;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonElement;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.render.WireRenderer;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		TurboList.PROGRAMS.add(new RotateY(0));
		TurboList.PROGRAMS.add(new Rotated());
		TurboList.PROGRAMS.add(new DownwardAngled(0, false));
		TurboList.PROGRAMS.add(new SpacedDeco());
	}
	
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
	
	public static class Rotated implements Program {
		
		public Rotated(){}

		public String getId(){
			return "fvtm:wire_rotated";
		}
		
		public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			GL11.glRotatef(WireRenderer.ANGLE, 0, 1, 0);
		}
		
	};
	
	public static class DownwardAngled implements Program {
		
		private float length;
		private boolean diswire;
		
		public DownwardAngled(float length, boolean disable){
			this.length = length;
			diswire = disable;
		}
		
		public DownwardAngled(float length){
			this(length, false);
		}
		
		public DownwardAngled(){
			this(sixteenth);
		}

		public String getId(){
			return "fvtm:wire_downward_angled";
		}
		
		public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
			GL11.glRotatef(WireRenderer.ANGLE_DOWN, 1, 0, 0);
		}

		public Program parse(JsonElement elm){
			return new DownwardAngled(elm.getAsJsonArray().get(0).getAsFloat(), elm.getAsJsonArray().get(1).getAsBoolean());
		}
		
		public Program parse(String[] args){
			return new DownwardAngled(args.length > 0 ? Float.parseFloat(args[0]) : sixteenth, args.length > 1 ? Boolean.parseBoolean(args[1]) : false);
		}

		public float length(){
			return length;
		}
		
		public boolean disable_wire(){
			return diswire;
		}
		
	};
	
	public static class SpacedDeco implements Program {
		
		private boolean symmetric, centered, symlit;
		private float center_spacing;
		private float ending_spacing;
		private float between_spacing;
		private int limit;
		
		public SpacedDeco(){}

		public String getId(){
			return "fvtm:wire_spaced_deco";
		}
		
		public Program parse(String[] args){
			for(String arg : args){
				String[] split = arg.split(":");
				switch(split[0]){
					case "symmetric":{
						symmetric = Boolean.parseBoolean(split[1]);
						break;
					}
					case "centered":{
						centered = Boolean.parseBoolean(split[1]);
						break;
					}
					case "center_spacing":{
						center_spacing = Float.parseFloat(split[1]);
						break;
					}
					case "ending_spacing":{
						ending_spacing = Float.parseFloat(split[1]);
						break;
					}
					case "between_spacing":{
						between_spacing = Float.parseFloat(split[1]);
						break;
					}
					case "limit":{
						limit = Integer.parseInt(split[1]);
						break;
					}
					case "symmetric_limit":{
						symlit = Boolean.parseBoolean(split[1]);
						break;
					}
				}
			}
			return this;
		}

		public ArrayList<Vec3f> generate(Wire wire, TurboList group){
			ArrayList<Vec3f> list = new ArrayList<>();
			list.add(wire.getVectorPosition0(1, false));
			list.add(wire.getVectorPosition0(1, true));
			return list;
		}
		
	}
	
}