package net.fexcraft.mod.fvtm.util;

import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakingPlugin implements ModelLoadingPlugin {

	@Override
	public void initialize(Context context){
		for(Block block : FvtmRegistry.BLOCKS){
			if(!block.getBlockType().isRoadLayer()) continue;
			ItemBlockRenderTypes.TYPE_BY_BLOCK.put(block.getBlock(), ChunkSectionLayer.CUTOUT);
			context.registerBlockStateResolver(block.getBlock(), ctx -> {
				net.minecraft.world.level.block.Block blk = block.getBlock();
				blk.getStateDefinition().getPossibleStates().forEach(state -> {
					ctx.setModel(state, new RoadLinesModel.UnbakedLines(block));
				});
			});
		}
	}

}
