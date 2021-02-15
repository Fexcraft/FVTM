package net.fexcraft.mod.fvtm.data.container;

import java.util.Map.Entry;
import java.util.TreeMap;

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

	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected int selected_texture;
	protected String extex, lockcode;
	protected ResourceLocation seltex;
	protected boolean externaltex, locked;
    private NonNullList<ItemStack> stacks;
    private FluidTank fluidtank;
	
	public ContainerData(Container type){
		super(type);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
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
	public RGB getColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public void setColorChannel(String channel, RGB color){
		channels.put(channel, color);
	}

	@Override
	public TreeMap<String, RGB> getColorChannels(){
		return channels;
	}

	@Override
	public boolean isLocked(){
		return locked;
	}

	@Override
	public String getLockCode(){
		return lockcode;
	}

	@Override
	public void setLocked(Boolean bool){
		locked = bool == null ? !locked : bool;
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
		for(String str : channels.keySet()){
			compound.setInteger("RGB_" + str, channels.get(str).packed);
		}
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", externaltex);
		}
        if(type.getInventoryType() == InventoryType.ITEM){
            compound = DataUtil.saveAllItems(compound, stacks, true, null);
        }
        else if(type.getInventoryType() == InventoryType.FLUID){
            fluidtank.writeToNBT(compound);
        }
		compound.setBoolean("Locked", locked);
		if(lockcode != null) compound.setString("LockCode", lockcode);
		return compound;
	}

	@Override
	public ContainerData read(NBTTagCompound compound){
		if(compound.hasKey("RGBPrimary")){
			channels.get("primary").packed = compound.getInteger("RGBPrimary");
		}
		if(compound.hasKey("RGBSecondary")){
			channels.get("secondary").packed = compound.getInteger("RGBSecondary");
		}
		for(String str : channels.keySet()){
			if(compound.hasKey("RGB_" + str)){
				channels.get(str).packed = compound.getInteger("RGB_" + str);
			}
		}
		//
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			externaltex = compound.getBoolean("ExternalTexture");
			seltex = externaltex ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = externaltex ? compound.getString("CustomTexture") : null;
		} else{ seltex = null; extex = null; externaltex = false; }
        if(type.getInventoryType() == InventoryType.ITEM){
            DataUtil.loadAllItems(compound, stacks, null);
        }
        else if(type.getInventoryType() == InventoryType.FLUID){
            fluidtank.readFromNBT(compound);
        }
		this.locked = compound.getBoolean("Locked");
		lockcode = compound.hasKey("LockCode") ? compound.getString("LockCode") : Lockable.newCode();
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
