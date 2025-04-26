package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

import java.util.*;

/**
 * Based on the loader in FCL.
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmBlockModelLoader implements ICustomModelLoader {

	protected static final FvtmBlockModelLoader INSTANCE = new FvtmBlockModelLoader();
	protected static final Map<ResourceLocation, ModelImpl> MODELS = new HashMap<>();
	public static final Map<String, Block> BLOCKS = new HashMap<>();

	@Override
	public void onResourceManagerReload(IResourceManager resourcemanager){
		MODELS.clear();
		BakedModelImpl.clear();
		FvtmResources.reloadModels();
	}

	@Override
	public boolean accepts(ResourceLocation rl){
		String str = rl.toString();
		if(!str.contains("/") && !str.endsWith("#inventory")){
			return BLOCKS.containsKey(str.split("#")[0]);
		}
		return BLOCKS.containsKey(str);
	}

	@Override
	public IModel loadModel(ResourceLocation rl) throws Exception {
		return new ModelImpl(rl);
	}

    @Override
    public String toString(){
        return "[FVTM BLOCK MODEL LOADER]";
    }

	public static FvtmBlockModelLoader getInstance(){
		return INSTANCE;
	}

}