package net.fexcraft.mod.fvtm.data.attribute;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class AttrValueType {
	
	public static final AttrValueType STRING = new Builder("string").setString().build();
	public static final AttrValueType BOOLEAN = new Builder("boolean").setBoolean().build();
	public static final AttrValueType TRISTATE = new Builder("tri-state").setTristate().build();
	public static final AttrValueType INTEGER = new Builder("integer").setInteger().build();
	public static final AttrValueType FLOAT = new Builder("float").setFloat().build();
	public static final AttrValueType LONG = new Builder("long").setLong().build();
	public static final AttrValueType VECTOR = new Builder("vector").setVector().build();
	public static final AttrValueType OBJECT = new Builder("object").setObject().build();
	//
	public static final AttrValueType STRING_ARRAY = new Builder("string_array").setString().setArray().build();
	public static final AttrValueType BOOLEAN_ARRAY = new Builder("boolean_array").setBoolean().setArray().build();
	public static final AttrValueType INTEGER_ARRAY = new Builder("integer_array").setInteger().setArray().build();
	public static final AttrValueType FLOAT_ARRAY = new Builder("float_array").setFloat().setArray().build();
	public static final AttrValueType OBJECT_ARRAY = new Builder("object_array").setObject().setArray().build();
	
	private boolean string, bool, tristate, integer, float_, long_, vector, array, object;
	public final String name;

	private AttrValueType(String id){
		name = id;
	}
	
	public boolean isString(){
		return string;
	}
	
	public boolean isBoolean(){
		return bool;
	}
	
	public boolean isTristate(){
		return tristate || bool;
	}
	
	public boolean isNumber(){
		return integer || float_ || long_ || bool;
	}
	
	public boolean isInteger(){
		return integer;
	}
	
	public boolean isFloat(){
		return float_;
	}
	
	public boolean isLong(){
		return long_;
	}
	
	public boolean isVector(){
		return vector;
	}
	
	public boolean isArray(){
		return array;
	}
	
	public boolean isObject(){
		return object;
	}
	
	public static class Builder {
		
		private AttrValueType valtype;
		
		public Builder(String name){
			valtype = new AttrValueType(name);
		}
		
		public Builder setString(){
			valtype.string = true;
			return this;
		}
		
		public Builder setBoolean(){
			valtype.bool = true;
			return this;
		}
		
		public Builder setTristate(){
			valtype.tristate = true;
			return this;
		}
		
		public Builder setInteger(){
			valtype.integer = true;
			return this;
		}
		
		public Builder setFloat(){
			valtype.float_ = true;
			return this;
		}
		
		public Builder setLong(){
			valtype.long_ = true;
			return this;
		}
		
		public Builder setVector(){
			valtype.vector = true;
			return this;
		}
		
		public Builder setArray(){
			valtype.array = true;
			return this;
		}
		
		public Builder setObject(){
			valtype.object = true;
			return this;
		}
		
		public AttrValueType build(){
			return valtype;
		}
		
	}

}
