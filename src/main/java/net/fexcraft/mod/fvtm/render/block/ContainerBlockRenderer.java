package net.fexcraft.mod.fvtm.render.block;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.blocks.ContainerTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ContainerBlockRenderer extends TileEntitySpecialRenderer<ContainerTileEntity> {

    @Override
    public void render(ContainerTileEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(!te.isCore()){
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        //ModelBase.bindTexture(ModelConstructorCenter.getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        switch(te.getBlockMetadata()){
            case 2: {
                GL11.glTranslated(0.5D, 0, 0);
                GL11.glRotated(0, 0, 1D, 0);
                break;
            }
            case 3: {
                GL11.glTranslated(0.5D, 0, 0);
                GL11.glRotated(180D, 0, 1D, 0);
                break;
            }
            case 4: {
                GL11.glTranslated(0, 0, -0.5D);
                GL11.glRotated(-90D, 0, 1D, 0);
                break;
            }
            case 5: {
                GL11.glTranslated(0, 0, -0.5D);
                GL11.glRotated(-270D, 0, 1D, 0);
                break;
            }
            default: {
                GL11.glTranslated(0, -0.5D, 0);
                GL11.glRotated(Time.getSecond() * 6, 0, 1D, 0);
                break;
            }
        }
        GL11.glRotated(180, 0, 1D, 0);
        ContainerData condata = te.getContainerData();
        if(condata != null){
            if(condata.getContainer().getModel() != null){
                ModelBase.bindTexture(condata.getTexture());
                condata.getContainer().getModel().render(condata, null);
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
