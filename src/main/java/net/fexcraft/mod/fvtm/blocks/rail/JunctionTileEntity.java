package net.fexcraft.mod.fvtm.blocks.rail;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.cap.WorldRailDataSerializer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class JunctionTileEntity extends TileEntity {
	
	public RailRegion region;
	
    /*@SideOnly(Side.CLIENT)
    @Override
    public double getMaxRenderDistanceSquared(){
        return super.getMaxRenderDistanceSquared() * 8;
    }

    @SideOnly(Side.CLIENT) @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return INFINITE_EXTENT_AABB;
    }*/
    
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
