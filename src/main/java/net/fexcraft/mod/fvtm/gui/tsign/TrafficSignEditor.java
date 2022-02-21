package net.fexcraft.mod.fvtm.gui.tsign;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.BACKGROUNDS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.COMPONENTS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.FONTS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.LIBRARIES;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.PRESETS;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.gui.constructor.ConstructorVP;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.BaseData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.CompDataRoot;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.ComponentData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.ComponentType;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.FontData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.Library;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class TrafficSignEditor extends GenericGui<TrafficSignEditorContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/traffic_sign_editor.png");
	private static float scale = 64f;
	private static TrafficSignEditor ris;
	//
	private TSEButton prev, next, search;
	private TSEButton lup, ldw, rup, rdw;
	private TSEButton zoom_in, zoom_out;
	private TSEButton cm_b, cm_c, cm_f, cm_p;
	private TSEButton c_up, c_dw, c_lr, c_rg;
	private TSEButton cancel, confirm;
	private TSEButton[] llist = new TSEButton[15];
	private TSEButton[] rlist = new TSEButton[15];
	private TSEButton[] rlistR = new TSEButton[15];
	private TSEButton[] rlistC = new TSEButton[15];
	private TSEButton[] rlistE = new TSEButton[15];
	private TSEButton[] colorchannels = new TSEButton[9];
	private TSEButton rgb_confirm, hex_confirm;
	private TSEButton[] tabclose = new TSEButton[2];
	private TSEButton[] editorconfirm = new TSEButton[6];
	private ConstructorVP.Spectrum spectrum;
	private ConstructorVP.Palette palette;
	private BasicText title;
	private BasicText[] lList = new BasicText[15];
	private BasicText[] rList = new BasicText[15];
	private BasicText[] editor = new BasicText[5];
	private TextField rgb_field, hex_field;
	private TextField font, rot, zpos, xpos, ypos, scal;
	private RGB current_color = RGB.BLUE;
	private TabMode tabmode = TabMode.LIST;
	private ComponentMode commode = ComponentMode.BACKGROUND;
	private static int pack_scroll = -1, left_scroll, right_scroll, right_selected = -1, channel_selected;
	private int cam_scroll_x, cam_scroll_y;
	private ArrayList<Library> libraries = new ArrayList<>();
	private ArrayList<String> leftlist = new ArrayList<>(), rightlist = new ArrayList<>();;
	private Library selectedlib;
	private boolean nolibs;
	private TrafficSignData data;
	private TrafficSignEntity entity;
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public TrafficSignEditor(EntityPlayer player, int x, int y, int z){
		super(texture, new TrafficSignEditorContainer(player, x, y, z), player);
		this.deftexrect = false;
		this.defbackground = false;
		this.xSize = 256;
		this.ySize = 206;
		entity = (TrafficSignEntity)player.world.getEntityByID(x);
		data = player.world.getChunk(player.chunkCoordX, player.chunkCoordZ).getCapability(Capabilities.TRAFFIC_SIGNS, null).getSign(entity.getPosition(), true);
		ris = this;
	}
	
	@Override
	protected void init(){
		int black = MapColor.BLACK.colorIndex;
		//int lightgray = MapColor.SILVER.colorValue;
		int darkgray = MapColor.GRAY.colorValue;
		TrafficSignEditor gui = this;
		libraries.addAll(LIBRARIES.values());
		nolibs = libraries.size() == 0;
		buttons.put("prev", prev = new TSEButton("prev", guiLeft + 7, guiTop + 7, 135, 7, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				packscroll(-1);
				return true;
			}
		});
		buttons.put("next", next = new TSEButton("next", guiLeft + 237, guiTop + 7, 365, 7, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				packscroll(1);
				return true;
			}
		});
		buttons.put("search", search = new TSEButton("search", guiLeft + 21, guiTop + 7, 149, 7, 12, 12, true));
		fields.put("search", new TextField(0, fontRenderer, guiLeft + 34, guiTop + 8, 200, 10, true));
		texts.put("title", title = new BasicText(guiLeft + 35, guiTop + 9, 198, black, "< selected title here >", true, black){
			public boolean scrollwheel(int a, int x, int y){
				packscroll(-a);
				return true;
			}
		}.autoscale());
		fields.get("search").setEnabled(false);
		fields.get("search").setVisible(false);
		//
		buttons.put("lup", lup = new TSEButton("lup", guiLeft - 96, guiTop + 201, 32, 201, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				updateleftlist(-1);
				return true;
			}
		});
		buttons.put("ldw", ldw = new TSEButton("ldw", guiLeft - 84, guiTop + 201, 44, 201, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				updateleftlist(1);
				return true;
			}
		});
		buttons.put("rup", rup = new TSEButton("rup", guiLeft + 330, guiTop + 201, 458, 201, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				updaterightlist(-1);
				return true;
			}
		});
		buttons.put("rdw", rdw = new TSEButton("rdw", guiLeft + 342, guiTop + 201, 470, 201, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				updaterightlist(1);
				return true;
			}
		});
		//
		buttons.put("zoom_in", zoom_in = new TSEButton("z+", guiLeft + 18, guiTop + 203, 146, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				scale *= 2f;
				if(scale > 1024) scale = 1024;
				return true;
			}
		});
		buttons.put("zoom_out", zoom_out = new TSEButton("z-", guiLeft + 31, guiTop + 203, 159, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				scale *= 0.5f;
				if(scale < 1) scale = 1;
				return true;
			}
		});
		buttons.put("confirm", confirm = new TSEButton("confirm", guiLeft + 226, guiTop + 203, 354, 203, 12, 12, true));
		buttons.put("cancel", cancel = new TSEButton("cancel", guiLeft + 213, guiTop + 203, 341, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				player.closeScreen();
				return true;
			}
		});
		//
		buttons.put("cm_b", cm_b = new TSEButton("cmb", guiLeft + 102, guiTop + 203, 230, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				(commode = ComponentMode.BACKGROUND).apply(gui);
				return true;
			}
		});
		buttons.put("cm_c", cm_c = new TSEButton("cmc", guiLeft + 115, guiTop + 203, 243, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				(commode = ComponentMode.COMPONENT).apply(gui);
				return true;
			}
		});
		buttons.put("cm_f", cm_f = new TSEButton("cmf", guiLeft + 128, guiTop + 203, 256, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				(commode = ComponentMode.FONT).apply(gui);
				return true;
			}
		});
		buttons.put("cm_p", cm_p = new TSEButton("cmp", guiLeft + 141, guiTop + 203, 269, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				(commode = ComponentMode.PRESET).apply(gui);
				return true;
			}
		});
		//
		buttons.put("c_up", c_up = new TSEButton("cup", guiLeft + 44, guiTop + 203, 172, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				cam_scroll_y--;
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				cam_scroll_y += a;
				return true;
			}
		});
		buttons.put("c_dw", c_dw = new TSEButton("cdw", guiLeft + 57, guiTop + 203, 185, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				cam_scroll_y++;
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				cam_scroll_y += a;
				return true;
			}
		});
		buttons.put("c_lr", c_lr = new TSEButton("clr", guiLeft + 70, guiTop + 203, 198, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				cam_scroll_x--;
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				cam_scroll_x += a;
				return true;
			}
		});
		buttons.put("c_rg", c_rg = new TSEButton("crg", guiLeft + 83, guiTop + 203, 211, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				cam_scroll_x++;
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				cam_scroll_x += a;
				return true;
			}
		});
		//
		for(int i = 0; i < 15; i++){
			int I = i;
			buttons.put("list_r_" + i, rlist[i] = new TSEButton("lr" + i, guiLeft + 251, guiTop + 21 + i * 12, 379, 21 + i * 12, 110, 10, true){
				public boolean onclick(int x, int y, int b){
					right_selected = I + right_scroll;
					if(rlistR[I].hovered(x, y)){
						if(right_selected < 0) return true;
						switch(commode){
							case BACKGROUND:
								if(right_selected < data.backgrounds.size()) data.backgrounds.remove(right_selected);
								break;
							case COMPONENT:
								if(right_selected < data.components.size()) data.components.remove(right_selected);
								break;
							case FONT:
								if(right_selected < data.fonts.size()) data.fonts.remove(right_selected);
								break;
							default:
								break;
						}
						right_selected = -1;
						updaterightlist();
					}
					else if(rlistC[I].hovered(x, y)){
						(tabmode = TabMode.COLOR).apply(gui);
					}
					else if(rlistE[I].hovered(x, y)){
						(tabmode = TabMode.EDIT).apply(gui);
					}
					else{
						//
					}
					setcolor(null);
					updateeditor();
					return true;
				}
			});
			texts.put("list_r_" + i, rList[i] = new BasicText(guiLeft + 253, guiTop + 23 + i * 12, 106, darkgray, "R" + i).autoscale());
			rlist[i].rgb_hover = TSEButton.light;
			//
			buttons.put("lrr_" + i, rlistR[i] = new TSEButton("lrr" + i, guiLeft + 334, guiTop + 22 + i * 12, 462, 4, 8, 8, true));
			buttons.put("lrc_" + i, rlistC[i] = new TSEButton("lrc" + i, guiLeft + 343, guiTop + 22 + i * 12, 471, 4, 8, 8, true));
			buttons.put("lre_" + i, rlistE[i] = new TSEButton("lre" + i, guiLeft + 352, guiTop + 22 + i * 12, 480, 4, 8, 8, true));
			rlistR[i].visible = rlistC[i].visible = rlistE[i].visible = false;
			//
			buttons.put("list_l_" + i, llist[i] = new TSEButton("ll" + i, guiLeft - 105, guiTop + 21 + i * 12, 0, 334 + i * 12, 110, 10, true){
				public boolean onclick(int x, int y, int b){
					addComponent(I);
					return true;
				}
			});
			texts.put("list_l_" + i, lList[i] = new BasicText(guiLeft - 103, guiTop + 23 + i * 12, 106, darkgray, "L" + i).autoscale());
		}
		//
		for(int i = 0; i < 9; i++){
			int I = i;
			buttons.put("color_channel" + i, colorchannels[i] = new TSEButton("cc" + i, guiLeft - 95 + i * 10, guiTop + 137, 122 + i * 10, 450, 10, 10, true){
				public void draw(GenericGui<?> g, float pticks, int mouseX, int mouseY){
					if(!visible) return;
					rgb = hovered || channel_selected == I? rgb_hover : rgb_none;
					RGB.glColorReset();
		            rgb.glColorApply();
		            ris.drawRect(x, y, tx, ty, sizex, sizey);
		            RGB.glColorReset();
				}
				public boolean onclick(int x, int y, int b){
					channel_selected = I;
					setcolor(null);
					return true;
				}
			});
		}
		buttons.put("rgb_confirm", rgb_confirm = new TSEButton("rgbconfirm", guiLeft - 6, guiTop + 158, 211, 471, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				try{
					String[] str = rgb_field.getText().trim().replace(" ", "").split(",");
					setcolor(new RGB(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return true;
			}
		});
		buttons.put("hex_confirm", hex_confirm = new TSEButton("hexconfirm", guiLeft - 6, guiTop + 178, 211, 491, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				try{
					setcolor(new RGB(hex_field.getText()));
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return true;
			}
		});
		fields.put("rgb_field", rgb_field = new TextField(1, fontRenderer, guiLeft - 103, guiTop + 159, 95, 8, false));
		fields.put("hex_field", hex_field = new TextField(2, fontRenderer, guiLeft - 103, guiTop + 179, 95, 8, false));
		buttons.put("tab_close_color", tabclose[0] = new TSEButton("tbcl0", guiLeft - 3, guiTop + 191, 214, 504, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				(gui.tabmode = TabMode.LIST).apply(gui);
				return true;
			}
		});
		buttons.put("spectrum", spectrum = new ConstructorVP.Spectrum(guiLeft - 105, guiTop + 125, 110, 10, 55){
			public boolean onclick(int x, int y, int b){
				setcolor(getColorAt(x));
				return true;
			}
		});
		buttons.put("palette", palette = new ConstructorVP.Palette(guiLeft - 100, guiTop + 23, 10, 10, 10, 10){
			public boolean onclick(int x, int y, int b){
				setcolor(getColorAt(x, y));
				return true;
			}
		});
		//
		texts.put("font_text", editor[0] = new BasicText(guiLeft - 103, guiTop + 23, 106, darkgray, I18n.format("gui.fvtm.trafficsigneditor.tab_editor.font_text")));
		texts.put("sign_sides", editor[1] = new BasicText(guiLeft - 103, guiTop + 51, 106, darkgray, I18n.format("gui.fvtm.trafficsigneditor.tab_editor.sign_sides")));
		texts.put("position", editor[2] = new BasicText(guiLeft - 103, guiTop + 109, 106, darkgray, I18n.format("gui.fvtm.trafficsigneditor.tab_editor.position")));
		texts.put("rotation", editor[3] = new BasicText(guiLeft - 103, guiTop + 137, 106, darkgray, I18n.format("gui.fvtm.trafficsigneditor.tab_editor.rotation")));
		texts.put("scale", editor[4] = new BasicText(guiLeft - 103, guiTop + 165, 106, darkgray, I18n.format("gui.fvtm.trafficsigneditor.tab_editor.scale")));
		buttons.put("fonttext", editorconfirm[0] = new TSEButton("fonttext", guiLeft - 6, guiTop + 36, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				if(!gui.commode.font()) return true;
				FontData comp = (FontData)data.getCompData(commode.toType(), right_selected);
				comp.text(font.getText());
				return true;
			}
		});
		buttons.put("xpos", editorconfirm[3] = new TSEButton("xpos", guiLeft - 62, guiTop + 122, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.xoff = xpos.getValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.xoff -= a;
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("ypos", editorconfirm[4] = new TSEButton("ypos", guiLeft - 6, guiTop + 122, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.yoff = ypos.getValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.yoff -= a;
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("rot", editorconfirm[1] = new TSEButton("rot", guiLeft - 62, guiTop + 150, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					int val = rot.getIntegerValue();
					if(val < -180) val = -180;
					if(val > 180) val = 180;
					comp.rotation = val;
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					int val = rot.getIntegerValue() - a;
					if(val < -180) val = -180;
					if(val > 180) val = 180;
					comp.rotation = val;
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("zpos", editorconfirm[2] = new TSEButton("zpos", guiLeft - 6, guiTop + 150, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.zoff = zpos.getIntegerValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.zoff -= a;
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("scale", editorconfirm[5] = new TSEButton("scale", guiLeft - 62, guiTop + 178, 323, 349, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale = scal.getValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale -= a * sixteenth;
					updateeditor();
				}
				return true;
			}
		});
		fields.put("font", font = new TextField(3, fontRenderer, guiLeft - 103, guiTop + 37, 95, 8, false));
		fields.put("xpos", xpos = new NumberField(6, fontRenderer, guiLeft - 103, guiTop + 123, 39, 8, false));
		fields.put("ypos", ypos = new NumberField(7, fontRenderer, guiLeft - 47, guiTop + 123, 39, 8, false));
		fields.put("rot", rot = new NumberField(4, fontRenderer, guiLeft - 103, guiTop + 151, 39, 8, false));
		fields.put("zpos", zpos = new NumberField(5, fontRenderer, guiLeft - 47, guiTop + 151, 39, 8, false));
		fields.put("scale", scal = new NumberField(8, fontRenderer, guiLeft - 103, guiTop + 179, 39, 8, false));
		buttons.put("tab_close_edit", tabclose[1] = new TSEButton("tbcl1", guiLeft - 3, guiTop + 191, 214, 504, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				(gui.tabmode = TabMode.LIST).apply(gui);
				return true;
			}
		});
		//
		tabmode.apply(this);
		commode.apply(this);
	}

	protected void updateeditor(){
		CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
		font.setText(commode.font() ? comp == null ? "text" : ((FontData)comp).text : I18n.format("gui.fvtm.trafficsigneditor.tab_editor.not_font"));
		rot.setText("" + (comp == null ? 0 : comp.rotation));
		zpos.setText("" + (comp == null ? 0 : comp.zoff));
		xpos.setText("" + (comp == null ? 0 : comp.xoff));
		ypos.setText("" + (comp == null ? 0 : comp.yoff));
		scal.setText("" + (comp == null ? 0 : comp.scale));
	}

	protected void setcolor(RGB color){
		CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
		if(comp == null){
			if(color == null) color = RGB.BLUE;
		}
		else if(color == null){
			color = comp.channels[channel_selected];
		}
		else{
			comp.channels[channel_selected].packed = color.packed;
		}
		current_color = color;
		palette.recalc(color);
		byte[] arr = color.toByteArray();
		rgb_field.setText((arr[0] + 128) + ", " + (arr[1] + 128) + ", " + (arr[2] + 128));
		hex_field.setText("#" + Integer.toHexString(color.packed));
	}

	protected void packscroll(int a){
		pack_scroll += a;
		if(pack_scroll < -1) pack_scroll = libraries.size() - 1;
		if(pack_scroll >= libraries.size() || nolibs) pack_scroll = -1;
		updateleftlist();
	}

	private void updateleftlist(){
		leftlist.clear();
		boolean all = pack_scroll == -1;
		selectedlib = all ? null : libraries.get(pack_scroll);
		switch(commode){
			case BACKGROUND:{
				if(all) leftlist.addAll(BACKGROUNDS.keySet());
				else leftlist.addAll(selectedlib.backgrounds.keySet());
				break;
			}
			case COMPONENT:{
				if(all) leftlist.addAll(COMPONENTS.keySet());
				else leftlist.addAll(selectedlib.components.keySet());
				break;
			}
			case FONT:{
				if(all) leftlist.addAll(FONTS.keySet());
				else leftlist.addAll(selectedlib.fonts.keySet());
				break;
			}
			case PRESET:{
				if(all) leftlist.addAll(PRESETS.keySet());
				else leftlist.addAll(selectedlib.presets.keySet());
				break;
			}
			default: break;
		}
		if(all) title.string = I18n.format("gui.fvtm.trafficsigneditor.title.all_packs");
		else title.string = I18n.format("fvtm.sign_library." + (selectedlib == null ? "error" : selectedlib.id));
		updateleftlist(0);
	}

	private void updaterightlist(){
		rightlist.clear();
		switch(commode){
			case BACKGROUND:{
				for(BaseData dat : data.backgrounds) rightlist.add(dat.comp);
				break;
			}
			case COMPONENT:{
				for(ComponentData dat : data.components) rightlist.add(dat.comp);
				break;
			}
			case FONT:{
				for(FontData dat : data.fonts) rightlist.add(dat.comp);
				break;
			}
			case PRESET:{
				//
				break;
			}
			default: break;
		}
		updaterightlist(0);
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 15; i++){
			rlistR[i].visible = rlistC[i].visible = rlistE[i].visible = rlist[i].hovered;
		}
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(guiLeft + 127 + (cam_scroll_x * 16), guiTop + 110 + (cam_scroll_y * 16), -200);
        GlStateManager.scale(-scale, scale, scale);
        //GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(180, 0, 1, 0);
        //
        ModelBase.bindTexture(Resources.WHITE_TEXTURE);
        for(BaseData comp : data.backgrounds){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * 0.1f);
        	if(comp.scale != 0f) GL11.glScalef(comp.scale, comp.scale, comp.scale);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	comp.model.render(comp, comp.comp, entity, null);
        	GL11.glPopMatrix();
        }
        for(ComponentData comp : data.components){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * 0.1f);
        	if(comp.scale != 0f) GL11.glScalef(comp.scale, comp.scale, comp.scale);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	comp.model.render(comp, comp.comp, entity, null);
        	GL11.glPopMatrix();
        }
        for(FontData comp : data.fonts){
        	if(comp.model == null) continue;
    		GL11.glPushMatrix();
        	GL11.glTranslatef(comp.xoff * sixteenth, comp.yoff * sixteenth, comp.zoff * 0.1f);
        	if(comp.scale != 0f) GL11.glScalef(comp.scale, comp.scale, comp.scale);
        	if(comp.rotation != 0) GL11.glRotatef(comp.rotation, 0, 0, 1);
        	comp.model.render(comp, comp.comp, entity, null);
        	GL11.glPopMatrix();
        }
        //
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		drawRect(guiLeft, guiTop, 128, 0, xSize, ySize);
		drawRect(guiLeft - 112, guiTop + 14, 16, 14, 112, 192);
		drawRect(guiLeft + 256, guiTop + 14, 384, 14, 112, 192);
		drawRect(guiLeft + 11, guiTop + 206, 139, 206, 150, 16);
		drawRect(guiLeft + 173, guiTop + 206, 301, 206, 72, 16);
		drawRect(guiLeft - 99, guiTop + 206, 29, 206, 28, 8);
		drawRect(guiLeft + 327, guiTop + 206, 455, 206, 28, 8);
		switch(tabmode){
			case LIST:
				drawRect(guiLeft - 105, guiTop + 21, 0, 334, 110, 178);
				break;
			case COLOR:
				drawRect(guiLeft - 105, guiTop + 21, 112, 334, 110, 178);
				break;
			case EDIT:
				drawRect(guiLeft - 105, guiTop + 21, 224, 334, 110, 178);
				break;
			default:
				break;
		}
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
	    ttip.clear();
		if(prev.hovered){
			String str = nolibs ? "fvtm.sign_library.none" : pack_scroll == 0 ? "gui.fvtm.trafficsigneditor.title.all_packs" : pack_scroll == -1 ? "fvtm.sign_library." + libraries.get(libraries.size() - 1).id : "fvtm.sign_library." + libraries.get(pack_scroll - 1).id;
			ttip.add(I18n.format("gui.fvtm.trafficsigneditor.prev") + I18n.format(str));
		}
		if(next.hovered){
			String str = nolibs ? "fvtm.sign_library.none" : pack_scroll == libraries.size() - 1 ? "gui.fvtm.trafficsigneditor.title.all_packs" : "fvtm.sign_library." + libraries.get(pack_scroll + 1).id;
			ttip.add(I18n.format("gui.fvtm.trafficsigneditor.next") + I18n.format(str));
		}
		if(search.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.search_" + (title.visible ? "off" : "on")));
		if(title.hovered) ttip.add(title.string);
		//
		if(tabmode.list()){
			if(lup.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.left_up"));
			if(ldw.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.left_down"));
		}
		if(rup.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.right_up"));
		if(rdw.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.right_down"));
		//
		if(zoom_in.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.zoom_in"));
		if(zoom_out.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.zoom_out"));
		if(confirm.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.confirm"));
		if(cancel.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.cancel"));
		//
		if(cm_b.hovered) ttip.add(I18n.format(commode.base() ? "gui.fvtm.trafficsigneditor.mode_current" : "gui.fvtm.trafficsigneditor.mode_base"));
		if(cm_c.hovered) ttip.add(I18n.format(commode.component() ? "gui.fvtm.trafficsigneditor.mode_current" : "gui.fvtm.trafficsigneditor.mode_component"));
		if(cm_f.hovered) ttip.add(I18n.format(commode.font() ? "gui.fvtm.trafficsigneditor.mode_current" : "gui.fvtm.trafficsigneditor.mode_font"));
		if(cm_p.hovered) ttip.add(I18n.format(commode.preset() ? "gui.fvtm.trafficsigneditor.mode_current" : "gui.fvtm.trafficsigneditor.mode_preset"));
		//
		if(c_up.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.move_up"));
		if(c_dw.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.move_down"));
		if(c_lr.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.move_left"));
		if(c_rg.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.move_right"));
		//
		for(int i = 0; i < 15; i++){
			if(rlist[i].hovered) ttip.add(rList[i].string);
			if(rlistR[i].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.remove"));
			if(rlistC[i].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.color"));
			if(rlistE[i].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.edit"));
		}
		if(tabmode.list()){
			for(int i = 0; i < 15; i++){
				if(llist[i].hovered) ttip.add(lList[i].string);
			}
		}
		//
	    if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(key.equals("search")){
			TextField field = fields.get("search");
			if(title.visible){
				field.setVisible(true);
				field.setEnabled(true);
				title.visible = false;
			}
			else{
				field.setText("");
				field.setVisible(false);
				field.setEnabled(false);
				title.visible = true;
			}
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		if(tabmode.list()){
			if(x >= guiLeft - 105 && x < guiLeft + 5 && y >= guiTop + 21 && y < guiTop + 199){
				updateleftlist(am);
			}
		}
		if(x >= guiLeft + 251 && x < guiLeft + 361 && y >= guiTop + 21 && y < guiTop + 199){
			updaterightlist(am);
		}
	}
	
	private void updateleftlist(int am){
		if(leftlist.size() > 15){
			left_scroll += am;
			if(left_scroll < 0) left_scroll = 0;
			if(left_scroll > leftlist.size() - 15) left_scroll = leftlist.size() - 15;
		}
		else left_scroll = 0;
		for(int i = 0; i < 15; i++){
			int j = i + left_scroll;
			lList[i].string = j >= leftlist.size() ? "" : I18n.format("fvtm.traffic_sign." + commode.lcname() + "." + (selectedlib == null ? "" : selectedlib.id + ":") + leftlist.get(j));
		}
	}
	
	private void updaterightlist(int am){
		if(rightlist.size() > 15){
			right_scroll += am;
			if(right_scroll < 0) right_scroll = 0;
			if(right_scroll > rightlist.size() - 15) right_scroll = rightlist.size() - 15;
		}
		else right_scroll = 0;
		for(int i = 0; i < 15; i++){
			int j = i + right_scroll;
			rList[i].string = j >= rightlist.size() ? "" : I18n.format("fvtm.traffic_sign." + commode.lcname() + "." + (selectedlib == null ? "" : selectedlib.id + ":") + rightlist.get(j));
		}
		updateeditor();
	}

	private void addComponent(int index){
		String str = null;
		index += left_scroll;
		if(index < 0 || index >= leftlist.size()) return;
		switch(commode){
			case BACKGROUND:
				str = leftlist.get(index);
				data.backgrounds.add((BaseData)new BaseData(selectedlib == null ? str : selectedlib + ":" + str).linkModel());
				rightlist.add(str);
				break;
			case COMPONENT:
				str = leftlist.get(index);
				data.components.add((ComponentData)new ComponentData(selectedlib == null ? str : selectedlib + ":" + str).linkModel());
				rightlist.add(str);
				break;
			case FONT:
				str = leftlist.get(index);
				data.fonts.add((FontData)new FontData(selectedlib == null ? str : selectedlib + ":" + str).linkModel());
				rightlist.add(str);
				break;
			case PRESET:
				//TODO
				break;
			default: return;
		}
		updaterightlist(0);
	}

	public void drawRect(int x, int y, int tx, int ty, int w, int h){
        float gw = 0.001953125f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(x, y + h, zLevel).tex(tx * gw, (ty + h) * gw).endVertex();
        bufferbuilder.pos(x + w, y + h, zLevel).tex((tx + w) * gw, (ty + h) * gw).endVertex();
        bufferbuilder.pos(x + w, y, zLevel).tex((tx + w) * gw, ty * gw).endVertex();
        bufferbuilder.pos(x, y, zLevel).tex(tx * gw, ty * gw).endVertex();
        tessellator.draw();
	}
	
	private static enum TabMode {
		
		LIST, COLOR, EDIT;

		public boolean list(){
			return this == LIST;
		}

		public boolean color(){
			return this == COLOR;
		}

		public boolean edit(){
			return this == EDIT;
		}

		public void apply(TrafficSignEditor gui){
			boolean list = list();
			for(int i = 0; i < 15; i++){
				gui.llist[i].visible = list;
				gui.lList[i].visible = list;
			}
			//
			boolean color = color();
			for(int i = 0; i < gui.colorchannels.length; i++) gui.colorchannels[i].visible = color;
			gui.rgb_confirm.visible = color;
			gui.hex_confirm.visible = color;
			gui.rgb_field.setVisible(color);
			gui.hex_field.setVisible(color);
			gui.tabclose[0].visible = color;
			gui.spectrum.visible = color;
			gui.palette.visible = color;
			gui.palette.recalc(gui.current_color);
			//
			boolean edit = edit();
			for(int i = 0; i < gui.editor.length; i++) gui.editor[i].visible = edit;
			for(int i = 0; i < gui.editorconfirm.length; i++) gui.editorconfirm[i].visible = edit;
			gui.font.setVisible(edit);
			gui.rot.setVisible(edit);
			gui.zpos.setVisible(edit);
			gui.xpos.setVisible(edit);
			gui.ypos.setVisible(edit);
			gui.scal.setVisible(edit);
			gui.tabclose[1].visible = edit;
			//
			gui.updateleftlist();
		}
		
	}
	
	private static enum ComponentMode {
		
		BACKGROUND, COMPONENT, FONT, PRESET;

		public boolean base(){
			return this == BACKGROUND;
		}

		public boolean component(){
			return this == COMPONENT;
		}

		public boolean font(){
			return this == FONT;
		}

		public boolean preset(){
			return this == PRESET;
		}

		public String lcname(){
			return name().toLowerCase();
		}

		public void apply(TrafficSignEditor gui){
			right_selected = -1;
			gui.updateleftlist();
			gui.updaterightlist();
		}

		public ComponentType toType(){
			switch(this){
				case BACKGROUND: return ComponentType.BASE;
				case COMPONENT: return ComponentType.COMPONENT;
				case FONT: return ComponentType.FONT;
				case PRESET:
				default: return null;
			
			}
		}
		
	}
	
	private static class TSEButton extends BasicButton {
		
		private static RGB light = new RGB(255, 246, 199, 0.5f);

		public TSEButton(String name, int x, int y, int tx, int ty, int sizex, int sizey, boolean enabled) {
			super(name, x, y, tx, ty, sizex, sizey, enabled);
		}
		
		@Override
		public void draw(GenericGui<?> g, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			rgb = hovered ? enabled ? rgb_hover : rgb_disabled : rgb_none;
			RGB.glColorReset();
            rgb.glColorApply();
            ris.drawRect(x, y, tx, ty, sizex, sizey);
            RGB.glColorReset();
		}
		
	}
	
}

