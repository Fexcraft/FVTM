package net.fexcraft.mod.fvtm.gui.construct;

import net.fexcraft.mod.fvtm.gui.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstStatus extends ConstGui {

	public ConstStatus(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		root = GuiHandler.CONSTRUCTOR_MAIN;
		help_url += "#status";
	}
	
	@Override
	public void init(){
		super.init();
		setMenuTitle("gui.fvtm.constructor.status.menu_title");
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addElement(ConstGuiElement.BLANK_SEG, "liftpos", "gui.fvtm.constructor.status.lift_pos", null);
		addElement(ConstGuiElement.INPUT3_SEG, "input", null, null);
		addElement(ConstGuiElement.EMPTY_SEG, "spacer0", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "auto", "gui.fvtm.constructor.status.auto", () -> {
			//TODO
		});
		addElement(ConstGuiElement.EMPTY_SEG, "spacer1", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "reset", "gui.fvtm.constructor.status.reset", () -> {
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("cargo", "constructor_disconnect");
			titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
			container.send(Side.SERVER, compound);
		});
		finish_init();
	}

	private NBTTagCompound conn_packet(boolean auto, BlockPos pos){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "constructor_connect");
		compound.setBoolean("Auto", auto);
		if(pos != null || !auto){
			compound.setLong("BlockPos", pos.toLong());
		}
		return compound;
	}

}
