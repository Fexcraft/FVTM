package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_TEXTUREMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.BLANK_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.SWITCH_SEG;

import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorGui.IconButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstPartManager extends ConstGui {
	
	private int page;

	public ConstPartManager(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		help_url += "#partmanager";
		droptype = "part";
	}
	
	@Override
	public void init(){
		super.init();
		setMenuTitle("gui.fvtm.constructor.part_manager.menu_title");
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addTopButton(ConstGuiElement.SAVE);
		addElement(BLANK_SEG, "name", "gui.fvtm.constructor.part_manager.installed", null);
		addElement(EMPTY_SEG, "spacer0", null, null);
		for(int i = 0; i < 12; i++){
			int j = i;
			addElement(SWITCH_SEG, "part" + i, "", button -> {
				try{
					if(button.name.endsWith("_0")){
						//NBTTagCompound compound = new NBTTagCompound();
						//compound.setString("category", texts.get("part" + j).string.trim());
						//openGui(920, tilepos, LISTENERID, compound);
						NBTTagCompound compound = new NBTTagCompound();
						if(texts.get("part" + j).string.length() == 0) return;
						compound.setString("category", texts.get("part" + j).string.trim());
						openGui(CONSTRUCTOR_TEXTUREMANAGER, tilepos, LISTENERID, compound);
					}
					else{
						NBTTagCompound compound = new NBTTagCompound();
						compound.setString("cargo", "part_remove");
						if(texts.get("part" + j).string.length() == 0) return;
						compound.setString("category", texts.get("part" + j).string.trim());
						titletext.update(REQUEST_SENT, RGB_CYAN.packed);
						container.send(Side.SERVER, compound);
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			},
			ConstGuiElement.EDITTEX_ICON.asarray(ConstGuiElement.CANCEL_ICON),
			new String[]{ "gui.fvtm.constructor.button.edit_tex", "gui.fvtm.constructor.button.remove" });
		}
		addElement(EMPTY_SEG, "spacer1", null, null);
		addElement(SWITCH_SEG, "page", "gui.fvtm.constructor.page", button -> {
			if(button.name.endsWith("_0")) page--; else page++;
			if(page < 0) page = 0;
			updateButtons();
		}, ConstGuiElement.PREV_ICON.asarray(ConstGuiElement.NEXT_ICON));
		finish_init();
		updateButtons();
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		if(am > 0) page--; else page++;
		if(page < 0) page = 0;
		updateButtons();
	}

	@Override
	public void onClientPacket(NBTTagCompound nbt){
		updateButtons();
	}
	
	private void updateButtons(){
		BasicText text = texts.get("page");
		VehicleData vdata = container.getTileEntity().getVehicleData();
		text.string = I18n.format("gui.fvtm.constructor.page") + " " + (page + 1) + "/" + (vdata.getParts().size() / 10 + 1);
		for(int i = 0; i < 12; i++){
			int j = i + (page * 10);
			texts.get("part" + i).string = j >= vdata.getParts().size() ? "" : (String)vdata.getParts().keySet().toArray()[j];
		}
		buttons.get("page_1").enabled = page < vdata.getParts().size() / 10;
		buttons.get("page_0").enabled = page > 0;
		buttons.entrySet().forEach(entry -> {
			if(entry.getKey().startsWith("icon")){
				IconButton button = (IconButton)entry.getValue();
				button.cbutton = null;
			}
		});
	}

}