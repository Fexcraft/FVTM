package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;

public abstract class CrafterBlockScriptBase implements BlockScript {

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		//TODO
		return compound;
	}

	@Override
	public BlockScript readFromNBT(NBTTagCompound compound){
		//TODO
		return this;
	}

	@Override
	public void onDataPacket(TileEntity tile, BlockData data, NBTTagCompound compound, Side side){
		//
	}

	@Override
	public boolean onInteract(TileEntity tile, BlockData data, EntityPlayer player, EnumHand hand){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onUpdate(TileEntity tile, BlockData data){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGuiRender(TileEntity tile, EntityPlayer player, GuiContainer container){
		//
	}
	
}