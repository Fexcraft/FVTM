package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCKS_SEPARATELY;

public class TileRenderer {

	private static final ArrayList<TileEntity> entities = new ArrayList<>();
	private static AxisAlignedBB box;

	public static void renderBlocks(World world, double cx, double cy, double cz, float ticks){
		//if(!RENDER_BLOCKS_SEPARATELY) return;
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		entities.clear();
		entities.addAll(world.loadedTileEntityList);
		BlockTileEntity tile;
		for(TileEntity entity : entities){
			if(entity instanceof BlockTileEntity == false) continue;
			tile = (BlockTileEntity)entity;
			if(!RENDER_BLOCKS_SEPARATELY && !tile.getBlockData().getType().getAABBs().containsKey("render")) continue;
			box = tile.getBlockData().getType().getAABB("render", "").get(0);
			if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(box.offset(tile.getPos()))) continue;
			//
			SeparateRenderCache.SORTED_BLK_ENTITY.add(tile);
			SeparateRenderCache.SORTED_BLK_DATA.add(tile.getBlockData());
			GL11.glPushMatrix();
			GL11.glTranslated(tile.getPos().getX() - cx + 0.5, tile.getPos().getY() - cy, tile.getPos().getZ() - cz + 0.5);
			GL11.glRotated(tile.getBlockData().getType().getBlockType().getRotationFor(tile.getBlockMetadata()), 0, 1, 0);
			//
			float i = getBrightness(tile.getPos()), j = i % 65536f, k = i / 65536f;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j, k);
			//
			RenderCache cache = tile.getCapability(Capabilities.RENDERCACHE, null);
			BlockModel model = (BlockModel)tile.getBlockData().getType().getModel();
			if(model != null){
				GL11.glPushMatrix();
				TexUtil.bindTexture(tile.getBlockData().getCurrentTexture());
				if(model.rootrender) model.render(BlockModel.RENDERDATA.set(tile.getBlockData(), tile, null).rc(cache));
				if(model.state_models.size() > 0){
					IBlockState state = tile.getWorld().getBlockState(tile.getPos());
					for(IProperty<?> prop : tile.getBlockType().getBlockState().getProperties()){
						String str = prop.getName() + "=" + state.getValue(prop);
						if(model.state_models.containsKey(str)){
							ArrayList<BlockModel> list = model.state_models.get(str);
							for(BlockModel statemodel : list){
								statemodel.render(BlockModel.RENDERDATA);
							}
						}
					}
				}
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
