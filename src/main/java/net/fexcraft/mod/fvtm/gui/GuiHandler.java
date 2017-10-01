package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute.FuelTankExtensionAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorController;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int ADDON_MANAGER = 55;
	public static final int CONSTRUCTOR_INPUT = 88;
	public static final int VEHICLE_INVENTORY = 9910;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
			case 88:
				return new GenericPlaceholderContainer();
			case 9910:
				return new VehicleInventoryGui.Server(player, world, x, y, z);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
				Print.debug("CREATING GUI!;");
				return new AddonManagerGui(x, y, z);
			case 88:
				Print.debug("CREATING GUI!");
				return new ConstructorInputGui(player, new BlockPos(x, y, z));
			case 9910:
				return new VehicleInventoryGui.Client(player, world, x, y, z);
			default:
				return null;
		}
	}
	
	public static class SReceiver implements IPacketListener<PacketNBTTagCompound> {

		@Override
		public String getId(){
			return "fvtm";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("task")){
				return;
			}
			switch(packet.nbt.getString("task")){
				case "open_addon_manager":
					int[] arr = packet.nbt.getIntArray("args");
					((EntityPlayer)objs[0]).openGui(FVTM.MODID, ADDON_MANAGER, ((EntityPlayer)objs[0]).world, arr[0], arr[1], arr[2]);
					break;
				case "toggle_debug":
					if(Static.side().isServer()){
						Static.toggleDebug();
						Print.chat((EntityPlayer)objs[0], "Server Side (FCL) Debug Toggled.");
					}
					break;
				case "toggle_addon_state":
					try{
						Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
						if(addon != null && !addon.hasMissingDependencies()){
							addon.setEnabled(!addon.isEnabled());
						}
						FVTM.getResources().updateAddonConfig();
					}
					catch(Exception e){
						break;
					}
					//break;
				case "get_addon_list":
					NBTTagCompound nbt = new NBTTagCompound();
					nbt.setString("target_listener", "fvtm");
					nbt.setString("cargo", "addon_list");
					nbt.setInteger("Size", Resources.ADDONS.getValues().size());
					int entryid = 0;
					for(Addon addon : Resources.ADDONS.getValues()){
						nbt.setTag("entry_" + entryid++, addon.toNBT());
					}
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (net.minecraft.entity.player.EntityPlayerMP)objs[0]);
					break;
				case "set_addon_state":
					boolean success;
					try{
						Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
						if(addon != null && !addon.hasMissingDependencies()){
							addon.setEnabled(packet.nbt.getBoolean("state"));
						}
						FVTM.getResources().updateAddonConfig();
						success = true;
					}
					catch(Exception e){
						e.printStackTrace();
						Print.log("Failed to update Addon State;");
						success = false;
					}

					NBTTagCompound tagc = new NBTTagCompound();
					tagc.setString("target_listener", "fvtm");
					tagc.setString("cargo", "addon_state_change_confirmation");
					tagc.setBoolean("success", success);
					tagc.setBoolean("enabled", packet.nbt.getBoolean("state"));
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(tagc), (net.minecraft.entity.player.EntityPlayerMP)objs[0]);
					Print.debug("S: " + tagc);
					break;
				case "constructor_input":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					String input = packet.nbt.getString("input");
					EntityPlayer player = (EntityPlayer)objs[0];
					((ConstructorControllerEntity.Server)player.world.getTileEntity(pos)).onButtonPress(ConstructorController.Button.INPUT, player, new String[]{input});
					break;
				}
				case "open_gui":{
					int gui = packet.nbt.getInteger("gui");
					int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[0];
					EntityPlayer player = (EntityPlayer)objs[0];
					player.openGui(FVTM.getInstance(), gui, player.world, args.length >= 1 ? args[0] : 0, args.length >= 2 ? args[1] : 0, args.length >= 3 ? args[2] : 0);
					break;
				}
			}
		}
		
		public NBTTagCompound getPacketCompound(String task){
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("target_listener", "fvtm");
			nbt.setString("cargo", task);
			return nbt;
		}
		
	}
	
	public static class CReceiver implements IPacketListener<PacketNBTTagCompound> {

		@Override
		public String getId(){
			return "fvtm";
		}

		@Override
		public void process(PacketNBTTagCompound packet, Object[] objs){
			if(!packet.nbt.hasKey("cargo")){
				return;
			}
			switch(packet.nbt.getString("cargo")){
				case "addon_list":{
					AddonManagerGui.addons.clear();
					int size = packet.nbt.getInteger("Size");
					for(int i = 0; i < size; i++){
						NBTTagCompound nbt = packet.nbt.getCompoundTag("entry_" + i);
						GenericAddon addon = new GenericAddon();
						AddonManagerGui.addons.add(addon.fromNBT(nbt));
					}
					break;
				}
				case "addon_state_change_confirmation":{
					if(packet.nbt.hasKey("success") && packet.nbt.getBoolean("success")){
						AddonManagerGui.addon.setEnabled(packet.nbt.getBoolean("enabled"));
					}
					Print.debug("C: " + packet.nbt);
					break;
				}
				case "update_fuel_tanks":{
					Print.debug(packet.nbt.toString());
					VehicleData data = ((com.flansmod.fvtm.EntitySeat)((EntityPlayer)objs[0]).getRidingEntity()).vehicle.data;
					NBTTagList list = (NBTTagList)packet.nbt.getTag("parts");
					list.forEach((nbtbase) -> {
						NBTTagCompound compound = (NBTTagCompound)nbtbase;
						data.getPart(compound.getString("part")).getAttributeData(FuelTankExtensionAttributeData.class).setContent(compound.getDouble("amount"));
					});
					break;
				}
			}
		}
		
	}
	
}