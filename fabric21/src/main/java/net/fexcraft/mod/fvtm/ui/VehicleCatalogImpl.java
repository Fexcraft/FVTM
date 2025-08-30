package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleCatalog;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import static net.fexcraft.mod.fvtm.render.Renderer21.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleCatalogImpl extends VehicleCatalog {

	private EntityRenderer<? super RootVehicle, ?> renderer;
	private RootVehicle rv;

    public VehicleCatalogImpl(JsonMap map, ContainerInterface container) throws Exception{
        super(map, container);
		EntityRenderDispatcher dis = Minecraft.getInstance().getEntityRenderDispatcher();
		rv = new RootVehicle(Resources21.VEHICLE_ENTITY, Minecraft.getInstance().level);
		renderer = dis.getRenderer(rv);
    }

    @Override
    public void postdraw(float ticks, int mx, int my){
        super.postdraw(ticks, mx, my);
		if(data == null) return;
		rv.initVD(data);
        GuiGraphics gg = root.matrix();
		gg.enableScissor(gLeft + 7, gTop + 23, gLeft + 127, gTop + 103);
		Quaternionf qua = new Quaternionf()
			.rotateAxis((float)Math.atan((mx - gLeft - 67) / 40f), AY)
			.rotateAxis((float)-Math.atan((my - gTop - 63) / 40f), AX)
			.rotateAxis(Static.rad180, AZ);
		gg.submitEntityRenderState(renderer.createRenderState(rv, 1f), preset.scale * 16, new Vector3f(), qua, null, gLeft + 7, gTop + 23, gLeft + 127, gTop + 103);
		gg.disableScissor();
    }

}