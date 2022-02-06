package net.fexcraft.mod.fvtm.model;

import com.google.gson.JsonElement;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.data.root.RenderCache;
import net.fexcraft.mod.fvtm.entity.TrafficSignEntity;
import net.fexcraft.mod.fvtm.model.TurboList.Program;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignData;

public class TrafficSignPrograms {

	public static void init(){
		TurboList.PROGRAMS.add(new ColorChannel(0));
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

}
