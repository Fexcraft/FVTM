package net.fexcraft.lib.frl;

import org.lwjgl.opengl.GL11;

public enum RotationOrder {
	
	XYZ {
		@Override
		public void rotate(Polyhedron<?> mrt){
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
		}
	},
	XZY {
		@Override
		public void rotate(Polyhedron<?> mrt){
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
		}
	},
	YXZ {
		@Override
		public void rotate(Polyhedron<?> mrt){
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
		}
	},
	YZX {
		@Override
		public void rotate(Polyhedron<?> mrt){
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
		}
	},
	ZXY {
		@Override
		public void rotate(Polyhedron<?> mrt){
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
		}
	},
	ZYX {
		@Override
		public void rotate(Polyhedron<?> mrt){
	        if(mrt.rotZ != 0.0F) GL11.glRotatef(mrt.rotZ, 0.0F, 0.0F, 1.0F);
			if(mrt.rotY != 0.0F) GL11.glRotatef(mrt.rotY, 0.0F, 1.0F, 0.0F);
	        if(mrt.rotX != 0.0F) GL11.glRotatef(mrt.rotX, 1.0F, 0.0F, 0.0F);
		}
	},
	;

	public abstract void rotate(Polyhedron<?> mrt);

}
