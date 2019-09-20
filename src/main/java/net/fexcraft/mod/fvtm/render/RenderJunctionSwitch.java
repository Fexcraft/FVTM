package net.fexcraft.mod.fvtm.render;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.entity.JunctionSwitchEntity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderJunctionSwitch extends Render<JunctionSwitchEntity> implements IRenderFactory<JunctionSwitchEntity> {

    public RenderJunctionSwitch(RenderManager renderManager){
        super(renderManager); shadowSize = 0.125F;
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }

    @Override
    public void doRender(JunctionSwitchEntity entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	float rot = 60;
        	switch(entity.junction.entityFacing.getIndex()){
	        	case 2:{ rot = 180; break; }
	        	case 3:{ rot = 0; break; }
	        	case 4:{ rot = 270; break; }
	        	case 5:{ rot = 90; break; }
        	}
        	GL11.glTranslated(x, y, z);
            GL11.glRotatef(180, 1f, 0f, 0f);
            GL11.glRotatef(rot, 0f, 1f, 0f);
            GL11.glPushMatrix();
            this.bindTexture(this.getEntityTexture(entity));
            entity.junction.tracks.get(0).gauge.getModel().renderSwitch(entity, entity.junction);
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(JunctionSwitchEntity entity){
        return entity.junction.tracks.get(0).gauge.getTexture();
    }
    
    @Override
    public Render<JunctionSwitchEntity> createRenderFor(RenderManager manager){
        return new RenderJunctionSwitch(manager);
    }

}
