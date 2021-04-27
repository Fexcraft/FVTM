package net.fexcraft.mod.fvtm.util;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Transforms {

	private static ArrayList<Transformer> transformers = new ArrayList<>();
	
	public void apply(){
		for(Transformer tr : transformers) tr.apply();
	}
	
	public void deapply(){
		for(Transformer tr : transformers) tr.deapply();
	}
	
	
	public static interface Transformer {
		
		public void apply();
		
		public void deapply();
		
	}
	
	public void parse(String[] args){
		switch(args[0]){
			case "translation":
			case "translate":
			case "trans":
			case "tra":
			case "tr":
				transformers.add(new TF_Translate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3])));
				return;
			case "rotation":
			case "rotate":
			case "rot":
				transformers.add(new TF_Rotate(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]), Float.parseFloat(args[4])));
				return;
			case "scale":
				if(args.length < 3){
					float scale = Float.parseFloat(args[1]);
					transformers.add(new TF_Scale(scale, scale, scale));
				}
				else transformers.add(new TF_Scale(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3])));
				return;
		}
	}
	
	public static class TF_Translate implements Transformer {
		
		private float x, y, z;
		
		public TF_Translate(float xx, float yy, float zz){
			x = xx; y = yy; z = zz;
		}

		@Override
		public void apply(){
			GL11.glTranslatef(x, y, z);
		}

		@Override
		public void deapply(){
			GL11.glTranslatef(-x, -y, -z);
		}
		
	}
	
	public static class TF_Rotate implements Transformer {
		
		private float x, y, z, angle;
		
		public TF_Rotate(float xx, float yy, float zz, float angle){
			x = xx; y = yy; z = zz; this.angle = angle;
		}

		@Override
		public void apply(){
			GL11.glRotatef(angle, x, y, z);
		}

		@Override
		public void deapply(){
			GL11.glRotatef(angle, -x, -y, -z);
		}
		
	}
	
	public static class TF_Scale implements Transformer {
		
		private float x, y, z;
		
		public TF_Scale(float xx, float yy, float zz){
			x = xx; y = yy; z = zz;
		}

		@Override
		public void apply(){
			GL11.glPushMatrix();
			GL11.glScalef(x, y, z);
		}

		@Override
		public void deapply(){
			//GL11.glScalef(-x, -y, -z);
			GL11.glPopMatrix();
		}
		
	}

	public ArrayList<Transformer> getTransformers(){
		return transformers;
	}
	
}
