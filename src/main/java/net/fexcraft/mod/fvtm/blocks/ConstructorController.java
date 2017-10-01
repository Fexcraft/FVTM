package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.item.PaintItem;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
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
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

//@fBlock(modid = FVTM.MODID, name = "landvehicle_constructor_controller", tileentity = ConstructorControllerEntity.class)
public class ConstructorController extends BlockContainer {
	
	public static ConstructorController INSTANCE;
	
	public ConstructorController(){
		super(Material.ANVIL, MapColor.OBSIDIAN);
		if(INSTANCE != null){
			Print.log("LANDVEHICLE CONSTRUCTOR CONTROLLER WAS INITIALIZED TWICE, THIS IS NOT ALLOWED.");
			Static.halt();
		}
    	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Tabs.BLOCKS);
		INSTANCE = this;
		
		FVTM.getRegisterer().addBlock("landvehicle_constructor_controller", this, null, 1, null);
		GameRegistry.registerTileEntity(ConstructorControllerEntity.Server.class, this.getRegistryName().toString() + "_server");
		GameRegistry.registerTileEntity(ConstructorControllerEntity.Client.class, this.getRegistryName().toString() + "_client");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return world.isRemote ? new ConstructorControllerEntity.Client() : new ConstructorControllerEntity.Server();
	}
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    @Override
	public boolean isFullBlock(IBlockState state){
		return false;
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
		ConstructorControllerEntity.Server te = (ConstructorControllerEntity.Server)w.getTileEntity(pos);
		if(te == null){
			return false;
		}
		if(!p.getHeldItem(hand).isEmpty()){
			ItemStack stack = p.getHeldItem(hand);
			if(stack.getItem() instanceof VehicleItem){
				if(te.getData() != null){
					ItemStack istack = te.getData().getVehicle().getItemStack(te.getData());
					EntityItem item = new EntityItem(w);
					item.setItem(istack);
					item.setPosition(pos.getX() + 0.5f, pos.getY() + 1.5d, pos.getZ() + 0.5f);
					w.spawnEntity(item);
				}
				te.setData((VehicleItem)stack.getItem(), stack);
				Print.chat(p, "Vehicle: " + te.getData().getVehicle().getName());
				p.getHeldItem(hand).shrink(64);
				te.updateColour(null, null);
				return true;
			}
			else if(stack.getItem() instanceof PartItem){
				PartData data = ((PartItem)stack.getItem()).getPart(stack);
				if(data == null){
					return false;
				}
				if(!te.getScreenId().equals("part_add_new")){
					if(!te.getData().getParts().containsKey(data.getPart().getCategory())){
						if(data.getPart().canInstall(data.getPart().getCategory(), te.getData(), p)){
							te.getData().installPart(data.getPart().getCategory(), data);
							Print.chat(p, "Part installed. (" + data.getPart().getName() + ")");
							p.getHeldItem(hand).shrink(1);
							te.updateVehicle(null);
							te.updateScreen(null, false);
						}
					}
					else{
						Print.chat(p, "Part of that category already installed, try the part menu for installing the part in another category.");
					}
				}
				else{
					if(data.getPart().isAvailable()){
						te.setPartData(data);
						p.getHeldItem(hand).shrink(1);
						Print.chat(p, "Part put into Contructor. You can access it via the part menu.");
					}
					else{
						Print.chat(p, "This part isn't available for editement in the Constructor.");
					}
				}
				return true;
			}
			else if(stack.getItem() instanceof PaintItem){
				if(hand == EnumHand.OFF_HAND){
					te.getData().getSecondaryColor().copyFrom(((PaintItem)stack.getItem()).getRGBColor());
				}
				else{
					te.getData().getPrimaryColor().copyFrom(((PaintItem)stack.getItem()).getRGBColor());
				}
				te.updateVehicle(null);
				Print.chat(p, "Colour updated.");
			}
		}
		else{
			if(te.getCenter() == null || w.getTileEntity(te.getCenter()) == null){
				//Print.chat(p, "&7No Center Block connected!");
				//Print.chat(p, "&7You can connect one via the Constructor's &8Settings&7.");
				if(hand != EnumHand.OFF_HAND){
					return findAndPressButton(te, w, pos, state, p, side, hitX, hitY, hitZ);//TODO remove, only for debug right now
				}
				else return true;
			}
			else{
				if(te.getData() == null){
					Print.chat(p, "No Vehicle.");
				}
				else{
					if(hand != EnumHand.OFF_HAND){
						return findAndPressButton(te, w, pos, state, p, side, hitX, hitY, hitZ);
					}
					else return true;
				}
			}
			return true;
		}
		return false;
    }
	
	private boolean findAndPressButton(ConstructorControllerEntity.Server te, World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumFacing side, float hitX, float hitY, float hitZ){
		boolean found = false;
		if(side == EnumFacing.UP){
			//Print.debugChat(hitX + " ||| " + hitZ);
			int x = calculateCoord(hitX);
			int z = calculateCoord(hitZ);
			//Print.debugChat(x + " ||| " + z);
			//Print.debugChat(state.getValue(FACING).toString());
			Button button = Button.findButton(state.getValue(FACING), x, z);
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
	
	public static enum Button {
		
		NULL(-1, new int[]{-1}, new int[]{-1}),
		SPAWN_ITEM(0,   new int[]{14, 15}, new int[]{3, 2}),
		SPAWN_ENTITY(1, new int[]{12, 13}, new int[]{3, 2}),
		REMOVE(2,       new int[]{ 6}, new int[]{ 5}),
		SELECT(3,       new int[]{ 6}, new int[]{ 6}),
		ARROW_DOWN(4,   new int[]{ 6}, new int[]{ 7}),
		ARROW_UP(5,     new int[]{ 6}, new int[]{ 8}),
		ARROW_RIGHT(6,  new int[]{ 6}, new int[]{ 9}),
		ARROW_LEFT(7,   new int[]{ 6}, new int[]{10}),
		RETURN(8,       new int[]{ 6}, new int[]{11}),
		HOME(9,         new int[]{ 6}, new int[]{12}),
		LIFT_DOWN(10,   new int[]{ 9, 10}, new int[]{3, 2}),
		LIFT_UP(11,     new int[]{ 6,  7}, new int[]{3, 2}),
		INPUT(12,       new int[]{ 0}, new int[]{ 0});
		
		public int ID;
		public int[] xc, zc;
		
		Button(int id, int[] x, int[] z){
			this.ID = id; this.xc = x; this.zc = z;
		}
		
		public boolean collides(EnumFacing facing, int x, int z){
			int xx = rotate(x, z, facing, true);
			int zz = rotate(z, x, facing, false);
			boolean xcb = false, zcb = false;
			for(int i : xc){
				if(i == xx){ xcb = true; break; }
			}
			for(int i : zc){
				if(i == zz){ zcb = true; break; }
			}
			return xcb && zcb;
		}
		
		private static final int rotate(int i, int o, EnumFacing facing, boolean x){
			switch(facing){
				case NORTH: return x ? (-o) + 17 : o;
				case SOUTH: return x ? o : (-o) + 17;
				case WEST:  return (-i) + 17;
				default: return i;
			}
		}

		public static final Button fromId(int id){
			for(Button button : values()){
				if(button.ID == id){
					return button;
				}
			}
			return NULL;
		}
		
		public static final Button findButton(EnumFacing value, int x, int z){
			for(Button button : values()){
				if(button.collides(value, x, z)){ return button; }
			}
			return null;
		}

		public boolean isVerticalArrow(){
			return this == ARROW_DOWN || this == ARROW_UP;
		}
		
		public boolean isHorizontalArrow(){
			return this == ARROW_RIGHT || this == ARROW_LEFT;
		}
		
		public boolean isLiftButton(){
			return this == LIFT_DOWN || this == LIFT_UP;
		}

		public boolean isSelect(){
			return this == SELECT;
		}
		
		public boolean isReset(){
			return this == REMOVE;
		}
		
		public boolean isReturn(){
			return this == RETURN;
		}
		
		public boolean isHome(){
			return this == HOME;
		}

		public boolean isLeftArrow(){
			return this == ARROW_LEFT;
		}
		
		public boolean isRightArrow(){
			return this == ARROW_RIGHT;
		}
		
		public boolean isUpArrow(){
			return this == ARROW_UP;
		}
		
		public boolean isDownArrow(){
			return this == ARROW_DOWN;
		}

		public boolean isInput(){
			return this == INPUT;
		}
		
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
	
}