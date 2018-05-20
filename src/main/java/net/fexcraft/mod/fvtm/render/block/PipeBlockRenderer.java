package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.mod.fvtm.blocks.PipeBlock.PipeType;
import net.fexcraft.mod.fvtm.blocks.PipeTileEntity;
import net.fexcraft.mod.fvtm.model.block.PipeModel;
import net.fexcraft.mod.lib.api.render.fTESR;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class PipeBlockRenderer extends TileEntitySpecialRenderer<PipeTileEntity> {

    //private static ResourceLocation texture = new ResourceLocation("minecraft:textures/blocks/planks_oak.png");
    //private static ResourceLocation texture = new ResourceLocation("minecraft:textures/blocks/iron_block.png");
    @Override
    public void render(PipeTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        Minecraft.getMinecraft().renderEngine.bindTexture(PipeType.byMetadata(te.getBlockMetadata()).getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        PipeModel.INSTANCE.render(te, null);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
