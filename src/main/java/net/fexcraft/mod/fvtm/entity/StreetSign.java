package net.fexcraft.mod.fvtm.entity;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.STREETSIGN_ADJUSTER;

import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import net.fexcraft.lib.common.lang.BitList;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.StreetSignItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StreetSign extends Entity implements IEntityAdditionalSpawnData, IPacketReceiver<PacketEntityUpdate> {
	
    private boolean locked = false;
    public static final ResourceLocation[] textures = new ResourceLocation[]{
    	new ResourceLocation("fvtm:textures/entity/street_sign_0.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_1.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_2.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_3.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_4.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_5.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_6.png"),
    	new ResourceLocation("fvtm:textures/entity/street_sign_7.png")
    };
    //To Sync
    public EnumFacing facing;
    public String[] text = new String[]{ "", "", "", "" };
    public boolean[] sides = new boolean[]{ true, true, true, true };
    public boolean[] centered = new boolean[]{ true, true, true, true };
    public boolean[] panels = new boolean[]{ true, true, true, true };
    public Boolean[] arrows = new Boolean[]{ null, null, null, null, false, false };
    public byte texture = 0;
    //
    @SideOnly(Side.CLIENT)
	public net.fexcraft.mod.fvtm.model.block.StreetSignCachedModel model;

    public StreetSign(World world){
        super(world); stepHeight = 0; setSize(0.75f, 0.75f); locked = false;
        if(world.isRemote){
        	model = new net.fexcraft.mod.fvtm.model.block.StreetSignCachedModel();
        }
    }

    public StreetSign(World world, EnumFacing facing){
        this(world); this.facing = facing;
    }

    @Override
    public void writeSpawnData(ByteBuf buffer){
        buffer.writeByte(facing.getIndex());
        buffer.writeBoolean(locked);
        buffer.writeByte(texture);
        //
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(sides[i]);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(panels[i]);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeBoolean(centered[i]);
        }
        for(int i = 0; i < 6; i++){
        	buffer.writeByte(arrows[i] == null ? -1 : arrows[i] ? 1 : 0);
        }
        for(int i = 0; i < 4; i++){
        	buffer.writeInt(text[i].length());
        	buffer.writeCharSequence(text[i], StandardCharsets.UTF_8);
        }
    }

    @Override
    public void readSpawnData(ByteBuf buffer){
    	facing = EnumFacing.byIndex(buffer.readByte());
    	locked = buffer.readBoolean();
    	texture = buffer.readByte();
    	//
        for(int i = 0; i < 4; i++){
        	sides[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 4; i++){
        	panels[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 4; i++){
        	centered[i] = buffer.readBoolean();
        }
        for(int i = 0; i < 6; i++){
        	byte bit = buffer.readByte();
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        try{
            for(int i = 0; i < 4; i++){
            	text[i] = buffer.readCharSequence(buffer.readInt(), StandardCharsets.UTF_8).toString();
            }
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        //
        if(world.isRemote){
        	model.recollectModel(this);
        }
    }
	
    @Override
	public void processClientPacket(PacketEntityUpdate pkt){
		try{ this.read(pkt.nbt); } catch(Exception e){ e.printStackTrace(); }
	}

    public void read(NBTTagCompound compound){
        BitList list = new BitList(); list.set(compound.getInteger("bitlist"));
        for(int i = 0; i < 4; i++){
            sides[i] = list.get(i); panels[i] = list.get(i + 4);
            text[i] = compound.getString("text" + i);
            centered[i] = text[i].startsWith("!");
            if(centered[i] && text[i].startsWith("!")){
            	text[i] = text[i].substring(1, text[i].length());
            }
        }
        for(int i = 0; i < 6; i++){
        	byte bit = compound.getByte("arrow" + i);
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        texture = compound.getByte("texture");
        //
        //TODO eventually scan for nearby sign entities to match their sides and corners.
        //
        if(world.isRemote){
        	model.recollectModel(this);
        }
	}

	@Override
    protected void readEntityFromNBT(NBTTagCompound compound){
    	facing = EnumFacing.byIndex(compound.getByte("facing"));
        locked = compound.getBoolean("locked");
        texture = compound.getByte("texture");
        //
        BitList list = new BitList(); list.set(compound.getInteger("bitlist"));
        for(int i = 0; i < 4; i++){
            sides[i] = list.get(i); panels[i] = list.get(i + 4); centered[i] = list.get(i + 8);
            text[i] = compound.getString("text" + i);
        }
        for(int i = 0; i < 6; i++){
        	byte bit = compound.getByte("arrow" + i);
        	arrows[i] = bit < 0 ? null : bit > 0;
        }
        //
        if(world.isRemote){
        	model.recollectModel(this);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound){
    	compound.setByte("facing", (byte)facing.getIndex());
    	compound.setBoolean("locked", locked);
    	compound.setByte("texture", texture);
    	//
    	BitList list = new BitList(sides); list.integrate(panels, 4); list.integrate(centered, 8);
    	compound.setInteger("bitlist", list.toInt());
    	for(int i = 0; i < 6; i++){
    		compound.setByte("arrow" + i, (byte)(arrows[i] == null ? -1 : arrows[i] ? 1 : 0));
    		if(i < 4) compound.setString("text" + i, text[i]);
    	}
    }
    
	@Override
	public void setDead(){
		super.setDead();
		if(world.isRemote){
			model.delete();
		}
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
            /*if(this.isLocked()){
                this.unlock(world, player, stack, (KeyItem)stack.getItem());
            }
            else{
                this.lock(world, player, stack, (KeyItem)stack.getItem());
            }*/
            return true;
        }
        if(locked){
            Print.chat(player, "Sign is locked.");
            return true;
        }
        if(stack.isEmpty()){
        	player.openGui(FVTM.getInstance(), STREETSIGN_ADJUSTER, world, this.getEntityId(), 0, 0);
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
                Print.chat(damagesource.getImmediateSource(), "Sign is locked.");
                return true;
            }
        	ItemStack stack = this.getPickedResult(null);
            entityDropItem(stack, 0.5F); this.setDead();
        }
        return true;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target){
        return new ItemStack(StreetSignItem.INSTANCE);
    }

}
