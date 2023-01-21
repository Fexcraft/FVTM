package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class VehicleAndPartInfo extends GenericGui<VehicleAndPartInfoContainer>{
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_part_info.png");
	private static boolean vehmode;

	public VehicleAndPartInfo(EntityPlayer player){
		super(texture, new VehicleAndPartInfoContainer(player), player);
		xSize = 248;
		ySize = 215;
	}
	
	@Override
	public void init(){
		texts.put("title", new BasicText(guiLeft + 35, guiTop + 9, 204, 0xcdcdcd, "gui.fvtm.vpinfo.title_" + (vehmode ? "veh" : "part")).translate().autoscale());
		texts.put("pack", new BasicText(guiLeft + 9, guiTop + 23, 204, null, "...").translate().autoscale());
		texts.put("selected", new BasicText(guiLeft + 29, guiTop + 38, 186, null, "...").translate().autoscale());
		texts.put("mode", new BasicText(guiLeft + 9, guiTop + 61, 204, null, "...").translate().autoscale());
		for(int i = 0; i < 9; i++){
			texts.put("line" + i, new BasicText(guiLeft + 9, guiTop + 75 + (i * 14), 204, null, "...").translate().autoscale());
		}
		texts.put("scroll", new BasicText(guiLeft + 151, guiTop + 200, 68, null, "0/0").translate().autoscale());
		buttons.put("vehmode", new BasicButton("vehmode", guiLeft + 7, guiTop + 7, 7, 7, 12, 12, true));
		buttons.put("partmode", new BasicButton("partmode", guiLeft + 20, guiTop + 7, 7, 20, 12, 12, true));
		buttons.put("pack_prev", new BasicButton("p_p", guiLeft + 216, guiTop + 21, 216, 21, 12, 12, true));
		buttons.put("pack_next", new BasicButton("p_n", guiLeft + 229, guiTop + 21, 229, 21, 12, 12, true));
		buttons.put("sel_prev", new BasicButton("s_p", guiLeft + 216, guiTop + 41, 216, 41, 12, 12, true));
		buttons.put("sel_next", new BasicButton("s_n", guiLeft + 229, guiTop + 41, 229, 41, 12, 12, true));
		buttons.put("mode_prev", new BasicButton("m_p", guiLeft + 216, guiTop + 59, 216, 59, 12, 12, true));
		buttons.put("mode_next", new BasicButton("m_n", guiLeft + 229, guiTop + 59, 229, 59, 12, 12, true));
		for(int i = 0; i < 9; i++){
			buttons.put("entry" + i, new BasicButton("e" + i, guiLeft + 229, guiTop + 73 + (i * 14), 229, 216, 12, 12, true));
		}
		buttons.put("scroll_up", new BasicButton("s_u", guiLeft + 222, guiTop + 199, 222, 199, 9, 9, true));
		buttons.put("scroll_dw", new BasicButton("s_d", guiLeft + 232, guiTop + 199, 232, 199, 9, 9, true));
	}

}
