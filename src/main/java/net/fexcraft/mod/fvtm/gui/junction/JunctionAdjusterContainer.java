package net.fexcraft.mod.fvtm.gui.junction;

import java.util.Collections;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.JunctionType;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class JunctionAdjusterContainer extends GenericContainer {
	
	protected GenericGui<JunctionAdjusterContainer> gui;
	protected Junction junction;
	
	public JunctionAdjusterContainer(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(player); junction = player.world.getCapability(Capabilities.RAILSYSTEM, null).getJunction(new Vec316f(compound));
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(junction == null){ Print.chat(player, "Error, Junction is null."); return; }
		if(packet.hasKey("type")){
			int type = packet.getByte("type");
			if(type < 2){
				Print.chat(player, "Type `" + type + "` cannot be set manually."); return;
			}
			if(junction.size() != 4){
				Print.chat(player, "Type `" + type + "` not applicable to a junction bellow 4 tracks."); return;
			}
			junction.type = type == 2 ? JunctionType.FORK_3 : type == 3 ? JunctionType.CROSSING
				: type == 4 ? JunctionType.DOUBLE : JunctionType.byTracksAmount(junction.size());
			junction.updateClient(); Print.chat(player, "&a&lJunction Type Updated.");
		}
		else if(packet.hasKey("del")){
			int del = packet.getByte("del");
			if(del < 0 || del >= junction.size()) return;
			Print.debug("delpack: " + packet);
			junction.remove(del, true); return;
		}
		else if(packet.hasKey("dw")){
			int dw = packet.getByte("dw");
			if(dw < 0 || dw >= junction.size()) return;
			Collections.swap(junction.tracks, dw, dw + 1);
			junction.updateClient(); return;
		}
		else if(packet.hasKey("up")){
			int up = packet.getByte("up");
			if(up < 0 || up >= junction.size()) return;
			Collections.swap(junction.tracks, up, up - 1);
			junction.updateClient(); return;
		}
		else if(packet.hasKey("station")){
			String station = packet.getString("station");
			if(station.equals("null") || station.equals("no station")){
				junction.station = null;
			} else junction.station = station;
			junction.updateClient(); return;
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
