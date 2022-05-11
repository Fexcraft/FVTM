package net.fexcraft.lib.tmt;

import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;

public class Shape3D {
	
	public TexturedVertex[] vertices;
	public TexturedPolygon[] faces;
	
	public Shape3D(TexturedVertex[] verts, TexturedPolygon[] poly){
		vertices = verts; faces = poly;
	}
	
}
