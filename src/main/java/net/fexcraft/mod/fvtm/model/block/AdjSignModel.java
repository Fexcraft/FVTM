package net.fexcraft.mod.fvtm.model.block;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.entity.Entity;

public class AdjSignModel extends Model<Object> {
	
	private static Table<Integer, Integer, AdjSignModel> models = HashBasedTable.create();
	private ModelRendererTurbo body;

	public AdjSignModel(int x, int y){
		this.textureWidth = x * 16;
		this.textureHeight = y * 16;
		body = new ModelRendererTurbo(this, 0, 0, this.textureWidth, this.textureHeight);
		body.addShapeBox(0F, 0F, 0F, 16 * x, 16 * y, 1, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, -0.8F, 0F, 0F, -0.8F);
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
	public void render(Object type, Entity entity){
		render();
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
		AdjSignModel model = models.get(x,  y);
		if(model == null){
			models.put(x, y, model = new AdjSignModel(x, y));
		}
		return model;
	}
	
}