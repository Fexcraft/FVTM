package net.fexcraft.mod.fvtm.gui.inv;

import java.util.Map;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.function.InventoryBlockFunction;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.fexcraft.mod.uni.impl.TagCWI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;

public class UniFluidInvContainer extends GenericContainer {

	protected GenericGui<UniFluidInvContainer> gui;
	protected MultiblockTileEntity mb_tile;
	protected ContainerEntity con_tile;
	protected BlockTileEntity blk_tile;
	protected InventoryFunction func;
	protected RootVehicle entity;
	protected String inv_id, title;
	//protected boolean coninv;
	//
	protected InvHandler invhandler;
	protected EntityPlayerMP mpp;
	protected long fluid_date;
	protected GenericIInventory fluid_io;
	protected FluidTank tank;

	public UniFluidInvContainer(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(player);
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		if(ID == UIKeys.MULTIBLOCK_INVENTORY_FLUID.id){
			mb_tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
			NBTTagCompound com = new NBTTagCompound();//TODO GuiHandler.validate(player, null, player.world.isRemote);
			if(com == null){
				player.closeScreen();
				return;
			}
			inv_id = com.getString("inventory");
			invhandler = mb_tile.getMultiBlockData().getInventory(inv_id);
			title = mb_tile.getBlockData().getType().getName() + " - " + inv_id;
		}
		else if(ID == GuiHandler.CONTAINER_INVENTORY_FLUID){
			con_tile = (ContainerEntity)world.getTileEntity(new BlockPos(x, y, z));
			invhandler = con_tile.getContainerData().getInventory();
			title = con_tile.getContainerData().getType().getName();
			//coninv = true;
		}
		else if(ID == UIKeys.BLOCK_INVENTORY_FLUID.id){
			blk_tile = (BlockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
			invhandler = ((InventoryBlockFunction)blk_tile.getBlockData().getFunctionInventory()).inventory();
			title = blk_tile.getBlockData().getType().getName();
		}
		else if(ID == UIKeys.VEHICLE_INVENTORY_FLUID.id){
			entity = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
			SeatInstance seat = entity.getSeatOf(player);
			int invid = 0;
			for(Map.Entry<String, PartData> entry : entity.vehicle.data.getParts().entrySet()){
				InventoryFunction inv = entry.getValue().getFunction("fvtm:inventory");
				if(inv == null || inv.inventory().type.isContainer()) continue;
				if(seat == null ? inv.getSeats().contains(entity.vehicle.data.getLock().isLocked() ? "external-locked" : "external") : (seat.seat.driver || (inv.getSeats().contains(seat.seat.name)))){
					if(invid == z){
						inv_id = entry.getKey();
						func = inv;
						break;
					}
					else invid++;
				}
			}
			if(inv_id == null) player.closeScreen();
			invhandler = func.inventory();
			title = entity.vehicle.data.getType().getName() + " - " + inv_id;
		}
		tank = invhandler.getTank();
		//
		this.inventoryItemStacks.clear();
		this.inventorySlots.clear();
		fluid_io = new GenericIInventory(null, 2, 1);
		addSlotToContainer(new Slot(fluid_io, 0, 116, 50));
		addSlotToContainer(new Slot(fluid_io, 1, 152, 50));
		//
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 74 + row * 18));
			}
		}
		for(int col = 0; col < 9; col++){
			addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 130));
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(!side.isServer()){
			if(packet.getString("cargo").equals("update_fluid_tank")){
				invhandler.load(new TagCWI(packet), "state");
				if(packet.hasKey("stack_0")) fluid_io.setInventorySlotContents(0, new ItemStack(packet.getCompoundTag("stack_0")));
				if(packet.hasKey("stack_1")) fluid_io.setInventorySlotContents(1, new ItemStack(packet.getCompoundTag("stack_1")));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(index < 2){
				if(!this.mergeItemStack(itemstack1, 2, this.inventorySlots.size(), true)){ return ItemStack.EMPTY; }
			}
			else if(!this.mergeItemStack(itemstack1, 0, 2, false)){ return ItemStack.EMPTY; }
			if(itemstack1.isEmpty()){
				slot.putStack(ItemStack.EMPTY);
			}
			else{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		fluid_io.closeInventory(player);
		if(mb_tile != null) mb_tile.markDirty();
		if(con_tile != null) con_tile.markDirty();
		if(blk_tile != null){
			blk_tile.markDirty();
			if(((InventoryBlockFunction)blk_tile.getBlockData().getFunctionInventory()).hasBool()){
				((InventoryBlockFunction)blk_tile.getBlockData().getFunctionInventory()).onClose(blk_tile);
			}
		}
	}

	@Override
	public void detectAndSendChanges(){
		if(invhandler.getTank() != null){
			if(fluid_date + 50 <= Time.getDate()){
				fluid_date = Time.getDate();
				boolean anychange = false;
				//
				ItemStack stack = fluid_io.getStackInSlot(0);
				if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
					IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
					if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
						FluidActionResult result = FluidUtil.tryEmptyContainer(stack, invhandler.getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(((FluidTank)invhandler.getTank()).getFluidAmount() > 0){
					stack = fluid_io.getStackInSlot(1);
					if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
						FluidActionResult result = FluidUtil.tryFillContainer(stack, invhandler.getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(1, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(!player.world.isRemote && anychange){
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "update_fluid_tank");
					invhandler.save(new TagCWI(compound), "state");
					compound.setTag("stack_0", fluid_io.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
					compound.setTag("stack_1", fluid_io.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
					this.send(Side.CLIENT, compound);
				}
			}
		}
		//
		super.detectAndSendChanges();
	}

}
