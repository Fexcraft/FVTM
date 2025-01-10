package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.render.VehicleRenderer;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleCatalog;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleCatalogImpl extends VehicleCatalog  {

	public VehicleCatalogImpl(JsonMap map, ContainerInterface container) throws Exception{
		super(map, container);
	}

	@Override
	public void postdraw(float ticks, int mx, int my){
		super.postdraw(ticks, mx, my);
        RenderHelper.enableStandardItemLighting();
		GL11.glPushMatrix();
		GL11.glTranslated(gLeft + 67, gTop + 63, 100);
		GL11.glRotated(Math.atan((mx - gLeft - 67) / 40f) * 20, 0, 1, 0);
		GL11.glRotated(-Math.atan((my - gTop - 63) / 40f) * 15, 1, 0, 0);
		GL11.glScalef(-preset.scale * 16, -preset.scale * 16, -preset.scale * 16);
		RGB.glColorReset();
		GlStateManager.disableLighting();
		TexUtil.bindTexture(data.getCurrentTexture());
		veh.getModel().render(DefaultModel.RENDERDATA.set(data, null, null, null, null, false, ticks));
		VehicleRenderer.renderPoint(data.getRotationPoint("vehicle"), null, data, null, ticks);
		GL11.glPopMatrix();
	}

}
