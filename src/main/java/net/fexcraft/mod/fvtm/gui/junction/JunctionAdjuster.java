package net.fexcraft.mod.fvtm.gui.junction;

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
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 230, MapColor.SNOW.colorValue, "Junction: " + container.junction.getVec316f().asIDString()));
		for(int i = 0; i < 5; i ++){
			buttons.put("type" + i, new BasicButton("type" + i, guiLeft + 7 + (i * 18), guiTop + 21, 7 + (i * 18), 21, 18, 18,
				i == 0 ? container.junction.size() <= 2 : i == 1 ? container.junction.size() == 3 : container.junction.size() == 4));
		}
		texts.put("type", new BasicText(guiLeft + 9, guiTop + 43, 230, MapColor.SNOW.colorValue, " . . . "));
		texts.put("signal", new BasicText(guiLeft + 9, guiTop + 57, 230, MapColor.SNOW.colorValue, " . . . "));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("type").string = "Current Type: " + container.junction.type.name();
		texts.get("signal").string = "Current Signal: " + (container.junction.signal == null ? "none" : container.junction.signal.name());
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		int i = -1; try{ i = Integer.parseInt(button.name.replace("type", "")); } catch(Exception e){ e.printStackTrace(); }
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
			default: return false;
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

