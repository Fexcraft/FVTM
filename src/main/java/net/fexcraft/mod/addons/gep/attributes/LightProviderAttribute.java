package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LightProviderAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("light_provider");
    private TreeMap<String, List<LightData>> lights;
    private ArrayList<LightData> emptylist = new ArrayList<LightData>();
    private String[] types = new String[]{"normal", "front", "rear", "long", "fog", "turn_signal_left", "turn_signal_right"};

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        lights = new TreeMap<String, List<LightData>>();
        JsonArray array = obj.has("Light-Providers") ? obj.get("Light-Providers").getAsJsonArray() : null;
        if(array != null){
            array.forEach(elm -> {
                JsonObject object = elm.getAsJsonObject();
                ArrayList<LightData> list = new ArrayList<LightData>();
                object.get("lights").getAsJsonArray().forEach(light -> {
                    list.add(new LightData(light.getAsJsonObject()));
                });
                lights.put(object.get("type").getAsString(), list);
            });
        }
    }

    @Override
    public String getName(){
        return "Light Provider";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
        String str = "";
        for(String type : types){
            if(lights.get(type) != null){
                str += lights.get(type).size() + ", ";
            }
            else{
                str += "0, ";
            }
        }
        if(str.endsWith(", ")){
            str = str.substring(0, str.lastIndexOf(", "));
        }
        tooltip.add(Formatter.format("&9Lights: &7" + str + ""));
    }

    @Override
    public boolean hasDataClass(){
        return false;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return null;
    }

    public List<LightData> getLightsOfType(String str){
        return lights.get(str) == null ? emptylist : lights.get(str);
    }

    public String[] getLightTypes(){
        return types;
    }

    public static class LightData {

        private Vec3f pos;
        private RGB color;
        private int segments;
        private float radius, length, base, top, rotx, roty, rotz;

        @SideOnly(Side.CLIENT)
        private ModelRendererTurbo main, send;

        public LightData(JsonObject obj){
            pos = Pos.fromJSON(obj.get("pos").getAsJsonObject()).to16Float();
            radius = JsonUtil.getIfExists(obj, "radius", 16).floatValue();
            length = JsonUtil.getIfExists(obj, "length", 128).floatValue();
            segments = JsonUtil.getIfExists(obj, "segments", 32).intValue();
            base = JsonUtil.getIfExists(obj, "base", 0.125f).floatValue();
            top = JsonUtil.getIfExists(obj, "top", 2f).floatValue();
            if(obj.has("color")){
                color = new RGB(obj.get("color").getAsJsonObject());
            }
            rotx = JsonUtil.getIfExists(obj, "rot_x", 0).floatValue();
            roty = JsonUtil.getIfExists(obj, "rot_y", 0).floatValue();
            rotz = JsonUtil.getIfExists(obj, "rot_z", 0).floatValue();
        }

        @SideOnly(Side.CLIENT)
        public void render(){
            if(main == null || send == null){
                main = new ModelRendererTurbo(null);
                send = new ModelRendererTurbo(null);
                main.addCylinder(0, 0, 0, radius, length, segments, base, top, 3);
                main.setRotationPoint(pos.xCoord, pos.yCoord, pos.zCoord);
                send.flip = true;
                send.addCylinder(0, 0, 0, radius, length, segments, base, top, 3);
                send.setRotationPoint(pos.xCoord, pos.yCoord, pos.zCoord);
                //
                main.rotationAngleX = rotx == 0 ? 0 : rotx;
                main.rotationAngleY = roty == 0 ? 0 : roty;
                main.rotationAngleZ = rotz == 0 ? 0 : rotz;
                send.rotationAngleX = rotx == 0 ? 0 : rotx;
                send.rotationAngleY = roty == 0 ? 0 : roty;
                send.rotationAngleZ = rotz == 0 ? 0 : rotz;
            }
            if(color != null){
                color.glColorApply();
            }
            main.render();
            send.render();
            if(color != null){
                RGB.glColorReset();
            }
        }

        public void updateColorIfMissing(RGB red){
            if(color == null){
                color = red;
            }
        }

    }

	@Override
	public boolean hasRenderData(){
		return true;
	}
	
	@Override
	public void render(VehicleEntity entity, PartData data, String key){
		if(entity == null) return;
		if(entity.getVehicleData().getLightsState() > 0){
            GL11.glPushMatrix();
            ModelBase.bindTexture(Resources.NULL_TEXTURE);
            GlStateManager.enableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
            GlStateManager.depthMask(false);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 50f, 50f);
            //OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 238f, 238f);
            entity.getVehicleData().getParts().values().forEach(part -> {
                if(part.getPart().getAttribute(LightProviderAttribute.class) != null){
                    LightProviderAttribute attr = part.getPart().getAttribute(LightProviderAttribute.class);
                    attr.getLightsOfType("normal").forEach(light -> {
                        light.render();
                    });
                    attr.getLightsOfType("rear").forEach(light -> {
                        light.updateColorIfMissing(RGB.RED);
                        light.render();
                    });
                    if(entity.getVehicleData().getLightsState() == 1){
                        attr.getLightsOfType("front").forEach(light -> {
                            light.render();
                        });
                    }
                    if(entity.getVehicleData().getLightsState() == 2){
                        attr.getLightsOfType("long").forEach(light -> {
                            light.render();
                        });
                    }
                    if(entity.getVehicleData().getLightsState() == 3){
                        attr.getLightsOfType("fog").forEach(light -> {
                            light.render();
                        });
                    }
                }
            });
            int i = entity.getEntity().getBrightnessForRender();
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GL11.glPopMatrix();
        }
	}

}
