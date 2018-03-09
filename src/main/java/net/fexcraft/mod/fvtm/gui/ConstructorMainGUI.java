package net.fexcraft.mod.fvtm.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.gui.windows.ConnectionStatus;
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
	static {
		WINDOWPOOL.put("connection_status", new ConnectionStatus());
	}
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000.png");
	public static EntityPlayer player;
	private static BlockPos pos;
	private static World world;
	private static int id;
	//
	public static boolean menu = false, connected, paint;
	public ArrayList<Window> windows = new ArrayList<Window>();
	public static String title = "";
	public static GuiButton time, conn, batt, resy, recy;
	public static GenericGuiButton menub;

	public ConstructorMainGUI(int iD, EntityPlayer ply, World w, int x, int y, int z){
		super(new GenericPlaceholderContainer());
		this.xSize = 256;
		this.ySize = 192;
		player = ply;
		pos = new BlockPos(x, y, z);
		id = iD; world = w;
		title = "loading...";
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
			windows.forEach(window -> {
				window.drawWindow(this, mc, i, j, mouseX, mouseY, partialTicks);
			});
		}
		if(title != null && title.length() > 0){
			mc.fontRenderer.drawString(mc.fontRenderer.trimStringToWidth(title, 122), i + 15, j + 181, 14737632, false);
		}
		//
		if(menu){
			this.mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(i + 1, j + 115, 128, 192, 128, 64);
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
					//menub0.visible = menub0.enabled = menu;//TODO
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
				default: return;
			}
		}
		if(!windows.isEmpty()){
			windows.get(0).actionPerformed(this, button);
		}
	}
	
	public void openWindow(String string){
		if(windows.size() > 0 && windows.get(0).getId().equals(string)){
			windows.get(0).close(this, string);
			windows.remove(0);
			if(!windows.isEmpty()){
				windows.get(0).toggleButtonState(this, true);
			}
			return;
		}
		Window win = WINDOWPOOL.get(string);
		if(!(win == null)){
			if(windows.contains(win)){
				windows.remove(win);
				//TODO put on front/0 instead
			}
			if(win.closesOther()){
				windows.forEach(window -> {
					window.close(this, win.getId());
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
		connected = nbt.getBoolean("connected");
		paint = nbt.getBoolean("paint");
		title = "";
	}
	
	public List<GuiButton> getButtonList(){
		return this.buttonList;
	}
	
}