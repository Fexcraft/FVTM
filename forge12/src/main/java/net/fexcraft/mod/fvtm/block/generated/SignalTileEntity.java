package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.nbt.NBTTagCompound;

public class SignalTileEntity extends BlockTileEntity implements JunctionTrackingTileEntity {
	
	protected QV3D juncpos;
	protected Junction junction;
	protected EntryDirection dir = EntryDirection.FORWARD;
	
	public SignalTileEntity(){}

	public SignalTileEntity(BlockBase type){
		super(type);
	}

	public int getSignalState(){
		return getJunction() == null ? -1 : junction.getSignalState(dir) ? 1 : 0;
	}

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(juncpos != null){
        	juncpos.write(TagCW.wrap(compound), "junction");
        	compound.setByte("direction", dir.getSaveByte());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("junction")){
        	juncpos = new QV3D(TagCW.wrap(compound), "junction");
        	dir = EntryDirection.getFromSaveByte(compound.getByte("direction"));
        }
        else{
        	juncpos = null;
        	junction = null;
        	dir = EntryDirection.FORWARD;
        }
    }

    @Override
	public void setJunction(QV3D vec){
		juncpos = vec;
		linkJunction(world, pos, vec);
		sendUpdate();
	}

    @Override
	public Junction getJunction(){
		if(junction == null && juncpos != null && this.pos != null){
        	RailSystem sys = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
        	if(sys != null) junction = sys.getJunction(juncpos, false);
        	if(junction == null){
        		juncpos = null;//TODO control
        		Static.stop();
        	}
        	else junction.addLinkedTileEntity(this.pos);
		}
		return junction;
	}

    @Override
	public QV3D getJuncPos(){
		return juncpos;
	}
    
    @Override
    public void invalidate(){
       super.invalidate();
       if(junction != null) junction.entities.remove(this.pos);
    }
    
    @Override
    public void updateSignalState(){
    	if(world == null || getJunction() == null) return;
    	world.notifyNeighborsOfStateChange(pos, world.getBlockState(pos).getBlock(), true);
    }

    @Override
	public void toggleDirection(){
		dir = dir.toggle();
		sendUpdate();
	}

    @Override
	public EntryDirection getDirection(){
		return dir;
	}

	/** For the status printout. */
	public String getValidatedJunctionStatus(){
		if(junction.signal_dir.isBoth() || junction.signal_dir == dir){
			return junction.getSignalState(dir) ? "&agreen" : "&cred";
		}
		else return "&einvalid signal direction for this junction";
	}

	@Override
	public boolean isSignal(){
		return true;
	}

	public long getSectionId(){
		if(getJunction() == null) return 0l;
		return junction.tracks.get(dir.getTrackId()).getUnit().getSectionId();
	}

}
