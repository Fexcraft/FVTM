package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.BLANK_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.SWITCH_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.WHITE_SEG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import net.fexcraft.mod.fvtm.FvtmRegistry;
import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstPainter extends ConstGui {
	
	private int channelidx;
	private String channelid;
	private RGB channel;
	private Colorable colorable;
	private static RGB CURRENT = RGB.WHITE.copy();
	private static RGB[] PALETTE = new RGB[54];
	static { for(int i = 0; i < 54; i++) PALETTE[i] = RGB.WHITE.copy(); }
	private Palette palette;
	private Spectrum spectrum;
	private File palette_file;

	public ConstPainter(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		help_url += "#painter";
		colorable = container.hasBlock() ? container.entity.getBlockData() : container.hasContainer() ? container.entity.getContainerData() : container.hasVehicle() ? container.entity.getVehicleData() : null;
		palette_file = new File(FvtmRegistry.CONFIG_DIR, "/fvtm/custom_palette.fvtm");
		if(!palette_file.exists()) palette_file.getParentFile().mkdirs();
		loadCustomPalette();
	}

	@Override
	public void init(){
		super.init();
		String title = "vehicle";
		if(container.hasBlock()) title = "block";
		else if(container.hasContainer()) title = "container";
		else if(container.hasVehicle()) title = "vehicle";
		setMenuTitle("gui.fvtm.constructor.texture.menu_title_" + title);
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addElement(BLANK_SEG, "channel_title", "gui.fvtm.constructor.painter.channel", null);
		addElement(SWITCH_SEG, "channel", "", (button, mb) -> {
				channelidx += button.name.endsWith("_0") ? -1 : 1;
				if(channelidx < 0) channelidx = colorable.getColorChannels().size() - 1;
				if(channelidx >= colorable.getColorChannels().size()) channelidx = 0;
				updateChannel();
			},
			ConstGuiElement.LEFT_ICON.asarray(ConstGuiElement.RIGHT_ICON),
			new String[]{ "gui.fvtm.constructor.button.prev", "gui.fvtm.constructor.button.next" }
		);
		addElement(EMPTY_SEG, "spacer0", null, null);
		addElement(ConstGuiElement.SWITCH_SEG, "current", "gui.fvtm.constructor.painter.current", (button, mb) -> {
				if(button.name.endsWith("_1")) updateColor(channel, true);
				sendUpdate();
			},
			ConstGuiElement.CONFIRM_ICON.asarray(ConstGuiElement.CANCEL_ICON),
			new String[]{ "gui.fvtm.constructor.button.apply", "gui.fvtm.constructor.button.reset" }
		);
		addElement(EMPTY_SEG, "color", null, null);
		buttons.put("preview", new Preview(17 + 12 * (elements.size() - 1), WHITE_SEG));
		addElement(BLANK_SEG, "hex_title", "gui.fvtm.constructor.painter.hex", null);
		addElement(ConstGuiElement.INPUT_1B_SEG, "hex", null, (button, mb) -> {
			try{
				RGB rgb = new RGB();
				rgb.packed = Integer.parseInt(fields.get("hex").getText().replace("#", ""), 16);
				if(mb == 0) updateColor(rgb, true);
				else saveCustomPalette(rgb);
			}
			catch(Exception e){
				e.printStackTrace();
				titletext.update("gui.fvtm.constructor.painter.error_hex", RGB_ORANGE.packed);
			}
		}, ConstGuiElement.EDIT_ICON.asarray(), new String[]{ "gui.fvtm.constructor.button.apply" });
		addElement(BLANK_SEG, "rgb_title", "gui.fvtm.constructor.painter.rgb", null);
		addElement(ConstGuiElement.INPUT3_SEG, "rgb", null, (button, mb) -> {
			try{
				RGB rgb = new RGB();
				rgb = new RGB(
					Integer.parseInt(fields.get("rgb_0").getText()),
					Integer.parseInt(fields.get("rgb_1").getText()),
					Integer.parseInt(fields.get("rgb_2").getText())
				);
				if(mb == 0) updateColor(rgb, true);
				else saveCustomPalette(rgb);
			}
			catch(Exception e){
				e.printStackTrace();
				titletext.update("gui.fvtm.constructor.painter.error_rgb", RGB_ORANGE.packed);
			}
		}, ConstGuiElement.EDIT_ICON.asarray(), new String[]{ "gui.fvtm.constructor.button.apply" });
		addElement(BLANK_SEG, "picker", "gui.fvtm.constructor.painter.picker", null);
		addElement(WHITE_SEG, "spectrum", null, null);
		buttons.put("spectrum", spectrum = new Spectrum(2, 17 + 12 * (elements.size() - 1), 135, 10, 27){
			@Override
			public boolean onclick(int x, int y, int b){
				if(b == 0) updateColor(getColorAt(x), true);
				else saveCustomPalette(getColorAt(x));
				return true;
			}
		});
		addElement(WHITE_SEG, "palette", null, null);
		buttons.put("palette", palette = new Palette(2, 17 + 12 * (elements.size() - 1), 27, 5, 5, 2){
			@Override
			public boolean onclick(int x, int y, int b){
				if(b == 0) updateColor(getColorAt(x, y), false);
				else saveCustomPalette(getColorAt(x, y));
				return true;
			}
		});
		addElement(WHITE_SEG, "custom_palette", null, null);
		buttons.put("custom_ palette", new CustomPalette(2, 17 + 12 * (elements.size() - 1)){
			@Override
			public boolean onclick(int x, int y, int b){
				updateColor(getColorAt(x, y), true);
				return true;
			}
		});
		String[] info = new String[]{ "gui.fvtm.constructor.painter.apply", "gui.fvtm.constructor.painter.save" };
		//infotext.put(spectrum, info);
		//infotext.put(palette, info);
		infotext.put(buttons.get("hex"), info);
		infotext.put(buttons.get("rgb"), info);
		//
		finish_init();
		updateChannel();
	}

	private void updateChannel(){
		Object[] arr = colorable.getColorChannels().keySet().toArray();
		for(int i = 0; i < arr.length; i++){
			if(i == channelidx) channelid = arr[i].toString();
		}
		channel = colorable.getColorChannel(channelid);
		texts.get("channel").string = channelid;
		updateColor(channel, true);
	}

	private void updateColor(RGB rgb, boolean update){
		CURRENT.packed = rgb.packed;
		fields.get("hex").setText(toHex(rgb.packed));
		byte[] arr = rgb.toByteArray();
		fields.get("rgb_0").setText(arr[0] + 128 + "");
		fields.get("rgb_1").setText(arr[1] + 128 + "");
		fields.get("rgb_2").setText(arr[2] + 128 + "");
		if(update) palette.recalc(CURRENT);
	}

	private void sendUpdate(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "color_update");
		compound.setString("channel", channelid);
		compound.setInteger("rgb", CURRENT.packed);
		titletext.update(REQUEST_SENT, RGB_CYAN.packed);
		container.send(Side.SERVER, compound);
	}

	private String toHex(int packed){
		String str = Integer.toHexString(packed);
		while(str.length() < 6) str = "0" + str;
		return "#" + str;
	}

	public static class Preview extends BasicButton {

		public Preview(int y, ConstGuiElement elm){
			super("preview", 2, y, elm.x + 2, elm.y + 1, 135, 10, true);
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			CURRENT.glColorApply();
			gui.drawTexturedModalRect(x, y, 1, 1, sizex, sizey);
			RGB.glColorReset();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

	}

	public static class Spectrum extends BasicButton {

		private RGB[] rgbs;
		private int size;

		public Spectrum(int x, int y, int width, int height, int length){
			super("spectrum", x, y, 0, 0, width, height, true);
			size = width / (rgbs = new RGB[length]).length;
			for(int i = 0; i < rgbs.length; i++){
				float c = i * (1f / rgbs.length);
				int r, g, b;
				//
				if(c >= 0 && c <= (1 / 6.f)){
					r = 255;
					g = (int)(1530 * c);
					b = 0;
				}
				else if(c > (1 / 6.f) && c <= (1 / 3.f)){
					r = (int)(255 - (1530 * (c - 1 / 6f)));
					g = 255;
					b = 0;
				}
				else if(c > (1 / 3.f) && c <= (1 / 2.f)){
					r = 0;
					g = 255;
					b = (int)(1530 * (c - 1 / 3f));
				}
				else if(c > (1 / 2f) && c <= (2 / 3f)){
					r = 0;
					g = (int)(255 - ((c - 0.5f) * 1530));
					b = 255;
				}
				else if(c > (2 / 3f) && c <= (5 / 6f)){
					r = (int)((c - (2 / 3f)) * 1530);
					g = 0;
					b = 255;
				}
				else if(c > (5 / 6f) && c <= 1){
					r = 255;
					g = 0;
					b = (int)(255 - ((c - (5 / 6f)) * 1530));
				}
				else{
					r = 127;
					g = 127;
					b = 127;
				}
				rgbs[i] = new RGB(r, g, b);
			}
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			for(int i = 0; i < rgbs.length; i++){
				rgbs[i].glColorApply();
				gui.drawTexturedModalRect(x + (size * i), y, 1, 1, size, sizey);
				RGB.glColorReset();
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		public RGB getColorAt(int mouseX){
			int i = (mouseX - x) / size;
			if(i < 0 || i >= rgbs.length) return CURRENT;
			return rgbs[i];
		}

	}

	public static class Palette extends BasicButton {

		private RGB[][] rgbs;
		private int wx, hy;

		public Palette(int x, int y, int columns, int width, int rows, int height){
			super("palette", x, y, 0, 0, (columns * width), (rows * height), true);
			rgbs = new RGB[columns][rows];
			wx = width;
			hy = height;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			for(int i = 0; i < rgbs.length; i++){
				for(int j = 0; j < rgbs[i].length; j++){
					rgbs[i][j].glColorApply();
					gui.drawTexturedModalRect(x + (i * wx), y + (j * hy), 1, 1, wx, hy);
					RGB.glColorReset();
				}
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		public void recalc(RGB current){
			byte[] arr = current.toByteArray();
			int[] err = new int[] { arr[0] + 128, arr[1] + 128, arr[2] + 128 };
			for(int x = 0; x < rgbs.length; x++){
				for(int z = 0; z < rgbs[x].length; z++){
					int y = x * rgbs.length + z;
					float e = (1f / (rgbs.length * rgbs[x].length) * y), f = (1f / rgbs.length) * z, h = (255 / rgbs.length) * x;
					int r = (int)Math.abs((e * err[0]) + ((1 - f) * h));
					int g = (int)Math.abs((e * err[1]) + ((1 - f) * h));
					int l = (int)Math.abs((e * err[2]) + ((1 - f) * h));
					rgbs[x][z] = new RGB(r, g, l);
				}
			}
		}

		public RGB getColorAt(int mouseX, int mouseY){
			int xx = (mouseX - x) / wx, yy = (mouseY - y) / hy;
			if(xx < 0 || xx >= rgbs.length|| yy < 0 || yy >= rgbs[xx].length) return CURRENT;
			return rgbs[xx][yy];
		}

	}

	public static class CustomPalette extends BasicButton {

		private int wx, hy;

		public CustomPalette(int x, int y){
			super("custom_palette", x, y, 0, 0, (27 * 5), (2 * 5), true);
			wx = hy = 5;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			for(int i = 0; i < PALETTE.length; i++){
				int xx = i % 27, yy = i > 26 ? 1 : 0;
				PALETTE[i].glColorApply();
				gui.drawTexturedModalRect(x + xx * wx, y + yy * hy, 1, 1, wx, hy);
				RGB.glColorReset();
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		public RGB getColorAt(int mouseX, int mouseY){
			int xx = (mouseX - x) / wx, yy = (mouseY - y) / hy;
			if(xx < 0 || xx >= 27 || yy < 0 || yy >= 2) return CURRENT;
			return PALETTE[xx + ( yy > 0 ? 27 : 0)];
		}

	}
	
	private void loadCustomPalette(){
		try{
			if(!palette_file.exists()) return;
			FileInputStream stream = new FileInputStream(palette_file);
			int r = 0, i = 0;
			while(r >= 0 || i >= 54){
				byte[] bit = new byte[4];
				r = stream.read(bit);
				if(r < 0) break;
				PALETTE[i++] = new RGB(ByteBuffer.wrap(bit).getInt());
			}
			stream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void saveCustomPalette(RGB rgb){
		try{
			for(int i = 52; i >= 0; i--){
				PALETTE[i + 1] = PALETTE[i];
			}
			PALETTE[0] = rgb.copy();
			FileOutputStream stream = new FileOutputStream(palette_file);
			for(RGB color : PALETTE){
				stream.write(ByteBuffer.allocate(4).putInt(color.packed).array());
			}
			stream.flush();
			stream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
