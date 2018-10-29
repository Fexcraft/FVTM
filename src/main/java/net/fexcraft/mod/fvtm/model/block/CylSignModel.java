package net.fexcraft.mod.fvtm.model.block;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class CylSignModel extends ModelBase {

    private static Table<Integer, Integer, CylSignModel> models = HashBasedTable.create();
    private ModelRendererTurbo body;

    public CylSignModel(int x, int y){
        if(x < 8){
            x = 8;
        }
        if(x > 64){
            x = 64;
        }
        if(y < 10){
            y = 10;
        }
        if(y > 80){
            y = 80;
        }
        body = new ModelRendererTurbo(this, 0, 0, 32, 32);
        body.addCylinder(0, 0, 0, 8, 0.4f, x, y / 10f, y / 10f, ModelRendererTurbo.MR_TOP);
        body.setRotationPoint(0F, -8F, 7.5F);
        body.rotateAngleX = Static.rad90;
        this.translateAll(8, 0, 8);
    }

    @Override
    public void render(){
        if(body != null){
            body.render();
        }
    }

    @Override
    public void translateAll(float x, float y, float z){
        body.rotationPointX += x;
        body.rotationPointY += y;
        body.rotationPointZ += z;
    }

    @Override
    public void rotateAll(float x, float y, float z){
        body.rotateAngleX += x;
        body.rotateAngleY += y;
        body.rotateAngleZ += z;
    }

    public static CylSignModel getModel(int x, int y){
        CylSignModel model = models.get(x, y);
        if(model == null){
            models.put(x, y, model = new CylSignModel(x, y));
        }
        return model;
    }

}
