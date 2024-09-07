package net.fexcraft.mod.fvtm.entity;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class RailTestEntity extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {
	
	public Track current;
	public float passed;
	private float speed = 0.01f;

    public RailTestEntity(World world){
        super(world); stepHeight = 0; setSize(0.125f, 0.125f);
    }

    public RailTestEntity(World world, Track start){
        this(world); current = start;
        this.setPosition(start.start.vec.x, start.start.vec.y, start.start.vec.z);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	buffer.writeDouble(posX); buffer.writeDouble(posY); buffer.writeDouble(posZ);
        if(current != null) ByteBufUtils.writeTag(buffer, current.getId().write(TagCW.create()).local());
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	setPosition(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
    	if(buffer.isReadable()){
    		current = SystemManager.get(Systems.RAIL, world, RailSystem.class).getTrack(new PathKey(TagCW.wrap(ByteBufUtils.readTag(buffer))));
    	}
    	Print.debug(current, posX, posY, posZ);
    }
	
    @Override
	public void processClientPacket(PacketEntityUpdate pkt){
    	NBTTagCompound compound = pkt.nbt;
    	this.setPosition(compound.getDouble("x"), compound.getDouble("y"), compound.getDouble("z"));
    	this.passed = compound.getFloat("passed");
    	if(compound.hasKey("id")){ current.read(TagCW.wrap(compound)); }
    	if(compound.hasKey("reset")){ current = null; }
	}

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	if(current != null) compound.setTag("Current", current.write(null).local());
    	compound.setFloat("Passed", passed);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	if(current != null) compound.setTag("Current", current.write(null).local());
    	passed = compound.getFloat("Passed");
    }
    
	@Override
	public void setDead(){
		super.setDead();
	}

    @Override
    public void fall(float k, float l){
        //
    }

    @Override
    protected void entityInit(){
        //
    }

    @Override
    public void onUpdate(){
    	//Print.debug(this.getPositionVector());
    	if(current != null){
        	if(world.isRemote) return;
    		passed += speed;
    		if(passed >= current.length){
    			Junction junc = SystemManager.get(Systems.RAIL, world, RailSystem.class).getJunction(current.end);
    			if(junc == null){
    				current = current.createOppositeCopy(); Print.debug(this, "No junction, returning.");
    			}
    			else{
    				current = junc.getNext(null, current.getId(), false); Print.debug(this, "Junction found, passing on new track.");
    			}
    			passed = 0;
    		}
    		else{
				V3D vec = current.getVectorPosition(passed, false);
    			setPosition(vec.x, vec.y, vec.z);
    		}
    	}
    	else{
    		world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, posX, posY, posZ, 0, 0, 0);
    		world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, posX, posY + 0.2, posZ, 0, 0, 0);
    		world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, posX, posY + 0.4, posZ, 0, 0, 0);
    		world.spawnParticle(EnumParticleTypes.WATER_DROP, posX, posY + 0.6, posZ, 0, 0, 0);
    		this.setDead();
    	}
    	if(!world.isRemote){
    		NBTTagCompound compound = new NBTTagCompound();
    		compound.setDouble("x", posX); compound.setDouble("y", posY);
    		compound.setDouble("z", posZ); compound.setFloat("passed", passed);
    		if(current != null) current.write(TagCW.wrap(compound)); else compound.setBoolean("reset", true);
    		ApiUtil.sendEntityUpdatePacketToAllAround(this, compound);
    	}
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int pri, boolean teleport){
        //super.setPositionAndRotationDirect(x, y, z, yaw, pitch, pri, teleport);
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    @Override
    public boolean canBeCollidedWith(){
        return !isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
    	if(hand == EnumHand.OFF_HAND) return false; speed *= 2; Print.chat(player, "&e&oSpeed Increased (x2)."); return true;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){ return true; }
        if(damagesource.damageType.equals("player")){ this.setDead(); }
        return true;
    }

}
