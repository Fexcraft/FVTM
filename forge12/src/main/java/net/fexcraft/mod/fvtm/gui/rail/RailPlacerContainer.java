package net.fexcraft.mod.fvtm.gui.rail;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RailPlacerContainer extends GenericContainer {
	
	/*protected GenericGui<RailPlacerContainer> gui;
	protected GuiCommandSender sender;
	private int itemslot, zoom;
	private RailSystem system;*/
	
	public RailPlacerContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		/*itemslot = x; zoom = y;
		system = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(player.world), RailSystem.class);
		sender = new GuiCommandSender(player);
		if(!player.world.isRemote && !Perms.RAIL_PLACER_GUI.has(player)) player.closeScreen();*/
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		//
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		/*if(system == null){
			Print.chat(player, "Error, RailSysCap is null.");
			return;
		}
		ItemStack stack = player.inventory.getStackInSlot(itemslot);
		RailGaugeItem item = (RailGaugeItem)stack.getItem();
		QV3D vec = new QV3D(TagCW.wrap(packet), "pos");
		switch(packet.getString("cargo")){
			case "place":{
				if(stack.getTagCompound() == null) stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setTag("fvtm:railpoints", packet.getTag("points"));
				item.placeTrack(player, player.world, stack, system, vec, sender, packet.getBoolean("noblocks"));
				reopen();
				break;
			}
			case "set_junc":{
				Junction junc = system.getJunction(vec.pos);
				if(junc != null){
					Print.chat(sender, "&eThere is already a Junction at that position.");
				}
				else{
					system.addJunction(vec);
					Print.chat(sender, "&2Junction created! " + vec.asIDString());
					reopen();
				}
				break;
			}
			case "del_junc":{
				Junction junc = system.getJunction(vec.pos);
				if(junc == null){
					Print.chat(sender, "&eThere is no a Junction at that position.");
				}
				else if(junc.tracks.size() > 0){
    				Print.chat(sender, "&bPlease remove all connected tracks first!");
				}
				else{
					system.delJunction(vec.pos);
					Print.chat(sender, "&eJunction removed! " + vec.asIDString());
					reopen();
				}
				break;
			}
		}*/
	}

    /*private void reopen(){
    	player.openGui(FVTM.getInstance(), GuiHandler.RAILPLACER, player.world, itemslot, zoom, 0);
	}*/

	@Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
