package net.fexcraft.mod.fvtm.data.container;

import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonObject;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.ContentData;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ContainerData extends ContentData<Container, ContainerData> implements Colorable, TextureUser {

	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected Textureable texture;
	private InvHandler inventory;
	protected Lockable lock;
	
	public ContainerData(Container type){
		super(type);
		texture = new Textureable(type);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		inventory = type.invtype.gen(type.type.length() * 3);
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

	public Lockable getLock(){
		return lock;
	}

	@Override
	public TagCW write(TagCW compound){
		if(compound == null) compound = TagCW.create();
		compound.set("Container", type.getIDS());
		for(String str : channels.keySet()){
			compound.set("RGB_" + str, channels.get(str).packed);
		}
		texture.save(new TagCWI(compound));
		inventory.save(new TagCWI(compound), "Inventory");
		lock.save(new TagCWI(compound));
		return compound;
	}

	@Override
	public ContainerData read(TagCW compound){
		if(compound.has("RGBPrimary")){
			channels.get("primary").packed = compound.getInteger("RGBPrimary");
		}
		if(compound.has("RGBSecondary")){
			channels.get("secondary").packed = compound.getInteger("RGBSecondary");
		}
		for(String str : channels.keySet()){
			if(compound.has("RGB_" + str)){
				channels.get(str).packed = compound.getInteger("RGB_" + str);
			}
		}
		//
		texture.load(new TagCWI(compound));
		inventory.load(new TagCWI(compound), "Inventory");
		lock.load(new TagCWI(compound));
		return this;
	}

	@Override
	public ContainerData parse(JsonMap obj){
		return this;
	}

	@Override
	public JsonMap toJson(){
		return new JsonMap();
	}

	public ContainerType getContainerType(){
		return type.getContainerType();
	}

    public InvHandler getInventory(){
        return inventory;
    }

	@Override
	public Textureable getTexture(){
		return texture;
	}

	@Override
	public TextureHolder getTexHolder(){
		return type;
	}

}
