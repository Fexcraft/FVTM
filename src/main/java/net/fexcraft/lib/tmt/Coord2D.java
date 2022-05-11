package net.fexcraft.lib.tmt;

/**
 * This class represents a coordinate space and its UV coordinates. This allows for
 * easier flat shape planning.
 * @author GaryCXJk
 *
 */
public class Coord2D {

	public float x, y, u, v;
	
	public Coord2D(float x, float y){
		this.x = x;
		this.y = y;
		u = (float) Math.floor(x);
		v = (float) Math.floor(y);
	}
	

	public Coord2D(float x, float y, int u, int v){
		this.x = x;
		this.y = y;
		this.u = u;
		this.v = v;
	}
	
}
