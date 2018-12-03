//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.fvp.models.part.ot1;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/** This file was exported via the FVTM Exporter V1 of<br>
 *  FMT (Fex's Modelling Toolbox) v.1.0.4-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "fvp:models/part/ot1_ltu")
public class OT1_LTU extends PartModel {

	public OT1_LTU(){
		super(); textureX = 512; textureY = 512;
		this.addToCreators("Ferdinand (FEX___96)");
		//
		TurboList cargo = new TurboList("cargo");
		cargo.add(new ModelRendererTurbo(cargo, 1, 305, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81, -20, -21).setRotationAngle(0, 0, 0).setName("Box 41")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 321, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81, -20, 15).setRotationAngle(0, 0, 0).setName("Box 42")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 337, textureX, textureY).addBox(0.5f, 0.2f, -0.5f, 97, 6, 6)
			.setRotationPoint(-81, -20, -14).setRotationAngle(-0.034906585f, 0, 0).setName("Box 43")
		);
		cargo.add(new ModelRendererTurbo(cargo, 209, 337, textureX, textureY).addBox(0.5f, 0, -0.5f, 97, 6, 6)
			.setRotationPoint(-81, -20, 9).setRotationAngle(-0.06981317f, 0, 0).setName("Box 44")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 353, textureX, textureY).addBox(0, 0.2f, 0, 97, 6, 6)
			.setRotationPoint(-81, -20, 1).setRotationAngle(0.05235988f, 0, 0).setName("Box 45")
		);
		cargo.add(new ModelRendererTurbo(cargo, 209, 353, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81, -20, -6.5f).setRotationAngle(0, 0, 0).setName("Box 46")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 369, textureX, textureY).addBox(0, 0.2f, 0, 96, 6, 6)
			.setRotationPoint(-79, -26, -9.5f).setRotationAngle(0, 0, 0).setName("Box 47")
		);
		cargo.add(new ModelRendererTurbo(cargo, 209, 369, textureX, textureY).addBox(0.5f, 0, -0.5f, 96, 6, 6)
			.setRotationPoint(-79, -26, -16).setRotationAngle(-0.06981317f, 0, 0).setName("Box 48")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 385, textureX, textureY).addBox(0, 0.2f, 0, 97, 6, 6)
			.setRotationPoint(-80, -30, -21).setRotationAngle(0.55850536f, 0, 0).setName("Box 49")
		);
		cargo.add(new ModelRendererTurbo(cargo, 209, 385, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81.5f, -26, -3).setRotationAngle(0.05235988f, 0, 0).setName("Box 50")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 401, textureX, textureY).addBox(0, 0.2f, 0, 95, 6, 6)
			.setRotationPoint(-78, -26, 4.5f).setRotationAngle(0, 0, 0).setName("Box 51")
		);
		cargo.add(new ModelRendererTurbo(cargo, 209, 401, textureX, textureY).addBox(0.5f, 0, -0.5f, 97, 6, 6)
			.setRotationPoint(-80, -26, 13).setRotationAngle(-0.06981317f, 0, 0).setName("Box 52")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 417, textureX, textureY).addBox(0.5f, 0, -0.5f, 98, 6, 6)
			.setRotationPoint(-81, -32, 16).setRotationAngle(-0.2268928f, 0, 0).setName("Box 53")
		);
		cargo.add(new ModelRendererTurbo(cargo, 217, 417, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-80, -32, 7.5f).setRotationAngle(0, 0, 0).setName("Box 54")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 433, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81, -32, -12.5f).setRotationAngle(0, 0, 0).setName("Box 55")
		);
		cargo.add(new ModelRendererTurbo(cargo, 217, 433, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-80.5f, -32, -5.5f).setRotationAngle(0, 0, 0).setName("Box 56")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 449, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-80.5f, -32, 0).setRotationAngle(0.89011794f, 0, 0).setName("Box 57")
		);
		cargo.add(new ModelRendererTurbo(cargo, 217, 449, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81, -38, 15).setRotationAngle(-0.05235988f, 0, 0).setName("Box 58")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 465, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-80.4f, -38, 8.5f).setRotationAngle(0, 0, 0).setName("Box 59")
		);
		cargo.add(new ModelRendererTurbo(cargo, 217, 465, textureX, textureY).addBox(0, 0, 0, 99, 6, 6)
			.setRotationPoint(-81.5f, -39, -21).setRotationAngle(-0.034906585f, 0, 0).setName("Box 60")
		);
		cargo.add(new ModelRendererTurbo(cargo, 1, 481, textureX, textureY).addBox(0.5f, 0, -0.5f, 98, 6, 6)
			.setRotationPoint(-80, -39, -13.5f).setRotationAngle(-0.2268928f, 0, 0).setName("Box 61")
		);
		cargo.add(new ModelRendererTurbo(cargo, 217, 481, textureX, textureY).addBox(0, 0.2f, 0, 98, 6, 6)
			.setRotationPoint(-81.5f, -38, -8).setRotationAngle(-0.017453292f, 0, 0).setName("Box 62")
		);
		cargo.addProgram(new TurboList.Program(){
			@Override
			public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
		        NonNullList<ItemStack> stacks = data.getPart(part).getAttributeData(InventoryAttributeData.class).getInventory();
		        int j = 0;
		        for(int i = 0; i < get("cargo").size(); i++){
		            if(i < stacks.size() && !stacks.get(i).isEmpty()){
		                j++; continue; //cargo[i].render();
		            }
		            if(i >= stacks.size()) break;
		        }
		        for(int i = 0; i < j; i++) list.get(i).render();
		        list.visible = false;
			}
			@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ list.visible = true; }
			@Override public String getId(){ return "fvp:ot1_ltu"; }
		});
		this.groups.add(cargo);
		TurboList chassis = new TurboList("chassis");
		chassis.add(new ModelRendererTurbo(chassis, 1, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 96, 2, 1, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-77, -14, 21).setRotationAngle(0, 0, 0).setName("Box 0")
		);
		chassis.add(new ModelRendererTurbo(chassis, 201, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 96, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.1f, 0, 0, 0.1f, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-77, -14, -22).setRotationAngle(0, 0, 0).setName("Box 1")
		);
		chassis.add(new ModelRendererTurbo(chassis, 201, 161, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-77, -15, 21).setRotationAngle(0, 0, 0).setName("Box 2")
		);
		chassis.add(new ModelRendererTurbo(chassis, 433, 177, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-77, -15, -23).setRotationAngle(0, 0, 0).setName("Box 3")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 193, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -15, -23).setRotationAngle(0, 0, 0).setName("Box 4")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 193, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(18, -15, 21).setRotationAngle(0, 0, 0).setName("Box 5")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 193, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-46, -15, 21).setRotationAngle(0, 0, 0).setName("Box 6")
		);
		chassis.add(new ModelRendererTurbo(chassis, 33, 201, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0)
			.setRotationPoint(-14, -15, 21).setRotationAngle(0, 0, 0).setName("Box 7")
		);
		chassis.add(new ModelRendererTurbo(chassis, 377, 201, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-14, -15, -23).setRotationAngle(0, 0, 0).setName("Box 8")
		);
		chassis.add(new ModelRendererTurbo(chassis, 393, 201, textureX, textureY)
			.addShapeBox(-0.5f, 0, 0, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(-46, -15, -23).setRotationAngle(0, 0, 0).setName("Box 9")
		);
		chassis.add(new ModelRendererTurbo(chassis, 25, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-77.5f, -37, 21).setRotationAngle(0, 0, 0).setName("Box 10")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-77.5f, -43, 21).setRotationAngle(0, 0, 0).setName("Box 11")
		);
		chassis.add(new ModelRendererTurbo(chassis, 449, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-46.5f, -37, 21).setRotationAngle(0, 0, 0).setName("Box 12")
		);
		chassis.add(new ModelRendererTurbo(chassis, 465, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-14.5f, -37, 21).setRotationAngle(0, 0, 0).setName("Box 13")
		);
		chassis.add(new ModelRendererTurbo(chassis, 481, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(17.5f, -37, 21).setRotationAngle(0, 0, 0).setName("Box 14")
		);
		chassis.add(new ModelRendererTurbo(chassis, 497, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-77.5f, -37, -23).setRotationAngle(0, 0, 0).setName("Box 15")
		);
		chassis.add(new ModelRendererTurbo(chassis, 417, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-46.5f, -37, -23).setRotationAngle(0, 0, 0).setName("Box 16")
		);
		chassis.add(new ModelRendererTurbo(chassis, 433, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-14.5f, -37, -23).setRotationAngle(0, 0, 0).setName("Box 17")
		);
		chassis.add(new ModelRendererTurbo(chassis, 401, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 22, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(17.5f, -37, -23).setRotationAngle(0, 0, 0).setName("Box 18")
		);
		chassis.add(new ModelRendererTurbo(chassis, 497, 201, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-46.5f, -43, 21).setRotationAngle(0, 0, 0).setName("Box 19")
		);
		chassis.add(new ModelRendererTurbo(chassis, 241, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-14.5f, -43, 21).setRotationAngle(0, 0, 0).setName("Box 20")
		);
		chassis.add(new ModelRendererTurbo(chassis, 257, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(17.5f, -43, 21).setRotationAngle(0, 0, 0).setName("Box 21")
		);
		chassis.add(new ModelRendererTurbo(chassis, 489, 209, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-77.5f, -43, -23).setRotationAngle(0, 0, 0).setName("Box 22")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 217, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-46.5f, -43, -23).setRotationAngle(0, 0, 0).setName("Box 23")
		);
		chassis.add(new ModelRendererTurbo(chassis, 9, 225, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(-14.5f, -43, -23).setRotationAngle(0, 0, 0).setName("Box 24")
		);
		chassis.add(new ModelRendererTurbo(chassis, 457, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 6, 2, 0, -0.3f, 0, -1.2f, -0.3f, 0, -1.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f, -0.2f, 0, -0.2f)
			.setRotationPoint(17.5f, -43, -23).setRotationAngle(0, 0, 0).setName("Box 25")
		);
		chassis.add(new ModelRendererTurbo(chassis, 385, 233, textureX, textureY)
			.addShapeBox(0, 0, 0, 2, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(17.5f, -43, -21).setRotationAngle(0, 0, 0).setName("Box 26")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -39, -21).setRotationAngle(0, 0, 0).setName("Box 28")
		);
		chassis.add(new ModelRendererTurbo(chassis, 89, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -35, -21).setRotationAngle(0, 0, 0).setName("Box 29")
		);
		chassis.add(new ModelRendererTurbo(chassis, 177, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -31, -21).setRotationAngle(0, 0, 0).setName("Box 30")
		);
		chassis.add(new ModelRendererTurbo(chassis, 265, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -27, -21).setRotationAngle(0, 0, 0).setName("Box 31")
		);
		chassis.add(new ModelRendererTurbo(chassis, 313, 265, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -23, -21).setRotationAngle(0, 0, 0).setName("Box 32")
		);
		chassis.add(new ModelRendererTurbo(chassis, 361, 281, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -19, -21).setRotationAngle(0, 0, 0).setName("Box 33")
		);
		chassis.add(new ModelRendererTurbo(chassis, 409, 289, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 2, 42, 0, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, 0, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f, -0.2f, -0.2f, 0.2f)
			.setRotationPoint(18, -15, -21).setRotationAngle(0, 0, 0).setName("Box 34")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 89, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 29, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -42, -17).setRotationAngle(0, 0, 0).setName("Box 35")
		);
		chassis.add(new ModelRendererTurbo(chassis, 489, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 29, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -42, 14).setRotationAngle(0, 0, 0).setName("Box 36")
		);
		chassis.add(new ModelRendererTurbo(chassis, 505, 249, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 29, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -42, -6).setRotationAngle(0, 0, 0).setName("Box 37")
		);
		chassis.add(new ModelRendererTurbo(chassis, 1, 257, textureX, textureY)
			.addShapeBox(0, 0, 0, 1, 29, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
			.setRotationPoint(18, -42, 4).setRotationAngle(0, 0, 0).setName("Box 38")
		);
		chassis.add(new ModelRendererTurbo(chassis, 49, 257, textureX, textureY).addBox(0, 0, 0, 1, 6, 26)
			.setRotationPoint(19.5f, -32, -13).setRotationAngle(0, 0, 0).setName("Box 39")
		);
		this.groups.add(chassis);
	}

}