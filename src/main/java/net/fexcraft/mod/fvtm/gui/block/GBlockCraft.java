package net.fexcraft.mod.fvtm.gui.block;

import java.util.List;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript.GuiElement;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraft extends GenericGui<GBlockCraftContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/block_craftscript.png");
	public CraftBlockScript.GuiElement[] elements = {};
	public List<Object[]> elementdata;

	public GBlockCraft(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new GBlockCraftContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = false;
		container.gui = this;
		this.xSize = 256;
		this.ySize = 176;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 192, MapColor.SNOW.colorValue, "loading...."));
		texts.put("page", new BasicText(guiLeft + 203, guiTop + 6, 28, MapColor.SNOW.colorValue, "1/pg"));
		texts.put("status", new BasicText(guiLeft + 9, guiTop + 19, 238, MapColor.SNOW.colorValue, "loading...."));
		texts.put("process", new BasicText(guiLeft + 9, guiTop + 33, container.tickable ? 136 : 238, MapColor.SNOW.colorValue, ""));
		buttons.put("prev", new BasicButton("prev", guiLeft + 233, guiTop + 6, 233, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 242, guiTop + 6, 242, 6, 8, 8, true));
		buttons.put("choose", new BasicButton("choose", guiLeft + 7, guiTop + 45, 7, 45, 120, 12, true));
		buttons.put("reset", new BasicButton("reset", guiLeft + 129, guiTop + 45, 129, 45, 120, 12, true));
		texts.put("choose", new BasicText(guiLeft + 10, guiTop + 47, 114, MapColor.SNOW.colorValue, "Choose Recipe"));
		texts.put("reset", new BasicText(guiLeft + 132, guiTop + 47, 114, MapColor.SNOW.colorValue, container.tickable ? "Reset Recipe" : "Craft/Process"));
		initElements();
	}

	private void initElements(){
		texts.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		if(!container.tickable) return;
		//
		List<Object[]> elms = container.script.getGuiElements();
		if(elms == null || elms.isEmpty()){
			elements = new GuiElement[]{};
			elementdata = null;
			return;
		}
		elements = new CraftBlockScript.GuiElement[elms.size()];
		for(int i = 0; i < elms.size(); i++){
			Object[] objs = elms.get(i);
			elements[i] = (GuiElement)objs[0];
			switch(elements[i]){
				case BUTTONS:
					buttons.put("e_" + i, new BasicButton("e_" + i, guiLeft + 7, guiTop + 59 + (i * 14), 7, 45, 120, 12, true));
					texts.put("e_" + i, new BasicText(guiLeft + 10, guiTop + 61 + (i * 14), 114, MapColor.SNOW.colorValue, (String)objs[1]));
					if(objs.length > 3){
						buttons.put("e_" + i, new BasicButton("e_" + i, guiLeft + 129, guiTop + 59 + (i * 14), 7, 45, 120, 12, true));
						texts.put("e_" + i, new BasicText(guiLeft + 132, guiTop + 61 + (i * 14), 114, MapColor.SNOW.colorValue, (String)objs[3]));
					}
					break;
				case PROGRESS_BAR:
					texts.put("e_" + i, new BasicText(guiLeft + 9, guiTop + 61 + (i * 14), 136, MapColor.SNOW.colorValue, (String)objs[1]));
					texts.put("e_" + i + "v", new BasicText(guiLeft + 150, guiTop + 61 + (i * 14), 94, MapColor.SNOW.colorValue, "" + container.data.getInventory((String)objs[2]).getVarValue()));
					break;
				case TEXT:
					texts.put("e_" + i, new BasicText(guiLeft + 9, guiTop + 61 + (i * 14), 238, MapColor.SNOW.colorValue, (String)objs[1]));
					break;
				case TEXT_VALUE:
					texts.put("e_" + i, new BasicText(guiLeft + 9, guiTop + 61 + (i * 14), 238, MapColor.SNOW.colorValue, String.format((String)objs[1], container.data.getInventory((String)objs[2]).getVarValue())));
					break;
				default:
					break;
			}
		}
		elementdata = elms;
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.tile != null){
			texts.get("top").string = container.tile.getMultiBlockData().getType().getName();
		}
		texts.get("status").string = "Current recipe: " + container.current;
		if(container.tickable){
			texts.get("process").string = container.script.getCooldown() > 0  ? "Cooldown/Paused (" + container.script.getCooldown() + ")" : container.current == null || container.current.equals("none") ? "Idle" : "Working/Processing.";
		}
		else{
			texts.get("process").string = container.ntstatus == null ? "" : container.ntstatus.equals(GBlockCraftContainer.success) ? container.crafted + "x " + container.ntstatus : container.ntstatus;
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, 58);
		this.drawTexturedModalRect(guiLeft, guiTop + 58 + elements.length * 14, 0, 250, this.xSize, 6);
		if(!container.tickable){
			this.drawTexturedModalRect(guiLeft, guiTop + 30, 0, 16, this.xSize, 14);
		}
		else{
			int proc = container.script.getCooldown() > 0 || container.script.getProcessed() <= 0 || container.crafttime == 0 ? 0 : (container.script.getProcessed() * 100) / container.crafttime;
			if(proc > 0){
				RGB.GREEN.glColorApply();
				this.drawTexturedModalRect(guiLeft + 148, guiTop + 32, 148, 32, proc, 10);
				RGB.glColorReset();
			}
			for(int i = 0; i < elements.length; i++){
				int offset = i * 14;
				Object[] objs = elementdata.get(i);
				switch(elements[i]){
					case PROGRESS_BAR:{
						texts.get("e_" + i + "v").string = "" + container.data.getInventory((String)objs[2]).getVarValue();
						this.drawTexturedModalRect(guiLeft, guiTop + 58 + offset, 0, 30, this.xSize, 14);
						int max = (int)objs[3], val = container.data.getInventory((String)objs[2]).getVarValue();
						proc = max == 0 || val == 0 ? 0 : (val * 100) / max;
						if(proc > 0){
							(objs.length < 5 ? RGB.GREEN : (RGB)objs[4]).glColorApply();
							this.drawTexturedModalRect(guiLeft + 148, guiTop + 60 + offset, 148, 32, proc, 10);
							RGB.glColorReset();
						}
						break;
					}
					case TEXT_VALUE:
						texts.get("e_" + i).string = String.format((String)objs[1], container.data.getInventory((String)objs[2]).getVarValue());
					case TEXT:
						this.drawTexturedModalRect(guiLeft, guiTop + 58 + offset, 0, 16, this.xSize, 14);
						break;
					case BUTTONS:
						this.drawTexturedModalRect(guiLeft, guiTop + 58 + offset, 0, 44, this.xSize, 14);
						break;
					default:
						break;
				}
			}
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
		if(button.name.equals("choose")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "open_chooser");
			this.container.send(Side.SERVER, compound);
		}
		if(button.name.equals("reset")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", container.tickable ? "reset_recipe" : "craft_recipe");
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
		compound.setString("cargo", "page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}

}
