package net.fexcraft.mod.fvtm.util.cap.pass;

import net.fexcraft.mod.fvtm.data.PassCap;

public class PassengerCallable implements java.util.concurrent.Callable<PassCap> {

	@Override
	public PassCap call() throws Exception {
		return new PassengerImplementation();
	}

}
