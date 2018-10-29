package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.fvtm.util.Resources;

public class ModelObjTest extends PartModelTMT {

    public ModelObjTest(){
    	super(); this.addToCreators("Ferdinand (FEX___96)");
        body = new ModelRendererTurbo[1];
        //
        body[0] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[0].addObj("fvp:models/obj/test.obj", Resources.getModelInputStream("fvp:models/obj/test.obj"));
        body[0].setRotationPoint(0, -24F, 0);
    }

}
