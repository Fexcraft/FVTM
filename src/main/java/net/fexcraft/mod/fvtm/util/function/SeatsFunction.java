package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.part.Function.StaticFuntion;
import net.fexcraft.mod.fvtm.data.part.Part;

public class SeatsFunction extends StaticFuntion {
	
	private ArrayList<Seat> seats = new ArrayList<>();

	public SeatsFunction(Part part, JsonObject obj){
		super(part, obj); JsonArray array = obj.get("seats").getAsJsonArray();
		for(JsonElement elm : array){
			seats.add(new Seat(elm.getAsJsonObject()));
		}
	}

	@Override
	public String getId(){
		return "fvtm:seats";
	}
	
	public Collection<Seat> getPositions(){
		return seats;
	}

	public ArrayList<Seat> getSeats(){
		return seats;
	}
	
}
