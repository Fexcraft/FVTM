package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockTileEntity;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.common.PaintableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import static net.minecraft.util.EnumFacing.*;

public class UniversalTileEntity extends TileEntity implements BlockTileEntity, IPacketReceiver<PacketTileEntityUpdate>, LockableObject, ITickable, PaintableObject {
	
	private Long longpos;
	private boolean core;
	private BlockPos corepos, relpos;
	private BlockData data;

	public UniversalTileEntity(){
        core = false; corepos = null;
	}

	@Override
	public TileEntity getTileEntity(){
		return this;
	}

	@Override
	public IBlockState getBlockState(){
		return this.getBlockState();
	}

	@Override
	public BlockData getBlockData(){
        return core ? data : corepos == null ? null : ((UniversalTileEntity)world.getTileEntity(corepos)).data;
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
        if(!core && corepos != null){
            compound.setLong("CorePos", corepos.toLong());
        }
    	compound.setLong("RelativePos", relpos.toLong());
        if(core && data != null){
        	data.writeToNBT(compound);
        }
        //Print.debug(compound);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        //Print.debug(compound);
        core = compound.getBoolean("Core");
        if(!core){
            corepos = BlockPos.fromLong(compound.getLong("CorePos"));
        }
        relpos = BlockPos.fromLong(compound.getLong("RelativePos"));
        //
        if(!core && corepos == null){//TODO check
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
        //
    	data = data == null ? Resources.getBlockData(compound) : data.readFromNBT(compound);
    }

    @Override
    public void processServerPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("task")){
            //
        }
        else if(packet.nbt.hasKey("ScriptPacket") && packet.nbt.getBoolean("ScriptPacket")){
        	BlockData data = this.getBlockData();
        	if(data != null && data.getScript() != null){
        		data.getScript().onDataPacket(this, data, packet.nbt, Side.SERVER);
        	}
        }
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("task")){
            switch(packet.nbt.getString("task")){
	            case "update_fluid_tank": {
	            	IFluidHandler handler = this.getBlockData().getFluidTanks().get(packet.nbt.getString("tankid"));
	            	if(handler != null){
	            		((FluidTank)handler).readFromNBT(packet.nbt.getCompoundTag("state"));
	            	}
	                break;
	            }
	            case "update_primary_color":{
	            	if(this.getBlockData() == null){ break; }
	            	this.getBlockData().getPrimaryColor().readFromNBT(packet.nbt, null);
	            	break;
	            }
	            case "update_secondary_color":{
	            	if(this.getBlockData() == null){ break; }
	            	this.getBlockData().getSecondaryColor().readFromNBT(packet.nbt, null);
	            	break;
	            }
            }
        }
        else if(packet.nbt.hasKey("ScriptPacket") && packet.nbt.getBoolean("ScriptPacket")){
        	BlockData data = this.getBlockData();
        	if(data != null && data.getScript() != null){
        		data.getScript().onDataPacket(this, data, packet.nbt, Side.CLIENT);
        	}
        }
        else{
            this.readFromNBT(packet.nbt);
        }
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
    public boolean canRenderBreaking(){
        return true;
    }

	public void setUp(ItemStack stack){
		this.corepos = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
        this.relpos = BlockPos.fromLong(stack.getTagCompound().getLong("RelativePos"));
        this.core = pos.equals(corepos);
        Print.debug(corepos, pos, relpos, this.core, stack.getTagCompound());
        if(this.core){
        	this.data = Resources.getBlockData(stack.getTagCompound());
        	if(data != null && data.getScript() != null){
        		this.getBlockData().getScript().onPlace(this, this.getBlockData());
        	}
        	if(data == null){
        		Print.debug(stack.getTagCompound());
        		Static.stop();
        	}
        }
        Print.debug("BLKTESETUP: " + this.pos.toString() + " OK;");
	}

	public void notifyBreak(World world, BlockPos pos, IBlockState state, boolean asp){
        if(world.getTileEntity(getCorePos()) == null){ return; }
        BlockData data = this.getBlockData();
        if(data == null){ return; }
        UniversalBlock.getPositions(data, getCorePos(), state.getValue(UniversalBlock.FACING)).forEach((relpos, blkpos) -> {
        	if(!asp && core){ this.data = null; }
        	if(this.core && blkpos.equals(this.pos) && asp){
            	if(data != null){
            		if(data.getScript() != null){
            			data.getScript().onBreak(this, data);
            		}
                    //
                    if(!world.isRemote){
                    	for(NonNullList<ItemStack> list : data.getItemStacks().values()){
                    		for(ItemStack is : list){
                            	EntityItem ent = new EntityItem(world);
                                ent.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 1.2, blkpos.getZ() + 0.5);
                                ent.setItem(is); world.spawnEntity(ent);
                    		}
                    		list.clear();
                    	}
                    }
            		//
                	EntityItem ent = new EntityItem(world);
                    ent.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 1.5, blkpos.getZ() + 0.5);
                    ent.setItem(data.getBlock().getItemStack(data));
                    world.spawnEntity(ent);
                    if(data.getScript() != null){
                    	data.getScript().onBreak(this, data);
                    }
                    this.data = null;
            	}
            }
            if(asp ? !blkpos.equals(pos) : true){
                world.setBlockState(blkpos, Blocks.AIR.getDefaultState(), 2);
            }
        });
	}

    public BlockPos getCorePos(){
        return core ? this.pos : corepos;
    }

	public BlockPos getRelPos(){
		return relpos;
	}

	public boolean isCore(){
		return core;
	}
    
    @Override
    public String toString(){
    	return super.toString() + (this.getBlockData() == null ? "" : " || " + this.getBlockData().toString()); 
    }

    public EnumFacing getRelFacing(EnumFacing facing){
    	EnumFacing local = EnumFacing.getFront(getBlockMetadata());
		if(local != EAST && local.getAxis() != EnumFacing.Axis.Y){
			if(facing.getAxis() == EnumFacing.Axis.Y){
				return facing;
			}
			switch(local){
				case NORTH:{
					switch(facing){
						case EAST: return SOUTH;
						case WEST: return NORTH;
						case NORTH: return EAST;
						case SOUTH: return WEST;
						default: break;
					}
					break;
				}
				case SOUTH:{
					switch(facing){
						case EAST: return NORTH;
						case WEST: return SOUTH;
						case NORTH: return WEST;
						case SOUTH: return EAST;
						default: break;
					}
					break;
				}
				case WEST:{
					return facing.getOpposite();
				}
				default: break;
			}
		}
		return facing;
	}
    
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
    	BlockData data = getBlockData();
        if(facing != null && data != null && !data.isLocked()){
            if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
                return data.getBlock().getSubBlocks().get(relpos).hasInventory(getRelFacing(facing));
            }
            if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
                return data.getBlock().getSubBlocks().get(relpos).hasFluidTank(getRelFacing(facing));
            }
        }
        return super.hasCapability(capability, facing);
    }

	@SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
        	BlockData data = getBlockData();
            return (T)data.getBlock().getSubBlocks().get(relpos).getInventory(data, getRelFacing(facing));
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
        	BlockData data = getBlockData();
            return (T)data.getBlock().getSubBlocks().get(relpos).getFluidTank(data, getRelFacing(facing));
        }
        return super.getCapability(capability, facing);
    }

	@Override
	public boolean isLocked(){
		return getBlockData() == null ? false : getBlockData().isLocked();
	}

    @Override
    public boolean unlock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
        if(!stack.hasTagCompound()){
            Print.chat(entity, "[ERROR] Key don't has a NBT Tag Compound!");
            return false;
        }
        else{
        	BlockData data = getBlockData();
            switch(item.getType(stack)){
                case PRIVATE:
                    if(entity.getGameProfile().getId().toString().equals(item.getCreator(stack).toString())){
                        Print.chat(entity, "This key can only be used by the Owner;");
                        return false;
                    }
                    else{
                        if(item.getCode(stack).equals(data.getLockCode())){
                            data.setLocked(false);
                            Print.chat(entity, "Block is now unlocked.");
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
                        Print.chat(entity, "Block is now unlocked.");
                        return true;
                    }
                    else{
                        Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
                        return false;
                    }
                case ADMIN:
                    data.setLocked(false);
                    Print.chat(entity, "[SU] Block is now unlocked.");
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean lock(World world, EntityPlayer entity, ItemStack stack, KeyItem item){
        BlockData data = getBlockData();
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
                                Print.chat(entity, "Block is now locked.");
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
                            Print.chat(entity, "Block is now locked.");
                            return true;
                        }
                        else{
                            Print.chat(entity, "Wrong key.\n[V:" + data.getLockCode().toUpperCase() + "] != [K:" + item.getCode(stack).toUpperCase() + "]");
                            return false;
                        }
                    case ADMIN:
                        data.setLocked(true);
                        Print.chat(entity, "[SU] Block is now locked.");
                        return true;
                }
            }
        }
        return false;
    }

	public void sendFluidTankUpdate(EntityPlayer player, String tank){
        if(player == null){ return; }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_fluid_tank");
        nbt.setTag("state", ((FluidTank)this.getBlockData().getFluidTanks().get(tank)).writeToNBT(new NBTTagCompound()));
        nbt.setString("tankid", tank);
        PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(player.dimension, this.getPos(), nbt), (EntityPlayerMP)player);
	}

	@Override
	public long getLongPos(){
		if(longpos == null){ longpos = pos.toLong(); }
		return longpos;
	}

	@Override
	public void update(){
		if(core && data != null && data.getScript() != null){
			data.getScript().onUpdate(this, data);
		}
	}

	@Override
	public void onPaintItemUse(RGB color, EnumDyeColor dye, ItemStack stack, EntityPlayer player, BlockPos pos, World world){
		if(this.isLocked() || this.getBlockData() == null){ return; }
		this.getBlockData().getPrimaryColor().packed = color.packed;
		this.getBlockData().getPrimaryColor().alpha = color.alpha;
		ApiUtil.sendTileEntityUpdatePacket(world, pos, this.writeToNBT(new NBTTagCompound()));
		Print.bar(player, this.getBlockData().getPrimaryColor().toString());
		//
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_primary_color");
        this.getBlockData().getPrimaryColor().writeToNBT(nbt, null);
        PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(player.dimension, this.getPos(), nbt), (EntityPlayerMP)player);
	}

}
