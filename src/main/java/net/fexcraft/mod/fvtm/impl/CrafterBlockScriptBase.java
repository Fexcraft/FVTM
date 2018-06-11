package net.fexcraft.mod.fvtm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.RecipeObject;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public abstract class CrafterBlockScriptBase implements BlockScript {
	
	public CrafterBlockScriptBase(){
		validateRecipes();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setInteger("Script_Progress", progress);
		if(current_recipe != null){
			compound.setTag("Script_CurrentRecipe", current_recipe.save());
		}
		return compound;
	}

	@Override
	public BlockScript readFromNBT(NBTTagCompound compound){
		progress = compound.getInteger("Script_Progress");
		if(compound.hasKey("Script_CurrentRecipe")){
			current_recipe = Recipe.fromSave(compound.getCompoundTag("Script_CurrentRecipe"));
		}
		return this;
	}

	@Override
	public boolean onInteract(TileEntity tile, BlockData data, EntityPlayer player, EnumHand hand){
		if(hand == EnumHand.MAIN_HAND && (player.getHeldItemMainhand().isEmpty() || player.getHeldItemMainhand().getItem() instanceof ItemTool)){
			player.openGui(FVTM.getInstance(), GuiHandler.BLOCK_CRAFTERSCRIPT, tile.getWorld(), tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
			return true;
		}
		return false;
	}
	
	/** Return number between 0 and 100, inclusive. **/
	public abstract int getProgressPercentage();
	
	public abstract String getInputInventoryForGui();
	
	public abstract String getOutputInventoryForGui();
	
	public abstract String[] getSubproducts();
	
	///--- RECIPES ---///
	
	public static final TreeMap<String, List<Recipe>> RECIPES = new TreeMap<>();
	protected Recipe current_recipe;
	protected int progress;
	
	public static class Recipe {
		
		private Object[] ingredients;
		private Object[] subproducts;
		private Object[] output;

		public boolean isValid(){
			for(Object obj : ingredients){
				if(obj == null){ return false; }
			}
			for(Object obj : output){
				if(obj == null){ return false; }
			}
			return true;
		}
		
		public static Recipe fromSave(NBTTagCompound compound){
			Recipe recipe = new Recipe();
			recipe.ingredients = new Object[0];
			recipe.subproducts = new Object[3];
			if(compound.hasKey("Subproducts")){
				int i = 0;
				NBTTagList list = (NBTTagList)compound.getTag("Subproducts");
				for(NBTBase nbt : list){
					NBTTagCompound tag = (NBTTagCompound)nbt;
					if(tag.hasNoTags()){
						recipe.subproducts[i] = null;
					}
					else if(tag.hasKey("FluidName")){
						recipe.subproducts[i] = FluidStack.loadFluidStackFromNBT(tag);
					}
					else{
						recipe.subproducts[i] = new ItemStack(tag);
					} i++;
				}
			}
			if(compound.hasKey("Output")){
				int i = 0; NBTTagList list = (NBTTagList)compound.getTag("Output");
				recipe.output = new Object[list.tagCount()];
				for(NBTBase nbt : list){
					NBTTagCompound tag = (NBTTagCompound)nbt;
					if(tag.hasNoTags()){
						recipe.output[i] = null;
					}
					else if(tag.hasKey("FluidName")){
						recipe.output[i] = FluidStack.loadFluidStackFromNBT(tag);
					}
					else{
						recipe.output[i] = new ItemStack(tag);
					} i++;
				}
				return recipe;
			}
			else return null;
		}
		
		public NBTTagCompound save(){
			NBTTagCompound compound = new NBTTagCompound();
			NBTTagList list = new NBTTagList();
			for(Object obj : subproducts){
				if(obj != null){
					list.appendTag(obj instanceof ItemStack ? ((ItemStack)obj).writeToNBT(new NBTTagCompound()) : ((FluidStack)obj).writeToNBT(new NBTTagCompound()));
				}
				else {
					list.appendTag(new NBTTagCompound());
				}
			}
			if(!list.hasNoTags()){
				compound.setTag("Subproducts", list);
				list = new NBTTagList();
			}
			for(Object obj : output){
				list.appendTag(obj instanceof ItemStack ? ((ItemStack)obj).writeToNBT(new NBTTagCompound()) : ((FluidStack)obj).writeToNBT(new NBTTagCompound()));
			}
			compound.setTag("Output", list);
			return compound;
		}
		
	}
	
	public static void registerRecipe(JsonObject obj, @Nullable ItemStack stack){
		String type = JsonUtil.getIfExists(obj, "Type", "null");
		if(type.equals("null")){ return; }
		switch(type){
			case "minecraft_shaped": return;//TODO
			case "fcl:bpt": case "fcl:blueprinttable":{
				try{
					String category = JsonUtil.getIfExists(obj, "Category", "FVTM:NoCategory");
					RecipeObject.parse(stack, obj, category);
					//TODO parse from json if stack null;
				}
				catch(Exception e){
					Print.log("Error while parsing/registering recipe: " + obj.toString());
					e.printStackTrace();
				}
				return;
			}
			case "minecraft_shapeless": return;//TODO
			case "minecraft_smelting": return;//TODO
		}
		if(Resources.BLOCKS.getValue((new ResourceLocation(type))) == null){
			Print.debug("Crafter block for Recipe not found!\n" + obj.toString());
			return;
		}
		//Proper parsing now.
		Recipe recipe = new Recipe();
		JsonArray array = obj.get("Ingredients").getAsJsonArray();
		recipe.ingredients = new Object[array.size()];
		for(int i = 0; i < recipe.ingredients.length; i++){
			recipe.ingredients[i] = parseObject(array.get(i).getAsJsonObject());
		}
		array = obj.get("Subproducts").getAsJsonArray();
		recipe.subproducts = new Object[3];
		for(int i = 0; i < 3; i++){
			recipe.subproducts[i] = parseObject(array.get(i).getAsJsonObject());
		}
		array = obj.get("Output").getAsJsonArray();
		recipe.output = new Object[array.size()];
		for(int i = 0; i < recipe.output.length; i++){
			recipe.output[i] = parseObject(array.get(i).getAsJsonObject());
		}
		if(recipe.isValid()){
			if(!RECIPES.containsKey(type)){
				RECIPES.put(type, new ArrayList<>());
			}
			RECIPES.get(type).add(recipe);
		}
	}
	
	private static Object parseObject(JsonObject obj){
		String type = obj.get("type").getAsString();
		switch(type){
			case "item":{
				String id = obj.get("id").getAsString();
				int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
				int amount = JsonUtil.getIfExists(obj, "amount", 1).intValue();
				ItemStack stack = null;
				if(meta >= 0){
					stack = new ItemStack(Item.getByNameOrId(id), amount, meta);
				}
				else{
					stack = new ItemStack(Item.getByNameOrId(id), amount);
				}
				setTag(stack, obj);
				return stack;
			}
			case "block":{
				String id = obj.get("id").getAsString();
				int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
				int amount = JsonUtil.getIfExists(obj, "amount", 1).intValue();
				ItemStack stack = null;
				if(meta >= 0){
					stack = new ItemStack(net.minecraft.block.Block.getBlockFromName(id), amount, meta);
				}
				else{
					stack = new ItemStack(net.minecraft.block.Block.getBlockFromName(id), amount);
				}
				setTag(stack, obj);
				return stack;
			}
			case "fvtm:material":{
				Material material = Resources.MATERIALS.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(material != null){
					ItemStack stack = material.getItemStack();
					int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
					if(meta >= 0){ stack.setItemDamage(meta); }
					stack.setCount(JsonUtil.getIfExists(obj, "amount", 1).intValue());
					setTag(stack, obj);
					return stack;
				}
				return null;
			}
			case "fvtm:part":{
				Part part = Resources.PARTS.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(part != null){
					NBTTagCompound compound = getTag(obj, false);
					try{
						ItemStack stack = part.getItemStack(part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(compound));
						int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
						if(meta >= 0){ stack.setItemDamage(meta); }
						return stack;
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				return null;
			}
			case "fvtm:vehicle":{
				Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(vehicle != null){
					NBTTagCompound compound = getTag(obj, false);
					try{
						ItemStack stack = vehicle.getItemStack(vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle).readFromNBT(compound));
						int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
						if(meta >= 0){ stack.setItemDamage(meta); }
						return stack;
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				return null;
			}
			case "fvtm:consumable":{
				Consumable con = Resources.CONSUMABLES.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(con != null){
					ItemStack stack = con.getItemStack();
					int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
					if(meta >= 0){ stack.setItemDamage(meta); }
					stack.setCount(JsonUtil.getIfExists(obj, "amount", 1).intValue());
					setTag(stack, obj);
					return stack;
				}
				return null;
			}
			case "fvtm:container":{
				Container con = Resources.CONTAINERS.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(con != null){
					NBTTagCompound compound = getTag(obj, false);
					try{
						ItemStack stack = con.getItemStack(con.getDataClass().getConstructor(Container.class).newInstance(con).readFromNBT(compound));
						int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
						if(meta >= 0){ stack.setItemDamage(meta); }
						return stack;
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				return null;
			}
			case "fvtm:block":{
				Block blk = Resources.BLOCKS.getValue(new ResourceLocation(obj.get("id").getAsString()));
				if(blk != null){
					NBTTagCompound compound = getTag(obj, false);
					try{
						ItemStack stack = blk.getItemStack(blk.getDataClass().getConstructor(Block.class).newInstance(blk).readFromNBT(compound));
						int meta = JsonUtil.getIfExists(obj, "meta", -1).intValue();
						if(meta >= 0){ stack.setItemDamage(meta); }
						return stack;
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				return null;
			}
			case "fluid":{
				Fluid fluid = FluidRegistry.getFluid(obj.get("id").getAsString());
				if(fluid != null){
					int amount = JsonUtil.getIfExists(obj, "amount", 1000).intValue();
					return new FluidStack(fluid, amount);
				}
				return null;
			}
			case "null": case "none":{
				return null;
			}
		}
		return null;
	}

	private static void setTag(ItemStack stack, JsonObject obj){
		NBTTagCompound compound = getTag(obj, true);
		if(compound != null && !compound.hasNoTags()){
			stack.setTagCompound(compound);
		}
	}
	
	private static NBTTagCompound getTag(JsonObject obj, boolean aln){
		if(obj.has("nbt")){
			try{
				return JsonToNBT.getTagFromJson(obj.get("nbt").getAsJsonObject().toString());
			}
			catch(NBTException e){
				e.printStackTrace();
				Static.stop();
			}
		}
		return aln ? null : new NBTTagCompound();
	}

	protected abstract void validateRecipes();
	
}