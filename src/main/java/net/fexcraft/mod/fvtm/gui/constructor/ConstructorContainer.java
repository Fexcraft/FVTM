package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.mod.fvtm.block.ConstructorEntity;
import net.fexcraft.mod.fvtm.gui.ConstructorCommandSender;
import net.fexcraft.mod.fvtm.gui.construct.ConstConInterface;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorContainer extends GenericContainer implements ConstConInterface {
	
	protected ConstructorCommandSender sender;
	protected ConstructorEntity entity;
	public ConstructorGui gui;

	public ConstructorContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		this.entity = (ConstructorEntity)world.getTileEntity(new BlockPos(x, y, z));
		this.sender = new ConstructorCommandSender(this);
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

	public void setGUI(ConstructorGui congui){
		this.gui = congui;
	}
	
	/** To be used from server side. */
	public final void setTitleText(String string, RGB color){
		setTitleText(string, color.packed);
	}
	
	/** To be used from server side. */
	public final void setTitleText(String string, Integer color){
		if(this.entity == null) return;
		if(this.entity.getWorld().isRemote){
			this.gui.texttitle = string;
			this.gui.titletext.update(string, color);
			return;
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "titletext");
		if(color != null) compound.setInteger("color", color);
		compound.setString("titletext", string);
		this.send(Side.CLIENT, compound);
	}

	public ConstructorEntity getTileEntity(){
		return entity;
	}

	public ICommandSender getCommandSender(){
		return sender;
	}

}
