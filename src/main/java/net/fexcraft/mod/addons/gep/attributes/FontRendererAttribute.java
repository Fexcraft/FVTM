package net.fexcraft.mod.addons.gep.attributes;

import java.util.List;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Map.Entry;

import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.math.Pos;
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
    private TreeMap<String, FontData> list;

    @Override
    public ResourceLocation getRegistryName(){
        return regname;
    }

    @Override
    public void load(JsonObject obj){
        list = new TreeMap<String, FontData>();
        JsonArray array = obj.has("Font-Renderers") ? obj.get("Font-Renderers").getAsJsonArray() : null;
        if(array != null){
            array.forEach(elm -> {
                FontData data = new FontData(elm.getAsJsonObject());
                list.put(data.getId(), data);
            });
        }
    }

    @Override
    public String getName(){
        return "Font Renderer";
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Font Renderers: &7" + list.size()));
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
        return list;
    }

    public static class FontData {
        
        private Pos pos;
        private int color;
        private String str, id;
        private boolean editable, glow;
        private float rotX, rotY, rotZ, scale;

        private FontData(JsonObject obj){
            pos = Pos.fromJSON(obj);
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
            Vec3d vec = ent.getAxes().getRelativeVector(pos.to16Double());
            float x = ent.getAxes().getYaw() + rotX + 180F;//- 90F;
            float y = ent.getAxes().getPitch() + rotY + 180F;
            float z = ent.getAxes().getRoll() + rotZ;
            net.fexcraft.mod.fvtm.render.Renderer.drawString(str, vec.x, vec.y, vec.z, x, y, z, glow, scale, color);
            //TODO adjust rotation
        }

    }
    
    public static class FontRendererAttributeData implements AttributeData {
        
        private FontRendererAttribute attr;
        
        public FontRendererAttributeData(Part.PartData data, Attribute attr){
            this.attr = (FontRendererAttribute)attr;
        }

        @Override
        public NBTTagCompound writeToNBT(Part.PartData data, NBTTagCompound compound){
            NBTTagCompound com = new NBTTagCompound();
            for(Entry<String, FontData> entry : data.getPart().getAttribute(FontRendererAttribute.class).getLocations().entrySet()){
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
                for(Entry<String, FontData> entry : data.getPart().getAttribute(FontRendererAttribute.class).getLocations().entrySet()){
                   if(entry.getValue().editable && com.hasKey(entry.getKey())){
                       entry.getValue().setString(com.getString(entry.getKey()));
                   }
                }
            }
            return this;
        }

        public TreeMap<String, FontData> getLocations(){
        return attr.getLocations();
        }
        
    }

}
