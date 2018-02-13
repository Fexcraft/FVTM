package net.fexcraft.mod.fvtm.render.item;

import java.util.Collections;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CustomModelOverrideList extends ItemOverrideList {
	
	public static final CustomModelOverrideList INSTANCE = new CustomModelOverrideList();

	private CustomModelOverrideList(){
		super(Collections.emptyList());
	}

	@Override
	public IBakedModel handleItemState(IBakedModel originalModel, ItemStack stack, World world, EntityLivingBase entity){
		CustomItemModelLoader.BakedIconBasedModel bakedModel = ((CustomItemModelLoader.BakedIconBasedModel) originalModel);
		CustomItemModelLoader.OverrideModelState state = bakedModel.getState();
		state.setStack(stack);
		state.setEntity(entity);
		//state.setWorld(world);
		return originalModel;
	}

}