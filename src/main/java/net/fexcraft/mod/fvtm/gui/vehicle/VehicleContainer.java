package net.fexcraft.mod.fvtm.gui.vehicle;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.VEHICLE_CONTAINER;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.ui.UIKey;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {

	protected GenericGui<VehicleContainer> gui;
	//
	private boolean invmode;
	protected InventoryFunction function;
	protected RootVehicle vehent;
	protected PartData invpart;
	protected String inv_id;
	protected GenericIInventory fuel;
	protected int slots;
	protected long fuel_date = 0;
	/** When things have to be fixed by force. */
	protected EntityPlayerMP mpp;
	//
	protected ContainerSlot slot;
	protected ConSlotInv slotInv;
	protected String slotid;
	protected Entity entity;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		if(x == UIKey.VEHICLE_FUEL.id){
			if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
			vehent = (RootVehicle)(player.getRidingEntity() instanceof RootVehicle ? player.getRidingEntity() : world.getEntityByID(y));
			this.inventoryItemStacks.clear();
			this.inventorySlots.clear();
			invmode = true;
			fuel = new GenericIInventory(null, 1, 1);
			slots = 1;
			addSlotToContainer(new Slot(fuel, 0, 116, 50));
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
		if(x == VEHICLE_CONTAINER){
			if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
			entity = player.world.getEntityByID(y);
			this.inventoryItemStacks.clear();
			this.inventorySlots.clear();
			slotid = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlotIds()[z];
			slot = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlot(slotid);
			//
			slotInv = new ConSlotInv(slot, entity);
			slots = slot.length;
			for(int col = 0; col < 12; col++){
				if(col >= slot.length) break;
				addSlotToContainer(new ConSlotInv.SSlot(slotInv, col, 8 + col * 18, 22));
			}
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 8 + col * 18, 64 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 8 + col * 18, 120));
			}
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(invmode){
			if(side.isServer()){
				//
			}
			else{
				if(packet.getString("cargo").equals("update_fuel_tank")){
					vehent.vehicle.data.getAttribute("fuel_stored").set(packet.getInteger("state"));
					if(packet.hasKey("stack")) fuel.setInventorySlotContents(0, new ItemStack(packet.getCompoundTag("stack")));
				}
				if(packet.getString("cargo").equals("update_fuel_data")){
					vehent.vehicle.data.getAttribute("fuel_primary").set(packet.getString("primary"));
					vehent.vehicle.data.getAttribute("fuel_secondary").set(packet.getString("secondary"));
					vehent.vehicle.data.getAttribute("fuel_quality").set(packet.getFloat("quality"));
				}
				if(packet.getString("cargo").equals("update_stack")){
					inventorySlots.get(packet.getInteger("index")).putStack(new ItemStack(packet.getCompoundTag("stack")));
					inventoryItemStacks.set(packet.getInteger("index"), new ItemStack(packet.getCompoundTag("stack")));
				}
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
		if(fuel != null){
			fuel.closeInventory(player);
		}
		if(slotInv != null){
			slotInv.closeInventory(player);
		}
	}

	@Override
	public void detectAndSendChanges(){
		if(fuel != null && !fuel.getStackInSlot(0).isEmpty()){
			if(fuel_date + 50 <= Time.getDate()){
				fuel_date = Time.getDate();
				boolean anychange = false;
				ItemStack stack = fuel.getStackInSlot(0);
				if(stack.getItem() instanceof MaterialItem){
					MaterialItem item = (MaterialItem)stack.getItem();
					boolean pass = false;
					Fuel fuel = item.getStoredFuelType(stack);
					if(fuel != null){
						for(String str : vehent.vehicle.data.getFuelGroup()){
							if(fuel.primary.equals(str)){
								pass = true;
								break;
							}
						}
					}
					if(pass){
						int stored = item.getStoredFuelAmount(stack);
						if(stored > 0){
							boolean considerempty = vehent.vehicle.data.getAttribute("fuel_stored").asInteger() <= 1000;
							int in = vehent.vehicle.data.getAttribute("fuel_stored").asInteger();
							int cantake = vehent.vehicle.data.getAttribute("fuel_capacity").asInteger() - in;
							if(cantake < stored) stored = cantake;
							if(stored > 100) stored = 100;
							if(stored > 0){
								item.extractFuel(stack, stored);
								vehent.vehicle.data.getAttribute("fuel_stored").increase(stored);
								anychange = true;
								//
								boolean morechanges = false;
								if(vehent.vehicle.data.getAttribute("fuel_primary").asString().length() == 0){
									vehent.vehicle.data.getAttribute("fuel_primary").set(fuel.getPrimaryGroup());
									morechanges = true;
								}
								Attribute<?> seco = vehent.vehicle.data.getAttribute("fuel_secondary");
								Attribute<?> qual = vehent.vehicle.data.getAttribute("fuel_quality");
								if(!seco.asString().equals(fuel.secondary)){
									seco.set(considerempty ? fuel.secondary : "mixed");
									morechanges = true;
								}
								float oldqual = qual.asFloat();
								int stor = vehent.vehicle.data.getAttribute("fuel_stored").asInteger();
								if(!considerempty){
									if(fuel.quality != oldqual){
										float per0 = in / stor, per1 = stored / stor;
										qual.set(per0 * oldqual + per1 * fuel.quality);
										// TODO check this for correctness.
									}
									if(!morechanges) morechanges = qual.asFloat() != oldqual;
								}
								else{
									qual.set(fuel.quality);
									morechanges = true;
								}
								if(morechanges){
									NBTTagCompound compound = new NBTTagCompound();
									compound.setString("cargo", "update_fuel_data");
									compound.setString("primary", vehent.vehicle.data.getAttribute("fuel_primary").asString());
									compound.setString("secondary", seco.asString());
									compound.setFloat("quality", qual.asFloat());
									this.send(Side.CLIENT, compound);
								}
							}
						}
					}
				}
				//
				if(!player.world.isRemote && anychange){
					NBTTagCompound compound = new NBTTagCompound();
					compound.setString("cargo", "update_fuel_tank");
					compound.setInteger("state", vehent.vehicle.data.getAttribute("fuel_stored").asInteger());
					compound.setTag("stack", stack.writeToNBT(new NBTTagCompound()));
					this.send(Side.CLIENT, compound);
				}
			}
		}
		//
		if(slotInv == null){
			super.detectAndSendChanges();
		}
		else{
			for(int i = 0; i < this.inventorySlots.size(); ++i){
				ItemStack itemstack = ((Slot)this.inventorySlots.get(i)).getStack(), itemstack1 = this.inventoryItemStacks.get(i);
				if(ItemStack.areItemStacksEqual(itemstack1, itemstack)) continue;
				boolean clientStackChanged = !ItemStack.areItemStacksEqualUsingNBTShareTag(itemstack1, itemstack);
				itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy();
				this.inventoryItemStacks.set(i, itemstack1);
				if(!clientStackChanged) continue;
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "update_stack");
				compound.setInteger("index", i);
				compound.setTag("stack", itemstack1.writeToNBT(new NBTTagCompound()));
				this.send(Side.CLIENT, compound);
			}
		}
	}

}
