/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import java.util.ArrayList;

public class ScrTask {

	protected final Type type;
	protected ArrayList<ScrBlock> blocks = new ArrayList<>();
	protected ScrExpr expr;
	protected boolean closed;
	
	public ScrTask(Type type, ScrBlock block){
		this.type = type;
		blocks.add(block);
	}

	public ScrTask(Type type, ScrExpr expr){
		this.type = type;
		this.expr = expr;
	}

	public static enum Type {
		
		IFELSE, LINE;

		boolean ifelse(){
			return this == IFELSE;
		}
		
	}

	public void add(ScrBlock block){
		blocks.add(block);
	}

	public void close(ScrBlock block){
		blocks.add(block);
		closed = true;
	}

	public String print(int depth){
		if(type == Type.LINE){
			return ScrBlock.getDepthTab(depth) + expr.print() + "\n";
		}
		else{
			String ret = "";
			for(ScrBlock block : blocks) ret += block.print(depth);
			return ret;
		}
	}
	
}
