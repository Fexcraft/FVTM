package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleOverlay {

	private static RS[] lines = new RS[12];
	private static boolean offinit = false;
	static{
		for(int i = 0; i < lines.length; i++){
			lines[i] = new RS();
			lines[i].y = (i % 6) * 10 + 10;
			if(i < 6){
				lines[i].x = 10;
				lines[i].trs = true;
			}
		}
	}

	public static RS[] update(VehicleInstance vi){
		lines[0].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.fuel");
		lines[1].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.throttle");
		lines[2].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.brake");
		lines[3].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.speed");
		lines[4].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.engine");
		lines[5].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay.pbrake");
		//
		lines[6].str = tobar(vi.data.getStoredFuel(), vi.data.getFuelCapacity(), '7') + vi.data.getStoredFuel();
		lines[7].str = tobar(Math.abs(vi.throttle), 1, 'b') + RGB.df.format(vi.throttle);
		lines[8].str = tobar(vi.brake, 1, 'c') + RGB.df.format(vi.brake);
		lines[9].str = RGB.df.format(vi.speed * 72);
		lines[10].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay." + (vi.engine != null && vi.engine.isOn() ? "on" : "off"));
		lines[11].str = ContainerInterface.translate("ui.fvtm.vehicle_overlay." + (vi.pbrake ? "on" : "off"));
		//
		if(!offinit){
			int off = Integer.parseInt(ContainerInterface.translate("ui.fvtm.vehicle_overlay.offset"));
			for(int i = 6; i < lines.length; i++) lines[i].x = off;
			offinit = true;
		}
		return lines;
	}

	public static class RS {

		public int x, y;
		public String str;
		public boolean trs;

	}

	public static String tobar(double val, int max, char code){
		double div = val / max * 10;
		int rou = (int)div;
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 10; i++){
			if(rou > i){
				str.append("\u00a7" + code + "\u2588");
			}
			else{
				str.append("\u00a7f\u2588");
			}
		}
		str.append(" \u00a7r");
		return str.toString();
	}

}
