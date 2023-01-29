package net.fexcraft.mod.fvtm.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log2 extends Log {
	
	private static final Logger logger = LogManager.getLogger("FVTM");

	@Override
	protected void print0(Object obj){
		if(obj instanceof Iterable){
			Iterable<?> inte = (Iterable<?>)obj;
			logger.info("ITERABLE: {");
			for(Object object : inte){
				logger.info("    " + (object == null ? ">> IS null;" : String.valueOf(object)));
			}
			logger.info("}");
			return;
		}
		if(obj instanceof Throwable){
			logger.info(ExceptionUtils.getStackTrace((Throwable)obj));
		}
		logger.info(obj == null ? "[OBJ IS NULL]" : String.valueOf(obj));
	}

}
