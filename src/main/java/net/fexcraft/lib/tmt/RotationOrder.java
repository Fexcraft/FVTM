package net.fexcraft.lib.tmt;

import org.lwjgl.opengl.GL11;

public enum RotationOrder {
	
	XYZ {
		@Override
		public void rotate(ModelRendererTurbo mrt){
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
		}
	},
	XZY {
		@Override
		public void rotate(ModelRendererTurbo mrt){
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
		}
	},
	YXZ {
		@Override
		public void rotate(ModelRendererTurbo mrt){
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
		}
	},
	YZX {
		@Override
		public void rotate(ModelRendererTurbo mrt){
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
		}
	},
	ZXY {
		@Override
		public void rotate(ModelRendererTurbo mrt){
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
		}
	},
	ZYX {
		@Override
		public void rotate(ModelRendererTurbo mrt){
	        if(mrt.rotationAngleZ != 0.0F) GL11.glRotatef(mrt.rotationAngleZ, 0.0F, 0.0F, 1.0F);
			if(mrt.rotationAngleY != 0.0F) GL11.glRotatef(mrt.rotationAngleY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotationAngleX != 0.0F) GL11.glRotatef(mrt.rotationAngleX, 1.0F, 0.0F, 0.0F);
		}
	},
	;

	public abstract void rotate(ModelRendererTurbo mrt);

}
