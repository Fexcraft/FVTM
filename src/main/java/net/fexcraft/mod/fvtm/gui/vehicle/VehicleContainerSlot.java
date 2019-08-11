package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class VehicleContainerSlot extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_containerslot.png");
	private ContainerSlot slot;
	private String slotid;
	private Entity entity;
	//
	private Integer coverx;
	private int covery, coversx, coversy;

	public VehicleContainerSlot(EntityPlayer player, int[] xyz, NBTTagCompound compound){
		super(texture, new VehicleContainer(player, xyz, compound), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this; this.xSize = 230; this.ySize = 144;
		entity = player.world.getEntityByID(xyz[0]); slotid = compound.getString("container");
		slot = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlot(slotid);
	}

	@Override
	protected void init(){
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 212, MapColor.SNOW.colorIndex, slotid + " / [" + slot.length + "]"));
		if(slot.length < 12){
			coverx = guiLeft + 7 + (18 * slot.length); covery = guiTop + 21;
			coversx = (12 - slot.length) * 18; coversy = 38;
		}
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(coverx != null){ drawTexturedModalRect(coverx, covery, 0, 218, coversx, coversy); }
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

