package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorPartInstaller extends ConstructorGui {
	
	private String[] categories;

	public ConstructorPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		String[] strarr = null;
		if(container.getTileEntity().getPartData() == null){ strarr = new String[7]; }
		else {
			PartData part = container.getTileEntity().getPartData();
			ArrayList<String> list = Lists.newArrayList(part.getType().getInstallationHandler().getValidCategories(part, container.getTileEntity().getVehicleData()));
			strarr = new String[7 + list.size()];
			categories = new String[list.size()];
			for(int i = 0; i < strarr.length - 7; i++){
				String str = list.get(i);
				if(str.startsWith("s:")){
					String[] stra = str.split(":");
					strarr[i + 7] = stra[1] + ":" + stra[2];
				}
				else strarr[i + 7] = str;
				categories[i] = str;
			}
		}
		strarr[0] = "||gui.fvtm.constructor.part_install.custom"; strarr[1] = ""; strarr[2] = "gui.fvtm.constructor.part_install.custom_install";
		strarr[3] = ""; strarr[4] = "gui.fvtm.constructor.part_install.back"; strarr[5] = ""; strarr[6] = "||gui.fvtm.constructor.part_install.default";
		this.buttontext = strarr;
	}
	
	@Override
	public void init(){
		super.init();
		this.menutitle.string = "gui.fvtm.constructor.part_install.menu_title";
		this.menutitle.translate();
		this.container.setTitleText(container.getTileEntity().getPartData() == null ? "gui.fvtm.constructor.part_install.empty_title" : container.getTileEntity().getPartData().getType().getName(), RGB.WHITE.packed);
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
			tbuttons[6].string = "gui.fvtm.constructor.part_install.empty";
			tbuttons[6].translate();
			for(int i = 7; i < buttontext.length; i++){
				buttons.get("icon" + i).visible = buttons.get("button" + i).visible = tbuttons[i].visible = false;
			}
		}
		else{
			for(int i = 7; i < buttontext.length; i++){
				buttons.get("icon" + i).visible = buttons.get("button" + i).visible = tbuttons[i].visible = true;
				//
				boolean partin = container.getTileEntity().getVehicleData() == null || container.getTileEntity().getVehicleData().getPart(buttontext[i]) != null;
				if(!partin && buttontext[i].startsWith("s:")) partin = container.getTileEntity().getVehicleData().getPart(buttontext[i].split(":")[2]) != null;
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
		if(button.name.equals("button4")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		else if(button.name.equals("button2")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "part_install");
			compound.setString("category", fields.get("field2").getText());
			compound.setBoolean("custom_category", true);
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
		}
		else{
			int in = Integer.parseInt(button.name.replace("button", "").replace("icon", ""));
			if(in >= 7){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "part_install");
				compound.setString("category", categories[in - 7]);
				compound.setBoolean("custom_category", false);
				this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
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
