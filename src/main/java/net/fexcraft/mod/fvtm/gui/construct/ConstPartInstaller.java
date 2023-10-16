package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.*;

import java.util.ArrayList;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstPartInstaller extends ConstGui {
	
	private ArrayList<String> categories = new ArrayList<>();
	private String title;
	private boolean haspages;
	private int page, onpage = 10;

	public ConstPartInstaller(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		help_url += "#partinstaller";
		/*if(container.getTileEntity().getPartData() == null){
			title = "gui.fvtm.constructor.part_install.empty_title";
			return;
		}*///TODO
		title = "gui.fvtm.constructor.part_install.menu_title";
		/*PartData part = container.getTileEntity().getPartData();
		categories.addAll(Lists.newArrayList(part.getType().getInstallHandler().getValidCategories(part, container.getTileEntity().getVehicleData())));
		haspages = categories.size() > onpage;*///TODO
	}
	
	@Override
	public void init(){
		super.init();
		setMenuTitle(title);
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addTopButton(ConstGuiElement.SAVE);
		addElement(BLANK_SEG, "name", "gui.fvtm.constructor.part_install.custom", null);
		addElement(ConstGuiElement.INPUT_1B_SEG, "custom_install", null, (button, mb) -> {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "part_install");
			compound.setString("category", fields.get("custom_install").getText());
			compound.setBoolean("custom_category", true);
			titletext.update(REQUEST_SENT, RGB_CYAN.packed);
			container.send(Side.SERVER, compound);
		}, ConstGuiElement.CONFIRM_ICON.asarray(), new String[]{ "gui.fvtm.constructor.part_install.custom_install" });
		addElement(EMPTY_SEG, "spacer0", null, null);
		addElement(EMPTY_SEG, "spacer1", null, null);
		addElement(BLANK_SEG, "default", "gui.fvtm.constructor.part_install.default", null);
		for(int i = 0; i < onpage; i++){
			int j = page * onpage + i;
			addElement(GENERIC_1B_SEG, "category" + i, "", (button, mb) -> {
				if(j >= categories.size()) return;
				try{
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "part_install");
					compound.setString("category", categories.get(j));
					compound.setBoolean("custom_category", false);
					titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
					container.send(Side.SERVER, compound);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			},
			ConstGuiElement.EDIT_ICON.asarray(),
			new String[]{ "gui.fvtm.constructor.button.edit", });
		}
		if(haspages){
			addElement(EMPTY_SEG, "spacer3", null, null);
			addElement(SWITCH_SEG, "page", "gui.fvtm.constructor.page", (button, mb) -> {
				if(button.name.endsWith("_0")) page--; else page++;
				if(page < 0) page = 0;
				updateButtons();
			}, ConstGuiElement.PREV_ICON.asarray(ConstGuiElement.NEXT_ICON));
		}
		finish_init();
		updateButtons();
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		if(haspages){
			if(am > 0) page--; else page++;
			if(page < 0) page = 0;
		}
		updateButtons();
	}

	@Override
	public void onClientPacket(NBTTagCompound nbt){
		updateButtons();
	}
	
	private void updateButtons(){
		VehicleData vdata = container.getTileEntity().getVehicleData();
		/*if(container.getTileEntity().getPartData() == null){
			for(int i = 0; i < onpage; i++){
				texts.get("category" + i).string = i == 0 ? I18n.format("gui.fvtm.constructor.part_install.empty") : "";
				infotext.remove(buttons.get("category" + i));
				((RunButton)buttons.get("category" + i + "_0")).set_type_and_info(this, EDIT_ICON, "gui.fvtm.constructor.part_install.empty");
			}
			categories.clear();
			return;
		}*///TODO
		if(haspages) texts.get("page").string = I18n.format("gui.fvtm.constructor.page") + " " + (page + 1) + "/" + ((categories.size() / onpage + 1));
		String sbprefix = I18n.format("gui.fvtm.constructor.part_install.slot_prefix");
		for(int i = 0; i < onpage; i++){
			int j = i + (page * onpage);
			boolean ex = j < categories.size();
			String cat = ex ? categories.get(j) : "";
			boolean slotbased = cat.startsWith("s:");
			String[] split = slotbased ? cat.split(":") : null;
			if(slotbased) cat = split[2].replace("*", split[1]);
			texts.get("category" + i).string = (slotbased ? sbprefix : "") + cat;
			BasicButton button = buttons.get("category" + i);
			RunButton icon = (RunButton)buttons.get("category" + i + "_0");
			texts.get("category" + i).visible = button.visible = icon.visible = ex;
			if(ex){
				if(!slotbased){
					infotext.put(button, new String[]{
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.normal")),
						"",
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.install"))
					});
				}
				else {
					infotext.put(button, new String[]{
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.slot_based")),
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.slot_root", split[1])),
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.slot_cat", cat)),
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.slot_index", split[3])),
						"",
						Formatter.format(I18n.format("gui.fvtm.constructor.part_install.install"))
					});
				}
				boolean partin = container.getTileEntity().getVehicleData() == null || container.getTileEntity().getVehicleData().getPart(cat) != null;
				icon.enabled = !partin;
				icon.set_type_and_info(this, partin ? CANCEL_ICON : CONFIRM_ICON, partin ? "gui.fvtm.constructor.part_install.cat_exists" : "gui.fvtm.constructor.part_install.cat_free");
			}
		}
		if(!haspages) return;
		buttons.get("page_1").enabled = page < vdata.getParts().size() / onpage;
		buttons.get("page_0").enabled = page > 0;
	}

}
