package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.render.VehicleRenderer;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class TextureEditorImpl extends TextureEditor  {

	private VehicleData vehicle;

	public TextureEditorImpl(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
		vehicle = new VehicleData(FvtmRegistry.VEHICLES.get("fvp:c13"));
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		super.postdraw(ticks, mx, my);
		GL11.glPushMatrix();
		GL11.glTranslated(gLeft + 128 + cam_pos.x, gTop + 128 + cam_pos.y, cam_pos.z);
		GL11.glRotated(cam_rot.y, 0, 1, 0);
		GL11.glRotated(cam_rot.x, 1, 0, 0);
		GL11.glRotated(cam_rot.z, 0, 0, 1);
		GL11.glScaled(-32 * cam_scl.x, -32 * cam_scl.y, -32 * cam_scl.z);
		RGB.glColorReset();
		TexUtil.bindTexture(vehicle.getCurrentTexture());
		vehicle.getType().getModel().render(vehicle.renderdata().update(null, ticks));
		VehicleRenderer.renderPoint(vehicle.getRotationPoint("vehicle"), null, vehicle, ticks);
		GL11.glPopMatrix();
	}

}
