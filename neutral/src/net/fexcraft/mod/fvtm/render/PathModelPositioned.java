package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.wire.Wire;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PathModelPositioned {

	public Polyhedron[] hedrons;
	protected V3D[] positions;

	public PathModelPositioned(Path path, RGB colour){
		int i = (int)path.getLength(null);
		if(path.length % 1f > 0) i++;
		if(i == 0) i = 1;
		hedrons = new Polyhedron[i];
		positions = new V3D[i];
		for(int k = 0; k < i; k++){
			hedrons[k] = new Polyhedron<>();
			//if(colour != null) turbos[k].setColor(colour);
			positions[k] = path.getVectorPosition(k == 0 ? 0.125f : k == i - 1 ? path.length - 0.125f : k, false);
		}
	}

	public PathModelPositioned(Wire wire, RGB colour){
		int i = (int)wire.getLength(null);
		if(wire.length % 1f > 0) i++;
		if(i == 0) i = 1;
		hedrons = new Polyhedron[i];
		positions = new V3D[i];
		for(int k = 0; k < i; k++){
			hedrons[k] = new Polyhedron<>();
			//if(colour != null) turbos[k].setColor(colour);
			positions[k] = wire.getVectorPosition(k == 0 ? 0.125f : k == i - 1 ? wire.length - 0.125f : k, false);
		}
	}

	public void clearGL(){
		for(Polyhedron hedron : hedrons){
			if(hedron != null && hedron.glId != null) Renderer.RENDERER.delete(hedron);
		}
	}

	public void render(){
		for(int m = 0; m < hedrons.length; m++){
			Renderer.RENDERER.light(positions[m]);
			Renderer.RENDERER.color(0xffffffff);
			hedrons[m].render();
		}
	}

	public void renderPlain(){
		for(int m = 0; m < hedrons.length; m++){
			hedrons[m].render();
		}
	}

}
