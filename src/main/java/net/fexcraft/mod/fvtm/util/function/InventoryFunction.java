package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.part.Function;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

public class InventoryFunction extends Function {
	
	private InvHandler inventory;
    private ArrayList<ItemStack> whitelist = new ArrayList<ItemStack>();
    private ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
    private ArrayList<String> seats = new ArrayList<String>();

	/** Static Copy in Part. */
	public InventoryFunction(Part part, JsonObject obj){
		super(part, obj); if(obj == null) return;
		inventory = new InvHandler(InvType.parse(JsonUtil.getIfExists(obj, "type", "item"), false));
		inventory.setCapacity(JsonUtil.getIfExists(obj, "capacity", 0).intValue());
		inventory.setArg(JsonUtil.getIfExists(obj, "fluid", "minecraft:water"));
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
		super(null, null);
		this.whitelist = root.whitelist; this.blacklist = root.blacklist; this.seats = root.seats;
		inventory = root.inventory.gen(1);
	}

	@Override
	public Function read(NBTTagCompound compound){
		inventory.load(compound.getCompoundTag("inventory"));
		return this;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		compound.setTag("inventory", inventory.save(new NBTTagCompound()));
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
        tooltip.add(Formatter.format("&9Inventory Size: &7" + inventory.capacity() + " " + inventory.type.unit_suffix));
        tooltip.add(Formatter.format("&9Inventory Type: &7" + inventory.type.name()));
        if(inventory.type.isFluid()){
            tooltip.add(Formatter.format("&9Inv. Content: &7" + (inventory.getTank().getFluidAmount() == 0 ? "empty" : inventory.getTank().getFluid().getLocalizedName())));
        }
    }

	public InvHandler inventory(){
		return inventory;
	}

}
