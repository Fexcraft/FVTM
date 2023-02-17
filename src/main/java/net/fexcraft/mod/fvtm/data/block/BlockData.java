package net.fexcraft.mod.fvtm.data.block;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataCore;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.util.function.BoolBlockFunction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockData extends DataCore<Block, BlockData> implements Colorable, TextureUser {
	
	protected Textureable texture;
	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected MultiBlockData multidata;
	protected ArrayList<BlockFunction> functions = new ArrayList<>();
	protected ArrayList<BoolBlockFunction> boolfuncs = new ArrayList<>();

	public BlockData(Block type){
		super(type);
		texture = new Textureable(type);
		for(Entry<String, RGB> entry : type.getDefaultColorChannels().entrySet()){
			channels.put(entry.getKey(), entry.getValue().copy());
		}
		multidata = type.isFunctional() ? new MultiBlockData(this, type.getMultiBlock()) : null;
		for(BlockFunction func : type.getFunctions()){
			functions.add(func.copy(type));
		}
		functions.forEach(func -> {
			if(func instanceof BoolBlockFunction){
				boolfuncs.add((BoolBlockFunction)func);
			}
		});
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound){
		if(compound == null) compound = new NBTTagCompound();
		compound.setString("Block", type.getRegistryName().toString());
		//
		texture.save(compound);
		//
		for(String str : channels.keySet()){
			compound.setInteger("RGB_" + str, channels.get(str).packed);
		}
		if(multidata != null) compound.setTag("MultiBlock", multidata.write(null));
		NBTTagCompound com = new NBTTagCompound();
		for(BlockFunction func : functions) func.save(com);
		if(!com.isEmpty()) compound.setTag("BlockFunction", com);
		return compound;
	}

	@Override
	public BlockData read(NBTTagCompound compound){
		texture.load(compound, type);
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
		if(compound.hasKey("BlockFunction")){
			NBTTagCompound com = compound.getCompoundTag("BlockFunction");
			for(BlockFunction func : functions) func.load(com);
		}
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

	public RelayData getRelayData(){
		return type.getRelayData();
	}

	@Override
	public Textureable getTexture(){
		return texture;
	}

	@Override
	public TextureHolder getTexHolder(){
		return type;
	}

    public ArrayList<BlockFunction> getFunctions(){
		return functions;
    }

    public boolean getFunctionBool(String key){
		for(BoolBlockFunction func : boolfuncs){
			if(func.key().equals(key)) return func.val();
		}
		return false;
    }
}
