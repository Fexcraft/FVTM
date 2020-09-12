//FMT-Marker FVTM-1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.ConstCenterEntity;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.1.7 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class ConstructorLiftModel extends GenericModel<ConstCenterEntity, BlockPos> {
	
	public static final ConstructorLiftModel INSTANCE = new ConstructorLiftModel();
	//
	public TurboList engine;
	public TurboList pillar;
	public TurboList glider;
	public TurboList holder0;
	public TurboList holder1;
	public TurboList arm0;
	public TurboList arm1;

	public ConstructorLiftModel(){
		super(); textureX = 256; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		engine = new TurboList("engine");
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
		//
		pillar = new TurboList("pillar");
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
			.setRotationPoint(-4, 0, -1).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(pillar);
		//
		glider = new TurboList("glider");
		glider.add(new ModelRendererTurbo(glider, 25, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 2, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -2, -2).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(glider);
		//
		holder0 = new TurboList("holder0");
		holder0.add(new ModelRendererTurbo(holder0, 48, 42, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 0.75f, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.375, 0.0), new boolean[]{ true, false, false, true })
			.setRotationPoint(14, -3.5f, -10).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		holder0.add(new ModelRendererTurbo(holder0, 48, 35, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 1, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.5, 0.0), new boolean[]{ false, true, false, true })
			.setRotationPoint(14, -4, -10).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(holder0);
		//
		holder1 = new TurboList("holder1");
		holder1.add(new ModelRendererTurbo(holder1, 39, 42, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 0.75f, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.375, 0.0), new boolean[]{ true, false, false, true })
			.setRotationPoint(-14, -3.5f, -10).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		holder1.add(new ModelRendererTurbo(holder1, 39, 35, textureX, textureY).addHollowCylinder(0, 0, 0, 2, 0.001f, 1, 12, 0, 1, 1, 4,
			new net.fexcraft.lib.common.math.Vec3f(0.0, -0.5, 0.0), new boolean[]{ false, true, false, true })
			.setRotationPoint(-14, -4, -10).setRotationAngle(0, 0, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(holder1);
		//
		arm0 = new TurboList("arm0");
		arm0.add(new ModelRendererTurbo(arm0, 39, 49, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, -0.5f).setSize(15, 2, 1)
			.setCorners(0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, -0.25f, -0.75f, -2, -0.25f, -0.75f, -2, -0.25f, 0, 0, -0.25f)
			.setPolygonUV(0, new float[]{ 16.0f, 0.0f })
			.setPolygonUV(1, new float[]{ 16.0f, 2.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 0.0f, 2.0f, 2.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 2.0f, 2.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 2.0f, 0.0f, 16.0f, 2.0f })
			.setPolygonUV(5, new float[]{ 2.0f, 2.0f, 16.0f, 4.0f }).build()
			.setRotationPoint(3, -2, -1).setRotationAngle(0, 40, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(arm0);
		//
		arm1 = new TurboList("arm1");
		arm1.add(new ModelRendererTurbo(arm1, 39, 54, textureX, textureY).newBoxBuilder()
			.setOffset(0, 0, -0.5f).setSize(15, 2, 1)
			.setCorners(0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, -0.25f, -0.75f, -2, -0.25f, -0.75f, -2, -0.25f, 0, 0, -0.25f)
			.setPolygonUV(0, new float[]{ 16.0f, 0.0f })
			.setPolygonUV(1, new float[]{ 16.0f, 2.0f })
			.setPolygonUV(2, new float[]{ 0.0f, 0.0f, 2.0f, 2.0f })
			.setPolygonUV(3, new float[]{ 0.0f, 2.0f, 2.0f, 4.0f })
			.setPolygonUV(4, new float[]{ 2.0f, 0.0f, 16.0f, 2.0f })
			.setPolygonUV(5, new float[]{ 2.0f, 2.0f, 16.0f, 4.0f }).build()
			.setRotationPoint(-3, -2, -1).setRotationAngle(0, 140, 0)
			.setTextured(true).setLines(false)
		);
		this.groups.add(arm1);
	}

	@Override
	public void render(ConstCenterEntity data, BlockPos key){
		//
	}

	@Override
	public void render(ConstCenterEntity data, BlockPos key, Entity ent, RenderCache cache){
		this.render(data, key); return;
	}

}
