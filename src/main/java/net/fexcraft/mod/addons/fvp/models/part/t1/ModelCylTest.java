//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2017 Minecraft-SMP.de
// Model: C2R2T1 Wheel
// Model Creator: FEX___96
// Created on: 31.03.2017 - 14:38:29
// Last changed on: 31.03.2017 - 14:38:29
package net.fexcraft.mod.addons.fvp.models.part.t1;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.part.PartModel;

public class ModelCylTest extends PartModel {

    public ModelCylTest(){
    	super(); this.addToCreators("Ferdinand (FEX___96)");
    	ModelRendererTurbo[] body = new ModelRendererTurbo[4];
        //
        body[0] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[0].addCylinder(0, -24, -12, 5, 20, 16, 1, 1, ModelRendererTurbo.MR_TOP);
        body[0].setRotationPoint(0, -24F, 0);
        //
        body[1] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[1].mirror = true;
        body[1].flip = true;
        body[1].addCylinder(0, -24, 0, 5, 20, 32, 1, 1, ModelRendererTurbo.MR_TOP);
        body[1].setRotationPoint(0, -24F, 0);
        //
        body[2] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[2].addCylinder(0, -24, 12, 5, 20, 16, 1.5f, 1.2f, ModelRendererTurbo.MR_RIGHT);
        body[2].setRotationPoint(0, -24F, 0);
        //
        body[3] = new ModelRendererTurbo(this, 0, 0, 512, 512);
        body[3].addCone(12, -24, -12, 5, 20, 16, 1f, ModelRendererTurbo.MR_RIGHT);
        body[3].setRotationPoint(0, -24F, 0);
        this.add("body", body);
    }

}
