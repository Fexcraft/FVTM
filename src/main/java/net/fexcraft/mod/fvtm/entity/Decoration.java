package net.fexcraft.mod.fvtm.entity;

import java.util.ArrayList;

import net.fexcraft.lib.common.utils.Print;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.item.DecorationItem;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;

public class Decoration extends Entity implements IEntityAdditionalSpawnData {
	
	public ArrayList<DecorationData> decos = new ArrayList<>();
	private boolean locked;
	private int size = 4;

    public Decoration(EntityType<Decoration> type, Level world){
        super(type, world);
        this.maxUpStep = 0;
        //TODO entity size setSize(size * sixteenth, size * sixteenth);
    }

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer){
    	try{
    		buffer.writeBoolean(locked);
    		buffer.writeInt(size);
    		buffer.writeInt(decos.size());
    		for(DecorationData deco : decos){
    			buffer.writeNbt(deco.write());
    		}
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void readSpawnData(FriendlyByteBuf buffer){
    	try{
    		locked = buffer.readBoolean();
        	size = buffer.readInt();
        	decos.clear();
        	int amount = buffer.readInt();
        	for(int i = 0; i < amount; i++){
        		decos.add(new DecorationData(buffer.readNbt(), level.isClientSide));
        	}
        	checksize();
    	}
    	catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void defineSynchedData(){
		//
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound){
        size = compound.getInt("size");
        decos.clear();
        if(compound.contains("decorations")){
        	ListTag list = (ListTag)compound.get("decorations");
        	for(int i = 0; i < list.size(); i++) decos.add(new DecorationData(list.getCompound(i), level.isClientSide));
        }
        checksize();
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound){
    	compound.putInt("size", size);
    	ListTag list = new ListTag();
    	for(DecorationData deco : decos) list.add(deco.write());
    	if(list.size() > 0) compound.put("decorations", list);
	}

	@Override
	public Packet<?> getAddEntityPacket(){
		//TODO packets
		return null;
	}

    private void checksize(){
        for(DecorationData data : decos){
        	if(data.size > size){
        		size = data.size;
        		//TODO entity size setSize(size * sixteenth, size * sixteenth);
        	}
        }
	}

    @Override
    public void tick(){
    	super.tick();
    }

    @Override
    public boolean canCollideWith(Entity ent){
        return false;
    }
    
    @Override
    public InteractionResult interact(Player player, InteractionHand hand){
        if(isRemoved() || level.isClientSide || hand == InteractionHand.OFF_HAND){
            return InteractionResult.PASS;
        }
        ItemStack stack = player.getItemInHand(hand);
        if(!stack.isEmpty() && stack.getItem() instanceof MaterialItem && ((MaterialItem)stack.getItem()).getType().isVehicleKey()){
            locked = !locked;
            Print.chat(player, "Toggled sign status.");
            return InteractionResult.SUCCESS;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return InteractionResult.SUCCESS;
        }
        if(stack.isEmpty() || stack.getItem() instanceof DecorationItem){
        	//TODO guis player.openGui(FVTM.getInstance(), DECORATION_EDITOR, world, getEntityId(), 0, 0);
        	return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    
    /*@Override
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
    }*///TODO find replacement
    
    @Override
    public ItemStack getPickedResult(HitResult target){
        return new ItemStack(DecorationItem.INSTANCE);
    }

	public void updateClient(){
		CompoundTag com = new CompoundTag();
		addAdditionalSaveData(com);
		com.putString("task", "deco_update");
		com.putInt("entid", getId());
		//com.setString("target_listener", Resources.UTIL_LISTENER);
		//PacketHandler.getInstance().sendToAllTracking(new PacketNBTTagCompound(com), this);
		//TODO packets
	}
    
	@Override
	public float getStepHeight(){
		return 0;
	}

}
