package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fcl.util.Renderer26;
import net.fexcraft.mod.fvtm.model.Transforms;
import org.joml.Quaternionf;

import static net.fexcraft.lib.frl.Renderer.RENDERER;
import static net.fexcraft.mod.fcl.util.Renderer26.*;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Transforms21 {

	public static final TF_RescaleNormal TF_RESCALE_NORMAL = new TF_RescaleNormal();

	public static class TF_Translate extends Transforms.TF_Translate {

		public TF_Translate(float xx, float yy, float zz){
			super(xx, yy, zz);
		}

		public void apply(){
			Renderer26.pose.translate(this.x, this.y, this.z);
		}

		public void deapply(){
			Renderer26.pose.translate(-this.x, -this.y, -this.z);
		}

	}

	public static class TF_Rotate extends Transforms.TF_Rotate {

		private int axe;
		private float ang;

		public TF_Rotate(float xx, float yy, float zz, float an){
			super(xx, yy, zz, an);
			axe = xx > 0 ? 0 : yy > 0 ? 1 : 2;
			ang = Static.toRadians(an);
		}

		public void apply(){
			Renderer26.stack.pushPose();
			switch(axe){
				case 0: {
					Renderer26.stack.mulPose(new Quaternionf().rotateAxis(ang, AX));
					break;
				}
				case 1: {
					Renderer26.stack.mulPose(new Quaternionf().rotateAxis(ang, AY));
					break;
				}
				case 2: {
					Renderer26.stack.mulPose(new Quaternionf().rotateAxis(ang, AZ));
					break;
				}
			}
		}

		public void deapply(){
			RENDERER.pop();
		}

	}

	public static class TF_Scale extends Transforms.TF_Scale {

		public TF_Scale(float xx, float yy, float zz){
			super(xx, yy, zz);
		}

		public void apply(){
			RENDERER.push();
			RENDERER.scale(x, y, z);
		}

		public void deapply(){
			RENDERER.pop();
		}

	}

	public static class TF_RescaleNormal implements Transforms.Transformer {

		public void apply(){}

		public void deapply(){}

	}

}