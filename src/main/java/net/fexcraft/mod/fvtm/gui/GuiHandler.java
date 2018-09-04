package net.fexcraft.mod.fvtm.gui;

import java.util.HashMap;
import java.util.UUID;

import net.fexcraft.mod.addons.gep.attributes.FuelTankExtensionAttribute.FuelTankExtensionAttributeData;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute.InventoryAttributeData;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Block.BlockScript;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.root.SettingHolder.ScriptSetting;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.blocks.PipeTileEntity;
import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.gui.re.CCGMain;
import net.fexcraft.mod.fvtm.gui.re.CCGStatus;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.util.AddonList;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketListener;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;

public class GuiHandler implements IGuiHandler {

    public static final int ADDON_MANAGER = 55;
    public static final int GENERIC_INVENTORY = 200;
    public static final int VEHICLE_INVENTORY = 9910;
    //public static final int CONSTRUCTOR = 9000;//92110;
    //public static final int CONTAINER_INVENTORY = 9210;
    public static final int CONTAINER_FLUID_INVENTORY = 9211;
    public static final int BLOCK_INVENTORY = 9310;
    public static final int BLOCK_FLUID_INVENTORY = 9311;
    public static final int BLOCK_SCRIPTSGUI = 9312;
    public static final int BLOCK_CRAFTERSCRIPT = 9313;
	public static final int VEHICLE_SCRIPTSGUI = 9214;
	//
	public static final int CCG_Main = 9000;
	public static final int CCG_Status = 9001;
	public static EnumFacing lastside = EnumFacing.UP;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
        switch(ID){
            case 55:
                return new GenericGuiContainer.DefImpl();
            case 200:
            	return new GenericAdjustableInventory.Container(world, player, x, y, z);
            case 9910:
                return new VehicleInventoryGui.Server(player, world, x, y, z);
            case 9210:
                return new ContainerInventoryGui.Server(player, world, x, y, z);
            case 9211:
                return new ContainerFluidGui.Server(player, world, x, y, z);
            case 9212:
                return new PipeGui.Server(player, world, x, y, z);
            case 9213:
                return new AdjSignGui.Server(player, world, x, y, z);
            case 9214:
            	return new GenericGuiContainer.DefImpl();
            case 9310:
            	return new UniversalBlockInventoryGui.Server(player, world, x, y, z);
            case 9311:
            	return new UniversalBlockFluidGui.Server(player, world, x, y, z);
            case 9312:
            	return new GenericGuiContainer.DefImpl();
            case 9313:
            	return new GenericGuiContainer.DefImpl();
            case 9000:
            	return new CCGMain.Container();
            case 9001:
            	return new CCGStatus.Container(world, x, y, z);
            default:
            	return new GenericGuiContainer.DefImpl();
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        Print.debug("REQUEST " + ID + " | " + x + ", " + y + ", " + z + ";");
        switch(ID){
            case 55:
                return new AddonManagerGui(x, y, z);
            case 200:
            	return new GenericAdjustableInventory.Gui(world, player, x, y, z);
            case 9910:
                return new VehicleInventoryGui.Client(player, world, x, y, z);
            case 9210:
                return new ContainerInventoryGui.Client(player, world, x, y, z);
            case 9211:
                return new ContainerFluidGui.Client(player, world, x, y, z);
            case 9212:
                return new PipeGui.Client(player, world, x, y, z);
            case 9213:
                return new AdjSignGui.Client(player, world, x, y, z);
            case 9214:
            	return new VehicleScriptGui(player, world, x, y, z);
            case 9310:
            	return new UniversalBlockInventoryGui.Client(player, world, x, y, z);
            case 9311:
            	return new UniversalBlockFluidGui.Client(player, world, x, y, z);
            case 9312:
            	return new UniversalBlockScriptGui(player, world, x, y, z);
            case 9313:
            	return new CrafterBlockScriptGui(player, world, x, y, z);
            //
            case 9000:
            	return new CCGMain(player, world, x, y, z);
            case 9001:
            	return new CCGStatus(player, world, x, y, z);
            default: return null;
        }
    }

    public static class SReceiver implements IPacketListener<PacketNBTTagCompound> {

