package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.Config.RENDER_VEHICLES_SEPARATELY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderRV extends Render<RootVehicle> implements IRenderFactory<RootVehicle> {

    public RenderRV(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    @Override
    public void doRender(RootVehicle rv, double x, double y, double z, float entity_yaw, float ticks){
        if(RENDER_VEHICLES_SEPARATELY || rv.vehicle.data == null || rv.vehicle.point == null) return;
        GL11.glPushMatrix();
		SeparateRenderCache.SORTED_VEH_POS.put(rv.getEntityId(), new double[]{ x, y, z });
		GL11.glTranslated(x, y, z);
		V3D rot = EffectRenderer.getRotations(rv, ticks);
		GL11.glRotated(rot.x, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(rot.y, 0.0F, 0.0F, 1.0F);
		GL11.glRotated(rot.z, 1.0F, 0.0F, 0.0F);
		//TODO SeparateRenderCache.SORTED_VEH_ROT.put(vehicle.getEntityId(), rot);
		GL11.glPushMatrix();
		RenderCache cache = rv.getCapability(Capabilities.RENDERCACHE, null);
		Model vehmod = rv.vehicle.data.getType().getModel();
		if(vehmod != null){
			GL11.glPushMatrix();
			TexUtil.bindTexture(rv.vehicle.data.getCurrentTexture());
			vehmod.render(RENDERDATA.set(rv.vehicle.data, rv, cache, false));
			GL11.glPopMatrix();
		}
		else{
			TexUtil.bindTexture(rv.vehicle.data.getCurrentTexture());
			DebugModels.CENTERSPHERE.render(1);
		}
		if(rv.vehicle.data.getParts().size() > 0){
			VehicleRenderer.renderPoint(rv.vehicle.point, rv, rv.vehicle.data, cache, ticks);
		}
		EffectRenderer.renderHotInstallInfo(rv, rv.vehicle.data);
		GL11.glPopMatrix();
		//
		EffectRenderer.renderToggableInfo(rv, rv.vehicle.data);
		//EffectRenderer.renderContainerInfo(rv, rot);
		EffectRenderer.renderSeats(rv, rv.vehicle);
        GL11.glPopMatrix();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(RootVehicle entity){
        return entity.vehicle.data.getCurrentTexture().local();
    }
    
    @Override
    public Render<RootVehicle> createRenderFor(RenderManager manager){
        return new RenderRV(manager);
    }

}
