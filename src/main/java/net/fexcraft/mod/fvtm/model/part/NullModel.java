//This File was created with the Minecraft-SMP Modelling Toolbox 2.3.0.0
// Copyright (C) 2016 Minecraft-SMP.de
// This file is for Fex's Vehicle Mod

// Model: T1(P)
// Model Creator: FEX___96
// Created on: 20.01.2016 - 22:15:40
// Last changed on: 20.01.2016 - 22:15:40

package net.fexcraft.mod.fvtm.model.part;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.entity.Entity;

public class NullModel extends PartModel {
	
	int textureX = 512;
	int textureY = 512;
	
	private static final NullModel nullmodel = new NullModel();

	public NullModel(){}
	
	@Override
	public void render(){
		return;
	}
	
	@Override
	public void render(VehicleData data, String usedAs){
		return;
	}
	
	@Override
	public void render(VehicleData data, String usedAS, Entity vehicle){
		/*//Particle
		if(vehicle.throttle != 0 && data.parts.get(usedAS).pspawners != null){
			PartType part = data.parts.get(usedAS);
			for(int i = 0; i < part.pspawners.length; i++){
				Vec3d vec = calculatePos(vehicle, part.pspawners[i].pos);
				vehicle.world.spawnParticle(part.pspawners[i].type, vec.xCoord, vec.yCoord, vec.zCoord, part.pspawners[i].sx, part.pspawners[i].sy, part.pspawners[i].sz);
			}
		}
		//CargoPos
		if(data.getContainer().getSizeInventory() > 0 && data.parts.get(usedAS).cargopos.size() > 0){
			PartType part = data.parts.get(usedAS);
            net.minecraft.client.Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			for(int i = 0; i < data.container.getSizeInventory(); i++){
				if(i >= part.cargopos.size()){
					break;
				}
				CargoRenderPos pos = part.cargopos.get(i);
				if(!pos.renderAlways && data.parts.containsKey("cargo")){
					continue;
				}
				IBlockState state = getBlockToRender(i, data);
				if(state.getRenderType() != EnumBlockRenderType.INVISIBLE){;
					pos.pos.translate();
		            /*GlStateManager.pushMatrix();
		            if(pos.scale != 1f){
		            	GL11.glScalef(pos.scale, pos.scale, pos.scale);
		            }*//*
		            GlStateManager.pushMatrix();
	            	//GL11.glRotatef( 180, 0, 0, 1);
		            Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(state, vehicle.getBrightness(Minecraft.getMinecraft().getRenderPartialTicks()));
	            	//GL11.glRotatef(-180, 0, 0, 1);
		            GlStateManager.popMatrix();
		            //GlStateManager.popMatrix();
		            pos.pos.translateR();
		        }
			}
            part.bindTexture();
		}*/
		return;
	}

	public static PartModel get(){
		return nullmodel;
	}
	
}