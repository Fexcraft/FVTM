package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerBlock;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.uni.EnvInfo;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Registerer12 {

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<net.minecraft.block.Block> event){
		event.getRegistry().register(ConstructorBlock.INSTANCE);
		event.getRegistry().register(ConstCenterBlock.INSTANCE);
		event.getRegistry().register(Asphalt.INSTANCE);
		event.getRegistry().register(ContainerBlock.INSTANCE);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<net.minecraft.item.Item> event){
		event.getRegistry().register(ConstructorBlock.ITEM);
		event.getRegistry().register(ConstCenterBlock.ITEM);
		event.getRegistry().register(Asphalt.ITEM);
		//
		event.getRegistry().register(RoadToolItem.INSTANCE = new RoadToolItem());
		event.getRegistry().register(ToolboxItem.INSTANCE = new ToolboxItem());
		event.getRegistry().register(DecorationItem.INSTANCE);
		if(EnvInfo.CLIENT){
			regModel(ConstructorBlock.ITEM);
			regModel(ConstCenterBlock.ITEM);
			regModel(Asphalt.ITEM, 16);
			//
			regModel(DecorationItem.INSTANCE);
			regModel(RoadToolItem.INSTANCE);
			regModel(ToolboxItem.INSTANCE, 3);
		}
	}

	private void regModel(Item item){
		net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	private void regModel(Item item, int vars){
		for(int v = 0; v < vars; v++){
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, v, new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(item.getRegistryName().toString() + "_" + v), "inventory"));
		}
	}

}
