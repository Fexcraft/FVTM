package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelObjTest extends PartModel {

    public ModelObjTest(){
    	super(); this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[1];
        //
        body[0] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[0].addObj("fvp:models/obj/test.obj");
        body[0].setRotationPoint(0, -24F, 0);
    }

}
