package net.fexcraft.mod.fvtm.impl;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
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
		if(hand == EnumHand.OFF_HAND && (player.getHeldItemMainhand().isEmpty() || player.getHeldItemMainhand().getItem() instanceof ItemTool)){
			player.openGui(FVTM.getInstance(), GuiHandler.BLOCK_SCRIPTSGUI, tile.getWorld(), tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
			return true;
		}
		return false;
	}

	@Override
	public void onUpdate(TileEntity tile, BlockData data){
		//TODO
	}

	@Override
	public void onGuiRender(TileEntity tile, EntityPlayer player, GuiContainer container){
		//
	}
	
	public abstract String getOutput();
	
	public abstract String[] getInput();
	
	public abstract boolean coolingType();
	
	public abstract boolean consumeTick();
	
	/** Should return 3 booleans. **/
	public abstract boolean[] semiProducts();
	
	/** Current hard limit being 9 */
	public abstract int maxRecipeSize();
	
	///--- RECIPES ---///
	
	public static final TreeMap<String, List<Recipe>> RECIPES = new TreeMap<>();
	
	public static class Recipe {
		
		private ItemStack[] ingredients;
		private ItemStack[] subproducts;
		private ItemStack[] output;
		
		public Recipe(JsonObject obj){
			
		}
		
		public boolean canProduce(){
			//TODO
			return true;
		}
		
	}
	
}