package net.fexcraft.mod.fvtm.impl;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entities.UnboundVehicleEntity;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;

public class EngineLoopSound extends PositionedSound implements ITickableSound {
	
	private VehicleEntity entity;
	private boolean done;

	public EngineLoopSound(SoundEvent soundIn, SoundCategory categoryIn, VehicleEntity entity){
		super(soundIn, categoryIn);
		this.entity = entity;
		this.xPosF = (float)entity.getEntity().getPositionVector().x;
		this.yPosF = (float)entity.getEntity().getPositionVector().y;
		this.zPosF = (float)entity.getEntity().getPositionVector().z;
		this.repeat = true;
		this.volume = entity.getVehicleData().getPart("engine").getPart().getSoundVolume("engine_running");
		this.pitch = entity.getVehicleData().getPart("engine").getPart().getSoundPitch("engine_running");
	}

	@Override
	public void update(){
		done = entity == null || entity.getEntity() == null || entity.getEntity().isDead ? true : !entity.getVehicleData().getPart("engine").getAttributeData(EngineAttribute.EngineAttributeData.class).isOn();
		if(done){
			((UnboundVehicleEntity)entity).engineloop = null;
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