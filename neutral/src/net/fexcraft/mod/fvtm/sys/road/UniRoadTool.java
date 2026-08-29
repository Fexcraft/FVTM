package net.fexcraft.mod.fvtm.sys.road;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.sys.uni.FvtmWorld;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.CompatUtil;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.UniPerm;
import net.fexcraft.mod.uni.inv.StackWrapper;
import net.fexcraft.mod.uni.inv.UniStack;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.EntityW;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WorldW;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static net.fexcraft.lib.common.utils.Formatter.format;
import static net.fexcraft.mod.fvtm.Config.MAX_ROAD_LENGTH;
import static net.fexcraft.mod.fvtm.FvtmRegistry.is112;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniRoadTool {

	public static String TAG_KEY = "RoadToolData";
	public static final Object[] NA = new Object[0];
	public static final V3D HCENTER = new V3D(0.5, 0, 0.5);

	public static void addTooltip(TagCW rcom, List<String> list, BiFunction<String, Object[], String> translator){
		list.add(format(translator.apply("tooltip.fvtm.road_tool.toolbox", NA)));
		if(rcom.empty() || !rcom.has(TAG_KEY)){
			list.add(format(translator.apply("tooltip.fvtm.road_tool.empty", NA)));
		}
		else{
			TagCW com = rcom.getCompound(TAG_KEY);
			int width  = com.getInteger("Width");
			boolean bot = com.getBoolean("Ground");
			boolean top = com.getBoolean("Top");
			boolean lin = com.getBoolean("Lines");
			int rheight  = com.getInteger("RHeight");
			int lheight  = com.getInteger("LHeight");
			StackWrapper stack = null;
			if(com.has("CustomRoadFill")){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.road_fill_custom", new Object[]{ width })));
			}
			else if(com.has("RoadFill")){
				stack = UniStack.createStack(com.getCompound("RoadFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.road_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			if(com.has("CustomSlabFill")){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.slab_fill_custom", new Object[]{ width })));
			}
			else if(com.has("SlabFill")){
				stack = UniStack.createStack(com.getCompound("SlabFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.slab_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			if(com.has("BottomFill") && bot){
				stack = UniStack.createStack(com.getCompound("BottomFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.ground_fill", new Object[]{ stack.getName() })));
			}
			if(com.has("SideLeftFill") && lheight > 0){
				stack = UniStack.createStack(com.getCompound("SideLeftFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.left_fill", new Object[]{ stack.getName(), lheight })));
			}
			if(com.has("SideRightFill") && rheight > 0){
				stack = UniStack.createStack(com.getCompound("SideRightFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.right_fill", new Object[]{ stack.getName(), rheight })));
			}
			//
			if(com.has("CustomTopFill") && top){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.top_fill_custom", new Object[]{ width })));
			}
			else if(com.has("TopFill") && top){
				stack = UniStack.createStack(com.getCompound("TopFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.top_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			//
			if(com.has("CustomLinesFill") && lin){
				list.add(format(translator.apply("tooltip.fvtm.road_tool.lines_fill_custom", new Object[]{ width })));
			}
			else if(com.has("LinesFill") && lin){
				stack = UniStack.createStack(com.getCompound("LinesFill"));
				list.add(format(translator.apply("tooltip.fvtm.road_tool.lines_fill", new Object[]{ stack.getName(), stack.count() })));
			}
			list.add(format(translator.apply("tooltip.fvtm.road_tool.undo", NA)));
		}
	}

	public static int onUse(EntityW pass, boolean main){
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

	public static boolean placeRoad(EntityW pass, StackWrapper stack, Road _road){
		if(_road.length > MAX_ROAD_LENGTH){
			pass.bar("interact.fvtm.road_tool.too_long");
			return false;
		}
		if(!UniPerm.has(pass, "fvtm.admin")){
			pass.send("no `fvtm.admin` perm");
			return false;
		}
		TagCW com = stack.directTag().getCompound(TAG_KEY);
		int width  = com.getInteger("Width");
		//
		SlabLayerFill road = new SlabLayerFill(width, com, "RoadFill", "SlabFill", "CustomRoadFill", "CustomSlabFill");
		LayerFill ground = new LayerFill(width, com, "Ground", "BottomFill");
		LayerFill top = new LayerFill(width, com, "Top", "TopFill", "CustomTopFill");
		LayerFill line = new LayerFill(width, com, "Lines", "LinesFill", "CustomLinesFill");
		//
		int rheight  = com.getInteger("RHeight");
		int lheight  = com.getInteger("LHeight");
		StackWrapper left = null;
		StackWrapper righ = null;
		ArrayList<QV3D> border_l = null;
		ArrayList<QV3D> border_r = null;
		int top_h = 0;
		int border_hl = 0;
		int border_hr = 0;
		if(lheight > 0 && com.has("SideLeftFill")){
			left = UniStack.createStack(com.getCompound("SideLeftFill"));
			border_hl = lheight;
			border_l = new ArrayList<>();
		}
		if(rheight > 0 && com.has("SideRightFill")){
			righ = UniStack.createStack(com.getCompound("SideRightFill"));
			border_hr = rheight;
			border_r = new ArrayList<>();
		}
		top_h = border_hl > border_hr ? border_hl : border_hr;
		if(top_h == 0){
			if(line.on()){
				border_hl++;
				border_hr++;
				top_h = 2;
			}
			else top_h = 1;
		}
		V3I pos = new V3I();
		V3D last, vec = _road.vecpath[0];
		double angle;
		double passed = 0.001;
		double half = width * 0.5 - 0.5;
		while(passed < _road.length){
			last = vec;
			vec = _road.getVectorPosition(passed, false);
			angle = Math.atan2(last.x - vec.x, last.z - vec.z);
			if(ground.on()){
				for(int i = 0; i < width; i++){
					ground.pos.get(i).add(gen(vec, angle, -half + i, -1));
				}
			}
			if(road.on()){
				for(int i = 0; i < width; i++){
					road.pos.get(i).add(gen(vec, angle, -half + i, 0));
				}
			}
			if(line.on()){
				for(int i = 0; i < width; i++){
					line.pos.get(i).add(gen(vec, angle, -half + i, 1));
				}
			}
			if(top.on()){
				for(int i = 0; i < width; i++){
					top.pos.get(i).add(gen(vec, angle, -half + i, top_h));
				}
			}
			if(border_l != null) border_l.add(gen(vec, angle, -half - 1, 0));
			if(border_r != null) border_r.add(gen(vec, angle, half + 1, 0));
			if(passed < 0.1) passed = 0;
			passed += 0.125;
		}
		WorldW world = pass.getWorld();
		JsonMap map = new JsonMap();
		if(ground.on()){
			for(int i = 0; i < width; i++){
				basicFill(world, pass, ground.pos.get(i), pos, ground.blk.get(i), map, true);
			}
		}
		if(border_l != null){
			borderFill(world, pass, border_l, pos, left, border_hl, map);
		}
		if(border_r != null){
			borderFill(world, pass, border_r, pos, righ, border_hr, map);
		}
		if(road.on()){
			StackWrapper block;
			for(int i = 0; i < width; i++){
				block = road.blk.get(i);
				StackWrapper slb = road.son() ? road.slb.get(i) : StackWrapper.EMPTY;
				road.flnk = CompatUtil.isValidFurenikus(block.getIDL());
				road.vani = !road.flnk && !block.getID().equals("fvtm:asphalt") && !block.isItemOf(ContentType.BLOCK.item_type);;
				roadFill(world, pass, road.pos.get(i), pos, block, slb, top_h, road.flnk, road.vani, map);
			}
		}
		if(line.on()){
			for(int i = 0; i < width; i++){
				basicFill(world, pass, line.pos.get(i), pos, line.blk.get(i), map, false);
			}
		}
		if(top.on()){
			for(int i = 0; i < width; i++){
				basicFill(world, pass, top.pos.get(i), pos, top.blk.get(i), map, false);
			}
		}
		pass.bar("interact.fvtm.road_tool.complete");
		RoadPlacingCache.addEntry(pass.getUUID(), pass.getWorld().type().side_key(), map);
		com.set("LastRoadDim", pass.getWorld().type().side_key());
		stack.updateTag(tag -> tag.set(TAG_KEY, com));
		return true;
	}

	private static void insert(JsonMap map, V3I pos, StateWrapper state){
		if(map.has(pos.asString())) return;
		JsonArray array = new JsonArray();
		array.add(state.getIDL().colon());
		if(EnvInfo.is112()) array.add(state.get12Meta());
		map.add(pos.asString(), array);
	}

	private static void roadFill(WorldW world, EntityW pass, ArrayList<QV3D> road, V3I pos, StackWrapper stack, StackWrapper slab, int th, boolean flnk, boolean vani, JsonMap map){
		int height;
		StateWrapper state;
		StateWrapper block;
		StateWrapper sslab;
		for(QV3D vec : road){
			height = vec.y;
			round(vec, pos);
			state = world.getStateAt(pos);
			block = StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true));
			if(!isRoad(world, state, block) || isLower(world, state, height)){
				if(isRoad(world, world.getStateAt(pos.add(0, 1, 0)))) height = 0;
				insert(map, pos, state);
				if(vani){
					sslab = StateWrapper.from(height < 9 && height != 0 ? slab : stack, new StateWrapper.PlacingContext(world, !is112 ? pos.add(0, 1, 0) : pos, HCENTER, null, pass, true));
					world.setBlockState(pos, sslab);
				}
				else{
					world.setBlockState(pos, ((FvtmWorld)world).getRoadWithHeight(block, CompatUtil.getRoadHeight(height, flnk)));
				}
			}
			if((height < 9 && height != 0) || isRoad(world, world.getStateAt(pos.add(0, -1, 0)))){
				V3I down = pos.add(0, -1, 0);
				insert(map, down, world.getStateAt(down));
				if(vani){
					sslab = StateWrapper.from(stack, new StateWrapper.PlacingContext(world, down, HCENTER, null, pass, true));
					world.setBlockState(down, sslab);
				}
				else{
					world.setBlockState(down, ((FvtmWorld)world).getRoadWithHeight(block, CompatUtil.getRoadHeight(0, flnk)));
				}
			}
			int c = th < 4 ? 4 : th;
			for(int i = 1; i < c; i++){
				pos.y++;
				insert(map, pos, world.getStateAt(pos));
				world.setBlockState(pos, StateWrapper.DEFAULT);
			}
		}
	}

	private static void basicFill(WorldW world, EntityW pass, ArrayList<QV3D> vecs, V3I pos, StackWrapper stack, JsonMap map, boolean rc){
		StateWrapper state;
		StateWrapper block;
		for(QV3D v : vecs){
			round(v, pos);
			block = StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true));
			state = world.getStateAt(pos);
			if(rc && (((FvtmWorld)world).isFvtmRoad(state) || CompatUtil.isValidFurenikus(state.getIDL()))) continue;
			if(state.getBlock() != block.getBlock()){
				insert(map, pos, state);
				world.setBlockState(pos, block);
			}
		}
	}

	private static void borderFill(WorldW world, EntityW pass, ArrayList<QV3D> vecs, V3I pos, StackWrapper stack, int top, JsonMap map){
		StateWrapper state;
		for(QV3D v : vecs){
			round(v, pos);
			for(int i = -1; i < top; i++){
				V3I vp = pos.add(0, i, 0);
				state = world.getStateAt(vp);
				if(((FvtmWorld)world).isFvtmRoad(state) || CompatUtil.isValidFurenikus(state.getIDL())) break;
				insert(map, vp, world.getStateAt(vp));
				world.setBlockState(vp, StateWrapper.from(stack, new StateWrapper.PlacingContext(world, pos, HCENTER, null, pass, true)));
			}
		}
	}

	public static void round(QV3D qv, V3I pos){
		/*double x = qv.vec.x % 1d;
		double z = qv.vec.z % 1d;
		x = x < 0 ? x < -.5 ? -2 : -1 : x > .5 ? 1 : 0;
		z = z < 0 ? z < -.5 ? -2 : -1 : z > .5 ? 1 : 0;*/
		pos.set(qv.pos.x + (qv.pos.x < 0 ? -1 : 0), qv.pos.y + (qv.y > 0 ? 1 : 0), qv.pos.z + (qv.pos.z < 0 ? -1 : 0));
	}

	public static QV3D round(V3D vec){
		return new QV3D((int)vec.x + (vec.x < 0 ? -1 : 0), vec.y, (int)vec.z + (vec.z < 0 ? -1 : 0));
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
		return new V3D(-Math.cos(rad) * vec.x, vec.y, Math.sin(rad) * vec.x);
	}

	public static V3D grv(double rad, double x, double y){
		return new V3D(-Math.cos(rad) * x, y, Math.sin(rad) * x);
	}

	public static QV3D gen(V3D vec, double rad, double x, double y){
		return new QV3D(vec.add(grv(rad, x, y)));
	}

	public static class LayerFill {

		protected ArrayList<ArrayList<QV3D>> pos = null;
		protected ArrayList<StackWrapper> blk = null;

		public LayerFill(){}

		public LayerFill(int width, TagCW com, String key_on, String key_stack){
			if(!com.getBoolean(key_on) || !com.has(key_stack)) return;
			StackWrapper stk = UniStack.createStack(com.getCompound(key_stack));
			pos = new ArrayList<>();
			blk = new ArrayList<>();
			for(int i = 0; i < width; i++){
				pos.add(new ArrayList<>());
				blk.add(stk);
			}
		}

		public LayerFill(int width, TagCW com, String key_on, String key_stack, String key_custom){
			if(!com.getBoolean(key_on)) return;
			pos = new ArrayList<>();
			blk = new ArrayList<>();
			StackWrapper stk;
			if(com.has(key_stack) && !com.has(key_custom)){
				stk = UniStack.createStack(com.getCompound(key_stack));
				for(int i = 0; i < width; i++){
					pos.add(new ArrayList<>());
					blk.add(stk);
				}
			}
			else if(com.has(key_custom)){
				com = com.getCompound(key_custom);
				for(int i = 0; i < width; i++){
					pos.add(new ArrayList<>());
					stk = StackWrapper.EMPTY;
					if(com.has("Block" + i)){
						stk = UniStack.createStack(com.getCompound("Block" + i));
					}
					blk.add(stk);
				}
			}
		}

		public boolean on(){
			return blk != null;
		}

	}

	public static class SlabLayerFill extends LayerFill {

		protected ArrayList<StackWrapper> slb = null;
		protected boolean vani;
		protected boolean flnk;

		public SlabLayerFill(int width, TagCW com, String key_road, String key_slab, String key_cr, String key_cs){
			pos = new ArrayList<>();
			blk = new ArrayList<>();
			for(int i = 0; i < width; i++) pos.add(new ArrayList<>());
			StackWrapper stk;
			if(com.has(key_road) && !com.has(key_cr)){
				stk = UniStack.createStack(com.getCompound(key_road));
				flnk = CompatUtil.isValidFurenikus(stk.getIDL());
				vani = !flnk && !stk.getID().equals("fvtm:asphalt") && !stk.isItemOf(ContentType.BLOCK.item_type);
				for(int i = 0; i < width; i++) blk.add(stk);
			}
			else if(com.has(key_cr)){
				TagCW cus = com.getCompound(key_cr);
				for(int i = 0; i < width; i++){
					stk = StackWrapper.EMPTY;
					if(cus.has("Block" + i)){
						stk = UniStack.createStack(cus.getCompound("Block" + i));
					}
					blk.add(stk);
				}
			}
			if(com.has(key_slab) && !com.has(key_cs)){
				slb = new ArrayList<>();
				stk = UniStack.createStack(com.getCompound(key_slab));
				for(int i = 0; i < width; i++) slb.add(stk);
			}
			else if(com.has(key_cs)){
				slb = new ArrayList<>();
				TagCW cus = com.getCompound(key_cs);
				for(int i = 0; i < width; i++){
					stk = StackWrapper.EMPTY;
					if(cus.has("Block" + i)){
						stk = UniStack.createStack(cus.getCompound("Block" + i));
					}
					slb.add(stk);
				}
			}
		}

		public boolean son(){
			return slb != null;
		}

	}

}
