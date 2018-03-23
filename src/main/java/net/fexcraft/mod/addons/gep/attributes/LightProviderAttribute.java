package net.fexcraft.mod.addons.gep.attributes;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
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
		
		private Pos pos;
		private RGB color;
		private int segments;
		private float radius, length, base, top, rotx, roty, rotz;
		
		@SideOnly(Side.CLIENT)
		private ModelRendererTurbo main, send;
		@SideOnly(Side.CLIENT)
		private Model<?> placeholder;

		public LightData(JsonObject obj){
			pos = Pos.fromJSON(obj.get("pos").getAsJsonObject());
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
			if(Static.side().isClient()){
				placeholder = Model.EMPTY;
			}
		}
		
		@SideOnly(Side.CLIENT)
		public void render(){
			if(main == null || send == null){
				main = new ModelRendererTurbo(placeholder);
				send = new ModelRendererTurbo(placeholder);
				main.addCylinder(0, 0, 0, radius, length, segments, base, top, 3);
				main.setRotationPoint(pos.x, pos.y, pos.z);
				send.flip = true;
				send.addCylinder(0, 0, 0, radius, length, segments, base, top, 3);
				send.setRotationPoint(pos.x, pos.y, pos.z);
				//
				main.rotateAngleX = rotx == 0 ? 0 : (float)Math.toRadians(rotx);
				main.rotateAngleY = roty == 0 ? 0 : (float)Math.toRadians(roty);
				main.rotateAngleZ = rotz == 0 ? 0 : (float)Math.toRadians(rotz);
				send.rotateAngleX = rotx == 0 ? 0 : (float)Math.toRadians(rotx);
				send.rotateAngleY = roty == 0 ? 0 : (float)Math.toRadians(roty);
				send.rotateAngleZ = rotz == 0 ? 0 : (float)Math.toRadians(rotz);
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
	
}