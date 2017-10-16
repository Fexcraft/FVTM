package net.fexcraft.mod.fme.overlay;

import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SelectedPolygon extends GuiScreen {
	
	public SelectedPolygon(){
		if(INSTANCE != null){
			Static.halt();
		}
		mc = Minecraft.getMinecraft();
		INSTANCE = this;
	}
	
	public static SelectedPolygon INSTANCE;
	private static boolean shown;
	//private String group = "body";
	//private int element = -1;
	public static final ResourceLocation texture = new ResourceLocation("fme:textures/gui/box_stats.png");
	//
	private PolygonType type = PolygonType.NONE;
	
	@SubscribeEvent
	public void display(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && shown && type.any()){
			mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(0, 0, 0, 0, 103, 54);
			//
			if(type.isRectangle()){
				
			}
			else if(type.isCylinder()){
				
			}
			else if(type.isShape()){
				
			}
			else{
				Static.halt();
			}
			//
		}
	}

	public static final void toggleVisibility(){
		shown = !shown;
	}
	
	public static final boolean isVisible(){
		return shown;
	}
	
	public static enum PolygonType {
		
		NONE, BOX, SHAPEBOX, SHAPE, CYLINDER, CONE;
		
		public boolean isCylinder(){
			return this == CYLINDER || this == CONE;
		}
		
		public boolean isRectangle(){
			return this == BOX || this == SHAPEBOX;
		}
		
		public boolean isShape(){
			return this == SHAPE;
		}
		
		public boolean any(){
			return !(this == NONE);
		}
		
	}
	
	public static void selectNew(PolygonType type, String group, int element){
		INSTANCE.type = type;
		//INSTANCE.group = group;
		//INSTANCE.element = element;
	}
	
	public static enum Field {
		
		POSX(new String[]{"posx", "null", "null", "posy", "offx"}, false),
		POSY(new String[]{"posy", "null", "posx", "posz", "offy"}, false),
		POSZ(new String[]{"posz", "null", "posy", "null", "offz"}, false),
		OFFX(new String[]{"offx", "posx", "null", "offy", "rotx"}, false),
		OFFY(new String[]{"offy", "posy", "offx", "offz", "roty"}, false),
		OFFZ(new String[]{"offz", "posz", "offy", "null", "rotz"}, false),
		ROTX(new String[]{"rotx", "offx", "null", "roty", "texx"}, false),
		ROTY(new String[]{"roty", "offy", "rotx", "rotz", "texy"}, false),
		ROTZ(new String[]{"rotz", "offz", "roty", "null", "texe"}, false),
		TEXX(new String[]{"texx", "rotx", "null", "texy", "type"}, false),
		TEXY(new String[]{"texy", "roty", "texx", "texe", "naml"}, false),
		TEXE(new String[]{"texe", "rotz", "texy", "null", "namr"}, false),
		TYPE(new String[]{"type", "texx", "null", "naml", "rads"}, false),
		NAML(new String[]{"naml", "texy", "type", "namr", "leng"}, false),
		NAMR(new String[]{"namr", "texe", "naml", "null", "segm"}, false),
		//
		RADS(new String[]{"rads", "type", "null", "leng", "base"}, true),
		LENG(new String[]{"leng", "naml", "rads", "segm", "tops"}, true),
		SEGM(new String[]{"segm", "namr", "leng", "null", "cone"}, true),
		BASE(new String[]{"base", "rads", "null", "tops", "null"}, true),
		TOPS(new String[]{"tops", "leng", "base", "cone", "null"}, true),
		CONE(new String[]{"cone", "cone", "tops", "null", "null"}, true);
		
		public String id, up, left, right, down;
		public boolean cylo;
		
		Field(String[] args, boolean bool){
			id = args[0];
			up = args[1];
			left = args[3];
			right = args[4];
			down = args[2];
			cylo = bool;
		}
		
		public Field getField(String str){
			if(str == null || str.equals("null")){
				return null;
			}
			for(Field field : values()){
				if(field.id.equals(str)){
					if(field.cylo && !INSTANCE.type.isCylinder()){
						return null;
					}
					return field;
				}
			}
			return null;
		}
		
	}
	
}