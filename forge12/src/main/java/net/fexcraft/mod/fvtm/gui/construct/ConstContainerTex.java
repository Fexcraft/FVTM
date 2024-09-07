package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ConstContainerTex extends ConstContainer {
	
	protected String part;
	protected boolean isinit;

	public ConstContainerTex(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		initPacket(null);
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		if((compound = GuiHandler.validate(player, compound, player.world.isRemote)) == null) return;
		if(compound.hasKey("category")) part = compound.getString("category");
		isinit = true;
	}

	@Override
	public boolean isInit(){
		return isinit;
	}

}
