package net.fexcraft.mod.fvtm.sys.impl;

import java.util.ArrayList;
import java.util.function.Function;

import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.event.ConditionEvent;
import net.fexcraft.mod.fvtm.sys.condition.Condition;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.condition.Conditional;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CondBuilder {

	public static Function<Condition, Conditional> run(){
		return (cond) -> {
			switch(cond.type){
				case "attribute":{
					switch(cond.mode){
						case "bequal":
						case "b=":{
							boolean bool = Boolean.parseBoolean(cond.condi);
							return data -> {
								return data.vehicle.getAttributeBoolean(cond.target, false) == bool;
							};
						}
						case "n=":{
							Float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) == val;
							};
						}
						case "!n=":{
							Float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) != val;
							};
						}
						case "equal":
						case "=":{
							return data -> {
								return data.vehicle.getAttributeString(cond.target, "null").equals(cond.condi);
							};
						}
						case "nequal":
						case "!=":{
							return data -> {
								return !data.vehicle.getAttributeString(cond.target, "null").equals(cond.condi);
							};
						}
						case "lequal":
						case "<=":{
							float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) <= val;
							};
						}
						case "gequal":
						case ">=":{
							float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) >= val;
							};
						}
						case "less":
						case "<":{
							float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) < val;
							};
						}
						case "greater":
						case ">":{
							float val = Float.parseFloat(cond.condi);
							return data -> {
								return data.vehicle.getAttributeFloat(cond.target, 0f) > val;
							};
						}
					}
					break;
				}
				case "metadata":{
					int meta = Integer.parseInt(cond.condi);
					switch(cond.mode){
						case "equal":
						case "=":{
							return data -> {
								return data.tile.getBlockMetadata() == meta;
							};
						}
						case "nequal":
						case "!=":{
							return data -> {
								return data.tile.getBlockMetadata() != meta;
							};
						}
						case "lequal":
						case "<=":{
							return data -> {
								return data.tile.getBlockMetadata() <= meta;
							};
						}
						case "gequal":
						case ">=":{
							return data -> {
								return data.tile.getBlockMetadata() >= meta;
							};
						}
						case "less":
						case "<":{
							return data -> {
								return data.tile.getBlockMetadata() < meta;
							};
						}
						case "greater":
						case ">":{
							return data -> {
								return data.tile.getBlockMetadata() > meta;
							};
						}
					}
					break;
				}
				case "part_function":
				case "part_func":
				case "partfunc":{
					return mrdata -> {
						PartData data = mrdata.part_category.equals(cond.target) ? mrdata.part : mrdata.vehicle.getPart(cond.target);
						net.fexcraft.mod.fvtm.data.part.Function func = data == null ? null : data.getFunction(cond.targets[1]);
						return func == null ? false : func.onCondition(cond.targets, cond.mode, cond.condi);
					};
				}
				case "multiple":
				case "multi":
				case "group":{
					int m = cond.mode.equals("any") ? 1 : cond.mode.equals("none") ? 2 : 0;
					ArrayList<Conditional> cons = new ArrayList<>();
					for(String str : cond.targets){
						Conditional con = ConditionRegistry.get(str);
						if(con != null) cons.add(con);
					}
					return data -> {
						for(Conditional con : cons){
							if(con.isMet(data)){
								if(m == 1) return true;
								else if(m == 2) return false;
							}
							else if(m == 0) return false;
						}
						return true;
					};
				}
				case "world_time":{
					int value = Integer.parseInt(cond.condi);
					switch(cond.mode){
						case "equal":
						case "=":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() == value;
							};
						}
						case "nequal":
						case "!=":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() != value;
							};
						}
						case "lequal":
						case "<=":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() <= value;
							};
						}
						case "gequal":
						case ">=":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() >= value;
							};
						}
						case "less":
						case "<":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() < value;
							};
						}
						case "greater":
						case ">":{
							return data -> {
								World world = data.entity == null ? data.tile == null ? null : data.tile.getWorld() : data.entity.world;
								return world == null ? false : world.getWorldTime() > value;
							};
						}
					}
					break;
				}
				default:{
					ConditionEvent.ConditionalCreate event = new ConditionEvent.ConditionalCreate(cond);
					MinecraftForge.EVENT_BUS.post(event);
					return event.getConditional();
				}
			}
			return null;
		};
	};
}
