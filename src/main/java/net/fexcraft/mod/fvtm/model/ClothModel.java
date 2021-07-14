package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.TreeMap;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ClothModel extends GenericModel<ClothItem, ArrayList<String>> {

	public static final ClothModel EMPTY = new ClothModel();
	protected TreeMap<String, ArrayList<String>> cloth_groups = new TreeMap<>();
	
	public ClothModel(){ super(); }
	
	public ClothModel(JsonObject obj){ super(obj); }
	
	public ClothModel(ResourceLocation loc, ObjModel data, ArrayList<String> objgroups, boolean exclude){
		super(loc, data, objgroups, exclude);
		//TODO read group assignment/offset from obj
	}
	
	public void setGroupAs(String group, String playermodelpart, float x, float y, float z){
		if(!groups.contains(group)) return;
		setGroupAs(groups.get(group), playermodelpart, x, y, z);
	}
	
	public void setGroupAs(TurboList group, String playermodelpart, float x, float y, float z){
		if(cloth_groups.containsKey(playermodelpart)){
			cloth_groups.get(playermodelpart).add(group.name);
		}
		else{
			ArrayList<String> arrlist = new ArrayList<>();
			arrlist.add(group.name);
			cloth_groups.put(playermodelpart, arrlist);
		}
		if(x == 0f && y == 0f && z == 0f) return;
		group.translate(x, y, z);
	}

	@Override
	public void render(ClothItem item, ArrayList<String> key){
		transforms.apply();
		for(TurboList list : groups){
			if(!key.contains(list.name)) continue;
			list.render(null, null, null, null, null);
		}
		transforms.deapply();
	}

	@Override
	public void render(ClothItem item, ArrayList<String> key, Entity ent, RenderCache cache){
		transforms.apply();
		GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(TurboList list : groups){
			if(!key.contains(list.name)) continue;
			list.render(null, null, null, null, null);
		}
		transforms.deapply();
	}

	public TreeMap<String, ArrayList<String>> getClothGroups(){
		return cloth_groups;
	}
	
}