package net.fexcraft.mod.fvtm.model.block;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import net.fexcraft.lib.mc.api.registry.fModel;
import net.fexcraft.lib.mc.render.FCLBlockModel;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

@fModel(registryname = "fvtm:models/block/dynamic_rail")
public class RailModel implements FCLBlockModel {

	public RailModel(){
		//TODO
	}

	@Override
	public Collection<ModelRendererTurbo> getPolygons(IBlockState state, EnumFacing side, Map<String, String> args, long rand){
		return Collections.emptyList();
	}
	
}