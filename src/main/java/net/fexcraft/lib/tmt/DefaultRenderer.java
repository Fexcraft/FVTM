package net.fexcraft.lib.tmt;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.tmt.ModelRendererTurbo.Renderer;

public class DefaultRenderer extends Renderer {

	@Override
	public void render(ModelRendererTurbo mrt, float scale){
        if(mrt.glId == null || mrt.forcedRecompile){
            compile(mrt, scale);
        }
        if(mrt.rotationAngleX != 0.0F || mrt.rotationAngleY != 0.0F || mrt.rotationAngleZ != 0.0F){
            GL11.glPushMatrix();
            GL11.glTranslatef(mrt.rotationPointX * scale, mrt.rotationPointY * scale, mrt.rotationPointZ * scale);
            mrt.rotationOrder.rotate(mrt);
    		GL11.glCallList((Integer)mrt.glId);
            if(mrt.childModels != null){
                for(ModelRendererTurbo child : mrt.childModels) child.render(scale);
            }
            GL11.glPopMatrix();
        }
        else if(mrt.rotationPointX != 0.0F || mrt.rotationPointY != 0.0F || mrt.rotationPointZ != 0.0F){
            GL11.glTranslatef(mrt.rotationPointX * scale, mrt.rotationPointY * scale, mrt.rotationPointZ * scale);
    		GL11.glCallList((Integer)mrt.glId);
            if(mrt.childModels != null){
                for(ModelRendererTurbo child : mrt.childModels) child.render(scale);
            }
            GL11.glTranslatef(-mrt.rotationPointX * scale, -mrt.rotationPointY * scale, -mrt.rotationPointZ * scale);
        }
        else{
    		GL11.glCallList((Integer)mrt.glId);
        	if(mrt.childModels != null){
                for(ModelRendererTurbo child : mrt.childModels) child.render(scale);
            }
        }
	}
	
    private void compile(ModelRendererTurbo mrt, float scale){
        mrt.glId = GL11.glGenLists(1);
        GL11.glNewList((Integer)mrt.glId, 4864 /*GL_COMPILE*/);
        if(mrt.textured){
        	for(TexturedPolygon poly : mrt.getFaces()) poly.draw(scale, mrt.linesColor, null);
        }
        else{
            for(int i = 0; i < mrt.getFaces().size(); i++){
                mrt.getFaces().get(i).draw(scale, mrt.linesColor, mrt.getColor(i));
            }
        }
        GL11.glEndList();
    }
	
}
