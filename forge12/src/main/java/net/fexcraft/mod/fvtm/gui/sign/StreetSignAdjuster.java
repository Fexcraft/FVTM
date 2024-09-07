package net.fexcraft.mod.fvtm.gui.sign;

import net.fexcraft.lib.common.lang.BitList;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.gui.GenericGui;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class StreetSignAdjuster extends GenericGui<StreetSignAdjusterContainer> {
	
	private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/gui/street_sign.png");
	//
	private static Boolean[] arrows = new Boolean[]{ null, null, null, null, false, false };
	private static boolean[] layers = new boolean[]{ true, true, true, true };
	private boolean[] sides = new boolean[]{ true, true, true, true };
	private byte textur = 0;
	private TextField[] cornfields = new TextField[4];//cropfields before
	private String[] textures = new String[]{
		"White (Black)", "Yellow (Black)", "Red (White)", "Green (White)", "Blue (White)", "Purple (White)", "Brown (White)", "Black (White)"
	};
	//private RGB[] colours = new RGB[]{ RGB.WHITE, RGB.WHITE, RGB.WHITE, RGB.WHITE, RGB.WHITE, RGB.WHITE, RGB.WHITE, RGB.WHITE };

	public StreetSignAdjuster(EntityPlayer player, World world, int x, int y, int z){
		super(texture, new StreetSignAdjusterContainer(player, world, x, y, z), player);
		this.defbackground = true; this.deftexrect = true; container.gui = this;
		this.xSize = 248; this.ySize = 202;
	}

	@Override
	protected void init(){
		sides = container.entity.sides;
		layers = container.entity.panels;
		arrows = container.entity.arrows;
		textur = container.entity.texture;
		//
		texts.put("title", new BasicText(guiLeft + 9, guiTop + 9, 190, MapColor.SNOW.colorValue, "Street Sign Editor"));
		for(int i = 0; i < 4; i++){
			fields.put("row" + i, cornfields[i] = new TextField(i, fontRenderer, guiLeft + 26, guiTop + 47 + (i * 32), 122, 12));
			cornfields[i].setText(container.entity.text[i]); //cornfields[i].setEnableBackgroundDrawing(false);
		}
		texts.put("texture", new BasicText(guiLeft + 20, guiTop + 185, 134, MapColor.SNOW.colorValue, textures[textur]));
		buttons.put("t", new Button("t", guiLeft +  23, guiTop +  21,  23,  21, 128,  16, true));
		buttons.put("r", new Button("r", guiLeft + 151, guiTop +  37, 151,  37,  16, 128, true));
		buttons.put("b", new Button("b", guiLeft +  23, guiTop + 165,  23, 165, 128,  16, true));
		buttons.put("l", new Button("l", guiLeft +   7, guiTop +  37,   7,  37,  16, 128, true));
		for(int i = 0; i < 4; i++){
			buttons.put("l" + i, new LayerButton("l" + i, guiLeft + 169, guiTop + 37 + (i * 32), 169, 37 + (i * 32), 12, 32, i));
			buttons.put("r" + i, new BasicButton("r" + i, guiLeft + 208, guiTop + 49 + (i * 32), 208, 49 + (i * 32), 8, 8, true));
			buttons.put("al" + i, new ArrowButton("al" + i, guiLeft + 184, guiTop + 41 + (i * 32), 184, 41 + (i * 32), 24, 24, i, true));
			buttons.put("ar" + i, new ArrowButton("ar" + i, guiLeft + 216, guiTop + 41 + (i * 32), 216, 41 + (i * 32), 24, 24, i, false));
		}
		buttons.put("r5", new BasicButton("r5", guiLeft + 194, guiTop + 166, 194, 166, 8, 8, true));
		buttons.put("r4", new BasicButton("r4", guiLeft + 222, guiTop + 186, 222, 186, 8, 8, true));
		buttons.put("a5", new ArrowButton("a5", guiLeft + 186, guiTop + 174, 186, 174, 24, 20, 5, true));
		buttons.put("a4", new ArrowButton("a4", guiLeft + 214, guiTop + 166, 214, 166, 24, 20, 4, true));
		//
		buttons.put("prev", new BasicButton("prev", guiLeft + 8, guiTop + 184, 8, 184, 10, 10, true));
		buttons.put("next", new BasicButton("next", guiLeft + 156, guiTop + 184, 156, 184, 10, 10, true));
		buttons.put("finish", new BasicButton("finish", guiLeft + 169, guiTop + 167, 169, 167, 12, 28, true));
	}
	
	private static final class Button extends BasicButton {
		
		public Button(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7){
			super(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(visible && hovered){ RGB.BLUE.glColorApply(); gui.drawTexturedModalRect(x, y, tx, ty, sizex, sizey); RGB.glColorReset(); }
		}
		
	}
	
	private static final class LayerButton extends BasicButton {
		
		private int layer;
		
		public LayerButton(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int layer){
			super(arg0, arg1, arg2, arg3, arg4, arg5, arg6, true); this.layer = layer;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return; RGB rgb = hovered ? rgb_hover : layers[layer] ? RGB.GREEN : RGB.RED;
			rgb.glColorApply(); gui.drawTexturedModalRect(x, y, tx, ty, sizex, sizey); RGB.glColorReset();
		}
		
	}
	
	private static final class ArrowButton extends BasicButton {
		
		private boolean expected;
		private int arrow;
		
		public ArrowButton(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int layer, boolean bool){
			super(arg0, arg1, arg2, arg3, arg4, arg5, arg6, true); this.arrow = layer; this.expected = bool;
		}

		@Override
		public void draw(GenericGui<?> gui, float pticks, int mouseX, int mouseY){
			if(!visible) return; RGB rgb = hovered ? rgb_hover : arrows[arrow] != null && arrows[arrow] == expected ? RGB.GREEN : RGB.WHITE;
			rgb.glColorApply(); gui.drawTexturedModalRect(x, y, tx, ty, sizex, sizey); RGB.glColorReset();
		}
		
	}

	@Override
	protected void predraw(float pticks, int mouseX, int mouseY){
		
	}

	@Override
	protected void drawbackground(float pticks, int mouseX, int mouseY){
		if(!sides[0]){ RGB.BLACK.glColorApply(); drawTexturedModalRect(guiLeft + 7, guiTop + 21, 7, 21, 160, 16); }
		if(!sides[1]){ RGB.BLACK.glColorApply(); drawTexturedModalRect(guiLeft + 151, guiTop + 21, 151, 21, 16, 160); }
		if(!sides[2]){ RGB.BLACK.glColorApply(); drawTexturedModalRect(guiLeft + 7, guiTop + 165, 7, 165, 160, 16); }
		if(!sides[3]){ RGB.BLACK.glColorApply(); drawTexturedModalRect(guiLeft + 7, guiTop + 21, 7, 21, 16, 160); }
		//
		for(int i = 0; i < 4; i++){ if(layers[i]) continue;
			RGB.BLACK.glColorApply(); drawTexturedModalRect(guiLeft + 23, guiTop + 37 + (i * 32), 23, 37 + (i * 32), 128, 32);
		}
		RGB.glColorReset();
	}

	@Override
	protected boolean buttonClicked(int mouseX, int mouseY, int mouseButton, String key, BasicButton button){
		if(button.name.equals("t")){ sides[0] = !sides[0]; return true; }
		if(button.name.equals("r")){ sides[1] = !sides[1]; return true; }
		if(button.name.equals("b")){ sides[2] = !sides[2]; return true; }
		if(button.name.equals("l")){ sides[3] = !sides[3]; return true; }
		//
		if(button.name.equals("l0")){ layers[0] = !layers[0]; cornfields[0].setVisible(layers[0] && !arrows[4]); return true; }
		if(button.name.equals("l1")){ layers[1] = !layers[1]; cornfields[1].setVisible(layers[1]); return true; }
		if(button.name.equals("l2")){ layers[2] = !layers[2]; cornfields[2].setVisible(layers[2]); return true; }
		if(button.name.equals("l3")){ layers[3] = !layers[3]; cornfields[3].setVisible(layers[3] && !arrows[5]); return true; }
		//
		if(button.name.equals("r0")){ arrows[0] = null; return true; }
		if(button.name.equals("r1")){ arrows[1] = null; return true; }
		if(button.name.equals("r2")){ arrows[2] = null; return true; }
		if(button.name.equals("r3")){ arrows[3] = null; return true; }
		if(button.name.equals("r4")){ arrows[4] = false; cornfields[0].setVisible(layers[0]); return true; }
		if(button.name.equals("r5")){ arrows[5] = false; cornfields[3].setVisible(layers[3]); return true; }
		//
		if(button.name.equals("al0")){ arrows[0] = true; return true; }
		if(button.name.equals("al1")){ arrows[1] = true; return true; }
		if(button.name.equals("al2")){ arrows[2] = true; return true; }
		if(button.name.equals("al3")){ arrows[3] = true; return true; }
		if(button.name.equals("ar0")){ arrows[0] = false; return true; }
		if(button.name.equals("ar1")){ arrows[1] = false; return true; }
		if(button.name.equals("ar2")){ arrows[2] = false; return true; }
		if(button.name.equals("ar3")){ arrows[3] = false; return true; }
		//
		if(button.name.equals("a4")){ arrows[4] = true; cornfields[0].setVisible(false); return true; }
		if(button.name.equals("a5")){ arrows[5] = true; cornfields[3].setVisible(false); return true; }
		//
		if(button.name.equals("prev")){ scroll(false); return true; }
		if(button.name.equals("next")){ scroll(true); return true; }
		if(button.name.equals("finish")){
			NBTTagCompound compound = new NBTTagCompound();
	    	BitList list = new BitList(sides); list.integrate(layers, 4);
	    	compound.setInteger("bitlist", list.toInt());
	    	for(int i = 0; i < 6; i++){
	    		compound.setByte("arrow" + i, (byte)(arrows[i] == null ? -1 : arrows[i] ? 1 : 0));
	    		if(i < 4){
	    			boolean bool = cornfields[i].getVisible();
	    			compound.setString("text" + i, bool ? cornfields[i].getText() : "");
	    		}
	    	}
	    	compound.setByte("texture", textur);
	    	container.send(Side.SERVER, compound);
			return true;
		}
		return false;
	}

	@Override
	protected void scrollwheel(int am, int x, int y){
		scroll(am < 0);
	}

	private void scroll(boolean bool){
		textur += bool ? 1 : -1; if(textur > 7) textur = 7; if(textur < 0) textur = 0;
		texts.get("texture").string = textures[textur];
	}
	
}

