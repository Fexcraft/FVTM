package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.ColoredVertex;
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

	public static float[] CYNCOLOR = new float[]{ 0, 1, 1 };
	public static float[] REDCOLOR = new float[]{ 1, 0, 0 };
	public static float[] GRNCOLOR = new float[]{ 0, 1, 0 };
	public static float[] YLWCOLOR = new float[]{ 1, 1, 0 };
	public static float[] GRYCOLOR = new float[]{ .8f, .8f, .8f };
	public static float[] ORGCOLOR = new float[]{ .92f, .52f, 0 };
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
	//public static Polyhedron CUBE = new Polyhedron();
	public static Polyhedron LLBB0 = new Polyhedron();
	public static Polyhedron LLBB1 = new Polyhedron();
	public static Polyhedron LLBB2 = new Polyhedron();
	public static Polyhedron PANE = new Polyhedron();
	public static Polyhedron JUNC_CORE = new Polyhedron();
	public static Polyhedron JUNC_LINE = new Polyhedron();
	public static Polyhedron JUNC_DIR = new Polyhedron();
	public static Polyhedron JUNC_SIG_STATE = new Polyhedron();
	public static Polyhedron JUNC_SIG_DIR = new Polyhedron();
	public static Polyhedron LINE = new Polyhedron();
	public static Polygon LINE_POLY;
	static{
		/*CUBE.polygons.add(new Polygon(new Vertex[]{ new Vertex(0, 0, 0), new Vertex(1, 0, 0) }));
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
		CUBE.pos(-.5f, -.5f, -.5f);*/
		LLBB0.importMRT(new ModelRendererTurbo(LLBB0, 0, 0, 1, 1).addBox(-8, -0.1f, -0.1f, 16, 0.2f, 0.2f), false, sixteenth);
		LLBB1.importMRT(new ModelRendererTurbo(LLBB1, 0, 0, 1, 1).addBox(-0.1f, -8, -0.1f, 0.2f, 16, 0.2f), false, sixteenth);
		LLBB2.importMRT(new ModelRendererTurbo(LLBB2, 0, 0, 1, 1).addBox(-0.1f, -0.1f, -8, 0.2f, 0.2f, 16), false, sixteenth);
		PANE.importMRT(new ModelRendererTurbo(PANE, 0, 0, 1, 1).addBox(-8, 0, -8, 16, 0.2f, 16), false, sixteenth);
		SPHERE.importMRT(new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8), false, 1);
		JUNC_CORE.importMRT(new ModelRendererTurbo(JUNC_CORE, 0, 0, 1, 1).newCylinderBuilder()
			.setPosition(0, 0, 0).setRadius(0.5f, 0.125f).setLength(0.5f).setSegments(8, 0).setScale(1.1f, 1.1f).setDirection(4).build(), false, sixteenth);
		JUNC_LINE.importMRT(new ModelRendererTurbo(JUNC_LINE, 0, 0, 1, 1).addBox(-0.125f, 0, 0.5f, 0.25f, 0.25f, 8), false, sixteenth);
		JUNC_DIR.importMRT(new ModelRendererTurbo(JUNC_DIR, 0, 0, 1, 1)
			.addShapeBox(-0.25f, 0, 0, 0.5f, 0.5f, 2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-0, 0, 0.5f), false, sixteenth);
		JUNC_SIG_DIR.importMRT(new ModelRendererTurbo(JUNC_SIG_DIR, 0, 0, 1, 1)
			.addShapeBox(-4, 0, 1, 2, 0.5f, 2, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0), false, sixteenth);
		JUNC_SIG_STATE.importMRT(new ModelRendererTurbo(JUNC_SIG_STATE, 0, 0, 1, 1)
			.addShapeBox(-4, 0, -1, 2, 0.5f, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), false, sixteenth);
		LINE_POLY = new Polygon(new Vertex[]{ new ColoredVertex(new Vec3f()), new ColoredVertex(new Vec3f())});
		LINE.polygons.add(LINE_POLY);
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

	public static void renderPane(float scale, int col){
		RENDERER.bind(FvtmResources.WHITE_TEXTURE);
		RENDERER.color(col);
		float hs = scale * 0.5f;
		RENDERER.push();
		RENDERER.scale(scale, 1, scale);
		RENDERER.translate(-hs, 0, -hs);
		PANE.render();
		RENDERER.pop();
		RENDERER.color(0xffffffff);
	}

	public static void renderAxe(float scale, int col){
		RENDERER.bind(FvtmResources.WHITE_TEXTURE);
		RENDERER.color(col);
		//
		RENDERER.push();
		RENDERER.scale(scale, 1, 1);
		LLBB0.render();
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, scale, 1);
		LLBB1.render();
		RENDERER.pop();
		//
		RENDERER.push();
		RENDERER.scale(1, 1, scale);
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
