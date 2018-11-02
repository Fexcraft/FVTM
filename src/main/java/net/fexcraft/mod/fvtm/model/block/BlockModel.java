package net.fexcraft.mod.fvtm.model.block;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class BlockModel extends GenericModel<BlockData, BlockTileEntity> implements FCLItemModel {
	
	public static final String[] defval = new String[]{ "body", "body_colored_primary", "body_colored_secondary", "glow" };
    
    public float gui_translate_x = 0;
    public float gui_translate_y = 0;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.250f;
    public float gui_scale_y = 0.250f;
    public float gui_scale_z = 0.250f;

    public BlockModel(){ super(); }

    public BlockModel(JsonObject obj){
        super(obj);
    }

    @Override
    public void render(){
        //cannot render without providing vehicledata;
    	render("body");
    }

	@Override
	public void render(BlockData data, BlockTileEntity key){
		render(data, key, null, -2);
	}

	@Override
	public void render(BlockData data, BlockTileEntity key, Entity ent, int meta){
		render("body");
		render("body_colored_primary", data.getPrimaryColor());
		render("body_colored_secondary", data.getSecondaryColor());
		renderGlow(ent, "glow");
	}

    @Override
    public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
        BlockData data = ((BlockItem)item.getItem()).getBlock(item);
        if(data == null){ return; }
        BlockModel model = (BlockModel)data.getBlock().getModel();
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
                    GL11.glTranslatef(0F, 0, 0F);
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
                    break;
                }
                case HEAD: {
                    //TODO
                    break;
                }
                default:
                    break;
            }
            if(PREVIEW){
            	scal[0] *= 0.5f; scal[1] *= 0.5f; scal[2] *= 0.5f; PREVIEW = false;
            }
            GL11.glScalef(scal[0], scal[1], scal[2]);
            //
            {
                GL11.glPushMatrix();
                GL11.glRotated(180d, 1, 0, 0);
                super.bindTexture(data.getTexture());
                model.render(data, null, null, -1);
                GL11.glPopMatrix();
            }
            GL11.glScalef(-scal[0], -scal[1], -scal[2]);
        }
        GL11.glPopMatrix();
    }
    
    public static boolean PREVIEW = false;

}
