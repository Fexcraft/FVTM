package net.fexcraft.mod.fme.blocks;

import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelEditor extends ModelBase {
	
	public final ModelRendererTurbo core;

	public ModelEditor(){
		this.core = new ModelRendererTurbo(this, 0, 0, 32, 32);
		this.core.addCylinder(0, 0, 0, 8, 0.5f, 32, 1, 1, ModelRendererTurbo.MR_TOP);
		this.core.setRotationPoint(0, 22, 0);
	}

}
