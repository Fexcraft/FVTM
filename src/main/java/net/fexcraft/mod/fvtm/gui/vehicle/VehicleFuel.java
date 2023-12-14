package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleFuel extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_fuel.png");
	private RootVehicle vehent;

	public VehicleFuel(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 176; this.ySize = 154;
		vehent = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
	}

	@Override
	protected void init(){
		String accepted = I18n.format("gui.fvtm.vehicle.fuel.accepts") + " ";
		for(int i = 0; i < vehent.vehicle.data.getFuelGroup().length; i++)
			accepted += vehent.vehicle.data.getFuelGroup()[i] + (i == vehent.vehicle.data.getFuelGroup().length - 1 ? "" : ",");
		texts.put("row0", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, accepted));
		texts.put("row1", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "fuel-tank-name"));
		texts.put("row2", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "fuel-tank-data"));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("row1").string = vehent.vehicle.data.getAttribute("fuel_primary").asString() + " - " + vehent.vehicle.data.getAttribute("fuel_secondary").asString() + " - "
			+ (vehent.vehicle.data.getAttribute("fuel_quality").asFloat() * 100) + "%";
		texts.get("row2").string = vehent.vehicle.data.getAttribute("fuel_stored").initial() + "/" + vehent.vehicle.data.getAttribute("fuel_capacity").asInteger() + "mB";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		float percent = vehent.vehicle.data.getAttribute("fuel_stored").asFloat() / vehent.vehicle.data.getAttribute("fuel_capacity").asFloat() * 100f;
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

