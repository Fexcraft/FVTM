package net.fexcraft.mod.fvtm.data.impl;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerItem;
import net.fexcraft.mod.fvtm.data.inv.ItemStackHandler;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.fexcraft.mod.uni.impl.TagLWI;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;

public class InvHandlerItemImpl extends InvHandlerItem {

	public InvHandlerItemImpl(String filter, int cap, int min){
		super(filter, cap, min);
		stackhandler = new ItemStackHandler(this, min);
	}

	@Override
	public boolean canStacksStack(StackWrapper other, StackWrapper stack){
		return ItemHandlerHelper.canItemStacksStack(other.local(), stack.local());
	}

}
