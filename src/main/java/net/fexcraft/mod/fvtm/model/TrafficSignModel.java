package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.utils.ObjParser;
import net.fexcraft.lib.common.utils.ObjParser.ObjModel;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.CompDataRoot;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.FontData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.FontOffset;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class TrafficSignModel extends GenericModel<TrafficSignData.CompDataRoot, String> {

	public static final TrafficSignModel EMPTY = new TrafficSignModel();
	public FontModelData fontdata;
	
	////-///---/---///-////
	
	public TrafficSignModel(){ super(); }
	
	public TrafficSignModel(JsonObject obj){ super(obj); }
	
	@Override
	public TrafficSignModel parse(Object[] stream, String type){
		return super.parse(stream, type);
	}
	
	public TrafficSignModel(ResourceLocation loc, ObjModel objdata, ArrayList<String> objgroups, boolean exclude){
		super(loc, objdata, objgroups, exclude);
		if(!Boolean.parseBoolean(ObjParser.getCommentValue(objdata, "Font:"))) return;
		fontdata = new FontModelData();
		//
		String space = ObjParser.getCommentValue(objdata, "SpaceWidth:");
		if(space != null) fontdata.space_width = Float.parseFloat(space);
		//
		String letter = ObjParser.getCommentValue(objdata, "LetterSpacing:");
		if(letter != null) fontdata.letter_spacing = Float.parseFloat(letter);
		//
		List<String[]> chars = ObjParser.getCommentValues(objdata, new String[]{ "Char:" }, null, null);
		for(int i = 0; i < chars.size(); i++){
			String[] arr = chars.get(i);
			CharModelData data = new CharModelData();
			float offx = 0, offy = 0;
			try{
				if(arr[0].startsWith("U+")){
					data.id = (char)Integer.parseInt(arr[0].substring(2), 16);
				}
				else if(arr[0].startsWith("u") && arr[0].length() > 1){
					data.id = (char)Integer.parseInt(arr[0].substring(1), 16);
				}
				else{
					data.id = arr[0].toCharArray()[0];
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(arr.length > 1) data.width = Float.parseFloat(arr[1]);
			if(arr.length > 2) data.height = Float.parseFloat(arr[2]);
			if(arr.length > 3) offx = Float.parseFloat(arr[3]);
			if(arr.length > 4) offy = Float.parseFloat(arr[4]);
			if(arr.length > 5){
				for(int j = 5; j < arr.length; j++){
					TurboList list = groups.get(arr[j]);
					if(list != null) data.groups.add(list);
				}
			}
			else{
				if(groups.contains(data.id + "")) data.groups.add(groups.get(data.id + ""));
			}
			for(TurboList list : data.groups){
				boolean found = false;
				for(TurboList.Program prog : list.programs){
					if(prog instanceof TrafficSignPrograms.ColorChannel){
						found = true;
						break;
					}
				}
				if(!found) list.addProgram(new TrafficSignPrograms.ColorChannel(0));
			}
			if(offx != 0){
				final float ox = offx;
				data.groups.forEach(list -> list.forEach(mrt -> mrt.rotationPointX -= ox));
			}
			if(offy != 0){
				final float oy = offy;
				data.groups.forEach(list -> list.forEach(mrt -> mrt.rotationPointY -= oy));
			}
			fontdata.chars.put(data.id, data);
		}
	}

	@Override
	public void render(CompDataRoot data, String key){
		if(fontdata != null){
			FontData font = (FontData)data;
			if(font.text() == null) font.init(fontdata);
			for(FontOffset offset : font.text()){
				GL11.glTranslatef(offset.offset, 0, 0);
				for(TurboList list : offset.data.groups) list.renderTrafficSign(data, key, null, null);
				GL11.glTranslatef(-offset.offset, 0, 0);
			}
			return;
		}
		for(TurboList list : groups) list.renderTrafficSign(data, key, null, null);
	}

	@Override
	public void render(CompDataRoot data, String key, Entity ent, RenderCache cache){
		if(fontdata != null){
			FontData font = (FontData)data;
			if(font.text() == null) font.init(fontdata);
			for(FontOffset offset : font.text()){
				GL11.glTranslatef(offset.offset, 0, 0);
				for(TurboList list : offset.data.groups) list.renderTrafficSign(data, key, null, null);
				GL11.glTranslatef(-offset.offset, 0, 0);
			}
			return;
		}
		for(TurboList list : groups) list.renderTrafficSign(data, key, (TrafficSignEntity)ent, cache);
	}
	
	public static class FontModelData {
		
		public float letter_spacing;
		public float space_width;
		public HashMap<Character, CharModelData> chars = new HashMap<>();
		
	}
	
	public static class CharModelData {

		public ArrayList<TurboList> groups = new ArrayList<>();
		public float height;
		public float width;
		public char id;
		
	}
	
}