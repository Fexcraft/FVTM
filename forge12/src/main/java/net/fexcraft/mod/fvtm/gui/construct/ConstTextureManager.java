package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.BLANK_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.GENERIC_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.INPUT_1B_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.SWITCH_SEG;

import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureUser;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstTextureManager extends ConstGui {
	
	private ConstContainerTex contex;

	public ConstTextureManager(EntityPlayer player, World world, int x, int y, int z){
		super(new ConstContainerTex(player, world, x, y, z), player, x, y, z);
		help_url += "#texturemanager";
		contex = (ConstContainerTex) container;
	}
	
	@Override
	public void init(){
		super.init();
		String title = "part";
		if(contex.part == null){
			if(container.getTileEntity().getBlockData() != null) title = "block"; 
			if(container.getTileEntity().getContainerData() != null) title = "container"; 
			if(container.getTileEntity().getVehicleData() != null) title = "vehicle"; 
		}
		setMenuTitle("gui.fvtm.constructor.texture.menu_title_" + title);
		if(contex.part != null) menutitle.string = menutitle.string.replace("$0", contex.part);
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addElement(BLANK_SEG, "current_title", "gui.fvtm.constructor.texture.current", null);
		addElement(GENERIC_SEG, "current", "", null);
		addElement(EMPTY_SEG, "spacer0", null, null);
		addElement(BLANK_SEG, "supplied_title", "gui.fvtm.constructor.texture.supplied", null);
		addElement(SWITCH_SEG, "supplied", "", (button, mb) -> {
			try{
				TextureUser textur = getTextureUser();
				int i = textur.getSelectedTexture() + (button.name.endsWith("_1") ? 1 : -1);
				if(i >= textur.getTexHolder().getDefaultTextures().size() || i < 0){
					Print.debug("invalid id " + i);
					return;
				}
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "tm_supplied");
				if(contex.part != null) compound.setString("part", contex.part);
					compound.setInteger("value", i);
					titletext.update(REQUEST_SENT, RGB_CYAN.packed);
					container.send(Side.SERVER, compound);
					updateTexts();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			},
			ConstGuiElement.LEFT_ICON.asarray(ConstGuiElement.RIGHT_ICON),
			new String[]{ "gui.fvtm.constructor.button.prev", "gui.fvtm.constructor.button.next" }
		);
		addElement(EMPTY_SEG, "spacer1", null, null);
		addElement(BLANK_SEG, "internal_title", "gui.fvtm.constructor.texture.internal", null);
		addElement(INPUT_1B_SEG, "internal", "", (button, mb) -> {
			applyTex(button);
		}, ConstGuiElement.CONFIRM_ICON.asarray(), new String[]{"gui.fvtm.constructor.button.confirm"});
		addElement(EMPTY_SEG, "spacer2", null, null);
		addElement(BLANK_SEG, "external_title", "gui.fvtm.constructor.texture.external", null);
		addElement(INPUT_1B_SEG, "external", "", (button, mb) -> {
			applyTex(button);
		}, ConstGuiElement.CONFIRM_ICON.asarray(), new String[]{ "gui.fvtm.constructor.button.confirm" });
		finish_init();
		updateTexts();
	}

	private void applyTex(BasicButton button){
		boolean external = button.name.equals("external");
		String value = fields.get(external ? "external" : "internal").getText();
		if(value.length() < 10){
			titletext.update("gui.fvtm.constructor.invalid_input", RGB_ORANGE.packed);
			return;
		}
		if(!external){
			ResourceLocation resloc = new ResourceLocation(value);
			ITextureObject obj = Minecraft.getMinecraft().getTextureManager().getTexture(resloc);
			if(obj == null && !Minecraft.getMinecraft().getTextureManager().loadTexture(resloc, obj = new SimpleTexture(resloc))){
				titletext.update("gui.fvtm.constructor.texture.not_found_in_memory", RGB_ORANGE.packed);
				return;
			}
		}
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "tm_custom");
		if(contex.part != null) compound.setString("part", contex.part);
		compound.setString("value", value);
		compound.setBoolean("external", external);
		titletext.update(REQUEST_SENT, RGB_CYAN.packed);
		container.send(Side.SERVER, compound);
	}

	private TextureUser getTextureUser(){
		VehicleData vehdata = container.getTileEntity().getVehicleData();
		return contex.part == null ? container.hasVehicle() ? vehdata : container.hasBlock() ? container.entity.getBlockData() : container.entity.getContainerData() : vehdata.getPart(contex.part);
		
	}

	private void updateTexts(){
		TextureUser texus = getTextureUser();
		boolean sup = texus.getSelectedTexture() >= 0;
		BasicText current = texts.get("current");
		current.string = !sup ? ("gui.fvtm.constructor.texture.tex_" + (texus.isTextureExternal() ? "external" : "internal")) : "gui.fvtm.constructor.texture.tex_supplied";
		current.translate();
		if(sup){
			current.string += " : " + texus.getSelectedTexture();
		}
		texts.get("supplied").string = sup ? getName(texus.getCurrentTexture().local()) : "...";
		buttons.get("supplied_0").enabled = texus.getSelectedTexture() > 0;
		buttons.get("supplied_1").enabled = texus.getSelectedTexture() < texus.getTexHolder().getDefaultTextures().size() - 1;
		fields.get("internal").setText(!sup && !texus.isTextureExternal() ? texus.getCurrentTexture().toString() : "...");
		fields.get("external").setText(!sup && texus.isTextureExternal() ? texus.getCurrentTexture().toString() : "...");
	}

	private String getName(ResourceLocation current){
		if(current instanceof NamedResourceLocation) return ((NamedResourceLocation)current).getName();
		return current.toString();
	}

	@Override
	public void onClientPacket(NBTTagCompound nbt){
		updateTexts();
	}

}
