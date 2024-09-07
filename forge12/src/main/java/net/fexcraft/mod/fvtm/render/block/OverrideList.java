package net.fexcraft.mod.fvtm.render.block;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;

class OverrideList extends ItemOverrideList {

    protected static final OverrideList INSTANCE = new OverrideList();

    private OverrideList() {
        super(Collections.emptyList());
    }

    @Override
    public IBakedModel handleItemState(IBakedModel bakedmodel, ItemStack stack, World world, EntityLivingBase entity){
        return bakedmodel;
    }

}
