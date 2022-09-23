/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import static net.fexcraft.mod.fvtm.sys.script.elm.Elm.FALSE;
import static net.fexcraft.mod.fvtm.sys.script.elm.Elm.NULL;
import static net.fexcraft.mod.fvtm.sys.script.elm.Elm.TRUE;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

import net.fexcraft.mod.fvtm.sys.script.elm.BoolElm;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.sys.script.elm.FltElm;
import net.fexcraft.mod.fvtm.sys.script.elm.IntElm;
import net.fexcraft.mod.fvtm.sys.script.elm.NullElm;
import net.fexcraft.mod.fvtm.sys.script.elm.RefElm;
import net.fexcraft.mod.fvtm.sys.script.elm.StrElm;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public abstract class ScrExpr {

	public String target;
	public ScrExpr next;
	
	public abstract Elm process(ScrBlock block, ScrExpr prev, Elm pelm);

	public ScrExpr next(ScrExpr expr){
		next = expr;
		return this;
	}
	
	public static class Return extends ScrExpr {

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			return next == null ? NULL : next.process(block, this, NULL);
		}

		public String print(){
			return "return " + (next == null ? "" : next.print());
		}

		@Override
		public boolean isReturn(){
			return true;
		}

	}

	public static class Reference extends ScrExpr {

		public Reference(String tar){
			target = tar;
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			Elm elm = block.getElm(target, null);
			if(next == null) return elm;
			else if(next instanceof Reference){
				ScrExpr nex = next;
				while(nex instanceof Reference){
					elm = elm.get(block, nex.target);
					nex = nex.next;
				}
				return nex == null ? elm : nex.process(block, this, elm);
			}
			else return next.process(block, this, elm);
		}

		public String print(){
			String dot = next != null && (next instanceof Reference || next instanceof Exec) ? "." : "";
			return "{" + target + "}" + dot + (next == null ? "" : next.print());
		}

	}
	
	public static class Not extends ScrExpr {

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			return new BoolElm(!next.process(block, this, NULL).bool_val());
		}

		public String print(){
			return "!" + (next == null ? "" : next.print());
		}

	}
	
	public static class Negate extends ScrExpr {

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			Elm elm = next.process(block, this, NULL);
			return elm.type().decimal() ? new FltElm(-elm.float_val()) : new IntElm(-elm.integer_val());
		}

		public String print(){
			return "-" + (next == null ? "" : next.print());
		}

	}

	public static class Exec extends ScrExpr {
		
		private ArrayList<Elm> args;

		public Exec(String tar){
			target = tar;
		}

		public Exec(String tar, String[] split){
			this(tar);
			args = new ArrayList<>();
			for(String str : split){
				boolean neg = false;
				str = str.trim();
				if(str.startsWith("!") || str.startsWith("-")){
					neg = true;
					str = str.substring(1);
				}
				if(str.startsWith("\"")){
					args.add(new StrElm(str.substring(1, str.endsWith("\"") ? str.length() - 1 : str.length())));
				}
				else if(NumberUtils.isCreatable(str)){
					Elm elm = null;
					if(str.contains(".")){
						elm = new FltElm(neg ? -Float.parseFloat(str) : Float.parseFloat(str));
					}
					else {
						elm = new IntElm(neg ? -Integer.parseInt(str) : Integer.parseInt(str));
					}
					args.add(elm);
				}
				else if(Script.isb(str)){
					boolean bool = str.toLowerCase().equals("true");
					args.add(new BoolElm(neg ? !bool : bool));
				}
				else args.add(new RefElm(str, neg));
			}
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			if(next == null) return (pelm == NULL ? NULL.exec(block, target, args) : pelm.exec(block, target, args));
			else return next.process(block, this, (pelm == NULL ? NULL.exec(block, target, args) : pelm.exec(block, target, args)));
		}

		public String print(){
			String dot = next != null && (next instanceof Reference || next instanceof Exec) ? "." : "";
			String arg = "";
			if(args != null){
				for(int i = 0; i < args.size(); i++){
					arg += args.get(i);
					if(i < args.size() - 1) arg += ", ";
				}
			}
			return target + "(" + arg + ")" + dot + (next == null ? "" : next.print());
		}

	}

	public static class Set extends ScrExpr {
		
		private ScrOper oper;

		public Set(ScrOper oper){
			this.oper = oper == null ? ScrOper.SET : oper;
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			if(!pelm.type().primitive() && oper != ScrOper.SET) return NULL;
			Elm nex = next.process(block, this, NULL);
			switch(oper){
				case SET:{
					if(nex.type().decimal()) pelm.set(nex.float_val());
					else if(nex.type().integer()) pelm.set(nex.integer_val());
					else if(nex.type().bool()) pelm.set(nex.bool_val());
					else if(nex.type().string()) pelm.set(nex.string_val());
					else pelm.set(nex);
					break;
				}
				case ADD:{
					if(nex.type().decimal()) pelm.set(pelm.float_val() + nex.float_val());
					else pelm.set(pelm.integer_val() + nex.integer_val());
					break;
				}
				case SUB:{
					if(nex.type().decimal()) pelm.set(pelm.float_val() - nex.float_val());
					else pelm.set(pelm.integer_val() - nex.integer_val());
					break;
				}
				case DIV:{
					if(nex.type().decimal()) pelm.set(pelm.float_val() / nex.float_val());
					else pelm.set(pelm.integer_val() / nex.integer_val());
					break;
				}
				case MUL:{
					if(nex.type().decimal()) pelm.set(pelm.float_val() * nex.float_val());
					else pelm.set(pelm.integer_val() * nex.integer_val());
					break;
				}
				case MOD:{
					if(nex.type().decimal()) pelm.set(pelm.float_val() % nex.float_val());
					else pelm.set(pelm.integer_val() % nex.integer_val());
					break;
				}
				default: break;
			}
			return pelm;
		}

		public String print(){
			return " " + (oper == ScrOper.SET ? "" : oper.sign) + "= " + (next == null ? "" : next.print());
		}

	}

	public static class Math extends ScrExpr {
		
		private ScrOper oper;

		public Math(ScrOper oper){
			this.oper = oper == null ? ScrOper.SET : oper;
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			// TODO Auto-generated method stub
			return pelm;
		}

		public String print(){
			return " " + oper.sign + " " + (next == null ? "" : next.print());
		}

	}

	public static class Compare extends ScrExpr {
		
		private ScrOper oper;

		public Compare(ScrOper oper){
			this.oper = oper == null ? ScrOper.SET : oper;
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			Elm next = this.next.process(block, this, pelm);
			switch(oper){
				case GRT: return pelm.float_val() > next.float_val() ? TRUE : FALSE;
				case GRT_EQL: return pelm.float_val() >= next.float_val() ? TRUE : FALSE;
				case LES: return pelm.float_val() < next.float_val() ? TRUE : FALSE;
				case LES_EQL: return pelm.float_val() <= next.float_val() ? TRUE : FALSE;
				case NOT_EQL:{
					if(pelm.type().number()){
						return pelm.float_val() != next.float_val() ? TRUE : FALSE;
					}
					else if(pelm.type().bool()){
						return pelm.bool_val() != next.bool_val() ? TRUE : FALSE;
					}
					else return !pelm.equals(next) ? TRUE : FALSE;
				}
				case EQL:{
					if(pelm.type().number()){
						return pelm.float_val() == next.float_val() ? TRUE : FALSE;
					}
					else if(pelm.type().bool()){
						return pelm.bool_val() == next.bool_val() ? TRUE : FALSE;
					}
					else return !pelm.equals(next) ? TRUE : FALSE;
				}
				default: return FALSE;
			}
		}

		public String print(){
			return " " + oper.sign + " " + (next == null ? "" : next.print());
		}

	}

	public static class Value extends ScrExpr {
		
		private Elm elm;

		public Value(){
			elm = NullElm.NULL;
		}

		public Value(String tar, boolean number, boolean bool, boolean str){
			if(number){
				if(tar.contains(".")) elm = new FltElm(Float.parseFloat(tar));
				else elm = new IntElm(Integer.parseInt(tar));
			}
			else if(bool){
				elm = new BoolElm(tar.toLowerCase().equals("true"));
			}
			else if(str){
				elm = new StrElm(tar.substring(1));
			}
			else elm = NullElm.NULL;
		}

		@Override
		public Elm process(ScrBlock block, ScrExpr prev, Elm pelm){
			return next == null ? elm : next.process(block, this, elm);
		}

		public String print(){
			return elm.print_val() + (next == null ? "" : next.print());
		}

	}

	public abstract String print();

	public boolean isReturn(){ return false; }
	

}
