package net.fexcraft.mod.fme.blocks;

import net.fexcraft.mod.fme.FME;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FME.MODID, name = "editor", tileentity = EditorTileEntity.class)
public class EditorBlock extends Block implements ITileEntityProvider {
	
	public EditorBlock(){
		super(Material.IRON, MapColor.GRAY);
    	//this.setDefaultState(this.blockState.getBaseState().withProperty(ON, false));
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta){
		return new EditorTileEntity(world.isRemote);
	}
	
	@Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.isRemote){
			//TODO open GUI (prevention of game pausing/blocking when using tools)
			//TODO open box list
			//TODO open tools
			//TODO open box editor
			return false;
		}
		return true;
	}
	
}