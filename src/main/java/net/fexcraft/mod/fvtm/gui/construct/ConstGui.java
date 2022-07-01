package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.FOOTER;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.LIFT;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.SPACER;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.TOP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstGui extends GenericGui<ConstContainer> {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation("fvtm:textures/gui/constructor_base.png");
	public static String REQUEST_SENT = "gui.fvtm.constructor.request_sent";
	protected String help_url = "https://fexcraft.net/wiki/mod/fvtm/constructor";
	private ReturnAddList<BasicButton> topbuttons = new ReturnAddList<>();
	private ReturnAddList<ConstElement> elements = new ReturnAddList<>();
	protected int root = GuiHandler.CONSTRUCTOR_MAIN;
	private ConstGui instance = this;
	protected TitleText titletext;
	protected BasicText menutitle;
	protected String texttitle = "Fex's Vehicle and Transporation Mod";
	protected ArrayList<String> info = new ArrayList<String>();
	protected HashMap<BasicButton, Object> infotext = new HashMap<>();
	protected final int[] tilepos;
	//
	public static final RGB RGB_ORANGE = new RGB(0xFFA000);
	public static final RGB RGB_CYAN = new RGB(0x00DDFF);
	public static final RGB RGB_TEXT_LIGHTGRAY = new RGB(222, 222, 222);
	public static final RGB RGB_TEXT_GRAY = new RGB(98, 98, 98);
	//
	public ConstGui(EntityPlayer player, World world, int x, int y, int z){
		this(new ConstContainer(player, world, x, y, z), player, x, y, z);
	}

	public ConstGui(ConstContainer container, EntityPlayer player, int x, int y, int z){
		super(TEXTURE, container, player);
		defbackground = false;
		deftexrect = false;
		tilepos = new int[]{ x, y, z };
		container.setGUI(this);
	}
	
	@Override
	protected void init(){
		buttons.clear();
		texts.clear();
		topbuttons.clear();
		elements.clear();
		ySize = height;
		xSize = 144;
		int gray = new RGB(63, 63, 63).packed;
		texts.put("title", titletext = new TitleText(this, texttitle, gray));
		texts.put("menutitle", menutitle = new BasicText(4, 2, width, gray, I18n.format("gui.fvtm.constructor.welcome", player.getDisplayNameString())));
		buttons.put("lift_up", new BasicButton("lift_up", 142, 41, 142, 41, 7, 12, true){
			@Override
			public boolean onclick(int mouseX, int mouseY, int mouseButton){
	    		NBTTagCompound compound = new NBTTagCompound();
	    		compound.setString("cargo", "lift");
	    		compound.setInteger("dir", -1);
	    		instance.container.send(Side.SERVER, compound);
				return true;
			}
		});
		buttons.put("lift_dw", new BasicButton("lift_dw", 150, 41, 150, 41, 7, 12, true){
			@Override
			public boolean onclick(int mouseX, int mouseY, int mouseButton){
	    		NBTTagCompound compound = new NBTTagCompound();
	    		compound.setString("cargo", "lift");
	    		compound.setInteger("dir", 1);
	    		instance.container.send(Side.SERVER, compound);
				return true;
			}
		});
		finish_init();
	}
	
	protected void finish_init(){
		menutitle.x = topbuttons.size() * 12 + 4;
	}
	
	public void setMenuTitle(String lang){
		menutitle.string = lang;
		menutitle.translate();
	}

	public void addTopButton(ConstGuiElement type){
		int size = topbuttons.size();
		BasicButton button = null;
		buttons.put("top" + size, button = topbuttons.addB(new BasicButton("tb" + size, size * 12, 0, type.x, type.y, type.w, type.h, true){
			@Override
			public boolean onclick(int mouseX, int mouseY, int mouseButton){
				switch(type){
					case BACK:{
						openGui(root, tilepos, LISTENERID);
						break;
					}
					case HELP:{
						instance.mc.displayGuiScreen(new GuiConfirmOpenLink(instance, help_url, 31102009, true){
			                @Override
			                public void drawScreen(int mouseX, int mouseY, float partialTicks){
			                	//instance.drawScreen(-1, -1, partialTicks);
			                    super.drawScreen(mouseX, mouseY, partialTicks);
			                }
			            });
						break;
					}
					case SAVE:{
						NBTTagCompound compound = new NBTTagCompound();
						compound.setString("cargo", "drop");
						compound.setString("what", "any"); 
						instance.titletext.update(REQUEST_SENT, RGB_CYAN.packed);
						instance.container.send(Side.SERVER, compound);
						break;
					}
					case SPAWN:{
						instance.titletext.update("gui.fvtm.constructor.not_available", null);
						break;
					}
					default: break;
				}
				return true;
			}
		}.alpha(false)));
		switch(type){
			case BACK:{
				infotext.put(button, "gui.fvtm.constructor.back");
				break;
			}
			case HELP:{
				infotext.put(button, new String[]{ "gui.fvtm.constructor.help", help_url });
				break;
			}
			case SAVE:{
				infotext.put(button, "gui.fvtm.constructor.save");
				break;
			}
			case SPAWN:{
				infotext.put(button, "gui.fvtm.constructor.spawn");
				break;
			}
			default: break;
		}		
	}
	
	public void addElement(ConstGuiElement type, String name, String lang, Runnable run){
		int index = elements.size();
		ConstElement elm = elements.addB(new ConstElement(name, type, index));
		switch(type){
			case GENERIC_SEG:{
				buttons.put(name, (elm.buttons = new BasicButton[]{ new RunButton(name, 2, 17 + 12 * index, type.x + 2, type.y + 1, 135, 10, run) })[0]);
				break;
			}
			default: break;
		}
		switch(type){
			case GENERIC_SEG:
			case BLANK_SEG:
			case EMPTY_SEG:{
				if(type == ConstGuiElement.EMPTY_SEG && lang == null) break;
				boolean generic = type == ConstGuiElement.GENERIC_SEG;
				RGB gray = generic ? RGB_TEXT_LIGHTGRAY : RGB_TEXT_GRAY;
				texts.put(name, (elm.texts = new BasicText[]{ new BasicText(4, 18 + 12 * index, 131, gray.packed, format(lang)).hoverable(generic).autoscale().withshadow(generic) })[0]);
				break;
			}
			default: break;
		}
	}
	
    private String format(String lang){
		return Formatter.format(I18n.format(lang));
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
		drawElement(TOP, 0, 0, width, 16);
		drawElement(SPACER, 0, 16);
		drawElement(LIFT, 139, 17);
		drawElement(FOOTER, 0, 16 + elements.size() * 12);
		for(ConstElement elm : elements){
			if(elm.index > 3) drawElement(elm.elm, 0, 16 + elm.index * 12);
			else drawElement(elm.elm, 0, 16 + elm.index * 12, elm.elm.w - 5, elm.elm.h);
		}
	}
	
	private void drawElement(ConstGuiElement elm, int x, int y){
		drawTexturedModalRect(x, y, elm.x, elm.y, elm.w, elm.h);
	}
	
	private void drawElement(ConstGuiElement elm, int x, int y, int w, int h){
		drawTexturedModalRect(x, y, elm.x, elm.y, w, h);
	}
	
	@Override
	protected void drawlast(float pticks, int mouseX, int mouseY){
	    info.clear();
	    Object text = null;
	    for(BasicButton button : buttons.values()){
	    	if(!button.hovered) continue;
	    	text = infotext.get(button);
	    	if(text == null) continue;
    		if(text instanceof String) info.add(I18n.format(text.toString()));
    		else {
    			for(String str : (String[])text){
    				info.add(I18n.format(str));
    			}
    		}
	    }
	    if(info.isEmpty()){
		    for(BasicText btext : texts.values()){
		    	if(!btext.hovered) continue;
		    	info.add(btext.string);
		    }
	    }
	    if(info.size() > 0) drawHoveringText(info, mouseX, mouseY, mc.fontRenderer);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		return false;
	}
	
	public static class TitleText extends BasicText {
		
		private GenericGui<?> gui;

		public TitleText(GenericGui<?> gui, String string, int color){
			super(0, 2, 100, null, string);
			this.gui = gui;
			update(string, color);
		}
		
		public void update(String newtext, Integer color){
			string = newtext;
			if(!string.contains(":")) string = I18n.format(string);
			else{
				String[] split = string.split(":");
				string = I18n.format(split[0], (Object[])Arrays.copyOfRange(split, 1, split.length));
			}
			string = Formatter.format(string);
			width = gui.mc.fontRenderer.getStringWidth(string);
			if(color != null) this.color = color;
			x = gui.width - width - 4;
		}
		
	}
	
	public static class ReturnAddList<T> extends ArrayList<T> {
		
		public T addB(T button){
			super.add(button);
			return button;
		}
		
	}
	
	public static class ConstElement {
		
		protected String id;
		protected int index;
		protected ConstGuiElement elm;
		protected BasicButton[] buttons;
		protected BasicText[] texts;
		protected TextField[] fields;
		
		public ConstElement(String id, ConstGuiElement elm, int index){
			this.id = id;
			this.elm = elm;
			this.index = index;
		}
		
	}
	
	public static class RunButton extends BasicButton {

		private Runnable run;

		public RunButton(String name, int x, int y, int tx, int ty, int sizex, int sizey, Runnable run){
			super(name, x, y, tx, ty, sizex, sizey, true);
			this.run = run;
		}
		
		@Override
		public boolean onclick(int mouseX, int mouseY, int mouseButton){
			if(run != null) run.run();
			return true;
		}
		
	}

	//To be overriden.
	public void onTitleTextUpdate(){}

	//To be overriden.
	public void onClientPacket(NBTTagCompound nbt){}

}
