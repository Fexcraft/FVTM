package net.fexcraft.lib.common.math;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

/**
 * Based on TMT, also compatible/required by the TMT branch shipped with FCL.
 * Further updates and patches by FEX___96 (Ferdinand Calo')
 * 
 */
public class TexturedPolygon {

	public static boolean TRIANGULATED_QUADS = true;
	private boolean invert = false;//, oppositetriangles;
    private float[] normals;
    private RGB color = null;
    private ArrayList<Vec3f> list;
    private TexturedVertex[] vertices;
	
	public TexturedPolygon(TexturedVertex[] verts){
		this.vertices = verts;
		normals = new float[0];
		list = new ArrayList<Vec3f>();
    }

	public TexturedPolygon(ArrayList<TexturedVertex> verts){
		this(verts.toArray(new TexturedVertex[0]));
	}

	public void setInvert(boolean bool){ invert = bool; }
	
	public void setNormals(float x, float y, float z){ normals = new float[] {x, y, z}; }
	
	public void draw(float scale, RGB lincol, RGB rgb){
		if(lincol != null){
			GL11.glBegin(GL11.GL_LINE_STRIP); lincol.glColorApply();
			//
			/*if(triline && vertices.length == 4){
				TexturedVertex texvex = null;
				//tess.startDrawing(GL11.GL_LINE_STRIP); tess.setColor(lincol);
            	texvex = vertices[0]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
            	texvex = vertices[1]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
            	texvex = vertices[2]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
            	texvex = vertices[0]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
            	texvex = vertices[2]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
            	texvex = vertices[3]; tess.addVertex(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
		        tess.draw(); return;
			}*/
		}
		else{
	        switch(vertices.length){
		        case 3: GL11.glBegin(GL11.GL_TRIANGLES); break;
		        case 4: GL11.glBegin(TRIANGULATED_QUADS ? GL11.GL_TRIANGLES : GL11.GL_QUADS); break;
		        default: GL11.glBegin(GL11.GL_POLYGON); break;
	        };
		}
		boolean gnorm = list.isEmpty() || list.size() != vertices.length;
        if(gnorm) checkGenerated();
        if(TRIANGULATED_QUADS && vertices.length == 4){
            if(rgb == null && color == null){
            	triangleT(scale, 0, 1, 2, gnorm, 0);
            }
            else{
            	(color == null ? rgb : color).glColorApply();
            	triangleC(scale, 0, 1, 2, gnorm, 0);
            }
            if(rgb == null && color == null){
            	triangleT(scale, 0, 2, 3, gnorm, 3);
            }
            else{
            	(color == null ? rgb : color).glColorApply();
            	triangleC(scale, 0, 2, 3, gnorm, 3);
            }
        }
        else{
            for(int i = 0; i < vertices.length; i++){
            	TexturedVertex texvex = vertices[i];
            	if(!gnorm){
                	Vec3f norm = list.get(i);
                	if(invert) GL11.glNormal3f(-norm.x, -norm.y, -norm.z);
                	else GL11.glNormal3f(norm.x, norm.y, norm.z);
            	}
            	else{
                	if(invert){ GL11.glNormal3f(-normals[0], -normals[1], -normals[2]); }
                	else{ GL11.glNormal3f(normals[0], normals[1], normals[2]); }
            	}
                if(rgb == null && color == null){
                	GL11.glTexCoord2f(texvex.textureX, texvex.textureY);
                	GL11.glVertex3f(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
                }
                else{
                	(color == null ? rgb : color).glColorApply();
                	GL11.glVertex3f(texvex.vector.x * scale, texvex.vector.y * scale, texvex.vector.z * scale);
                }
            }
        }
        GL11.glEnd();
    }

    private void triangleT(float scale, int x, int y, int z, boolean gnorm, int off){
    	if(gnorm){
    		if(invert){ GL11.glNormal3f(-normals[0 + off], -normals[1 + off], -normals[2 + off]); }
        	else{ GL11.glNormal3f(normals[0 + off], normals[1 + off], normals[2 + off]); }
    	}
    	if(!gnorm) norm(x);
    	GL11.glTexCoord2f(vertices[x].textureX, vertices[x].textureY);
    	GL11.glVertex3f(vertices[x].vector.x * scale, vertices[x].vector.y * scale, vertices[x].vector.z * scale);
    	if(!gnorm) norm(y);
    	GL11.glTexCoord2f(vertices[y].textureX, vertices[y].textureY);
    	GL11.glVertex3f(vertices[y].vector.x * scale, vertices[y].vector.y * scale, vertices[y].vector.z * scale);
    	if(!gnorm) norm(z);
    	GL11.glTexCoord2f(vertices[z].textureX, vertices[z].textureY);
    	GL11.glVertex3f(vertices[z].vector.x * scale, vertices[z].vector.y * scale, vertices[z].vector.z * scale);
	}

	private void triangleC(float scale, int x, int y, int z, boolean gnorm, int off){
    	if(gnorm){
    		if(invert){ GL11.glNormal3f(-normals[0 + off], -normals[1 + off], -normals[2 + off]); }
        	else{ GL11.glNormal3f(normals[0 + off], normals[1 + off], normals[2 + off]); }
    	}
    	if(!gnorm) norm(x);
    	GL11.glVertex3f(vertices[x].vector.x * scale, vertices[x].vector.y * scale, vertices[x].vector.z * scale);
    	if(!gnorm) norm(y);
    	GL11.glVertex3f(vertices[y].vector.x * scale, vertices[y].vector.y * scale, vertices[y].vector.z * scale);
    	if(!gnorm) norm(z);
    	GL11.glVertex3f(vertices[z].vector.x * scale, vertices[z].vector.y * scale, vertices[z].vector.z * scale);
	}
    
    private void norm(int i){
    	Vec3f norm = list.get(i);
    	if(invert) GL11.glNormal3f(-norm.x, -norm.y, -norm.z);
    	else GL11.glNormal3f(norm.x, norm.y, norm.z);
	}

	private void checkGenerated(){
    	if(normals.length >= 3) return;
        if(TRIANGULATED_QUADS && vertices.length == 4){
	        Vec3f vec0 = new Vec3f(vertices[1].vector.sub(vertices[0].vector));
	        Vec3f vec1 = new Vec3f(vertices[1].vector.sub(vertices[2].vector));
	        Vec3f vec2 = vec1.cross(vec0).normalize();
	        vec0 = new Vec3f(vertices[2].vector.sub(vertices[0].vector));
	        vec1 = new Vec3f(vertices[2].vector.sub(vertices[3].vector));
	        Vec3f vec3 = vec1.cross(vec0).normalize();
	        normals = new float[]{ vec2.x, vec2.y, vec2.z, vec3.x, vec3.y, vec3.z };
        }
		else if(vertices.length >= 3){
	        Vec3f vec0 = new Vec3f(vertices[1].vector.sub(vertices[0].vector));
	        Vec3f vec1 = new Vec3f(vertices[1].vector.sub(vertices[2].vector));
	        Vec3f vec2 = vec1.cross(vec0).normalize();
	        normals = new float[]{ vec2.x, vec2.y, vec2.z };
        }
	}

	public void flipFace(){
        TexturedVertex[] verts = new TexturedVertex[vertices.length];
        for(int i = 0; i < vertices.length; ++i){
            verts[i] = vertices[vertices.length - i - 1];
        }
        vertices = verts;
    }

	public TexturedVertex[] getVertices(){
		return vertices;
	}

	public void clearNormals(){
		normals = new float[0]; list = new ArrayList<Vec3f>();
	}

	public boolean isInverted(){
		return invert;
	}

	public float[] getNormals(){
		return normals;
	}

	public List<Vec3f> getNormalVerts(){
		return list;
	}

	public TexturedPolygon setColor(RGB rgb){
		this.color = rgb; return this;
	}

	/*public TexturedPolygon setOppositeTriangles(boolean bool){
		if(this.vertices.length != 4 || bool == oppositetriangles) return this;
		TexturedVertex[] verts = new TexturedVertex[4];
		verts[0] = vertices[1]; verts[1] = vertices[0];
		verts[2] = vertices[3]; verts[3] = vertices[2];
		vertices = verts; this.oppositetriangles = bool; return this;
	}*/
	
}