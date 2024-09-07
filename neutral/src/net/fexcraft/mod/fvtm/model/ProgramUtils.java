package net.fexcraft.mod.fvtm.model;

import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ProgramUtils {

	public static final Function<ModelRenderData, Float> FLOAT_SUPP = mrd -> 0f;
	public static final Function<ModelRenderData, Float[]> FLOAT2_SUPP = mrd -> new Float[]{ 0f, 0f };
	public static final Function<ModelRenderData, Integer> INT_SUPP = mrd -> 0;
	public static final Function<ModelRenderData, FloatBool> FLOAT_BOOL_SUPP = mrd -> new FloatBool(0, false);
	public static final Function<ModelRenderData, FloatBool2> FLOAT_BOOL2_SUPP = mrd -> new FloatBool2(0, false, false);

	public static class FloatBool {

		public float fl;
		public boolean bl;

		public FloatBool(float f, boolean b){
			fl = f;
			bl = b;
		}

	}

	public static class FloatBool2 {

		public float fl;
		public boolean bl0;
		public boolean bl1;

		public FloatBool2(float f, boolean b0, boolean b1){
			fl = f;
			bl0 = b0;
			bl1 = b1;
		}

	}

}
