package net.fexcraft.mod.fvtm.model.container;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.part.PartModel;
import net.fexcraft.mod.lib.tmt.util.TMTItemModel;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ContainerBaseModel extends GenericModel<ContainerData, Object> implements TMTItemModel {
	
    public float gui_translate_x = 0;
    public float gui_translate_y = 0;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.125f;
    public float gui_scale_y = 0.125f;
    public float gui_scale_z = 0.125f;
    
	public ContainerBaseModel(){ super(); }
	
	public ContainerBaseModel(JsonObject obj){ super(obj); }
	
	@Override
	public void render(ContainerData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(ContainerData data, Object key, Entity ent, int meta){
		render(submodels.get("body"));
        //
        if(PartModel.rq(submodels.get("body_colored_primary"), submodels.get("body_door_close_colored_primary"), submodels.get("body_door_open_colored_primary"))){
            data.getPrimaryColor().glColorApply();
            render(submodels.get("bodyColoredPrimary"));
            render((key instanceof VehicleData ? ((VehicleData)key).doorsOpen() : false) ? submodels.get("body_door_open_colored_primary") : submodels.get("body_door_close_colored_primary"));
            RGB.glColorReset();
        }
        //
        if(PartModel.rq(submodels.get("body_colored_secondary"))){
            data.getSecondaryColor().glColorApply();
            render(submodels.get("body_colored_secondary"));
            RGB.glColorReset();
        }
        //
        render(submodels.get("other"));
	}

	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity) {
		ContainerData data = ((ContainerItem)item.getItem()).getContainer(item);
        if(data == null){ return; }
        ContainerBaseModel model = (ContainerBaseModel)data.getContainer().getModel();
        if(model == null){ return; }
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
                    GL11.glRotatef(-135, 0, 1, 0);
                    GL11.glRotatef(-30, 1, 0, 0);
                    GL11.glRotatef(-30, 0, 0, 1);
                    break;
                }
                case HEAD: {
                    //GL11.glTranslatef(0, 8, 0);
                    break;
                }
                default: break;
            }
            GL11.glScalef(scal[0], scal[1], scal[2]);
            //
            {
                GL11.glPushMatrix();
                GL11.glRotated(180d, 1, 0, 0);
                bindTexture(data.getTexture());
                model.render(data, null);
                //
                GL11.glPopMatrix();
            }
            GL11.glScalef(-scal[0], -scal[1], -scal[2]);
        }
        GL11.glPopMatrix();
	}
	
}