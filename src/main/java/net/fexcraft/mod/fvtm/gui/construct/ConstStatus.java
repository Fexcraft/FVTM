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
		addElement(ConstGuiElement.INPUT3_SEG, "input", null, () -> {
			if(container.getTileEntity().getCenterPos() != null){
				send_disconnect();
				return;
			}
			BlockPos pos = new BlockPos(fields.get("input_0").getIntegerValue(), fields.get("input_1").getIntegerValue(), fields.get("input_2").getIntegerValue());
			if(player.world.getTileEntity(pos) == null){
				titletext.update("gui.fvtm.constructor.status.no_tile", RGB_ORANGE.packed);
				return;
			}
			container.send(Side.SERVER, conn_packet(false, pos));
		});
		addElement(ConstGuiElement.EMPTY_SEG, "spacer0", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "auto", "gui.fvtm.constructor.status.auto", () -> container.send(Side.SERVER, conn_packet(true, null)));
		addElement(ConstGuiElement.EMPTY_SEG, "spacer1", null, null);
		addElement(ConstGuiElement.GENERIC_SEG, "reset", "gui.fvtm.constructor.status.reset", () -> send_disconnect());
		finish_init();
	}

	private void send_disconnect(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "constructor_disconnect");
		titletext.update(REQUEST_SENT, RGB_CYAN.packed);
		container.send(Side.SERVER, compound);
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
