package net.fexcraft.mod.fvtm.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Container.ContainerEntity;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.fexcraft.mod.fvtm.api.root.SettingHolder;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.api.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.entities.WheelEntity;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.math.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Vehicle extends IForgeRegistryEntry<Vehicle>, TextureHolder, ColorHolder {

    public Addon getAddon();

    public String getName();

    public String[] getDescription();

    @Override
    public default Class<Vehicle> getRegistryType(){
        return Vehicle.class;
    }

    public VehicleType getType();

    public ItemStack getItemStack(@Nullable VehicleData data);

    public Map<String, ResourceLocation> getPreinstalledParts();

    public List<String> getRequiredParts();

    public float getYAxisConstructorOffset();

    public float getWheelConstructorOffset();

    public int getConstructionLength();

    public List<Pos> getDefaultWheelPos();

    @SideOnly(Side.CLIENT)
    public VehicleModel<VehicleData> getModel();

    public Class<? extends VehicleData> getDataClass();

    public boolean canSpawnAs(EntityType type);
    
    public float getFMAttribute(String attr);

    public DriveType getDriveType();

    public boolean isTrailerOrWagon();

    public ResourceLocation getDefaultKey();

    public TreeMap<String, Pos> getWheelPositions();

    public Collection<ResourceLocation> getSounds();

    public SoundEvent getSound(String event);

    public void setSoundEvent(SoundEvent soundevent);

    public float getSoundVolume(String event);

    public float getSoundPitch(String event);

    //<-- VEHICLE DATA -->//
    public static interface VehicleData extends Colorable, Lockable, Saveloadable<VehicleData>, Textureable {

        public Vehicle getVehicle();

        public double getFuelTankContent();

        public boolean consumeFuel(double d);

        public int getFuelTankSize();

        public TreeMap<String, PartData> getParts();

        public PartData getPart(String string);

        public List<Pos> getWheelPos();

        public boolean readyToSpawn();

        public boolean doorsOpen();

        public void toggleDoors(@Nullable Boolean doors);

        public void installPart(String as, PartData data);

        public Collection<VehicleScript> getScripts();

        public <T extends VehicleScript> T getScript(Class<T> clazz);

        public int getSpawnedKeysAmount();

        public void setSpawnedKeysAmount(@Nullable Integer i);

        public List<FMSeat> getSeats();

        public int getMaxInventorySize();

        /**
         * Preferably don't edit stuff in this one, do any processing in the
         * specific part attribute.
         */
        public NonNullList<ItemStack> getAllInventoryContents();

        public List<PartData> getInventoryContainers();

        public List<PartData> getContainerHolders();

        @Nullable
        public Pos getFrontConnector();

        @Nullable
        public Pos getRearConnector();

        /**
         * 0 = off 1 = on 2 = long (?) 3 = fog lights (?)
         */
        public int getLightsState();

        public void setLightsState(int i);

    }

    //<-- VEHICLE ITEM -->//
    public static interface VehicleItem {

        public static final String NBTKEY = "FVTM:Vehicle";
        public static final String OLDNBTKEY = "FVTM:LandVehicle";

        public VehicleData getVehicle(ItemStack stack);

    }

    public static interface VehicleScript extends Saveloadable<VehicleScript>, SettingHolder {

        public ResourceLocation getId();

        public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side);

        public void onCreated(Entity entity, VehicleData data);

        public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player, EnumHand hand);

        public void onUpdate(Entity entity, VehicleData data);

        public void onRemove(Entity entity, VehicleData data);

        public default void sendPacketToClient(Entity ent, EntityPlayer player, NBTTagCompound nbt){
            nbt.setString("ScriptId", getId().toString());
            PacketHandler.getInstance().sendTo(new PacketEntityUpdate(ent, nbt), (EntityPlayerMP) player);
        }

        public default void sendPacketToAll(Entity ent, NBTTagCompound nbt){
            nbt.setString("ScriptId", getId().toString());
            PacketHandler.getInstance().sendToAll(new PacketEntityUpdate(ent, nbt));
        }

        public default void sendPacketToAllAround(Entity ent, NBTTagCompound nbt){
            nbt.setString("ScriptId", getId().toString());
            PacketHandler.getInstance().sendToAllAround(new PacketEntityUpdate(ent, nbt), new TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, 256));
        }

        public default void sendPacketToServer(Entity ent, NBTTagCompound nbt){
            nbt.setString("ScriptId", getId().toString());
            PacketHandler.getInstance().sendToServer(new PacketEntityUpdate(ent, nbt));
        }

        public default void onKeyInput(int key, int seatid, VehicleEntity vehicle){
            return;
        }
        
        @Override
        public default String getSettingHolderId(){
        	return getId().toString();
        }

    }

    //<-- VEHICLE ENTITY -->//
    public static interface VehicleEntity {

        public VehicleData getVehicleData();

        public VehicleType getVehicleType();

        public Entity getEntity();

        public VehicleAxes getAxes();

        public WheelEntity[] getWheels();

        public SeatEntity[] getSeats();

        public boolean onKeyPress(int key, int seat, EntityPlayer player);

        public Entity getCamera();

        public double getThrottle();

        public void setThrottle(double newthr);

        public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw);

        public VehicleEntity getEntityAtFront();

        public VehicleEntity getEntityAtRear();

        public Vec3d getAngularVelocity();

        public float getWheelsAngle();

        public float getWheelsYaw();

        public default void syncVehicleData(){
            NBTTagCompound nbt = this.getVehicleData().writeToNBT(new NBTTagCompound());
            nbt.setString("task", "update_vehicledata");
            ApiUtil.sendEntityUpdatePacketToAllAround(this.getEntity(), nbt);
        }

        public default void moveTrailer(){
            //TO BE OVERRIDEN BY A TRAILER
        }

		public @Nullable TreeMap<String, ContainerEntity> getContainers();

    }

    //<-- VEHICLE TYPE -->//
    public static enum VehicleType {

        LAND, AIR, WATER, RAIL, NULL;

        VehicleType(){
            //
        }

        public static VehicleType fromString(String string){
            for(VehicleType type : values()){
                if(type.name().equalsIgnoreCase(string)){
                    return type;
                }
            }
            return LAND;
        }

        public static VehicleType fromJson(JsonObject obj){
            if(obj.has("VehicleType")){
                return fromString(obj.get("VehicleType").getAsString());
            }
            if(obj.has("Type")){
                return fromString(obj.get("Type").getAsString());
            }
            return LAND;
        }

        public boolean isLandVehicle(){
            return this == LAND;
        }

        public boolean isWaterVehicle(){
            return this == WATER;
        }

        public boolean isAirVehicle(){
            return this == AIR;
        }

        public boolean isRailVehicle(){
            return this == LAND;
        }

    }

}
