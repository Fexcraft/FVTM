package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraft extends GenericGui<GBlockCraftContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/block_craftscript.png");

	public GBlockCraft(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new GBlockCraftContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = false;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 216;
		container.init();
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 192, MapColor.SNOW.colorValue, "loading...."));
		texts.put("page", new BasicText(guiLeft + 203, guiTop + 6, 3028, MapColor.SNOW.colorValue, "0/pg"));
		texts.put("status", new BasicText(guiLeft + 9, guiTop + 19, 238, MapColor.SNOW.colorValue, "loading...."));
		texts.put("process", new BasicText(guiLeft + 9, guiTop + 33, 238, MapColor.SNOW.colorValue, "loading...."));
		buttons.put("prev", new BasicButton("prev", guiLeft + 233, guiTop + 6, 233, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 242, guiTop + 6, 242, 6, 8, 8, true));
		buttons.put("choose", new BasicButton("choose", guiLeft + 7, guiTop + 45, 7, 45, 120, 12, true));
		buttons.put("reset", new BasicButton("reset", guiLeft + 129, guiTop + 45, 129, 45, 120, 12, true));
		texts.put("choose", new BasicText(guiLeft + 10, guiTop + 47, 114, MapColor.SNOW.colorValue, "Choose Recipe"));
		texts.put("reset", new BasicText(guiLeft + 132, guiTop + 47, 114, MapColor.SNOW.colorValue, "Reset Recipe"));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.tile != null){
			texts.get("top").string = container.tile.getBlockData().getType().getName();
		}
		texts.get("status").string = "Current recipe: " + container.current;
		texts.get("process").string = container.script.getCooldown() > 0  ? "Cooldown/Paused (" + container.script.getCooldown() + ")" : container.current == null || container.current.equals("none") ? "Idle" : "Working/Processing.";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, 58);
		this.drawTexturedModalRect(guiLeft, guiTop + 58 + container.elements * 14, 0, 250, this.xSize, 6);
		int proc = container.script.getCooldown() > 0 || container.script.getProcessed() <= 0 || container.crafttime == 0 ? 0 : (container.script.getProcessed() * 100) / container.crafttime;
		if(proc > 0){
			RGB.GREEN.glColorApply();
			this.drawTexturedModalRect(guiLeft + 148, guiTop + 32, 148, 32, proc, 10);
			RGB.glColorReset();
		}
		
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){
			updatePage(-1);
			return true;
		}
		if(button.name.equals("next")){
			updatePage(1);
			return true;
		}
		if(button.name.equals("reset")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "reset_recipe");
			this.container.send(Side.SERVER, compound);
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? -1 : 1);
	}

	private void updatePage(int i){
		container.page += i;
		if(container.page < 0) container.page = 0;
		texts.get("page").string = (container.page + 1) + "/pg";
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "init");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}

}
