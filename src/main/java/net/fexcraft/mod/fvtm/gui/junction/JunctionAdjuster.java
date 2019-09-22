package net.fexcraft.mod.fvtm.gui.junction;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class JunctionAdjuster extends GenericGui<JunctionAdjusterContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/junction_main.png");
	
	public JunctionAdjuster(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(texture, new JunctionAdjusterContainer(player, xyz, compound), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 192;
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 218, MapColor.SNOW.colorValue, "ID: " + container.junction.getVec316f().asIDString()));
		for(int i = 0; i < 5; i ++){
			buttons.put("type" + i, new BasicButton("type" + i, guiLeft + 7 + (i * 18), guiTop + 21, 7 + (i * 18), 21, 18, 18,
				i == 0 ? container.junction.size() <= 2 : i == 1 ? container.junction.size() == 3 : container.junction.size() == 4));
		}
		texts.put("type", new BasicText(guiLeft + 9, guiTop + 43, 230, MapColor.SNOW.colorValue, " . . . "));
		texts.put("signal", new BasicText(guiLeft + 9, guiTop + 57, 230, MapColor.SNOW.colorValue, " . . . "));
		for(int i = 0; i < 7; i ++){
			buttons.put("command" + i, new BasicButton("command" + i, guiLeft + 7 + (i * 18), guiTop + 167, 7 + (i * 18), 167, 18, 18, true));
		}
		buttons.put("copy", new BasicButton("copy", guiLeft + 229, guiTop + 7, 229, 7, 12, 12, true));
		fields.put("station", new TextField(0, fontRenderer, guiLeft + 7, guiTop + 69, 207, 12));
		fields.get("station").setText(container.junction.station == null ? "no station" : container.junction.station);
		for(int i = 0; i < 4; i++){ int j =  + (i * 14);
			texts.put("track" + i, new BasicText(guiLeft + 9, guiTop + 92 + j, 191, MapColor.SNOW.colorValue, ""));
			buttons.put("del" + i, new BasicButton("del" + i, guiLeft + 229, guiTop + 90 + j, 229, 90 + j, 12, 12, true));
			if(i != 3) buttons.put("dw" + i, new BasicButton("dw" + i, guiLeft + 216, guiTop + 90 + j, 216, 90 + j, 12, 12, true));
			if(i != 0) buttons.put("up" + i, new BasicButton("up" + i, guiLeft + 203, guiTop + 90 + j, 203, 90 + j, 12, 12, true));
		}
		buttons.put("s_del", new BasicButton("s_del", guiLeft + 229, guiTop + 69, 229, 69, 12, 12, true));
		buttons.put("s_app", new BasicButton("s_app", guiLeft + 216, guiTop + 69, 216, 69, 12, 12, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("type").string = "Current Type: " + container.junction.type.name();
		texts.get("signal").string = "Current Signal: " + (!container.junction.type.isStraight() ? "not available"
			: container.junction.signal == null ? "none" : container.junction.signal.name());
		for(int i = 0; i < 4; i++){
			buttons.get("del" + i).enabled = i < container.junction.size();;
			if(i != 3) buttons.get("dw" + i).enabled = i + 1 < container.junction.size();
			if(i != 0) buttons.get("up" + i).enabled = i > 0 && i < container.junction.size();
			texts.get("track" + i).string = i >= container.junction.size() ? "" :  i + "| " + container.junction.tracks.get(i).end.asIDString();
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
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
			NBTTagCompound compound = new NBTTagCompound(); compound.setString("station", "null");
			this.container.send(Side.SERVER, compound); return true;
		}
		else if(button.name.equals("s_app")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("station", fields.get("station").getText());
			this.container.send(Side.SERVER, compound); return true;
		}
		int i = -1; try{ i = Integer.parseInt(button.name.replace("type", "").replace("command", "").replace("dw", "")
			.replace("up", "").replace("del", "")); } catch(Exception e){ e.printStackTrace(); }
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
		else if(button.name.startsWith("command")){
			if(i < 0 || i > 7) return false;
			switch(i){
				//TODO
				default: break;
			}
		}
		else if(button.name.startsWith("del")){
			NBTTagCompound compound = new NBTTagCompound(); compound.setByte("del", (byte)i);
			this.container.send(Side.SERVER, compound); return true;
		}
		else if(button.name.startsWith("dw")){
			NBTTagCompound compound = new NBTTagCompound(); compound.setByte("dw", (byte)i);
			this.container.send(Side.SERVER, compound); return true;
		}
		else if(button.name.startsWith("up")){
			NBTTagCompound compound = new NBTTagCompound(); compound.setByte("up", (byte)i);
			this.container.send(Side.SERVER, compound); return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

