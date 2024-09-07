package net.fexcraft.mod.fvtm.model.block;

import java.util.ArrayList;

import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.entity.StreetSign;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

public class StreetSignCachedModel {
	
	private ModelGroup cachedmodel = new ModelGroup("cache");

    @SideOnly(Side.CLIENT)
	public void recollectModel(StreetSign sign){
		for(Polyhedron<GLObject> turbo : cachedmodel) if(turbo.glId!= null) GL11.glDeleteLists(turbo.glId, 1);
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
			ArrayList<Polyhedron<GLObject>> list = copyGroup("corner_bl");
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.posY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[1] && sign.sides[2]){
			ArrayList<Polyhedron<GLObject>> list = copyGroup("corner_tl");
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.posY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[2] && sign.sides[3]){
			ArrayList<Polyhedron<GLObject>> list = copyGroup("corner_tr");
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.posY += (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[3] && sign.sides[0]){
			ArrayList<Polyhedron<GLObject>> list = copyGroup("corner_br");
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) list.forEach(turbo -> turbo.posY -= (j * 4));
				cachedmodel.addAll(list);
			}
		}
		if(sign.sides[0]){
			Polyhedron turbo = copyTurbo("top_bot", 0);
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.posY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.sides[2]){
			Polyhedron turbo = copyTurbo("top_bot", 1);
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.posY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.arrows[0] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[0] ? "right" : "left"), 0)); }
		if(sign.arrows[1] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[1] ? "right" : "left"), 3)); }
		if(sign.arrows[2] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[2] ? "right" : "left"), 2)); }
		if(sign.arrows[3] != null){ cachedmodel.add(copyTurbo("arrow_" + (sign.arrows[3] ? "right" : "left"), 1)); }
		if(sign.arrows[4] != null && sign.arrows[4]){
			Polyhedron turbo = copyTurbo("arrow_top_bot", 0);
			int j = sign.panels[0] ? 0 : sign.panels[1] ? 1 : sign.panels[2] ? 2 : sign.panels[3] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.posY -= (j * 4);
				cachedmodel.add(turbo);
			}
		}
		if(sign.arrows[5] != null && sign.arrows[5]){
			Polyhedron turbo = copyTurbo("arrow_top_bot", 1);
			int j = sign.panels[3] ? 0 : sign.panels[2] ? 1 : sign.panels[1] ? 2 : sign.panels[0] ? 3 : -1;
			if(j != -1){
				if(j > 0) turbo.posY += (j * 4);
				cachedmodel.add(turbo);
			}
		}
	}

    private Polyhedron copyTurbo(String string, int i){
		return StreetSignModel.INSTANCE.groups.get(string).get(i).copy(true);
	}

	@SideOnly(Side.CLIENT)
	private ArrayList<Polyhedron<GLObject>> copyGroup(String string){
    	ArrayList<Polyhedron<GLObject>> list = new ArrayList<>();
    	for(Polyhedron<GLObject> poly : StreetSignModel.INSTANCE.groups.get(string)){
    		list.add(poly.copy(true));
		}
		return list;
	}

	public void delete(){
		for(Polyhedron<GLObject> poly : cachedmodel) if(poly.glId != null) GL11.glDeleteLists(poly.glId, 1);
	}

	public void render(){
		cachedmodel.render();
	}

}
