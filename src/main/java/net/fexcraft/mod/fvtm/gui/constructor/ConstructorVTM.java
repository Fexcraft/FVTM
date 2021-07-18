package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

/** Vehicle Texture Manager*/
public class ConstructorVTM extends ConstructorGui {

	//private Textureable textur;
	private IconButton next, prev;

	public ConstructorVTM(EntityPlayer player, World world, int x, int y, int z){
		super(new ConstructorContainerVTM(player, world, x, y, z), player, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||gui.fvtm.constructor.texture.current" , "||...", "", "||gui.fvtm.constructor.texture.supplied",
			"", "", "||gui.fvtm.constructor.texture.internal",
			"", "", "||gui.fvtm.constructor.texture.external",
			"", "", "gui.fvtm.constructor.back" };
	}
	
	private String part(){
		return ((ConstructorContainerVTM)container).part;
	}
	
	@Override
	public void init(){
		super.init();
		String title = "part";
		if(part() == null){
			if(container.getTileEntity().getBlockData() != null) title = "block"; 
			if(container.getTileEntity().getContainerData() != null) title = "container"; 
			if(container.getTileEntity().getVehicleData() != null) title = "vehicle"; 
		}
		this.menutitle.string = "gui.fvtm.constructor.texture.menu_title_" + title;
		this.menutitle.translate();
		if(part() != null) menutitle.string = menutitle.string.replace("$0", part());
		Textureable textur = getTextureable();
		this.buttons.put("next_supplied", next = new IconButton("next_supplied", 3, 0, false, ICON_RIGHT));
		this.buttons.put("prev_supplied", prev = new IconButton("prev_supplied", 3, 1, false, ICON_LEFT));
		this.buttons.put("in_apply", new IconButton("in_apply", 6, 0, false, ICON_RIGHT));
		this.buttons.put("ex_apply", new IconButton("ex_apply", 9, 0, false, ICON_RIGHT));
		this.cfields[4] = new TextField(4, fontRenderer, 2, 20 + (4 * buttonheight), xSize - 4, 10);
		this.cfields[7] = new TextField(7, fontRenderer, 2, 20 + (7 * buttonheight), xSize - 4, 10).setMaxLength(1024);
		this.cfields[10] = new TextField(10, fontRenderer, 2, 20 + (10 * buttonheight), xSize - 4, 10).setMaxLength(1024);
		this.fields.put("field4", cfields[4]); this.fields.put("field7", cfields[7]); this.fields.put("field10", cfields[10]);
		//
		cfields[ 7].setText(textur == null ? "no data" :  textur.isExternalTexture() ? "" : textur.getCustomTextureString());
		cfields[10].setText(textur == null ? "no data" : !textur.isExternalTexture() ? "" : textur.getCustomTextureString());
	}
	
	private Textureable getTextureable(){
		VehicleData vdata = container.getTileEntity().getVehicleData();
		ContainerData condata = container.getTileEntity().getContainerData();
		return part() == null ? vdata == null ? condata == null ? container.getTileEntity().getBlockData() : condata : vdata : vdata.getPart(part());
	}

	private void updateIconsAndButtons(){
		Textureable textur = getTextureable();
		if(textur.getSelectedTexture() < 0){
			tbuttons[1].string = "gui.fvtm.constructor.texture.tex_" + (textur.isExternalTexture() ? "external" : "internal");
			tbuttons[1].translate();
			cfields[4].setText(" - - - - ");
		}
		else{
			tbuttons[1].string = "gui.fvtm.constructor.texture.tex_supplied";
			tbuttons[1].translate();
			tbuttons[1].string += ":" + textur.getSelectedTexture();
			cfields[4].setText(textur.getHolder().getDefaultTextures().get(textur.getSelectedTexture()).getName());
		}
		prev.enabled = textur.getSelectedTexture() > 0;
		next.enabled = textur.getSelectedTexture() < textur.getHolder().getDefaultTextures().size() - 1;
	}
	
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		this.updateIconsAndButtons();
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button12")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		else if(button.name.endsWith("_supplied")){
			Textureable textur = getTextureable();
			int i = textur.getSelectedTexture() + (button.name.startsWith("next") ? 1 : -1);
			if(i >= textur.getHolder().getDefaultTextures().size() || i < 0){
				Print.debug("invalid id " + i);
				return true;
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "vtm_supplied");
			if(part() != null) compound.setString("part", part());
			compound.setInteger("value", i);
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else if(button.name.endsWith("_apply")){
			boolean external = button.name.startsWith("ex");
			String value = external ? cfields[10].getText() : cfields[7].getText();
			if(value.length() < 10){
				this.titletext.update("gui.fvtm.constructor.invalid_input", RGB_ORANGE.packed);
				return true;
			}
			if(!external){
				ResourceLocation resloc = new ResourceLocation(value);
				ITextureObject obj = Minecraft.getMinecraft().getTextureManager().getTexture(resloc);
				if(obj == null && !Minecraft.getMinecraft().getTextureManager().loadTexture(resloc, obj = new SimpleTexture(resloc))){
					this.titletext.update("gui.fvtm.constructor.texture.not_found_in_memory", RGB_ORANGE.packed);
					return true;
				}
			}
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "vtm_custom");
			if(part() != null) compound.setString("part", part());
			compound.setString("value", value);
			compound.setBoolean("external", external);
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
			return true;
		}
		else Print.debug("function not found");
		return true;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
}
