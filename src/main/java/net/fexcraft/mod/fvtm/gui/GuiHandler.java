package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute.FuelTankExtensionAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int ADDON_MANAGER = 55;
	public static final int VEHICLE_INVENTORY = 9910;
	public static final int CONSTRUCTOR = 9000;//92110;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
				return new GenericPlaceholderContainer();
			case 9910:
				return new VehicleInventoryGui.Server(player, world, x, y, z);
		}
		if(ID >= CONSTRUCTOR && ID < VEHICLE_INVENTORY){
			return new GenericPlaceholderContainer();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
		switch(ID){
			case 55:
				Print.debug("CREATING GUI!;");
				return new AddonManagerGui(x, y, z);
			case 9910:
				return new VehicleInventoryGui.Client(player, world, x, y, z);
		}
		if(ID >= CONSTRUCTOR && ID < VEHICLE_INVENTORY){
			Print.debug("CREATING GUI!");
			return new ConstructorMainGUI(ID, player, world, x, y, z);
		}
		return null;
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
				case "open_gui":{
					int gui = packet.nbt.getInteger("gui");
					int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[0];
					EntityPlayer player = (EntityPlayer)objs[0];
					player.openGui(FVTM.getInstance(), gui, player.world, args.length >= 1 ? args[0] : 0, args.length >= 2 ? args[1] : 0, args.length >= 3 ? args[2] : 0);
					break;
				}
				case "constructor_9000_init":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					EntityPlayer player = (EntityPlayer)objs[0];
					ConstructorControllerEntity serv = (ConstructorControllerEntity)player.world.getTileEntity(pos);
					NBTTagCompound com = getPacketCompound("constructor_9000_init");
					com.setBoolean("connected", serv.center != null);
					com.setBoolean("paint", true);//TODO
					PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(com), (EntityPlayerMP)player);
					break;
				}
				case "constructor_9000":{
					if(packet.nbt.hasKey("payload")){
						BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
						EntityPlayer player = (EntityPlayer)objs[0];
						ConstructorControllerEntity serv = (ConstructorControllerEntity)player.world.getTileEntity(pos);
						switch(packet.nbt.getString("payload")){
							case "auto_connect":{
								if(serv.center == null){
									serv.scanAndConnect(player);
									NBTTagCompound com = getPacketCompound("constructor_9000_init");
									com.setBoolean("connected", serv.center != null);
									PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(com), (EntityPlayerMP)player);
								}
								break;
							}
							case "rgb_update":{
								if(serv.vehicledata == null){
									return;
								}
								String group = packet.nbt.getString("group");
								int rgb = packet.nbt.getInteger("rgb");
								if(group.equals("primary")){
									serv.vehicledata.getPrimaryColor().packed = rgb;
								}
								else if(group.equals("secondary")){
									serv.vehicledata.getSecondaryColor().packed = rgb;
								}
								else return;
								serv.sendUpdate("rgb");
								break;
							}
							case "texture_update":{
								if(serv.vehicledata == null){
									return;
								}
								boolean vehicle = packet.nbt.getString("type").equals("vehicle");
								PartData part = vehicle ? null : serv.vehicledata.getPart(packet.nbt.getString("type").split(":")[1]);
								int cat = packet.nbt.getInteger("category");
								String data = packet.nbt.getString("data");
								if(cat == 0){
									if(data.equals("prev")){
										if(vehicle){
											int i = serv.vehicledata.getSelectedTexture() - 1;
											i = i < 0 ? 0 : i;
											serv.vehicledata.setSelectedTexture(i);
										}
										else{
											int i = part.getSelectedTexture() - 1;
											i = i < 0 ? 0 : i;
											part.setSelectedTexture(i);
										}
									}
									else if(data.equals("next")){
										if(vehicle){
											int i = serv.vehicledata.getSelectedTexture() + 1;
											i = i >= serv.vehicledata.getVehicle().getTextures().size() ? serv.vehicledata.getVehicle().getTextures().size() - 1 : i;
											serv.vehicledata.setSelectedTexture(i);
										}
										else{
											int i = part.getSelectedTexture() - 1;
											i = i < 0 ? 0 : i;
											part.setSelectedTexture(i);
										}
									}
									else return;
								}
								else{
									if(vehicle){
										serv.vehicledata.setSelectedTexture(-1);
										serv.vehicledata.setCustomTexture(data, cat == 2);
									}
									else{
										part.setSelectedTexture(-1);
										part.setCustomTexture(data, cat == 2);
									}
								}
								serv.sendUpdate("vehicle");
								break;
							}
							case "part_remove":{
								if(serv.vehicledata == null){
									return;
								}
								PartData data = serv.vehicledata.getParts().remove(packet.nbt.getString("part"));
								if(data == null || !data.getPart().isRemovable()){
									Print.chat(player, data == null ? "Part not found in Server Instance." : "Part is marked as non-remove on Server Instance!");
									return;
								}
								EntityItem item = new EntityItem(serv.getWorld());
								item.setItem(data.getPart().getItemStack(data));
								item.setPosition(serv.getPos().getX() + 0.5, serv.getPos().getY() + 1.5, serv.getPos().getZ() + 0.5);
								serv.getWorld().spawnEntity(item);
								serv.sendUpdate("vehicle");
								break;
							}
							case "part_install":{
								if(serv.partdata == null){
									return;
								}
								if(packet.nbt.getBoolean("drop")){
									ItemStack stack = serv.partdata.getPart().getItemStack(serv.partdata);
									EntityItem entity = new EntityItem(serv.getWorld(), serv.getPos().getX() + 0.5, serv.getPos().getY() + 1.5f, serv.getPos().getZ() + 0.5, stack);
									serv.getWorld().spawnEntity(entity);
									serv.partdata = null;
									serv.sendUpdate(null);
									return;
								}
								else{
									if(packet.nbt.getBoolean("auto")){
										for(String str : serv.partdata.getPart().getCategories()){
											if(serv.vehicledata.getPart(str) == null && serv.partdata.getPart().canInstall(str, serv.getVehicleData(), player)){
												serv.getVehicleData().installPart(str, serv.partdata);
												Print.chat(player, "Part processed. (" + serv.partdata.getPart().getName() + ")");
												serv.partdata = null;
												serv.sendUpdate(null);
											}
											else continue;
										}
									}
									else{
										String cat = packet.nbt.getString("category");
										if(serv.vehicledata.getPart(cat) != null){
											Print.chat(player, "There is already a part installed in that category.");
											return;
										}
										if(serv.partdata.getPart().canInstall(cat, serv.getVehicleData(), player)){
											serv.getVehicleData().installPart(cat, serv.partdata);
											Print.chat(player, "Part processed. (" + serv.partdata.getPart().getName() + ")");
											serv.partdata = null;
											serv.sendUpdate(null);
										}
										else return;
									}
								}
								break;
							}
						}
					}
					break;
				}
				case "constructor_9000_recycle":{
					BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
					EntityPlayer player = (EntityPlayer)objs[0];
					ConstructorControllerEntity serv = (ConstructorControllerEntity)player.world.getTileEntity(pos);
					player.closeScreen();
					serv.recycleVehicle();
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
					VehicleData data = ((SeatEntity)((EntityPlayer)objs[0]).getRidingEntity()).getVehicle().getVehicleData();
					NBTTagList list = (NBTTagList)packet.nbt.getTag("parts");
					list.forEach((nbtbase) -> {
						NBTTagCompound compound = (NBTTagCompound)nbtbase;
						data.getPart(compound.getString("part")).getAttributeData(FuelTankExtensionAttributeData.class).setContent(compound.getDouble("amount"));
					});
					break;
				}
				case "constructor_9000_init":{
					ConstructorMainGUI.processInitResponse(packet.nbt);
					break;
				}
			}
		}
		
	}
	
}