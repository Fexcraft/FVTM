package net.fexcraft.mod.fvtm.data.root;

import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundEvent;

public interface Soundable {
	
	public SoundEvent getSoundEvent(String event);
	
	public float getSoundVolume(String event);
	
	public float getSoundPitch(String event);
	
	public Sound getSound(String event);
	
	public static interface SoundHolder {
		
		public Map<String, Sound> getSounds();
		
	}
	
	/** Plays a sound if the sound file/event is present. */
	public void playSound(Entity at, String event);

}
