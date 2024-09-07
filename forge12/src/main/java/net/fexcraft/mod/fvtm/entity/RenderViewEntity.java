package net.fexcraft.mod.fvtm.entity;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class RenderViewEntity extends Entity implements IEntityAdditionalSpawnData {
	
    private UUID player_id;
    private EntityPlayer player;

    public RenderViewEntity(World world){
        super(world);
        stepHeight = 0;
        setSize(0.125f, 0.25f);
    }

    public RenderViewEntity(EntityPlayer player){
        this(player.world);
        this.player = player;
        this.player_id = player.getGameProfile().getId();
    	this.setPosition(player.posX, player.posY, player.posZ);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	buffer.writeLong(player_id.getMostSignificantBits());
    	buffer.writeLong(player_id.getLeastSignificantBits());
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	player_id = new UUID(buffer.readLong(), buffer.readLong());
    	player = world.getPlayerEntityByUUID(player_id);
    }

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	this.setDead();
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setUniqueId("player_id", player_id);
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
    	if(getPlayer() == null) return;
    	this.setPosition(getPlayer().posX, getPlayer().posY + 1, getPlayer().posZ);
    }

    @Override
    public void setPositionAndRotationDirect(double d, double d1, double d2, float f, float f1, int i, boolean b){
        //
    }

    @Override
    public boolean canBePushed(){
        return false;
    }

    @Override
    public boolean canBeCollidedWith(){
        return false;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        return false;
    }

	public EntityPlayer getPlayer(){
		return player;
	}
    
    /*@Override
    public ItemStack getPickedResult(RayTraceResult target){
    	ItemStack stack = new ItemStack(Items.SKULL, 1, 3);
    	stack.setTagCompound(new NBTTagCompound());
    	stack.getTagCompound().setString("SkullOwner", player.getGameProfile().getName());
        return stack;
    }*///can't be collided, can't be picked.

}
