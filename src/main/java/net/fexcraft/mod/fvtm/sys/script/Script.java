/*
 * Copyright (c) 2022, Ferdinand Calo'. All rights reserved.
 *
 *
 */
package net.fexcraft.mod.fvtm.sys.script;

import static net.fexcraft.mod.fvtm.sys.script.ScrExprType.EXT_COND;
import static net.fexcraft.mod.fvtm.sys.script.ScrExprType.EXT_LEFT;
import static net.fexcraft.mod.fvtm.sys.script.ScrExprType.EXT_NONE;
import static net.fexcraft.mod.fvtm.sys.script.ScrExprType.EXT_RETURN;
import static net.fexcraft.mod.fvtm.sys.script.ScrExprType.EXT_RIGHT;
import static net.fexcraft.mod.fvtm.sys.script.elm.Elm.NULL;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.condition.Condition.Conditional;
import net.fexcraft.mod.fvtm.sys.condition.ConditionRegistry;
import net.fexcraft.mod.fvtm.sys.script.elm.Elm;
import net.fexcraft.mod.fvtm.sys.script.wrappers.VehicleScriptContext;

/**
 * "FEX Script" Version 1.0
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class Script extends ScrBlock {

	public static final ConcurrentHashMap<String, ConcurrentHashMap<String, Elm>> globals = new ConcurrentHashMap<>();
	public final HashMap<String, String> attrmap = new HashMap<>();
	public final HashMap<String, Conditional> conds = new HashMap<>();
	public final HashMap<String, ScrBlock> blocks = new HashMap<>();
	public final String id;
	
	public Script(InputStream stream, String scriptid){
		super(Type.SCRIPT, null, null, scriptid);
		script = this;
		Scanner scanner = new Scanner(stream);
		id = scriptid;
		String line = null;
		ScrBlock block = this;
		boolean ignore = false;
		try{
			while(scanner.hasNextLine()){
				line = scanner.nextLine().trim();
				if(ignore){
					if(line.endsWith("*/")) ignore = false;
					continue;
				}
				if(line.startsWith("//")) continue;
				if(line.startsWith("/*")){
					ignore = true;
					continue;
				}
				if(line.startsWith("}") || line.startsWith(";;")){
					block = block.rootnn();
					continue;
				}
				if(checkForDataTypes(block, line, block == this && line.startsWith("global"))) continue;
				if(line.startsWith("use ") && blocks.isEmpty()){
					line = line.substring(4);
					if(line.startsWith("attr ")){
						line = line.substring(5);
						int idx = line.indexOf("->");
						String attr = line.substring(0, idx).trim();
						String nick = line.substring(idx + 2).trim();
						attrmap.put(nick, attr);
					}
					else if(line.startsWith("cond ")){
						line = line.substring(5);
						int idx = line.indexOf("->");
						String cond = line.substring(0, idx).trim();
						String nick = line.substring(idx + 2).trim();
						Conditional condition = ConditionRegistry.get(cond);
						if(condition != null) conds.put(nick, condition);
					}
					continue;
				}
				if(block == this && line.startsWith("act ")){
					int idx0 = line.indexOf("(");
					String name = line.substring(4, idx0);
					String[] args = line.substring(idx0 + 1, line.indexOf(")")).split(",");
					ScrAction act = new ScrAction(this, name);
					for(String str : args){
						if(str.length() < 3) continue;
						String[] s = str.split(" ");
						act.locals.put(s[1], Elm.from(Elm.Type.from(s[0])));
						act.parameters.add(s[1]);
					}
					blocks.put(name, block = act);
					continue;
				}
				if(block != this){
					if(line.startsWith("if")){
						ScrBlock old = block;
						block = new ScrBlock(Type.IFELSE, this, block, "if");
						block.cond(new ScrCond(block, line.substring(line.indexOf("(") + 1, line.lastIndexOf(")"))));
						old.tasks.add(new ScrTask(ScrTask.Type.IFELSE, block));
						continue;
					}
					if(line.startsWith("elif") || line.startsWith("else if")){
						ScrTask last = block.lastTask();
						if(last == null || !last.type.ifelse() || last.closed) continue;
						block = new ScrBlock(Type.IFELSE, this, block, "elseif");
						block.cond(new ScrCond(block, line.substring(line.indexOf("(") + 1, line.lastIndexOf(")"))));
						last.add(block);
						continue;
					}
					if(line.startsWith("else")){
						ScrTask last = block.lastTask();
						if(last == null || !last.type.ifelse() || last.closed) continue;
						block = new ScrBlock(Type.IFELSE, this, block, "else");
						last.close(block);
						continue;
					}
					ScrExpr expr = parseExpression(line, EXT_NONE);
					if(expr != null){
						block.exprs.add(expr);
						block.tasks.add(new ScrTask(ScrTask.Type.LINE, expr));
					}
				}
			}
		}
		catch(Exception e){
			Print.log("Error while parsing script with ID '" + id + "'!");
			Print.log("Parsed till: \n" + print(0));
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
	}
	
	public static ScrExpr parseExpression(String line, ScrExprType current){
		ScrExpr expr = null, next, last = null;
		ParseExprParams par = new ParseExprParams(line, current);
		while((next = parseExpression(par)) != null){
			if(expr == null) expr = last = next;
			else (last.next != null ? last.next : last).next(last = next);
		}
		return expr;
	}
	
	//java records would be nice here
	private static class ParseExprParams {
		
		public ParseExprParams(String ln, ScrExprType curr){
			line = ln;
			current = curr;
		}
		
		//private ScrBlock block;
		private String line;
		private ScrExprType current;
		
		public ParseExprParams set(String ln, ScrExprType curr){
			//if(blk != null) block = blk;
			if(ln != null) line = ln;
			if(curr != null) current = curr;
			return this;
		}
		
	}

	protected static ScrExpr parseExpression(ParseExprParams par){
		par.line = par.line.trim();
		if(par.line.length() == 0) return null;
		if(par.current.returnable() && par.line.startsWith("return")){
			par.set(par.line.substring(6), EXT_RETURN);
			return new ScrExpr.Return();
		}
		if(par.current == EXT_NONE) par.current = EXT_LEFT;
		boolean left = par.current == EXT_LEFT;
		if(!left && par.line.startsWith("!")){
			par.line = par.line.substring(1);
			return new ScrExpr.Not();
		}
		if(!left && par.line.startsWith("-")){
			par.line = par.line.substring(1);
			return new ScrExpr.Negate();
		}
		char[] arr = par.line.toCharArray();
		int till0 = till(arr, 0, !left);
		if(till0 < 0) return null;
		String tar = par.line.substring(0, till0).trim();
		par.line = par.line.substring(till0).trim();
		if(par.line.length() < 2){
			par.line = "";
			if(tar.equals("null")) return new ScrExpr.Value();
			boolean bool = isb(tar), number = isn(tar.charAt(0)), str = tar.startsWith("\"");
			return number || bool || str ? new ScrExpr.Value(tar, number, bool, str) : new ScrExpr.Reference(tar);
		}
		if(par.line.startsWith(".")){
			par.line = par.line.substring(1);
			return new ScrExpr.Reference(tar);
		}
		if(par.line.startsWith("(")){
			ScrExpr.Exec exec = null;
			if(par.line.charAt(1) == ')'){
				exec = new ScrExpr.Exec(tar);
			}
			else{
				String pars = par.line.substring(par.line.indexOf("(") + 1, par.line.lastIndexOf(")"));
				exec = new ScrExpr.Exec(tar, pars.split(","));
			}
			par.line = par.line.substring(par.line.lastIndexOf(")") + 1);
			return exec;
		}
		ScrExpr.Reference ref = new ScrExpr.Reference(tar);
		if(par.current == EXT_LEFT){
			if(par.line.startsWith("=")){
				par.set(par.line.substring(1), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(null));
			}
			else if(par.line.startsWith("+=")){
				par.set(par.line.substring(2), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(ScrOper.ADD));
			}
			else if(par.line.startsWith("-=")){
				par.set(par.line.substring(2), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(ScrOper.SUB));
			}
			else if(par.line.startsWith("*=")){
				par.set(par.line.substring(2), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(ScrOper.MUL));
			}
			else if(par.line.startsWith("/=")){
				par.set(par.line.substring(2), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(ScrOper.DIV));
			}
			else if(par.line.startsWith("%=")){
				par.set(par.line.substring(2), EXT_RIGHT);
				return ref.next(new ScrExpr.Set(ScrOper.MOD));
			}
		}
		else if(par.current == EXT_COND){
			if(par.line.startsWith("==")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.EQL));
			}
			if(par.line.startsWith(">=")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.GRT_EQL));
			}
			if(par.line.startsWith("<=")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.LES_EQL));
			}
			if(par.line.startsWith(">")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Compare(ScrOper.GRT));
			}
			if(par.line.startsWith("<")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Compare(ScrOper.LES));
			}
			if(par.line.startsWith("!=")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.NOT_EQL));
			}
			if(par.line.startsWith("&&")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.AND));
			}
			if(par.line.startsWith("||")){
				par.line = par.line.substring(2);
				return ref.next(new ScrExpr.Compare(ScrOper.OR));
			}
		}
		else if(par.current == EXT_RIGHT){
			if(par.line.startsWith("+")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Math(ScrOper.ADD));
			}
			else if(par.line.startsWith("-")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Math(ScrOper.SUB));
			}
			else if(par.line.startsWith("*")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Math(ScrOper.MUL));
			}
			else if(par.line.startsWith("/")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Math(ScrOper.DIV));
			}
			else if(par.line.startsWith("%")){
				par.line = par.line.substring(1);
				return ref.next(new ScrExpr.Math(ScrOper.MOD));
			}
		}
		return null;
	}

	private static int till(char[] arr, int from, boolean dot){
		//if(po){
			boolean ia = dot && arr[from] == '"';
			for(int i = ia ? from + 1 : from; i < arr.length; i++){
				if(ia){
					if(arr[i] == '"' && arr[i - 1] != '\\') return i;
					continue;
				}
				if(arr[i] == '_' || arr[i] == ' ') continue;
				if(arr[i] >= 'a' && arr[i] <= 'z') continue;
				if(arr[i] >= 'A' && arr[i] <= 'Z') continue;
				if(isn(arr[i])) continue;
				if(dot && arr[i] == '.' && (i - 1 > 0 ? isn(arr[i]) : true) && (i + 1 < arr.length - 1 ? isn(arr[i]) : true)) continue;
				return i;
			}
			return arr.length;
		/*}
		else{
			for(int i = from; i < arr.length; i++){
				if(arr[i] == '_') return i;
				if(arr[i] >= 'a' && arr[i] <= 'z') return i;
				if(arr[i] >= 'A' && arr[i] <= 'Z') return i;
				if(arr[i] >= '0' && arr[i] <= '9') return i;
			}
			return -1;
		}*/
	}

	public static boolean isn(char c){
		return c >= '0' && c <= '9';
	}

	public static boolean isb(String str){
		str = str.toLowerCase();
		return str.equals("true") || str.equals("false");
	}

	private boolean checkForDataTypes(ScrBlock block, String line, boolean global){
		if(global) line = line.substring(7);
		Two<String, Elm> elm = null;
		if(line.startsWith("str ")){
			elm = Elm.parse(line, Elm.Type.STRING);
		}
		else if(line.startsWith("int ")){
			elm = Elm.parse(line, Elm.Type.INTEGER);
		}
		else if(line.startsWith("flt ")){
			elm = Elm.parse(line, Elm.Type.FLOAT);
		}
		else if(line.startsWith("bln ")){
			elm = Elm.parse(line, Elm.Type.BOOLEAN);
		}
		else if(line.startsWith("lis ")){
			elm = Elm.parse(line, Elm.Type.LIST);
		}
		else if(line.startsWith("obj ")){
			elm = Elm.parse(line, Elm.Type.OBJ);
		}
		else if(line.startsWith("cnd ")){
			elm = Elm.parse(line, Elm.Type.COND);
		}
		if(elm != null){
			if(global){
				if(!globals.contains(id)) globals.put(id, new ConcurrentHashMap<>());
				globals.get(id).put(elm.first, elm.second);
			}
			else block.locals.put(elm.first, elm.second);
			return true;
		}
		return false;
	}
	
	public static final <A, B> void insert(HashMap<A, B> map, Two<A, B> two){
		map.put(two.first, two.second);
	}

	@Override
	public Elm getElm(String elm, ScrBlock sub){
		if(locals.containsKey(elm)) return locals.get(elm);
		if(attrmap.containsKey(elm)){
			VehicleScriptContext con = (VehicleScriptContext)sub.locals.get("context");
			return con == null ? NULL : con.getAttribute(attrmap.get(elm));
		}
		if(globals.contains(id) && globals.get(id).containsKey(elm)) return globals.get(id).get(elm);
		return NULL;
	}

	public Elm getLocalScriptElm(String elm, Supplier<Elm> create){
		if(locals.containsKey(elm)) return locals.get(elm);
		else{
			locals.put(elm, create.get());
			return locals.get(elm);
		}
	}
	
	@Override
	protected String preprint(String ret, String tab, String tab1, int depth){
		//if(globals.size() > 0) ret += "\n";
		if(globals.contains(id)){
			for(HashMap.Entry<String, Elm> entry : globals.get(id).entrySet()){
				ret += tab1 + "global " + entry.getValue().type() + " " + entry.getKey() + " = " + entry.getValue().print_val() + "\n";
			}
		}
		//if(attrmap.size() > 0) ret += "\n";
		for(Entry<String, String> entry : attrmap.entrySet()){
			ret += tab1 + "using attr " + entry.getValue() + " as " + entry.getKey() + "\n";
		}
		//if(conds.size() > 0) ret += "\n";
		for(Entry<String, Conditional> entry : conds.entrySet()){
			ret += tab1 + "using cond '" + entry.getValue() + "'\n";
		}
		return ret;
	}
	
	@Override
	protected String postprint(String ret, String tab, String tab1, int depth){
		if(subs.size() > 0) ret += "\n";
		for(ScrBlock sub : subs){
			ret += sub.print(depth + 1);
		}
		return ret;
	}
	
	@Override
	public String toString(){
		return print();
	}
	
}
