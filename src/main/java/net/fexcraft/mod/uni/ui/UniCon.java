package net.fexcraft.mod.uni.ui;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.packet.Packet_TagListener;
import net.fexcraft.mod.fvtm.packet.Packets;
import net.fexcraft.mod.fvtm.sys.uni.Passenger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class UniCon extends Container {

	protected EntityPlayer player;
	protected ContainerInterface con;
	@SideOnly(Side.CLIENT)
	protected UniUI uni;
	protected int slots;

	public UniCon(ContainerInterface con, EntityPlayer player){
		this.con = con;
		this.player = player;
		con.SEND_TO_CLIENT = (com, pass) -> {
			Packets.sendTo(Packet_TagListener.class, (Passenger)pass, "ui", com);
		};
		con.SEND_TO_SERVER = com -> {
			Packets.send(Packet_TagListener.class, "ui", com);
		};
		if(!con.ui_map.has("slots") || con instanceof InventoryInterface == false) return;
		ArrayList<UISlot> uislots = new ArrayList<>();
		if(con.ui_map.has("slots")){
			for(Map.Entry<String, JsonValue<?>> entry : con.ui_map.getMap("slots").entries()){
				try{
					uislots.add(new UISlot(con.ui, entry.getValue().asMap()));
				}
				catch(Exception e){
					FvtmLogger.log(e, "inventory slot parsing");
				}
			}
		}
		slots = 0;
		inventoryItemStacks.clear();
		inventorySlots.clear();
		InventoryInterface invcon = (InventoryInterface)con;
		for(UISlot slot : uislots){
			IInventory inventory = slot.playerinv ? player.inventory : (IInventory)invcon.getInventory();
			for(int y = 0; y < slot.repeat_y; y++){
				for(int x = 0; x < slot.repeat_x; x++){
					try{
						addSlotToContainer((Slot)UISlot.SLOT_GETTER.apply(slot.type,
							new Object[]{ inventory, x + (y * slot.repeat_x) + slot.index, slot.x + x * 18, slot.y + y * 18 }));
					}
					catch(Exception e){
						FvtmLogger.log(e, "inventory slot creation");
					}
					if(!slot.playerinv) slots++;
				}
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return player != null;
	}

	public void setup(UniUI ui){
		uni = ui;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(index < slots){
				if(!mergeItemStack(itemstack1, slots, inventorySlots.size(), true)) return ItemStack.EMPTY;
			}
			else if(!mergeItemStack(itemstack1, 0, slots, false)) return ItemStack.EMPTY;
			if(itemstack1.isEmpty()) slot.putStack(ItemStack.EMPTY);
			else slot.onSlotChanged();
		}
		return itemstack;
	}

	public ContainerInterface container(){
		return con;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		con.onClosed();
	}

	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		con.update(this);
	}

}
