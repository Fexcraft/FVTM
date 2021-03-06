package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
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
	
	public ContainerModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){ super(loc, data, objgroups, exclude); }
    
	@Override
	public void render(ContainerData data, Object key){
		transforms.apply();
		render(data, key, null, null);
		transforms.deapply();
	}

	@Override
	public void render(ContainerData data, Object key, Entity ent, RenderCache cache){
		transforms.apply();
        GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(TurboList list : groups){ list.render(ent, null, data, null, cache); }
		transforms.deapply();
	}
	
	////-///---/---///-////

	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity) {
		if(item.getItem() instanceof ContainerItem == false){ return; }
		ContainerData data = item.getCapability(Capabilities.VAPDATA, null).getContainerData();
		if(data == null){ Print.debug("no data in item"); return; }
        ContainerModel model = (ContainerModel)data.getType().getModel();
        if(model == null){ Print.debug("no model in data"); return; }
        float[] scal = new float[]{ model.gui_scale_x, model.gui_scale_y, model.gui_scale_z };
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