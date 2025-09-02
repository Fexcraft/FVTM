package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fcl.UniFCL;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;

import static net.fexcraft.mod.fvtm.sys.uni.VehicleInstance.PKT_UPD_VEHICLEDATA;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxTextureContainer extends ContainerInterface {

	protected Textureable textureable;
	protected Textureable.TextureHolder texroot;
	protected VehicleInstance vehicle;

	public ToolboxTextureContainer(JsonMap map, UniEntity player, V3I vec){
		super(map, player, vec);
		vehicle = ((FvtmWorld)player.entity.getWorld()).getVehicle(vec.x);
		if(vec.z > 0){
			PartData data = vehicle.data.getIndexPart(vec.y);
			if(data != null){
				textureable = data.getTexture();
				texroot = data.getTexHolder();
				return;
			}
		}
		textureable = vehicle.data.getTexture();
		texroot = vehicle.data.getTexHolder();
	}

	@Override
	public Object get(String key, Object... objs){
		switch(key){
			case "open_wiki":{
				if(player.entity.getWorld().isClient()){
					player.entity.sendLink("https://fexcraft.net/wiki/mod/fvtm/toolbox#texture");
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
			case "select":{
				String tex = com.getString("tex");
				boolean ext = com.getBoolean("ext");
				if(ext && !UniFCL.URL_TEXTURES && !tex.startsWith("server:")){
					player.entity.send("ui.fvtm.toolbox.texture.no_url");
					player.entity.send("ui.fvtm.toolbox.texture.server");
					break;
				}
				textureable.setSelectedTexture(com.getInteger("sel"), tex, ext);
				if(client){
					((ToolboxTexture)ui).updateStatus();
					break;
				}
				vehicle.sendUpdate(PKT_UPD_VEHICLEDATA);
				SEND_TO_CLIENT.accept(com, player);
				break;
			}
		}

	}

}
