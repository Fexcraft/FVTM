package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class MaterialItem extends TypeCoreItem<Material> {

	public MaterialItem(Material core){
		super(new Properties().stacksTo(core.getMaxStackSize()).durability(core.getMaxDamage()).tab(Resources.getCreativeTab(core)), core);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> list, TooltipFlag flag){
		list.add(new TextComponent("Name: " + type.getName()));
        for(String s : type.getDescription()){ list.add(new TextComponent(I18n.get(s))); }
        if(type.getOreDictionaryId() != null){
    		list.add(new TextComponent("Oredict: " + type.getOreDictionaryId()));
        }
        if(type.isVehicleKey()){
        	list.add(new TextComponent("LockCode: " + this.getLockCode(stack)));
        }
        if(type.isFuelContainer()){
        	list.add(new TextComponent("Container: " + (type.isUniversalFuelContainer() ? "universal" : type.getFuelType() == null ? type.getFuelGroup() : type.getFuelType().getName())));
        	list.add(new TextComponent("Fuel Stored: " + this.getStoredFuelName(stack)));
        	list.add(new TextComponent("Fuel Amount: " + this.getStoredFuelAmount(stack) + "mB"));
        }
	}
    
    public String getLockCode(ItemStack stack){
    	if(!type.isVehicleKey()) return null;
    	if(stack.getTag() == null) stack.setTag(new CompoundTag());
    	if(!stack.getTag().contains("LockCode")) stack.getTag().putString("LockCode", Lockable.newCode());
    	return stack.getTag().getString("LockCode");
    }
    
    public Fuel getStoredFuelType(ItemStack stack){
    	if(!type.isFuelContainer()) return null;
    	if(type.getFuelType() != null) return type.getFuelType();
    	if(stack.hasTag()) return Resources.getFuel(stack.getTag().getString("StoredFuelType"));
    	else return null;
    }
    
    public int getStoredFuelAmount(ItemStack stack){
    	if(!type.isFuelContainer() || !stack.hasTag()) return 0;
    	return stack.getTag().getInt("StoredFuelAmount");
    }
    
    public String getStoredFuelName(ItemStack stack){
    	if(!type.isFuelContainer()) return "Nothing.";
    	if(type.getFuelType() != null) return type.getFuelType().getName();
    	if(stack.hasTag()) return Resources.getFuelName(stack.getTag().getString("StoredFuelType"));
    	else return "none";
    }

	public void extractFuel(ItemStack stack, int stored){
		if(!stack.hasTag()) stack.setTag(new CompoundTag());
		stack.getTag().putInt("StoredFuelAmount", stack.getTag().getInt("StoredFuelAmount") - stored);
		if(stack.getTag().getInt("StoredFuelAmount") < 0) stack.getTag().putInt("StoredFuelAmount", 0);
	}

	public void insertFuel(ItemStack stack, int stored){
		if(!stack.hasTag()) stack.setTag(new CompoundTag());
		stack.getTag().putInt("StoredFuelAmount", stack.getTag().getInt("StoredFuelAmount") + stored);
		if(stack.getTag().getInt("StoredFuelAmount") > type.getFuelCapacity()) stack.getTag().putInt("StoredFuelAmount", type.getFuelCapacity());
	}

}
