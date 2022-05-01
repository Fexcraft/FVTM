package net.fexcraft.mod.fvtm.gui.deco;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Pos;
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
					gui.select(-1);
				}
				break;
			}
			case "pos":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				Pos pos = null;
				switch(packet.getInteger("axis")){
					case 0: pos = new Pos(packet.getFloat("value"), deco.offset.y, deco.offset.z); break;
					case 1: pos = new Pos(deco.offset.x, packet.getFloat("value"), deco.offset.z); break;
					case 2: pos = new Pos(deco.offset.x, deco.offset.y, packet.getFloat("value")); break;
					default: return;
				}
				deco.offset = pos;
				if(side.isServer()) send(Side.CLIENT, packet);
				break;
			}
			case "rot":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				switch(packet.getInteger("axis")){
					case 0: deco.rotx = packet.getFloat("value"); break;
					case 1: deco.roty = packet.getFloat("value"); break;
					case 2: deco.rotz = packet.getFloat("value"); break;
					default: return;
				}
				if(side.isServer()) send(Side.CLIENT, packet);
				break;
			}
			case "scale":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				switch(packet.getInteger("axis")){
					case 0: deco.sclx = packet.getFloat("value"); break;
					case 1: deco.scly = packet.getFloat("value"); break;
					case 2: deco.sclz = packet.getFloat("value"); break;
					default: return;
				}
				if(side.isServer()) send(Side.CLIENT, packet);
				break;
			}
			case "tex":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				int sel = packet.getInteger("sel");
				if(sel >= 0 && sel < deco.textures.size()){
					deco.seltex = sel;
					if(side.isServer()) send(Side.CLIENT, packet);
					else{
						gui.select(gui.selected);
					}
				}
				break;
			}
		}
	}

	@Override
    public void onContainerClosed(EntityPlayer player){
        super.onContainerClosed(player);
        if(!player.world.isRemote && entity != null){
        	entity.updateClient();
        }
    }

}
