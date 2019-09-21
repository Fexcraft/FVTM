package net.fexcraft.mod.fvtm.gui.junction;

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
		int type = packet.getByte("type");
		if(type < 2){
			Print.chat(player, "Type `" + type + "` cannot be set automatically."); return;
		}
		if(junction.size() != 4){
			Print.chat(player, "Type `" + type + "` not applicable to a junction bellow 4 tracks."); return;
		}
		junction.type = type == 2 ? JunctionType.FORK_3 : type == 3 ? JunctionType.CROSSING
			: type == 4 ? JunctionType.DOUBLE : JunctionType.byTracksAmount(junction.size());
		junction.updateClient(); Print.chat(player, "&a&lJunction Type Updated.");
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
