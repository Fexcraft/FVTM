package net.fexcraft.mod.fvtm.render.item;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.container.ContainerModel;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.tmt.Model;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderCustomItem {
	
	public static final RenderCustomItem INSTANCE = new RenderCustomItem();
	
	public void renderItem(ItemCameraTransforms.TransformType type, ItemStack item, EntityLivingBase entity){
		if(!(item.getItem() instanceof VehicleItem)){
			if(item.getItem() instanceof ContainerItem){
				render(type, item, ((ContainerItem)item.getItem()).getContainer(item), entity);
			}
			return;	
		}
		VehicleData data = ((VehicleItem)item.getItem()).getVehicle(item);
		if(data == null || data.getVehicle().getModel() == null){
			return;
		}
		render(type, item, data, entity);
	}

	private void render(TransformType type, ItemStack item, ContainerData data, EntityLivingBase entity) {
		ContainerModel<ContainerData> model = data.getContainer().getModel();
		if(model == null){ return; }
		float[] scal = new float[]{ 0.125f, 0.125f, 0.125f };
		GL11.glPushMatrix();
		{
			switch(type){
				case GROUND:{
					GL11.glTranslatef(-0.45F, -0.05F, 0);
					break;
				}
				case FIXED:{
					//GL11.glRotatef(0, 0, 0, 0);
					break;
				}
				case THIRD_PERSON_RIGHT_HAND:
				case THIRD_PERSON_LEFT_HAND:{
					GL11.glRotatef(90F, 0F, 1F, 0F);
					GL11.glTranslatef(0F, 0/*-0.15F*/, 0F);
					GL11.glTranslatef(0, 0, 0);
					break;
				}
				case FIRST_PERSON_LEFT_HAND:{
					//GL11.glTranslatef(-1F, 0.675F, 0F);
					GL11.glRotatef( 60f, 0F, 1F, 0F);
					break;
				}
				case FIRST_PERSON_RIGHT_HAND:{
					//GL11.glTranslatef(-1F, 0.675F, 0f);
					GL11.glRotatef(120f, 0F, 1F, 0F);
					break;
				}
				case GUI:{
					GL11.glTranslatef(model.gui_translate_x, model.gui_translate_y, model.gui_translate_z);
					GL11.glRotatef(-135, 0, 1, 0);
					GL11.glRotatef(-30, 1, 0, 0);
					GL11.glRotatef(-30, 0, 0, 1);
					//
					scal[0] = model.gui_scale_x;
					scal[1] = model.gui_scale_y;
					scal[2] = model.gui_scale_z;
					break;
				}
				case HEAD:{
					//TODO
					break;
				}
				default: break;
			}
			GL11.glScalef(scal[0], scal[1], scal[2]);
			//
			{
				GL11.glPushMatrix();
				GL11.glRotated(180d, 1, 0, 0);
				Model.bindTexture(data.getTexture());
				try{
					VehicleData vehdata = ((Vehicle)Resources.VEHICLES.getValues().toArray()[0]).getDataClass().getConstructor(Vehicle.class).newInstance((Vehicle)Resources.VEHICLES.getValues().toArray()[0]);
					data.getContainer().getModel().render(vehdata, "null", data, data.getContainer().getType() == ContainerType.LARGE ? ContainerPosition.LARGE_SINGLE : ContainerPosition.MEDIUM_SINGLE, entity);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				//
				GL11.glPopMatrix();
			}
		}
		GL11.glPopMatrix();
	}

	private void render(TransformType type, ItemStack item, VehicleData data, EntityLivingBase entity){
		VehicleModel<VehicleData> model = data.getVehicle().getModel();
		if(model == null){ return; }
		float[] scal = new float[]{ 0.125f, 0.125f, 0.125f };
		GL11.glPushMatrix();
		{
			switch(type){
				case GROUND:{
					GL11.glTranslatef(-0.45F, -0.05F, 0);
					break;
				}
				case FIXED:{
					//GL11.glRotatef(0, 0, 0, 0);
					break;
				}
				case THIRD_PERSON_RIGHT_HAND:
				case THIRD_PERSON_LEFT_HAND:{
					GL11.glRotatef(90F, 0F, 1F, 0F);
					GL11.glTranslatef(0F, 0/*-0.15F*/, 0F);
					GL11.glTranslatef(0, 0, 0);
					break;
				}
				case FIRST_PERSON_LEFT_HAND:{
					if(data.getVehicle().isTrailerOrWagon()){
						GL11.glTranslatef(0, 0, -0.5f);
					}
					GL11.glRotatef( 60f, 0F, 1F, 0F);
					break;
				}
				case FIRST_PERSON_RIGHT_HAND:{
					if(data.getVehicle().isTrailerOrWagon()){
						GL11.glTranslatef(0, 0, -0.5f);
					}
					GL11.glRotatef(120f, 0F, 1F, 0F);
					break;
				}
				case GUI:{
					float f = data.getVehicle().isTrailerOrWagon() ? -0.375f : 0;
					GL11.glTranslatef(model.gui_translate_x + f, model.gui_translate_y + f, model.gui_translate_z);
					GL11.glRotatef(-135, 0, 1, 0);
					GL11.glRotatef(-30, 1, 0, 0);
					GL11.glRotatef(-30, 0, 0, 1);
					//
					scal[0] = model.gui_scale_x;
					scal[1] = model.gui_scale_y;
					scal[2] = model.gui_scale_z;
					break;
				}
				case HEAD:{
					//TODO
					break;
				}
				default: break;
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
		}
		GL11.glPopMatrix();
	}
	
}