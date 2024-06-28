package net.fexcraft.mod.fvtm.entity;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

import java.util.ArrayList;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class Decoration extends Entity implements IEntityAdditionalSpawnData {
	
	public ArrayList<DecorationData> decos = new ArrayList<>();
	private boolean locked;
	private int size = 4;

    public Decoration(World world){
        super(world);
        stepHeight = 0;
        setSize(size * sixteenth, size * sixteenth);
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
    	try{
    		buffer.writeBoolean(locked);
    		buffer.writeInt(size);
    		buffer.writeInt(decos.size());
    		for(DecorationData deco : decos){
    			ByteBufUtils.writeTag(buffer, deco.write().local());
    		}
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	try{
    		locked = buffer.readBoolean();
        	size = buffer.readInt();
        	decos.clear();
        	int amount = buffer.readInt();
        	for(int i = 0; i < amount; i++){
        		decos.add(new DecorationData(new TagCWI(ByteBufUtils.readTag(buffer)), world.isRemote));
        	}
        	checksize();
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
    }

	@Override
	public void readEntityFromNBT(NBTTagCompound compound){
        size = compound.getInteger("size");
        decos.clear();
        if(compound.hasKey("decorations")){
        	NBTTagList list = (NBTTagList)compound.getTag("decorations");
        	for(int i = 0; i < list.tagCount(); i++) decos.add(new DecorationData(new TagCWI(list.getCompoundTagAt(i)), world.isRemote));
        }
        checksize();
    }

    private void checksize(){
        for(DecorationData data : decos){
        	if(data.size > size){
        		size = data.size;
        		setSize(size * sixteenth, size * sixteenth);
        	}
        }
	}

	@Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setInteger("size", size);
    	NBTTagList list = new NBTTagList();
    	for(DecorationData deco : decos) list.appendTag(deco.write().local());
    	if(list.tagCount() > 0) compound.setTag("decorations", list);
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
    	//
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
        return !isDead;
    }

    @Override
    public void applyEntityCollision(Entity entity){
        return;
    }
    
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand){
        if(isDead || world.isRemote || hand == EnumHand.OFF_HAND){
            return false;
        }
        ItemStack stack = player.getHeldItem(hand);
        if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem ){//TODO && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
            locked = !locked;
            Print.chat(player, "Toggled sign status.");
            return true;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty() || stack.getItem() instanceof DecorationItem){
        	player.openGui(FVTM.getInstance(), UIKeys.ID12_DECORATION_EDITOR, world, getEntityId(), 0, 0);
        	return true;
        }
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float i){
        if(world.isRemote || isDead){
            return true;
        }
        if(damagesource.damageType.equals("player")){
            if(locked){
                Print.chat(damagesource.getImmediateSource(), "Deco is locked.");
                return true;
            }
        	ItemStack stack = this.getPickedResult(null);
            entityDropItem(stack, 0.5F);
            setDead();
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return new ItemStack(DecorationItem.INSTANCE);
    }

	public void updateClient(){
		NBTTagCompound com = new NBTTagCompound();
		writeEntityToNBT(com);
		com.setString("task", "deco_update");
		com.setInteger("entid", getEntityId());
		com.setString("target_listener", UTIL_LISTENER);
		PacketHandler.getInstance().sendToAllTracking(new PacketNBTTagCompound(com), this);
	}

}
