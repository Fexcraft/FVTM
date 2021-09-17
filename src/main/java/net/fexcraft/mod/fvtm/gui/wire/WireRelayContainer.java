package net.fexcraft.mod.fvtm.gui.wire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.WireModel;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
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

public class WireRelayContainer extends GenericContainer {
	
	protected GenericGui<WireRelayContainer> gui;
	protected WireSystem system;
	protected BlockTileEntity tile;
	protected RelayData data;
	protected List<String> conns;
	protected ArrayList<WireRelay> relays = new ArrayList<>();
	protected ItemStack stack;
	protected WireType type;
	//
	protected static String SELRELAY;
	protected RelayHolder holder;
	protected WireRelay relay;
	protected static int WIRE = -1;
	protected Wire wire;
	protected boolean opp;
	protected static String CURRDECO = "relay";
	protected TreeMap<String, ArrayList<WireModel>> models = new TreeMap<>();
	protected ArrayList<String> modelkeys = new ArrayList<>();

	public WireRelayContainer(EntityPlayer player, World world, int x, int y, int z, boolean reset){
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
		if(!reset && SELRELAY != null){
			holder = system.getHolder(tile.getPos());
			relay = relays.get(conns.indexOf(SELRELAY));
			wire = WIRE > -1 && relay.size() > WIRE ? relay.wires.get(WIRE) : null;
			if(wire != null){
				if(wire.isOppositeCopy()){
					wire = system.getWire(wire.getOppositeId());
					opp = true;
				}
				models.clear();
				modelkeys.clear();
				List<WireModel> umodels = WireModel.DECOS.values().stream().filter(model -> {
					return model.accepts(wire.getWireType().wire_type());
				}).collect(Collectors.toList());
				for(WireModel model : umodels){
					if(!models.containsKey(model.decotype())){
						models.put(model.decotype(), new ArrayList<>());
					}
					models.get(model.decotype()).add(model);
				}
				for(String key : models.keySet()){
					if(!modelkeys.contains(key)) modelkeys.add(key);
				}
				if(!modelkeys.contains(CURRDECO)) CURRDECO = "relay";
			}
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
						Wire wire = new Wire(relay0, relay, type, r0, r1);
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
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_RELAY_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "edit_wire":{
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "del_wire":{
					holder = system.getHolder(BlockPos.fromLong(packet.getLong("holder")));
					relay = relays.get(conns.indexOf(packet.getString("relay")));
					relay.remove(packet.getInteger("index"), true);
					return;
				}
				case "reset_deco":{
					wire = system.getWire(new PathKey(packet.getCompoundTag("wire")));
					String deco = packet.getString("type");
					if(deco.equals("relay")){
						if(!packet.getBoolean("opp")){
							wire.deco_start = null;
						}
						else{
							wire.deco_end = null;
						}
					}
					else{
						if(wire.decos != null) wire.decos.remove(deco);
					}
					wire.getRelay().updateClient();
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "select_deco":{
					wire = system.getWire(new PathKey(packet.getCompoundTag("wire")));
					String deco = packet.getString("type");
					String seld = packet.getString("selected");
					if(deco.equals("relay")){
						if(!packet.getBoolean("opp")){
							wire.deco_start = seld;
						}
						else{
							wire.deco_end = seld;
						}
					}
					else{
						if(wire.decos == null) wire.decos = new HashMap<>();
						wire.decos.put(deco, seld);
					}
					wire.getRelay().updateClient();
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "set_slack":{
					Wire wire0 = system.getWire(new PathKey(packet.getCompoundTag("wire")));
					Wire wire1 = system.getWire(wire0.op);
					float value = packet.getFloat("slack");
					if(value > 2) value = 2;
					if(value < 0) value = 0;
					wire0.slack = wire1.slack = value;
					wire0.reslack();
					wire1.reslack();
					wire0.getRelay().updateClient();
					wire1.getRelay().updateClient();
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

	public void nextdeco(){
		int idx = modelkeys.indexOf(CURRDECO);
		if(idx < 0 || idx >= modelkeys.size() - 1) idx = 0;
		else idx++;
		CURRDECO = modelkeys.get(idx);
	}

	public String currdeconame(){
		if(CURRDECO.equals("relay")){
			if(wire.start.equals(relay.getVec316f())){
				return wire.deco_start;
			}
			else{
				return wire.deco_end;
			}
		}
		else return wire.decos == null ? null : wire.decos.get(CURRDECO);
	}

}
