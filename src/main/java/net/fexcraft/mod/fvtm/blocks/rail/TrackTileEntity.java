package net.fexcraft.mod.fvtm.blocks.rail;

import java.util.Map.Entry;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.prototype.ConnContainer;
import net.fexcraft.mod.fvtm.prototype.RailRegion;
import net.fexcraft.mod.fvtm.prototype.WorldRailDataSerializer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrackTileEntity extends TileEntity {
	
	public RailRegion region;
	public Entry<BlockPos, ConnContainer> entry;
	
    @SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }

    @SideOnly(Side.CLIENT) @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound){
    	super.readFromNBT(compound);
        if(this.world != null && this.world.isRemote){
        	world.getCapability(WorldRailDataSerializer.CAPABILITY, null).setTileData(this, true);
        }
        else{
        	Print.debug(world == null ? "noworld" : "te:" + world.isRemote);
        }
    }

}
