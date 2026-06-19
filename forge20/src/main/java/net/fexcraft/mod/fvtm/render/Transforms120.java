package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fcl.util.Renderer20;
import net.fexcraft.mod.fvtm.model.Transforms;
import org.joml.Quaternionf;

import static net.fexcraft.mod.fcl.util.Renderer20.*;

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
			Renderer20.pose.translate(this.x, this.y, this.z);
		}

		public void deapply(){
			Renderer20.pose.translate(-this.x, -this.y, -this.z);
		}

	}

	public static class TF_Rotate implements Transforms.Transformer {

		private int axe;
		private float angle;

		public TF_Rotate(float xx, float yy, float zz, float ang){
			axe = xx > 0 ? 0 : yy > 0 ? 1 : 2;
			angle = Static.toRadians(ang);
		}

		public void apply(){
			Renderer20.pose.pushPose();
			switch(axe){
				case 0: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(angle, AX));
					break;
				}
				case 1: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(angle, AY));
					break;
				}
				case 2: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(angle, AZ));
					break;
				}
			}
		}

		public void deapply(){
			Renderer20.pose.popPose();
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
			Renderer20.pose.pushPose();
			Renderer20.pose.scale(this.x, this.y, this.z);
		}

		public void deapply(){
			Renderer20.pose.popPose();
		}

	}

	public static class TF_RescaleNormal implements Transforms.Transformer {

		public void apply(){}

		public void deapply(){}

	}

}