package net.fexcraft.mod.fvtm.gui.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class WireContainer extends GenericContainer {
	
	protected GenericGui<WireContainer> gui;
	protected WireSystem system;
	protected BlockTileEntity tile;
	protected RelayData data;
	protected List<String> conns;
	protected ArrayList<WireRelay> relays = new ArrayList<>();
	protected WireItem item;
	protected WireType type;

	public WireContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		system = SystemManager.get(Systems.WIRE, world);
		tile = (BlockTileEntity) world.getTileEntity(new BlockPos(x, y, z));
		data = tile.getBlockData().getType().getRelayData();
		conns = data.conns.keySet().stream().collect(Collectors.toList());
		ArrayList<Vec316f> list = data.getVectors(tile);
		for(Vec316f vec : list) relays.add(system.getRelay(vec, false));
		item = (WireItem)player.getHeldItemMainhand().getItem();
		type = item.getType();
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			switch(packet.getString("cargo")){
				//
			}
		}
		else{
			switch(packet.getString("cargo")){
				//
			}
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }

}
