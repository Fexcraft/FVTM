package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PAINTER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTINFO;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTINSTALLER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_PARTMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_STATUS;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_TEXTUREMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_VEHINFO;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

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
		addElement(ConstGuiElement.GENERIC_SEG, "status", "gui.fvtm.constructor.main.status", () -> openGui(CONSTRUCTOR_STATUS, tilepos, LISTENERID));
		addElement(ConstGuiElement.GENERIC_SEG, "info", "gui.fvtm.constructor.main.info", () -> openGui(CONSTRUCTOR_VEHINFO, tilepos, LISTENERID));
		addElement(ConstGuiElement.EMPTY_SEG, "spacer0", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "part_cache", "gui.fvtm.constructor.main.part_cache", () -> openGui(CONSTRUCTOR_PARTINFO, tilepos, LISTENERID));
		addElement(ConstGuiElement.GENERIC_SEG, "part_manager", "gui.fvtm.constructor.main.part_manager", () -> openGui(CONSTRUCTOR_PARTMANAGER, tilepos, LISTENERID));
		addElement(ConstGuiElement.GENERIC_SEG, "part_install", "gui.fvtm.constructor.main.part_installer", () -> openGui(CONSTRUCTOR_PARTINSTALLER, tilepos, LISTENERID));
		addElement(ConstGuiElement.EMPTY_SEG, "spacer1", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "texture", "gui.fvtm.constructor.main.texture", () -> openGui(CONSTRUCTOR_TEXTUREMANAGER, tilepos, LISTENERID));
		addElement(ConstGuiElement.GENERIC_SEG, "color", "gui.fvtm.constructor.main.color", () -> openGui(CONSTRUCTOR_PAINTER, tilepos, LISTENERID));
		addElement(ConstGuiElement.EMPTY_SEG, "spacer2", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "exit", "gui.fvtm.constructor.main.exit", () -> player.closeScreen());
		finish_init();
	}

}
