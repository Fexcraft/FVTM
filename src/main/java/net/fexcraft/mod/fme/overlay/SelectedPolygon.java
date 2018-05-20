package net.fexcraft.mod.fme.overlay;

import org.lwjgl.input.Keyboard;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fme.blocks.EditorTileEntity;
import net.fexcraft.mod.fme.util.TempModel;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

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
    private String group = "body";
    private int element = -1;
    public static final ResourceLocation texture = new ResourceLocation("fme:textures/gui/box_stats.png");
    //
    private PolygonType type = PolygonType.NONE;
    private BlockPos editor = null;
    private Polygon polygon;
    public static boolean compress;
    private static Field selfield = Field.POSX;
    //
    private static final String keyCategory = "Fex's Model Editor";
    public static KeyBinding keyLeft;
    public static KeyBinding keyRight;
    public static KeyBinding keyUp;
    public static KeyBinding keyDown;
    public static KeyBinding keyAdd;
    public static KeyBinding keySub;
    public static KeyBinding[] keys = new KeyBinding[]{
        keyLeft = new KeyBinding("Editor - Left", Keyboard.KEY_NUMPAD4, keyCategory),//75
        keyRight = new KeyBinding("Editor - Right", Keyboard.KEY_NUMPAD6, keyCategory),//77
        keyUp = new KeyBinding("Editor - Up", Keyboard.KEY_NUMPAD8, keyCategory),//72
        keyDown = new KeyBinding("Editor - Down", Keyboard.KEY_NUMPAD2, keyCategory),//80
        keyAdd = new KeyBinding("Editor - Add.", Keyboard.KEY_NUMPAD9, keyCategory),//73
        keySub = new KeyBinding("Editor - Sub.", Keyboard.KEY_NUMPAD7, keyCategory),//71
    };

    @SubscribeEvent
    public void display(RenderGameOverlayEvent event){
        if(event.getType() == ElementType.HOTBAR && shown && type.any()){
            mc.getTextureManager().bindTexture(texture);
            this.drawTexturedModalRect(0, 0, 0, 0, 103, type.isCylinder() ? 77 : 54);
            this.drawTexturedModalRect(selfield.x, selfield.y, 0, 248, 1, 8);
            //
            if(polygon != null){
                Box box = (Box) polygon;
                TempModel model = this.getModel();
                GlStateManager.scale(0.5, 0.5, 0.5);
                mc.fontRenderer.drawString(box.posx + "", 8 * 2, 5 * 2, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.posy + "", 40 * 2, 5 * 2, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.posz + "", 72 * 2, 5 * 2, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.offx + "", 16, 30, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.offy + "", 80, 30, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.offz + "", 144, 30, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.rotx + "", 16, 50, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.roty + "", 80, 50, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.rotz + "", 144, 50, MapColor.GRAY.colorValue);
                //
                mc.fontRenderer.drawString(box.texx + "", 16, 70, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.texy + "", 80, 70, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(model.hasTexture() + "", 144, 70, MapColor.GRAY.colorValue);
                //
                mc.fontRenderer.drawString(box.getType(), 16, 90, MapColor.GRAY.colorValue);
                mc.fontRenderer.drawString(box.getName(), 80, 90, MapColor.GRAY.colorValue);
                //
                if(type.isCylinder()){

                }
                GlStateManager.scale(2, 2, 2);
            }
            else{

            }
            //
        }
    }

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event){
        if(!isVisible()){
            return;
        }
        for(int i = 0; i < keys.length; i++){
            if(i < 4 && keys[i].isPressed()){
                selfield.move(i);
            }
            else if((i == 4 && keys[i].isPressed()) || (i == 5 && keys[i].isPressed()) && type != PolygonType.NONE && polygon != null){
                polygon.processInput(selfield.id, i == 4 ? +1 : -1);//TODO brush/whatever size
                this.getModel().groups.get(group).set(element, polygon.toTMT(this.getModel()));
                Print.chat(mc.player, i == 4 ? "add" : "sub");
            }
        }
    }

    public static final void toggleVisibility(boolean bool, BlockPos pos){
        INSTANCE.shown = bool;
        INSTANCE.editor = pos;
    }

    public static final boolean isVisible(){
        return INSTANCE.shown;
    }

    public final TempModel getModel(){
        return ((EditorTileEntity) Static.getServer().getEntityWorld().getTileEntity(editor)).getModel();
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

        private Class<? extends Polygon> clazz;

        PolygonType(Class<? extends SelectedPolygon.Polygon> claxx){
            this.clazz = claxx;
        }

        public PolygonType get(JsonObject obj){
            if(obj.has("type")){
                switch(obj.get("type").getAsString()){
                    case "box":
                    case "cube":
                    case "b": {
                        return BOX;
                    }
                    case "shapebox":
                    case "sbox":
                    case "sb": {
                        return SHAPEBOX;
                    }
                    case "cylinder":
                    case "cyl":
                    case "c": {
                        return CYLINDER;
                    }
                    case "cone":
                    case "cn": {
                        return CONE;
                    }
                    default:
                        break;
                }
            }
            return NONE;
        }

        public Polygon getPolygon(){
            try{
                return this.clazz.newInstance();
            }
            catch(InstantiationException | IllegalAccessException e){
                e.printStackTrace();
                return null;
            }
        }

    }

    public static void selectNew(PolygonType type, String group, int element){
        INSTANCE.type = type;
        INSTANCE.polygon = INSTANCE.type.getPolygon();
        INSTANCE.group = group;
        INSTANCE.element = element;
    }

    public static enum Field {

        POSX(new String[]{"posx", "null", "null", "posy", "offx"}, false, 6, 3),
        POSY(new String[]{"posy", "null", "posx", "posz", "offy"}, false, 38, 3),
        POSZ(new String[]{"posz", "null", "posy", "null", "offz"}, false, 70, 3),
        OFFX(new String[]{"offx", "posx", "null", "offy", "rotx"}, false, 6, 13),
        OFFY(new String[]{"offy", "posy", "offx", "offz", "roty"}, false, 38, 13),
        OFFZ(new String[]{"offz", "posz", "offy", "null", "rotz"}, false, 70, 13),
        ROTX(new String[]{"rotx", "offx", "null", "roty", "texx"}, false, 6, 23),
        ROTY(new String[]{"roty", "offy", "rotx", "rotz", "texy"}, false, 38, 23),
        ROTZ(new String[]{"rotz", "offz", "roty", "null", "texe"}, false, 70, 23),
        TEXX(new String[]{"texx", "rotx", "null", "texy", "type"}, false, 6, 33),
        TEXY(new String[]{"texy", "roty", "texx", "texe", "naml"}, false, 38, 33),
        TEXE(new String[]{"texe", "rotz", "texy", "null", "namr"}, false, 70, 33),
        TYPE(new String[]{"type", "texx", "null", "naml", "rads"}, false, 6, 43),
        NAML(new String[]{"naml", "texy", "type", "namr", "leng"}, false, 38, 43),
        NAMR(new String[]{"namr", "texe", "naml", "null", "segm"}, false, 99, 43),
        //
        RADS(new String[]{"rads", "type", "null", "leng", "base"}, true, 6, 56),
        LENG(new String[]{"leng", "naml", "rads", "segm", "tops"}, true, 38, 56),
        SEGM(new String[]{"segm", "namr", "leng", "null", "dirc"}, true, 70, 56),
        BASE(new String[]{"base", "rads", "null", "tops", "null"}, true, 6, 66),
        TOPS(new String[]{"tops", "leng", "base", "dirc", "null"}, true, 38, 66),
        DIRC(new String[]{"dirc", "segm", "tops", "null", "null"}, true, 70, 66);

        public String id, up, left, right, down;
        public boolean cylo;
        public int x, y;

        Field(String[] args, boolean bool, int px, int py){
            id = args[0];
            up = args[1];
            left = args[2];
            right = args[3];
            down = args[4];
            cylo = bool;
            x = px;
            y = py;
        }

        public void move(int i){
            switch(i){
                case 0: {//left
                    if(!left.equals("null")){
                        selfield = getField(left);
                    }
                    break;
                }
                case 1: {//right
                    if(!right.equals("null")){
                        selfield = getField(right);
                    }
                    break;
                }
                case 2: {//up
                    if(!up.equals("null")){
                        selfield = getField(up);
                    }
                    break;
                }
                case 3: {//down
                    if(!down.equals("null")){
                        selfield = getField(down);
                    }
                    break;
                }
            }
        }

        public Field getField(String str){
            if(str == null || str.equals("null")){
                return this;
            }
            for(Field field : values()){
                if(field.id.equals(str)){
                    if(field.cylo && !INSTANCE.type.isCylinder()){
                        return this;
                    }
                    return field;
                }
            }
            return this;
        }

    }

    public static interface Polygon {

        public ModelRendererTurbo toTMT(TempModel base);

        public JsonObject toJTMT();

        public void fromTMT(ModelRendererTurbo model);

        public void fromJTMT(JsonObject obj);

        public void processInput(String field, float value);

        public String getType();

        public String getName();

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
        private String name;

        @Override
        public ModelRendererTurbo toTMT(TempModel model){
            ModelRendererTurbo turbo = new ModelRendererTurbo(model, texx, texy, model.textureHeight, model.textureWidth);
            turbo.addBox(offx, offy, offz, w, h, d, expansion);
            turbo.rotateAngleX = rotx;
            turbo.rotateAngleY = roty;
            turbo.rotateAngleZ = rotz;
            turbo.setRotationPoint(posx, posy, posz);
            return turbo;
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
            obj.addProperty("type", this.getType());
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
                case "posx": {
                    this.posx += value;
                    break;
                }
                case "posy": {
                    this.posy += value;
                    break;
                }
                case "posz": {
                    this.posz += value;
                    break;
                }
            }
        }

        @Override
        public String getType(){
            return "box";
        }

        @Override
        public String getName(){
            return name;
        }

    }

    public static class ShapeBox extends Box {

    }

    public static class Cylinder extends Box {

    }

    public static class Cone extends Cylinder {

    }

}
