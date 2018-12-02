package net.fexcraft.mod.addons.fvp.models.part.c8;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.Coord2D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.lib.tmt.Shape2D;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.part.PartModel;

@fModel(registryname = "fvp:models/part/c8_phwheel")
public class C8PHW extends PartModel {

    public C8PHW(){
    	super(); textureX = 512; textureY = 512;
        this.addToCreators("01e4af9b-2a30-471e-addf-f6338ffce04b");
        ModelRendererTurbo[] wheel_front_left = new ModelRendererTurbo[1];
        wheel_front_left[0] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Shape 11
        wheel_front_left[0].addShape3D(8F, -8F, -4F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 11
        wheel_front_left[0].setRotationPoint(39F, 2F, 16.5F);
        this.add("wheel_front_left", wheel_front_left);
        this.get("wheel_front_left").addProgram(DefaultPrograms.IMPORTED_WHEEL);
        //
        ModelRendererTurbo[] wheel_front_right = new ModelRendererTurbo[1];
        wheel_front_right[0] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Shape 10
        wheel_front_right[0].addShape3D(8F, -8F, 0F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 10
        wheel_front_right[0].setRotationPoint(39F, 2F, -16.5F);
        this.add("wheel_front_right", wheel_front_right);
        this.get("wheel_front_right").addProgram(DefaultPrograms.IMPORTED_WHEEL);
        //
        ModelRendererTurbo[] wheel_back_left = new ModelRendererTurbo[1];
        wheel_back_left[0] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Shape 13
        wheel_back_left[0].addShape3D(8F, -8F, -4F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 13
        wheel_back_left[0].setRotationPoint(-39F, 2F, 16.5F);
        this.add("wheel_back_left", wheel_back_left);
        this.get("wheel_back_left").addProgram(DefaultPrograms.IMPORTED_WHEEL);
        //
        ModelRendererTurbo[] wheel_back_right = new ModelRendererTurbo[1];
        wheel_back_right[0] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Shape 12
        wheel_back_right[0].addShape3D(8F, -8F, 0F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 12
        wheel_back_right[0].setRotationPoint(-39F, 2F, -16.5F);
        this.add("wheel_back_right", wheel_back_right);
        this.get("wheel_back_right").addProgram(DefaultPrograms.IMPORTED_WHEEL);
        fixRotations();
    }

}
