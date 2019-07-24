package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.sys.legacy.SeatEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleInventory extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_item_inventory.png");
	//private VehicleEntity veh;

	public VehicleInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 216;
		if(!player.isRiding() || player.getRidingEntity() instanceof SeatEntity == false){ player.closeScreen(); return; }
	}

	@Override
	protected void init(){
		//
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		//
		return false;
	}
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
}

