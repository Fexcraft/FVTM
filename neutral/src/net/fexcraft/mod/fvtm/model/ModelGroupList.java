package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class ModelGroupList extends ArrayList<ModelGroup> {

	public ModelGroupList(){
		super();
	}

	public ModelGroupList(ArrayList<ModelGroup> groups){
		super(groups);
	}

	public abstract void render(ModelRenderData data);

	public abstract ModelGroupList copyWithoutPrograms();

	public ModelGroup get(String key){
		for(ModelGroup group : this){
			if(group.name.equals(key)) return group;
		}
		return null;
	}

	public boolean contains(String key){
		for(ModelGroup group : this){
			if(group.name.equals(key)) return true;
		}
		return false;
	}

	//

	public static class DefaultModelGroupList extends ModelGroupList {

		public DefaultModelGroupList(){
			super();
		}

		public DefaultModelGroupList(ArrayList<ModelGroup> groups) {
			super(groups);
		}

		@Override
		public void render(ModelRenderData data){
			for(ModelGroup group : this) group.render(data);
		}

		@Override
		public ModelGroupList copyWithoutPrograms(){
			DefaultModelGroupList list = new DefaultModelGroupList();
			for(ModelGroup group : this){
				list.add(group.copyWithoutPrograms());
			}
			return list;
		}

	}

	public static Supplier<ModelGroupList> SEPARATE_GROUP_LIST = null;

}
