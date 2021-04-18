//FMT-Marker FVTM-1.5
package net.fexcraft.mod.addons.gep.models.block;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.ConditionalPrograms;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.tileentity.TileEntity;

/** This file was exported via the FVTM Exporter v1.5 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.6.5 &copy; 2021 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/block/simple_switch_fork2")
public class SimpleSwitchFork2Model extends BlockModel {

	public SimpleSwitchFork2Model(){
		super(); textureX = 32; textureY = 16;
		this.addToCreators("Ferdinand (FEX___96)");
	    gui_scale_x = gui_scale_y = gui_scale_z = 0.5f;
		//
		TurboList base = new TurboList("base");
		base.add(new ModelRendererTurbo(base, 0, 6, textureX, textureY).addCylinder(0, 0, 0, 2, 2, 16, 1, 1, 1, null)
			.setRotationPoint(0, -1, -1).setRotationAngle(0, 0, -90)
		);
		base.add(new ModelRendererTurbo(base, 0, 0, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 1, 4, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, -0.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -1, -2).setRotationAngle(0, 0, 0)
		);
		this.groups.add(base);
		//
		TurboList lever = new TurboList("lever");
		lever.add(new ModelRendererTurbo(lever, 9, 6, textureX, textureY).addBox(-0.25f, -8, -0.25f, 0.5f, 8, 0.5f)
			.setRotationPoint(0, -1, 0).setRotationAngle(0, 0, 0)
		);
		lever.addProgram(new ConditionalPrograms.SwitchFork2State()
			.add(new DefaultPrograms.RotationSetter(2, 20, 0, true))
			.addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(lever);
		//
		TurboList sign = new TurboList("sign");
		sign.add(new ModelRendererTurbo(sign, 14, 6, textureX, textureY).addBox(-0.2f, -11, -1.5f, 0.4f, 3, 3)
			.setRotationPoint(0, -1, 0).setRotationAngle(0, 0, 0)
		);
		sign.add(new ModelRendererTurbo(sign, 23, 6, textureX, textureY).addBox(-1.5f, -11, -0.2f, 3, 3, 0.4f)
			.setRotationPoint(0, -1, 0).setRotationAngle(0, 0, 0)
		);
		sign.addPrograms(new ConditionalPrograms.SwitchFork2State().add(new TurboList.Program(){
			@Override
			public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				GL11.glPushMatrix();
				GL11.glRotatef(20, 0, 0, 2);
				GL11.glRotatef(90, 0, 1, 0);
			}
			@Override
			public void postRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				GL11.glPopMatrix();
			}
		}).addElse(new DefaultPrograms.RotationSetter(2, -20, 0, true)));
		this.groups.add(sign);
		//
	}

}
