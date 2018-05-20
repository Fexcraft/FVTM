package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.blocks.SmelteryTileEntity;
import net.fexcraft.mod.fvtm.model.block.ModelConstructorCenter;
import net.fexcraft.mod.fvtm.model.block.SmelteryModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@fTESR
public class SmelteryBlockRenderer extends TileEntitySpecialRenderer<SmelteryTileEntity> {

    private static final ResourceLocation texture = new ResourceLocation(FVTM.MODID, "textures/blocks/smeltery.png");
    private static final SmelteryModel model = new SmelteryModel();

    @Override
    public void render(SmelteryTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(ModelConstructorCenter.getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        //double d = te.getBlockMetadata() * 22.5d;
        //GL11.glRotated(d, 0, 1, 0);
        GL11.glRotated(90, 0, 1D, 0);
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        model.render();
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
