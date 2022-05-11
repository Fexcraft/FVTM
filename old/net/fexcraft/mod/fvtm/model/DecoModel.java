package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class DecoModel extends GenericModel<DecorationData, Object> {
	
	public static final DecoModel EMPTY = new DecoModel();

	public DecoModel(){ super(); }
	
	public DecoModel(JsonObject obj){ super(obj); }
	
	@Override
	public DecoModel parse(Object[] stream, String type){
		return super.parse(stream, type);
	}
	
	public DecoModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){
		super(loc, data, objgroups, exclude);
	}

	@Override
	public void render(DecorationData data, Object obj){
		transforms.apply();
		for(TurboList list : groups){
			list.render(null, null, data, null, null);
		}
		transforms.deapply();
	}

	@Override
	public void render(DecorationData data, Object obj, Entity ent, RenderCache cache){
		transforms.apply();
		GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(TurboList list : groups){
			list.render(ent, null, data, null, cache);
		}
		transforms.deapply();
	}

}
