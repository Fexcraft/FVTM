package net.fexcraft.mod.fvtm.gui.wire;

import java.util.ArrayList;

import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class WireRelayChooser extends GenericGui<WireRelayContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/wire_relays.png");
	private static BasicButton[] b0 = new BasicButton[8], b1 = new BasicButton[8];
	private static BasicText[] t = new BasicText[8];
	private ArrayList<String> tooltip = new ArrayList<>();
	private static int scroll;
	private static boolean filter;
	private boolean filtered;
	private static ArrayList<String> conns = new ArrayList<>();

	public WireRelayChooser(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new WireRelayContainer(player, world, x, y, z, true), player);
		this.container.gui = this;
		this.defbackground = true;
		this.deftexrect = true;
		this.xSize = 200;
		this.ySize = 138;
	}

	@Override
	protected void init(){
		buttons.put("filter", new BasicButton("filter", guiLeft + 168, guiTop + 6, 168, 6, 8, 8, true));
		buttons.put("prev", new BasicButton("prev", guiLeft + 177, guiTop + 6, 177, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 186, guiTop + 6, 186, 6, 8, 8, true));
		texts.put("title", new BasicText(guiLeft + 7, guiTop + 6, 162, MapColor.SNOW.colorValue, "Wire Relay Management"));
		for(int i = 0; i < 8; i++){
			buttons.put("idx0" + i, b0[i] = new BasicButton("idx0" + i, guiLeft + 167, guiTop + 17 + (i * 14), 244, 244, 12, 12, true));
			buttons.put("idx1" + i, b1[i] = new BasicButton("idx1" + i, guiLeft + 181, guiTop + 17 + (i * 14), 244, 244, 12, 12, true));
			texts.put("idx" + i, t[i] = new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 154, MapColor.SNOW.colorValue, "..."));
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(!filtered) filter();
	}

	private void filter(){
		conns.clear();
		ArrayList<String> list = null;
		WireRelay relay = null;
		if(filter){
			for(String str : container.conns){
				list = container.data.types.get(str);
				if(list.isEmpty() || list.contains(container.type.getType())){
					conns.add(str);
				}
			}
		}
		else conns.addAll(container.conns);
		int l = 0;
		for(int i = 0; i < 8; i++){
			int j = i + scroll;
			if(j >= conns.size()){
				t[i].string = "";
				b0[i].tx = 244;
				b1[i].tx = 244;
			}
			else{
				t[i].string = conns.get(j);
				boolean pass = filtered;
				relay = container.holder.get(conns.get(j));
				if(!pass){
					list = container.data.types.get(conns.get(j));
					pass = list.isEmpty() || list.contains(container.type.getType());
				}
				if(pass){
					l = container.data.limits.get(t[i].string);
					if(relay.size() == 0){
						b0[i].tx = 202;
						b1[i].tx = 216;
					}
					else if(l == 0 || relay.size() < l){
						b0[i].tx = 202;
						b1[i].tx = 230;
					}
					else{
						b0[i].tx = 188;
						b1[i].tx = 230;
					}
				}
				else{
					b0[i].tx = 174;
					b1[i].tx = relay.size() > 0 ? 230 : 216;
				}
			}
		}
		filtered = true;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 8; i++){
			if(b0[i].tx > 174) continue;
			drawTexturedModalRect(guiLeft + 7, guiTop + 17 + (i * 14), 0, 244, 158, 12);
		}
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
		tooltip.clear();
		for(int i = 0; i < 8; i++){
			if(b0[i].hovered){
				if(b0[i].tx == 174){
					tooltip.add("invalid wire for this relay");
				}
				else if(b0[i].tx == 188){
					tooltip.add("relay reached wire limit");
				}
				else{
					tooltip.add("add wire to relay");
				}
			}
			if(b1[i].hovered){
				tooltip.add("open wire relay editor");
				if(b1[i].tx == 216) tooltip.add("(relay has no wires connected)");
			}
		}
		if(buttons.get("filter").hovered) tooltip.add(Formatter.format("filter: " + (filter ? "&aon" : "&coff")));
		if(tooltip.size() > 0) drawHoveringText(tooltip, mouseX, mouseY);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){
			scroll--;
			if(scroll < 0 ) scroll = 0;
			filtered = false;
		}
		else if(button.name.equals("next")){
			scroll++;
			filtered = false;
		}
		else if(button.name.startsWith("idx0")){
			if(button.tx == 188){
				Print.chat(player, "Relay reached wire limit.");
			}
			else if(button.tx == 174){
				Print.chat(player, "Wire not compatible with relay.");
			}
			else{
				NBTTagCompound com = new NBTTagCompound();
				com.setString("cargo", "connect");
				com.setString("id", conns.get(Integer.parseInt(button.name.substring(4)) + scroll));
				container.send(Side.SERVER, com);
			}
			return true;
		}
		else if(button.name.startsWith("idx1")){
			int i = Integer.parseInt(button.name.substring(4)) + scroll;
			WireRelayContainer.SELRELAY = container.conns.get(i);
			WireRelayContainer.WIRE = -1;
			NBTTagCompound com = new NBTTagCompound();
			com.setString("cargo", "open_editor");
			container.send(Side.SERVER, com);
		}
		else if(button.name.equals("filter")){
			filter = !filter;
			filtered = false;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? 1 : -1;
		if(scroll < 0) scroll = 0;
		filtered = false;
	}
	
}

