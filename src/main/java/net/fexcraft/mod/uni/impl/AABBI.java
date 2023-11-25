package net.fexcraft.mod.uni.impl;

import net.fexcraft.mod.fvtm.data.block.AABB;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AABBI extends AABB {

    private AxisAlignedBB aabb;

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
    public <AB> AB offset(int x, int y, int z){
        return (AB)aabb.offset(x, y, z);
    }

}
