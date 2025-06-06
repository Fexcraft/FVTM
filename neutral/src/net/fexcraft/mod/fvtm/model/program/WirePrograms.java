package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.render.WireRenderer;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireKey;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import org.lwjgl.opengl.GL11;//TODO

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		ModelGroup.PROGRAMS.add(new RotateY(0));
		ModelGroup.PROGRAMS.add(ROTATED);
		ModelGroup.PROGRAMS.add(new DownwardAngled(0, false));
		ModelGroup.PROGRAMS.add(new SpacedDeco());
		ModelGroup.PROGRAMS.add(new CatenaryDropper());
	}
	
	public static class RotateY implements Program {
		
		private float deg;
		
		public RotateY(float angle){
			deg = angle;
		}

		@Override
		public String id(){
			return "fvtm:wire_rotate_y";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glRotatef(deg, 0, 1, 0);
		}

		@Override
		public Program parse(String[] args){
			return args.length > 0 ? new RotateY(Float.parseFloat(args[0])) : this;
		}
		
	};
	
	public static Program ROTATED = new Program(){

		@Override
		public String id(){
			return "fvtm:wire_rotated";
		}

		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glRotated(WireRenderer.ANGLE, 0, 1, 0);
		}
		
	};
	
	public static class DownwardAngled implements Program {
		
		private float length;
		private boolean diswire;
		
		public DownwardAngled(float length, boolean disable){
			this.length = length;
			diswire = disable;
		}

		@Override
		public String id(){
			return "fvtm:wire_downward_angled";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			GL11.glRotated(WireRenderer.ANGLE_DOWN, 1, 0, 0);
		}

		@Override
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

		@Override
		public String id(){
			return "fvtm:wire_spaced_deco";
		}

		@Override
		public Program parse(String[] args){
			return new SpacedDeco(args);
		}

		@SuppressWarnings("rawtypes")
		public ArrayList generate(WireRelay relay, Wire wire, ModelGroup group, String decoid, boolean vecs){
			ArrayList list = vecs ? new ArrayList<V3D>() : new ArrayList<Float>();
			if(symmetric){
				int limit = this.limit * 2;
				float half = wire.length / 2f;
				if(centered){
					float pass = half - center_spacing;
					while(pass > ending_spacing && (limit > 0 ? list.size() < limit : true)){
						list.add(vecs ? wire.getVectorPosition(pass, false) : pass);
						list.add(vecs ? wire.getVectorPosition(pass, true) : pass);
						pass -= between_spacing;
					}
				}
				else{
					float pass = ending_spacing;
					while(pass < half - center_spacing && (limit > 0 ? list.size() < limit : true)){
						list.add(vecs ? wire.getVectorPosition(pass, false) : pass);
						list.add(vecs ? wire.getVectorPosition(pass, true) : pass);
						pass += between_spacing;
					}
				}
			}
			else{
				float pass = center_spacing;
				while(pass < wire.length - ending_spacing && (limit > 0 ? list.size() < limit : true)){
					list.add(vecs ? wire.getVectorPosition(pass, false) : pass);
					pass += between_spacing;
				}
			}
			return list;
		}
		
	}
	
	public static class CatenaryDropper extends SpacedDeco {
		
		public Vec3f[][] model = new Vec3f[4][];
		public float sx = 0.5f, sz = 0.5f, sl = Static.sixteenth;

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
		}

		@Override
		public String id(){
			return "fvtm:wire_catenary_dropper";
		}

		@Override
		public Program parse(String[] args){
			return new CatenaryDropper(args);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public ArrayList generate(WireRelay relay, Wire wire, ModelGroup group, String decoid, boolean bool){
			ArrayList<V3D> veclis = super.generate(relay, wire, group, decoid, true);
			if(!relay.getKey().equals("contact")) return veclis;
			WireRelay other = relay.getHolder().relays.get("support");
			if(other == null) return veclis;
			ArrayList<Float> dislis = super.generate(relay, wire, group, decoid, false);
			Wire owir = other.getWire(new WireKey(wire.key.start_pos, "support", wire.key.end_pos, "support"));
			//if(owir.copy) owir = relay.getHolder().getRegion().getSystem().getWire(owir.okey);
			if(owir != null){
				ArrayList<ModelRendererTurbo> tlist = new ArrayList<>();
				float rat = owir.length / wire.length;
				float last = -1;
				int idx = 0;
				for(Float dis : dislis){
					V3D vec = owir.getVectorPosition(dis * rat, last == dis);
					V3D vecl = veclis.get(idx);
					double hei = vec.y - vecl.y;
					tlist.add(new ModelRendererTurbo(null, 0, 0, 16, 16)
						.addBox(-sx/2, 0, -sz/2, sx, (float)hei * 16, sz)
						.setRotationPoint(0, (float)-hei * 16, 0));
					last = dis;
					idx++;
				}
				wire.model.deco_g.get(decoid).put(group.name, tlist);
			}
			return veclis;
		}
		
	}
	
}