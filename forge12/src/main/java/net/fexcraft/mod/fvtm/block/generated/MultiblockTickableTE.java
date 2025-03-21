package net.fexcraft.mod.fvtm.block.generated;

import java.util.Map;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.minecraft.util.ITickable;

public class MultiblockTickableTE extends MultiblockTileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {

	public MultiblockTickableTE(BlockBase type){
		super(type);
	}
	
	public MultiblockTickableTE(){}

	private int pass = 20;

	@Override
	public void update(){
		if(data == null || mdata == null) return;// || mdata.getScript() == null) return;
		//mdata.getScript().onUpdate(this);
		if(pass > 0){
			pass--;
			return;
		}
		pass = 20;
		for(Map.Entry<String, InvHandler> entry : mdata.getInventories().entrySet()){
			entry.getValue().update(this, entry.getKey(), world.isRemote);
		}
	}

}
