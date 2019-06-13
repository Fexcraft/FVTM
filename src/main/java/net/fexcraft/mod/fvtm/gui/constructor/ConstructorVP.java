package net.fexcraft.mod.fvtm.gui.constructor;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/** Vehicle Color Painter */
public class ConstructorVP extends ConstructorGui {
	
	private static RGB current, org_p, org_s;
	private boolean primary = true;
	private Spectrum spectrum;
	private Palette palette;
	private Preview preview;
	private TextField rgb, hex;

	public ConstructorVP(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||RGB" , "", "||HEX", "", "", "", "", "", "", "", "||", "||T: ----", "< Back" };
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Vehicle Color Painter";
		VehicleData vdata = container.getTileEntity().getVehicleData();
		current = primary ? vdata.getPrimaryColor() : vdata.getSecondaryColor();
		org_p = vdata.getPrimaryColor().copy(); org_s = vdata.getSecondaryColor().copy();
		this.buttons.put("icon_rgb", new IconButton("icon_rgb", 0, 0, false, ICON_CHECK));
		this.buttons.put("icon_hex", new IconButton("icon_hex", 2, 0, false, ICON_CHECK));
		this.buttons.put("icon_try", new IconButton("icon_try", 10, 2, false, ICON_QMARK));
		this.buttons.put("icon_check", new IconButton("icon_check", 10, 1, false, ICON_CHECK));
		this.buttons.put("icon_remove", new IconButton("icon_remove", 10, 0, false, ICON_REMOVE));
		this.buttons.put("icon_type_prev", new IconButton("icon_type_prev", 11, 1, false, ICON_LEFT));
		this.buttons.put("icon_type_next", new IconButton("icon_type_next", 11, 0, false, ICON_RIGHT));
		this.buttons.put("spectrum", spectrum = new Spectrum(2, 20 + (5 * buttonheight), xSize - 4));
		this.buttons.put("palette", palette = new Palette(2, 20 + (6 * buttonheight), xSize - 4));
		this.buttons.put("preview", preview = new Preview(2, 20 + (4 * buttonheight), xSize - 4));
		this.fields.put("rgb", cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10));
		this.fields.put("hex", cfields[3] = new TextField(2, fontRenderer, 2, 20 + (3 * buttonheight), xSize - 4, 10));
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
		if(button.name.equals("button12")){ this.openGui(modid, 900, xyz); return true; }
		else if(button.name.equals("icon_type_prev") || button.name.equals("icon_type_next")){ primary = !primary; return true; }
		return true;
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
		
	}
	
	public static class Palette extends BasicButton {

		public Palette(int x, int y, int width){
			super("palette", x, y, 0, 0, width, (4 * buttonheight) - 2, true);
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
            RGB.BLUE.glColorApply();
            //
            gui.drawTexturedModalRect(x, y, 1, 1, sizex, sizey);
            //
            RGB.glColorReset();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
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
	
}
