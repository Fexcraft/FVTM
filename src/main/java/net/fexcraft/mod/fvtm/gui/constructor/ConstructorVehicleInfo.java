package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.fexcraft.lib.common.math.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorVehicleInfo extends ConstructorGui {

	public ConstructorVehicleInfo(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Name:", "", "Attributes", "Functions", "Scripts", "", "< Back" };
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Vehicle Data Overview";
		this.container.setTitleText(container.getTileEntity().getVehicleData() == null ? "No Vehicle in Constructor." : container.getTileEntity().getVehicleData().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		String string = container.getTileEntity() == null ? "Const. Offline" : container.getTileEntity().getVehicleData() == null ?
			"No Vehicle" : container.getTileEntity().getVehicleData().getName();
		this.cfields[1].setText(string);
		this.fields.put("field2", cfields[1]);
		this.buttons.put("name_apply", new IconButton("name_apply", 0, 0, false, ICON_RIGHT));
		this.buttons.put("name_reset", new IconButton("name_reset", 0, 1, false, ICON_REMOVE));
	}
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button6")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		else if(button.name.equals("button2")){
			
		}
		else if(button.name.equals("button3")){
			
		}
		else if(button.name.equals("button4")){
			
		}
		else if(button.name.endsWith("name_apply")){
			String value = cfields[1].getText();
			if(value.length() < 1){
				this.titletext.update("Invalid input / too short.", RGB_ORANGE.packed);
				return true;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "veh_name_change");
			compound.setString("value", value);
			this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.endsWith("name_reset")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "veh_name_change");
			compound.setBoolean("reset", true);
			this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
			return true;
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
