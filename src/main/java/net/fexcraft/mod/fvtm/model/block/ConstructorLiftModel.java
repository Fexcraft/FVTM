//FMT-Marker FVTM-1
package net.fexcraft.mod.fvtm.model.block;

import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.block.ConstructorCenterEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.1.7 &copy; 2019 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
public class ConstructorLiftModel extends GenericModel<ConstructorCenterEntity, BlockPos> {
	
	public static final ConstructorLiftModel INSTANCE = new ConstructorLiftModel();
	//
	private TurboList frame, holder, primary, secondary, rails;

	public ConstructorLiftModel(){
		super(); textureX = 256; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		frame = new TurboList("frame");
		frame.add(new ModelRendererTurbo(frame, 113, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 12, 16, 1, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-6, -16, 6).setRotationAngle(0, 0, -0).setName("Box 21")
		);
		frame.add(new ModelRendererTurbo(frame, 145, 1, textureX, textureY).addBox(0, 0, 0, 2, 16, 1)
			.setRotationPoint(-6, -16, 7).setRotationAngle(0, 0, -0).setName("Box 22")
		);
		frame.add(new ModelRendererTurbo(frame, 153, 1, textureX, textureY).addBox(0, 0, 0, 2, 16, 1)
			.setRotationPoint(4, -16, 7).setRotationAngle(0, 0, -0).setName("Box 23")
		);
		this.groups.add(frame);
		//
		holder = new TurboList("holder");
		holder.add(new ModelRendererTurbo(holder, 25, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 12, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(2, -1, -6).setRotationAngle(0, 0, -0).setName("Box 18")
		);
		holder.add(new ModelRendererTurbo(holder, 57, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 1, 12, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-5, -1, -6).setRotationAngle(0, 0, -0).setName("Box 19")
		);
		holder.add(new ModelRendererTurbo(holder, 81, 1, textureX, textureY).addBox(0, 0, 0, 4, 1, 8)
			.setRotationPoint(-2, -1, -6).setRotationAngle(0, 0, -0).setName("Box 20")
		);
		this.groups.add(holder);
		//
		primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 161, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0)
			.setRotationPoint(-4, -16, 7).setRotationAngle(0, 0, -0).setName("Box 24")
		);
		primary.add(new ModelRendererTurbo(primary, 177, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f)
			.setRotationPoint(1, -16, 7).setRotationAngle(0, 0, -0).setName("Box 25")
		);
		this.groups.add(primary);
		//
		rails = new TurboList("rails");
		rails.add(new ModelRendererTurbo(rails, 1, 1, textureX, textureY).addBox(0, 0, 0, 16, 1, 1)
			.setRotationPoint(-8, -1, -3).setRotationAngle(0, 0, -0).setName("Box 0")
		);
		rails.add(new ModelRendererTurbo(rails, 1, 9, textureX, textureY).addBox(0, 0, 0, 16, 1, 1)
			.setRotationPoint(-8, -1, 2).setRotationAngle(0, 0, -0).setName("Box 1")
		);
		rails.add(new ModelRendererTurbo(rails, 1, 17, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 1, 8, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -2, -4).setRotationAngle(0, 0, -0).setName("Box 2")
		);
		rails.add(new ModelRendererTurbo(rails, 1, 33, textureX, textureY)
			.addShapeBox(0, 0.5f, 0, 16, 1, 1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -3, -4).setRotationAngle(0, 0, -0).setName("Box 3")
		);
		rails.add(new ModelRendererTurbo(rails, 1, 41, textureX, textureY)
			.addShapeBox(0, 0.5f, 0, 16, 1, 1, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -3, 3).setRotationAngle(0, 0, -0).setName("Box 4")
		);
		this.groups.add(rails);
		//
		secondary = new TurboList("secondary");
		secondary.add(new ModelRendererTurbo(secondary, 193, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 16, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f, 0, 0, 0, 0, 0, 0, 0, 0, -0.8f, 0, 0, -0.8f)
			.setRotationPoint(-1, -16, 7).setRotationAngle(0, 0, -0).setName("Box 26")
		);
		this.groups.add(secondary);
	}

	@Override
	public void render(ConstructorCenterEntity data, BlockPos key){
		//TODO
	}

	@Override
	public void render(ConstructorCenterEntity data, BlockPos key, Entity ent, int meta){
		this.render(data, key); return;
	}

}
