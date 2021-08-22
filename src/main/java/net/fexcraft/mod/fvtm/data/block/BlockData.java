package net.fexcraft.mod.fvtm.data.block;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockData extends DataCore<Block, BlockData> implements Textureable, Colorable {
	
	protected int selected_texture;
	protected String extex;
	protected ResourceLocation seltex;
	protected boolean isTextureExternal;
	//
	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected MultiBlockData multidata;

	public BlockData(Block type){
		super(type);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		multidata = type.isFunctional() ? new MultiBlockData(this, type.getMultiBlock()) : null;
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Block", type.getRegistryName().toString());
		//
		compound.setInteger("SelectedTexture", selected_texture);
		if(seltex != null || extex != null || selected_texture < 0){
			compound.setString("CustomTexture", seltex == null ? extex : seltex.toString());
			compound.setBoolean("ExternalTexture", isTextureExternal);
		}
		//
		for(String str : channels.keySet()){
			compound.setInteger("RGB_" + str, channels.get(str).packed);
		}
		if(multidata != null) compound.setTag("MultiBlock", multidata.write(null));
		return compound;
	}

	@Override
	public BlockData read(NBTTagCompound compound){
		this.selected_texture = compound.getInteger("SelectedTexture");
		if(selected_texture < 0){
			isTextureExternal = compound.getBoolean("ExternalTexture");
			seltex = isTextureExternal ? null : new ResourceLocation(compound.getString("CustomTexture"));
			extex = isTextureExternal ? compound.getString("CustomTexture") : null;
		}
		else{
			seltex = null;
			extex = null;
			isTextureExternal = false;
		}
		if(selected_texture >= type.getDefaultTextures().size()) selected_texture = 0;
		//
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
		if(compound.hasKey("MultiBlock")) multidata.read(compound.getCompoundTag("MultiBlock"));
		return this;
	}

	@Override
	public BlockData parse(JsonObject obj){
		//
		return this;
	}

	@Override
	public JsonObject toJson(){
		JsonObject obj = new JsonObject();
		obj.addProperty("Block", type.getRegistryName().toString());
		//
		return obj;
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
		return isTextureExternal ? ExternalTextureHelper.get(extex) : seltex;
	}

	@Override
	public String getCustomTextureString(){
		return isTextureExternal ? extex : seltex == null ? "" : seltex.toString();
	}

	@Override
	public boolean isExternalTexture(){
		return isTextureExternal;
	}

	@Override
	public void setSelectedTexture(int i, String tex, boolean ex){
		if(i < 0){
			this.isTextureExternal = ex; this.selected_texture = -1;
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

	public MultiBlockData getMultiBlockData(){
		return multidata;
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

}
