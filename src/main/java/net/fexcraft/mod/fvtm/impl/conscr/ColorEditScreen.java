package net.fexcraft.mod.fvtm.impl.conscr;

import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.ConstructorEntity;
import net.fexcraft.mod.fvtm.api.ConstructorScreen;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import static net.fexcraft.mod.fvtm.api.ConstructorButton.ARROW_UP;

public class ColorEditScreen extends ConstructorScreen {

	@Override
	public void onButtonPress(ConstructorEntity tileentity, ConstructorButton button, EntityPlayer player, String[] args) {
		String str = tileentity.getScreenId().split("_")[2];
		RGB rgb = str.equals("primary") ? tileentity.getVehicleData().getPrimaryColor() :tileentity.getVehicleData().getSecondaryColor();
		if(button.isReturn()){
			tileentity.updateScreenId("colour_menu");
		}
		if(button.isReset()){
			switch(tileentity.getSelection()){
				case 1:{
					tileentity.setBrush(1);
					break;
				}
				case 2: case 3: {
					rgb.red   = 127;
					break;
				}
				case 4: case 5: {
					rgb.green = 127;
					break;
				}
				case 6: case 7: {
					rgb.blue  = 127;
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
			tileentity.updateColour(str, rgb);
		}
		if(button.isSelect()){
			//guess, nothing to select here?
		}
		if(button.isHorizontalArrow()){
			byte brush = tileentity.getBrush();
			switch(tileentity.getSelection()){
				case 1:{
					tileentity.setBrush(tileentity.getBrush() + (button.isLeftArrow() ? -1 : 1));
					break;
				}
				case 3: case 2:{
					rgb.add(0, button.isLeftArrow() ? -brush : brush);
					break;
				}
				case 5: case 4:{
					rgb.add(1, button.isLeftArrow() ? -brush : brush);
					break;
				}
				case 7: case 6:{
					rgb.add(2, button.isLeftArrow() ? -brush : brush);
					break;
				}
			}
			tileentity.updateScreenId(tileentity.getScreenId(), false);
			tileentity.updateColour(str, rgb);
		}
		if(button.isVerticalArrow()){
			tileentity.updateSelection(button == ARROW_UP ? -1 : 1);
		}
	}

	@Override
	public void getScreenUpdate(ConstructorEntity tileentity, NBTTagCompound compound) {
		String str = tileentity.getScreenId().split("_")[2];
		RGB rgb = str.equals("primary") ? tileentity.getVehicleData().getPrimaryColor() : tileentity.getVehicleData().getSecondaryColor();
		compound.setString("Text0", "Color Editor (" + str + ")");
		compound.setString("Text1", "&3Brush: &7" + tileentity.getBrush());
		compound.setString("Text2", "&cRed:   &7{" + (rgb.red   + 128) + "}i [" + rgb.red   + "]b");
		compound.setString("Text3", getColorBar(rgb.red,   "c"));
		compound.setString("Text4", "&aGreen: &7{" + (rgb.green + 128) + "}i [" + rgb.green + "]b");
		compound.setString("Text5", getColorBar(rgb.green, "a"));
		compound.setString("Text6", "&bBlue:  &7{" + (rgb.blue  + 128) + "}i [" + rgb.blue  + "]b");
		compound.setString("Text7", getColorBar(rgb.blue,  "b"));
	}
}
