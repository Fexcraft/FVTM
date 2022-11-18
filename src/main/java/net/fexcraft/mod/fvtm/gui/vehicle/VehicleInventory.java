package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;

public class VehicleInventory extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture_item = new ResourceLocation("fvtm:textures/gui/vehicle_item_inventory.png");
	private static final ResourceLocation texture_fluid = new ResourceLocation("fvtm:textures/gui/vehicle_fluid_inventory.png");
	private String empty, no_fluid;
	
	public VehicleInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture_item, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true;
		this.deftexrect = true;
		container.gui = this;
		if(container.function.inventory().type.isFluid()){
			this.xSize = 176;
			this.ySize = 154;
			this.texloc = texture_fluid;
		}
		else player.closeScreen();
		no_fluid = I18n.format("gui.fvtm.vehicle.inventory.no_fluid");
		empty = I18n.format("gui.fvtm.vehicle.inventory.empty");
	}

	@Override
	protected void init(){
		if(container.function.inventory().type.isFluid()){
			texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, I18n.format("gui.fvtm.vehicle.inventory.fluid_tank") + " - " + container.inv_id));
			texts.put("info", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "[fluid info]"));
			texts.put("capacity", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "[capacity info]"));
		}
		else player.closeScreen();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		if(container.fluid_io != null){//assume we're in fluid mode
			FluidTank tank = container.function.inventory().getTank();
			String name = tank.getFluid() == null ? no_fluid : tank.getFluid().getLocalizedName();
			texts.get("info").string = tank.getFluidAmount() == 0 ? empty + " - " + name : name; 
			texts.get("capacity").string = tank.getFluidAmount() + "mB / " + tank.getCapacity() + "mB";
		}
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(container.fluid_io != null){
			float percent = container.function.inventory().getTank().getFluidAmount() * 1f / container.function.inventory().getTank().getCapacity() * 100f;
			if(percent > 0) drawTexturedModalRect(guiLeft + 10, guiTop + 49, 0, 238, (int)percent, 18);
		}
	}
	
}

