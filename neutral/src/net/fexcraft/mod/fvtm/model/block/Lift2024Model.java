//FMT-Marker FVTM-1.6
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelGroup;

/**
 * This file was exported via the FVTM Exporter v1.6 of<br>
 * FMT (Fex's Modelling Toolbox) v.3.0.0 &copy; 2024 - fexcraft.net<br>
 * All rights reserved.
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class Lift2024Model extends DefaultModel {

	public static final Lift2024Model INSTANCE = new Lift2024Model();
	public static ModelGroup control;
	public static ModelGroup struct;
	public static ModelGroup motor;
	public static ModelGroup lift;
	public static ModelGroup arm_s;
	public static ModelGroup arm_s_e;
	public static ModelGroup arm_n;
	public static ModelGroup arm_n_e;
	public static ModelGroup center;

	public Lift2024Model(){
		super();
		textureX = 128;
		textureY = 128;
		//
		struct = new ModelGroup("struct");
		struct.add(new ModelRendererTurbo(struct, 48, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 62, 5, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(0, 1, 3).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 74, 61, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 62, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0)
			.setRotationPoint(0, 1, -8).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 88, 22, textureX, textureY).addBox(0, 0, 0, 4, 62, 16)
			.setRotationPoint(2, 1, -8).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 82, 3, textureX, textureY).addBox(0, 0, 0, 6, 1, 16)
			.setRotationPoint(0, 0, -8).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 0, 1, textureX, textureY).addBox(0, 0, 0, 8, 1, 16)
			.setRotationPoint(0, 63, -8).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 68, 64, textureX, textureY).addBox(0, 0, 0, 1, 62, 2)
			.setRotationPoint(6, 1, -5).setRotationAngle(0, 0, 0)
		);
		struct.add(new ModelRendererTurbo(struct, 62, 64, textureX, textureY).addBox(0, 0, 0, 1, 62, 2)
			.setRotationPoint(6, 1, 3).setRotationAngle(0, 0, 0)
		);
		groups.add(struct);
		//
		lift = new ModelGroup("lift");
		lift.add(new ModelRendererTurbo(lift, 111, 9, textureX, textureY).addCylinder(0, -0.2f, 0, 2, 4, 12, 1, 1, 4, new net.fexcraft.lib.common.math.Vec3f(0.0, 0.1, 0.0))
			.setRotationPoint(12, 0, -6).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 111, 0, textureX, textureY)
			.addShapeBox(0, -0.2f, 0, 2, 2, 6, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(12, 2, -3).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 0, 109, textureX, textureY)
			.addShapeBox(0, -0.2f, 0, 2, 2, 16, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 0)
			.setRotationPoint(12, 0, -8).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 49, 19, textureX, textureY).addBox(0, -1.2f, 0, 6, 2, 16)
			.setRotationPoint(6, 1, -8).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 89, 109, textureX, textureY).addBox(0, -0.2f, 0, 3, 2, 16)
			.setRotationPoint(6, 2, -8).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 78, 21, textureX, textureY).addBox(0, -0.2f, 0, 3, 2, 6)
			.setRotationPoint(9, 2, -3).setRotationAngle(0, 0, 0)
		);
		lift.add(new ModelRendererTurbo(lift, 54, 0, textureX, textureY).addCylinder(0, -0.2f, 0, 2, 4, 12, 1, 1, 4, new net.fexcraft.lib.common.math.Vec3f(0.0, 0.1, 0.0))
			.setRotationPoint(12, 0, 6).setRotationAngle(0, 0, 0)
		);
		groups.add(lift);
		//
		control = new ModelGroup("control");
		control.add(new ModelRendererTurbo(control, 0, 19, textureX, textureY).addBox(0, 0, 0, 8, 14, 16)
			.setRotationPoint(-8, 0, -8).setRotationAngle(0, 0, 0)
		);
		control.add(new ModelRendererTurbo(control, 49, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0)
			.setRotationPoint(-8, 14, -8).setRotationAngle(0, 0, 0)
		);
		control.add(new ModelRendererTurbo(control, 0, 11, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-3, 15.2f, -1).setRotationAngle(0, 0, 0)
		);
		control.add(new ModelRendererTurbo(control, 95, 0, textureX, textureY).addBox(-2.75f, -0.5f, -3.25f, 2, 1, 0.5f)
			.setRotationPoint(-4, 15.5f, 3).setRotationAngle(0, 0, 27)
		);
		control.add(new ModelRendererTurbo(control, 9, 0, textureX, textureY).addBox(-2, -0.5f, 5, 0.5f, 1, 2)
			.setRotationPoint(-4, 15.5f, -6).setRotationAngle(0, 0, 27)
		);
		control.add(new ModelRendererTurbo(control, 9, 11, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0)
			.setRotationPoint(-4, 15.5f, -7).setRotationAngle(0, 0, 27)
		);
		control.add(new ModelRendererTurbo(control, 33, 12, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-3, 15.2f, -7).setRotationAngle(0, 0, 0)
		);
		control.add(new ModelRendererTurbo(control, 42, 12, textureX, textureY).addBox(0, 0, 0, 2, 1, 2)
			.setRotationPoint(-3, 15.2f, 5).setRotationAngle(0, 0, 0)
		);
		control.add(new ModelRendererTurbo(control, 120, 9, textureX, textureY)
			.addShapeBox(-2.5f, -0.5f, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, -0.9f, 0, 0, -0.9f, 0, 0, 0, 0, 0, -0.9f, 0, 0, 0, 0, 0, 0, 0, 0, -0.9f)
			.setRotationPoint(-4, 15.5f, 4).setRotationAngle(0, 0, 27)
		);
		groups.add(control);
		//
		motor = new ModelGroup("motor");
		motor.add(new ModelRendererTurbo(motor, 82, 8, textureX, textureY).addBox(0, 0, 5, 5, 2, 1)
			.setRotationPoint(-3, 35, -3).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 0, 7, textureX, textureY).addBox(0, 0, 0, 5, 2, 1)
			.setRotationPoint(-3, 35, -3).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 0, 18, textureX, textureY).addCylinder(0, 0, 0, 3, 5, 12, 1, 1, 4, null)
			.setRotationPoint(-3, 34, 0).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 33, 19, textureX, textureY).addCylinder(0, 0, 0, 5, 1, 12, 1, 0.8f, 5, null)
			.setRotationPoint(-3, 39, 0).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 24, 103, textureX, textureY).addCylinder(0, 0, 0, 5, 10, 12, 1, 1, 4, null)
			.setRotationPoint(-3, 40, 0).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 82, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 1, 12, 1, 1, 4, null)
			.setRotationPoint(-3, 51, 0).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 33, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 1, 12, 1, 0.8f, 4, null)
			.setRotationPoint(-3, 50, 0).setRotationAngle(0, 0, 0)
		);
		motor.add(new ModelRendererTurbo(motor, 0, 0, textureX, textureY).addBox(0, 0, 0, 2, 2, 4)
			.setRotationPoint(0, 48.5f, -2).setRotationAngle(0, 0, 0)
		);
		groups.add(motor);
		//
		arm_s = new ModelGroup("arm_s");
		arm_s.add(new ModelRendererTurbo(arm_s, 0, 69, textureX, textureY).addBox(-1.5f, -0.2f, 0, 3, 2, 14)
			.setRotationPoint(12, 2, 6).setRotationAngle(0, 0, 0)
		);
		groups.add(arm_s);
		//
		arm_s_e = new ModelGroup("arm_s_e");
		arm_s_e.add(new ModelRendererTurbo(arm_s_e, 33, 40, textureX, textureY).addBox(-1.3f, 0, 0.5f, 2.6f, 1.6f, 16)
			.setRotationPoint(12, 2, 6).setRotationAngle(0, 0, 0)
		);
		arm_s_e.add(new ModelRendererTurbo(arm_s_e, 1, 58, textureX, textureY)
			.addShapeBox(0, 0, 16.5f, 1.3f, 1.6f, 1, 0, 0, 0, 0, 0, 0, 0, -0.8f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0)
			.setRotationPoint(12, 2, 6).setRotationAngle(0, 0, 0)
		);
		arm_s_e.add(new ModelRendererTurbo(arm_s_e, 6, 58, textureX, textureY)
			.addShapeBox(-1.3f, 0, 16.5f, 1.3f, 1.6f, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.5f, 0, -0.8f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0)
			.setRotationPoint(12, 2, 6).setRotationAngle(0, 0, 0)
		);
		arm_s_e.add(new ModelRendererTurbo(arm_s_e, 54, 19, textureX, textureY).addCylinder(0, 0.8f, 16, 2, 1, 12, 1, 1, 4, null)
			.setRotationPoint(12, 3, 6).setRotationAngle(0, 0, 0)
		);
		arm_s_e.add(new ModelRendererTurbo(arm_s_e, 1, 50, textureX, textureY).addCylinder(0, 0.8f, 16, 1, 1, 8, 1, 1, 4, null)
			.setRotationPoint(12, 2, 6).setRotationAngle(0, 0, 0)
		);
		groups.add(arm_s_e);
		//
		arm_n = new ModelGroup("arm_n");
		arm_n.add(new ModelRendererTurbo(arm_n, 0, 86, textureX, textureY).addBox(-1.5f, -0.2f, -14, 3, 2, 14)
			.setRotationPoint(12, 2, -6).setRotationAngle(0, 0, 0)
		);
		groups.add(arm_n);
		//
		arm_n_e = new ModelGroup("arm_n_e");
		arm_n_e.add(new ModelRendererTurbo(arm_n_e, 0, 50, textureX, textureY).addBox(-1.3f, 0, -16.5f, 2.6f, 1.6f, 16)
			.setRotationPoint(12, 2, -6).setRotationAngle(0, 0, 0)
		);
		arm_n_e.add(new ModelRendererTurbo(arm_n_e, 6, 54, textureX, textureY)
			.addShapeBox(-1.3f, 0, -17.5f, 1.3f, 1.6f, 1, 0, -0.8f, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12, 2, -6).setRotationAngle(0, 0, 0)
		);
		arm_n_e.add(new ModelRendererTurbo(arm_n_e, 1, 54, textureX, textureY)
			.addShapeBox(0, 0, -17.5f, 1.3f, 1.6f, 1, 0, 0, -0.5f, 0, -0.8f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(12, 2, -6).setRotationAngle(0, 0, 0)
		);
		arm_n_e.add(new ModelRendererTurbo(arm_n_e, 54, 9, textureX, textureY).addCylinder(0, 0.8f, -16, 2, 1, 12, 1, 1, 4, null)
			.setRotationPoint(12, 3, -6).setRotationAngle(0, 0, 0)
		);
		arm_n_e.add(new ModelRendererTurbo(arm_n_e, 122, 0, textureX, textureY).addCylinder(0, 0.8f, -16, 1, 1, 8, 1, 1, 4, null)
			.setRotationPoint(12, 2, -6).setRotationAngle(0, 0, 0)
		);
		groups.add(arm_n_e);
		//
		center = new ModelGroup("center");
		center.add(new ModelRendererTurbo(center, 55, 38, textureX, textureY).newCylinderBuilder()
			.setPosition(0, 0, 0).setRadius(8, 6).setLength(1).setSegments(20, 0).setScale(1, 0.95f).setDirection(4)
			.setTopOffset(null).setTopRotation(new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, 0.0)).build());
		groups.add(center);
	}

}
