package net.fexcraft.mod.fvtm.util.function;

import com.google.gson.JsonObject;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoolBlockFunction extends BlockFunction {

	private String key;
	private boolean value;

	public BlockFunction parse(JsonObject obj){
		if(obj == null) return this;
		key = obj.get("key").getAsString();
		value = obj.has("value") && obj.get("value").getAsBoolean();
		return this;
	}

	@Override
	public BlockFunction load(NBTTagCompound com){
		if(com.hasKey(save_id())) value = com.getBoolean(save_id());
		return this;
	}

	@Override
	public NBTTagCompound save(NBTTagCompound com){
		com.setBoolean(save_id(), value);
		return com;
	}

	@Override
	public String id(){
		return "fvtm:bool_value";
	}

	public String save_id(){
		return "fvtm:bool_value_" + key;
	}

	@Override
	public BlockFunction copy(net.fexcraft.mod.fvtm.data.block.Block block) {
		return new BoolBlockFunction().copy(key, value);
	}

	public BlockFunction copy(String k, boolean v){
		key = k;
		value = v;
		return this;
	}

	@Override
	public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(hand == EnumHand.OFF_HAND) return false;
		value = !value;
		BlockTileEntity tile = ((BlockTileEntity)world.getTileEntity(pos));
		if(tile != null) sendClientSync(tile.getBlockData(), pos, world.provider.getDimension());
		return true;
	}

	public String key(){
		return key;
	}

	public boolean val(){
		return value;
	}

	public void toggle(BlockTileEntity tile, Boolean to){
		value = to == null ? !value : to;
		if(tile == null) return;
		sendClientSync(tile.getBlockData(), tile.getPos(), tile.getWorld().provider.getDimension());
	}
}
