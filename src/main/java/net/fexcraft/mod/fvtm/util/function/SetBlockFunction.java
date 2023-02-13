package net.fexcraft.mod.fvtm.util.function;

import com.google.gson.JsonObject;
import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.generated.BlockBase;
import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.util.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SetBlockFunction extends BlockFunction.StaticBlockFunction {

	private String nblock = Blocks.STONE.getRegistryName().toString();
	private float chance;
	private int meta, variant;

	public BlockFunction parse(JsonObject obj){
		if(obj == null) return this;
		nblock = obj.get("block").getAsString();
		chance = obj.has("chance") ? obj.get("chance").getAsFloat() : 1f;
		if(chance > 1) chance = 1;
		if(chance < 0) chance = 0;
		meta = obj.has("meta") ? obj.get("meta").getAsInt() : -1;
		variant = obj.has("variant") ? obj.get("variant").getAsInt() : -1;
		return this;
	}

	@Override
	public String id(){
		return "fvtm:set_block";
	}

	@Override
	public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(Static.random.nextFloat() < (1f - chance)) return false;
		Block block = Block.getBlockFromName(nblock);
		if(block != null){
			PlainBase base = (PlainBase)state.getBlock();
			IBlockState stato = block.getDefaultState();
			if(block instanceof PlainBase){
				if(base.type.getBlockType().getProperty() == ((PlainBase)block).type.getBlockType().getProperty()){
					if(base.type.getBlockType().getProperty() == Properties.FACING){
						stato = stato.withProperty(Properties.FACING, state.getValue(Properties.FACING));
					}
					if(base.type.getBlockType().getProperty() == Properties.ROTATION){
						stato = stato.withProperty(Properties.ROTATION, state.getValue(Properties.ROTATION));
					}
					if(base.type.getBlockType().getProperty() == Asphalt.HEIGHT){
						stato = stato.withProperty(Asphalt.HEIGHT, state.getValue(Asphalt.HEIGHT));
					}
				}
				if(variant >= 0 && base.type.getBlockType().isVariant()){
					stato = stato.withProperty(base.type.getBlockType().getIntProperty(), variant);
				}
			}
			else if(meta >= 0){
				stato = block.getStateFromMeta(meta);
			}
			world.setBlockState(pos, stato, 2);
			return true;
		}
		return false;
	}

}
