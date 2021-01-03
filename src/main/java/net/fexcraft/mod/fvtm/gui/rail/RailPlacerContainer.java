package net.fexcraft.mod.fvtm.gui.rail;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;

public class RailPlacerContainer extends GenericContainer {
	
	protected GenericGui<RailPlacerContainer> gui;
	protected Junction junction;
	
	public RailPlacerContainer(EntityPlayer player, int x, int y, int z){
		super(player);
		initPacket(null);
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		if((compound = GuiHandler.validate(player, compound, player.world.isRemote)) == null) return;
		junction = player.world.getCapability(Capabilities.RAILSYSTEM, null).get().getJunction(new Vec316f(compound));
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(junction == null){ Print.chat(player, "Error, Junction is null."); return; }
		if(packet.hasKey("type")){
			//
		}
	}

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
}
