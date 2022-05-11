package net.fexcraft.mod.fvtm.event;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.Cloth;
import net.fexcraft.mod.fvtm.data.Material;
import net.fexcraft.mod.fvtm.data.container.Container;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.minecraftforge.fml.common.eventhandler.Event;

public class TypeEvents<T extends TypeCore<T>> extends Event {

	private TypeCore<T> type;
	private JsonObject config;
	
	public TypeEvents(TypeCore<T> type, JsonObject config){
		this.type = type;
	}
	
	public T getType(){
		return (T)type;
	}
	
	public JsonObject getConfig(){
		return config;
	}
	
	public static class MaterialCreated extends TypeEvents<Material> {

		public MaterialCreated(TypeCore<Material> type, JsonObject obj){
			super(type, obj);
		}
		
	}
	
	public static class PartCreated extends TypeEvents<Part> {
		
		public PartCreated(Part part, JsonObject obj){
			super(part, obj);
		}
		
	}
	
	public static class VehicleCreated extends TypeEvents<Vehicle> {

		public VehicleCreated(TypeCore<Vehicle> type, JsonObject obj){
			super(type, obj);
		}
		
	}
	
	public static class ContainerCreated extends TypeEvents<Container> {

		public ContainerCreated(TypeCore<Container> type, JsonObject obj){
			super(type, obj);
		}
		
	}
	
	public static class ClothCreated extends TypeEvents<Cloth> {

		public ClothCreated(TypeCore<Cloth> type, JsonObject obj){
			super(type, obj);
		}
		
	}

}
