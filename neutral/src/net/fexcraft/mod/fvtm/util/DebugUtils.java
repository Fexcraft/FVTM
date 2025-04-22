package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmResources;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.lib.frl.Renderer.RENDERER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DebugUtils {

	public static boolean ACTIVE = false;
	public static Vec3f CYNCOLOR = new Vec3f(0, 1, 1);
	public static Vec3f REDCOLOR = new Vec3f(1, 0, 0);
	public static Vec3f GRNCOLOR = new Vec3f(0, 1, 0);
	public static Vec3f YLWCOLOR = new Vec3f(1, 1, 0);
	public static Vec3f GRYCOLOR = new Vec3f(.8, .8, .8);
	public static Vec3f ORGCOLOR = new Vec3f(.92, .52, 0);
	public static Vec3f SEATCOLOR = new Vec3f(1, 1, 0);
	//
	public static int COL_RED = 0xff0000;
	public static int COL_GRN = 0x00ff00;
	public static int COL_BLU = 0x0000ff;
	public static int COL_CYN = 0x00ffff;
	public static int COL_YLW = 0xffff00;
	public static int COL_GRY = 0xcdcdcd;
	public static int COL_ORG = 0xeb8500;
	//
	public static Polyhedron SPHERE = new Polyhedron();
	public static Polyhedron CUBE = new Polyhedron();
	public static Polyhedron LLBB0 = new Polyhedron();
	public static Polyhedron LLBB1 = new Polyhedron();
	public static Polyhedron LLBB2 = new Polyhedron();
	public static Polyhedron JUNC_CORE = new Polyhedron();
	static{
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 0), new Vertex(1, 0, 0) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 0), new Vertex(0, 0, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(1, 0, 0), new Vertex(1, 0, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 1), new Vertex(1, 0, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 1, 0), new Vertex(1, 1, 0) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 1, 0), new Vertex(0, 1, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(1, 1, 0), new Vertex(1, 1, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 1, 1), new Vertex(1, 1, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 0), new Vertex(0, 1, 0) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(1, 0, 0), new Vertex(1, 1, 0) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 1), new Vertex(0, 1, 1) }));
		CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(1, 0, 1), new Vertex(1, 1, 1) }));
		CUBE.pos(-.5f, -.5f, -.5f);
		LLBB0.importMRT(new ModelRendererTurbo(LLBB0, 0, 0, 1, 1).addBox(-8, -0.1f, -0.1f, 16, 0.2f, 0.2f), false, sixteenth);
		LLBB1.importMRT(new ModelRendererTurbo(LLBB1, 0, 0, 1, 1).addBox(-0.1f, -8, -0.1f, 0.2f, 16, 0.2f), false, sixteenth);
		LLBB2.importMRT(new ModelRendererTurbo(LLBB2, 0, 0, 1, 1).addBox(-0.1f, -0.1f, -8, 0.2f, 0.2f, 16), false, sixteenth);
		SPHERE.importMRT(new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8), false, 1);
		JUNC_CORE.importMRT(new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(120, 120, 120)), false, sixteenth);
	}

	public static void renderBB(float scale, int col){
		RENDERER.bind(FvtmResources.WHITE_TEXTURE);
		RENDERER.color(col);
		float hs = scale * 0.5f;
		//
		RENDERER.push();
		RENDERER.scale(scale, 1, 1);
		RENDERER.translate(0, -hs, -hs);
		LLBB0.render();
		RENDERER.translate(0, 0, scale);
		LLBB0.render();
		RENDERER.translate(0, scale, 0);
		LLBB0.render();
		RENDERER.translate(0, 0, -scale);
		LLBB0.render();
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, scale, 1);
		RENDERER.translate(-hs, 0, -hs);
		LLBB1.render();
		RENDERER.translate(scale, 0, 0);
		LLBB1.render();
		RENDERER.translate(0, 0, scale);
		LLBB1.render();
		RENDERER.translate(-scale, 0, 0);
		LLBB1.render();
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, 1, scale);
		RENDERER.translate(-hs, -hs, 0);
		LLBB2.render();
		RENDERER.translate(scale, 0, 0);
		LLBB2.render();
		RENDERER.translate(0, scale, 0);
		LLBB2.render();
		RENDERER.translate(-scale, 0, 0);
		LLBB2.render();
		RENDERER.pop();
		//
		RENDERER.color(0xffffffff);
	}

	public static void renderBB(V3D pos, float scale, int col){
		RENDERER.translate(pos.x, pos.y, pos.z);
		renderBB(scale, col);
		RENDERER.translate(-pos.x, -pos.y, -pos.z);
	}

	public static void renderSphere(float scale, int col){
		RENDERER.bind(FvtmResources.WHITE_TEXTURE);
		RENDERER.color(col);
		RENDERER.push();
		RENDERER.scale(scale, scale, scale);
		SPHERE.render();
		RENDERER.pop();
		RENDERER.color(0xffffffff);
	}

}
