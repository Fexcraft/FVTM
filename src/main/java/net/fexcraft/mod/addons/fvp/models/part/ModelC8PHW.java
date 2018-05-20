package net.fexcraft.mod.addons.fvp.models.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.Coord2D;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.tmt.Shape2D;
import net.minecraft.entity.Entity;

public class ModelC8PHW extends PartModel<VehicleData> {

    private static final int textureX = 512, textureY = 512;

    public ModelC8PHW(){
        this.creators.add("01e4af9b-2a30-471e-addf-f6338ffce04b");
        wheel_front_left = new ModelRendererTurbo[1];
        wheel_front_left[0] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Shape 11
        wheel_front_left[0].addShape3D(8F, -8F, -4F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 11
        wheel_front_left[0].setRotationPoint(39F, 2F, 16.5F);
        //
        wheel_front_right = new ModelRendererTurbo[1];
        wheel_front_right[0] = new ModelRendererTurbo(this, 201, 1, textureX, textureY); // Shape 10
        wheel_front_right[0].addShape3D(8F, -8F, 0F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 10
        wheel_front_right[0].setRotationPoint(39F, 2F, -16.5F);
        //
        wheel_back_left = new ModelRendererTurbo[1];
        wheel_back_left[0] = new ModelRendererTurbo(this, 393, 1, textureX, textureY); // Shape 13
        wheel_back_left[0].addShape3D(8F, -8F, -4F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 13
        wheel_back_left[0].setRotationPoint(-39F, 2F, 16.5F);
        //
        wheel_back_right = new ModelRendererTurbo[1];
        wheel_back_right[0] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Shape 12
        wheel_back_right[0].addShape3D(8F, -8F, 0F, new Shape2D(new Coord2D[]{new Coord2D(8, 0, 8, 0), new Coord2D(14, 2, 14, 2), new Coord2D(16, 8, 16, 8), new Coord2D(14, 14, 14, 14), new Coord2D(8, 16, 8, 16), new Coord2D(2, 14, 2, 14), new Coord2D(0, 8, 0, 8), new Coord2D(2, 2, 2, 2)}), 4, 16, 16, 56, 4, ModelRendererTurbo.MR_FRONT, new float[]{7, 7, 7, 7, 7, 7, 7, 7}); // Shape 12
        wheel_back_right[0].setRotationPoint(-39F, 2F, -16.5F);

        flipAll();

    }

    @Override
    public void render(VehicleData data, String us){
        super.def_renderWheels4(data, us);
    }

    @Override
    public void render(VehicleData data, String us, Entity vehicle){
        super.def_renderWheels4(data, us, vehicle);
    }

}
