package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.BLANK_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.GENERIC_SEG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ConstPartCache extends ConstGui {

	public ConstPartCache(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		help_url += "#partcache";
		droptype = "part";
	}
	
	@Override
	public void init(){
		super.init();
		setMenuTitle("gui.fvtm.constructor.part_cache.menu_title");
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addTopButton(ConstGuiElement.SAVE);
		addElement(GENERIC_SEG, "name", "gui.fvtm.constructor.part_cache.name", null);
		addElement(BLANK_SEG, "partname", container.hasPart() ? container.entity.getPartData().getType().getName() : null, null);
		addElement(EMPTY_SEG, "spacer0", null, null);
		addElement(GENERIC_SEG, "attributes", "gui.fvtm.constructor.part_cache.attributes", NOT_AVAILABLE_YET);
		addElement(GENERIC_SEG, "functions", "gui.fvtm.constructor.part_cache.functions", NOT_AVAILABLE_YET);
		addElement(GENERIC_SEG, "textures", "gui.fvtm.constructor.part_cache.textures", NOT_AVAILABLE_YET);
		addElement(GENERIC_SEG, "install_info", "gui.fvtm.constructor.part_cache.install_info", NOT_AVAILABLE_YET);
		finish_init();
	}

}
