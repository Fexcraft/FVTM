package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.ConstructorButton;
import net.fexcraft.mod.fvtm.api.Material.MaterialItem;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.api.item.KeyItem;
import net.fexcraft.mod.lib.api.item.PaintItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@fBlock(modid = FVTM.MODID, name = "constructor_controller", tileentity = ConstructorControllerEntity.class)
public class ConstructorController extends BlockContainer {
	
	public static ConstructorController INSTANCE;
	
	public ConstructorController() throws Exception {
		super(Material.ANVIL, MapColor.OBSIDIAN);
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Tabs.BLOCKS);
		INSTANCE = this;
		//
		//FVTM.getRegisterer().addBlock("constructor_controller", this, null, 1, null);
		//GameRegistry.registerTileEntity(ConstructorControllerEntity.class, this.getRegistryName().toString());
		//
		/*ConstructorScreen.addScreen("main", new MainScreen());
		ConstructorScreen.addScreen("info", new InfoScreen());
		ConstructorScreen.addScreen("colour_menu", new ColorMenuScreen());
		ConstructorScreen.addScreen("colour_unavailable", new ColorUnavailableScreen());
		ConstructorScreen.addScreen("crash", new CrashScreen());
		ConstructorScreen.addScreens(new String[]{"colour_edit_primary", "colour_edit_secondary"}, new ColorEditScreen());
		ConstructorScreen.addScreen("part_menu", new PartMenuScreen());
		ConstructorScreen.addScreen("part_add_new", new PartAddNewScreen());
		ConstructorScreen.addScreen("part_view_cache", new PartViewCacheScreen());
		ConstructorScreen.addScreen("part_cache_install", new PartCacheInstallScreen());
		ConstructorScreen.addScreen("part_view_required", new PartViewRequiredScreen());
		ConstructorScreen.addScreen("part_view_installed", new PartViewInstalledScreen());
		ConstructorScreen.addScreen("part_view_selected", new PartViewSelectedScreen());
		ConstructorScreen.addScreen("constructor_menu", new ConstructorMenuScreen());
		ConstructorScreen.addScreen("constructor_connect_center", new ConstructorConnectCenterScreen());
		ConstructorScreen.addScreen("part_selected_edit_texture", new PartSelectedEditTextureScreen());
		ConstructorScreen.addScreen("vehicle_menu", new VehicleMenuScreen());
		ConstructorScreen.addScreen("vehicle_edit_texture", new VehicleEditTextureScreen());
		ConstructorScreen.addScreen("spawn_as", new SpawnAsScreen());*/
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new ConstructorControllerEntity();
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

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
        return FULL_BLOCK_AABB;
    }
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

	@Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
	@Override
    public IBlockState getStateFromMeta(int meta){
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if (enumfacing.getAxis() == EnumFacing.Axis.Y){
            enumfacing = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	@Override
    public int getMetaFromState(IBlockState state){
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
	//<-- VANILLA END -->//
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote/* || hand == EnumHand.OFF_HAND*/){
			/*ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
			te.hitX = hitX;
			te.hitY = hitY;
			te.hitZ = hitZ;
			//Print.debugChat("HITX: " + hitX + " | HITY: " + hitY + " | HITZ: " + hitZ);
			//te.setState("0101010101");
			//te.lift += Static.rad10;*/
			return false;
		}
		ConstructorControllerEntity te = (ConstructorControllerEntity)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(!p.getHeldItem(hand).isEmpty()){
			ItemStack stack = p.getHeldItem(hand);
			if(stack.getItem() instanceof VehicleItem){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.chat(p, "Current VehicleData is locked.");
					return true;
				}
				if(te.getVehicleData() != null){
					ItemStack istack = te.getVehicleData().getVehicle().getItemStack(te.getVehicleData());
					EntityItem item = new EntityItem(w);
					item.setItem(istack);
					item.setPosition(pos.getX() + 0.5f, pos.getY() + 1.5d, pos.getZ() + 0.5f);
					w.spawnEntity(item);
				}
				te.setData((VehicleItem)stack.getItem(), stack);
				Print.chat(p, "Vehicle: " + te.getVehicleData().getVehicle().getName());
				p.getHeldItem(hand).shrink(64);
				te.sendUpdate(null);
				return true;
			}
			else if(stack.getItem() instanceof PartItem){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.chat(p, "VehicleData is locked.");
					return true;
				}
				PartData data = ((PartItem)stack.getItem()).getPart(stack);
				if(data == null){
					return false;
				}
				if(data.getPart().getCategories().size() > 1){
					if(data.getPart().canInstall(data.getPart().getCategory(), te.getVehicleData(), p)){
						te.setPartData(data);
						Print.chat(p, "Part put into Constructor. (" + data.getPart().getName() + ")");
						p.getHeldItem(hand).shrink(1);
						te.sendUpdate(null);
					}
				}
				else{
					if(!te.getVehicleData().getParts().containsKey(data.getPart().getCategory())){
						if(data.getPart().canInstall(data.getPart().getCategory(), te.getVehicleData(), p)){
							te.getVehicleData().installPart(data.getPart().getCategory(), data);
							Print.chat(p, "Part installed. (" + data.getPart().getName() + ")");
							p.getHeldItem(hand).shrink(1);
							te.sendUpdate(null);
						}
					}
					else{
						Print.chat(p, "Part of that category is already installed.");
					}
				}
				return true;
			}
			else if(stack.getItem() instanceof PaintItem){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.chat(p, "VehicleData is locked.");
					return true;
				}
				if(te.getVehicleData() == null){
					Print.chat(p, "No VehicleData.");
					return true;
				}
				if(hand == EnumHand.OFF_HAND){
					te.getVehicleData().getSecondaryColor().packed = (((PaintItem)stack.getItem()).getRGBColor()).packed;
				}
				else{
					te.getVehicleData().getPrimaryColor().packed = (((PaintItem)stack.getItem()).getRGBColor()).packed;
				}
				te.sendUpdate(null);
				Print.chat(p, "Colour updated.");
				return true;
			}
			else if(stack.getItem() instanceof ItemDye){
				if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
					Print.chat(p, "VehicleData is locked.");
					return true;
				}
				if(te.getVehicleData() == null){
					Print.chat(p, "No VehicleData.");
					return true;
				}
				EnumDyeColor dyecolor = EnumDyeColor.byDyeDamage(stack.getMetadata());
				if(hand == EnumHand.OFF_HAND){
					te.getVehicleData().getSecondaryColor().packed = RGB.fromDyeColor(dyecolor).packed;
				}
				else{
					te.getVehicleData().getPrimaryColor().packed = RGB.fromDyeColor(dyecolor).packed;
				}
				stack.shrink(1);
				te.sendUpdate("rgb");
			}
			else if(stack.getItem() instanceof KeyItem && (stack.getItem() instanceof MaterialItem ? ((MaterialItem)stack.getItem()).getMaterial(stack).isVehicleKey() : true)){
				if(te.getVehicleData() == null){
					Print.bar(p, "No VehicleData.");
				}
				else{
					KeyItem item = (KeyItem)stack.getItem();
					if(!te.getVehicleData().isLocked()){
						if(item.getCode(stack).equals(te.getVehicleData().getLockCode())){
							te.getVehicleData().setLocked(true);
							Print.chat(p, "VehicleData locked.");
						}
						else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
							te.getVehicleData().setLocked(true);
							Print.chat(p, "&8[&aAO&8] &7VehicleData locked.");
						}
						else{
							Print.chat(p, "Invalid code!");
							Print.chat(p, item.getCode(stack) + " != " + te.getVehicleData().getLockCode());
						}
						Print.debug(te.getVehicleData().isLocked());
					}
					else{
						if(item.getCode(stack).equals(te.getVehicleData().getLockCode())){
							te.getVehicleData().setLocked(false);
							Print.chat(p, "VehicleData unlocked.");
						}
						else if(item.getType(stack) == KeyItem.KeyType.ADMIN){
							te.getVehicleData().setLocked(false);
							Print.chat(p, "&8[&aAO&8] &7VehicleData unlocked.");
						}
						else{
							Print.chat(p, "Invalid code!");
							Print.chat(p, item.getCode(stack) + " != " + te.getVehicleData().getLockCode());
						}
					}
					te.sendUpdate(null);
				}
				return true;
			}
		}
		else{
			if(te.getVehicleData() != null && te.getVehicleData().isLocked()){
				Print.bar(p, "&cLOCKED");
			}
			if(hand != EnumHand.OFF_HAND){
				if(!findAndPressButton(te, w, pos, state, p, side, hitX, hitY, hitZ)){
					p.openGui(FVTM.getInstance(), GuiHandler.CONSTRUCTOR, w, te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
				}
			}
			return true;
		}
		return false;
    }
	
	private boolean findAndPressButton(ConstructorControllerEntity te, World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
		boolean found = false;
		if(side == EnumFacing.UP){
			//Print.debugChat(hitX + " ||| " + hitZ);
			int x = calculateCoord(hitX);
			int z = calculateCoord(hitZ);
			//Print.debugChat(x + " ||| " + z);
			//Print.debugChat(state.getValue(FACING).toString());
			ConstructorButton button = ConstructorButton.findButton(state.getValue(FACING), x, z);
			if(button != null){
				//Print.debugChat(button.name());
				if(button.ID < 10){
					te.onButtonPress(button, p, null);
				}
				else{
					te.addLift(button.ID == 10 ? 1 : -1);
				}
				found = true;
			}
		}
		return found;
	}

	private final int calculateCoord(float coords){
		int i = 0;
		while((coords - 0.0625) > 0){
			coords -= 0.0625;
			i++;
		}
		if(coords > 0){
			i++;
		}
		return i;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state){
		ConstructorControllerEntity conte = (ConstructorControllerEntity)world.getTileEntity(pos);
		if(conte.vehicledata != null){
			ItemStack stack = conte.vehicledata.getVehicle().getItemStack(conte.vehicledata);
			EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
			world.spawnEntity(entity);
		}
		if(conte.partdata != null){
			ItemStack stack = conte.partdata.getPart().getItemStack(conte.partdata);
			EntityItem entity = new EntityItem(world, conte.getPos().getX() + 0.5, conte.getPos().getY() + 1.5f, conte.getPos().getZ() + 0.5, stack);
			world.spawnEntity(entity);
		}
		super.breakBlock(world, pos, state);
	}
	
}