package net.fexcraft.mod.fvtm.entities;

import javax.annotation.Nullable;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;

public class GenericContainerEntity extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate>, Container.ContainerEntity {

    private int vehicleid, holderid;
    private String holder;
    private VehicleEntity vehicle;

    public GenericContainerEntity(World world){
        super(world);
        setSize(0.8F, 0.8F);
    }

    public GenericContainerEntity(World world, VehicleEntity veh, String holder, int i){
        this(world);
        vehicle = veh; vehicleid = veh.getEntity().getEntityId();
        setPosition(veh.getEntity().posX, veh.getEntity().posY, veh.getEntity().posZ);
        this.holder = holder; this.holderid = i;
        this.setRelPos();
        Print.debug(this, world.isRemote, holderid, holder, vehicle);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("holderid", holderid);
        compound.setString("holderpart", holder);
        compound.setInteger("vid", vehicleid = vehicle.getEntity().getEntityId());
        compound.setLong("pos", this.getPosition().toLong());
        ByteBufUtils.writeTag(buffer, compound);
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
        NBTTagCompound compound = ByteBufUtils.readTag(buffer);
        this.holderid = compound.getInteger("holderid");
        this.holder = compound.getString("holderpart");
        this.vehicleid = compound.getInteger("vid");
        this.vehicle = (VehicleEntity) world.getEntityByID(vehicleid);
        if(vehicle != null && vehicle.getContainers() != null){
            this.vehicle.getContainers().put(holder, this);
        }
        else{
            Print.debug("VEHICLE CONTAINER HOLDER NULL? ", holder, holderid, vehicle, vehicleid, world.getEntityByID(vehicleid));
            Print.debug(world.loadedEntityList);
            BlockPos pos = BlockPos.fromLong(compound.getLong("pos"));
            setPosition(pos.getX(), pos.getY(), pos.getZ());
            return;
        }
        this.setRelPos();
    }
    
    private Vec3d getRelPos(){
    	return new Vec3d(0, 1, 0);
    }
    
    private void setRelPos(){
        if(world.isRemote && vehicle == null){ rqSync(); return; }
        Print.debug(this, world.isRemote, "relpos");
        Vec3d relpos = vehicle.getAxes().getRelativeVector(getRelPos());
        setPosition(vehicle.getEntity().posX + relpos.x, vehicle.getEntity().posY + relpos.y, vehicle.getEntity().posZ + relpos.z);
        this.lastTickPosX = this.prevPosX = posX; this.lastTickPosY = this.prevPosY = posY; this.lastTickPosZ = this.prevPosZ = posZ;
    }

    @Nullable
    public VehicleEntity getVehicle(){
        return vehicle;
    }

    public void rqSync(){
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("request", "sync");
        ApiUtil.sendEntityUpdatePacketToServer(this, nbt);
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int partialticks, boolean b){
        super.setPositionAndRotationDirect(x, y, z, yaw, pitch, partialticks, b);//TODO check
    }

    @Override
    public void onUpdate(){
        super.onUpdate();
        this.setRelPos();
    }

    @Override
    public void updatePassenger(Entity passenger){
        super.updatePassenger(passenger);
    }

    public void processServerPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("request")){
            switch(pkt.nbt.getString("request")){
                case "sync": {
                    try{
                        NBTTagCompound nbt = new NBTTagCompound();
                        nbt.setString("task", "sync");
                        nbt.setInteger("holderid", holderid);
                        nbt.setString("holderpart", holder);
                        nbt.setLong("pos", this.getPosition().toLong());
                        nbt.setInteger("vid", vehicle.getEntity().getEntityId());
                        ApiUtil.sendEntityUpdatePacketToAllAround(this, nbt);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        //remove seat since it's apparently non existent or broken.
                    }
                    break;
                }
            }
        }
    }

    public void processClientPacket(PacketEntityUpdate pkt){
        if(pkt.nbt.hasKey("task")){
            switch(pkt.nbt.getString("task")){
                case "sync": {
                    this.holderid = pkt.nbt.getInteger("id");
                    this.holder = pkt.nbt.getString("holderpart");
                    this.vehicleid = pkt.nbt.getInteger("vid");
                    this.vehicle = (VehicleEntity) world.getEntityByID(vehicleid);
                    if(vehicle != null && vehicle.getContainers() != null){
                        vehicle.getContainers().put(holder, this);
                    }
                    else{
                        Print.debug("VEHICLE CONTAINER HOLDERS NULL? ", holder, holderid, vehicle, vehicleid, world.getEntityByID(vehicleid));
                        Print.debug(world.loadedEntityList);
                        BlockPos pos = BlockPos.fromLong(pkt.nbt.getLong("pos"));
                        setPosition(pos.getX(), pos.getY(), pos.getZ());
                        return;
                    }
                    //
                    this.setRelPos();
                    break;
                }
            }
        }
    }

    @Override
    public boolean canBeCollidedWith(){
        return !isDead;
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tags){
        //
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tags){
        //
    }

    @Override
    public boolean writeToNBTOptional(NBTTagCompound tags){
        return false;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity){
        return null;//entity.getEntityBoundingBox();
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

	@Override
	public ContainerData getContainerData(){
		if(vehicle == null || vehicle.getVehicleData().isLocked()){
			return null;
		}
		ContainerAttributeData condata = vehicle.getVehicleData().getPart(holder).getAttributeData(ContainerAttributeData.class);
		return condata == null ? null : holderid == 0 ? condata.main : condata.second;
	}

	@Override
	public void setContainerData(ContainerData data){
		if(vehicle == null || vehicle.getVehicleData().isLocked()){ return; }
		ContainerAttributeData condata = vehicle.getVehicleData().getPart(holder).getAttributeData(ContainerAttributeData.class);
		if(holderid == 0){
			condata.main = data;
		}
		else{
			condata.second = data;
		}
		if(!world.isRemote){ rqSync(); }
	}

	@Override
	public Entity getEntity(){
		return this;
	}

	@Override
	public ContainerType getContainerType(){
		if(vehicle == null || vehicle.getVehicleData().isLocked()){
			return null;
		}
		ContainerAttributeData condata = vehicle.getVehicleData().getPart(holder).getAttributeData(ContainerAttributeData.class);
		if(condata == null){
			return ContainerType.TINY;
		}
		switch(condata.getAttribute().getContainerType()){
			case LARGE:
				switch(this.holderid){
					case -1: return condata.getAttribute().getContainerType();
					case 0: case 1: return ContainerType.MEDIUM;
				}
				break;
			case MEDIUM: return ContainerType.MEDIUM;
			default: return ContainerType.TINY;
		}
		return ContainerType.TINY;
	}

    @Override
    public String getName(){
        return vehicle == null ? "Container Holder Entity" : vehicle.getVehicleData().getPart(holder).getPart().getName();
    }
    
    @Override
    public void setDead(){
    	Print.debug(this, holder, vehicle);
    	super.setDead();
    }

}
