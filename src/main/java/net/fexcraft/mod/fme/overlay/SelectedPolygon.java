package net.fexcraft.mod.fme.overlay;

import com.google.gson.JsonObject;

import net.fexcraft.mod.lib.tmt.JsonToTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
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
	private boolean shown;
	//private String group = "body";
	//private int element = -1;
	public static final ResourceLocation texture = new ResourceLocation("fme:textures/gui/box_stats.png");
	//
	private PolygonType type = PolygonType.NONE;
	private BlockPos editor = null;
	private Polygon polygon;
	public static final int TXSx = 512;
	public static final int TXSy = 512;
	public static boolean compress;
	
	@SubscribeEvent
	public void display(RenderGameOverlayEvent event){
		if(event.getType() == ElementType.HOTBAR && shown && type.any()){
			mc.getTextureManager().bindTexture(texture);
			this.drawTexturedModalRect(0, 0, 0, 0, 103, type.isCylinder() ? 77 : 54);
			//
			if(type.isRectangle()){
				
			}
			else if(type.isCylinder()){
				
			}
			else if(type.isShape()){
				
			}
			else{
				Print.log(editor.toString());
				Print.log(polygon);
				Static.halt();
			}
			//
		}
	}

	public static final void toggleVisibility(boolean bool, BlockPos pos){
		INSTANCE.shown = bool;
		INSTANCE.editor = pos;
	}
	
	public static final boolean isVisible(){
		return INSTANCE.shown;
	}
	
	public static enum PolygonType {
		
		NONE(null),
		BOX(Box.class),
		SHAPEBOX(ShapeBox.class),
		SHAPE(null),
		CYLINDER(Cylinder.class),
		CONE(Cone.class);
		
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
		
		public Class<? extends Polygon> clazz;
		
		PolygonType(Class<? extends SelectedPolygon.Polygon> claxx){
			this.clazz = claxx;
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
		SEGM(new String[]{"segm", "namr", "leng", "null", "dirc"}, true),
		BASE(new String[]{"base", "rads", "null", "tops", "null"}, true),
		TOPS(new String[]{"tops", "leng", "base", "dirc", "null"}, true),
		DIRC(new String[]{"dirc", "segm", "tops", "null", "null"}, true);
		
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
	
	public static interface Polygon {
		
		public ModelRendererTurbo toTMT(ModelBase base);
		
		public JsonObject toJTMT();
		
		public void fromTMT(ModelRendererTurbo model);
		
		public void fromJTMT(JsonObject obj);
		
		public void processInput(String field, float value);
		
	}
	
	public static class Box implements Polygon {
		
		private float rotx, roty, rotz;
		private float offx, offy, offz;
		private float posx, posy, posz;
		private int w, h, d;
		private float expansion = 0f;
		private int texx, texy;
		//
		private boolean rotorder, flip, mirror;

		@Override
		public ModelRendererTurbo toTMT(ModelBase base){
			ModelRendererTurbo turbo = new ModelRendererTurbo(base, texx, texy, TXSx, TXSy);
			turbo.addBox(offx, offy, offz, w, h, d, expansion);
			turbo.rotateAngleX = rotx;
			turbo.rotateAngleY = roty;
			turbo.rotateAngleZ = rotz;
			turbo.setRotationPoint(posx, posy, posz);
			return null;
		}

		@Override
		public JsonObject toJTMT(){
			JsonObject obj = new JsonObject();
			obj.addProperty(compress ? "x" : "rotation_point_x", posx);
			obj.addProperty(compress ? "y" : "rotation_point_y", posy);
			obj.addProperty(compress ? "y" : "rotation_point_y", posy);
			obj.addProperty(compress ? "w" : "width", w);
			obj.addProperty(compress ? "h" : "height", h);
			obj.addProperty(compress ? "d" : "depth", d);
			if(expansion != 0f){
				obj.addProperty(compress ? "e" : "expansion", expansion);
			}
			if(rotx != 0f){
				obj.addProperty(compress ? "rx" : "rotation_angle_x", rotx);
			}
			if(roty != 0f){
				obj.addProperty(compress ? "ry" : "rotation_angle_y", rotx);
			}
			if(rotz != 0f){
				obj.addProperty(compress ? "rz" : "rotation_angle_z", rotx);
			}
			if(offx != 0f){
				obj.addProperty(compress ? "ox" : "offset_x", offx);
			}
			if(offy != 0f){
				obj.addProperty(compress ? "oy" : "offset_y", offy);
			}
			if(offz != 0f){
				obj.addProperty(compress ? "oz" : "offset_x", offz);
			}
			if(rotorder){
				obj.addProperty("oro", rotorder);
			}
			if(flip){
				obj.addProperty("flip", flip);
			}
			if(mirror){
				obj.addProperty(compress ? "m" : "mirror", mirror);
			}
			return obj;
		}

		@Override
		public void fromTMT(ModelRendererTurbo model){
			//currently most likely not possible
		}

		@Override
		public void fromJTMT(JsonObject obj){
			posx = JsonToTMT.get(JsonToTMT.posx, obj, 0);
			posy = JsonToTMT.get(JsonToTMT.posy, obj, 0);
			posz = JsonToTMT.get(JsonToTMT.posz, obj, 0);
			offx = JsonToTMT.get(JsonToTMT.offx, obj, 0);
			offy = JsonToTMT.get(JsonToTMT.offy, obj, 0);
			offz = JsonToTMT.get(JsonToTMT.offz, obj, 0);
			rotx = JsonToTMT.get(JsonToTMT.rotx, obj, 0);
			roty = JsonToTMT.get(JsonToTMT.roty, obj, 0);
			rotz = JsonToTMT.get(JsonToTMT.rotz, obj, 0);
			//
			w = JsonToTMT.get(JsonToTMT.width, obj, 0);
			h = JsonToTMT.get(JsonToTMT.height, obj, 0);
			d = JsonToTMT.get(JsonToTMT.depth, obj, 0);
			expansion = JsonToTMT.get(JsonToTMT.expansion, obj, 0);
			//
			rotorder = JsonUtil.getIfExists(obj, JsonToTMT.oldrot, false);
			mirror = JsonUtil.getIfExists(obj, JsonToTMT.mirror, false);
			flip = JsonUtil.getIfExists(obj, JsonToTMT.flip, false);
		}

		@Override
		public void processInput(String field, float value){
			switch(field){
			
			}
		}
		
	}
	
	public static class ShapeBox extends Box {
		
	}
	
	public static class Cylinder extends Box {
		
	}
	
	public static class Cone extends Cylinder {
		
	}
	
}