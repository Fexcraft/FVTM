package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.ui.vehicle.VehicleCatalog;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleCatalogImpl extends VehicleCatalog {

    public VehicleCatalogImpl(JsonMap map, ContainerInterface container) throws Exception{
        super(map, container);
    }

    @Override
    public void postdraw(float ticks, int mx, int my){
        super.postdraw(ticks, mx, my);
        /*GuiGraphics gg = root.matrix();
        gg.pose().pushPose();
        gg.pose().translate(gLeft + 67, gTop + 63, 50);
        gg.pose().mulPose((new Matrix4f()).scaling(-preset.scale * 16, -preset.scale * 16, -preset.scale * 16));
        gg.pose().mulPose(new Quaternionf()
            .rotateAxis((float)Math.atan((mx - gLeft - 67) / 40f), AY)
            .rotateAxis((float)-Math.atan((my - gTop - 63) / 40f), AX)
        );
        Lighting.setupForEntityInInventory();
        drawer.applyWhite();
        Renderer21.set(gg.pose(), gg.bufferSource, 15728880);
        FvtmRenderTypes.setCutout(data.getCurrentTexture());
        veh.getModel().render(DefaultModel.RENDERDATA.set(data, null, null, null, ticks));
        RVRenderer.renderPoint(gg.pose(), data.getRotationPoint("vehicle"), null, data, null, ticks);
        gg.flush();
        gg.pose().popPose();
        Lighting.setupFor3DItems();*/
    }

}