//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod
// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40
package net.fexcraft.mod.fvtm.model.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

public class NullModel extends PartModel<VehicleData> {

    int textureX = 512;
    int textureY = 512;

    private static final NullModel nullmodel = new NullModel();

    public NullModel(){
    }

    @Override
    public void render(){
        return;
    }

    @Override
    public void render(VehicleData data, String usedAs){
        return;
    }

    @Override
    public void render(VehicleData data, String usedAS, Entity vehicle){
        //
    }

    public static PartModel<VehicleData> get(){
        return nullmodel;
    }

}
