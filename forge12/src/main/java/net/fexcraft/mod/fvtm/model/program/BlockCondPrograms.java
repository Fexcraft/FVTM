package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SignalTileEntity;
import net.fexcraft.mod.fvtm.block.generated.SwitchTileEntity;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.fvtm.block.generated.FvtmProperties;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

import static net.fexcraft.mod.fvtm.model.ModelGroup.COND_PROGRAMS;

/**
 * Dedicated Conditional Programs for Block Models
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockCondPrograms {

    public static void init(){
		COND_PROGRAMS.put("fvtm:signal_state", new SignalState());
		COND_PROGRAMS.put("fvtm:basic_signal", new SignalState());
		COND_PROGRAMS.put("fvtm:switch_fork2_state", new SwitchFork2State());
		COND_PROGRAMS.put("fvtm:switch_fork3_state", new SwitchFork3State());
		COND_PROGRAMS.put("fvtm:switch_double_state", new SwitchDoubleState());
		COND_PROGRAMS.put("fvtm:switch_double_state_side", new SwitchDoubleStateSide());
		COND_PROGRAMS.put("fvtm:block_bool_value", new BlockBoolValue());
		COND_PROGRAMS.put("fvtm:block_facing", new BlockFacing());
		COND_PROGRAMS.put("fvtm:block_rotation", new BlockRotation());
		COND_PROGRAMS.put("fvtm:block_state_property", new BlockStateProperty());
    }

	public static class SignalState extends Program.ConditionalProgram {

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SignalTileEntity)data.tile).getSignalState() > 0;
		}

	}

	public static class SwitchFork2State extends Program.ConditionalProgram {

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).getSwitch0State();
		}

	}

	public static class SwitchFork3State extends Program.ConditionalProgram {

		private int tracked;

		public SwitchFork3State(){}

		public SwitchFork3State(int tracked){
			this.tracked = tracked;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).getSwitch2State() == tracked;
		}

		@Override
		public Program parse(String[] args){
			return new SwitchFork3State(Integer.parseInt(args[0])).transfer(this);
		}

	}

	public static class SwitchDoubleState extends Program.ConditionalProgram {

		private boolean switch0, switch1;

		public SwitchDoubleState(){}

		public SwitchDoubleState(boolean switch0, boolean switch1){
			this.switch0 = switch0;
			this.switch1 = switch1;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).isDoubleSwitchState(switch0, switch1);
		}

		@Override
		public Program parse(String[] args){
			return new SwitchDoubleState(Boolean.parseBoolean(args[0]), Boolean.parseBoolean(args[1])).transfer(this);
		}

	}

	public static class SwitchDoubleStateSide extends Program.ConditionalProgram {

		private boolean side, state;

		public SwitchDoubleStateSide(){}

		public SwitchDoubleStateSide(boolean side, boolean state){
			this.side = side;
			this.state = state;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((SwitchTileEntity)data.tile).isDoubleSwitchStateOnSide(side, state);
		}

		@Override
		public Program parse(String[] args){
			return new BlockBoolValue(args[0], Boolean.parseBoolean(args[1])).transfer(this);
		}

	}
	public static class BlockBoolValue extends Program.ConditionalProgram {

		private String key;
		private boolean val = true;

		public BlockBoolValue(){}

		public BlockBoolValue(String key, boolean val){
			this.key = key;
			this.val = val;
		}

		public BlockBoolValue(EnumFacing byName, boolean val) {
			super();
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.tile != null && ((BlockTileEntity)data.tile).getBlockData().getFunctionBool(key) == val;
		}

		@Override
		public Program parse(String[] args){
			return new BlockBoolValue(args[0], args.length == 1 || Boolean.parseBoolean(args[1])).transfer(this);
		}

	}

	public static class BlockFacing extends Program.ConditionalProgram {

		private EnumFacing facing;
		private boolean val = true;

		public BlockFacing(){
			facing = EnumFacing.NORTH;
		}

		public BlockFacing(EnumFacing facing, boolean val){
			this.facing = facing;
			this.val = val;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.blockstate != null && (((IBlockState)data.blockstate).getValue(FvtmProperties.FACING) == facing) == val;
		}

		@Override
		public Program parse(String[] args){
			return new BlockFacing(EnumFacing.byName(args[0]), args.length == 1 || Boolean.parseBoolean(args[1])).transfer(this);
		}

	}

	public static class BlockRotation extends Program.ConditionalProgram {

		private int rot;
		private boolean val = true;

		public BlockRotation(){
			rot = 0;
		}

		public BlockRotation(int rot, boolean val){
			this.rot = rot;
			this.val = val;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.blockstate != null && (((IBlockState)data.blockstate).getValue(FvtmProperties.ROTATION) == rot) == val;
		}

		@Override
		public Program parse(String[] args){
			return new BlockRotation(Integer.parseInt(args[0]), args.length == 1 || Boolean.parseBoolean(args[1])).transfer(this);
		}

	}

	public static class BlockStateProperty extends Program.ConditionalProgram {

		private String key, value;
		private boolean bool = true;

		public BlockStateProperty(){}

		public BlockStateProperty(String key, String value, boolean bool){
			this.key = key;
			this.value = value;
			this.bool = bool;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			IProperty prop = gp((IBlockState)data.blockstate);
			Print.debug(prop.getName() + " " + ((IBlockState)data.blockstate).getValue(prop) + " " + key + " " + value + " " + bool);
			return data.blockstate != null && (((IBlockState)data.blockstate).getValue(prop).toString().equals(value)) == bool;
		}

		private IProperty<?> gp(IBlockState blockstate){
			for(IProperty<?> prop : blockstate.getPropertyKeys()){
				if(prop.getName().equals(key)) return prop;
			}
			return null;
		}

		@Override
		public Program parse(String[] args){
			return new BlockStateProperty(args[0], args[1], args.length == 2 || Boolean.parseBoolean(args[2])).transfer(this);
		}

	}

}
