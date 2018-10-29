package net.fexcraft.mod.fvtm.model.block;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class AdjSignModel extends ModelBase {

    private static Table<Integer, Integer, AdjSignModel> models = HashBasedTable.create();
    private ModelRendererTurbo body;

    public AdjSignModel(int x, int y){
        body = new ModelRendererTurbo(this, 0, 0, x * 32, y * 32);
        //body.addShapeBox(0F, 0F, 0F, 16 * x, 16 * y, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F);
        body.addBox(0f, 0f, 0f, 16 * x, 16 * y, 0);
        body.setRotationPoint(-8F, -16F, 7.5F);
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

    public static AdjSignModel getModel(int x, int y){
        AdjSignModel model = models.get(x, y);
        if(model == null){
            models.put(x, y, model = new AdjSignModel(x, y));
        }
        return model;
    }

}
