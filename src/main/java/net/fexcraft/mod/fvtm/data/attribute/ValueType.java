package net.fexcraft.mod.fvtm.data.attribute;

public class ValueType {
	
	public static final ValueType STRING = new Builder().setString().build();
	public static final ValueType BOOLEAN = new Builder().setBoolean().build();
	public static final ValueType TRISTATE = new Builder().setTristate().build();
	public static final ValueType INTEGER = new Builder().setInteger().build();
	public static final ValueType FLOAT = new Builder().setFloat().build();
	public static final ValueType VECTOR = new Builder().setVector().build();
	public static final ValueType OBJECT = new Builder().setObject().build();
	//
	public static final ValueType STRING_ARRAY = new Builder().setString().setArray().build();
	public static final ValueType BOOLEAN_ARRAY = new Builder().setBoolean().setArray().build();
	public static final ValueType INTEGER_ARRAY = new Builder().setInteger().setArray().build();
	public static final ValueType FLOAT_ARRAY = new Builder().setFloat().setArray().build();
	public static final ValueType OBJECT_ARRAY = new Builder().setObject().setArray().build();
	
	private boolean string, bool, tristate, integer, float_, vector, array, object;
	
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
		return integer || float_ || bool;
	}
	
	public boolean isInteger(){
		return integer;
	}
	
	public boolean isFloat(){
		return float_;
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
		
		private ValueType valtype;
		
		public Builder(){
			valtype = new ValueType();
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
		
		public ValueType build(){
			return valtype;
		}
		
	}

}
