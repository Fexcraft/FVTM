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

	public static class TF_Translate extends Transforms.TF_Translate {

		public TF_Translate(float xx, float yy, float zz){
			super(xx, yy, zz);
		}

		@Override
		public void apply(){
			Renderer20.pose.translate(x, y, z);
		}

		@Override
		public void deapply(){
			Renderer20.pose.translate(-x, -y, -z);
		}

	}

	public static class TF_Rotate extends Transforms.TF_Rotate {

		private int axe;
		private float ang;

		public TF_Rotate(float xx, float yy, float zz, float a){
			super(xx, yy, zz, a);
			axe = xx > 0 ? 0 : yy > 0 ? 1 : 2;
			ang = Static.toRadians(a);
		}

		@Override
		public void apply(){
			Renderer20.pose.pushPose();
			switch(axe){
				case 0: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(ang, AX));
					break;
				}
				case 1: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(ang, AY));
					break;
				}
				case 2: {
					Renderer20.pose.mulPose(new Quaternionf().rotateAxis(ang, AZ));
					break;
				}
			}
		}

		@Override
		public void deapply(){
			Renderer20.pose.popPose();
		}

	}

	public static class TF_Scale extends Transforms.TF_Scale {

		public TF_Scale(float xx, float yy, float zz){
			super(xx, yy, zz);
		}

		@Override
		public void apply(){
			Renderer20.pose.pushPose();
			Renderer20.pose.scale(x, y, z);
		}

		@Override
		public void deapply(){
			Renderer20.pose.popPose();
		}

	}

	public static class TF_RescaleNormal implements Transforms.Transformer {

		public void apply(){}

		public void deapply(){}

	}

}