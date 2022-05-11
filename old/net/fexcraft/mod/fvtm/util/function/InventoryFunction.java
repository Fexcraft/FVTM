package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.handler.ItemStackHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class InventoryFunction extends Function {
	
	private InventoryType type;
	private String fluid;
	private int capacity;
	//private byte stacksize;
	//
    private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
    private ArrayList<String> seats = new ArrayList<String>();
	//
	private NonNullList<ItemStack> stacks;
	private FluidTank tank;

	/** Static Copy in Part. */
	public InventoryFunction(Part part, JsonObject obj){
		super(part, obj); if(obj == null) return;
		type = InventoryType.valueOf(JsonUtil.getIfExists(obj, "type", "ITEM"));
		capacity = JsonUtil.getIfExists(obj, "capacity", 0).intValue();
		//stacksize = (byte)JsonUtil.getIfExists(obj, "StackSize", 64).intValue();
		fluid = JsonUtil.getIfExists(obj, "fluid", "minecraft:water");
		//
        if(obj.has("whitelist")){
            obj.get("whitelist").getAsJsonArray().forEach((elm) -> {
                JsonObject jsn = elm.getAsJsonObject();
                try{
                    whitelist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
        if(obj.has("blacklist")){
            obj.get("blacklist").getAsJsonArray().forEach((elm) -> {
                JsonObject jsn = elm.getAsJsonObject();
                try{
                    blacklist.add(new ItemStack(Item.getByNameOrId(JsonUtil.getIfExists(jsn, "id", "minecraft:stone")), 1, JsonUtil.getIfExists(jsn, "meta", 0).intValue()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            });
        }
        seats = (ArrayList<String>)DataUtil.getStringArray(obj, "seats", false, false);
	}

	/** Functional Copy in PartData. */
	public InventoryFunction(InventoryFunction root){
		super(null, null); type = root.type; capacity = root.capacity; /*stacksize = root.stacksize;*/
		fluid = root.fluid; this.whitelist = root.whitelist; this.blacklist = root.blacklist; this.seats = root.seats;
		switch(type){
			case CONTAINER: break;
			case ENERGY: break;
			case FLUID:{
				Fluid flui = FluidRegistry.getFluid(fluid);
				tank = flui == null ? new FluidTank((int)capacity) : new FluidTank(flui, 0, capacity);
				break;
			}
			case ITEM: stacks = NonNullList.<ItemStack>withSize((int)capacity, ItemStack.EMPTY); break;
			default: break;//type not found, may be bad.
		}
	}

	@Override
	public Function read(NBTTagCompound compound){
		if(stacks != null){
			ItemStackHelper.loadAllItems(compound.getCompoundTag("inventory"), stacks);
		}
		if(tank != null){
            tank.readFromNBT(compound.getCompoundTag("inventory"));
		}
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(stacks != null){
			compound.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), stacks));
		}
		if(tank != null){
            compound.setTag("inventory", tank.writeToNBT(new NBTTagCompound()));
		}
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:inventory";
	}

	@Override
	public Function copy(Part part){
		return new InventoryFunction(this);
	}

	public boolean isInventoryType(InventoryType othertype){
		return type == othertype;
	}

	public boolean isInventoryType(Capability<?> capability){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return isInventoryType(InventoryType.ITEM);
		if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return isInventoryType(InventoryType.FLUID);
		return false;
	}
	
	public <T> T getInventory(InventoryType type){
		switch(type){
			case CONTAINER: break;
			case ENERGY: break;
			case FLUID: return (T)tank;
			case ITEM: return (T)new ItemStackHandler(null, stacks);
			default: break;
		} return null;
	}

	public <T> T getInventory(Capability<T> capability){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return getInventory(InventoryType.ITEM);
		if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return getInventory(InventoryType.FLUID);
		return null;
	}

    public ItemStackHandler getItemStackHandler(){
        return new ItemStackHandler(stacks);
    }

	public NonNullList<ItemStack> getStacks(){
		return stacks;
	}

    public IFluidHandler getFluidHandler(){
        return tank;
    }

    public FluidTank getFluidTank(){
        return tank;
    }
    
    public ArrayList<String> getSeats(){
    	return seats;
    }
    
    public boolean isItemValid(ItemStack stack){
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
            } return found;
        } return true;
    }

    @Override
    public void addInformation(ItemStack stack, World world, PartData data, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Inventory Size: &7" + capacity + " " + type.getUnitSuffix()));
        tooltip.add(Formatter.format("&9Inventory Type: &7" + type.name()));
        if(type == InventoryType.FLUID){
            tooltip.add(Formatter.format("&9Inv. Content: &7" + (tank.getFluidAmount() == 0 ? "empty" : tank.getFluid().getLocalizedName())));
        }
    }

	public InventoryType getInventoryType(){
		return type;
	}

}
