//FMT-Marker FVTM-1
package net.fexcraft.mod.addons.zmp.models.part.flatbedwagon;

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
 *  FMT (Fex's Modelling Toolbox) v.1.0.5-test &copy; 2018 - Fexcraft.net<br>
 *  All rights reserved. For this Model's License contact the Author/Creator.
 */
@fModel(registryname = "zmp:models/part/flatbedwagon_logtransport2")
public class FlatbedWagonLogTransport2 extends PartModel {

	public FlatbedWagonLogTransport2(){
		super(); textureX = 1024; textureY = 256;
		this.addToCreators("zackyboy19");
		//
		TurboList logs = new TurboList("logs");
		logs.add(new ModelRendererTurbo(logs, 137, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 18, 1, 1, 4)
			.setRotationPoint(110, -34, 19).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 485, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -34, 10).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 326, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -34, 0).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 468, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 219, 15, 1, 1, 4)
			.setRotationPoint(110, -34, -10).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 305, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -34, -19).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 112, 0, textureX, textureY).addCylinder(0, 0, 0, 6, 219, 18, 1, 1, 4)
			.setRotationPoint(110, -43, -12).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 284, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 18, 1, 1, 4)
			.setRotationPoint(110, -44, -1).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 672, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -38, -6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 567, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -39, 6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 263, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 219, 18, 1, 1, 4)
			.setRotationPoint(110, -42, 13).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 554, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 221, 15, 1, 1, 4)
			.setRotationPoint(110, -42, -20.5f).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 33, 0, textureX, textureY).addCylinder(0, 0, 0, 7, 221, 20, 1, 1, 4)
			.setRotationPoint(110, -52, 8).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 663, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -43, 6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 87, 0, textureX, textureY).addCylinder(0, 0, 0, 6, 220, 18, 1, 1, 4)
			.setRotationPoint(110, -53, -6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 451, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -49, -19).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 541, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -54, -14.5f).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 528, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -41, 21).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 434, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -47, 18).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 654, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -52, 17).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 417, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 216, 15, 1, 1, 4)
			.setRotationPoint(108, -60, 1).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 400, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -58, 17).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 645, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -55, -19).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 0, 0, textureX, textureY).addCylinder(0, 0, 0, 8, 219, 18, 1, 1, 4)
			.setRotationPoint(110, -64, -14).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 636, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -61, -5).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 515, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -65, -3.5f).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 242, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 219, 18, 1, 1, 4)
			.setRotationPoint(110, -63, 9).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 347, 0, textureX, textureY).addCylinder(0, 0, 0, 4.5f, 218, 15, 1, 1, 4)
			.setRotationPoint(107, -66, 17).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 221, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 18, 1, 1, 4)
			.setRotationPoint(110, -70, 2).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 383, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 216, 15, 1, 1, 4)
			.setRotationPoint(108, -72, -6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 62, 0, textureX, textureY).addCylinder(0, 0, 0, 6, 220, 18, 1, 1, 4)
			.setRotationPoint(112, -73, 12).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 366, 0, textureX, textureY).addCylinder(0, 0, 0, 4, 216, 15, 1, 1, 4)
			.setRotationPoint(108, -76, -12).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 627, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -77, -18).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 502, 0, textureX, textureY).addCylinder(0, 0, 0, 3, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -81, -16.5f).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 580, 0, textureX, textureY).addCylinder(0, 0, 0, 2.5f, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -73, -19).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 200, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 18, 1, 1, 4)
			.setRotationPoint(112, -79, 3).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 179, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 220, 18, 1, 1, 4)
			.setRotationPoint(110, -83, -6).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 618, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(110, -77, -3).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 158, 0, textureX, textureY).addCylinder(0, 0, 0, 5, 219, 18, 1, 1, 4)
			.setRotationPoint(110, -84, 12).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 600, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(111, -82, -13).setRotationAngle(0, 0, 90)
		);
		logs.add(new ModelRendererTurbo(logs, 591, 0, textureX, textureY).addCylinder(0, 0, 0, 2, 220, 15, 1, 1, 4)
			.setRotationPoint(109, -79, 17).setRotationAngle(0, 0, 90)
		);
		logs.addProgram(new TurboList.Program(){
			@Override public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
		        NonNullList<ItemStack> stacks = data.getPart(part).getAttributeData(InventoryAttributeData.class).getInventory();
		        int j = 0;
		        for(int i = 0; i < list.size(); i++){
		            if(i < stacks.size() && !stacks.get(i).isEmpty()){
		                j++; continue; //cargo[i].render();
		            }
		            if(i >= stacks.size()) break;
		        }
		        for(int i = 0; i < j; i++) list.get(i).render();
		        list.visible = false;
			}
			@Override public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){ list.visible = true; }
			@Override public String getId(){ return "zmp:flatbed_logtransport"; }
		});
		this.groups.add(logs);
		this.translate(0, 8, 0);
	}

}
