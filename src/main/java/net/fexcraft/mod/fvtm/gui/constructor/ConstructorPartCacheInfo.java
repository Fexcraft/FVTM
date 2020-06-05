package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorPartCacheInfo extends ConstructorGui {

	public ConstructorPartCacheInfo(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Name:", "", "Attributes", "Functions", "Def. Textures", "Install Info", "Eject", "", "< Back" };
	}
	
	@Override
	public void init(){
		super.init();
		this.menutitle.string = "Part Data Overview (CACHE)";
		this.container.setTitleText(container.getTileEntity().getPartData() == null ? "No Part in Constructor Cache." : container.getTileEntity().getPartData().getType().getName(), RGB.WHITE.packed);
		this.cfields[1] = new TextField(2, fontRenderer, 2, 20 + buttonheight, xSize - 4, 10);
		String string = container.getTileEntity() == null ? "Const.Offline" : container.getTileEntity().getPartData() == null ?
			"Cache Empty" : container.getTileEntity().getPartData().getType().getName();
		this.cfields[1].setText(string); this.fields.put("field2", cfields[1]);
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
			container.setTitleText("No Part in Constructor Cache.", RGB.RED.packed);
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
			this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
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
