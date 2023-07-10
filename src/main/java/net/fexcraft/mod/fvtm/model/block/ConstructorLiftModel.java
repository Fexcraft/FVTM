//FMT-Marker FVTM-1
package net.fexcraft.mod.fvtm.model.block;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.1.7 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class ConstructorLiftModel extends GenericModel {
	
	public ModelGroup engine;
	public ModelGroup pillar;
	public ModelGroup glider;
	public ModelGroup holder0;
	public ModelGroup holder1;
	public ModelGroup arm0;
	public ModelGroup arm1;
	private float rotation, yoff;
	private Pos offset;
	private float zoff = 10;

	public ConstructorLiftModel(LiftingPoint point, LiftingPoint counter){
		super();
		textureX = 64;
		textureY = 64;
		this.addToCreators("Ferdinand (FEX___96)");
		float dis = 0;
		boolean singular = point.isSingular() || counter == null;
		zoff += point.off;
		if(singular){
			offset = new Pos(point.pos.x, 0, point.pos.z + (point.pos.z < 0 ? -zoff : zoff));
		}
		else{
			offset = new Pos((point.pos.x + counter.pos.x) / 2, 0, point.pos.z + (point.pos.z < 0 ? -zoff : zoff));
			float less = point.pos.x > counter.pos.x ? counter.pos.x : point.pos.x;
			float more = point.pos.x > counter.pos.x ? point.pos.x : counter.pos.x;
			dis = Math.abs(more - less) / 2;
			if(dis < 3) singular = true;
		}
		yoff = point.pos.y16;
		//
		if(point.pos.z >= 0){
			engine = new ModelGroup("engine");
			engine.add(new ModelRendererTurbo(engine, 25, 16, textureX, textureY).addHollowCylinder(0, 0, 0, 4, 0.001f, 8, 12, 0, 1, 1, 4,
				null, new boolean[]{ true, true, false, true })
				.setRotationPoint(0, -15, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 25, 25, textureX, textureY).addHollowCylinder(0, 0, 0, 4, 0.001f, 1, 12, 0, 1, 0.75f, 4,
				null, new boolean[]{ true, true, false, true })
				.setRotationPoint(0, -7, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 25, 14, textureX, textureY).addHollowCylinder(0, 0, 0, 4, 0.001f, 1, 12, 0, 0.75f, 1, 4,
				null, new boolean[]{ false, true, false, true })
				.setRotationPoint(0, -16, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 25, 29, textureX, textureY).addHollowCylinder(0, 0, 0, 3, 0.001f, 1, 12, 0, 1, 1, 4,
				null, new boolean[]{ true, true, false, true })
				.setRotationPoint(0, -6, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 25, 37, textureX, textureY).addHollowCylinder(0, 0, 0, 3, 0.001f, 1, 12, 0, 1, 0.75f, 4,
				null, new boolean[]{ true, false, false, true })
				.setRotationPoint(0, -5, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 25, 46, textureX, textureY)
				.addBox(0, 0, 0, 1, 6, 3, 0, 1f, new boolean[]{ true, false, false, false, false, false })
				.setRotationPoint(-4, -14, 4).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 32, 46, textureX, textureY)
				.addBox(0, 0, 0, 1, 6, 3, 0, 1f, new boolean[]{ false, true, false, false, false, false })
				.setRotationPoint(3, -14, 4).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 52, 14, textureX, textureY).addHollowCylinder(0, 0, 0, 1, 0.001f, 8, 8, 0, 1, 1, 5,
				new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, -3.0), new boolean[]{ true, true, false, true })
				.setRotationPoint(0, -24, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 42, 14, textureX, textureY).addHollowCylinder(0, 0, 0, 0.5f, 0.001f, 8, 8, 0, 1, 1, 5,
				new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, -3.0), new boolean[]{ true, true, false, true })
				.setRotationPoint(2, -24, 4).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			engine.add(new ModelRendererTurbo(engine, 47, 14, textureX, textureY).addHollowCylinder(0, 0, 0, 0.5f, 0.001f, 8, 8, 0, 1, 1, 5,
				new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, -3.0), new boolean[]{ true, true, false, true })
				.setRotationPoint(-2, -24, 5).setRotationAngle(0, 0, 0)
				.setTextured(true).setLines(false)
			);
			this.groups.add(engine);
		}
		else rotation = 180;
		//
		pillar = new ModelGroup("pillar");
		pillar.add(new ModelRendererTurbo(pillar, 5, 56, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -8, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 56, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -8, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 56, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -8, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 48, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -16, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 48, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -16, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 48, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -16, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 40, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -24, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 40, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -24, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 40, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -24, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 32, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -32, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 32, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -32, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 32, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -32, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 24, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -40, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 24, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -40, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 24, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -40, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 16, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -48, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 16, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -48, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 16, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -48, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 8, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -56, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 8, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -56, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 8, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -56, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 5, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(6, 8, 3)
			.removePolygons(0, 1, 2, 3)
			.setPolygonUV(4, new float[]{ 12.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 0.0f, 0.0f }).build()
			.setRotationPoint(-3, -64, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 16, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0)
			.removePolygons(0, 2, 3)
			.setPolygonUV(1, new float[]{ -4.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(5, new float[]{ -5.0f, 0.0f }).build()
			.setRotationPoint(-4, -64, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 0, 0, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, 0).setSize(1, 8, 4)
			.setCorners(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1)
			.removePolygons(1, 2, 3)
			.setPolygonUV(0, new float[]{ 0.0f, 0.0f })
			.setPolygonUV(4, new float[]{ 23.0f, 0.0f })
			.setPolygonUV(5, new float[]{ 4.0f, 0.0f }).build()
			.setRotationPoint(3, -64, 0).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 56, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -8, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 56, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -8, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 48, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -16, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 48, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -16, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 40, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -24, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 40, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -24, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 32, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -32, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 32, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -32, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 24, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -40, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 24, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -40, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 16, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -48, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 16, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -48, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 8, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -56, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 8, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -56, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 58, 0, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(-3, -64, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 61, 0, textureX, textureY)
			.addBox(0, 0, 0, 1, 8, 1, 0, 1f, new boolean[]{ false, false, true, true, false, true })
			.setRotationPoint(2, -64, -0.5f).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 25, 0, textureX, textureY).addBox(0, 0, 0, 8, 1, 5)
			.setRotationPoint(-4, -65, -1).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		pillar.add(new ModelRendererTurbo(pillar, 25, 7, textureX, textureY).addBox(0, 0, 0, 8, 1, 5)
			.setRotationPoint(-4, -0.1f, -1).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(pillar);
		//
		glider = new ModelGroup("glider");
		glider.add(new ModelRendererTurbo(glider, 25, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 2, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -2, -2).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(glider);
		//
		Vec3f hol0 = new Vec3f(singular ? 3 : dis, -4, -zoff - 1);
		holder0 = new ModelGroup("holder0");
		holder0.add(new ModelRendererTurbo(holder0, 48, 42, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 0.75f, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.375, 0.0), new boolean[]{ true, false, false, true })
			.setRotationPoint(hol0.x, hol0.y + 0.5f, hol0.z).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		holder0.add(new ModelRendererTurbo(holder0, 48, 35, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 1, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.5, 0.0), new boolean[]{ false, true, false, true })
			.setRotationPoint(hol0.x, hol0.y, hol0.z).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(holder0);
		//
		Vec3f hol1 = new Vec3f(singular ? -3 : -dis, -4, -zoff - 1);
		holder1 = new ModelGroup("holder1");
		holder1.add(new ModelRendererTurbo(holder1, 39, 42, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 0.75f, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.375, 0.0), new boolean[]{ true, false, false, true })
			.setRotationPoint(hol1.x, hol1.y + 0.5f, hol1.z).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		holder1.add(new ModelRendererTurbo(holder1, 39, 35, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 1, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.5, 0.0), new boolean[]{ false, true, false, true })
			.setRotationPoint(hol1.x, hol1.y, hol1.z).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(holder1);
		//
		Vec3f ar0m = new Vec3f(3, -2, -1);
		arm0 = new ModelGroup("arm0");
		arm0.add(new ModelRendererTurbo(arm0, 39, 49, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, -0.5f).setSize((int)ar0m.dis(hol0) + 1, 2, 1)
			.setCorners(0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, -0.25f, -0.75f, -2, -0.25f, -0.75f, -2, -0.25f, 0, 0, -0.25f)
			.setPolygonUV(0, new float[]{ 16.0f, 0.0f })
			.setPolygonUV(1, new float[]{ 16.0f, 2.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 0.0f, 2.0f, 2.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 2.0f, 2.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 2.0f, 0.0f, 16.0f, 2.0f })
			.setPolygonUV(5, new float[]{ 2.0f, 2.0f, 16.0f, 4.0f }).build()
			.setRotationPoint(ar0m.x, ar0m.y, ar0m.z)
			.setRotationAngle(0, (float)Math.toDegrees(Math.atan2(ar0m.x - hol0.x, ar0m.z - hol0.z)) + 90, 0)
		);
		this.groups.add(arm0);
		//
		Vec3f ar1m = new Vec3f(-3, -2, -1);
		arm1 = new ModelGroup("arm1");
		arm1.add(new ModelRendererTurbo(arm1, 39, 54, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, -0.5f).setSize((int)ar1m.dis(hol1) + 1, 2, 1)
			.setCorners(0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, -0.25f, -0.75f, -2, -0.25f, -0.75f, -2, -0.25f, 0, 0, -0.25f)
			.setPolygonUV(0, new float[]{ 16.0f, 0.0f })
			.setPolygonUV(1, new float[]{ 16.0f, 2.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 0.0f, 2.0f, 2.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 2.0f, 2.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 2.0f, 0.0f, 16.0f, 2.0f })
			.setPolygonUV(5, new float[]{ 2.0f, 2.0f, 16.0f, 4.0f }).build()
			.setRotationPoint(ar1m.x, ar1m.y, ar1m.z)
			.setRotationAngle(0, (float)Math.toDegrees(Math.atan2(ar1m.x - hol1.x, ar1m.z - hol1.z)) + 90, 0)
		);
		this.groups.add(arm1);
	}

	@Override
	public void render(ModelRenderData data){
		ConstCenterEntity tile = (ConstCenterEntity)data.tile;
		offset.translate();
		if(engine != null) engine.render();
		GL11.glRotatef(rotation, 0, 1, 0);
		pillar.render();
		float off = (yoff - tile.getLowestLiftPoint());
		GL11.glTranslatef(0, tile.getRawLiftState() + off + .25f, 0);
		glider.render();
		arm0.render();
		arm1.render();
		holder0.render();
		holder1.render();
		GL11.glTranslatef(0, -tile.getRawLiftState() - off - .25f, 0);
		GL11.glRotatef(-rotation, 0, 1, 0);
		offset.translateR();
	}
	
	public static ArrayList<ConstructorLiftModel> setup(VehicleData data){
		ArrayList<String> processed = new ArrayList<>(); 
		ArrayList<ConstructorLiftModel> models = new ArrayList<>(); 
		for(LiftingPoint point : data.getType().getLiftingPoints().values()){
			if(processed.contains(point.id)) continue;
			models.add(new ConstructorLiftModel(point, data.getType().getLiftingPoints().get(point.second)));
			if(!point.isSingular()) processed.add(point.second);
			processed.add(point.id);
		}
		return models;
	}

}
