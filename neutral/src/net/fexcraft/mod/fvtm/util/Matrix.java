package net.fexcraft.mod.fvtm.util;

/**
 * Based on other Matrix classes.
 * Simplified to the only use cases in FVTM
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class Matrix {

	public float[] m0 = new float[4];
	public float[] m1 = new float[4];
	public float[] m2 = new float[4];

	public Matrix(){
		reset();
	}

	public void reset(){
		for(int i = 0; i < 4; i++) m0[i] = 0f;
		for(int i = 0; i < 4; i++) m1[i] = 0f;
		for(int i = 0; i < 4; i++) m2[i] = 0f;
		m0[0] = m1[1] = m2[2] = 1f;
	}

	public void rotate(float am, float x, float y, float z){
		float cos = (float)Math.cos(am);
		float sin = (float)Math.sin(am);
		float con = 1f - cos;
		float mxy = x * y, mxz = x * z, myz = y * z;
		float six = sin * x, siy = sin * y, siz = sin * z;
		float cx = x * x * con + cos, cy = y * y * con + cos, cz = z * z * con + cos;
		float c0y = mxy * con + siz, c0z = mxz * con - siy;
		float c1x = mxy * con - siz, c1z = myz * con + six;
		float c2x = mxz * con + siy, c2y = myz * con - six;
		float[] tmp = new float[8];
		tmp[0] = m0[0] * cx + m1[0] * c0y + m2[0] * c0z;
		tmp[1] = m0[1] * cx + m1[1] * c0y + m2[1] * c0z;
		tmp[2] = m0[2] * cx + m1[2] * c0y + m2[2] * c0z;
		tmp[3] = m0[3] * cx + m1[3] * c0y + m2[3] * c0z;
		tmp[4] = m0[0] * c1x + m1[0] * cy + m2[0] * c1z;
		tmp[5] = m0[1] * c1x + m1[1] * cy + m2[1] * c1z;
		tmp[6] = m0[2] * c1x + m1[2] * cy + m2[2] * c1z;
		tmp[7] = m0[3] * c1x + m1[3] * cy + m2[3] * c1z;
		m2[0] = m0[0] * c2x + m1[0] * c2y + m2[0] * cz;
		m2[1] = m0[1] * c2x + m1[1] * c2y + m2[1] * cz;
		m2[2] = m0[2] * c2x + m1[2] * c2y + m2[2] * cz;
		m2[3] = m0[3] * c2x + m1[3] * c2y + m2[3] * cz;
		m0[0] = tmp[0]; m0[1] = tmp[1]; m0[2] = tmp[2]; m0[3] = tmp[3];
		m1[0] = tmp[4]; m1[1] = tmp[5]; m1[2] = tmp[6]; m1[3] = tmp[7];
	}

	public void rotateX(float am, float x){
		float cos = (float)Math.cos(am);
		float sin = (float)Math.sin(am);
		float con = 1f - cos;
		float six = sin * x;
		float cx = x * x * con + cos;
		float[] tmp = new float[8];
		tmp[0] = m0[0] * cx; tmp[1] = m0[1] * cx; tmp[2]= m0[2] * cx; tmp[3] = m0[3] * cx;
		tmp[4] = m1[0] * cos + m2[0] * six; tmp[5] = m1[1] * cos + m2[1] * six;
		tmp[6] = m1[2] * cos + m2[2] * six; tmp[7] = m1[3] * cos + m2[3] * six;
		m2[0] = m1[0] * -six + m2[0] * cos; m2[1] = m1[1] * -six + m2[1] * cos;
		m2[2] = m1[2] * -six + m2[2] * cos; m2[3] = m1[3] * -six + m2[3] * cos;
		m0[0] = tmp[0]; m0[1] = tmp[1]; m0[2] = tmp[2]; m0[3] = tmp[3];
		m1[0] = tmp[4]; m1[1] = tmp[5]; m1[2] = tmp[6]; m1[3] = tmp[7];
	}

	public void rotateY(float am, float y){
		float cos = (float)Math.cos(am);
		float sin = (float)Math.sin(am);
		float con = 1f - cos;
		float siy = sin * y;
		float cy = y * y * con + cos;
		float[] tmp = new float[8];
		tmp[0] = m0[0] * cos + m2[0] * -siy; tmp[1] = m0[1] * cos + m2[1] * -siy;
		tmp[2] = m0[2] * cos + m2[2] * -siy; tmp[3] = m0[3] * cos + m2[3] * -siy;
		tmp[4] = m1[0] * cy; tmp[5] = m1[1] * cy; tmp[6] = m1[2] * cy; tmp[7] = m1[3] * cy;
		m2[0] = m0[0] * siy + m2[0] * cos; m2[1] = m0[1] * siy + m2[1] * cos;
		m2[2] = m0[2] * siy + m2[2] * cos; m2[3] = m0[3] * siy + m2[3] * cos;
		m0[0] = tmp[0]; m0[1] = tmp[1]; m0[2] = tmp[2]; m0[3] = tmp[3];
		m1[0] = tmp[4]; m1[1] = tmp[5]; m1[2] = tmp[6]; m1[3] = tmp[7];
	}

	public void rotateZ(float am, float z){
		float cos = (float)Math.cos(am);
		float sin = (float)Math.sin(am);
		float con = 1f - cos;
		float siz = sin * z;
		float cz = z * z * con + cos;
		float[] tmp = new float[8];
		tmp[0] = m0[0] * cos + m1[0] * siz; tmp[1] = m0[1] * cos + m1[1] * siz;
		tmp[2] = m0[2] * cos + m1[2] * siz; tmp[3] = m0[3] * cos + m1[3] * siz;
		tmp[4] = m0[0] * -siz + m1[0] * cos; tmp[5] = m0[1] * -siz + m1[1] * cos;
		tmp[6] = m0[2] * -siz + m1[2] * cos; tmp[7] = m0[3] * -siz + m1[3] * cos;
		m2[0] = m2[0] * cz; m2[1] = m2[1] * cz; m2[2] = m2[2] * cz; m2[3] = m2[3] * cz;
		m0[0] = tmp[0]; m0[1] = tmp[1]; m0[2] = tmp[2]; m0[3] = tmp[3];
		m1[0] = tmp[4]; m1[1] = tmp[5]; m1[2] = tmp[6]; m1[3] = tmp[7];
	}

}
