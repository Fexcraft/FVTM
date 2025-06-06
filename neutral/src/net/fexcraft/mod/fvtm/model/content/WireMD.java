package net.fexcraft.mod.fvtm.model.content;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.render.PathModelGenerator;
import net.fexcraft.mod.fvtm.render.PathModelPositioned;
import net.fexcraft.mod.fvtm.sys.wire.Wire;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Wire Model Data
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireMD {

	public PathModelPositioned wiremodel;
	public double start_angle, end_angle;
	public double start_angle_down, end_angle_down;
	public WireDeco deco_s, deco_e;
	public HashMap<String, HashMap<String, ArrayList<V3D>>> deco_d;
	public HashMap<String, HashMap<String, ArrayList<net.fexcraft.lib.tmt.ModelRendererTurbo>>> deco_g;

	public WireMD(Wire wire){
		wire.model = this;
		PathModelGenerator.generateWireModel(wire, wire.getWireType().getModel());
	}

}
