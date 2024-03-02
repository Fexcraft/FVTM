package net.fexcraft.mod.fvtm.gui.inv;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTank;

public class UniFluidInvUi extends GenericGui<UniFluidInvContainer> {
	
	private static final ResourceLocation texture_fluid = new ResourceLocation("fvtm:textures/gui/inventory_fluid.png");
	
	public UniFluidInvUi(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(texture_fluid, new UniFluidInvContainer(player, world, ID, x, y, z), player);
		defbackground = deftexrect = true;
		this.xSize = 176; this.ySize = 154;
		container.gui = this;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 158, MapColor.SNOW.colorValue, container.title).autoscale());
		texts.put("info", new BasicText(guiLeft + 9, guiTop + 23, 158, MapColor.SNOW.colorValue, "[fluid info]").autoscale());
		texts.put("capacity", new BasicText(guiLeft + 9, guiTop + 37, 158, MapColor.SNOW.colorValue, "[capacity info]").autoscale());
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		FluidTank tank = container.invhandler.getTank();
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
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

