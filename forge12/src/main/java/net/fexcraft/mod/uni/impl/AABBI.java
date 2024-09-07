package net.fexcraft.mod.uni.impl;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.block.AABB;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AABBI extends AABB {

    private AxisAlignedBB aabb;

    public AABBI(){}

    public AABBI(AxisAlignedBB albb){
        aabb = albb;
    }


    @Override
    public AABB set(float sx, float sy, float sz, float ex, float ey, float ez){
        aabb = new AxisAlignedBB(sx, sy, sz, ex, ey, ez);
        return this;
    }

    @Override
    public <AB> AB local(){
        return (AB)aabb;
    }

    @Override
    public Object direct(){
        return aabb;
    }

    @Override
    public AABB offset(int x, int y, int z){
        return new AABBI(aabb.offset(x, y, z));
    }

    @Override
    public AABB offset(V3D vec){
        return new AABBI(aabb.offset(vec.x, vec.y, vec.z));
    }

    @Override
    public boolean contains(V3D vec){
        return aabb.contains(new Vec3d(vec.x, vec.y, vec.z));
    }

    @Override
    public boolean contains(Object vec){
        return aabb.contains((Vec3d)vec);
    }

}
