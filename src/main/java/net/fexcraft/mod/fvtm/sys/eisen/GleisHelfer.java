package net.fexcraft.mod.fvtm.sys.eisen;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.fvtm.util.Vector3D;
import net.fexcraft.mod.fvtm.util.config.Config;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class GleisHelfer {

	public static Vec3f[] pfadErstellen(Vec3f[] punkte){
		ArrayList<Vec3f> vektoren = new ArrayList<Vec3f>();
		float länge = längeBerechnen(punkte), zusatz = 1 / länge / Config.RAIL_SEGMENTATOR;
		double d = 0; while(d < 1){
			Vec3f[] bewegt = punkte;
			while(bewegt.length > 2){
				Vec3f[] arr = new Vec3f[bewegt.length - 1];
				for(int i = 0; i < bewegt.length - 1; i++){
					arr[i] = verschieben(bewegt[i], bewegt[i + 1], bewegt[i].distanceTo(bewegt[i + 1]) * d);
				} bewegt = arr;
			} d += zusatz;//0.0625//0.05;
			vektoren.add(verschieben(bewegt[0], bewegt[1], bewegt[0].distanceTo(bewegt[1]) * d));
		}
		return vektoren.toArray(new Vec3f[0]);
	}

	public static Vec3f verschieben(Vec3f vec0, Vec3f vec1, double dis){
		double[] dest = Vector3D.newVector(vec1), beg = Vector3D.newVector(vec0);
    	dest = Vector3D.direction(dest[0] - beg[0], dest[1] - beg[1], dest[2] - beg[2]);
    	dest = Vector3D.newVector(beg[0] + (dest[0] * dis), beg[1] + (dest[1] * dis), beg[2] + (dest[2] * dis));
		return new Vec3f(dest[0], dest[1], dest[2]);
	}

	public static float längeBerechnen(Vec3f[] punkte){
		float temp = 0; for(int i = 0; i < punkte.length - 1; i++){ temp += punkte[i].distanceTo(punkte[i + 1]); } return temp;
	}

}
