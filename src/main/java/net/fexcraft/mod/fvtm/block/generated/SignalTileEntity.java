package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;

public class SignalTileEntity extends BlockTileEntity implements JunctionTrackingTileEntity {
	
	protected Vec316f juncpos;
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
        	compound.setTag("junction", juncpos.write());
        	compound.setByte("direction", dir.getSaveByte());
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("junction")){
        	juncpos = new Vec316f(compound.getCompoundTag("junction"));
        	dir = EntryDirection.getFromSaveByte(compound.getByte("direction"));
        }
        else{
        	juncpos = null;
        	junction = null;
        	dir = EntryDirection.FORWARD;
        }
    }

    @Override
	public void setJunction(Vec316f vec){
		juncpos = vec;
		sendUpdate();
	}

    @Override
	public Junction getJunction(){
		if(junction == null && juncpos != null){
        	RailSystem sys = world.getCapability(Capabilities.RAILSYSTEM, null);
        	if(sys != null) junction = sys.get().getJunction(juncpos, false);
        	if(junction == null){
        		juncpos = null;//TODO control
        		Static.stop();
        	}
        	junction.entities.add(this);
		}
		return junction;
	}

    @Override
	public Vec316f getJuncPos(){
		return juncpos;
	}
    
    @Override
    public void invalidate(){
       super.invalidate();
       if(junction != null) junction.entities.remove(this);
    }
    
    @Override
    public void updateSignalState(){
    	Print.debug(world, junction, juncpos);
    	if(world == null || junction == null) return;
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

}
