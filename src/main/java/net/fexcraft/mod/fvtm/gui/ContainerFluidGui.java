package net.fexcraft.mod.fvtm.gui;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.fexcraft.mod.fvtm.render.Renderer;
import net.fexcraft.mod.lib.util.common.Formatter;
import net.fexcraft.mod.lib.util.math.Time;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

public class ContainerFluidGui {

	private static final ResourceLocation fluidtex = new ResourceLocation("fvtm:textures/guis/vehicle_inventory_fluid.png");
	
	public static class Client extends GuiContainer {
		
		private ContainerTileEntity tile;
		private static Server server;

		public Client(EntityPlayer player, World world, int x, int y, int z){
			super(server = new Server(player, world, x, y, z));
			this.tile = (ContainerTileEntity) world.getTileEntity(new BlockPos(x, y, z));
			this.xSize = 210;
			this.ySize = 126;
		}
		
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	        this.drawDefaultBackground();
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	    }

		@Override
		protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
			int i = this.guiLeft, j = this.guiTop;
			this.mc.getTextureManager().bindTexture(fluidtex);
			this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
			ContainerData data = tile.getContainerData();
			int con = data.getFluidTank().getFluid() == null ? 0 : data.getFluidTank().getFluidAmount();
			int perducenti = (int)(((float)con / data.getFluidTank().getCapacity()) * 200);
			this.drawTexturedModalRect(i + 6, j + 25, 0, 242, perducenti, 14);
			//
			this.fontRenderer.drawString(data.getContainer().getName(), i + 7, j + 7, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(Formatter.format("&a" + server.getFluidItemAmount()), i + 171, j + 91, MapColor.SNOW.colorValue);
			this.fontRenderer.drawString(Formatter.format("&6" + server.getFluidItemCapacity()), i + 171, j + 77, MapColor.SNOW.colorValue);
			//this.fontRenderer.drawString((invattr.getFluidTank().getFluidAmount() / 1000) + " / " + (invattr.getFluidTank().getCapacity() / 1000), i + 9, j + 28, MapColor.SNOW.colorValue);
			String fill = data.getFluidTank().getFluid() == null ? "empty" : data.getFluidTank().getFluid().getLocalizedName();
			Renderer.drawTextOutlined(fontRenderer, con + "mB / " + data.getFluidTank().getCapacity() + "mB (" + fill + ")", i + 9, j + 28, MapColor.SNOW.colorValue);
		}
		
	}
	
	public static class Server extends Container {
		
		private EntityPlayer player;
		private ContainerTileEntity tile;
		//
		FluidInventory fluidinv;
		
		public Server(EntityPlayer player, World world, int x, int y, int z){
			this.player = player;
			tile = (ContainerTileEntity) world.getTileEntity(new BlockPos(x, y, z));
			addSlotToContainer(new FluidInventory.FluidSlot(fluidinv = new FluidInventory(), 0, 179, 50, null));
			//
			for(int row = 0; row < 3; row++){
				for(int col = 0; col < 9; col++){
					addSlotToContainer(new Slot(player.inventory, col + row * 9 + 9, 6 + col * 18, 48 + row * 18));
				}
			}
			for(int col = 0; col < 9; col++){
				addSlotToContainer(new Slot(player.inventory, col, 6 + col * 18, 104));
			}
		}
		
		@Override
		public boolean canInteractWith(EntityPlayer player){
			return player != null && !player.isDead;
		}
		
		@Override
		public void onContainerClosed(EntityPlayer player){
			super.onContainerClosed(player);
			if(fluidinv != null){ fluidinv.closeInventory(player); }
		}
		
		public String getFluidItemCapacity(){
			if(!fluidinv.getStackInSlot(0).isEmpty()){
				IFluidHandlerItem item = fluidinv.getStackInSlot(0).getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
				return item.getTankProperties()[0].getContents() == null ? "0" : "" + item.getTankProperties()[0].getCapacity();
			}
			return " - - - ";
		}

		public String getFluidItemAmount(){
			if(!fluidinv.getStackInSlot(0).isEmpty()){
				IFluidHandlerItem item = fluidinv.getStackInSlot(0).getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
				return item.getTankProperties()[0].getContents() == null ? "0" : "" + item.getTankProperties()[0].getContents().amount;
			}
			return " - - - ";
		}
		
		private long date = 0;
		

		
		@Override
		public ItemStack transferStackInSlot(EntityPlayer player, int index){
			ItemStack itemstack = ItemStack.EMPTY;
	        Slot slot = this.inventorySlots.get(index);
	        if(slot != null && slot.getHasStack()){
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();
	            if(index < 1){
	                if(!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), true)){
	                    return ItemStack.EMPTY;
	                }
	            }
	            else if(!this.mergeItemStack(itemstack1, 0, 1, false)){
	                return ItemStack.EMPTY;
	            }
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
		public void detectAndSendChanges(){
			super.detectAndSendChanges();
			if(tile.getWorld().isRemote){
				return;
			}
			if((fluidinv != null && !fluidinv.isEmpty()) && date + 50 <= Time.getDate()){
				date = Time.getDate();
				ItemStack stack = fluidinv.getStackInSlot(0);
				//boolean wasempty = tile.getContainerData().getFluidTank().getFluid() == null;
				IFluidHandlerItem item = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
				if(fluidinv.isnew){
					fluidinv.isnew = false;
					fluidinv.lastaction = item.getTankProperties()[0].getContents() == null ? 1 : -1;
				}
				if(item.getTankProperties().length > 0){
					if(fluidinv.lastaction == -1 && item.getTankProperties()[0].getContents() != null && item.getTankProperties()[0].getContents().amount > 0){
						FluidActionResult result = FluidUtil.tryEmptyContainer(stack, tile.getContainerData().getFluidHandler(), 1000, player, true);
						if(result.success){
							fluidinv.setInventorySlotContents(0, result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
					else if(fluidinv.lastaction == 1){
						FluidActionResult result = FluidUtil.tryFillContainer(stack, tile.getContainerData().getFluidHandler(), 1000, player, true);
						if(result.success){
							fluidinv.setInventorySlotContents(0, result.getResult() == null ? ItemStack.EMPTY : result.getResult());
						}
					}
					else{
						//
					}
				}
				if(!player.world.isRemote){
					tile.sendFluidTankUpdate(player);
				}
			}
			else{
				if(date + 50 <= Time.getDate()){
					date = Time.getDate();
					tile.sendFluidTankUpdate(player);
				}
			}
		}
		
	}
	
}