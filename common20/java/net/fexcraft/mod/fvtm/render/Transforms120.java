package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.model.Transforms;
import org.joml.Quaternionf;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Transforms120 {

	public static final TF_RescaleNormal TF_RESCALE_NORMAL = new TF_RescaleNormal();

	public static class TF_Translate implements Transforms.Transformer {

		private float x;
		private float y;
		private float z;

		public TF_Translate(float xx, float yy, float zz){
			this.x = xx;
			this.y = yy;
			this.z = zz;
		}

		public void apply(){
			Renderer120.pose.translate(this.x, this.y, this.z);
		}

		public void deapply(){
			Renderer120.pose.translate(-this.x, -this.y, -this.z);
		}

	}

	public static class TF_Rotate implements Transforms.Transformer {

		private float x;
		private float y;
		private float z;
		private float angle;

		public TF_Rotate(float xx, float yy, float zz, float angle){
			this.x = xx;
			this.y = yy;
			this.z = zz;
			this.angle = angle;
		}

		public void apply(){
			Renderer120.pose.pushPose();
			Renderer120.pose.mulPose(new Quaternionf(this.x, this.y, this.z, Static.toRadians(this.angle)));
		}

		public void deapply(){
			Renderer120.pose.popPose();
		}

	}

	public static class TF_Scale implements Transforms.Transformer {

		private float x;
		private float y;
		private float z;

		public TF_Scale(float xx, float yy, float zz){
			this.x = xx;
			this.y = yy;
			this.z = zz;
		}

		public void apply(){
			Renderer120.pose.pushPose();
			Renderer120.pose.scale(this.x, this.y, this.z);
		}

		public void deapply(){
			Renderer120.pose.popPose();
		}

	}

	public static class TF_RescaleNormal implements Transforms.Transformer {

		public void apply(){}

		public void deapply(){}

	}

}