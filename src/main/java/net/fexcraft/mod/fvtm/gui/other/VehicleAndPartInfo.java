package net.fexcraft.mod.fvtm.gui.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.I19U;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class VehicleAndPartInfo extends GenericGui<VehicleAndPartInfoContainer>{
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_part_info.png");
	private boolean vehmode = true;
	private List<Addon> vehpacks, partpacks;
	private List<Vehicle> vehicles;
	private List<Part> parts;
	private List<String> etexts = new ArrayList<>();
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
		texts.put("pack", new BasicText(guiLeft + 9, guiTop + 23, 204, null, "...").translate().autoscale());
		texts.put("selected", new BasicText(guiLeft + 29, guiTop + 38, 186, null, "...").translate().autoscale());
		texts.put("selid", new BasicText(guiLeft + 29, guiTop + 46, 186, null, "...").translate().scale(0.75f));
		texts.put("mode", new BasicText(guiLeft + 9, guiTop + 61, 204, null, "...").translate().autoscale());
		for(int i = 0; i < 9; i++){
			texts.put("line" + i, new BasicText(guiLeft + 9, guiTop + 75 + (i * 14), 204, 0xf1f1f1, "...").translate().autoscale());
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
					if(vmode.ordinal() - 1 < 0) vmode = VehMode.REQUIRED;
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
					if(vmode.ordinal() + 1 >= VehMode.values().length - 1) vmode = VehMode.COMPATIBLE_ALL;
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
			buttons.put("entry" + i, new BasicButton("e" + i, guiLeft + 229, guiTop + 73 + (i * 14), 229, 216, 12, 12, true));
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
		for(Vehicle veh : Resources.VEHICLES){
			if(!vehpacks.contains(veh.getAddon())) vehpacks.add(veh.getAddon());
		}
		partpacks = new ArrayList<>();
		for(Part part : Resources.PARTS){
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
			vehicles = Resources.VEHICLES.stream().filter(veh -> veh.getAddon() == addon).collect(Collectors.toList());
			veh = vehicles.get(sel_idx = 0);
		}
		else{
			parts = Resources.PARTS.stream().filter(part -> part.getAddon() == addon).collect(Collectors.toList());
			part = parts.get(sel_idx = 0);
		}
		refmode();
	}

	protected void refmode(){
		if(vehmode) stack = (veh = vehicles.get(sel_idx)).newItemStack();
		else stack = (part = parts.get(sel_idx)).newItemStack();
		texts.get("mode").string = "gui.fvtm.vpinfo.mode." + (vehmode ? vmode : pmode).name().toLowerCase();
		if(selcat == null) texts.get("mode").translate();
		else texts.get("mode").translate(selcat);
		//
		etexts.clear();
		if(vehmode){
			switch(vmode){
			case REQUIRED:
				etexts.addAll(veh.getRequiredParts());
				break;
			case PRE_INSTALLED:
				veh.getPreInstalledParts().entrySet().forEach(entry -> {
					etexts.add(entry.getKey() + " (" + entry.getValue().toString() + ")");
				});
				break;
			case COMPATIBLE_ALL:
				etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.wait"));
				mc.addScheduledTask(() -> {
					VehicleData vdata = new VehicleData(veh);
					ArrayList<String> list = new ArrayList<>();
					for(Part part : Resources.PARTS){
						PartData data = new PartData(part);
						for(String str : part.getCategories()){
							if(part.getInstallationHandler().allowInstall(null, data, str, vdata)) list.add(part.getRegistryName() + " (" + str + ")");
						}
					}
					etexts.clear();
					etexts.addAll(list);
					if(etexts.isEmpty()) etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.none"));
				});
				break;
			case COMPATIBLE_SPECIFIC:
				etexts.add(I19U.trsc("gui.fvtm.vpinfo.line.wait"));
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
	
	private void refscroll(){
		if(scroll < 0) scroll = 0;
		for(int i = 0; i < 9; i++){
			int j = scroll + i;
			buttons.get("entry" + i).visible = j < etexts.size();
			texts.get("line" + i).string = j >= etexts.size() ? "" : etexts.get(j);
		}
		texts.get("scroll").string = scroll + "/" + (etexts.size() < 9 ? 0 : etexts.size() - 9);
	}

	@Override
	public void predraw(float ticks, int x, int y){
		texts.get("pack").string = addon.getName();
		texts.get("selected").string = vehmode ? veh.getName() : part.getName();
		texts.get("selid").string = (vehmode ? veh.getRegistryName() : part.getRegistryName()).toString();
	}
	
	@Override
	public void drawlast(float ticks, int x, int y){
		if(stack == null) return;
        RenderHelper.enableGUIStandardItemLighting();
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		itemRender.renderItemAndEffectIntoGUI(stack, guiLeft + 8, guiTop + 36);
        RenderHelper.disableStandardItemLighting();
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
		
	}
	
	public static enum PartMode {
		
		CATEGORIES, COMPATIBLE
		
	}

}
