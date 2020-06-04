package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TickableTE;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE.TileEntity;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.InputWrapper.InputType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Base class for Crafter-Type MultiBlock Scripts.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class CraftBlockScript implements BlockScript {
	
	public static LinkedHashMap<String, Recipe> RECIPE_REGISTRY = new LinkedHashMap<>();
	public static LinkedHashMap<String, ArrayList<Recipe>> SORTED_REGISTRY = new LinkedHashMap<>();
	
	protected String blockid;
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
		if(blockid == null){
			blockid = multidata.getData().getType().getRegistryName().toString();
		}
		ArrayList<Recipe> recipes = SORTED_REGISTRY.get(blockid);
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
		
		protected ArrayList<InputWrapper> input = new ArrayList<>();
		protected ArrayList<OutputWrapper> output = new ArrayList<>();
		protected HashMap<String, Integer> consume = new HashMap<>();
		protected String targetmachine, id;
		protected int crafttime;
		
		public Recipe(JsonObject obj) throws Exception {
			targetmachine = obj.get("block").getAsString();
			JsonArray ingr = obj.get("input").getAsJsonArray();
			for(JsonElement entry : ingr){
				input.add(new InputWrapper(entry.getAsJsonObject()));
			}
			ingr = obj.get("output").getAsJsonArray();
			for(JsonElement entry : ingr){
				output.add(new OutputWrapper(entry.getAsJsonObject()));
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
			for(InputWrapper entry : input){
				InputType local = entry.getInputType();
				if(local.toInventory().isFluid()){
					data.getFluidTank(entry.inventory).drain(entry.fluid, true);
				}
				else{
					ItemStackHandler handler = data.getInventoryHandler(entry.inventory);
					for(int i = 0; i < handler.getSlots(); i++){
						ItemStack stack = handler.getStackInSlot(i);
						if(entry.valid(stack) && stack.getCount() >= entry.amount){
							handler.extractItem(i, entry.amount, false);
							break;
						}
					}
				}
			}
			for(OutputWrapper entry : output){
				InventoryType local = entry.getInventoryType();
				if(local.isFluid()){
					data.getFluidTank(entry.inventory).fill(entry.fluid, true);
				}
				else{
					ItemStackHandler handler = data.getInventoryHandler(entry.inventory);
					ItemStack left = entry.stack.copy();
					for(int i = 0; i < handler.getSlots(); i++){
						left = handler.insertItem(i, left, false);
						if(left.isEmpty()) break;
					}
				}
			}
			script.addCooldown();
		}

		public boolean canCraft(CraftBlockScript script, MultiBlockData data, boolean addcooldown){
			boolean fits = true;
			ArrayList<Integer> ints = new ArrayList<>();
			for(OutputWrapper entry : output){
				InventoryType local = entry.getInventoryType();
				if(data.getType().getInventoryTypes().get(entry.inventory) != local){
					fits = false;
					break;
				}
				if(entry.overflow) continue;
				if(local.isFluid()){
					if(data.getFluidTank(entry.inventory).fill(entry.fluid, false) < entry.fluid.amount){
						fits = false;
						break;
					}
				}
				else{
					boolean found = false;
					ItemStackHandler handler = data.getInventoryHandler(entry.inventory);
					for(int i = 0; i < handler.getSlots(); i++){
						if(ints.contains(i)) continue;
						if(handler.insertItem(i, entry.stack, true).isEmpty()){
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
			for(InputWrapper entry : input){
				InputType local = entry.getInputType();
				if(data.getType().getInventoryTypes().get(entry.inventory) != local.toInventory()){
					passed = false;
					break;
				}
				if(local.toInventory().isFluid()){
					FluidStack drained = data.getFluidTank(entry.inventory).drain(entry.fluid, false);
					if(drained == null || drained.amount < entry.fluid.amount){
						passed = false;
						break;
					}
				}
				else{
					boolean found = false;
					ItemStackHandler handler = data.getInventoryHandler(entry.inventory);
					for(int i = 0; i < handler.getSlots(); i++){
						if(ints.contains(i)) continue;
						ItemStack stack = handler.getStackInSlot(i);
						if(entry.valid(stack) && stack.getCount() >= entry.amount){
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

		public String id(){
			return id;
		}
		
	}
	
	public static class InputWrapper {

		protected static HashMap<String, NonNullList<ItemStack>> oredict = new HashMap<>();
		protected Ingredient ingredient;
		protected FluidStack fluid;
		protected String inventory;
		protected String oreid;
		protected int amount;
		
		public InputWrapper(JsonObject obj) throws Exception {
			inventory = obj.get("inventory").getAsString();
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
			else if(obj.has("oredict")){
				String id = obj.get("oredict").getAsString();
				if(!oredict.containsKey(id)){
					oredict.put(id, OreDictionary.getOres(id, true));
				}
				if(oredict.get(id).size() < 1){
					throw new Exception("OreDict for '" + id + "' is empty!");
				}
				oreid = id;
			}
			amount = obj.has("amount") ? obj.get("amount").getAsInt() : obj.has("count") ? obj.get("count").getAsInt() : 1;
		}
		
		public boolean valid(ItemStack stack){
			if(ingredient != null){
				return ingredient.apply(stack);
			}
			if(oreid != null){
				return OreDictionary.containsMatch(false, oredict.get(oreid), stack);
			}
			return false;
		}

		public static enum InputType {
			
			ITEM, FLUID, OREDICT;
			
			public InventoryType toInventory(){
				return this == FLUID ? InventoryType.FLUID : InventoryType.ITEM;
			}
			
		}

		public InputType getInputType(){
			return fluid != null ? InputType.FLUID : ingredient == null ? InputType.OREDICT : InputType.ITEM;
		}
		
	}
	
	public static class OutputWrapper {

		protected ItemStack stack;
		protected FluidStack fluid;
		protected boolean overflow;
		protected String inventory;
		
		public OutputWrapper(JsonObject obj) throws Exception {
			inventory = obj.get("inventory").getAsString();
			if(obj.has("fluid")){
				fluid = new FluidStack(FluidRegistry.getFluid(obj.get("fluid").getAsString()), obj.get("amount").getAsInt());
			}
			else if(obj.has("item")){
				stack = fromJson(obj.get("item"));
				if(obj.has("amount") || obj.has("count")){
					stack.setCount(obj.get(obj.has("amount") ? "amount" : "count").getAsInt());
				}
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
				JsonObject obj = elm.getAsJsonObject();
				if(obj.get("block").getAsString().equals("fcl:bpt") || obj.get("block").getAsString().equals("fcl:blueprinttable")){
					ItemStack output = fromJson(obj.get("output").getAsJsonObject());
					JsonArray erray = obj.get("input").getAsJsonArray();
					ItemStack[] stacks = new ItemStack[erray.size()];
					for(int i = 0; i < stacks.length; i++){
						stacks[i] = fromJson(erray.get(i));
					}
					RecipeRegistry.addBluePrintRecipe(obj.get("category").getAsString(), output, stacks);
					//redirect recipe to FCL:BPT
					continue;
				}
				Recipe recipe = new Recipe(obj);
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
				if(Static.dev()){
					e.printStackTrace();
					Static.stop();
				}
			}
		}
	}

	private static final ItemStack fromJson(JsonElement elm) throws Exception {
		ItemStack stack = null;
		if(elm.isJsonPrimitive()){
			stack = new ItemStack(Item.getByNameOrId(elm.getAsString()));
		}
		else{
			JsonObject obj = elm.getAsJsonObject();
			stack = new ItemStack(Item.getByNameOrId(obj.get("id").getAsString()));
			stack.setCount(obj.has("count") ? obj.get("count").getAsInt() : 0);
			stack.setItemDamage(obj.has("damage") ? obj.get("damage").getAsInt() : 0);
			if(obj.has("tag")){
				stack.setTagCompound(JsonToNBT.getTagFromJson(obj.get("tag").toString()));
			}
		}
		if(stack.isEmpty()){
			throw new Exception("Item not found: " + elm.toString());
		}
		return stack;
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

	public void setSelectedRecipe(TileEntity tile, String string){
		if(blockid == null){
			blockid = tile.getMultiBlockData().getData().getType().getRegistryName().toString();
		}
		this.addCooldown();
		for(Recipe recipe : SORTED_REGISTRY.get(blockid)){
			if(recipe.id().equals(string)){
				selected = recipe;
				return;
			}
		}
		selected = null;
	}

}
