package net.fexcraft.mod.fvtm.gui.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartInstallHandler;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.I19U;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class VehicleAndPartInfo extends GenericGui<VehicleAndPartInfoContainer>{
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_part_info.png");
	private static final String CAT_PRE = "# ", SUB_PRE = "  ";
	private boolean vehmode = true;
	private List<Addon> vehpacks, partpacks;
	private List<Vehicle> vehicles;
	private List<Part> parts;
	private List<String> etexts = new ArrayList<>();
	private List<String> itexts = new ArrayList<>();
	private List<String> tips = new ArrayList<>();
	private int pack_idx = 0, sel_idx = 0, scroll;
	private Addon addon;
	private Vehicle veh;
	private Part part;
	private VehMode vmode = VehMode.REQUIRED;
	private PartMode pmode = PartMode.CATEGORIES;
	private String selcat;
	private ItemStack stack = ItemStack.EMPTY;

	public VehicleAndPartInfo(EntityPlayer player){
		super(texture, new VehicleAndPartInfoContainer(player), player);
		xSize = 248;
		ySize = 215;
	}
	
	@Override
	public void init(){
		texts.put("title", new BasicText(guiLeft + 35, guiTop + 9, 204, 0xcdcdcd, "gui.fvtm.vpinfo.title_" + (vehmode ? "veh" : "part")).translate().autoscale());
		texts.put("pack", new BasicText(guiLeft + 9, guiTop + 23, 204, null, "...").translate().autoscale().hoverable(true));
		texts.put("selected", new BasicText(guiLeft + 29, guiTop + 38, 186, null, "...").translate().autoscale().hoverable(true));
		texts.put("selid", new BasicText(guiLeft + 29, guiTop + 46, 186, null, "...").translate().scale(0.75f).hoverable(true));
		texts.put("mode", new BasicText(guiLeft + 9, guiTop + 61, 204, null, "...").translate().autoscale());
		for(int i = 0; i < 9; i++){
			texts.put("line" + i, new BasicText(guiLeft + 9, guiTop + 75 + (i * 14), 204, MapColor.SNOW.colorValue, "...").translate().autoscale().hoverable(true));
		}
		texts.put("scroll", new BasicText(guiLeft + 151, guiTop + 200, 68, null, "0/0").translate().autoscale());
		buttons.put("vehmode", new BasicButton("vehmode", guiLeft + 7, guiTop + 7, 7, 7, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				switchmode(true);
				return true;
			}
		});
		buttons.put("partmode", new BasicButton("partmode", guiLeft + 20, guiTop + 7, 7, 20, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				switchmode(false);
				return true;
			}
		});
		buttons.put("pack_prev", new BasicButton("p_p", guiLeft + 216, guiTop + 21, 216, 21, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(--pack_idx < 0) pack_idx = (vehmode ? vehpacks : partpacks).size() - 1;
				refcontentlist();
				return true;
			}
		});
		buttons.put("pack_next", new BasicButton("p_n", guiLeft + 229, guiTop + 21, 229, 21, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(++pack_idx >= (vehmode ? vehpacks : partpacks).size()) pack_idx = 0;
				refcontentlist();
				return true;
			}
		});
		buttons.put("sel_prev", new BasicButton("s_p", guiLeft + 216, guiTop + 41, 216, 41, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(--sel_idx < 0) sel_idx = (vehmode ? vehicles : parts).size() - 1;
				refmode();
				return true;
			}
		});
		buttons.put("sel_next", new BasicButton("s_n", guiLeft + 229, guiTop + 41, 229, 41, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(++sel_idx >= (vehmode ? vehicles : parts).size()) sel_idx = 0;
				refmode();
				return true;
			}
		});
		buttons.put("mode_prev", new BasicButton("m_p", guiLeft + 216, guiTop + 59, 216, 59, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(vehmode){
					if(vmode.ordinal() - 1 < 0) vmode = VehMode.COMPATIBLE_ALL;
					else vmode = VehMode.values()[vmode.ordinal() - 1];
				}
				else{
					if(pmode.ordinal() - 1 < 0) pmode = PartMode.COMPATIBLE;
					else pmode = PartMode.values()[pmode.ordinal() - 1];
				}
				refmode();
				return true;
			}
		});
		buttons.put("mode_next", new BasicButton("m_n", guiLeft + 229, guiTop + 59, 229, 59, 12, 12, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(vehmode){
					if(vmode.ordinal() + 1 >= VehMode.values().length - 1) vmode = VehMode.REQUIRED;
					else vmode = VehMode.values()[vmode.ordinal() + 1];
				}
				else{
					if(pmode.ordinal() + 1 >= PartMode.values().length) pmode = PartMode.CATEGORIES;
					else pmode = PartMode.values()[pmode.ordinal() + 1];
				}
				refmode();
				return true;
			}
		});
		for(int i = 0; i < 9; i++){
			int j = i;
			buttons.put("entry" + i, new BasicButton("e" + i, guiLeft + 229, guiTop + 73 + (i * 14), 229, 216, 12, 12, true){
				@Override
				public boolean onclick(int x, int y, int m){
					if(vehmode){
						switch(vmode){
							case REQUIRED:
								vmode = VehMode.COMPATIBLE_SPECIFIC;
								selcat = etexts.get(j + scroll);
								refmode();
								break;
							case PRE_INSTALLED:
								Part pert = FvtmRegistry.PARTS.get(itexts.get(j + scroll));
								switchmode(false);
								pack_idx = partpacks.indexOf(pert.getAddon());
								refcontentlist();
								sel_idx = parts.indexOf(pert);
								refmode();
								break;
							case COMPATIBLE_ALL:
								String cat = etexts.get(j + scroll);
								if(cat.startsWith(CAT_PRE)){
									vmode = VehMode.COMPATIBLE_SPECIFIC;
									selcat = itexts.get(j + scroll);
									refmode();
								}
								else{
									Part part = FvtmRegistry.PARTS.get(itexts.get(j + scroll));
									switchmode(false);
									pack_idx = partpacks.indexOf(part.getAddon());
									refcontentlist();
									sel_idx = parts.indexOf(part);
									refmode();
								}
								break;
							case COMPATIBLE_SPECIFIC:
								Part part = FvtmRegistry.PARTS.get(itexts.get(j + scroll));
								switchmode(false);
								pack_idx = partpacks.indexOf(part.getAddon());
								refcontentlist();
								sel_idx = parts.indexOf(part);
								refmode();
								break;
							default: return false;
						}
					}
					else{
						if(pmode == PartMode.COMPATIBLE && !etexts.get(j + scroll).startsWith(CAT_PRE)){
							Vehicle veh = FvtmRegistry.VEHICLES.get(itexts.get(j + scroll));
							switchmode(true);
							pack_idx = vehpacks.indexOf(veh.getAddon());
							refcontentlist();
							sel_idx = vehicles.indexOf(veh);
							refmode();
						}
						else return false;
					}
					return true;
				}
			});
		}
		buttons.put("scroll_up", new BasicButton("s_u", guiLeft + 222, guiTop + 199, 222, 199, 9, 9, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(--scroll < 0) scroll = 0;
				refscroll();
				return true;
			}
		});
		buttons.put("scroll_dw", new BasicButton("s_d", guiLeft + 232, guiTop + 199, 232, 199, 9, 9, true){
			@Override
			public boolean onclick(int x, int y, int m){
				if(++scroll + 9 >= etexts.size()) scroll = etexts.size() - 9;
				refscroll();
				return true;
			}
		});
		buttons.put("item_hover", new BasicButton("i_h", guiLeft + 8, guiTop + 36, 8, 36, 16, 16, true));
		collectpacks();
		if(vehpacks.isEmpty()){
			Print.chat(player, I19U.trsc("gui.fvtm.vpinfo.no_vehicles"));
			player.closeScreen();
		}
		if(partpacks.isEmpty()){
			Print.chat(player, I19U.trsc("gui.fvtm.vpinfo.no_parts"));
			player.closeScreen();
		}
		refcontentlist();
	}

	private void collectpacks(){
		vehpacks = new ArrayList<>();
		for(Vehicle veh : FvtmRegistry.VEHICLES){
			if(!vehpacks.contains(veh.getAddon())) vehpacks.add(veh.getAddon());
		}
		partpacks = new ArrayList<>();
		for(Part part : FvtmRegistry.PARTS){
			if(!partpacks.contains(part.getAddon())) partpacks.add(part.getAddon());
		}
	}

	protected void switchmode(boolean to){
		vehmode = to;
		texts.get("title").string = "gui.fvtm.vpinfo.title_" + (vehmode ? "veh" : "part");
		texts.get("title").translate();
		refcontentlist();
	}

	protected void refcontentlist(){
		if(vehicles != null) vehicles.clear();
		if(parts != null) parts.clear();
		addon = (vehmode ? vehpacks : partpacks).get(pack_idx);
		if(vehmode){
			vehicles = FvtmRegistry.VEHICLES.stream().filter(veh -> veh.getAddon() == addon).collect(Collectors.toList());
			veh = vehicles.get(sel_idx = 0);
		}
		else{
			parts = FvtmRegistry.PARTS.stream().filter(part -> part.getAddon() == addon).collect(Collectors.toList());
			part = parts.get(sel_idx = 0);
		}
		refmode();
	}

	protected void refmode(){
		if(vehmode) stack = (veh = vehicles.get(sel_idx)).getNewStack().local();
		else stack = (part = parts.get(sel_idx)).getNewStack().local();
		texts.get("mode").string = "gui.fvtm.vpinfo.mode." + (vehmode ? vmode : pmode).name().toLowerCase();
		if(selcat == null || !vehmode || vmode != VehMode.COMPATIBLE_SPECIFIC) texts.get("mode").translate();
		else texts.get("mode").translate(selcat);
		//
		etexts.clear();
		itexts.clear();
		if(vehmode){
			switch(vmode){
			case REQUIRED:
				//TODO etexts.addAll(veh.getRequiredParts());
				//TODO replace with new required parts checks
				break;
			case PRE_INSTALLED:
				if(veh.getInstalled() == null) break;
				veh.getInstalled().entrySet().forEach(entry -> {
					etexts.add(entry.getKey());
					itexts.add(entry.getValue().toString());
				});
				break;
			case COMPATIBLE_ALL:
				etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.wait"));
				mc.addScheduledTask(() -> {
					VehicleData vdata = new VehicleData(veh);
					ArrayList<String> cats = new ArrayList<>();
					HashMap<String, ArrayList<String>> emap = new HashMap<>();
					HashMap<String, ArrayList<String>> imap = new HashMap<>();
					PartInstallHandler handler = null;
					boolean slot = false;
					for(Part part : FvtmRegistry.PARTS){
						slot = part.getInstallHandler() instanceof DefaultPartInstallHandler;
						PartData data = new PartData(part);
						cats.clear();
						//TODO fillcats(cats, veh.getRequiredParts(), part.getCategories());
						if(slot){
							for(String str : cats){
								if(vdata.hasPartSlot(str)) fillmap(emap, imap, str, part.getName(), part.getID());
							}
						}
						else{
							handler = part.getInstallHandler();
							for(String str : cats){
								if(handler.validInstall(null, data, str, vdata, false)) fillmap(emap, imap, str, part.getName(), part.getID());
							}
						}
					}
					etexts.clear();
					itexts.clear();
					emap.entrySet().forEach(entry -> {
						etexts.add(CAT_PRE + entry.getKey());
						entry.getValue().forEach(elm -> etexts.add(SUB_PRE + elm));
					});
					imap.entrySet().forEach(entry -> {
						itexts.add(entry.getKey());
						entry.getValue().forEach(elm -> itexts.add(elm));
					});
					if(etexts.isEmpty()) etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.none"));
				});
				break;
			case COMPATIBLE_SPECIFIC:
				etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.wait"));
				mc.addScheduledTask(() -> {
					VehicleData vdata = new VehicleData(veh);
					ArrayList<String> elist = new ArrayList<>();
					ArrayList<String> ilist = new ArrayList<>();
					PartInstallHandler handler = null;
					boolean slot = false;
					for(Part part : FvtmRegistry.PARTS){
						slot = part.getInstallHandler() instanceof DefaultPartInstallHandler;
						PartData data = new PartData(part);
						if(slot){
							if(vdata.hasPartSlot(selcat)){
								elist.add(part.getName());
								ilist.add(part.getIDS());
							}
						}
						else{
							handler = part.getInstallHandler();
							if(handler.validInstall(null, data, selcat, vdata, false)){
								elist.add(part.getName());
								ilist.add(part.getIDS());
							}
						}
					}
					etexts.clear();
					itexts.clear();
					elist.forEach(elm -> etexts.add(elm));
					ilist.forEach(elm -> itexts.add(elm));
					if(etexts.isEmpty()) etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.none"));
				});
				break;
			default:
				etexts.add("error.unknown.mode");
				break;
			}
		}
		else{
			switch(pmode){
			case CATEGORIES:
				etexts.addAll(part.getCategories());
				break;
			case COMPATIBLE:
				etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.wait"));
				mc.addScheduledTask(() -> {
					PartData data = new PartData(part);
					boolean slot = part.getInstallHandler() instanceof DefaultPartInstallHandler;
					HashMap<String, ArrayList<String>> emap = new HashMap<>();
					HashMap<String, ArrayList<String>> imap = new HashMap<>();
					PartInstallHandler handler = null;
					for(Vehicle veh : FvtmRegistry.VEHICLES){
						VehicleData vdata = new VehicleData(veh);
						if(slot){
							for(String cat : part.getCategories()){
								if(vdata.hasPartSlot(cat)) fillmap(emap, imap, cat, veh.getName(), veh.getID());
							}
						}
						else{
							handler = part.getInstallHandler();
							for(String cat : part.getCategories()){
								if(handler.validInstall(null, data, selcat, vdata, false)) fillmap(emap, imap, cat, veh.getName(), veh.getID());
							}
						}
					}
					etexts.clear();
					itexts.clear();
					emap.entrySet().forEach(entry -> {
						etexts.add(CAT_PRE + entry.getKey());
						entry.getValue().forEach(elm -> etexts.add(SUB_PRE + elm));
					});
					imap.entrySet().forEach(entry -> {
						itexts.add(entry.getKey());
						entry.getValue().forEach(elm -> itexts.add(elm));
					});
					if(etexts.isEmpty()) etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.none"));
				});
				break;
			default:
				etexts.add("error.unknown.mode");
				break;
			}
		}
		//
		scroll = 0;
		refscroll();
	}
	
	private void fillmap(HashMap<String, ArrayList<String>> emap, HashMap<String, ArrayList<String>> imap, String cat, String name, IDL regname){
		if(!emap.containsKey(cat)) emap.put(cat, new ArrayList<>());
		emap.get(cat).add(name);
		if(!imap.containsKey(cat)) imap.put(cat, new ArrayList<>());
		imap.get(cat).add(regname.colon());
		
	}

	private void fillcats(ArrayList<String> cats, ArrayList<String> list0, List<String> list1){
		for(String str : list0) if(!cats.contains(str)) cats.add(str);
		for(String str : list1) if(!cats.contains(str)) cats.add(str);
	}

	private void refscroll(){
		if(scroll < 0) scroll = 0;
		for(int i = 0; i < 9; i++){
			int j = scroll + i;
			boolean vis = j < etexts.size();
			if(vis && !vehmode){
				if(pmode == PartMode.CATEGORIES) vis = false;
				else vis = !etexts.get(j).startsWith(CAT_PRE);
			}
			buttons.get("entry" + i).visible = j < etexts.size() && (vehmode ? true : pmode != PartMode.CATEGORIES);
			texts.get("line" + i).string = j >= etexts.size() ? "" : etexts.get(j);
		}
		texts.get("scroll").string = scroll + "/" + (etexts.size() < 9 ? 0 : etexts.size() - 9);
	}

	@Override
	public void predraw(float ticks, int x, int y){
		texts.get("pack").string = addon.getName();
		texts.get("selected").string = vehmode ? veh.getName() : part.getName();
		texts.get("selid").string = vehmode ? veh.getIDS() : part.getIDS();
	}
	
	@Override
	public void drawlast(float ticks, int x, int y){
		if(stack == null) return;
		RenderHelper.enableGUIStandardItemLighting();
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		itemRender.renderItemAndEffectIntoGUI(stack, guiLeft + 8, guiTop + 36);
		RenderHelper.disableStandardItemLighting();
		tips.clear();
		for(Entry<String, BasicText> text : texts.entrySet()){
			if(text.getValue().hovered){
				boolean imode = vehmode ? vmode.hasinfotip() : pmode.hasinfotip();
				if(imode && text.getKey().startsWith("line")){
					int i = Integer.parseInt(text.getKey().substring(4));
					if(text.getValue().string.startsWith(SUB_PRE)) tips.add(text.getValue().string.substring(2));
					if(i < itexts.size()) tips.add(itexts.get(i + scroll));
				}
				else tips.add(text.getValue().string);
			}
		}
		if(buttons.get("item_hover").hovered){
			tips.addAll(stack.getTooltip(player, ITooltipFlag.TooltipFlags.NORMAL));
		}
		if(tips.size() > 0) this.drawHoveringText(tips, x, y, fontRenderer);
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll += am > 0 ? 1 : -1;
		if(scroll < 0) scroll = 0;
		if(scroll + 9 >= etexts.size()) scroll = etexts.size() - 9;
		refscroll();
	}
	
	public static enum VehMode {
		
		REQUIRED, PRE_INSTALLED, COMPATIBLE_ALL, COMPATIBLE_SPECIFIC;

		boolean hasinfotip(){
			return this != REQUIRED;
		}
		
	}
	
	public static enum PartMode {
		
		CATEGORIES, COMPATIBLE;

		boolean hasinfotip(){
			return this == COMPATIBLE;
		}
		
	}

}
