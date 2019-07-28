package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleFuel extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_fuel.png");
	private VehicleEntity veh;

	public VehicleFuel(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 176; this.ySize = 154;
		if(player.isRiding() && player.getRidingEntity() instanceof SeatEntity){
			SeatEntity ent = (SeatEntity)player.getRidingEntity(); veh = ent.getVehicle();
			if(!ent.seatdata.driver){ player.closeScreen(); }
		}
		else{
			veh = (VehicleEntity)world.getEntityByID(y);
			if(veh == null){
				Print.chat(player, "VEHICLE NOT FOUND BY ID[" + y + "], OPERATION CANCELLING");
				player.closeScreen(); return;
			}
		}
	}

	@Override
	protected void init(){
		String accepted = "Accepts: ";
		for(int i = 0; i < veh.getVehicleData().getFuelGroup().length; i++)
			accepted += veh.getVehicleData().getFuelGroup()[i] + (i == veh.getVehicleData().getFuelGroup().length - 1 ? "" : ",");
		texts.put("row0", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, accepted));
		texts.put("row1", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "fuel-tank-name"));
		texts.put("row2", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "fuel-tank-data"));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("row1").string = veh.getVehicleData().getAttribute("fuel_primary").getStringValue() + " - " + veh.getVehicleData().getAttribute("fuel_secondary").getStringValue() + " - "
			+ (veh.getVehicleData().getAttribute("fuel_quality").getFloatValue() * 100) + "%";
		texts.get("row2").string = veh.getVehicleData().getAttribute("fuel_stored").getIntegerValue() + "/" + veh.getVehicleData().getAttribute("fuel_capacity").getIntegerValue() + "mB";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		float percent = veh.getVehicleData().getAttribute("fuel_stored").getFloatValue() / veh.getVehicleData().getAttribute("fuel_capacity").getFloatValue() * 100f;
		if(percent > 0) drawTexturedModalRect(guiLeft + 10, guiTop + 49, 0, 238, (int)percent, 18);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

