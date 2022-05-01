package net.fexcraft.mod.fvtm.gui.deco;

import java.util.ArrayList;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.util.Resources;
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
	private static boolean listmode = true, search;
	private int scroll0, scroll1, selected, category = 0;
	private String searchstr = "";

	public DecoEditor(EntityPlayer player, World world, int entid){
		super(null, new DecoEditorContainer(player, world, entid), player);
		this.xSize = this.ySize = 256;
		this.deftexrect = false;
		this.defbackground = false;
		if(Resources.DECORATION_CATEGORIES.isEmpty()){
			player.closeScreen();
		}
		container.gui = this;
	}
	
	@Override
	protected void init(){
		int black = MapColor.BLACK.colorIndex;
		int gray = MapColor.GRAY.colorValue;
		buttons.put("l_prev", new BasicButton("prev", 2, 2, 2, 2, 12, 12, true){
			public boolean onclick(int mx, int my, int button){
				category--;
				if(category < 0) category = Resources.DECORATION_CATEGORIES.size() - 1;
				updateCategorySearch();
				return true;
			}
		});
		buttons.put("l_next", new BasicButton("next", 125, 2, 125, 2, 12, 12, true){
			public boolean onclick(int mx, int my, int button){
				category++;
				if(category >= Resources.DECORATION_CATEGORIES.size()) category = 0;
				updateCategorySearch();
				return true;
			}
		});
		buttons.put("l_search", new BasicButton("search", 16, 2, 16, 2, 12, 12, true){
			public boolean onclick(int mx, int my, int button){
				search = !search;
				updateCategorySearch();
				return true;
			}
		});
		buttons.put("l_add", new BasicButton("add", 140, 9, 140, 9, 12, 12, true){
			public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
				TexUtil.bindTexture(texl);
				super.draw(gui, pticks, mouseX, mouseY);
			}
			public boolean onclick(int mx, int my, int button){
				listmode = false;
				updateResults();
				return true;
			}
		});
		buttons.put("l_list", new BasicButton("list", 140, 23, 140, 23, 12, 12, true){
			public boolean onclick(int mx, int my, int button){
				listmode = true;
				updateEntries();
				return true;
			}
		});
		buttons.put("l_lup", new BasicButton("lup", 131, 21, 131, 21, 7, 12, true){
			public boolean onclick(int mx, int my, int button){
				if(listmode) scroll0--;
				else scroll1--;
				if(scroll0 < 0) scroll0 = 0;
				if(scroll1 < 1) scroll1 = 0;
				updateEntries();
				return true;
			}
		});
		buttons.put("l_ldw", new BasicButton("ldw", 131, 175, 131, 175, 7, 12, true){
			public boolean onclick(int mx, int my, int button){
				if(listmode) scroll0++;
				else scroll1++;
				updateEntries();
				return true;
			}
		});
		for(int i = 0; i < rows; i++){
			int j  = i;
			buttons.put("l_entry" + i, new BasicButton("entry" + i, 2, 21 + (i * 14), 2, 21 + (i * 14), 120, 12, true){
				public boolean onclick(int mx, int my, int button){
					selected = scroll0 + j;
					updateEntries();
					return true;
				}
			});
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
			buttons.put("r_pos" + i, new BasicButton("pos" + i, width - 105 + (i * 46), 17, 151 + 46, 17, 10, 10, true));
			buttons.put("r_rot" + i, new BasicButton("rot" + i, width - 105 + (i * 46), 45, 151 + 46, 45, 10, 10, true));
			buttons.put("r_scl" + i, new BasicButton("scl" + i, width - 105 + (i * 46), 73, 151 + 46, 73, 10, 10, true));
		}
		buttons.put("r_t-", new BasicButton("t-", width - 25, 101, 231, 101, 10, 10, true));
		buttons.put("r_t+", new BasicButton("t+", width - 13, 101, 243, 101, 10, 10, true));
		buttons.put("r_c-", new BasicButton("c-", width - 25, 126, 231, 126, 10, 10, true));
		buttons.put("r_c+", new BasicButton("c+", width - 13, 126, 243, 126, 10, 10, true){
			public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
				TexUtil.bindTexture(texr);
				super.draw(gui, pticks, mouseX, mouseY);
			}
		});
		buttons.put("r_rgb", new BasicButton("rgb", width - 13, 146, 243, 146, 10, 10, true));
		buttons.put("r_hex", new BasicButton("hex", width - 13, 166, 243, 166, 10, 10, true));
		texts.put("cat", new BasicText(30, 4, 91, black, "category").autoscale());
		texts.put("pos", new BasicText(width - 136, 5, 132, black, I18n.format("gui.fvtm.decoration_editor.position")));
		texts.put("rot", new BasicText(width - 136, 33, 132, black, I18n.format("gui.fvtm.decoration_editor.rotation")));
		texts.put("scl", new BasicText(width - 136, 61, 132, black, I18n.format("gui.fvtm.decoration_editor.scale")));
		texts.put("tex", new BasicText(width - 136, 89, 132, black, I18n.format("gui.fvtm.decoration_editor.texture")));
		texts.put("texc", new BasicText(width - 135, 102, 107, gray, "-"));
		texts.put("channel", new BasicText(width - 135, 127, 107, gray, "-"));
		fields.put("search", new TextField(1, fontRenderer, 29, 3, 93, 10, true));
		fields.put("rgb", new TextField(1, fontRenderer, width - 135, guiTop + 147, 107, 8, false));
		fields.put("hex", new TextField(2, fontRenderer, width - 135, guiTop + 167, 107, 8, false));
		updateCategorySearch();
		//updateResults();
		//updateEntries();
	}
	
	protected void updateCategorySearch(){
		texts.get("cat").string = Resources.DECORATION_CATEGORIES.get(category);
		texts.get("cat").visible = !search;
		fields.get("search").setVisible(search);
		updateResults();
	}

	protected void updateResults(){
		results.clear();
		if(search){
			for(DecorationData deco : Resources.DECORATIONS.values()){
				if(deco.key().contains(searchstr) || format(deco.key()).contains(searchstr)) results.add(deco);
			}
		}
		else{
			String cat = Resources.DECORATION_CATEGORIES.get(category);
			for(DecorationData deco : Resources.DECORATIONS.values()){
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
