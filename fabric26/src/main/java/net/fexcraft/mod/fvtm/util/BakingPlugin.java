package net.fexcraft.mod.fvtm.util;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.EncodingFormat;
import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.MutableQuadViewImpl;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.client.resources.model.ModelDebugName;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakingPlugin implements ModelLoadingPlugin {

	public static ModelDebugName MDN = () -> "FVTM:MDN";

	@Override
	public void initialize(Context context){
		for(Block block : FvtmRegistry.BLOCKS){
			//ItemBlockRenderTypes.TYPE_BY_BLOCK.put(block.getBlock(), ChunkSectionLayer.CUTOUT);
			if(block.getBlockType().isRoadLayer()){
				context.registerBlockStateResolver(block.getBlock(), ctx -> {
					net.minecraft.world.level.block.Block blk = block.getBlock();
					blk.getStateDefinition().getPossibleStates().forEach(state -> {
						ctx.setModel(state, new RoadLinesModel.UnbakedLines(block));
					});
				});
			}
			else if(block.getModelData().getBoolean("Baked", false)){
				context.registerBlockStateResolver(block.getBlock(), ctx -> {
					net.minecraft.world.level.block.Block blk = block.getBlock();
					blk.getStateDefinition().getPossibleStates().forEach(state -> {
						ctx.setModel(state, new BakedBlockModel.UnbakedModel(block));
					});
				});
			}
		}
	}

	public static class MutableQuad extends MutableQuadViewImpl {

		public MutableQuad(){
			data = new int[EncodingFormat.TOTAL_STRIDE];
		}

		@Override
		protected void emitDirectly(){
			//
		}

	}

}
