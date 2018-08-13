package net.fexcraft.mod.addons.hcp;

import java.io.File;

import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class HeavyCargoPack extends HybridAddon {

    public HeavyCargoPack(File file){
		super(file);
	}
    
    public void onPreInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(this);
    }

    //@SubscribeEvent public void register(Register<Block> event){ /*//*/ }

}
