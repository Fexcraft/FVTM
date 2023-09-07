package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.data.root.Sound;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.function.EngineFunction;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class LoopSound extends PositionedSound implements ITickableSound {

    private VehicleEntity entity;
    private boolean done;
    private Sound sound_;
	public float patch;

    public LoopSound(SoundEvent soundIn, SoundCategory categoryIn, VehicleEntity entity){
        super(soundIn, categoryIn);
        this.entity = entity;
        this.xPosF = (float)entity.getEntity().getPositionVector().x;
        this.yPosF = (float)entity.getEntity().getPositionVector().y;
        this.zPosF = (float)entity.getEntity().getPositionVector().z;
        this.repeat = true;
        sound_ = entity.getVehicleData().getSound("engine_running");
        this.volume = sound_.volume;
        this.pitch = sound_.pitch;
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
        pitch = sound_.pitch * patch;
    }

    @Override
    public boolean isDonePlaying(){
        return done;
    }

}
