package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.RailBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.sys.legacy.AirVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.LandVehicle;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.PresetTab;
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
        	type.getRegistryName().getPath(), this, 0, null);
        if(Static.side().isServer()) return;
        this.setCreativeTab(type.getAddon().getCreativeTab());
	}

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
    	if(!cache.overridesLang(false)) tooltip.add(Formatter.format("&9Name: &7" + type.getName()));
        for(String s : type.getDescription()){ tooltip.add(Formatter.format(I18n.format(s, new Object[0]))); }
        VehicleData data = cache.getVehicleData();
        if(data == null) return;
        if(data.isPreset()) tooltip.add(Formatter.format("&6Preset: &7" + data.getPreset()));
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
	
    @SuppressWarnings("deprecation")
	@Override
    public String getItemStackDisplayName(ItemStack stack){
    	VehicleAndPartDataCache cache = stack.getCapability(Capabilities.VAPDATA, null);
    	if(cache.getVehicleData().getDisplayName() != null){
    		return Formatter.format("&o" + cache.getVehicleData().getName());
    	}
    	if(!cache.overridesLang(false)){
        	String langname = "item." + stack.getItem().getRegistryName().toString() + ".name";
        	langname = net.minecraft.util.text.translation.I18n.translateToLocal(langname).trim();
        	if(langname.length() > 0) return langname;
        	if(cache != null) stack.getCapability(Capabilities.VAPDATA, null).overridesLang(true);
    	}
        return Formatter.format(cache.getVehicleData().getType().getName());
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
    	if(tab == CreativeTabs.SEARCH || tab == PresetTab.INSTANCE){
    		if(tab == PresetTab.INSTANCE) (PresetTab.INSTANCE.ITEMS = items).clear();
    		for(ItemStack stack : PresetTab.INSTANCE.get()){ items.add(stack); }
    	}
    }
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand){
    	if(world.isRemote || side != EnumFacing.UP) return EnumActionResult.PASS; ItemStack stack = player.getHeldItem(hand);
    	if(world.getBlockState(pos).getBlock() instanceof ConstructorBlock) return EnumActionResult.PASS;
    	VehicleData data = ((VehicleItem)stack.getItem()).getData(stack);
    	if(data.getType().getVehicleType().isAirVehicle()){
    		if(!validToSpawn(player, stack, world, data, true)){ return EnumActionResult.SUCCESS; }
    		world.spawnEntity(new AirVehicle(world, data, new Vec3d(pos.up(2)), player, -1));
    	}
    	else if(data.getType().getVehicleType().isRailVehicle()){
            RailSys syscap = world.getCapability(Capabilities.RAILSYSTEM, null).get();
            if(syscap == null){ Print.chat(player, "&cWorld Capability not found."); return EnumActionResult.SUCCESS; }
            Vec316f vector = new Vec316f(new Vec3d(pos).add(hitX, hitY, hitZ), Config.RAIL_PLACING_GRID);
    		Junction junk = syscap.getJunction(vector, true);
    		net.fexcraft.mod.fvtm.block.RailEntity tile = world.getBlockState(pos).getBlock() instanceof RailBlock ? (net.fexcraft.mod.fvtm.block.RailEntity)world.getTileEntity(pos) : null;
			double length = data.getWheelPositions().get("bogie_front").x + -data.getWheelPositions().get("bogie_rear").x;
    		if((junk == null || junk.tracks.isEmpty()) && tile != null){
    			if(tile.getTracks().size() > 1){
        			Print.bar(player, "&c&oPlaceable only on single-track rail blocks.");
    			}
    			else{
    				Track track = syscap.getTrack(tile.getTracks().keySet().toArray(new PathKey[0])[0]);
        			if(track.length < length){
            			Print.bar(player, "&c&oTrack too short to spawn this vehicle.");
            			return EnumActionResult.SUCCESS;
        			}
        			else{
            			Print.bar(player, "&b&oSpawning vehicle...");
        				syscap.registerEntity(new RailEntity(syscap, data, track, player.getGameProfile().getId()));
        			}
    			}
    	        return EnumActionResult.SUCCESS;
    		}
    		if(junk == null){
    			Print.bar(player, "&c&oNo Junction found at this position.");
    		}
    		else if(junk.tracks.isEmpty()){
    			Print.bar(player, "&c&oJunction has no tracks attached.");
    		}
    		else{
    			if(junk.tracks.get(0).length < length){
        			Print.bar(player, "&c&oFirst Track of Junction too short to spawn this vehicle."); return EnumActionResult.SUCCESS;
    			}
    			Print.bar(player, "&a&oSpawning vehicle...");
				syscap.registerEntity(new RailEntity(syscap, data, junk.tracks.get(0), player.getGameProfile().getId()));
    		}
    	}
    	else{
    		if(!validToSpawn(player, stack, world, data, false)){ return EnumActionResult.SUCCESS; }
    		world.spawnEntity(new LandVehicle(world, data, new Vec3d(pos.up(2)), player, -1));
    	}
    	if(!player.capabilities.isCreativeMode) stack.shrink(1);
        return EnumActionResult.SUCCESS;
    }
    
    public static boolean validToSpawn(EntityPlayer player, ItemStack stack, World world, VehicleData data, boolean plane){
		String[] index = plane ? AirVehicle.WHEELINDEX : data.getType().isTrailerOrWagon()
			? LandVehicle.TRAILERWHEELINDEX : LandVehicle.WHEELINDEX; boolean failed = false;
		for(String str : index){
			if(!data.getWheelPositions().containsKey(str)){
				String trailer = data.getType().isTrailerOrWagon() ? "&9Trailer" : "&9Vehicle";
				Print.chat(player, trailer + " is missing a wheel! &7&o" + str); failed = true;
			}
		}
		if(!data.getType().isTrailerOrWagon() && !data.hasPart("engine")){
			Print.chat(player, "&9Vehicle does not have an Engine installed!"); //failed = true;
		}
		if(!data.getType().isTrailerOrWagon() && data.getSeats().size() < 1){
			Print.chat(player, "&9Vehicle does not have any Seats!"); failed = true;
		}
		for(String part : data.getType().getRequiredParts()){
			if(data.getPart(part) == null){
				Print.chat(player, "&9Vehicle is missing &6required part&9: &a" + part + "&9!"); failed = true;
			}
		}
		//TODO add later more checks if necessary
		return !failed;
	}

	@Override
    public boolean showJunctionGrid(){
    	return type.getVehicleType().isRailVehicle();
    }

}
