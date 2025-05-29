package net.fexcraft.mod.fvtm.sys.condition;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CondKey {

	public CondType type;
	public CondMode mode;
	public String target;

	protected CondKey(CondType ct, CondMode cm, String tar){
		type = ct;
		mode = cm;
		target = tar;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof CondKey){
			CondKey ck = (CondKey)obj;
			return type == ck.type && mode == ck.mode && target.equals(ck.target);
		}
		if(obj instanceof String) return toString().equals(obj.toString());
		return false;
	}

	@Override
	public String toString(){
		return type.key + "-" + mode.key + "-" + target;
	}

	@Override
	public int hashCode(){
		return toString().hashCode();
	}

}
