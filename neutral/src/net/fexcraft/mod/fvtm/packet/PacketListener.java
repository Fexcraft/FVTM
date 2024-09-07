package net.fexcraft.mod.fvtm.packet;

import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@FunctionalInterface
public interface PacketListener {

	public void handle(TagCW packet, Passenger player);

}
