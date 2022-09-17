/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

import java.util.ArrayList;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.script.ScrAction;
import net.fexcraft.mod.fvtm.sys.script.ScrBlock;
import net.fexcraft.mod.fvtm.sys.script.Two;
import net.fexcraft.mod.fvtm.sys.script.elm.BoolElm.Final;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class Elm {
	
	public static final NullElm NULL = new NullElm();
	public static final BoolElm TRUE = new Final(true);
	public static final BoolElm FALSE = new Final(false);
	
	public abstract String string_val();
	
	public abstract int integer_val();
	
	public abstract float float_val();
	
	public abstract boolean bool_val();

	public abstract Type type();
	
	//
	
	public abstract void set(String val);

	public abstract void set(int val);
	
	public abstract void set(float val);

	public abstract void set(boolean val);

	public void set(Elm nex){};
	
	//
	
	public static enum Type {
		
		NULL, STRING, INTEGER, FLOAT, BOOLEAN, LIST, OBJ, COND, REF;
		
		public boolean primitive(){
			return !(this == LIST || this == OBJ);
		}

		public static Type from(String str){
			switch(str){
				case "str": return STRING;
				case "int": return INTEGER;
				case "flt": return FLOAT;
				case "bln": return BOOLEAN;
				case "lis": return LIST;
				case "obj": return OBJ;
				case "cnd": return COND;
				case "ref": return REF;
			}
			return NULL;
		}

		public boolean decimal(){
			return this == FLOAT;
		}

		public boolean bool(){
			return this == BOOLEAN || this == COND;
		}

		public boolean integer(){
			return this == INTEGER;
		}

		public boolean string(){
			return this == STRING;
		}

		public boolean reference(){
			return this == REF;
		}

		public boolean number(){
			return this == INTEGER || this == FLOAT;
		}

		public boolean cond(){
			return this == COND;
		}
		
	}

	public static Two<String, Elm> parse(String line, Type type){
		line = line.substring(4);
		if(!line.contains("=")){
			return new Two<String, Elm>(line.trim(), Elm.from(type));
		}
		String name = line.substring(0, line.indexOf("=")).trim();
		line = line.substring(line.indexOf("=") + 1).trim();
		Elm elm = null;
		switch(type){
			case BOOLEAN:
				elm = new BoolElm(Boolean.parseBoolean(line));
				break;
			case FLOAT:
				elm = new FltElm(Float.parseFloat(line));
				break;
			case INTEGER:
				elm = new IntElm(Integer.parseInt(line));
				break;
			case STRING:{
				int s = 0, e = line.length();
				if(line.startsWith("\"")) s = 1;
				if(line.endsWith("\"")) e--;
				elm = new StrElm(line.substring(s, e));
				break;
			}
			case LIST:{
				elm = new ListElm();
				break;
			}
			case OBJ:{
				elm = new ObjElm();
				break;
			}
			case COND:{
				elm = new CondElm(line);
				break;
			}
			default:{
				elm = NullElm.NULL;
				break;
			}
		}
		return new Two<String, Elm>(name, elm);
	}

	public static Elm from(Type from){
		switch(from){
			case BOOLEAN: return new BoolElm(false);
			case FLOAT: return new FltElm(0f);
			case INTEGER: return new IntElm(0);
			case LIST: return new ListElm();
			case OBJ: return new ObjElm();
			case STRING: return new StrElm("");
			case NULL:
			default: return NullElm.NULL;
		}
	}

	public String print_val(){
		return type() == Type.STRING ? "\"" + string_val() + "\"" : string_val();
	}
	
	public String toString(){
		return print_val();
	}

	public Elm get(ScrBlock block, String target){
		return NULL;
	}

	public Elm exec(ScrBlock block, String act, ArrayList<Elm> args){
		if(block.script.blocks.containsKey(act)){
			return ((ScrAction)block.script.blocks.get(act)).process(args);
		}
		switch(act){
			case "print":{
				if(args == null) break;
				for(Elm elm : args){
					if(elm.type().reference()){
						Elm e = ((RefElm)elm).getElm(block);
						Print.log(((RefElm)elm).negative() ? e.type().number() ? -elm.float_val() : !elm.bool_val() :  e.print_val());
					}
					else Print.log(elm.print_val());
				}
				break;
			}
			default: break;
		}
		return NULL;
	}

	/** If this element overrides existing element object rather than it's value. */
	public boolean overrides(){
		return false;
	}

	public static Elm asBool(boolean bool){
		return bool ? TRUE : FALSE;
	}

}
