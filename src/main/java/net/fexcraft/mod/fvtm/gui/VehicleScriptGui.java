package net.fexcraft.mod.fvtm.gui;

import java.util.ArrayList;
import java.util.Arrays;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.SettingHolder.ScriptSetting;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleScriptGui extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation("fvtm:textures/guis/vehicle_scripts.png");
    //private EntityPlayer player;
    //private World world;
    private int seat, vehicle, scroll, size;
    private VehicleEntity entity;
    private ArrayList<ScriptSetting<?, ?>> settings = new ArrayList<ScriptSetting<?, ?>>();
    private GenericGuiButton button_up, button_down;
	
	public VehicleScriptGui(EntityPlayer player, World world, int x, int y, int z){
		super(new GenericGuiContainer.DefImpl());
		/*this.player = player; this.world = world;*/ this.seat = y; this.vehicle = x; this.scroll = z;
		Entity ent = world.getEntityByID(vehicle);
		if(ent == null || ent instanceof VehicleEntity == false){
			exit(); return;
		}
		this.entity = (VehicleEntity)ent;
		ArrayList<ScriptSetting<?, ?>> list = new ArrayList<>();
		entity.getVehicleData().getScripts().forEach(scr -> { ScriptSetting<?, ?>[] arr = scr.getSettings(seat); if(arr != null){ list.addAll(Arrays.asList(arr)); } });
		for(int i = 0; i < 8; i++){
			if(i + scroll >= list.size()){ break; }
			settings.add(list.get(i + scroll));
		}
		size = list.size();
		list.clear();
	}
	
	private void exit(){
		this.mc.displayGuiScreen((GuiScreen)null);
        if(this.mc.currentScreen == null){ this.mc.setIngameFocus(); }
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 168 + 12, 150);
        //
        for(int i = 0; i < 8; i++){
        	if(i >= settings.size()){ break; }
        	ScriptSetting<?, ?> setting = settings.get(i);
        	String str = this.fontRenderer.trimStringToWidth(I18n.format("script." + setting.getHolder().getSettingHolderId() + "." + setting.getId(), new Object[0]), 105);
    		this.fontRenderer.drawString(str, guiLeft +   8, guiTop + 23 + (i * 16), MapColor.GRAY.colorValue);
    		str = this.fontRenderer.trimStringToWidth(setting.getValue(), 105);
    		this.fontRenderer.drawString(str, guiLeft + 128, guiTop + 23 + (i * 16), MapColor.GRAY.colorValue);
        }
        //
        for(int i = 0; i < 16; i++){
        	Button button = getButton(i);
        	if(button == null){ break; }
        	switch(button.setting.getType()){
				case BOOLEAN:
					if(button.upper){
						button.enabled = !Boolean.parseBoolean(button.setting.getValue());
					}
					else{
						button.enabled = Boolean.parseBoolean(button.setting.getValue());
					}
					break;
				case BUTTON:
					button.enabled = !button.setting.getValue().equals("");
					break;
				case INTEGER:
					try{
						if(button.upper){
							button.enabled = Integer.parseInt(button.setting.getValue()) > -10000;
						}
						else{
							button.enabled = Integer.parseInt(button.setting.getValue()) < 10000;
						}
					}
					catch(Exception e){
						button.enabled = true;
					}
					break;
				case STRING: break;
        	}
        }
        //
        button_up.enabled = scroll > 0;
        button_down.enabled = scroll + 8 < size;
	}
	
	@Override
	public void actionPerformed(GuiButton button){
		if(button.id < 16){
			NBTTagCompound compound = new NBTTagCompound();
			ScriptSetting<?, ?> setting = button instanceof Button ? ((Button)button).setting : null;
			if(setting == null){ return; }
			boolean positive = ((Button)button).upper;
			switch(setting.getType()){
				case BOOLEAN:{
					//setting.onChange(entity.getEntity(), positive ? 1 : 0);
					compound.setInteger("payload", positive ? 1 : 0);
					break;
				}
				case BUTTON:{
					//setting.onChange(entity.getEntity(), 1);
					compound.setInteger("payload", 1);
					break;
				}
				case INTEGER:{
					//setting.onChange(entity.getEntity(), positive ? 1 : -1);
					compound.setInteger("payload", positive ? 1 : -1);
					break;
				}
				case STRING:{
					//TODO
					break;
				}
			}
            compound.setString("target_listener", "fvtm");
            compound.setString("task", "script_setting");
            compound.setString("script", setting.getHolder().getSettingHolderId());
            compound.setString("script_setting", setting.getId());
            compound.setInteger("seat", seat);
            compound.setInteger("entity", entity.getEntity().getEntityId());
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
		}
		if(button.id == 16 || button.id == 17){
			NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("target_listener", "fvtm");
            nbt.setString("task", "open_gui");
            nbt.setInteger("gui", GuiHandler.VEHICLE_SCRIPTSGUI);
            nbt.setIntArray("args", new int[]{vehicle, seat, scroll + (button.id == 16 ? -1 : 1)});
            PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
		}
		return;
	}
	
	private Button getButton(int i){
		for(GuiButton button : buttonList){
			if(button.id == i){
				return (Button)button;
			}
		}
		return null;
	}

	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		for(int i = 0; i < 8; i++){
			if(i >= settings.size()){ break; }
			this.buttonList.add(new Button(buttonList.size(), guiLeft + 118, guiTop + 19 + (i * 16), settings.get(i), true));
			this.buttonList.add(new Button(buttonList.size(), guiLeft + 118, guiTop + 26 + (i * 16), settings.get(i), false));
		}
		//
		button_up = new GenericGuiButton(16, 166 + guiLeft, 5 + guiTop, 9, 12, "");
		button_up.setTexturePos(0, 220, 0);
        button_up.setTexturePos(1, 229, 0);
        button_up.setTexturePos(2, 238, 0);
        button_up.setTexturePos(3, 247, 0);
        button_up.setTexture(TEXTURE);
		this.buttonList.add(button_up);
        //
		button_down = new GenericGuiButton(17, 166 + guiLeft, 23 + guiTop, 9, 12, "");
		button_down.setTexturePos(0, 220, 12);
        button_down.setTexturePos(1, 229, 12);
        button_down.setTexturePos(2, 238, 12);
        button_down.setTexturePos(3, 247, 12);
        button_down.setTexture(TEXTURE);
        this.buttonList.add(button_down);
        //
	}
	
	public static class Button extends GuiButton {
		
		private boolean upper;
		private ScriptSetting<?, ?> setting;

		public Button(int id, int x, int y, ScriptSetting<?, ?> setting, boolean upper){
			super(id, x, y, 9, 7, "");
			this.setting = setting;
			this.upper = upper;
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			if(!this.visible){ return; }
			mc.getTextureManager().bindTexture(TEXTURE);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			int j = 0;
			switch(setting.getType()){
				case BOOLEAN: j = 52; break;
				case BUTTON:  j = 66; break;
				case INTEGER: j = 24; break;
				case STRING:  j = 38; break;
			}
			if(!upper){ j += 7; }
			if(this.enabled){
				if(!this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 220, j, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 229, j, this.width, this.height);
				}
			}
			else{
				if(!this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 238, j, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 247, j, this.width, this.height);
				}
			}
		}
		
	}
	
}