package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadLinesModelLoader implements ICustomModelLoader {

	public static RoadLinesModelLoader INSTANCE = new RoadLinesModelLoader();
	public static final Map<String, Block> BLOCKS = new HashMap<>();

	@Override
	public void onResourceManagerReload(IResourceManager resman){

	}

	@Override
	public boolean accepts(ResourceLocation loc){
		String str = loc.toString();
		if(!str.contains("/") && !str.endsWith("#inventory")){
			return BLOCKS.containsKey(str.split("#")[0]);
		}
		return BLOCKS.containsKey(str);
	}

	@Override
	public IModel loadModel(ResourceLocation loc) throws Exception{
		return null;
	}

}
