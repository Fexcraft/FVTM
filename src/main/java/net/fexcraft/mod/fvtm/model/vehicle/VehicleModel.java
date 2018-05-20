package net.fexcraft.mod.fvtm.model.vehicle;

import java.util.ArrayList;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.tmt.util.TMTItemModel;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class VehicleModel<T extends VehicleData> extends Model<VehicleData> implements TMTItemModel {

    public ModelRendererTurbo chassis[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
    public ModelRendererTurbo wheels_import[] = new ModelRendererTurbo[0];
    public ArrayList<String> creators = new ArrayList<String>();

    private int tx, ty;
    public float gui_translate_x = 0;
    public float gui_translate_y = 0;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.125f;
    public float gui_scale_y = 0.125f;
    public float gui_scale_z = 0.125f;

    public VehicleModel(){
    }

    public VehicleModel(JsonObject obj){
        if(obj == null || (obj.has("type") && obj.get("type").getAsString().equals("class"))){
            return;
        }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        tx = obj.get("texture_size_x").getAsInt();
        ty = obj.get("texture_size_y").getAsInt();
        chassis = JsonToTMT.parse(this, "chassis", obj, tx, ty);
        body = JsonToTMT.parse(this, "body", obj, tx, ty);
        bodyColoredPrimary = JsonToTMT.parse(this, "body_colored_primary", obj, tx, ty);
        bodyColoredSecondary = JsonToTMT.parse(this, "body_colored_secondary", obj, tx, ty);
        bodyDoorOpen = JsonToTMT.parse(this, "body_door_open", obj, tx, ty);
        bodyDoorClose = JsonToTMT.parse(this, "body_door_close", obj, tx, ty);
        bodyDoorOpenColoredPrimary = JsonToTMT.parse(this, "body_door_open_colored_primary", obj, tx, ty);
        bodyDoorCloseColoredPrimary = JsonToTMT.parse(this, "body_door_close_colored_primary", obj, tx, ty);
        turret = JsonToTMT.parse(this, "turret", obj, tx, ty);
        wheels_import = JsonToTMT.parse(this, "wheels_import", obj, tx, ty);
    }

    @Override
    public void render(){
        //cannot render without providing vehicledata;
    }

    public void render(VehicleData data){
        render(data, null, 0);
    }

    @Override
    public void render(VehicleData data, Entity entity){
        render(data, entity, 0);
    }

    public void render(VehicleData data, @Nullable Entity entity, int meta){
        //Vehicle Chassis
        render(chassis);

        //Vehicle Body
        render(body);
        if(data.doorsOpen()){
            render(bodyDoorOpen);
        }
        else{
            render(bodyDoorClose);
        }

        //Render Primary Color Things
        data.getPrimaryColor().glColorApply();
        render(bodyColoredPrimary);
        if(data.doorsOpen()){
            render(bodyDoorOpenColoredPrimary);
        }
        else{
            render(bodyDoorCloseColoredPrimary);
        }
        RGB.glColorReset();

        //Render Secondary Color Things
        data.getSecondaryColor().glColorApply();
        render(bodyColoredSecondary);
        RGB.glColorReset();

        //Render Turret
        render(turret);

        //TODO
        render(steering);

        //Other
        render(wheels_import);

    }

    @Override
    public void rotate(ModelRendererTurbo[] mod, float d, float d1, float d2){
        for(ModelRendererTurbo model : mod){
            model.rotateAngleX = d;
            model.rotateAngleY = d1;
            model.rotateAngleZ = d2;
        }
    }

    @Override
    public void rotateAll(float x, float y, float z){
        rotate(chassis, x, y, z);
        rotate(body, x, y, z);
        rotate(bodyColoredPrimary, x, y, z);
        rotate(bodyColoredSecondary, x, y, z);
        rotate(bodyDoorOpen, x, y, z);
        rotate(bodyDoorClose, x, y, z);
        rotate(bodyDoorOpenColoredPrimary, x, y, z);
        rotate(bodyDoorCloseColoredPrimary, x, y, z);
        rotate(turret, x, y, z);
        rotate(steering, x, y, z);
        rotate(wheels_import, x, y, z);
    }

    public void translateAll(float x, float y, float z){
        translate(chassis, x, y, z);
        translate(body, x, y, z);
        translate(bodyColoredPrimary, x, y, z);
        translate(bodyColoredSecondary, x, y, z);
        translate(bodyDoorOpen, x, y, z);
        translate(bodyDoorClose, x, y, z);
        translate(bodyDoorOpenColoredPrimary, x, y, z);
        translate(bodyDoorCloseColoredPrimary, x, y, z);
        translate(turret, x, y, z);
        translate(steering, x, y, z);
        translate(wheels_import, x, y, z);
    }

    public void flip(ModelRendererTurbo[] mod){
        /*for(ModelRendererTurbo sub : mod){
			sub.doMirror(false, true, true);
			sub.setRotationPoint(sub.rotationPointX, - sub.rotationPointY, - sub.rotationPointZ);
		}*/
        this.fixRotations(mod);
    }

    public void flipAll(){
        flip(chassis);
        flip(body);
        flip(bodyColoredPrimary);
        flip(bodyColoredSecondary);
        flip(bodyDoorOpen);
        flip(bodyDoorClose);
        flip(bodyDoorOpenColoredPrimary);
        flip(bodyDoorCloseColoredPrimary);
        flip(turret);
        flip(steering);
        flip(wheels_import);
    }

    @Override
    public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
        VehicleData data = ((VehicleItem) item.getItem()).getVehicle(item);
        if(data == null){
            return;
        }
        VehicleModel<VehicleData> model = data.getVehicle().getModel();
        if(model == null){
            return;
        }
        float[] scal = new float[]{model.gui_scale_x, model.gui_scale_y, model.gui_scale_z};
        //
        GL11.glPushMatrix();
        {
            switch(type){
                case GROUND: {
                    GL11.glTranslatef(-0.45F, -0.05F, 0);
                    break;
                }
                case FIXED: {
                    //GL11.glRotatef(0, 0, 0, 0);
                    break;
                }
                case THIRD_PERSON_RIGHT_HAND:
                case THIRD_PERSON_LEFT_HAND: {
                    GL11.glRotatef(90F, 0F, 1F, 0F);
                    GL11.glTranslatef(0F, 0/*-0.15F*/, 0F);
                    GL11.glTranslatef(0, 0, 0);
                    break;
                }
                case FIRST_PERSON_LEFT_HAND: {
                    if(data.getVehicle().isTrailerOrWagon()){
                        GL11.glTranslatef(0, 0, -0.5f);
                    }
                    GL11.glRotatef(60f, 0F, 1F, 0F);
                    break;
                }
                case FIRST_PERSON_RIGHT_HAND: {
                    if(data.getVehicle().isTrailerOrWagon()){
                        GL11.glTranslatef(0, 0, -0.5f);
                    }
                    GL11.glRotatef(120f, 0F, 1F, 0F);
                    break;
                }
                case GUI: {
                    float f = data.getVehicle().isTrailerOrWagon() ? -0.375f : 0;
                    GL11.glTranslatef(model.gui_translate_x + f, model.gui_translate_y + f, model.gui_translate_z);
                    GL11.glRotatef(-135, 0, 1, 0);
                    GL11.glRotatef(-30, 1, 0, 0);
                    GL11.glRotatef(-30, 0, 0, 1);
                    //
                    /*scal[0] = model.gui_scale_x;
					scal[1] = model.gui_scale_y;
					scal[2] = model.gui_scale_z;*/
                    break;
                }
                case HEAD: {
                    //TODO
                    break;
                }
                default:
                    break;
            }
            GL11.glScalef(scal[0], scal[1], scal[2]);
            //
            {
                GL11.glPushMatrix();
                GL11.glRotated(180d, 1, 0, 0);
                Minecraft.getMinecraft().renderEngine.bindTexture(data.getTexture());
                model.render(data, null, 0);
                data.getParts().forEach((key, partdata) -> {
                    Minecraft.getMinecraft().renderEngine.bindTexture(partdata.getTexture());
                    partdata.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translate();
                    partdata.getPart().getModel().render(data, key);
                    partdata.getPart().getOffsetFor(data.getVehicle().getRegistryName()).translateR();
                });
                Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
                GL11.glPopMatrix();
            }
            GL11.glScalef(-scal[0], -scal[1], -scal[2]);
        }
        GL11.glPopMatrix();
    }

}
