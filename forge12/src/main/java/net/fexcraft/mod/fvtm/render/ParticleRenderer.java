package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.entity.ParticleEntity;
import net.fexcraft.mod.fvtm.sys.uni.EntitySystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class ParticleRenderer {
	
	private static final ArrayList<ParticleEntity> ents = new ArrayList<>();

	public static void renderParticles(World world, double cx, double cy, double cz, float ticks){
        EntitySystem sys = SystemManager.get(Systems.ENTITY, WrapperHolder.getWorld(world));
        if(sys == null) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
		TexUtil.bindTexture(FvtmRegistry.WHITE_TEXTURE);
        ents.addAll(sys.particles);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        for(ParticleEntity part : ents){
        	if(part == null || part.pos == null) return;
	        int z = getBrightness(part.pos), x = z % 65536, y = z / 65536;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)x / 1.0F, (float)y / 1.0F);
            part.render(ticks, cx, cy, cz);
        }
        GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		ents.clear();
	}

	//@Deprecated
	public static int getBrightness(V3D vec){
		BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(vec.x), 0, MathHelper.floor(vec.z));
		if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
			mutblk.setY(MathHelper.floor(vec.y));
			return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
		}
		return 0;
	}

}
