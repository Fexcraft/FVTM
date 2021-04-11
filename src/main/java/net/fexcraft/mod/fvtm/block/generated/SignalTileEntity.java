package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.minecraft.nbt.NBTTagCompound;

public class SignalTileEntity extends BlockTileEntity {
	
	public Vec316f juncpos;
	public Junction junction;
	public EntryDirection dir = EntryDirection.FORWARD;
	
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
        	if(world != null){
            	RailSystem sys = world.getCapability(Capabilities.RAILSYSTEM, null);
            	if(sys != null) junction = sys.get().getJunction(juncpos, true);
        	}
        	dir = EntryDirection.getFromSaveByte(compound.getByte("direction"));
        }
    }

	public void setJunction(Vec316f vec){
		juncpos = vec;
		sendUpdate();
    	RailSystem sys = world.getCapability(Capabilities.RAILSYSTEM, null);
    	if(sys != null) junction = sys.get().getJunction(juncpos, true);
	}

	public Junction getJunction(){
		if(junction == null && juncpos != null){
        	RailSystem sys = world.getCapability(Capabilities.RAILSYSTEM, null);
        	if(sys != null) junction = sys.get().getJunction(juncpos, false);
        	if(junction == null) juncpos = null;//TODO control
		}
		return junction;
	}

	public Vec316f getJuncPos(){
		return juncpos;
	}

	public void toggleDirection(){
		dir = dir.toggle();
		sendUpdate();
	}

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

}
