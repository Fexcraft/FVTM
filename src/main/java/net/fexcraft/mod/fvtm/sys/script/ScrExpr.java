/*
 * Copyright (c) 2022, Ferdinand Calo' / "Fexcraft". All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import static net.fexcraft.mod.fvtm.sys.script.ScrElm.FALSE;
import static net.fexcraft.mod.fvtm.sys.script.ScrElm.NULL;
import static net.fexcraft.mod.fvtm.sys.script.ScrElm.TRUE;
import static net.fexcraft.mod.fvtm.sys.script.ScrElm.asBool;

import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

import net.fexcraft.mod.fvtm.sys.script.elm.BoolElm;
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
	
	public abstract ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm);

	public ScrExpr next(ScrExpr expr){
		next = expr;
		return this;
	}
	
	public static class Return extends ScrExpr {

		@Override
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			ScrElm elm = block.getElm(target, null);
			if(next == null) return elm;
			else if(next instanceof Reference){
				ScrExpr nex = next;
				while(nex instanceof Reference){
					elm = elm.scr_get(block, nex.target);
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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			return new BoolElm(!next.process(block, this, NULL).scr_bln());
		}

		public String print(){
			return "!" + (next == null ? "" : next.print());
		}

	}
	
	public static class Negate extends ScrExpr {

		@Override
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			ScrElm elm = next.process(block, this, NULL);
			return elm.scr_type().decimal() ? new FltElm(-elm.scr_flt()) : new IntElm(-elm.scr_int());
		}

		public String print(){
			return "-" + (next == null ? "" : next.print());
		}

	}

	public static class Exec extends ScrExpr {
		
		private ArrayList<ScrElm> args;

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
					ScrElm elm = null;
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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			if(next == null) return (pelm == NULL ? NULL.scr_exec(block, target, args) : pelm.scr_exec(block, target, args));
			else return next.process(block, this, (pelm == NULL ? NULL.scr_exec(block, target, args) : pelm.scr_exec(block, target, args)));
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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			if(!pelm.scr_type().primitive() && oper != ScrOper.SET) return NULL;
			ScrElm nex = next.process(block, this, NULL);
			switch(oper){
				case SET:{
					if(pelm.scr_type().decimal()) pelm.scr_set(nex.scr_flt());
					else if(pelm.scr_type().integer()) pelm.scr_set(nex.scr_int());
					else if(pelm.scr_type().bool()) pelm.scr_set(nex.scr_bln());
					else if(pelm.scr_type().string()) pelm.scr_set(nex.scr_str());
					else pelm.scr_set(nex);
					break;
				}
				case ADD:{
					if(pelm.scr_type().decimal()) pelm.scr_set(pelm.scr_flt() + nex.scr_flt());
					else pelm.scr_set(pelm.scr_int() + nex.scr_int());
					break;
				}
				case SUB:{
					if(pelm.scr_type().decimal()) pelm.scr_set(pelm.scr_flt() - nex.scr_flt());
					else pelm.scr_set(pelm.scr_int() - nex.scr_int());
					break;
				}
				case DIV:{
					if(pelm.scr_type().decimal()) pelm.scr_set(pelm.scr_flt() / nex.scr_flt());
					else pelm.scr_set(pelm.scr_int() / nex.scr_int());
					break;
				}
				case MUL:{
					if(pelm.scr_type().decimal()) pelm.scr_set(pelm.scr_flt() * nex.scr_flt());
					else pelm.scr_set(pelm.scr_int() * nex.scr_int());
					break;
				}
				case MOD:{
					if(pelm.scr_type().decimal()) pelm.scr_set(pelm.scr_flt() % nex.scr_flt());
					else pelm.scr_set(pelm.scr_int() % nex.scr_int());
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
			this.oper = oper;
		}

		@Override
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			ScrElm nex = next.process(block, this, NULL);
			if((pelm.scr_type().string() || nex.scr_type().string()) && oper == ScrOper.ADD){
				return new StrElm(pelm.scr_str() + nex.scr_str());
			}
			boolean deci = pelm.scr_type().decimal() || nex.scr_type().decimal();
			ScrElm res = pelm.scr_type().integer() ? new IntElm(0) : new FltElm(0f);
			switch(oper){
				case ADD:{
					if(deci) res.scr_set(pelm.scr_flt() + nex.scr_flt());
					else res.scr_set(pelm.scr_int() + nex.scr_int());
					break;
				}
				case SUB:{
					if(deci) res.scr_set(pelm.scr_flt() - nex.scr_flt());
					else res.scr_set(pelm.scr_int() - nex.scr_int());
					break;
				}
				case DIV:{
					if(deci) res.scr_set(pelm.scr_flt() / nex.scr_flt());
					else res.scr_set(pelm.scr_int() / nex.scr_int());
					break;
				}
				case MUL:{
					if(deci) res.scr_set(pelm.scr_flt() * nex.scr_flt());
					else res.scr_set(pelm.scr_int() * nex.scr_int());
					break;
				}
				case MOD:{
					if(deci) res.scr_set(pelm.scr_flt() % nex.scr_flt());
					else res.scr_set(pelm.scr_int() % nex.scr_int());
					break;
				}
				default: break;
			}
			return res;
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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			ScrElm next = this.next.process(block, this, pelm);
			switch(oper){
				case GRT: return pelm.scr_flt() > next.scr_flt() ? TRUE : FALSE;
				case GRT_EQL: return pelm.scr_flt() >= next.scr_flt() ? TRUE : FALSE;
				case LES: return pelm.scr_flt() < next.scr_flt() ? TRUE : FALSE;
				case LES_EQL: return pelm.scr_flt() <= next.scr_flt() ? TRUE : FALSE;
				case NOT_EQL:{
					if(pelm.scr_type().number()){
						return pelm.scr_flt() != next.scr_flt() ? TRUE : FALSE;
					}
					else if(pelm.scr_type().boolcond()){
						return pelm.scr_bool(block, prev, pelm) != next.scr_bool(block, prev, pelm) ? TRUE : FALSE;
					}
					else return !pelm.equals(next) ? TRUE : FALSE;
				}
				case EQL:{
					if(pelm.scr_type().number()){
						return pelm.scr_flt() == next.scr_flt() ? TRUE : FALSE;
					}
					else if(pelm.scr_type().boolcond()){
						return pelm.scr_bool(block, prev, pelm) == next.scr_bool(block, prev, pelm) ? TRUE : FALSE;
					}
					else return pelm.equals(next) ? TRUE : FALSE;
				}
				case AND:{
					return asBool(pelm.scr_bool(block, prev, pelm) && next.scr_bool(block, prev, pelm));
				}
				case OR:{
					return asBool(pelm.scr_bool(block, prev, pelm) || next.scr_bool(block, prev, pelm));
				}
				default: return FALSE;
			}
		}

		public String print(){
			return " " + oper.sign + " " + (next == null ? "" : next.print());
		}

	}

	public static class Value extends ScrExpr {
		
		private ScrElm elm;

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
		public ScrElm process(ScrBlock block, ScrExpr prev, ScrElm pelm){
			return next == null ? elm : next.process(block, this, elm);
		}

		public String print(){
			return elm.scr_print() + (next == null ? "" : next.print());
		}

	}

	public abstract String print();

	public boolean isReturn(){ return false; }
	

}
