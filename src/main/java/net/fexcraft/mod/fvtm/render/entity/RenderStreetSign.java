package net.fexcraft.mod.fvtm.render.entity;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.entities.StreetSignEntity;
import net.fexcraft.mod.fvtm.model.block.StreetSignModel;
import net.fexcraft.mod.fvtm.render.Renderer;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStreetSign extends Render<StreetSignEntity> implements IRenderFactory<StreetSignEntity> {

    public RenderStreetSign(RenderManager renderManager){
        super(renderManager);
        shadowSize = 0.5F;
    }

    public void bindTexture(ResourceLocation rs){
        ModelBase.bindTexture(rs);
    }
    
    private static final StreetSignModel model = new StreetSignModel();

    @Override
    public void doRender(StreetSignEntity entity, double x, double y, double z, float entity_yaw, float ticks){
        GL11.glPushMatrix();
        {
        	float rot = 60;
        	//float xo = 0, zo = 0;
        	switch(entity.facing.getIndex()){
	        	case 2:{
	        		rot = 0;
	        		break;
	        	}
	        	case 3:{
	        		rot = 180;
	        		break;
	        	}
	        	case 4:{
	        		rot = 90;
	        		break;
	        	}
	        	case 5:{
	        		rot = 270;
	        		break;
	        	}
        	}
        	GL11.glTranslated(x, y, z);
            GL11.glRotatef(rot, 0f, 1f, 0f);
            GL11.glPushMatrix();
            this.bindTexture(this.getEntityTexture(entity));
            model.render();
            //
            GL11.glPopMatrix();
        	GL11.glTranslated(0, 1.25, -0.26);
            for(int i = 0; i < 4; i++){
            	GL11.glTranslated(0, -0.25, 0);
            	if(entity.text[i] == null || entity.text[i].equals("")){ continue; }
            	Renderer.drawString(entity.text[i], 0, -0.05, 0, 0, 0, 0, false, 0.8f, entity.texture > 1 ? 0xffffff : 0);
            }
        }
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(StreetSignEntity entity){
        return entity.getSelectedTexture();
    }
    
    @Override
    public Render<StreetSignEntity> createRenderFor(RenderManager manager){
        return new RenderStreetSign(manager);
    }

}
