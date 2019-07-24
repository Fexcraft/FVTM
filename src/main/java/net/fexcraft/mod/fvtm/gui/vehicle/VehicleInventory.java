package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

public class VehicleInventory extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture_item = new ResourceLocation("fvtm:textures/gui/vehicle_item_inventory.png");
	private static final ResourceLocation texture_fluid = new ResourceLocation("fvtm:textures/gui/vehicle_fluid_inventory.png");

	/*public VehicleInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 216;
		if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
		SeatEntity ent = (SeatEntity)player.getRidingEntity(); veh = ent.getVehicle();
		//
	}*/
	
	public VehicleInventory(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(texture_item, new VehicleContainer(player, xyz, compound), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this; this.xSize = 248; this.ySize = 216;
		if(container.function.isInventoryType(InventoryType.FLUID)){ this.texloc = texture_fluid; }
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 230, MapColor.SNOW.colorValue, container.veh.getVehicleData().getType().getName() + " - " + container.inv_id));
		texts.put("page", new BasicText(guiLeft + 188, guiTop + 138, 40, MapColor.SNOW.colorValue, "1/" + (container.function.getStacks().size() / 78 + 1)));
		buttons.put("prev", new BasicButton("prev", guiLeft + 176, guiTop + 137, 176, 137, 10, 10, true));
		buttons.put("next", new BasicButton("next", guiLeft + 230, guiTop + 137, 230, 137, 10, 10, true));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(container.empty_index != -1){
			for(int y = 0; y < 6; y++){
				for(int x = 0; x < 13; x++){ if((x + y * 12) < container.empty_index) continue;
					drawTexturedModalRect(guiLeft + 7 + x * 18, guiTop + 21 + y * 18, 0, 238, 18, 18);
				}
			}
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){ updatePage(-1); return true; }
		if(button.name.equals("next")){ updatePage( 1); return true; }
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? -1 : 1);
	}
	
	private void updatePage(int i){
		container.page += i; if(container.page < 0) container.page = 0; container.populateSlots();
		texts.get("page").string = (container.page + 1) + "/" + (container.function.getStacks().size() / 78 + 1);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "inventory_page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}
	
}

