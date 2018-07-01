package net.fexcraft.mod.fmt.block;

import net.fexcraft.mod.fmt.FMT;
import net.fexcraft.mod.fmt.capabilities.EPDCCU;
import net.fexcraft.mod.fmt.capabilities.EditorPlayerDataContainerCapability;
import net.fexcraft.mod.lib.api.block.fBlock;
import net.fexcraft.mod.lib.network.PacketHandler;
import net.fexcraft.mod.lib.network.packet.PacketNBTTagCompound;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@fBlock(modid = FMT.MODID, name = "editor", tileentity = EditorTileEntity.class)
public class EditorBlock extends BlockContainer {

	public EditorBlock(){
		super(Material.BARRIER);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new EditorTileEntity();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		//Print.debug(world, world.isRemote, pos, state, player, hand, player.getHeldItem(hand), facing);
		if(world.isRemote || hand == EnumHand.OFF_HAND){
			return false;
		}
		else if(player.getHeldItem(hand).isEmpty()){
			EditorPlayerDataContainerCapability data = player.getCapability(EPDCCU.CAPABILITY, null);
			if(data != null && world.getTileEntity(pos) instanceof EditorTileEntity){
				data.setEditorTileEntity((EditorTileEntity)world.getTileEntity(pos));
				Print.bar(player, "Updating selected Editor...");
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("target_listener", "fmt:main");
				compound.setString("task", "editor_pos_update");
				compound.setLong("pos", pos.toLong());
				PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(compound), (EntityPlayerMP)player);
			}
			return true;
		}
		else return false;
    }
	
}