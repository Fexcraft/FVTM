package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BarrelBlockFunction extends BlockFunction {

	private int stored, capacity;
	private String content_cat, stored_id;
	private ArrayList<String> compatible = new ArrayList<>();

	public BlockFunction parse(JsonObject obj){
		if(obj == null) return this;
		capacity = obj.has("capacity") ? obj.get("capacity").getAsInt() : 1000;
		content_cat = obj.has("category") ? obj.get("category").getAsString() : "barrel";
		if(obj.has("compatible")){
			JsonArray array = obj.get("compatible").getAsJsonArray();
			for(JsonElement elm : array){
				compatible.add(elm.getAsString());
			}
		}
		return this;
	}

	@Override
	public BlockFunction load(NBTTagCompound com){
		if(com.hasKey(id())){
			NBTTagCompound nbt = com.getCompoundTag(id());
			stored = nbt.getInteger("stored");
			stored_id = nbt.getString("stored_id");
		}
		return this;
	}

	@Override
	public NBTTagCompound save(NBTTagCompound com){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("stored", stored);
		if(stored_id != null) nbt.setString("stored_id", stored_id);
		nbt.setInteger("capacity", capacity);
		com.setTag(id(), nbt);
		return com;
	}

	@Override
	public String id(){
		return "fvtm:barrel";
	}

	@Override
	public BlockFunction copy(Block block){
		return new BarrelBlockFunction().set(capacity, content_cat, compatible);
	}

	public BlockFunction set(int c, String cc, ArrayList<String> ccc){
		capacity = c;
		content_cat = cc;
		compatible.addAll(ccc);
		return this;
	}

	@Override
	public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(hand == EnumHand.OFF_HAND) return false;
		//
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World world, BlockData data, List<String> list, boolean adv){
		list.add(Formatter.format("&eContent Category: &7" + content_cat));
		for(String str : compatible){
			list.add(Formatter.format("&e- &7" + str));
		}
		list.add(Formatter.format("&eStored: &7" + stored + "/" + capacity));
		list.add(Formatter.format("&e of &7" + (stored_id == null || stored_id.length() == 0 ? "nothing" : stored_id)));
	}

}
