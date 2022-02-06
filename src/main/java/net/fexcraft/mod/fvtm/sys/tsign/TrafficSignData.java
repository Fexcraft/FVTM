package net.fexcraft.mod.fvtm.sys.tsign;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.model.TrafficSignModel;
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
		
		public CompDataRoot(String str, ComponentType type){
			this.type = type;
			comp = str;
			for(int i = 0; i < 9; i++) channels[i] = RGB.WHITE.copy();
			channels[0].packed = RGB.GREEN.packed;
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
					//TODO
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

		public FontData(String str){
			super(str, ComponentType.FONT);
		}
		
	}

}
