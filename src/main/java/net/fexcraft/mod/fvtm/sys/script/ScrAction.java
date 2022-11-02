/*
 * Copyright (c) 2022, Ferdinand Calo'. All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.sys.script.elm.Elm;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ScrAction extends ScrBlock {
	
	public final ArrayList<String> parameters = new ArrayList<>();

	public ScrAction(Script root, String name){
		super(Type.ACTION, root, root, name);
	}
	
	public Elm process(ArrayList<Elm> args){
		if(args != null){
			for(int i = 0; i < args.size(); i++){
				if(i >= parameters.size()) break;
				locals.get(parameters.get(i)).set(args.get(i));
			}
		}
		return super.process().first;
	}
	
	public Elm process(Elm... args){
		if(args != null){
			for(int i = 0; i < args.length; i++){
				if(i >= parameters.size()) break;
				if(args[i].overrides()) locals.put(parameters.get(i), args[i]);
				else locals.get(parameters.get(i)).set(args[i]);
			}
		}
		return super.process().first;
	}

}
