package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.fexcraft.lib.common.math.RGB;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorPartCacheInfo extends ConstructorGui {

	public ConstructorPartCacheInfo(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||gui.fvtm.constructor.part_cache.name", "",
			"gui.fvtm.constructor.part_cache.attributes", "gui.fvtm.constructor.part_cache.functions",
			"gui.fvtm.constructor.part_cache.textures", "gui.fvtm.constructor.part_cache.install_info",
			"gui.fvtm.constructor.part_cache.eject", "", "gui.fvtm.constructor.back" };
	}
	
	@Override
	public void init(){
		super.init();
		this.menutitle.string = "gui.fvtm.constructor.part_cache.menu_title";
		this.menutitle.translate();
		this.container.setTitleText(container.getTileEntity().getPartData() == null ? "gui.fvtm.constructor.no_cache_title" : container.getTileEntity().getPartData().getType().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		String string = container.getTileEntity() == null ? "gui.fvtm.constructor.no_const" : container.getTileEntity().getPartData() == null ?
			"gui.fvtm.constructor.no_cache" : container.getTileEntity().getPartData().getType().getName();
		this.cfields[1].setText(I18n.format(string)); this.fields.put("field2", cfields[1]);
	}
	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button8")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		if(container.getTileEntity().getPartData() == null){
			container.setTitleText("gui.fvtm.constructor.no_cache_title", RGB_ORANGE.packed);
		}
		if(button.name.equals("button2")){
			openGui(913, xyz, LISTENERID);//TODO
		}
		else if(button.name.equals("button3")){
			openGui(912, xyz, LISTENERID);//TODO
		}
		else if(button.name.equals("button4")){
			openGui(911, xyz, LISTENERID);//TODO
		}
		else if(button.name.equals("button5")){
			openGui(910, xyz, LISTENERID);//TODO
		}
		else if(button.name.equals("button6")){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "part_cache_drop");
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
			this.container.send(Side.SERVER, compound);
			openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	@Override
	public void onTitleTextUpdate(){
		//
	}

}
