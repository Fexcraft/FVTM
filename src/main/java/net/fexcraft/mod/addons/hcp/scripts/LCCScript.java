package net.fexcraft.mod.addons.hcp.scripts;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.block.ContainerBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleScript;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Ferdinand Calo' (FEX___96)
 *
 */
public class LCCScript extends VehicleScript {
	
	public boolean alright;

	@Override
	public String getId(){
		return "hcp:lcc";
	}

	@Override
	public String getName(){
		return "HCP LCC Script";
	}
	
	@Override
	public void onAttributeToggle(Entity entity, Attribute<?> attr, Object oldvalue, EntityPlayer player){
		if(entity.world.isRemote || attr == null) return;
		boolean bool;
		if(!attr.id().startsWith("lcc_catch")){
			if(!attr.id().startsWith("lcc_release")){
				return;
			}
			else bool = false;
		}
		else bool = true;
    	VehicleEntity ent = (VehicleEntity)entity;
    	if(ent.getVehicleData().getThrottle() > 0){
    		Print.chat(player, "&6Please stop the vehicle first!");
    		return;
    	}
    	if((int)(ent.getRotPoint().getAxes().getYaw()) % 90 != 0){
    		Print.chat(player, "&6Please make sure the crane is in a valid 90\u00B0 rotation!");
    		return;
    	}
    	if(bool){
    		tryCatch(ent, player, attr.id().endsWith("_single"));
    	}
    	else{
    		tryRelease(ent, player, attr.id().endsWith("_single"));
    	}
	}

