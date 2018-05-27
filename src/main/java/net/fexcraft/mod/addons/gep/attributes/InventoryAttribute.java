package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class InventoryAttribute implements Attribute {

    private static final ResourceLocation rs = new ResourceLocation("inventory");
    private int size;
    private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
    private InventoryType type = InventoryType.ITEM;
    private Fluid fluid = null;

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
        fluid = obj.has("Inventory-FluidType") ? FluidRegistry.getFluid(obj.get("Inventory-FluidType").getAsString()) : null;
    }

    @Override
    public String getName(){
        return "Inventory Attribute";
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

        private InventoryAttribute root;
        private NonNullList<ItemStack> stacks;
        private FluidTank fluidtank;

        public InventoryAttributeData(PartData data, Attribute attr){
            root = (InventoryAttribute) attr;
            switch(root.type){
                case ENERGY:
                    break;
                case FLUID:
                    fluidtank = root.getFluidType() == null ? new FluidTank(root.size) : new FluidTank(root.getFluidType(), 0, root.size);
                    break;
                case FUEL:
                    break;
                case ITEM:
                    stacks = NonNullList.<ItemStack>withSize(root.size, ItemStack.EMPTY);
                    break;
                default:
                    break;
            }
        }

        @Override
        public NBTTagCompound writeToNBT(PartData data, NBTTagCompound compound){
            if(root.type == InventoryType.ITEM){
                compound.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), stacks));
            }
            else if(root.type == InventoryType.FLUID){
                compound.setTag("inventory", fluidtank.writeToNBT(new NBTTagCompound()));
            }
            return compound;
        }

        @Override
        public AttributeData readFromNBT(PartData data, NBTTagCompound compound){
            if(root.type == InventoryType.ITEM){
                if(stacks == null){
                    stacks = NonNullList.<ItemStack>withSize(data.getPart().getAttribute(InventoryAttribute.class).getSize(), ItemStack.EMPTY);
                }
                ItemStackHelper.loadAllItems(compound.getCompoundTag("inventory"), stacks);
            }
            else if(root.type == InventoryType.FLUID){
                fluidtank.readFromNBT(compound.getCompoundTag("inventory"));
            }
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

        public IFluidHandler getFluidHandler(){
            return fluidtank;
        }

        public FluidTank getFluidTank(){
            return fluidtank;
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

    public @Nullable
    Fluid getFluidType(){
        return fluid;
    }

	@Override
	public boolean hasRenderData(){
		return true;
	}

}
