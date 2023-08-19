package net.fexcraft.mod.fvtm.util;

import static net.minecraftforge.server.permission.DefaultPermissionLevel.ALL;
import static net.minecraftforge.server.permission.DefaultPermissionLevel.OP;

import net.fexcraft.mod.fvtm.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.server.permission.PermissionAPI;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Perms {
	
	public static final Perm RAIL_PLACER_GUI = new Perm("fvtm.gui.rail_placer");
	public static final Perm ROAD_PLACER_GUI = new Perm("fvtm.gui.road_placer");
	public static final Perm ROAD_PLACER_ITEM = new Perm("fvtm.item.road_placer");
	public static final Perm EDIT_INTERNAL_ATTRIBUTES = new Perm("fvtm.attribute.edit_internal");
	public static final Perm EDIT_NON_EDITABLE_ATTRIBUTES = new Perm("fvtm.attribute.edit_non_editable");
	public static final Perm ATTR_LICENSE_PLATE = new Perm("fvtm.attribute.license_plate");
	//public static final Perm ROAD_PLACER_GUI_NOBLOCK = new Perm("fvtm.gui.road_placer.noblock");
	
	public static void register(){
		PermissionAPI.registerNode(RAIL_PLACER_GUI.id(), ALL, "FVTM GUI for placing rails.");
		PermissionAPI.registerNode(ROAD_PLACER_GUI.id(), OP, "FVTM GUI for placing (block) roads.");
		PermissionAPI.registerNode(ROAD_PLACER_ITEM.id(), Config.ROADTOOL_FOR_ALL ? ALL : OP, "FVTM Item for placing (block) roads.");
		//PermissionAPI.registerNode(ROAD_PLACER_GUI_NOBLOCK.id(), Config.NO_RAIL_BLOCKS ? ALL : OP, "Allows to place road blocks without inventory consumption via the RoadPlacer GUI.");
		PermissionAPI.registerNode(EDIT_INTERNAL_ATTRIBUTES.id(), OP, "Permission to edit internal attributes (which are not marked as external) when being outside a vehicle.");
		PermissionAPI.registerNode(EDIT_NON_EDITABLE_ATTRIBUTES.id(), OP, "Permission to edit non editable attributes.");
		PermissionAPI.registerNode(ATTR_LICENSE_PLATE.id(), OP, "Permission to edit license plate attributes.");
	}
	
	public static class Perm {
		
		private final String node;
		
		private Perm(String node){
			this.node = node;
		}
		
		public String id(){
			return node;
		}

		public boolean has(EntityPlayer player){
			return PermissionAPI.hasPermission(player, node);
		}
		
	}

}
