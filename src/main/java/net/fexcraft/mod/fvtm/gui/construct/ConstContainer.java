package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstContainer extends GenericContainer implements ConstConInterface {
	
	protected ConstCommandSender sender;
	protected ConstructorEntity entity;
	public ConstGui gui;

	public ConstContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		this.entity = (ConstructorEntity)world.getTileEntity(new BlockPos(x, y, z));
		this.sender = new ConstCommandSender(this);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(side.isClient() && packet.hasKey("cargo") && packet.getString("cargo").equals("titletext")){
			Integer color = packet.hasKey("color") ? packet.getInteger("color") : null;
			this.gui.titletext.update(packet.getString("titletext"), color);
			this.gui.onTitleTextUpdate();
		}
		entity.processGUIPacket(side, packet, player, this);
	}

	public void setGUI(ConstGui congui){
		this.gui = congui;
	}
	
	/** To be used from server side. */
	public final void setTitleText(String string, RGB color){
		if(this.entity == null) return;
		if(this.entity.getWorld().isRemote){
			this.gui.texttitle = string;
			this.gui.titletext.update(string, color.packed);
			return;
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "titletext");
		if(color != null) compound.setInteger("color", color.packed);
		compound.setString("titletext", string);
		this.send(Side.CLIENT, compound);
	}

	public ConstructorEntity getTileEntity(){
		return entity;
	}

	public ConstCommandSender getCommandSender(){
		return sender;
	}

	public boolean noBlock(){
		return entity.getBlockData() == null;
	}

	public boolean noVehicle(){
		return entity.getVehicleData() == null;
	}

	public boolean noContainer(){
		return entity.getContainerData() == null;
	}

	public boolean hasBlock(){
		return entity.getBlockData() != null;
	}

	public boolean hasVehicle(){
		return entity.getVehicleData() != null;
	}

	public boolean hasContainer(){
		return entity.getContainerData() != null;
	}

	public boolean isEmpty(){
		return entity.getBlockData() == null && entity.getVehicleData() == null && entity.getContainerData() == null;
	}

}
