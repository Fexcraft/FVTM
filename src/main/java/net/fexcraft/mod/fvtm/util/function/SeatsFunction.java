package net.fexcraft.mod.fvtm.util.function;

import java.util.ArrayList;
import java.util.Collection;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.part.Part2;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;

public class SeatsFunction extends StaticFunction {
	
	private ArrayList<Seat> seats = new ArrayList<>();

	@Override
	public PartFunction init(Part2 part, FJson json){
		for(JsonValue<?> entry : json.asArray().value){
			seats.add(new Seat(entry.asMap()));
		}
		return this;
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
