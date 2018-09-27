package net.fexcraft.mod.addons.test.models;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModelTMT;
import net.fexcraft.mod.lib.fmr.ModelCompound;
import net.fexcraft.mod.lib.fmr.polygons.Cuboid;
import net.fexcraft.mod.lib.fmr.polygons.Cylinder;
import net.fexcraft.mod.lib.fmr.polygons.Shapebox;
import net.fexcraft.mod.lib.fmr.polygons.Sphere;
import net.minecraft.entity.Entity;

// This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2018 Minecraft-SMP.de

// Model: Sentinel
// Model Creator: FEX___96
// Created on: 18.03.2018 - 20:37:49
// Last changed on: 03.08.2018

public class ModelC9T2 extends VehicleModelTMT {
	
	private ModelCompound test0;

	public ModelC9T2(){
		textureX = textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        test0 = new ModelCompound();
        test0.insert(new Cuboid().setSize(4, 4, 4).setOffset(0, 0, 0));
        test0.insert(new Shapebox(false, false).setSize(8, 8, 8).setCorner(0, 2.5f, 2.1f, 2.3f));
        /*test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj"));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0,  -24, 0));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0,  -48, 0));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0,  -72, 0));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0,  -96, 0));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0, -120, 0));
        test0.insert(new Imported(Shape.WAVEFRONT_OBJ, false, false).importOBJ("fvp:models/obj/test.obj").setPosition(0, -144, 0));*/
        test0.insert(new Cylinder(false, false).setRadius(8).setLength(16).setDirection(ModelCompound.DIR_TOP).setFlipped(false));
        test0.insert(new Sphere(false, false).setRadius( 8f).setSegments(16).setRings( 8).setPosition(0, -16, 0));
        test0.insert(new Sphere(false, false).setRadius(16f).setSegments(16).setRings(16).setPosition(0, -32, 0));
        test0.insert(new Sphere(false, false).setRadius(32f).setSegments(16).setRings(32).setPosition(0, -48, 0));
	}
	
	@Override
	public void render(VehicleData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(VehicleData data, Object key, Entity ent, int meta){
		test0.render();
		return;
	}
	
}