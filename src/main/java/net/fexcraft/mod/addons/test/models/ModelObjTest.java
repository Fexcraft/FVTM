package net.fexcraft.mod.addons.test.models;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.fvtm.util.Resources;

public class ModelObjTest extends PartModel {

    public ModelObjTest(){
    	super(); this.addToCreators("Ferdinand (FEX___96)");
    	ModelRendererTurbo[] body = new ModelRendererTurbo[1];
        //
        body[0] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[0].addObj(Resources.getModelInputStream("fvp:models/obj/test.obj"), null);//"fvp:models/obj/test.obj"
        body[0].setRotationPoint(0, -24F, 0);
        this.add("body", body);
    }

}
