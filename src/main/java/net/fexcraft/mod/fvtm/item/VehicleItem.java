package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.AirVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VehicleItem extends TypeCoreItem<Vehicle> implements DataCoreItem<VehicleData>, JunctionGridItem  {

    public VehicleItem(Vehicle core){
		super(core); this.setHasSubtypes(true); this.setMaxStackSize(1);
        this.type.getAddon().getFCLRegisterer().addItem(
        	type.getRegistryName().getResourcePath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
        tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
        VehicleData data = stack.getCapability(Capabilities.VAPDATA, null).getVehicleData(); if(data == null) return;
        tooltip.add(Formatter.format("&9Texture: &7" + getTexTitle(data)));
        if(data.hasPart("engine")){
            tooltip.add(Formatter.format("&9Engine: &7" + data.getPart("engine").getType().getName()));
            tooltip.add(Formatter.format("&9Fuel Group: &7" + data.getPart("engine").getFunction(EngineFunction.class, "fvtm:engine").getFuelGroup()[0]));
            tooltip.add(Formatter.format("&9Fuel Stored: &7" + data.getAttribute("fuel_stored").getIntegerValue() + "mB"));
        }
        tooltip.add(Formatter.format("&9Weight: &7" + data.getAttribute("weight").getStringValue() + "kg"));
        tooltip.add(Formatter.format("&9Seats: &7" + data.getSeats().size()));
        //temporary
        /*if(flag.isAdvanced() && !data.getAttributes().isEmpty()){
        	for(Attribute attr : data.getAttributes().values()){
        		tooltip.add(Formatter.format("&9" + attr.getId() + ": &7" + attr.getCurrentString()));
        	}
        }*/
        if(type.getModel().getCreators().size() > 0){
            tooltip.add(Formatter.format("&9Model by:"));
            for(String str : type.getModel().getCreators()){
            	tooltip.add(Formatter.format("&7- " + str));
            }
        }
        //TODO other data
    }

	private String getTexTitle(VehicleData data){
		if(data.getSelectedTexture() >= 0){
			return "[" + data.getSelectedTexture() + "] " + data.getType().getDefaultTextures().get(data.getSelectedTexture()).getName();
		} else return data.isExternalTexture() ? "external" : "internal";
	}

	@Override
	public VehicleData getData(ItemStack stack){
		if(!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound()); return getData(stack.getTagCompound());
	}

	@Override
	public VehicleData getData(NBTTagCompound compound){
		return new VehicleData(type).read(compound);
	}
	
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
    	if(tab == CreativeTabs.SEARCH || tab == this.getCreativeTab()){
    		items.add(type.newItemStack());
    	}
    }
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side != EnumFacing.UP) return EnumActionResult.PASS; ItemStack stack = player.getHeldItem(hand);
    	if(world.getBlockState(pos).getBlock() instanceof ConstructorBlock) return EnumActionResult.PASS;
    	VehicleData data = ((VehicleItem)stack.getItem()).getData(stack);
    	if(data.getType().getVehicleType().isAirVehicle()){
    		if(!valid(player, stack, world, data, true)){ return EnumActionResult.FAIL; }
    		world.spawnEntity(new AirVehicle(world, data, new Vec3d(pos.up(2)), player, -1));
    	}
    	else if(data.getType().getVehicleType().isRailVehicle()){
            RailSystem syscap = world.getCapability(Capabilities.RAILSYSTEM, null);
            if(syscap == null){ Print.chat(player, "&cWorld Capability not found."); return EnumActionResult.FAIL; }
            Vec316f vector = new Vec316f(new Vec3d(pos).addVector(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
    		Junction junk = syscap.getJunction(vector, true);
    		if(junk == null){
    			Print.bar(player, "&c&oNo Junction found at this position.");
    		}
    		else if(junk.tracks.isEmpty()){
    			Print.bar(player, "&c&oJunction has no tracks attached.");
    		}
    		else{
    			double length = data.getWheelPositions().get("bogie_front").x + -data.getWheelPositions().get("bogie_rear").x;
    			if(junk.tracks.get(0).length < length){
        			Print.bar(player, "&c&oFirst Track of Junction too short to spawn this vehicle."); return EnumActionResult.FAIL;
    			}
    			Print.bar(player, "&a&oSpawning vehicle...");
				syscap.registerEntity(new RailEntity((RailData)syscap, data, junk.tracks.get(0), player.getGameProfile().getId()));
    		}
    	}
    	else{
    		if(!valid(player, stack, world, data, false)){ return EnumActionResult.FAIL; }
    		world.spawnEntity(new LandVehicle(world, data, new Vec3d(pos.up(2)), player, -1));
    	}
    	if(!player.capabilities.isCreativeMode) stack.shrink(1);
        return EnumActionResult.SUCCESS;
    }
    
    private boolean valid(EntityPlayer player, ItemStack stack, World world, VehicleData data, boolean plane){
		String[] index = plane ? AirVehicle.WHEELINDEX : LandVehicle.WHEELINDEX; boolean failed = false;
		for(String str : index){
			if(!data.getWheelPositions().containsKey(str)){
				Print.chat(player, "&9Vehicle is missing a wheel! &7&o" + str); failed = true;
			}
		}
		if(!data.getType().isTrailerOrWagon() && !data.hasPart("engine")){
			Print.chat(player, "Vehicle does not have an Engine installed!"); failed = true;
		}
		if(!data.getType().isTrailerOrWagon() && data.getSeats().size() < 1){
			Print.chat(player, "Vehicle does not have any Seats!"); failed = true;
		}
		//TODO add later more checks if necessary
		return !failed;
	}

	@Override
    public boolean showJunctionGrid(){
    	return type.getVehicleType().isRailVehicle();
    }

}
