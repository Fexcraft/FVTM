package net.fexcraft.mod.fvtm.blocks;

import net.fexcraft.mod.fvtm.util.Tabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

//@fBlock(modid = "fvtm", name = "block", tileentity = UniversalTileEntity.class)
public class UniversalBlock extends BlockContainer {

    public static UniversalBlock INSTANCE = new UniversalBlock();

	public UniversalBlock(){
        super(Material.ANVIL);
        this.setCreativeTab(Tabs.BLOCKS);
        this.setRegistryName("fvtm", "block");
        this.setUnlocalizedName(this.getRegistryName().toString());
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

}
