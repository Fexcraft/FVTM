package net.fexcraft.mod.fvtm.model;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonElement;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData.BaseData;

public class TrafficSignPrograms {

	public static void init(){
		TurboList.PROGRAMS.add(new ColorChannel(0));
		TurboList.PROGRAMS.add(new SignBase());
		TurboList.PROGRAMS.add(new SignBorder(true));
		TurboList.PROGRAMS.add(new SignBorderEdge(true));
	}
	
	public static class ColorChannel implements Program {
		
		private int channel;
		
		public ColorChannel(int channel){
			this.channel = channel;
		}
		
		@Override
		public String getId(){
			return "fvtm:ts_rgb_channel";
		}
		
		@Override
		public void preRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			data.channels[channel].glColorApply();
		}
		
		@Override
		public void postRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			RGB.glColorReset();
		}
		
		@Override
		public Program parse(JsonElement elm){
			return new ColorChannel(elm.getAsJsonArray().get(0).getAsInt());
		}

		@Override
		public Program parse(String[] args){
			return new ColorChannel(Integer.parseInt(args[0]));
		}
		
	}
	
	public static class SignBase implements Program {
		
		public SignBase(){}

		@Override
		public String getId(){
			return "fvtm:ts_sign_base";
		}
		
		@Override
		public void preRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			list.visible = ((BaseData)data).base;
		}
		
		@Override
		public void postRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			list.visible = true;
		}
		
	}
	
	public static class SignBorder implements Program {
		
		public static SignBorder[] inst = new SignBorder[4];
		
		private int index = 0;
		
		public SignBorder(boolean init){
			if(!init) return;
			inst[0] = new SignBorder(false).index(0);
			inst[1] = new SignBorder(false).index(1);
			inst[2] = new SignBorder(false).index(2);
			inst[3] = new SignBorder(false).index(3);
		}
		
		private SignBorder index(int idx){
			index = idx;
			return this;
		}

		@Override
		public String getId(){
			return "fvtm:ts_sign_border";
		}
		
		@Override
		public void preRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			if(!(list.visible = ((BaseData)data).sides[index])) return;
			GL11.glPushMatrix();
			switch(index){
				case 0: GL11.glTranslatef(0, -(data.scale1 - 1) * 0.5f, 0); break;
				case 1: GL11.glTranslatef(-(data.scale0 - 1) * 0.5f, 0, 0); break;
				case 2: GL11.glTranslatef((data.scale0 - 1) * 0.5f, 0, 0); break;
				case 3: GL11.glTranslatef(0, (data.scale1 - 1) * 0.5f, 0); break;
			}
		}
		
		@Override
		public void postRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			if(list.visible){
				GL11.glPopMatrix();
			}
			list.visible = true;
		}
		
		@Override
		public Program parse(JsonElement elm){
			return parse(elm.getAsJsonArray().get(0).getAsString());
		}

		@Override
		public Program parse(String[] args){
			return parse(args[0]);
		}

		private Program parse(String str){
			switch(str){
				case "top":
				case "t":{
					return inst[0];
				}
				case "bottom":
				case "bot":
				case "b":{
					return inst[3];
				}
				case "left":
				case "l":{
					return inst[1];
				}
				case "right":
				case "r":{
					return inst[2];
				}
			}
			return inst[0];
		}
		
	}
	
	public static class SignBorderEdge implements Program {
		
		public static SignBorderEdge[] inst = new SignBorderEdge[4];
		
		private int idx0, idx1, idx2;
		
		public SignBorderEdge(boolean init){
			if(!init) return;
			inst[0] = new SignBorderEdge(false).index(0, 1, 0);
			inst[1] = new SignBorderEdge(false).index(0, 2, 1);
			inst[2] = new SignBorderEdge(false).index(2, 3, 2);
			inst[3] = new SignBorderEdge(false).index(1, 3, 3);
		}
		
		private SignBorderEdge index(int idx3, int idx4, int idx5){
			idx0 = idx3;
			idx1 = idx4;
			idx2 = idx5;
			return this;
		}

		@Override
		public String getId(){
			return "fvtm:ts_sign_border_edge";
		}
		
		@Override
		public void preRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			BaseData base = (BaseData)data;
			if(!base.sides[idx0] || !base.sides[idx1]) list.visible = false;
			if(!list.visible) return;
			GL11.glPushMatrix();
			switch(idx2){
				case 0: GL11.glTranslatef(-(data.scale0 - 1) * 0.5f, -(data.scale1 - 1) * 0.5f, 0); break;
				case 1: GL11.glTranslatef((data.scale0 - 1) * 0.5f, -(data.scale1 - 1) * 0.5f, 0); break;
				case 2: GL11.glTranslatef((data.scale0 - 1) * 0.5f, (data.scale1 - 1) * 0.5f, 0); break;
				case 3: GL11.glTranslatef(-(data.scale0 - 1) * 0.5f, (data.scale1 - 1) * 0.5f, 0); break;
			}
		}
		
		@Override
		public void postRender(TurboList list, TrafficSignEntity ent, TrafficSignData.CompDataRoot data, RenderCache cache){
			if(list.visible){
				GL11.glPopMatrix();
			}
			list.visible = true;
		}
		
		@Override
		public Program parse(JsonElement elm){
			return parse(elm.getAsJsonArray().get(0).getAsString());
		}

		@Override
		public Program parse(String[] args){
			return parse(args[0]);
		}

		private Program parse(String str){
			switch(str){
				case "top_left":
				case "tl":{
					return inst[0];
				}
				case "top_right":
				case "tr":{
					return inst[1];
				}
				case "bottom_right":
				case "bot_right":
				case "br":{
					return inst[2];
				}
				case "bottom_left":
				case "bot_left":
				case "bl":{
					return inst[3];
				}
			}
			return inst[0];
		}
		
	}

}
