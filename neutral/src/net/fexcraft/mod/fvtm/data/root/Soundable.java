package net.fexcraft.mod.fvtm.data.root;

import java.util.Map;

import net.fexcraft.mod.uni.world.EntityW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface Soundable {
	
	public Object getSoundEvent(String event);
	
	public float getSoundVolume(String event);
	
	public float getSoundPitch(String event);
	
	public Sound getSound(String event);
	
	public static interface SoundHolder {
		
		public Map<String, Sound> getSounds();
		
	}
	
	/** Plays a sound if the sound file/event is present. */
	public void playSound(EntityW at, String event);

}
