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
		if(!obj.has("Sides")){ return EMPTY; }
		GenericBlockIOT blk = new GenericBlockIOT();
		obj.get("Sides").getAsJsonArray().forEach(elm -> {
			JsonObject jsn = elm.getAsJsonObject();
			EnumFacing facing = null;
			switch(jsn.get("side").getAsString().toLowerCase()){
				case "top": case "up": facing = EnumFacing.UP; break;
				case "bottom": case "down": facing = EnumFacing.DOWN; break;
				case "west": facing = EnumFacing.WEST; break;
				case "east": facing = EnumFacing.EAST; break;
				case "north": facing = EnumFacing.NORTH; break;
				case "south": facing = EnumFacing.SOUTH; break;
				default: break;
			}
			if(facing != null){
				if(jsn.has("gui")){
					blk.guitypes[facing.getIndex()] = jsn.get("gui").getAsString();
				}
				if(jsn.has("tank")){
					blk.tanks[facing.getIndex()] = jsn.get("tank").getAsString();
				}
				if(jsn.has("inventory")){
					blk.stacks[facing.getIndex()] = jsn.get("inventory").getAsString();
				}
			}
			else{
				String gui = jsn.has("gui") ? jsn.get("gui").getAsString() : null;
				String tank = jsn.has("tank") ? jsn.get("tank").getAsString() : null;
				String inv = jsn.has("inventory") ? jsn.get("inventory").getAsString() : null;
				for(int i = 0; i < 6; i++){
					if(blk.guitypes[i] == null){ blk.guitypes[i] = gui; }
					if(blk.tanks[i] == null){ blk.tanks[i] = tank; }
					if(blk.stacks[i] == null){ blk.stacks[i] = inv; }
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
	
	@Override
	public String toString(){
		return "GBIOT " + (empty ? "EMPTY" : guitypes + " " + tanks + " " + stacks) + ";";
	}
	
}