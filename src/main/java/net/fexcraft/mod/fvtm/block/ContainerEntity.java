package net.fexcraft.mod.fvtm.block;

import static net.fexcraft.mod.fvtm.Config.VEHICLES_DROP_CONTENTS;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
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
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

public class ContainerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {

    private boolean core, setup;
    private ContainerData container;
    private BlockPos corepos;
    private ContainerEntity coretile;

    public ContainerEntity(){
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
            container.write(compound);
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
        if(core && compound.hasKey("Container")){
            container = FvtmResources.getContainerData(compound);
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

    protected ContainerEntity getCore(){
        return core ? this : coretile == null ? coretile = corepos == null ? null : (ContainerEntity) world.getTileEntity(corepos) : coretile;
    }
    
    private ContainerEntity corr;

    public ContainerData getContainerData(){
        return (corr = getCore()) == null ? null : corr.container;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(facing != null && facing.getAxis().isVertical() && getCore() != null && getCore().container != null && !this.isLocked()){
            if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
                return getCore().container.getInventory().type.isItem() && getCore().container.getInventory().capacity() > 0;
            }
            if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
                return getCore().container.getInventory().type.isFluid();
            }
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && getCore().container.getInventory().type.isItem()){
            return (T)getCore().container.getInventory().getStackHandler();
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && getCore().container.getInventory().type.isFluid()){
            return (T) getCore().container.getInventory().getTank();
        }
        return super.getCapability(capability, facing);
    }

    public boolean isCore(){
        return core;
    }

    public BlockPos getCorePos(){
        return core ? this.pos : corepos;
    }

    public void setUp(ItemStack stack){
        BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
        this.core = pos.equals(core);
        if(this.core){
            container = ((ContainerItem)stack.getItem()).getData(TagCW.wrap(stack.getTagCompound()));
            Print.debug(container.write(new NBTTagCompound()).toString());
        }
        else{
            this.corepos = core;
        }
        this.setup = true;
        Print.debug("CONTESETUP: " + this.pos.toString() + " OK;");
    }

    public void notifyBreak(World world, BlockPos pos, IBlockState state, boolean asplayer){
        if(getCore() == null){ return; }
        ContainerEntity core = getCore();
        if(core.container == null){ return; }
        ContainerBlock.getPositions(core.container, core.pos, state.getValue(ContainerBlock.FACING)).forEach(blkpos -> {
        	if(!asplayer){ core.container = null; }
        	if(this.core && blkpos.equals(core.pos) && asplayer){
            	if(core.container != null){
                	EntityItem ent = new EntityItem(world);
                    ent.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 1.5, blkpos.getZ() + 0.5);
                    ent.setItem(core.container.getNewStack().local());
                    world.spawnEntity(ent);
                    core.container = null;
            	}
                //
                if(VEHICLES_DROP_CONTENTS && !world.isRemote){
                    getContainerData().getInventory().dropAllAt(WrapperHolder.getWorld(world), new V3I(blkpos.getX(), blkpos.getY(), blkpos.getZ()));
                }
            }
            if(asplayer ? !blkpos.equals(pos) : true){
                world.setBlockState(blkpos, Blocks.AIR.getDefaultState(), 2);
            }
        });
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

    public boolean isLocked(){
        return getContainerData().getLock().isLocked();
    }
    
    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("task")){
            switch(packet.nbt.getString("task")){
                case "update_container_inventory": {
                    if(getContainerData() == null) break;
                    getContainerData().getInventory().load(new TagCWI(packet.nbt), "state");
                    break;
                }
            }
        }
        else{
            this.readFromNBT(packet.nbt);
        }
    }

    public void sendInvUpdate(EntityPlayer player){
        if(player == null) return;
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_container_inventory");
        getContainerData().getInventory().save(new TagCWI(nbt), "state");
        PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(player.dimension, this.getPos(), nbt), (EntityPlayerMP)player);
    }

	public InvType getInventoryType(){
		return this.getContainerData() == null ? null : this.getContainerData().getType().getInventoryType();
	}

}
