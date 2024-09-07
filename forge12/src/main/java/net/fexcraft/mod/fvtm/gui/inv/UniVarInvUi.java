package net.fexcraft.mod.fvtm.gui.inv;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class UniVarInvUi extends GenericGui<UniVarInvContainer> {

	private static final ResourceLocation texture_fluid = new ResourceLocation("fvtm:textures/gui/inventory_variable.png");
	private float percent;

	public UniVarInvUi(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(texture_fluid, new UniVarInvContainer(player, world, ID, x, y, z), player);
		defbackground = deftexrect = true;
		this.xSize = 176; this.ySize = 152;
		container.gui = this;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, container.title).autoscale());
		texts.put("info", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "[var info]").autoscale());
		texts.put("info2", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "[info]").autoscale());
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("info").string = container.invhandler.content_id() + " [" + container.invhandler.container_cat() + "]";
		texts.get("info2").string = (int)(percent = (container.invhandler.getVarValue() * 1f / container.invhandler.capacity()) * 100) + "%";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(percent > 0) drawTexturedModalRect(guiLeft + 65, guiTop + 36, 0, 246, percent > 100 ? 100 : (int)percent, 10);
		int w = (container.invhandler.items() * -18 / 2) + 9;
		for(int i = 0; i < container.invhandler.items(); i++){
			drawTexturedModalRect(guiLeft + 79 + w + (i * 18), guiTop + 50, 177, 50, 18, 18);
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

