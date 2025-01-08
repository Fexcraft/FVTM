package net.fexcraft.mod.fvtm.gui.tsign;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.BACKGROUNDS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.COMPONENTS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.FONTS;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.LIBRARIES;
import static net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.PRESETS;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Collection;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.NBTToJson;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.BaseData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.CompDataRoot;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.ComponentData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.ComponentType;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.FontData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignLibrary.Library;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

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
	private TSEButton cancel, confirm, copy, paste, export, impart;
	private TSEButton[] llist = new TSEButton[15];
	private TSEHButton[] rlist = new TSEHButton[15];
	private TSEButton rlistR, rlistC, rlistE;
	private TSEButton[] colorchannels = new TSEButton[9];
	private TSEButton rgb_confirm, hex_confirm;
	private TSEButton[] tabclose = new TSEButton[2];
	private TSEButton[] editorconfirm = new TSEButton[7];
	private TSEButton[] border = new TSEButton[5];
	//private ConstPainter.Spectrum spectrum;
	//private ConstPainter.Palette palette;
	private BasicText title;
	private BasicText[] lList = new BasicText[15];
	private BasicText[] rList = new BasicText[15];
	private BasicText[] editor = new BasicText[5];
	private TextField rgb_field, hex_field, searchfield;
	private TextField font, rot, zpos, xpos, ypos, scal0, scal1;
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
	private static NBTTagCompound clipboard;
	private static String lasttext = "";
	//
	private ArrayList<String> ttip = new ArrayList<String>();
	
	public TrafficSignEditor(EntityPlayer player, int x, int y, int z){
		super(texture, new TrafficSignEditorContainer(player, x, y, z), player);
		this.deftexrect = false;
		this.defbackground = false;
		this.xSize = 256;
		this.ySize = 206;
		data = new TrafficSignData(container.entity.getPosition()).read(container.data.write());
		data.linkModels();
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
		buttons.put("search", search = new TSEButton("search", guiLeft + 21, guiTop + 7, 149, 7, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				if(title.visible){
					searchfield.setVisible(true);
					searchfield.setEnabled(true);
					title.visible = false;
				}
				else{
					searchfield.setText("");
					searchfield.setVisible(false);
					searchfield.setEnabled(false);
					title.visible = true;
				}
				return true;
			}
		});
		fields.put("search", searchfield = new TextField(0, fontRenderer, guiLeft + 34, guiTop + 8, 200, 10, true));
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
		buttons.put("confirm", confirm = new TSEButton("confirm", guiLeft + 226, guiTop + 203, 354, 203, 12, 12, true){
			public boolean onclick(int x, int y, int b){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setTag("signdata", data.write());
				container.send(Side.SERVER, compound);
				return true;
			}
		});
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
			buttons.put("list_r_" + i, rlist[i] = new TSEHButton("lr" + i, guiLeft + 251, guiTop + 21 + i * 12, 379, 21 + i * 12, 110, 10, i){
				public boolean onclick(int x, int y, int b){
					right_selected = I + right_scroll;
					setcolor(null);
					updateeditor();
					return true;
				}
			});
			texts.put("list_r_" + i, rList[i] = new BasicText(guiLeft + 253, guiTop + 23 + i * 12, 106, darkgray, "R" + i).autoscale());
			rlist[i].rgb_hover = TSEButton.light;
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
		buttons.put("lrr", rlistR = new TSEButton("lrr", guiLeft + 326, guiTop + 10, 454, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
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
				return true;
			}
		});
		buttons.put("lrc", rlistC = new TSEButton("lrc", guiLeft + 335, guiTop + 10, 463, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				(tabmode = TabMode.COLOR).apply(gui);
				return true;
			}
		});
		buttons.put("lre", rlistE = new TSEButton("lre", guiLeft + 344, guiTop + 10, 472, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				(tabmode = TabMode.EDIT).apply(gui);
				return true;
			}
		});
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
		/*buttons.put("spectrum", spectrum = new ConstPainter.Spectrum(guiLeft - 105, guiTop + 125, 110, 10, 55){
			public boolean onclick(int x, int y, int b){
				setcolor(getColorAt(x));
				return true;
			}
		});
		buttons.put("palette", palette = new ConstPainter.Palette(guiLeft - 100, guiTop + 23, 10, 10, 10, 10){
			public boolean onclick(int x, int y, int b){
				setcolor(getColorAt(x, y));
				return true;
			}
		});*///TODO
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
				if(comp != null){
					comp.text(font.getText());
					updateeditor();
				}
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
		buttons.put("scale0", editorconfirm[5] = new TSEButton("scale0", guiLeft - 62, guiTop + 178, 267, 491, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale0 = scal0.getValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale0 -= a * sixteenth;
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("scale1", editorconfirm[6] = new TSEButton("scale1", guiLeft - 6, guiTop + 178, 323, 491, 10, 10, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale1 = scal1.getValue();
					updateeditor();
				}
				return true;
			}
			public boolean scrollwheel(int a, int x, int y){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null){
					comp.scale1 -= a * sixteenth;
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
		fields.put("scale0", scal0 = new NumberField(8, fontRenderer, guiLeft - 103, guiTop + 179, 39, 8, false));
		fields.put("scale1", scal1 = new NumberField(9, fontRenderer, guiLeft - 47, guiTop + 179, 39, 8, false));
		buttons.put("tab_close_edit", tabclose[1] = new TSEButton("tbcl1", guiLeft - 3, guiTop + 191, 214, 504, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				(gui.tabmode = TabMode.LIST).apply(gui);
				return true;
			}
		});
		buttons.put("bt", border[0] = new TSEButton("bt", guiLeft - 83, guiTop + 64, 246, 377, 64, 8, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null && commode.base()){
					BaseData base = (BaseData)comp;
					base.sides[0] = !base.sides[0];
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("bb", border[1] = new TSEButton("bb", guiLeft - 83, guiTop + 96, 246, 409, 64, 8, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null && commode.base()){
					BaseData base = (BaseData)comp;
					base.sides[3] = !base.sides[3];
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("bl", border[2] = new TSEButton("bl", guiLeft - 91, guiTop + 72, 238, 385, 8, 24, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null && commode.base()){
					BaseData base = (BaseData)comp;
					base.sides[1] = !base.sides[1];
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("br", border[3] = new TSEButton("br", guiLeft - 19, guiTop + 72, 310, 385, 8, 24, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null && commode.base()){
					BaseData base = (BaseData)comp;
					base.sides[2] = !base.sides[2];
					updateeditor();
				}
				return true;
			}
		});
		buttons.put("bs", border[4] = new TSEButton("bs", guiLeft - 83, guiTop + 72, 246, 385, 64, 24, true){
			public boolean onclick(int x, int y, int b){
				CompDataRoot comp = data.getCompData(commode.toType(), right_selected);
				if(comp != null && commode.base()){
					BaseData base = (BaseData)comp;
					base.base = !base.base;
					updateeditor();
				}
				return true;
			}
		});
		//
		buttons.put("copy", copy = new TSEButton("copy", guiLeft + 276, guiTop + 10, 404, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				clipboard = data.write();
				return true;
			}
		});
		buttons.put("paste", paste = new TSEButton("paste", guiLeft + 285, guiTop + 10, 413, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				if(clipboard != null) data.read(clipboard);
				return true;
			}
		});
		buttons.put("export", export = new TSEButton("export", guiLeft + 294, guiTop + 10, 422, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
        		try{
    				StringSelection stringSelection = new StringSelection(NBTToJson.getJsonFromTag(data.write()).toString());
            		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    				Print.chat(player, "sign -> clipboard");
        		}
        		catch(Exception e){
        			e.printStackTrace();
        		}
				return true;
			}
		});
		buttons.put("import", impart = new TSEButton("import", guiLeft + 303, guiTop + 10, 431, 10, 8, 8, true){
			public boolean onclick(int x, int y, int b){
				try{
					data.read(JsonToNBT.getTagFromJson(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor).toString()));
					Print.chat(player, "clipboard -> sign");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return true;
			}
		});
		//
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
		scal0.setText("" + (comp == null ? 0 : comp.scale0));
		scal1.setText("" + (comp == null ? 0 : comp.scale1));
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
		//TODO palette.recalc(color);
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
		boolean search = searchfield.getVisible() && lasttext.length() > 0;
		switch(commode){
			case BACKGROUND:{
				if(search) leftlist.addAll(search(all ? BACKGROUNDS.keySet() : selectedlib.backgrounds.keySet()));
				else if(all) leftlist.addAll(BACKGROUNDS.keySet());
				else leftlist.addAll(selectedlib.backgrounds.keySet());
				break;
			}
			case COMPONENT:{
				if(search) leftlist.addAll(search(all ? COMPONENTS.keySet() : selectedlib.components.keySet()));
				else if(all) leftlist.addAll(COMPONENTS.keySet());
				else leftlist.addAll(selectedlib.components.keySet());
				break;
			}
			case FONT:{
				if(search) leftlist.addAll(search(all ? FONTS.keySet() : selectedlib.fonts.keySet()));
				else if(all) leftlist.addAll(FONTS.keySet());
				else leftlist.addAll(selectedlib.fonts.keySet());
				break;
			}
			case PRESET:{
				if(search) leftlist.addAll(search(all ? PRESETS.keySet() : selectedlib.presets.keySet()));
				else if(all) leftlist.addAll(PRESETS.keySet());
				else leftlist.addAll(selectedlib.presets.keySet());
				break;
			}
			default: break;
		}
		if(all) title.string = I18n.format("gui.fvtm.trafficsigneditor.title.all_packs");
		else title.string = I18n.format("fvtm.sign_library." + (selectedlib == null ? "error" : selectedlib.id));
		updateleftlist(0);
	}

	private Collection<? extends String> search(Collection<String> keys){
		ArrayList<String> list = new ArrayList<>();
		for(String str : keys){
			if(str.contains(lasttext) || I18n.format("fvtm.traffic_sign." + commode.lcname() + "." + (selectedlib == null ? "" : selectedlib.id + ":") + str).contains(str)) list.add(str);
		}
		return list;
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
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(guiLeft + 127 + (cam_scroll_x * 16), guiTop + 110 + (cam_scroll_y * 16), -200);
        GlStateManager.scale(-scale, scale, scale);
        //GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.rotate(180, 0, 1, 0);
        //
        TexUtil.bindTexture(FvtmRegistry.WHITE_TEXTURE);
        data.render(mc.world, false, pticks);
        //
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        //
        if(searchfield.getVisible() && !searchfield.getText().equals(lasttext)){
        	lasttext = searchfield.getText();
        	updateleftlist();
        }
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
		drawRect(guiLeft + 271, guiTop + 7, 399, 7, 86, 7);
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
		}
		if(rlistR.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.remove"));
		if(rlistC.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.color"));
		if(rlistE.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.list.edit"));
		if(tabmode.list()){
			for(int i = 0; i < 15; i++){
				if(llist[i].hovered) ttip.add(lList[i].string);
			}
		}
		//
		if(border[0].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tab_editor.border_top"));
		if(border[1].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tab_editor.border_bottom"));
		if(border[2].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tab_editor.border_left"));
		if(border[3].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tab_editor.border_right"));
		if(border[4].hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tab_editor.base"));
		//
		if(copy.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tool.copy"));
		if(paste.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tool.paste"));
		if(export.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tool.export"));
		if(impart.hovered) ttip.add(I18n.format("gui.fvtm.trafficsigneditor.tool.import"));
		//
	    if(ttip.size() > 0) this.drawHoveringText(ttip, mouseX, mouseY, mc.fontRenderer);
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
				try {
					float rot = data.rotation;
					float off = data.offset;
					data.read(JsonToNBT.getTagFromJson(TrafficSignLibrary.PRESETS.get(leftlist.get(index)).toString()));
					data.rotation = rot;
					data.offset = off;
				}
				catch(NBTException e){
					e.printStackTrace();
				}
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
			/*gui.spectrum.visible = color;
			gui.palette.visible = color;
			gui.palette.recalc(gui.current_color);*///TODO
			//
			boolean edit = edit();
			for(int i = 0; i < gui.editor.length; i++) gui.editor[i].visible = edit;
			for(int i = 0; i < gui.editorconfirm.length; i++) gui.editorconfirm[i].visible = edit;
			gui.font.setVisible(edit);
			gui.rot.setVisible(edit);
			gui.zpos.setVisible(edit);
			gui.xpos.setVisible(edit);
			gui.ypos.setVisible(edit);
			gui.scal0.setVisible(edit);
			gui.scal1.setVisible(edit);
			for(TSEButton button : gui.border) button.visible = edit;
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
		
		private static RGB light = new RGB(255, 246, 199);

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
	
	private static class TSEHButton extends BasicButton {
		
		private int idx;

		public TSEHButton(String name, int x, int y, int tx, int ty, int sizex, int sizey, int idx){
			super(name, x, y, tx, ty, sizex, sizey, true);
			this.idx = idx;
		}
		
		@Override
		public void draw(GenericGui<?> g, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			rgb = hovered || TrafficSignEditor.right_selected - TrafficSignEditor.right_scroll == idx ? enabled ? rgb_hover : rgb_disabled : rgb_none;
			RGB.glColorReset();
            rgb.glColorApply();
            ris.drawRect(x, y, tx, ty, sizex, sizey);
            RGB.glColorReset();
		}
		
	}
	
}

