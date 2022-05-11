package net.fexcraft.lib.tmt;

import java.util.ArrayList;
import java.util.Map;

import net.fexcraft.lib.common.math.RGB;

/**
 * Color Indexed Voxel Builder for MRT<br>
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ColorIndexedVoxelBuilder {
	
	private ModelRendererTurbo root;
	private int[][][] data;
	private Map<Integer, RGB> colours;
	private int segx, segy, segz;
	
	public ColorIndexedVoxelBuilder(ModelRendererTurbo turbo, int segments){
		this.root = turbo == null ? new ModelRendererTurbo(null) : turbo;
		this.segx = segments;
		this.segy = segments;
		this.segz = segments;
	}
	
	public ColorIndexedVoxelBuilder(ModelRendererTurbo turbo, int x, int y, int z){
		this.root = turbo == null ? new ModelRendererTurbo(null) : turbo;
		this.segx = x;
		this.segy = y;
		this.segz = z;
	}

	public ColorIndexedVoxelBuilder setVoxels(int[][][] content){
		data = new int[segx][segy][segz];
		for(int x = 0; x < segx; x++){
			for(int y = 0; y < segy; y++){
				for(int z = 0; z < segz; z++){
					data[x][y][z] = content[x][y][z];
				}
			}
		} return this;
	}

	public ColorIndexedVoxelBuilder setColors(Map<Integer, RGB> colours){
		this.colours = colours;
		return this;
	}
	
	public ColorIndexedVoxelBuilder addVoxels(int xf, int yf, int zf, int xt, int yt, int zt, int value){
		if(data == null)data = new int[segx][segy][segz];
		for(int x = xf; x < xt; x++)
			for(int y = yf; y < yt; y++)
				for(int z = zf; z < zt; z++)
					data[x][y][z] = value;
		return this;
	}
	
	/*public VoxelBuilder setSidesHidden(boolean front, boolean back, boolean left, boolean right, boolean top, boolean bottom){
		sides = new boolean[]{ front, back, left, right, top, bottom }; return this;
	}
	
	public VoxelBuilder setSidesHidden(boolean... bools){
		if(bools == null || bools.length < 1) return setSidesHidden(false, false, false, false, false, false);
		sides = new boolean[]{ false, bools.length < 2 ? false : bools[1], bools.length < 3 ? false : bools[2],
			bools.length < 4 ? false : bools[3], bools.length < 5 ? false : bools[4], bools.length < 6 ? false : bools[5] };
		return this;
	}*/

	public ModelRendererTurbo build(){
		ArrayList<int[]> rects = rectangulate();
		root.childModels = new ArrayList<>();
		for(int[] rect : rects){
			int x = rect[3] - rect[0], y = rect[4] - rect[1], z = rect[5] - rect[2];
			ModelRendererTurbo turbo = new ModelRendererTurbo(root).addBox(rect[0], rect[1], rect[2], x + 1, y + 1, z + 1);
			root.childModels.add(turbo.setTextured(false).setColor(colours.get(rect[6])));
		}
		return root;
	}

	public ArrayList<int[]> buildCoords(){
		ArrayList<int[]> rects = rectangulate(), export = new ArrayList<>();
		for(int[] rect : rects){
			int x = rect[3] - rect[0], y = rect[4] - rect[1], z = rect[5] - rect[2];
			export.add(new int[]{ rect[0], rect[1], rect[2], x + 1, y + 1, z + 1 });
		} return export;
	}
	
	public ArrayList<int[]> rectangulate(){
		//System.out.println("Starting rectangulation.");
		ArrayList<int[]> rects = new ArrayList<int[]>();
		for(int i : colours.keySet()){
			//if(i == 0) continue;
			for(int x = 0; x < segx; x++){
				for(int y = 0; y < segy; y++){
					for(int z = 0; z < segz; z++){
						if(contains(x, y, z, i)){
							//System.out.println("Found at " + x + ", " + y + ", " + z + "!");
							rects.add(find(x, y, z, i));
						}
					}
				}
			}
			//System.out.println("Processed color " + i + "!");
		}
		//System.out.println("Finished rectangulation.");
		return rects;
	}

	private int[] find(int sx, int sy, int sz, int color){
		int ix = 1, iy = 1, iz = 1, lx = 0, ly = 0, lz = 0; boolean failed = false;
		ArrayList<VV3> allrem = new ArrayList<>(), torem = new ArrayList<>(); 
		while(true){
			if(lx != ix){
				int x = sx + ix;
				for(int y = sy; y < sy + ly + 1; y++){
					for(int z = sz; z < sz + lz + 1; z++){
						if(contains(x, y, z, color)){
							torem.add(new VV3(x, y, z));
						}
						else{
							failed = true;
							break;
						}
					}
				}
				if(failed){ failed = false; ix = lx; }
				else{ lx = ix; ix++; allrem.addAll(torem); }
				torem.clear(); 
			}
			if(lz != iz){
				int z = sz + iz;
				for(int x = sx; x < sx + lx + 1; x++){
					for(int y = sy; y < sy + ly + 1; y++){
						if(contains(x, y, z, color)){
							torem.add(new VV3(x, y, z));
						}
						else{
							failed = true;
							break;
						}
					}
				}
				if(failed){ failed = false; iz = lz; }
				else{ lz = iz; iz++; allrem.addAll(torem); }
				torem.clear(); 
			}
			if(ly != iy){
				int y = sy + iy;
				for(int x = sx; x < sx + lx + 1; x++){
					for(int z = sz; z < sz + lz + 1; z++){
						if(contains(x, y, z, color)){
							torem.add(new VV3(x, y, z));
						}
						else{
							failed = true;
							break;
						}
					}
				}
				if(failed){ failed = false; iy = ly; }
				else{ ly = iy; iy++; allrem.addAll(torem); }
				torem.clear(); 
			}
			if(lx == ix && ly == iy && lz == iz) break;
		}
		removeAll(allrem);
		return new int[]{ sx, sy, sz, sx + ix, sy + iy, sz + iz, color };
	}

	private boolean contains(int x, int y, int z, int color){
		if(x >= segx || y >= segy || z >= segz) return false;
		return data[x][y][z] == color;
	}
	
	private void removeAll(ArrayList<VV3> torem){
		for(VV3 w3 : torem) data[w3.x][w3.y][w3.z] = 0;
	}

	/**
	 * Voxel Vector 3
	 * 
	 * @author Ferdinand Calo' (FEX___96)
	 *
	 */
	private static final class VV3 {
		
		private int x, y, z;
		
		public VV3(int x2, int y2, int z2){ x = x2; y = y2; z = z2; }

		@Override
		public boolean equals(Object obj){
			if(obj instanceof VV3 == false) return false;
			VV3 xel = (VV3)obj; return xel.x == x && xel.y == y && xel.z == z;
		}
		
	}
	
}
