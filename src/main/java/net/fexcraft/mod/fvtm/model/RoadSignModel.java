package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RoadSign;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.RoadSignEntity;
import net.fexcraft.mod.fvtm.item.RoadSignItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RoadSignModel extends GenericModel<RoadSignEntity, RoadSign> implements FCLItemModel {

	public static final RoadSignModel EMPTY = new RoadSignModel();
	
	////-///---/---///-////
	
	public RoadSignModel(){ super(); }
	
	public RoadSignModel(JsonObject obj){ super(obj); }
	
	@Override
	public RoadSignModel parse(Object[] stream, String type){
		return super.parse(stream, type);
	}
	
	public RoadSignModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){ super(loc, data, objgroups, exclude); }

	@Override
	public void render(RoadSignEntity data, RoadSign key){
		for(TurboList list : groups){ list.renderPlain(); }
	}

	@Override
	public void render(RoadSignEntity data, RoadSign key, Entity ent, RenderCache cache){
		for(TurboList list : groups){ list.renderPlain(); }
	}
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof RoadSignItem == false){ return; }
		RoadSign data = item.getCapability(Capabilities.VAPDATA, null).getRSData(); if(data == null){ return; }
		RoadSignModel model = (RoadSignModel)data.getModel(); if(model == null) { return; }
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
		GL11.glPopMatrix();
	}
	
}