package net.fexcraft.mod.fvtm.gui.junction;

import static net.fexcraft.lib.mc.utils.Formatter.format;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.uni.PathJuncType;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class JunctionAdjuster extends GenericGui<JunctionAdjusterContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/junction_main.png");
	private BasicButton[] type = new BasicButton[5];
	private ArrayList<String> tooltip = new ArrayList<>();
	private boolean crossing;
	public static final RGB BLU = new RGB(0x0094FF);
	public static final RGB RED = new RGB(0xCC1A29);
	public static final RGB GRE = new RGB(0x00FF21);
	public static final RGB ORA = new RGB(0xFF6A00);
	
	public JunctionAdjuster(EntityPlayer player){
		super(texture, new JunctionAdjusterContainer(player), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 176;
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 205, MapColor.SNOW.colorValue, "ID: " + container.junction.getVec316f().asIDString()));
		buttons.put("help", new BasicButton("help", guiLeft + 216, guiTop + 7, 216, 7, 12, 12, true));
		buttons.put("copy", new BasicButton("copy", guiLeft + 229, guiTop + 7, 229, 7, 12, 12, true));
		for(int i = 0; i < PathJuncType.values().length; i ++){
			buttons.put("type" + i, type[i] = new BasicButton("type" + i, guiLeft + 76 + (i * 18), guiTop + 21, 76 + (i * 18), 21, 18, 18,
				i == 0 ? container.junction.size() <= 2 : i == 1 ? container.junction.size() == 3 : container.junction.size() == 4));
		}
		texts.put("switch0", new BasicText(guiLeft + 75, guiTop + 44, 127, MapColor.SNOW.colorValue, " . . . "));
		texts.put("switch1", new BasicText(guiLeft + 75, guiTop + 57, 127, MapColor.SNOW.colorValue, " . . . "));
		fields.put("station", new TextField(0, fontRenderer, guiLeft + 73, guiTop + 69, 142, 12));
		fields.get("station").setText(container.junction.station == null ? "no station" : container.junction.station);
		buttons.put("s_app", new BasicButton("s_app", guiLeft + 216, guiTop + 69, 216, 69, 12, 12, true));
		buttons.put("s_del", new BasicButton("s_del", guiLeft + 229, guiTop + 69, 229, 69, 12, 12, true));
		for(int i = 0; i < 4; i++){
			int j =  + (i * 14);
			texts.put("track" + i, new BasicText(guiLeft + 12, guiTop + 96 + j, 203, MapColor.SNOW.colorValue, ""));
			if(i != 0) buttons.put("up" + i, new BasicButton("up" + i, guiLeft + 218, guiTop + 94 + j, 218, 94 + j, 7, 12, true));
			if(i != 3) buttons.put("dw" + i, new BasicButton("dw" + i, guiLeft + 226, guiTop + 94 + j, 226, 94 + j, 7, 12, true));
			buttons.put("del" + i, new BasicButton("del" + i, guiLeft + 234, guiTop + 94 + j, 234, 94 + j, 7, 12, true));
		}
		texts.put("signal", new BasicText(guiLeft + 16, guiTop + 160, 162, MapColor.SNOW.colorValue, ""));
		buttons.put("s_c", new BasicButton("sig_change", guiLeft + 181, guiTop + 156, 181, 156, 7, 12, true));
		buttons.put("s_r", new BasicButton("sig_remove", guiLeft + 189, guiTop + 156, 189, 156, 7, 12, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.junction == null) return;
		crossing = container.junction.type.isCrossing();
		texts.get("switch0").string = container.junction.size() > 2 && !crossing ? "switch [0]: " + container.junction.switch0 : "inactive";
		texts.get("switch1").string = container.junction.size() > 3 && !crossing ? "switch [1]: " + container.junction.switch1 : "inactive";
		for(int i = 0; i < 4; i++){
			if(i != 0) buttons.get("up" + i).enabled = i > 0 && i < container.junction.size();
			if(i != 3) buttons.get("dw" + i).enabled = i + 1 < container.junction.size();
			buttons.get("del" + i).enabled = i < container.junction.size();
			texts.get("track" + i).string = i >= container.junction.size() ? "" : container.junction.tracks.get(i).end.asIDString();
		}
		String signal = new String();
		if(container.junction.signal == null) signal = container.junction.size() > 2 ? "inactive" : "no signal mode";
		else if(container.junction.signal_dir.isBoth()){
			signal = EntryDirection.BOTH.name() + " | S0: " + container.junction.signal0 + " | S1: " + container.junction.signal1;
		}
		else{
			signal = container.junction.signal_dir.name() + " | S0: " + container.junction.signal0;
		}
		texts.get("signal").string = signal;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(container.junction == null) return;
		this.drawTexturedModalRect(guiLeft + 76 + (container.junction.type.ordinal() * 18), guiTop + 21, 0, 238, 18, 18);
		if(container.junction.size() < 3 || crossing){
			this.drawTexturedModalRect(guiLeft + 203, guiTop + 41, 18, 244, 38, 12);
		}
		else{
			BLU.glColorApply();
			this.drawTexturedModalRect(guiLeft + 204, guiTop + 42, 204, 42, 10, 10);
			if(container.junction.type.isFork2() || container.junction.type.isDouble()){
				(container.junction.switch0 ? RED : GRE).glColorApply();
			}
			else if(container.junction.type.isFork3()){
				(container.junction.switch0 ? RED : container.junction.switch1 ? ORA : GRE).glColorApply();
			}
			this.drawTexturedModalRect(guiLeft + 230, guiTop + 42, 230, 42, 10, 10);
			RGB.glColorReset();
		}
		if(!container.junction.type.is4Track() || crossing){
			this.drawTexturedModalRect(guiLeft + 203, guiTop + 55, 18, 244, 38, 12);
		}
		else{
			(container.junction.type.isFork3() ? BLU : container.junction.switch0 ? RED : GRE).glColorApply();
			this.drawTexturedModalRect(guiLeft + 204, guiTop + 56, 204, 56, 10, 10);
			if(container.junction.type.isDouble()){
				(container.junction.switch1 ? BLU : ORA).glColorApply();
			}
			else if(container.junction.type.isFork3()){
				(container.junction.switch0 ? RED : container.junction.switch1 ? ORA : GRE).glColorApply();
			}
			this.drawTexturedModalRect(guiLeft + 230, guiTop + 56, 230, 56, 10, 10);
			RGB.glColorReset();
		}
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		if(container.junction == null) return;
		tooltip.clear();
		for(int i = 0; i < type.length; i++){
			if(!type[i].hovered) continue;
			tooltip.add(format("&9Junction Type: &7" + PathJuncType.values()[i].name()));
			if(i == container.junction.type.ordinal()) tooltip.add(format("&a&oCurrent type of this junction."));
		}
		for(int i = 0; i < 4; i++){
			if(i != 0 && buttons.get("up" + i).hovered) tooltip.add(format("&9Move track index &eup&9."));
			if(i != 3 && buttons.get("dw" + i).hovered) tooltip.add(format("&9Move track index &edown&9."));
			if(buttons.get("del" + i).hovered) tooltip.add(format("&eRemove track from junction."));
		}
		if(buttons.get("s_c").hovered) tooltip.add(format("&7Change signal mode/direction."));
		if(buttons.get("s_r").hovered) tooltip.add(format("&eRemove signal mode."));
		if(tooltip.size() > 0) drawHoveringText(tooltip, mouseX, mouseY);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("copy")){
			texts.get("title").string = "Position Copied to clipboard!";
			StringSelection selection = new StringSelection(container.junction.getVec316f().asIDString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
			return true;
		}
		else if(button.name.equals("s_del")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("station", "null");
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.equals("s_app")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("station", fields.get("station").getText());
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.equals("help")){
			GuiScreen parent = this;
			this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, "https://github.com/Fexcraft/FVTM/wiki/Junction", 31102009, true){
                @Override
                public void drawScreen(int mouseX, int mouseY, float partialTicks){
                    parent.drawScreen(-1, -1, partialTicks);
                    super.drawScreen(mouseX, mouseY, partialTicks);
                }
            });
			return true;
		}
		else if(button.name.equals("sig_change")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("signal", true);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.equals("sig_remove")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("signal", false);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		int i = -1;
		try{
			i = Integer.parseInt(button.name.replace("type", "").replace("dw", "").replace("up", "").replace("del", ""));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(button.name.startsWith("type")){
			if(i < 0 || i > 5) return false;
			switch(i){
				case 0:{ return true; }//skip, this type is automatic
				case 1:{ return true; }//skip, this type is semi-automatic
				case 2: case 3: case 4:{
					if(container.junction.size() < 4) return true;//only applicable to 4 track junctions
					NBTTagCompound compound = new NBTTagCompound();
					compound.setByte("type", (byte)i); this.container.send(Side.SERVER, compound);
					return true;
				}
				default: break;
			}
		}
		else if(button.name.startsWith("del")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setByte("del", (byte)i);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.startsWith("dw")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setByte("dw", (byte)i);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.startsWith("up")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setByte("up", (byte)i);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

