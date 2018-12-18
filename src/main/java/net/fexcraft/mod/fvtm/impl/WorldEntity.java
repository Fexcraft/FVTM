package net.fexcraft.mod.fvtm.impl;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WorldEntity extends Entity {

	public WorldEntity(World world){
		super(world);
	}

	@Override
	protected void entityInit(){
		//
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound){
		//
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound){
		//
	}
	
	private Vec3d temp;
	
	@Override
	public void onUpdate(){
		if(world.isRemote){
			temp = net.minecraft.client.Minecraft.getMinecraft().player.getPositionVector();
			this.posX = temp.x; this.posY = temp.y; this.posZ = temp.z;
			this.lastTickPosX = this.prevPosX = this.posX;
			this.lastTickPosY = this.prevPosY = this.posY;
			this.lastTickPosZ = this.prevPosZ = this.posZ;
		}
	}
	
}