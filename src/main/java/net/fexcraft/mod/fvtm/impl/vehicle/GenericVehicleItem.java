package net.fexcraft.mod.fvtm.impl.vehicle;

import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import java.util.Collection;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.EntityType;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.impl.GenericCreativeTab;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.SpawnCmd;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.server.permission.PermissionAPI;

public class GenericVehicleItem extends Item implements VehicleItem {

    public static final GenericVehicleItem INSTANCE = new GenericVehicleItem();

    public GenericVehicleItem(){
        //this.setCreativeTab(Tabs.LANDVEHICLES);
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setRegistryName("fvtm:vehicles");
        this.setUnlocalizedName(this.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static class ItemMeshDef implements net.minecraft.client.renderer.ItemMeshDefinition {

        @Override
        public final net.minecraft.client.renderer.block.model.ModelResourceLocation getModelLocation(ItemStack stack){
            if(stack.hasTagCompound() && (stack.getTagCompound().hasKey(NBTKEY) || stack.getTagCompound().hasKey(OLDNBTKEY))){
                return new net.minecraft.client.renderer.block.model.ModelResourceLocation(new ResourceLocation(stack.getTagCompound().getString(NBTKEY)), "inventory");
            }
            return new net.minecraft.client.renderer.block.model.ModelResourceLocation(INSTANCE.getRegistryName(), "inventory");
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        if(stack.hasTagCompound() && (stack.getTagCompound().hasKey(NBTKEY) || stack.getTagCompound().hasKey(OLDNBTKEY))){
            VehicleData veh = stack.getCapability(FVTMCaps.VAPDATA, null).getVehicleData();
            if(veh == null){
                return;
            }
            if(stack.getTagCompound().hasKey("PresetKey")){
                tooltip.add(Formatter.format("&9Preset: &6" + stack.getTagCompound().getString("PresetKey")));
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
            }
            if(veh.getVehicle().isTrailerOrWagon()){
                tooltip.add(Formatter.format("&o&6Trailer/Wagon."));
            }
            tooltip.add(Formatter.format("&9Name: &7" + veh.getVehicle().getName()));
            for(String s : veh.getVehicle().getDescription()){
                tooltip.add(Formatter.format(s));
            }
            tooltip.add(Formatter.format("&9Lock Code: &r" + veh.getLockCode()));
            tooltip.add(Formatter.format("&9Selected Texture: &7" + veh.getSelectedTexture()));
            tooltip.add(Formatter.format("&9Seat Amount: &r" + veh.getSeats().size()));
            tooltip.add(Formatter.format("&9Adj. Wheels: &r" + veh.getVehicle().getWheelPositions().size()));
            tooltip.add(Formatter.format("&9Fuel Tank: &7" + RGB.format(veh.getFuelTankContent()) + "&8/&e" + veh.getFuelTankSize()));
            tooltip.add(Formatter.format("&9Fuel Type: &7" + (veh.getPart("engine") == null ? "unknown / no engine" : veh.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelType().getName())));
            if(veh.getVehicle().getType().isWaterVehicle()){
                tooltip.add(Formatter.format("&9Bouyancy: &r" + veh.getVehicle().getFMAttribute("bouyancy")));
            }
            if(veh.getParts().size() > 0){
                tooltip.add(Formatter.format("&3Installed Parts:"));
                if(tooltip.size() >= 9 && veh.getParts().size() > 6 && !flagIn.isAdvanced()){
                    tooltip.add(Formatter.format("&7- &oEnable Advanced Tooltips to see all."));
                }
                else{
                    veh.getParts().forEach((key, data) -> {
                        tooltip.add(Formatter.format("&7- &3" + data.getPart().getName() + " &7(" + key + ")"));
                    });
                }
            }
            if(veh.getVehicle().getModel() != null && veh.getVehicle().getModel().getCreators().size() > 0){
                tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
                tooltip.add(Formatter.format("&6Model by:"));
                for(String string : veh.getVehicle().getModel().getCreators()){
                    try{
                        tooltip.add(Formatter.format("&7- &3" + Static.getPlayerNameByUUID(UUID.fromString(string))));
                    }
                    catch(Exception e){
                        tooltip.add(Formatter.format("&7- &3" + string));
                    }
                }
            }
            tooltip.add(Formatter.format("&9Ready to Spawn: " + (veh.readyToSpawn() ? "&ayes" : "&cno")));
        }
    }

    @SuppressWarnings("deprecation") @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
        if(tab == CreativeTabs.SEARCH){
            for(Vehicle veh : Resources.VEHICLES.getValues()){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, veh.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab instanceof GenericCreativeTab){
            Collection<Vehicle> coll = Resources.getVehiclesByAddon(((GenericCreativeTab)tab).getAddon());
            for(Vehicle veh : coll){
                ItemStack stack = new ItemStack(this);
                NBTTagCompound nbt = new NBTTagCompound();
                nbt.setString(NBTKEY, veh.getRegistryName().toString());
                stack.setTagCompound(nbt);
                items.add(stack);
            }
        }
        if(tab == Tabs.VEHICLE_PRESETS || tab == CreativeTabs.SEARCH){
            for(Entry<String, JsonObject> entry : Resources.PRESETS.entrySet()){
                try{
                    NBTTagCompound nbt = JsonToNBT.getTagFromJson(SpawnCmd.quickFix(entry.getValue()).toString());
                    ItemStack stack = new ItemStack(this);
                    nbt.setString("PresetKey", entry.getKey());
                    stack.setTagCompound(nbt);
                    items.add(stack);
                }
                catch(Exception e){
                    //e.printStackTrace();
                };
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        if(stack.hasTagCompound()){
            return "item." + stack.getTagCompound().getString(NBTKEY);
        }
        return this.getUnlocalizedName();
    }

    @Override
    public VehicleData getVehicle(ItemStack stack){
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTKEY)){
            return Resources.getVehicleData(stack.getTagCompound());
        }
        return null;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
    	if(world.isRemote) return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
    	if(!PermissionAPI.hasPermission(player, FvtmPermissions.VEHICLE_PLACE) || !PermissionAPI.hasPermission(player, FvtmPermissions.permPlace(player.getHeldItem(hand)))){
    		Print.chat(player, "&c&oYou do not have permission to place/spawn this vehicle.");
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    	}
    	//TODO open gui for selecting EntityType
    	ItemStack stack = player.getHeldItem(hand); VehicleData data = ((VehicleItem)stack.getItem()).getVehicle(stack);
    	EntityType.INTERNAL.spawnEntity(world, player, stack, data, data.getVehicle().getType());
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

}
