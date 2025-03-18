package net.fexcraft.mod.fvtm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FVTM implements ModInitializer {

	@Override
	public void onInitialize(){
		FvtmRegistry.init("1.21", new File(FabricLoader.getInstance().getGameDirectory(), "/config/"));
		Logger LOGGER21 = LoggerFactory.getLogger("fvtm");
		FvtmLogger.LOGGER = new FvtmLogger() {
			@Override
			protected void log0(Object obj){
				LOGGER21.info(obj == null ? "null " + new Exception().getStackTrace()[2].toString() : obj.toString());
			}
		};
	}

}