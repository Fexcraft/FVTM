package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.mod.uni.world.WorldW;

import java.util.function.Function;

import static net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry.COND_FALSE;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondBuilderRoot {

	public static Function<CondKey, Conditional> run(){
		return key -> {
			switch(key.type){
				case ATTRIBUTE:{
					switch(key.mode){
						case BOOL_EQUAL:{
							return (cond, data) -> data.vehicle.getAttributeBoolean(key.target, false) == cond.value.bool();
						}
						case BOOL_NEQUAL:{
							return (cond, data) -> data.vehicle.getAttributeBoolean(key.target, false) != cond.value.bool();
						}
						case NUMB_EQUAL:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) == cond.value.float_value();
						}
						case NUMB_NEQUAL:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) != cond.value.float_value();
						}
						case EQUAL:{
							return (cond, data) -> data.vehicle.getAttributeString(key.target, "null").equals(cond.value.string_value());
						}
						case NEQUAL:{
							return (cond, data) -> !data.vehicle.getAttributeString(key.target, "null").equals(cond.value.string_value());
						}
						case LEQUAL:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) <= cond.value.float_value();
						}
						case GEQUAL:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) >= cond.value.float_value();
						}
						case LESS:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) < cond.value.float_value();
						}
						case GREATER:{
							return (cond, data) -> data.vehicle.getAttributeFloat(key.target, 0f) > cond.value.float_value();
						}
					}
					break;
				}
				/*case PART_FUNC:{
					return edat -> {
						ModelRenderData mrdata = (ModelRenderData)edat;
						PartData data = mrdata.part_category.equals(key.target) ? mrdata.part : mrdata.vehicle.getPart(key.target);
						PartFunction func = data == null ? null : data.getFunction(key.targets[1]);
						return func == null ? false : func.onCondition(key.targets, key.mode, key.condi);
					};
				}*/
				case TRACK_FROM:{
					switch(key.mode){
						case EQUAL:
						case NUMB_EQUAL:{
							return (cond, data) -> (int)data.args[1] == cond.value.integer_value();
						}
						case NEQUAL:
						case NUMB_NEQUAL:{
							return (cond, data) -> (int)data.args[1] != cond.value.integer_value();
						}
						case LEQUAL:{
							return (cond, data) -> (int)data.args[1] <= cond.value.integer_value();
						}
						case GEQUAL:{
							return (cond, data) -> (int)data.args[1] >= cond.value.integer_value();
						}
						case LESS:{
							return (cond, data) -> (int)data.args[1] < cond.value.integer_value();
						}
						case GREATER:{
							return (cond, data) -> (int)data.args[1] > cond.value.integer_value();
						}
					}
				}
				case MULTI:{
					Conditional[] als = ConditionRegistry.getByTarget(key.target);
					if(key.mode == CondMode.AND){
						return (cond, data) -> als[0].isMet(cond, data) && als[1].isMet(cond, data);
					}
					else if(key.mode == CondMode.ANN){
						return (cond, data) -> als[0].isMet(cond, data) && !als[1].isMet(cond, data);
					}
					else if(key.mode == CondMode.OR){
						return (cond, data) -> als[0].isMet(cond, data) || als[1].isMet(cond, data);
					}
					else return COND_FALSE;
				}
				case DAYTIME:{
					switch(key.mode){
						case EQUAL:
						case NUMB_EQUAL:
						case BOOL_EQUAL:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() == cond.value.integer_value();
						}
						case NEQUAL:
						case NUMB_NEQUAL:
						case BOOL_NEQUAL:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() != cond.value.integer_value();
						}
						case LEQUAL:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() <= cond.value.integer_value();
						}
						case GEQUAL:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() >= cond.value.integer_value();
						}
						case LESS:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() < cond.value.integer_value();
						}
						case GREATER:{
							return (cond, data) -> data.entity != null && data.entity.getWorld().getDayTime() > cond.value.integer_value();
						}
					}
					break;
				}
			}
			return null;
		};
	}

}
