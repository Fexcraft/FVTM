package net.fexcraft.mod.fvtm.gui.inv;

import java.util.Map;

import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class UniItemInvContainer extends GenericContainer {

	protected GenericGui<UniItemInvContainer> gui;
	protected MultiblockTileEntity mb_tile;
	protected ContainerEntity con_tile;
	protected InventoryFunction func;
	protected GenericVehicle entity;
	protected String inv_id, title;
	protected boolean coninv;
	//
	protected int page, slots;
	protected InvHandler invhandler;
	protected EntityPlayerMP mpp;
	protected GenericIInventory insert;

	public UniItemInvContainer(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(player);
		if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		initPacket(null);
		if(ID == GuiHandler.MULTIBLOCK_INVENTORY_ITEM){
			mb_tile = (MultiblockTileEntity)world.getTileEntity(new BlockPos(x, y, z));
			NBTTagCompound com = GuiHandler.validate(player, null, player.world.isRemote);
			if(com == null){
				player.closeScreen();
				return;
			}
			inv_id = com.getString("inventory");
			invhandler = mb_tile.getMultiBlockData().getInventory(inv_id);
			title = mb_tile.getBlockData().getType().getName() + " - " + inv_id;
		}
		else if(ID == GuiHandler.CONTAINER_INVENTORY_ITEM){
			con_tile = (ContainerEntity)world.getTileEntity(new BlockPos(x, y, z));
			invhandler = con_tile.getContainerData().getInventory();
			title = con_tile.getContainerData().getType().getName();
			coninv = true;
		}
		else if(ID == GuiHandler.VEHICLE_INVENTORY_ITEM){
			entity = (GenericVehicle)(player.getRidingEntity() instanceof GenericVehicle ? player.getRidingEntity() : world.getEntityByID(y));
			SeatCache seat = entity.getSeatOf(player);
			int invid = 0;
			for(Map.Entry<String, PartData> entry : entity.getVehicleData().getParts().entrySet()){
				InventoryFunction inv = entry.getValue().getFunction("fvtm:inventory");
				if(inv == null || inv.inventory().type.isContainer()) continue;
				if(seat == null ? inv.getSeats().contains(entity.isLocked() ? "external-locked" : "external") : (seat.seatdata.driver || (inv.getSeats().contains(seat.seatdata.name)))){
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
			title = entity.getVehicleData().getType().getName() + " - " + inv_id;
		}
		insert = new GenericIInventory(null, 1, 64);
		//populateSlots();
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear();
		this.inventorySlots.clear();
		this.slots = 0;
		int size = invhandler.getStacks().size();
		for(int row = 0; row < 6; row++){
			int index = (page * 6) + row;
			if(index >= size) break;
			addSlotToContainer(new InvSlot(this, invhandler, true, index, 8, 22 + row * 20));
			addSlotToContainer(new InvSlot(this, invhandler, false, index, 26, 22 + row * 20));
			slots++;
		}
		addSlotToContainer(new Slot(insert, 0, 176, 143){
		    @Override
		    public boolean isItemValid(ItemStack stack){
		        return InvSlot.isValid(invhandler, stack);
		    }
		});
		//
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 147 + row * 18));
			}
		}
		for(int col = 0; col < 9; col++){
			addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 203));
		}
		//
		if(player.world.isRemote) return;
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "reload_slots");
		send(Side.CLIENT, compound);
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(side.isServer()){
			if(packet.getString("cargo").equals("inventory_page")){
				page = packet.getInteger("page");
				if(page < 0) page = 0;
				populateSlots();
			}
			if(packet.getString("cargo").equals("insert_stack")){
				ItemStack stack = insert.getStackInSlot(0);
				if(stack.isEmpty()) return;
				ItemStack stack1 = stack.copy();
				if((stack = invhandler.getStackHandler().insertItem(0, stack, true)).isEmpty() || stack1.getCount() > stack.getCount()){
					insert.setInventorySlotContents(0, invhandler.getStackHandler().insertItem(0, stack1, false));
					NBTTagCompound compound = new NBTTagCompound();
					invhandler.save(compound);
					compound.setTag("insert", insert.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
					compound.setString("cargo", "inv_update");
					send(Side.CLIENT, compound);
					populateSlots();
				}
			}
		}
		else{
			if(packet.getString("cargo").equals("update_stack")){
				inventorySlots.get(packet.getInteger("index")).putStack(new ItemStack(packet.getCompoundTag("stack")));
				inventoryItemStacks.set(packet.getInteger("index"), new ItemStack(packet.getCompoundTag("stack")));
			}
			if(packet.getString("cargo").equals("reload_slots")) this.populateSlots();
			if(packet.getString("cargo").equals("inv_update")){
				invhandler.load(packet);
				insert.setInventorySlotContents(0, new ItemStack(packet.getCompoundTag("insert")));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		return ItemStack.EMPTY;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		if(mb_tile != null) mb_tile.markDirty();
		if(con_tile != null) con_tile.markDirty();
		insert.closeInventory(player);
	}

	@Override
	public void detectAndSendChanges(){
        for(int i = 0; i < this.inventorySlots.size(); ++i){
            ItemStack itemstack = ((Slot)this.inventorySlots.get(i)).getStack();
            ItemStack itemstack1 = this.inventoryItemStacks.get(i);
            if(!ItemStack.areItemStacksEqual(itemstack1, itemstack)){
                boolean changed = !ItemStack.areItemStacksEqualUsingNBTShareTag(itemstack1, itemstack);
                itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy();
                this.inventoryItemStacks.set(i, itemstack1);
                if(changed){
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
