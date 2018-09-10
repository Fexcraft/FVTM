package net.fexcraft.mod.fvtm.blocks;

import java.util.ArrayList;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.fvtm.api.root.Lockable;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.lib.api.network.IPacketReceiver;
import net.fexcraft.mod.lib.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.lib.util.common.ApiUtil;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class ConstructorControllerEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {

    private VehicleData vehicledata;
    private PartData partdata;
    private ContainerData containerdata;
    public double liftstate;
    public byte lift;
    public BlockPos center;
    //
    private byte lc;

    @Override
    public void update(){
        if(lift != 0){
            if(lc == Time.getSecond()){
                return;
            }
            lc = (byte) Time.getSecond();
            this.liftstate += -(lift * 0.01);
            if(liftstate <= 0){
                liftstate = 0;
                lift = 0;
                return;
            }
            if(liftstate >= 4.5f){
                liftstate = 4.5f;
                lift = 0;
                return;
            }
            this.sendUpdate("lift");
        }
        return;
    }

    public void sendUpdate(String string){
        this.markDirty();
        NBTTagCompound compound = null;
        if(string != null){
            compound = new NBTTagCompound();
            switch(string){
                case "lift": {
                    compound.setDouble("liftstate", liftstate);
                    compound.setByte("lift", lift);
                    break;
                }
                case "center": {
                    compound.setBoolean("center_con", center != null);
                    if(center != null){
                        compound.setLong("center", center.toLong());
                    }
                    break;
                }
                case "vehicle":
                case "vehicledata": {
                    if(vehicledata != null){
                        vehicledata.writeToNBT(compound);
                    }
                    break;
                }
                case "part":
                case "partdata": {
                    if(partdata != null){
                    	partdata.writeToNBT(compound);
                    }
                    break;
                }
                case "rgb":
                case "color": {
                    compound.setInteger("primary_rgb", this.getColorable().getPrimaryColor().getColorInt());
                    compound.setInteger("secondary_rgb", this.getColorable().getSecondaryColor().getColorInt());
                    break;
                }
                case "container":
                case "containerdata": {
                    if(containerdata != null){
                        containerdata.writeToNBT(compound);
                    }
                    break;
                }
            }
        }
        else{
            compound = getUpdateTag();
            compound.setBoolean("default", true);
        }
        ApiUtil.sendTileEntityUpdatePacket(world, pos, compound);
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate pkt){
        if(pkt.nbt.hasKey("default") && pkt.nbt.getBoolean("default")){
            this.readFromNBT(pkt.nbt);
        }
        else{
            NBTTagCompound com = pkt.nbt;
            lift = com.hasKey("lift") ? com.getByte("lift") : lift;
            liftstate = com.hasKey("liftstate") ? com.getDouble("liftstate") : liftstate;
            VehicleData data = Resources.getVehicleData(com);
            if(data != null){
                vehicledata = data;
            }
            PartData pdata = Resources.getPartData(com);
            if(pdata != null){
                partdata = pdata;
            }
            ContainerData cdata = Resources.getContainerData(com);
            if(cdata != null){
                containerdata = cdata;
            }
            if(com.hasKey("center_con")){
                center = com.getBoolean("center_con") ? BlockPos.fromLong(com.getLong("center")) : null;
            }
            if(com.hasKey("primary_rgb")){
                if(vehicledata != null){
                    vehicledata.getPrimaryColor().packed = com.getInteger("primary_rgb");
                }
                if(containerdata != null){
                    containerdata.getPrimaryColor().packed = com.getInteger("primary_rgb");
                }
            }
            if(com.hasKey("secondary_rgb")){
                if(vehicledata != null){
                    vehicledata.getSecondaryColor().packed = com.getInteger("secondary_rgb");
                }
                if(containerdata != null){
                    containerdata.getSecondaryColor().packed = com.getInteger("secondary_rgb");
                }
            }
        }
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
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(this.vehicledata != null){
            compound = vehicledata.writeToNBT(compound);
        }
        compound.setDouble("LiftState", liftstate);
        if(center != null){
            compound.setLong("Center", center.toLong());
        }
        if(partdata != null){
            compound = this.partdata.writeToNBT(compound);
        }
        if(containerdata != null){
            compound = this.containerdata.writeToNBT(compound);
        }
        Print.debug(compound);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        Print.debug(compound);
        super.readFromNBT(compound);
        this.vehicledata = Resources.getVehicleData(compound);
        this.liftstate = compound.getFloat("LiftState");
        this.center = compound.hasKey("Center") ? BlockPos.fromLong(compound.getLong("Center")) : null;
        this.partdata = Resources.getPartData(compound);
        containerdata = Resources.getContainerData(compound);
    }

    public void scanAndConnect(EntityPlayer player){
        ArrayList<ConstructorCenterEntity> list = new ArrayList<ConstructorCenterEntity>();
        int x = pos.getX() - 8;
        int y = pos.getY();
        int z = pos.getZ() - 8;
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                TileEntity tile = world.getTileEntity(new BlockPos(x + i, y, z + j));
                if(tile != null && tile instanceof ConstructorCenterEntity){
                    list.add((ConstructorCenterEntity) tile);
                }
                tile = world.getTileEntity(new BlockPos(x + i, y - 1, z + j));
                if(tile != null && tile instanceof ConstructorCenterEntity){
                    list.add((ConstructorCenterEntity) tile);
                }
                tile = world.getTileEntity(new BlockPos(x + i, y + 1, z + j));
                if(tile != null && tile instanceof ConstructorCenterEntity){
                    list.add((ConstructorCenterEntity) tile);
                }
            }
        }
        for(ConstructorCenterEntity entity : list){
            if(entity.getConstructor() == null || world.getTileEntity(entity.getConstructor()) == null){
                entity.link(new BlockPos(this.pos));
                Print.chat(player, "&aConnected&7!");
                this.center = new BlockPos(entity.getPos());
                this.sendUpdate("center");
                return;
            }
        }
        Print.chat(player, "&7No &aFree &7Center Block found!");
    }

    public VehicleData getVehicleData(){
        return this.vehicledata;
    }

    public PartData getPartData(){
        return this.partdata;
    }

    public ContainerData getContainerData(){
        return this.containerdata;
    }

    public Colorable getColorable(){
        return vehicledata == null ? containerdata : vehicledata;
    }

    public Lockable getLockable(){
        return vehicledata == null ? containerdata : vehicledata;
    }

    public Textureable getTextureable(){
        return vehicledata == null ? containerdata : vehicledata;
    }

    public void setData(ItemStack stack){
        if(stack.getItem() instanceof VehicleItem){
            this.vehicledata = ((VehicleItem) stack.getItem()).getVehicle(stack);
            this.containerdata = null;
            setPartData(null, true);
        }
        if(stack.getItem() instanceof ContainerItem){
            this.vehicledata = null;
            this.containerdata = ((ContainerItem) stack.getItem()).getContainer(stack);
            setPartData(null, true);
        }
    }

    public void setPartData(PartData data){
        this.setPartData(data, false);
        return;
    }

    public void setPartData(PartData data, boolean drop){
        if((this.partdata != null && data != null) || drop){
            if(partdata == null){
                return;
            }
            ItemStack stack = this.partdata.getPart().getItemStack(partdata);
            EntityItem entity = new EntityItem(world, this.pos.getX() + 0.5, this.pos.getY() + 1.5f, this.pos.getZ() + 0.5, stack);
            world.spawnEntity(entity);
            this.partdata = null;
        }
        this.partdata = data;
    }

    public void recycleVehicle(){
        if(vehicledata == null){
            return;
        }
        ArrayList<EntityItem> list = new ArrayList<EntityItem>();
        ArrayList<String> slist = new ArrayList<String>();
        vehicledata.getParts().forEach((as, data) -> {
            if(!vehicledata.getVehicle().getPreinstalledParts().values().contains(data.getPart().getRegistryName())){
                EntityItem item = new EntityItem(world);
                item.setItem(data.getPart().getItemStack(data));
                item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                list.add(item);
                slist.add(as);
            }
        });
        for(String string : slist){
            vehicledata.getParts().remove(string);
        }
        //
        EntityItem item = new EntityItem(world);
        item.setItem(vehicledata.getVehicle().getItemStack(vehicledata));
        item.setPosition(pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
        list.add(item);
        //
        list.forEach((entity) -> {
            world.spawnEntity(entity);
        });
        this.vehicledata = null;
        this.sendUpdate(null);
    }

    public void addLift(int i){
        this.lift += i;
        if(this.lift > 10){
            this.lift = 10;
        }
        if(this.lift < -10){
            this.lift = -10;
        }
        this.sendUpdate("lift");
    }

    public void onButtonPress(ConstructorButton button, EntityPlayer player, String[] args){
        if(button.ID == 0){
            ItemStack stack = vehicledata == null ? containerdata == null ? null : containerdata.getContainer().getItemStack(containerdata) : vehicledata.getVehicle().getItemStack(vehicledata);
            if(stack != null){
                EntityItem item = new EntityItem(world);
                item.setItem(stack);
                item.setPosition(this.pos.getX() + 0.5f, this.pos.getY() + 1.5f, this.pos.getZ() + 0.5f);
                world.spawnEntity(item);
            }
            this.vehicledata = null;
            this.containerdata = null;
            this.liftstate = 0;
            this.lift = 0;
            this.sendUpdate(null);
            return;
        }
        else if(button.ID == 1){
            //TODO open "spawn as" screen
            return;
        }
        return;
    }

}
