package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ContainerInventory implements IInventory {

    private NonNullList<ItemStack> coninv = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);
    private ContainerAttributeData condata;

    public ContainerInventory(ContainerAttributeData attributeData){
        this.condata = attributeData;
        if(condata.getAttribute().getContainerType() == ContainerType.MEDIUM){
            coninv.set(1, new ItemStack(Blocks.BARRIER));
        }
        if(condata.main != null){
            coninv.set(0, condata.main.getContainer().getItemStack(condata.main));
        }
        if(condata.second != null){
            coninv.set(0, condata.main.getContainer().getItemStack(condata.main));
        }
    }

    @Override
    public String getName(){
        return coninv == null || coninv.isEmpty() || coninv.get(0).isEmpty() ? "Null;" : coninv.get(0).getDisplayName();
    }

    @Override
    public boolean hasCustomName(){
        return true;
    }

    @Override
    public ITextComponent getDisplayName(){
        return new TextComponentString(getName());
    }

    @Override
    public int getSizeInventory(){
        return 2;
    }

    @Override
    public boolean isEmpty(){
        return coninv.get(0).isEmpty() && coninv.get(1).isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int index){
        return coninv.get(index);
    }

    @Override
    public ItemStack decrStackSize(int index, int count){
        return can(index) && !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(coninv, index, count) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeStackFromSlot(int index){
        return can(index) ? coninv.set(index, ItemStack.EMPTY) : ItemStack.EMPTY;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack){
        if(can(index)){
            coninv.set(index, stack);
        }
    }

    @Override
    public int getInventoryStackLimit(){
        return 1;
    }

    @Override
    public void markDirty(){
        //
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player){
        return !player.isDead;
    }

    @Override
    public void openInventory(EntityPlayer player){
        // Apparently this doesn't get called, let's use the constructor instead;
    }

    @Override
    public void closeInventory(EntityPlayer player){
        condata.main = (!coninv.get(0).isEmpty()) ? get(coninv.get(0)) : null;
        condata.second = (!coninv.get(1).isEmpty() && can(1)) ? get(coninv.get(1)) : null;
        (((SeatEntity) player.getRidingEntity()).getVehicle()).syncVehicleData();
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack){
        if(stack.getItem() instanceof Container.ContainerItem){
            ContainerData data = get(stack);
            if(data.getContainer().isLargeContainer()){
                if(index == 1){
                    return false;
                }
                if(condata.getAttribute().getContainerType() == ContainerType.LARGE){
                    return coninv.get(1).isEmpty();
                }
                else if(condata.getAttribute().getContainerType() == ContainerType.MEDIUM){
                    return false;
                }
            }
            else if(data.getContainer().isMediumContainer()){
                if(condata.getAttribute().getContainerType() == ContainerType.LARGE){
                    return (coninv.get(0).isEmpty() || !get(coninv.get(0)).getContainer().isLargeContainer());
                }
                else if(condata.getAttribute().getContainerType() == ContainerType.MEDIUM){
                    return coninv.get(0).isEmpty() && index != 1;
                }
            }
        }
        return false;
    }

    private boolean can(int i){
        return i == 1 ? !(coninv.get(1).getItem() instanceof ItemBlock) && !(((ItemBlock) coninv.get(1).getItem()).getBlock() == Blocks.BARRIER) : true;
    }

    private ContainerData get(ItemStack stack){
        return ((ContainerItem) stack.getItem()).getContainer(stack);
    }

    @Override
    public int getField(int id){
        return 0;
    }

    @Override
    public void setField(int id, int value){
        //
    }

    @Override
    public int getFieldCount(){
        return 0;
    }

    @Override
    public void clear(){
        coninv.clear();
    }

}
