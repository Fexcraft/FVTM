package net.fexcraft.mod.fvtm.compatibility.trainsmod;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderTrainsModGeneric extends Render<TrainsModEntityConverter> implements IRenderFactory<TrainsModEntityConverter> {
	
	public RenderTrainsModGeneric(RenderManager rm){ super(rm);	}
		
	public void doRender(TrainsModEntityConverter entity, double x, double y, double z, float entityYaw, float partialTicks){
	    GlStateManager.pushMatrix();
	    float yaw  = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks;
	    double xDif = entity.posX - x;
	    double yDif = entity.posY - y;
	    double zDif = entity.posZ - z;
	    x = entity.getTrainPosX() - xDif;
	    y = entity.getTrainPosY() - yDif;
	    z = entity.getTrainPosZ() - zDif;
	    GlStateManager.translate(x, y + 0.375F, z);
	    GlStateManager.rotate(90 - yaw, 0.0F, 1.0F, 0.0F);
	    //this.bindEntityTexture(entity);
	    if(entity.data != null && entity.data.getVehicle().getModel() != null){
	    	GL11.glRotatef(180, 0, 0, 1);
            ModelBase.bindTexture(entity.data.getTexture());
            entity.data.getVehicle().getModel().render(entity.data, null, null, -1);
            if(entity.data.getParts().size() > 0){
            	for(java.util.Map.Entry<String, PartData> entry : entity.data.getParts().entrySet()){
                	ModelBase.bindTexture(entry.getValue().getTexture());
                    Pos pos = entry.getValue().getPart().getOffsetFor(entity.data.getVehicle().getRegistryName());
                    pos.translate();
                    entry.getValue().getPart().getModel().render(entity.data, entry.getKey(), null, -1);
                    for(Attribute attr : entry.getValue().getPart().getAttributes()) if(attr.hasRenderData()){ attr.render(null, entry.getValue(), entry.getKey()); };
                    pos.translateR();
            	}
            }
	    }
	    GlStateManager.popMatrix();
	    
	    entity.lastPartialTick = partialTicks;
	    super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(TrainsModEntityConverter entity){
		return entity.data == null ? Resources.NULL_TEXTURE : entity.data.getTexture();
	}
	
	@Override
	public Render<? super TrainsModEntityConverter> createRenderFor(RenderManager rm){
		return new RenderTrainsModGeneric(rm);
	}

}