package net.fexcraft.mod.fvtm.util;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

import static net.fexcraft.lib.common.Static.sixteenth;

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
	public static Polyhedron SPHERE = new Polyhedron()
		.importMRT(new ModelRendererTurbo(null, 0, 0, 1, 1)
			.addSphere(0, 0, 0, 1, 16, 16, 1, 1), false, 1f);
	public static Polyhedron CUBE = new Polyhedron();
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
	}
	public static Polyhedron JUNC_CORE = new Polyhedron()
		.importMRT(new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(120, 120, 120)), false, sixteenth);

}
