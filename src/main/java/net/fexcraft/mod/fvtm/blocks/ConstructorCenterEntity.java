package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConstructorCenterEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {

    private ConstructorControllerEntity link = null;
    private final int offset = 24;
    private final int length = 4;
    private BlockPos constructor;

    public void link(BlockPos pos){
        if(world.isRemote){
            try{
                link = (ConstructorControllerEntity) world.getTileEntity(pos);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            this.constructor = pos;
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setLong("pos", this.constructor.toLong());
            nbt.setBoolean("reset", false);
            ApiUtil.sendTileEntityUpdatePacket(world, this.pos, nbt);
            //remind controller we're here
            ((ConstructorControllerEntity) world.getTileEntity(constructor)).center = this.pos;
        }
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate packet){
        Print.debug("SYNC -> CK");
        if(packet.nbt.hasKey("pos")){
            this.constructor = BlockPos.fromLong(packet.nbt.getLong("pos"));
            this.link(this.constructor);
            Print.debug("SYNC -> OK");
        }
        if(packet.nbt.hasKey("reset") && packet.nbt.getBoolean("reset")){
            this.constructor = null;
            this.link = null;
            Print.chat(net.minecraft.client.Minecraft.getMinecraft().player, "Center Block at " + pos.toString() + " resseted!");
            Print.debug("SYNC -> RS");
        }
    }

    public int getLength(){
        if(link != null && link.getVehicleData() != null){
            return link.getVehicleData().getVehicle().getConstructionLength();
        }
        return length;
    }

    public int getRenderLength(){
        if(link != null && link.getVehicleData() != null){
            return (link.getVehicleData().getVehicle().getConstructionLength() * 2) + 1;
        }
        return (length * 2) + 1;
    }

    public float getRenderOffset(){
        if(link != null && link.getVehicleData() != null){
            return link.getVehicleData().getVehicle().getWheelConstructorOffset() * 0.0625f;
        }
        return offset * 0.0625f;
    }

    public ConstructorControllerEntity getLink(){
        return link;
    }

    public double getLiftState(){
        return link == null ? 0 : link.liftstate;
    }

    public VehicleData getVehicleData(){
        return link == null ? null : link.getVehicleData() == null ? null : link.getVehicleData();
    }

    public ContainerData getContainerData(){
        return link == null ? null : link.getContainerData() == null ? null : link.getContainerData();
    }

    public BlockPos getConstructor(){
        return constructor;
    }

    //
    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.getPos(), this.getBlockMetadata(), this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(constructor != null){
            compound.setLong("Constructor", constructor.toLong());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("Constructor")){
            this.constructor = BlockPos.fromLong(compound.getLong("Constructor"));
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


}
