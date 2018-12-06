package net.fexcraft.mod.fvtm.blocks.sign;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.registry.UCResourceLocation;
import net.fexcraft.lib.mc.render.ExternalTextureHelper;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.model.block.AdjSignModel;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdjustableSignEntity extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate> {

    private byte width, height;
    private UCResourceLocation texture = new UCResourceLocation(Resources.NULL_TEXTURE);

    @SideOnly(Side.CLIENT)
    private AdjSignModel model;

    public AdjustableSignEntity(){
        width = 1;
        height = 1;
        if(Static.side().isClient()){
            model = AdjSignModel.getModel(width, height);
        }
    }

    public final AdjSignModel getModel(){
        return model;
    }

    public final ResourceLocation getTexture(){
        return texture;
    }

    public final int getWidth(){
        return this.width;
    }

    public final int getHeight(){
        return this.height;
    }

    public void resize(EnumFacing.Plane plane, int i){
        if(plane == EnumFacing.Plane.HORIZONTAL){
            this.width = (byte) i;
            if(width > 16){
                width = 16;
            }
            if(width < 1){
                width = 1;
            }
        }
        else if(plane == EnumFacing.Plane.VERTICAL){
            this.height = (byte) i;
            if(height > 16){
                height = 16;
            }
            if(height < 1){
                height = 1;
            }
        }
        this.sendUpdate();
    }

    public void setTexture(String string, EntityPlayer player){
        if(string == null){
            this.texture = new UCResourceLocation(Resources.NULL_TEXTURE);
            //Print.chat(player, "Resseting texture.");
        }
        if(string != null){
            this.texture = new UCResourceLocation("", string);
            //Print.chat(player, "Texture set to: " + this.texture.getResourcePath());
        }
        this.sendUpdate();
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
        super.writeToNBT(compound);
        compound.setString("texture", this.texture.getResourcePath());
        compound.setByte("width", width);
        compound.setByte("height", height);
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

        if(compound.hasKey("texture")){
            this.texture = new UCResourceLocation("", compound.getString("texture"));
        }
        if(compound.hasKey("width")){
            this.width = compound.getByte("width");
        }
        if(compound.hasKey("height")){
            this.height = compound.getByte("height");
        }
        //
        if(Static.side().isClient()){
            if(texture.toString().contains("fcl:remote/")){
                texture = new UCResourceLocation("", texture.toString().replace("fcl:remote/", ""));
            }
            model = AdjSignModel.getModel(width, height);
            texture = ExternalTextureHelper.get(texture.getResourcePath());
        }
    }

    @SideOnly(Side.CLIENT)
    public double getMaxRenderDistanceSquared(){
        return 512D;
    }

}
