package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import org.lwjgl.opengl.GL11;

public class TurboArrayPositioned {

	protected ModelRendererTurbo[] turbos;
	protected V3D[] positions;

	public TurboArrayPositioned(Path path, RGB colour){
		int i = (int)path.getLength(null);
		if(path.length % 1f > 0) i++;
		if(i == 0) i = 1;
		turbos = new ModelRendererTurbo[i];
		positions = new V3D[i];
		for(int k = 0; k < i; k++){
			turbos[k] = new ModelRendererTurbo(path, 0, 0, 16, 16);
			if(colour != null) turbos[k].setColor(colour);
			positions[k] = path.getVectorPosition(k == 0 ? 0.125f : k == i - 1 ? path.length - 0.125f : k, false);
		}
	}

	/*public TurboArrayPositioned(Wire wire, RGB colour){
		int i = (int)wire.getLength(null);
		if(wire.length % 1f > 0) i++;
		if(i == 0) i = 1;
		turbos = new ModelRendererTurbo[i];
		positions = new V3D[i];
		for(int k = 0; k < i; k++){
			turbos[k] = new ModelRendererTurbo(wire, 0, 0, 16, 16);
			if(colour != null) turbos[k].setColor(colour);
			positions[k] = wire.getVectorPosition(k == 0 ? 0.125f : k == i - 1 ? wire.length - 0.125f : k, false);
		}
	}*///TODO

	public void clearDisplayLists(){
		for(ModelRendererTurbo turbo : turbos)
			if(turbo != null && turbo.displaylist() != null) GL11.glDeleteLists(turbo.displaylist(), 1);
	}

	public void render(){
		for(int m = 0; m < turbos.length; m++){
			//TODO int i = RailRenderer.getBrightness(positions[m]), j = i % 65536, k = i / 65536;
			//TODO setLightmapTextureCoords(lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			//TODO color(1.0F, 1.0F, 1.0F, 1.0F);
			turbos[m].render(1f);
		}
	}

	public void renderPlain(){
		for(int m = 0; m < turbos.length; m++){
			turbos[m].render(1f);
		}
	}

}
