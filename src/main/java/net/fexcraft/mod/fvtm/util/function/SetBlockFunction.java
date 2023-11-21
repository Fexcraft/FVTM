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
import net.minecraft.command.server.CommandSetBlock;
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
	private String state;

	public BlockFunction parse(JsonObject obj){
		if(obj == null) return this;
		nblock = obj.get("block").getAsString();
		chance = obj.has("chance") ? obj.get("chance").getAsFloat() : 1f;
		if(chance > 1) chance = 1;
		if(chance < 0) chance = 0;
		meta = obj.has("meta") ? obj.get("meta").getAsInt() : -1;
		variant = obj.has("variant") ? obj.get("variant").getAsInt() : -1;
		state = obj.has("state") ? obj.get("state").getAsString() : null;
		return this;
	}

	@Override
	public String id(){
		return "fvtm:set_block";
	}

	@Override
	public boolean onClick(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(hand == EnumHand.OFF_HAND || Static.random.nextFloat() < (1f - chance)) return false;
		Block block = Block.getBlockFromName(nblock);
		if(block != null){
			PlainBase base = (PlainBase)state.getBlock();
			IBlockState stato = block.getDefaultState();
			if(block instanceof PlainBase){
				if(Properties.getProperty(base.type.getBlockType()) == Properties.getProperty(((PlainBase)block).type.getBlockType())){
					if(Properties.getProperty(base.type.getBlockType()) == Properties.FACING){
						stato = stato.withProperty(Properties.FACING, state.getValue(Properties.FACING));
					}
					if(Properties.getProperty(base.type.getBlockType()) == Properties.ROTATION){
						stato = stato.withProperty(Properties.ROTATION, state.getValue(Properties.ROTATION));
					}
					if(Properties.getProperty(base.type.getBlockType()) == Asphalt.HEIGHT){
						stato = stato.withProperty(Asphalt.HEIGHT, state.getValue(Asphalt.HEIGHT));
					}
				}
				if(variant >= 0 && base.type.getBlockType().isVariant()){
					stato = stato.withProperty(Properties.getIntProperty(base.type.getBlockType()), variant);
				}
			}
			else if(meta >= 0){
				stato = block.getStateFromMeta(meta);
			}
			else if(this.state != null){
				try {
					stato = CommandSetBlock.convertArgToBlockState(block, this.state);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			world.setBlockState(pos, stato, 2);
			return true;
		}
		return false;
	}

}
