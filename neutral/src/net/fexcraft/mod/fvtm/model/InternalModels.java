package net.fexcraft.mod.fvtm.model;

import net.fexcraft.lib.frl.CompactModel;
import net.fexcraft.lib.frl.CompactParserBEO;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.FvtmResources.InputStreamWithFallback;
import net.fexcraft.mod.fvtm.model.content.BlockModel;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class InternalModels {

	public static BlockModel FUEL_FILLER;
	public static Polyhedron ROAD_MARKER_MAIN;
	public static Polyhedron ROAD_MARKER_ARROW;
	public static Polyhedron RAIL_MARKER_BASE;
	public static Polyhedron RAIL_MARKER_GLOW;
	public static Polyhedron RAIL_MARKER_ARROW;

	public static void load(){
		try{
			FUEL_FILLER = (BlockModel)FvtmResources.getModel("fvtm:models/block/fuelfiller.bob", new ModelData(), BlockModel.class);
			InputStreamWithFallback iswf = FvtmResources.getAssetInputStreamWithFallback("fvtm:models/entity/roadmarker.bob");
			CompactModel compact = CompactParserBEO.parse(iswf.stream(), 0.0625f, false);
			ROAD_MARKER_MAIN = compact.groups.get("main").polyhedrons.get(0);
			ROAD_MARKER_ARROW = compact.groups.get("arrow").polyhedrons.get(0);
			iswf.close();
			iswf = FvtmResources.getAssetInputStreamWithFallback("fvtm:models/entity/railmarker.bob");
			compact = CompactParserBEO.parse(iswf.stream(), 0.0625f, false);
			RAIL_MARKER_BASE = compact.groups.get("base").polyhedrons.get(0);
			RAIL_MARKER_GLOW = compact.groups.get("glow").polyhedrons.get(0);
			RAIL_MARKER_ARROW = compact.groups.get("arrow").polyhedrons.get(0);
			iswf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
