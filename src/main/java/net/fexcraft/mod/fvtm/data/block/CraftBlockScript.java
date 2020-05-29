package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Base class for Crafter-Type MultiBlock Scripts.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class CraftBlockScript implements BlockScript {
	
	public static LinkedHashMap<String, Recipe> RECIPE_REGISTRY = new LinkedHashMap<>();
	public static LinkedHashMap<String, ArrayList<Recipe>> SORTED_REGISTRY = new LinkedHashMap<>();
	
	protected Recipe selected, autosel;
	protected int cooldown;
	protected int processed;

	@Override
	public void read(MultiBlockData data, NBTTagCompound tag){
		selected = tag.hasKey("selected") ? RECIPE_REGISTRY.get(tag.getString("selected")) : null;
		autosel = tag.hasKey("auto_selected") ? RECIPE_REGISTRY.get(tag.getString("auto_selected")) : null;
		cooldown = tag.hasKey("cooldown") ? tag.getInteger("cooldown") : 0;
		processed = tag.hasKey("processed") ? tag.getInteger("processed") : 0;
	}

	@Override
	public NBTTagCompound write(MultiBlockData data, NBTTagCompound compound){
		if(selected != null) compound.setString("selected", selected.id);
		if(autosel != null) compound.setString("auto_selected", autosel.id);
		compound.setInteger("cooldown", cooldown);
		compound.setInteger("processed", processed);
		return null;
	}

	@Override
	public void onUpdate(TickableTE tile){
		if(cooldown > 0){
			cooldown -= cooldown_speed();
			return;
		}
		if(!ready()){
			prepare();
			return;
		}
		running();
		if(selected != null){
			tryCrafting(tile, selected);
			return;
		}
		if(autoRecipeChooser() && (autosel == null || !autosel.canCraft(tile.getMultiBlockData()))){
			searchForRecipe();
		}
		if(autosel != null){
			tryCrafting(tile, selected);
			return;
		}
		cooldown += cooldown();
	}

	protected void tryCrafting(TickableTE tile, Recipe recipe){
		//TODO
	}

	protected void searchForRecipe(){
		//TODO
	}

	@Override
	public void onTrigger(MultiBlockData data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, Vec3d hit){
		switch(trigger.getTarget()){
			//TODO
			default: return;
		}
	}
	
	public abstract boolean autoRecipeChooser();
	
	public abstract int cooldown();
	
	public abstract boolean instant();
	
	/** If this block is ready to process recipes. */
	public abstract boolean ready();

	/** If the block returned not to be ready this method is called and further recipe processing skipped.*/
	public abstract void prepare();

	/** This method is called after the ready check and before recipes are processed. */
	public abstract void running();
	
	public abstract int process_speed();
	
	public abstract int cooldown_speed();
	
	public abstract boolean update_client();
	
	public static class Recipe {
		
		protected HashMap<String, IngredientWrapper> input = new HashMap<>();
		protected HashMap<String, IngredientWrapper> output = new HashMap<>();
		protected HashMap<String, Integer> consume = new HashMap<>();
		protected String targetmachine, id;
		protected int crafttime;
		
		public Recipe(JsonObject obj) throws Exception {
			targetmachine = obj.get("block").getAsString();
			JsonArray ingr = obj.get("input").getAsJsonArray();
			for(JsonElement entry : ingr){
				JsonObject ingredient = entry.getAsJsonObject();
				String inventory = ingredient.get("inventory").getAsString();
				input.put(inventory, new IngredientWrapper(ingredient));
			}
			ingr = obj.get("output").getAsJsonArray();
			for(JsonElement entry : ingr){
				JsonObject ingredient = entry.getAsJsonObject();
				String inventory = ingredient.get("inventory").getAsString();
				output.put(inventory, new IngredientWrapper(ingredient));
			}
			if(obj.has("consume")){
				obj.get("consume").getAsJsonObject().entrySet().forEach(entry -> {
					consume.put(entry.getKey(), entry.getValue().getAsInt());
				});
			}
			crafttime = obj.has("craft_time") ? obj.get("craft_time").getAsInt() : 20;
			id = obj.get("id").getAsString();
		}

		public boolean canCraft(MultiBlockData data){
			//TODO
			return false;
		}
		
	}
	
	public static class IngredientWrapper {

		protected Ingredient ingredient;
		protected Fluid fluid;
		protected int amount;
		
		public IngredientWrapper(JsonObject obj) throws NBTException {
			if(obj.has("fluid")){
				fluid = FluidRegistry.getFluid(obj.get("fluid").getAsString());
				amount = obj.get("amount").getAsInt();
			}
			else if(obj.has("item")){
				ingredient = Ingredient.fromStacks(fromJson(obj.get("item")));
			}
			else if(obj.has("items")){
				JsonArray array = obj.get("items").getAsJsonArray();
				ItemStack[] stacks = new ItemStack[array.size()];
				for(int i = 0; i < stacks.length; i++){
					stacks[i] = fromJson(array.get(i));
				}
				ingredient = Ingredient.fromStacks(stacks);
			}
		}

		private ItemStack fromJson(JsonElement elm) throws NBTException {
			if(elm.isJsonPrimitive()){
				return new ItemStack(Item.getByNameOrId(elm.getAsString()));
			}
			else{
				JsonObject obj = elm.getAsJsonObject();
				ItemStack stack = new ItemStack(Item.getByNameOrId(obj.get("id").getAsString()));
				stack.setCount(obj.has("count") ? obj.get("count").getAsInt() : 0);
				stack.setItemDamage(obj.has("damage") ? obj.get("damage").getAsInt() : 0);
				if(obj.has("tag")){
					stack.setTagCompound(JsonToNBT.getTagFromJson(obj.get("tag").toString()));
				}
				return stack;
			}
		}
		
	}

}
