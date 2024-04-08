package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.GENERIC_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.INPUT_2B_SEG;

import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstContentData extends ConstGui {

	public ConstContentData(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		root = UIKey.CONSTRUCTOR.id;
		help_url += "#contentinfo";
	}
	
	@Override
	public void init(){
		super.init();
		setMenuTitle("gui.fvtm.constructor.content_data.menu_title");
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		if(container.hasVehicle()){
			addTopButton(ConstGuiElement.SAVE);
			addElement(GENERIC_SEG, "veh_name", "gui.fvtm.constructor.content_data.name", null);
			addElement(INPUT_2B_SEG, "name_input", null, (button, mb) -> {
				if(button.name.endsWith("_0")){
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "veh_name_change");
					compound.setBoolean("reset", true);
					titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
					container.send(Side.SERVER, compound);
				}
				else{
					String value = fields.get("name_input").getText();
					if(value.length() < 1){
						titletext.update("gui.fvtm.constructor.invalid_input", RGB_ORANGE.packed);
						return;
					}
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "veh_name_change");
					compound.setString("value", value);
					titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
					container.send(Side.SERVER, compound);
				}
			}, ConstGuiElement.CANCEL_ICON.asarray(ConstGuiElement.CONFIRM_ICON), new String[]{ "gui.fvtm.constructor.button.reset", "gui.fvtm.constructor.button.confirm"});
			addElement(EMPTY_SEG, "spacer0", null, null);
		}
		if(container.hasVehicle()){
			addElement(GENERIC_SEG, "attributes", "gui.fvtm.constructor.content_data.attributes", (button, mb) -> notAvailableYet());
			addElement(GENERIC_SEG, "functions", "gui.fvtm.constructor.content_data.functions", (button, mb) -> notAvailableYet());
		}
		addElement(GENERIC_SEG, "scripts", "gui.fvtm.constructor.content_data.scripts", (button, mb) -> notAvailableYet());
		if(container.hasVehicle()) fields.get("name_input").setText(container.entity.getVehicleData().getName());
		finish_init();
	}

}
