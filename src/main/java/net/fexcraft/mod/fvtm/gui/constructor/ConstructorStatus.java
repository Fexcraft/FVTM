package net.fexcraft.mod.fvtm.gui.constructor;

import static net.fexcraft.mod.fvtm.gui.GuiHandler.CONSTRUCTOR_MAIN;
import static net.fexcraft.mod.fvtm.gui.GuiHandler.LISTENERID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorStatus extends ConstructorGui {

	public ConstructorStatus(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||gui.fvtm.constructor.status.lift_pos", "", "", "", "gui.fvtm.constructor.status.manual", "gui.fvtm.constructor.status.auto", "", "gui.fvtm.constructor.return"};
	}
	
	@Override
	public void init(){
		super.init();
		this.menutitle.string = "gui.fvtm.constructor.status.menu_title";
		this.menutitle.translate();
		cfields[1] = new NumberField(1, fontRenderer, 2, 20 + (1 * buttonheight), xSize - 4, 10, true);
		cfields[2] = new NumberField(2, fontRenderer, 2, 20 + (2 * buttonheight), xSize - 4, 10, true);
		cfields[3] = new NumberField(3, fontRenderer, 2, 20 + (3 * buttonheight), xSize - 4, 10, true);
		this.fields.put("field1", cfields[1]);
		this.fields.put("field2", cfields[2]);
		this.fields.put("field3", cfields[3]);
		this.updateText(true);
	}
	
	private void updateText(boolean initial){
		if(this.container.getTileEntity().getCenterPos() != null){
			cfields[1].setText(this.container.getTileEntity().getCenterPos().getX() + "");
			cfields[2].setText(this.container.getTileEntity().getCenterPos().getY() + "");
			cfields[3].setText(this.container.getTileEntity().getCenterPos().getZ() + "");
			this.tbuttons[4].string = "gui.fvtm.constructor.status.reset";
			this.cbuttons[5].enabled = false;
			this.cbuttons[5].visible = false;
			this.tbuttons[5].visible = false;
		}
		else{
			if(initial) for(TextField field : cfields) if(field != null) field.setText("0");
			this.tbuttons[4].string = this.buttontext[4];
			this.cbuttons[5].enabled = true;
			this.cbuttons[5].visible = true;
			this.tbuttons[5].visible = true;
		}
		this.tbuttons[4].translate();
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(super.buttonClicked(mouseX, mouseY, mouseButton, key, button)) return true;
		if(button.name.equals("button7")) openGui(CONSTRUCTOR_MAIN, xyz, LISTENERID);
		else if(button.name.equals("button4")){
			if(this.container.getTileEntity().getCenterPos() != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "constructor_disconnect");
				this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
				this.container.send(Side.SERVER, compound);
				return true;
			}
			BlockPos pos = new BlockPos(cfields[1].getIntegerValue(), cfields[2].getIntegerValue(), cfields[3].getIntegerValue());
			if(player.world.getTileEntity(pos) == null){
				this.titletext.update("gui.fvtm.constructor.status.no_tile", RGB_ORANGE.packed);
				return true;
			}
			this.container.send(Side.SERVER, newConnectPacket(false, pos));
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
		}
		else if(button.name.equals("button5")){
			this.container.send(Side.SERVER, newConnectPacket(true, null));
			this.titletext.update("gui.fvtm.constructor.request_sending", RGB_CYAN.packed);
		}
		return false;
	}

	private NBTTagCompound newConnectPacket(boolean auto, BlockPos pos){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "constructor_connect");
		compound.setBoolean("Auto", auto);
		if(pos != null || !auto){
			compound.setLong("BlockPos", pos.toLong());
		}
		return compound;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		//
	}
	
	@Override
	public void onTitleTextUpdate(){
		this.updateText(false);
	}

}
