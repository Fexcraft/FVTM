package net.fexcraft.mod.fvtm.data.block;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class MultiBlockData {
	
	private MultiBlock type;
	private LinkedHashMap<String, NonNullList<ItemStack>> inventories = new LinkedHashMap<>();
	private LinkedHashMap<String, ContentFilter> invfilters = new LinkedHashMap<>();
	private LinkedHashMap<String, FluidTank> tanks = new LinkedHashMap<>();
	private BlockScript script;
	private BlockData data;
	
	public MultiBlockData(BlockData data, MultiBlock block){
		this.type = block;
		this.data = data;
		for(Entry<String, InventoryType> entry : block.getInventoryTypes().entrySet()){
			int capacity = block.getInventorySizes().get(entry.getKey());
	        switch(entry.getValue()){
		        case ENERGY:
		            break;
		        case FLUID:
		        	Fluid fluid = (Fluid)block.getInventoryData().get(entry.getKey());
		            tanks.put(entry.getKey(), fluid == null ? new FluidTank(capacity) : new FluidTank(fluid, 0, capacity));
		            break;
		        case ITEM:
		        	ContentFilter filter = (ContentFilter)block.getInventoryData().get(entry.getKey());
		        	if(filter != null) invfilters.put(entry.getKey(), filter);
		            inventories.put(entry.getKey(), NonNullList.<ItemStack>withSize(capacity, ItemStack.EMPTY));
		            break;
		        default:
		            break;
		    }
		}
		try{
			script = block.hasScript() ? block.getScript().newInstance() : null;
		}
		catch(InstantiationException | IllegalAccessException e){
			e.printStackTrace();
			Static.stop();
		}
	}
	
	public MultiBlockData(BlockData data, NBTTagCompound compound){
		this(data, data.getType().getMultiBlock());
		this.read(compound);
	}
	
	public void read(NBTTagCompound compound){
		for(Entry<String, NonNullList<ItemStack>> entry : inventories.entrySet()){
			if(!compound.hasKey("inv-" + entry.getKey())) continue;
			DataUtil.loadAllItems(compound, entry.getValue(), "inv-" + entry.getKey());
		}
		for(Entry<String, FluidTank> entry : tanks.entrySet()){
			if(!compound.hasKey("tank-" + entry.getKey())) continue;
			entry.getValue().readFromNBT(compound.getCompoundTag("tank-" + entry.getKey()));
		}
		if(script != null){
			script.read(this, compound);
		}
	}

	public MultiBlock getType(){
		return type;
	}
	
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		for(Entry<String, NonNullList<ItemStack>> entry : inventories.entrySet()){
			DataUtil.saveAllItems(compound, entry.getValue(), true, "inv-" + entry.getKey());
		}
		for(Entry<String, FluidTank> entry : tanks.entrySet()){
			compound.setTag("tank-" + entry.getKey(), entry.getValue().writeToNBT(new NBTTagCompound()));
		}
		if(script != null){
			script.write(this, compound);
		}
		return compound;
	}
	
	public BlockScript getScript(){
		return script;
	}
	
	public NonNullList<ItemStack> getInventory(String id){
		return inventories.get(id);
	}
	
	public FluidTank getFluidTank(String id){
		return tanks.get(id);
	}
	
	public BlockData getData(){
		return data;
	}

}
