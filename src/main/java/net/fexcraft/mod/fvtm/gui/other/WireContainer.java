package net.fexcraft.mod.fvtm.gui.other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
	protected ItemStack stack;
	protected WireType type;

	public WireContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		system = SystemManager.get(Systems.WIRE, world);
		tile = (BlockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
		data = tile.getBlockData().getType().getRelayData();
		conns = data.conns.keySet().stream().collect(Collectors.toList());
		ArrayList<Vec316f> list = data.getVectors(tile);
		for(Vec316f vec : list) relays.add(system.getRelay(vec, false));
		stack = player.getHeldItemMainhand();
		type = ((WireItem)stack.getItem()).getType();
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			switch(packet.getString("cargo")){
				case "connect":{
					int index = packet.getInteger("index");
					WireRelay relay = relays.get(index);
					String relid = conns.get(index);
					ArrayList<String> list = data.types.get(relid);
					if(!list.isEmpty() && !list.contains(type.wire_type())){
						Print.chat(player, "&bWire not compatible with relay.");
						return;
					}
					int l = data.limits.get(relid);
					if(l > 0 && relay.size() > l){
						Print.chat(player, "&bRelay reached wire limit.");
						return;
					}
					if(stack.getTagCompound().hasKey("fvtm:wirepoint")){
						WireRelay relay0 = system.getRelay(new Vec316f(stack.getTagCompound().getCompoundTag("fvtm:wirepoint_vec")));
						if(relay0.getVec3f().dis(relay.getVec3f()) > Config.MAX_WIRE_LENGTH){
							Print.chat(player, "&cWire length exceeds the configured max length.");
							player.closeScreen();
							return;
						}
						BlockTileEntity tile0 = (BlockTileEntity)system.getWorld().getTileEntity(BlockPos.fromLong(stack.getTagCompound().getLong("fvtm:wirepoint")));
						RelayData data0 = tile0.getBlockData().getType().getRelayData();
						Vec3f r0 = data0.getVec3f(stack.getTagCompound().getString("fvtm:wirepoint_slot"), tile0.getPos(), tile0.meta, tile0.data.getType().getBlockType());
						Vec3f r1 = data.getVec3f(relid, tile.getPos(), tile.meta, tile.data.getType().getBlockType());
						Wire wire = new Wire(relay, relay0, type, r0, r0.middle(r1).add(0, -1, 0), r1);
						if(relay0.isDuplicate(wire) || relay.isDuplicate(wire)){
							Print.chat(player, "&cWire has same start/end as another wire.");
							player.closeScreen();
							return;
						}
						relay0.addnew(wire);
						relay.addnew(wire.createOppositeCopy());
						relay0.checkWireSectionConsistency();
		    			stack.getTagCompound().removeTag("fvtm:wirepoint");
		    			stack.getTagCompound().removeTag("fvtm:wirepoint_slot");
		    			stack.getTagCompound().removeTag("fvtm:wirepoint_vec");
						Print.chatbar(player, "&aWire created.");
						player.closeScreen();
					}
					else{
						stack.getTagCompound().setLong("fvtm:wirepoint", tile.getPos().toLong());
						stack.getTagCompound().setString("fvtm:wirepoint_slot", relid);
						stack.getTagCompound().setTag("fvtm:wirepoint_vec", relay.getVec316f().write());
						Print.chatbar(player, "&aRelay position cached.");
						player.closeScreen();
					}
					return;
				}
				case "open_editor":{
					Print.chatbar(player, "&bwork in progress");
					return;
				}
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
