package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.sys.rail.vis.RailVehicle;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleConnectors extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_connectors.png");
	private final GenericVehicle vehicle;

	public VehicleConnectors(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 181; this.ySize = 40;
		if(player.getRidingEntity() instanceof SeatEntity){
			vehicle = ((SeatEntity)player.getRidingEntity()).getVehicle();
		} else{ vehicle = (GenericVehicle)world.getEntityByID(y); }
	}

	@Override
	protected void init(){
		this.texts.put("row0", new BasicText(20,  10, 160, MapColor.SNOW.colorValue, "Status/Info"));
		this.texts.put("row1", new BasicText(20,  24, 160, MapColor.SNOW.colorValue, "Settings"));
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
			texts.get("row" + i).string = vehicle.getCoupledEntity(i == 0) == null ? "none"
				: vehicle.getCoupledEntity(i == 0).getVehicleData().getType().getName();
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("row0")){ tryCouple(true); return true; }
		if(button.name.equals("row1")){ tryCouple(false); return true; }
		//
		return false;
	}

	private void tryCouple(boolean front){
		if(vehicle instanceof LandVehicle){
			LandVehicle land = (LandVehicle)vehicle;
			if(front && land.truck != null){ land.truck.tryDetach(player); }
			if(!front){
        		if(land.getVehicleData().getRearConnector() == null){
        			Print.chat(player, "This vehicle does not have a rear connector installed.");
        		} else { if(land.trailer != null) land.tryDetach(player); else land.tryAttach(player); }
			}
		}
		else if(vehicle instanceof RailVehicle){
			/*RailVehicle railveh = (RailVehicle)vehicle;
			railveh.rek.ent().tryCoupling(player, front);*/
			//TODO isn't this client side?
		}
		else {
			Print.chat(player, "There is no connector/coupler function for this vehicle type yet.");
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

