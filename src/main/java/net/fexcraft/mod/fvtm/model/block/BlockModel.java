package net.fexcraft.mod.fvtm.model.block;

import java.util.ArrayList;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.lib.tmt.util.JsonToTMT;
import net.fexcraft.mod.lib.tmt.util.TMTItemModel;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class BlockModel<T extends BlockData> extends Model<BlockData> implements TMTItemModel {

    public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
    public ArrayList<String> creators = new ArrayList<String>();

    private int tx, ty;
    public float gui_translate_x = 0;
    public float gui_translate_y = 0;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.250f;
    public float gui_scale_y = 0.250f;
    public float gui_scale_z = 0.250f;

    public BlockModel(){
    	//
    }

    public BlockModel(JsonObject obj){
        if(obj == null || (obj.has("type") && obj.get("type").getAsString().equals("class"))){
            return;
        }
        creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
        tx = obj.get("texture_size_x").getAsInt();
        ty = obj.get("texture_size_y").getAsInt();
        body = JsonToTMT.parse(this, "body", obj, tx, ty);
    }

    @Override
    public void render(){
        //cannot render without providing vehicledata;
    }

    public void render(BlockData data){
        render(data, null, 0);
    }

    @Override
    public void render(BlockData data, Entity entity){
        render(data, entity, 0);
    }

    public void render(BlockData data, @Nullable Entity entity, int meta){
        render(body);
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
        rotate(body, x, y, z);
    }

    public void translateAll(float x, float y, float z){
        translate(body, x, y, z);
    }

    public void flip(ModelRendererTurbo[] mod){
        /*for(ModelRendererTurbo sub : mod){
			sub.doMirror(false, true, true);
			sub.setRotationPoint(sub.rotationPointX, - sub.rotationPointY, - sub.rotationPointZ);
		}*/
        this.fixRotations(mod);
    }

    public void flipAll(){
        flip(body);
    }

    @Override
    public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
        BlockData data = ((BlockItem)item.getItem()).getBlock(item);
        if(data == null){
            return;
        }
        BlockModel<BlockData> model = data.getBlock().getModel();
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
                    GL11.glRotatef(60f, 0F, 1F, 0F);
                    break;
                }
                case FIRST_PERSON_RIGHT_HAND: {
                    GL11.glRotatef(120f, 0F, 1F, 0F);
                    break;
                }
                case GUI: {
                    GL11.glTranslatef(model.gui_translate_x, model.gui_translate_y, model.gui_translate_z);
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
                GL11.glPopMatrix();
            }
            GL11.glScalef(-scal[0], -scal[1], -scal[2]);
        }
        GL11.glPopMatrix();
    }

}
