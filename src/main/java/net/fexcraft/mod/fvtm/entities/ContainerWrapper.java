package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class ContainerWrapper implements ContainerHolder {
	
	private VehicleEntity entity;
	private ContainerAttributeData attribute;
	private ContainerPosition type;
	private AxisAlignedBB bbox = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private int id;
	
	public ContainerWrapper(VehicleEntity ent, ContainerAttributeData data, ContainerPosition pos, int id){
		entity = ent; attribute = data; type = pos; this.id = id;
	}

	@Override
	public ContainerData getContainerData(){
		return attribute.getContainer(type);
	}

	@Override
	public boolean setContainerData(ContainerData data){
        if(data.getContainer().isLargeContainer()){
            if(attribute.getAttribute().getContainerType() != ContainerType.LARGE || type == ContainerPosition.MEDIUM_SINGLE){
                return false;
            }
            attribute.main = data; return true;
        }
        else if(data.getContainer().isMediumContainer()){
            if(attribute.getAttribute().getContainerType() == ContainerType.LARGE){
            	switch(type){
					case MEDIUM_SINGLE: case LARGE_SINGLE:
					case MEDIUM_DUAL1: attribute.main = data; return true;
					case MEDIUM_DUAL2: attribute.second = data; return true;
					default: return false;
            	}
            }
            else if(attribute.getAttribute().getContainerType() == ContainerType.MEDIUM){
            	attribute.main = data; return true;
            }
        }
        return false;
	}

	@Override
	public ContainerType getContainerType(){
		return attribute.getAttribute().getContainerType();
	}

	public boolean intersects(AxisAlignedBB aabb){
		Vec3d temp = entity.getAxes().getRelativeVector(getRelPos());
		return bbox.offset(entity.getEntity().posX + temp.x, entity.getEntity().posY + temp.y, entity.getEntity().posZ + temp.z).intersects(aabb);
	}
	
    private VehicleAxes conrot;
	
    private Vec3d getRelPos(){
    	Vec3d pos = attribute.getAttribute().getContainerOffset().to16Double();
		pos = new Vec3d(pos.x, -pos.y, pos.z);
		if(attribute == null){ return pos; }
		switch(attribute.getAttribute().getContainerType()){
			case LARGE:
				switch(this.id){
					case -1: return pos;
					case 0: case 1:{
						if(conrot == null){
							conrot = new VehicleAxes(attribute.getAttribute().getContainerRotation(), 0, 0);
						}
						pos = pos.addVector(id == 0 ? 3 : -3, 0, 0);
						pos = conrot.getRelativeVector(pos);
					}
				}
				break;
			case MEDIUM: default: return pos;
		}
    	return pos;
    }
	
}