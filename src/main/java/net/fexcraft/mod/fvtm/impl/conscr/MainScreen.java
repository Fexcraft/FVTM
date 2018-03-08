package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class MainScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity te, ConstructorButton button, EntityPlayer player, String[] args){
		if(te.getVehicleData() == null){
			return;
		}
		if(button.isVerticalArrow()){
			te.updateSelection(button == ConstructorButton.ARROW_UP ? -1 : 1);
		}
		else if(button.isSelect()){
			switch(te.getSelection()){
				case 0:{
					te.updateScreenId("info");
					break;
				}
				case 1:{
					te.updateScreenId("vehicle_menu");
					break;
				}
				case 2:{
					te.updateScreenId("colour_menu");
					break;
				}
				case 3:{
					te.updateScreenId("part_menu");
					break;
				}
				case 4:{
					player.openGui(FVTM.getInstance(), GuiHandler.CONSTRUCTOR, te.getWorld(), te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
					Print.chat(player, "Opening Constructor GUI...");
					break;
				}
				case 5:{
					te.updateScreenId("constructor_menu");
					break;
				}
				case 6:{
					te.recycleVehicle();
					break;
				}
				case 7:{
					te.updateScreenId("crash");
					break;
				}
				case -1:
				default:
					return;
			}
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity te, NBTTagCompound compound){
		if(te.getVehicleData() == null){
			compound.setString("Text0", "No Vehicle.");
			compound.setString("Text1", "_");
			super.fill(te, 2, compound);
			te.setSelection(-1);
		}
		else{
			compound.setString("Text0", ">> Welcome!");
			compound.setString("Text1", "Vehicle Settings");
			compound.setString("Text2", "Colour Settings");
			compound.setString("Text3", "Part Settings");
			compound.setString("Text4", Formatter.PARAGRAPH_SIGN + "o" + Formatter.PARAGRAPH_SIGN + "lOpen GUI...");
			//compound.setString("Text4", "- - - - - - - - - -");
			compound.setString("Text5", "Constructor Settings");
			compound.setString("Text6", "Recycle Vehicle");
			compound.setString("Text7", "Crash Game");
		}
	}
	
}