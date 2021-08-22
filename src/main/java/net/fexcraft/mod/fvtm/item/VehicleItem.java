package net.fexcraft.mod.fvtm.item;

import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.data.VehicleAndPartDataCache;
import net.fexcraft.mod.fvtm.data.root.DataCore.DataCoreItem;
import net.fexcraft.mod.fvtm.data.root.TypeCore.TypeCoreItem;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem;
import net.fexcraft.mod.fvtm.data.vehicle.EntitySystem.SpawnMode;
import net.fexcraft.mod.fvtm.data.vehicle.Vehicle;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.util.PresetTab;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.function.EngineFunction;
import net.fexcraft.mod.fvtm.util.function.TransmissionFunction;
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
        this.setCreativeTab(Resources.getCreativeTab(type));
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
            tooltip.add(Formatter.format("&9Fuel Stored: &7" + data.getAttribute("fuel_stored").integer_value() + "mB"));
        }
        if(data.hasPart("transmission")){
        	TransmissionFunction func = data.getFunctionInPart("transmission", "fvtm:transmission");
            tooltip.add(Formatter.format("&9Transmission: &7" + (func == null ? "disfunctional" : func.isAutomatic() ? "automatic" : "manual")));
        }
        tooltip.add(Formatter.format("&9Weight: &7" + data.getAttribute("weight").float_value() + "kg"));
        tooltip.add(Formatter.format("&9Seats: &7" + data.getSeats().size()));
    	tooltip.add(Formatter.format("&9LockCode: &7" + data.getLockCode()));
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
    	EntitySystem.spawnVehicle(player, new Vec3d(pos).add(hitX, hitY, hitZ), stack, data, SpawnMode.PLAYER);
    	return EnumActionResult.SUCCESS;
    }

	@Override
    public boolean showJunctionGrid(){
    	return type.getVehicleType().isRailVehicle();
    }

}
