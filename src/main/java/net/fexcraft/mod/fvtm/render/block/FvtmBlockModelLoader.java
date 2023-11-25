package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.model.BlockModel;
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
	protected static final TreeMap<ResourceLocation, ModelImpl> MODELS = new TreeMap<>();

	@Override
	public void onResourceManagerReload(IResourceManager resourcemanager){
		MODELS.clear();
		BakedModelImpl.clear();
	}

	@Override
	public boolean accepts(ResourceLocation rl){
		Block block = FvtmRegistry.BLOCKS.get(getBlockIdFromResLoc(rl));
		if(block.getModel() instanceof BlockModel == false){
			Print.log("ERROR --- BLOCK MODEL IS NOT A BLOCK MODEL --- " + block.getIDS());
			return false;
		}
		return ((BlockModel)block.getModel()).bake;
	}

	protected String getBlockIdFromResLoc(ResourceLocation rl){
		return rl.getNamespace() + ":" + rl.getPath().substring(rl.getPath().lastIndexOf("/") + 1);
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