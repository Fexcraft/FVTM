package net.fexcraft.mod.fvtm.util.function;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.block.generated.PlainBase;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.util.Properties;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.server.CommandSetBlock;

public class SetBlockFunction extends BlockFunction.StaticBlockFunction {

	private String nblock = "minecraft:stone";
	private float chance;
	private int meta, variant;
	private String state;

	@Override
	public BlockFunction parse(JsonMap map){
		if(map == null) return this;
		nblock = map.get("block").string_value();
		chance = map.getFloat("chance", 1f);
		if(chance > 1) chance = 1;
		if(chance < 0) chance = 0;
		meta = map.getInteger("meta", -1);
		variant = map.getInteger("variant", -1);
		state = map.getString("state", null);
		return this;
	}

	@Override
	public String id(){
		return "fvtm:set_block";
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, Passenger player, boolean main){
		if(!main || Static.random.nextFloat() < (1f - chance)) return false;
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
			world.setBlockState(pos, StateWrapper.of(stato), 2);
			return true;
		}
		return false;
	}

}
