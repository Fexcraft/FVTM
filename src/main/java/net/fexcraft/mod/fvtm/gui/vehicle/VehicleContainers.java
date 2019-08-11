package net.fexcraft.mod.fvtm.gui.vehicle;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VehicleContainers extends GenericGui<VehicleContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_inventories.png");
	private RGB[] colors = new RGB[8];
	private String[] inv_names;
	private Entity entity;
	private int page;

	public VehicleContainers(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new VehicleContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this; this.xSize = 194; this.ySize = 134;
		entity = world.getEntityByID(x); inv_names = entity.getCapability(Capabilities.CONTAINER, null).getContainerSlotIds();
		for(int i = 0; i < 8; i++) colors[i] = InventoryType.CONTAINER.getColor();
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 7, guiTop + 6, 162, MapColor.SNOW.colorValue, "Container Slots [-/-]"));
		for(int i = 0; i < 8; i++){
			texts.put("row" + i, new BasicText(guiLeft + 9, guiTop + 19 + (i * 14), 162, MapColor.SNOW.colorValue, "<---->"));
			buttons.put("inv" + i, new BasicButton("inv" + i, guiLeft + 7, guiTop + 17 + (i * 14), 7, 17, 166, 12, true));
		}
		buttons.put("prev", new BasicButton("prev", guiLeft + 171, guiTop + 6, 171, 6, 8, 8, true));
		buttons.put("next", new BasicButton("next", guiLeft + 180, guiTop + 6, 180, 6, 8, 8, true));
		this.updatePage(0);
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		for(int i = 0; i < 8; i++){
			colors[i].glColorApply();
			drawTexturedModalRect(guiLeft + 175, guiTop + 17 + (14 * i), 175, 17 + (14 * i), 12, 12);
			RGB.glColorReset();
		}
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("prev")){ updatePage(-1); return true; }
		if(button.name.equals("next")){ updatePage( 1); return true; }
		if(button.name.startsWith("inv")){
			int i = Integer.parseInt(button.name.replace("inv", ""));
			if(i < 0 || (i + (page * 8)) >= inv_names.length) return true;
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("container", inv_names[i + (page * 8)]);
			openGenericGui(938, new int[]{ entity.getEntityId(), 0, 0 }, compound);
			return true;
		}
		return false;
	}
	
	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? -1 : 1);
	}

	private void updatePage(int i){
		page += i; if(page < 0) page = 0;
		texts.get("top").string = String.format("Container Slots [%s/%s]", page + 1, inv_names.length / 8 + 1);
		for(int j = 0; j < 8; j++){ int k = j + (page * 8); boolean bool = k >= inv_names.length;
			texts.get("row" + j).string = bool ? "" : inv_names[k];buttons.get("inv" + j).enabled = !bool;
		}
	}
	
}

