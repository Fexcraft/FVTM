package net.fexcraft.mod.fvtm.data;

import java.util.Comparator;
import java.util.TreeSet;

public abstract class VehicleAttribute<T> {

	public static final Comparator<Modifier> MODIFIER_COMPARATOR = new Comparator<Modifier>() {
        @Override public int compare(Modifier m0, Modifier m1){ return m0.priority.compareTo(m1.priority); }
    };
	protected TreeSet<Modifier> modifiers = new TreeSet<>(MODIFIER_COMPARATOR);
	protected boolean original;
	
	public VehicleAttribute(boolean isStatic){
		this.original = isStatic;
	}
	
	public boolean isOriginal(){ return original; }
	
	public abstract T getValue();
	
	public abstract void setValue(T value);
	
	public void refresh(){
		for(Modifier mod : modifiers){
			if(this.getType() == AttributeType.STRING && mod.getVal() == null) continue;
			if(this.getType() != AttributeType.STRING && mod.getVal() != null) continue;
			mod.refresh(); mod.modify(this);
		}
	}
	
	public abstract VehicleAttribute<T> clone();
	
	public abstract AttributeType getType();
	
	public void addModifer(Modifier modifier){
		this.modifiers.add(modifier);
	}
	
	public java.util.Set<Modifier> getModifiers(){ return modifiers; }
	
	public static class Modifier {

		protected ModifierPriority priority;
		protected ModifierType type;
		protected String id, val;
		protected float value;
		
		private Modifier(String string, float val, ModifierType mtype, ModifierPriority priority){
			this.id = string; this.value = val; this.type = mtype; this.priority = priority;
		}

		private Modifier(String string, String val, ModifierType mtype, ModifierPriority priority){
			this.id = string; this.val = val; this.type = mtype; this.priority = priority;
		}
		
		public void modify(VehicleAttribute<?> vehattr){
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
		public void refresh(){};
		
		public Modifier clone(){
			if(val == null){
				return new Modifier(id, value, type, priority);
			}
			else{
				return new Modifier(id, val, type, priority);
			}
		}
		
	}
	
	public static enum ModifierPriority {
		VERYHIGH, HIGH, NORMAL, LOW, VERYLOW
	}
	
	public static enum ModifierType {
		OVERRIDE, ADDITIVE, PROCENT_ADD, PROCENT_DEC, PROCENT_SET
	}
	
	public static enum AttributeType {
		STRING, FLOAT, INTEGER
	}
	
	public static class StringAttribute extends VehicleAttribute<String> {
		
		protected String value;
		
		public StringAttribute(boolean isStatic, String string){
			super(isStatic); this.value = string;
		}

		@Override
		public String getValue(){
			return value;
		}

		@Override
		public void setValue(String value){
			this.value = value;
		}

		@Override
		public VehicleAttribute<String> clone(){
			StringAttribute str = new StringAttribute(false, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			str.modifiers = mod; return str;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.STRING;
		}
		
	}
	
	public static class IntegerAttribute extends VehicleAttribute<Integer> {
		
		protected int value;

		public IntegerAttribute(boolean isStatic, int value){
			super(isStatic); this.value = value;
		}

		@Override
		public Integer getValue(){
			return value;
		}

		@Override
		public void setValue(Integer value){
			this.value = value;
		}

		@Override
		public VehicleAttribute<Integer> clone(){
			IntegerAttribute inte = new IntegerAttribute(false, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			inte.modifiers = mod; return inte;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.INTEGER;
		}
		
	}
	
	public static class FloatAttribute extends VehicleAttribute<Float> {
		
		protected float value;

		public FloatAttribute(boolean isStatic, float value){
			super(isStatic); this.value = value;
		}

		@Override
		public Float getValue(){
			return value;
		}

		@Override
		public void setValue(Float value){
			this.value = value;
		}

		@Override
		public VehicleAttribute<Float> clone(){
			FloatAttribute flt = new FloatAttribute(false, value);
			TreeSet<Modifier> mod = new TreeSet<>(MODIFIER_COMPARATOR);
			for(Modifier modi : modifiers) mod.add(modi.clone());
			flt.modifiers = mod; return flt;
		}

		@Override
		public AttributeType getType(){
			return AttributeType.FLOAT;
		}
		
	}

}
