package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ConstructorGui extends GenericGui<ConstructorContainer> {
	
	private static final ResourceLocation STONE = new ResourceLocation("minecraft:textures/blocks/stone.png");
	private static final ResourceLocation ANVIL = new ResourceLocation("minecraft:textures/blocks/anvil_base.png");

	public ConstructorGui(EntityPlayer player, World world, int x, int y, int z){
		super(STONE, new ConstructorContainer(player, world, x, y, z), player);
		this.defbackground = false; this.deftexrect = false;
	}
	
	private TitleText titletext;
	private BasicText menutitle;
	private BasicText[] tbuttons = new BasicText[9];
	private BasicButton[] cbuttons = new BasicButton[9];
	private String[] main = new String[]{ "Constructor Status", "Vehicle Data", "Part Manager", "Part Installer", "- - - -", "Texture Manager", "Spraying Tool", "- - - -", "Exit"};

	@Override
	protected void init(){
		this.ySize = this.height; this.xSize = this.width / 4; int white = new RGB(228, 235, 228).packed;
		this.texts.put("title", titletext = new TitleText(this, "Fex's Vehicle & Transporation Mod"));
		this.texts.put("menutitle", menutitle = new BasicText(4, 4, width, white, "Welcome " + player.getDisplayNameString() + "!"));
		for(int i = 0; i < 9; i++){
			this.buttons.put("button" + i, cbuttons[i] = new BasicButton("button" + i, 2, 20 + (i * 12), 0, 0, xSize - 4, 10, true));
			this.texts.put("button" + i, tbuttons[i] = new BasicText(4, 21 + (i * 12), xSize - 8, white, main[i]));
			cbuttons[i].rgb_hover.alpha = cbuttons[i].rgb_none.alpha = 0.8f;
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		titletext.update();
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
		this.mc.getTextureManager().bindTexture(ANVIL);
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		// TODO Auto-generated method stub
		
	}
	
	public static class TitleText extends BasicText {
		
		private GenericGui<?> gui;

		public TitleText(GenericGui<?> gui, String string){
			super(0, 4, gui.mc.fontRenderer.getStringWidth(string), null, string); this.gui = gui;
		}

		public void update(){
			this.x = gui.width - width - 4;
		}
		
		public void update(String newtext){
			this.string = newtext; this.width = gui.mc.fontRenderer.getStringWidth(newtext);
		}
		
	}

}
