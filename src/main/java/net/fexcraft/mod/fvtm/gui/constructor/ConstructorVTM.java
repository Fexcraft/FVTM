package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.VehicleData;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

/** Vehicle Texture Manager*/
public class ConstructorVTM extends ConstructorGui {
	
	private IconButton next, prev;

	public ConstructorVTM(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Current:" , "||...", "", "||Supplied:", "", "", "||Internal:", "", "", "||External:", "", "", "< Back" };
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Vehicle Texture Management";
		this.buttons.put("next_supplied", next = new IconButton("next_supplied", 3, 0, false, ICON_RIGHT));
		this.buttons.put("prev_supplied", prev = new IconButton("prev_supplied", 3, 1, false, ICON_LEFT));
		this.buttons.put("in_apply", new IconButton("in_apply", 6, 0, false, ICON_RIGHT));
		this.buttons.put("ex_apply", new IconButton("ex_apply", 9, 0, false, ICON_RIGHT));
		this.cfields[4] = new TextField(4, fontRenderer, 2, 20 + (4 * buttonheight), xSize - 4, 10);
		this.cfields[7] = new TextField(7, fontRenderer, 2, 20 + (7 * buttonheight), xSize - 4, 10).setMaxLength(1024);
		this.cfields[10] = new TextField(10, fontRenderer, 2, 20 + (10 * buttonheight), xSize - 4, 10).setMaxLength(1024);
		this.fields.put("field4", cfields[4]); this.fields.put("field7", cfields[7]); this.fields.put("field10", cfields[10]);
		VehicleData data = container.getTileEntity().getVehicleData();
		cfields[ 7].setText(data == null ? "no data" :  data.isExternalTexture() ? "" : data.getCustomTextureString());
		cfields[10].setText(data == null ? "no data" : !data.isExternalTexture() ? "" : data.getCustomTextureString());
	}
	
	private void updateIconsAndButtons(){
		VehicleData data = container.getTileEntity().getVehicleData();
		tbuttons[1].string = data.getSelectedTexture() < 0 ? data.isExternalTexture() ? "external" : "internal" : "supplied:" + data.getSelectedTexture();
		cfields[4].setText(data.getSelectedTexture() < 0 ? " - - - - " : data.getType().getDefaultTextures().get(data.getSelectedTexture()).toString());
		prev.enabled = data.getSelectedTexture() > 0; next.enabled = !(data.getSelectedTexture() >= data.getType().getDefaultTextures().size());
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		this.updateIconsAndButtons();
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button12")) this.openGui(modid, 900, xyz);
		else if(button.name.endsWith("_supplied")){
			VehicleData data = container.getTileEntity().getVehicleData();
			int i = data.getSelectedTexture() + (button.name.startsWith("next") ? 1 : -1);
			if(i >= data.getType().getDefaultTextures().size() || i < 0){
				Print.debug("invalid id " + i); return true;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "vtm_supplied");
			compound.setInteger("value", i);
			this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
			this.container.send(Side.SERVER, compound); return true;
		}
		else if(button.name.endsWith("_apply")){
			boolean external = button.name.startsWith("ex");
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "vtm_custom");
			compound.setString("value", external ? cfields[10].getText() : cfields[7].getText());
			compound.setBoolean("external", external);
			this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
			this.container.send(Side.SERVER, compound); return true;
		}
		else Print.debug("function not found");
		return true;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
}
