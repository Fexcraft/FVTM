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
	public static final net.fexcraft.mod.uni.world.AABB[] LAYERS8 = new net.fexcraft.mod.uni.world.AABB[8];
	static{
		LAYERS8[0] = net.fexcraft.mod.uni.world.AABB.create().set(0, 0, 0, 1, 1, 1);
		for(int i = 1; i < 8; i++){
			LAYERS8[i] = net.fexcraft.mod.uni.world.AABB.create().set(0, 0, 0, 1, i * 0.125, 1);
		}
	}
    protected List<net.fexcraft.mod.uni.world.AABB> aabbs;

    public AABBs(){
        aabbs = new ArrayList<>();
    }

    public AABBs(int i){
        if(i == 0){
            aabbs = ImmutableList.<net.fexcraft.mod.uni.world.AABB>of();
        }
        else if(i == 1){
            aabbs = ImmutableList.<net.fexcraft.mod.uni.world.AABB>of(net.fexcraft.mod.uni.world.AABB.create().set(0, 0, 0, 1, 1, 1));
        }
    }

    public AABBs(ArrayList<net.fexcraft.mod.uni.world.AABB> list){
        aabbs = list;
    }

    public AABBs(net.fexcraft.mod.uni.world.AABB... abs){
        aabbs = new ArrayList<>();
        for(net.fexcraft.mod.uni.world.AABB ab : abs) aabbs.add(ab);
    }

    public AABBs(float sx, float sy, float sz, float ex, float ey, float ez){
        this();
        aabbs.add(net.fexcraft.mod.uni.world.AABB.create(sx, sy, sz, ex, ey, ez));
    }

    public <AB> AB get(int idx){
        if(idx >= aabbs.size()) return null;
        return (AB)aabbs.get(idx).direct();
    }

    public net.fexcraft.mod.uni.world.AABB offset(int i, int x, int y, int z){
        return aabbs.get(i).offset(x, y, z);
    }

    public List<net.fexcraft.mod.uni.world.AABB> get(){
        return aabbs;
    }

    @Override
    public String toString(){
        return aabbs.toString();
    }

}
