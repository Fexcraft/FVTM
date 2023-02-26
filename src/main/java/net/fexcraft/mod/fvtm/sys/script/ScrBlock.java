/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import static net.fexcraft.mod.fvtm.sys.script.ScrElm.NULL;

import java.util.ArrayList;
import java.util.HashMap;

import net.fexcraft.mod.fvtm.sys.script.elm.NullElm;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class ScrBlock {
	
	public final HashMap<String, ScrElm> locals = new HashMap<>();
	public final ArrayList<ScrExpr> exprs = new ArrayList<>();
	public final ArrayList<ScrBlock> subs = new ArrayList<>();
	public final ArrayList<ScrTask> tasks = new ArrayList<>();
	private ScrCond condition;
	public Script script;
	public final ScrBlock root;
	public final String name;
	public final Type type;
	
	public ScrBlock(Type type, Script script, ScrBlock root, String name){
		this.root = root;
		this.script = script;
		this.name = name == null ? type.name().toLowerCase() : name;
		this.type = type;
		if(root != null) root.subs.add(this);
	}

	public ScrBlock action(){
		if(type == Type.ACTION) return this;
		else if(root != null) return root.action();
		return null;
	}

	public static enum Type {
		
		SCRIPT,
		ACTION,
		IFELSE;

		boolean is(Type o){
			return this == o;
		}

		boolean is(Type... o){
			for(Type type : o) if(this == type) return true;
			return false;
		}
		
	}

	public ScrBlock rootnn(){
		return root == null ? this : root;
	}

	public void cond(ScrCond cond){
		this.condition = cond;
	}

	public ScrElm getElm(String elm, ScrBlock sub){
		if(locals.containsKey(elm)) return locals.get(elm);
		return root == null ? NullElm.NULL : root.getElm(elm, this);
	}
	
	public String print(int depth){
		String tab = getDepthTab(depth), tab1 = getDepthTab(depth + 1);
		String cond = condition == null ? "" : condition.print();
		String ret = tab + type.name() + " " + name + "(" + cond + "){\n";
		ret = preprint(ret, tab, tab1, depth);
		//if(condition != null && locals.size() > 0) ret += "\n";
		for(HashMap.Entry<String, ScrElm> entry : locals.entrySet()){
			ret += tab1 + entry.getValue().scr_type() + " " + entry.getKey() + " = " + entry.getValue().scr_print() + "\n";
		}
		/*if(exprs.size() > 0) ret += "\n";
		for(ScrExpr expr : exprs){
			ret += tab1 + expr.print(tab) + "\n";
		}
		if(subs.size() > 0) ret += "\n";
		for(ScrBlock sub : subs){
			ret += sub.print(depth + 1);
		}*/
		//if(tasks.size() > 0) ret += "\n";
		for(ScrTask task : tasks){
			ret += task.print(depth + 1);
		}
		ret = postprint(ret, tab, tab1, depth);
		ret += tab + "}\n";
		return ret;
	}
	
	public String print(){
		return print(0);
	}

	protected String preprint(String ret, String tab, String tab1, int depth){
		return ret;
	}

	protected String postprint(String ret, String tab, String tab1, int depth){
		return ret;
	}

	protected static String getDepthTab(int depth){
		String ret = "";
		for(int i = 0; i < depth; i++) ret += "   ";
		return ret;
	}

	public ScrTask lastTask(){
		return tasks.size() == 0 ? null : tasks.get(tasks.size() - 1);
	}

	public Two<ScrElm, Boolean> process(){
		for(ScrTask task : tasks){
			if(task.type.ifelse()){
				for(ScrBlock block : task.blocks){
					if(block.condition == null || block.condition.isMet()){
						Two<ScrElm, Boolean> two = block.process();
						if(two.second) return two;
						break;
					}
				}
			}
			else{
				if(task.expr.isReturn()) return new Two<>(task.expr.process(this, null, NULL), true);
				else task.expr.process(this, null, NULL);
			}
		}
		return new Two<>(NULL, false);
	}

	public Script getScript(){
		ScrBlock block = this;
		while(block.root != null) block = block.root;
		return (Script)block;
	}

}
