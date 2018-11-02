package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.lang.ArrayList;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

/**
 * Similar concept as the TurboList inside FMT-Standalone
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TurboList extends ArrayList<ModelRendererTurbo> {
	
	private static final long serialVersionUID = 1L;
	protected static final TurboList EMPTY = new TurboList();
	
	public TurboList(){ super(); }
	
	public TurboList(ModelRendererTurbo[] mrts){
		super(); for(ModelRendererTurbo mrt : mrts){ this.add(mrt); }
	}

	public void render(String key){
		for(ModelRendererTurbo turbo : this){ turbo.render(); }
	}

	public void translate(float x, float y, float z){
		this.forEach(mrt -> { mrt.rotationPointX += x; mrt.rotationPointY += y; mrt.rotationPointZ += z; });
	}
	
	public void rotate(float x, float y, float z){
		rotate(x, y, z, false);
	}

	public void rotate(float x, float y, float z, boolean apply){
		this.forEach(mrt -> {
			if(apply){ mrt.rotateAngleX = x; mrt.rotateAngleY = y; mrt.rotateAngleZ = z; }
			else{ mrt.rotateAngleX += x; mrt.rotateAngleY += y; mrt.rotateAngleZ += z; }
		});
	}
	
}