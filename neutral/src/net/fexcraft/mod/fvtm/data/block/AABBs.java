package net.fexcraft.mod.fvtm.data.block;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AABBs {

    public static final AABBs EMPTY = new AABBs(0);
    public static final AABBs FULL = new AABBs(1);
    protected List<AABB> aabbs;

    public AABBs(){
        aabbs = new ArrayList<>();
    }

    public AABBs(int i){
        if(i == 0){
            aabbs = ImmutableList.<AABB>of();
        }
        else if(i == 1){
            aabbs = ImmutableList.<AABB>of(AABB.create().set(0, 0, 0, 1, 1, 1));
        }
    }

    public AABBs(ArrayList<AABB> list){
        aabbs = list;
    }

    public AABBs(float sx, float sy, float sz, float ex, float ey, float ez){
        this();
        aabbs.add(AABB.create(sx, sy, sz, ex, ey, ez));
    }

    public <AB> AB get(int idx){
        if(idx >= aabbs.size()) return null;
        return (AB)aabbs.get(idx).direct();
    }

    public AABB offset(int i, int x, int y, int z){
        return aabbs.get(i).offset(x, y, z);
    }

    public List<AABB> get(){
        return aabbs;
    }

    @Override
    public String toString(){
        return aabbs.toString();
    }

}
