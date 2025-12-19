package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.V3I;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.utils.ApiUtil;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.uni.world.AABB;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.data.block.MB_Access.CapabilityContainer;
import net.fexcraft.mod.fvtm.data.block.MB_Interact;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.uni.world.CubeSide;
import net.fexcraft.mod.uni.world.WrapperHolder;
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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.fexcraft.mod.fvtm.util.GuiHandler.LISTENERID;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.FACING;

public class M_4ROT_TE extends BlockBase {

    public M_4ROT_TE(Block type){
        super(type);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return type.getAABB("default", "facing=" + state.getValue(FACING).getName()).get(0);
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos){
        return type.getAABB("selection", "facing=" + state.getValue(FACING).getName()).offset(0, pos.getX(), pos.getY(), pos.getZ()).local();
    }
    
    @Nullable @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos){
        return type.getAABB("collision", "facing=" + state.getValue(FACING).getName()).get(0);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
    	if(player.getHeldItem(hand).getItem() instanceof ItemDye){
    		return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    	}
        if(!world.isRemote){
        	MultiblockTileEntity te = (MultiblockTileEntity)world.getTileEntity(pos);
            if(te == null){
                Print.chat(player, "No TileEntity found.");
                return true;
            }
            MultiBlockData data = te.getMultiBlockData();
            if(data == null){
                Print.chat(player, "MultiBlockData not found [TE].");
                return true;
            }
			V3I vpos = new V3I(pos.getX(), pos.getY(), pos.getZ());
			V3I vcor = te.isCore() ? vpos : new V3I(te.getCore().getX(), te.getCore().getY(), te.getCore().getZ());
            if(te.triggers == null) te.triggers = data.getType().getInteract(WrapperHolder.getSide(state.getValue(FACING)), vpos, vcor);
            if(processTriggers(te, te.triggers, data, te.isCore() ? pos : te.getCore(), player, hand, state, pos, side, hitX, hitY, hitZ)){
            	return true;
            }
            return false;
        }
        return true;
    }
    
    protected static boolean processTriggers(MultiblockTileEntity te, List<MB_Interact> triggers, MultiBlockData data, BlockPos core, EntityPlayer player, EnumHand hand, IBlockState state, BlockPos pos, EnumFacing side, float x, float y, float z){
    	for(MB_Interact trigger : triggers){
        	boolean pass = trigger.isWholeBlock();
        	IBlockState corestate = player.world.getBlockState(core);
        	V3D hit = new V3D(x, y, z);
        	if(!pass && trigger.getBB() != null) pass = trigger.getBB().contains(hit);//TODO aabb rotation
        	if(!pass && trigger.getSide() != null) pass = trigger.getSide(corestate.getValue(FACING).getIndex()) == CubeSide.fromIndex(side.getIndex(), null);
        	if(pass){
        		/*if(trigger.forInventory()){
        			InvHandler handler = data.getInventory(trigger.getTarget());
        			if(handler == null){
        				Print.chat(player, "error_target_inventory_not_found");
        				return true;
        			}
        			openInventory(player, trigger.getTarget(), handler, core);
        			return true;
        		}*/
        		/*if(trigger.forScript() && data.getScript() != null){
        			data.getScript().onTrigger(data, trigger, player, hand, core, pos, side, hit);
        			return true;
        		}*/
        	}
        	//Print.debug(pass + " " + trigger.getTarget() + " " + trigger.forInventory());
    	}
    	if(te == null) return false;
    	for(CapabilityContainer capcon : te.getCapabilities(side)){
    		if(capcon.handler.type.isVariable()){
    			openInventory(player, capcon.id, capcon.handler, core);
    			return true;
    		}
    	}
    	return false;
    }

    public static void openInventory(EntityPlayer player, String target, InvHandler handler, BlockPos corepos){
    	TileEntity core = (TileEntity)player.world.getTileEntity(corepos);
    	ApiUtil.sendTileEntityUpdatePacket(core, core.writeToNBT(new NBTTagCompound()), 256);
    	//
    	NBTTagCompound packet = new NBTTagCompound();
		packet.setString("inventory", target);
        int[] xyz = new int[]{ corepos.getX(), corepos.getY(), corepos.getZ() };
        GenericContainer.openGui(handler.type.getMBUI().id, xyz, LISTENERID, packet, player);
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		super.onBlockPlacedBy(world, pos, state, placer, stack);
        world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
        ((MultiblockTileEntity)world.getTileEntity(pos)).setCore(pos, stack).setup();
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing facing = EnumFacing.byIndex(meta);
        facing = facing.getAxis() == EnumFacing.Axis.Y ? EnumFacing.NORTH : facing;
        return this.getDefaultState().withProperty(FACING, facing);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(FACING).getIndex();
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
		MultiblockTileEntity broken = hastile ? (MultiblockTileEntity)world.getTileEntity(pos) : null;
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
		ArrayList<V3I> positions = data.getType().getPositions(new V3I(corepos.getX(), corepos.getY(), corepos.getZ()), WrapperHolder.getSide(core.getValue(FACING).getOpposite()));
		positions.forEach(vec -> {
			BlockPos blkpos = new BlockPos(vec.x, vec.y, vec.z);
			IBlockState posstate = world.getBlockState(blkpos);
			if(posstate.getBlock() instanceof M_4ROT_TE || posstate.getBlock() instanceof M_4ROT){
				MultiblockTileEntity tile = (MultiblockTileEntity)world.getTileEntity(blkpos);
				if(tile != null && tile.iscore){
					for(InvHandler handler : tile.getMultiBlockData().getInventories().values()){
						handler.dropAllAt(WrapperHolder.getWorld(world), tile.getV3I());
					}
					EntityItem item = new EntityItem(world);
					item.setPosition(tile.getPos().getX() + 0.5, tile.getPos().getY() + 0.5, tile.getPos().getZ() + 0.5);
					item.setItem(tile.getMultiBlockData().getNewStack().local());
					world.spawnEntity(item);
				}
	            world.setBlockState(blkpos, Blocks.AIR.getDefaultState());
			}
		});
		//Print.debug("Removed MultiBlock at " + corepos + " / " + pos);
	}

	@Override
	public net.minecraft.tileentity.TileEntity createNewTileEntity(World world, int meta){
		return type.isTickable() ? new MultiblockTickableTE(this) : new MultiblockTileEntity(this);
	}

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player){
    	MultiblockTileEntity our = (MultiblockTileEntity)world.getTileEntity(pos);
    	MultiblockTileEntity tile = our.iscore ? our : our.reference;
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().getNewStack().local();
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
    	MultiblockTileEntity our = (MultiblockTileEntity)world.getTileEntity(pos);
    	MultiblockTileEntity tile = our.iscore ? our : our.reference;
        return tile == null ? ItemStack.EMPTY : tile.getBlockData().getNewStack().local();
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos){
        return false;
    }

	@Override
	protected void addCollisionsToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entitybox, List<AxisAlignedBB> boxes){
		for(AABB aabb : type.getAABB("collision", "facing=" + state.getValue(FACING).getName()).get()){
			if(entitybox == null) boxes.add(aabb.local());
			else addCollisionBoxToList(pos, entitybox, boxes, aabb.local());
		}
	}

}

