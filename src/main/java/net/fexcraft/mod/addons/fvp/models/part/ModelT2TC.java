//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de
// This file is for Fex's Vehicle & Transportation Mod
// Model: T2 (Trailer Connection Point)
// Model Creator: FEX___96
package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class ModelT2TC extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    public ModelT2TC(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        body = new ModelRendererTurbo[3];
        body[0] = new ModelRendererTurbo(this, 129, 297, textureX, textureY); // Box 218
        body[1] = new ModelRendererTurbo(this, 465, 193, textureX, textureY); // Box 219
        body[2] = new ModelRendererTurbo(this, 465, 209, textureX, textureY); // Box 220
        body[0].addShapeBox(0F, 0F, 0F, 8, 3, 20, 0F, 0F, 0F, -2F, -3F, 0F, -2F, -3F, 0F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 218
        body[0].setRotationPoint(-28F, -17F, -10F);
        body[1].addShapeBox(0F, 0F, 0F, 15, 3, 8, 0F, -2F, -1F, -2F, 0F, 0F, -2F, 0F, 0F, 0F, -2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 219
        body[1].setRotationPoint(-43F, -17F, -10F);
        body[2].addShapeBox(0F, 0F, 0F, 15, 3, 8, 0F, -2F, -1F, 0F, 0F, 0F, 0F, 0F, 0F, -2F, -2F, -1F, -2F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F); // Box 220
        body[2].setRotationPoint(-43F, -17F, 2F);
        //translateAll(0F, 0F, 0F);
        flipAll();
    }

    @Override
    public void render(VehicleData data, String us){
        render(body);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle){
        render(body);
    }

}
