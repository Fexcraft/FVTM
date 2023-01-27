package net.fexcraft.mod.fvtm.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.api.registry.fItem;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Statics;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.Path;
import net.fexcraft.mod.fvtm.sys.uni.PathType;
import net.fexcraft.mod.fvtm.util.Compat;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fItem(modid = "fvtm", name = "road_tool")
public class RoadToolItem extends Item implements JunctionGridItem {
	
	public static RoadToolItem INSTANCE;

    public RoadToolItem(){
		super();
		INSTANCE = this;
		setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        tooltip.add(Formatter.format("&aRoad Placing Toolbox"));
        if(stack.getTagCompound() == null){
        	tooltip.add("No Compound Data.");
        }
        else{
        	int[] layers = stack.getTagCompound().getIntArray("RoadLayers");
        	if(layers.length < 6){
        		int[] n = new int[6];
        		for(int i = 0; i < 6; i++){
        			n[i] = i >= layers.length ? 0 : layers[i];
        		}
        		stack.getTagCompound().setIntArray("RoadLayers", layers = n);
        	}
        	ItemStack stack0 = null;
        	if(stack.getTagCompound().hasKey("CustomRoadFill")){
                tooltip.add(Formatter.format("&6Road Fill: &bCUSTOM &7x" + layers[0]));
        	}
        	else{
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("RoadFill"));
                tooltip.add(Formatter.format("&6Road Fill: &b" + stack0.getDisplayName().toUpperCase() + " &7x" + stack.getCount()));
        	}
        	if(stack.getTagCompound().hasKey("BottomFill") && layers[1] > 0){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill"));
                tooltip.add(Formatter.format("&9Ground Fill: &7" + stack0.getDisplayName()));
        	}
        	if(stack.getTagCompound().hasKey("SideLeftFill") && layers[2] > 0){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideLeftFill"));
                tooltip.add(Formatter.format("&9L Wall Fill: &7" + stack0.getDisplayName() + " &ex" + layers[2]));
        	}
        	if(stack.getTagCompound().hasKey("SideRightFill") && layers[3] > 0){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideRightFill"));
                tooltip.add(Formatter.format("&9R Wall Fill: &7" + stack0.getDisplayName() + " &ex" + layers[3]));
        	}
        	//
        	if(stack.getTagCompound().hasKey("CustomTopFill") && layers[4] > 0){
                tooltip.add(Formatter.format("&9Roof Fill: &7CUSTOM &ex" + layers[0]));
        	}
        	else if(stack.getTagCompound().hasKey("TopFill") && layers[4] > 0){
        		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("TopFill"));
                tooltip.add(Formatter.format("&9Roof Fill: &7" + stack0.getDisplayName()));
        	}
        	//
        	if(layers.length > 5){
            	if(stack.getTagCompound().hasKey("CustomLinesFill") && layers[5] > 0){
                    tooltip.add(Formatter.format("&9Lines Fill: &7CUSTOM &ex" + layers[0]));
            	}
            	else if(stack.getTagCompound().hasKey("LinesFill") && layers[5] > 0){
            		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("LinesFill"));
                    tooltip.add(Formatter.format("&9Lines Fill: &7" + stack0.getDisplayName()));
            	}
        	}
            tooltip.add(Formatter.format("&7Use &6/fvtm undo road &7to undo last road."));
        }
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if(world.isRemote){ return EnumActionResult.PASS; }
        ItemStack stack = player.getHeldItem(hand);
        if(player.isSneaking() && hand != EnumHand.OFF_HAND){
        	player.openGui(FVTM.getInstance(), GuiHandler.ROADTOOLFILL, world, 0, 0, 0);
        	return EnumActionResult.SUCCESS;
        }
        if(!player.capabilities.isCreativeMode){
        	Print.chat(player, "&9This is a &6CREATIVE &9mode tool.");
        	return EnumActionResult.FAIL;
        }
        if(!Statics.getServer().isSinglePlayer() && !Perms.ROAD_PLACER_ITEM.has(player)){
        	Print.chat(player, "&cNo permission to use this item.");
        	return EnumActionResult.FAIL;
        }
        Vec316f vector = new Vec316f(world, new Vec3d(pos.down()).add(hitX, hitY, hitZ), Config.ROAD_PLACING_GRID);
    	RoadPlacingUtil.place(world, player, stack, vector);
		return EnumActionResult.SUCCESS;
    }

	@SuppressWarnings("deprecation")
	public boolean placeRoad(EntityPlayer player, World world, ItemStack stack, Vec316f vector, Road _road, ICommandSender sender){
		Print.debug(_road.vecpath);
		if(_road.length > Config.MAX_ROAD_LENGTH){
			Print.chatbar(sender, "&cRoad vector length exceeds the configured max length.");
			return false;
		}
    	ItemStack stack0 = null;
		int[] layers = stack.getTagCompound().getIntArray("RoadLayers");
		IBlockState top = null, bot = null, righ = null, left = null, roadB = null, lineB = null;
		ArrayList<Vec316f> border_r = null, border_l = null, roof = null, ground = null, road, line = null;
    	int borderheight_l = 0, borderheight_r = 0, topheight = 0;
    	ArrayList<ArrayList<Vec316f>> roadfill = null, rooffill = null, linefill = null;
    	boolean flnx = false, hlines = layers.length > 5 && layers[5] > 0;
    	if(stack.getTagCompound().hasKey("RoadFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("RoadFill"));
    		flnx = Compat.isValidFlenix(stack0.getItem());
            roadB = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(Compat.getRoadHeight(0, flnx));
    	}
    	if(layers[1] > 0 && stack.getTagCompound().hasKey("BottomFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("BottomFill"));
            bot = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
            ground = new ArrayList<>();
    	}
    	if(layers[2] > 0 && stack.getTagCompound().hasKey("SideLeftFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideLeftFill"));
            left = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
            borderheight_l = layers[2];
            border_l = new ArrayList<>();
    	}
    	if(layers[3] > 0 && stack.getTagCompound().hasKey("SideRightFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("SideRightFill"));
            righ = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
            borderheight_r = layers[3];
            border_r = new ArrayList<>();
    	}
    	if(layers[4] > 0 && stack.getTagCompound().hasKey("TopFill") && !stack.getTagCompound().hasKey("CustomTopFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("TopFill"));
            top = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
    	}
    	if(hlines && stack.getTagCompound().hasKey("LinesFill") && !stack.getTagCompound().hasKey("CustomLinesFill")){
    		stack0 = new ItemStack(stack.getTagCompound().getCompoundTag("LinesFill"));
            lineB = ((ItemBlock)stack0.getItem()).getBlock().getStateFromMeta(stack0.getMetadata());
    	}
    	topheight = borderheight_l > borderheight_r ? borderheight_l : borderheight_r;
    	if(topheight == 0){
    		if(hlines){
    			borderheight_l++;
    			borderheight_r++;
    			topheight = 2;
    		}
    		else topheight = 1;
    	}
    	ArrayList<IBlockState> roadfillB = null, rooffillB = null, linefillB = null;
    	if(stack.getTagCompound().hasKey("CustomRoadFill")){
    		roadfill = new ArrayList<>();
    		roadfillB = new ArrayList<>();
    		loadFill(roadfill, roadfillB, layers[0], stack.getTagCompound().getCompoundTag("CustomRoadFill"));
    	}
    	if(layers[4] > 0 && stack.getTagCompound().hasKey("CustomTopFill")){
    		rooffill = new ArrayList<>();
    		rooffillB = new ArrayList<>();
    		loadFill(rooffill, rooffillB, layers[0], stack.getTagCompound().getCompoundTag("CustomTopFill"));
    	}
    	if(hlines && stack.getTagCompound().hasKey("CustomLinesFill")){
    		linefill = new ArrayList<>();
    		linefillB = new ArrayList<>();
    		loadFill(linefill, linefillB, layers[0], stack.getTagCompound().getCompoundTag("CustomLinesFill"));
    	}
		//
		BlockPos blk;
		Vec3f last, vec;
		IBlockState state;
		int width = layers[0], height;
		float angle, passed = 0, half = (width * 0.5f) - 0.5f;
		road = roadfill == null && roadB != null ? new ArrayList<>() : null;
		roof = rooffill == null && layers[4] > 0 ? new ArrayList<>() : null;
		line = linefill == null && hlines ? new ArrayList<>() : null;
		//
		vec = _road.getVectorPosition0(0.001f, false); passed = 0;
		angle = (float)Math.atan2(_road.vecpath[0].z - vec.z, _road.vecpath[0].x - vec.x);
		angle += Statics.rad90;
		for(float fl = -half; fl <= half; fl += 0.25f){
			if(road != null) road.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(fl, 0, 0)))));
			if(ground != null) ground.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(fl, -1, 0)))));
			if(line != null) line.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(fl, 1, 0)))));
			if(roof != null) roof.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(fl, topheight, 0)))));
		}
		if(roadfill != null){
			for(int i = 0; i < roadfill.size(); i++){
				roadfill.get(i).add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), 0, 0)))));
			}
		}
		if(linefill != null){
			for(int i = 0; i < linefill.size(); i++){
				linefill.get(i).add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), 1, 0)))));
			}
		}
		if(rooffill != null){
			for(int i = 0; i < rooffill.size(); i++){
				rooffill.get(i).add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), topheight, 0)))));
			}
		}
		if(border_l != null) border_l.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(-half - 1, 0, 0)))));
		if(border_r != null) border_r.add(new Vec316f(_road.vecpath[0].add(grv(angle, new Vec3f(half + 1, 0, 0)))));
		while(passed < _road.length){ passed += 0.125f;
			last = vec; vec = _road.getVectorPosition0(passed, false);
			angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
			angle += Statics.rad90;
			float off = roadfill == null ? 0 : 0.25f;
			for(float fl = -half; fl <= half; fl += 0.25f){
				if(road != null) road.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, 0, 0)))));
				if(ground != null) ground.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl + off, -1, 0)))));
				if(line != null) line.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, 1, 0)))));
				if(roof != null) roof.add(new Vec316f(vec.add(grv(angle, new Vec3f(fl, topheight, 0)))));
			}
			if(roadfill != null){
				for(int i = 0; i < roadfill.size(); i++){
					roadfill.get(i).add(new Vec316f(vec.add(grv(angle, new Vec3f(-half + 0.25 + (i * 1), 0, 0)))));
				}
			}
			if(linefill != null){
				for(int i = 0; i < linefill.size(); i++){
					linefill.get(i).add(new Vec316f(vec.add(grv(angle, new Vec3f(-half + off + (i * 1), 1, 0)))));
				}
			}
			if(rooffill != null){
				for(int i = 0; i < rooffill.size(); i++){
					rooffill.get(i).add(new Vec316f(vec.add(grv(angle, new Vec3f(-half + off + (i * 1), topheight, 0)))));
				}
			}
			if(border_l != null) border_l.add(new Vec316f(vec.add(grv(angle, new Vec3f(-half - 1 + off, 0, 0)))));
			if(border_r != null) border_r.add(new Vec316f(vec.add(grv(angle, new Vec3f(half + 1 + off, 0, 0)))));
		}
		JsonMap map = new JsonMap();
		if(road != null){
			roadFill(world, road, roadB, topheight, flnx, map);
		}
		IBlockState block = null;
		if(roadfill != null){
			for(int i = 0; i < roadfill.size(); i++){
				block = roadfillB.get(i);
				flnx = Compat.isValidFlenix(block.getBlock());
				roadFill(world, roadfill.get(i), block, topheight, flnx, map);
			}
		}
		if(linefill != null){
			for(int i = 0; i < linefill.size(); i++){
				block = linefillB.get(i);
				for(Vec316f v : linefill.get(i)){
					state = world.getBlockState(blk = v.y != 0 ? v.pos.up() : v.pos);
					if(state.getBlock() != block.getBlock()){
						insert(map, blk, state);
						world.setBlockState(blk, block);
					}
				}
			}
		}
		if(rooffill != null){
			for(int i = 0; i < rooffill.size(); i++){
				block = rooffillB.get(i);
				for(Vec316f v : rooffill.get(i)){
					state = world.getBlockState(blk = v.y != 0 ? v.pos.up() : v.pos);
					if(state.getBlock() != block.getBlock()){
						insert(map, blk, state);
						world.setBlockState(blk, block);
					}
				}
			}
		}
		if(border_l != null){
			for(Vec316f v : border_l){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				for(int i = -1/*1*/; i < borderheight_l + 1; i++){
					//if(i == 1 && height > 8) continue;
					//if(world.getBlockState(blk.up(i)).isOpaqueCube()){
						insert(map, blk.up(i), world.getBlockState(blk.up(i)));
						world.setBlockState(blk.up(i), left);
					//}
				}
			}
		}
		if(border_r != null){
			for(Vec316f v : border_r){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				for(int i = -1/*1*/; i < borderheight_r + 1; i++){
					//if(i == 1 && height > 8) continue;
					//if(world.getBlockState(blk.up(i)).isOpaqueCube()){
						insert(map, blk.up(i), world.getBlockState(blk.up(i)));
						world.setBlockState(blk.up(i), righ);
					//}
				}
			}
		}
		if(ground != null){
			for(Vec316f v : ground){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				state = world.getBlockState(blk);
				if(!Compat.isFVTMRoad(state.getBlock()) && !Compat.isValidFlenix(state.getBlock())){
					insert(map, blk, world.getBlockState(blk));
					world.setBlockState(blk, bot);
				}
			}
		}
		if(line != null){
			for(Vec316f v : line){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				insert(map, blk, world.getBlockState(blk));
				world.setBlockState(blk, lineB);
			}
		}
		if(roof != null){
			for(Vec316f v : roof){
				height = v.y; blk = height != 0 ? v.pos.up() : v.pos;
				//if(world.getBlockState(blk).isOpaqueCube()){
					insert(map, blk, world.getBlockState(blk));
					world.setBlockState(blk, top);
				//}
			}
		}
		//
		Print.chatbar(player, "&bRoad placed!");
		RoadPlacingCache.addEntry(player, map);
		stack.getTagCompound().setInteger("LastRoadDim", world.provider.getDimension());
		return true;
	
	}
	
	private void insert(JsonMap map, BlockPos pos, IBlockState state){
		if(map.has(pos.toLong() + "")) return;
		JsonArray array = new JsonArray();
		array.add(state.getBlock().getRegistryName().toString());
		array.add(state.getBlock().getMetaFromState(state));
		map.add(pos.toLong() + "", array);
	}

	@SuppressWarnings("deprecation")
	private void loadFill(ArrayList<ArrayList<Vec316f>> fill, ArrayList<IBlockState> fillB, int layers, NBTTagCompound compound){
		for(int i = 0; i < layers; i++){
			fill.add(new ArrayList<>());
			IBlockState state = Blocks.AIR.getDefaultState();
			if(compound.hasKey("Block" + i)){
				Block block = Block.REGISTRY.getObject(new ResourceLocation(compound.getString("Block" + i)));
				Integer meta = compound.hasKey("Meta" + i) ? compound.getInteger("Meta" + i) : null;
				if(block != null) state = meta == null ? block.getDefaultState() : block.getStateFromMeta(meta);
			}
			fillB.add(state);
		}
	}

	@SuppressWarnings("deprecation")
	private void roadFill(World world, ArrayList<Vec316f> fill, IBlockState block, int topheight, boolean flenix, JsonMap map){
		int height = 0;
		BlockPos blk;
		boolean bool;
		for(Vec316f v : fill){
			height = v.y;
			IBlockState state = world.getBlockState(blk = height != 0 ? v.pos.up() : v.pos);
			if(!isRoad(state, block) || isLower(state, height)){
				if(bool = isRoad(world.getBlockState(blk.up()))) height = 0;
				insert(map, blk, state);
				world.setBlockState(blk, block.getBlock().getStateFromMeta(Compat.getRoadHeight(bool ? 0 : height, flenix)));
			}
			if((height < 9 && height != 0) || isRoad(world.getBlockState(blk.down()))){
				insert(map, blk.down(), world.getBlockState(blk.down()));
				world.setBlockState(blk.down(), block.getBlock().getStateFromMeta(Compat.getRoadHeight(0, flenix)));
			}
			int checkheight = topheight == 0 ? 4 : topheight;
			for(int i = 1; i < checkheight; i++){
				if(world.getBlockState(blk.up(i)).isOpaqueCube()){
					insert(map, blk.up(i), world.getBlockState(blk.up(i)));
					world.setBlockState(blk.up(i), Blocks.AIR.getDefaultState());
				}
			}
		}
	}

	private boolean isRoad(IBlockState state){
		return Compat.isFVTMRoad(state.getBlock()) || Compat.isValidFlenix(state.getBlock());
	}

	private boolean isRoad(IBlockState state, IBlockState roadB){
		return isRoad(state) && state.getBlock() == roadB.getBlock();
	}

	private boolean isLower(IBlockState state, int height){
		int h = Compat.isFVTMRoad(state.getBlock()) ? state.getValue(Asphalt.HEIGHT) : state.getBlock().getMetaFromState(state);
		return h > height;
	}

	public static final Vec3f grv(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad);
        return new Vec3f(co * vec.x, vec.y, si * vec.x);
	}

	private boolean lastEquals(NBTTagList list, Vec316f vector){
		if(list.isEmpty() || list.tagCount() < 2) return false; return getLastVector(list).equals(vector);
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}
	
	public Vec316f getLastVector(NBTTagList list){
		return new Vec316f(list.getCompoundTagAt(list.tagCount() - 1));
	}
	
	@Override
	public Vec316f[] getVectors(ItemStack stack){
		if(stack.getTagCompound() == null || !stack.getTagCompound().hasKey("fvtm:roadpoints")) return new Vec316f[0];
		return getVectors((NBTTagList)stack.getTagCompound().getTag("fvtm:roadpoints"), false);
	}

	public Vec316f[] getVectors(NBTTagList list, boolean all){
		Vec316f[] arr = new Vec316f[list.tagCount() - (all ? 0 : 1)];
		for(int i = 0; i < arr.length; i++){
			arr[i] = new Vec316f(list.getCompoundTagAt(i));
		} return arr;
	}

	@Override
	public boolean hasVectors(){
		return true;
	}
	
	public static class Road extends Path {

		public Road(Vec316f[] vec316fs){
			super(vec316fs);
		}
		
		public Road(Vec316f[] vec316fs, Vec316f vector){
			super(vec316fs, vector);
		}

		@Override
		public Vec3f getVectorPosition(float distance, boolean reverse){
			return super.getVectorPosition0(distance, reverse);
		}

		@Override
		public PathType getType(){
			return PathType.ROAD;
		}
		
	}

}
