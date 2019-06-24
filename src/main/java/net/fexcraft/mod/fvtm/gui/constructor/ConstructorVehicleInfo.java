package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstructorVehicleInfo extends ConstructorGui {

	public ConstructorVehicleInfo(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Name:", "", "Attributes", "Functions", "Scripts", "", "< Back" };
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Vehicle Data Overview";
		this.container.setTitleText(container.getTileEntity().getVehicleData() == null ? "No Vehicle in Constructor." : container.getTileEntity().getVehicleData().getType().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		String string = container.getTileEntity() == null ? "Const. Offline" : container.getTileEntity().getVehicleData() == null ?
			"No Vehicle" : container.getTileEntity().getVehicleData().getType().getName();
		this.cfields[1].setText(string); this.fields.put("field2", cfields[1]);
	}
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button6")) openGui(modid, 900, xyz);
		else if(button.name.equals("button2")){
			
		}
		else if(button.name.equals("button3")){
			
		}
		else if(button.name.equals("button4")){
			
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	@Override
	public void onTitleTextUpdate(){
		//
	}

}
