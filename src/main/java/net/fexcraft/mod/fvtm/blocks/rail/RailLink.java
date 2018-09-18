package net.fexcraft.mod.fvtm.blocks.rail;

import net.minecraft.util.math.BlockPos;

/** @author Ferdinand Calo' (FEX___96) **/
public class RailLink {
	
	public final BlockPos prev, self, next;
	
	public RailLink(BlockPos prev, BlockPos self, BlockPos next){
		this.prev = prev; this.self = self; this.next = next;
	}
	
}