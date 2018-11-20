//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ab1b;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.DefaultPrograms.AutoRegProgram;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;

/** This file was exported via the FVTM Exporter V1 of
 *  FMT (Fex's Modelling Toolbox) v.1.0.1-test &copy; 2018 - Fexcraft.net
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ab1b_doors")
public class AB1Doors extends PartModel {

	public AB1Doors(){
		super(); textureX = 1024; textureY = 1024;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList back_door = new TurboList("back_door");
		back_door.add(new ModelRendererTurbo(back_door, 457, 177, textureX, textureY).addBox(0, 0, 0, 14, 22, 1)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 298")
		);
		back_door.add(new ModelRendererTurbo(back_door, 41, 105, textureX, textureY).addBox(9, 6, -0.5f, 3, 1, 2)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 299")
		);
		back_door.add(new ModelRendererTurbo(back_door, 913, 57, textureX, textureY)
			.addShapeBox(0, -21, 0, 1, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 300")
		);
		back_door.add(new ModelRendererTurbo(back_door, 337, 145, textureX, textureY)
			.addShapeBox(13, -21, 0, 1, 21, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 301")
		);
		back_door.add(new ModelRendererTurbo(back_door, 57, 105, textureX, textureY).addBox(1, -21, 1, 12, 1, 1)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 302")
		);
		back_door.add(new ModelRendererTurbo(back_door, 1, 105, textureX, textureY).addBox(-1, 2, 0.5f, 3, 2, 1)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 303")
		);
		back_door.add(new ModelRendererTurbo(back_door, 89, 105, textureX, textureY).addBox(-1, 16, 0.5f, 3, 2, 1)
			.setRotationPoint(-54, -26, -31.5f).setRotationAngle(0, 0, 0).setName("Box 304")
		);
		back_door.addProgram(AB1BDOORPROG);
		back_door.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(back_door);
		//
		TurboList front_door = new TurboList("front_door");
		front_door.add(new ModelRendererTurbo(front_door, 1, 161, textureX, textureY).addBox(0, 0, 0, 13, 17, 1)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 289")
		);
		front_door.add(new ModelRendererTurbo(front_door, 209, 57, textureX, textureY)
			.addShapeBox(0, -23, 0, 1, 23, 1, 0, 0, 0, -1, 0, 0, -1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 290")
		);
		front_door.add(new ModelRendererTurbo(front_door, 297, 57, textureX, textureY)
			.addShapeBox(12, -23, 0, 1, 23, 1, 0, 2, 0, -1, -2, 0, -1, -2, 0, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 291")
		);
		front_door.add(new ModelRendererTurbo(front_door, 481, 97, textureX, textureY)
			.addShapeBox(1, -23, 1, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 292")
		);
		front_door.add(new ModelRendererTurbo(front_door, 57, 81, textureX, textureY).addBox(-1, 1, 0.5f, 3, 2, 1)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 293")
		);
		front_door.add(new ModelRendererTurbo(front_door, 169, 81, textureX, textureY).addBox(-1, 13, 0.5f, 3, 2, 1)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 294")
		);
		front_door.add(new ModelRendererTurbo(front_door, 273, 89, textureX, textureY).addBox(9, 1, -0.5f, 3, 1, 2)
			.setRotationPoint(82, -21, -31.5f).setRotationAngle(0, 0, 0).setName("Box 296")
		);
		front_door.addProgram(AB1BDOORPROG);
		front_door.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(front_door);
		//
	}
	
	//TODO add animation state
	private static final TurboList.Program AB1BDOORPROG = new AutoRegProgram(){
		@Override
		public String getId(){
			return "ab1b_doors";
		}
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			if(data.doorsOpen()){
				for(ModelRendererTurbo con : list){ con.rotateAngleY = Static.rad90; }
			}
		}
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			for(ModelRendererTurbo con : list){ con.rotateAngleY = 0; }
		}
	};

}
