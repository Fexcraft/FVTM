package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.uni.PathJuncType;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.tag.TagCW;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public interface JunctionTrackingTileEntity {

	public static void updateJunction(EntityPlayer player, TileEntity tile_entity, ItemStack held){
		if(tile_entity instanceof JunctionTrackingTileEntity == false) return;
		JunctionTrackingTileEntity tile = (JunctionTrackingTileEntity)tile_entity;
    	if(held.hasTagCompound() && held.getTagCompound().hasKey("fvtm:junction")){
    		QV3D vector = new QV3D(TagCW.wrap(held.getTagCompound()), "fvtm:junction");
    		Junction junc = null;
        	RailSystem sys = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(tile_entity.getWorld()));
        	if(sys != null) junc = sys.getJunction(vector, false);
        	if(junc == null){
            	Print.bar(player, "&eJunction at cached location in Item not found.");
            	return;
        	}
    		if(!tile.isSignal()){
    			Block block = tile_entity.getWorld().getBlockState(tile_entity.getPos()).getBlock();
    			boolean wrong = false;
    			switch(junc.type){
					case DOUBLE:
						wrong = block instanceof DBSW_4ROT_TE == false;
						break;
					case FORK_2:
						wrong = block instanceof F2SW_4ROT_TE == false;
						break;
					case FORK_3:
						wrong = block instanceof F3SW_4ROT_TE == false;
						break;
					default: break;
    			}
    			if(wrong){
    	        	Print.chat(player, "&eInvalid switch type for this junction.");
    	        	Print.chat(player, "&bJ: &7" + junc.type + " &8 != &aB: &7" + PathJuncType.fromAddonBlock(block));
    				return;
    			}
    		}
        	tile.setJunction(vector);
        	held.getTagCompound().removeTag("fvtm:junction");
        	Print.bar(player, "&b" + (tile.isSignal() ? "Signal" : "Switch") + " junction set. &7[" + tile.getJuncPos() + "]");
    	}
    	else if(tile.isSignal()){
    		tile.toggleDirection();
        	Print.bar(player, "&bSignal entry direction set to &7" + tile.getDirection() + "&b.");
    	}
	}
	
	public default void linkJunction(World world, BlockPos pos, QV3D vec){
		if(world == null) return;
		RailSystem system = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world));
		if(system == null) return;
		Junction junc = system.getJunction(vec);
		if(junc != null) junc.addLinkedTileEntity(WrapperHolder.mutPos(pos));
	}

	public QV3D getJuncPos();

	public void setJunction(QV3D gridvecs);
	
	public Junction getJunction();

	/** For Signals. */
	public default EntryDirection getDirection(){
		return EntryDirection.FORWARD;
	}

	/** For Signals. */
	public default void toggleDirection(){}
	
	public default boolean isSignal(){
		return false;
	}

	/** For Signals. */
	public default void updateSignalState(){}

	/** For Switches. */
	public default void updateSwitchState(){}

}
