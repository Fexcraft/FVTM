package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.fexcraft.mod.fvtm.model.program.TrafficSignPrograms;
import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.model.program.TrafficSignPrograms.SignBase;
import net.fexcraft.mod.fvtm.model.program.TrafficSignPrograms.SignBorder;
import net.fexcraft.mod.fvtm.model.program.TrafficSignPrograms.SignBorderEdge;

public class TrafficSignModel extends DefaultModel {

	public static final TrafficSignModel EMPTY = new TrafficSignModel();
	private ArrayList<ModelGroup> base, vert, hori, other;
	public FontModelData fontdata;
	private boolean signbase;
	
	////-///---/---///-////
	
	@Override
	public TrafficSignModel parse(ModelData data){
		super.parse(data);
		if(!data.get("Font", false)){
			checkifsignbase();
			return this;
		}
		fontdata = new FontModelData();
		//
		fontdata.space_width = data.getFloat("SpaceWidth", 0);
		fontdata.letter_spacing = data.getFloat("LetterSpacing", 0);
		//
		List<String> chars = data.getArray("Char").toStringList();
		for(int i = 0; i < chars.size(); i++){
			String[] arr = chars.get(i).trim().split(" ");
			CharModelData chardata = new CharModelData();
			float offx = 0, offy = 0;
			try{
				if(arr[0].startsWith("U+")){
					chardata.id = (char)Integer.parseInt(arr[0].substring(2), 16);
				}
				else if(arr[0].startsWith("u") && arr[0].length() > 1){
					chardata.id = (char)Integer.parseInt(arr[0].substring(1), 16);
				}
				else{
					chardata.id = arr[0].toCharArray()[0];
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(arr.length > 1) chardata.width = Float.parseFloat(arr[1]);
			if(arr.length > 2) chardata.height = Float.parseFloat(arr[2]);
			if(arr.length > 3) offx = Float.parseFloat(arr[3]);
			if(arr.length > 4) offy = Float.parseFloat(arr[4]);
			if(arr.length > 5){
				for(int j = 5; j < arr.length; j++){
					ModelGroup list = groups.get(arr[j]);
					if(list != null) chardata.groups.add(list);
				}
			}
			else{
				if(groups.contains(chardata.id + "")) chardata.groups.add(groups.get(chardata.id + ""));
			}
			for(ModelGroup list : chardata.groups){
				boolean found = false;
				for(Program prog : list.getAllPrograms()){
					if(prog instanceof TrafficSignPrograms.ColorChannel){
						found = true;
						break;
					}
				}
				if(!found) list.addProgram(new TrafficSignPrograms.ColorChannel(0));
			}
			if(offx != 0){
				final float ox = offx;
				chardata.groups.forEach(list -> list.forEach(mrt -> mrt.posX -= ox));
			}
			if(offy != 0){
				final float oy = offy;
				chardata.groups.forEach(list -> list.forEach(mrt -> mrt.posY -= oy));
			}
			fontdata.chars.put(chardata.id, chardata);
		}
		return this; 
	}
	
	private void checkifsignbase(){
		for(ModelGroup list : groups){
			if(signbase) break;
			for(Program prog : list.getAllPrograms()){
				if(prog instanceof SignBase || prog instanceof SignBorder || prog instanceof SignBorderEdge){
					signbase = true;
					break;
				}
			}
		}
		if(!signbase) return;
		base = new ArrayList<>();
		vert = new ArrayList<>();
		hori = new ArrayList<>();
		other = new ArrayList<>();
		for(ModelGroup list : groups){
			boolean found = false;
			for(Program prog : list.getAllPrograms()){
				if(prog instanceof SignBase){
					base.add(list);
					found = true;
					break;
				}
				else if(prog instanceof SignBorder){
					if(prog == SignBorder.inst[0] || prog == SignBorder.inst[3]){
						hori.add(list);
					}
					else vert.add(list);
					found = true;
					break;
				}
			}
			if(!found) other.add(list);
		}
	}

	@Override
	public void render(ModelRenderData renderdata){
		CompDataRoot data = (CompDataRoot)renderdata.trafficsign_compdata;
		if(fontdata != null){
			FontData font = (FontData)data;
			if(font.text() == null) font.init(fontdata);
			for(FontOffset offset : font.text()){
				GL11.glTranslatef(offset.offset, 0, 0);
				for(ModelGroup list : offset.data.groups) list.render(renderdata);
				GL11.glTranslatef(-offset.offset, 0, 0);
			}
			return;
		}
		else if(signbase){
			GL11.glPushMatrix();
			GL11.glScalef(data.scale0, data.scale1, 1);
			for(ModelGroup list : base){
				list.render(renderdata);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(data.scale0, 1, 1);
			for(ModelGroup list : hori){
				list.render(renderdata);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(1, data.scale1, 1);
			for(ModelGroup list : vert){
				list.render(renderdata);
			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			//TODO offset
			for(ModelGroup list : other){
				list.render(renderdata);
			}
			GL11.glPopMatrix();
			return;
		}
		for(ModelGroup list : groups) list.render(renderdata);
	}
	
	public static class FontModelData {
		
		public float letter_spacing;
		public float space_width;
		public HashMap<Character, CharModelData> chars = new HashMap<>();
		
	}
	
	public static class CharModelData {

		public ArrayList<ModelGroup> groups = new ArrayList<>();
		public float height;
		public float width;
		public char id;
		
	}
	
}