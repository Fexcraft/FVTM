package net.fexcraft.mod.fvtm.sys.condition;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.sys.impl.CondBuilder;

import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ConditionRegistry {

	public static HashMap<String, CondKey> KEY_REG = new HashMap<>();
	private static HashMap<String, Condition> CONDITIONS = new HashMap<>();
	private static HashMap<CondKey, Conditional> CONDITIONALS = new HashMap<>();
	public static Function<CondKey, Conditional> BUILDER = CondBuilder.run();
	public static final Conditional COND_FALSE = (con, data) -> false;
	public static final Conditional COND_TRUE = (con, data) -> true;
	static {
		CondKey key = new CondKey(CondType.CUSTOM, CondMode.EQUAL, "");
		KEY_REG.put("fvtm:true", key);
		KEY_REG.put("true", key);
		CONDITIONS.put("fvtm:true", new Condition(key, new JsonValue(false)));
		CONDITIONALS.put(key, COND_TRUE);
		key = new CondKey(CondType.CUSTOM, CondMode.EQUAL, "");
		KEY_REG.put("fvtm:false", key);
		KEY_REG.put("false", key);
		CONDITIONS.put("fvtm:false", new Condition(key, new JsonValue(false)));
		CONDITIONALS.put(key, COND_FALSE);
	}
	
	public static Conditional get(CondKey key){
		if(!CONDITIONALS.containsKey(key)){
			CONDITIONALS.put(key, BUILDER.apply(key));
		}
		return CONDITIONALS.get(key);
	}

	public static Condition parse(String cond){
		if(CONDITIONS.containsKey(cond)) return CONDITIONS.get(cond);
		String[] arr = cond.split(" ");
		if(arr.length < 2) return CONDITIONS.get("fvtm:false");
		return new Condition(arr);
	}

	public static CondKey parseKey(String ctype, String tar, String cmode){
		CondType type = CondType.parse(ctype);
		CondMode mode = CondMode.parse(cmode);
		String key = type.key + "-" + mode + "-" + tar;
		if(KEY_REG.containsKey(key)) return KEY_REG.get(key);
		CondKey ck = new CondKey(type, mode, tar);
		KEY_REG.put(ck.toString(), ck);
		return ck;
	}

	public static void register(String key, Condition cond){
		if(!KEY_REG.containsKey(key)) KEY_REG.put(key, cond.key);
		CONDITIONS.put(key, cond);
	}

}
