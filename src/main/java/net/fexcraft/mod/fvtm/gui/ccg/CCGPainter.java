package net.fexcraft.mod.fvtm.gui.ccg;

import java.io.IOException;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPainter extends GenericGui<CCGPainter.Container> {
	
	private int[] pos;
	private boolean view;
	private RGB rgb;
	private byte prisec;

	public CCGPainter(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/ccg_painter.png"), new Container(world, x, y, z), player);
		this.xSize = 200; this.ySize = 32; this.pos = new int[]{ x, y, z };
		this.deftexrect = false; this.defbackground = false; prisec = 1;
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(13, 4, 154, null, "..."));
		this.buttons.put("view", new BasicButton("view", 175, 19, 175, 19, 10, 10, true));
		this.buttons.put("apply", new BasicButton("apply", 187, 19, 187, 19, 10, 10, true));
		this.buttons.put("primary", new BasicButton("primary", 175, 3, 175, 3, 10, 10, true));
		this.buttons.put("secondary", new BasicButton("secondary", 187, 3, 187, 3, 10, 10, true));
		//
		this.buttons.put("spectrum", new SpectrumButton());
		this.buttons.put("palette", new PaletteButton());
		//
		this.fields.put("red", new GuiTextField(0, fontRenderer, 11, 19, 46, 10));
		this.fields.put("green", new GuiTextField(1, fontRenderer, 67, 19, 46, 10));
		this.fields.put("blue", new GuiTextField(2, fontRenderer, 123, 19, 46, 10));
		//
		this.refreshRGB();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("title").string = container.tile.getColorable() == null ? "nothing in constructor" : container.tile.getColorable() instanceof VehicleData ? container.tile.getVehicleData().getVehicle().getName() : container.tile.getContainerData().getContainer().getName();
		buttons.get("spectrum").visible = buttons.get("palette").visible = view;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
		if(view){
			this.drawTexturedModalRect(0, 32, 0, 32, 134, 15);
			this.drawTexturedModalRect(0, 47, 0, 47, 70, 69);
			this.drawTexturedModalRect(70, 47, 70, 47, 36, 36);
			rgb.glColorApply();
			this.drawTexturedModalRect(73, 50, 73, 50, 32, 32);
			RGB.glColorReset();
		}
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "view":{ view = !view; break; }
			case "apply":{ send(); break; }
			case "primary":{
				prisec = 1; refreshRGB();
				break;
			}
			case "secondary":{
				prisec = 2; refreshRGB();
				break;
			}
			case "spectrum":{
				int mx = mouseX - button.x; if(mx > 127) mx = 127; if(mx < 0) mx = 0;
				rgb = ((SpectrumButton)button).spectrum[mx / 2]; refreshRGB();
				break;
			}
			case "palette":{
				PaletteButton pb = (PaletteButton)buttons.get("palette");
				int mx = mouseX - button.x, my = mouseY - button.y;
				if(mx > 63) mx = 63; if(my > 63) my = 63; if(mx < 0) mx = 0; if(my < 0) my = 0;
				int x = 0, y = 0; while((mx -= pb.dav) > 0) x++; while((my -= pb.dav) > 0) y++;
				Print.debug(mx, my, x, y, mouseX - button.x, mouseY - button.y);
				this.rgb = pb.palette[x * pb.div + y]; send();
				break;
			}
		}
	}
	
	private final void send(){
        NBTTagCompound compound = new NBTTagCompound();
        compound.setIntArray("pos", pos);
        compound.setByteArray("rgb", rgb.toByteArray());
        compound.setByte("which", prisec);
        this.container.send(Side.SERVER, compound);
	}
	
	private void refreshRGB(){
		if(container.tile.getColorable() == null){ ((PaletteButton)buttons.get("palette")).palette = null; return; }
		if(rgb == null){
			rgb = prisec == 1 ? container.tile.getColorable().getPrimaryColor() : container.tile.getColorable().getSecondaryColor();
		}
		PaletteButton b = (PaletteButton)buttons.get("palette"); b.palette = new RGB[b.dev];
		byte[] arr = rgb.toByteArray();
		int[] err = new int[]{ arr[0] + 128, arr[1] + 128, arr[2] + 128 };
		for(int x = 0; x < b.div; x++){
			for(int z = 0; z < b.div; z++){
				int y = x * b.div + z;
				float e = (1f / b.dev) * y, f = (1f / b.div) * z, h = (255 / b.div) * x;
				int r = (int)Math.abs((e * err[0]) + ((1 - f) * h));
				int g = (int)Math.abs((e * err[1]) + ((1 - f) * h));
				int l = (int)Math.abs((e * err[2]) + ((1 - f) * h));
				b.palette[y] = new RGB(r, g, l); //Print.debug(b.palette[y]);
			}
		}
		fields.get("red").setText(err[0] + "");
		fields.get("green").setText(err[1] + "");
		fields.get("blue").setText(err[2] + "");
	}

	public static class Container extends GenericGuiContainer {
		
		private ConstructorControllerEntity tile;

		public Container(World world, int x, int y, int z){
			tile = (ConstructorControllerEntity)world.getTileEntity(new BlockPos(x, y, z));
		}

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			if(side.isClient() || !packet.hasKey("rgb")) return;
			byte[] rgb = packet.getByteArray("rgb"); byte prisec = packet.getByte("which");
			RGB color = prisec == 1 ? tile.getColorable().getPrimaryColor() : tile.getColorable().getSecondaryColor();
			color.packed = new RGB(rgb).packed;
			tile.sendUpdate("color");
		}
		
	}
	
	public static class SpectrumButton extends BasicButton {
		
		private int div = 64/*16,32*/, dev = 128 / div;
		private RGB[] spectrum = new RGB[div];

		public SpectrumButton(){
			super("sptr", 3, 34, 3, 34, 128, 10, true);
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			if(spectrum[0] == null){
				for(int i = 0; i < div; i ++){
					float c = i * (1f / div);
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
					spectrum[i] = new RGB(r, g, b);
				}
			}
			for(int i = 0; i < div; i++){
				spectrum[i].glColorApply();
				gui.drawTexturedModalRect(x + (i * dev), y, tx + (i * dev), ty, dev, sizey);
				RGB.glColorReset();
			}
		}
		
	}
	
	public static class PaletteButton extends BasicButton {
		
		private int div = 16, dev = div * div, dav = 4;
		private RGB[] palette = new RGB[dev];

		public PaletteButton() {
			super("palette", 3, 49, 3, 49, 64, 64, true);
		}
		
		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return; if(palette == null || palette[0] == null) return;
			for(int x = 0; x < div; x ++){
				for(int z = 0; z < div; z ++){
					palette[x * div + z].glColorApply();
					gui.drawTexturedModalRect(this.x + (x * dav), this.y + (z * dav), tx + (x * dav), ty + (z * dav), dav, dav);
					RGB.glColorReset();
				}
			}
		}
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1) this.openGui(GuiHandler.CCG_Main, pos);
        if(keyCode == 28){
        	if(fields.get("red").isFocused()){
        		try{
        			byte[] arr = rgb.toByteArray();
        			rgb = new RGB(Integer.parseInt(fields.get("red").getText()), arr[1] + 128, arr[2] + 128);
        		}
        		catch(Exception e){
        			e.printStackTrace(); Print.chat(mc.player, "Error while parsing number [RGB-R]");
        		}
        	}
        	else if(fields.get("green").isFocused()){
        		try{
        			byte[] arr = rgb.toByteArray();
        			rgb = new RGB(arr[0] + 128, Integer.parseInt(fields.get("green").getText()), arr[2] + 128);
        		}
        		catch(Exception e){
        			e.printStackTrace(); Print.chat(mc.player, "Error while parsing number [RGB-G]");
        		}
            }
        	else if(fields.get("blue").isFocused()){
        		try{
        			byte[] arr = rgb.toByteArray();
        			rgb = new RGB(arr[0] + 128, arr[1] + 128, Integer.parseInt(fields.get("blue").getText()));
        		}
        		catch(Exception e){
        			e.printStackTrace(); Print.chat(mc.player, "Error while parsing number [RGB-B]");
        		}
        	}
        }
        super.keyTyped(typedChar, keyCode);
    }
	
}