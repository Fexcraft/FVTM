package net.fexcraft.mod.fvtm.gui.constructor;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.gui.ConstructorGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstructorStatus extends ConstructorGui {

	public ConstructorStatus(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z); this.removeEmptyButtons = true;
		this.buttontext = new String[]{ "||Lift/Center Pos.", "", "", "", "Manual Connect", "Auto Connect", "", "Return."};
	}
	
	@Override
	public void init(){
		super.init(); this.menutitle.string = "Const. Status";
		cfields[1] = new NumberField(1, fontRenderer, 2, 20 + (1 * buttonheight), xSize - 4, 10, true);
		cfields[2] = new NumberField(2, fontRenderer, 2, 20 + (2 * buttonheight), xSize - 4, 10, true);
		cfields[3] = new NumberField(3, fontRenderer, 2, 20 + (3 * buttonheight), xSize - 4, 10, true);
		this.fields.put("field1", cfields[1]); this.fields.put("field2", cfields[2]); this.fields.put("field3", cfields[3]);
		this.updateText(true);
	}
	
	private void updateText(boolean initial){
		if(this.container.getTileEntity().getCenterPos() != null){
			cfields[1].setText(this.container.getTileEntity().getCenterPos().getX() + "");
			cfields[2].setText(this.container.getTileEntity().getCenterPos().getY() + "");
			cfields[3].setText(this.container.getTileEntity().getCenterPos().getZ() + "");
			this.tbuttons[4].string = "Reset Connection";
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
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		//
	}

	@Override
	protected void buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("button7")) this.openGui(modid, 900, xyz);
		else if(button.name.equals("button4")){
			if(this.container.getTileEntity().getCenterPos() != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setString("cargo", "constructor_disconnect");
				this.titletext.update("Request sending to Server.", RGB.BLUE.packed);
				this.container.send(Side.SERVER, compound); return;
			}
			BlockPos pos = new BlockPos(cfields[1].getIntegerValue(), cfields[2].getIntegerValue(), cfields[3].getIntegerValue());
			if(player.world.getTileEntity(pos) == null){
				this.titletext.update("No TileEntity at selected position. [CLIENT]", RGB.RED.packed); return;
			}
			this.container.send(Side.SERVER, newConnectPacket(false, pos));
			this.titletext.update("Request sent to Server.", RGB.BLUE.packed);
		}
		else if(button.name.equals("button5")){
			this.container.send(Side.SERVER, newConnectPacket(true, null));
			this.titletext.update("Request sent to Server.", RGB.BLUE.packed);
		}
		else return;
	}

	private NBTTagCompound newConnectPacket(boolean auto, BlockPos pos){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "constructor_connect");
		compound.setBoolean("Auto", auto);
		if(pos != null || !auto){
			compound.setLong("BlockPos", pos.toLong());
		} return compound;
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
