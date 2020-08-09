package net.fexcraft.mod.fvtm.block;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedProperties {
	
	public static final IUnlistedProperty<BlockPos> POSITION = new IUnlistedProperty<BlockPos>(){

		@Override
		public String getName(){
			return "pos";
		}

		@Override
		public boolean isValid(BlockPos value){
			return value != null;
		}

		@Override
		public Class<BlockPos> getType(){
			return BlockPos.class;
		}

		@Override
		public String valueToString(BlockPos value){
			return Long.toHexString(value.toLong());
		}
		
	};

}
