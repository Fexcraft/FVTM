package net.fexcraft.mod.fvtm.impl.block;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public abstract class CrafterBlockScriptBase implements BlockScript {
	
	public CrafterBlockScriptBase(){
		validateRecipes(RECIPES.get(this.getSettingHolderId()));
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
	
	@Override
	public void onBreak(TileEntity tile, BlockData data){
		current_recipe = null; progress = 0;
	}
	
	/** Return number between 0 and 100, inclusive. **/
	public abstract int getProgressPercentage();
	
	public abstract List<String> getStatus(BlockData data);
	
	public abstract Recipe findNextRecipe(BlockData data);
	
	///--- RECIPES ---///
	
	public static final TreeMap<String, List<Recipe>> RECIPES = new TreeMap<>();
	protected Recipe current_recipe;
	protected int progress;
	
	public static class Recipe {
		
		public Object[] ingredients;
		//public Object[] subproducts;
		public Object[] output;

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
			for(Object obj : output){
				list.appendTag(obj instanceof ItemStack ? ((ItemStack)obj).writeToNBT(new NBTTagCompound()) : ((FluidStack)obj).writeToNBT(new NBTTagCompound()));
			}
			compound.setTag("Output", list);
			return compound;
		}
		
		@Override
		public String toString(){
			String in = "I: [";
			for(Object obj : ingredients){
				in += obj.toString();
			}
			in += "]; || O:[";
			for(Object obj : output){
				in += obj.toString();
			}
			return in += "];";
		}
		
	}
	
	public static void registerRecipes(JsonElement elm, @Nullable ItemStack stack, @Nullable String category){
		if(elm.isJsonArray()){
			elm.getAsJsonArray().forEach(obj -> {
				registerRecipe(obj.getAsJsonObject(), stack, category);
			});
		}
		else if(elm.isJsonObject()){
			registerRecipe(elm.getAsJsonObject(), stack, category);
		}
		else return;
	}
	
	public static void registerRecipe(JsonObject obj, @Nullable ItemStack stack, @Nullable String category){
		String type = JsonUtil.getIfExists(obj, "Type", "null");
		if(type.equals("null")){ return; }
		switch(type){
			case "minecraft_shaped":
			case "minecraft_shapeless":
			case "minecraft_smelting":
			case "fcl:bpt": case "fcl:blueprinttable":
			case "smelting": case "Smelting":
			case "blueprint": case "Blueprint":{
				try{
					String cat = JsonUtil.getIfExists(obj, "Category", category == null ? "FVTM:NoCategory" : category);
					RecipeObject.parse(stack, obj, cat);
					//TODO parse from json if stack null;
				}
				catch(Exception e){
					Print.log("Error while parsing/registering recipe: " + obj.toString());
					e.printStackTrace();
				}
				return;
			}
		}
		if(Resources.BLOCKS.getValue((new ResourceLocation(type))) == null){
			Print.debug("Crafter block for Recipe not found!\n" + obj.toString());
			Static.stop();
			return;
		}
		//Proper parsing now.
		Recipe recipe = new Recipe();
		JsonArray array = obj.get("Ingredients").getAsJsonArray();
		recipe.ingredients = new Object[array.size()];
		for(int i = 0; i < recipe.ingredients.length; i++){
			recipe.ingredients[i] = parseObject(array.get(i).getAsJsonObject());
			if(recipe.ingredients[i] instanceof ItemStack && ((ItemStack)recipe.ingredients[i]).getItem().getUnlocalizedName().equals("tile.air")){
				recipe.ingredients[i] = null;
			}
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
		else{
			Print.debug(obj); Static.stop();
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
	
	/** Remove from list whichever are invalid for this block. **/
	protected abstract void validateRecipes(List<Recipe> list);
	
	public boolean insert(NonNullList<ItemStack> list, ItemStack stack){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).isEmpty()){
				list.set(i, stack.copy());
				return true;
			}
			else if(canMerge(list.get(i), stack, false)){
				list.get(i).grow(stack.getCount());
				return true;
			}
			else if(canMerge(list.get(i), stack, true)){
				ItemStack is = list.get(i);
				int j = (is.getMaxStackSize() > 64 ? 64 : is.getMaxStackSize()) - is.getCount();
				stack.shrink(j); is.grow(j);
			}
		}
		return stack.isEmpty();
	}
	
	private boolean canMerge(ItemStack stack, ItemStack compare, boolean part){
		if(part && stack.getCount() >= stack.getMaxStackSize()){
			return false;
		}
		else if(!part && stack.getCount() + compare.getCount() > stack.getMaxStackSize()){
			return false;
		}
        else if(stack.getItem() != compare.getItem()){
            return false;
        }
        else if(stack.getItemDamage() != compare.getItemDamage()){
            return false;
        }
        else if(stack.getTagCompound() == null && compare.getTagCompound() != null){
            return false;
        }
        else{
            return (stack.getTagCompound() == null || stack.getTagCompound().equals(compare.getTagCompound())) && stack.areCapsCompatible(compare);
        }
	}
	
	protected boolean canFit(NonNullList<ItemStack> out, ItemStack obj){
		boolean found = false;
		ItemStack mer = obj.copy();
		for(ItemStack stack : out){
			if(stack.isEmpty() || canMerge(stack, mer, false)){
				found = true; break;
			}
			else if(canMerge(stack, mer, true)){
				mer.shrink(stack.getCount());
				if(mer.isEmpty()){
					return true;
				}
			}
		}
		return found;
	}

	public boolean extract(NonNullList<ItemStack> list, ItemStack stack){
		ItemStack extr = stack.copy();
		for(int i = 0; i < list.size(); i++){
			if(isEqualOrValid(list.get(i), extr)){
				ItemStack is = list.get(i);
				if(is.getCount() == extr.getCount()){
					list.set(i, ItemStack.EMPTY);
					return true;
				}
				else if(is.getCount() > extr.getCount()){
					list.get(i).shrink(extr.getCount());
					return true;
				}
				else if(is.getCount() < extr.getCount()){
					extr.shrink(is.getCount());
					list.set(i, ItemStack.EMPTY);
				}
			}
		}
		return extr.isEmpty();
	}
	
	public boolean containsItemStack(NonNullList<ItemStack> list, ItemStack stack){
		for(int i = 0; i < list.size(); i++){
			if(isEqualOrValid(list.get(i), stack)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isEqualOrValid(ItemStack stack, ItemStack compare){
		if(stack.getCount() < compare.getCount()){
            return false;
        }
        else if(stack.getItem() != compare.getItem()){
            return false;
        }
        else if(stack.getItemDamage() != compare.getItemDamage()){
            return false;
        }
        else if(stack.getTagCompound() == null && compare.getTagCompound() != null){
            return false;
        }
        else{
            return (stack.getTagCompound() == null || stack.getTagCompound().equals(compare.getTagCompound())) && stack.areCapsCompatible(compare);
        }
	}
	
	public boolean fill(FluidTank handler, FluidStack stack){
		//TODO
		return false;
	}
	
	public boolean drain(FluidTank handler, FluidStack stack){
		//TODO
		return false;
	}

	public int getProgress(){
		return progress;
	}
	
}