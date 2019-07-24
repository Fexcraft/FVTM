package net.fexcraft.mod.fvtm.gui.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {
	
	protected GenericGui<VehicleContainer> gui;
	@Nullable protected NBTTagCompound initpacket;
	//
	private boolean invmode;
	protected InventoryFunction function;
	protected VehicleEntity veh;
	protected PartData invpart;
	protected String inv_id;
	protected TIFI temp;
	protected int empty_index = -1, page;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
	}
	
	public VehicleContainer(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(player); initpacket = compound;
		if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
		//
		if(compound.hasKey("inventory")){ invmode = true;
			SeatEntity ent = (SeatEntity)player.getRidingEntity(); veh = ent.getVehicle();
			invpart = veh.getVehicleData().getPart(inv_id = compound.getString("inventory"));
			function = invpart.getFunction("fvtm:inventory");
			if(function.isInventoryType(InventoryType.ITEM)){
	            temp = new TIFI(invpart, function);
	            this.populateSlots();
			} else;//TODO
		}
	}

	void populateSlots(){
		this.inventoryItemStacks.clear(); this.inventorySlots.clear(); this.empty_index = -1;
        for(int row = 0; row < 6; row++){
            for(int col = 0; col < 13; col++){
                int index = (col + row * 12) + (page * 78);
                if(index >= temp.getSizeInventory()){ if(empty_index == -1) empty_index = (col + row * 12); break; }
                addSlotToContainer(new TIS(temp, index, 8 + col * 18, 22 + row * 18, temp.getData(), null));
            }
        }
        //
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 9; col++){
                addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 136 + row * 18));
            }
        }
        for(int col = 0; col < 9; col++){
            addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 192));
        }
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(invmode && packet.getString("cargo").equals("inventory_page")){
			page = packet.getInteger("page"); this.populateSlots();
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
		if(!invmode) return super.transferStackInSlot(player, index);
        int slots = 0;
        switch(function.getInventoryType()){
			case CONTAINER: break;
			case ENERGY: break;
			case FLUID: break;
			case ITEM: slots = 78; break;
			default: return ItemStack.EMPTY;
        } Print.debug(slots);
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(index < slots){
                if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 0, slots, false)){ return ItemStack.EMPTY; }
            if(itemstack1.isEmpty()){ slot.putStack(ItemStack.EMPTY); } else{ slot.onSlotChanged(); }
        } return itemstack;
    }

}
