package net.fexcraft.mod.fvtm.block;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.LiftingPoint;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRef;
import net.fexcraft.mod.fvtm.handler.InteractionHandler.InteractRefHolder;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.packet.PacketListener;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConstructorEntity extends BlockEntity {

	public ConstructorEntity(BlockPos pPos, BlockState pBlockState){
		super(FvtmGetters.CONST_ENTITY.get(), pPos, pBlockState);
	}

}
