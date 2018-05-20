package net.fexcraft.mod.fvtm.gui.windows;

import java.util.List;

import net.fexcraft.mod.fvtm.gui.ConstructorMainGUI;
import net.fexcraft.mod.lib.util.common.GenericGuiButton;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class SprayingTool implements Window {

    private static final ResourceLocation texture = new ResourceLocation("fvtm:textures/guis/constructor_9000_rgb_painter.png");
    private static GenericGuiButton close, white;//black
    private static String[] groups = new String[]{"primary", "secondary"};//trimary, etc.
    private static byte brush = 1, group = 0;
    private static ARB[] buttons = new ARB[10];
    private static Palette palette;

    @Override
    public String getId(){
        return "rgb_painter";
    }

    @Override
    public void drawWindow(ConstructorMainGUI gui, Minecraft mc, int i, int j, int mouseX, int mouseY, float partialTicks){
        mc.getTextureManager().bindTexture(texture);
        gui.drawTexturedModalRect(i + 1, j + 1, 1, 1, 254, 176);
        //
        RGB rgb = gui.tile.getColorable() == null ? RGB.WHITE : (group == 0 ? gui.tile.getColorable().getPrimaryColor() : gui.tile.getColorable().getSecondaryColor());
        rgb.glColorApply();
        gui.drawTexturedModalRect(i + 172, j + 15, 172, 15, 78, 30);
        RGB.glColorReset();
        //
        byte[] arr = rgb.toByteArray();
        drawRGB(gui, i + 14, j + 15, 15, arr[0], RGB.RED);
        drawRGB(gui, i + 14, j + 27, 27, arr[1], RGB.GREEN);
        drawRGB(gui, i + 14, j + 39, 39, arr[2], RGB.BLUE);
        //
        for(int k = 0; k < 30; k++){
            for(int l = 0; l < 12; l++){
                rgb = getByPos(k, l);
                rgb.glColorApply();
                gui.drawTexturedModalRect(i + 8 + (k * 8), j + 50 + (l * 8), 8, 50, 8, 8);
                RGB.glColorReset();
            }
        }
        rgb = gui.tile.getColorable() == null ? RGB.WHITE : (group == 0 ? gui.tile.getColorable().getPrimaryColor() : gui.tile.getColorable().getSecondaryColor());
        //
        arr = rgb.toByteArray();
        mc.fontRenderer.drawString("ColorGroup: " + groups[group], i + 6, j + 150, MapColor.GRAY.colorValue, false);
        mc.fontRenderer.drawString("Brush: " + brush, i + 182, j + 150, MapColor.GRAY.colorValue, false);
        mc.fontRenderer.drawString("R:" + (arr[0] + 128), i + 8, j + 165, gui.COLOR, false);
        mc.fontRenderer.drawString("G:" + (arr[1] + 128), i + 40, j + 165, gui.COLOR, false);
        mc.fontRenderer.drawString("B:" + (arr[2] + 128), i + 72, j + 165, gui.COLOR, false);
    }

    private static RGB getByPos(int k, int l){
        int m = k * 8, n = l * 21;
        switch(l){
            //000
            //100
            //010
            //001
            //110
            //011
            //101
            //111
            case 0:
                return new RGB(m, m, m);
            case 1:
                return new RGB(n, m, m);
            case 2:
                return new RGB(m, n, m);
            case 3:
                return new RGB(m, m, n);
            case 4:
                return new RGB(n, n, m);
            case 5:
                return new RGB(m, n, n);
            case 6:
                return new RGB(n, m, n);
            case 7:
                return new RGB(n, n, n);
            case 8:
                return new RGB(m, m, m);
            case 9:
                return new RGB(n + 4, m, m);
            case 10:
                return new RGB(m, n + 4, m);
            case 11:
                return new RGB(m, m, n + 4);
        }
        return new RGB();
    }

    private void drawRGB(ConstructorMainGUI gui, int i, int j, int t, byte b, RGB rgb){
        int l = b + 128;
        l = l > 255 ? 255 : l < 0 ? 0 : l;
        rgb.glColorApply();
        gui.drawTexturedModalRect(i, j, 14, t, (l / 2) + 1, 6);
        RGB.glColorReset();
    }

    @Override
    public boolean closesOther(){
        return true;
    }

    @Override
    public void close(ConstructorMainGUI gui, String rqFrom){
        gui.getButtonList().remove(close);
        for(ARB button : buttons){
            gui.getButtonList().remove(button);
        }
        gui.getButtonList().remove(palette);
        gui.getButtonList().remove(white);
    }

    @Override
    public void actionPerformed(ConstructorMainGUI gui, GuiButton button){
        if(button.id == 12){
            gui.closeWindow(getId());
        }
        else if(button instanceof ARB){
            if(gui.tile.getColorable() == null){
                return;
            }
            RGB ORG = group == 0 ? gui.tile.getColorable().getPrimaryColor() : gui.tile.getColorable().getSecondaryColor();
            int i = button.id - 12;
            switch(i){
                case 1:
                case 2: {
                    byte[] arr = ORG.toByteArray();
                    arr[0] += i == 1 ? -brush : brush;
                    ORG.packed = new RGB(arr[0], arr[1], arr[2]).packed;
                    break;
                }
                case 3:
                case 4: {
                    byte[] arr = ORG.toByteArray();
                    arr[1] += i == 3 ? -brush : brush;
                    ORG.packed = new RGB(arr[0], arr[1], arr[2]).packed;
                    break;
                }
                case 5:
                case 6: {
                    byte[] arr = ORG.toByteArray();
                    arr[2] += i == 5 ? -brush : brush;
                    ORG.packed = new RGB(arr[0], arr[1], arr[2]).packed;
                    break;
                }
                case 7:
                case 8: {
                    group += i == 7 ? -1 : 1;
                    group = group < 0 ? 0 : group >= groups.length ? (byte) (groups.length - 1) : group;
                    break;
                }
                case 9:
                case 10: {
                    brush += i == 9 ? -1 : brush;
                    brush = brush < 1 ? 1 : brush > 32 ? 32 : brush;
                    break;
                }
                default:
                    break;
            }
            gui.tile.sendUpdate("rgb");
        }
        else if(button instanceof Palette){
            if(gui.tile.getColorable() == null){
                return;
            }
            if(palette.xx == 0 && palette.yy == 0){
                return;
            }
            int i = palette.xx, j = palette.yy, k = 0, l = 0;
            while((i -= 8) > 0){
                k++;
            }
            k += i > 0 ? 1 : 0;
            while((j -= 8) > 0){
                l++;
            }
            l += j > 0 ? 1 : 0;
            RGB rgb = getByPos(k, l);
            sendUpdate(gui, rgb);
        }
        else if(button.id == 255){
            sendUpdate(gui, RGB.WHITE);
            return;
        }
        else{
            return;
        }
    }

    private void sendUpdate(ConstructorMainGUI gui, RGB rgb){
        NBTTagCompound compound = gui.getPacketNBT("constructor_9000");
        compound.setString("payload", "rgb_update");
        compound.setString("group", groups[group]);
        compound.setInteger("rgb", rgb.getColorInt());
        gui.sendPacket(compound);
    }

    @Override
    public void addButtons(ConstructorMainGUI gui, List<GuiButton> buttonList){
        int i = gui.getGuiLeft(), j = gui.getGuiTop();
        close = new GenericGuiButton(12, i + 246, j + 2, 8, 8, "");
        close.setTexture(texture);
        close.setTexturePos(0, 246, 2);
        close.setTexturePos(1, 246, 2);
        buttonList.add(close);
        buttonList.add(buttons[0] = new ARB(13, i + 146, j + 13, true));
        buttonList.add(buttons[1] = new ARB(14, i + 158, j + 13, false));
        buttonList.add(buttons[2] = new ARB(15, i + 146, j + 25, true));
        buttonList.add(buttons[3] = new ARB(16, i + 158, j + 25, false));
        buttonList.add(buttons[4] = new ARB(17, i + 146, j + 37, true));
        buttonList.add(buttons[5] = new ARB(18, i + 158, j + 37, false));
        buttonList.add(buttons[6] = new ARB(19, i + 152, j + 149, true));
        buttonList.add(buttons[7] = new ARB(20, i + 164, j + 149, false));
        buttonList.add(buttons[8] = new ARB(21, i + 230, j + 149, true));
        buttonList.add(buttons[9] = new ARB(22, i + 242, j + 149, false));
        buttonList.add(palette = new Palette(23, i + 8, j + 50));
        white = new GenericGuiButton(255, i + 122, j + 164, 64, 10, "Set WHITE");
        white.setTexture(texture);
        white.setTexturePos(0, 122, 164);
        white.setTexturePos(1, 122, 164);
        white.setTextPos(i + 124, j + 166);
        buttonList.add(white);
    }

    @Override
    public void toggleButtonState(ConstructorMainGUI gui, boolean visible){
        close.visible = visible;
        for(ARB button : buttons){
            button.visible = visible;
        }
        palette.visible = visible;
        white.visible = visible;
        Print.debug("buttons " + (visible ? "enabled" : "disabled"));
    }

    @Override
    public String getTitle(){
        return "FN Paint";
    }

    private static class ARB extends GuiButton {

        private boolean left = false;

        public ARB(int buttonId, int x, int y, boolean left){
            super(buttonId, x, y, 10, 10, "");
            this.left = left;
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
            if(!visible){
                return;
            }
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            //
            if(this.enabled){
                if(this.hovered){
                    this.drawTexturedModalRect(this.x, this.y, left ? 199 : 210, 180, this.width, this.height);
                }
                else{
                    this.drawTexturedModalRect(this.x, this.y, left ? 146 : 158, 13, this.width, this.height);
                }
            }
            else{
                if(this.hovered){
                    this.drawTexturedModalRect(this.x, this.y, left ? 177 : 188, 180, this.width, this.height);
                }
                else{
                    this.drawTexturedModalRect(this.x, this.y, left ? 146 : 158, 13, this.width, this.height);
                }
            }
        }

    }

    private static class Palette extends GuiButton {

        private int xx = 0, yy = 0;

        public Palette(int buttonId, int x, int y){
            super(buttonId, x, y, 240, 96, "");
        }

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks){
            if(!visible){
                return;
            }
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            xx = mouseX - x;
            yy = mouseY - this.y;
        }

    }

    @Override
    public void applyArguments(ConstructorMainGUI gui, String[] args){
        //
    }

}
