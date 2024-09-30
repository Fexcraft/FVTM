package net.fexcraft.mod.fvtm.sys.rail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.RailGauge;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.sys.uni.PathKey;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.uni.world.EntityW;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class TrackPlacer {
	
	private Track track;
	private ICommandSender sender;
	private EntityPlayer player;
	private World world;
	private BlockPos pos;
	private boolean register;
	private boolean useitems;
	//private boolean blocks;
	
	public static TrackPlacer set(EntityW pass, BlockPos pos, Track track){
		TrackPlacer placer = new TrackPlacer();
		placer.sender = pass.local();
		placer.player = pass.local();
		placer.world = pass.getWorld().local();
		placer.pos = pos;
		placer.track = track;
		return placer;
	}
	
	public TrackPlacer place(){
		register = true;
		return this;
	}
	
	public TrackPlacer remove(){
		register = false;
		return this;
	}
	
	public TrackPlacer consume(){
		useitems = true;
		return this;
	}
	
	/*public TrackPlacer blocks(){
		blocks = true;
		return this;
	}
	
	public TrackPlacer blocks(boolean bool){
		blocks = bool;
		return this;
	}*/
	
	public boolean result(){
		RailGauge type = track.getGauge();
		float width = type.getBlockWidth();
		boolean creative = player != null && player.capabilities.isCreativeMode;
		boolean regblocks = false;//this.blocks;// && !DISABLE_RAIL_BLOCKS;
		if(register ? creative ? regblocks : useitems : (/*!track.blockless &&*/ regblocks)){
			double angle, half = (width * 0.5f) - 0.25f;
			ArrayList<QV3D> path = new ArrayList<>();
			V3D last, vec = track.getVectorPosition0(0.001f, false);
			angle = (float)Math.atan2(track.vecpath[0].z - vec.z, track.vecpath[0].x - vec.x);
			angle += Static.rad90;
			/*for(float fl = -half; fl <= half; fl += 0.25f){
				path.add(new Vec316f(track.vecpath[0].add(grv(angle, new Vec3f(fl, type.getBlockHeight(), 0)))));
			}*/
			double passed = 0.125f;
			while(passed < track.length){
				last = vec; vec = track.getVectorPosition0(passed, false);
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
				angle += Static.rad90;
				for(double fl = -half; fl <= half; fl += 0.25f){
					path.add(new QV3D(vec.add(grv(angle, new Vec3f(fl, type.getBlockHeight(), 0))), 0));
				}
				passed += 0.125f;
			}
			int height;
			BlockPos blk;
			IBlockState state;
			if(regblocks){
				for(QV3D v : path){
					height = v.y;
					blk = new BlockPos(v.pos.x, v.pos.y, v.pos.z);
					if(height == 0) blk = blk.down();
					state = world.getBlockState(blk);
					if(!state.getBlock().isReplaceable(world, blk)){
			            if(player != null) Print.chatbar(sender, String.format("Obstacle at position: %sx, %sy, %sz!", blk.getX(), blk.getY(), blk.getZ()));
			            return false;
					}
				}
			}
			boolean rb;
			HashMap<BlockPos, Integer> blocks = new HashMap<>();
			for(QV3D v : path){
				height = v.y;
				blk = new BlockPos(v.pos.x, v.pos.y, v.pos.z);
				if(height == 0) blk = blk.down();
				state = world.getBlockState(blk);
				//rb = state.getBlock() == RailBlock.INSTANCE;
				if(register){// ? true : rb){
					if(!blocks.containsKey(blk)) blocks.put(blk, height);
				}
				state = world.getBlockState(blk = blk.down());
				/*if(state.getBlock() instanceof RailBlock){
					if(!blocks.containsKey(blk)) blocks.put(blk, -1);
				}*/
			}
			if(useitems && !creative && getRailsOfTypeInInv(type, player) < blocks.size()){
				Print.chatbar(sender, String.format("Not enough rails in inventory! Needed: %s", blocks.size()));
				return false;
			}
			for(Entry<BlockPos, Integer> entry : blocks.entrySet()){
				if(!register && pos != null && entry.getKey().equals(pos)) continue;
				if(register && !regblocks){
					if(useitems){
						consumeOneItem(type, player);
						track.items++;
					}
					continue;
				}
				blk = entry.getKey();
				height = entry.getValue();
				state = world.getBlockState(blk);
				HashMap<PathKey, Integer> tracks = null;
				//RailEntity tile = (RailEntity)world.getTileEntity(blk);
				/*if(register && (state.getBlock() != RailBlock.INSTANCE || state.getValue(HEIGHT) < (height == 0 ? 16 : height))){
					if(state.getBlock() == RailBlock.INSTANCE){
						tracks = tile.getTracks();
					}
					world.setBlockState(blk, RailBlock.INSTANCE.getDefaultState().withProperty(HEIGHT, height));
					if(tracks != null){
						tile = (RailEntity)world.getTileEntity(blk);
						tile.getTracks().putAll(tracks);
					}
				}*/
				//tile = (RailEntity)world.getTileEntity(blk);
				/*if(tile != null){
					if(register && height == -1 && state.getValue(HEIGHT) > 0){
						height = 0;
						tracks = tile.getTracks();
						world.setBlockState(blk, RailBlock.INSTANCE.getDefaultState().withProperty(HEIGHT, 0));
						tile = (RailEntity)world.getTileEntity(blk);
						tile.getTracks().putAll(tracks);
					}
					regTile(world, tile, track, height, register);
				}*/
				if(register && useitems && !creative){
					consumeOneItem(type, player);
					track.items++;
				}
			}
		}
		if(!register && !creative){
			if(pos == null) pos = new BlockPos(track.start.pos.x, track.start.pos.y, track.start.pos.z);
			if(track.preset != null){
				EntityItem item = new EntityItem(world);
				item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
				item.setItem(new ItemStack(Item.getByNameOrId(track.preset)));
				world.spawnEntity(item);
			}
			else if(track.items > 0){
				int items = track.items;
				while(items > 0){
					EntityItem item = new EntityItem(world);
					item.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
					ItemStack stack = track.gauge.getNewStack().local();
					stack.setCount(items);
					item.setItem(stack);
					world.spawnEntity(item);
					items -= 64;
				}
			}
		}
		return true;
	}
	
	public void process(){
		result();
	}

	public static V3D grv(double rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad);
        return new V3D(co * vec.x - si * vec.z, vec.y, si * vec.x + co * vec.z);
	}

	private static int getRailsOfTypeInInv(RailGauge type, EntityPlayer player){
		int found = 0;
		for(ItemStack stack : player.inventoryContainer.getInventory()){
			if(stack.isEmpty() || stack.getItem() instanceof RailGaugeItem == false) continue;
			if(((RailGaugeItem)stack.getItem()).getContent() != type) continue;
			found += stack.getCount();
		}
		return found;
	}
	
	private static void consumeOneItem(RailGauge type, EntityPlayer player){
		for(ItemStack stack : player.inventoryContainer.getInventory()){
			if(stack.isEmpty() || stack.getItem() instanceof RailGaugeItem == false) continue;
			if(((RailGaugeItem)stack.getItem()).getContent() != type) continue;
			stack.shrink(1);
			return;
		}
	}

	/*private static void regTile(World world, RailEntity tile, Track track, int height, boolean reg){
		if(reg) tile.addTrack(track, height);
		else tile.remTrack(track, world);
	}*/

}
