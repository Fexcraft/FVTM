package net.fexcraft.mod.fvtm.data.part;

import java.util.List;

import net.fexcraft.app.json.FJson;
import net.fexcraft.mod.fvtm.sys.condition.CondMode;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;

/**
 * Part Function
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class PartFunction {

	public abstract PartFunction init(Part part, FJson json);
	
	public abstract PartFunction load(TagCW compound);
	
	public abstract TagCW save(TagCW compound);

	public abstract String getId();
	
	/** Used to crease an use-copy from the "default" function stored in a Part. */
	public abstract PartFunction copy(Part Part);
	
	public static abstract class StaticFunction extends PartFunction {

		@Override
		public PartFunction load(TagCW compound){
			return this;
		}

		@Override
		public TagCW save(TagCW compound){
			return null;
		}

		@Override
		public PartFunction copy(Part part){
			return this;
		}
		
	}

    public void addInformation(StackWrapper stack, WorldW world, PartData data, List<String> list, boolean extended){}

	public boolean onCondition(String[] targets, CondMode mode, String condi){
		return false;
	}

}
