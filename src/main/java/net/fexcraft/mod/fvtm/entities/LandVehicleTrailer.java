package net.fexcraft.mod.fvtm.entities;

import io.netty.buffer.ByteBuf;
import net.fexcraft.mod.addons.gep.attributes.InventoryAttribute;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Fuel.FuelItem;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.FvtmPermissions;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.VehicleAxes;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleControl;
import net.fexcraft.mod.fvtm.util.packets.PacketVehicleKeyPress;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketEntityUpdate;
import net.fexcraft.mod.lib.perms.PermManager;
import net.fexcraft.mod.lib.perms.player.PlayerPerms;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LandVehicleTrailer extends Entity implements VehicleEntity, IEntityAdditionalSpawnData, LockableObject, IPacketReceiver<PacketEntityUpdate> {
	
	public boolean sync = true;
	public int serverPositionTransitionTicker, parentid;
	public double serverPosX, serverPosY, serverPosZ;
	public double serverYaw, serverPitch, serverRoll;
	public VehicleData vehicledata;
	//public double throttle;
	public SeatEntity[] seats;
	public WheelEntity[] wheels;
	public float prevRotationRoll;
	public Vec3d angularVelocity = new Vec3d(0F, 0F, 0F);
	public VehicleAxes prevAxes, axes;
	private float yOffset;
	//
	public VehicleEntity parent;
	
	public LandVehicleTrailer(World world){
		super(world);
		axes = new VehicleAxes();
		prevAxes = new VehicleAxes();
		preventEntitySpawning = true;
		setSize(1F, 1F);
		yOffset = 6F / 16F;
		ignoreFrustumCheck = true;
		if(world.isRemote){
			setRenderDistanceWeight(200D);
		}
		//
		stepHeight = 1.0F;
	}
	
	private LandVehicleTrailer(World world, VehicleData data){
		this(world);
		vehicledata = data;
	}
	
	//From Item;
	public LandVehicleTrailer(World world, VehicleData data, VehicleEntity parent){
		this(world, data);
		stepHeight = 1.0F;
		Vec3d vec = parent.getAxes().getRelativeVector(parent.getVehicleData().getRearConnector().to16Double());
		setPosition(parent.getEntity().posX + vec.x, parent.getEntity().posY + vec.y, parent.getEntity().posZ + vec.z);
		this.parentid = parent.getEntity().getEntityId();
		this.axes = parent.getAxes().clone();
		initType(data, false);
		Print.debug("SPAWNING TRAILER");
	}

	@Override
	public void writeSpawnData(ByteBuf buffer){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("ParentId", this.parentid);
		ByteBufUtils.writeTag(buffer, axes.write(this, vehicledata.writeToNBT(nbt)));
	}

	@Override
	public void readSpawnData(ByteBuf buffer){
		try{
			NBTTagCompound compound = ByteBufUtils.readTag(buffer);
			vehicledata = Resources.getVehicleData(compound, world.isRemote);
			axes = VehicleAxes.read(this, compound);
			prevRotationYaw = axes.getYaw();
			prevRotationPitch = axes.getPitch();
			prevRotationRoll = axes.getRoll();
			this.parentid = compound.getInteger("ParentId");
			initType(vehicledata, true);
		}
		catch(Exception e){
			e.printStackTrace();
			Print.debug("Failed to receive additional spawn data for this trailer!");
		}
		
	}
	
	protected void initType(VehicleData type, boolean remote){
		seats = new SeatEntity[type.getSeats().size()];
		wheels = new WheelEntity[type.getWheelPos().size()];
		if(!remote){
			for(int i = 0; i < type.getSeats().size(); i++){
				world.spawnEntity(seats[i] = new SeatEntity(world, this, i));
			}
			for(int i = 0; i < type.getWheelPos().size(); i++){
				world.spawnEntity(wheels[i] = new WheelEntity(world, this, i));
			}
		}
		stepHeight = type.getVehicle().getFMWheelStepHeight();
		yOffset = 10F / 16F;//TODO check dis
		vehicledata.getScripts().forEach((script) -> script.onCreated(this, vehicledata));
		this.moveTrailer();
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag){
		tag = vehicledata.writeToNBT(tag);
		axes.write(this, tag);
		tag.setInteger("ParentId", parentid);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tag){
		if(vehicledata == null){
			vehicledata = Resources.getVehicleData(tag, world.isRemote);
		}
		else{
			vehicledata.readFromNBT(tag, world.isRemote);
		}
		prevRotationYaw = tag.getFloat("RotationYaw");
		prevRotationPitch = tag.getFloat("RotationPitch");
		prevRotationRoll = tag.getFloat("RotationRoll");
		axes = VehicleAxes.read(this, tag);
		parentid = tag.getInteger("ParentId");
		initType(vehicledata, false);
	}
	
	public boolean isSeatFree(int seat){
		return vehicledata.getSeats().size() >= seat && seats[seat].getControllingPassenger() == null;
	}
	
	@Override
	protected boolean canTriggerWalking(){
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entity){
		return entity.getEntityBoundingBox();
	}

	@Override
    public boolean canBePushed(){
        return false;
    }

	@Override
	public double getMountedYOffset(){
		return 0D;
	}
	
	@Override
    public double getYOffset(){
    	return yOffset;
    }
	
	@Override
	public void setDead(){
		if(Config.DROP_ITEMS_ON_BREAK && !world.isRemote){
			for(Part.PartData partData : this.vehicledata.getInventoryContainers()){
				InventoryAttribute.InventoryAttributeData invattr = partData.getAttributeData(InventoryAttribute.InventoryAttributeData.class);
				if(invattr == null){
					continue;
				}
				for(int i = 0; i < invattr.getInventory().size(); i++){
					this.entityDropItem(invattr.getInventory().get(i), 0.5f);
					invattr.getInventory().set(i, ItemStack.EMPTY);
				}
			}
		}
		//
		super.setDead();
		for(SeatEntity seat : seats){
			if(seat != null){
				seat.setDead();
			}
		}
		for(WheelEntity wheel : wheels){
			if(wheel != null){
				wheel.setDead();
			}
		}
		vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
		if(this.parent != null && parent instanceof LandVehicleEntity){
			((LandVehicleEntity)parent).trailer = null;
		}
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer){
		//
	}

	@Override
	public boolean canBeCollidedWith(){
		return !isDead;
	}
	
	@Override
	public void applyEntityCollision(Entity entity){
		if(!isPartOfThis(entity)){
			super.applyEntityCollision(entity);
		}
	}
	
	@Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport){
		if(ticksExisted > 1){
			return;
		}
		if(!this.parent.getEntity().getPassengers().isEmpty() && this.parent.getEntity().getControllingPassenger() instanceof EntityPlayer){
			//
		}
		else{				
			if(sync){
				serverPositionTransitionTicker = posRotationIncrements + 5;
			}
			else{
				double var10 = x - posX; double var12 = y - posY; double var14 = z - posZ;
				double var16 = var10 * var10 + var12 * var12 + var14 * var14;
				if (var16 <= 1.0D){
					return;
				}
				serverPositionTransitionTicker = 3;
			}
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
		}
	}
	
	public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, double avelx, double avely, double avelz, double throttle2, float steeringYaw){
		if(world.isRemote){
			serverPosX = x;
			serverPosY = y;
			serverPosZ = z;
			serverYaw = yaw;
			serverPitch = pitch;
			serverRoll = roll;
			serverPositionTransitionTicker = 5;
		}
		else{
			setPosition(x, y, z);
			prevRotationYaw = yaw;
			prevRotationPitch = pitch;
			prevRotationRoll = roll;
			setRotation(yaw, pitch, roll);
		}
		motionX = motX;
		motionY = motY;
		motionZ = motZ;
		angularVelocity = new Vec3d(avelx, avely, avelz);
		//throttle = throttle2;
		//wheelsYaw = steeringYaw;
	}
	

	@Override
	public void setVelocity(double d, double d1, double d2){
		motionX = d;
		motionY = d1;
		motionZ = d2;
	}
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
		if(isDead || world.isRemote){
			return false;
		}
		ItemStack stack = player.getHeldItem(hand);
		if(!stack.isEmpty() && stack.getItem() instanceof KeyItem && (stack.getItem() instanceof Material.MaterialItem ? ((Material.MaterialItem)stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
			if(this.isLocked()){
				this.unlock(world, player, stack, (KeyItem)stack.getItem());
			}
			else{
				this.lock(world, player, stack, (KeyItem)stack.getItem());
			}
			return true;
		}
		if(vehicledata.isLocked()){
			Print.chat(player, "Trailer is locked.");
			return true;
		}
		if(!stack.isEmpty()){
			if(stack.getItem() instanceof FuelItem){
				player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 1, 0, 0);//Inventory.
				return true;
			}
			if(stack.getItem() instanceof VehicleItem){
				if(this.vehicledata.getRearConnector() != null && this.getEntityAtRear() == null && ((VehicleItem)stack.getItem()).getVehicle(stack).getVehicle().isTrailerOrWagon()){
					/*Print.chat(player, "Connecting...");
					LandVehicleTrailer trailer = new LandVehicleTrailer(world, ((VehicleItem)stack.getItem()).getVehicle(stack), this);
					world.spawnEntity(trailer);
					stack.shrink(1);*/
					//TODO
					return true;
				}
			}
		}
		//TODO Item interaction
		for(int i = 0; i <= vehicledata.getSeats().size(); i++){
			if(seats[i] != null && seats[i].processInitialInteract(player, hand)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean onKeyPress(int key, int seat, EntityPlayer player){
		//Print.debug("T: " + key + " " + seat + " " + player.getName() + " [" + Time.getDate() + "];");
		try{
			if(world.isRemote && key >= 6){
				PacketHandler.getInstance().sendToServer(new PacketVehicleKeyPress(key));
				return true;
			}
			switch(key){
				case 6:{//Exit
					player.dismountRidingEntity();
			  		return true;
				}
				case 7:{//Inventory
					if(!world.isRemote){
						player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 0, 0, 0);
						//open inventory
					}
					return true;
				}
				case 11:{
					if(!world.isRemote){
						player.openGui(FVTM.getInstance(), GuiHandler.VEHICLE_INVENTORY, world, 5, seat, 0);
						//open scripts gui
					}
				}
			}
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
	@Override
    public void onUpdate(){
        super.onUpdate();
        if(parent == null){
        	try{
            	parent = (VehicleEntity)world.getEntityByID(parentid);
        		((LandVehicleEntity)parent).trailer = this;//TODO
        		//
        		this.posX = parent.getEntity().posX;
        		this.posY = parent.getEntity().posY;
        		this.posZ = parent.getEntity().posZ;
        		Print.debug("Found vehicle. ");
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
        if(!world.isRemote && /*ticksExisted > 200 && */ (parent == null || this.getPositionVector().squareDistanceTo(parent.getEntity().getPositionVector()) > 256)){
        	Print.debug("Vehicle which this trailer was connected to not found.");
    		vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
			ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
			entityDropItem(stack, 0.5F);
	 		setDead();
        	return;
        }
        //
        if(!world.isRemote){
        	for(int i = 0; i < vehicledata.getSeats().size(); i++){
        		if(seats[i] == null || !seats[i].addedToChunk){
    				world.spawnEntity(seats[i] = new SeatEntity(world, this, i));
        		}
        	}
        	for(int i = 0; i < vehicledata.getWheelPos().size(); i++){
        		if(wheels[i] == null || !wheels[i].addedToChunk){
    				world.spawnEntity(wheels[i] = new WheelEntity(world, this, i));
        		}
        	}
        }
        //
		prevRotationYaw = axes.getYaw();
		prevRotationPitch = axes.getPitch();
		prevRotationRoll = axes.getRoll();		
		prevAxes = axes.clone();
		this.ticksExisted++;
		//
		boolean drivenByPlayer = world.isRemote && parent.getSeats()[0] != null && parent.getSeats()[0].getControllingPassenger() instanceof EntityPlayer;
		//
		for(WheelEntity wheel : wheels){
			if(wheel != null && world != null){
				wheel.prevPosX = wheel.posX;
				wheel.prevPosY = wheel.posY;
				wheel.prevPosZ = wheel.prevPosZ;
			}
		}
		//
		if(wheels.length == 2 && world.isRemote /*&& ticksExisted % 100 == 0*/){
			if(!(wheels[0] == null || wheels[1] == null)){
				//
			}
			else{
				Print.debug("Wheels are null!");
			}
		}
		else if(wheels.length == 4){
			//4 Wheeled Trailer
			//TODO
		}
		checkForCollisions();
		for(SeatEntity seat : seats){
			if(seat != null){
				seat.updatePosition();
			}
		}
		if(drivenByPlayer){
			PacketHandler.getInstance().sendToServer(new PacketVehicleControl(this));
			serverPosX = posX;
			serverPosY = posY;
			serverPosZ = posZ;
			serverYaw = axes.getYaw();
		}
		if(!world.isRemote && ticksExisted % 5 == 0){
			PacketHandler.getInstance().sendToAllAround(new PacketVehicleControl(this), Resources.getTargetPoint(this));
		}
		vehicledata.getScripts().forEach((script) -> script.onUpdate(this, vehicledata));
	}
	
	private final void alignWheels(){
		for(int i = 0; i < wheels.length; i++){
			if(wheels[i] == null){ continue; }
			WheelEntity wheel = wheels[i];
			onGround = true;
			wheel.onGround = true;
			wheel.rotationYaw = axes.getYaw();
			//
			Vec3d targetpos = axes.getRelativeVector(vehicledata.getWheelPos().get(i).to16Double());
			Vec3d current = new Vec3d(wheel.posX - posX, wheel.posY - posY, wheel.posZ - posZ);
			Vec3d despos = new Vec3d(targetpos.x - current.x, targetpos.y - current.y, targetpos.z - current.z).scale(vehicledata.getVehicle().getFMWheelSpringStrength());
			if(despos.lengthSquared() > 0.001F){
				wheel.move(MoverType.SELF, despos.x, (despos.y - (0.98F / 20F)), despos.z);
			}
			//
			if(wheel.getPositionVector().distanceTo(this.getPositionVector()) > 1024){
				wheel.posX = despos.x;
				wheel.posY = despos.y;
				wheel.posZ = despos.z;
			}
		}
	}
	
	@Override
	public void moveTrailer(){
		prevPosX = posX; prevPosY = posY; prevPosZ = posZ;
		if(parent == null || wheels.length > 2){
			//TODO add alternative code for 4 wheeled trailers
			return;
		}
		//
		Vec3d conn = parent.getAxes().getRelativeVector(parent.getVehicleData().getRearConnector().to16Double());
		this.setPosition(parent.getEntity().posX + conn.x, parent.getEntity().posY + conn.y, parent.getEntity().posZ + conn.z);
		//
		alignWheels();
		//
		//Vec3d axle = new Vec3d((wheels[0].posX + wheels[1].posX) * 0.5, (wheels[0].posY + wheels[1].posY) * 0.5, (wheels[0].posZ + wheels[1].posZ) * 0.5);
		//double grr = Math.atan2(conn.z - axle.z, conn.x - axle.x);
		//double yaw = axes.getYaw(), grs = grr;
		//axes.setAngles((grr = (float)(grr * 180 / Math.PI)) > Static.rad1 || grr < -Static.rad1 ? grr : 0, 0, 0);
		//Print.debug(yaw, grs, axes.getYaw(), grr);
		//
		//
		Vec3d front = new Vec3d((parent.getWheels()[0].posX + parent.getWheels()[1].posX) / 2F, (parent.getWheels()[0].posY + parent.getWheels()[1].posY) / 2F, (parent.getWheels()[0].posZ + parent.getWheels()[1].posZ) / 2F);
		Vec3d back  = new Vec3d((wheels[0].posX + wheels[1].posX) / 2F, (wheels[0].posY + wheels[1].posY) / 2F, (wheels[0].posZ + wheels[1].posZ) / 2F);
		Vec3d left = new Vec3d((wheels[0].posX + parent.getWheels()[0].posX) / 2F, (wheels[0].posY + parent.getWheels()[0].posY) / 2F, (wheels[0].posZ + parent.getWheels()[0].posZ) / 2F);
		Vec3d right = new Vec3d((wheels[1].posX + parent.getWheels()[1].posX) / 2F, (wheels[1].posY + parent.getWheels()[1].posY) / 2F, (wheels[1].posZ + parent.getWheels()[1].posZ) / 2F);
		//
		double dx = front.x - back.x, dy = front.y - back.y, dz = front.z - back.z;
		double drx = left.x - right.x, dry = left.y - right.y, drz = left.z - right.z;
		double dxz = Math.sqrt(dx * dx + dz * dz);
		double drxz = Math.sqrt(drx * drx + drz * drz);
		//
		double yaw = Math.atan2(dz, dx);
		double pitch = -Math.atan2(dy, dxz);
		double roll = 0F;
		roll = -(float)Math.atan2(dry, drxz);
		//
		if(vehicledata.getVehicle().getDriveType().hasTracks()){
			yaw = (float)Math.atan2(wheels[3].posZ - wheels[2].posZ, wheels[3].posX - wheels[2].posX) + (float)Math.PI / 2F;
		}
		//Print.debug(axes.getYaw(), axes.getRadianYaw());
		double thrt = parent.getThrottle() > 0 ? parent.getThrottle() : -parent.getThrottle();
		double rawy = Math.toDegrees(yaw) - axes.getYaw();
		double diff = rawy * thrt * 0.2;
		diff = rawy > 0 ? diff > rawy ? rawy : diff : diff < rawy ? rawy : diff;
		axes.setRotation(axes.getRadianYaw() + Math.toRadians(diff), pitch, roll);
		//Print.debug(axes.getYaw(), axes.getRadianYaw());
		//alignWheels();
	}
	
	public boolean attackEntityFrom(DamageSource damagesource, float i){
		if(world.isRemote || isDead){
			return true;
		}
		if(damagesource.damageType.equals("player") && damagesource.getImmediateSource().onGround && (seats.length == 0 || seats[0] == null || seats[0].getControllingPassenger() == null)){
			if(vehicledata.isLocked()){
				Print.chat(damagesource.getImmediateSource(), "Vehicle is locked. Unlock to remove it.");
				return false;
			}
			else{
				PlayerPerms pp = PermManager.getPlayerPerms((EntityPlayer)damagesource.getImmediateSource());
				vehicledata.getScripts().forEach((script) -> script.onRemove(this, vehicledata));
				ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
				boolean brk = pp.hasPermission(FvtmPermissions.LAND_VEHICLE_BREAK) ? pp.hasPermission(FvtmPermissions.permBreak(stack)) : false;
				if(brk){
					entityDropItem(stack, 0.5F);
			 		setDead();
			 		Print.debug(stack.toString());
			 		return true;
				}
				else{
					Print.chat(damagesource.getImmediateSource(), "No permission to break this vehicle/type.");
			 		Print.debug(stack.toString());
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isLocked(){
		return vehicledata.isLocked();
	}

	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		if(!stack.hasTagCompound()){
			Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
			return false;
		}
		else{
			switch(item.getType(stack)){
				case PRIVATE:
					if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
						Print.chat(entity, "This key can only be used by the Owner;");
						return false;
					}
					else{
						if(item.getCode(stack).equals(vehicledata.getLockCode())){
							vehicledata.setLocked(false);
							Print.chat(entity, "Vehicle is now unlocked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					}
				case COMMON:
					if(item.getCode(stack).equals(vehicledata.getLockCode())){
						vehicledata.setLocked(false);
						Print.chat(entity, "Vehicle is now unlocked.");
						return true;
					}
					else{
						Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
						return false;
					}
				case ADMIN:
					vehicledata.setLocked(false);
					Print.chat(entity, "[SU] Vehicle is now unlocked.");
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item) {
		if(!vehicledata.allowsLocking()){
			Print.chat(entity, "This vehicle doesn't allow locking.");
			return false;
		}
		else{
			if(!stack.hasTagCompound()){
				Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
				return false;
			}
			else{
				switch(item.getType(stack)){
					case PRIVATE:
						if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
							Print.chat(entity, "This key can only be used by the Owner;");
							return false;
						}
						else{
							if(item.getCode(stack).equals(vehicledata.getLockCode())){
								vehicledata.setLocked(true);
								Print.chat(entity, "Vehicle is now locked.");
								return true;
							}
							else{
								Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
								return false;
							}
						}
					case COMMON:
						if(item.getCode(stack).equals(vehicledata.getLockCode())){
							vehicledata.setLocked(true);
							Print.chat(entity, "Vehicle is now locked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + vehicledata.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					case ADMIN:
						vehicledata.setLocked(true);
						Print.chat(entity, "[SU] Vehicle is now locked.");
						return true;
				}
			}
		}
		return false;
	}

	@Override
    public void fall(float distance, float damageMultiplier){
		//
	}
		
	public void checkForCollisions(){
		return;
	}
	
	public Vec3d rotate(Vec3d inVec){
		return axes.getRelativeVector(inVec);
	}
	
	public void rotateYaw(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F){
			return;
		}
		axes.rotateYawD(rotateBy);
		updatePrevAngles();
	}
	
	public void rotatePitch(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F){
			return;
		}
		axes.rotatePitchD(rotateBy);
		updatePrevAngles();
	}

	public void rotateRoll(float rotateBy){
		if(Math.abs(rotateBy) < 0.01F)
			return;
		axes.rotateRollD(rotateBy);
		updatePrevAngles();
	}
		
	public void updatePrevAngles(){
		double yaw = axes.getYaw() - prevRotationYaw;
		if(yaw > 180){ prevRotationYaw += 360F; }
		if(yaw < -180){ prevRotationYaw -= 360F; }
		double pitch = axes.getPitch() - prevRotationPitch;
		if(pitch > 180){ prevRotationPitch += 360F; }
		if(pitch < -180){ prevRotationPitch -= 360F; }
		double roll = axes.getRoll() - prevRotationRoll;
		if(roll > 180){ prevRotationRoll += 360F; }
		if(roll < -180){ prevRotationRoll -= 360F; }
	}
	
	public void setRotation(float rotYaw, float rotPitch, float rotRoll){
		axes.setAngles(rotYaw, rotPitch, rotRoll);
	}
	
	public boolean isPartOfThis(Entity ent){
		/*for(SeatEntity seat : seats){
			if(seat == null){
				continue;
			}
			if(ent == seat || seats[0].getControllingPassenger() == ent){
				return true;
			}
		}*/
		return (ent instanceof VehicleEntity || ent instanceof SeatEntity || ent instanceof  WheelEntity);
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target){
		ItemStack stack = vehicledata.getVehicle().getItemStack(vehicledata);
		stack.setItemDamage(0);
		return stack;
	}
	
	public double get3DSpeed(){
		return Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
	}
	
	public double getHorizontalSpeed(){
		return Math.sqrt(motionX * motionX + motionZ * motionZ);
	}
	
	public float getPlayerRoll(){
		return axes.getRoll();
	}
	
	public float getPrevPlayerRoll() {
		return prevAxes.getRoll();
	}
	
	public float getCameraDistance(){
		return vehicledata.getVehicle().getFMCameraDistance();
	}
	
	@Override
	public String getName(){
		return vehicledata.getVehicle().getName();
	}
	
	@SideOnly(Side.CLIENT)
	public boolean showInventory(int seat){
		return true;
	}

	@Override
	public Entity getCamera(){
		return parent.getCamera();
	}

	public VehicleData getData(){
		return vehicledata;
	}
	
	@Override
	public void processServerPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("ScriptId")){
			for(VehicleScript script : vehicledata.getScripts()){
				if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
					script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
				}
			}
		}
		if(pkt.nbt.hasKey("task")){
			switch(pkt.nbt.getString("task")){
				//
			}
		}
	}
	
	@Override
	public void processClientPacket(PacketEntityUpdate pkt){
		if(pkt.nbt.hasKey("ScriptId")){
			for(VehicleScript script : vehicledata.getScripts()){
				if(script.getId().toString().equals(pkt.nbt.getString("ScriptId"))){
					script.onDataPacket(this, vehicledata, pkt.nbt, Side.SERVER);
				}
			}
		}
		if(pkt.nbt.hasKey("task")){
			switch(pkt.nbt.getString("task")){
				case "update_vehicledata":{
					this.vehicledata.readFromNBT(pkt.nbt, world.isRemote);
					break;
				}
			}
		}
	}

	@Override
	public VehicleData getVehicleData(){
		return this.vehicledata;
	}

	@Override
	public VehicleType getVehicleType(){
		return VehicleType.LAND;
	}

	@Override
	public Entity getEntity(){
		return this;
	}

	@Override
	public VehicleAxes getAxes(){
		return this.axes;
	}

	@Override
	public WheelEntity[] getWheels(){
		return wheels;
	}

	@Override
	public SeatEntity[] getSeats(){
		return seats;
	}

	@Override
	public double getThrottle(){
		return parent.getThrottle();
	}

	@Override
	public VehicleEntity getEntityAtFront(){
		return parent;
	}

	@Override
	public VehicleEntity getEntityAtRear(){
		return null;
	}

	@Override
	public Vec3d getAngularVelocity(){
		return this.angularVelocity;
	}

	@Override
	public float getWheelsYaw(){
		return this.parent.getWheelsYaw();
	}

	@Override
	public float getWheelsAngle(){
		return this.parent.getWheelsAngle();
	}
	
}