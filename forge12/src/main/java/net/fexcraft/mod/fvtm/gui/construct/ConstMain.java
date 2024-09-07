package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_CONTENTINFO;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PAINTER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTINFO;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTINSTALLER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_STATUS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_TEXTUREMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.GENERIC_SEG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstMain extends ConstGui {

	public ConstMain(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
	}
	
	@Override
	public void init(){
		super.init();
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.SAVE);
		addTopButton(ConstGuiElement.SPAWN);
		addElement(GENERIC_SEG, "status", "gui.fvtm.constructor.main.status", (button, mb) -> openGui(CONSTRUCTOR_STATUS, tilepos, LISTENERID));
		if(container.noContainer() && !container.isEmpty()){
			addElement(GENERIC_SEG, "info", "gui.fvtm.constructor.main.data", (button, mb) -> openGui(CONSTRUCTOR_CONTENTINFO, tilepos, LISTENERID));
		}
		if(container.hasVehicle()){
			addElement(EMPTY_SEG, "spacer0", null, null);
			addElement(GENERIC_SEG, "part_cache", "gui.fvtm.constructor.main.part_cache", (button, mb) -> openGui(CONSTRUCTOR_PARTINFO, tilepos, LISTENERID));
			addElement(GENERIC_SEG, "part_manager", "gui.fvtm.constructor.main.part_manager", (button, mb) -> openGui(CONSTRUCTOR_PARTMANAGER, tilepos, LISTENERID));
			addElement(GENERIC_SEG, "part_install", "gui.fvtm.constructor.main.part_installer", (button, mb) -> openGui(CONSTRUCTOR_PARTINSTALLER, tilepos, LISTENERID));
		}
		if(!container.isEmpty()){
			addElement(EMPTY_SEG, "spacer1", null, null);
			addElement(GENERIC_SEG, "texture", "gui.fvtm.constructor.main.texture", (button, mb) -> openGui(CONSTRUCTOR_TEXTUREMANAGER, tilepos, LISTENERID));
			addElement(GENERIC_SEG, "color", "gui.fvtm.constructor.main.color", (button, mb) -> openGui(CONSTRUCTOR_PAINTER, tilepos, LISTENERID));
		}
		addElement(EMPTY_SEG, "spacer2", null, null);
		addElement(GENERIC_SEG, "exit", "gui.fvtm.constructor.main.exit", (button, mb) -> player.closeScreen());
		finish_init();
	}

}
