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
    public static final ModelRendererTurbo SEAT_CUBE = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-0.5f, 0, -0.5f, 1, 1, 1).setLines(new RGB(0xeb8500));

}
