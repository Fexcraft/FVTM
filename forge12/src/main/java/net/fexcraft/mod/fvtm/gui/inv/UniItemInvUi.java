package net.fexcraft.mod.fvtm.gui.inv;

import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.inv.StackEntry;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class UniItemInvUi extends GenericGui<UniItemInvContainer> {
	
	private static final ResourceLocation texture_item = new ResourceLocation("fvtm:textures/gui/inventory_item.png");
	
	public UniItemInvUi(EntityPlayer player, World world, int ID, int x, int y, int z){
		super(texture_item, new UniItemInvContainer(player, world, ID, x, y, z), player);
		defbackground = deftexrect = true;
		this.xSize = 248; this.ySize = 227;
		container.gui = this;
		sendPageUpdate();
	}

	@Override
	protected void init(){
		texts.put("top", new BasicText(guiLeft + 9, guiTop + 9, 230, MapColor.SNOW.colorValue, container.title).autoscale());
		texts.put("page", new BasicText(guiLeft + 177, guiTop + 164, 64, MapColor.SNOW.colorValue, "").autoscale());
		for(int i = 0; i < 6; i++){
			texts.put("name" + i, new BasicText(guiLeft + 47, guiTop + 22 + (i * 20), 192, MapColor.SNOW.colorValue, "").autoscale());
			texts.put("info" + i, new BasicText(guiLeft + 47, guiTop + 31 + (i * 20), 192, MapColor.SNOW.colorValue, "").autoscale());
		}
		buttons.put("insert", new BasicButton("insert", guiLeft + 195, guiTop + 144, 195, 144, 14, 14, true){
			@Override
			public boolean onclick(int mx, int my, int b){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "insert_stack");
				container.send(Side.SERVER, compound);
				return true;
			}
		});
		buttons.put("prev", new BasicButton("prev", guiLeft + 211, guiTop + 144, 211, 144, 14, 14, true){
			@Override
			public boolean onclick(int mx, int my, int b){
				updatePage(-1); 
				return true;
			}
		});
		buttons.put("next", new BasicButton("next", guiLeft + 227, guiTop + 144, 227, 144, 14, 14, true){
			@Override
			public boolean onclick(int mx, int my, int b){
				updatePage(1); 
				return true;
			}
		});
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		int size = container.invhandler.getStacks().size();
		for(int row = 0; row < 6; row++){
			int index = (container.page * 6) + row;
			if(index >= size){
				texts.get("name" + row).string = "";
				texts.get("info" + row).string = "";
				continue;
			}
			StackEntry entry = container.invhandler.getStacks().get(index);
			texts.get("name" + row).string = entry.stack.getName();
			texts.get("info" + row).string = entry.amount + " items    " + entry.stacksize() + " stacks";
		}
		size = 0;
		for(StackEntry entry : container.invhandler.getStacks()){
			size += entry.stacksize();
		}
		texts.get("page").string = (container.page + 1) + "/" + (container.invhandler.getStacks().size() / 6 + 1) + "p   ";
		texts.get("page").string += size + "/" + container.invhandler.capacity() + "c";
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		int size = container.invhandler.getStacks().size();
		for(int row = 0; row < 6; row++){
			int index = (container.page * 6) + row;
			if(index < size) continue;
			drawTexturedModalRect(guiLeft + 6, guiTop + 20 + (row * 20), 0, 236, 236, 20);
		}
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		updatePage(am > 0 ? 1 : -1);
	}
	
	private void updatePage(int i){
		container.page += i;
		if(container.page < 0) container.page = 0;
		sendPageUpdate();
	}

	private void sendPageUpdate(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "inventory_page");
		compound.setInteger("page", container.page);
		this.container.send(Side.SERVER, compound);
	}
	
}

