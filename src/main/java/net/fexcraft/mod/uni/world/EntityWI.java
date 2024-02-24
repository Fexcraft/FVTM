package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.common.utils.Formatter;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.uni.UniReg;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWI extends Passenger {

	protected Entity entity;
	protected WorldW world;

	public EntityWI(Entity ent){
		entity = ent;
		world = WrapperHolder.getWorld(ent.world);
	}

	@Override
	public boolean isOnClient(){
		return entity.world.isRemote;
	}

	@Override
	public int getId(){
		return entity.getEntityId();
	}

	@Override
	public WorldW getWorld(){
		return world;
	}

	@Override
	public boolean isPlayer(){
		return entity instanceof EntityPlayer;
	}

	@Override
	public boolean isAnimal(){
		return entity instanceof EntityAnimal;
	}

	@Override
	public boolean isHostile(){
		return entity instanceof EntityMob;
	}

	@Override
	public boolean isLiving(){
		return entity instanceof EntityLiving;
	}

	@Override
	public boolean isRiding(){
		return entity.isRiding();
	}

	@Override
	public String getRegName(){
		EntityEntry entry = EntityRegistry.getEntry(entity.getClass());
		return entry == null ? "minecraft:null" : entry.getRegistryName().toString();
	}

	@Override
	public void decreaseXZMotion(double x){
		entity.motionX *= x;
		entity.motionZ *= x;
	}

	@Override
	public void setYawPitch(float oyaw, float opitch, float yaw, float pitch){
		entity.prevRotationYaw = oyaw;
		entity.prevRotationPitch = opitch;
		entity.rotationYaw = yaw;
		entity.rotationPitch = pitch;
	}

	@Override
	@Deprecated
	public void openUI(int ui, WorldW world, V3I pos){
		if(entity instanceof EntityPlayer == false) return;
		((EntityPlayer)entity).openGui(FVTM.getInstance(), ui, world.local(), pos.x, pos.y, pos.z);
	}

	@Override
	public void openUI(String id, V3I pos){
		if(entity instanceof EntityPlayer == false) return;
		((EntityPlayer)entity).openGui(FVTM.getInstance(), UniReg.getUIID(id), entity.world, pos.x, pos.y, pos.z);
	}

	@Override
	public String getName() {
		return entity.getName();
	}

	@Override
	public SeatInstance getSeatOn(){
		if(entity.getRidingEntity() instanceof RootVehicle == false) return null;
		return ((RootVehicle)entity.getRidingEntity()).getSeatOf(entity);
	}

	@Override
	public <E> E local(){
		return (E)entity;
	}

	@Override
	public Object direct(){
		return entity;
	}

	@Override
	public V3D getPos(){
		return new V3D(entity.posX, entity.posY, entity.posZ);
	}

	@Override
	public void send(String s){
		entity.sendMessage(new TextComponentString(Formatter.format(I18n.format(s))));
	}

	@Override
	public void bar(String s){
		if(entity instanceof EntityPlayer){
			((EntityPlayer)entity.getCommandSenderEntity()).sendStatusMessage(new TextComponentString(Formatter.format(I18n.format(s))), true);
		}
		else entity.sendMessage(new TextComponentString(Formatter.format(s)));
	}

	@Override
	public void dismount(){
		entity.dismountRidingEntity();
	}

}
