package net.fexcraft.mod.fvtm.model.block;

import static net.fexcraft.lib.common.Static.thirtysecondth;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedQuadData {

	public static double[][] quad = {
		{ 1, thirtysecondth, 0 },
		{ 0, thirtysecondth, 0 },
		{ 0, thirtysecondth, 1 },
		{ 1, thirtysecondth, 1 }
	};
	public static int[][] uv_full = {
		{ 16,  0 }, { 0,  0 }, { 0, 16 }, { 16, 16 }
	};
	public static int[][] uv_ls = {
		{ 8,  0 }, { 0,  0 }, { 0, 8 }, { 8, 8 }
	};
	public static int[][] uv_lc = {
		{ 16,  0 }, { 8,  0 }, { 8, 8 }, { 16, 8 }
	};
	public static int[][] uv_lt = {
		{ 8,  8 }, { 0,  8 }, { 0, 16 }, { 8, 16 }
	};
	public static int[][] uv_lf = {
		{ 16,  8 }, { 8,  8 }, { 8, 16 }, { 16, 16 }
	};
	public static int[][][] uv_ls2 = new int[2][][];
	public static int[][][] uv_lc2 = new int[4][][];
	public static int[][][] uv_l3 = new int[4][][];
	static{
		uv_ls2[0] = uv_ls;
		uv_ls2[1] = rotateR(uv_ls);
		uv_lc2[0] = uv_lc;
		uv_lc2[1] = rotateL(uv_lc);
		uv_lc2[2] = rotateU(uv_lc);
		uv_lc2[3] = rotateR(uv_lc);
		uv_l3[0] = uv_lt;
		uv_l3[1] = rotateL(uv_lt);
		uv_l3[2] = rotateU(uv_lt);
		uv_l3[3] = rotateR(uv_lt);
	}

	public static int[][] rotateR(int[][] ar){
		int[][] na = new int[ar.length][ar[0].length];
		na[0] = ar[3];
		na[1] = ar[0];
		na[2] = ar[1];
		na[3] = ar[2];
		return na;
	}

	public static int[][] rotateL(int[][] ar){
		int[][] na = new int[ar.length][ar[0].length];
		na[0] = ar[1];
		na[1] = ar[2];
		na[2] = ar[3];
		na[3] = ar[0];
		return na;
	}

	public static int[][] rotateU(int[][] ar){
		int[][] na = new int[ar.length][ar[0].length];
		na[0] = ar[2];
		na[1] = ar[3];
		na[2] = ar[0];
		na[3] = ar[1];
		return na;
	}

}
