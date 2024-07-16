package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.container.ContainerType;

public class DebugModels {

	public static ModelRendererTurbo[] CONTAINER = {
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-8.1f, -48.1f, -24.1f, 16.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-16.1f, -48.1f, -24.1f, 32.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-24.1f, -48.1f, -24.1f, 48.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-48.1f, -48.1f, -24.1f, 96.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-96.1f, -48.1f, -24.1f, 192.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0)
	};

	static{
		for(int i = 0; i < ContainerType.values().length; i++){
			RGB rgb = new RGB(ContainerType.values()[i].getRGB().packed * 2);
			CONTAINER[i].setTextured(false).setColor(rgb);
		}
	}

	public static final ModelRendererTurbo SPHERE = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8);
	public static final ModelRendererTurbo SPHERE_GRY = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0xcdcdcd));
	public static final ModelRendererTurbo SPHERE_RED = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0xff0000));
	public static final ModelRendererTurbo SPHERE_GRN = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0x00ff00));
	public static final ModelRendererTurbo SPHERE_BLU = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0x0000ff));
	public static final ModelRendererTurbo SPHERE_YLW = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0xffff00));
	public static final ModelRendererTurbo SPHERE_CYN = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0x00ffff));
	public static final ModelRendererTurbo CUBE_CYN = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0x00ffff));
	public static final ModelRendererTurbo CUBE_RED = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0xff0000));
	public static final ModelRendererTurbo CUBE_GRN = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0x00ff00));
	public static final ModelRendererTurbo CUBE_YLW = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0xffff00));
	public static final ModelRendererTurbo CUBE_ORG = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0xeb8500));
	public static final ModelRendererTurbo CUBE_ATTR = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0x1d8228/*ffbb00*/));
	public static final ModelRendererTurbo SEAT_CUBE_SITTING = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0xeb8500));
	public static final ModelRendererTurbo SEAT_CUBE_STANDING = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0xcbcf00));
	public static final ModelRendererTurbo SEAT_CUBE_OCCUPIED = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0x619900));

	public static final ModelRendererTurbo centermarker0 = new ModelRendererTurbo(null, 0, 0, 0, 0).addBox(-0.25f, -8, -0.25f, .5f, 16, .5f).setTextured(false).setColor(RGB.GREEN.copy());
	public static final ModelRendererTurbo centermarker1 = new ModelRendererTurbo(null, 0, 0, 0, 0).addBox(-8, -0.25f, -0.25f, 16, .5f, .5f).setTextured(false).setColor(RGB.RED.copy());
	public static final ModelRendererTurbo centermarker2 = new ModelRendererTurbo(null, 0, 0, 0, 0).addBox(-0.25f, -0.25f, -8, .5f, .5f, 16).setTextured(false).setColor(RGB.BLUE.copy());
	public static ModelGroup group0, center, arm_left, arm_right;
	public static ModelRendererTurbo chest, leg, reg, br, bl;

	static{
		group0 = new ModelGroup("group0");
		group0.add(new ModelRendererTurbo(group0, -1, -1, 16, 16).newCylinderBuilder()
			.setPosition(0, 0, 0).setRadius(6, 5).setLength(3).setSegments(8, 0).setScale(1, 1).setDirection(4)
			.setRadialTexture(3, 1).setTopOffset(null).setTopRotation(new net.fexcraft.lib.common.math.Vec3f(0.0, 0.0, 0.0)).build()
			.setRotationPoint(0, -5, 0).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, 16, 16)
			.addShapeBox(0, 0, 0, 5, 0.5f, 10, 0, 0, 0, -0.1f, 0, 0, -0.6f, 0, 0, -0.6f, 0, 0, -0.1f, 0, 0, 0, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0)
			.setRotationPoint(2, -2.5f, -5).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, 16, 16).addCylinder(0, 0, 0, 6, 1, 8, 0.8f, 1, 4, null)
			.setRotationPoint(0, -6, 0).setRotationAngle(0, 0, 0)
		);
		group0.add(new ModelRendererTurbo(group0, -1, -1, 16, 16)
			.addShapeBox(0, 0, 0, 1, 0.5f, 9, 0, 0, 0, -0.1f, -0.1f, 0, -1.5f, -0.1f, 0, -1.5f, 0, 0, -0.1f, 0, 0, 0, 0, 0, -1.4f, 0, 0, -1.4f, 0, 0, 0)
			.setRotationPoint(7, -2.5f, -4.5f).setRotationAngle(0, 0, 0)
		);
		group0.translate(0, -4, 0, false);
		//
		arm_left = new ModelGroup("arm_left");
		arm_left.add(new ModelRendererTurbo(arm_left, -1, -1, 16, 16).addBox(-0.1f, 0, -0.1f, 4.2f, 10, 4.2f)
			.setRotationPoint(-2, -24, 4).setRotationAngle(0, 0, 0).setName("arm_left")
		);
		arm_left.add(new ModelRendererTurbo(arm_left, -1, -1, 16, 16)
			.addShapeBox(-0.1f, 0, -0.1f, 4.2f, 0.2f, 4.2f, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -24.2f, 4).setRotationAngle(0, 0, 0).setName("arm_leftcp")
		);
		arm_left.translate(0, 22, -5, false);
		//
		arm_right = new ModelGroup("arm_right");
		arm_right.add(new ModelRendererTurbo(arm_right, -1, -1, 16, 16).addBox(-0.1f, 0, -0.1f, 4.2f, 10, 4.2f)
			.setRotationPoint(-2, -24, -8).setRotationAngle(0, 0, 0).setName("arm_right")
		);
		arm_right.add(new ModelRendererTurbo(arm_right, -1, -1, 16, 16)
			.addShapeBox(-0.1f, 0, -0.1f, 4.2f, 0.2f, 4.2f, 0, -0.5f, 0, -0.5f, -0.5f, 0, -0.5f, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-2, -24.2f, -8).setRotationAngle(0, 0, 0).setName("arm_rightcp")
		);
		arm_right.translate(0, 22, +5, false);
		//
		chest = new ModelRendererTurbo(null, -1, -1, 16, 16).addBox(-0.1f, 0, -0.1f, 4.2f, 12, 8.2f).setRotationPoint(-2, 0, -4).setName("chest");
		leg = new ModelRendererTurbo(null, -1, -1, 16, 16).addBox(-2.1f, 0, -2, 4.2f, 10, 4.1f).setRotationPoint(0, 0, 0).setName("leg_left");
		reg = new ModelRendererTurbo(null, -1, -1, 16, 16).addBox(-2.1f, 0, -2.1f, 4.2f, 10, 4.1f).setRotationPoint(0, 0, 0).setName("leg_right");
		bl = new ModelRendererTurbo(null, -1, -1, 16, 16).addBox(-2.1f, 0, -2, 5, 2, 4.1f).setRotationPoint(0, 10, 0).setName("boot_left");
		br = new ModelRendererTurbo(null, -1, -1, 16, 16).addBox(-2.1f, 0, -2.1f, 5, 2, 4.1f).setRotationPoint(0, 10, 0).setName("boot_right");
		//
		center = new ModelGroup("center");
		center.add(centermarker0);
		center.add(centermarker1);
		center.add(centermarker2);
	}

}
