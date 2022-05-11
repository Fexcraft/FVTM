package net.fexcraft.lib.frl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;

/**
 * 
 * Default (LWJGL2 / Static Pipeline) Renderer
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class DefaultRenderer extends Renderer<Object> {
	
	public void render(Polyhedron<Object> poly){
		if(poly.glId == null || poly.recompile){
			compile(poly);
		}
		if(poly.rotX != 0f || poly.rotY != 0f || poly.rotZ != 0f){
			glPushMatrix();
			glTranslatef(poly.posX, poly.posY, poly.posZ);
			poly.rotOrder.rotate(poly);
			glCallList(poly.glId);
			if(poly.sub != null) for(Polyhedron<Object> p : poly.sub) render(p);
			glPopMatrix();
		}
		else if(poly.posX != 0 || poly.posY != 0f || poly.posZ != 0){
			glTranslatef(poly.posX, poly.posY, poly.posZ);
			glCallList(poly.glId);
			if(poly.sub != null) for(Polyhedron<Object> p : poly.sub) render(p);
			glTranslatef(-poly.posX, -poly.posY, -poly.posZ);
		}
		else{
			glCallList(poly.glId);
			if(poly.sub != null) for(Polyhedron<Object> p : poly.sub) render(p);
		}
	}

	private static void compile(Polyhedron<Object> poly){
		poly.glId = glGenLists(1);
		glNewList(poly.glId, GL_COMPILE);
		for(Polygon gon : poly.polygons){
			if(gon.lines){
				glBegin(GL_LINE_STRIP);
			}
			else{
				switch(gon.vertices.length){
					case 3: glBegin(GL_TRIANGLES); break;
					case 4: glBegin(TRIANGULATED_QUADS ? GL_TRIANGLES : GL_QUADS); break;
					default: glBegin(GL_POLYGON); break;
				}
			}
			if(TRIANGULATED_QUADS && gon.vertices.length == 4){
				if(gon.colored) quadAsTriangleCol(gon, 0, 1, 2, 0);
				else quadAsTriangleTex(gon, 0, 1, 2, 0);
				if(gon.colored) quadAsTriangleCol(gon, 0, 2, 3, 3);
				else quadAsTriangleTex(gon, 0, 2, 3, 3);
			}
			else{
				for(int i = 0; i < gon.vertices.length; i++){
					glNormal3f(gon.vertices[i].norm.x, gon.vertices[i].norm.y, gon.vertices[i].norm.z);
					if(gon.colored){
						glColor4f(gon.vertices[i].color().x, gon.vertices[i].color().y, gon.vertices[i].color().z, 1);
					}
					else{
						glTexCoord2f(gon.vertices[i].u, gon.vertices[i].v);
					}
					glVertex3f(gon.vertices[i].vector.x, gon.vertices[i].vector.y, gon.vertices[i].vector.z);
				}
			}
			glEnd();
		}
		glEndList();
		poly.recompile = false;
	}

	private static void quadAsTriangleCol(Polygon poly, int x, int y, int z, int o){
		glColor4f(poly.vertices[x].color().x, poly.vertices[x].color().y, poly.vertices[x].color().z, 1);
		glNormal3f(poly.vertices[x].norm.x, poly.vertices[x].norm.y, poly.vertices[x].norm.z);
		glTexCoord2f(poly.vertices[x].u, poly.vertices[x].v);
		glVertex3f(poly.vertices[x].vector.x, poly.vertices[x].vector.y, poly.vertices[x].vector.z);
		glColor4f(poly.vertices[y].color().x, poly.vertices[y].color().y, poly.vertices[y].color().z, 1);
		glNormal3f(poly.vertices[y].norm.x, poly.vertices[y].norm.y, poly.vertices[y].norm.z);
		glTexCoord2f(poly.vertices[y].u, poly.vertices[y].v);
		glVertex3f(poly.vertices[y].vector.x, poly.vertices[y].vector.y, poly.vertices[y].vector.z);
		glColor4f(poly.vertices[z].color().x, poly.vertices[z].color().y, poly.vertices[z].color().z, 1);
		glNormal3f(poly.vertices[z].norm.x, poly.vertices[z].norm.y, poly.vertices[z].norm.z);
		glTexCoord2f(poly.vertices[z].u, poly.vertices[z].v);
		glVertex3f(poly.vertices[z].vector.x, poly.vertices[z].vector.y, poly.vertices[z].vector.z);
		RGB.glColorReset();
	}

	private static void quadAsTriangleTex(Polygon poly, int x, int y, int z, int o){
		glNormal3f(poly.vertices[x].norm.x, poly.vertices[x].norm.y, poly.vertices[x].norm.z);
		glTexCoord2f(poly.vertices[x].u, poly.vertices[x].v);
		glVertex3f(poly.vertices[x].vector.x, poly.vertices[x].vector.y, poly.vertices[x].vector.z);
		glNormal3f(poly.vertices[y].norm.x, poly.vertices[y].norm.y, poly.vertices[y].norm.z);
		glTexCoord2f(poly.vertices[y].u, poly.vertices[y].v);
		glVertex3f(poly.vertices[y].vector.x, poly.vertices[y].vector.y, poly.vertices[y].vector.z);
		glNormal3f(poly.vertices[z].norm.x, poly.vertices[z].norm.y, poly.vertices[z].norm.z);
		glTexCoord2f(poly.vertices[z].u, poly.vertices[z].v);
		glVertex3f(poly.vertices[z].vector.x, poly.vertices[z].vector.y, poly.vertices[z].vector.z);
	}

	@Override
	public void delete(Polyhedron<Object> poly){
		if(poly.glId == null) return;
		GL11.glDeleteLists(poly.glId, 1);
	}

}
