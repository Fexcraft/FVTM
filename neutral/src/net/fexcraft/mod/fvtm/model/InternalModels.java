package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.frl.CompactModel;
import net.fexcraft.lib.frl.CompactParserBEO;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.content.BlockModel;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InternalModels {

	public static BlockModel FUEL_FILLER;
	public static Polyhedron ROAD_MARKER_MAIN;
	public static Polyhedron ROAD_MARKER_ARROW;

	public static void load(){
		FUEL_FILLER = (BlockModel)FvtmResources.getModel("fvtm:models/block/fuelfiller.bob", new ModelData(), BlockModel.class);
		try{
			CompactModel roadmarker = CompactParserBEO.parse(FvtmResources.getAssetInputStreamWithFallback("fvtm:models/entity/roadmarker.bob").stream(), 0.0625f, false);
			ROAD_MARKER_MAIN = roadmarker.groups.get("main").polyhedrons.get(0);
			ROAD_MARKER_ARROW = roadmarker.groups.get("arrow").polyhedrons.get(0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
