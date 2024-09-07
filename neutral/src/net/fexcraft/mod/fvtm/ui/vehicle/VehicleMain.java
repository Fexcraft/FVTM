package net.fexcraft.mod.fvtm.ui.vehicle;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.ui.ContainerInterface;
import net.fexcraft.mod.uni.ui.UIButton;
import net.fexcraft.mod.uni.ui.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class VehicleMain extends UserInterface {

	public VehicleMain(JsonMap map, ContainerInterface con) throws Exception {
		super(map, con);
	}

	@Override
	public boolean onAction(UIButton button, String id, int x, int y, int mb){
		switch(id){
			case "status":{
				TagCW tag = TagCW.create();
				tag.set("open", "info");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
			case "fuel":{
				TagCW tag = TagCW.create();
				tag.set("open", "fuel");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
			case "attributes":{
				TagCW tag = TagCW.create();
				tag.set("open", "attributes");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
			case "inventories":{
				TagCW tag = TagCW.create();
				tag.set("open", "inventories");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
			case "containers":{
				TagCW tag = TagCW.create();
				tag.set("open", "containers");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
			case "connectors":{
				TagCW tag = TagCW.create();
				tag.set("open", "connectors");
				container.SEND_TO_SERVER.accept(tag);
				break;
			}
		}
		return false;
	}

}
