package net.fexcraft.mod.fvtm.model.container;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ContainerModel extends GenericModel<ContainerData, Object> implements FCLItemModel {
	
	public static final ContainerModel EMPTY = new ContainerModel();
	public static final String[] defval = new String[]{ "body", "body_colored_primary", "body_door_open_colored_primary",
		"body_door_close_colored_primary", "body_colored_secondary", "other"};
	
	////-///---/---///-////
	
    public float gui_translate_x = 0;
    public float gui_translate_y = 0;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.125f;
    public float gui_scale_y = 0.125f;
    public float gui_scale_z = 0.125f;
    
	public ContainerModel(){ super(); }
	
	public ContainerModel(JsonObject obj){ super(obj); }
	
	public ContainerModel(String type, ResourceLocation loc){ super(type, loc); }
    
	@Override
	public void render(ContainerData data, Object key){
		render(data, key, null, -2);
	}

	@Override
	public void render(ContainerData data, Object key, VehicleEntity ent, int meta){
		for(TurboList list : groups){
			list.render(ent, null, data, null);
		}
	}
	
	////-///---/---///-////

	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity) {
		ContainerData data = ((ContainerItem)item.getItem()).getContainer(item);
        if(data == null){ return; }
        ContainerModel model = (ContainerModel)data.getContainer().getModel();
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