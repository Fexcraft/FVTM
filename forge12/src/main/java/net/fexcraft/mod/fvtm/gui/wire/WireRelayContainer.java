package net.fexcraft.mod.fvtm.gui.wire;

import static net.fexcraft.mod.fvtm.Config.MAX_WIRE_LENGTH;
import static net.fexcraft.mod.uni.world.WrapperHolder.getPos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.WireDeco;
import net.fexcraft.mod.fvtm.data.WireType;
import net.fexcraft.mod.fvtm.data.block.RelayData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.WireItem;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.RelayHolder;
import net.fexcraft.mod.fvtm.sys.wire.Wire;
import net.fexcraft.mod.fvtm.sys.wire.WireKey;
import net.fexcraft.mod.fvtm.sys.wire.WireRelay;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
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
	protected TreeMap<String, ArrayList<WireDeco>> models = new TreeMap<>();
	protected ArrayList<String> modelkeys = new ArrayList<>();

	public WireRelayContainer(EntityPlayer player, World world, int x, int y, int z, boolean reset){
		super(player);
		system = SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world));
		tile = (BlockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
		data = tile.getBlockData().getType().getRelayData();
		holder = system.getHolder(getPos(tile.getPos()));
		conns = new ArrayList<>(holder.relays.keySet());
		stack = player.getHeldItemMainhand();
		type = ((WireItem)stack.getItem()).getContent();
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
		}
		if(!reset && SELRELAY != null){
			relay = holder.get(SELRELAY);
			wire = WIRE > -1 && relay.size() > WIRE ? relay.wires.get(WIRE) : null;
			if(wire != null){
				if(wire.copy){
					wire = system.getWire(wire.okey);
					opp = true;
				}
				models.clear();
				modelkeys.clear();
				List<WireDeco> decos = FvtmRegistry.WIREDECOS.stream().filter(deco -> deco.accepts(wire.getWireType().getType())).collect(Collectors.toList());
				for(WireDeco deco : decos){
					if(!models.containsKey(deco.getType())){
						models.put(deco.getType(), new ArrayList<>());
					}
					models.get(deco.getType()).add(deco);
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
				case "connect": return;
				case "open_editor":{
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_RELAY_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "edit_wire":{
					player.openGui(FVTM.getInstance(), GuiHandler.WIRE_EDIT, player.world, tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ());
					return;
				}
				case "del_wire":{
					holder = system.getHolder(getPos(packet.getLong("holder")));
					relay = holder.get(conns.indexOf(packet.getString("relay")));
					relay.remove(packet.getInteger("index"), true);
					return;
				}
				case "reset_deco":{
					wire = system.getWire(new WireKey(TagCW.wrap(packet.getCompoundTag("wire"))));
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
					wire = system.getWire(new WireKey(TagCW.wrap(packet.getCompoundTag("wire"))));
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
					Wire wire0 = system.getWire(new WireKey(TagCW.wrap(packet.getCompoundTag("wire"))));
					Wire wire1 = system.getWire(wire0.okey);
					float value = packet.getFloat("slack");
					if(value > 8) value = 8;
					if(value < -8) value = -8;
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
		CURRDECO = modelkeys.size() == 0 ? "relay" : modelkeys.get(idx);
	}

	public String currdeconame(){
		if(CURRDECO.equals("relay")){
			if(wire.key.start_relay.equals(relay.getKey())){
				return wire.deco_start;
			}
			else{
				return wire.deco_end;
			}
		}
		else return wire.decos == null ? null : wire.decos.get(CURRDECO);
	}

}
