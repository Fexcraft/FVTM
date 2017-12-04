package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.compatibility.InventoryType;
import net.fexcraft.mod.fvtm.blocks.ConstructorController.Button;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class InventoryAttribute implements Attribute {

	private static final ResourceLocation rs = new ResourceLocation("inventory");
	private int size;
	private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
	private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
	private InventoryType type = InventoryType.ITEM;
	
	@Override
	public ResourceLocation getRegistryName(){
		return rs;
	}

	@Override
	public void load(JsonObject obj){
		size = JsonUtil.getIfExists(obj, "Inventory-Size", 4).intValue();
		if(obj.has("Inventory-Whitelist")){
			obj.get("Inventory-Whitelist").getAsJsonArray().forEach((elm) -> {
				JsonObject jsn = elm.getAsJsonObject();
				try{
					whitelist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(obj.has("Inventory-Blacklist")){
			obj.get("Inventory-Blacklist").getAsJsonArray().forEach((elm) -> {
				JsonObject jsn = elm.getAsJsonObject();
				try{
					blacklist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		type = InventoryType.fromString(JsonUtil.getIfExists(obj, "Inventory-Type", "item"));
	}

	@Override
	public String getName(){
		return "Inventory Attribute";
	}

	@Override
	public NBTTagCompound getScreen(NBTTagCompound compound, PartData part, int selection, int scroll){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onButtonPress(Button button, EntityPlayer player, String[] args){
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
		tooltip.add(Formatter.format("&9Inventory Size: &7" + size + " " + type.getUnitsName()));
		tooltip.add(Formatter.format("&9Inventory Type: &7" + type.getName()));
	}

	@Override
	public boolean hasDataClass(){
		return true;
	}

	@Override
	public Class<? extends AttributeData> getDataClass(){
		return InventoryAttributeData.class;
	}
	
	public static class InventoryAttributeData implements AttributeData {
		
		private NonNullList<ItemStack> stacks;
		
		public InventoryAttributeData(PartData data, Attribute attr){
			stacks = NonNullList.<ItemStack>withSize(((InventoryAttribute)attr).size, ItemStack.EMPTY);
		}

		@Override
		public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
			compound.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), stacks));
			return compound;
		}

		@Override
		public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
			if(stacks == null){
				stacks = NonNullList.<ItemStack>withSize(data.getPart().getAttribute(InventoryAttribute.class).getSize(), ItemStack.EMPTY);
			}
			ItemStackHelper.loadAllItems(compound.getCompoundTag("inventory"), stacks);
			return this;
		}

		public NonNullList<ItemStack> getInventory(){
			return stacks;
		}

		public boolean isEmpty(){
			int i = 0;
			for(ItemStack stack : stacks){
				if(!stack.isEmpty()){
					i++;
				}
			}
			return i == 0;
		}
		
	}
	
	public int getSize(){
		return size;
	}
	
	public ArrayList<ItemStack> getItemWhitelist(){
		return whitelist;
	}
	
	public ArrayList<ItemStack> getItemBlacklist(){
		return blacklist;
	}

	public boolean isItemValid(ItemStack stack){
		Print.debug("CHECKING");
		Print.debug(stack.toString());
		for(ItemStack itemstack : blacklist){
			if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
				if(itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()){
					return false;
				}
			}
		}
		//
		if(!whitelist.isEmpty()){
			boolean found = false;
			for(ItemStack itemstack : whitelist){
				if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
					if(itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()){
						found = true;
						break;
					}
				}
			}
			Print.debug(found);
			return found;
		}
		return true;
	}
	
	public InventoryType getType(){
		return type;
	}
	
}