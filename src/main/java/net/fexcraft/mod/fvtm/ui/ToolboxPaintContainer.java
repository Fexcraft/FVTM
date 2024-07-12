package net.fexcraft.mod.fvtm.ui;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATIONS;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ToolboxPaintContainer extends ContainerInterface {

	protected Colorable colorable;
	protected RootVehicle vehicle;

	public ToolboxPaintContainer(JsonMap map, UniEntity player, V3I pos){
		super(map, player, pos);
		vehicle = ((FvtmWorld)player.entity.getWorld()).getVehicle(pos.x).entity.local();
		colorable = vehicle.vehicle.data;
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
					net.minecraft.client.Minecraft.getMinecraft().displayGuiScreen(
						new GuiConfirmOpenLink((GuiContainer)ui.root, "https://fexcraft.net/wiki/mod/fvtm/toolbox#painter", 31102009, true));
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
				vehicle.sendColorChannelUpdate(com.getString("channel"));
				break;
			}
		}
	}

	@Override
	public void onClosed(){
		//
	}

}
