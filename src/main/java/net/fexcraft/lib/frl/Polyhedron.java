package net.fexcraft.lib.frl;

import static net.fexcraft.lib.frl.Renderer.RENDERER;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Polyhedron<GLO> {
	
	public ArrayList<Polygon> polygons = new ArrayList<>();
	public ArrayList<Polyhedron<GLO>> sub;
	public float rotX, rotY, rotZ;
	public float posX, posY, posZ;
	public float texU, texV;
	public boolean recompile, visible = true;
	public RotationOrder rotOrder = RotationOrder.YZX;
	public String name;
	public GLO glObj;
	public Integer glId;
	
	public Polyhedron(){}
	
	public Polyhedron(String name){
		this.name = name;
	}
	
	public Polyhedron<GLO> rescale(float scale){
		for(Polygon gon : polygons) gon.rescale(scale);
		posX *= scale;
		posY *= scale;
		posZ *= scale;
		return this;
	}
	
	public Polyhedron<GLO> color(RGB color){
		for(Polygon gon : polygons) gon.color(color);
		return this;
	}

	public void render(){
		RENDERER.render(this);
	}
	
	public Polyhedron<GLO> importMRT(ModelRendererTurbo turbo, boolean insoff, float scale){
		this.name = turbo.boxName;
		for(TexturedPolygon tp : turbo.getFaces()){
			Vertex[] verts = new Vertex[tp.getVertices().length];
			for(int i = 0; i < verts.length; i++){
				verts[i] = new ColoredVertex(new Vec3f(tp.getVertices()[i].vector.scale(scale)), tp.getVertices()[i].textureX, tp.getVertices()[i].textureY);
				if(insoff){
					verts[i].vector = verts[i].vector.add(turbo.rotationPointX * scale, turbo.rotationPointY * scale, turbo.rotationPointZ * scale);
				}
		        Vec3f vec0 = new Vec3f(tp.getVertices()[1].vector.sub(tp.getVertices()[0].vector));
		        Vec3f vec1 = new Vec3f(tp.getVertices()[1].vector.sub(tp.getVertices()[2].vector));
		        Vec3f vec2 = vec1.cross(vec0).normalize();
				verts[i].norm(vec2);
				//verts[i].color(1, i == 2 || i == 3 ? 1 : 0, 0);
			}
			polygons.add(new Polygon(verts));//.colored(true));
		}
		if(!insoff){
			posX = turbo.rotationPointX;// * scale;
			posY = turbo.rotationPointY;// * scale;
			posZ = turbo.rotationPointZ;// * scale;
		}
		rotX = turbo.rotationAngleX;
		rotY = turbo.rotationAngleY;
		rotZ = turbo.rotationAngleZ;
		texU = turbo.texoffx;
		texV = turbo.texoffy;
		return this;
	}
	
	public void clear(){
		polygons.clear();
		RENDERER.delete(this);
	}
	
	public Polyhedron<GLO> setGlObj(GLO newobj){
		this.glObj = newobj;
		return this;
	}

	public void pos(float x, float y, float z){
		posX = x;
		posY = y;
		posZ = z;
	}

	public void rot(float x, float y, float z){
		rotX = x;
		rotY = y;
		rotZ = z;
	}

}
