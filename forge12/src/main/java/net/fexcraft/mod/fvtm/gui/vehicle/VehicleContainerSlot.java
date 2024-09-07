package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleContainerSlot extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_containerslot.png");
	//
	private Integer coverx;
	private int covery, coversx, coversy;

	public VehicleContainerSlot(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this; this.xSize = 230; this.ySize = 144;
	}

	@Override
	protected void init(){
		String string = container.slot.onlytype == null ? null : container.slot.onlytype.name();
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 212, MapColor.SNOW.colorIndex, container.slotid + " / [" + container.slot.length + "]" + (string == null ? "" : " / " + string)));
		if(container.slot.length < 12){
			coverx = guiLeft + 7 + (18 * container.slot.length); covery = guiTop + 21;
			coversx = (12 - container.slot.length) * 18; coversy = 18;
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(coverx != null){ drawTexturedModalRect(coverx, covery, 0, 238, coversx, coversy); } int count = -1;
		for(ItemStack stack : container.slotInv.getArray()){
			count++; if(stack == null || stack.isEmpty()) continue;
			ContainerData data = stack.getCapability(Capabilities.VAPDATA, null).getContainerData();
			data.getContainerType().getRGB().glColorApply();
			drawTexturedModalRect(guiLeft + 7 + (18 * count), guiTop + 39, 7 + (18 * count), 39, 18 * data.getContainerType().length(), 18);
			RGB.glColorReset();
			if(data.getContainerType().length() > 1){
				for(int i = 1; i < data.getContainerType().length(); i++){
					drawTexturedModalRect(guiLeft + 7 + (18 * (i + count)), guiTop + 21, 0, 220, 18, 18);
				}
			}
		}
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

