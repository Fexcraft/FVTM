package net.fexcraft.mod.fvtm.gui.deco;

import static net.fexcraft.mod.fvtm.FvtmRegistry.DECORATION_CATEGORIES;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.DecorationData;
import net.fexcraft.mod.fvtm.entity.Decoration;
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
		if(DECORATION_CATEGORIES.isEmpty()){
			player.closeScreen();
			Print.chat(player, "error, no decorations installed");
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		String cargo = packet.getString("cargo");
		switch(cargo){
			case "tex":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				int sel = packet.getInteger("sel");
				if(sel >= 0 && sel < deco.textures.size()){
					deco.seltex = sel;
					if(side.isServer()) send(Side.CLIENT, packet);
					else{
						//gui.select(gui.selected, gui.selcol);
					}
				}
				break;
			}
			case "color":{
				DecorationData deco = entity.decos.get(packet.getInteger("idx"));
				deco.getColorChannel(packet.getString("channel")).packed = packet.getInteger("rgb");
				if(side.isServer()) send(Side.CLIENT, packet);
				else{
					//gui.select(gui.selected, gui.selcol);
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
