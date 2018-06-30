package net.fexcraft.mod.fmt.various;

import net.fexcraft.mod.fmt.FMT;
import net.fexcraft.mod.lib.tmt.util.TMTItemModel;
import net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

//@fItem(modid = FMT.MODID, name = "modelitem")
public class ModelItem extends Item {
	
	public ModelItem(){
		this.setCreativeTab(CreativeTabs.TOOLS);
		TMTItemModelLoader.addItemModel(new ResourceLocation(FMT.MODID, "modelitem"), new ModelImpl());
	}
	
	public static class ModelImpl implements TMTItemModel {

		@Override
		public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
			// TODO Auto-generated method stub
			
		}
		
	}
	
}