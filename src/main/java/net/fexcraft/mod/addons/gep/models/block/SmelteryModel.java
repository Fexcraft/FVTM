//FMT-Marker FVTM-1.4
package net.fexcraft.mod.addons.gep.models.block;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.scripts.SmelteryScript;
import net.fexcraft.mod.fvtm.block.generated.M_4ROT_TE;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.tileentity.TileEntity;

/** This file was exported via the FVTM Exporter V1.4 of<br>
 *  FMT (Fex's Modelling Toolbox) v.2.5.1 &copy; 2020 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "gep:models/block/smeltery")
public class SmelteryModel extends BlockModel {

	public SmelteryModel(){
		super(); textureX = 512; textureY = 256;
		this.addToCreators("Ferdinand (FEX___96)");
	    gui_scale_x = gui_scale_y = gui_scale_z = 0.125f;
		//
		TurboList body = new TurboList("body");
		body.add(new ModelRendererTurbo(body, 1, 1, textureX, textureY).addBox(-24, 0, -24, 48, 4, 48)
			.setRotationPoint(0, -4, 0).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		body.add(new ModelRendererTurbo(body, 201, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 16, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(-24, -20, -24).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		body.add(new ModelRendererTurbo(body, 313, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 16, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4)
			.setRotationPoint(20, -20, -24).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		body.add(new ModelRendererTurbo(body, 377, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 16, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4)
			.setRotationPoint(20, -36, -24).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		body.add(new ModelRendererTurbo(body, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 16, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(-24, -36, -24).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		body.add(new ModelRendererTurbo(body, 377, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 16, 4, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -20, 20).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		body.add(new ModelRendererTurbo(body, 65, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 16, 4, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -36, 20).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		body.add(new ModelRendererTurbo(body, 129, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 12, 48, 0, -8, 0, -8, 8, 0, -12, 8, 0, -12, -8, 0, -8, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(-24, -48, -24).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		body.add(new ModelRendererTurbo(body, 193, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 12, 48, 0, 8, 0, -12, -8, 0, -8, -8, 0, -8, 8, 0, -12, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4)
			.setRotationPoint(20, -48, -24).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		body.add(new ModelRendererTurbo(body, 257, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 12, 4, 0, -8, 0, -8, -8, 0, -8, -12, 0, 8, -12, 0, 8, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0)
			.setRotationPoint(-24, -48, -24).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		body.add(new ModelRendererTurbo(body, 65, 81, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 12, 4, 0, -12, 0, 8, -12, 0, 8, -8, 0, -8, -8, 0, -8, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -48, 20).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		body.add(new ModelRendererTurbo(body, 153, 1, textureX, textureY).addBox(0, 0, 0, 40, 4, 4)
			.setRotationPoint(-20, -36, -24).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		body.add(new ModelRendererTurbo(body, 305, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 32, 44, 4, 0, -2, 0, -2, -2, 0, -2, -6, 0, 2, -6, 0, 2, 0, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0)
			.setRotationPoint(-16, -92, -16).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		body.add(new ModelRendererTurbo(body, 385, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 44, 32, 0, -2, 0, -2, 2, 0, -6, 2, 0, -6, -2, 0, -2, 0, 0, 0, 0, 0, -4, 0, 0, -4, 0, 0, 0)
			.setRotationPoint(-16, -92, -16).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		body.add(new ModelRendererTurbo(body, 105, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 32, 44, 4, 0, -6, 0, 2, -6, 0, 2, -2, 0, -2, -2, 0, -2, -4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-16, -92, 12).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		body.add(new ModelRendererTurbo(body, 1, 129, textureX, textureY)
			.addShapeBox(0, 0, 0, 4, 44, 32, 0, 2, 0, -6, -2, 0, -2, -2, 0, -2, 2, 0, -6, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, -4)
			.setRotationPoint(12, -92, -16).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		body.add(new ModelRendererTurbo(body, 265, 1, textureX, textureY).addBox(0, 0, 0, 20, 1, 20)
			.setRotationPoint(-10, -90, -10).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		body.add(new ModelRendererTurbo(body, 249, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 18, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-25, -18, -24).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		body.add(new ModelRendererTurbo(body, 129, 121, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 18, 49, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(24, -18, -24).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		body.add(new ModelRendererTurbo(body, 233, 169, textureX, textureY)
			.addShapeBox(0, 0, 0, 48, 18, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-24, -18, 24).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		body.add(new ModelRendererTurbo(body, 1, 1, textureX, textureY).addBox(0, 0, 0, 17, 18, 1)
			.setRotationPoint(-25, -18, -25).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		body.add(new ModelRendererTurbo(body, 153, 17, textureX, textureY).addBox(0, 0, 0, 17, 18, 1)
			.setRotationPoint(8, -18, -25).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		body.add(new ModelRendererTurbo(body, 265, 25, textureX, textureY).addBox(0, 0, 0, 40, 8, 4)
			.setRotationPoint(-20, -20, -24).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		body.add(new ModelRendererTurbo(body, 337, 177, textureX, textureY).addBox(0, 0, 0, 40, 6, 4)
			.setRotationPoint(-20, -10, -24).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		body.add(new ModelRendererTurbo(body, 441, 25, textureX, textureY).addBox(0, 0, 0, 16, 13, 16)
			.setRotationPoint(-8, -13, -40).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		body.add(new ModelRendererTurbo(body, 193, 17, textureX, textureY).addBox(0, 0, 0, 2, 3, 16)
			.setRotationPoint(-8, -16, -40).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		body.add(new ModelRendererTurbo(body, 1, 25, textureX, textureY).addBox(0, 0, 0, 2, 3, 16)
			.setRotationPoint(6, -16, -40).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		body.add(new ModelRendererTurbo(body, 329, 1, textureX, textureY).addBox(0, 0, 0, 12, 3, 2)
			.setRotationPoint(-6, -16, -40).setRotationAngle(0, 0, 0).setName("Box 27")
		);
		body.add(new ModelRendererTurbo(body, 329, 9, textureX, textureY).addBox(0, 0, 0, 12, 4, 2)
			.setRotationPoint(-6, -16, -36).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		body.add(new ModelRendererTurbo(body, 217, 17, textureX, textureY).addBox(0, 0, 0, 12, 4, 2)
			.setRotationPoint(-6, -16, -32).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		body.add(new ModelRendererTurbo(body, 217, 25, textureX, textureY).addBox(0, 0, 0, 12, 4, 2)
			.setRotationPoint(-6, -16, -28).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		body.add(new ModelRendererTurbo(body, 377, 25, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 15, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-1, -18, -38.5f).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		body.add(new ModelRendererTurbo(body, 441, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10)
			.setRotationPoint(0, -20, -20).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		body.add(new ModelRendererTurbo(body, 433, 97, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0)
			.setRotationPoint(-20, -20, -20).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		body.add(new ModelRendererTurbo(body, 433, 113, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10)
			.setRotationPoint(0, -33, -20).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		body.add(new ModelRendererTurbo(body, 185, 153, textureX, textureY)
			.addShapeBox(0, 0, 0, 20, 1, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0)
			.setRotationPoint(-20, -33, -20).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		body.add(new ModelRendererTurbo(body, 193, 73, textureX, textureY).addBox(0, 0, 0, 4, 5, 16)
			.setRotationPoint(-2, -16.5f, -39.5f).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		body.add(new ModelRendererTurbo(body, 41, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(6, -18, -25).setRotationAngle(0, 0, 0).setName("Box 50")
		);
		body.add(new ModelRendererTurbo(body, 241, 1, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, -1.8f, 0, 0, -1.8f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-8, -18, -25).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		body.add(new ModelRendererTurbo(body, 41, 9, textureX, textureY).addBox(0, 0, 0, 2, 4, 1)
			.setRotationPoint(-23, -30, -24.5f).setRotationAngle(0, 0, 0).setName("Box 52")
		);
		body.add(new ModelRendererTurbo(body, 241, 9, textureX, textureY).addBox(0, 0, 0, 2, 4, 1)
			.setRotationPoint(21, -30, -24.5f).setRotationAngle(0, 0, 0).setName("Box 53")
		);
		body.add(new ModelRendererTurbo(body, 153, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 42, 3, 2, 0, 0, 0, -1, 0, 0, -1, 2, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0)
			.setRotationPoint(-21, -36, -25).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		body.add(new ModelRendererTurbo(body, 0, 0, textureX, textureY).addBox(0, 0, 0, 1, 1, 1).setName("Box 56"));
		this.groups.add(body);
		//
		TurboList door_right = new TurboList("door_right");
		door_right.add(new ModelRendererTurbo(door_right, 1, 57, textureX, textureY)
			.addShapeBox(0, 0, -21, 12, 12, 1, 0, 0, 0, 0, 0, 0, -4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 4, 0, 0, 0)
			.setRotationPoint(0, -32, 0).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		door_right.add(new ModelRendererTurbo(door_right, 489, 1, textureX, textureY)
			.addShapeBox(12, 0, -17, 9, 12, 1, 0, 0, 0, 0, 0, 0, -9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, -9, 0, 0, 9, 0, 0, 0)
			.setRotationPoint(0, -32, 0).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		door_right.addProgram(new TurboList.Program(){
			
			private boolean wasopen;

			@Override
			public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				if(tile == null) return;
				MultiBlockData multidata = ((M_4ROT_TE.TileEntity)tile).getMultiBlockData();
				if(multidata != null && multidata.getScript() != null && ((SmelteryScript)multidata.getScript()).isOpen()){
					list.rotate(0, -45, 0, true);
					wasopen = true;
				}
			}

			@Override
			public void postRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				if(wasopen){
					list.rotate(0, 0, 0, true);
					wasopen = false;
				}
			}
			
		});
		this.groups.add(door_right);
		//
		TurboList door_left = new TurboList("door_left");
		door_left.add(new ModelRendererTurbo(door_left, 1, 73, textureX, textureY)
			.addShapeBox(-12, 0, -21, 12, 12, 1, 0, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, -4, 0, 0, 0, 0, 0, 0, 0, 0, 4)
			.setRotationPoint(0, -32, 0).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		door_left.add(new ModelRendererTurbo(door_left, 25, 25, textureX, textureY)
			.addShapeBox(-21, 0, -17, 9, 12, 1, 0, 0, 0, -9, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, -9, 0, 0, 0, 0, 0, 0, 0, 0, 9)
			.setRotationPoint(0, -32, 0).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		door_left.addProgram(new TurboList.Program(){
			
			private boolean wasopen;

			@Override
			public void preRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				if(tile == null) return;
				MultiBlockData multidata = ((M_4ROT_TE.TileEntity)tile).getMultiBlockData();
				if(multidata != null && multidata.getScript() != null && ((SmelteryScript)multidata.getScript()).isOpen()){
					list.rotate(0, 45, 0, true);
					wasopen = true;
				}
			}

			@Override
			public void postRender(TurboList list, @Nullable TileEntity tile, BlockData data, @Nullable RenderCache cache){
				if(wasopen){
					list.rotate(0, 0, 0, true);
					wasopen = false;
				}
			}
			
		});
		this.groups.add(door_left);
		//
		TurboList bars = new TurboList("bars");
		bars.add(new ModelRendererTurbo(bars, 265, 1, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(-6, -15, -26).setRotationAngle(0, 0, 0).setName("Box 40")
		);
		bars.add(new ModelRendererTurbo(bars, 265, 9, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(2, -15, -26).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		bars.add(new ModelRendererTurbo(bars, 193, 17, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(-6, -15, -30).setRotationAngle(0, 0, 0).setName("Box 43")
		);
		bars.add(new ModelRendererTurbo(bars, 489, 17, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(2, -15, -30).setRotationAngle(0, 0, 0).setName("Box 44")
		);
		bars.add(new ModelRendererTurbo(bars, 1, 25, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(-6, -15, -34).setRotationAngle(0, 0, 0).setName("Box 45")
		);
		bars.add(new ModelRendererTurbo(bars, 193, 25, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(2, -15, -34).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		bars.add(new ModelRendererTurbo(bars, 377, 25, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(-6, -15, -38).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		bars.add(new ModelRendererTurbo(bars, 401, 25, textureX, textureY).addBox(0, 0, 0, 4, 2, 2)
			.setRotationPoint(2, -15, -38).setRotationAngle(0, 0, 0).setName("Box 48")
		);
		this.groups.add(bars);
	}
	
}
