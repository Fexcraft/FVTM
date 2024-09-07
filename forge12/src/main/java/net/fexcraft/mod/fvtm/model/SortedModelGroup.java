package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.render.SeparateRenderCache;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.tileentity.TileEntity;

public abstract class SortedModelGroup extends ArrayList<ModelGroup> {

	public SortedModelGroup(ArrayList<ModelGroup> groups) {
		super(groups);
	}

	public abstract void render(ModelRenderData data);

	public static class GenericSortedModelGroup extends SortedModelGroup {

		public GenericSortedModelGroup(ArrayList<ModelGroup> groups) {
			super(groups);
		}

		@Override
		public void render(ModelRenderData data){
			for(ModelGroup group : this) group.render(data);
		}

	}

	public static class SeparateSortedModelGroup extends SortedModelGroup {

		public SeparateSortedModelGroup(ArrayList<ModelGroup> groups) {
			super(groups);
		}

		@Override
		public void render(ModelRenderData data){
			if(data.separaterender){
				for(ModelGroup group : this) group.render(data);
				return;
			}
			if(data.entity == null){
				if(data.tile == null || data.block == null) return;
				SeparateRenderCache.SORTED_BLK_QUEUE.add(this);
				SeparateRenderCache.SORTED_BLK_DATA.add(data.block);
				SeparateRenderCache.SORTED_BLK_ENTITY.add((TileEntity)data.tile);
			}
			else{
				SeparateRenderCache.SORTED_VEH_QUEUE.add(this);
				SeparateRenderCache.SORTED_VEH_DATA.add(data.vehicle);
				SeparateRenderCache.SORTED_VEH_ENTITY.add((RootVehicle)data.entity);
			}
		}

	}

}
