package net.fexcraft.mod.fvtm.data.inv;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InvHandlerInit extends InvHandler{

	protected String initarg;

	public InvHandlerInit(InvType type){
		super(type);
	}

	public InvHandler setArg(String str){
		initarg = str;
		return this;
	}

	public InvHandler setCapacity(int val){
		capacity = val;
		return this;
	}

	@Override
	public InvHandler gen(int min){
		try{
			if(type.isItem()){
				return InvHandlerItem.IMPL.getConstructor(String.class, int.class, int.class)
					.newInstance(initarg, capacity, min);
			}
			else if(type.isFluid()){
				return InvHandlerFluid.IMPL.getConstructor(String.class, int.class)
					.newInstance(initarg, capacity);
			}
			else if(type.isContainer()) return null;
			else if(type.isVariable()) return new InvHandlerVar(initarg, capacity);
		}
		catch(Exception e){
			FvtmLogger.log(e, "Inventory Handler Generation / " + type.name + " " + capacity + " " + initarg);
		}
		return null;
	}

	@Override
	public TagCW save(TagCW compound, String ctag){
		return null;
	}

	@Override
	public void load(TagCW compound, String ctag){

	}

	@Override
	public String getContentDesc(){
		return null;
	}

	@Override
	public void dropAllAt(EntityW entity){

	}

	@Override
	public void dropAllAt(WorldW world, V3I pos){

	}

	@Override
	public String getSavePrefix(){
		return null;
	}

	@Override
	public ArrayList<StackEntry> getStacks(){
		return null;
	}

	@Override
	public <FT> FT getTank(){
		return null;
	}

	@Override
	public <ISH> ISH getStackHandler(){
		return null;
	}

	@Override
	public Object getCapability(){
		return null;
	}

}
