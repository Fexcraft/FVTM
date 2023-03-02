package net.fexcraft.mod.fvtm.gui.block;

import java.util.List;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockCraft extends GenericGui<GBlockCraftContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/block_craftscript.png");
	private List<Object[]> relms;
	public Elm[] elements = {};
	private int footerdepth;
	private boolean has_status, has_progress, has_choose, has_reset, has_recipe;

	public GBlockCraft(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new GBlockCraftContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = false;
		container.gui = this;
		this.xSize = 256;
		relms = container.script.getUIElements();
		this.ySize = 39 + (8 * 14);
		boolean iv = false;
		for(Object[] elm : relms) if(elm[0] == GBCElm.ITEMVIEW){ iv = true; break;}
		if(iv) ySize += GBCElm.ITEMVIEW.h;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 244, MapColor.SNOW.colorValue, "loading...."));
		texts.put("page", new BasicText(guiLeft + 175, guiTop, 40, MapColor.BLACK.colorValue, "-/-"));
		buttons.put("prev", new BasicButton("prev", guiLeft + 219, guiTop, 219, 122, 14, 14, true));
		buttons.put("next", new BasicButton("next", guiLeft + 235, guiTop, 235, 122, 14, 14, true));
		//buttons.put("choose", new BasicButton("choose", guiLeft + 7, guiTop + 45, 7, 45, 120, 12, true));
		//buttons.put("reset", new BasicButton("reset", guiLeft + 129, guiTop + 45, 129, 45, 120, 12, true));
		//texts.put("choose", new BasicText(guiLeft + 10, guiTop + 47, 114, MapColor.SNOW.colorValue, "Choose Recipe"));
		//texts.put("reset", new BasicText(guiLeft + 132, guiTop + 47, 114, MapColor.SNOW.colorValue, container.tickable ? "Reset Recipe" : "Craft/Process"));
		texts.get("top").string = container.tile.getMultiBlockData().getType().getName();
		initElements();
	}

	private void initElements(){
		texts.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		//if(!container.tickable) return;
		//
		boolean half = false;
		int off = 16, pass = 0;
		elements = new Elm[relms.size()];
		for(int i = 0; i < elements.length; i++){
			Object[] objs = relms.get(i);
			elements[i] = new Elm();
			GBCElm elm = (GBCElm)objs[0];
			elements[i].elm = elm;
			elements[i].off = off;
			if(elm.full || half){
				off += elm.h;
				half = false;
				if(pass < 8) pass++;
				else if(pass < 10) pass = 10;
			}
			else half = true;
			String arg = objs.length > 1 ? objs[1].toString() : null;
			switch(elements[i].elm){
				/*case BUTTONS:
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
					break;*/
				case SPACER:
					break;
				case ITEMVIEW:
					break;
				case ELM_FULL_CLEAR:
				case ELM_LEFT_CLEAR:
				case ELM_RIGHT_CLEAR:
				case ELM_FULL_TEXT:
				case ELM_LEFT_TEXT:
				case ELM_RIGHT_TEXT:{
					int w = elm.full ? 238 : 116;
					String id = null;
					if(arg.startsWith("#") && arg.endsWith("#")){
						switch(arg){
							case "#status#":{
								has_status = true;
								id = "status";
								break;
							}
							case "#recipe#":{
								has_recipe = true;
								id = "recipe";
								break;
							}
						}
					}
					else if(arg.startsWith("@")){

					}
					texts.put(id == null ? "e_" + i : id, new BasicText(guiLeft + 9 + elm.x, guiTop + 3 + elements[i].off, w, MapColor.SNOW.colorValue, arg).autoscale());
					if(id == null) texts.get("e_" + i).translate();
					break;
				}
				case ELM_TWO_BUTTONS:
					break;
				case ELM_LEFT_BUTTON:
					break;
				case ELM_RIGHT_BUTTON:
					break;
				case ELM_TWO_PROGRESS:
					break;
				case ELM_LEFT_PROGRESS:
					break;
				case ELM_RIGHT_PROGRESS:
					break;
			}
		}
		if(half) off += elements[elements.length - 1].elm.h;
		footerdepth = off;
		texts.get("page").y = guiTop + off + 6;
		buttons.get("prev").y = guiTop + off + 2;
		buttons.get("next").y = guiTop + off + 2;
	}

	public static class Elm {

		protected GBCElm elm;
		protected Runnable run;
		protected int off;

	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(has_recipe){
			texts.get("recipe").string = container.current;
		}
		if(has_status){
			if(container.tickable){
				texts.get("status").string = container.script.getCooldown() > 0  ? "Cooldown/Paused (" + container.script.getCooldown() + ")" : container.current == null || container.current.equals("none") ? "Idle" : "Working/Processing.";
			}
			else{
				texts.get("status").string = container.ntstatus == null ? "" : container.ntstatus.equals(GBlockCraftContainer.success) ? container.crafted + "x " + container.ntstatus : container.ntstatus;
			}
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		drawElm(GBCElm.HEAD, 0);
		for(Elm elm : elements){
			drawElm(elm.elm, elm.off);
			if(elm.run != null) elm.run.run();
		}
		drawElm(GBCElm.FOOTER, elements.length == 0 ? 16 : footerdepth);
		/*this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, 58);
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
		}*/
	}

	private void drawElm(GBCElm elm, int yoff){
		drawTexturedModalRect(guiLeft + elm.x, guiTop + yoff, elm.x, elm.y, elm.full ? 256 : 128, elm.h);
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
