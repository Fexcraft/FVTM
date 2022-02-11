package net.fexcraft.mod.fvtm.block.generated;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
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
			type.getRegistryName().getPath(), this, BlockItem.class, type.getBlockType().isGenericRoad() ? 16 : 0, null);
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
		return type.isCutout() ? BlockRenderLayer.CUTOUT : BlockRenderLayer.SOLID;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return type.isInvisible() ? EnumBlockRenderType.INVISIBLE : EnumBlockRenderType.MODEL;
	}
	
	@Override
	public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end){
		List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();
		ArrayList<AxisAlignedBB> aabbs = new ArrayList<>();
		this.addCollisionsToList(state, world, pos, aabb, aabbs);
		for(AxisAlignedBB aabb : aabbs) list.add(rayTrace(pos, start, end, aabb.offset(pos)));
		RayTraceResult result = null;
		double v = 0;
		for(RayTraceResult sub : list){
			if(sub != null){
				double d = sub.hitVec.squareDistanceTo(end);
				if(d > v){
					result = sub;
					v = d;
				}
			}
		}
		return result;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes, @Nullable Entity entity, boolean isactual){
		addCollisionsToList(state, world, pos, entitybox, boxes);
	}
	
	protected abstract void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes);

	public static final AxisAlignedBB aabb = new AxisAlignedBB(0, 0, 0, 0.25, 1, 0.15);

}
