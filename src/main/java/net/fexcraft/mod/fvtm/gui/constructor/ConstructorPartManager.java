package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_TEXTUREMANAGER;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorPartManager extends ConstructorGui {

	private IconButton[] remico = new IconButton[10], edico = new IconButton[20];
	private IconButton next, prev;
	private int page;

	public ConstructorPartManager(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{"||Installed Parts:", "||-", "||-", "||-", "||-", "||-", "||-", "||-", "||-", "||-", "||-", "||Page -/-", "", "< Back"};
	}
	
	@Override
	public void init(){
		super.init();
		this.menutitle.string = "Part Manager";
		boolean noveh = container.getTileEntity().getVehicleData() == null;
		this.container.setTitleText(noveh ? "No Vehicle in Constructor" : container.getTileEntity().getVehicleData().getType().getName(), RGB.WHITE.packed);
		this.buttons.put("next_page", next = new IconButton("next", 11, 0, false, ICON_RIGHT));
		this.buttons.put("prev_page", prev = new IconButton("prev", 11, 1, false, ICON_LEFT));
		for(int i = 1; i < 11; i++){
			this.buttons.put("icon" + i + "r", remico[i - 1] = new IconButton("icon_rem" + i, i, 0, false, ICON_REMOVE));
			this.buttons.put("icon0" + i + "e", edico[i - 1] = new IconButton("icon_edit0" + i, i, 1, false, ICON_EDIT0));
			this.buttons.put("icon1" + i + "e", edico[i - 1 + 10] = new IconButton("icon_edit1" + i, i, 2, false, ICON_EDIT1));
		}
		this.updateButtons();
	}
	
	private void updateButtons(){
		if(container.getTileEntity().getVehicleData() == null){
			tbuttons[11].string = "Page -/-";
			for(int i = 1; i < 11; i++) tbuttons[i].string = " / / / / / ";
			next.enabled = prev.enabled = false;
		}
		else{
			VehicleData vdata = container.getTileEntity().getVehicleData();
			tbuttons[11].string = "Page " + (page + 1) + "/" + (vdata.getParts().size() / 10 + 1);
			for(int i = 1; i < 11; i++){
				int j = i + (page * 10) - 1;
				tbuttons[i].string = j >= vdata.getParts().size() ? " - - - - " : "." + (String)vdata.getParts().keySet().toArray()[j];
				remico[i -1].visible = edico[i -1].visible = edico[i + 9].visible = j < vdata.getParts().size();
				//TODO edico[i -1].enabled = edico[i -1].visible ? vdata.getParts().values().toArray(new PartData[0])[j].getType().isRemovable() : false;
			}
			next.enabled = page < vdata.getParts().size() / 10;
			prev.enabled = page > 0;
			buttons.entrySet().forEach(entry -> {
				if(entry.getKey().startsWith("icon")){
					IconButton button = (IconButton)entry.getValue();
					button.cbutton = null;
				}
			});
		}
		for(int i = 1; i < 11; i++){
			buttons.get("button" + i).sizex = getButtonWidth(tbuttons[i].string);
		}
		buttons.entrySet().forEach(entry -> {
			if(entry.getKey().startsWith("icon")){
				IconButton button = (IconButton)entry.getValue();
				button.cbutton = null;
			}
		});
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button13")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		else if(button.name.equals("next")){
			page++;
			this.updateButtons();
		}
		else if(button.name.equals("prev")){
			page--;
			this.updateButtons();
		}
		else if(button.name.contains("icon_edit0")){
			try{
				int i = Integer.parseInt(button.name.replace("icon_edit0", ""));
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("category", tbuttons[i].string.trim().replace(".", ""));
				openGui(920, xyz, LISTENERID, compound);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(button.name.contains("icon_edit1")){
			try{
				int i = Integer.parseInt(button.name.replace("icon_edit1", ""));
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("category", tbuttons[i].string.trim().replace(".", ""));
				openGui(CONSTRUCTOR_TEXTUREMANAGER, xyz, LISTENERID, compound);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(button.name.contains("icon_rem")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "part_remove");
			compound.setString("category", tbuttons[Integer.parseInt(button.name.replace("icon_rem", ""))].string.replace(".", ""));
			this.titletext.update("Request sending to Server.", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
		}
		return true;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		if(am == 0) return;
		if(am > 0) page--; else page++;
		if(page < 0) page = 0;
		this.updateButtons();
	}
	
	@Override
	public void onTitleTextUpdate(){
		//
	}

	@Override
	public void onClientPacket(NBTTagCompound nbt){
		updateButtons();
	}

}
