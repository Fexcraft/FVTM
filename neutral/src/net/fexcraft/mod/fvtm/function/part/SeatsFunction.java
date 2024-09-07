package net.fexcraft.mod.fvtm.function.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;

import net.fexcraft.app.json.FJson;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.data.Seat;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartFunction;
import net.fexcraft.mod.fvtm.data.part.PartFunction.StaticFunction;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SeatsFunction extends StaticFunction {
	
	private ArrayList<Seat> seats = new ArrayList<>();

	@Override
	public PartFunction init(Part part, FJson json){
		for(Entry<String, JsonValue<?>> entry : json.asMap().entries()){
			seats.add(new Seat(entry.getKey(), entry.getValue().asMap()));
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
