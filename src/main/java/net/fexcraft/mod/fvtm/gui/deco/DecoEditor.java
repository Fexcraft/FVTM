package net.fexcraft.mod.fvtm.gui.deco;

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
				//select(selected, selcol);
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
				//select(selected, selcol);
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
	}

}
