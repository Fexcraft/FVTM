package net.fexcraft.mod.fvtm.sys.tsign;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.model.TrafficSignModel;
import net.fexcraft.mod.fvtm.model.TrafficSignModel.CharModelData;
import net.fexcraft.mod.fvtm.model.TrafficSignModel.FontModelData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrafficSignData {
	
	public ArrayList<BaseData> backgrounds = new ArrayList<>();
	public ArrayList<ComponentData> components = new ArrayList<>();
	public ArrayList<FontData> fonts = new ArrayList<>();

	public TrafficSignData(){
		//
	}
	
	public TrafficSignData read(NBTTagCompound com){
		//
		return this;
	}

	public NBTTagCompound write(){
		//
		return new NBTTagCompound();
	}

	public void render(World world, float partialticks){
		//
	}
	
	public static enum ComponentType {
		
		BASE, COMPONENT, FONT
		
	}
	
	public static class CompDataRoot {
		
		@SideOnly(Side.CLIENT)
		public TrafficSignModel model;
		public final ComponentType type;
		public String comp;
		public RGB[] channels = new RGB[9];
		public int rotation, zoff;
		public float xoff, yoff;
		public float scale;
		
		public CompDataRoot(String str, ComponentType type){
			this.type = type;
			comp = str;
			for(int i = 0; i < 9; i++) channels[i] = RGB.WHITE.copy();
			//channels[0].packed = RGB.GREEN.packed;
		}
		
		public CompDataRoot read(NBTTagCompound com){
			//
			return this;
		}

		public NBTTagCompound write(){
			//
			return new NBTTagCompound();
		}

		@SideOnly(Side.CLIENT)
		public CompDataRoot linkModel(){
			switch(type){
				case BASE:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.BACKGROUNDS.get(comp));
					break;
				case COMPONENT:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.COMPONENTS.get(comp));
					break;
				case FONT:
					model = TrafficSignLibrary.MODELS.get(TrafficSignLibrary.FONTS.get(comp));
					break;
			}
			return this;
		}
		
	}
	
	public static class BaseData extends CompDataRoot {

		public BaseData(String str){
			super(str, ComponentType.BASE);
		}
		
	}
	
	public static class ComponentData extends CompDataRoot {

		public ComponentData(String str){
			super(str, ComponentType.COMPONENT);
		}
		
	}
	
	public static class FontData extends CompDataRoot {

		public String text = "text";
		private ArrayList<FontOffset> chars = new ArrayList<>();

		public FontData(String str){
			super(str, ComponentType.FONT);
		}

		public ArrayList<FontOffset> text(){
			return chars;
		}

		public void text(String str){
			chars = null;
			text = str;
		}

		public void init(FontModelData fontdata){
			chars = new ArrayList<>();
			char[] textchars = text.toCharArray();
			char[] upperchars = text.toUpperCase().toCharArray();
			char[] lowerchars = text.toLowerCase().toCharArray();
			float passed = 0;
			for(int i = 0; i < textchars.length; i++){
				if(textchars[i] == ' '){
					passed += fontdata.space_width + fontdata.letter_spacing;
					continue;
				}
				Object[] cher = findChar(fontdata.chars, textchars[i], lowerchars[i], upperchars[i]);
				if(cher == null){
					passed += fontdata.space_width + fontdata.letter_spacing;
					Print.log("Model for char '" + textchars[i] + "'/#" + Integer.toHexString(textchars[i]) + " not found!");
					continue;
				}
				chars.add(new FontOffset((char)cher[0], (CharModelData)cher[1], passed * Static.sixteenth));
				passed += ((CharModelData)cher[1]).width + fontdata.letter_spacing;
			}
		}

		private static Object[] findChar(HashMap<Character, CharModelData> chars, char c, char l, char u){
			if(chars.containsKey(c)) return new Object[]{ c, chars.get(c) };
			if(chars.containsKey(l)) return new Object[]{ l, chars.get(l) };
			if(chars.containsKey(u)) return new Object[]{ u, chars.get(u) };
			return null;
		}
		
	}
	
	public static class FontOffset {
		
		public char id;
		public float offset;
		public CharModelData data;
		
		public FontOffset(char c, CharModelData data, float passed){
			id = c;
			offset = passed;
			this.data = data;
		}
		
	}

	public CompDataRoot getCompData(ComponentType type, int index){
		if(type == null || index < 0) return null;
		switch(type){
			case BASE:
				if(index >= backgrounds.size()) return null;
				else return backgrounds.get(index);
			case COMPONENT:
				if(index >= components.size()) return null;
				else return components.get(index);
			case FONT:
				if(index >= fonts.size()) return null;
				else return fonts.get(index);
			default: return null;
		}
	}

}
