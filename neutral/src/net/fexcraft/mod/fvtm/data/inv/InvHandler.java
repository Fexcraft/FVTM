package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class InvHandler {

	public final InvType type;
	protected int capacity;

	public InvHandler(InvType type){
		this.type = type;
	}

	public InvHandler setArg(String str){
		return this;
	}

	public InvHandler setCapacity(int val){
		return this;
	}

	public InvHandler gen(int min){
		return this;
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

	public abstract TagCW save(TagCW compound, String ctag);

	public abstract void load(TagCW compound, String ctag);

	//

	public abstract String getContentDesc();

	public void dropAllAt(EntityW entity){}

	public void dropAllAt(WorldW world, V3I pos){}

	public abstract String getSavePrefix();

	public ArrayList<StackEntry> getStacks(){
		return null;
	}

	public <FT> FT getTank(){
		return null;
	}

	public <ISH> ISH getStackHandler(){
		return null;
	}

	public Object getCapability(){
		return null;
	}

	public int getVarValue(){
		return 0;
	}

	public void setVarValue(int i){}

	public void update(Object tile, String key, boolean remote){}
}
