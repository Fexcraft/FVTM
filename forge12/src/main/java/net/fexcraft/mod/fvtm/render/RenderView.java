package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.entity.RenderViewEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderView extends Render<RenderViewEntity> implements IRenderFactory<RenderViewEntity> {

	public static Frustum FRUSTUM = new Frustum();

	public RenderView(RenderManager renderManager){
		super(renderManager);
		shadowSize = 0.5F;
	}

	@Override
	public void doRender(RenderViewEntity entity, double x, double y, double z, float entity_yaw, float ticks){
		if(entity.getPlayer() != Minecraft.getMinecraft().player) return;
		GL11.glPushMatrix();
		{
			Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
			double cx = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * ticks;
			double cy = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * ticks;
			double cz = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * ticks;
			FRUSTUM.setPosition(cx, cy, cz);
			RailRenderer.renderRails(entity.world, cx, cy, cz, ticks);
			RoadRenderer.renderRoads(entity.world, cx, cy, cz, ticks);
			VehicleRenderer.renderVehicles(entity.world, cx, cy, cz, ticks);
			DecorationRenderer.renderDecorations(entity.world, cx, cy, cz, ticks);
			TrafficSignRenderer.renderTrafficSigns(entity.world, cx, cy, cz, ticks);
			WireRenderer.renderWires(entity.world, cx, cy, cz, ticks);
			ParticleRenderer.renderParticles(entity.world, cx, cy, cz, ticks);
		}
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(RenderViewEntity entity){
		return FvtmRegistry.NULL_TEXTURE.local();
	}

	@Override
	public Render<RenderViewEntity> createRenderFor(RenderManager manager){
		return new RenderView(manager);
	}

}
