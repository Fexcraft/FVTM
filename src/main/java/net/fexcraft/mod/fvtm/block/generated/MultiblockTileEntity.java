package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.MB_Access;
import net.fexcraft.mod.fvtm.data.block.MB_Access.CapabilityContainer;
import net.fexcraft.mod.fvtm.data.block.MB_Trigger;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData0;
import net.fexcraft.mod.fvtm.item.MultiBlockItem;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiblockTileEntity extends BlockTileEntity {
	
	public List<MB_Trigger> triggers;
	protected MultiblockTileEntity reference;
	protected MultiBlockData0 mdata;
	protected BlockPos core;
	protected boolean iscore;
	
	public MultiblockTileEntity(BlockBase type){
		super(type);
	}

	public MultiblockTileEntity(){}
	
	public MultiblockTileEntity setCore(BlockPos pos, ItemStack stack){
        BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
        if(!pos.equals(core)){
            this.core = core;
        }
        else{
        	iscore = true;
	        mdata = ((MultiBlockItem)stack.getItem()).getData(stack);
        }
        this.markDirty();
        return this;
	}
	
	public BlockPos getCore(){
		return iscore ? pos : core;
	}
	
	public boolean isCore(){
		return iscore;
	}

	public MultiBlockData0 getMultiBlockData(){
		return iscore ? mdata : getMultiBlockDataFromCore();
	}
	
	private MultiBlockData0 getMultiBlockDataFromCore(){
		if(reference != null) return reference.getMultiBlockData();
		if(core == null){
			//Print.debug("no core from");
			return null;
		}
		MultiblockTileEntity tile = (MultiblockTileEntity)world.getTileEntity(core);
		reference = (tile == null ? null : tile);
		return reference == null ? null : reference.getMultiBlockData();
	}

	public void setup(){
		if(mdata == null) return;
		world.getCapability(Capabilities.MULTIBLOCKS, null).registerMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()).getOpposite(), mdata);
	}
	
	@Override
	public void invalidate(){
		super.invalidate();
		if(data == null || mdata == null) return;
		world.getCapability(Capabilities.MULTIBLOCKS, null).unregisterMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()).getOpposite(), mdata);
	}
    
    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("MultiBlockCore")) core = BlockPos.fromLong(compound.getLong("MultiBlockCore"));
		if(compound.hasKey("MultiBlock")){
			if(mdata != null) mdata.read(compound.getCompoundTag("MultiBlock"));
			else mdata = Resources.getMultiBlockData(compound.getCompoundTag("MultiBlock"));
		}
        if(iscore = core == null) reference = this;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(core != null) compound.setLong("MultiBlockCore", core.toLong());
		if(mdata != null) compound.setTag("MultiBlock", mdata.write(new NBTTagCompound()));
        return compound;
    }
    
    private Map<EnumFacing, List<MB_Access.CapabilityContainer>> capabilities;

    private void loadCapabilities(){
    	MultiBlockData0 data = getMultiBlockData();
    	if(data == null){
    		//Print.debug("no data");
    		return;
    	}
    	if(reference == null){
    		//Print.debug("no core");
    		return;
    	}
		data.getType().getCapabilities(data, EnumFacing.byIndex(reference.getBlockMetadata()), pos, isCore() ? pos : getCore(), capabilities = new HashMap<>());
	}

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
    	if(capabilities == null) loadCapabilities();
    	if(capabilities != null && capabilities.containsKey(facing)){
			for(MB_Access.CapabilityContainer con : capabilities.get(facing)){
				if(con.cap == capability) return true;
			}
    	}
        return super.hasCapability(capability, facing);
    }

	@Override
    @Nullable
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
    	if(capabilities == null) loadCapabilities();
    	if(capabilities != null && capabilities.containsKey(facing)){
			for(MB_Access.CapabilityContainer con : capabilities.get(facing)){
				if(con.cap == capability) return (T)con.handler.getCapObj();
			}
    	}
        return super.getCapability(capability, facing);
    }

    @Override
    public void processClientPacket(PacketTileEntityUpdate pkt){
    	if(pkt.nbt.hasKey("target") && pkt.nbt.getString("target").equals("script")){
    		if(this.getMultiBlockData() != null && this.getMultiBlockData().getScript() != null){
    			this.getMultiBlockData().getScript().onUpdatePacket(this, pkt.nbt);
    		}
    		return;
    	}
    	super.processClientPacket(pkt);
    }

    @Override
    public void processServerPacket(PacketTileEntityUpdate pkt){
    	if(pkt.nbt.hasKey("target") && pkt.nbt.getString("target").equals("script")){
    		if(this.getMultiBlockData() != null && this.getMultiBlockData().getScript() != null){
    			this.getMultiBlockData().getScript().onUpdatePacket(this, pkt.nbt);
    		}
    		return;
    	}
    	super.processServerPacket(pkt);
    }
    
    public List<CapabilityContainer> getCapabilities(EnumFacing side){
    	if(capabilities == null) loadCapabilities();
    	return capabilities.get(side);
    }

}
