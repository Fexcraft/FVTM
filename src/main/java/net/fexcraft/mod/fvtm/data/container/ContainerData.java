package net.fexcraft.mod.fvtm.data.container;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContainerData extends DataCore<Container, ContainerData> implements Colorable, Textureable, Lockable {

	protected RGB primary, secondary;
	protected int selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean externaltex, locked;
	
	public ContainerData(Container type){
		super(type);
		this.primary = type.getDefaultPrimaryColor().copy();
		this.secondary = type.getDefaultSecondaryColor().copy();
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
		this.locked = compound.getBoolean("Locked");
		return null;
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

}
