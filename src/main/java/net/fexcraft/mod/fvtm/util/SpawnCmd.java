package net.fexcraft.mod.fvtm.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.entities.GenericVehicleEntity;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.api.common.fCommand;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.json.NBTToJson;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.server.permission.PermissionAPI;

@fCommand
public class SpawnCmd extends CommandBase {

    @Override
    public String getName(){
        return "fvtms";
    }

    @Override
    public String getUsage(ICommandSender var1){
        return "/fvtms <arg>";
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender){
        if(sender instanceof EntityPlayer){
            return server.isSinglePlayer() ? true : PermissionAPI.hasPermission((EntityPlayer)sender, FvtmPermissions.SPAWN_CMD);
        }
        Print.chat(sender, "Only executable by a player IN-GAME.");
        return false;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException{
        if(args.length < 1){
            Print.chat(sender, FVTM.PREFIX + "&8=============== &5==== &8==");
            Print.chat(sender, "&7Vehicle and Item Spawning Command");
            Print.chat(sender, "&9/fvtms presetfolder &f&o(opens folder)");
            Print.chat(sender, "&9/fvtms preset &6<filelocation> &f&o(entity)");
            Print.chat(sender, "&9/fvtms preset &6<filelocation> &5item");
            Print.chat(sender, "&9/fvtms print &f&o(vehicle item in hand)");
            Print.chat(sender, "&9/fvtms print clipboard &f&o(vehicle item in hand)");
            Print.chat(sender, "&9/fvtms print file &6<filename> &f&o(vehicle item in hand)");
            Print.chat(sender, "&9/fvtms registry &6<vehicle-registry-name>");
            Print.chat(sender, FVTM.PREFIX + "&8=============== &2==== &8==");
            return;
        }
        else if(args[0].equals("presetfolder")){
            if(!server.isSinglePlayer()){
                Print.chat(sender, "&7Only available in SinglePlayer.");
            }
            else{
                File file = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/presets/");
                if(!file.exists()){
                    file.mkdirs();
                }
                net.minecraft.client.renderer.OpenGlHelper.openFile(file);
            }
        }
        else if(args[0].equals("preset")){
            try{
                if(args.length < 2){
                    Print.chat(sender, "&7&lMissing \"path\" Argument.");
                    return;
                }
                File file = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/presets/" + args[1] + ".preset");
                if(!file.exists()){
                    Print.chat(sender, "&8&lFile not found.");
                    Print.chat(sender, "&7&o" + file.toString());
                    return;
                }
                VehicleData data = Resources.getVehicleData(JsonToNBT.getTagFromJson(quickFix(JsonUtil.get(file)).toString()));
                Print.debug(data.writeToNBT(new NBTTagCompound()));
                if(args.length >= 3 && args[2].equals("item")){
                    ItemStack stack = data.getVehicle().getItemStack(data);
                    ((EntityPlayer) sender).dropItem(stack, false);
                    Print.chat(sender, "Item Spawned.");
                }
                else{
                    Vec3d vec = sender.getPositionVector().addVector(0, 2, 0);
                    sender.getEntityWorld().spawnEntity(new GenericVehicleEntity(sender.getEntityWorld(), vec.x, vec.y, vec.z, (EntityPlayer) sender, data));
                    Print.chat(sender, "Entity Spawned.");
                }
            }
            catch(Exception e){
                Print.chat(sender, e.getLocalizedMessage());
            }
        }
        else if(args[0].equals("print")){
            ItemStack stack = ((EntityPlayer) sender).getHeldItem(EnumHand.MAIN_HAND);
            if(!stack.isEmpty() && stack.getItem() instanceof VehicleItem){
                boolean cptc = args.length >= 2 && args[1].equals("clipboard");
                boolean asfl = args.length >= 2 && args[1].equals("file");
                NBTTagCompound nbt = ((VehicleItem) stack.getItem()).getVehicle(stack).writeToNBT(new NBTTagCompound());
                JsonObject json = NBTToJson.getJsonFromTag(nbt);
                json.addProperty("PresetCreator", ((EntityPlayer) sender).getName());
                json.addProperty("PresetCreatorUUID", ((EntityPlayer) sender).getGameProfile().getId().toString());
                json.addProperty("PresetCreated", Time.getDate());
                if(cptc){
                    StringSelection selection = new StringSelection(JsonUtil.getGson().toJson(json));
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, selection);
                    Print.chat(sender, "Copied to clipboard!");
                }
                else if(asfl){
                    if(args.length < 3){
                        Print.chat(sender, "&7&lMissing \"filename\" Argument.");
                        return;
                    }
                    File file = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/presets/" + args[2] + ".preset");
                    if(!file.getParentFile().exists()){
                        file.mkdirs();
                    }
                    if(file.exists() && (args.length < 4 || !args[3].equals("overwrite"))){
                        Print.chat(sender, "&7&lA preset with that name already does exists.");
                        Print.chat(sender, "&7&oTry: /fvtms print file <filename> overwrite");
                        return;
                    }
                    JsonUtil.write(file, json);
                    Print.chat(sender, "&7Preset created!");
                    Print.chat(sender, "&8&o" + file.toString());
                }
                else{
                    Print.chat(sender, "&7&o" + JsonUtil.getGson().toJson(json));
                }
            }
            else{
                Print.chat(sender, "No valid Vehicle Item in mainhand.");
            }
        }
        else if(args[0].equals("registry")){
            if(args.length < 2){
                Print.chat(sender, "&7&lMissing \"path\" Argument.");
                return;
            }
            try{
                Vehicle vehicle = Resources.VEHICLES.getValue(new ResourceLocation(args[1]));
                if(vehicle == null){
                    Print.chat(sender, "Vehicle not found.");
                    return;
                }
                Vec3d vec = sender.getPositionVector().addVector(0, 2, 0);
                sender.getEntityWorld().spawnEntity(new GenericVehicleEntity(sender.getEntityWorld(), vec.x, vec.y, vec.z, (EntityPlayer) sender, vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle)));
            }
            catch(Exception e){
                Print.chat(sender, e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }

    public static final JsonObject quickFix(JsonObject obj){
        JsonObject jsn = obj.has("fvtm_landvehicle") ? obj.get("fvtm_landvehicle").getAsJsonObject() : obj.has("fvtm_vehicle") ? obj.get("fvtm_vehicle").getAsJsonObject() : null;
        if(jsn.has("PrimaryRed")){
            jsn.addProperty("PrimaryRed", Byte.parseByte(jsn.get("PrimaryRed").getAsString().replace("b", "")));
        }
        if(jsn.has("PrimaryGreen")){
            jsn.addProperty("PrimaryGreen", Byte.parseByte(jsn.get("PrimaryGreen").getAsString().replace("b", "")));
        }
        if(jsn.has("PrimaryBlue")){
            jsn.addProperty("PrimaryBlue", Byte.parseByte(jsn.get("PrimaryBlue").getAsString().replace("b", "")));
        }
        if(jsn.has("SecondaryRed")){
            jsn.addProperty("SecondaryRed", Byte.parseByte(jsn.get("SecondaryRed").getAsString().replace("b", "")));
        }
        if(jsn.has("SecondaryGreen")){
            jsn.addProperty("SecondaryGreen", Byte.parseByte(jsn.get("SecondaryGreen").getAsString().replace("b", "")));
        }
        if(jsn.has("SecondaryBlue")){
            jsn.addProperty("SecondaryBlue", Byte.parseByte(jsn.get("SecondaryBlue").getAsString().replace("b", "")));
        }
        return obj;
    }

}
