//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.hcp.models.vehicle;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.DefaultPrograms;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "hcp:models/vehicle/container_lift")
public class ContainerLiftModel extends VehicleModel {

	public ContainerLiftModel(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList grabber = new TurboList("grabber");
		grabber.add(new ModelRendererTurbo(grabber, 203, 13, textureX, textureY).addBox(0, 0, 0, 96, 2, 5)
			.setRotationPoint(-48, -146, 19).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 0, 13, textureX, textureY).addBox(0, 0, 0, 96, 2, 5)
			.setRotationPoint(-48, -146, -24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 0, 0, textureX, textureY).addBox(0, 0, 0, 176, 2, 10)
			.setRotationPoint(-88, -146, -5).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 217, 136, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f)
			.setRotationPoint(40, -146, 24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 177, 136, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f)
			.setRotationPoint(-48, -146, 24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 25, 126, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f)
			.setRotationPoint(-4, -146, 24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 426, 73, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(40, -146, -25).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 474, 65, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-48, -146, -25).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 474, 57, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-4, -146, -25).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 217, 141, textureX, textureY).addBox(0, 0, 0, 8, 2, 48)
			.setRotationPoint(88, -146, -24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 358, 139, textureX, textureY).addBox(0, 0, 0, 8, 2, 48)
			.setRotationPoint(-96, -146, -24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 474, 49, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f)
			.setRotationPoint(-96, -146, 24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 474, 41, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-96, -146, -25).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 376, 32, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, 0, 0, 0, 0, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f)
			.setRotationPoint(88, -146, 24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 376, 24, textureX, textureY)
			.addShapeBox(0, 0, 0, 8, 6, 1, 0, 0, -0.25f, -0.25f, 0, -0.25f, -0.25f, 0, 0, 0, 0, 0, 0, 0, -1.5f, -0.25f, 0, -1.5f, -0.25f, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(88, -146, -25).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 293, 136, textureX, textureY).addBox(0, 0, 0, 8, 2, 48)
			.setRotationPoint(-32, -148, -24).setRotationAngle(0, 0, 0)
		);
		grabber.add(new ModelRendererTurbo(grabber, 152, 136, textureX, textureY).addBox(0, 0, 0, 8, 2, 48)
			.setRotationPoint(24, -148, -24).setRotationAngle(0, 0, 0)
		);
		grabber.addProgram(new TurboList.Program(){
			@Override
			public String getId(){
				return "hcp:container_lift";
			}
			//
			@Override
			public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
				//
			}
			//
			@Override
			public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
				//
			}
		});
		this.groups.add(grabber);
		//
		TurboList ladder = new TurboList("ladder");
		ladder.add(new ModelRendererTurbo(ladder, 62, 159, textureX, textureY).addBox(0, 0, 0, 2, 90, 1)
			.setRotationPoint(46, -97.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 55, 158, textureX, textureY).addBox(0, 0, 0, 2, 90, 1)
			.setRotationPoint(37, -97.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 404, 126, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -96.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 334, 126, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -91.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 44, 126, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -86.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 404, 123, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -81.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 334, 123, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -76.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 477, 122, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -71.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 460, 122, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -66.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 267, 119, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -61.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 427, 109, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -56.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 427, 106, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -51.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 280, 102, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -46.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 270, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -41.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 253, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -36.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 236, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -31.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 219, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -26.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 202, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -21.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 185, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -16.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		ladder.add(new ModelRendererTurbo(ladder, 168, 92, textureX, textureY).addBox(0, 0, 0, 7, 1, 1)
			.setRotationPoint(39, -11.5f, -33.5f).setRotationAngle(0, 0, 0)
		);
		this.groups.add(ladder);
		//
		TurboList primary = new TurboList("primary");
		primary.add(new ModelRendererTurbo(primary, 386, 106, textureX, textureY).addBox(0, 0, 0, 16, 8, 8)
			.setRotationPoint(36, -8, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 337, 106, textureX, textureY).addBox(0, 0, 0, 16, 8, 8)
			.setRotationPoint(-52, -8, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 288, 106, textureX, textureY).addBox(0, 0, 0, 16, 8, 8)
			.setRotationPoint(-52, -8, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 439, 105, textureX, textureY).addBox(0, 0, 0, 16, 8, 8)
			.setRotationPoint(36, -8, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 427, 122, textureX, textureY).addBox(0, 0, 0, 12, 8, 8)
			.setRotationPoint(36, -100, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 234, 119, textureX, textureY).addBox(0, 0, 0, 12, 8, 8)
			.setRotationPoint(-48, -100, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 193, 119, textureX, textureY).addBox(0, 0, 0, 12, 8, 8)
			.setRotationPoint(-48, -100, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 152, 119, textureX, textureY).addBox(0, 0, 0, 12, 8, 8)
			.setRotationPoint(36, -100, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 152, 136, textureX, textureY).addBox(0, 0, 0, 8, 8, 8)
			.setRotationPoint(36, -152, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 25, 135, textureX, textureY).addBox(0, 0, 0, 8, 8, 8)
			.setRotationPoint(-44, -152, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 308, 134, textureX, textureY).addBox(0, 0, 0, 8, 8, 8)
			.setRotationPoint(-44, -152, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 0, 126, textureX, textureY).addBox(0, 0, 0, 8, 8, 8)
			.setRotationPoint(36, -152, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 239, 102, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, -10, 0, 0, 0, 0, 0)
			.setRotationPoint(36, 0, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 190, 102, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, -10, 0, 0, 0, 0, 0)
			.setRotationPoint(36, 0, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 141, 102, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0)
			.setRotationPoint(-52, 0, -33).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 0, 60, textureX, textureY)
			.addShapeBox(0, 0, 0, 16, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0)
			.setRotationPoint(-52, 0, 25).setRotationAngle(0, 0, 0)
		);
		primary.add(new ModelRendererTurbo(primary, 0, 28, textureX, textureY).addBox(0, 0, 0, 88, 4, 50)
			.setRotationPoint(-44, -152, -25).setRotationAngle(0, 0, 0)
		);
		primary.addProgram(DefaultPrograms.RGB_PRIMARY);
		this.groups.add(primary);
		//
		TurboList secondary = new TurboList("secondary");
		secondary.add(new ModelRendererTurbo(secondary, 0, 99, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, -7, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 298, 97, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, -7, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 149, 95, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -98, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 0, 92, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -98, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 296, 90, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -150, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 298, 83, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -150, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 139, 119, textureX, textureY).addCylinder(0, 0, 0, 3, 84, 12, 1, 1, 4)
			.setRotationPoint(44, -92, -29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 126, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 84, 12, 1, 1, 4)
			.setRotationPoint(-44, -92, -29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 113, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 84, 12, 1, 1, 4)
			.setRotationPoint(44, -92, 29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 100, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 44, 12, 1, 1, 4)
			.setRotationPoint(40, -144, -29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 87, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 44, 12, 1, 1, 4)
			.setRotationPoint(-40, -144, -29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 74, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 44, 12, 1, 1, 4)
			.setRotationPoint(40, -144, 29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 61, 108, textureX, textureY).addCylinder(0, 0, 0, 3, 44, 12, 1, 1, 4)
			.setRotationPoint(-40, -144, 29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 44, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -77, 0, 0, 77, 0, 0, 77, 0, 0, -77, 0, 0)
			.setRotationPoint(-40, -92, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 33, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0, 0, -77, 0, 0, -77, 0, 0, 77, 0, 0)
			.setRotationPoint(37, -92, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 22, 152, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -77, 0, 0, 77, 0, 0, 77, 0, 0, -77, 0, 0)
			.setRotationPoint(-40, -92, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 11, 143, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0, 0, -77, 0, 0, -77, 0, 0, 77, 0, 0)
			.setRotationPoint(37, -92, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 468, 125, textureX, textureY).addBox(-4, -4, -3.5f, 8, 8, 7)
			.setRotationPoint(0, -50, 29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 380, 123, textureX, textureY).addBox(-4, -4, -3.5f, 8, 8, 7)
			.setRotationPoint(0, -50, -29).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 149, 83, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, 1, 30).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 0, 83, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, 1, -32).setRotationAngle(0, 0, 0)
		);
		secondary.add(new ModelRendererTurbo(secondary, 496, 41, textureX, textureY).addCylinder(0, 0, 0, 3, 84, 12, 1, 1, 4)
			.setRotationPoint(-44, -92, 29).setRotationAngle(0, 0, 0)
		);
		secondary.addProgram(DefaultPrograms.RGB_SECONDARY);
		this.groups.add(secondary);
		//
		TurboList steel = new TurboList("steel");
		steel.add(new ModelRendererTurbo(steel, 277, 74, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, -7, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 65, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, -7, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 58, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -98, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 51, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -98, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 44, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -150, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 37, textureX, textureY).addBox(0, 0, 0, 72, 4, 2)
			.setRotationPoint(-36, -150, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 0, 143, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -77, 0, 0, 77, 0, 0, 77, 0, 0, -77, 0, 0)
			.setRotationPoint(-40, -92, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 482, 141, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0, 0, -77, 0, 0, -77, 0, 0, 77, 0, 0)
			.setRotationPoint(37, -92, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 471, 141, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -77, 0, 0, 77, 0, 0, 77, 0, 0, -77, 0, 0)
			.setRotationPoint(-40, -92, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 499, 132, textureX, textureY)
			.addShapeBox(0, 0, 0, 3, 84, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0, 0, -77, 0, 0, -77, 0, 0, 77, 0, 0)
			.setRotationPoint(37, -92, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 227, 28, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, 1, 26).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 363, 0, textureX, textureY).addBox(0, 0, 0, 72, 6, 2)
			.setRotationPoint(-36, 1, -28).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 185, 21, textureX, textureY).addBox(0, 0, 0, 90, 4, 2)
			.setRotationPoint(-45, -2, -34).setRotationAngle(0, 0, 0)
		);
		steel.add(new ModelRendererTurbo(steel, 0, 21, textureX, textureY).addBox(0, 0, 0, 90, 4, 2)
			.setRotationPoint(-45, -2, 32).setRotationAngle(0, 0, 0)
		);
		this.groups.add(steel);
	}

}
