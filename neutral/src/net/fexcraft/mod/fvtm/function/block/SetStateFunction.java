package net.fexcraft.mod.fvtm.function.block;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class SetStateFunction extends BlockFunction.StaticBlockFunction {

	private ArrayList<ChangeState> changes = new ArrayList<>();

	@Override
	public BlockFunction parse(JsonValue val){
		if(val == null) return this;
		if(val.isMap()){
			changes.add(new ChangeState(val.asMap()));
		}
		else if(val.isArray()){
			for(JsonValue<?> jsn : val.asArray().value){
				changes.add(new ChangeState(jsn.asMap()));
			}
		}
		return this;
	}

	@Override
	public String id(){
		return "fvtm:set_state";
	}

	@Override
	public boolean onClick(WorldW world, V3I pos, V3D hit, StateWrapper state, CubeSide side, EntityW player, boolean main){
		if(!main) return false;
		for(ChangeState cs : changes){
			FvtmLogger.marker(cs.cstate + " " + cs.nstate);
			if(Static.random.nextFloat() < (1f - cs.chance)) continue;
			if(cs.cstate != null){
				StateWrapper cond = StateWrapper.from(state.getBlock(), cs.cstate);
				if(!state.equals(cond)) continue;
			}
			if(cs.valid.size() > 0){
				if(!cs.valid.contains(player.getHeldItem(main).getID())) continue;
				if(cs.consume){
					StackWrapper stack = player.getHeldItem(main);
					stack.count(stack.count() - 1);
				}
			}
			String str = cs.nstate.isEmpty() ? state.getStateString() : cs.nstate.endsWith(" *") ? cs.nstate.replace("*", state.getStateString()) : cs.nstate;
			StateWrapper newstate = StateWrapper.from(cs.nstate.contains(" ") ? null : state.getBlock(), str);
			world.setBlockState(pos, newstate);
			return true;
		}
		return false;
	}

	private static class ChangeState {

		private String cstate;
		private String nstate;
		private float chance;
		private ArrayList<String> valid = new ArrayList<>();
		private boolean consume;

		public ChangeState(JsonMap map){
			cstate = map.getString("equals", null);
			nstate = map.getString("state", "");
			if(map.has("state12") && EnvInfo.is112()){
				nstate = map.getString("state12", "");
			}
			chance = map.getFloat("chance", 1f);
			if(chance > 1f) chance = 1;
			if(chance < 0f) chance = 0;
			if(map.has("valid_items")){
				valid = map.getArray("valid_items").toStringList();
			}
			consume = map.getBoolean("consume_item", false);
		}

	}

}
