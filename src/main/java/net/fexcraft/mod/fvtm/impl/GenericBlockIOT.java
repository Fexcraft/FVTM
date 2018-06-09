package net.fexcraft.mod.fvtm.impl;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Block;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockIOT;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

public class GenericBlockIOT implements Block.BlockIOT {
	
	public static final BlockIOT EMPTY = new GenericBlockIOT();
	private String[] guitypes = new String[6], tanks = new String[6], stacks = new String[6];
	boolean empty = false;
	
	private GenericBlockIOT(){ empty = true; }
	
	public static BlockIOT fromJson(JsonObject obj){
		if(!obj.has("Sides")){
			return EMPTY;
		}
		GenericBlockIOT blk = new GenericBlockIOT();
		obj.get("Sides").getAsJsonArray().forEach(elm -> {
			JsonObject jsn = elm.getAsJsonObject();
			EnumFacing facing = EnumFacing.byName(jsn.get("side").getAsString());
			if(facing != null){
				blk.guitypes[facing.getIndex()] = jsn.has("gui") ? jsn.get("gui").getAsString() : null;
				blk.tanks[facing.getIndex()] = jsn.has("tank") ? jsn.get("tank").getAsString() : null;
				blk.stacks[facing.getIndex()] = jsn.has("inventory") ? jsn.get("inventory").getAsString() : null;
			}
			else{
				String gui = jsn.has("gui") ? jsn.get("gui").getAsString() : null;
				String tank = jsn.has("tank") ? jsn.get("tank").getAsString() : null;
				String inv = jsn.has("inventory") ? jsn.get("inventory").getAsString() : null;
				for(int i = 0; i < 6; i++){
					blk.guitypes[i] = gui; blk.tanks[i] = tank; blk.stacks[i] = inv;
				}
			}
		});
		return blk;
	}

	@Override
	public boolean hasGui(EnumFacing facing){
		return empty ? false : true;
	}

	@Override
	public String getGuiType(EnumFacing facing){
		return guitypes[facing.getIndex()];
	}

	@Override
	public boolean hasFluidTank(EnumFacing facing){
		return tanks[facing.getIndex()] != null;
	}

	@Override
	public IFluidHandler getFluidTank(BlockData data, EnumFacing facing){
		return data.getFluidTanks().get(tanks[facing.getIndex()]);
	}

	@Override
	public boolean hasInventory(EnumFacing facing){
		return stacks[facing.getIndex()] != null;
	}

	@Override
	public IItemHandler getInventory(BlockData data, EnumFacing facing){
		return data.getInventories().get(stacks[facing.getIndex()]);
	}
	
}