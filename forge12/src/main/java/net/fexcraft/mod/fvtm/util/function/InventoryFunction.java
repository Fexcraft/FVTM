package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerInit;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.uni.item.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class InventoryFunction extends PartFunction {
	
	private InvHandler inventory;
    private ArrayList<ItemStack> allowed = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> disallowed = new ArrayList<ItemStack>();
    private ArrayList<String> seats = new ArrayList<String>();

	/** Static Copy in Part. */
	public InventoryFunction(){}

	/** Functional Copy in PartData. */
	public InventoryFunction(InventoryFunction root){
		allowed = root.allowed;
		disallowed = root.disallowed;
		seats = root.seats;
		inventory = root.inventory.gen(1);
	}

	@Override
	public PartFunction init(Part part, FJson json){
		JsonMap map = json.asMap();
		inventory = new InvHandlerInit(InvType.parse(map.getString("type", "item"), false));
		inventory.setCapacity(map.getInteger("capacity", 0));
		inventory.setArg(map.getString("fluid", "minecraft:water"));
		//
		if(map.has("allowed")){
			map.get("allowed").asArray().value.forEach(val -> {
				try{
					JsonMap jsn = val.asMap();
					allowed.add(new ItemStack(Item.getByNameOrId(jsn.getString("id", "minecraft:stone")), 1, map.getInteger("meta", 0)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(map.has("disallowed")){
			map.get("disallowed").asArray().value.forEach(val -> {
				try{
					JsonMap jsn = val.asMap();
					disallowed.add(new ItemStack(Item.getByNameOrId(jsn.getString("id", "minecraft:stone")), 1, map.getInteger("meta", 0)));
				}
				catch(Exception e){
					e.printStackTrace();
				}
			});
		}
		if(map.has("seats")) seats = map.getArray("seats").toStringList();
		return this;
	}

	@Override
	public PartFunction load(TagCW compound){
		inventory.load(compound, "inventory");
		return this;
	}

	@Override
	public TagCW save(TagCW compound){
        inventory.save(compound, "inventory");
		return compound;
	}

	@Override
	public String getId(){
		return "fvtm:inventory";
	}

	@Override
	public PartFunction copy(Part part){
		return new InventoryFunction(this);
	}

	public boolean isInventoryType(InvType othertype){
		return inventory.type == othertype;
	}

	public boolean isInventoryType(Capability<?> capability){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return inventory.type.isItem();
		if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return inventory.type.isFluid();
		return false;
	}

	public <T> T getInventory(Capability<?> capability){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T)inventory.getStackHandler();
		if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return (T)inventory.getTank();
		return null;
	}
    
    public ArrayList<String> getSeats(){
    	return seats;
    }
    
    public boolean isItemValid(ItemStack stack){
        for(ItemStack itemstack : disallowed){
            if(stack.getItem().getRegistryName().equals(itemstack.getItem().getRegistryName())){
                if(itemstack.getMetadata() == 0 || stack.getItemDamage() == itemstack.getItemDamage()){
                    return false;
                }
            }
        }
        //
        if(!allowed.isEmpty()){
            boolean found = false;
            for(ItemStack itemstack : allowed){
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
    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> tooltip, boolean ext){
        tooltip.add(Formatter.format("&9Inventory Size: &7" + inventory.capacity() + " " + inventory.type.unit_suffix));
        tooltip.add(Formatter.format("&9Inventory Type: &7" + inventory.type.name()));
        if(inventory.type.isFluid()){
			FluidTank tank = inventory.getTank();
            tooltip.add(Formatter.format("&9Inv. Content: &7" + (tank.getFluidAmount() == 0 ? "empty" : tank.getFluid().getLocalizedName())));
        }
    }

	public InvHandler inventory(){
		return inventory;
	}

}
