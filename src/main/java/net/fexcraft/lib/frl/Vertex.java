package net.fexcraft.lib.frl;

import net.fexcraft.lib.common.math.Vec3f;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Vertex {
	
	public Vec3f COLOR_BLACK = new Vec3f(0, 0, 0);
	public Vec3f COLOR_RED   = new Vec3f(1, 0, 0);
	public Vec3f COLOR_BLUE  = new Vec3f(0, 0, 1);
	public Vec3f COLOR_GREEN = new Vec3f(0, 1, 0);
	public Vec3f COLOR_WHITE = new Vec3f(1, 1, 1);
	
	public Vec3f vector;
	public float u, v;
	public Vec3f norm;
	
	public Vertex(Vec3f vec){
		this.vector = vec;
	}
	
	public Vertex(float[] vec){
		this.vector = new Vec3f(vec[0], vec[1], vec[2]);
	}
	
	public Vertex(float x, float y, float z){
		this.vector = new Vec3f(x, y, z);
	}
	
	public Vertex(Vec3f vec, float u, float v){
		this(vec);
		this.u = u;
		this.v = v;
	}

	public Vertex(Vertex vertex){
		this(vertex.vector.x, vertex.vector.y, vertex.vector.z);
	}

	public Vec3f color(){
		return COLOR_WHITE;
	}
	
	public Vertex color(Vec3f vec){
		return this;
	}

	public Vertex color(float r, float g, float b){
		return this;
	}
	
	public Vertex norm(Vec3f vec){
		this.norm = vec;
		return this;
	}
	
	public Vertex uv(float x, float y){
		this.u = x;
		this.v = y;
		return this;
	}

	public Vertex nauv(float u, float v){
		return new Vertex(this).uv(u, v);
	}

}
