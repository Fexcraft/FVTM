package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.minecraft.util.ITickable;

public class MultiblockTickableTE extends MultiblockTileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
	
	public MultiblockTickableTE(BlockBase type){
		super(type);
	}
	
	public MultiblockTickableTE(){}

	@Override
	public void update(){
		if(data == null || data.getMultiBlockData() == null || data.getMultiBlockData().getScript() == null) return;
		data.getMultiBlockData().getScript().onUpdate(this);
	}

}
