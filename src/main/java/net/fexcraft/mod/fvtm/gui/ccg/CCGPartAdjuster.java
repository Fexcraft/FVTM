package net.fexcraft.mod.fvtm.gui.ccg;

import java.io.IOException;

import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class CCGPartAdjuster extends GenericGui<CCGPartAdjuster.Container> {
	
	private int[] pos; //private int scroll;

	public CCGPartAdjuster(EntityPlayer player, int[] args, NBTTagCompound compound){
		super(new ResourceLocation("fvtm:textures/guis/ccg_part_adjuster.png"), new Container(player, args, compound), player);
		this.xSize = 200; this.ySize = 45; this.pos = args;
		this.defbackground = false; this.deftexrect = false;
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(13, 4, 112, null, "..."));
		this.fields.put("xpos", new GuiTextField(0, fontRenderer, 39, 20, 46, 10));
		this.fields.put("ypos", new GuiTextField(1, fontRenderer, 95, 20, 46, 10));
		this.fields.put("zpos", new GuiTextField(2, fontRenderer, 151, 20, 46, 10));
		PartData part = container.tile.getPartData();
		fields.get("xpos").setText(part == null ? "no part" : part.getCurrentOffset().x + "");
		fields.get("ypos").setText(part == null ? "no part" : part.getCurrentOffset().y + "");
		fields.get("zpos").setText(part == null ? "no part" : part.getCurrentOffset().z + "");
		//
		this.buttons.put("texture", new BasicButton("textures", 3, 32, 3, 32, 47, 10, true));
		this.texts.put("texture", new BasicText(5, 33, 43, null, "Texture"));
		//
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		texts.get("title").string = container.part == null ? container.tile.getPartData() == null ? "no part in constructor" : container.tile.getPartData().getPart().getName() : container.tile.getVehicleData() == null ? "no vehicle" : container.tile.getVehicleData().getPart(container.part) == null ? "no such part in vehicle" : container.tile.getVehicleData().getPart(container.part).getPart().getName();
		buttons.get("texture").enabled = container.part != null;
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "texture":{
				if(container.part != null){
					NBTTagCompound compound = new NBTTagCompound(); compound.setString("part", container.part);
					this.openGenericGui(GuiHandler.CCG_TextureManager, pos, compound);
				}
				else {
					Print.chat(player, "Cannot edit textures of loose parts.");
				}
				break;
			}
		}
	}
	
	public static class Container extends GenericGuiContainer {
		
		private String part;
		private ConstructorControllerEntity tile;
		
		public Container(EntityPlayer player, int[] arr, NBTTagCompound compound){
			tile = (ConstructorControllerEntity)player.world.getTileEntity(new BlockPos(arr[0], arr[1], arr[2]));
			part = compound.hasKey("part") ? compound.getString("part") : null;
		}
		
		public PartData partdata(){
			return part == null ? tile.getPartData() : tile.getVehicleData() == null ? null : tile.getVehicleData().getPart(part);
		}

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			//
		}
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1){
        	if(container.part == null){
        		this.openGui(GuiHandler.CCG_Main, pos);
        	}
        	else{
				this.openGui(GuiHandler.CCG_PartManager, pos);
        	}
        }
        super.keyTyped(typedChar, keyCode);
    }
	
}