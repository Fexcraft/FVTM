package net.fexcraft.mod.fvtm.gui.container;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ContainerItemInventory extends GenericGui<ContainerInvContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/vehicle_item_inventory.png");
	
	public ContainerItemInventory(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new ContainerInvContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 216;
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 230, MapColor.SNOW.colorValue, container.tile.getContainerData().getType().getName()));
		texts.put("page", new BasicText(guiLeft + 188, guiTop + 138, 40, MapColor.SNOW.colorValue, "1/" + (container.tile.getContainerData().getInventory().getStacks().size() / 78 + 1)));
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
				for(int x = 0; x < 13; x++){
					if((x + y * 13) < container.empty_index) continue;
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
		texts.get("page").string = (container.page + 1) + "/" + (container.tile.getContainerData().getInventory().getStacks().size() / 78 + 1);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "inventory_page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}
	
}

