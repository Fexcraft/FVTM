package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockFunction;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.sys.wire.WireSystem;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static net.fexcraft.mod.uni.world.WrapperHolder.*;

public abstract class BlockBase extends PlainBase implements ITileEntityProvider {
	
	public BlockBase(Block type){
		super(type);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable net.minecraft.tileentity.TileEntity te, ItemStack stack){
        player.addStat(StatList.getBlockStats(this));
        player.addExhaustion(0.005F);
        if(this.canSilkHarvest(world, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0)
        harvesters.set(player);
        EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        item.setItem(((BlockTileEntity)te).getBlockData().getNewStack().local());
        world.spawnEntity(item);
        harvesters.set(null);
	}

	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(world.isRemote) return false;
        if(!player.isSneaking() && type.getFunctions().size() > 0){
            BlockTileEntity tile = (BlockTileEntity)world.getTileEntity(pos);
            for(BlockFunction func : tile.data.getFunctions()){
                if(func.onClick(getWorld(world), getPos(pos), new V3D(hitX, hitY, hitZ), StateWrapper.of(state), getSide(side), UniEntity.getEntity(player), hand == EnumHand.MAIN_HAND)) return true;
            }
        }
        ItemStack held = player.getHeldItem(hand);
        if(held.isEmpty()) return true;
        if(held.getItem() instanceof ItemDye){
        	RGB colour = new RGB(ItemDye.DYE_COLORS[held.getMetadata()]);
        	held.shrink(1);
        	BlockTileEntity tile = (BlockTileEntity)world.getTileEntity(pos);
        	if(tile == null) return true;
        	if(hand == EnumHand.MAIN_HAND){
        		tile.getBlockData().setColorChannel("primary", colour);
        	}
        	else{
        		tile.getBlockData().setColorChannel("secondary", colour);
        	}
        	tile.sendUpdate();
        	Print.chat(player, "&eColour applied. &7[" + (hand == EnumHand.MAIN_HAND ? "primary" : "secondary") + "]");
        	return true;
        }
        return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return new BlockTileEntity(this);
	}
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state){
        return type.isInvisible() ? EnumBlockRenderType.INVISIBLE : type.hasPlainModel() ? EnumBlockRenderType.MODEL : EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(type.hasRelay() && SystemManager.active(Systems.WIRE)){
    		SystemManager.get(Systems.WIRE, WrapperHolder.getWorld(world), WireSystem.class).deregister(world.getTileEntity(pos));
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        BlockTileEntity tile = (BlockTileEntity)world.getTileEntity(pos);
        Print.debug(world.isRemote, tile, stack.getTagCompound());
        if(tile != null && stack.getTagCompound() != null){
            tile.getBlockData().read(stack.getTagCompound());
            tile.markDirty();
            tile.sendUpdate();
        }
    }

}
