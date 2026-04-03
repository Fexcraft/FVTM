package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.uni.tag.TagCW;

public interface SpawnPacketEntity {

	public void writeSpawnData(TagCW com);

	public void readSpawnData(TagCW com);

}
