package net.fexcraft.mod.fvtm.block.generated;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class PlainBase extends net.minecraft.block.Block {

	public final Block type;
	
	public PlainBase(Block type){
		super(type.getMaterial(), type.getMapColor()); this.type = type;
		type.getAddon().getFCLRegisterer().addBlock(
			type.getRegistryName().getPath(), this, BlockItem.class, type.getBlockType().getMetaVariants(), null);
		this.setHardness(type.getHardness());
		this.setLightLevel(type.getLightLevel());
		this.setResistance(type.getResistance());
		this.setLightOpacity(type.getLightOpacity());
		this.setHarvestLevel(type.getHarverestToolClass(), type.getHarverestToolLevel());
	}
	
	@Override
	public boolean isFullBlock(IBlockState state){ return type.isFullBlock(); }

	@Override
	public boolean isFullCube(IBlockState state){ return type.isFullCube(); }

	@Override
	public boolean isOpaqueCube(IBlockState state){ return type == null ? false : type.isOpaque(); }
	
	@Override
	public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity){
		if(type.getCollisionDamage() > 0) entity.attackEntityFrom(DamageSource.CACTUS, type.getCollisionDamage());
		if(type.isWebLike()) entity.setInWeb(); return;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer(){
		return type.isCutout() ? BlockRenderLayer.CUTOUT : type.isTranslucent() ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return type.isInvisible() ? EnumBlockRenderType.INVISIBLE : EnumBlockRenderType.MODEL;
	}
	
	@Override
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end){
		ArrayList<AxisAlignedBB> aabbs = new ArrayList<>();
		this.addCollisionsToList(state, world, pos, null, aabbs);
		if(aabbs.size() < 2) return super.collisionRayTrace(state, world, pos, start, end); 
		ArrayList<RayTraceResult> list = new ArrayList<>();
		for(AxisAlignedBB aabb : aabbs){
			RayTraceResult res = rayTrace(pos, start, end, aabb);
			if(res != null) list.add(res);
		}
		RayTraceResult result = null;
		double v = 0;
		for(RayTraceResult sub : list){
			double d = sub.hitVec.squareDistanceTo(end);
			if(d > v){
				result = sub;
				v = d;
			}
		}
		return result;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes, @Nullable Entity entity, boolean isactual){
		addCollisionsToList(state, world, pos, entitybox, boxes);
	}
	
	protected abstract void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes);

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote) return false;
		if(!player.isSneaking() && type.getFunctions().size() > 0){
			for(BlockFunction func : type.getFunctions()){
				if(func.onClick(world, pos, state, player, hand, side, hitX, hitY, hitZ)) return true;
			}
		}
		return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
	}

}
