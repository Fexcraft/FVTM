package net.fexcraft.mod.fvtm.gui.rail;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RailPlacerContainer extends GenericContainer {
	
	protected GenericGui<RailPlacerContainer> gui;
	private int itemslot, zoom;
	private RailSys system;
	
	public RailPlacerContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		itemslot = x; zoom = y;
		system = player.world.getCapability(Capabilities.RAILSYSTEM, null).get();
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(system == null){
			Print.chat(player, "Error, RailSysCap is null.");
			return;
		}
		switch(packet.getString("cargo")){
			case "place":{
				ItemStack stack = player.inventory.getStackInSlot(itemslot);
				Vec316f vec = new Vec316f(packet.getCompoundTag("end"));
				if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setTag("fvtm:railpoints", packet.getTag("points"));
				((RailGaugeItem)stack.getItem()).placeTrack(player, player.world, stack, system, vec, false);
				player.openGui(FVTM.getInstance(), GuiHandler.RAILPLACER, player.world, itemslot, zoom, 0);
				break;
			}
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
