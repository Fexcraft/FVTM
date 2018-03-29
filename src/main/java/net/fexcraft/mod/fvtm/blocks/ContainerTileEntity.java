package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ContainerTileEntity extends TileEntity implements IInventory, IPacketReceiver<PacketTileEntityUpdate>, LockableObject {
	
	private ItemStackHandler itemStackHandler;
	private boolean core, setup;
	private ContainerData container;
	private BlockPos corepos;
	private ContainerTileEntity coretile;
	
	public ContainerTileEntity(){
		core = false;
		container = null;
		corepos = null;
		coretile = null;
		setup = false;
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
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		compound.setBoolean("Core", core);
		if(core && container != null){
			container.writeToNBT(compound);
		}
		if(!core && corepos != null){
			compound.setLong("CorePos", corepos.toLong());
		}
		compound.setBoolean("SetUp", setup);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		core = compound.getBoolean("Core");
		if(core && compound.hasKey(ContainerItem.NBTKEY)){
			container = Resources.getContainerData(compound);
		}
		if(!core){
			corepos = BlockPos.fromLong(compound.getLong("CorePos"));
		}
		setup = compound.getBoolean("SetUp");
		//
		if(!core && setup && corepos == null){
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	}
	
	ContainerTileEntity getCore(){
		return core ? this : coretile == null ? coretile = corepos == null ? null : (ContainerTileEntity)world.getTileEntity(corepos) : coretile;
	}

	@Override
	public String getName(){
		return "container_block";
	}

	@Override
	public boolean hasCustomName(){
		return false;
	}

	@Override
	public int getSizeInventory(){
		return getCore().container.getInventory().size();
	}

	@Override
	public boolean isEmpty(){
		return getCore().container.getInventory().isEmpty();
	}

	@Override
	public ItemStack getStackInSlot(int index){
		return getCore().container.getInventory().get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count){
		return !getStackInSlot(index).isEmpty() ? ItemStackHelper.getAndSplit(getCore().container.getInventory(), index, count) : ItemStack.EMPTY;
	}

	@Override
	public ItemStack removeStackFromSlot(int index){
		return getCore().container.getInventory().set(index, ItemStack.EMPTY);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		getCore().container.getInventory().set(index, stack);
	}

	@Override
	public int getInventoryStackLimit(){
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player){
		return player != null && !player.isDead;
	}

	@Override
	public void openInventory(EntityPlayer player){
		//
	}

	@Override
	public void closeInventory(EntityPlayer player){
		//
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){
		return getCore().container.getContainer().isItemValid(stack);
	}

	@Override
	public int getField(int id){
		return 0;
	}

	@Override
	public void setField(int id, int value){
		//
	}

	@Override
	public int getFieldCount(){
		return 0;
	}

	@Override
	public void clear(){
		getCore().container.getInventory().clear();
	}
	
	public ContainerData getContainerData(){
		return getCore().container;
	}
	
	@Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return !this.isLocked() && getCore() != null && getCore().container != null && getCore().container.getInventory().size() > 0;
        }
        return super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked") @Override @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && facing.getAxis().isVertical() && !this.isLocked()){
        	if(itemStackHandler == null){
        		itemStackHandler = new ItemStackHandler(getCore().container.getInventory());
        	}
            return (T)itemStackHandler;
        }
        return getCapability(capability, facing);
    }

	public boolean isCore(){
		return core;
	}

	public BlockPos getCorePos(){
		return corepos;
	}

	public void setUp(ItemStack stack){
		BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
		this.core = pos.equals(core);
		if(this.core){
			container = Resources.getContainerData(stack.getTagCompound());
			Print.debug(container.writeToNBT(new NBTTagCompound()).toString());
		}
		else{
			this.corepos = core;
		}
		this.setup = true;
		Print.debug("CONTESETUP: " + this.pos.toString() + " OK;");
	}

	public void notifyBreak(World world, BlockPos pos, IBlockState state){
		if(getCore() == null){ return; }
		ContainerTileEntity core = getCore();
		ContainerBlock.getPositions(core.container, core.pos, state.getValue(ContainerBlock.FACING)).forEach(blkpos -> {
			if(this.core && blkpos.equals(core.pos)){
				EntityItem ent = new EntityItem(world);
				ent.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 1.5, blkpos.getZ() + 0.5);
				ent.setItem(core.container.getContainer().getItemStack(core.container));
				world.spawnEntity(ent);
			}
			if(!blkpos.equals(pos)){
				world.setBlockState(blkpos, Blocks.AIR.getDefaultState(), 2);
			}
		});
	}
	
	@SideOnly(Side.CLIENT) @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }
	
	@SideOnly(Side.CLIENT) @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }
	
	@Override
    public boolean canRenderBreaking(){
        return true;
    }

	@Override
	public boolean isLocked(){
		return getContainerData().isLocked();
	}
	
	@Override
	public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		if(!stack.hasTagCompound()){
			Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
			return false;
		}
		else{
			ContainerData data = getContainerData();
			switch(item.getType(stack)){
				case PRIVATE:
					if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
						Print.chat(entity, "This key can only be used by the Owner;");
						return false;
					}
					else{
						if(item.getCode(stack).equals(data.getLockCode())){
							data.setLocked(false);
							Print.chat(entity, "Container is now unlocked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					}
				case COMMON:
					if(item.getCode(stack).equals(data.getLockCode())){
						data.setLocked(false);
						Print.chat(entity, "Container is now unlocked.");
						return true;
					}
					else{
						Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
						return false;
					}
				case ADMIN:
					data.setLocked(false);
					Print.chat(entity, "[SU] Container is now unlocked.");
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
		ContainerData data = getContainerData();
		if(!data.allowsLocking()){
			Print.chat(entity, "This vehicle doesn't allow locking.");
			return false;
		}
		else{
			if(!stack.hasTagCompound()){
				Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
				return false;
			}
			else{
				switch(item.getType(stack)){
					case PRIVATE:
						if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
							Print.chat(entity, "This key can only be used by the Owner;");
							return false;
						}
						else{
							if(item.getCode(stack).equals(data.getLockCode())){
								data.setLocked(true);
								Print.chat(entity, "Container is now locked.");
								return true;
							}
							else{
								Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
								return false;
							}
						}
					case COMMON:
						if(item.getCode(stack).equals(data.getLockCode())){
							data.setLocked(true);
							Print.chat(entity, "Container is now locked.");
							return true;
						}
						else{
							Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
							return false;
						}
					case ADMIN:
						data.setLocked(true);
						Print.chat(entity, "[SU] Container is now locked.");
						return true;
				}
			}
		}
		return false;
	}
    
}
