package net.fexcraft.mod.fvtm.gui.constructor;

import java.util.ArrayList;
import com.google.common.collect.Lists;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorPartInstaller extends ConstructorGui {

	public ConstructorPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);this.removeEmptyButtons = true; String[] strarr = null;
		if(container.getTileEntity().getPartData() == null){ strarr = new String[7]; }
		else {
			PartData part = container.getTileEntity().getPartData();
			ArrayList<String> list = Lists.newArrayList(part.getType().getInstallationHandler().getValidCategories(part, container.getTileEntity().getVehicleData()));
			strarr = new String[7 + list.size()]; for(int i = 0; i < strarr.length - 7; i++){ strarr[i + 7] = list.get(i); }
		}
		strarr[0] = "||Custom Category:"; strarr[1] = ""; strarr[2] = "Install Custom";
		strarr[3] = ""; strarr[4] = "< Back"; strarr[5] = ""; strarr[6] = "||Default Category:";
		this.buttontext = strarr;
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Part Installation (from cache)";
		this.container.setTitleText(container.getTileEntity().getPartData() == null ? "No Part in Constructor Cache." : container.getTileEntity().getPartData().getType().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		this.cfields[1].setText("custom_cat"); this.fields.put("field2", cfields[1]);
		for(int i = 7; i < buttontext.length; i++){
			this.buttons.put("icon" + i, new IconButton("icon" + i, i, 0, false, ICON_EDIT0));
		}
		this.buttons.put("icon2", new IconButton("icon2", 2, 0, false, ICON_EDIT0));
		//this.updateIconsAndButtons();
	}
	
	private void updateIconsAndButtons(){
		if(container.getTileEntity().getPartData() == null){
			tbuttons[6].string = "cache empty";
			for(int i = 7; i < buttontext.length; i++){
				buttons.get("icon" + i).visible = buttons.get("button" + i).visible = tbuttons[i].visible = false;
			}
		}
		else{
			for(int i = 7; i < buttontext.length; i++){
				buttons.get("icon" + i).visible = buttons.get("button" + i).visible = tbuttons[i].visible = true;
				//
				boolean partin = container.getTileEntity().getVehicleData() == null || container.getTileEntity().getVehicleData().getPart(buttontext[i]) != null;
				buttons.get("icon" + i).enabled = buttons.get("button" + i).enabled = !partin;
				((IconButton)buttons.get("icon" + i)).texture = partin ? ICON_REMOVE : ICON_CHECK;
			}
			boolean bool = container.getTileEntity().getPartData() == null
				|| !container.getTileEntity().getPartData().getType().getInstallationHandler().allowsCustomCategory(container.getTileEntity().getPartData());
			cbuttons[2].enabled = !bool; ((IconButton)buttons.get("icon2")).texture = bool ? ICON_REMOVE : ICON_CHECK;
		}
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		this.updateIconsAndButtons();
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button4")) this.openGui(modid, 900, xyz);
		else if(button.name.equals("button2")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "part_install");
			compound.setString("category", fields.get("field2").getText());
			compound.setBoolean("custom_category", true);
			this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
			this.container.send(Side.SERVER, compound);
		}
		else{
			int in = Integer.parseInt(button.name.replace("button", "").replace("icon", ""));
			if(in >= 7){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "part_install");
				compound.setString("category", tbuttons[in].string);
				compound.setBoolean("custom_category", false);
				this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
				this.container.send(Side.SERVER, compound);
			} else return false;
		}
		return true;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	@Override
	public void onTitleTextUpdate(){
		//this.updateIconsAndButtons();
	}

}
