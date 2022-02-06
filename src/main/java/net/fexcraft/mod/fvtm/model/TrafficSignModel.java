package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.CompDataRoot;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TrafficSignModel extends GenericModel<TrafficSignData.CompDataRoot, String> implements FCLItemModel {

	public static final TrafficSignModel EMPTY = new TrafficSignModel();
	
	////-///---/---///-////
	
	public TrafficSignModel(){ super(); }
	
	public TrafficSignModel(JsonObject obj){ super(obj); }
	
	@Override
	public TrafficSignModel parse(Object[] stream, String type){
		return super.parse(stream, type);
	}
	
	public TrafficSignModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){ super(loc, data, objgroups, exclude); }

	@Override
	public void render(CompDataRoot data, String key){
		for(TurboList list : groups) list.renderTrafficSign(data, key, null, null);
	}

	@Override
	public void render(CompDataRoot data, String key, Entity ent, RenderCache cache){
		for(TurboList list : groups) list.renderTrafficSign(data, key, (TrafficSignEntity)ent, cache);
	}
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		/*if(item.getItem() instanceof RoadSignItem == false){ return; }
		TrafficSign data = item.getCapability(Capabilities.VAPDATA, null).getRSData(); if(data == null){ return; }
		TrafficSignModel model = (TrafficSignModel)data.getModel(); if(model == null) { return; }
		//
		GL11.glPushMatrix();
		switch(type){
			case GROUND: {
				GL11.glTranslatef(-0.45F, -0.05F, 0);
				break;
			}
			case FIXED: {
				//
				break;
			}
			case THIRD_PERSON_RIGHT_HAND:
			case THIRD_PERSON_LEFT_HAND: {
				GL11.glRotatef(90f, 0F, 1F, 0F);
				GL11.glTranslatef(0, -0.5f, 0);
				break;
			}
			case FIRST_PERSON_LEFT_HAND: {
				GL11.glTranslatef(0, -0.5f, 0);
				GL11.glRotatef(60f, 0F, 1F, 0F);
				break;
			}
			case FIRST_PERSON_RIGHT_HAND: {
				GL11.glTranslatef(0, -0.5f, 0);
				GL11.glRotatef(-60f, 0F, 1F, 0F);
				break;
			}
			case GUI: {
				GL11.glTranslatef(0, -0.5f, 0);
				break;
			}
			case HEAD: {
				// TODO
				break;
			}
			default: break;
		}
		GL11.glPushMatrix();
		GL11.glRotated(180d, 1, 0, 0);
		bindTexture(data.getTexture());
		model.render(null, data);
		GL11.glPopMatrix();
		GL11.glPopMatrix();*/
		DebugModels.CENTERSPHERE.render();
	}
	
}