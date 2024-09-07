package net.fexcraft.mod.fvtm.event;

import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ConditionEvent extends Event {

	private Condition condition;

	public ConditionEvent(Condition con){
		this.condition = con;
	}

	public Condition getCondition(){
		return condition;
	}
	
	public static class ConditionalCreate extends ConditionEvent {
		
		private Conditional result;

		public ConditionalCreate(Condition con){
			super(con);
		}
		
		public void setConditional(Conditional cond){
			result = cond;
		}
		
		public Conditional getConditional(){
			return result;
		}
		
	}

}
