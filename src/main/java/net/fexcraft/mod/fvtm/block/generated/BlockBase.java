package net.fexcraft.mod.fvtm.block.generated;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends net.minecraft.block.Block implements ITileEntityProvider {

	public final Block type;
	
	public BlockBase(Block type){
		super(type.getMaterial(), type.getMapColor()); this.type = type;
		type.getAddon().getFCLRegisterer().addBlock(
			type.getRegistryName().getResourcePath(), this, BlockItem.class, 0, null);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable net.minecraft.tileentity.TileEntity te, ItemStack stack){
        player.addStat(StatList.getBlockStats(this)); player.addExhaustion(0.005F);
        if(this.canSilkHarvest(world, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0)
        harvesters.set(player);
        EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        item.setItem(((TileEntity)te).getBlockData().newItemStack()); world.spawnEntity(item);
        harvesters.set(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new BlockBase.TileEntity(this);
	}
	
	public static class TileEntity extends net.minecraft.tileentity.TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {
		
		public BlockData data;
		
		public TileEntity(BlockBase type){
			data = new BlockData(type.type);
		}
		
		public TileEntity(){}

		public BlockData getBlockData(){
			return data;
		}

	    public final void sendUpdate(){
	        ApiUtil.sendTileEntityUpdatePacket(world, pos, this.getUpdateTag());
	    }

	    @Override
	    public final void processClientPacket(PacketTileEntityUpdate pkt){
	        this.readFromNBT(pkt.nbt);
	    }

	    @Override
	    public SPacketUpdateTileEntity getUpdatePacket(){
	        return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
	    }

	    @Override
	    public NBTTagCompound getUpdateTag(){
	        return this.writeToNBT(new NBTTagCompound());
	    }

	    @Override
	    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
	        super.readFromNBT(pkt.getNbtCompound());
	        this.readFromNBT(pkt.getNbtCompound());
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound){
	        super.writeToNBT(compound); if(data != null){ data.write(compound); }
	        return compound;
	    }

	    @Override
	    public void readFromNBT(NBTTagCompound compound){
	        super.readFromNBT(compound);
	        if(data != null) data.read(compound);
	        else data = Resources.getBlockData(compound);
	    }

	    @SideOnly(Side.CLIENT)
	    @Override
	    public double getMaxRenderDistanceSquared(){
	        return super.getMaxRenderDistanceSquared() * 8;
	    }

	    @SideOnly(Side.CLIENT)
	    @Override
	    public AxisAlignedBB getRenderBoundingBox(){
	        return INFINITE_EXTENT_AABB;
	    }

	    @Override
	    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
	        return oldState.getBlock() != newState.getBlock();
	    }

	}

}
