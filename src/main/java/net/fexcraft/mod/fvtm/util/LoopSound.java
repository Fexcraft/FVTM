package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class LoopSound extends PositionedSound implements ITickableSound {

    private VehicleEntity entity;
    private boolean done;

    public LoopSound(SoundEvent soundIn, SoundCategory categoryIn, VehicleEntity entity){
        super(soundIn, categoryIn);
        this.entity = entity;
        this.xPosF = (float)entity.getEntity().getPositionVector().x;
        this.yPosF = (float)entity.getEntity().getPositionVector().y;
        this.zPosF = (float)entity.getEntity().getPositionVector().z;
        this.repeat = true;
        Sound sound = entity.getVehicleData().getSound("engine_running");
        this.volume = sound.volume; this.pitch = sound.pitch;
    }

    @Override
    public void update(){
        done = entity == null || entity.getEntity() == null || entity.getEntity().isDead ? true : !entity.getVehicleData().getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").isOn();
        if(done){
        	((GenericVehicle)entity).engineloop = null;
        }
        this.xPosF = (float)entity.getEntity().getPositionVector().x;
        this.yPosF = (float)entity.getEntity().getPositionVector().y;
        this.zPosF = (float)entity.getEntity().getPositionVector().z;
    }

    @Override
    public boolean isDonePlaying(){
        return done;
    }

}
