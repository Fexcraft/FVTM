package net.fexcraft.mod.fvtm.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.util.Tabs;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.registry.ItemBlock16;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@fBlock(modid = FVTM.MODID, name = "pipe", tileentity = PipeTileEntity.class, item = PipeBlock.PipeItemBlock.class)
public class PipeBlock extends BlockContainer {
	
	public static final PropertyEnum<PipeBlock.PipeType> TYPE = PropertyEnum.<PipeBlock.PipeType>create("type", PipeBlock.PipeType.class);

	public PipeBlock(){
		super(Material.IRON, MapColor.WHITE_STAINED_HARDENED_CLAY);
		this.setCreativeTab(Tabs.BLOCKS);
		this.setSoundType(SoundType.GLASS);
		//
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(10.0F);
        this.setResistance(20.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new PipeTileEntity(world, meta);
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
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos change){
		((PipeTileEntity)world.getTileEntity(pos)).removeConnection(pos, change);
    }
	
	@Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		if(world.isRemote){ return; }
		for(EnumFacing facing : EnumFacing.VALUES){
			((PipeTileEntity)world.getTileEntity(pos)).updateConnections(world, pos, facing, false);
		}
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return Item.getItemFromBlock(this);
    }
	
	@Override
    public int damageDropped(IBlockState state){
        return ((PipeType)state.getValue(TYPE)).getMetadata();
    }
	
	@Override
    public void getSubBlocks(CreativeTabs item, NonNullList<ItemStack> items){
        for(PipeType type : PipeType.values()){
            items.add(new ItemStack(this, 1, type.getMetadata()));
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState().withProperty(TYPE, PipeType.byMetadata(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state){
        return ((PipeType)state.getValue(TYPE)).getMetadata();
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, TYPE);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!world.isRemote && hand != EnumHand.OFF_HAND){
			PipeTileEntity te = (PipeTileEntity)world.getTileEntity(pos);
			if(te == null){
				Print.chat(player, "No TileEntity.");
			}
			else{
				Print.chat(player, te.getTank().getFluidAmount() + " mB (" + (te.getTank().getFluid() == null ? "empty" : te.getTank().getFluid().getLocalizedName()) + ")");
			}
		}
		return false;
    }
	
	public static enum PipeType implements IStringSerializable {
		
		WOOD_OAK("wood_oak",           0, 1, 10, "minecraft:textures/blocks/planks_oak"),
		WOOD_SPRUCE("wood_spruce",     1, 1, 10, "minecraft:textures/blocks/planks_spruce"),
		WOOD_BIRCH("wood_birch",       2, 1, 10, "minecraft:textures/blocks/planks_birch"),
		WOOD_JUNGLE("wood_jungle",     3, 1, 10, "minecraft:textures/blocks/planks_jungle"),
		WOOD_ACACIA("wood_acacia",     4, 1, 10, "minecraft:textures/blocks/planks_acacia"),
		WOOD_DARK_OAK("wood_dark_oak", 5, 1, 10, "minecraft:textures/blocks/planks_big_oak"),
		IRON("iron",                   6, 2,  6, "minecraft:textures/blocks/iron_block"),
		CLAY("clay",                   7, 2,  4, "minecraft:textures/blocks/brick"),
		SANDSTONE("sandstone",         8, 2,  5, "minecraft:textures/blocks/sandstone_smooth"),
		RED_SANDSTONE("red_sandstone", 9, 2,  5, "minecraft:textures/blocks/red_sandstone_smooth"),
		//STEEL("steel",            10, 3, "fvtm:textures/blocks/steel_block"),
		GRANITE("granite",            10, 3,  3, "minecraft:textures/blocks/stone_granite_smooth"),
		DIORITE("diorite",            11, 3,  3, "minecraft:textures/blocks/stone_diorite_smooth"),
		ANDESITE("andesite",          12, 3,  3, "minecraft:textures/blocks/stone_andesite_smooth"),
		QUARTZ("quartz",              13, 4,  4, "minecraft:textures/blocks/quartz_block_side"),
		CONCRETE("concrete",          14, 4,  5, "minecraft:textures/blocks/concrete_silver"),
		DIAMOND("diamond",            15, 5,  4, "minecraft:textures/blocks/diamond_block");
		
		private String name;
		private int meta, tier, multiplier;
		private ResourceLocation texture;
		
		PipeType(String name, int meta, int tier, int multiplier, String texture){
			this.name = name;
			this.meta = meta;
			this.texture = new ResourceLocation(texture + ".png");
			this.tier = tier;
			this.multiplier = multiplier;
		}

		public static PipeType byMetadata(int meta){
			for(PipeType type : values()){
				if(type.meta == meta){
					return type;
				}
			}
			return null;
		}

		public int getMetadata(){
			return meta;
		}

		@Override
		public String getName(){
			return name;
		}
		
		public ResourceLocation getTexture(){
			return texture;
		}
		
		private int getTier(){
			return tier;
		}
		
		public int getTPS(){
			switch(tier){
				case 1: return 10;
				case 2: return 50;
				case 3: return 200;
				case 4: return 500;
				case 5: return 1000;
				default: return -1;
			}
		}

		public boolean canConnect(PipeType pipe){
			if(this == CONCRETE || pipe == CONCRETE){
				return true;
			}
			return this == pipe;
		}

		public int getTankSize(){
			return getTPS() * multiplier;
		}
		
	}
	
	public static class PipeItemBlock extends ItemBlock16 {

		public PipeItemBlock(Block block){
			super(block);
		}
		
		public int getItemBurnTime(ItemStack stack){
	        return getMetadata(stack) < 6 ? Item.getItemFromBlock(Blocks.PLANKS).getItemBurnTime(new ItemStack(Item.getItemFromBlock(Blocks.PLANKS))) : 0;
	    }
		
		@SideOnly(Side.CLIENT) @Override
	    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn){
			PipeType type = PipeType.byMetadata(stack.getMetadata());
			tooltip.add(Formatter.format("&9Type: &7" + type.getName()));
			tooltip.add(Formatter.format("&9Tier: &7" + type.getTier()));
			tooltip.add(Formatter.format("&9mBPT: &7" + type.getTPS() + " mB/tick"));
			tooltip.add(Formatter.format("&9Capacity: &7" + type.getTankSize() + " mB"));
	    }
		
	}

}
