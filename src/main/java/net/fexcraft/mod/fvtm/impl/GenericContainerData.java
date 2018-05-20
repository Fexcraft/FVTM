package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.impl.root.GenericColorable;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class GenericContainerData extends GenericColorable<ContainerData, Container> implements ContainerData {

    private NonNullList<ItemStack> stacks;
    private FluidTank fluidtank;

    public GenericContainerData(Container container){
        super(container);
        switch(container.getInventoryType()){
            case ENERGY:
                break;
            case FLUID:
                fluidtank = container.getFluidType() == null ? new FluidTank(container.getInventorySize()) : new FluidTank(container.getFluidType(), 0, container.getInventorySize());
                break;
            case FUEL:
                break;
            case ITEM:
                stacks = NonNullList.<ItemStack>withSize(container.getInventorySize(), ItemStack.EMPTY);
                break;
            default:
                break;
        }
    }

    @Override
    public Container getContainer(){
        return root;
    }

    @Override
    public int getSelectedTexture(){
        return sel;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagcompound){
        tagcompound.setString(ContainerItem.NBTKEY, root.getRegistryName().toString());
        NBTTagCompound compound = new NBTTagCompound();
        super.writeToNBT(compound);
        //
        if(root.getInventoryType() == InventoryType.ITEM){
            compound = ItemStackHelper.saveAllItems(compound, stacks);
        }
        else if(root.getInventoryType() == InventoryType.FLUID){
            fluidtank.writeToNBT(compound);
        }
        //
        tagcompound.setTag(FVTM.MODID + "_container", compound);
        return tagcompound;
    }

    @Override
    public ContainerData readFromNBT(NBTTagCompound tagcompound){
        NBTTagCompound compound = tagcompound.getCompoundTag(FVTM.MODID + "_container");
        super.readFromNBT(compound);
        //
        if(root.getInventoryType() == InventoryType.ITEM){
            ItemStackHelper.loadAllItems(compound, stacks);
        }
        else if(root.getInventoryType() == InventoryType.FLUID){
            fluidtank.readFromNBT(compound);
        }
        //
        return this;
    }

    @Override
    public NonNullList<ItemStack> getInventory(){
        return stacks;
    }

    @Override
    public IFluidHandler getFluidHandler(){
        return fluidtank;
    }

    @Override
    public FluidTank getFluidTank(){
        return fluidtank;
    }

}
