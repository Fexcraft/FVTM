package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class DecoEditor extends GenericGui<DecoEditorContainer> {
	
	private static final ResourceLocation texl = new ResourceLocation("fvtm:textures/gui/deco_editor_left.png");
	private static final ResourceLocation texr = new ResourceLocation("fvtm:textures/gui/deco_editor_right.png");

	public DecoEditor(EntityPlayer player, World world, int entid){
		super(null, new DecoEditorContainer(player, world, entid), player);
		this.xSize = this.ySize = 256;
		this.deftexrect = false;
		this.defbackground = false;
	}
	
	@Override
	protected void init(){
		buttons.put("l_prev", new BasicButton("prev", 2, 2, 2, 2, 12, 12, true));
		buttons.put("l_next", new BasicButton("next", 125, 2, 125, 2, 12, 12, true));
		buttons.put("l_search", new BasicButton("search", 16, 2, 16, 2, 12, 12, true));
		buttons.put("l_add", new BasicButton("add", 140, 9, 140, 9, 12, 12, true){
			public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
				TexUtil.bindTexture(texl);
				super.draw(gui, pticks, mouseX, mouseY);
			}
		});
		buttons.put("l_list", new BasicButton("list", 140, 23, 140, 23, 12, 12, true));
		buttons.put("l_lup", new BasicButton("lup", 131, 21, 131, 21, 7, 12, true));
		buttons.put("l_ldw", new BasicButton("ldw", 131, 175, 131, 175, 7, 12, true));
		for(int i = 0; i < 12; i++){
			buttons.put("l_entry" + i, new BasicButton("entry" + i, 2, 21 + (i * 14), 2, 21 + (i * 14), 120, 12, true));
			buttons.put("l_entry_add" + i, new BasicButton("entry_add" + i, 123, 21 + (i * 14), 146, 58, 7, 12, true));
			buttons.put("l_entry_rem" + i, new BasicButton("entry_rem" + i, 123, 21 + (i * 14), 146, 44, 7, 12, true));
			buttons.get("l_entry_rem" + i).visible = false;
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
		int black = MapColor.BLACK.colorIndex;
		int gray = MapColor.GRAY.colorValue;
		texts.put("cat", new BasicText(30, 4, 91, black, "category"));
		texts.put("pos", new BasicText(width - 136, 5, 132, black, I18n.format("gui.fvtm.decoration_editor.position")));
		texts.put("rot", new BasicText(width - 136, 33, 132, black, I18n.format("gui.fvtm.decoration_editor.rotation")));
		texts.put("scl", new BasicText(width - 136, 61, 132, black, I18n.format("gui.fvtm.decoration_editor.scale")));
		texts.put("tex", new BasicText(width - 136, 89, 132, black, I18n.format("gui.fvtm.decoration_editor.texture")));
		texts.put("texc", new BasicText(width - 135, 102, 107, gray, "-"));
		texts.put("channel", new BasicText(width - 135, 127, 107, gray, "-"));
		fields.put("search_field", new TextField(1, fontRenderer, 29, 3, 93, 10, true));
		fields.put("rgb_field", new TextField(1, fontRenderer, width - 135, guiTop + 147, 107, 8, false));
		fields.put("hex_field", new TextField(2, fontRenderer, width - 135, guiTop + 167, 107, 8, false));
		fields.get("search_field").setVisible(false);
	}
	
	@Override
	public void drawbackground(float ticks, int mx, int my){
		TexUtil.bindTexture(texl);
		drawTexturedModalRect(0, 0, 0, 0, 144, 198);
		drawTexturedModalRect(144, 2, 144, 2, 15, 40);
		TexUtil.bindTexture(texr);
		drawTexturedModalRect(width - 144, 0, 112, 0, 144, 188);
	}

}
