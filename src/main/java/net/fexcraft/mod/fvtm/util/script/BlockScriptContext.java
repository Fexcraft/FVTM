package net.fexcraft.mod.fvtm.util.script;

import net.fexcraft.lib.script.ScrBlock;
import net.fexcraft.lib.script.ScrElm;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;

public class BlockScriptContext implements ScrElm {

	public HashMap<String, BiFunction<ScrBlock, ArrayList<ScrElm>, ScrElm>> exes = new HashMap<>();
	private FSBlockScript wrapper;
	private BlockTileEntity entity;
	protected MultiBlockData data;
	//
	private NBTTagCompound packet;
	private Side side;

	public BlockScriptContext(MultiBlockData data, FSBlockScript fscript){
		this.data = data;
		wrapper = fscript;
	}

	@Override
	public String scr_str(){
		return "{block-context}";
	}

	@Override
	public ScrElm scr_get(ScrBlock block, String target){
		if(target.equals("client")){
			return entity.getWorld().isRemote ? TRUE : FALSE;
		}
		return NULL;
	}

	@Override
	public ScrElm scr_exec(ScrBlock block, String act, ArrayList<ScrElm> args){
		ScrElm val = NULL;
		BiFunction<ScrBlock, ArrayList<ScrElm>, ScrElm> exe = exes.get(act);
		if(exe != null){
			return exe.apply(block, args);
		}
		return val;
	}

	@Override
	public boolean overrides(){
		return true;
	}

	public ScrElm update(MultiblockTickableTE tile){
		entity = tile;
		return this;
	}

	public TileEntity entity(){
		return entity;
	}

	public MultiBlockData mdata(){
		return data;
	}

}
