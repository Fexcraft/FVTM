package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstructorPartInstaller extends ConstructorGui {

	public ConstructorPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		String[] strarr = new String[7 + (container.getTileEntity().getPartData() == null ? 0 : container.getTileEntity().getPartData().getType().getCategories().size())];
		strarr[0] = "||Custom Category:"; strarr[1] = ""; strarr[2] = "Install Custom"; strarr[3] = ""; strarr[4] = "< Back"; strarr[5] = ""; strarr[6] = "||Default Category:";
		for(int i = 0; i < strarr.length - 7; i++){
			strarr[i + 7] = "- " + container.getTileEntity().getPartData().getType().getCategories().get(i);
		} this.buttontext = strarr;
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Part Installation (from cache)";
		this.container.setTitleText(container.getTileEntity().getPartData() == null ? "No Part in Constructor Cache." : container.getTileEntity().getPartData().getType().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		this.cfields[1].setText("custom_cat"); this.fields.put("field2", cfields[1]);
		for(int i = 7; i < buttontext.length; i++){
			this.buttons.put("icon" + i, new IconButton("icon" + i, i, 0, false, ICON_EDIT));
		}
		this.buttons.put("icon2", new IconButton("icon2", 2, 0, false, ICON_EDIT));
		this.updateIconsAndButtons();
	}
	
	private void updateIconsAndButtons(){
		for(int i = 7; i < buttontext.length; i++){
			boolean partin = container.getTileEntity().getVehicleData() == null || container.getTileEntity().getVehicleData().getPart(buttontext[i]) != null;
			buttons.get("icon" + i).enabled = partin; ((IconButton)buttons.get("icon" + i)).texture = partin ? ICON_REMOVE : ICON_CHECK;
		}
		boolean bool = container.getTileEntity().getPartData() == null || !container.getTileEntity().getPartData().getType().getInstallationHandler().allowsCustomCategory(container.getTileEntity().getPartData());
		cbuttons[2].enabled = !bool; ((IconButton)buttons.get("icon2")).texture = bool ? ICON_REMOVE : ICON_CHECK;
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("button4")) this.openGui(modid, 900, xyz);
		else if(button.name.equals("button2")){
			
		}
		else{
			int in = Integer.parseInt(button.name.replace("button", "").replace("icon", ""));
			if(in >= 7){
				
			} else return;
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	@Override
	public void onTitleTextUpdate(){
		this.updateIconsAndButtons();
	}

}
