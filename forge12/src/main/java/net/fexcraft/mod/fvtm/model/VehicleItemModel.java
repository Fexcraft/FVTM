package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.content.VehicleModel;
import net.fexcraft.mod.fvtm.render.VehicleRenderer;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX__96)
 */
public class VehicleItemModel implements FCLItemModel {

	public static final VehicleItemModel INSTANCE = new VehicleItemModel();

	@Override
	public void renderItem(ItemCameraTransforms.TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof VehicleItem == false) return;
		VehicleData data = item.getCapability(Capabilities.VAPDATA, null).getVehicleData();
		if(data == null) return;
		VehicleModel model = (VehicleModel)data.getType().getModel();
		if(model == null || model == DefaultModel.EMPTY){
			DebugModels.SPHERE_RED.render(0.5f);
			RGB.glColorReset();
			return;
		}
		//
		GL11.glPushMatrix();
		Vec3f translate = model.item_translate.get(type.name());
		GL11.glTranslatef(translate.x, translate.y, translate.z);
		if(data.getType().isTrailer() && !data.getType().getVehicleType().isRailVehicle()){
			if(type == ItemCameraTransforms.TransformType.GUI){
				GL11.glTranslatef(-.375f, -.375f, 0);
			}
			else if(type == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || type == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND){
				GL11.glTranslatef(0, 0, -0.5f);
			}
		}
		Vec3f rotate = model.item_rotate.get(type.name());
		GL11.glRotatef(rotate.y, 0F, 1F, 0F);
		if(type == ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND || type == ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND){
			GL11.glRotatef(data.getType().getVehicleType().isAirVehicle() ? -90f : 90f, 0F, 1F, 0F);
		}
		GL11.glRotatef(rotate.x, 1F, 0F, 0F);
		GL11.glRotatef(rotate.z, 0F, 0F, 1F);
		//
		//
		Vec3f scale = model.item_scale.get(type.name());
		GL11.glScalef(scale.x, scale.y, scale.z);
		//
		{
			GL11.glPushMatrix();
			Model modVehicle = data.getType().getModel();
			GL11.glRotatef(-90f, 0f, 1f, 0f);
			if(modVehicle != null){
				GL11.glPushMatrix();
				TexUtil.bindTexture(data.getCurrentTexture());
				modVehicle.render(DefaultModel.RENDERDATA.set(data, null, Minecraft.getMinecraft().getRenderPartialTicks()));
				GL11.glPopMatrix();
			}
			else {
				TexUtil.bindTexture(data.getCurrentTexture());
				DebugModels.SPHERE.render(0.5f);
			}
			if(data.getParts().size() > 0){
				VehicleRenderer.renderPoint(data.getRotationPoint("vehicle"), null, data, null, Minecraft.getMinecraft().getRenderPartialTicks());
			}
			GL11.glPopMatrix();
		}
		//GL11.glScalef(-scale.xCoord, -scale.yCoord, -scale.zCoord);
		GL11.glPopMatrix();
	}

}
