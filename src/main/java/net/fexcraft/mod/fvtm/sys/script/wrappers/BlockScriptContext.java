package net.fexcraft.mod.fvtm.sys.script.wrappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiFunction;

import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.util.script.FSBlockScript;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;

public class BlockScriptContext extends WrapperElm {

	public HashMap<String, BiFunction<ScrBlock, ArrayList<Elm>, Elm>> exes = new HashMap<>();
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
	public String string_val(){
		return "{block-context}";
	}

	@Override
	public Elm get(ScrBlock block, String target){
		if(target.equals("client")){
			return entity.getWorld().isRemote ? TRUE : FALSE;
		}
		return NULL;
	}

	@Override
	public Elm exec(ScrBlock block, String act, ArrayList<Elm> args){
		Elm val = NULL;
		BiFunction<ScrBlock, ArrayList<Elm>, Elm> exe = exes.get(act);
		if(exe != null){
			return exe.apply(block, args);
		}
		return val;
	}

	@Override
	public boolean overrides(){
		return true;
	}

	public Elm update(MultiblockTickableTE tile){
		entity = tile;
		return this;
	}

	public TileEntity entity(){
		return entity;
	}

}
