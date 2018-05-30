package net.fexcraft.mod.fvtm.blocks;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.util.ItemStackHandler;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.lib.api.common.LockableObject;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.Print;
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

public class ContainerTileEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, LockableObject {

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
        return core ? this : coretile == null ? coretile = corepos == null ? null : (ContainerTileEntity) world.getTileEntity(corepos) : coretile;
    }

    public ContainerData getContainerData(){
        return getCore().container;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        if(facing != null && facing.getAxis().isVertical() && getCore() != null && getCore().container != null && !this.isLocked()){
            if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
                return getCore().container.getContainer().getInventoryType() == InventoryType.ITEM && getCore().container.getInventory().size() > 0;
            }
            if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY){
                return getCore().container.getContainer().getInventoryType() == InventoryType.FLUID;
            }
        }
        return super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
            if(itemStackHandler == null){
                itemStackHandler = new ItemStackHandler(getCore().container.getContainer(), getCore().container.getInventory());
            }
            return (T) itemStackHandler;
        }
        if(capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY && this.hasCapability(capability, facing)){
            return (T) getCore().container.getFluidHandler();
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
            container = Resources.getContainerData(stack.getTagCompound());
            Print.debug(container.writeToNBT(new NBTTagCompound()).toString());
        }
        else{
            this.corepos = core;
        }
        this.setup = true;
        Print.debug("CONTESETUP: " + this.pos.toString() + " OK;");
    }

    public void notifyBreak(World world, BlockPos pos, IBlockState state, boolean asplayer){
        if(getCore() == null){ return; }
        ContainerTileEntity core = getCore();
        if(core.container == null){ return; }
        ContainerBlock.getPositions(core.container, core.pos, state.getValue(ContainerBlock.FACING)).forEach(blkpos -> {
        	if(!asplayer){ core.container = null; }
        	if(this.core && blkpos.equals(core.pos) && asplayer){
            	if(core.container != null){
                	EntityItem ent = new EntityItem(world);
                    ent.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 1.5, blkpos.getZ() + 0.5);
                    ent.setItem(core.container.getContainer().getItemStack(core.container));
                    world.spawnEntity(ent);
                    core.container = null;
            	}
                //
                if(Config.DROP_ITEMS_ON_BREAK && !world.isRemote){
                    for(ItemStack stack : getContainerData().getInventory()){
                        if(!stack.isEmpty()){
                            EntityItem entity = new EntityItem(world);
                            entity.setPosition(blkpos.getX() + 0.5, blkpos.getY() + 2.5, blkpos.getZ() + 0.5);
                            entity.setItem(stack);
                            world.spawnEntity(entity);
                        }
                    }
                    getContainerData().getInventory().clear();
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

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        if(packet.nbt.hasKey("task")){
            switch(packet.nbt.getString("task")){
                case "update_container_fluid_tank": {
                    if(this.getContainerData().getContainer().getInventoryType() != InventoryType.FLUID){
                        return;
                    }
                    this.getContainerData().getFluidTank().readFromNBT(packet.nbt.getCompoundTag("state"));
                    break;
                }
            }
        }
        else{
            this.readFromNBT(packet.nbt);
        }
    }

    public void sendFluidTankUpdate(EntityPlayer player){
        if(player == null){
            return;
        }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setString("task", "update_container_fluid_tank");
        nbt.setTag("state", this.getContainerData().getFluidTank().writeToNBT(new NBTTagCompound()));
        PacketHandler.getInstance().sendTo(new PacketTileEntityUpdate(player.dimension, this.getPos(), nbt), (EntityPlayerMP) player);
    }

}
