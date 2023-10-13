package net.fexcraft.mod.uni.world;

import net.fexcraft.lib.common.utils.Formatter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EntityWI extends EntityW {

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
	public void send(String s){
		entity.sendMessage(new TextComponentString(Formatter.format(s)));
	}

	@Override
	public void bar(String s){
		if(entity instanceof EntityPlayer){
			((EntityPlayer)entity.getCommandSenderEntity()).sendStatusMessage(new TextComponentString(Formatter.format(s)), true);
		}
		else entity.sendMessage(new TextComponentString(Formatter.format(s)));
	}

}
