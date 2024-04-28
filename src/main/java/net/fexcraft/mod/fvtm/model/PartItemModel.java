package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.handler.TireInstallationHandler.*;
import static net.fexcraft.mod.fvtm.util.TexUtil.bindTexture;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.handler.TireInstallationHandler;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler.WheelData;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class PartItemModel implements FCLItemModel {

	public static final PartItemModel INSTANCE = new PartItemModel();
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof PartItem == false) return;
		PartData data = item.getCapability(Capabilities.VAPDATA, null).getPartData();
		if(data == null) return;
		DefaultModel model = (DefaultModel)data.getType().getModel();
		if(model == null) return;
		//
		GL11.glPushMatrix();
		switch(type){
			case GROUND: {
				GL11.glTranslatef(-0.45F, -0.05F, 0);
				break;
			}
			case FIXED: {
				GL11.glRotatef(-90f, 0F, 1F, 0F);
				WheelData ihdata = data.getType().getInstallHandlerData();
				GL11.glTranslatef(0, 0, ihdata.getWidth() * -.015625f);
				break;
			}
			case THIRD_PERSON_RIGHT_HAND:{
				GL11.glRotatef(180f, 0F, 1F, 0F);
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case THIRD_PERSON_LEFT_HAND: {
				GL11.glScalef(.75f, .75f, .75f);
				break;
			}
			case FIRST_PERSON_LEFT_HAND:
			case FIRST_PERSON_RIGHT_HAND: {
				GL11.glRotatef(90f, 0F, 1F, 0F);
				GL11.glScalef(.5f, .5f, .5f);
				break;
			}
			case GUI: {
				GL11.glRotatef(90f, 0F, 1F, 0F);
				if(data.getType().getInstallHandlerData() instanceof WheelData){
					WheelData ihdata = data.getType().getInstallHandlerData();
					if(ihdata.getRadius() > 0.5){
						for(float v = ihdata.getRadius(); v > 0.5; v -= 0.0625)
						GL11.glScalef(1 - Static.sixteenth, 1 - Static.sixteenth, 1 - Static.sixteenth);
					}
				}
				if(data.getType().getInstallHandlerData() instanceof TireData){
					TireData ihdata = data.getType().getInstallHandlerData();
					if(ihdata.getOuterRadius() > 0.5){
						for(float v = ihdata.getOuterRadius(); v > 0.5; v -= 0.0625)
						GL11.glScalef(1 - Static.sixteenth, 1 - Static.sixteenth, 1 - Static.sixteenth);
					}
				}
				break;
			}
			case HEAD: {
				// TODO
				break;
			}
			default: break;
		}
		model.transforms.apply();
		bindTexture(data.getCurrentTexture());
		for(ModelGroup list : model.groups) list.render();
		model.transforms.deapply();
		GL11.glPopMatrix();
	}
	
}