package net.fexcraft.mod.fvtm.util.function;

import com.google.gson.JsonObject;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InventoryBlockFunction extends BlockFunction {

	private InvHandler handler;
	private String key;
	private boolean bool = true;

	public BlockFunction parse(JsonObject obj){
		if(obj == null) return this;
		handler = new InvHandler(InvType.parse(obj.get("inv_type").getAsString(), true));
		if(obj.has("capacity")) handler.setCapacity(obj.get("capacity").getAsInt());
		if(obj.has("stacks")) handler.setCapacity(obj.get("stacks").getAsInt());
		if(obj.has("var")) handler.setArg(obj.get("var").getAsString());
		if(obj.has("fluid")) handler.setArg(obj.get("fluid").getAsString());
		if(obj.has("bool_key")) key = obj.get("bool_key").getAsString();
		if(obj.has("bool_val")) bool = obj.get("bool_val").getAsBoolean();
		return this;
	}

	@Override
	public BlockFunction load(NBTTagCompound com){
		if(com.hasKey(id())) handler.load(new TagCWI(com), id());
		return this;
	}

	@Override
	public NBTTagCompound save(NBTTagCompound com){
		handler.save(new TagCWI(com), id());
		return com;
	}

	@Override
	public String id(){
		return "fvtm:inventory";
	}

	@Override
	public BlockFunction copy(Block block){
		return new InventoryBlockFunction().set(handler.gen(1), key, bool);
	}

	public BlockFunction set(InvHandler invhandler, String k, boolean b){
		handler = invhandler;
		key = k;
		bool = b;
		return this;
	}

	@Override
	public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(hand == EnumHand.OFF_HAND) return false;
		int ui = handler.type.isFluid() ? GuiHandler.BLOCK_INVENTORY_FLUID : GuiHandler.BLOCK_INVENTORY_ITEM;
		if(key != null){
			BlockTileEntity tile = (BlockTileEntity)world.getTileEntity(pos);
			if(tile.getBlockData().getFunctionBool(key) != bool) return false;
		}
		player.openGui(FVTM.getInstance(), ui, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public InvHandler inventory(){
		return handler;
	}

	public void onClose(BlockTileEntity tile){
		BoolBlockFunction func = tile.getBlockData().getFunctionBoolInst(key);
		if(func != null) func.toggle(tile, !bool);
	}

	public boolean hasBool(){
		return key != null;
	}
}
