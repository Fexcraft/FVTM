package net.fexcraft.lib.tmt;

/*
 * @author Ferdinand Calo' (FEX___96)
 */
public interface CustomUVBuilder {
	
	public CustomUVBuilder removePolygon(int index);
	
	public CustomUVBuilder removePolygons(int... poly_indices);

	public CustomUVBuilder removePolygons(boolean... sides);
	
	public CustomUVBuilder setPolygonUV(int poly_index, float[] uv);
	
	public CustomUVBuilder setPolygonUVs(int[] poly_indices, float[][] uvs);
	
	public CustomUVBuilder setPolygonUVs(float[][] uvs);
	
	public CustomUVBuilder setDetachedUV(int... indices);
	
	public CustomUVBuilder setDetachedUV(boolean... bools);

}
