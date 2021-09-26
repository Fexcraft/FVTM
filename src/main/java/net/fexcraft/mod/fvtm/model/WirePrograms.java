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
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.minecraft.tileentity.TileEntity;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		TurboList.PROGRAMS.add(new RotateY(0));
		TurboList.PROGRAMS.add(ROTATED);
		TurboList.PROGRAMS.add(new DownwardAngled(0, false));
		TurboList.PROGRAMS.add(new SpacedDeco());
		TurboList.PROGRAMS.add(new CatenaryDropper());
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
	
	public static Program ROTATED = new Program(){

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
		
		protected boolean symmetric, centered;
		protected float center_spacing = 0.5f;
		protected float ending_spacing = 0.5f;
		protected float between_spacing = 1f;
		protected int limit = 0;
		
		public SpacedDeco(String... args){
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
					case "start_spacing":
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
				}
			}
		}

		public String getId(){
			return "fvtm:wire_spaced_deco";
		}
		
		public Program parse(String[] args){
			return new SpacedDeco(args);
		}

		public ArrayList<Vec3f> generate(WireRelay relay, Wire wire, TurboList group){
			ArrayList<Vec3f> list = new ArrayList<>();
			if(symmetric){
				int limit = this.limit * 2;
				float half = wire.length / 2f;
				if(centered){
					float pass = half - center_spacing;
					while(pass > ending_spacing && (limit > 0 ? list.size() < limit : true)){
						list.add(wire.getVectorPosition0(pass, false));
						list.add(wire.getVectorPosition0(pass, true));
						pass -= between_spacing;
					}
				}
				else{
					float pass = ending_spacing;
					while(pass < half - center_spacing && (limit > 0 ? list.size() < limit : true)){
						list.add(wire.getVectorPosition0(pass, false));
						list.add(wire.getVectorPosition0(pass, true));
						pass += between_spacing;
					}
				}
			}
			else{
				float pass = center_spacing;
				while(pass < wire.length - ending_spacing && (limit > 0 ? list.size() < limit : true)){
					list.add(wire.getVectorPosition0(pass, false));
					pass += between_spacing;
				}
			}
			return list;
		}
		
	}
	
	public static class CatenaryDropper extends SpacedDeco {
		
		public Vec3f[][] model = new Vec3f[8][];
		public float sx, sz, sl;

		public CatenaryDropper(String... args){
			super(args);
			for(String arg : args){
				String[] split = arg.split(":");
				switch(split[0]){
					case "width":{
						sx = Float.parseFloat(split[1]);
						break;
					}
					case "depth":{
						sz = Float.parseFloat(split[1]);
						break;
					}
					case "scale":{
						sl = Float.parseFloat(split[1]);
						break;
					}
				}
			}
			float hx = sx / 2, hz = sz / 2;
			model[0] = new Vec3f[]{ new Vec3f(-hx, 0, -hz).scale(sl), new Vec3f(hx, -hz, 0).scale(sl) };
			model[1] = new Vec3f[]{ new Vec3f(-hx, 0, hz).scale(sl), new Vec3f(-hx, -hz, 0).scale(sl) };
			model[2] = new Vec3f[]{ new Vec3f(hx, 0, -hz).scale(sl), new Vec3f(hx, 0, hz).scale(sl) };
			model[3] = new Vec3f[]{ new Vec3f(-hx, 0, hz).scale(sl), new Vec3f(hx, 0, hz).scale(sl) };
			model[4] = new Vec3f[]{ new Vec3f(-hx, 0, -hz).scale(sl), new Vec3f(hx, -hz, 0).scale(sl) };
			model[5] = new Vec3f[]{ new Vec3f(-hx, 0, hz).scale(sl), new Vec3f(-hx, -hz, 0).scale(sl) };
			model[6] = new Vec3f[]{ new Vec3f(hx, 0, -hz).scale(sl), new Vec3f(hx, 0, hz).scale(sl) };
			model[7] = new Vec3f[]{ new Vec3f(-hx, 0, hz).scale(sl), new Vec3f(hx, 0, hz).scale(sl) };
		}

		public String getId(){
			return "fvtm:wire_catenary_dropper";
		}

		public ArrayList<Vec3f> generate(WireRelay relay, Wire wire, TurboList group){
			//Wire other = relay.getHolder().getRelay("contact");
			
			
			
			return super.generate(relay, wire, group);
		}
		
	}
	
}