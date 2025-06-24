package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.pro.LandVehicle;
import net.fexcraft.mod.fvtm.sys.pro.RailVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleConnectors extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_connectors.png");
	private final RootVehicle vehicle;

	public VehicleConnectors(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 181; this.ySize = 40;
		vehicle = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
	}

	@Override
	protected void init(){
		this.texts.put("row0", new BasicText(20,  10, 160, MapColor.SNOW.colorValue, "..."));
		this.texts.put("row1", new BasicText(20,  24, 160, MapColor.SNOW.colorValue, "..."));
		for(int i = 0; i < 2; i++){
			this.buttons.put("row" + i, new BasicButton("row" + i, 7, 7 + (i * 14), 7, 7 + (i * 14), 155, 12, true));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 2; i++){
			texts.get("row" + i).x = guiLeft + 20;
			texts.get("row" + i).y = guiTop + 10 + (i * 14);
			buttons.get("row" + i).x = guiLeft + 7;
			buttons.get("row" + i).y = guiTop + 7 + (i * 14);
			VehicleInstance ent = i == 0 ? vehicle.vehicle.front : vehicle.vehicle.rear;
			texts.get("row" + i).string = ent == null ? "none" : ent.data.getType().getName();
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("row0")){
			tryCouple(true);
			return true;
		}
		if(button.name.equals("row1")){
			tryCouple(false);
			return true;
		}
		//
		return false;
	}

	private void tryCouple(boolean front){
		if(vehicle instanceof LandVehicle){
			LandVehicle land = (LandVehicle)vehicle;
			if(front && land.vehicle.front != null){
				//land.vehicle.front.tryDetach(player);
			}
			if(!front){
        		/*if(land.getVehicleData().getRearConnector() == null){
        			Print.chat(player, I18n.format("gui.fvtm.vehicle.connector.no_rear_connector"));
        		}
        		else{
        			if(land.trailer != null) land.tryDetach(player);
        			else land.tryAttach(player);
        		}*///TODO
			}
		}
		else if(vehicle instanceof RailVehicle){
			/*RailVehicle railveh = (RailVehicle)vehicle;
			railveh.rek.ent().tryCoupling(player, front);*/
			//TODO isn't this client side?
		}
		else {
			Print.chat(player, I18n.format("gui.fvtm.vehicle.connector.not_available_yet"));
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

