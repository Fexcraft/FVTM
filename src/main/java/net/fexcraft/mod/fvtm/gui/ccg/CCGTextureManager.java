package net.fexcraft.mod.fvtm.gui.ccg;

import java.io.IOException;

import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.root.Textureable;
import net.fexcraft.mod.fvtm.blocks.ConstructorControllerEntity;
import net.fexcraft.mod.fvtm.gui.GenericGui;
import net.fexcraft.mod.fvtm.gui.GenericGuiContainer;
import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class CCGTextureManager extends GenericGui<CCGTextureManager.Container> {
	
	private int[] pos;

	public CCGTextureManager(EntityPlayer player, int[] arr, NBTTagCompound compound){
		super(new ResourceLocation("fvtm:textures/guis/ccg_textures.png"), new Container(player, arr, compound), player);
		this.xSize = 200; this.ySize = 68; this.pos = arr;
		this.deftexrect = false; this.defbackground = false;
	}

	@Override
	protected void init(){
		this.texts.put("title", new BasicText(13, 4, 182, null, container.part != null ? "P: " : "VC: "));
		this.texts.get("title").string += container.part == null ? container.textureable() instanceof ContainerData ? ((ContainerData)container.textureable()).getContainer().getName() : ((VehicleData)container.textureable()).getVehicle().getName() : "[" + container.part + "] " + ((PartData)container.textureable()).getPart().getName();
		//
		this.buttons.put("prev", new BasicButton("prev", 175, 19, 175, 19, 10, 10, true));
		this.buttons.put("next", new BasicButton("next", 187, 19, 187, 19, 10, 10, true));
		//
		this.buttons.put("in_apply", new BasicButton("ia", 187, 31, 187, 31, 10, 10, true));
		this.buttons.put("in_reset", new BasicButton("ir", 175, 31, 175, 31, 10, 10, true));
		//
		this.buttons.put("ex_apply", new BasicButton("ea", 187, 43, 187, 43, 10, 10, true));
		this.buttons.put("ex_reset", new BasicButton("er", 175, 43, 175, 43, 10, 10, true));
		this.buttons.values().forEach(button -> button.rgb_hover = new RGB(143, 244, 66));
		//
		this.fields.put("supplied", new GuiTextField(0, fontRenderer, 11, 19, 162, 10));
		this.fields.put("internal", new GuiTextField(1, fontRenderer, 11, 31, 162, 10));
		this.fields.put("external", new GuiTextField(2, fontRenderer, 11, 43, 162, 10));
		//fields.get("supplied").setEnabled(false);
		fields.values().forEach(elm -> elm.setMaxStringLength(1024)); this.updateTexts();
		//
		this.texts.put("status", new BasicText(13, 56, 83, null, "..."));
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		buttons.get("prev").enabled = container.textureable().getSelectedTexture() > 0;
		buttons.get("next").enabled = container.textureable().getSelectedTexture() < container.textureable().getTextureHolder().getTextures().size();
		texts.get("status").string = "CR: " + (container.textureable().getSelectedTexture() >= 0 ? (container.textureable().getSelectedTexture() + 1) + " / " + container.textureable().getTextureHolder().getTextures().size() : container.textureable().isTextureExternal() ? "external" : "internal");
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		this.drawTexturedModalRect(0, 0, 0, 0, this.xSize, this.ySize);
	}
	
	private void updateTexts(){
		fields.get("supplied").setText(container.textureable().getSelectedTexture() >= 0 ? container.textureable().getTextureHolder().getTextures().get(container.textureable().getSelectedTexture()).toString() : "none");
		fields.get("internal").setText(container.textureable().isTextureExternal() ? "none" : container.textureable().getCustomTexture().toString());
		fields.get("external").setText(container.textureable().isTextureExternal() ? container.textureable().getCustomTexture().toString() : "none");
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		switch(key){
			case "prev": case "next": {
				int i = container.textureable().getSelectedTexture() + (key.equals("next") ? 1 : -1);
				i = i < 0 ? 0 : i >= container.textureable().getTextureHolder().getTextures().size() ? container.textureable().getTextureHolder().getTextures().size() - 1 : i;
				NBTTagCompound compound = new NBTTagCompound();
		        compound.setIntArray("pos", pos);
		        compound.setString("cargo", "supplied_set");
		        compound.setInteger("data", i);
		        this.container.send(Side.SERVER, compound);
		        container.textureable().setSelectedTexture(i);
		        break;
			}
			case "in_reset": { fields.get("internal").setText(container.textureable().isTextureExternal() ? "none" : container.textureable().getCustomTexture().toString()); break; }
			case "ex_reset": { fields.get("external").setText(container.textureable().isTextureExternal() ? container.textureable().getCustomTexture().toString() : "none"); break; }
			case "in_apply": case "ex_apply": {
		        NBTTagCompound compound = new NBTTagCompound();
		        compound.setIntArray("pos", pos);
		        compound.setString("cargo", "custom_set");
		        compound.setBoolean("external", key.equals("ex_apply"));
		        compound.setString("data", key.equals("in_apply") ? fields.get("internal").getText() : fields.get("external").getText());
		        this.container.send(Side.SERVER, compound);
		        //
		        container.textureable().setSelectedTexture(-1);
		        container.textureable().setCustomTexture(key.equals("in_apply") ? fields.get("internal").getText() : fields.get("external").getText(), key.equals("ex_apply"));
				break;
			}
		}
		this.updateTexts();
	}
	
	public static class Container extends GenericGuiContainer {

		private String part;
		private ConstructorControllerEntity tile;

		public Container(EntityPlayer player, int[] arr, NBTTagCompound compound){
			part = compound.hasKey("part") ? compound.getString("part") : null;
			tile = (ConstructorControllerEntity)player.world.getTileEntity(new BlockPos(arr[0], arr[1], arr[2]));
		}

		@Override
		protected void packet(Side side, NBTTagCompound packet, EntityPlayer player){
			if(side.isClient()) return;
			if(!packet.hasKey("cargo")) return;
			switch(packet.getString("cargo")){
				case "supplied_set":{
					textureable().setSelectedTexture(packet.getInteger("data"));
					break;
				}
				case "custom_set":{
					String data = packet.getString("data");
					if(data.replace(" ", "").length() == 0) return;
					textureable().setCustomTexture(data, packet.getBoolean("external"));
					textureable().setSelectedTexture(-1);
					break;
				}
			}
			tile.sendUpdate(part != null ? "partdata" : tile.getTextureable() instanceof ContainerData ? "containerdata" : "vehicledata");
		}
		
		private Textureable textureable(){
			return part != null ? tile.getVehicleData() == null ? null : tile.getVehicleData().getPart(part) : tile.getTextureable();
		}
		
	}
	
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(keyCode == 1){
        	if(container.part == null){
        		this.openGui(GuiHandler.CCG_Main, pos);
        	}
        	else{
				NBTTagCompound compound = new NBTTagCompound(); compound.setString("part", container.part);
				this.openGenericGui(GuiHandler.CCG_PartAdjuster, pos, compound);
        	}
        }
        super.keyTyped(typedChar, keyCode);
    }
	
}