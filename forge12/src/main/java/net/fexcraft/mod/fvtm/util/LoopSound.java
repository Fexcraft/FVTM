package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.root.LoopedSound;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class LoopSound extends PositionedSound implements ITickableSound {

    private RootVehicle entity;
    private LoopedSound loop_sound;
	public float patch;

    public LoopSound(SoundCategory cat, LoopedSound sound){
        super((SoundEvent)sound.sound.event, cat);
        loop_sound = sound;
        entity = loop_sound.vehicle.entity.local();
        this.xPosF = (float)entity.getPositionVector().x;
        this.yPosF = (float)entity.getPositionVector().y;
        this.zPosF = (float)entity.getPositionVector().z;
        this.repeat = true;
        this.volume = loop_sound.sound.volume;
        this.pitch = loop_sound.sound.pitch;
    }

    @Override
    public void update(){
        this.xPosF = (float)entity.getPositionVector().x;
        this.yPosF = (float)entity.getPositionVector().y;
        this.zPosF = (float)entity.getPositionVector().z;
        pitch = loop_sound.sound.pitch * patch;
    }

    @Override
    public boolean isDonePlaying(){
        return !loop_sound.active;
    }

}
