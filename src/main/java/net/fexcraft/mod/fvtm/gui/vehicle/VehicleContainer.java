package net.fexcraft.mod.fvtm.gui.vehicle;

import javax.annotation.Nullable;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.gui.GenericContainer;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.Fuel;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.gui.GenericIInventory;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.sys.legacy.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.fexcraft.mod.fvtm.util.function.InventoryFunction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleContainer extends GenericContainer {
	
	protected GenericGui<VehicleContainer> gui;
	@Nullable protected NBTTagCompound initpacket;
	//
	private boolean invmode;
	protected InventoryFunction function;
	protected VehicleEntity veh;
	protected PartData invpart;
	protected String inv_id;
	protected TIFI temp;
	protected GenericIInventory fluid_io, fuel;
	protected int empty_index = -1, page, slots;
	protected long fluid_date;
	/** When things have to be fixed by force. */
	protected EntityPlayerMP mpp;
	//
	protected ContainerSlot slot;
	protected ConSlotInv slotInv;
	protected String slotid;
	protected Entity entity;

	public VehicleContainer(EntityPlayer player, World world, int x, int y, int z){
		super(player);
		if(x == 933){
			if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
			if(player.isRiding() && player.getRidingEntity() instanceof SeatEntity){
				SeatEntity ent = (SeatEntity)player.getRidingEntity(); veh = ent.getVehicle();
				if(!ent.seatdata.driver){ player.closeScreen(); }
			}
			else{
				veh = (VehicleEntity)world.getEntityByID(y);
				if(veh == null){
					Print.chat(player, "VEHICLE NOT FOUND BY ID[" + y + "], OPERATION CANCELLING");
					player.closeScreen(); return;
				}
			}
			this.inventoryItemStacks.clear(); this.inventorySlots.clear();
			invmode = true; fuel = new GenericIInventory(null, 1, 1); slots = 1;
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
		if(z == 938){
			if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
			entity = player.world.getEntityByID(x); this.inventoryItemStacks.clear(); this.inventorySlots.clear();
			slotid = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlotIds()[y];
			slot = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlot(slotid);
			//
			slotInv = new ConSlotInv(slot, entity); slots = slot.length;
			for(int col = 0; col < 12; col++){ if(col >= slot.length) break;
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
	
	public VehicleContainer(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(player); initpacket = compound; if(!player.world.isRemote) mpp = (EntityPlayerMP)player;
		if(xyz[1] == 0 && (!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false)){ player.closeScreen(); return; }
		//
		if(compound.hasKey("inventory")){ invmode = true;
			SeatEntity ent = (SeatEntity)player.getRidingEntity();
			veh = ent == null ? (GenericVehicle)player.world.getEntityByID(xyz[1]) : ent.getVehicle();
			invpart = veh.getVehicleData().getPart(inv_id = compound.getString("inventory"));
			function = invpart.getFunction("fvtm:inventory");
			this.populateSlots();
		}
	}

	protected void populateSlots(){
		this.inventoryItemStacks.clear(); this.inventorySlots.clear(); this.empty_index = -1; slots = 0;
		switch(function.getInventoryType()){
			case CONTAINER: return;
			case ENERGY:
				break;
			case FLUID:{
				fluid_io = new GenericIInventory(null, 2, 1); slots = 2;
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
		        break;
			}
			case ITEM:{
				temp = new TIFI(invpart, function);
		        for(int row = 0; row < 6; row++){
		            for(int col = 0; col < 13; col++){
		                int index = (col + row * 13) + (page * 78);
						if(index >= temp.getSizeInventory()){
							if(empty_index == -1) empty_index = index;
							break;
						}
						addSlotToContainer(new TIS(temp, index, 8 + col * 18, 22 + row * 18, temp.getData(), null));
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
		        break;
			}
			default: return;
		}
	}

	@Override
	protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
		if(!packet.hasKey("cargo")) return;
		if(invmode){
			if(side.isServer()){
				if(packet.getString("cargo").equals("inventory_page")){
					page = packet.getInteger("page"); this.populateSlots();
				}
			}
			else{
				if(packet.getString("cargo").equals("update_fluid_tank")){
                    function.getFluidTank().readFromNBT(packet.getCompoundTag("state"));
				}
				if(packet.getString("cargo").equals("update_fuel_tank")){
                    veh.getVehicleData().getAttribute("fuel_stored").setValue(packet.getInteger("state"));
				}
				if(packet.getString("cargo").equals("update_fuel_data")){
                    veh.getVehicleData().getAttribute("fuel_primary").setValue(packet.getString("primary"));
                    veh.getVehicleData().getAttribute("fuel_secondary").setValue(packet.getString("secondary"));
                    veh.getVehicleData().getAttribute("fuel_quality").setValue(packet.getFloat("quality"));
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
                if(!this.mergeItemStack(itemstack1, slots, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 0, slots, false)){ return ItemStack.EMPTY; }
            if(itemstack1.isEmpty()){ slot.putStack(ItemStack.EMPTY); } else{ slot.onSlotChanged(); }
        } return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer player){
        super.onContainerClosed(player);
        if(fluid_io != null){ fluid_io.closeInventory(player); }
        if(fuel != null){ fuel.closeInventory(player); }
        if(slotInv != null){ slotInv.closeInventory(player); }
    }
    
    @Override
    public void detectAndSendChanges(){
        if(fluid_io != null && function != null){
            if(fluid_date + 50 <= Time.getDate()){
                fluid_date = Time.getDate(); boolean anychange = false;
                //
                ItemStack stack = fluid_io.getStackInSlot(0);
                if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                    if(item.getTankProperties().length > 0 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
                        FluidActionResult result = FluidUtil.tryEmptyContainer(stack, function.getFluidTank(), 1000, player, true);
                        if(result.success){ anychange = true;
                        	fluid_io.setInventorySlotContents(0, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                            if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, stack));
                        }
                    }
                }
                //
                if(function.getFluidTank().getFluidAmount() > 0){
                    stack = fluid_io.getStackInSlot(1);
                    if(!stack.isEmpty() && stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)){
                    	FluidActionResult result = FluidUtil.tryFillContainer(stack, function.getFluidTank(), 1000, player, true);
                        if(result.success){ anychange = true;
                        	fluid_io.setInventorySlotContents(1, stack = result.getResult() == null ? ItemStack.EMPTY : result.getResult());
                            if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 1, stack));
                        }
                    }
                }
                //
                if(!player.world.isRemote && anychange){
                    NBTTagCompound compound = new NBTTagCompound();
                    compound.setString("cargo", "update_fluid_tank");
                    compound.setTag("state", function.getFluidTank().writeToNBT(new NBTTagCompound()));
                	this.send(Side.CLIENT, compound);
                }
            }
        }
        if(fuel != null && !fuel.getStackInSlot(0).isEmpty()){
            if(fluid_date + 50 <= Time.getDate()){
                fluid_date = Time.getDate(); boolean anychange = false;
                ItemStack stack = fuel.getStackInSlot(0);
                if(stack.getItem() instanceof MaterialItem){
                	MaterialItem item = (MaterialItem)stack.getItem();
                	boolean pass = false; Fuel fuel = item.getStoredFuelType(stack);
                	if(fuel != null){
                    	for(String str : veh.getVehicleData().getFuelGroup()){
                    		if(fuel.primary.equals(str)){ pass = true; break; }
                    	}
                	}
                	if(pass){
                        int stored = item.getStoredFuelAmount(stack);
                        if(stored > 0){
                        	boolean considerempty = veh.getVehicleData().getAttribute("fuel_stored").getIntegerValue() <= 1000;
                            int in = veh.getVehicleData().getAttribute("fuel_stored").getIntegerValue();
                        	int cantake = veh.getVehicleData().getAttribute("fuel_capacity").getIntegerValue() - in;
                        	if(cantake < stored) stored = cantake; if(stored > 100) stored = 100;
                        	if(stored > 0){
                            	item.extractFuel(stack, stored); veh.getVehicleData().getAttribute("fuel_stored").increase(stored);
                                if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, stack));
                            	anychange = true;
                                //
                                boolean morechanges = false;
                                if(veh.getVehicleData().getAttribute("fuel_primary").getStringValue().length() == 0){
                                	veh.getVehicleData().getAttribute("fuel_primary").setValue(fuel.getPrimaryGroup());
                                	morechanges = true;
                                }
                                Attribute<?> seco = veh.getVehicleData().getAttribute("fuel_secondary");
                                Attribute<?> qual = veh.getVehicleData().getAttribute("fuel_quality");
                            	if(!seco.getStringValue().equals(fuel.secondary)){
                            		seco.setValue(considerempty ? fuel.secondary : "mixed"); morechanges = true;
                            	}
                            	float oldqual = qual.getFloatValue();
                            	int stor = veh.getVehicleData().getAttribute("fuel_stored").getIntegerValue();
                            	if(!considerempty){
                            		if(fuel.quality != oldqual){
                            			float per0 = in / stor, per1 = stored / stor;
                            			qual.setValue(per0 * oldqual + per1 * fuel.quality);
                            			//TODO check this for correctness.
                            		}
                            		if(!morechanges) morechanges = qual.getFloatValue() != oldqual;
                            	}
                            	else{
                            		qual.setValue(fuel.quality); morechanges = true;
                            	}
                            	if(morechanges){
                                    NBTTagCompound compound = new NBTTagCompound();
                                    compound.setString("cargo", "update_fuel_data");
                                    compound.setString("primary", veh.getVehicleData().getAttribute("fuel_primary").getStringValue());
                                    compound.setString("secondary", seco.getStringValue());
                                    compound.setFloat("quality", qual.getFloatValue());
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
                    compound.setInteger("state", veh.getVehicleData().getAttribute("fuel_stored").getIntegerValue());
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
                itemstack1 = itemstack.isEmpty() ? ItemStack.EMPTY : itemstack.copy(); this.inventoryItemStacks.set(i, itemstack1);
                if(!clientStackChanged) continue; if(mpp != null) mpp.connection.sendPacket(new SPacketSetSlot(this.windowId, i, itemstack1));
                for(int j = 0; j < this.listeners.size(); ++j){ this.listeners.get(j).sendSlotContents(this, i, itemstack1); }
            }
        }
    }

}
