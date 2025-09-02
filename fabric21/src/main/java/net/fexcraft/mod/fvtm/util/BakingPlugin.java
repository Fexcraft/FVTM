package net.fexcraft.mod.fvtm.util;

import net.fabricmc.fabric.api.client.model.loading.v1.BlockStateResolver;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakingPlugin implements ModelLoadingPlugin {

	@Override
	public void initialize(Context context){
		for(Block block : FvtmRegistry.BLOCKS){
			if(!block.getBlockType().isRoadLayer()) continue;
			context.registerBlockStateResolver(block.getBlock(), new BlockStateResolver() {
				@Override
				public void resolveBlockStates(Context context){
					context.setModel(context.block().defaultBlockState(), new RoadLinesModel.UnbakedLines());
				}
			});
		}
	}

}
