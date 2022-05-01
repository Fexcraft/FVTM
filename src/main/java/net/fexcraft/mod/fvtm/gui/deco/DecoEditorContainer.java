package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DecoEditorContainer extends GenericContainer {
	
	protected Decoration entity;
	protected DecorationData selected;
	@SideOnly(Side.CLIENT)
	protected DecoEditor gui;

	public DecoEditorContainer(EntityPlayer player, World world, int entid){
		super(player);
		entity = (Decoration)world.getEntityByID(entid);
		if(Resources.DECORATION_CATEGORIES.isEmpty()){
			player.closeScreen();
			Print.chat(player, "error, no decorations installed");
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		String cargo = packet.getString("cargo");
		switch(cargo){
			case "add":{
				DecorationData deco = Resources.DECORATIONS.get(packet.getString("key"));
				entity.decos.add(deco.copy());
				if(side.isServer()) send(Side.CLIENT, packet);
				else{
					entity.decos.get(entity.decos.size() - 1).copy(deco);
					gui.updateEntries();
				}
				break;
			}
			case "rem":{
				entity.decos.remove(packet.getInteger("idx"));
				if(side.isServer()){
					send(Side.CLIENT, packet);
				}
				else{
					gui.updateEntries();
				}
			}
		}
	}

}
