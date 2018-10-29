package net.fexcraft.mod.fvtm.impl.container;

import net.fexcraft.lib.mc.capabilities.sign.SignCapability;
import net.fexcraft.lib.mc.utils.Formatter;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.root.InventoryType;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ContainerStatusListener implements SignCapability.Listener {

    private static final ResourceLocation regname = new ResourceLocation("fvtm:container");
    private boolean active;
    private BlockPos container;

    @Override
    public ResourceLocation getId(){
        return regname;
    }

    @Override
    public boolean isActive(){
        return active;
    }

    @Override
    public boolean onPlayerInteract(SignCapability cap, PlayerInteractEvent event, IBlockState state, TileEntitySign tileentity){
        if(event.getWorld().isRemote){
            return false;
        }
        if(!active){
            if(tileentity.signText[0].getUnformattedText().equals("[fvtm-container]")){
                TileEntity te = event.getWorld().getTileEntity(getPosAtBack(state, tileentity));
                if(te != null && te instanceof ContainerTileEntity){
                    container = te.getPos();
                    updateText(tileentity);
                    sendUpdate(tileentity);
                    cap.setActive();
                    active = true;
                    return true;
                }
                else{
                    Print.bar(event.getEntityPlayer(), "Container not found.");
                }
            }
        }
        else{
            updateText(tileentity);
            sendUpdate(tileentity);
            return true;
        }
        return false;
    }

    private void updateText(TileEntitySign tileentity){
        tileentity.signText[0] = new TextComponentString(Formatter.format("&0[&9FVTM&3-&9Container&0]"));
        TileEntity te = tileentity.getWorld().getTileEntity(container);
        if(te != null && te instanceof ContainerTileEntity){
            ContainerTileEntity conte = (ContainerTileEntity) te;
            if(conte.getContainerData() == null){
                tileentity.signText[1] = new TextComponentString("no con. data");
            }
            else{
                ContainerData data = conte.getContainerData();
                if(data.getContainer().getInventoryType() == InventoryType.ITEM){
                    if(data.getContainer() instanceof GenericContainer && ((GenericContainer) data.getContainer()).contenttype != null){
                        tileentity.signText[1] = new TextComponentString("Type: " + ((GenericContainer) data.getContainer()).contenttype);
                    }
                    else{
                        tileentity.signText[1] = new TextComponentString("General Use");
                    }
                }
                else if(data.getContainer().getInventoryType() == InventoryType.FLUID){
                    tileentity.signText[1] = new TextComponentString(data.getFluidTank().getFluid() != null ? "F: " + data.getFluidTank().getFluid().getLocalizedName() : "no fluid");
                }
                tileentity.signText[2] = new TextComponentString(data.getFluidTank() == null || data.getFluidTank().getFluid() == null ? data.getInventory() == null ? "empty" : data.getInventory().stream().filter(is -> is != null && !is.isEmpty()).count() + " stacks" : data.getFluidTank().getFluidAmount() + "mB");
                tileentity.signText[3] = new TextComponentString("Capacity: " + (data.getContainer().getInventoryType() == InventoryType.FLUID ? (data.getContainer().getInventorySize() / 1000) + "b" : data.getContainer().getInventorySize()));
            }
        }
        else{
            tileentity.signText[1] = new TextComponentString("no container");
        }
    }

    @Override
    public NBTBase writeToNBT(Capability<SignCapability> capability, EnumFacing side){
        if(!active || container == null){
            return null;
        }
        return new NBTTagLong(container.toLong());
    }

    @Override
    public void readNBT(Capability<SignCapability> capability, EnumFacing side, NBTBase nbt){
        if(nbt == null){
            active = false;
            return;
        }
        active = true;
        container = BlockPos.fromLong(((NBTTagLong) nbt).getLong());
    }

}
