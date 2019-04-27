package net.fexcraft.mod.fvtm.data;

import java.util.Comparator;
import java.util.TreeSet;

public abstract class Attribute<T> {

	public static final Comparator<Modifier> MODIFIER_COMPARATOR = new Comparator<Modifier>() {
        @Override public int compare(Modifier m0, Modifier m1){ return m0.priority.compareTo(m1.priority); }
    };
	protected TreeSet<Modifier> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	protected boolean original;
	protected String id, target;
	protected T value, initial;
	
	public Attribute(boolean isStatic, String id){
		this.original = isStatic; this.id = id;
	}
	
	public boolean isOriginal(){ return original; }
	
	public T getValue(){ return value; }
	
	public void setValue(T value){ this.value = value; }
	
	public void resetValue(){ this.value = initial; }
	
	public void refresh(){
		if(this.isOriginal()) return;
		for(Modifier mod : modifiers){
			if(this.getType() == AttributeType.STRING && mod.getVal() == null) continue;
			if(this.getType() != AttributeType.STRING && mod.getVal() != null) continue;
			mod.refresh(); mod.modify(this);
		}
	}
	
	public abstract Attribute<T> clone();
	
	public abstract AttributeType getType();
	
	public void addModifer(Modifier modifier){
		this.modifiers.add(modifier);
	}
	
	public java.util.Set<Modifier> getModifiers(){ return modifiers; }
	
	//for storing in parts, till they are in an active instance
	public Attribute<T> setTarget(String str){ this.target = str; return this; }
	public String getTarget(){ return target; }
	
	public static class Modifier {

		protected ModifierPriority priority;
		protected ModifierUpdate interval;
		protected ModifierType type;
		protected String id, val, target;
		protected float value;
		
		public Modifier(String string, float val, ModifierType mtype, ModifierUpdate up, ModifierPriority priority){
			this.id = string; this.value = val; this.type = mtype; this.priority = priority; this.interval = up;
		}

		public Modifier(String string, String val, ModifierType mtype, ModifierUpdate up, ModifierPriority priority){
			this.id = string; this.val = val; this.type = mtype; this.priority = priority; this.interval = up;
		}
		
		public void modify(Attribute<?> vehattr){
			if(this.getVal() != null && vehattr.getType() == AttributeType.STRING){
				StringAttribute attr = (StringAttribute)vehattr;
				switch(type){
					case ADDITIVE: attr.setValue(attr.getValue() + this.getVal()); return;
					case OVERRIDE: attr.setValue(this.getVal()); return;
					default: return;
				}
			}
			if(this.getVal() == null && vehattr.getType() != AttributeType.STRING){
				if(vehattr.getType() == AttributeType.INTEGER){
					IntegerAttribute attr = (IntegerAttribute)vehattr;
					int result = attr.getValue();
					if(type == ModifierType.ADDITIVE) result += this.getValue();
					else if(type == ModifierType.OVERRIDE) result = (int)this.getValue();
					else{
						float percent = result * 0.01f * this.getValue();
						switch(type){
							case PROCENT_ADD: result += percent; break;
							case PROCENT_DEC: result -= percent; break;
							case PROCENT_SET: result = (int)percent; break;
							default: return;//we shouldn't be here if not procents
						}
					} attr.setValue(result); return;
				}
				else{//could/should only be a float then
					FloatAttribute attr = (FloatAttribute)vehattr;
					float result = attr.getValue();
					if(type == ModifierType.ADDITIVE) result += this.getValue();
					else if(type == ModifierType.OVERRIDE) result = this.getValue();
					else{
						float percent = result * 0.01f * this.getValue();
						switch(type){
							case PROCENT_ADD: result += percent; break;
							case PROCENT_DEC: result -= percent; break;
							case PROCENT_SET: result = percent; break;
							default: return;//we shouldn't be here if not procents
						}
					} attr.setValue(result); return;
				}
			}
			return;
		}
		
		public String getId(){ return id; }
		public String getVal(){ return val; }
		public float getValue(){ return value; }
		public ModifierType getType(){ return type; }
		public ModifierUpdate getInterval(){ return interval; }
		public void refresh(){};
		
		public Modifier clone(){
			if(val == null){
				return new Modifier(id, value, type, interval, priority);
			}
			else{
				return new Modifier(id, val, type, interval, priority);
			}
		}
		
		//for storing modifiers in parts, till they are in the vehicle
		public Modifier setTarget(String str){ this.target = str; return this; }
		public String getTarget(){ return target; }
		
	}
	
	public static enum ModifierPriority {
		VERYHIGH, HIGH, NORMAL, LOW, VERYLOW
	}
	
	public static enum ModifierType {
		OVERRIDE, ADDITIVE, PROCENT_ADD, PROCENT_DEC, PROCENT_SET
	}
	
	public static enum ModifierUpdate {
		INSTALL, UPDATE, CALLED
	}
	
	public static enum AttributeType {
		STRING, FLOAT, INTEGER
	}
	
	public static class StringAttribute extends Attribute<String> {
		
		public StringAttribute(boolean isStatic, String id, String string){
			super(isStatic, id); this.value = this.initial = string;
		}

		@Override
		public Attribute<String> clone(){
			StringAttribute str = new StringAttribute(false, id, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			str.modifiers = mod; return str;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.STRING;
		}
		
	}
	
	public static class IntegerAttribute extends Attribute<Integer> {

		public IntegerAttribute(boolean isStatic, String id, int value){
			super(isStatic, id); this.value = this.initial = value;
		}

		@Override
		public Attribute<Integer> clone(){
			IntegerAttribute inte = new IntegerAttribute(false, id, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			inte.modifiers = mod; return inte;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.INTEGER;
		}
		
	}
	
	public static class FloatAttribute extends Attribute<Float> {
		
		protected float value;

		public FloatAttribute(boolean isStatic, String id, float value){
			super(isStatic, id); this.value = value;
		}

		@Override
		public Attribute<Float> clone(){
			FloatAttribute flt = new FloatAttribute(false, id, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			flt.modifiers = mod; return flt;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.FLOAT;
		}
		
	}

	public String getId(){
		return id;
	}

}
