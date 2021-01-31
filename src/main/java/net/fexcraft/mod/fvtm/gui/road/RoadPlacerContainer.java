package net.fexcraft.mod.fvtm.gui.road;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerContainer extends GenericContainer {
	
	protected GenericGui<RoadPlacerContainer> gui;
	protected GuiCommandSender sender;
	private int itemslot, zoom;
	
	public RoadPlacerContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		itemslot = x; zoom = y;
		sender = new GuiCommandSender(player);
		if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		ItemStack stack = player.inventory.getStackInSlot(itemslot);
		RoadToolItem item = (RoadToolItem)stack.getItem();
		Vec316f vec = new Vec316f(packet.getCompoundTag("pos"));
		switch(packet.getString("cargo")){
			case "place":{
				if(packet.getBoolean("noblocks") && !Perms.ROAD_PLACER_GUI_NOBLOCK.has(null)){
					Print.chat(sender, "&cNo permission to place blockless roads.");
					return;
				}
				if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setTag("fvtm:railpoints", packet.getTag("points"));
				item.placeRoad(player, player.world, stack, vec, sender, packet.getBoolean("noblocks"));
				reopen();
				break;
			}
			case "reset":{
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("fvtm:roadpoints")){
					stack.getTagCompound().removeTag("fvtm:roadpoints");
				}
				break;
			}
		}
	}

    private void reopen(){
    	player.openGui(FVTM.getInstance(), GuiHandler.ROADTOOL, player.world, itemslot, zoom, 0);
	}

	@Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
