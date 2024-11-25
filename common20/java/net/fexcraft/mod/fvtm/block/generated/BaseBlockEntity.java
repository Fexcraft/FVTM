package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.impl.WorldWIE;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockEntity extends BlockEntity {

	public BlockData data;

	public BaseBlockEntity(BlockPos pos, BlockState state){
		super(FvtmGetters.BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public void saveAdditional(CompoundTag com){
		super.saveAdditional(com);
		if(data != null) com.put("FvtmData", data.write(TagCW.create()).local());
	}

	@Override
	public void load(CompoundTag com){
		super.load(com);
		if(com.contains("FvtmData")){
			data = FvtmResources.getBlockData(com.getCompound("FvtmData"));
		}
	}

	@Override
	public CompoundTag getUpdateTag(){
		CompoundTag tag = new CompoundTag();
		saveAdditional(tag);
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag tag){
		load(tag);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket(){
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public BlockData getBlockData(){
		return data;
	}

	@Override
	public AABB getRenderBoundingBox(){
		return WorldWIE.aabb2.move(getBlockPos());
	}

}
