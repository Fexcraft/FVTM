package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.program.BakedPrograms;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
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

	public static void registerTint(){
		IBlockColor ibc_g = (state, world, pos, t) -> {
			Biome bio = world.getBiome(pos);
			return bio.getGrassColorAtPos(pos);
		};
		IBlockColor ibc_f = (state, world, pos, t) -> {
			Biome bio = world.getBiome(pos);
			return bio.getFoliageColorAtPos(pos);
		};
		HashSet<Block> tint_g = new HashSet<>();
		HashSet<Block> tint_f = new HashSet<>();
		BakedPrograms.Tint tint;
		for(Block block : FvtmBlockModelLoader.BLOCKS.values()){
			Model model = block.getModel();
			if(model == null) return;
			for(ModelGroup group : model.getGroups()){
				tint = group.getProgram("fvtm:baked_tint");
				if(tint == null) continue;
				if(tint.grass) tint_g.add(block);
				else tint_f.add(block);
				break;
			}
		}
		for(Block block : tint_g){
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(ibc_g, (net.minecraft.block.Block)block.getBlock());
		}
		for(Block block : tint_f){
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(ibc_f, (net.minecraft.block.Block)block.getBlock());
		}
	}

}