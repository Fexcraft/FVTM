package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Map.Entry;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FontRendererAttribute implements Attribute {

    private static final ResourceLocation regname = new ResourceLocation("font_renderer");
    private TreeMap<String, FontData> rawlist;

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
    	rawlist = new TreeMap<String, FontData>();
        JsonArray array = obj.has("Font-Renderers") ? obj.get("Font-Renderers").getAsJsonArray() : null;
        if(array != null){
            array.forEach(elm -> {
                FontData data = new FontData(elm.getAsJsonObject());
                rawlist.put(data.getId(), data);
            });
        }
    }

    @Override
    public String getName(){
        return "Font Renderer";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Font Renderers: &7" + rawlist.size()));
    }

    @Override
    public boolean hasDataClass(){
        return true;
    }

    @Override
    public Class<? extends AttributeData> getDataClass(){
        return FontRendererAttributeData.class;
    }

    public TreeMap<String, FontData> getLocations(){
        return rawlist;
    }

    public static class FontData {
        
        private Vec3d pos;
        private int color;
        private String str, id;
        private boolean editable, glow, ondoor;
        private float rotX, rotY, rotZ, scale;
        
        private FontData(){}
        
        private FontData(JsonObject obj){
            pos = Pos.fromJSON(obj).to16Double();
            if(!obj.has("id")){
                throw new UnsupportedOperationException("Tried to instantiate Data for Font Renderer, but no ID specified!");
            }
            id = obj.get("id").getAsString();
            editable = JsonUtil.getIfExists(obj, "editable", false);
            str = JsonUtil.getIfExists(obj, "string", editable ? id : "FVTM");
            rotX = JsonUtil.getIfExists(obj, "rot_x", 0).floatValue();
            rotY = JsonUtil.getIfExists(obj, "rot_y", 0).floatValue();
            rotZ = JsonUtil.getIfExists(obj, "rot_z", 0).floatValue();
            glow = JsonUtil.getIfExists(obj, "glow", false);
            color = Integer.decode(JsonUtil.getIfExists(obj, "color", "#ffffff"));
            scale = JsonUtil.getIfExists(obj, "scale", 1f).floatValue();
            ondoor = JsonUtil.getIfExists(obj, "ondoor", false);
        }
        
        public boolean isEditable(){
            return editable;
        }
        
        public String getString(){
            return str;
        }
        
        public void setString(String newstr){
            str = newstr == null ? "" : newstr;
        }
        
        public String getId(){
            return id;
        }
        
        @SideOnly(Side.CLIENT)
        public void render(VehicleEntity ent){
        	if(ent == null || ent.getAxes() == null) return;
            if(ondoor && ent.getVehicleData().doorsOpen()){ return; }
            float x = (float)(ent.getAxes().getRadianYaw())   + rotX - 90F;
            float y = (float)(ent.getAxes().getRadianPitch()) + rotY + 180F;
            float z = (float)(ent.getAxes().getRadianRoll())  + rotZ;
            net.fexcraft.mod.fvtm.render.Renderer.drawString(str, pos.x, pos.y, pos.z, x, y, z, glow, scale, color);
        }

		public FontData copy() {
			FontData data = new FontData();
			data.pos = new Vec3d(pos.x, pos.y, pos.z);
			data.id = id; data.editable = editable;
			data.str = str; data.glow = glow;
			data.rotX = rotX; data.rotY = rotY; data.rotZ = rotZ;
			data.color = color; data.scale = scale;
			data.ondoor = ondoor;
			return data;
		}

    }
    
    public static class FontRendererAttributeData implements AttributeData {
        
        private FontRendererAttribute attr;
        private TreeMap<String, FontData> list;
        
        public FontRendererAttributeData(Part.PartData data, Attribute attr){
            this.attr = (FontRendererAttribute)attr;
        }

        @Override
        public NBTTagCompound writeToNBT(Part.PartData data, NBTTagCompound compound){
            NBTTagCompound com = new NBTTagCompound();
            for(Entry<String, FontData> entry : getLocations().entrySet()){
               if(entry.getValue().editable){
                   compound.setString(entry.getKey(), entry.getValue().getId());
               }
            }
            if(!com.hasNoTags()){
                compound.setTag("FontRendererData", com);
            }
            return compound;
        }

        @Override
        public AttributeData readFromNBT(Part.PartData data, NBTTagCompound compound){
            NBTTagCompound com = compound.getCompoundTag("FontRendererData");
            if(com != null){
                for(Entry<String, FontData> entry : getLocations().entrySet()){
                   if(entry.getValue().editable && com.hasKey(entry.getKey())){
                       entry.getValue().setString(com.getString(entry.getKey()));
                   }
                }
            }
            return this;
        }

        public TreeMap<String, FontData> getLocations(){
        	if(list == null){
        		list = new TreeMap<>();
        		attr.getLocations().forEach((key, data) -> { list.put(key, data.copy()); });
        	}
        	return list;
        }
        
    }

	@Override
	public boolean hasRenderData(){
		return true;
	}

	@Override
	public void render(VehicleEntity entity, PartData data, String key){
		FontRendererAttributeData attrdata = (FontRendererAttributeData)data.getAttributeData(this.getDataClass());
		if(attrdata == null){
			this.getLocations().forEach((id, fontdata) -> {
				fontdata.render(entity);
			});
		}
		else{
			attrdata.getLocations().forEach((id, fontdata) -> {
				fontdata.render(entity);
			});
		}
	}

}
