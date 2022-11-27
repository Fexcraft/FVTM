package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class VehicleAndPartInfo extends GenericGui<VehicleAndPartInfoContainer>{
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_part_info.png");

	public VehicleAndPartInfo(EntityPlayer player){
		super(texture, new VehicleAndPartInfoContainer(player), player);
		xSize = 248;
		ySize = 215;
	}

}
