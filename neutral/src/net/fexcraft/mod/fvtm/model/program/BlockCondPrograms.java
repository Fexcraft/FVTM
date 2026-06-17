package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity.SignalBE;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity.SwitchBE;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.uni.world.CubeSide;

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
			return data.block_entity != null && ((SignalBE)data.block_entity).getSignalState() > 0;
		}

	}

	public static class SwitchFork2State extends Program.ConditionalProgram {

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.block_entity != null && ((SwitchBE)data.block_entity).getSwitch0State();
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
			return data.block_entity != null && ((SwitchBE)data.block_entity).getSwitch2State() == tracked;
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
			return data.block_entity != null && ((SwitchBE)data.block_entity).isDoubleSwitchState(switch0, switch1);
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
			return data.block_entity != null && ((SwitchBE)data.block_entity).isDoubleSwitchStateOnSide(side, state);
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

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.block_entity != null && data.block_entity.getBlockData().getFunctionBool(key) == val;
		}

		@Override
		public Program parse(String[] args){
			return new BlockBoolValue(args[0], args.length == 1 || Boolean.parseBoolean(args[1])).transfer(this);
		}

	}

	public static class BlockFacing extends Program.ConditionalProgram {

		private Object side;
		private boolean val = true;

		public BlockFacing(){
			side = CubeSide.NORTH.local();
		}

		public BlockFacing(CubeSide side, boolean val){
			this.side = side.local();
			this.val = val;
		}

		@Override
		public boolean test(ModelGroup list, ModelRenderData data){
			return data.blockstate != null && (data.blockstate.getValue("facing", Object.class) == side) == val;
		}

		@Override
		public Program parse(String[] args){
			return new BlockFacing(CubeSide.parse(args[0]), args.length == 1 || Boolean.parseBoolean(args[1])).transfer(this);
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
			return data.blockstate != null && (data.blockstate.getValue("rotation", Integer.class) == rot) == val;
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
			if(data.blockstate == null) return false;
			return (data.blockstate.getValue(data.blockstate.getProperty(key)).toString().equals(value)) == bool;
		}

		@Override
		public Program parse(String[] args){
			return new BlockStateProperty(args[0], args[1], args.length == 2 || Boolean.parseBoolean(args[2])).transfer(this);
		}

	}

}
