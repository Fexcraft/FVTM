package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3F;
import net.fexcraft.lib.frl.ColoredVertex;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.frl.gen.AxisDir;
import net.fexcraft.lib.frl.gen.Generator;
import net.fexcraft.lib.frl.gen.Generator.Type;
import net.fexcraft.mod.fvtm.FvtmResources;

import java.util.Arrays;

import static net.fexcraft.lib.common.Static.*;
import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.lib.frl.gen.Generator.Type.CUBOID;
import static net.fexcraft.lib.frl.gen.Generator.Type.CYLINDER;
import static net.fexcraft.lib.frl.gen.Generator.Values.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class DebugUtils {

	public static int COL_RED = 0xff0000;
	public static int COL_GRN = 0x00ff00;
	public static int COL_BLU = 0x0000ff;
	public static int COL_CYN = 0x00ffff;
	public static int COL_YLW = 0xffff00;
	public static int COL_GRY = 0xcdcdcd;
	public static int COL_ORG = 0xeb8500;
	//
	public static Polyhedron SPHERE = new Generator(Type.SPHERE).set(RADIUS1, 1f).set(SEGMENTS, 16).set(CIRCLES, 16).make();
	public static Polyhedron LLBB0 = new Generator(CUBOID).set(OFF_X, -8f).set(OFF_Y, -0.1f).set(OFF_Z, -0.1f).set(WIDTH, 16f).set(HEIGHT, 0.2f).set(DEPTH, 0.2f).set(SCALE, sixteenth).make();
	public static Polyhedron LLBB1 = new Generator(CUBOID).set(OFF_X, -0.1f).set(OFF_Y, -8f).set(OFF_Z, -0.1f).set(WIDTH, 0.2f).set(HEIGHT, 16f).set(DEPTH, 0.2f).set(SCALE, sixteenth).make();
	public static Polyhedron LLBB2 = new Generator(CUBOID).set(OFF_X, -0.1f).set(OFF_Y, -0.1f).set(OFF_Z, -8f).set(WIDTH, 0.2f).set(HEIGHT, 0.2f).set(DEPTH, 16f).set(SCALE, sixteenth).make();
	public static Polyhedron PANE = new Generator(CUBOID).set(OFF_X, -8f).set(OFF_Y, 0f).set(OFF_Z, -8f).set(WIDTH, 16f).set(HEIGHT, 0.2f).set(DEPTH, 16f).set(SCALE, sixteenth).make();
	public static Polyhedron JUNC_CORE = new Generator(CYLINDER).set(RADIUS1, 0.5f).set(RADIUS2, 0.125f).set(LENGTH, 0.5f).set(SEGMENTS, 8).set(TOP_SCALE, 1.1f).set(BASE_SCALE, 1.1f).set(AXIS_DIR, AxisDir.Y_NEGATIVE).set(SCALE, sixteenth).make();
	public static Polyhedron JUNC_LINE = new Generator(CUBOID).set(OFF_X, -0.125f).set(OFF_Y, 0f).set(OFF_Z, -0.5f).set(WIDTH, 0.25f).set(HEIGHT, 0.25f).set(DEPTH, 8f).set(SCALE, sixteenth).make();
	public static Polyhedron JUNC_DIR = new Generator(CUBOID).set(OFF_X, -0.25f).set(OFF_Y, -0.125f).set(OFF_Z, -0.5f).set(WIDTH, 0.5f).set(HEIGHT, 0.5f).set(DEPTH, 2f).set(SCALE, sixteenth)
		.set(CORNERS, Arrays.asList(new V3F(1, 0, 0), new V3F(1, 0, 0), V3F.NULL, V3F.NULL, new V3F(1, 0, 0), new V3F(1, 0, 0), V3F.NULL, V3F.NULL))
		.make().pos(0f, 0f, 0.5f);
	public static Polyhedron JUNC_SIG_STATE = new Generator(CUBOID).set(OFF_X, -4f).set(OFF_Z, -1f).set(WIDTH, 2f).set(HEIGHT, 0.5f).set(DEPTH, 2f).set(SCALE, sixteenth).make();
	public static Polyhedron JUNC_SIG_DIR = new Generator(CUBOID).set(OFF_X, -4f).set(OFF_Z, 1f).set(WIDTH, 2f).set(HEIGHT, 0.5f).set(DEPTH, 2f).set(SCALE, sixteenth)
		.set(CORNERS, Arrays.asList(V3F.NULL, V3F.NULL, new V3F(-1, 0, 0), new V3F(-1, 0, 0), V3F.NULL, V3F.NULL, new V3F(-1, 0, 0), new V3F(-1, 0, 0))).make();
	public static Polyhedron LINE = new Polyhedron();
	public static Polyhedron LINE_2D = new Polyhedron();
	public static Polygon LINE_POLY;
	public static Polygon[] LINE_POLY_2D = new Polygon[2];
	static{
		LINE_POLY = new Polygon(new Vertex[]{ new ColoredVertex(new V3F()), new ColoredVertex(new V3F()) });
		LINE.polygons.add(LINE_POLY);
		LINE_POLY_2D[0] = new Polygon(new Vertex[]{ new ColoredVertex(new V3F()), new ColoredVertex(new V3F()), new ColoredVertex(new V3F()), new ColoredVertex(new V3F()) });
		LINE_POLY_2D[1] = new Polygon(new Vertex[]{ new ColoredVertex(new V3F()), new ColoredVertex(new V3F()), new ColoredVertex(new V3F()), new ColoredVertex(new V3F()) });
		LINE_2D.polygons.add(LINE_POLY_2D[0]);
		LINE_2D.polygons.add(LINE_POLY_2D[1]);
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
		//float hs = scale * 0.5f;
		RENDERER.push();
		RENDERER.scale(scale, 1, scale);
		//RENDERER.translate(-hs, 0, -hs);
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
		RENDERER.bind(FvtmResources.SPHERE_TEXTURE);
		RENDERER.color(col);
		RENDERER.push();
		RENDERER.scale(scale, scale, scale);
		SPHERE.render();
		RENDERER.pop();
		RENDERER.color(0xffffffff);
	}

	public static void renderLine2D(double sx, double sy, double sz, double ex, double ey, double ez){
		LINE_POLY_2D[0].vertices[0].pos(sx, sy, sz);
		LINE_POLY_2D[0].vertices[1].pos(ex, ey, ez);
		LINE_POLY_2D[0].vertices[2].pos(ex, ey - 0.01f, ez);
		LINE_POLY_2D[0].vertices[3].pos(sx, sy - 0.01f, sz);
		LINE_POLY_2D[1].vertices[1].pos(sx, sy, sz);
		LINE_POLY_2D[1].vertices[0].pos(ex, ey, ez);
		LINE_POLY_2D[1].vertices[3].pos(ex, ey - 0.01f, ez);
		LINE_POLY_2D[1].vertices[2].pos(sx, sy - 0.01f, sz);
		RENDERER.render(LINE_2D);
	}

}
