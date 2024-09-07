package net.fexcraft.mod.fvtm.entity;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WheelEntityF extends WheelEntity implements IEntityAdditionalSpawnData {

	public WheelEntityF(EntityType<WheelEntityF> type, Level level){
		super(type, level);
	}

	public WheelEntityF(RootVehicle veh, String str){
		super(veh, str);
	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer){
		super.writeSpawnData(buffer);
	}

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
		super.readSpawnData(buffer);
	}

	@Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
