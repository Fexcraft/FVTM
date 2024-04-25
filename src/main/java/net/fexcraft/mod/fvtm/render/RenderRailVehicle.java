package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.Config.RENDER_VEHICLES_SEPARATELY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderRailVehicle extends Render<RailVehicle> implements IRenderFactory<RailVehicle> {

    public RenderRailVehicle(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    public void bindTexture(RailVehicle ent){
        TexUtil.bindTexture(this.getEntityTexture(ent));
    }

    public void bindTexture(ResourceLocation rs){
        TexUtil.bindTexture(rs);
    }
    
    //private static final ModelRendererTurbo turbo = new ModelRendererTurbo(null, 0, 0, 16, 16).addBox(-2, -2, -2, 4, 4, 4);

    @Override
    public void doRender(RailVehicle vehicle, double x, double y, double z, float entity_yaw, float ticks){
        if(RENDER_VEHICLES_SEPARATELY || vehicle.getVehicleData() == null){ return; }
        GL11.glPushMatrix();
        {
        	SeparateRenderCache.SORTED_VEH_POS.put(vehicle.getEntityId(), new double[]{ x, y, z });
            GL11.glTranslated(x, y, z);
            GL11.glPushMatrix();
            V3D rot = EffectRenderer.getRotations(vehicle.rotpoint, ticks);
            GL11.glRotated(rot.x, 0.0F, 1.0F, 0.0F);
            GL11.glRotated(rot.y, 0.0F, 0.0F, 1.0F);
            GL11.glRotated(rot.z, 1.0F, 0.0F, 0.0F);
            SeparateRenderCache.SORTED_VEH_ROT.put(vehicle.getEntityId(), rot);
            GL11.glPushMatrix();
            RenderCache cache = vehicle.getCapability(Capabilities.RENDERCACHE, null);
			{
				Model modVehicle = vehicle.getVehicleData().getType().getModel();
				if(modVehicle != null){
					GL11.glPushMatrix();
					GL11.glRotatef(180f, 0f, 0f, 1f);
					TexUtil.bindTexture(vehicle.getVehicleData().getCurrentTexture());
					modVehicle.render(RENDERDATA.set(vehicle.getVehicleData(), null/*vehicle*/, cache, false, ticks));
					GL11.glPopMatrix();
				}
				else {
					TexUtil.bindTexture(vehicle.getVehicleData().getCurrentTexture());
					DebugModels.CENTERSPHERE.render(1);
				}
				if(vehicle.getVehicleData().getParts().size() > 0){
					VehicleRenderer.renderPoint(vehicle.getRotPoint(), null/*vehicle*/, vehicle.getVehicleData(), cache, ticks);
				}
			}
            //EffectRenderer.renderHotInstallInfo(vehicle);
            GL11.glPopMatrix();
            //
            GL11.glPopMatrix();
            //EffectRenderer.renderToggableInfo(vehicle);
            EffectRenderer.renderContainerInfo(vehicle, rot);
            EffectRenderer.renderSeats(vehicle);
        }
        GL11.glPopMatrix();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(RailVehicle entity){
        return entity.getVehicleData().getCurrentTexture().local();
    }
    
    @Override
    public Render<RailVehicle> createRenderFor(RenderManager manager){
        return new RenderRailVehicle(manager);
    }

}
