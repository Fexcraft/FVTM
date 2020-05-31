package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
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
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.ItemStackHandler;

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
		return compound;
	}

	@Override
	public void onUpdate(TickableTE tile){
		if(tile.getWorld().isRemote) return;
		if(!ready(tile)){
			prepare(tile);
			return;
		}
		running(tile);
		if(cooldown > 0){
			cooldown -= cooldown_speed();
			return;
		}
		if(selected != null){
			tryCrafting(tile, selected);
			return;
		}
		if(autoRecipeChooser() && (autosel == null || !autosel.canCraft(this, tile.getMultiBlockData(), false))){
			autosel = null;
			searchForRecipe(tile.getMultiBlockData());
		}
		if(autosel != null){
			tryCrafting(tile, autosel);
			return;
		}
		else addCooldown();
	}

	protected void tryCrafting(TickableTE tile, Recipe recipe){
		if(!recipe.canCraft(this, tile.getMultiBlockData(), true)) return;
		if(!instant()){
			int question = recipe.crafttime == 0 ? process_time() : recipe.crafttime;
			if(processed < question){
				processed += process_speed();
				return;
			}
		}
		recipe.craft(this, tile.getMultiBlockData());
		processed = 0;
	}

	protected void searchForRecipe(MultiBlockData multidata){
		ArrayList<Recipe> recipes = SORTED_REGISTRY.get(multidata.getData().getType().getRegistryName().toString());
		if(recipes == null || recipes.isEmpty()) return;
		for(Recipe recipe : recipes){
			if(recipe.canCraft(this, multidata, false)){
				autosel = recipe;
			}
		}
	}

	protected void addCooldown(){
		cooldown += cooldown();
	}
	
	protected boolean isCoolingDown(){
		return cooldown > 0;
	}

	@Override
	public boolean onTrigger(MultiBlockData data, MB_Trigger trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, Vec3d hit){
		switch(trigger.getTarget()){
			case "open_gui":{
				GenericContainer.openGui("fvtm", 952, new int[]{ core.getX(), core.getY(), core.getZ() }, player);
				return true;
			}
			case "select_recipe":{
				GenericContainer.openGui("fvtm", 953, new int[]{ core.getX(), core.getY(), core.getZ() }, player);
				return true;
			}
			default: return false;
		}
	}

	public abstract List<Object[]> getGuiElements();

	public String getCurrentRecipe(){
		return selected == null ? autosel == null ? "none" : autosel.id : selected.id;
	}
	
	public abstract boolean autoRecipeChooser();
	
	public abstract int cooldown();
	
	public abstract boolean instant();
	
	/** If this block is ready to process recipes. */
	public abstract boolean ready(TickableTE tile);

	/** If the block returned not to be ready this method is called and further recipe processing skipped.*/
	public abstract void prepare(TickableTE tile);

	/** This method is called after the ready check and before recipes are processed. */
	public abstract void running(TickableTE tile);
	
	public abstract int process_speed();
	
	public abstract int process_time();
	
	public abstract int cooldown_speed();
	
	public abstract boolean update_client();
	
	public abstract boolean consume(String id, int amount, boolean simulate);
	
	public abstract int getConsumable(String id);
	
	public abstract String[] getConsumables();

	/** For GUI/External */
	public abstract void setConsumable(String id, int value);

	public int getCooldown(){
		return cooldown;
	}

	public int getProcessed(){
		return processed;
	}
	
	/** For GUI/External */
	public int getProcessTime(){
		if(selected == null && autosel == null) return 0;
		Recipe recipe = selected == null ? autosel : selected;
		return recipe.crafttime == 0 ? process_time() : recipe.crafttime;
	}

	/** For GUI/External */
	public void setProcessed(int value){
		processed = value;
	}

	/** For GUI/External */
	public void setCooldown(int value){
		cooldown = value;
	}
	
	public static class Recipe {
		
		protected HashMap<String, InputWrapper> input = new HashMap<>();
		protected HashMap<String, OutputWrapper> output = new HashMap<>();
		protected HashMap<String, Integer> consume = new HashMap<>();
		protected String targetmachine, id;
		protected int crafttime;
		
		public Recipe(JsonObject obj) throws Exception {
			targetmachine = obj.get("block").getAsString();
			JsonArray ingr = obj.get("input").getAsJsonArray();
			for(JsonElement entry : ingr){
				JsonObject ingredient = entry.getAsJsonObject();
				String inventory = ingredient.get("inventory").getAsString();
				input.put(inventory, new InputWrapper(ingredient));
			}
			ingr = obj.get("output").getAsJsonArray();
			for(JsonElement entry : ingr){
				JsonObject ingredient = entry.getAsJsonObject();
				String inventory = ingredient.get("inventory").getAsString();
				output.put(inventory, new OutputWrapper(ingredient));
			}
			if(obj.has("consume")){
				obj.get("consume").getAsJsonObject().entrySet().forEach(entry -> {
					consume.put(entry.getKey(), entry.getValue().getAsInt());
				});
			}
			crafttime = obj.has("craft_time") ? obj.get("craft_time").getAsInt() : 0;
			id = obj.get("id").getAsString();
		}

		public void craft(CraftBlockScript script, MultiBlockData data){
			for(Entry<String, Integer> cons : consume.entrySet()){
				script.consume(cons.getKey(), cons.getValue(), false);
			}
			for(Entry<String, InputWrapper> entry : input.entrySet()){
				InventoryType local = entry.getValue().getInventoryType();
				if(local.isFluid()){
					data.getFluidTank(entry.getKey()).drain(entry.getValue().fluid, true);
				}
				else{
					ItemStackHandler handler = data.getInventoryHandler(entry.getKey());
					for(int i = 0; i < handler.getSlots(); i++){
						ItemStack stack = handler.getStackInSlot(i);
						if(entry.getValue().ingredient.apply(stack) && stack.getCount() >= entry.getValue().amount){
							handler.extractItem(i, entry.getValue().amount, false);
							break;
						}
					}
				}
			}
			for(Entry<String, OutputWrapper> entry : output.entrySet()){
				InventoryType local = entry.getValue().getInventoryType();
				if(local.isFluid()){
					data.getFluidTank(entry.getKey()).fill(entry.getValue().fluid, true);
				}
				else{
					ItemStackHandler handler = data.getInventoryHandler(entry.getKey());
					ItemStack left = entry.getValue().stack;
					for(int i = 0; i < handler.getSlots(); i++){
						left = handler.insertItem(i, left, false);;
						if(left.isEmpty()) break;
					}
				}
			}
			script.addCooldown();
		}

		public boolean canCraft(CraftBlockScript script, MultiBlockData data, boolean addcooldown){
			boolean fits = true;
			ArrayList<Integer> ints = new ArrayList<>();
			for(Entry<String, OutputWrapper> entry : output.entrySet()){
				InventoryType local = entry.getValue().getInventoryType();
				if(data.getType().getInventoryTypes().get(entry.getKey()) != local){
					fits = false;
					break;
				}
				if(entry.getValue().overflow) continue;
				if(local.isFluid()){
					if(data.getFluidTank(entry.getKey()).fill(entry.getValue().fluid, false) < entry.getValue().fluid.amount){
						fits = false;
						break;
					}
				}
				else{
					boolean found = false;
					ItemStackHandler handler = data.getInventoryHandler(entry.getKey());
					for(int i = 0; i < handler.getSlots(); i++){
						if(ints.contains(i)) continue;
						if(handler.insertItem(i, entry.getValue().stack, true).isEmpty()){
							ints.add(i);
							found = true;
							break;
						}
					}
					if(!found){
						fits = false;
						break;
					}
				}
			}
			if(!fits){
				if(addcooldown) script.addCooldown();
				return false;
			}
			boolean passed = true;
			ints.clear();
			for(Entry<String, InputWrapper> entry : input.entrySet()){
				InventoryType local = entry.getValue().getInventoryType();
				if(data.getType().getInventoryTypes().get(entry.getKey()) != local){
					passed = false;
					break;
				}
				if(local.isFluid()){
					FluidStack drained = data.getFluidTank(entry.getKey()).drain(entry.getValue().fluid, false);
					if(drained == null || drained.amount < entry.getValue().fluid.amount){
						passed = false;
						break;
					}
				}
				else{
					boolean found = false;
					ItemStackHandler handler = data.getInventoryHandler(entry.getKey());
					for(int i = 0; i < handler.getSlots(); i++){
						if(ints.contains(i)) continue;
						ItemStack stack = handler.getStackInSlot(i);
						if(entry.getValue().ingredient.apply(stack) && stack.getCount() >= entry.getValue().amount){
							ints.add(i);
							found = true;
							break;
						}
					}
					if(!found){
						passed = false;
						break;
					}
				}
			}
			if(!passed){
				if(addcooldown) script.addCooldown();
				return false;
			}
			for(Entry<String, Integer> cons : consume.entrySet()){
				if(!script.consume(cons.getKey(), cons.getValue(), true)) return false;
			}
			return true;
		}
		
	}
	
	public static class InputWrapper {

		protected Ingredient ingredient;
		protected FluidStack fluid;
		protected int amount;
		
		public InputWrapper(JsonObject obj) throws NBTException {
			if(obj.has("fluid")){
				fluid = new FluidStack(FluidRegistry.getFluid(obj.get("fluid").getAsString()), obj.get("amount").getAsInt());
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
			amount = obj.has("amount") ? obj.get("amount").getAsInt() : 1;
		}

		public InventoryType getInventoryType(){
			return fluid != null ? InventoryType.FLUID : InventoryType.ITEM;
		}

		private static ItemStack fromJson(JsonElement elm) throws NBTException {
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
	
	public static class OutputWrapper {

		protected ItemStack stack;
		protected FluidStack fluid;
		protected boolean overflow;
		
		public OutputWrapper(JsonObject obj) throws NBTException {
			if(obj.has("fluid")){
				fluid = new FluidStack(FluidRegistry.getFluid(obj.get("fluid").getAsString()), obj.get("amount").getAsInt());
			}
			else if(obj.has("item")){
				stack = InputWrapper.fromJson(obj.get("item"));
			}
			overflow = obj.has("overflow") ? obj.get("overflow").getAsBoolean() : false;
		}

		public InventoryType getInventoryType(){
			return fluid != null ? InventoryType.FLUID : InventoryType.ITEM;
		}
		
	}

	public static void parseRecipes(Addon addon, String filename, boolean override, JsonArray array){
		for(JsonElement elm : array){
			try{
				Recipe recipe = new Recipe(elm.getAsJsonObject());
				if(!override && RECIPE_REGISTRY.containsKey(recipe.id)){
					Print.log(String.format("Duplicate Recipe ID detected from addon '%s' with id '%s' from file '%s'!", addon.getRegistryName().toString(), recipe.id, filename));
					continue;
				}
				RECIPE_REGISTRY.put(recipe.id, recipe);
				if(!SORTED_REGISTRY.containsKey(recipe.targetmachine)) SORTED_REGISTRY.put(recipe.targetmachine, new ArrayList<>());
				SORTED_REGISTRY.get(recipe.targetmachine).add(recipe);
				Print.debug("Added Recipe '" + recipe.id + "' to '" + recipe.targetmachine + "' from '" + addon.getRegistryName().toString() + "'!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void resetRecipe(){
		if(selected == null && autosel == null) return;
		selected = autosel = null;
		processed = 0;
		addCooldown();
	}
	
	public static enum GuiElement {
		TEXT, TEXT_VALUE, PROGRESS_BAR, BUTTONS
	}

}