	private void tryCatch(VehicleEntity ent, EntityPlayer player, boolean single){
		ContainerHolder ch = ent.getEntity().getCapability(Capabilities.CONTAINER, null);
		if(ch == null){
			Print.bar(player, "&cERROR: Could not find ContainerHolder Capability in Entity!");
			return;
		}
		ContainerSlot holder = ch.getContainerSlot("holder");
		if(holder == null){
			Print.bar(player, "&cERROR: Could not find 'holder' ContainerSlot in Entity!");
			return;
		}
		for(ContainerData data : holder.getContainers()){
			if(data != null){
				Print.bar(player, "&cPlease unload all containers first.");
				return;
			}
		}
		BlockPos vec0 = new BlockPos(ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(-0.4, 0.1, 0)));
		BlockPos vec1 = new BlockPos(ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector( 0.4, 0.1, 0)));
		Block block0 = player.world.getBlockState(vec0).getBlock();
		Block block1 = player.world.getBlockState(vec1).getBlock();
		boolean first = false;
		ContainerEntity tile = null;
		if(block0 instanceof ContainerBlock){
			tile = (ContainerEntity)player.world.getTileEntity(vec0);
			first = tile.isCore();
		}
		if(!first && block1 instanceof ContainerBlock){
			tile = (ContainerEntity)player.world.getTileEntity(vec1);
			if(!tile.isCore()) tile = null;
		}
		if(tile == null){
			Vec3d vec2 = ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(0, .1, 0));
			ContainerHolder cap = null;
			String slotid = null;
			Entity capent = null;
			Integer index = null;
			for(Entity entity : player.world.loadedEntityList){
				if(capent != null) break;
				if(entity == ent) continue;
				if((cap = entity.getCapability(Capabilities.CONTAINER, null)) == null) continue;
				for(String str : cap.getContainerSlotIds()){
					if(capent != null) break;
					if(single){
						ContainerSlot slot = cap.getContainerSlot(str);
						if(slot == null) continue;
						for(int i = 0; i < slot.length; i++){
							if(slot.getContainers()[i] == null) continue;
							ContainerData data = slot.getContainers()[i];
							//if(i + data.getContainerType().length() >= slot.length) break;
							Vec3d capos = ((ContainerHoldingEntity)entity).getContainerInSlotPosition(str, cap, data.getContainerType(), i);
							AxisAlignedBB bb = new AxisAlignedBB(capos.add(-.45, 0, -.45), capos.add(0.45, 1, 0.45));
							if(bb.contains(vec2)){
								slotid = str;
								capent = entity;
								index = i;
								break;
							}
						}
						if(index == null) capent = null;
					}
					else{
						Vec3d capos = ((ContainerHoldingEntity)entity).getContainerSlotPosition(str, cap);
						AxisAlignedBB bb = new AxisAlignedBB(capos.add(-.5, 0, -.5), capos.add(0.5, 1, 0.5));
						if(bb.contains(vec2)){
							slotid = str;
							capent = entity;
						}
						else{
							//Print.chat(player, "not colliding");
							//Print.debug(vec2, capos, bb);
							capent = null;
						}
					}
				}
			}
			if(cap != null && slotid != null){
				ContainerSlot slot = cap.getContainerSlot(slotid);
				boolean empty = true;
				for(ContainerData con : slot.getContainers()){
					if(con != null){
						empty = false;
						break;
					}
				}
				if(empty){
					Print.bar(player, "&6No Containers in Vehicle: &3" + capent.getName());
					return;
				}
				if(index != null){
					ContainerData data = slot.getContainers()[index];
					slot.setContainer(index, null);
					int off = 0;
					switch(data.getContainerType().length()){
						case 12: off = 0; break;
						case 6: off = 3; break;
						case 3: off = 5; break;
						case 2: off = 5; break;
						case 1: off = 6; break;
					}
					holder.setContainer(off, data);
				}
				else{
					int off = 0;
					switch(slot.length){
						case 12: off = 0; break;
						case 6: off = 3; break;
						case 3: off = 5; break;
						case 2:
						case 1: off = 6; break;
					}
					for(int i = 0; i < slot.getContainers().length; i++){
						if(slot.getContainers()[i] == null) continue;
						holder.setContainer(i + off, slot.getContainers()[i]);
						slot.setContainer(i, null);
					}
				}
				cap.sync(false);
				ch.sync(false);
				Print.bar(player, "&6Loaded from: &3" + capent.getName());
				return;
			}
			else{
				Print.bar(player, "&cNo Container found at position.");
				return;
			}
		}
		ContainerData data = tile.getContainerData();
		//player.world.setBlockState(first ? vec0 : vec1, Blocks.AIR.getDefaultState());
		IBlockState state = player.world.getBlockState(first ? vec0 : vec1);
		tile.notifyBreak(ent.getEntity().world, first ? vec0 : vec1, state, false);
		switch(data.getContainerType()){
			case LARGE:
				holder.setContainer(0, data);
				break;
			case MEDIUM:
				holder.setContainer(3, data);
				break;
			case SMALL:
				holder.setContainer(5, data);
				break;
			case TINY:
				holder.setContainer(6, data);
				break;
			case MICRO:
				holder.setContainer(6, data);
				break;
			default:
				break;
		}
		Print.bar(player, "&6Loaded: &3" + data.getType().getName());
		ch.sync(player.world.isRemote);
	}

	private void tryRelease(VehicleEntity ent, EntityPlayer player, boolean single){
		ContainerHolder ch = ent.getEntity().getCapability(Capabilities.CONTAINER, null);
		if(ch == null){
			Print.bar(player, "&cERROR: Could not find ContainerHolder Capability in Entity!");
			return;
		}
		ContainerSlot holder = ch.getContainerSlot("holder");
		if(holder == null){
			Print.bar(player, "&cERROR: Could not find 'holder' ContainerSlot in Entity!");
			return;
		}
		boolean found = false;
		for(ContainerData data : holder.getContainers()){
			if(data != null){
				found = true;
				break;
			}
		}
		if(!found){
			Print.bar(player, "&cThere are no containers loaded!");
			return;
		}
		Vec3d vec1;
		ContainerData firstcon = null;
		int hlength = 0, firstid = 0;
		for(int i = 0; i < holder.length; i++){
			if(holder.getContainers()[i] != null){
				firstcon = holder.getContainers()[i];
				firstid = i;
				break;
			}
		}
		if(!single){
			for(ContainerData data : holder.getContainers()){
				if(data != null) hlength += data.getContainerType().length();
			}
			vec1 = ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(0, .1, 0));
		}
		else{
			float offset = firstid - (holder.getContainers().length / 2) + (firstcon.getContainerType().length() / 2);
			vec1 = ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(offset, .1, 0));
		}
		ContainerHolder cap = null;
		String slotid = null;
		Entity capent = null;
		Integer index = null;
		for(Entity entity : player.world.loadedEntityList){
			if(capent != null) break;
			if(entity == ent) continue;
			if((cap = entity.getCapability(Capabilities.CONTAINER, null)) == null) continue;
			for(String str : cap.getContainerSlotIds()){
				if(capent != null) break;
				if(single){
					ContainerSlot slot = cap.getContainerSlot(str);
					if(slot == null || slot.length < firstcon.getContainerType().length()) continue;
					for(int i = 0; i < slot.length;){
						if(slot.getContainers()[i] != null){
							i += slot.getContainers()[i].getContainerType().length();
							continue;
						}
						Vec3d capos = ((ContainerHoldingEntity)entity).getContainerInSlotPosition(str, cap, firstcon.getContainerType(), i);
						AxisAlignedBB bb = new AxisAlignedBB(capos.add(-.45, 0, -.45), capos.add(0.45, 1, 0.45));
						if(bb.contains(vec1)){
							slotid = str;
							capent = entity;
							index = i;
							break;
						}
						i++;//+= firstcon.getContainerType().length();
					}
					if(index == null) cap = null;
				}
				else{
					Vec3d capos = ((ContainerHoldingEntity)entity).getContainerSlotPosition(str, cap);
					AxisAlignedBB bb = new AxisAlignedBB(capos.add(-.5, 0, -.5), capos.add(0.5, 1, 0.5));
					if(bb.contains(vec1)){
						slotid = str;
						capent = entity;
					}
					else{
						//Print.chat(player, "not colliding");
						//Print.debug(vec2, capos, bb);
						capent = null;
					}
				}
			}
		}
		if(cap != null && slotid != null){
			ContainerSlot slot = cap.getContainerSlot(slotid);
			if(!single && hlength > slot.length){
				Print.bar(player, "&cLoaded Containers are longer than the Slot. " + String.format("%s > %s",hlength, slot.length));
				return;
			}
			if(index != null){
				for(int i = 0; i < firstcon.getContainerType().length(); i++){
					if(index + i >= slot.getContainers().length || slot.getContainers()[index + i] != null){
						Print.bar(player, "&cNo space to load Container into slot!" + String.format("%s !> %s", index, index + i));
						return;
					}
				}
				slot.setContainer(index, firstcon);
				holder.setContainer(firstid, null);
			}
			else{
				int free = 0;
				for(int i = 0; i < slot.length;){
					if(slot.getContainers()[i] == null){
						free++; i++;
					}
					else i += slot.getContainers()[i].getContainerType().length();
				}
				if(free < hlength){
					Print.bar(player, "&cNo space to load all Containers into slot!" + String.format("%s !> %s", free, hlength));
					return;
				}
				int last = slot.reSort();
				for(int i = 0; i < holder.getContainers().length; i++){
					if(holder.getContainers()[i] == null) continue;
					ContainerData condata = holder.getContainers()[i];
					slot.setContainer(last, condata);
					last += condata.getContainerType().length();
				}
				for(int i = 0; i < holder.length; i++){
					holder.setContainer(i, null);
				}
			}
			cap.sync(false);
			ch.sync(false);
			Print.bar(player, "&6Unloaded to: &3" + capent.getName());
			return;
		}
		//
		boolean passed = false;
		for(int i = 0; i < holder.getContainers().length; i++){
			if(holder.getContainers()[i] == null) continue;
			if(passed && single) break;
			passed = true;
			ContainerData condata = holder.getContainers()[i];
			float offset = i - (holder.getContainers().length / 2) + (condata.getContainerType().length() / 2);
			vec1 = ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(offset, 0.1, 0));
			BlockPos vec0 = new BlockPos(vec1);//ent.getEntity().getPositionVector().add(ent.getVehicleData().getRotationPoint("lcc_holder").getRelativeVector(-0.4, 0, 0)));
			Block block0 = player.world.getBlockState(vec0).getBlock();
			if(block0 == Blocks.AIR || block0.isReplaceable(player.world, vec0)){
				if(player.world.getBlockState(vec0.down()).getBlock().isReplaceable(player.world, vec0.down())){
					if(single){
						Print.bar(player, "&cNot solid block bellow core Position.");
					}
					else{
						Print.chat(player, "&cNot solid block bellow core Position." + (single ? "" : "&3slot:" + i));
					}
					return;
				}
				EnumFacing facing = EnumFacing.fromAngle(ent.getRotPoint().getAxes().getYaw());
				if(ContainerItem.isValidPostitionForContainer(ent.getEntity().world, player, vec0, facing, condata)){
		            ItemStack stack = condata.newItemStack();
		            stack.getTagCompound().setLong("PlacedPos", vec0.toLong());
		            ContainerBlock.getPositions(condata, vec0, facing).forEach(blkpos -> {
		                IBlockState state = ContainerBlock.INSTANCE.getDefaultState();
		                state.getBlock().onBlockPlacedBy(player.world, blkpos, state.withProperty(ContainerBlock.FACING, facing), player, stack);
		            });
		            stack.shrink(64);
		            if(single){
			            Print.bar(player, "&3" + condata.getType().getName() + " &6placed.");
		            }
		            else{
			            Print.chat(player, "&3" + condata.getType().getName() + " &6placed." + (single ? "" : "&3slot:" + i));
		            }
		            holder.setContainer(i, null);
		            ch.sync(false);
				}
				else{
					if(single){
						Print.bar(player, "&cContainer could not be placed.");
					}
					else{
						Print.chat(player, "&cContainer could not be placed." + (single ? "" : "&3slot:" + i));
					}
				}
			}
			else{
				if(single){
					Print.bar(player, "&cNot replaceable block at core Position.");
				}
				else{
					Print.chat(player, "&cNot replaceable block at core Position." + (single ? "" : "&3slot:" + i));
				}
				return;
			}
		}
	}

	@Override
	public void onUpdate(Entity entity, VehicleData data){
    	VehicleEntity ent = (VehicleEntity)entity;
    	if(ent.getVehicleData().getThrottle() > 0){
    		alright = false;
    	}
	}

}
