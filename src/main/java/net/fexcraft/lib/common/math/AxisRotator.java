package net.fexcraft.lib.common.math;

public interface AxisRotator {

	public void setAngles(float x, float y, float z);

	public Vec3f getRelativeVector(Vec3f vector);

	public static AxisRotator newDefInstance(){
		try{
			return DefHolder.DEF_IMPL.newInstance();
		}
		catch(InstantiationException | IllegalAccessException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static class DefHolder {
		
		private static Class<? extends AxisRotator> DEF_IMPL = Axis3DL.class;
		
	}
	
	public static void setDefImpl(Class<? extends AxisRotator> clazz){
		DefHolder.DEF_IMPL = clazz;
	}

}
