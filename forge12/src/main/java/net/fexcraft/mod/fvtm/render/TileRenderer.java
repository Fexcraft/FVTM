package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCKS_SEPARATELY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

public class TileRenderer {

	private static final ArrayList<TileEntity> entities = new ArrayList<>();
	private static AxisAlignedBB box;

	public static void renderBlocks(World world, double cx, double cy, double cz, float ticks){
		if(!RENDER_BLOCKS_SEPARATELY) return;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		entities.clear();
		entities.addAll(world.loadedTileEntityList);
		for(TileEntity entity : entities){
			if(entity instanceof BlockTileEntity == false) continue;
			BlockTileEntity tile = (BlockTileEntity)entity;
			box = tile.getBlockData().getType().getAABB("render", "").get(0);
			if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(box.offset(tile.getPos()))) continue;
			//
			SeparateRenderCache.SORTED_BLK_ENTITY.add(tile);
			SeparateRenderCache.SORTED_BLK_DATA.add(tile.getBlockData());
			GL11.glPushMatrix();
			GL11.glTranslated(tile.getPos().getX() - cx + 0.5, tile.getPos().getY() - cy, tile.getPos().getZ() - cz + 0.5);
			//
			float i = getBrightness(tile.getPos()), j = i % 65536f, k = i / 65536f;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j, k);
			//
			RenderCache cache = tile.getCapability(Capabilities.RENDERCACHE, null);
			Model modVehicle = tile.getBlockData().getType().getModel();
			if(modVehicle != null){
				GL11.glPushMatrix();
				TexUtil.bindTexture(tile.getBlockData().getCurrentTexture());
				modVehicle.render(RENDERDATA.set(tile.getBlockData(), null, null).rc(cache));
				GL11.glPopMatrix();
			}
			else{
				TexUtil.bindTexture(tile.getBlockData().getCurrentTexture());
				DebugUtils.SPHERE.render();
			}
			//
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	@Deprecated
	public static int getBrightness(BlockPos pos){
		if(Minecraft.getMinecraft().world.isBlockLoaded(pos)){
			return Minecraft.getMinecraft().world.getCombinedLight(pos, 0);
		}
		else return 0;
	}

}
