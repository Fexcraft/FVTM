package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.container.ContainerType;

public class DebugModels {
	
	public static ModelRendererTurbo[] CONTAINER = {
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(- 8.1f, -48.1f, -24.1f,  16.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-16.1f, -48.1f, -24.1f,  32.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-24.1f, -48.1f, -24.1f,  48.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-48.1f, -48.1f, -24.1f,  96.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0),
		new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-96.1f, -48.1f, -24.1f, 192.2f, 48.2f, 48.2f).setRotationPoint(0, 0, 0)
	};
	static{
		for(int i = 0; i < ContainerType.values().length; i++){
			RGB rgb = new RGB(ContainerType.values()[i].getRGB().packed * 2);
			CONTAINER[i].setTextured(false).setColor(rgb);
		}
	}
    public static final ModelRendererTurbo CENTERSPHERE = new ModelRendererTurbo(null, 0, 0, 16, 16).addSphere(0, 0, 0, 1, 16, 16, 8, 8).setLines(new RGB(0xcdcdcd));
    public static final ModelRendererTurbo HOTINSTALLCUBE = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0x00ffff));
    public static final ModelRendererTurbo ATTRBOXCUBE = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, -0.5f, -0.5f, 1, 1, 1).setLines(new RGB(0x1d8228/*ffbb00*/));
    public static final ModelRendererTurbo SEAT_CUBE_SITTING = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0xeb8500));
    public static final ModelRendererTurbo SEAT_CUBE_STANDING = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0xcbcf00));
    public static final ModelRendererTurbo SEAT_CUBE_OCCUPIED = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0x619900));
    
    public static TurboList group0;
    static {
		group0 = new TurboList("group0");
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
		group0.translate(0, 4, 0);
    }

}
