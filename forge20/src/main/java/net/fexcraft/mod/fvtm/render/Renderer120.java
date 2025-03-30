package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Renderer120 extends Renderer<GLObject> {

	public static final Vector3f AY = new Vector3f(0, 1, 0);
	public static final Vector3f AX = new Vector3f(1, 0, 0);
	public static final Vector3f AZ = new Vector3f(0, 0, 1);
	public static final Vector3f NULLVEC = new Vector3f(0, 0, 0);
	//
	public static final Vec3f DEFCOLOR = new Vec3f(1, 1, 1);
	private static Vec3f color = new Vec3f();
	//
	public static PoseStack pose;
	private static MultiBufferSource buffer;
	private static VertexConsumer cons;
	protected static RenderType rentype;
	protected static int overlay = OverlayTexture.NO_OVERLAY;
	public static int light;

	public static void setColor(RGB col){
		float[] arr = col.toFloatArray();
		color.x = arr[0];
		color.y = arr[1];
		color.z = arr[2];
	}

	public static void setColor(Vec3f col){
		color.copy(col);
	}

	public static void resetColor(){
		color.x = color.y = color.z = 1;
	}

	public static void rotateDeg(float by, Vector3f axe){
		pose.mulPose(new Quaternionf().rotateAxis(Static.toRadians(by), axe));
	}

	public static void rotateRad(float by, Vector3f axe){
		pose.mulPose(new Quaternionf().rotateAxis(by, axe));
	}

	public static void rotateDeg(PoseStack pose, float by, Vector3f axe){
		pose.mulPose(new Quaternionf().rotateAxis(Static.toRadians(by), axe));
	}

	public static void rotateRad(PoseStack pose, float by, Vector3f axe){
		pose.mulPose(new Quaternionf().rotateAxis(by, axe));
	}

	public static void pushPose(){
		pose.pushPose();
	}

	public static void popPose(){
		pose.popPose();
	}

	public static RenderType rentype(){
		return rentype;
	}

	public void render(Polyhedron<GLObject> poly){
		if(!poly.visible) return;
		pose.pushPose();
		pose.translate(poly.posX, poly.posY, poly.posZ);
		if(poly.rotX != 0.0F || poly.rotY != 0.0F || poly.rotZ != 0.0F){
			pose.mulPose(new Quaternionf()
				.rotateAxis(Static.toRadians(poly.rotY), AY)
				.rotateAxis(Static.toRadians(poly.rotX), AX)
				.rotateAxis(Static.toRadians(poly.rotZ), AZ)
			);
		}
		if(buffer != null) cons = buffer.getBuffer(rentype);
		Matrix4f verma = pose.last().pose();
		Matrix3f norma = pose.last().normal();
		for(Polygon poli : poly.polygons){
			if(rentype.mode() == VertexFormat.Mode.QUADS){
				for(Vertex vert : poli.vertices){
					fillVert(verma, norma, vert);
				}
				if(poli.vertices.length < 4){
					fillVert(verma, norma, poli.vertices[2]);
				}
			}
			else{
				if(poli.vertices.length == 4){
					fillVert(verma, norma, poli.vertices[0]);
					fillVert(verma, norma, poli.vertices[1]);
					fillVert(verma, norma, poli.vertices[2]);
					fillVert(verma, norma, poli.vertices[0]);
					fillVert(verma, norma, poli.vertices[2]);
					fillVert(verma, norma, poli.vertices[3]);
				}
				else{
					for(Vertex vert : poli.vertices){
						fillVert(verma, norma, vert);
					}
				}
			}
		}
		pose.popPose();
	}

	private void fillVert(Matrix4f verma, Matrix3f norma, Vertex vert){
		Vector4f vec = verma.transform(new Vector4f(vert.vector.x, vert.vector.y, vert.vector.z, 1.0F));
		Vector3f norm = norma.transform(vert.norm == null ? NULLVEC : new Vector3f(vert.norm.x, vert.norm.y, vert.norm.z));
		cons.vertex(vec.x, vec.y, vec.z, color.x, color.y, color.z, 1.0F, vert.u, vert.v, overlay, light, norm.x, norm.y, norm.z);
	}

	public void delete(Polyhedron<GLObject> poly){
		//
	}

	@Override
	public void push(){
		pose.pushPose();
	}

	@Override
	public void pop(){
		pose.popPose();
	}

	@Override
	public void translate(double x, double y, double z){
		pose.translate(x, y, z);
	}

	@Override
	public void rotate(float deg, int x, int y, int z){
		Matrix4f mat = new Matrix4f();
		if(x != 0f) mat.rotate(deg, AX);
		if(y != 0f) mat.rotate(deg, AY);
		if(z != 0f) mat.rotate(deg, AZ);
		pose.mulPoseMatrix(mat);
	}

	@Override
	public void scale(double x, double y, double z){
		pose.scale((float)x, (float)y, (float)z);
	}

	public static void set(PoseStack ps, MultiBufferSource mbs, int lgt, int ol){
		pose = ps;
		buffer = mbs;
		cons = null;
		light = lgt;
		overlay = ol;
	}

	public static void set(PoseStack ps, MultiBufferSource mbs, int lgt){
		pose = ps;
		buffer = mbs;
		cons = null;
		light = lgt;
		overlay = OverlayTexture.NO_OVERLAY;
	}

	public static void set(PoseStack ps, VertexConsumer con, int lgt, int ol){
		pose = ps;
		buffer = null;
		cons = con;
		light = lgt;
		overlay = ol;
	}

	public static void set(PoseStack ps, VertexConsumer con, int lgt){
		pose = ps;
		buffer = null;
		cons = con;
		light = lgt;
		overlay = OverlayTexture.NO_OVERLAY;
	}

}