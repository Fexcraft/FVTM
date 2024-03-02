package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.MB_Access;
import net.fexcraft.mod.fvtm.data.block.MB_Access.CapabilityContainer;
import net.fexcraft.mod.fvtm.data.block.MB_Interact;
import net.fexcraft.mod.fvtm.data.block.MultiBlock;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.item.MultiBlockItem;
import net.fexcraft.mod.uni.tag.TagCW;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.fexcraft.mod.uni.world.WrapperHolder.getLocalSide;

public class MultiblockTileEntity extends BlockTileEntity {
	
	public List<MB_Interact> triggers;
	protected MultiblockTileEntity reference;
	protected MultiBlockData mdata;
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
	        mdata = ((MultiBlockItem)stack.getItem()).getData(TagCW.wrap(stack.getTagCompound()));
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

	public MultiBlockData getMultiBlockData(){
		return iscore ? mdata : getMultiBlockDataFromCore();
	}
	
	private MultiBlockData getMultiBlockDataFromCore(){
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
			else mdata = FvtmResources.getMultiBlockData(compound.getCompoundTag("MultiBlock"));
		}
        if(iscore = core == null) reference = this;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        if(core != null) compound.setLong("MultiBlockCore", core.toLong());
		if(mdata != null) compound.setTag("MultiBlock", mdata.write(null).local());
        return compound;
    }
    
    private Map<EnumFacing, List<MB_Access.CapabilityContainer>> capabilities;

    private void loadCapabilities(){
    	MultiBlockData data = getMultiBlockData();
    	if(data == null){
    		//Print.debug("no data");
    		return;
    	}
    	if(reference == null){
    		//Print.debug("no core");
    		return;
    	}
		getCapabilities(data, EnumFacing.byIndex(reference.getBlockMetadata()), pos, isCore() ? pos : getCore(), capabilities = new HashMap<>());
	}

	public void getCapabilities(MultiBlockData data, EnumFacing facing, BlockPos pos, BlockPos core, Map<EnumFacing, List<MB_Access.CapabilityContainer>> capabilities){
		pos = core.subtract(pos);
		pos = pos.up(-pos.getY() * 2);
		pos = pos.rotate(getRotation(facing, true));
		V3I rpos = new V3I(pos.getX(), pos.getY(), pos.getZ());
		data.getType().getAccess().forEach(access -> {
			if(access.getPos().equals(rpos)){
				//Print.debug("found " + rpos);
				fillCaps(access, data, null, facing, capabilities);
			}
		});
	}

	@Deprecated
	public static Rotation getRotation(EnumFacing facing, boolean counter){
		switch(facing){
			case EAST:
				return counter ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90;
			case SOUTH:
				return Rotation.CLOCKWISE_180;
			case WEST:
				return counter ? Rotation.CLOCKWISE_90 : Rotation.COUNTERCLOCKWISE_90;
			default:
				return Rotation.NONE;
		}
	}

	public void fillCaps(MB_Access access, MultiBlockData data, EnumFacing facing, EnumFacing rotateby, Map<EnumFacing, List<CapabilityContainer>> capabilities){
		if(facing == null){
			if(access.getSide() == null){
				for(EnumFacing face : EnumFacing.VALUES){
					fillCaps(access, data, face, rotateby, capabilities);
				}
			}
			else fillCaps(access, data, getLocalSide(access.getSide()), rotateby, capabilities);
			return;
		}
		//Print.debug("filling " + facing);
		facing = MultiBlock.rotate(facing, rotateby).local();
		if(!capabilities.containsKey(facing)) capabilities.put(facing, new ArrayList<>());
		InvHandler handler = data.getInventories().get(access.getTarget());
		Capability<?> cap = null;
		if(handler.type.isFluid()){
			cap = CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
		}
		else if(handler.type.isItem()){
			cap = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
		}
		else if(!handler.type.isVariable()) return;
		capabilities.get(facing).add(new CapabilityContainer(access.getTarget(), cap, handler));
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
