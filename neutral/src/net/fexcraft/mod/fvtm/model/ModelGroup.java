package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.Program.ConditionalProgram;

import static net.fexcraft.lib.frl.Renderer.RENDERER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ModelGroup extends ArrayList<Polyhedron<GLObject>> {

	public static final ProgramRegistry PROGRAMS = new ProgramRegistry();
	public static final ModelGroup EMPTY = new ModelGroup("empty");
	public static final HashMap<String, ConditionalProgram> COND_PROGRAMS = new HashMap<>();
	
	private ArrayList<Program> all_programs = new ArrayList<>();
	protected ArrayList<Program> pre_programs = new ArrayList<>();
	protected ArrayList<Program> pst_programs = new ArrayList<>();

	public V3D offset;

	public final String name;
	public float scale = Static.sixteenth;
	public boolean visible = true;
	public boolean has_pre_prog = false;
	public boolean has_pst_prog = false;
	private boolean initialized;

	public ModelGroup(String name){
		super();
		this.name = name;
	}

	public void render(ModelRenderData data){
		if(offset != null) RENDERER.translate(offset.x, offset.y, offset.z);
		if(has_pre_prog) for(Program program : pre_programs) program.pre(this, data);
		if(visible) for(Polyhedron poly : this) poly.render();
		if(has_pst_prog) for(Program program : pst_programs) program.post(this, data);
		if(offset != null) RENDERER.translate(-offset.x, -offset.y, -offset.z);
	}

	public void render(){
		if(visible) for(Polyhedron poly : this) poly.render();
	}

	public void addProgram(String str){
		addProgram(PROGRAMS.get(str));
	}

	public void addPrograms(String... strs){
		for(String str : strs) addProgram(str);
	}

	public void addProgram(Program program){
		if(program == null || initialized) return;
		if(program.pre()) pre_programs.add(program);
		if(program.post()) pst_programs.add(program);
		all_programs.add(program);
	}

	public void addPrograms(Program... programs){
		for(Program program : programs) addProgram(program);
	}

	public void initPrograms(){
		for(Program prog : getAllPrograms()) prog.init(this);
		has_pre_prog = pre_programs.size() > 0;
		has_pst_prog = pst_programs.size() > 0;
		initialized = true;
	}

	public ArrayList<Program> getAllPrograms() {
		return all_programs;
	}

	public ArrayList<Program> getPrePrograms() {
		return pre_programs;
	}

	public ArrayList<Program> getPstPrograms() {
		return pst_programs;
	}
	
	//

	public void translate(float x, float y, float z, boolean set){
		if(offset == null) offset = new V3D();
		offset.set(x, y, z);
		/*if(set){
			for(Polyhedron poly : this) poly.pos(x, y, z);
		}
		else{
			for(Polyhedron poly : this){
				poly.posX += x;
				poly.posY += y;
				poly.posZ += z;
			}
		}*/
	}

	public void scale(float flt){
		scale = flt;
	}

	public void rotate(float x, float y, float z){
		rotate(x, y, z, false);
	}

	public void rotate(float x, float y, float z, boolean set){
		if(set){
			for(Polyhedron poly : this) poly.rot(x, y, z);
		}
		else {
			for(Polyhedron poly : this){
				poly.rotX += x;
				poly.rotY += y;
				poly.rotZ += z;
			}
		}
	}

	public void rotate(float value, int axis, boolean set){
		if(axis == 0){
			if(set){
				for(Polyhedron poly : this) poly.rotX = value;
			}
			else{
				for(Polyhedron poly : this) poly.rotX += value;
			}
		}
		else if(axis == 1){
			if(set){
				for(Polyhedron poly : this) poly.rotY = value;
			}
			else{
				for(Polyhedron poly : this) poly.rotY += value;
			}
		}
		else{
			if(set){
				for(Polyhedron poly : this) poly.rotZ = value;
			}
			else{
				for(Polyhedron poly : this) poly.rotZ += value;
			}
		}
	}

	@Override
	public boolean add(Polyhedron<GLObject> poly){
		if(poly.glObj == null) poly.glObj = new GLObject();
		return super.add(poly);
	}

	public boolean add(ModelRendererTurbo mrt){
		return add(new Polyhedron<GLObject>().importMRT(mrt, false, 0.0625f));
	}

    public <P extends Program> P getProgram(String key){
		for(Program prog : all_programs){
			if(prog.id().equals(key)) return (P)prog;
		}
		return null;
    }

	public ModelGroup copyWithoutPrograms(){
		ModelGroup group = new ModelGroup(name);
		group.addAll(this);
		group.scale = scale;
		return group;
	}

}
