package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Print;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Yes, yes I know this is how it is.
 * 
 * @author Ferdinand Calo' (FEX___96)
 * */
public class CollisionGrid extends AxisAlignedBB {
	
	private ArrayList<AABB> aabbs = new ArrayList<>();
	
	public CollisionGrid(){ super(0, 0, 0, 0, 0, 0); }

	/**
	 * @param from grid root pos
	 * @param size grid size
	 * @param ut UnitSize
	 * @param id ID (null = vehicle)
	 * @return this grid after new aabbs are added
	 */
	public CollisionGrid addGrid(Pos from, Pos size, float ut, String id){
		float hut = ut / 2;
		for(int x = 0; x < size.x; x++){
			for(int y = 0; y < size.y; y++){
				for(int z = 0; z < size.z; z++){
					addAABB(ut, new Vec3f(from.x + hut + (x * ut), from.y + hut + (y * ut), from.z + hut + (z * ut)), id);
				}
			}
		} return this;
	}
	
	public CollisionGrid addGrid(CollisionGrid othergrid){
		this.aabbs.addAll(othergrid.aabbs); return this;
	}
	
	public CollisionGrid addAABB(float ut, Vec3f pos, String id){
		aabbs.add(new AABB(ut, pos, id)); return this;
	}
	
	public CollisionGrid clone(){
		CollisionGrid grid = new CollisionGrid();
		for(AABB aabb : aabbs) grid.aabbs.add(aabb.clone());
		return grid;
	}
	
	/** Initially intended as extending AxisAlignedBB, but apparently that one has FINAL fields.*/
	public static class AABB {
		
		public AxisAlignedBB axis;
		private Vec3f relpos; private Vec3d actualpos;
		private String id; private double unitsize;
		
		public AABB(double unitsize, Vec3f pos, String id){
			this.id = id; this.relpos = pos; this.unitsize = unitsize;
			actualpos = new Vec3d(pos.xCoord, pos.yCoord, pos.zCoord); axis = refresh();
		}

		public AABB clone(){
			return new AABB(unitsize, relpos, id);
		}
		
		public void updatePosition(Axis3D axe){
			actualpos = axe.getRelativeVector(relpos.xCoord, relpos.yCoord, relpos.zCoord); axis = refresh();
		}
		
		private AxisAlignedBB refresh(){
			return new AxisAlignedBB(unitsize - actualpos.x, unitsize - actualpos.y, unitsize - actualpos.z,
				unitsize + actualpos.x, unitsize + actualpos.y, unitsize + actualpos.z);
		}

		public Vec3d getCurrentPos(){
			return actualpos;
		}
		
	}
	
	@Override
    public boolean intersects(AxisAlignedBB other){
		Print.debug(other);
		for(AABB aabb : aabbs){ if(aabb.axis.intersects(other)) return true; } return false;
    }

	@Override
    public boolean intersects(double x1, double y1, double z1, double x2, double y2, double z2){
		Print.debug(x1, y1, z1, x2, y2, z2);
		for(AABB aabb : aabbs){ if(aabb.axis.intersects(x1, y1, z1, x2, y2, z2)) return true; } return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean intersects(Vec3d min, Vec3d max){
        return this.intersects(Math.min(min.x, max.x), Math.min(min.y, max.y), Math.min(min.z, max.z), Math.max(min.x, max.x), Math.max(min.y, max.y), Math.max(min.z, max.z));
    }
    
    @Override
    public boolean contains(Vec3d vec){
    	for(AABB aabb : aabbs){ if(aabb.axis.contains(vec)) return true; } return false;
    }

	public void update(Axis3D axes){
		axes.rotateYawD(-90); for(AABB aabb : aabbs) aabb.updatePosition(axes);
	}

	public ArrayList<AABB> getAABBs(){
		return aabbs;
	}

}
