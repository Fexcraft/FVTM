package net.fexcraft.mod.fvtm.gui.container;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;

public class ContainerFluidInventory extends GenericGui<ContainerInvContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_fluid_inventory.png");
	
	public ContainerFluidInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new ContainerInvContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 176; this.ySize = 154;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, container.tile.getContainerData().getType().getName()));
		texts.put("info", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "[fluid info]"));
		texts.put("capacity", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "[capacity info]"));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		FluidTank tank = container.tile.getContainerData().getInventory().getTank();
		String name = tank.getFluid() == null ? "no fluid" : tank.getFluid().getLocalizedName();
		texts.get("info").string = tank.getFluidAmount() == 0 ? "empty - " + name : name; 
		texts.get("capacity").string = tank.getFluidAmount() + "mB / " + tank.getCapacity() + "mB";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		float percent = container.tank.getFluidAmount() * 1f / container.tank.getCapacity() * 100f;
		if(percent > 0) drawTexturedModalRect(guiLeft + 10, guiTop + 49, 0, 238, (int)percent, 18);
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

