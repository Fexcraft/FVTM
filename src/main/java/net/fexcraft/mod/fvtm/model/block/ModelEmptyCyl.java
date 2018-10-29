package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;

public class ModelEmptyCyl extends ModelBase {

    public static final ModelEmptyCyl INSTANCE = new ModelEmptyCyl();
    private final ModelRendererTurbo core;

    public ModelEmptyCyl(){
        this.core = new ModelRendererTurbo(this, 0, 0, 32, 32);
        this.core.addCylinder(0, 0, 0, 8, 2, 32, 1, 1, ModelRendererTurbo.MR_TOP);
        this.core.setRotationPoint(0, 22, 0);
    }

    @Override
    public void render(){
        core.render();
    }

	@Override
	public void translateAll(float x, float y, float z){
		//
	}

	@Override
	public void rotateAll(float x, float y, float z) {
		//
	}

}
