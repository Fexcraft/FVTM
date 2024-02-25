package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.Static;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.nbt.NBTTagCompound;

public class SwitchTileEntity extends BlockTileEntity implements JunctionTrackingTileEntity {
	
	protected QV3D juncpos;
	protected Junction junction;
	
	public SwitchTileEntity(){}

	public SwitchTileEntity(BlockBase type){
		super(type);
	}

	public boolean getSwitch0State(){
		return getJunction() != null && junction.switch0;
	}

	public boolean getSwitch1State(){
		return getJunction() != null && junction.switch1;
	}

	public Boolean getSwitchStateFork3(){
		return getJunction() == null || junction.switch0 ? null : junction.switch1;
	}

	public int getSwitch2State(){
		return getJunction() == null || junction.switch0 ? 0 : junction.switch1 ? 2 : 1;
	}

	public boolean isDoubleSwitchState(boolean switch0, boolean switch1){
		if(getJunction() == null) return false;
		return junction.switch0 == switch0 && junction.switch1 == switch1;
	}

	public boolean isDoubleSwitchStateOnSide(boolean side, boolean state){
		if(getJunction() == null) return false;
		return side ? junction.switch1 == state : junction.switch0 == state;
	}

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(juncpos != null){
        	juncpos.write(TagCW.wrap(compound), "junction");
        }
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("junction")){
        	juncpos = new QV3D(TagCW.wrap(compound), "junction");
        }
        else{
        	juncpos = null;
        	junction = null;
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
        	RailSystem sys = SystemManager.get(Systems.RAIL, world);
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
    public void updateSwitchState(){
    	if(world == null || junction == null) return;
    	world.notifyNeighborsOfStateChange(pos, world.getBlockState(pos).getBlock(), true);
    }

}
