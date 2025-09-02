package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxPaintContainer extends ContainerInterface {

	protected Colorable colorable;
	protected VehicleInstance vehicle;

	public ToolboxPaintContainer(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		vehicle = ((FvtmWorld)player.entity.getWorld()).getVehicle(vec.x);
		colorable = vehicle.data;
	}

	@Override
	public Object get(String key, Object... objs){
		switch(key){
			case "channel_keys":{
				return colorable.getColorChannels().keySet();
			}
			case "color":{
				return colorable.getColorChannel(objs[0].toString());
			}
			case "open_wiki":{
				if(player.entity.getWorld().isClient()){
					player.entity.sendLink("https://fexcraft.net/wiki/mod/fvtm/toolbox#painter");
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public void packet(TagCW com, boolean client){
		String task = com.getString("task");
		switch(task){
			case "apply":{
				colorable.getColorChannel(com.getString("channel")).packed = com.getInteger("color");
				TagCW tag = TagCW.create();
				tag.set("vehicle", vehicle.entity.getId());
				tag.set("channel", com.getString("channel"));
				tag.set("color", com.getInteger("color"));
				Packets.sendToAll(Packet_TagListener.class, "vehicle_color", tag);
				break;
			}
		}
	}

}
