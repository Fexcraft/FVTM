package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class ConstructorGui extends GenericGui<ConstructorContainer> {
	
	private static final ResourceLocation STONE = new ResourceLocation("minecraft:textures/blocks/stone.png");
	private static final ResourceLocation ANVIL = new ResourceLocation("minecraft:textures/blocks/anvil_base.png");
	//
	protected static final String modid = FVTM.MODID;
	protected static final int buttonheight = 12;
	protected TitleText titletext;
	protected BasicText menutitle;
	protected BasicText[] tbuttons;
	protected BasicButton[] cbuttons;
	protected TextField[] cfields;
	protected String[] buttontext;
	protected String texttitle = "Fex's Vehicle & Transporation Mod";
	protected final int[] xyz;
	protected boolean removeEmptyButtons;

	public ConstructorGui(EntityPlayer player, World world, int x, int y, int z){
		super(STONE, new ConstructorContainer(player, world, x, y, z), player);
		this.defbackground = false; this.deftexrect = false; xyz = new int[]{ x, y, z };
		this.container.setGUI(this);
	}
	
	@Override
	protected void init(){
		this.ySize = this.height; this.xSize = this.width / 4; int white = new RGB(228, 235, 228).packed;
		this.texts.put("title", titletext = new TitleText(this, texttitle, white));
		this.texts.put("menutitle", menutitle = new BasicText(4, 4, width, white, "Welcome " + player.getDisplayNameString() + "!"));
		tbuttons = new BasicText[buttontext.length]; cbuttons = new BasicButton[buttontext.length]; cfields = new TextField[buttontext.length];
		for(int i = 0; i < buttontext.length; i++){
			if(!(removeEmptyButtons && buttontext[i].equals(""))){
				this.texts.put("button" + i, tbuttons[i] = new BasicText(4, 21 + (i * buttonheight), xSize - 8, white, buttontext[i]));
				this.buttons.put("button" + i, cbuttons[i] = new BasicButton("button" + i, 2, 20 + (i * buttonheight), 0, 0, xSize - 4, 10, true));
				cbuttons[i].rgb_hover = new RGB("#8f9924"/*"#d9df99"*/, 0.8f); cbuttons[i].rgb_none.alpha = 0.8f;
				if(buttontext[i].equals("") || buttontext[i].startsWith("||")){ cbuttons[i].enabled = false; }
				if(buttontext[i].startsWith("||")) tbuttons[i].string = buttontext[i].replace("||", "");
				if(!buttontext[i].startsWith(";;")) tbuttons[i].translate();
				else tbuttons[i].string = buttontext[i].replace(";;", "");
			}
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		titletext.update();
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
		this.drawTexturedModalRect(this.xSize, 0, 0, 0, this.width - this.xSize, 16);
		this.mc.getTextureManager().bindTexture(ANVIL);
	}
	
	public static class TitleText extends BasicText {
		
		private GenericGui<?> gui;

		public TitleText(GenericGui<?> gui, String string, int color){
			super(0, 4, gui.mc.fontRenderer.getStringWidth(string), null, string); this.gui = gui; this.color = color;
		}

		public void update(){
			this.x = gui.width - width - 4;
		}
		
		public void update(String newtext, Integer color){
			this.string = newtext; this.width = gui.mc.fontRenderer.getStringWidth(newtext);
			if(color != null) this.color = color;
		}
		
	}
	
	public static class IconButton extends BasicButton {
		
		private int button, index;
		private boolean left;

		public IconButton(String name, int button, int index, int size, boolean left){
			super(name, 0, 0, 0, 0, size, size, true); this.button = button; this.index = index; this.left = left;
			this.rgb_hover = RGB.GREEN.copy(); this.rgb_disabled = RGB.RED.copy(); this.rgb_none = RGB.WHITE.copy();
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return; ConstructorGui g = (ConstructorGui)gui;
			this.x = g.cbuttons[button].x; int off = 2 + (index * (2 + sizex));
			this.x += left ? off : g.cbuttons[button].sizex - off - sizex;
			this.y = g.cbuttons[button].y + 1;
			super.draw(gui, pticks, mouseX, mouseY);
		}
		
	}

	//To be overriden.
	public void onTitleTextUpdate(){}

}
