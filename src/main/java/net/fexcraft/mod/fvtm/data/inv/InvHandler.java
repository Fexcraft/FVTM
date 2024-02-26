package net.fexcraft.mod.fvtm.data.inv;

import java.util.ArrayList;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTickableTE;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerItem.StackEntry;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;

public class InvHandler {
	
	public final InvType type;
	protected String initarg;
	protected int capacity;

	public InvHandler(InvType type){
		this.type = type;
	}
	
	public InvHandler setArg(String str){
		if(this.getClass() == InvHandler.class) initarg = str;
		return this;
	}
	
	public InvHandler setCapacity(int val){
		if(this.getClass() == InvHandler.class) capacity = val;
		return this;
	}
	
	public InvHandler gen(int min){
		if(type.isItem()) return new InvHandlerItem(initarg, capacity, min);
		else if(type.isFluid()) return new InvHandlerFluid(initarg, capacity);
		else if(type.isContainer()) return null;
		else if(type.isVariable()) return new InvHandlerVar(initarg, capacity);
		return null;
	}
	
	public int capacity(){
		return capacity;
	}

	public String getFluid(){
		return null;
	}

	public ContentFilter getFilter(){
		return null;
	}
	
	//

	/*public NBTTagCompound save(NBTTagCompound compound){
		return save(compound, null);
	}

	public void load(NBTTagCompound compound){
		load(compound, null);
	}*/

	public TagCW save(TagCW compound, String ctag){
		return compound;
	}

	public void load(TagCW compound, String ctag){}
	
	//

	public ArrayList<StackEntry> getStacks(){
		return null;
	}

	public FluidTank getTank(){
		return null;
	}

	public String getContentDesc(){
		return "empty";
	}

	public void dropAllAt(Entity entity){
		//
	}

	public void dropAllAt(World world, BlockPos pos){
        //
	}

	public String getBlkSavePrefix(){
		if(type.isItem()) return "inv-";
		if(type.isFluid()) return "tank-";
		if(type.isVariable()) return "var-";
		return "";
	}

	public ItemStackHandler getStackHandler(){
		return null;
	}

	public Object getCapObj(){
		Static.exception(null, true);
		return null;
	}

	public int getVarValue(){
		return 0;
	}

	public void setVarValue(int i){
		//
	}

    public void update(MultiblockTickableTE tile, String key){}
}
