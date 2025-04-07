package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import static net.fexcraft.mod.fvtm.util.TexUtil.bindTexture;

/**
 * @author Ferdinand Calo' (FEX__96)
 */
public class ContainerItemModel extends DefaultModel implements FCLItemModel {
	
	public static final ContainerItemModel INSTANCE = new ContainerItemModel();

	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity) {
		if(item.getItem() instanceof ContainerItem == false){ return; }
		ContainerData data = item.getCapability(Capabilities.VAPDATA, null).getContainerData();
		if(data == null){ Print.debug("no data in item"); return; }
        ContainerItemModel model = (ContainerItemModel)data.getType().getModel();
        if(model == null){ Print.debug("no model in data"); return; }
        float[] scal = new float[]{ 0.125f, 0.125f, 0.125f };
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
                bindTexture(data.getCurrentTexture());
                model.render(RENDERDATA.set(data, null));
                //
                GL11.glPopMatrix();
            }
            GL11.glScalef(-scal[0], -scal[1], -scal[2]);
        }
        GL11.glPopMatrix();
	}
	
}