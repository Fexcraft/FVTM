package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.mod.fvtm.sys.event.EventData;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
@FunctionalInterface
public interface Conditional {

	boolean isMet(Condition cond, EventData data);

}
