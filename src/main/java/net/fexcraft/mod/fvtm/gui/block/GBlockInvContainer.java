package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.util.handler.ItemStackHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.SlotItemHandler;

public class GBlockInvContainer extends GenericContainer {

	protected GenericGui<GBlockInvContainer> gui;
	protected MultiblockTileEntity tile;
	//
	protected String inv_id;
	protected ItemStackHandler temp;
	protected GenericIInventory fluid_io;
	protected int empty_index = -1, page, slots;
	protected long fluid_date, lastfluid;
	protected InvHandler inventory;
	/** When things have to be fixed by force. */
	protected EntityPlayerMP mpp;
	//
	protected String slotid;
	protected Entity entity;

	public GBlockInvContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		tile = (MultiblockTileEntity)player.world.getTileEntity(new BlockPos(x, y, z));
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		//
		initPacket(null);
	}

	@Override
	public void initPacket(NBTTagCompound compound){
		if((compound = GuiHandler.validate(player, compound, player.world.isRemote)) == null) return;
		inv_id = compound.getString("inventory");
		inventory = tile.getMultiBlockData().getType().getInventories().get(inv_id);
		this.populateSlots();
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear();
		this.inventorySlots.clear();
		this.empty_index = -1;
		this.slots = 0;
		if(inventory.type.isFluid()){
			fluid_io = new GenericIInventory(null, 2, 1);
			slots = 2;
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
		else if(inventory.type.isItem()){
			temp = new ItemStackHandler(tile.getMultiBlockData().getInventory(inv_id).getStacks());
			int size = tile.getMultiBlockData().getInventory(inv_id).getStacks().size();
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 13; col++){
					int index = (col + row * 13) + (page * 78);
					if(index >= size){
						if(empty_index == -1) empty_index = index;
						break;
					}
					addSlotToContainer(new SlotItemHandler(temp, index, 8 + col * 18, 22 + row * 18));
					slots++;
				}
			}
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 136 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 192));
			}
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			if(packet.getString("cargo").equals("inventory_page")){
				page = packet.getInteger("page");
				this.populateSlots();
			}
		}
		else{
			if(packet.getString("cargo").equals("update_fluid_tank")){
				tile.getMultiBlockData().getInventory(inv_id).load(packet.getCompoundTag("state"));
				if(packet.hasKey("stack_0")) fluid_io.setInventorySlotContents(0, new ItemStack(packet.getCompoundTag("stack_0")));
				if(packet.hasKey("stack_1")) fluid_io.setInventorySlotContents(1, new ItemStack(packet.getCompoundTag("stack_1")));
			}
			if(packet.getString("cargo").equals("update_stack")){
				inventorySlots.get(packet.getInteger("index")).putStack(new ItemStack(packet.getCompoundTag("stack")));
				inventoryItemStacks.set(packet.getInteger("index"), new ItemStack(packet.getCompoundTag("stack")));
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
			if(index < slots){
				if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){ return ItemStack.EMPTY; }
			}
			else if(!this.mergeItemStack(itemstack1, 0, slots, false)){ return ItemStack.EMPTY; }
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
		if(fluid_io != null){
			fluid_io.closeInventory(player);
		}
		tile.markDirty();
	}

	@Override
	public void detectAndSendChanges(){
		if(fluid_io != null && inventory.type.isFluid()){
			if(fluid_date + 50 <= Time.getDate()){
				fluid_date = Time.getDate();
				boolean anychange = false;
				//
				ItemStack stack = fluid_io.getStackInSlot(0);
				if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
					IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
					if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
						FluidActionResult result = FluidUtil.tryEmptyContainer(stack, tile.getMultiBlockData().getInventory(inv_id).getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(tile.getMultiBlockData().getInventory(inv_id).getTank().getFluidAmount() > 0){
					stack = fluid_io.getStackInSlot(1);
					if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
						FluidActionResult result = FluidUtil.tryFillContainer(stack, tile.getMultiBlockData().getInventory(inv_id).getTank(), 1000, player, true);
						if(result.success){
							anychange = true;
							fluid_io.setInventorySlotContents(1, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
				}
				//
				if(!anychange && lastfluid != tile.getMultiBlockData().getInventory(inv_id).getTank().getFluidAmount()){
					lastfluid = tile.getMultiBlockData().getInventory(inv_id).getTank().getFluidAmount();
					anychange = true;
				}
				if(!player.world.isRemote && anychange){
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "update_fluid_tank");
					compound.setTag("state", tile.getMultiBlockData().getInventory(inv_id).save(new NBTTagCompound()));
					compound.setTag("stack_0", fluid_io.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
					compound.setTag("stack_1", fluid_io.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
					this.send(Side.CLIENT, compound);
				}
			}
		}
		else{
	        for(int i = 0; i < this.inventorySlots.size(); ++i){
	            ItemStack itemstack = ((Slot)this.inventorySlots.get(i)).getStack();
	            ItemStack itemstack1 = this.inventoryItemStacks.get(i);
	            if(!ItemStack.areItemStacksEqual(itemstack1, itemstack)){
	                boolean clientStackChanged = !ItemStack.areItemStacksEqualUsingNBTShareTag(itemstack1, itemstack);
	                itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy();
	                this.inventoryItemStacks.set(i, itemstack1);
	                if(clientStackChanged){
						NBTTagCompound compound = new NBTTagCompound();
						compound.setString("cargo", "update_stack");
						compound.setInteger("index", i);
						compound.setTag("stack", itemstack1.writeToNBT(new NBTTagCompound()));
						this.send(Side.CLIENT, compound);
	                }
	            }
	        }
		}
	}

}
