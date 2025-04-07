package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Program;
import net.minecraftforge.fml.common.ICrashCallable;

import java.util.Map;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class CrashCallableModels implements ICrashCallable {

	@Override
	public String call() throws Exception {
		String string = "\n\tLast Model: " + DefaultModel.LAST.name + "\n";
		string += "\tRenderData: \n";
		if(RENDERDATA.entity != null) string += "\t\tENT=" + RENDERDATA.entity + "\n";
		if(RENDERDATA.tile != null) string += "\t\tTLE=" + RENDERDATA.tile + "\n";
		if(RENDERDATA.blockstate != null) string += "\t\tBST=" + RENDERDATA.blockstate + "\n";
		if(RENDERDATA.vehicle != null) string += "\t\tVEH=" + vehicle() + "\n";
		if(RENDERDATA.container != null) string += "\t\tCON=" + container() + "\n";
		if(RENDERDATA.blockstate != null) string += "\t\tBLK=" + block() + "\n";
		if(RENDERDATA.part != null) string += "\t\tPRT=" + part() + " / " + RENDERDATA.part_category + "\n";
		if(RENDERDATA.decoration != null) string += "\t\tDEC=" + RENDERDATA.decoration + "\n";
		string += "\t\tSR=" + RENDERDATA.separaterender + "\n";
		string += "\tRenderCache: \n";
		if(RENDERDATA.cache == null){
			string += "\t\tnull\n";
		}
		else if(RENDERDATA.cache.map().isEmpty()){
			string += "\t\tempty\n";
		}
		else{
			for(Map.Entry<Program, Object> entry : RENDERDATA.cache.map().entrySet()){
				string += "\t\t" + entry.toString() + "\n";
			}
		}
		return string;
	}

	private String vehicle(){
		return RENDERDATA.vehicle.getName() + " (" + RENDERDATA.vehicle.getType().getIDS() + ")";
	}

	private String container(){
		return RENDERDATA.container.getType().getName() + " (" + RENDERDATA.container.getType().getIDS() + ")";
	}

	private String block(){
		return RENDERDATA.block.getType().getName() + " (" + RENDERDATA.block.getType().getIDS() + ")";
	}

	private String part(){
		return RENDERDATA.part.getType().getName() + " (" + RENDERDATA.part.getType().getIDS() + ")";
	}

	@Override
	public String getLabel(){
		return "\n\tFVTM Rendering";
	}
	
}