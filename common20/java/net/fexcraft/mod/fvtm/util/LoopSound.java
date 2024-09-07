package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.TickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class LoopSound extends AbstractSoundInstance implements TickableSoundInstance {

	private RootVehicle entity;
	private LoopedSound loop_sound;
	public float patch;

	public LoopSound(LoopedSound sound){
		super((SoundEvent)sound.sound.event, SoundSource.NEUTRAL, SoundInstance.createUnseededRandom());
		loop_sound = sound;
		entity = loop_sound.vehicle.entity.local();
		this.x = (float)entity.position().x;
		this.y = (float)entity.position().y;
		this.z = (float)entity.position().z;
		this.looping = true;
		this.delay = 0;
		this.volume = loop_sound.sound.volume;
		this.pitch = loop_sound.sound.pitch;
	}

	@Override
	public void tick(){
		this.x = (float)entity.position().x;
		this.y = (float)entity.position().y;
		this.z = (float)entity.position().z;
		pitch = loop_sound.sound.pitch * patch;
	}

	@Override
	public boolean canPlaySound(){
		return true;
	}

	@Override
	public boolean canStartSilent(){
		return true;
	}

	@Override
	public boolean isStopped(){
		return !loop_sound.active;
	}

}
