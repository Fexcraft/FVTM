package net.fexcraft.mod.fvtm.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.compatibility.FMSeat;
import net.fexcraft.mod.fvtm.entities.SeatEntity;
import net.fexcraft.mod.fvtm.entities.WheelEntity;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleModel;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.math.Pos;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Vehicle extends IForgeRegistryEntry<Vehicle> {
	
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
	
	public List<ResourceLocation> getTextures();
	
	public List<Pos> getDefaultWheelPos();
	
	public RGB getDefPrimaryColor();
	
	public RGB getDefSecondaryolor();
	
	@SideOnly(Side.CLIENT)
	public VehicleModel<VehicleData> getModel();
	
	public Class<? extends VehicleData> getDataClass();
	
	public boolean canSpawnAs(String modid);

	public float getFMCameraDistance();//5f

	public float getFMWheelStepHeight();//1f

	public float getFMWheelSpringStrength();//0.5f

	public float getFMMaxNegativeThrottle();
	
	public float getFMMaxPositiveThrottle();

	public float getFMTurnLeftModifier();

	public float getFMTurnRightModifier();

	public DriveType getDriveType();
	
	public boolean canSpawnAs(EntityType type);
	
	public Collection<ResourceLocation> getSounds();
	
	public SoundEvent getSound(String event);

	public void setSound(ResourceLocation sound, SoundEvent soundevent);
	
	public int getFMSoundLength(String event);

	public boolean isTrailerOrWagon();
	
	//<-- VEHICLE DATA -->//
	public static interface VehicleData {
		
		public Vehicle getVehicle();
		
		public int getSelectedTexture();
		
		public void setSelectedTexture(int i);
		
		public ResourceLocation getCustomTexture();
		
		public void setCustomTexture(String string, boolean external);
		
		public boolean isTextureExternal();
		
		public ResourceLocation getTexture();
		
		public double getFuelTankContent();

		public boolean consumeFuel(double d);
		
		public int getFuelTankSize();
		
		public TreeMap<String, PartData> getParts();

		public PartData getPart(String string);
		
		public List<Pos> getWheelPos();
		
		public RGB getPrimaryColor();
		
		public RGB getSecondaryColor();
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public VehicleData readFromNBT(NBTTagCompound compound, boolean isRemote);
		
		public boolean readyToSpawn();

		public boolean doorsOpen();

		public void toggleDoors(@Nullable Boolean doors);

		public void installPart(String as, PartData data);
		
		public boolean isLocked();
		
		public boolean setLocked(@Nullable Boolean lock);

		public String getLockCode();
		
		public Collection<VehicleScript> getScripts();
		
		public <T extends VehicleScript> T getScript(Class<T> clazz);

		public int getSpawnedKeysAmount();

		public void setSpawnedKeysAmount(@Nullable Integer i);

		public List<FMSeat> getSeats();

		public default boolean allowsLocking(){
			return true;
		}

		public boolean isRemote();
		
		public int getMaxInventorySize();
		
		/** Prefferably don't edit stuff in this one, do any processing in the specific part attribute. */
		public NonNullList<ItemStack> getAllInventoryContents();

		public List<PartData> getInventoryContainers();
		
		@Nullable
		public Pos getFrontConnector();
		
		@Nullable
		public Pos getRearConnector();
		
	}
	
	//<-- VEHICLE ITEM -->//
	public static interface VehicleItem {
		
		public static final String NBTKEY = "FVTM:Vehicle";
		public static final String OLDNBTKEY = "FVTM:LandVehicle";
		
		public VehicleData getVehicle(ItemStack stack);
		
	}
	
	public static interface VehicleScript {
		
		public ResourceLocation getId();
		
		public boolean isOn(Side side);
		
		public NBTTagCompound writeToNBT(NBTTagCompound compound);
		
		public VehicleScript readFromNBT(NBTTagCompound compound, boolean isRemote);
		
		public void onDataPacket(Entity entity, VehicleData data, NBTTagCompound compound, Side side);

		public void onCreated(Entity entity, VehicleData data);

		public boolean onInteract(Entity entity, VehicleData data, EntityPlayer player);

		public void onUpdate(Entity entity, VehicleData data);

		public void onRemove(Entity entity, VehicleData data);
		
		public default void sendPacketToClient(Entity ent, EntityPlayerMP player, NBTTagCompound nbt){
			nbt.setString("ScriptId", getId().toString());
			PacketHandler.getInstance().sendTo(new PacketEntityUpdate(ent, nbt), player);
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

		public void setPositionRotationAndMotion(double posX, double posY, double posZ, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle, float steeringYaw);
		
		public VehicleEntity getEntityAtFront();
		
		public VehicleEntity getEntityAtRear();

		public Vec3d getAngularVelocity();

		public float getWheelsYaw();
		
	}
	
	//<-- VEHICLE  -->//
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

	public double getBuoyancy();
	
}