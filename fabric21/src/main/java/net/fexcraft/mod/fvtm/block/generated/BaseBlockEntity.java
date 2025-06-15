package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Resources21;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WorldW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.PROP_ROT16;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BaseBlockEntity extends BlockEntity implements FvtmBlockEntity {

	public BlockData data;

	public BaseBlockEntity(BlockPos pos, BlockState state){
		super(Resources21.BASE_ENTITY, pos, state);
	}

	@Override
	public void saveAdditional(CompoundTag com, HolderLookup.Provider prov){
		super.saveAdditional(com, prov);
		if(data != null) com.put("FvtmData", data.write(TagCW.create()).local());
	}

	@Override
	public void loadAdditional(CompoundTag com, HolderLookup.Provider prov){
		super.loadAdditional(com, prov);
		if(com.contains("FvtmData")){
			data = FvtmResources.getBlockData(com.getCompound("FvtmData"));
		}
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider prov){
		CompoundTag tag = new CompoundTag();
		saveAdditional(tag, prov);
		return tag;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket(){
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public BlockData getBlockData(){
		return data;
	}

	/*@Override
	public void onLoad(){
		super.onLoad();
		regRelay();
	}*///TODO

	protected void regRelay(){
		if(data == null || !data.getType().hasRelay() || !SystemManager.active(SystemManager.Systems.WIRE)) return;
		SystemManager.get(SystemManager.Systems.WIRE, WrapperHolder.getWorld(level), WireSystem.class).register(this);
	}

	@Override
	public V3I getV3I(){
		return new V3I(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());
	}

	@Override
	public int getMeta(){
		return getBlockState().getValue(PROP_ROT16);
	}

	@Override
	public WorldW getWorldW(){
		return WrapperHolder.getWorld(level);
	}

}
