package net.fexcraft.mod.fvtm;

import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.world.MessageSender;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class FvtmLogger {

	public static FvtmLogger LOGGER = null;

	protected abstract void log0(Object obj);

	public void info(String s){
		log0(s);
	}

	public static void log(Object o){
		LOGGER.log0(o);
	}

	public static void log(Iterable<?> it){
		LOGGER.log0("#[");
		for(Object o : it) LOGGER.log0(it);
		LOGGER.log0("]#");
	}

	public static void log(Object... os){
		LOGGER.log0("@[");
		for(Object o : os) LOGGER.log0(o);
		LOGGER.log0("]@");
	}

	public static void debug(Object o){
		if(EnvInfo.DEV) LOGGER.log0(o);
	}

	public static void marker(Object o){
		if(EnvInfo.DEV) LOGGER.log0("MARKER " + o);
	}

	public static void log(Throwable e, String info){
		LOGGER.log0("ERROR: " + e.getMessage() + " / " + e.getCause() + " @ " + info);
		for(StackTraceElement elm : e.getStackTrace()){
			LOGGER.log0(elm);
		}
	}

	public static final MessageSender LOG = new MessageSender(){

		@Override
		public void send(String s){
			FvtmLogger.LOGGER.log(s);
		}

		@Override
		public void send(String str, Object... args){
			FvtmLogger.LOGGER.log(str, args);
		}

		@Override
		public void bar(String s){
			FvtmLogger.LOGGER.log(s);
		}

		@Override
		public void bar(String str, Object... args){
			FvtmLogger.LOGGER.log(str, args);
		}

		@Override
		public void dismount(){
			//
		}

		@Override
		public String getName(){
			return "LOG";
		}

	};
	public static final MessageSender DEVLOG = new MessageSender(){

		@Override
		public void send(String s){
			if(EnvInfo.DEV) FvtmLogger.LOGGER.log(s);
		}

		@Override
		public void send(String str, Object... args){
			if(EnvInfo.DEV) FvtmLogger.LOGGER.log(str, args);
		}

		@Override
		public void bar(String s){
			if(EnvInfo.DEV) FvtmLogger.LOGGER.log(s);
		}

		@Override
		public void bar(String str, Object... args){
			if(EnvInfo.DEV) FvtmLogger.LOGGER.log(str, args);
		}

		@Override
		public void dismount(){
			//
		}

		@Override
		public String getName(){
			return "DEVLOG";
		}

	};
	public static final MessageSender NONE = new MessageSender(){

		@Override
		public void send(String s){
			//
		}

		@Override
		public void send(String str, Object... args){
			//
		}

		@Override
		public void bar(String s){
			//
		}

		@Override
		public void bar(String str, Object... args){
			//
		}

		@Override
		public void dismount(){
			//
		}

		@Override
		public String getName(){
			return "NONE";
		}

	};
}
