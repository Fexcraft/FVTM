package net.fexcraft.mod.fvtm.block.generated;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.MULTIBLOCK_INVENTORY;
import static net.fexcraft.mod.fvtm.util.Properties.FACING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.fexcraft.lib.mc.api.packet.IPacketReceiver;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.network.packet.PacketTileEntityUpdate;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.MB_Access;
import net.fexcraft.mod.fvtm.data.block.MB_Trigger;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class M_4ROT_TE extends BlockBase {

    public M_4ROT_TE(Block type){
        super(type);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "facing=" + state.getValue(FACING).getName());
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "facing=" + state.getValue(FACING).getName()).offset(pos);
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "facing=" + state.getValue(FACING).getName());
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(player.getHeldItem(hand).getItem() instanceof ItemDye){
    		return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    	}
        if(!world.isRemote){
            TileEntity te = (TileEntity)world.getTileEntity(pos);
            if(te == null){
                Print.chat(player, "No TileEntity found.");
                return true;
            }
            MultiBlockData data = te.getMultiBlockData();
            if(data == null){
                Print.chat(player, "MultiBlockData not found.");
                return true;
            }
            if(te.triggers == null) te.triggers = data.getType().getTriggers(state.getValue(FACING), pos, te.isCore() ? pos : te.getCore());
            if(processTriggers(te.triggers, data, te.isCore() ? pos : te.getCore(), player, hand, state, pos, side, hitX, hitY, hitZ)){
            	return true;
            }
            return false;
        }
        return true;
    }
    
    protected static boolean processTriggers(List<MB_Trigger> triggers, MultiBlockData data, BlockPos core, EntityPlayer player, EnumHand hand, IBlockState state, BlockPos pos, EnumFacing side, float x, float y, float z){
    	for(MB_Trigger trigger : triggers){
        	boolean pass = trigger.isWholeBlock();
        	IBlockState corestate = player.world.getBlockState(core);
        	Vec3d hit = new Vec3d(x, y, z);
        	if(!pass && trigger.getBB() != null) pass = trigger.getBB().contains(hit);//TODO aabb rotation
        	if(!pass && trigger.getSide() != null) pass = trigger.getSide(corestate.getValue(FACING)) == side;
        	if(pass){
        		if(trigger.forInventory()){
        			openInventory(player, trigger.getTarget(), core);
        			return true;
        		}
        		if(trigger.forScript() && data.getScript() != null){
        			data.getScript().onTrigger(data, trigger, player, hand, core, pos, side, hit);
        			return true;
        		}
        	}
        	Print.debug(pass + " " + trigger.getTarget() + " " + trigger.forInventory());
    	}
    	return false;
    }

    protected static void openInventory(EntityPlayer player, String target, BlockPos corepos){
    	TileEntity core = (TileEntity)player.world.getTileEntity(corepos);
    	ApiUtil.sendTileEntityUpdatePacket(core, core.writeToNBT(new NBTTagCompound()), 256);
    	//
    	NBTTagCompound packet = new NBTTagCompound();
		packet.setString("inventory", target);
        int[] xyz = new int[]{ corepos.getX(), corepos.getY(), corepos.getZ() };
        GenericContainer.openGui(MULTIBLOCK_INVENTORY, xyz, LISTENERID, packet, player);
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        ((TileEntity)world.getTileEntity(pos)).setCore(pos, stack).setup();
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote){
    		processBreak(world, pos, true);
        }
        super.breakBlock(world, pos, state);
    }
    
	public static void processBreak(World world, BlockPos pos, boolean hastile){
		TileEntity broken = hastile ? (TileEntity)world.getTileEntity(pos) : null;
		MultiBlockData data = broken == null ? world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlock(pos) : broken.getMultiBlockData();
		if(data == null){
			//Print.debug("Multiblock at " + pos + " not found!");
			return;
		}
		BlockPos corepos = broken == null ? world.getCapability(Capabilities.MULTIBLOCKS, null).getMultiBlockCore(pos) : broken.getCore();
		IBlockState core = world.getBlockState(corepos);
		if(core == null){
			//Print.debug("Multiblock at " + pos + " has no core!");
			return;
		}
		if(core.getBlock() instanceof M_4ROT_TE == false){
			//Print.debug("Block at " + pos + "is NOT a MultiBlock! " + core);
			return;
		}
		ArrayList<BlockPos> positions = data.getType().getPositions(data.getData().getType(), corepos, core.getValue(FACING));
		positions.forEach(blkpos -> {
			IBlockState posstate = world.getBlockState(blkpos);
			if(posstate.getBlock() instanceof M_4ROT_TE || posstate.getBlock() instanceof M_4ROT){
				TileEntity tile = (TileEntity)world.getTileEntity(blkpos);
				if(tile != null && tile.iscore){
					//TODO empty out inventories (drop)
					EntityItem item = new EntityItem(world);
					item.setPosition(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
					item.setItem(tile.getBlockData().newItemStack());
					world.spawnEntity(item);
				}
	            world.setBlockState(blkpos, Blocks.AIR.getDefaultState());
			}
		});
		//Print.debug("Removed MultiBlock at " + corepos + " / " + pos);
	}

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return type.getMultiBlock() != null && type.getMultiBlock().isTickable() ? new M_4ROT_TE.TickableTE(this) : new M_4ROT_TE.TileEntity(this);
	}

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
    	TileEntity our = (TileEntity)world.getTileEntity(pos);
        TileEntity tile = our.iscore ? our : our.reference;
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().newItemStack();
    }
    
    @Override
    public int quantityDropped(Random random){
        return 0;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Items.AIR;
    }
    
    @Override
    public ItemStack getItem(World world, BlockPos pos, IBlockState state){
    	TileEntity our = (TileEntity)world.getTileEntity(pos);
        TileEntity tile = our.iscore ? our : our.reference;
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().newItemStack();
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }
	
	public static class TileEntity extends BlockBase.TileEntity {
		
		public List<MB_Trigger> triggers;
		private TileEntity reference;
		private BlockPos core;
		private boolean iscore;
		
		public TileEntity(BlockBase type){
			super(type);
		}

		public TileEntity(){}
		
		public TileEntity setCore(BlockPos pos, ItemStack stack){
	        BlockPos core = BlockPos.fromLong(stack.getTagCompound().getLong("PlacedPos"));
	        if(!pos.equals(core)){
	            this.core = core;
	        }
	        else{
	        	iscore = true;
		        data = ((BlockItem)stack.getItem()).getData(stack);
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
			return iscore ? data.getMultiBlockData() : getMultiBlockDataFromCore();
		}
		
		private MultiBlockData getMultiBlockDataFromCore(){
			if(reference != null) return reference.getMultiBlockData();
			if(core == null){
				//Print.debug("no core from");
				return null;
			}
			TileEntity tile = (TileEntity)world.getTileEntity(core);
			reference = (tile == null ? null : tile);
			return reference == null ? null : reference.getMultiBlockData();
		}

		public void setup(){
			if(data == null || data.getMultiBlockData() == null){
				//Print.debug("data is null");
				return;
			}
			//Print.debug("data is NOT null");
			world.getCapability(Capabilities.MULTIBLOCKS, null).registerMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()).getOpposite(), data.getMultiBlockData());
		}
		
		@Override
		public void invalidate(){
			super.invalidate();
			if(data == null || data.getMultiBlockData() == null) return;
			world.getCapability(Capabilities.MULTIBLOCKS, null).unregisterMultiBlock(pos, EnumFacing.byIndex(this.getBlockMetadata()).getOpposite(), data.getMultiBlockData());
		}
	    
	    @Override
	    public void readFromNBT(NBTTagCompound compound){
	        super.readFromNBT(compound);
	        if(compound.hasKey("MultiBlockCore")) core = BlockPos.fromLong(compound.getLong("MultiBlockCore"));
	        if(iscore = core == null) reference = this;
	    }

	    @Override
	    public NBTTagCompound writeToNBT(NBTTagCompound compound){
	        super.writeToNBT(compound);
	        if(core != null) compound.setLong("MultiBlockCore", core.toLong());
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

		@SuppressWarnings("unchecked")
	    @Override
	    @Nullable
	    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
	    	if(capabilities == null) loadCapabilities();
	    	if(capabilities != null && capabilities.containsKey(facing)){
    			for(MB_Access.CapabilityContainer con : capabilities.get(facing)){
    				if(con.cap == capability) return (T)con.value;
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

	}
	
	public static class TickableTE extends TileEntity implements IPacketReceiver<PacketTileEntityUpdate>, ITickable {
		
		public TickableTE(BlockBase type){
			super(type);
		}
		
		public TickableTE(){}

		@Override
		public void update(){
			if(data == null || data.getMultiBlockData() == null || data.getMultiBlockData().getScript() == null) return;
			data.getMultiBlockData().getScript().onUpdate(this);
		}

	}

}

