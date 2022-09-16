/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script.elm;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class BoolElm extends Elm {
	
	private boolean value;

	public BoolElm(boolean bool){
		value = bool;
	}

	@Override
	public String string_val(){
		return value + "";
	}

	@Override
	public int integer_val(){
		return value ? 0 : 1;
	}

	@Override
	public float float_val(){
		return value ? 0f : 1f;
	}

	@Override
	public boolean bool_val(){
		return value;
	}

	@Override
	public Type type(){
		return Type.BOOLEAN;
	}

	@Override
	public void set(String val){
		value = val.toLowerCase().equals("true");
	}

	@Override
	public void set(int val){
		value = val > 0;
	}

	@Override
	public void set(float val){
		value = val > 0;
	}

	@Override
	public void set(boolean val){
		value = val;
	}
	
	public static class Final extends BoolElm {
		
		public Final(boolean bool){
			super(bool);
		}

		@Override
		public void set(String val){
			//
		}

		@Override
		public void set(int val){
			//
		}

		@Override
		public void set(float val){
			//
		}

		@Override
		public void set(boolean val){
			//
		}
		
	}

}
