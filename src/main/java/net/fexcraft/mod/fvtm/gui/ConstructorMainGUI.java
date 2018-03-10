package net.fexcraft.mod.fvtm.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.windows.ConnectionStatus;
import net.fexcraft.mod.fvtm.gui.windows.ConstructorStatus;
import net.fexcraft.mod.fvtm.gui.windows.SprayingTool;
import net.fexcraft.mod.fvtm.gui.windows.Window;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ConstructorMainGUI extends GuiContainer {
	
	public static final TreeMap<String, Window> WINDOWPOOL = new TreeMap<>();
	public final int COLOR = 14737632;
	static {
		WINDOWPOOL.put("connection_status", new ConnectionStatus());
		WINDOWPOOL.put("status", new ConstructorStatus());
		WINDOWPOOL.put("rgb_painter", new SprayingTool());
	}
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000.png");
	public static EntityPlayer player;
	public BlockPos pos;
	public ConstructorControllerEntity tile;
	public static World world;
	public static int id;
	//
	public static boolean menu = false, connected, paint;
	public ArrayList<Window> windows = new ArrayList<Window>();
	public static String title = "";
	public static GuiButton time, conn, batt, resy, recy;
	public static GenericGuiButton menub;
	public static MenuButton menub0, menub1, menub2, menub3, menub4, menub5;

	public ConstructorMainGUI(int iD, EntityPlayer ply, World w, int x, int y, int z){
		super(new GenericPlaceholderContainer());
		this.xSize = 256;
		this.ySize = 192;
		player = ply;
		pos = new BlockPos(x, y, z);
		id = iD; world = w;
		title = "...";
		tile = (ConstructorControllerEntity)world.getTileEntity(pos);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm");
		compound.setString("task", "constructor_9000_init");
		compound.setLong("pos", pos.toLong());
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		this.mc.getTextureManager().bindTexture(texture);
		int i = this.guiLeft, j = this.guiTop;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		//
		//time.drawButton(mc, mouseX, mouseY, partialTicks);
		//menub.drawButton(mc, mouseX, mouseY, partialTicks);
		//conn.drawButton(mc, mouseX, mouseY, partialTicks);
		if(windows.size() > 0){
			for(int k = windows.size() - 1; k >= 0; k--){
				windows.get(k).drawWindow(this, mc, i, j, mouseX, mouseY, partialTicks);
			}
		}
		if(title != null && title.length() > 0){
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(title, 122), i + 15, j + 181, 14737632, false);
		}
		//
		if(menu){
			this.mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(i + 1, j + 115, 128, 192, 128, 64);
			//menub0.drawButton(mc, mouseX, mouseY, partialTicks);
		}
	}
	
	@Override
	public void initGui(){
		super.initGui();
		this.buttonList.clear();
		int i = this.guiLeft;
		int j = this.guiTop;
		//
		this.buttonList.add(time = new TimeButton(0, i + 221, j + 180));
		this.buttonList.add(menub = new GenericGuiButton(1, i + 2, j + 180, 10, 10, ""));
		menub.setTexture(texture);
		menub.setTexturePos(0, 25, 233);
		menub.setTexturePos(1, 37, 233);
		this.buttonList.add(conn = new StatusButton(2, i + 210, j + 180, "connected"));
		this.buttonList.add(batt = new StatusButton(3, i + 199, j + 180, "battery"));
		this.buttonList.add(resy = new StatusButton(4, i + 188, j + 180, "resync"));
		this.buttonList.add(recy = new StatusButton(5, i + 177, j + 180, "recycle"));
		this.buttonList.add(menub0 = new MenuButton(6, i + 12, j + 118, "Con. Status"));
		this.buttonList.add(menub1 = new MenuButton(7, i + 12, j + 128, "Vehicle Data"));
		this.buttonList.add(menub2 = new MenuButton(8, i + 12, j + 138, "Spraying Tool"));
		this.buttonList.add(menub3 = new MenuButton(9, i + 12, j + 148, "Texture Tool"));
		this.buttonList.add(menub4 = new MenuButton(10, i + 12, j + 158, "Part Manager"));
		this.buttonList.add(menub5 = new MenuButton(11, i + 12, j + 168, "Shutdown"));
		menub0.visible = menu; menub1.visible = menu; menub2.visible = menu;
		menub3.visible = menu; menub4.visible = menu; menub5.visible = menu;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);
		//
    }
	
	@Override
	protected void actionPerformed(GuiButton button){
		if(button.id < 12){
			switch(button.id){
				case 1:{
					menu = !menu;
					menub0.visible = menub0.enabled = menu;
					menub1.visible = menub1.enabled = menu;
					menub2.visible = menub2.enabled = menu;
					menub3.visible = menub3.enabled = menu;
					menub4.visible = menub4.enabled = menu;
					menub5.visible = menub5.enabled = menu;
					break;
				}
				case 2:{
					openWindow("connection_status");
					Print.debug("Opening Connection Status.");
					break;
				}
				case 4:{
					NBTTagCompound nbt = getPacketNBT("open_gui");
					nbt.setInteger("gui", id);
					nbt.setIntArray("args", new int[]{ pos.getX(), pos.getY(), pos.getZ() });
					sendPacket(nbt);
					break;
				}
				case 5:{
					NBTTagCompound nbt = getPacketNBT("constructor_9000_recycle");
					sendPacket(nbt);
					break;
				}
				case 6:{
					openWindow("status");
					break;
				}
				case 8:{
					openWindow("rgb_painter");
					break;
				}
				case 11:{
					Minecraft.getMinecraft().currentScreen = null;//TODO
					break;
				}
				default: return;
			}
		}
		if(!windows.isEmpty()){
			windows.get(0).actionPerformed(this, button);
		}
	}
	
	public void openWindow(String string){
		menu = false;
		menub0.visible = menub0.enabled = menu;
		menub1.visible = menub1.enabled = menu;
		menub2.visible = menub2.enabled = menu;
		menub3.visible = menub3.enabled = menu;
		menub4.visible = menub4.enabled = menu;
		menub5.visible = menub5.enabled = menu;
		//
		if(windows.size() > 0 && windows.get(0).getId().equals(string)){
			windows.get(0).close(this, string);
			windows.remove(0);
			if(!windows.isEmpty()){
				windows.get(0).toggleButtonState(this, true);
				title = windows.get(0).getTitle() == null ? "..." : windows.get(0).getTitle();
			}
			return;
		}
		Window win = WINDOWPOOL.get(string);
		if(!(win == null)){
			if(windows.contains(win)){
				boolean b = windows.remove(win);
				if(b){
					windows.add(0, win);
					win.toggleButtonState(this, true);
					title = win.getTitle() == null ? title : win.getTitle();
					return;
				}
			}
			if(win.closesOther()){
				windows.forEach(window -> {
					if(!win.getId().equals(window.getId())){
						window.close(this, win.getId());
					}
				});
				windows.clear();
			}
			windows.forEach(window -> {
				win.toggleButtonState(this, false);
			});
			windows.add(0, win);
			win.addButtons(this, this.buttonList);
			title = win.getTitle() == null ? title : win.getTitle();
			Print.debug(win.getId());
			return;
		}
		Print.debug("Window with ID:'" + string + "' not found!");
	}
	
	public void closeWindow(String string){
		if(!windows.isEmpty() && windows.get(0).getId().equals(string)){
			windows.get(0).close(this, string);
			windows.remove(0);
			if(!windows.isEmpty()){
				windows.get(0).toggleButtonState(this, true);
			}
			title = "...";
			//
			if(!windows.isEmpty()){
				windows.get(0).toggleButtonState(this, true);
				title = windows.get(0).getTitle() == null ? "..." : windows.get(0).getTitle();
			}
			return;
		}
	}

	private static class TimeButton extends GuiButton {

		public TimeButton(int buttonId, int x, int y){
			super(buttonId, x, y, 32, 10, "");
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float pt){
			if(!this.visible){ return; }
			int j = 14737632;
            this.drawCenteredString(mc.fontRenderer, this.displayString = calcTime(), this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
		}
		
		/** based on https://bukkit.org/threads/ticks-to-real-time.86695/#post-1217476 */
		public static String calcTime(){
	        long worldtime = world.getWorldTime();
	        long hours = worldtime / 1000 + 6;
	        long minutes = (worldtime % 1000) * 60 / 1000;
	        if(hours >= 24){ hours -= 24; }
	        if(hours >= 24){ hours -= 24; }
	        String mm = "0" + minutes; 
	        mm = mm.substring(mm.length() - 2, mm.length());
	        return hours + ":" + mm;
	    }
		
	}
	
	private static class MenuButton extends GuiButton {

		public MenuButton(int buttonId, int x, int y, String buttonText){
			super(buttonId, x, y, 114, 8, buttonText);
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float pt){
			if(!this.visible){ return; }
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(this.displayString, 114), x + 1, y, hovered ? 16777120 : 14737632, false);
		}
	}
		
	private static class StatusButton extends GuiButton {

		public StatusButton(int buttonId, int x, int y, String type){
			super(buttonId, x, y, 10, 10, type);
		}
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float pt){
			if(!this.visible){ return; }
			mc.getTextureManager().bindTexture(texture);
			switch(displayString){
				case "connected":{
					this.drawTexturedModalRect(x, y, connected ? 13 : 1, 245, 10, 10);
					break;
				}
				case "battery":{
					this.drawTexturedModalRect(x, y, connected ? 25 : 37, 245, 10, 10);
					break;
				}
				case "resync":{
					this.drawTexturedModalRect(x, y, 1, 233, 10, 10);
					break;
				}
				case "recycle":{
					this.drawTexturedModalRect(x, y, 13, 233, 10, 10);
					break;
				}
			}
		}
		
	}
	
	public NBTTagCompound getPacketNBT(String task){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("target_listener", "fvtm");
		compound.setString("task", task);
		compound.setLong("pos", pos.toLong());
		return compound;
	}
	
	public void sendPacket(NBTTagCompound compound){
		PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
	}

	public static void processInitResponse(NBTTagCompound nbt){
		if(nbt.hasKey("connected")){
			connected = nbt.getBoolean("connected");
		}
		if(nbt.hasKey("paint")){
			paint = nbt.getBoolean("paint");
		}
	}
	
	public List<GuiButton> getButtonList(){
		return this.buttonList;
	}
	
}