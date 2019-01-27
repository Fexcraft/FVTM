package net.fexcraft.mod.fvtm.gui.veh;

import java.io.IOException;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.api.capability.FVTMCaps;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.fvtm.impl.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.impl.caps.ContainerHolderUtil.ContainerSlot;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class VehInvContainer extends GenericGui<VehInvContainer.Container> {
	
	private int[] pos;

	public VehInvContainer(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/veh_inv_container.png"), new Container(player, world, x, y, z), player);
		this.xSize = 226; this.ySize = 123; pos = new int[]{ x, y, z };
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 7, guiTop + 7, 192, MapColor.BLACK.colorValue, "0"));
		this.texts.put("size", new BasicText(guiLeft + 174, guiTop + 46, 45, MapColor.BLACK.colorValue, "0"));
		this.texts.put("curr", new BasicText(guiLeft + 174, guiTop + 74, 45, MapColor.BLACK.colorValue, "0"));
		this.texts.put("state", new BasicText(guiLeft + 174, guiTop + 88, 45, MapColor.BLACK.colorValue, " - - - - "));
		//
		this.buttons.put("-", new BasicButton("-", guiLeft + 172, guiTop + 58, 172, 58, 23, 12, true));
		this.buttons.put("+", new BasicButton("+", guiLeft + 198, guiTop + 58, 198, 58, 23, 12, true));
		//
		texts.get("size").string = container.coninv.getConSlot().size.name();
		texts.get("curr").string = container.coninv.getConSlot().curr.name();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("title").string = "ID: " + container.id + " || ST:" + container.coninv.getConSlot().curr + "/" + container.coninv.getConSlot().size;
		//
		buttons.get("+").enabled = container.coninv.getConSlot().curr.next(false, true) != null;
		buttons.get("-").enabled = container.coninv.getConSlot().curr.prev(false, true) != null;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(!key.equals("+") && !key.equals("-")) return;
		if(!container.coninv.isEmpty()){ Print.chat(player, "Please remove all Containers first."); return; }
		if(container.coninv.getConSlot().supported == null || container.coninv.getConSlot().supported.length == 0){
			Print.chat(player, "Slot does not support other Container Sizes."); return;
		}
		boolean add = key.equals("+") || !key.equals("-"); ContainerSlot slot = container.coninv.getConSlot();
		ContainerType type = add ? slot.curr.next(false, true) : slot.curr.prev(false, true); if(type == null) return;
		texts.get("curr").string = type.name();
		if(slot.isValid(type)){
	        NBTTagCompound compound = new NBTTagCompound();
	        compound.setIntArray("pos", pos);
	        compound.setString("cargo", "update_slot_contype");
	        compound.setString("contype", type.name());
	        this.container.send(Side.SERVER, compound);
			texts.get("state").string = "valid";
		}
		else{
			texts.get("state").string = "invalid";
		}
	}
	
	public static class Container extends GenericGuiContainer {

		private VehicleEntity vehent;
		private Entity entity;
		private String id;
		//
		private ContainerInventory coninv;
		
		public Container(EntityPlayer player, World world, int x, int y, int z){
			this.entity = world.getEntityByID(x); this.player = player;
			if(entity instanceof VehicleEntity){ int i = 0; vehent = (VehicleEntity)entity;
				for(java.util.Map.Entry<String, PartData> entry : vehent.getVehicleData().getParts().entrySet()){
					if(entry.getValue().getPart().getAttribute(ContainerAttribute.class) != null){
						if(i == y){ id = entry.getKey(); break; } i++;
					}
				}
			}
			else{
				id = entity.getCapability(FVTMCaps.CONTAINER, null).getContainerIDs(null).toArray(new String[0])[y];
			}
			//
            coninv = new ContainerInventory(((ContainerHolderUtil.Implementation)entity.getCapability(FVTMCaps.CONTAINER, EnumFacing.DOWN)).getContainerSlot(id));
			for(int i = 0; i < 12; i++){
				addSlotToContainer(new net.fexcraft.mod.fvtm.gui.veh.ContainerSlot(coninv, i, 6 + (i * 18), 20));
			}
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 9; col++){
                    addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 45 + row * 18));
                }
            }
            for(int col = 0; col < 9; col++){
                addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 101));
            }
		}
		
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int index){
            ItemStack itemstack = ItemStack.EMPTY;
            Slot slot = this.inventorySlots.get(index);
            if(slot != null && slot.getHasStack()){
                ItemStack itemstack1 = slot.getStack();
                itemstack = itemstack1.copy();
                if(index < 12){
                    if(!this.mergeItemStack(itemstack1, 12, this.inventorySlots.size(), true)){
                        return ItemStack.EMPTY;
                    }
                }
                else if(!this.mergeItemStack(itemstack1, 0, 12, false)){
                    return ItemStack.EMPTY;
                }
                if(itemstack1.isEmpty()){ slot.putStack(ItemStack.EMPTY); } else{ slot.onSlotChanged(); }
            }
            return itemstack;
        }

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			if(side.isClient() || !packet.hasKey("cargo")) return;
			switch(packet.getString("cargo")){
				case "update_slot_contype":{
					if(!coninv.isEmpty()){ Print.chat(player, "SERVER: Please remove all Containers first."); return; }
					if(coninv.getConSlot().supported == null || coninv.getConSlot().supported.length == 0){
						Print.chat(player, "SERVER: Slot does not support other Container Sizes."); return;
					}
					ContainerType type = ContainerType.valueOf(packet.getString("contype"));
					if(type == null){ Print.chat(player, "SERVER: ContainerType not found."); return; }
					coninv.getConSlot().setType(type); coninv.getConSlot().impl.sync(false);
					//
					int[] pos = packet.getIntArray("pos");
					player.openGui(FVTM.getInstance(), GuiHandler.VEH_INV_Container, entity.world, pos[0], pos[1], pos[2]);
					return;
				}
			}
		}
		
        @Override
        public void onContainerClosed(EntityPlayer player){
            super.onContainerClosed(player); if(coninv != null) coninv.closeInventory(player);
        }
		
        @Override
        public void detectAndSendChanges(){
            super.detectAndSendChanges();
        }
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1) this.openGui(GuiHandler.VEHICLE_INVENTORY, new int[]{ 0, 0, 0 });
        super.keyTyped(typedChar, keyCode);
    }
	
}