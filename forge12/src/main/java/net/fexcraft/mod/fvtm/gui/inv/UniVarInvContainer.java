package net.fexcraft.mod.fvtm.gui.inv;

import java.util.Map;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerVar;
import net.fexcraft.mod.fvtm.data.inv.VarStackHandler;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.ui.UIKeys;
import net.fexcraft.mod.fvtm.util.function.InventoryBlockFunction;
import net.fexcraft.mod.fvtm.function.part.InventoryFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.SlotItemHandler;

public class UniVarInvContainer extends GenericContainer {

	protected GenericGui<UniVarInvContainer> gui;
	protected MultiblockTileEntity mb_tile;
	protected ContainerEntity con_tile;
	protected BlockTileEntity blk_tile;
	protected InventoryFunction func;
	protected RootVehicle entity;
	protected String inv_id, title;
	//protected boolean coninv;
	//
	protected InvHandlerVar invhandler;
	protected EntityPlayerMP mpp;
	protected VarStackHandler items;
	protected long date;

	public UniVarInvContainer(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(player);
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		if(ID == UIKeys.MULTIBLOCK_INVENTORY_VAR.id){
			mb_tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
			NBTTagCompound com = new NBTTagCompound();//TODO GuiHandler.validate(player, null, player.world.isRemote);
			if(com == null){
				player.closeScreen();
				return;
			}
			inv_id = com.getString("inventory");
			invhandler = (InvHandlerVar)mb_tile.getMultiBlockData().getInventory(inv_id);
			title = mb_tile.getBlockData().getType().getName() + " - " + inv_id;
		}
		else if(ID == GuiHandler.CONTAINER_INVENTORY_VAR){
			con_tile = (ContainerEntity)world.getTileEntity(new BlockPos(x, y, z));
			invhandler = (InvHandlerVar)con_tile.getContainerData().getInventory();
			title = con_tile.getContainerData().getType().getName();
			//coninv = true;
		}
		else if(ID == UIKeys.BLOCK_INVENTORY_VAR.id){
			blk_tile = (BlockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
			invhandler = (InvHandlerVar)((InventoryBlockFunction)blk_tile.getBlockData().getFunctionInventory()).inventory();
			title = blk_tile.getBlockData().getType().getName();
		}
		else if(ID == UIKeys.VEHICLE_INVENTORY_FLUID.id){
			entity = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
			SeatInstance seat = entity.getSeatOf(player);
			int invid = 0;
			for(Map.Entry<String, PartData> entry : entity.vehicle.data.getParts().entrySet()){
				InventoryFunction inv = entry.getValue().getFunction("fvtm:inventory");
				if(inv == null || inv.inventory().type.isContainer()) continue;
				if(seat == null ? inv.access().contains(entity.vehicle.data.getLock().isLocked() ? "external-locked" : "external") : (seat.seat.driver || (inv.access().contains(seat.seat.name)))){
					if(invid == z){
						inv_id = entry.getKey();
						func = inv;
						break;
					}
					else invid++;
				}
			}
			if(inv_id == null) player.closeScreen();
			//TODO invhandler = (InvHandlerVar)func.inventory();
			title = entity.vehicle.data.getType().getName() + " - " + inv_id;
		}
		//
		this.inventoryItemStacks.clear();
		this.inventorySlots.clear();
		items = new VarStackHandler(invhandler);
		int w = (invhandler.items() * -18 / 2) + 9;
		for(int i = 0; i < invhandler.items(); i++){
			addSlotToContainer(new SlotItemHandler(items, i, w + (i * 18) + 80, 51));
		}
		//
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 72 + row * 18));
			}
		}
		for(int col = 0; col < 9; col++){
			addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 128));
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(!side.isServer()){
			if(packet.getString("cargo").equals("update_varval")){
				invhandler.setVarValue(packet.getInteger("varval"));
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
			if(index < invhandler.items()){
				if(!this.mergeItemStack(itemstack1, invhandler.items(), this.inventorySlots.size(), true)){ return ItemStack.EMPTY; }
			}
			else if(!this.mergeItemStack(itemstack1, 0, invhandler.items(), false)){ return ItemStack.EMPTY; }
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
		if(date + 50 <= Time.getDate()){
			date = Time.getDate();
			NBTTagCompound compound = new NBTTagCompound();
			compound.setInteger("varval", invhandler.getVarValue());
			compound.setString("cargo", "update_varval");
			send(Side.CLIENT, compound);
		}
		super.detectAndSendChanges();
	}

}
