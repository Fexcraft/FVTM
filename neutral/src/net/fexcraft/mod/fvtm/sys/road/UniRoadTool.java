package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.CompatUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static net.fexcraft.lib.common.utils.Formatter.format;
import static net.fexcraft.mod.fvtm.Config.MAX_ROAD_LENGTH;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniRoadTool {

	public static final Object[] NA = new Object[0];
	public static final V3D HCENTER = new V3D(0.5, 0, 0.5);

	public static void addTooltip(TagCW com, List<String> list, BiFunction<String, Object[], String> translator){
		list.add(format(translator.apply("tooltip.fvtm.road_tool.toolbox", NA)));
		if(com.empty()){
			list.add(format(translator.apply("tooltip.fvtm.road_tool.empty", NA)));
		}
		else{
			int[] layers = com.getIntArray("RoadLayers");
			if(layers.length < 6){
				int[] n = new int[6];
				for(int i = 0; i < 6; i++){
					n[i] = i >= layers.length ? 0 : layers[i];
				}
				com.set("RoadLayers", layers = n);
			}
			StackWrapper stack = null;
			if(com.has("CustomRoadFill")){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.road_fill_custom", new Object[]{ layers[0] })));
			}
			else{
				stack = UniStack.createStack(com.getCompound("RoadFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.road_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			if(com.has("BottomFill") && layers[1] > 0){
				stack = UniStack.createStack(com.getCompound("BottomFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.ground_fill", new Object[]{ stack.getName() })));
			}
			if(com.has("SideLeftFill") && layers[2] > 0){
				stack = UniStack.createStack(com.getCompound("SideLeftFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.left_fill", new Object[]{ stack.getName(), layers[2] })));
			}
			if(com.has("SideRightFill") && layers[2] > 0){
				stack = UniStack.createStack(com.getCompound("SideRightFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.right_fill", new Object[]{ stack.getName(), layers[3] })));
			}
			//
			if(com.has("CustomTopFill") && layers[4] > 0){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.top_fill_custom", new Object[]{ layers[0] })));
			}
			else if(com.has("TopFill") && layers[4] > 0){
				stack = UniStack.createStack(com.getCompound("TopFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.top_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			//
			if(com.has("CustomLinesFill") && layers[5] > 0){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.lines_fill_custom", new Object[]{ layers[0] })));
			}
			else if(com.has("LinesFill") && layers[5] > 0){
				stack = UniStack.createStack(com.getCompound("LinesFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.lines_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			list.add(format(translator.apply("tooltip.fvtm.road_tool.undo", NA)));
		}
	}

	public static int onUse(Passenger pass, boolean main){
		if(pass.getWorld().isClient()) return 0;
		if(!pass.isCreative()){
			pass.send("tooltip.fvtm.road_tool.creative");
			return 1;
		}
		if(pass.isShiftDown() && main){
			pass.openUI(UIKeys.ROAD_TOOL, V3I.NULL);
			return 2;
		}
		return 3;
	}

	public static boolean placeRoad(Passenger pass, StackWrapper stack, Road _road){
		if(_road.length > MAX_ROAD_LENGTH){
			pass.bar("interact.fvtm.road_tool.too_long");
			return false;
		}
		TagCW tag = stack.copyTag();
		int[] layers = tag.getIntArray("RoadLayers");
		StackWrapper top = null;
		StackWrapper bot = null;
		StackWrapper left = null;
		StackWrapper righ = null;
		StackWrapper line_b = null;
		StackWrapper road_b = null;
		ArrayList<QV3D> roof;
		ArrayList<QV3D> ground = null;
		ArrayList<QV3D> border_l = null;
		ArrayList<QV3D> border_r = null;
		ArrayList<QV3D> line;
		ArrayList<QV3D> road;
		int top_h = 0;
		int border_hl = 0;
		int border_hr = 0;
		ArrayList<ArrayList<QV3D>> rooffill = null;
		ArrayList<ArrayList<QV3D>> linefill = null;
		ArrayList<ArrayList<QV3D>> roadfill = null;
		boolean flnk = false;
		if(tag.has("RoadFill")){
			road_b = UniStack.createStack(tag.getCompound("RoadFill"));
			flnk = CompatUtil.isValidFurenikus(road_b.getIDL());
		}
		if(layers[1] > 0 && tag.has("BottomFill")){
			bot = UniStack.createStack(tag.getCompound("BottomFill"));
			ground = new ArrayList<>();
		}
		if(layers[2] > 0 && tag.has("SideLeftFill")){
			left = UniStack.createStack(tag.getCompound("SideLeftFill"));
			border_hl = layers[2];
			border_l = new ArrayList<>();
		}
		if(layers[3] > 0 && tag.has("SideRightFill")){
			righ = UniStack.createStack(tag.getCompound("SideRightFill"));
			border_hr = layers[3];
			border_r = new ArrayList<>();
		}
		if(layers[4] > 0 && tag.has("TopFill") && !tag.has("CustomTopFill")){
			top = UniStack.createStack(tag.getCompound("TopFill"));
		}
		if(layers[5] > 0 && tag.has("LinesFill") && !tag.has("CustomLinesFill")){
			line_b = UniStack.createStack(tag.getCompound("LinesFill"));
		}
		top_h = border_hl > border_hr ? border_hl : border_hr;
		if(top_h == 0){
			if(layers[5] > 0){
				border_hl++;
				border_hr++;
				top_h = 2;
			}
			top_h = 1;
		}
		ArrayList<StackWrapper> roadfill_b = null;
		ArrayList<StackWrapper> rooffill_b = null;
		ArrayList<StackWrapper> linefill_b = null;
		if(tag.has("CustomRoadFill")){
			roadfill = new ArrayList<>();
			roadfill_b = new ArrayList<>();
			loadFill(roadfill, roadfill_b, layers[0], tag.getCompound("CustomRoadFill"));
		}
		if(layers[4] > 0 && tag.has("CustomTopFill")){
			rooffill = new ArrayList<>();
			rooffill_b = new ArrayList<>();
			loadFill(rooffill, rooffill_b, layers[0], tag.getCompound("CustomTopFill"));
		}
		if(layers[5] > 0 && tag.has("CustomLinesFill")){
			linefill = new ArrayList<>();
			linefill_b = new ArrayList<>();
			loadFill(linefill, linefill_b, layers[0], tag.getCompound("CustomLinesFill"));
		}
		V3I pos = new V3I();
		V3D last;
		V3D vec;
		StateWrapper state;
		int width = layers[0];
		double angle;
		double passed = 0.001;
		double half = width * 0.5 - 0.5;
		road = roadfill == null && road_b != null ? new ArrayList<>() : null;
		roof = rooffill == null && layers[4] > 0 ? new ArrayList<>() : null;
		line = linefill == null && layers[5] > 0 ? new ArrayList<>() : null;
		vec = _road.vecpath[0];
		double off = roadfill == null ? 0 : 0.25;
		while(passed < _road.length){
			last = vec;
			vec = _road.getVectorPosition(passed, false);
			angle = Math.atan2(last.x - vec.x, last.z - vec.z);
			for(double db = -half; db <= half; db += 0.25){
				if(road != null) road.add(gen(vec, angle, db, 0));
				if(ground != null) ground.add(gen(vec, angle, db + off, -1));
				if(line != null) line.add(gen(vec, angle, db, 1));
				if(roof != null) roof.add(gen(vec, angle, db, top_h));
			}
			if(roadfill != null){
				for(int i = 0; i < roadfill.size(); i++){
					roadfill.get(i).add(gen(vec, angle, -half + off + i, 0));
				}
			}
			if(linefill != null){
				for(int i = 0; i < linefill.size(); i++){
					linefill.get(i).add(gen(vec, angle, -half + off + i, 1));
				}
			}
			if(rooffill != null){
				for(int i = 0; i < rooffill.size(); i++){
					rooffill.get(i).add(gen(vec, angle, -half + off + i, top_h));
				}
			}
			if(border_l != null) border_l.add(gen(vec, angle, -half - 1 + off, 0));
			if(border_r != null) border_r.add(gen(vec, angle, half + 1 + off, 0));
			if(passed < 0.1) passed = 0;
			passed += 0.125;
		}
		WorldW world = pass.getWorld();
		JsonMap map = new JsonMap();
		if(road != null){
			roadFill(world, pass, road, pos, road_b, top_h, flnk, map);
		}
		StackWrapper block = null;
		if(roadfill != null){
			for(int i = 0; i < roadfill.size(); i++){
				block = roadfill_b.get(i);
				flnk = CompatUtil.isValidFurenikus(block.getIDL());
				roadFill(world, pass, roadfill.get(i), pos, block, top_h, flnk, map);
			}
		}
		if(linefill != null){
			for(int i = 0; i < linefill.size(); i++){
				basicFill(world, pass, linefill.get(i), pos, linefill_b.get(i), map);
			}
		}
		if(rooffill != null){
			for(int i = 0; i < rooffill.size(); i++){
				basicFill(world, pass, rooffill.get(i), pos, rooffill_b.get(i), map);
			}
		}
		if(border_l != null){
			borderFill(world, pass, border_l, pos, left, border_hl, map);
		}
		if(border_r != null){
			borderFill(world, pass, border_r, pos, righ, border_hr, map);
		}
		if(ground != null){
			for(QV3D v : ground){
				pos.set(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				state = world.getStateAt(pos);
				if(!((FvtmWorld)world).isFvtmRoad(state) && !CompatUtil.isValidFurenikus(state.getIDL())){
					insert(map, pos, state);
					world.setBlockState(pos, StateWrapper.from(bot, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true)));
				}
			}
		}
		if(line != null){
			for(QV3D v : line){
				pos.set(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				insert(map, pos, world.getStateAt(pos));
				world.setBlockState(pos, StateWrapper.from(line_b, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true)));
			}
		}
		if(roof != null){
			for(QV3D v : roof){
				pos.set(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				try{
					insert(map, pos, world.getStateAt(pos));
					world.setBlockState(pos, StateWrapper.from(top, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true)));
				}
				catch(Exception e){
					FvtmLogger.log(e, "road top/ceiling creation");
				}
			}
		}
		pass.bar("interact.fvtm.road_tool.complete");
		RoadPlacingCache.addEntry(pass.getUUID(), pass.dimid(), map);
		tag.set("LastRoadDim", pass.dimid());
		stack.updateTag(tag);
		return true;
	}

	private static void insert(JsonMap map, V3I pos, StateWrapper state){
		if(map.has(pos.asString())) return;
		JsonArray array = new JsonArray();
		array.add(state.getIDL().colon());
		if(EnvInfo.is112()) array.add(state.get12Meta());
		map.add(pos.asString(), array);
	}

	private static void loadFill(ArrayList<ArrayList<QV3D>> fill, ArrayList<StackWrapper> bill, int width, TagCW com){
		for(int i = 0; i < width; i++){
			fill.add(new ArrayList<>());
			StackWrapper stack = StackWrapper.EMPTY;
			if(com.has("Block" + i)){
				stack = UniStack.createStack(com.getCompound("Block" + i));
			}
			bill.add(stack);
		}
	}

	private static void roadFill(WorldW world, Passenger pass, ArrayList<QV3D> road, V3I pos, StackWrapper stack, int th, boolean flnk, JsonMap map){
		int height;
		StateWrapper state;
		StateWrapper block;
		for(QV3D vec : road){
			height = vec.y;
			pos.set(vec.pos.x, vec.pos.y + (vec.y > 0 ? 1 : 0), vec.pos.z);
			state = world.getStateAt(pos);
			block = StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true));
			if(!isRoad(world, state, block) || isLower(world, state, height)){
				if(isRoad(world, world.getStateAt(pos.add(0, 1, 0)))) height = 0;
				insert(map, pos, state);
				world.setBlockState(pos, ((FvtmWorld)world).getRoadWithHeight(block, CompatUtil.getRoadHeight(height, flnk)));
			}
			if((height < 9 && height != 0) || isRoad(world, world.getStateAt(pos.add(0, -1, 0)))){
				V3I down = pos.add(0, -1, 0);
				insert(map, down, world.getStateAt(down));
				world.setBlockState(down, ((FvtmWorld)world).getRoadWithHeight(block, CompatUtil.getRoadHeight(0, flnk)));
			}
			int c = th < 4 ? 4 : th;
			for(int i = 1; i < c; i++){
				pos.y++;
				insert(map, pos, world.getStateAt(pos));
				world.setBlockState(pos, StateWrapper.DEFAULT);
			}
		}
	}

	private static void basicFill(WorldW world, Passenger pass, ArrayList<QV3D> vecs, V3I pos, StackWrapper stack, JsonMap map){
		StateWrapper state;
		StateWrapper block;
		for(QV3D v : vecs){
			pos.set(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
			block = StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true));
			state = world.getStateAt(pos);
			if(state.getBlock() != block.getBlock()){
				insert(map, pos, state);
				world.setBlockState(pos, block);
			}
		}
	}

	private static void borderFill(WorldW world, Passenger pass, ArrayList<QV3D> vecs, V3I pos, StackWrapper stack, int top, JsonMap map){
		for(QV3D v : vecs){
			pos.set(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
			for(int i = -1; i < top; i++){
				V3I vp = pos.add(0, i, 0);
				insert(map, vp, world.getStateAt(vp));
				world.setBlockState(vp, StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true)));
			}
		}
	}

	private static boolean isRoad(WorldW world, StateWrapper state, StateWrapper block){
		return isRoad(world, state) && state.getBlock() == block.getBlock();
	}

	private static boolean isRoad(WorldW world, StateWrapper state){
		return ((FvtmWorld)world).isFvtmRoad(state) || CompatUtil.isValidFurenikus(state.getIDL());
	}

	private static boolean isLower(WorldW world, StateWrapper state, int height){
		return ((FvtmWorld)world).getRoadHeight(state) < height;
	}

	public static class Road extends Path {

		public Road(QV3D[] gridvecs){
			super(gridvecs);
		}

		public Road(QV3D[] gridvecs, QV3D vector){
			super(gridvecs, vector);
		}

		@Override
		public V3D getVectorPosition(double distance, boolean reverse){
			return super.getVectorPosition0(distance, reverse);
		}

		@Override
		public PathType getType(){
			return PathType.ROAD;
		}

	}

	public static V3D grv(double rad, V3D vec){
		double co = -Math.cos(rad), si = Math.sin(rad);
		return new V3D(co * vec.x, vec.y, si * vec.x);
	}

	public static V3D grv(double rad, double x, double y){
		return new V3D(-Math.cos(rad) * x, y, Math.sin(rad) * x);
	}

	public static QV3D gen(V3D vec, double rad, double x, double y){
		return new QV3D(vec.add(grv(rad, x, y)));
	}

}
