package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.mod.fvtm.data.Passenger;

public class PassengerCallable implements java.util.concurrent.Callable<Passenger> {

	@Override
	public Passenger call() throws Exception {
		return new PassengerImplementation();
	}

}
