package net.fexcraft.mod.fvtm.model;

import com.google.common.collect.ImmutableList;
import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.model.ModelGroupList.DefaultModelGroupList;
import net.fexcraft.mod.fvtm.model.Program.ConditionalProgram;
import net.fexcraft.mod.fvtm.model.program.AnimationPrograms.AnimationRoot;
import net.fexcraft.mod.fvtm.model.program.ConditionalPrograms.ConditionBased;
import org.lwjgl.opengl.GL11;

import java.util.*;

import static net.fexcraft.mod.fvtm.model.ModelGroup.COND_PROGRAMS;
import static net.fexcraft.mod.fvtm.model.ModelGroupList.SEPARATE_GROUP_LIST;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DefaultModel implements Model {

	public static DefaultModel LAST;
	public static final DefaultModel EMPTY = new DefaultModel();
	public static final ModelRenderData RENDERDATA = new ModelRenderData();
	public TreeMap<RenderOrder, ModelGroupList> sorted = new TreeMap<>();
	public ModelGroupList groups = new DefaultModelGroupList();
	private List<String> authors = new ArrayList<>();
	public Transforms transforms = new Transforms();
	public boolean smooth_shading;
	public int textureX, textureY;
	public int tex_width;
	public int tex_height;
	public boolean locked;
	public String name;

	@Override
	public void render(ModelRenderData data){
		LAST = this;
		transforms.apply();
		if(FvtmRegistry.is112) GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(ModelGroupList list : sorted.values()) list.render(data);
		transforms.deapply();
	}

	@Override
	public Collection<String> getCreators(){
		return authors;
	}

	@Override
	public boolean addToCreators(String str){
		if(locked) return false;
		return authors.add(str);
	}

	@Override
	public void setGroups(ModelGroupList list){
		groups = list;
	}

	@Override
	public ModelGroupList getGroups(){
		return groups;
	}

	@Override
	public Model parse(ModelData data){
		smooth_shading = data.getBoolean(SMOOTHSHADING, false);
		if(data.has(PROGRAMS)){
			JsonArray programs = data.getArray(PROGRAMS);
			for(JsonValue<?> val : programs.value){
				if(val.isArray()){
					JsonArray prarr = val.asArray();
					if(prarr.size() > 1 && prarr.get(1).isArray()){//conditional
						String[] split = prarr.get(0).string_value().trim().split(" ");
						try{
							ConditionalProgram prog = null;
							if(COND_PROGRAMS.containsKey(split[1])){
								prog = COND_PROGRAMS.get(split[1]).getConstructor().newInstance();
							}
							else prog = new ConditionBased(split[1]);
							if(split.length > 2){
								prog = (ConditionalProgram)prog.parse(Arrays.copyOfRange(split, 2, split.length));
							}
							for(JsonValue<?> elm : prarr.get(1).asArray().value){
								prog.addIf(parseProgram(elm.string_value().trim().split(" "), 0));
							}
							if(prarr.size() > 2){
								for(JsonValue<?> elm : prarr.get(2).asArray().value){
									prog.addElse(parseProgram(elm.string_value().trim().split(" "), 0));
								}
							}
							groups.get(split[0]).addProgram(prog);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else{//animation
						String[] split = prarr.get(0).string_value().trim().split(" ");
						try{
							AnimationRoot root = (AnimationRoot)parseProgram(split);
							for(int i = 1; i < prarr.size(); i++){
								String[] splt = prarr.get(i).string_value().trim().split(" ");
								String[] od = splt[0].split("-");
								int off = Integer.parseInt(od[0]);
								int dur = od.length > 1 ? Integer.parseInt(od[1]) : 0;
								root.addProgram(off, dur, parseProgram(splt));
							}
							groups.get(split[0]).addProgram((Program)root);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					continue;
				}
				String[] split = val.string_value().trim().split(" ");
				if(!groups.contains(split[0])) continue;
				try{
					groups.get(split[0]).addProgram(parseProgram(split));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.has(CONDPROGRAMS)){
			JsonArray programs = data.getArray(CONDPROGRAMS);
			for(JsonValue<?> val : programs.value){
				if(val.isMap()){
					JsonMap json = val.asMap();
					if(!json.has("id") || !json.has("group")) continue;
					try{
						String group = json.get("group").string_value();
						String progid = json.get("id").string_value();
						ConditionalProgram prog = null;
						if(COND_PROGRAMS.containsKey(progid)){
							prog = COND_PROGRAMS.get(progid).getConstructor().newInstance();
						}
						else prog = new ConditionBased(progid);
						if(json.has("ifmet")){
							JsonArray array = json.get("ifmet").asArray();
							for(JsonValue<?> elm : array.value){
								prog.addIf(parseProgram(elm.string_value().trim().split(" "), 0));
							}
						}
						if(json.has("else")){
							JsonArray array = json.get("else").asArray();
							for(JsonValue<?> elm : array.value){
								prog.addElse(parseProgram(elm.string_value().trim().split(" "), 0));
							}
						}
						if(json.has("args")){
							prog = (ConditionalProgram)prog.parse(json.get("args").string_value().trim().split(" "));
						}
						groups.get(group).addProgram(prog);
					}
					catch(Exception e){
						e.printStackTrace();
					}
					continue;
				}
				String string = val.toString();
				String[] args = string.trim().split("||");
				if(!groups.contains(args[0])) continue;
				try{
					ConditionalProgram prog = null;
					if(COND_PROGRAMS.containsKey(args[1])){
						prog = COND_PROGRAMS.get(args[1]).getConstructor().newInstance();
					}
					else prog = new ConditionBased(args[1]);
					String[] sub = args[2].split("|");
					for(String s : sub){
						prog.addIf(parseProgram(s.trim().split(" ")));
					}
					if(args.length > 3){
						sub = args[3].split("|");
						for(String s : sub){
							prog.addElse(parseProgram(s.trim().split(" ")));
						}
					}
					if(args.length > 4){
						prog = (ConditionBased)prog.parse(args[4].trim().split(" "));
					}
					groups.get(args[0]).addProgram(prog);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.has(TRANSFORMS)){
			for(JsonValue<?> val : data.getArray(TRANSFORMS).value){
				transforms.parse(val.string_value().trim().split(" "));
			}
		}
		if(data.has(PIVOTS)){
			for(JsonValue<?> val : data.getArray(PIVOTS).value){
				String[] args = val.string_value().trim().split(" ");
				if(!groups.contains(args[0])) continue;
				try{
					ModelGroup group = groups.get(args[0]);
					Vec3f vector = new Vec3f(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
					Vec3f rotation = new Vec3f(
							args.length > 4 ? Float.parseFloat(args[4]) : 0,
							args.length > 5 ? Float.parseFloat(args[5]) : 0,
							args.length > 6 ? Float.parseFloat(args[6]) : 0
					);
					for(Polyhedron<?> poly : group){
						for(Polygon poli : poly.polygons){
							for(Vertex vert : poli.vertices){
								vert.vector = vert.vector.sub(vector);
							}
						}
						poly.pos(vector.x, vector.y, vector.z);
						poly.rot(rotation.x, rotation.y, rotation.z);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		if(data.has(OFFSET)){
			for(JsonValue<?> val : data.getArray(OFFSET).value){
				String[] args = val.string_value().trim().split(" ");
				if(!groups.contains(args[0])) continue;
				try{
					ModelGroup group = groups.get(args[0]);
					Vec3f vector = new Vec3f(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
					for(Polyhedron<?> poly : group){
						for(Polygon poli : poly.polygons){
							for(Vertex vert : poli.vertices){
								vert.vector = vert.vector.sub(vector);
							}
						}
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return this;
	}

	@Override
	public void lock(){
		if(locked) return;
		authors = ImmutableList.copyOf(authors);
		for(ModelGroup group : groups) group.initPrograms();
		sort();
		locked = true;
	}

	@Override
	public void sort(){
		sorted.clear();
		ArrayList<ModelGroup> nor = new ArrayList<>();
		ArrayList<ModelGroup> bln = new ArrayList<>();
		ArrayList<ModelGroup> las = new ArrayList<>();
		ArrayList<ModelGroup> sep = new ArrayList<>();
		RenderOrder order;
		for(ModelGroup group : groups){
			order = RenderOrder.NORMAL;
			for(Program prog : group.getAllPrograms()){
				if(prog.order().ordinal() > order.ordinal()) order = prog.order();
			}
			switch(order){
				case BLENDED: bln.add(group); break;
				case LAST: las.add(group); break;
				case SEPARATE: sep.add(group); break;
				case NORMAL:
				default: nor.add(group); break;
			}
		}
		if(nor.size() > 0) sorted.put(RenderOrder.NORMAL, new DefaultModelGroupList(nor));
		if(bln.size() > 0) sorted.put(RenderOrder.BLENDED, new DefaultModelGroupList(bln));
		if(las.size() > 0) sorted.put(RenderOrder.LAST, new DefaultModelGroupList(las));
		if(sep.size() > 0){
			ModelGroupList list = SEPARATE_GROUP_LIST.get();
			list.addAll(sep);
			sorted.put(RenderOrder.SEPARATE, list);
		}
	}

	@Override
	public void clearGLData(){//static pipeline
		for(ModelGroup group : groups){
			for(Polyhedron<GLObject> poly : group){
				if(poly.glId == null) continue;
				GL11.glDeleteLists(poly.glId, 1);
			}
		}
	}

	private static Program parseProgram(String[] args) throws Exception {
		return parseProgram(args, 1);
	}

	private static Program parseProgram(String[] args, int atidx) throws Exception {
		if(args[atidx].startsWith("#")) return null;
		Program prog = ModelGroup.PROGRAMS.get(args[atidx]);
		if(prog == null){
			throw new Exception("PROGRAM WITH ID '" + args[atidx] + "' NOT FOUND!");
		}
		return prog.parse(Arrays.copyOfRange(args, atidx + 1, args.length));
	}

	public ModelGroup get(String key){
		return groups.get(key);
	}

	public void translate(float x, float y, float z){
		for(ModelGroup group : groups) group.translate(x, y, z, false);
	}

	public void translate(float x, float y, float z, boolean set){
		for(ModelGroup group : groups) group.translate(x, y, z, set);
	}

}
