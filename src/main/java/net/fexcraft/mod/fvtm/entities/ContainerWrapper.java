package net.fexcraft.mod.fvtm.entities;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerHolder;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class ContainerWrapper implements ContainerHolder {
	
	private VehicleEntity entity;
	private ContainerAttributeData attribute;
	private ContainerPosition type;
	private Vec3d position;
	
	public ContainerWrapper(VehicleEntity ent, ContainerAttributeData data, ContainerPosition pos, Vec3d offset){
		entity = ent; attribute = data; type = pos; position = offset;
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
		return false;//TODO
	}
	
}