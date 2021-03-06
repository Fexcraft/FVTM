package net.fexcraft.mod.fvtm.gui.constructor;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.FVTM;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public abstract class ConstructorGui extends GenericGui<ConstructorContainer> {
	
	public static final ResourceLocation STONE = new ResourceLocation("minecraft:textures/blocks/stone.png");
	public static final ResourceLocation ANVIL = new ResourceLocation("minecraft:textures/blocks/anvil_base.png");
	public static final ResourceLocation ICON_LEFT = new ResourceLocation("fvtm:textures/gui/icons/arrow_left.png");
	public static final ResourceLocation ICON_RIGHT = new ResourceLocation("fvtm:textures/gui/icons/arrow_right.png");
	public static final ResourceLocation ICON_UP = new ResourceLocation("fvtm:textures/gui/icons/arrow_up.png");
	public static final ResourceLocation ICON_DOWN = new ResourceLocation("fvtm:textures/gui/icons/arrow_down.png");
	public static final ResourceLocation ICON_CHECK = new ResourceLocation("fvtm:textures/gui/icons/check.png");
	public static final ResourceLocation ICON_REMOVE = new ResourceLocation("fvtm:textures/gui/icons/remove.png");
	public static final ResourceLocation ICON_EDIT0 = new ResourceLocation("fvtm:textures/gui/icons/edit.png");
	public static final ResourceLocation ICON_EDIT1 = new ResourceLocation("fvtm:textures/gui/icons/edit2.png");
	public static final ResourceLocation ICON_QMARK = new ResourceLocation("fvtm:textures/gui/icons/qmark.png");
	//
	public static final ResourceLocation ICON_BOOL_BACK = new ResourceLocation("fvtm:textures/gui/icons/bool_back.png");
	public static final ResourceLocation ICON_BOOL_TRUE = new ResourceLocation("fvtm:textures/gui/icons/bool_on.png");
	public static final ResourceLocation ICON_BOOL_FALSE = new ResourceLocation("fvtm:textures/gui/icons/bool_off.png");
	public static final ResourceLocation ICON_BOOL_TRI0 = new ResourceLocation("fvtm:textures/gui/icons/bool_tri0.png");
	public static final ResourceLocation ICON_BOOL_TRI1 = new ResourceLocation("fvtm:textures/gui/icons/bool_tri1.png");
	//
	public static final RGB RGB_ORANGE = new RGB(0xFFA000);
	public static final RGB RGB_CYAN = new RGB(0x00DDFF);
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
	protected CenterBox cbox;

	public ConstructorGui(EntityPlayer player, World world, int x, int y, int z){
		this(new ConstructorContainer(player, world, x, y, z), player, x, y, z);
	}

	public ConstructorGui(ConstructorContainer container, EntityPlayer player, int x, int y, int z){
		super(STONE, container, player);
		this.defbackground = false;
		this.deftexrect = false;
		xyz = new int[]{ x, y, z };
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
				this.buttons.put("button" + i, cbuttons[i] = new BasicButton("button" + i, 2, 20 + (i * buttonheight), 0, 0, getButtonWidth(buttontext[i]), 10, true));
				cbuttons[i].rgb_hover = new RGB("#8f9924"/*"#d9df99"*/, 0.8f); cbuttons[i].rgb_none.alpha = 0.8f;
				if(buttontext[i].equals("") || buttontext[i].startsWith("||")) cbuttons[i].enabled = false;
				if(buttontext[i].startsWith("||")) tbuttons[i].string = buttontext[i].replace("||", "");
				if(!buttontext[i].startsWith(";;")){
					tbuttons[i].translate();
					cbuttons[i].sizex = getButtonWidth(tbuttons[i].string);
				}
				else tbuttons[i].string = buttontext[i].replace(";;", "");
			}
		}
		cbox = new CenterBox(this, 128, 128);
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException{
        super.keyTyped(typedChar, keyCode);
        if(keyCode == Keyboard.KEY_DOWN){
    		NBTTagCompound compound = new NBTTagCompound();
    		compound.setString("cargo", "lift");
    		compound.setInteger("dir", 1);
    		this.container.send(Side.SERVER, compound);
    		return;
        }
        else if(keyCode == Keyboard.KEY_UP){
    		NBTTagCompound compound = new NBTTagCompound();
    		compound.setString("cargo", "lift");
    		compound.setInteger("dir", -1);
    		this.container.send(Side.SERVER, compound);
        }
    }
	
	public int getButtonWidth(String str){
		int width = fontRenderer.getStringWidth(str);
		return width > xSize - 4 ? width : xSize - 4;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		titletext.update(); 
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
		this.drawTexturedModalRect(this.xSize, 0, 0, 0, this.width - this.xSize, 16);
		this.mc.getTextureManager().bindTexture(ANVIL); cbox.draw(pticks, mouseX, mouseY);
	}
	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("center_exit")){ cbox.exit(); return true; } return false;
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
			this.string = newtext;
			if(!string.startsWith(";;")) string = I18n.format(string);
			this.width = gui.mc.fontRenderer.getStringWidth(string);
			if(color != null) this.color = color;
		}
		
	}
	
	public static class IconButton extends BasicButton {
		
		public ResourceLocation texture; 
		private int button, index;
		private boolean left;
		private CenterBox box;
		public BasicButton cbutton;

		public IconButton(String name, int button, int index, boolean left, ResourceLocation texture){
			super(name, 0, 0, 0, 0, 8, 8, true); this.button = button; this.index = index; this.left = left;
			this.rgb_hover = RGB.GREEN.copy(); this.rgb_disabled = RGB.RED.copy(); this.rgb_none = RGB.WHITE.copy();
			this.texture = texture;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			if(box != null){
				this.x = box.x;
				int off = 2 + (index * (2 + sizex));
				this.x += left ? off : box.width - off - sizex;
				this.y = box.y + 1;
			}
			else{
				int off = 2 + (index * (2 + sizex));
				if(cbutton == null){
					ConstructorGui g = (ConstructorGui)gui;
					cbutton = g.cbuttons[button];
					if(g.fontRenderer.getStringWidth(g.tbuttons[button].string) + off + sizex > g.xSize - 8){
						cbutton.sizex += 12;
					}
				}
				this.x = cbutton.x;
				this.x += left ? off : cbutton.sizex - off - sizex;
				this.y = cbutton.y + 1;
			}
			gui.mc.renderEngine.bindTexture(texture);
			RGB rgb = hovered ? enabled ? rgb_hover : rgb_disabled : rgb_none; RGB.glColorReset();
            rgb.glColorApply(); Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, 8, 8, 8, 8); RGB.glColorReset();
			gui.mc.renderEngine.bindTexture(gui.getTexLoc());
		}

		public IconButton setCenterBound(CenterBox centerbox){
			this.box = centerbox; return this;
		}

		public IconButton setCenterButtonBound(BasicButton button){
			this.cbutton = button; return this;
		}

		public BasicButton setEnabled(boolean bool){
			this.enabled = bool; return this;
		}
		
	}
	
	public static class CenterBox {
		
		private int width, height, x, y;
		public boolean visible = false;
		private ConstructorGui gui;
		public IconButton exit;
		public ArrayList<BasicText> texts = new ArrayList<>();
		public ArrayList<BasicButton> buttons = new ArrayList<>();
		
		public CenterBox(ConstructorGui gui, int width, int height){
			this.width = width; this.height = height; this.gui = gui;
			gui.buttons.put("center_exit", exit = new IconButton("center_exit", 0, 0, false, ICON_REMOVE).setCenterBound(this));
		}

		public void exit(){
			this.visible = false;
			gui.buttons.values().removeIf(pre -> buttons.contains(pre));
			gui.texts.values().removeIf(pre -> texts.contains(pre));
			texts.clear(); buttons.clear();
		}

		public void draw(float pticks, int mouseX, int mouseY){
			exit.visible = this.visible; if(!visible) return;
			this.x = (gui.width / 2) - (width / 2);
			this.y = (gui.height / 2) - (height / 2);
            Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, 16, 16);
		}
		
		public CenterBox resize(int w, int h){
			this.width = w; this.height = h; return this;
		}
		
		public int getWidth(){ return width; }
		public int getHeight(){ return height; }
		
	}

	//To be overriden.
	public void onTitleTextUpdate(){}

	//To be overriden.
	public void onClientPacket(NBTTagCompound nbt){}

}
