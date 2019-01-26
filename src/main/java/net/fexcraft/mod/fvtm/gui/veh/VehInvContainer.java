package net.fexcraft.mod.fvtm.gui.veh;

import java.io.IOException;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
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

	public VehInvContainer(EntityPlayer player, World world, int x, int y, int z){
		super(new ResourceLocation("fvtm:textures/guis/veh_inv_container.png"), new Container(player, world, x, y, z), player);
		this.xSize = 226; this.ySize = 123;
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(guiLeft + 7, guiTop + 7, 192, MapColor.BLACK.colorValue, "0"));
		//
		this.buttons.put("+", new BasicButton("+", guiLeft + 172, guiTop + 58, 3, 172, 58, 12, true));
		this.buttons.put("-", new BasicButton("-", guiLeft + 198, guiTop + 58, 3, 198, 58, 12, true));
		//
		/*for(int i = 0; i < 12; i++){
			this.texts.put("row" + i, new BasicText(guiLeft + 13, guiTop + 20 + (i * 12), 181, null, i + ""));
			this.buttons.put("edit" + i, new BasicButton("e" + i, guiLeft + 175, guiTop + 19 + (i * 12), 175, 19, 10, 10, false));
			this.buttons.put("rem" + i, new BasicButton("r" + i, guiLeft + 187, guiTop + 19 + (i * 12), 187, 19, 10, 10, false));
		}*/
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("title").string = "ConSlot: " + container.id;
		/*if(container.tile.getVehicleData() == null){
			texts.get("title").string = "no vehicle";
			buttons.get("+").enabled = false; buttons.get("-").enabled = false;
		}
		else{
			texts.get("title").string = container.tile.getVehicleData().getVehicle().getName();
			Part.PartData[] arr = container.tile.getVehicleData().getParts().values().toArray(new Part.PartData[]{});
			buttons.get("+").enabled = scroll < arr.length; buttons.get("-").enabled = scroll > 0;
			//
			for(int j = 0; j < 12; j ++){
				int k = scroll + j; texts.get("row" + j).string = k >= arr.length ? "" : arr[k].getPart().getName();
				buttons.get("edit" + j).enabled = k >= arr.length ? false : arr[k].getPart().isAdjustable();//TODO
				buttons.get("rem" + j).enabled = k >= arr.length ? false : arr[k].getPart().isRemovable();//TODO
			}
		}*/
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		/*switch(key){
			case "+": scroll = ++scroll > (container.tile.getVehicleData() == null ? 0 : container.tile.getVehicleData().getParts().size()) ? --scroll : scroll; break;
			case "-": scroll = --scroll < 0 ? 0 : scroll; break;
		}
		if(key.startsWith("edit")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("part", container.tile.getVehicleData().getParts().keySet().toArray(new String[]{})[Integer.parseInt(key.replace("edit", "")) + scroll]);
			this.openGenericGui(GuiHandler.CCG_PartAdjuster, pos, compound);
		}
		else if(key.startsWith("rem")){
	        NBTTagCompound compound = new NBTTagCompound();
	        compound.setIntArray("pos", pos);
	        compound.setString("cargo", "remove");
	        compound.setString("part", container.tile.getVehicleData().getParts().keySet().toArray(new String[]{})[Integer.parseInt(key.replace("rem", "")) + scroll]);
	        this.container.send(Side.SERVER, compound);
		}*/
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
					if(entry.getValue().getAttributeData(ContainerAttributeData.class) != null){
						if(i == y){ id = entry.getKey(); break; } i++;
					}
				}
			}
			else{
				id = entity.getCapability(FVTMCaps.CONTAINER, null).getContainerIDs(null).toArray(new String[0])[y];
			}
			//
            ContainerSlot slot = ((ContainerHolderUtil.Implementation)entity.getCapability(FVTMCaps.CONTAINER, EnumFacing.DOWN)).getContainerSlot(id);
			for(int i = 0; i < 12; i++){
				addSlotToContainer(new net.fexcraft.mod.fvtm.gui.veh.ContainerSlot(coninv = new ContainerInventory(slot), i, 6 + (i * 18), 20));
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
				case "remove":{
					/*String part = !packet.hasKey("part") ? null : packet.getString("part");
					if(part == null || tile.getVehicleData() == null) return;
					Part.PartData data = tile.getVehicleData().getPart(part);
                    if(data == null || !data.getPart().isRemovable()){
                        Print.chat(player, data == null ? "Part not found in Server Instance." : "Part is marked as non-remove on Server Instance!");
                        return;
                    }
                    data = tile.getVehicleData().getParts().remove(part);
                    if(data == null){ Print.chat(player, "Error, see log for location."); Static.exception(new Exception(), false); }
                    EntityItem item = new EntityItem(tile.getWorld());
                    item.setItem(data.getPart().getItemStack(data));
                    item.setPosition(tile.getPos().getX() + 0.5, tile.getPos().getY() + 1.5, tile.getPos().getZ() + 0.5);
                    tile.getWorld().spawnEntity(item);
                    tile.sendUpdate("vehicledata");*/
					break;
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