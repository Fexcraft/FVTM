package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.function.Function;

import net.fexcraft.lib.common.math.Vec3f;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Transforms {

	public static final Transformer TF_RESCALE_NORMAL = new TF_RescaleNormal();
	public static Function<String[], Transformer> GET_TRANSFORM;
	private ArrayList<Transformer> transformers = new ArrayList<>();
	
	public void apply(){
		for(Transformer tr : transformers) tr.apply();
	}
	
	public void deapply(){
		for(Transformer tr : transformers) tr.deapply();
	}

	public boolean hasRotate(){
		for(Transformer trn : transformers){
			if(trn instanceof TF_Rotate) return true;
		}
		return false;
	}

	public ArrayList<TF_Rotate> getBakedRotate(){
		ArrayList<TF_Rotate> list = new ArrayList<>();
		for(Transformer trn : transformers){
			if(trn instanceof TF_Rotate) list.add((TF_Rotate)trn);
		}
		return list;
	}

	public boolean hasTranslate(){
		for(Transformer trn : transformers){
			if(trn instanceof TF_Translate) return true;
		}
		return false;
	}

	public Vec3f getBakedTranslate(){
		for(Transformer trn : transformers){
			if(trn instanceof TF_Translate){
				TF_Translate tf = (TF_Translate)trn;
				return new Vec3f(tf.x, tf.y, tf.z);
			}
		}
		return new Vec3f();
	}

	public boolean hasScale(){
		for(Transformer trn : transformers){
			if(trn instanceof TF_Scale) return true;
		}
		return false;
	}

	public Vec3f getBakedScale(){
		for(Transformer trn : transformers){
			if(trn instanceof TF_Scale){
				TF_Scale tf = (TF_Scale)trn;
				return new Vec3f(tf.x, tf.y, tf.z);
			}
		}
		return new Vec3f();
	}

	public void add(Transformer transformer){
		transformers.add(transformer);
	}


	public static interface Transformer {
		
		public void apply();
		
		public void deapply();
		
	}
	
	public void parse(String[] args){
		Transformer form = GET_TRANSFORM.apply(args);
		if(form != null) transformers.add(form);
	}

	// GL11 implementation below //
	
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
		
		public final float x, y, z, angle;
		
		public TF_Rotate(float xx, float yy, float zz, float angle){
			x = xx; y = yy; z = zz; this.angle = angle;
		}

		@Override
		public void apply(){
			GL11.glPushMatrix();
			GL11.glRotatef(angle, x, y, z);
		}

		@Override
		public void deapply(){
			//GL11.glRotatef(angle, -x, -y, -z);
			GL11.glPopMatrix();
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
	
	public static class TF_RescaleNormal implements Transformer {
		
		public TF_RescaleNormal(){}

		@Override
		public void apply(){
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}

		@Override
		public void deapply(){
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
		
	}

	public ArrayList<Transformer> getTransformers(){
		return transformers;
	}

	public void copy(Transforms transforms){
		transformers.addAll(transforms.getTransformers());
	}
	
}
