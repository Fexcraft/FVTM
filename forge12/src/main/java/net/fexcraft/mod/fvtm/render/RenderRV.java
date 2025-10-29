package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.Config.RENDER_VEHICLES_SEPARATELY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.EffectRenderer.drawString;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.SEP_VEH_CACHE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RenderRV extends Render<RootVehicle> implements IRenderFactory<RootVehicle> {

	private SeparateRenderCache.SepVehCache sepcache;

    public RenderRV(RenderManager renderManager){
        super(renderManager); shadowSize = 0.5F;
    }

    @Override
    public void doRender(RootVehicle rv, double x, double y, double z, float entity_yaw, float ticks){
        if(RENDER_VEHICLES_SEPARATELY || rv.vehicle.data == null || rv.vehicle.point == null) return;
		if(rv.vehicle.cache == null) rv.vehicle.cache = rv.getCapability(Capabilities.RENDERCACHE, null);
		sepcache = rv.vehicle.cache.get(SEP_VEH_CACHE, data -> new SeparateRenderCache.SepVehCache());
        GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		V3D rot = EffectRenderer.getRotations(rv, ticks);
		GL11.glRotated(-rot.x, 0.0F, 1.0F, 0.0F);
		GL11.glRotated(rot.y, 1.0F, 0.0F, 0.0F);
		GL11.glRotated(rot.z, 0.0F, 0.0F, 1.0F);
		sepcache.set(x, y, z, rot);
		if(Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
			RootVehicle veh = Static.getServer().isSinglePlayer() ? (RootVehicle)Static.getServer().getWorld(rv.dimension).getEntityByID(rv.getEntityId()) : rv;
			if(veh == null) veh = rv;
			GL11.glPushMatrix();
			TexUtil.bindTexture(rv.vehicle.data.getCurrentTexture());
			GL11.glTranslatef(0, 2, 0);
			drawString(veh.vehicle.pivot().deg_yaw() + "", 0, 0, 0, true, true, 0.8f, 0x000000, null);
			GL11.glTranslatef(0, 0.2f, 0);
			drawString(veh.vehicle.pivot().deg_pitch() + "", 0, 0, 0, true, true, 0.8f, 0x000000, null);
			GL11.glTranslatef(0, 0.2f, 0);
			drawString(veh.vehicle.pivot().deg_roll() + "", 0, 0, 0, true, true, 0.8f, 0x000000, null);
			GL11.glPopMatrix();
		}
		GL11.glPushMatrix();
		Model vehmod = rv.vehicle.data.getType().getModel();
		if(vehmod != null){
			GL11.glPushMatrix();
			TexUtil.bindTexture(rv.vehicle.data.getCurrentTexture());
			vehmod.render(RENDERDATA.set(rv.vehicle, ticks).rc(rv.vehicle.cache));
			GL11.glPopMatrix();
		}
		else{
			DebugUtils.renderBB(0.5f, RGB.RED.packed);
		}
		EffectRenderer.renderVehicleInfo(rv.vehicle, rv.vehicle.entity.getPos(), rv.vehicle.data);
		GL11.glPopMatrix();
		if(rv.vehicle.data.getParts().size() > 0){
			VehicleRenderer.renderPoint(rv.vehicle.point, rv, rv.vehicle.data, rv.vehicle.cache, ticks);
		}
		//
		EffectRenderer.renderToggableInfo(rv, rv.vehicle.data);
		//EffectRenderer.renderContainerInfo(rv, rot);
		EffectRenderer.renderSeatsAndInvs(rv.vehicle);
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
