package net.fexcraft.mod.fvtm.gui;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.lib.network.Browser;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class AddonManagerGui extends GuiContainer {
	
	//MAIN
	private Button[][] menubuttons;
	//ALL
	private ListEntryButton[][] listbuttons;
	private ScrollButton up, down;
	private int scroll = 0;
	public static ArrayList<Addon> addons = new ArrayList<Addon>();
	//ONE
	public static Addon addon;
	//COMMON
	private Modes mode;

	public AddonManagerGui(int mode, int y, int z){
		super(new GenericPlaceholderContainer());
		this.mode = Modes.fromInt(mode);
		switch(this.mode){
			case MAIN:
				this.xSize = 256;
				this.ySize = 123;
				break;
			case VIEW_ALL:
				this.xSize = 256;
				this.ySize = 189;
				PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(getPacket("get_addon_list")));
				break;
			case VIEW_ONE:
				this.xSize = 256;
				this.ySize = 187;
				addon = addons.get(y);
				if(addon == null){
					Static.stop();
				}
				break;
		}
	}
	
	public static enum Modes {
		MAIN(0,     "fvtm:textures/guis/addon_manager_main.png"),
		VIEW_ALL(1, "fvtm:textures/guis/addon_manager_view_all.png"),
		VIEW_ONE(2, "fvtm:textures/guis/addon_manager_view_one.png");
		
		private ResourceLocation texture;
		private int id;
		
		Modes(int id, String rs){
			this.id = id;
			this.texture = new ResourceLocation(rs);
		}

		public static Modes fromInt(int id){
			for(Modes mode : values()){
				if(mode.id == id){
					return mode;
				}
			}
			return null;
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.mc.getTextureManager().bindTexture(mode.texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		
		if(mode == Modes.MAIN){
			this.fontRenderer.drawString(trs("main_description_0"), i + 7, j + 26, MapColor.GRAY.colorValue);
			this.fontRenderer.drawString(trs("main_description_1"), i + 7, j + 38, MapColor.GRAY.colorValue);
			this.fontRenderer.drawString(trs("main_description_2"), i + 7, j + 50, MapColor.GRAY.colorValue);
		}
		else if(mode == Modes.VIEW_ALL){
			this.fontRenderer.drawString(trs("view_all_loadedaddons") + " " + addons.size(), i + 7, j + 7, MapColor.CYAN.colorValue);
			this.fontRenderer.drawString(scroll + "s", i + 242, j + 176, MapColor.YELLOW.colorValue);
			this.fontRenderer.drawString(trs("view_all_note"), i + 86, j + 176, MapColor.RED.colorValue);
			//updateListButtons();
			Addon addon = null;
			int id = scroll, k = 7, l = 216, m = MapColor.GRAY.colorValue;
			//0
			addon = id >= addons.size() ? null : addons.get(id);
			if(addon != null){
				this.draw(addon, 0, i, j, k, l, m, 26, 38, 50);
			}
			else{
				listbuttons[0][0].enabled = false; listbuttons[0][1].enabled = false;
			}
			//1
			id++;
			addon = id >= addons.size() ? null : addons.get(id);
			if(addon != null){
				this.draw(addon, 1, i, j, k, l, m, 64, 76, 88);
			}
			else{
				listbuttons[1][0].enabled = false; listbuttons[1][1].enabled = false;
			}
			//2
			id++;
			addon = id >= addons.size() ? null : addons.get(id);
			if(addon != null){
				this.draw(addon, 2, i, j, k, l, m, 102, 114, 126);
			}
			else{
				listbuttons[2][0].enabled = false;listbuttons[2][1].enabled = false;
			}
			//3
			id++;
			addon = id >= addons.size() ? null : addons.get(id);
			if(addon != null){
				this.draw(addon, 3, i, j, k, l, m, 140, 152, 164);
			}
			else{
				listbuttons[3][0].enabled = false;listbuttons[3][1].enabled = false;
			}
		}
		else if(mode == Modes.VIEW_ONE){
			this.fontRenderer.drawString(trim228(addon.getName()), i + 7, j + 7, MapColor.YELLOW.colorValue);
			this.fontRenderer.drawString("ID: " + addon.getRegistryName().toString(), i + 7, j + 26, MapColor.GRAY.colorValue);
			this.fontRenderer.drawString(trs(addon.isEnabled() ? "view_all_state_enabled" : "view_all_state_disabled") + " || MD: " + (addon.hasMissingDependencies() ? 1 : 0), i + 7, j + 40, MapColor.GRAY.colorValue);
			this.fontRenderer.drawString(trim228(addon.getURL()), i + 7, j + 68, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(trim228(addon.getLicense()), i + 7, j + 83, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(trim228(addon.getFileAddress()), i + 7, j + 98, MapColor.SNOW.colorValue);
			//
			String deps = "Dependencies: ";
			if(addon.getDependencies().size() == 0){
				deps += "none";
			}
			else{
				for(ResourceLocation string : addon.getDependencies()){
					deps += string + ", ";
				}
			}
			this.fontRenderer.drawSplitString(trim(deps, 3 * 242), i + 7, j + 112, 242, MapColor.GRAY.colorValue);
			String authors = "Authors: ";
			if(addon.getAuthors().size() > 0){
				for(UUID uuid : addon.getAuthors()){
					authors += Static.getPlayerNameByUUID(uuid) + ", ";
				}
			}
			this.fontRenderer.drawSplitString(trim(authors, 3 * 242), i + 7, j + 144, 242, MapColor.GRAY.colorValue);
			
			this.buttonList.get(4).enabled = !addon.isEnabled() && !addon.hasMissingDependencies();
			this.buttonList.get(5).enabled =  addon.isEnabled() && !addon.hasMissingDependencies();
		}
		else{
			Static.stop();
		}
	}
	
	private String trim(String string, int i){
		return this.fontRenderer.trimStringToWidth(string, i);
	}
	
	private String trim228(String string){
		return this.fontRenderer.trimStringToWidth(string, 228);
	}
	
	private void draw(Addon addon, int arr, int i, int j, int k, int l, int m, int p0, int p1, int p2){
		listbuttons[arr][0].enabled = addon.isEnabled() && !addon.hasMissingDependencies();
		listbuttons[arr][1].enabled = !listbuttons[arr][0].enabled;
		//
		this.fontRenderer.drawSplitString(addon.getName(), i + k, j + p0, l, m);
		this.fontRenderer.drawSplitString("ID: " + addon.getRegistryName().toString() + " || " + trs(addon.isEnabled() ? "view_all_state_enabled" : "view_all_state_disabled") + " || MD: " + (addon.hasMissingDependencies() ? 1 : 0), i + k, j + p1, l, m);
		this.fontRenderer.drawSplitString(addon.getURL(), i + k, j + p2, l, m);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch(mode){
			case MAIN:
				if(button.id == 0){
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("target_listener", "fvtm");
					nbt.setIntArray("args", new int[]{1,0,0});
					nbt.setString("task", "open_addon_manager");
					PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
				}
				else if(button.id == 1){
					OpenGlHelper.openFile(new File(this.mc.getResourcePackRepository().getDirResourcepacks().getParentFile(), "addons/"));
				}
				else if(button.id == 2){
					Static.toggleDebug();
					Print.chat(mc.player, "Client Side (FCL) Debug Toggled.");
					PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(getPacket("toggle_debug")));
				}
				else if(button.id == 6){
					Print.chat(mc.player, trs("main_button_2_0_e"));
					Static.halt();
				}
				break;
			case VIEW_ALL:
				switch(button.id){
					case 0:
						sendAddonToggle(0, true);
						break;
					case 1:
						sendAddonToggle(0, false);		
						break;
					case 2:
						sendViewAddon(0);	
						break;
					case 3:
						sendAddonToggle(1, true);			
						break;
					case 4:
						sendAddonToggle(1, false);			
						break;
					case 5:
						sendViewAddon(1);		
						break;
					case 6:
						sendAddonToggle(2, true);			
						break;
					case 7:
						sendAddonToggle(2, false);	
						break;
					case 8:
						sendViewAddon(2);		
						break;
					case 9:
						sendAddonToggle(3, true);		
						break;
					case 10:
						sendAddonToggle(3, false);		
						break;
					case 11:
						sendViewAddon(3);	
						break;
					case 12:
						if(scroll - 1 >= 0){
							scroll--;
						}
						break;
					case 13:
						scroll++;
						break;
				}
				break;
			case VIEW_ONE:
				switch(button.id){
					case 0:
	    				Browser.browse(mc.player, addon.getURL());
						break;
					case 1:
	    				Browser.browse(mc.player, addon.getLicense());
						break;
					case 2:
						File file = new File(addon.getFileAddress());
						OpenGlHelper.openFile(file.isDirectory() ? file : file.getParentFile());
						break;
					case 3:
						Print.chat(mc.player, "Function not available yet.");
						break;
					case 4:
						try{
							NBTTagCompound nbt = this.getPacket("set_addon_state");
							nbt.setString("id", addon.getRegistryName().toString());
							nbt.setBoolean("state", true);
							PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
						}
						catch(Exception e){
							Print.chat(mc.player, e.getMessage());
							e.printStackTrace();
						}
						break;
					case 5:
						try{
							NBTTagCompound nbt = this.getPacket("set_addon_state");
							nbt.setString("id", addon.getRegistryName().toString());
							nbt.setBoolean("state", false);
							PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
						}
						catch(Exception e){
							Print.chat(mc.player, e.getMessage());
							e.printStackTrace();
						}
						break;
				}
				break;
			default:
				break;
		}
	}
	
	private void sendViewAddon(int i){
		/*NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("target_listener", "fvtm");
		nbt.setIntArray("args", new int[]{2,0,0});
		nbt.setString("id", addons.get(scroll + i).id);
		nbt.setString("task", "open_addon_manager");
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));*/
		mc.player.openGui(FVTM.getInstance(), GuiHandler.ADDON_MANAGER, mc.world, 2, i, 0);
	}

	private void sendAddonToggle(int i, boolean b){
		try{
			NBTTagCompound nbt = this.getPacket("toggle_addon_state");
			nbt.setString("id", addons.get(scroll + i).getRegistryName().toString());
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(nbt));
		}
		catch(Exception e){
			Print.chat(mc.player, e.getMessage());
			e.printStackTrace();
		}
	}

	public NBTTagCompound getPacket(String task){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("target_listener", "fvtm");
		nbt.setString("task", task);
		return nbt;
	}
	
	public static final String trs(String string){
		return I18n.format("gui.fvtm.addon_manager." + string, new Object[0]);
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		int i = this.guiLeft;
		int j = this.guiTop;
		switch(mode){
			case MAIN:
				menubuttons = new Button[3][3];
				menubuttons[0][0] = new Button(0,   5 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_0"));
				menubuttons[0][0].enabled = true;
				menubuttons[0][1] = new Button(1,  88 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_1"));
				menubuttons[0][1].enabled = true;
				menubuttons[0][2] = new Button(2, 171 + this.guiLeft, 62 + this.guiTop, trs("main_button_0_2"));
				menubuttons[0][2].enabled = true;
				menubuttons[1][0] = new Button(3,   5 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_0"));
				menubuttons[1][0].enabled = false;
				menubuttons[1][1] = new Button(4,  88 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_1"));
				menubuttons[1][1].enabled = false;
				menubuttons[1][2] = new Button(5, 171 + this.guiLeft, 78 + this.guiTop, trs("main_button_1_2"));
				menubuttons[1][2].enabled = false;
				menubuttons[2][0] = new Button(6,   5 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_0"));
				menubuttons[2][0].enabled = true;
				menubuttons[2][1] = new Button(7,  88 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_1"));
				menubuttons[2][1].enabled = false;
				menubuttons[2][2] = new Button(8, 171 + this.guiLeft, 94 + this.guiTop, trs("main_button_2_2"));
				menubuttons[2][2].enabled = false;
				for(int l = 0; l < 3; l++){
					for(int m = 0; m < 3; m++){
						this.buttonList.add(menubuttons[l][m]);
					}
				}
				break;
			case VIEW_ALL:
				int k = i + 227;
				listbuttons = new ListEntryButton[4][3];
				//
				this.buttonList.add(listbuttons[0][0] = new ListEntryButton(0, k, j + 24, 0));
				this.buttonList.add(listbuttons[0][1] = new ListEntryButton(1, k, j + 36, 1));
				this.buttonList.add(listbuttons[0][2] = new ListEntryButton(2, k, j + 48, 2));
				//
				this.buttonList.add(listbuttons[1][0] = new ListEntryButton(3, k, j + 62, 0));
				this.buttonList.add(listbuttons[1][1] = new ListEntryButton(4, k, j + 74, 1));
				this.buttonList.add(listbuttons[1][2] = new ListEntryButton(5, k, j + 86, 2));
				//
				this.buttonList.add(listbuttons[2][0] = new ListEntryButton(6, k, j + 100, 0));
				this.buttonList.add(listbuttons[2][1] = new ListEntryButton(7, k, j + 112, 1));
				this.buttonList.add(listbuttons[2][2] = new ListEntryButton(8, k, j + 124, 2));
				//
				this.buttonList.add(listbuttons[3][0] = new ListEntryButton( 9, k, j + 138, 0));
				this.buttonList.add(listbuttons[3][1] = new ListEntryButton(10, k, j + 150, 1));
				this.buttonList.add(listbuttons[3][2] = new ListEntryButton(11, k, j + 162, 2));
				//
				this.buttonList.add(up   = new ScrollButton(true, i, j));
				this.buttonList.add(down = new ScrollButton(false, i, j));
				break;
			case VIEW_ONE:
				this.buttonList.add(new LinkButton(0, i + 239, j + 66, !addon.getURL().equals(""/*Addon.deflink*/)));
				this.buttonList.add(new LinkButton(1, i + 239, j + 81, !addon.getURL().equals(""/*Addon.deflicense*/)));
				this.buttonList.add(new LinkButton(2, i + 239, j + 96, true));
				this.buttonList.add(new SelectionButton(3, i + 170, j + 24, 0, trs("view_one_update")));
				this.buttonList.add(new SelectionButton(4, i + 170, j + 38, 1, trs("view_one_state_enabled")));
				this.buttonList.add(new SelectionButton(5, i + 170, j + 52, 2, trs("view_one_state_disabled")));
				break;
			default:
				break;
		}
	}
	
	public class Button extends GuiButton {
		
		public Button(int id, int x, int y, String text){
			super(id, x, y, 80, 14, text);
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			int color;
			if(this.enabled){
				color = MapColor.GRAY.colorValue;
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 176, 228, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 176, 214, this.width, this.height);
				}
				//this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, MapColor.GRAY.colorValue);
			}
			else{
				color = MapColor.SNOW.colorValue;
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 176, 200, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 176, 242, this.width, this.height);
				}
				//this.drawCenteredString(mc.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, MapColor.SILVER.colorValue);
			}
			mc.fontRenderer.drawString(this.displayString, ((this.x + this.width / 2) - mc.fontRenderer.getStringWidth(this.displayString) / 2), this.y + (this.height - 8) / 2, color);
		}
		
	}
	
	public class ListEntryButton extends GuiButton {
		
		private int type;

		public ListEntryButton(int buttonId, int x, int y, int type){
			super(buttonId, x, y, 11, 12, "");
			this.type = type;
		}
		
		private int fromType(){
			switch(type){
				case 0: return 234;
				case 1: return 245;
				case 2: return 223;
				default: return 0;
			}
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, fromType(), 232, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, fromType(), 244, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.x, this.y, fromType(), 220, this.width, this.height);
			}
		}
	}
	
	public class ScrollButton extends GuiButton {
		
		private boolean up;

		public ScrollButton(boolean b, int i, int j){
			super(b ? 12 : 13, i + 240, j + (b ? 24 : 162), 11, 12, "");
			up = b;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, up ? 212 : 201, 232, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, up ? 212 : 201, 244, this.width, this.height);
				}
			}
			else{
				this.drawTexturedModalRect(this.x, this.y, up ? 212 : 201, 220, this.width, this.height);
			}
		}
	}
	
	public class LinkButton extends GuiButton{
		
		public LinkButton(int id, int x, int y, boolean b){
			super(id, x, y, 12, 12, "");
			this.enabled = b;
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			if(this.enabled){
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 12, 224, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 0, 224, this.width, this.height);
				}
			}
			else{
				if(this.hovered){
					this.drawTexturedModalRect(this.x, this.y, 12, 236, this.width, this.height);
				}
				else{
					this.drawTexturedModalRect(this.x, this.y, 0, 236, this.width, this.height);
				}
			}
		}
		
	}
	
	public class SelectionButton extends GuiButton {
		
		private int type;

		public SelectionButton(int buttonId, int x, int y, int type, String text){
			super(buttonId, x, y, 81, 12, text);
			this.type = type;
		}
		
		private int fromType(){
			switch(type){
				case 0: return 196;
				case 1: return 220;
				case 2: return 244;
				default: return 0;
			}
		}
		
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float f){
			super.drawButton(mc, mouseX, mouseY, f);
			mc.getTextureManager().bindTexture(mode.texture);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			
			int color;
			if(this.enabled){
				if(this.hovered){
					color = MapColor.BLUE.colorValue;
					this.drawTexturedModalRect(this.x, this.y, 175, 232, this.width, this.height);
				}
				else{
					color = MapColor.SNOW.colorValue;
					this.drawTexturedModalRect(this.x, this.y, 175, fromType(), this.width, this.height);
				}
			}
			else{
				color = MapColor.GRAY.colorValue;
				this.drawTexturedModalRect(this.x, this.y, 175, 208, this.width, this.height);
			}
			mc.fontRenderer.drawString(this.displayString, ((this.x + this.width / 2) - mc.fontRenderer.getStringWidth(this.displayString) / 2), this.y + (this.height - 8) / 2, color);
		}
		
	}
	
}