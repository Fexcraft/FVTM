package net.fexcraft.mod.fvtm.gui.constructor;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

/** Vehicle Color Painter */
public class ConstructorVP extends ConstructorGui {
	
	private static RGB current, org_p, org_s;
	private boolean primary = true;
	private Spectrum spectrum;
	private Palette palette;
	//private Preview preview;
	private TextField rgb, hex;

	public ConstructorVP(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||RGB" , "", "||HEX", "", "", "", "", "", "", "", "||", "||T: ----", "< Back" };
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Vehicle Color Painter";
		this.buttons.put("icon_rgb", new IconButton("icon_rgb", 0, 0, false, ICON_CHECK));
		this.buttons.put("icon_hex", new IconButton("icon_hex", 2, 0, false, ICON_CHECK));
		this.buttons.put("icon_try", new IconButton("icon_try", 10, 2, false, ICON_QMARK).setEnabled(false));
		this.buttons.put("icon_check", new IconButton("icon_check", 10, 1, false, ICON_CHECK));
		this.buttons.put("icon_remove", new IconButton("icon_remove", 10, 0, false, ICON_REMOVE));
		this.buttons.put("icon_type_prev", new IconButton("icon_type_prev", 11, 1, false, ICON_LEFT));
		this.buttons.put("icon_type_next", new IconButton("icon_type_next", 11, 0, false, ICON_RIGHT));
		this.buttons.put("spectrum", spectrum = new Spectrum(2, 20 + (5 * buttonheight), xSize - 4));
		this.buttons.put("palette", palette = new Palette(2, 20 + (6 * buttonheight), xSize - 4));
		this.buttons.put("preview", new Preview(2, 20 + (4 * buttonheight), xSize - 4));
		this.fields.put("rgb", rgb = cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10));
		this.fields.put("hex", hex = cfields[3] = new TextField(2, fontRenderer, 2, 20 + (3 * buttonheight), xSize - 4, 10));
		//
		VehicleData vdata = container.getTileEntity().getVehicleData();
		this.updateColorTo(primary ? vdata.getPrimaryColor() : vdata.getSecondaryColor(), true);
		org_p = vdata.getPrimaryColor().copy(); org_s = vdata.getSecondaryColor().copy();
	}
	
	private void updateIconsAndButtons(){
		tbuttons[11].string = "T: " + (primary ? "primary" : "secondary");
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		this.updateIconsAndButtons();
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button12")){ openGui(modid, 900, xyz); return true; }
		else if(button.name.equals("icon_type_prev") || button.name.equals("icon_type_next")){ primary = !primary; return true; }
		else if(button.name.equals("spectrum")){ this.updateColorTo(spectrum.getColorAt(mouseX), true); return true; }
		else if(button.name.equals("palette")){ this.updateColorTo(palette.getColorAt(mouseX, mouseY), false); return true; }
		else if(button.name.equals("icon_rgb")){ this.updateColorTo(tryParse(rgb.getText(), false), true); return true; }
		else if(button.name.equals("icon_hex")){ this.updateColorTo(tryParse(hex.getText(), true), true); return true; }
		else if(button.name.equals("icon_remove")){ this.updateColorTo(primary ? org_p : org_s, true); sendColorUpdate(); return true; }
		else if(button.name.equals("icon_check")){ sendColorUpdate(); return true; }
		return true;
	}

	private void sendColorUpdate(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "color_update");
		compound.setBoolean("primary", primary);
		compound.setInteger("rgb", current.packed);
		this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
		this.container.send(Side.SERVER, compound);
	}

	private RGB tryParse(String text, boolean hex){
		RGB rgb = null; try{
			if(hex){
				rgb = new RGB(); rgb.packed = Integer.parseInt(text.replace("#", ""), 16);
			}
			else{
				String[] str = text.trim().replace(" ", "").split(",");
				rgb = new RGB(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			}
		}
		catch(Exception e){
			e.printStackTrace(); this.titletext.update("Error parsing " + (hex ? "HEX Code" : "RGB Color") + ".", RGB.RED.packed);
		} return rgb;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	public static class Spectrum extends BasicButton {
		
		private RGB[] rgbs = new RGB[32];
		private int size;

		public Spectrum(int x, int y, int width){
			super("spectrum", x, y, 0, 0, width, buttonheight - 2, true); size = width / rgbs.length;
			for(int i = 0; i < rgbs.length; i ++){
				float c = i * (1f / rgbs.length);
				int r, g, b;
				//
		        if(c >= 0 && c <= (1/6.f)){
		            r = 255;
		            g = (int)(1530 * c);
		            b = 0;
		        }
		        else if( c > (1/6.f) && c <= (1/3.f) ){
		            r = (int)(255 - (1530 * (c - 1/6f)));
		            g = 255;
		            b = 0;
		        }
		        else if( c > (1/3.f) && c <= (1/2.f)){
		            r = 0;
		            g = 255;
		            b = (int)(1530 * (c - 1/3f));
		        }
		        else if(c > (1/2f) && c <= (2/3f)) {
		            r = 0;
		            g = (int)(255 - ((c - 0.5f) * 1530));
		            b = 255;
		        }
		        else if( c > (2/3f) && c <= (5/6f) ){
		            r = (int)((c - (2/3f)) * 1530);
		            g = 0;
		            b = 255;
		        }
		        else if(c > (5/6f) && c <= 1 ){
		            r = 255;
		            g = 0;
		            b = (int)(255 - ((c - (5/6f)) * 1530));
		        }
		        else{ r = 127; g = 127; b = 127; }
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
			int i = (mouseX - x) / size; if(i < 0 || i >= 32) return current; return rgbs[i];
		}
		
	}
	
	public static class Palette extends BasicButton {
		
		private RGB[][] rgbs = new RGB[8][4];
		private int wx, hy;

		public Palette(int x, int y, int width){
			super("palette", x, y, 0, 0, width, (4 * buttonheight) - 2, true); wx = sizex / 8; hy = sizey / 4;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 4; j++){
					rgbs[i][j].glColorApply();
		            gui.drawTexturedModalRect(x + (i * wx), y + (j * hy), 1, 1, wx, hy);
		            RGB.glColorReset();
				}
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
		
		protected void recalc(){
			byte[] arr = current.toByteArray();
			int[] err = new int[]{ arr[0] + 128, arr[1] + 128, arr[2] + 128 };
			for(int x = 0; x < 8; x++){
				for(int z = 0; z < 4; z++){
					int y = x * 8 + z;
					float e = (1f / (8 * 4) * y), f = (1f / 8) * z, h = (255 / 8) * x;
					int r = (int)Math.abs((e * err[0]) + ((1 - f) * h));
					int g = (int)Math.abs((e * err[1]) + ((1 - f) * h));
					int l = (int)Math.abs((e * err[2]) + ((1 - f) * h));
					rgbs[x][z] = new RGB(r, g, l);
				}
			}
		}

		public RGB getColorAt(int mouseX, int mouseY){
			int xx = (mouseX - x) / wx, yy = (mouseY - y) / hy;
			if(xx < 0 || xx >= 8 || yy < 0 || yy >= 4) return current; return rgbs[xx][yy];
		}
		
	}
	
	public static class Preview extends BasicButton {

		public Preview(int x, int y, int width){
			super("preview", x, y, 0, 0, width, buttonheight - 2, true);
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
            current.glColorApply();
            gui.drawTexturedModalRect(x, y, 1, 1, sizex, sizey);
            RGB.glColorReset();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
		
	}
	
	public void updateColorTo(RGB rgb, boolean update_pallet){
		current = rgb; cfields[3].setText("#" + Integer.toHexString(current.packed));
		byte[] arr = rgb.toByteArray(); cfields[1].setText((arr[0] + 128) + ", " + (arr[1] + 128) + ", " + (arr[2] + 128));
		if(update_pallet) palette.recalc();
	}
	
}
