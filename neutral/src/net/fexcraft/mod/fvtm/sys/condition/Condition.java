package net.fexcraft.mod.fvtm.sys.condition;

import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Condition {

	public CondType type;
	public String target;
	public String condi;
	public CondMode mode;
	
	public Condition(){}

	public Condition(String[] array){
		type = CondType.parse(array[0]);
		target = array[1];
		mode = CondMode.parse(array.length > 2 ? array[2] : "==");
		condi = array.length > 3 ? array[3] : "true";
	}

	public Condition(List<String> array){
		type = CondType.parse(array.get(0));
		target = array.get(1);
		mode = CondMode.parse(array.size() > 2 ? array.get(2) : "==");
		condi = array.size() > 3 ? array.get(3) : "true";
	}
	
	public String toCompare(){
		return type + " " + target + " " + mode.key + " " + condi;
	}

}
