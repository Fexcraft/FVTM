package net.fexcraft.mod.fvtm.util;

public class BakedModelLoader {
	
	public static void register(){
		net.minecraftforge.client.model.ModelLoaderRegistry.registerLoader(net.fexcraft.mod.fvtm.render.block.FvtmBlockModelLoader.getInstance());
	}

}
