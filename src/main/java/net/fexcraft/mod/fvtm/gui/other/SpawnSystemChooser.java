package net.fexcraft.mod.fvtm.gui.other;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class SpawnSystemChooser extends GenericGui<SpawnSystemContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/spawn_system.png");
	private static int scroll;
	private boolean save;

	public SpawnSystemChooser(EntityPlayer player, int x, int y, int z){
		super(texture, new SpawnSystemContainer(player, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 194; this.ySize = 120;
	}

	@Override
	protected void init(){
		buttons.put("remember", new BasicButton("remember", guiLeft + 176, guiTop + 102, 176, 102, 10, 10, true));
		buttons.put("prev", new BasicButton("prev", guiLeft + 171, guiTop + 6, 171, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 180, guiTop + 6, 180, 6, 8, 8, true));
		texts.put("title", new BasicText(guiLeft + 7, guiTop + 6, 162, MapColor.SNOW.colorValue, "Select an Entity System"));
		texts.put("remember", new BasicText(guiLeft + 9, guiTop + 103, 162, null, "Remember choice?"));
		for(int i = 0; i < 6; i++){
			buttons.put("idx" + i, new BasicButton("idx" + i, guiLeft + 175, guiTop + 17 + (i * 14), 175, 17 + (i * 14), 12, 12, true));
			texts.put("idx" + i, new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 162, null, "loading..."));
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "init_data");
		this.container.send(Side.SERVER, compound);
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(save){
			this.drawTexturedModalRect(guiLeft + 176, guiTop + 102, 195, 102, 10, 10);
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("remember")){
			save = !save;
			return true;
		}
		else return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? -1 : 1;
	}
	
}

