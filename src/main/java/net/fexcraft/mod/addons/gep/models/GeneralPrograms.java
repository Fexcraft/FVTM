package net.fexcraft.mod.addons.gep.models;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.addons.gep.scripts.MultiDoorScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.model.TurboList.Program;

public class GeneralPrograms {
	
	
	// MULTIDOOR ROOT
	
	public static abstract class MultiDoorRoot implements Program {
		
		protected MultiDoorScript script;
		
		public MultiDoorRoot(boolean reg){
			if(reg) TurboList.PROGRAMS.add(this);
		}

		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			this.script = data.getScript(MultiDoorScript.class);
		}
		
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        list.visible = true;
		}
		
	}
	
	public static abstract class CustomMultiDoor extends MultiDoorRoot {
		private int angle, axis; private boolean apply, did;
		public CustomMultiDoor(int rotam, int axis, boolean apply){ super(false); angle = rotam; this.axis = axis; this.apply = apply; }
		@Override public String getId(){ return "gep:multidoor_custom"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part);
			if(did = check(data)) list.rotateAxis(Static.rad1 * angle, axis, apply);
		}
		@Override
		public void postRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
	        if(did) list.rotateAxis(0, axis, apply);
		}
		public abstract boolean check(VehicleData data);
	};
	
	//MULTIDOOR CUSTOM ROOT
	
	public static class CustomMultiDoorHood extends CustomMultiDoor {
		public CustomMultiDoorHood(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.hood; }
	}
	
	public static class CustomMultiDoorTrunk extends CustomMultiDoor {
		public CustomMultiDoorTrunk(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.trunk; }
	}
	
	public static class CustomMultiDoorFrontLeft extends CustomMultiDoor {
		public CustomMultiDoorFrontLeft(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.front_left; }
	}
	
	public static class CustomMultiDoorFrontRight extends CustomMultiDoor {
		public CustomMultiDoorFrontRight(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.front_right; }
	}
	
	public static class CustomMultiDoorBackLeft extends CustomMultiDoor {
		public CustomMultiDoorBackLeft(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.back_left; }
	}
	
	public static class CustomMultiDoorBackRight extends CustomMultiDoor {
		public CustomMultiDoorBackRight(int rotam, int axis, boolean apply){ super(rotam, axis, apply); }
		@Override public boolean check(VehicleData data){ return script == null ? data.doorsOpen() : script.back_right; }
	}
	
	//MULTIDOOR STATIC OPEN/CLOSE
	
	public static final Program MULTIDOOR_HOOD_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_hood_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.hood;
		}
	};
	
	public static final Program MULTIDOOR_HOOD_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_hood_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.hood);
		}
	};
	
	public static final Program MULTIDOOR_TRUNK_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_trunk_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.trunk;
		}
	};
	
	public static final Program MULTIDOOR_TRUNK_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_trunk_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.trunk);
		}
	};
	
	public static final Program MULTIDOOR_FRONT_LEFT_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_front_left_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.front_left;
		}
	};
	
	public static final Program MULTIDOOR_FRONT_LEFT_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_front_left_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.front_left);
		}
	};
	
	public static final Program MULTIDOOR_FRONT_RIGHT_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_front_right_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.front_right;
		}
	};
	
	public static final Program MULTIDOOR_FRONT_RIGHT_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_front_right_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.front_right);
		}
	};
	
	public static final Program MULTIDOOR_BACK_LEFT_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_back_left_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.back_left;
		}
	};
	
	public static final Program MULTIDOOR_BACK_LEFT_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_back_left_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.back_left);
		}
	};
	
	public static final Program MULTIDOOR_BACK_RIGHT_OPEN = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_back_right_open"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = script == null ? data.doorsOpen() : script.back_right;
		}
	};
	
	public static final Program MULTIDOOR_BACK_RIGHT_CLOSE = new MultiDoorRoot(true){
		@Override public String getId(){ return "gep:multidoor_back_right_close"; }
		@Override
		public void preRender(TurboList list, VehicleEntity ent, VehicleData data, Colorable color, String part){
			super.preRender(list, ent, data, color, part); list.visible = !(script == null ? data.doorsOpen() : script.back_right);
		}
	};
	
}