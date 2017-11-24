package net.fexcraft.mod.fvtm.impl;

import java.util.List;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.addons.gep.attributes.EngineAttribute;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.entities.LandVehicleEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.SpawnCmd;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.render.RGB;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericVehicleItem extends Item implements VehicleItem {
	
	public static final GenericVehicleItem INSTANCE = new GenericVehicleItem();
	
	public GenericVehicleItem(){
		this.setCreativeTab(Tabs.LANDVEHICLES);
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
			VehicleData veh = Resources.getVehicleData(stack.getTagCompound(), worldIn == null ? false/*true?*/ : worldIn.isRemote);
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
			tooltip.add(Formatter.format("&9Fuel Tank: &7" + RGB.format(veh.getFuelTankContent()) + "&8/&e" + veh.getFuelTankSize()));
			tooltip.add(Formatter.format("&9Fuel Type: &7" + (veh.getPart("engine") == null ? "unknown / no engine" : veh.getPart("engine").getPart().getAttribute(EngineAttribute.class).getFuelType().getName())));
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
			if(veh.getVehicle().getModel() != null && veh.getVehicle().getModel().creators.size() > 0){
				tooltip.add(Formatter.format("&9- - - &7-&9 - - -"));
				tooltip.add(Formatter.format("&6Model by:"));
				for(String string : veh.getVehicle().getModel().creators){
					tooltip.add(Formatter.format("&7- &3" + string));
				}
			}
			tooltip.add(Formatter.format("&9Ready to Spawn: " + (veh.readyToSpawn() ? "&ayes" : "&cno")));
		}
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		if(tab == Tabs.LANDVEHICLES){
			for(Vehicle veh : Resources.getVehiclesByType(VehicleType.LAND)){
				ItemStack stack = new ItemStack(this);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString(NBTKEY, veh.getRegistryName().toString());
				stack.setTagCompound(nbt);
				items.add(stack);
			}
		}
		if(tab == Tabs.AIRVEHICLES){
			for(Vehicle veh : Resources.getVehiclesByType(VehicleType.AIR)){
				ItemStack stack = new ItemStack(this);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString(NBTKEY, veh.getRegistryName().toString());
				stack.setTagCompound(nbt);
				items.add(stack);
			}
		}
		if(tab == Tabs.WATERVEHICLES){
			for(Vehicle veh : Resources.getVehiclesByType(VehicleType.WATER)){
				ItemStack stack = new ItemStack(this);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString(NBTKEY, veh.getRegistryName().toString());
				stack.setTagCompound(nbt);
				items.add(stack);
			}
		}
		if(tab == Tabs.RAILVEHICLES){
			for(Vehicle veh : Resources.getVehiclesByType(VehicleType.RAIL)){
				ItemStack stack = new ItemStack(this);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString(NBTKEY, veh.getRegistryName().toString());
				stack.setTagCompound(nbt);
				items.add(stack);
			}
		}
		if(tab == Tabs.VEHICLE_PRESETS){
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
			return Resources.getVehicleData(stack.getTagCompound(), false);
		}
		return null;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		float cosYaw = MathHelper.cos(-player.rotationYaw * 0.01745329F - 3.141593F);
		float sinYaw = MathHelper.sin(-player.rotationYaw * 0.01745329F - 3.141593F);
		float cosPitch = -MathHelper.cos(-player.rotationPitch * 0.01745329F);
		float sinPitch = MathHelper.sin(-player.rotationPitch * 0.01745329F);
		double length = 5D;
		Vec3d posVec = new Vec3d(player.posX, player.posY + 1.62D - player.getYOffset(), player.posZ);		
		Vec3d lookVec = posVec.addVector(sinYaw * cosPitch * length, sinPitch * length, cosYaw * cosPitch * length);
		RayTraceResult movingobjectposition = world.rayTraceBlocks(posVec, lookVec, true);
		if(movingobjectposition == null){
			return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));
		}
		if(movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK){
			BlockPos pos = movingobjectposition.getBlockPos();
			if(!world.isRemote){
				world.spawnEntity(new LandVehicleEntity(world, pos.getX() + 0.5F, pos.getY() + 2.5F, pos.getZ() + 0.5F, player, this.getVehicle(player.getHeldItem(hand))));
			}
			if(!player.capabilities.isCreativeMode){
				player.getHeldItem(hand).shrink(1);
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	
}