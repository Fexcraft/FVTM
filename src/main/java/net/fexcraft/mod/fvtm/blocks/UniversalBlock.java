package net.fexcraft.mod.fvtm.blocks;

import java.util.Random;
import java.util.TreeMap;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockIOT;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.api.root.SettingHolder.ScriptSetting;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

//@fBlock(modid = "fvtm", name = "block", tileentity = UniversalTileEntity.class)
public class UniversalBlock extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static UniversalBlock INSTANCE = new UniversalBlock();

	public UniversalBlock(){
        super(Material.ANVIL);
        this.setCreativeTab(Tabs.BLOCKS);
        this.setRegistryName("fvtm", "block");
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        //
        GameRegistry.registerTileEntity(UniversalTileEntity.class, this.getRegistryName().toString());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new UniversalTileEntity();
    }

    @Override
    public boolean isFullBlock(IBlockState state){
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState blockState, World worldIn, BlockPos pos){
        return FULL_BLOCK_AABB.offset(pos);
    }
    
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if(enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
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
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(this);
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, FACING);
    }
    
    //

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        world.setBlockState(pos, state, 2);
        ((UniversalTileEntity)world.getTileEntity(pos)).setUp(stack);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	if(!world.isRemote){
    		UniversalTileEntity tile = (UniversalTileEntity)world.getTileEntity(pos);
            tile.notifyBreak(world, pos, state, true);
        }
        super.breakBlock(world, pos, state);
    }

	public static TreeMap<BlockPos, BlockPos> getPositions(BlockData data, BlockPos core, EnumFacing facing){
        TreeMap<BlockPos, BlockPos> map = new TreeMap<>();
        for(BlockPos pos : data.getBlock().getSubBlocks().keySet()){
        	if(facing != EnumFacing.EAST){
        		switch(facing){
        			case NORTH:{
        				map.put(pos, new BlockPos( pos.getZ(), pos.getY(), -pos.getX()).add(core));
        				break;
        			}
        			case SOUTH:{
        				map.put(pos, new BlockPos(-pos.getZ(), pos.getY(),  pos.getX()).add(core));
        				break;
        			}
        			case WEST:{
        				map.put(pos, new BlockPos(-pos.getX(), pos.getY(), -pos.getZ()).add(core));
        				break;
        			}
        			default: break;
        		}
        	}
        	else{
        		map.put(pos, pos.add(core));
        	}
        }
        return map;
	}

    @SuppressWarnings("unchecked")
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote && hand == EnumHand.MAIN_HAND){
        	UniversalTileEntity tile = (UniversalTileEntity)world.getTileEntity(pos);
            if(tile == null){
                Print.chat(player, "No TileEntity at position found.");
                return true;
            }
            if(!tile.isCore() && tile.getCorePos() == null){
                Print.chat(player, "Linked Core block is null! Removing...");
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                return true;
            }
            ItemStack stack = player.getHeldItem(hand);
            if(stack.getItem() instanceof KeyItem && (stack.getItem() instanceof MaterialItem ? ((MaterialItem)stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
                if(tile.isLocked()){
                    tile.unlock(world, player, stack, (KeyItem) stack.getItem());
                }
                else{
                    tile.lock(world, player, stack, (KeyItem) stack.getItem());
                }
            }
            if(tile.isLocked()){
                Print.chat(player, "Block is Locked.");
                return true;
            }
            if(stack.isEmpty()){
                if(tile.getCorePos() == null){
                    Print.chat(player, "Block Core Position is NULL.");
                    return true;
                }
                BlockData data = tile.getBlockData();
                if(data == null){
                	Print.chat(player, "BlockData not found.");
                	Print.debug(tile.getRelPos(), tile.getCorePos());
                	return true;
                }
                BlockIOT biot = data.getBlock().getSubBlocks().get(tile.getRelPos());
                String str = biot.getGuiType(tile.getRelFacing(side));
                if(str == null){ return false; }
                String[] arr = str.split(":");
                switch(arr[0]){
                	case "tank":{
                		if(data.getFluidTanks().get(arr[1]) == null){
                			Print.chat(player, "Tank with ID " + arr[1] + " not found!");
                		}
                		else{
                			if(Static.side().isClient()){
                				net.fexcraft.mod.fvtm.gui.UniversalBlockFluidGui.lastside = side;
                			}
                			player.openGui(FVTM.getInstance(), GuiHandler.BLOCK_FLUID_INVENTORY, world, pos.getX(), pos.getY(), pos.getZ());
                		}
                		break;
                	}
                	case "inventory":{
                		if(data.getItemStacks().get(arr[1]) == null){
                			Print.chat(player, "Inventory with ID " + arr[1] + " not found!");
                		}
                		else{
                			if(Static.side().isClient()){
                				net.fexcraft.mod.fvtm.gui.UniversalBlockInventoryGui.lastside = side;
                			}
                			player.openGui(FVTM.getInstance(), GuiHandler.BLOCK_INVENTORY, world, pos.getX(), pos.getY(), pos.getZ());
                		}
                		break;
                	}
                	case "settings":{
                		player.openGui(FVTM.getInstance(), GuiHandler.BLOCK_SCRIPTSGUI, world, pos.getX(), pos.getY(), pos.getZ());
                		break;
                	}
                	case "script":{
                		if(data.getScript() == null){
                			Print.chat(player, "Block has no script.");
                		}
                		else{
                			data.getScript().onInteract(tile, data, player, hand);
                		}
                		break;
                	}
                	case "button":{
                		if(data.getScript() == null){
                			Print.chat(player, "Block has no buttons script.");
                		}
                		else{
                			ScriptSetting<?, TileEntity>[] test = (ScriptSetting<?, TileEntity>[])data.getScript().getSettings(0);
                			for(ScriptSetting<?, TileEntity> sett : test){
                				if(sett.getId().equals(arr[1])){
                					switch(sett.getType()){
										case BOOLEAN:
											sett.onChange(player, tile, sett.getValue().equals("true") ? 0 : 1, new Object[0]);
											break;
										case BUTTON:
											sett.onChange(player, tile, 0, new Object[0]);
											break;
										case INTEGER: case STRING: default:
											Print.chat(player, "Selected Script setting is not a Button/Bool!");
											break;
                					}
                					return true;
                				}
                			}
                			Print.chat(player, "Button/Function with ID '" + arr[1] + "' not found!");
                		}
                		break;
                	}
                	default:{
                		Print.debug(tile.getRelFacing(side), str);
                		break;
                	}
                }
        		Print.debug(tile.getRelFacing(side), str);
                return true;
            }
            else if(Static.dev()){
                Print.debug(tile.getBlockData() == null ? "No Container." : tile.getBlockData().writeToNBT(new NBTTagCompound()).toString());
            }
        }
        return false;
    }

}
