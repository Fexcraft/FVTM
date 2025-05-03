package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.InputWrapper.InputType;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;

import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

import static net.fexcraft.mod.fvtm.util.GuiHandler.MULTIBLOCK_CRAFT_CHOOSE;
import static net.fexcraft.mod.fvtm.util.GuiHandler.MULTIBLOCK_CRAFT_MAIN;

/**
 * Base class for Crafter-Type MultiBlock Scripts.
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class CraftBlockScript implements BlockScript {
	
	public static LinkedHashMap<String, Recipe> RECIPE_REGISTRY = new LinkedHashMap<>();
	public static LinkedHashMap<String, ArrayList<Recipe>> SORTED_REGISTRY = new LinkedHashMap<>();
	private static LinkedHashMap<String, Ingredient> ITEMGROUPS = new LinkedHashMap<>();
	
	protected String blockid;
	protected Recipe selected, autosel;
	protected int cooldown;
	protected int processed;

	@Override
	public void read(MultiBlockData data, TagCW tag){
		selected = tag.has("selected") ? RECIPE_REGISTRY.get(tag.getString("selected")) : null;
		autosel = tag.has("auto_selected") ? RECIPE_REGISTRY.get(tag.getString("auto_selected")) : null;
		cooldown = tag.has("cooldown") ? tag.getInteger("cooldown") : 0;
		processed = tag.has("processed") ? tag.getInteger("processed") : 0;
	}

	@Override
	public TagCW write(MultiBlockData data, TagCW compound){
		if(selected != null) compound.set("selected", selected.id);
		if(autosel != null) compound.set("auto_selected", autosel.id);
		compound.set("cooldown", cooldown);
		compound.set("processed", processed);
		return compound;
	}

	@Override
	public void onUpdate(MultiblockTickableTE tile){
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

	protected void tryCrafting(MultiblockTickableTE tile, Recipe recipe){
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
			blockid = multidata.getType().getIDS();
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
	public boolean onTrigger(MultiBlockData data, MB_Interact trigger, EntityPlayer player, EnumHand hand, BlockPos core, BlockPos pos, EnumFacing side, V3D hit){
		switch(trigger.getTarget()){
			case "open_gui":{
				player.openGui(FVTM.getInstance(), MULTIBLOCK_CRAFT_MAIN, player.world, core.getX(), core.getY(), core.getZ());
				return true;
			}
			case "select_recipe":{
				player.openGui(FVTM.getInstance(), MULTIBLOCK_CRAFT_CHOOSE, player.world, core.getX(), core.getY(), core.getZ());
				return true;
			}
			default: return false;
		}
	}

	public abstract List<Object[]> getUIElements(BlockData bdata, MultiBlockData mdata);

	public String getCurrentRecipe(){
		return selected == null ? autosel == null ? "none" : autosel.id : selected.id;
	}
	
	public abstract boolean autoRecipeChooser();
	
	public abstract int cooldown();
	
	public abstract boolean instant();
	
	/** If this block is ready to process recipes. */
	public abstract boolean ready(MultiblockTickableTE tile);

	/** If the block returned not to be ready this method is called and further recipe processing skipped.*/
	public abstract void prepare(MultiblockTickableTE tile);

	/** This method is called after the ready check and before recipes are processed. */
	public abstract void running(MultiblockTickableTE tile);
	
	public abstract int process_speed();
	
	public abstract int process_time();
	
	public abstract int cooldown_speed();
	
	public abstract boolean update_client();
	
	public abstract boolean consume(MultiBlockData data, String id, int amount, boolean simulate);

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

		public Recipe(String blkid, String rcpid){
			targetmachine = blkid;
			id = rcpid;
		}

		public void craft(CraftBlockScript script, MultiBlockData data){
			for(Entry<String, Integer> cons : consume.entrySet()){
				script.consume(data, cons.getKey(), cons.getValue(), false);
			}
			for(InputWrapper entry : input){
				InputType local = entry.getInputType();
				String inventory = getInvId(data, local.toInventory(), entry.inventory, "input");
				if(local.toInventory().isFluid()){
					((FluidTank)data.getInventory(inventory).getTank()).drain(entry.fluid, true);
				}
				else{
					IItemHandler handler = data.getInventory(inventory).getStackHandler();
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
				InvType local = entry.getInventoryType();
				String inventory = getInvId(data, local, entry.inventory, "output");
				if(local.isFluid()){
					((FluidTank)data.getInventory(inventory).getTank()).fill(entry.fluid, true);
				}
				else{
					IItemHandler handler = data.getInventory(inventory).getStackHandler();
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
				InvType local = entry.getInventoryType();
				String invid = getInvId(data, local, entry.inventory, "output");
				if(invid == null){
					fits = false;
					break;
				}
				if(data.getInventories().get(invid).type != local){
					fits = false;
					break;
				}
				if(entry.overflow) continue;
				if(local.isFluid()){
					if(((FluidTank)data.getInventory(invid).getTank()).fill(entry.fluid, false) < entry.fluid.amount){
						fits = false;
						break;
					}
				}
				else{
					boolean found = false;
					IItemHandler handler = data.getInventory(invid).getStackHandler();
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
				String invid = getInvId(data, local.toInventory(), entry.inventory, "input");
				if(data.getInventories().get(invid).type != local.toInventory()){
					passed = false;
					break;
				}
				if(local.toInventory().isFluid()){
					FluidStack drained = ((FluidTank)data.getInventory(invid).getTank()).drain(entry.fluid, false);
					if(drained == null || drained.amount < entry.fluid.amount){
						passed = false;
						break;
					}
				}
				else{
					boolean found = false;
					IItemHandler handler = data.getInventory(invid).getStackHandler();
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
				if(!script.consume(data, cons.getKey(), cons.getValue(), true)) return false;
			}
			return true;
		}

		public String id(){
			return id;
		}

		public List<InputWrapper> getInputs(){
			return input;
		}

		public List<OutputWrapper> getOutput(){
			return output;
		}

		public Map<String, Integer> getConsume(){
			return consume;
		}
		
	}

	public static String getInvId(MultiBlockData data, InvType type, String invname, String fix){
		if(data.getInventories().containsKey(invname)) return invname;
		ArrayList<String> coll = new ArrayList<>();
		for(Entry<String, InvHandler> entry : data.getInventories().entrySet()){
			if(entry.getKey().equals(fix)) return entry.getKey();
			if(entry.getValue().type == type) coll.add(entry.getKey());
		}
		return coll.size() != 1 ? null : coll.get(0);
	}
	
	public static class InputWrapper {

		protected static HashMap<String, NonNullList<ItemStack>> oredict = new HashMap<>();
		public Ingredient ingredient;
		public FluidStack fluid;
		public String inventory;
		public String oreid;
		public int amount;
		
		public InputWrapper(String inv){
			inventory = inv;
		}
		
		public InputWrapper(String inv, String data, InputType type){
			inventory = inv;
			String[] arr = data.split(" ");
			if(arr[0].contains("*")){
				String[] am = arr[0].split("\\*");
				arr[0] = am[0];
				amount = Integer.parseInt(am[1]);
			}
			if(amount < 1) amount = 1;
			if(type == InputType.ITEM){
				ingredient = Ingredient.fromStacks(parseStack(arr, amount));
			}
			else if(type == InputType.FLUID){
				fluid = new FluidStack(FluidRegistry.getFluid(arr[0]), amount);
			}
			else{//InputType.OREDICT
				if(!oredict.containsKey(arr[0])){
					oredict.put(arr[0], OreDictionary.getOres(arr[0], true));
				}
				if(oredict.get(arr[0]).size() < 1){
					Print.log("OreDict for '" + arr[0] + "' is empty!");
				}
				else oreid = arr[0];
			}
		}
		
		protected void addIngredientItem(String data){
			ingredient = toIngrArray(parseStack(data.split(" "), amount));
		}

		private Ingredient toIngrArray(ItemStack stack){
			if(ingredient == null) return Ingredient.fromStacks(stack);
			ItemStack[] stacks = new ItemStack[ingredient.getMatchingStacks().length + 1];
			for(int i = 0; i < stacks.length - 1; i++){
				stacks[i] = ingredient.getMatchingStacks()[i];
			}
			stacks[stacks.length - 1] = stack;
			return Ingredient.fromStacks(stacks);
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
			
			public InvType toInventory(){
				return this == FLUID ? InvType.FLUID : InvType.ITEM;
			}
			
		}

		public InputType getInputType(){
			return fluid != null ? InputType.FLUID : ingredient == null ? InputType.OREDICT : InputType.ITEM;
		}
		
	}
	
	public static class OutputWrapper {

		public ItemStack stack;
		public FluidStack fluid;
		public boolean overflow;
		public String inventory;

		public OutputWrapper(String inv, String data, boolean item){
			inventory = inv;
			int amount = 0;
			String[] arr = data.split(" ");
			if(arr[0].contains("*")){
				String[] am = arr[0].split("\\*");
				arr[0] = am[0];
				amount = Integer.parseInt(am[1]);
			}
			if(amount < 1) amount = 1;
			if(item){
				stack = parseStack(arr, amount);
			}
			else{
				fluid = new FluidStack(FluidRegistry.getFluid(arr[0]), amount);
			}
		}

		public InvType getInventoryType(){
			return fluid != null ? InvType.FLUID : InvType.ITEM;
		}

		public int amount(){
			return fluid == null ? stack.getCount() : fluid.amount;
		}
		
	}

	public static void parseRecipes(Addon addon, String filename, InputStream stream){
		try{
			Scanner scanner = new Scanner(stream);
			String line = null;
			boolean override = false;
			//
			RecipeParser parser = null;
			while(scanner.hasNextLine()){
				line = scanner.nextLine().trim();
				if(line.equals("#override")) override = !override;
				if(line.startsWith("#")){
					if(parser != null) parser.finish(addon);
					//
					String[] split = line.substring(1).split("@");
					if(split.length < 2) continue;
					String blkid = split[0].trim();
					String rcpid = split[1].trim();
					if(blkid.equals("fcl:bpt") || blkid.equals("fcl:blueprinttable")){
						parser = new FCLBPTParser().start(blkid, rcpid);
					}
					else if(blkid.equals("itemgroup")){
						if(!override && ITEMGROUPS.containsKey(rcpid)){
							Print.log(String.format("Duplicate ItemGroup ID detected from addon '%s' with id '%s' from file '%s'!", addon.getIDS(), rcpid, filename));
							continue;
						}
						parser = new ItemGroupParser().start(blkid, rcpid);
					}
					else{
						if(!override && RECIPE_REGISTRY.containsKey(rcpid)){
							Print.log(String.format("Duplicate Recipe ID detected from addon '%s' with id '%s' from file '%s'!", addon.getIDS(), rcpid, filename));
							continue;
						}
						parser = new RecipeParserImpl().start(blkid, rcpid);
					}
				}
				if(line.startsWith("//")) continue;
				if(parser != null) parser.read(line);
			}
			if(parser != null) parser.finish(addon);
			scanner.close();
		}
		catch(Exception e){
			if(Static.dev()){
				e.printStackTrace();
				Static.stop();
			}
		}
	}
	
	protected static interface RecipeParser {
		
		public static String KEY_IN = "@in";
		public static String KEY_OUT = "@out";
		
		public RecipeParser start(String id, String rcpid);
		
		public void read(String line);
		
		public void finish(Addon addon);
		
	}
	
	protected static class FCLBPTParser implements RecipeParser {
		
		private String category;
		private boolean in;
		private ArrayList<ItemStack> stacks = new ArrayList<>();
		private ItemStack out;

		@Override
		public RecipeParser start(String id, String rcpid){
			category = rcpid;
			return this;
		}

		@Override
		public void read(String line){
			if(line.startsWith(KEY_IN)){
				in = true;
				return;
			}
			if(line.startsWith(KEY_OUT)){
				in = false;
				return;
			}
			if(line.startsWith("item")){
				if(in) stacks.add(parseStack(line.substring(4).trim()));
				else out = parseStack(line.substring(4).trim());
				return;
			}
		}

		@Override
		public void finish(Addon addon){
			RecipeRegistry.addBluePrintRecipe(category.length() == 0 ? addon.getID().path() + ".recipes" : category, out, stacks.toArray(new ItemStack[0]));
		}
		
	}
	
	protected static class ItemGroupParser implements RecipeParser {
		
		private ArrayList<ItemStack> stacks = new ArrayList<>();
		private String id;

		@Override
		public RecipeParser start(String unused, String rcpid){
			id = rcpid;
			return this;
		}

		@Override
		public void read(String line){
			if(line.startsWith("item")){
				stacks.add(parseStack(line.substring(4).trim()));
			}
		}

		@Override
		public void finish(Addon addon){
			ITEMGROUPS.put(id, Ingredient.fromStacks(stacks.toArray(new ItemStack[0])));
		}
		
	}
	
	protected static class RecipeParserImpl implements RecipeParser {
		
		private Recipe recipe;
		private boolean input;
		private InputWrapper in;
		private OutputWrapper out;
		private String inv;

		@Override
		public RecipeParser start(String blkid, String rcpid){
			recipe = new Recipe(blkid, rcpid);
			return this;
		}

		@Override
		public void read(String line){
			if(line.startsWith(KEY_IN)){
				input = true;
				inv = line.substring(3).trim();
				if(inv.length() == 0) inv = null;
				in = null;
				return;
			}
			if(line.startsWith(KEY_OUT)){
				input = false;
				inv = line.substring(4).trim();
				if(inv.length() == 0) inv = null;
				out = null;
				return;
			}
			if(line.equals("overflow") && out != null){
				out.overflow = true;
				return;
			}
			if(line.startsWith("time")){
				recipe.crafttime = Integer.parseInt(line.substring(5));
				return;
			}
			if(line.startsWith("item")){
				if(input) recipe.input.add(in = new InputWrapper(inv, line.substring(4).trim(), InputType.ITEM));
				else recipe.output.add(out = new OutputWrapper(inv, line.substring(4).trim(), true));
				return;
			}
			if(line.startsWith("+item") && in != null && in.getInputType() == InputType.ITEM){
				in.addIngredientItem(line.substring(5).trim());
				return;
			}
			if(line.startsWith("group")){
				String[] arr = line.substring(5).split("\\*");
				String id = arr[0].trim();
				if(!ITEMGROUPS.containsKey(id)) return;
				InputWrapper inw = new InputWrapper(inv);
				inw.ingredient = ITEMGROUPS.get(id);
				inw.amount = arr.length > 1 ? Integer.parseInt(arr[1].trim()) : 1;
				recipe.input.add(inw);
				return;
			}
			if(line.startsWith("fluid")){
				if(input) recipe.input.add(new InputWrapper(inv, line.substring(5).trim(), InputType.FLUID));
				else recipe.output.add(out = new OutputWrapper(inv, line.substring(5).trim(), false));
				return;
			}
			if(line.startsWith("oredict") && input){
				recipe.input.add(new InputWrapper(inv, line.substring(7).trim(), InputType.OREDICT));
				return;
			}
			if(line.startsWith("consume")){
				String[] str = line.split(" ");
				recipe.consume.put(str[1], Integer.parseInt(str[2]));
				return;
			}
		}

		@Override
		public void finish(Addon addon){
			if(recipe.input.isEmpty() && recipe.consume.isEmpty()){
				Print.debug("Recipe '" + recipe.id + "' for '" + recipe.targetmachine + "' from '" + addon.getIDS() + "' has no input/consumption, skipping!");
				return;
			}
			RECIPE_REGISTRY.put(recipe.id, recipe);
			if(!SORTED_REGISTRY.containsKey(recipe.targetmachine)) SORTED_REGISTRY.put(recipe.targetmachine, new ArrayList<>());
			SORTED_REGISTRY.get(recipe.targetmachine).add(recipe);
			Print.debug("Added Recipe '" + recipe.id + "' to '" + recipe.targetmachine + "' from '" + addon.getIDS() + "'!");
		}
		
	}

	private static final ItemStack parseStack(String data){
		int amount = 0;
		String[] arr = data.split(" ");
		if(arr[0].contains("*")){
			String[] am = arr[0].split("\\*");
			arr[0] = am[0];
			amount = Integer.parseInt(am[1]);
		}
		if(amount < 1) amount = 1;
		return parseStack(arr, amount);
	}

	private static final ItemStack parseStack(String[] args, int count){
		ItemStack stack = null;
		if(args.length == 1){
			stack = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(args[0])), count);
		}
		else{
			stack = new ItemStack(Item.REGISTRY.getObject(new ResourceLocation(args[0])), count);
			boolean tag = args[1].startsWith("{");
			if(!tag){
				stack.setItemDamage(Integer.parseInt(args[1]));
			}
			if(tag || args.length > 2){
				try{
					stack.setTagCompound(JsonToNBT.getTagFromJson(args[tag ? 1 : 2]));
				}
				catch(NBTException e){
					Print.log("Error while parsing tag for recipe ingredient.");
					e.printStackTrace();
				}
			}
		}
		if(stack.isEmpty()){
			Print.log("Item for recipe not found: " + args[0]);
		}
		return stack;
	}

	public void resetRecipe(){
		if(selected == null && autosel == null) return;
		selected = autosel = null;
		processed = 0;
		addCooldown();
	}

	public void setSelectedRecipe(MultiblockTileEntity tile, String string){
		if(blockid == null){
			blockid = tile.getMultiBlockData().getType().getIDS();
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

	public Recipe getSelected(){
		return selected;
	}

}
