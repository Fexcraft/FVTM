package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.util.TexUtil.bindTexture;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockItemModel implements FCLItemModel {

    public static BlockItemModel INSTANCE = new BlockItemModel();

    private BlockItemModel(){}

    @Override
    public void renderItem(ItemCameraTransforms.TransformType type, ItemStack item, EntityLivingBase entity){
        if(item.getItem() instanceof BlockItem == false){ Print.debug("wrong_instance"); return; }
        BlockData data = item.getCapability(Capabilities.VAPDATA, null).getBlockData(); if(data == null){ Print.debug("no_data"); return; }
        BlockModel model = (BlockModel)data.getType().getModel();
        if(model == null){ Print.debug("no_model"); return; }
        float[] scal = new float[]{ model.gui_scale_x, model.gui_scale_y, model.gui_scale_z };
        //
        GL11.glPushMatrix();
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
        GL11.glScalef(scal[0], scal[1], scal[2]);
        bindTexture(model.bindtex ? data.getCurrentTexture() : FvtmRegistry.WHITE_TEXTURE);
        model.render(RENDERDATA.set(data, null, null, null, true));
        Block block = ((ItemBlock)item.getItem()).getBlock();
        for(IProperty<?> property : block.getBlockState().getProperties()){
            ArrayList<BlockModel> models = model.state_models.get(property.getName() + "=" + block.getStateFromMeta(item.getMetadata()).getValue(property));
            if(models == null) continue;
            for(BlockModel mod : models) mod.render(RENDERDATA);
        }
        GL11.glPopMatrix();
    }

}
