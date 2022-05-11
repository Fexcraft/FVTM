//FMT-Marker FVTM-1.1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.PartModel;

/** This file was exported via the FVTM Exporter V1.1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.2.9 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class StreetSignModel extends PartModel {
	
	public static final StreetSignModel INSTANCE = new StreetSignModel();

	public StreetSignModel(){
		super(); textureX = 64; textureY = 128; this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList arrow_left = new TurboList("arrow_left");
		arrow_left.add(new ModelRendererTurbo(arrow_left, 40, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -4, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_left.add(new ModelRendererTurbo(arrow_left, 41, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -16, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_left.add(new ModelRendererTurbo(arrow_left, 53, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -12, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_left.add(new ModelRendererTurbo(arrow_left, 11, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -8, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		this.groups.add(arrow_left);
		//
		TurboList arrow_right = new TurboList("arrow_right");
		arrow_right.add(new ModelRendererTurbo(arrow_right, 29, 67, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -4, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_right.add(new ModelRendererTurbo(arrow_right, 30, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -16, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_right.add(new ModelRendererTurbo(arrow_right, 22, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -12, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_right.add(new ModelRendererTurbo(arrow_right, 0, 10, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(3, -8, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		this.groups.add(arrow_right);
		//
		TurboList arrow_top_bot = new TurboList("arrow_top_bot");
		arrow_top_bot.add(new ModelRendererTurbo(arrow_top_bot, 0, 69, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -4, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		arrow_top_bot.add(new ModelRendererTurbo(arrow_top_bot, 51, 66, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -16, -4.1f).setRotationAngle(0, 0, 0).setName("Box 4cp")
		);
		this.groups.add(arrow_top_bot);
		//
		TurboList corner_bl = new TurboList("corner_bl");
		corner_bl.add(new ModelRendererTurbo(corner_bl, 1, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.95f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, -0.95f, 0)
			.setRotationPoint(-9, 0, -4).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		corner_bl.add(new ModelRendererTurbo(corner_bl, 9, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, -2, 0, -0.5f, 1, -1, -0.5f, 1, -1, 0, -2, 0, 0)
			.setRotationPoint(-10, 0, -4).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		this.groups.add(corner_bl);
		//
		TurboList corner_br = new TurboList("corner_br");
		corner_br.add(new ModelRendererTurbo(corner_br, 17, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 1, -1, -0.5f, -2, 0, -0.5f, -2, 0, 0, 1, -1, 0)
			.setRotationPoint(9, 0, -4).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		corner_br.add(new ModelRendererTurbo(corner_br, 25, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.95f, -0.5f, 0, -0.95f, 0, 0, 0, 0)
			.setRotationPoint(8, 0, -4).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		this.groups.add(corner_br);
		//
		TurboList corner_tl = new TurboList("corner_tl");
		corner_tl.add(new ModelRendererTurbo(corner_tl, 57, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, -0.95f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, -0.95f, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-9, -17, -4).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		corner_tl.add(new ModelRendererTurbo(corner_tl, 41, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, -2, 0, -0.5f, 1, -1, -0.5f, 1, -1, 0, -2, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -18, -4).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		this.groups.add(corner_tl);
		//
		TurboList corner_tr = new TurboList("corner_tr");
		corner_tr.add(new ModelRendererTurbo(corner_tr, 49, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 1, 0, 1, -1, -0.5f, -2, 0, -0.5f, -2, 0, 0, 1, -1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(9, -18, -4).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		corner_tr.add(new ModelRendererTurbo(corner_tr, 57, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 1, 1, 0, 0, 0, -0.5f, 0, -0.95f, -0.5f, 0, -0.95f, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -17, -4).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		this.groups.add(corner_tr);
		//
		TurboList left = new TurboList("left");
		left.add(new ModelRendererTurbo(left, 41, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -16, -4).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		left.add(new ModelRendererTurbo(left, 49, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -12, -4).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		left.add(new ModelRendererTurbo(left, 57, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -8, -4).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		left.add(new ModelRendererTurbo(left, 41, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-10, -4, -4).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		this.groups.add(left);
		//
		TurboList right = new TurboList("right");
		right.add(new ModelRendererTurbo(right, 49, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -16, -4).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		right.add(new ModelRendererTurbo(right, 57, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -12, -4).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		right.add(new ModelRendererTurbo(right, 41, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -8, -4).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		right.add(new ModelRendererTurbo(right, 49, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(8, -4, -4).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		this.groups.add(right);
		//
		TurboList row0 = new TurboList("row0");
		row0.add(new ModelRendererTurbo(row0, 49, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-7, -16, -3).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		row0.add(new ModelRendererTurbo(row0, 49, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(5, -16, -3).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		row0.add(new ModelRendererTurbo(row0, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -16, -4).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		this.groups.add(row0);
		//
		TurboList row1 = new TurboList("row1");
		row1.add(new ModelRendererTurbo(row1, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-7, -12, -3).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		row1.add(new ModelRendererTurbo(row1, 57, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(5, -12, -3).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		row1.add(new ModelRendererTurbo(row1, 57, 17, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(-7, -10, -3).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		row1.add(new ModelRendererTurbo(row1, 49, 25, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(5, -10, -3).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		row1.add(new ModelRendererTurbo(row1, 1, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -12, -4).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		this.groups.add(row1);
		//
		TurboList row2 = new TurboList("row2");
		row2.add(new ModelRendererTurbo(row2, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(-7, -6, -3).setRotationAngle(0, 0, 0).setName("Box 7 0")
		);
		row2.add(new ModelRendererTurbo(row2, 41, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f)
			.setRotationPoint(5, -6, -3).setRotationAngle(0, 0, 0).setName("Box 7 1")
		);
		row2.add(new ModelRendererTurbo(row2, 41, 25, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(-7, -8, -3).setRotationAngle(0, 0, 0).setName("Box 7 2")
		);
		row2.add(new ModelRendererTurbo(row2, 57, 25, textureX, textureY).addBox(0, 0, 0, 2, 2, 1)
			.setRotationPoint(5, -8, -3).setRotationAngle(0, 0, 0).setName("Box 7 3")
		);
		row2.add(new ModelRendererTurbo(row2, 1, 33, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -8, -4).setRotationAngle(0, 0, 0).setName("Box 7 4")
		);
		this.groups.add(row2);
		//
		TurboList row3 = new TurboList("row3");
		row3.add(new ModelRendererTurbo(row3, 41, 9, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(-7, -4, -3).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		row3.add(new ModelRendererTurbo(row3, 49, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(5, -4, -3).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		row3.add(new ModelRendererTurbo(row3, 1, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 4, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -4, -4).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		this.groups.add(row3);
		//
		TurboList top_bot = new TurboList("top_bot");
		top_bot.add(new ModelRendererTurbo(top_bot, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, 0, -4).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		top_bot.add(new ModelRendererTurbo(top_bot, 1, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 2, 1, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -18, -4).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		this.groups.add(top_bot);
	}

}