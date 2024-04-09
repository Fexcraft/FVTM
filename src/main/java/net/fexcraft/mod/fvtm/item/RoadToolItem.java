package net.fexcraft.mod.fvtm.item;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.UniRoadTool;
import net.fexcraft.mod.fvtm.util.Compat;
import net.fexcraft.mod.fvtm.util.Perms;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static net.fexcraft.mod.fvtm.Config.MAX_ROAD_LENGTH;
import static net.fexcraft.mod.fvtm.sys.road.UniRoadTool.grv;

public class RoadToolItem extends Item implements JunctionGridItem {
	
	public static RoadToolItem INSTANCE;

    public RoadToolItem(){
		super();
		INSTANCE = this;
		setMaxStackSize(1);
		setRegistryName("fvtm:road_tool");
		setTranslationKey("fvtm:road_tool");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
        UniRoadTool.addTooltip(TagCW.wrap(stack.getTagCompound()), tooltip, (str, objs) -> I18n.format(str, objs));
    }
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        int result = UniRoadTool.onUse(player.getCapability(Capabilities.PASSENGER, null).asWrapper(), hand == EnumHand.MAIN_HAND);
		switch(result){
			case 1: return EnumActionResult.FAIL;
			case 2: return EnumActionResult.SUCCESS;
			case 3:{
				if(!Static.getServer().isSinglePlayer() && !Perms.ROAD_PLACER_ITEM.has(player)){
					Print.chat(player, "&cNo permission to use this item.");
					return EnumActionResult.FAIL;
				}
				pos = pos.down();
				RoadPlacingUtil.place(WrapperHolder.getWorld(world),
					player.getCapability(Capabilities.PASSENGER, null).asWrapper(),
					TagCW.wrap(player.getHeldItem(hand).getTagCompound()),
					new QV3D(pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ, 16));
				return EnumActionResult.SUCCESS;
			}
			case 0:
			default: return EnumActionResult.PASS;
		}
    }

	@SuppressWarnings("deprecation")
	public static boolean placeRoad(EntityPlayer player, World world, ItemStack stack, QV3D vector, UniRoadTool.Road _road, ICommandSender sender){
		if(_road.length > MAX_ROAD_LENGTH){
			Print.chatbar(sender, "&cRoad vector length exceeds the configured max length.");
			return false;
		}
    	ItemStack stack0 = null;
		int[] layers = stack.getTagCompound().getIntArray("RoadLayers");
		IBlockState top = null, bot = null, righ = null, left = null, roadB = null, lineB = null;
		ArrayList<QV3D> border_r = null, border_l = null, roof = null, ground = null, road, line = null;
    	int borderheight_l = 0, borderheight_r = 0, topheight = 0;
    	ArrayList<ArrayList<QV3D>> roadfill = null, rooffill = null, linefill = null;
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
		BlockPos.MutableBlockPos blk = new BlockPos.MutableBlockPos();
		V3D last, vec;
		IBlockState state;
		int width = layers[0], height;
		double angle, passed = 0, half = (width * 0.5) - 0.5;
		road = roadfill == null && roadB != null ? new ArrayList<>() : null;
		roof = rooffill == null && layers[4] > 0 ? new ArrayList<>() : null;
		line = linefill == null && hlines ? new ArrayList<>() : null;
		//
		vec = _road.getVectorPosition0(0.001f, false); passed = 0;
		angle = Math.atan2(_road.vecpath[0].z - vec.z, _road.vecpath[0].x - vec.x);
		angle += Static.rad90;
		for(double fl = -half; fl <= half; fl += 0.25){
			if(road != null) road.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(fl, 0, 0))), 16));
			if(ground != null) ground.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(fl, -1, 0))), 16));
			if(line != null) line.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(fl, 1, 0))), 16));
			if(roof != null) roof.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(fl, topheight, 0))), 16));
		}
		if(roadfill != null){
			for(int i = 0; i < roadfill.size(); i++){
				roadfill.get(i).add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(-half + 0.25 + (i * 1), 0, 0))), 16));
			}
		}
		if(linefill != null){
			for(int i = 0; i < linefill.size(); i++){
				linefill.get(i).add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(-half + 0.25 + (i * 1), 1, 0))), 16));
			}
		}
		if(rooffill != null){
			for(int i = 0; i < rooffill.size(); i++){
				rooffill.get(i).add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(-half + 0.25 + (i * 1), topheight, 0))), 16));
			}
		}
		if(border_l != null) border_l.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(-half - 1, 0, 0))), 16));
		if(border_r != null) border_r.add(new QV3D(_road.vecpath[0].add(grv(angle, new V3D(half + 1, 0, 0))), 16));
		while(passed < _road.length){ passed += 0.125f;
			last = vec; vec = _road.getVectorPosition0(passed, false);
			angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
			angle += Static.rad90;
			double off = roadfill == null ? 0 : 0.25;
			for(double fl = -half; fl <= half; fl += 0.25){
				if(road != null) road.add(new QV3D(vec.add(grv(angle, new V3D(fl, 0, 0))), 16));
				if(ground != null) ground.add(new QV3D(vec.add(grv(angle, new V3D(fl + off, -1, 0))), 16));
				if(line != null) line.add(new QV3D(vec.add(grv(angle, new V3D(fl, 1, 0))), 16));
				if(roof != null) roof.add(new QV3D(vec.add(grv(angle, new V3D(fl, topheight, 0))), 16));
			}
			if(roadfill != null){
				for(int i = 0; i < roadfill.size(); i++){
					roadfill.get(i).add(new QV3D(vec.add(grv(angle, new V3D(-half + 0.25 + (i * 1), 0, 0))), 16));
				}
			}
			if(linefill != null){
				for(int i = 0; i < linefill.size(); i++){
					linefill.get(i).add(new QV3D(vec.add(grv(angle, new V3D(-half + off + (i * 1), 1, 0))), 16));
				}
			}
			if(rooffill != null){
				for(int i = 0; i < rooffill.size(); i++){
					rooffill.get(i).add(new QV3D(vec.add(grv(angle, new V3D(-half + off + (i * 1), topheight, 0))), 16));
				}
			}
			if(border_l != null) border_l.add(new QV3D(vec.add(grv(angle, new V3D(-half - 1 + off, 0, 0))), 16));
			if(border_r != null) border_r.add(new QV3D(vec.add(grv(angle, new V3D(half + 1 + off, 0, 0))), 16));
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
				for(QV3D v : linefill.get(i)){
					blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
					state = world.getBlockState(blk);
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
				for(QV3D v : rooffill.get(i)){
					blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
					state = world.getBlockState(blk);
					if(state.getBlock() != block.getBlock()){
						insert(map, blk, state);
						world.setBlockState(blk, block);
					}
				}
			}
		}
		if(border_l != null){
			for(QV3D v : border_l){
				height = v.y;
				blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
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
			for(QV3D v : border_r){
				height = v.y;
				blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
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
			for(QV3D v : ground){
				height = v.y;
				blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				state = world.getBlockState(blk);
				if(!Compat.isFVTMRoad(state.getBlock()) && !Compat.isValidFlenix(state.getBlock())){
					insert(map, blk, world.getBlockState(blk));
					world.setBlockState(blk, bot);
				}
			}
		}
		if(line != null){
			for(QV3D v : line){
				height = v.y;
				blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				insert(map, blk, world.getBlockState(blk));
				world.setBlockState(blk, lineB);
			}
		}
		if(roof != null){
			for(QV3D v : roof){
				height = v.y;
				blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
				try{
					//if(world.getBlockState(blk).isOpaqueCube()){
						insert(map, blk, world.getBlockState(blk));
						world.setBlockState(blk, top);
					//}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		//
		Print.chatbar(player, "&bRoad placed!");
		RoadPlacingCache.addEntry(player.getGameProfile().getId(), player.dimension, map);
		stack.getTagCompound().setInteger("LastRoadDim", world.provider.getDimension());
		return true;
	
	}
	
	private static void insert(JsonMap map, BlockPos pos, IBlockState state){
		if(map.has(pos.toLong() + "")) return;
		JsonArray array = new JsonArray();
		array.add(state.getBlock().getRegistryName().toString());
		array.add(state.getBlock().getMetaFromState(state));
		map.add(pos.toLong() + "", array);
	}

	@SuppressWarnings("deprecation")
	private static void loadFill(ArrayList<ArrayList<QV3D>> fill, ArrayList<IBlockState> fillB, int layers, NBTTagCompound compound){
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
	private static void roadFill(World world, ArrayList<QV3D> fill, IBlockState block, int topheight, boolean flenix, JsonMap map){
		int height = 0;
		BlockPos.MutableBlockPos blk = new BlockPos.MutableBlockPos();
		boolean bool;
		for(QV3D v : fill){
			height = v.y;
			blk.setPos(v.pos.x, v.pos.y + (v.y > 0 ? 1 : 0), v.pos.z);
			IBlockState state = world.getBlockState(blk);
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

	private static boolean isRoad(IBlockState state){
		return Compat.isFVTMRoad(state.getBlock()) || Compat.isValidFlenix(state.getBlock());
	}

	private static boolean isRoad(IBlockState state, IBlockState roadB){
		return isRoad(state) && state.getBlock() == roadB.getBlock();
	}

	private static boolean isLower(IBlockState state, int height){
		int h = Compat.isFVTMRoad(state.getBlock()) ? state.getValue(Asphalt.HEIGHT) : state.getBlock().getMetaFromState(state);
		return h > height;
	}

	private String getSuffix(int tagCount){
		if(tagCount < 4) return tagCount == 1 ? "st" : tagCount == 2 ? "nd" : "rd"; else return "th";
	}

	@Override
	public boolean hasVectors(){
		return true;
	}

}
