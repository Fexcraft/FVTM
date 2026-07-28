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
public class ModelGroup extends ArrayList<Polyhedron> {

	public static final ProgramRegistry PROGRAMS = new ProgramRegistry();
	public static final ModelGroup EMPTY = new ModelGroup("empty");
	public static final HashMap<String, ConditionalProgram> COND_PROGRAMS = new HashMap<>();
	
	private ArrayList<Program> all_programs = new ArrayList<>();
	protected ArrayList<Program> pre_programs = new ArrayList<>();
	protected ArrayList<Program> pst_programs = new ArrayList<>();

	public V3D offset = new V3D();
	public V3D rotation = new V3D();
	public V3D scale = new V3D(1, 1, 1);

	public final String name;
	public boolean visible = true;
	public boolean has_pre_prog = false;
	public boolean has_pst_prog = false;
	private boolean initialized;

	public ModelGroup(String name){
		super();
		this.name = name;
	}

	@Deprecated
	public void render(ModelRenderData data){
		if(offset != null) RENDERER.translate(offset.x, offset.y, offset.z);
		if(has_pre_prog) for(Program program : pre_programs) program.pre(this, data);
		if(visible) for(Polyhedron poly : this) poly.render();
		if(has_pst_prog) for(Program program : pst_programs) program.post(this, data);
		if(offset != null) RENDERER.translate(-offset.x, -offset.y, -offset.z);
	}

	public void pre(ModelRenderData data){
		RENDERER.push();
		if(has_pre_prog) for(Program program : pre_programs) program.pre(this, data);
		if(offset != null) RENDERER.translate(offset.x, offset.y, offset.z);
		if(rotation.notNull()){
			RENDERER.rotate(rotation.y, 0, 1, 0);
			RENDERER.rotate(rotation.x, 1, 0, 0);
			RENDERER.rotate(rotation.z, 0, 0, 1);
		}
		if(scale.notOne()){
			RENDERER.scale(scale.x, scale.y, scale.z);
		}
	}

	public void post(ModelRenderData data){
		if(has_pst_prog) for(Program program : pst_programs) program.post(this, data);
		rotation.set(0, 0, 0);
		scale.set(1, 1, 1);
		//if(offset != null) RENDERER.translate(-offset.x, -offset.y, -offset.z);
		RENDERER.pop();
	}

	public void render(){
		for(Polyhedron poly : this) poly.render();
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

	public void translate(double x, double y, double z){
		if(offset == null) offset = new V3D();
		offset.x += x;
		offset.y += y;
		offset.z += z;
	}

	public void translate(double x, double y, double z, boolean set){
		if(offset == null) offset = new V3D();
		if(set) offset.set(x, y, z);
		else{
			offset.x += x;
			offset.y += y;
			offset.z += z;
		}
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

	public void scale(double x, double y, double z){
		scale(x, y, z, false);
	}

	public void scale(double x, double y, double z, boolean set){
		if(set) scale.set(x, y, z);
		else{
			scale.x *= x;
			scale.y *= y;
			scale.z *= z;
		}
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

	public void rotateGroup(double x, double y, double z){
		rotation.x += x;
		rotation.y += y;
		rotation.z += z;
	}

	public void rotateGroup(double x, double y, double z, boolean set){
		if(set) rotation.set(x, y, z);
		else{
			rotation.x += x;
			rotation.y += y;
			rotation.z += z;
		}
	}

	public void rotateGroup(double value, int axis, boolean set){
		if(axis == 0){
			if(set) rotation.x = value;
			else rotation.x += value;
		}
		else if(axis == 1){
			if(set) rotation.y = value;
			else rotation.y += value;
		}
		else{
			if(set) rotation.z = value;
			else rotation.z += value;
		}
	}

	public boolean add(ModelRendererTurbo mrt){
		return add(new Polyhedron().importMRT(mrt, false, 0.0625f));
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
