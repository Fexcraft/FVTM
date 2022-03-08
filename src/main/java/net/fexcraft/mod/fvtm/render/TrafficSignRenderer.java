package net.fexcraft.mod.fvtm.render;

import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSigns;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class TrafficSignRenderer {
	
	//private static TrafficSignLibrary lib;
    
    public static void renderTrafficSigns(World world, double cx, double cy, double cz, float partialticks){
	    //lib = SystemManager.get(Systems.TRAFFICSIGN, world, TrafficSignLibrary.class);
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-cx, -cy, -cz);
    	ModelBase.bindTexture(Resources.WHITE_TEXTURE);
        for(Chunk chunk : TrafficSignLibrary.CHUNKS){
        	TrafficSigns cap = chunk.getCapability(Capabilities.TRAFFIC_SIGNS, null);
        	if(cap == null) continue;
        	for(Entry<BlockPos, TrafficSignData> entry : cap.getSigns().entrySet()){
        		if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(entry.getValue().getBB())) continue;
                //if(entry.getValue().entity == null) continue;
                if(entry.getValue().isEmpty()) continue;
            	GL11.glPushMatrix();
            	GL11.glTranslatef(entry.getKey().getX() + 0.5f, entry.getKey().getY() + 0.5f, entry.getKey().getZ() + 0.5f);
                GlStateManager.rotate(180, 0, 1, 0);
                GlStateManager.rotate(180, 0, 0, 1);
                if(entry.getValue().isEmpty()) DebugModels.TRAFFICSIGNCUBE.render(0.5f);
                else entry.getValue().render(world, true, partialticks);
            	GL11.glPopMatrix();
        	}
        }
		GL11.glPopMatrix();
    }

}
