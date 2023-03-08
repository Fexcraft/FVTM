package net.fexcraft.mod.fvtm.gui.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.block.CraftBlockScript;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import scala.actors.threadpool.Arrays;

public class GBlockCraft extends GenericGui<GBlockCraftContainer> {

	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/block_craftscript.png");
	private List<Object[]> relms;
	private List<String> tips = new ArrayList<>();
	private AreaMap<List<String>> hoverables = new AreaMap<>();
	public Elm[] elements = {};
	private int footerdepth, maxelm = 12, off = 16;
	private boolean has_status, has_progress, has_choose, has_reset, has_recipe;

	public GBlockCraft(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new GBlockCraftContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = false;
		container.gui = this;
		xSize = 256;
		int pass = 0;
		boolean half = false;
		relms = container.script.getUIElements(container.tile.data, container.data);
		elements = new Elm[relms.size()];
		for(int i = 0; i < elements.length; i++) {
			elements[i] = new Elm();
			Object[] objs = relms.get(i);
			GBCElm elm = (GBCElm)objs[0];
			elements[i].elm = elm;
			elements[i].off = off;
			if(elm.full || half){
				off += elm.h;
				half = false;
				if (pass < maxelm) pass++;
				else if (pass < maxelm + 2) pass = maxelm + 2;
			}
			else half = true;
		}
		if(half) off += elements[elements.length - 1].elm.h;
		ySize = 39 + off;
		footerdepth = off;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 244, MapColor.SNOW.colorValue, "loading....").hoverable(true));
		texts.put("page", new BasicText(guiLeft + 175, guiTop + off + 6, 40, MapColor.BLACK.colorValue, "-/-").hoverable(true));
		buttons.put("prev", new BasicButton("prev", guiLeft + 219, guiTop + off + 2, 219, 122, 14, 14, true){
			@Override
			public boolean onclick(int x, int y, int b){
				updatePage(-1);
				return true;
			}
		});
		buttons.put("next", new BasicButton("next", guiLeft + 235, guiTop + off + 2, 235, 122, 14, 14, true){
			@Override
			public boolean onclick(int x, int y, int b){
				updatePage(1);
				return true;
			}
		});
		texts.get("top").string = container.tile.getMultiBlockData().getType().getName();
		initElements();
	}

	private void initElements(){
		texts.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		buttons.entrySet().removeIf(entry -> entry.getKey().startsWith("e_"));
		//if(!container.tickable) return;
		//
		for(int i = 0; i < elements.length; i++){
			Object[] objs = relms.get(i);
			GBCElm elm = (GBCElm)objs[0];
			String arg = objs.length > 1 ? objs[1].toString() : "";
			switch(elements[i].elm){
				case SPACER:
					break;
				case ITEMVIEW:
					int oy = elements[i].off + 2;
					for(int j = 0; j < 6; j++){
						int k = j * 18;
						hoverables.put(new Area(guiLeft + 130 + k, guiLeft + 130 + 16 + k, guiTop + oy, guiTop + oy + 16), new ArrayList<>());
					}
					elements[i].run = () -> {
						if(container.current != null && !container.current.equals("none")){
							CraftBlockScript.Recipe recipe = CraftBlockScript.RECIPE_REGISTRY.get(container.current);
							RenderHelper.enableGUIStandardItemLighting();
							OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
							GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
							for(int j = 0; j < 6; j++){
								List<String> a = hoverables.get(guiLeft + 130 + (j * 18), guiTop + oy);
								a.clear();
								if(recipe.getOutput().size() <= j) continue;
								if(!recipe.getOutput().get(j).getInventoryType().isItem()) continue;
								itemRender.renderItemAndEffectIntoGUI(recipe.getOutput().get(j).stack, guiLeft + 130 + (j * 18), guiTop + oy);
								recipe.getOutput().get(j).stack.getItem().addInformation(recipe.getOutput().get(j).stack, player.world, a, ITooltipFlag.TooltipFlags.NORMAL);
							}
							RenderHelper.disableStandardItemLighting();
							TexUtil.bindTexture(texture);
						}
					};
					break;
				case ELM_FULL_CLEAR:
				case ELM_LEFT_CLEAR:
				case ELM_RIGHT_CLEAR:
				case ELM_FULL_TEXT:
				case ELM_LEFT_TEXT:
				case ELM_RIGHT_TEXT:{
					if(arg == null || arg.length() == 0) break;
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
					texts.put(id == null ? "e_" + i : id, new BasicText(guiLeft + (elm.x > 0 ? elm.x + 3 : 9), guiTop + 3 + elements[i].off, w, MapColor.SNOW.colorValue, arg).autoscale().hoverable(true));
					if(id == null) texts.get("e_" + i).translate();
					break;
				}
				case ELM_LEFT_BUTTON:
				case ELM_RIGHT_BUTTON:
					int w = elm.full ? 238 : 116;
					arg = objs.length > 2 ? objs[2].toString() : "";
					String id = null;
					Runnable[] run = { null };
					if(arg.startsWith("#") && arg.endsWith("#")){
						switch(arg){
							case "#choose#":{
								has_choose = true;
								id = "choose";
								run[0] = () -> {
									NBTTagCompound compound = new NBTTagCompound();
									compound.setString("cargo", "open_chooser");
									this.container.send(Side.SERVER, compound);
								};
								break;
							}
							case "#reset#":{
								has_reset = true;
								id = "reset";
								run[0] = () -> {
									NBTTagCompound compound = new NBTTagCompound();
									compound.setString("cargo", container.tickable ? "reset_recipe" : "craft_recipe");
									this.container.send(Side.SERVER, compound);
								};
								break;
							}
						}
					}
					else if(arg.startsWith("@")){

					}
					texts.put(id == null ? "e_" + i : id, new BasicText(guiLeft + (elm.x > 0 ? elm.x + 4 : 10), guiTop + 3 + elements[i].off, w, MapColor.SNOW.colorValue, objs[1].toString()).autoscale().translate().hoverable(true));
					if(id == null) id = "e_" + i;
					int x = elm.x > 0 ? elm.x + 1 : 7, y = 1 + elements[i].off;
					buttons.put(id, new BasicButton(id, guiLeft + x, guiTop + y, elm.x + (elm.x > 0 ? 1 : 7), elm.y + 1, 120, 12, true){
						@Override
						public boolean onclick(int x, int y, int b){
							if(run[0] != null) run[0].run();
							return true;
						}
					});
					break;
				case ELM_LEFT_PROGRESS:
				case ELM_RIGHT_PROGRESS:
					if(arg == null || arg.length() == 0) break;
					RGB color = objs.length > 3 ? objs[3] instanceof RGB ? (RGB)objs[3] : new RGB((String)objs[3]) : RGB.GREEN;
					int ex = elm.x > 0 ? elm.x + 11 : 17, ey = 2 + elements[i].off;
					hoverables.put(new Area(guiLeft + ex, guiLeft + ex + 100, guiTop + ey, guiTop + ey + 10), Arrays.asList(new String[]{ "" }));
					if(arg.equals("#progress#")){
						elements[i].run = () -> {
							int proc = container.script.getCooldown() > 0 || container.script.getProcessed() <= 0 || container.crafttime == 0 ? 0 : (container.script.getProcessed() * 100) / container.crafttime;
							if(proc > 0){
								if(proc > 107) proc = 108;
								color.glColorApply();
								drawTexturedModalRect(guiLeft + ex, guiTop + ey, ex, elm.y + 2, proc, 10);
								RGB.glColorReset();
							}
							hoverables.get(guiLeft + ex, guiTop + ey).set(0, proc + "%");
						};
					}
					else{
						boolean auto = objs[2] instanceof String && objs[2].toString().equalsIgnoreCase("auto");
						InvHandler inv = container.data.getInventory((String)objs[1]);
						int max = auto ? inv.capacity() : (int)objs[2];
						elements[i].run = () -> {
							int val = inv.getVarValue();
							int proc = max == 0 || val == 0 ? 0 : (val * 100) / max;
							if(proc > 0){
								if(proc > 107) proc = 108;
								color.glColorApply();
								drawTexturedModalRect(guiLeft + ex, guiTop + ey, ex, elm.y + 2, proc, 10);
								RGB.glColorReset();
							}
							hoverables.get(guiLeft + ex, guiTop + ey).set(0, val + " / " + max);
						};
					}
					break;
			}
		}
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
	}

	private void drawElm(GBCElm elm, int yoff){
		drawTexturedModalRect(guiLeft + elm.x, guiTop + yoff, elm.x, elm.y, elm.full ? 256 : 128, elm.h);
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

	@Override
	public void drawlast(float ticks, int x, int y){
		tips.clear();
		for(Map.Entry<String, BasicText> text : texts.entrySet()){
			if(text.getValue().hovered){
				tips.add(text.getValue().string);
			}
		}
		for(Map.Entry<Area, List<String>> hov : hoverables.entrySet()){
			if(x >= hov.getKey().x && x <= hov.getKey().xe){
				if(y >= hov.getKey().y && y <= hov.getKey().ye){
					tips.addAll(hov.getValue());
				}
			}
		}
		if(tips.size() > 0) this.drawHoveringText(tips, x, y, fontRenderer);
	}

	private static class Area {

		public int x, xe, y, ye;

		public Area(int a, int ae, int b, int be){
			x = a;
			xe = ae;
			y = b;
			ye = be;
		}

	}

	private static class AreaMap<T> extends HashMap<Area, T>{

		public Entry<Area, T> get(int x, int xe, int y, int ye){
			for(Entry<Area, T> entry : entrySet()){
				Area a = entry.getKey();
				if(a.x == x && a.xe == xe && a.y == y && a.ye == ye) return entry;
			}
			return null;
		}

		public T get(int x, int y){
			for(Entry<Area, T> entry : entrySet()){
				Area a = entry.getKey();
				if(a.x == x && a.y == y) return entry.getValue();
			}
			return null;
		}

	}

}
