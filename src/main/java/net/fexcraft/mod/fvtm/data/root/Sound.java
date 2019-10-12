package net.fexcraft.mod.fvtm.data.root;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class Sound {
	
	public SoundEvent event;
	public float pitch, volume;
	public boolean override;
	public ResourceLocation soundid;
	
	public Sound(ResourceLocation resloc, float vol, float pitch){
		this(resloc, vol, pitch, true); 
	}
	public Sound(ResourceLocation resloc, float vol, float pitch, boolean override){
		this.soundid = resloc; volume = vol; this.pitch = pitch; this.override = override;
	}

}
