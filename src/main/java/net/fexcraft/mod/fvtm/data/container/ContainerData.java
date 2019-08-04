package net.fexcraft.mod.fvtm.data.container;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContainerData extends DataCore<Container, ContainerData> implements Colorable, Textureable, Lockable {

	protected RGB primary, secondary;
	protected int selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean externaltex, locked;
    private NonNullList<ItemStack> stacks;
    private FluidTank fluidtank;
	
	public ContainerData(Container type){
		super(type);
		this.primary = type.getDefaultPrimaryColor().copy();
		this.secondary = type.getDefaultSecondaryColor().copy();
		//
        switch(type.getInventoryType()){
	        case ENERGY:
	            break;
	        case FLUID:
	            fluidtank = type.getFluidType() == null ? new FluidTank(type.getCapacity()) : new FluidTank(type.getFluidType(), 0, type.getCapacity());
	            break;
	        case ITEM:
	            stacks = NonNullList.<ItemStack>withSize(type.getCapacity(), ItemStack.EMPTY);
	            break;
	        default:
	            break;
	    }
	}

	@Override
	public RGB getPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getSecondaryColor(){
		return secondary;
	}

	@Override
	public void setPrimaryColor(RGB color){
		this.primary = color;
	}

	@Override
	public void setSecondaryColor(RGB color){
		this.secondary = color;
	}

	@Override
	public boolean isLocked(){
		return locked;
	}

	public ItemStack newItemStack(){
		ItemStack stack = this.type.newItemStack();
		stack.setTagCompound(this.write(new NBTTagCompound()));
		return stack;
	}

	@Override
	public ResourceLocation getTexture(){
		return selected_texture < 0 ? this.getCustomTexture() : type.getDefaultTextures().get(selected_texture);
	}

	@Override
	public int getSelectedTexture(){
		return selected_texture;
	}

	@Override
	public ResourceLocation getCustomTexture(){
		return externaltex ? ExternalTextureHelper.get(extex) : seltex;
	}

	@Override
	public String getCustomTextureString(){
		return externaltex ? extex : seltex.toString();
	}

	@Override
	public boolean isExternalTexture(){
		return externaltex;
	}

	@Override
	public void setSelectedTexture(int i, String tex, boolean ex){
		if(i < 0){
			this.externaltex = ex; this.selected_texture = -1;
			this.seltex = ex ? null : new ResourceLocation(tex);
			this.extex = ex ? tex : null;
		}
		else{
			this.selected_texture = i >= type.getDefaultTextures().size() ? type.getDefaultTextures().size() - 1 : i;
			this.seltex = null; this.extex = null;
		}
	}

	@Override
	public TextureHolder getHolder(){
		return type;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Container", type.getRegistryName().toString());
		compound.setInteger("RGBPrimary", primary.packed);
		compound.setInteger("RGBSecondary", secondary.packed);
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", externaltex);
		}
        if(type.getInventoryType() == InventoryType.ITEM){
            compound = DataUtil.saveAllItems(compound, stacks, true);
        }
        else if(type.getInventoryType() == InventoryType.FLUID){
            fluidtank.writeToNBT(compound);
        }
		compound.setBoolean("Locked", locked);
		return compound;
	}

	@Override
	public ContainerData read(NBTTagCompound compound){
		if(compound.hasKey("RGBPrimary")) primary.packed = compound.getInteger("RGBPrimary");
		if(compound.hasKey("RGBSecondary")) secondary.packed = compound.getInteger("RGBSecondary");
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			externaltex = compound.getBoolean("ExternalTexture");
			seltex = externaltex ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = externaltex ? compound.getString("CustomTexture") : null;
		} else{ seltex = null; extex = null; externaltex = false; }
        if(type.getInventoryType() == InventoryType.ITEM){
            DataUtil.loadAllItems(compound, stacks);
        }
        else if(type.getInventoryType() == InventoryType.FLUID){
            fluidtank.readFromNBT(compound);
        }
		this.locked = compound.getBoolean("Locked");
		return this;
	}

	@Override
	public ContainerData parse(JsonObject obj){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject toJson(){
		// TODO Auto-generated method stub
		return null;
	}

	public ContainerType getContainerType(){
		return type.getContainerType();
	}

    public NonNullList<ItemStack> getInventory(){
        return stacks;
    }

    public IFluidHandler getFluidHandler(){
        return fluidtank;
    }

    public FluidTank getFluidTank(){
        return fluidtank;
    }

	public boolean isItemValid(ItemStack stack){
		return type.getContentFilter() == null ? true : type.getContentFilter().isValid(this, stack);
	}

}
