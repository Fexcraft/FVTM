/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 * @param <A>
 * @param <B>
 */
public class Two<A, B> {
	
	public A first;
	public B second;
	
	public Two(A a, B b){
		first = a;
		second = b;
	}
	
	public Two(Object[] obj){
		first = (A)obj[0];
		second = (B)obj[1];
	}

}
