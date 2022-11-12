package net.fexcraft.mod.fvtm.gui.block;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;

public class GBlockInventory extends GenericGui<GBlockInvContainer> {
	
	private static final ResourceLocation texture_item = new ResourceLocation("fvtm:textures/gui/vehicle_item_inventory.png");
	private static final ResourceLocation texture_fluid = new ResourceLocation("fvtm:textures/gui/vehicle_fluid_inventory.png");
	
	public GBlockInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture_item, new GBlockInvContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		if(container.inventory.type.isFluid()){
			this.xSize = 176; this.ySize = 154;
			this.texloc = texture_fluid;
		}
		else if(container.inventory.type.isItem()){
			this.xSize = 248; this.ySize = 216; 
		}
		else player.closeScreen();
	}

	@Override
	protected void init(){
		if(container.inventory.type.isFluid()){
			texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, "FluidTank - " + container.inv_id));
			texts.put("info", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "[fluid info]"));
			texts.put("capacity", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "[capacity info]"));
		}
		else if(container.inventory.type.isItem()){
			texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 230, MapColor.SNOW.colorValue, container.tile.getBlockData().getType().getName() + " - " + container.inv_id));
			texts.put("page", new BasicText(guiLeft + 188, guiTop + 138, 40, MapColor.SNOW.colorValue, "1/" + (container.tile.getMultiBlockData().getInventory(container.inv_id).getStacks().size() / 78 + 1)));
			buttons.put("prev", new BasicButton("prev", guiLeft + 176, guiTop + 137, 176, 137, 10, 10, true));
			buttons.put("next", new BasicButton("next", guiLeft + 230, guiTop + 137, 230, 137, 10, 10, true));
		}
		else player.closeScreen();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.fluid_io != null){//assume we're in fluid mode
			FluidTank tank = container.tile.getMultiBlockData().getInventory(container.inv_id).getTank();
			String name = tank.getFluid() == null ? "no fluid" : tank.getFluid().getLocalizedName();
			texts.get("info").string = tank.getFluidAmount() == 0 ? "empty - " + name : name; 
			texts.get("capacity").string = tank.getFluidAmount() + "mB / " + tank.getCapacity() + "mB";
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(container.empty_index != -1){
			for(int y = 0; y < 6; y++){
				for(int x = 0; x < 13; x++){ if((x + y * 13) < container.empty_index) continue;
					drawTexturedModalRect(guiLeft + 7 + x * 18, guiTop + 21 + y * 18, 0, 238, 18, 18);
				}
			}
		}
		if(container.fluid_io != null){
			FluidTank tank = container.tile.getMultiBlockData().getInventory(container.inv_id).getTank();
			float percent = tank.getFluidAmount() * 1f / tank.getCapacity() * 100f;
			if(percent > 0) drawTexturedModalRect(guiLeft + 10, guiTop + 49, 0, 238, (int)percent, 18);
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
		if(!container.inventory.type.isItem()) return;
		container.page += i; if(container.page < 0) container.page = 0; container.populateSlots();
		texts.get("page").string = (container.page + 1) + "/" + (container.tile.getMultiBlockData().getInventory(container.inv_id).getStacks().size() / 78 + 1);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "inventory_page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}
	
}