        @Override
        public String getId(){
            return "fvtm";
        }

        @SuppressWarnings({ "deprecation", "unchecked" })
        @Override
        public void process(PacketNBTTagCompound packet, Object[] objs){
            if(!packet.nbt.hasKey("task")){
                return;
            }
            switch(packet.nbt.getString("task")){
                case "open_addon_manager":
                    int[] arr = packet.nbt.getIntArray("args");
                    ((EntityPlayer) objs[0]).openGui(FVTM.MODID, ADDON_MANAGER, ((EntityPlayer) objs[0]).world, arr[0], arr[1], arr[2]);
                    break;
                case "toggle_debug":
                    if(Static.side().isServer()){
                        Static.toggleDebug();
                        Print.chat((EntityPlayer) objs[0], "Server Side (FCL) Debug Toggled.");
                    }
                    break;
                case "toggle_addon_state":
                    try{
                        Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
                        if(addon != null && addon.getMissingDependencies().isEmpty()){
                            addon.setEnabled(!addon.isEnabled());
                        }
                        AddonList.updateAddon(addon);
                        AddonList.save();
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
                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(nbt), (net.minecraft.entity.player.EntityPlayerMP) objs[0]);
                    break;
                case "set_addon_state":
                    boolean success;
                    try{
                        Addon addon = Resources.ADDONS.getValue(new ResourceLocation(packet.nbt.getString("id")));
                        if(addon != null && addon.getMissingDependencies().isEmpty()){
                            addon.setEnabled(packet.nbt.getBoolean("state"));
                        }
                        AddonList.updateAddon(addon);
                        AddonList.save();
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
                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(tagc), (net.minecraft.entity.player.EntityPlayerMP) objs[0]);
                    Print.debug("S: " + tagc);
                    break;
                case "open_gui": {
                    int gui = packet.nbt.getInteger("gui");
                    int[] args = packet.nbt.hasKey("args") ? packet.nbt.getIntArray("args") : new int[0];
                    EntityPlayer player = (EntityPlayer) objs[0];
                    player.openGui(FVTM.getInstance(), gui, player.world, args.length >= 1 ? args[0] : 0, args.length >= 2 ? args[1] : 0, args.length >= 3 ? args[2] : 0);
                    break;
                }
                case "constructor_9000_init": {
                    BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
                    EntityPlayer player = (EntityPlayer) objs[0];
                    ConstructorControllerEntity serv = (ConstructorControllerEntity) player.world.getTileEntity(pos);
                    NBTTagCompound com = getPacketCompound("constructor_9000_init");
                    com.setBoolean("connected", serv.center != null);
                    com.setBoolean("paint", true);//TODO
                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(com), (EntityPlayerMP) player);
                    break;
                }
                case "constructor_9000": {
                    if(packet.nbt.hasKey("payload")){
                        BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
                        EntityPlayer player = (EntityPlayer) objs[0];
                        ConstructorControllerEntity serv = (ConstructorControllerEntity) player.world.getTileEntity(pos);
                        switch(packet.nbt.getString("payload")){
                            case "auto_connect": {
                                if(serv.center == null){
                                    serv.scanAndConnect(player);
                                    NBTTagCompound com = getPacketCompound("constructor_9000_init");
                                    com.setBoolean("connected", serv.center != null);
                                    PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(com), (EntityPlayerMP) player);
                                }
                                break;
                            }
                            case "rgb_update": {
                                if(serv.getColorable() == null){
                                    return;
                                }
                                String group = packet.nbt.getString("group");
                                int rgb = packet.nbt.getInteger("rgb");
                                if(group.equals("primary")){
                                    serv.getColorable().getPrimaryColor().packed = rgb;
                                }
                                else if(group.equals("secondary")){
                                    serv.getColorable().getSecondaryColor().packed = rgb;
                                }
                                else{
                                    return;
                                }
                                serv.sendUpdate("rgb");
                                break;
                            }
                            case "texture_update": {
                                if(serv.getTextureable() == null){
                                    return;
                                }
                                Textureable textureable = packet.nbt.getString("type").equals("vehicle") ? serv.getTextureable() : serv.getVehicleData() == null ? null : serv.getVehicleData().getPart(packet.nbt.getString("type").split(":")[1]);
                                if(textureable == null){
                                    return;
                                }
                                int cat = packet.nbt.getInteger("category");
                                String data = packet.nbt.getString("data");
                                if(cat == 0){
                                    if(data.equals("prev")){
                                        int i = textureable.getSelectedTexture() - 1;
                                        i = i < 0 ? 0 : i;
                                        textureable.setSelectedTexture(i);
                                    }
                                    else if(data.equals("next")){
                                        int i = textureable.getSelectedTexture() + 1;
                                        i = i >= textureable.getTextureHolder().getTextures().size() ? textureable.getTextureHolder().getTextures().size() - 1 : i;
                                        textureable.setSelectedTexture(i);
                                    }
                                    else{
                                        return;
                                    }
                                }
                                else{
                                    textureable.setSelectedTexture(-1);
                                    textureable.setCustomTexture(data, cat == 2);
                                }
                                serv.sendUpdate(serv.getVehicleData() == null ? "container" : "vehicle");
                                break;
                            }
                            case "part_remove": {
                                if(serv.getVehicleData() == null){
                                    return;
                                }
                                PartData data = serv.getVehicleData().getParts().remove(packet.nbt.getString("part"));
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
                            case "part_install": {
                                if(serv.getPartData() == null){
                                    return;
                                }
                                if(packet.nbt.getBoolean("drop")){
                                    serv.setPartData(null, true);
                                    serv.sendUpdate(null);
                                    return;
                                }
                                else{
                                    if(packet.nbt.getBoolean("auto")){
                                        for(String str : serv.getPartData().getPart().getCategories()){
                                            if(serv.getVehicleData().getPart(str) == null && serv.getPartData().getPart().installable(str, serv.getVehicleData(), player)){
                                                serv.getVehicleData().installPart(str, serv.getPartData());
                                                Print.chat(player, "Part processed. (" + serv.getPartData().getPart().getName() + ")");
                                                serv.setPartData(null);
                                                serv.sendUpdate(null);
                                            }
                                            else{
                                                continue;
                                            }
                                        }
                                    }
                                    else{
                                        String cat = packet.nbt.getString("category");
                                        if(serv.getVehicleData().getPart(cat) != null){
                                            Print.chat(player, "There is already a part installed in that category.");
                                            return;
                                        }
                                        if(serv.getPartData().getPart().installable(cat, serv.getVehicleData(), player)){
                                            serv.getVehicleData().installPart(cat, serv.getPartData());
                                            Print.chat(player, "Part processed. (" + serv.getPartData().getPart().getName() + ")");
                                            serv.setPartData(null);
                                            serv.sendUpdate(null);
                                        }
                                        else{
                                            return;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
                case "constructor_9000_recycle": {
                    BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
                    EntityPlayer player = (EntityPlayer) objs[0];
                    ConstructorControllerEntity serv = (ConstructorControllerEntity) player.world.getTileEntity(pos);
                    player.closeScreen();
                    serv.recycleVehicle();
                    break;
                }
                case "container_gui_scroll": {
                    ContainerInventoryGui.Server container = (ContainerInventoryGui.Server) ((EntityPlayer) objs[0]).openContainer;
                    container.refresh(packet.nbt.getInteger("scroll"));
                    break;
                }
                case "set_pipe_state": {
                    BlockPos pos = BlockPos.fromLong(packet.nbt.getLong("pos"));
                    EnumFacing facing = EnumFacing.getFront(packet.nbt.getInteger("facing"));
                    EntityPlayer player = (EntityPlayer) objs[0];
                    PipeTileEntity tile = (PipeTileEntity) player.world.getTileEntity(pos);
                    if(!tile.conn[facing.getIndex()]){
                        return;
                    }
                    switch(packet.nbt.getString("iod")){
                        case "red": {
                            tile.mode[facing.getIndex()] = true;
                            break;
                        }
                        case "blue": {
                            tile.mode[facing.getIndex()] = false;
                            break;
                        }
                        case "green": {
                            tile.direction = facing;
                            break;
                        }
                    }
                    tile.sendUpdate();
                    break;
                }
                case "script_setting":{
                	Print.debug(packet.nbt);
                    EntityPlayer player = (EntityPlayer)objs[0];
                	Entity ent = player.world.getEntityByID(packet.nbt.getInteger("entity"));
                	if(ent == null || ent instanceof VehicleEntity == false){ return; }
                	VehicleEntity vehicle = (VehicleEntity)ent;
                	VehicleScript script = null;
                	for(VehicleScript scr : vehicle.getVehicleData().getScripts()){
                		if(scr.getId().toString().equals(packet.nbt.getString("script"))){
                			script = scr; break;
                		}
                	}
                	if(script == null){ return; }
                	ScriptSetting<? extends VehicleScript, Entity> setting = null;
                	for(ScriptSetting<?, ?> sett : script.getSettings(packet.nbt.getInteger("seat"))){
                		if(sett.getId().equals(packet.nbt.getString("script_setting"))){
                			setting = (ScriptSetting<? extends VehicleScript, Entity>) sett; break;
                		}
                	}
                	if(setting != null){
                		Object[] objects = null;
                		if(packet.nbt.hasKey("objs")){
                			NBTTagList list = (NBTTagList)packet.nbt.getTag("objs");
                			objects = new Object[list.tagCount()];
                			for(int i = 0; i < objects.length; i++){
                				objects[i] = ((NBTTagString)list.get(i)).getString();
                			}
                		}
                		setting.onChange(player, ent, packet.nbt.getInteger("payload"), objects);
                	}
                	else return;
                }
                case "block_fluid_tank_set":{
                    EntityPlayer player = (EntityPlayer)objs[0];
                    if(player.openContainer instanceof UniversalBlockFluidGui.Server){
                    	((UniversalBlockFluidGui.Server)player.openContainer).init(packet.nbt.getString("string"));
                    }
                	return;
                }
                case "block_inventory_handler_set":{
                    EntityPlayer player = (EntityPlayer)objs[0];
                    if(player.openContainer instanceof UniversalBlockInventoryGui.Server){
                    	((UniversalBlockInventoryGui.Server)player.openContainer).refresh(null, packet.nbt.getString("string"));
                    }
                	return;
                }
                case "block_inventory_handler_scroll": {
                	UniversalBlockInventoryGui.Server container = (UniversalBlockInventoryGui.Server)((EntityPlayer) objs[0]).openContainer;
                    container.refresh(packet.nbt.getInteger("scroll"), null);
                    break;
                }
                case "block_script_setting":{
                	Print.debug(packet.nbt);
                    EntityPlayer player = (EntityPlayer)objs[0];
                    UniversalTileEntity tile = (UniversalTileEntity)player.world.getTileEntity(BlockPos.fromLong(packet.nbt.getLong("tile")));
                	if(tile == null || tile.getBlockData() == null || tile.getBlockData().getScript() == null){ return; }
                	BlockScript script = tile.getBlockData().getScript();
                	ScriptSetting<? extends BlockScript, TileEntity> setting = null;
                	for(ScriptSetting<?, ?> sett : script.getSettings(packet.nbt.getInteger("seat"))){
                		if(sett.getId().equals(packet.nbt.getString("script_setting"))){
                			setting = (ScriptSetting<? extends BlockScript, TileEntity>)sett; break;
                		}
                	}
                	if(setting != null){
                		Object[] objects = null;
                		if(packet.nbt.hasKey("objs")){
                			NBTTagList list = (NBTTagList)packet.nbt.getTag("objs");
                			objects = new Object[list.tagCount()];
                			for(int i = 0; i < objects.length; i++){
                				objects[i] = ((NBTTagString)list.get(i)).getString();
                			}
                		}
                		setting.onChange(player, tile, packet.nbt.getInteger("payload"), objects);
                	}
                	else return;
                }
                case "generic_adjustable_inventory_data":{
                	//TODO
                	Print.debug(packet.nbt);
                	return;
                }
                case "generic_gui":{
                    EntityPlayer player = (EntityPlayer)objs[0];
                    ((GenericGuiContainer)player.openContainer).packet(Side.SERVER, packet.nbt, player);
                	return;
                }
                default:{
                	Print.debug("unknown target", packet.nbt, objs[0]);
                	return;
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
            if(!packet.nbt.hasKey("cargo") && !packet.nbt.hasKey("task")) return;
            String str = packet.nbt.hasKey("cargo") ? packet.nbt.getString("cargo") : packet.nbt.getString("task");
            switch(str){
                case "addon_list": {
                    AddonManagerGui.addons.clear();
                    int size = packet.nbt.getInteger("Size");
                    for(int i = 0; i < size; i++){
                        NBTTagCompound nbt = packet.nbt.getCompoundTag("entry_" + i);
                        GenericAddon addon = new GenericAddon();
                        AddonManagerGui.addons.add(addon.fromNBT(nbt));
                    }
                    break;
                }
                case "addon_state_change_confirmation": {
                    if(packet.nbt.hasKey("success") && packet.nbt.getBoolean("success")){
                        AddonManagerGui.addon.setEnabled(packet.nbt.getBoolean("enabled"));
                    }
                    Print.debug("C: " + packet.nbt);
                    break;
                }
                case "update_fuel_tanks": {
                    Print.debug(packet.nbt.toString());
                    VehicleData data = ((SeatEntity)((EntityPlayer)objs[0]).getRidingEntity()).getVehicle().getVehicleData();
                    NBTTagList list = (NBTTagList) packet.nbt.getTag("parts");
                    list.forEach((nbtbase) -> {
                        NBTTagCompound compound = (NBTTagCompound) nbtbase;
                        data.getPart(compound.getString("part")).getAttributeData(FuelTankExtensionAttributeData.class).setContent(compound.getDouble("amount"));
                    });
                    break;
                }
                case "constructor_9000_init": {
                    ConstructorMainGUI.processInitResponse(packet.nbt);
                    break;
                }
                case "update_fluid_tank": {
                    VehicleData data = ((SeatEntity)((EntityPlayer)objs[0]).getRidingEntity()).getVehicle().getVehicleData();
                    PartData part = data.getInventoryContainers().get(packet.nbt.getInteger("tank"));
                    if(packet.nbt.getBoolean("wasempty")){
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString("task", "resync");
                        PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(((SeatEntity) ((EntityPlayer) objs[0]).getRidingEntity()).getVehicle().getEntity(), nbt));
                    }
                    else{
                        InventoryAttributeData attr = part.getAttributeData(InventoryAttributeData.class);
                        if(attr.getFluidTank() != null){
                            attr.getFluidTank().readFromNBT(packet.nbt.getCompoundTag("state"));
                        }
                    }
                    break;
                }
                case "generic_adjustable_inventory_data":{
                	String[] data = packet.nbt.getString("data").split("|");
                	EntityPlayer player = (EntityPlayer)objs[0];
                	if(player.openContainer != null && player.openContainer instanceof GenericAdjustableInventory.Container){
                		((GenericAdjustableInventory.Container)player.openContainer).setup(player, data);
                		Print.debug("OK", player, data, player.openContainer);
                	}
                	else{
                		Print.debug("NO", player, data, player.openContainer);
                	}
                	break;
                }
                case "generic_gui":{
                    EntityPlayer player = (EntityPlayer)objs[0];
                    ((GenericGuiContainer)player.openContainer).packet(Side.CLIENT, packet.nbt, player);
                	return;
                }
                default:{
                	Print.debug("unknown target", packet.nbt, objs[0]);
                	return;
                }
            }
        }

    }
    
    public static class EventHandler {
    	
    	public static HashMap<UUID, String[]> QUEUE = new HashMap<>();
    	
    	@SubscribeEvent
    	public void onContainerOpen(PlayerContainerEvent.Open event){
    		if(!event.getEntityPlayer().world.isRemote && event.getContainer() instanceof GenericAdjustableInventory.Container && QUEUE.containsKey(event.getEntityPlayer().getGameProfile().getId())){
    			((GenericAdjustableInventory.Container)event.getContainer()).setup(event.getEntityPlayer(), QUEUE.remove(event.getEntityPlayer().getGameProfile().getId()));
    		}
    	}
    	
    }

}
