package net.fexcraft.mod.fvtm.gui.construct;

import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.BLANK_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.EMPTY_SEG;
import static net.fexcraft.mod.fvtm.gui.construct.ConstGuiElement.SWITCH_SEG;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class ConstPainter extends ConstGui {
	
	private int channelidx;
	private String channelid;
	private RGB channel;
	private Colorable colorable;
	private static RGB CURRENT = RGB.WHITE.copy();

	public ConstPainter(EntityPlayer player, World world, int x, int y, int z){
		super(player, world, x, y, z);
		help_url += "#painter";
		colorable = container.hasBlock() ? container.entity.getBlockData() : container.hasContainer() ? container.entity.getContainerData() : container.hasVehicle() ? container.entity.getVehicleData() : null;
	}
	
	@Override
	public void init(){
		super.init();
		String title = "vehicle";
		if(container.hasBlock()) title = "block";
		else if(container.hasContainer()) title = "container";
		else if(container.hasVehicle()) title = "vehicle";
		setMenuTitle("gui.fvtm.constructor.texture.menu_title_" + title);
		addTopButton(ConstGuiElement.HELP);
		addTopButton(ConstGuiElement.BACK);
		addElement(BLANK_SEG, "channel_title", "gui.fvtm.constructor.painter.channel", null);
		addElement(SWITCH_SEG, "channel", "", button -> {
				channelidx += button.name.endsWith("_0") ? -1 : 1;
				if(channelidx < 0) channelidx = colorable.getColorChannels().size() - 1;
				if(channelidx >= colorable.getColorChannels().size()) channelidx = 0;
				updateChannel();
			},
			ConstGuiElement.LEFT_ICON.asarray(ConstGuiElement.RIGHT_ICON),
			new String[]{ "gui.fvtm.constructor.button.prev", "gui.fvtm.constructor.button.next" }
		);
		addElement(EMPTY_SEG, "spacer0", null, null);
		addElement(ConstGuiElement.SWITCH_SEG, "current", "gui.fvtm.constructor.painter.current", button -> {
				if(button.name.endsWith("_1")) updateColor(channel, true);
				sendUpdate();
			},
			ConstGuiElement.CONFIRM_ICON.asarray(ConstGuiElement.CANCEL_ICON),
			new String[]{ "gui.fvtm.constructor.button.apply", "gui.fvtm.constructor.button.reset" }
		);
		addElement(EMPTY_SEG, "color", null, null);
		buttons.put("preview", new Preview(17 + 12 * (elements.size() - 1), ConstGuiElement.WHITE_SEG));
		addElement(BLANK_SEG, "hex_title", "gui.fvtm.constructor.painter.hex", null);
		addElement(ConstGuiElement.INPUT_1B_SEG, "hex", null, button -> {
			try{
				RGB rgb = new RGB();
				rgb.packed = Integer.parseInt(fields.get("hex").getText().replace("#", ""), 16);
				updateColor(rgb, true);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}, ConstGuiElement.EDIT_ICON.asarray(), new String[]{ "gui.fvtm.constructor.button.apply" });
		addElement(BLANK_SEG, "rgb_title", "gui.fvtm.constructor.painter.rgb", null);
		addElement(ConstGuiElement.INPUT3_SEG, "rgb", null, button -> {
			try{
				RGB rgb = new RGB();
				rgb = new RGB(
					Integer.parseInt(fields.get("rgb_0").getText()),
					Integer.parseInt(fields.get("rgb_1").getText()),
					Integer.parseInt(fields.get("rgb_2").getText())
				);
				updateColor(rgb, true);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}, ConstGuiElement.EDIT_ICON.asarray(), new String[]{ "gui.fvtm.constructor.button.apply" });
		addElement(EMPTY_SEG, "spacer1", null, null);
		//
		finish_init();
		updateChannel();
	}

	private void updateChannel(){
		Object[] arr = colorable.getColorChannels().keySet().toArray();
		for(int i = 0; i < arr.length; i++){
			if(i == channelidx) channelid = arr[i].toString();
		}
		channel = colorable.getColorChannel(channelid);
		texts.get("channel").string = channelid;
		updateColor(channel, true);
	}

	private void updateColor(RGB rgb, boolean update){
		CURRENT.packed = rgb.packed;
		fields.get("hex").setText(toHex(rgb.packed));
		byte[] arr = rgb.toByteArray();
		fields.get("rgb_0").setText(arr[0] + 128 + "");
		fields.get("rgb_1").setText(arr[1] + 128 + "");
		fields.get("rgb_2").setText(arr[2] + 128 + "");
	}

	private void sendUpdate(){
		NBTTagCompound compound = new NBTTagCompound();
		compound.setString("cargo", "color_update");
		compound.setString("channel", channelid);
		compound.setInteger("rgb", CURRENT.packed);
		titletext.update(REQUEST_SENT, RGB_CYAN.packed);
		container.send(Side.SERVER, compound);
	}

	private String toHex(int packed){
		String str = Integer.toHexString(packed);
		while(str.length() < 6) str = "0" + str;
		return "#" + str;
	}

	public static class Preview extends BasicButton {

		public Preview(int y, ConstGuiElement elm){
			super("preview", 2, y, elm.x + 2, elm.y + 1, 135, 10, true);
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return;
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			CURRENT.glColorApply();
			gui.drawTexturedModalRect(x, y, 1, 1, sizex, sizey);
			RGB.glColorReset();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

	}

}
