package net.fexcraft.mod.uni.world;

import com.mojang.authlib.GameProfile;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WrapperHolderImpl extends WrapperHolder {

	private static WorldW client;

	@Override
	public EntityW getEntity0(Object o){
		return ((Entity)o).getCapability(Capabilities.PASSENGER, null).asWrapper();
	}

	@Override
	public WorldW getWorld0(Object o){
		if(o == null) return null;
		if(!WORLDS.containsKey(o)){
			WORLDS.put(o, new WorldWI((World)o));
		}
		return WORLDS.get(o);
	}

	@Override
	public <W extends WorldW> W getClientWorld0(){
		if(client == null){
			client = getWorld0(net.minecraft.client.Minecraft.getMinecraft().world);
		}
		return (W)client;
	}

	@Override
	public V3I getPos0(Object o){
		BlockPos pos = (BlockPos)o;
		return new V3I(pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public CubeSide getSide0(Object o){
		EnumFacing facing = (EnumFacing)o;
		switch(facing){
			case UP: return CubeSide.UP;
			case DOWN: return CubeSide.DOWN;
			case NORTH: return CubeSide.NORTH;
			case WEST: return CubeSide.WEST;
			case EAST: return CubeSide.EAST;
			case SOUTH: return CubeSide.SOUTH;
		}
		return CubeSide.NORTH;
	}

	@Override
	public <S> S getLocalSide0(CubeSide side){
		switch(side){
			case UP: return (S)EnumFacing.UP;
			case DOWN: return (S)EnumFacing.DOWN;
			case NORTH: return (S)EnumFacing.NORTH;
			case SOUTH: return (S)EnumFacing.SOUTH;
			case EAST: return (S)EnumFacing.EAST;
			case WEST: return (S)EnumFacing.WEST;
		}
		return (S)EnumFacing.NORTH;
	}

	@Override
	public List<UUID> getOnlinePlayerIDs0(){
		List<UUID> list = new ArrayList<>();
		for(GameProfile prof : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getOnlinePlayerProfiles()){
			list.add(prof.getId());
		}
		return list;
	}

	@Override
	public void reset(){
		client = null;
	}

}
