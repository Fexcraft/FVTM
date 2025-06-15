package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;

import java.util.ArrayList;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fvtm.render.UniWireRenderer.ANGLE;
import static net.fexcraft.mod.fvtm.render.UniWireRenderer.ANGLE_DOWN;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class WirePrograms {
	
	public static void init(){
		ModelGroup.PROGRAMS.add(new RotateY(0));
		ModelGroup.PROGRAMS.add(ROTATED);
		ModelGroup.PROGRAMS.add(new DownwardAngled(0));
		ModelGroup.PROGRAMS.add(new SpacedDeco(new JsonMap()));
		ModelGroup.PROGRAMS.add(new WireBreak(0, 0));
		//ModelGroup.PROGRAMS.add(new CatenaryDropper(new JsonMap()));
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
			RENDERER.rotate(deg, 0, 1, 0);
		}

		@Override
		public boolean post(){
			return false;
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
			RENDERER.rotate(ANGLE, 0, 1, 0);
		}

		@Override
		public boolean post(){
			return false;
		}
		
	};
	
	public static class DownwardAngled implements Program {
		
		private float length;
		
		public DownwardAngled(float length){
			this.length = length;
		}

		@Override
		public String id(){
			return "fvtm:wire_downward_angled";
		}
		
		@Override
		public void pre(ModelGroup list, ModelRenderData data){
			RENDERER.rotate(ANGLE_DOWN, 0, 0, 1);
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return new DownwardAngled(args.length > 0 ? Float.parseFloat(args[0]) : sixteenth/*, args.length > 1 ? Boolean.parseBoolean(args[1]) : false*/);
		}

		public float length(){
			return length;
		}
		
	}

	public static class WireBreak implements Program {

		public final float after, _for;

		public WireBreak(float af, float fr){
			after = af;
			_for = fr;
		}

		@Override
		public String id(){
			return "fvtm:wire_break";
		}

		@Override
		public boolean pre(){
			return false;
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(String[] args){
			return new WireBreak(args.length > 0 ? Float.parseFloat(args[0]) : 0.5f, args.length > 1 ? Float.parseFloat(args[1]) : 1f);
		}

		public float minlength(){
			return after * 2 + _for * 2;
		}
	}
	
	public static class SpacedDeco implements Program {
		
		protected boolean symmetric;
		protected boolean centered;
		protected float center_spacing = 0.5f;
		protected float ending_spacing = 0.5f;
		protected float between_spacing = 1f;
		protected int limit = 0;
		
		public SpacedDeco(JsonMap map){
			symmetric = map.getBoolean("symmetric", false);
			centered = map.getBoolean("centered", false);
			center_spacing = map.getFloat("center_spacing", 0.5f);
			ending_spacing = map.getFloat("ending_spacing", 0.5f);
			between_spacing = map.getFloat("between_spacing", 1f);
			limit = map.getInteger("limit", 0);
		}

		@Override
		public String id(){
			return "fvtm:wire_spaced_deco";
		}

		@Override
		public boolean pre(){
			return false;
		}

		@Override
		public boolean post(){
			return false;
		}

		@Override
		public Program parse(JsonMap map){
			return new SpacedDeco(map);
		}

		@Override
		public Program parse(String[] args){
			return new SpacedDeco(new JsonMap());
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
	
	/*public static class CatenaryDropper extends SpacedDeco {
		
		public Vec3f[][] model = new Vec3f[4][];
		public float sx;
		public float sz;
		public float sl;

		public CatenaryDropper(JsonMap map){
			super(map);
			sx = map.getFloat("width", 0.5f);
			sz = map.getFloat("depth", 0.5f);
			sl = map.getFloat("scale", sixteenth);
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
		public Program parse(JsonMap map){
			return new CatenaryDropper(map);
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
				ArrayList<Polyhedron> tlist = new ArrayList<>();
				float rat = owir.length / wire.length;
				float last = -1;
				int idx = 0;
				for(Float dis : dislis){
					V3D vec = owir.getVectorPosition(dis * rat, last == dis);
					V3D vecl = veclis.get(idx);
					double hei = vec.y - vecl.y;
					tlist.add(new Polyhedron().importMRT(new ModelRendererTurbo(null, 0, 0, 16, 16)
						.addBox(-sx/2, 0, -sz/2, sx, (float)hei * 16, sz)
						.setRotationPoint(0, (float)-hei * 16, 0), false, sixteenth));
					last = dis;
					idx++;
				}
				wire.model.deco_g.get(decoid).put(group.name, tlist);
			}
			return veclis;
		}
		
	}*/
	
}