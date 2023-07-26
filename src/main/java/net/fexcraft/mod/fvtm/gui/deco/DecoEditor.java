package net.fexcraft.mod.fvtm.gui.deco;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATION_CATEGORIES;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class DecoEditor extends GenericGui<DecoEditorContainer> {
	
	private static final ResourceLocation texl = new ResourceLocation("fvtm:textures/gui/deco_editor_left.png");
	private static final ResourceLocation texr = new ResourceLocation("fvtm:textures/gui/deco_editor_right.png");
	private static final int rows = 12;
	private static ArrayList<DecorationData> results = new ArrayList<>();
	private static ArrayList<String> colors = new ArrayList<>();
	private static boolean listmode = true, search;
	private int scroll0, scroll1;
	protected int selected = -1, selcol;
	private int category = 0;
	private String searchstr = "";

	public DecoEditor(EntityPlayer player, World world, int entid){
		super(null, new DecoEditorContainer(player, world, entid), player);
		this.xSize = this.ySize = 256;
		this.deftexrect = false;
		this.defbackground = false;
		if(DECORATION_CATEGORIES.isEmpty()){
			player.closeScreen();
		}
		container.gui = this;
	}
	
	@Override
	protected void init(){
		int black = MapColor.BLACK.colorValue;
		for(int i = 0; i < rows; i++){
			int j  = i;
			buttons.put("l_entry_add" + i, new BasicButton("entry_add" + i, 123, 21 + (i * 14), 146, 58, 7, 12, true){
				public boolean onclick(int mx, int my, int button){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("cargo", "add");
					com.setString("key", results.get(scroll1 + j).key());
					container.send(Side.SERVER, com);
					return true;
				}
			});
			buttons.put("l_entry_rem" + i, new BasicButton("entry_rem" + i, 123, 21 + (i * 14), 146, 44, 7, 12, true){
				public boolean onclick(int mx, int my, int button){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("cargo", "rem");
					com.setInteger("idx", scroll1 + j);
					container.send(Side.SERVER, com);
					return true;
				}
			});
			texts.put("entry" + i, new BasicText(4, 23 + (i * 14), 116, black, "").autoscale());
		}
		for(int i = 0; i < 3; i++){
			int j = i;
			buttons.put("r_pos" + i, new BasicButton("pos" + i, width - 105 + (i * 46), 17, 151 + 46, 17, 10, 10, true){
				public boolean onclick(int mx, int my, int button){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("cargo", "pos");
					com.setInteger("axis", j);
					com.setInteger("idx", selected);
					com.setFloat("value", fields.get("pos" + j).getValue());
					container.send(Side.SERVER, com);
					return true;
				}
				public boolean scrollwheel(int am, int x, int y){
					float val = fields.get("pos" + j).getValue();
					val += am > 0 ? -1 : 1;
					fields.get("pos" + j).setText(val + "");
					onclick(x, y, 0);
					return true;
				}
			});
			buttons.put("r_rot" + i, new BasicButton("rot" + i, width - 105 + (i * 46), 45, 151 + 46, 45, 10, 10, true){
				public boolean onclick(int mx, int my, int button){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("cargo", "rot");
					com.setInteger("axis", j);
					com.setInteger("idx", selected);
					com.setFloat("value", fields.get("rot" + j).getValue());
					container.send(Side.SERVER, com);
					return true;
				}
				public boolean scrollwheel(int am, int x, int y){
					float val = fields.get("rot" + j).getValue();
					val += am > 0 ? -1 : 1;
					fields.get("rot" + j).setText(val + "");
					onclick(x, y, 0);
					return true;
				}
			});
			buttons.put("r_scl" + i, new BasicButton("scl" + i, width - 105 + (i * 46), 73, 151 + 46, 73, 10, 10, true){
				public boolean onclick(int mx, int my, int button){
					NBTTagCompound com = new NBTTagCompound();
					com.setString("cargo", "scale");
					com.setInteger("axis", j);
					com.setInteger("idx", selected);
					com.setFloat("value", fields.get("scl" + j).getValue());
					container.send(Side.SERVER, com);
					return true;
				}
				public boolean scrollwheel(int am, int x, int y){
					float val = fields.get("scl" + j).getValue();
					val += am > 0 ? -sixteenth : sixteenth;
					fields.get("scl" + j).setText(val + "");
					onclick(x, y, 0);
					return true;
				}
			});
			fields.put("pos" + i, new NumberField(3 + i, fontRenderer, width - 135 + (i * 46), 18, 27, 8, false));
			fields.put("rot" + i, new NumberField(3 + i, fontRenderer, width - 135 + (i * 46), 46, 27, 8, false));
			fields.put("scl" + i, new NumberField(3 + i, fontRenderer, width - 135 + (i * 46), 74, 27, 8, false));
		}
		buttons.put("r_t-", new BasicButton("t-", width - 25, 101, 231, 101, 10, 10, true){
			public boolean onclick(int mx, int my, int button){
				if(selected < 0 || selected >= container.entity.decos.size()) return true;
				NBTTagCompound com = new NBTTagCompound();
				com.setString("cargo", "tex");
				com.setInteger("idx", selected);
				DecorationData data = container.entity.decos.get(selected);
				com.setInteger("sel", data.seltex - 1 < 0 ? data.textures.size() - 1 : data.seltex - 1);
				container.send(Side.SERVER, com);
				return true;
			}
		});
		buttons.put("r_t+", new BasicButton("t+", width - 13, 101, 243, 101, 10, 10, true){
			public boolean onclick(int mx, int my, int button){
				if(selected < 0 || selected >= container.entity.decos.size()) return true;
				NBTTagCompound com = new NBTTagCompound();
				com.setString("cargo", "tex");
				com.setInteger("idx", selected);
				DecorationData data = container.entity.decos.get(selected);
				com.setInteger("sel", data.seltex + 1 < data.textures.size() ? data.seltex + 1 : 0);
				container.send(Side.SERVER, com);
				return true;
			}
		});
		buttons.put("r_c-", new BasicButton("c-", width - 25, 126, 231, 126, 10, 10, true){
			public boolean onclick(int mx, int my, int button){
				if(colors.isEmpty()) return true;
				selcol--;
				if(selcol < 0) selcol = colors.size() - 1;
				select(selected, selcol);
				return true;
			}
		});
		buttons.put("r_c+", new BasicButton("c+", width - 13, 126, 243, 126, 10, 10, true){
			public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
				TexUtil.bindTexture(texr);
				super.draw(gui, pticks, mouseX, mouseY);
			}
			public boolean onclick(int mx, int my, int button){
				if(colors.isEmpty()) return true;
				selcol++;
				if(selcol >= colors.size()) selcol = 0;
				select(selected, selcol);
				return true;
			}
		});
		buttons.put("r_rgb", new BasicButton("rgb", width - 13, 146, 243, 146, 10, 10, true){
			public boolean onclick(int mx, int my, int button){
				if(selected < 0 || selected >= container.entity.decos.size() || colors.isEmpty()) return true;
				NBTTagCompound com = new NBTTagCompound();
				com.setString("cargo", "color");
				com.setInteger("idx", selected);
				com.setString("channel", colors.get(selcol));
				RGB rgb = RGB.WHITE;
				try{
					String[] arr = fields.get("rgb").getText().split("\\,");
					int r = Integer.parseInt(arr[0].trim());
					int g = Integer.parseInt(arr[1].trim());
					int b = Integer.parseInt(arr[2].trim());
					rgb = new RGB(r, g, b);
				}
				catch(Exception e){
					e.printStackTrace();
					Print.chat(player, e.getMessage());
				}
				com.setInteger("rgb", rgb.packed);
				container.send(Side.SERVER, com);
				return true;
			}
		});
		buttons.put("r_hex", new BasicButton("hex", width - 13, 166, 243, 166, 10, 10, true){
			public boolean onclick(int mx, int my, int button){
				if(selected < 0 || selected >= container.entity.decos.size() || colors.isEmpty()) return true;
				NBTTagCompound com = new NBTTagCompound();
				com.setString("cargo", "color");
				com.setInteger("idx", selected);
				com.setString("channel", colors.get(selcol));
				RGB rgb = RGB.WHITE;
				try{
					rgb = new RGB(fields.get("hex").getText());
				}
				catch(Exception e){
					e.printStackTrace();
					Print.chat(player, e.getMessage());
				}
				com.setInteger("rgb", rgb.packed);
				container.send(Side.SERVER, com);
				return true;
			}
		});
		buttons.put("r_cc", new BasicButton("cc", width - 10, 118, 246, 118, 6, 6, true){
			public boolean onclick(int mx, int my, int button){
				if(selected < 0 || selected >= container.entity.decos.size() || colors.isEmpty()) return true;
				try{
					new Thread(){
						@Override
						public void run(){
							Color color = JColorChooser.showDialog(null, "select color", new Color(container.entity.decos.get(selected).getColorChannel(colors.get(selcol)).packed));
							RGB rgb = new RGB(color.getRGB());
							byte[] ar = rgb.toByteArray();
							fields.get("rgb").setText((ar[0] + 128) + ", " + (ar[1] + 128) + ", " + (ar[2] + 128));
							fields.get("hex").setText("#" + Integer.toHexString(rgb.packed));
						}
					}.start();
				}
				catch(Exception e){
					e.printStackTrace();
					Print.chat(player, e.getMessage());
				}
				return true;
			}
		});
		texts.put("pos", new BasicText(width - 136, 5, 132, black, I18n.format("gui.fvtm.decoration_editor.position")));
		texts.put("rot", new BasicText(width - 136, 33, 132, black, I18n.format("gui.fvtm.decoration_editor.rotation")));
		texts.put("scl", new BasicText(width - 136, 61, 132, black, I18n.format("gui.fvtm.decoration_editor.scale")));
		texts.put("tex", new BasicText(width - 136, 89, 132, black, I18n.format("gui.fvtm.decoration_editor.texture")));
		texts.put("texc", new BasicText(width - 135, 102, 107, 0xcfcfcf, "-").autoscale());
		texts.put("channel", new BasicText(width - 135, 127, 107, 0xcfcfcf, "-").autoscale());
		fields.put("search", new TextField(1, fontRenderer, 29, 3, 93, 10, true));
		fields.put("rgb", new TextField(1, fontRenderer, width - 135, 147, 107, 8, false));
		fields.put("hex", new TextField(2, fontRenderer, width - 135, 167, 107, 8, false));
		updateCategorySearch();
		//updateResults();
		//updateEntries();
		select(-1, -1);
	}

	protected void select(int idx, int colidx){
		selected = idx;
		colors.clear();
		DecorationData data = idx < 0 || idx >= container.entity.decos.size() ? null : container.entity.decos.get(idx);
		boolean miss = data == null;
		for(int i = 0; i < 3; i++){
			fields.get("pos" + i).setText(miss ? "0" : (i == 0 ? data.offset.x : i == 1 ? data.offset.y : data.offset.z) + "");
			fields.get("rot" + i).setText(miss ? "0" : (i == 0 ? data.rotx : i == 1 ? data.roty : data.rotz) + "");
			fields.get("scl" + i).setText(miss ? "0" : (i == 0 ? data.sclx : i == 1 ? data.scly : data.sclz) + "");
		}
		texts.get("texc").string = miss ? "" : data.textures.get(data.seltex).name();
		selcol = colidx;
		if(!miss) colors.addAll(data.getColorChannels().keySet());
		if(selcol >= colors.size() || selcol < 0) selcol = 0;
		texts.get("channel").string = miss ? "" : colors.isEmpty() ? I18n.format("gui.fvtm.decoration_editor.no_color_channels") : colors.get(selcol);
		RGB color = miss || colors.isEmpty() ? RGB.WHITE : data.getColorChannel(colors.get(selcol));
		byte[] ar = color.toByteArray();
		fields.get("rgb").setText((ar[0] + 128) + ", " + (ar[1] + 128) + ", " + (ar[2] + 128));
		fields.get("hex").setText("#" + Integer.toHexString(color.packed));
	}
	
	protected void updateCategorySearch(){
		texts.get("cat").string = DECORATION_CATEGORIES.get(category);
		texts.get("cat").visible = !search;
		fields.get("search").setVisible(search);
		updateResults();
	}

	protected void updateResults(){
		results.clear();
		if(search){
			for(DecorationData deco : DECORATIONS.values()){
				if(deco.key().contains(searchstr) || format(deco.key()).contains(searchstr)) results.add(deco);
			}
		}
		else{
			String cat = DECORATION_CATEGORIES.get(category);
			for(DecorationData deco : DECORATIONS.values()){
				if(deco.category().equals(cat)) results.add(deco);
			}
		}
		updateEntries();
	}

	protected void updateEntries(){
		int j = 0;
		boolean over;
		if(listmode){
			for(int i = 0; i < rows; i++){
				j = scroll0 + i;
				over = j >= container.entity.decos.size();
				texts.get("entry" + i).string = over ? "" : format(container.entity.decos.get(j).key());
				buttons.get("l_entry_rem" + i).visible = true;
				buttons.get("l_entry_add" + i).visible = false;
				buttons.get("l_entry" + i).enabled = selected != j;
			}
		}
		else{
			for(int i = 0; i < rows; i++){
				j = scroll1 + i;
				over = j >= results.size();
				texts.get("entry" + i).string = over ? "" : format(results.get(j).key());
				buttons.get("l_entry_rem" + i).visible = false;
				buttons.get("l_entry_add" + i).visible = true;
				buttons.get("l_entry" + i).enabled = true;
			}
		}
	}

	private String format(String key){
		return I18n.format("fvtm.decoration." + key);
	}

	@Override
	public void predraw(float ticks, int mx, int my){
		if(!fields.get("search").getText().equals(searchstr)){
			searchstr = fields.get("search").getText();
			updateResults();
		}
	}

	@Override
	public void drawbackground(float ticks, int mx, int my){
		TexUtil.bindTexture(texl);
		drawTexturedModalRect(0, 0, 0, 0, 144, 198);
		drawTexturedModalRect(144, 2, 144, 2, 15, 40);
		TexUtil.bindTexture(texr);
		drawTexturedModalRect(width - 144, 0, 112, 0, 144, 188);
	}
	
	@Override
	public void scrollwheel(int a, int x, int y){
		if(x > 1 && x < 139 && y > 20 && y < 188){
			scroll(a);
		}
	}

	private void scroll(int a){
		if(listmode){
			scroll0 += a > 0 ? 1 : -1;
			if(scroll0 < 0) scroll0 = 0;
		}
		else{
			scroll1 += a > 0 ? 1 : -1;
			if(scroll1 < 0) scroll1 = 0;
		}
		updateEntries();
	}

}
