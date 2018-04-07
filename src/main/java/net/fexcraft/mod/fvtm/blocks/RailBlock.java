package net.fexcraft.mod.fvtm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

//@fBlock(modid = FVTM.MODID, name = "rail", tileentity = RailTileEntity.class)
public class RailBlock extends BlockContainer {

	public RailBlock(){
		super(Material.ANVIL, MapColor.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new RailTileEntity();
	}
	
}