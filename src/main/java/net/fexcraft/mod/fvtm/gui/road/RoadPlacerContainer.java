package net.fexcraft.mod.fvtm.gui.road;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.gui.GuiCommandSender;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.item.RoadToolItem;
import net.fexcraft.mod.fvtm.util.Perms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.relauncher.Side;

public class RoadPlacerContainer extends GenericContainer {
	
	protected GenericGui<RoadPlacerContainer> gui;
	protected GuiCommandSender sender;
	private int zoom;
	
	public RoadPlacerContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		zoom = y;
		sender = new GuiCommandSender(player);
		if(!Perms.ROAD_PLACER_GUI.has(player)) player.closeScreen();
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		ItemStack stack = player.getHeldItemMainhand();
		RoadToolItem item = (RoadToolItem)stack.getItem();
		switch(packet.getString("cargo")){
			case "place":{
				if(packet.getBoolean("noblocks") /*&& !Perms.ROAD_PLACER_GUI_NOBLOCK.has(null)*/){
					Print.chat(sender, "&cNo permission to place material-less roads.");
					return;
				}
				if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setTag("fvtm:roadpoints", packet.getTag("points"));
				item.placeRoad(player, player.world, stack, null, (NBTTagList)packet.getTag("points"), sender, packet.getBoolean("noblocks"));
				//reopen();
				player.closeScreen();
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

    @SuppressWarnings("unused")
	private void reopen(){
    	player.openGui(FVTM.getInstance(), GuiHandler.ROADTOOL, player.world, 0, zoom, 0);
	}

	@Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
