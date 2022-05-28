package net.fexcraft.mod.fvtm.model.block;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StreetSignCachedModel {
	
	private ModelGroup cachedmodel = new ModelGroup("cache");

    @SideOnly(Side.CLIENT)
	public void recollectModel(StreetSign sign){
		for(ModelRendererTurbo turbo : cachedmodel)
			if(turbo.displaylist() != null)
				GL11.glDeleteLists(turbo.displaylist(), 1);
		cachedmodel.clear();
		//
		//Print.debug(StreetSignModel.INSTANCE.groups);
		//
		if(sign.panels[0]){
			cachedmodel.addAll(copyGroup("row3"));
			if(sign.sides[3]) cachedmodel.add(copyTurbo("right", 3));
			if(sign.sides[1]) cachedmodel.add(copyTurbo("left", 3));
		}
		if(sign.panels[1]){
			cachedmodel.addAll(copyGroup("row2"));
			if(sign.sides[3]) cachedmodel.add(copyTurbo("right", 2));
			if(sign.sides[1]) cachedmodel.add(copyTurbo("left", 2));
		}
		if(sign.panels[2]){
			cachedmodel.addAll(copyGroup("row1"));
			if(sign.sides[3]) cachedmodel.add(copyTurbo("right", 1));
			if(sign.sides[1]) cachedmodel.add(copyTurbo("left", 1));
		}
		if(sign.panels[3]){
			cachedmodel.addAll(copyGroup("row0"));
			if(sign.sides[3]) cachedmodel.add(copyTurbo("right", 0));
			if(sign.sides[1]) cachedmodel.add(copyTurbo("left", 0));
		}
		//
		if(sign.sides[0] && sign.sides[1]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_bl");
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[1] && sign.sides[2]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_tl");
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[2] && sign.sides[3]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_tr");
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[3] && sign.sides[0]){
			ArrayList<ModelRendererTurbo> list = copyGroup("corner_br");
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.rotationPointY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[0]){
			ModelRendererTurbo turbo = copyTurbo("top_bot", 0);
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.sides[2]){
			ModelRendererTurbo turbo = copyTurbo("top_bot", 1);
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.arrows[0] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[0] ? "right" : "left"), 0)); }
		if(sign.arrows[1] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[1] ? "right" : "left"), 3)); }
		if(sign.arrows[2] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[2] ? "right" : "left"), 2)); }
		if(sign.arrows[3] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[3] ? "right" : "left"), 1)); }
		if(sign.arrows[4] != null && sign.arrows[4]){
			ModelRendererTurbo turbo = copyTurbo("arrow_top_bot", 0);
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.arrows[5] != null && sign.arrows[5]){
			ModelRendererTurbo turbo = copyTurbo("arrow_top_bot", 1);
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.rotationPointY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
	}

    private ModelRendererTurbo copyTurbo(String string, int i){
    	ModelRendererTurbo turbo = StreetSignModel.INSTANCE.groups.get(string).get(i);
		ModelRendererTurbo turbo0 = new ModelRendererTurbo(null).copyTo(turbo.getFaces());
		return turbo0.setRotationPoint(turbo.rotationPointX, turbo.rotationPointY, turbo.rotationPointZ);
	}

	@SideOnly(Side.CLIENT)
	private ArrayList<ModelRendererTurbo> copyGroup(String string){
    	ArrayList<ModelRendererTurbo> list = new ArrayList<>();
    	for(ModelRendererTurbo turbo : StreetSignModel.INSTANCE.groups.get(string)){
    		ModelRendererTurbo turbo0 = new ModelRendererTurbo(null).copyTo(turbo.getFaces());
			list.add(turbo0.setRotationPoint(turbo.rotationPointX, turbo.rotationPointY, turbo.rotationPointZ));
		} return list;
	}

	public void delete(){
		for(ModelRendererTurbo turbo : cachedmodel) if(turbo.displaylist() != null) GL11.glDeleteLists(turbo.displaylist(), 1);
	}

	public void render(){
		cachedmodel.render();
	}

}
