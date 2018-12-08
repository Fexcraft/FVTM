package net.fexcraft.mod.fvtm.api;

import java.util.TreeMap;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class EntityType {
	
	//Those here usually get initialized by FVTM, 
	public static EntityType NONE, INTERNAL, PROTOTYPE;
	private static TreeMap<ResourceLocation, EntityType> ENTITYTYPES = new TreeMap<>();

    private ResourceLocation rsname;
    private VehicleType[] types;
    private String name;

    public EntityType(ResourceLocation id, String name, VehicleType... types){
        this.rsname = id; this.name = name; this.types = types; add(this, name.equals("NONE"));
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public String getName(){
        return name;
    }
    
    public ResourceLocation getRegistryName(){
    	return rsname;
    }
    
    /** Returns the first type in the array, or NULL. */
    public VehicleType getType(){
    	return types == null || types.length == 0 ? VehicleType.NULL : types[0];
    }
    
    public VehicleType[] getTypes(){
    	return types;
    }
    
    public boolean supports(VehicleType type){
    	for(VehicleType vehtype : types) if(vehtype == type) return true; return false;
    }
    
    public static void add(EntityType type, boolean override){
    	if(!override && ENTITYTYPES.containsKey(type.getRegistryName())) return;
    	ENTITYTYPES.put(type.getRegistryName(), type); return;
    }
    
    public static void addAll(Iterable<EntityType> types, boolean override){
    	for(EntityType type : types) add(type, override);
    }
    
    public static void addAll(EntityType[] types, boolean override){
    	for(EntityType type : types) add(type, override);
    }
    
    public static TreeMap<ResourceLocation, EntityType> getEntityTypes(){
    	return ENTITYTYPES;
    }
    
    public abstract boolean spawnEntity(World world, @Nullable EntityPlayer player, ItemStack stack, VehicleData data, VehicleType type);
    
    public abstract boolean spawnEntity(World world, @Nullable BlockPos pos, VehicleData data);

}