package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.container.ContainerData;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@fTESR
public class ContainerBlockRenderer extends TileEntitySpecialRenderer<ContainerEntity> {

	private double off;

    @Override
    public void render(ContainerEntity te, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(!te.isCore() || te.getContainerData() == null){ return; }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        //TexUtil.bindTexture(ModelConstructorCenter.getTexture());
        GL11.glPushMatrix(); off = te.getContainerData().getContainerType().isEven() ? 0.5 : 0;
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        switch(te.getBlockMetadata()){
            case 2: {
                GL11.glTranslated(off, 0, 0);
                GL11.glRotated(0, 0, 1D, 0);
                break;
            }
            case 3: {
                GL11.glTranslated(off, 0, 0);
                GL11.glRotated(180D, 0, 1D, 0);
                break;
            }
            case 4: {
                GL11.glTranslated(0, 0, -off);
                GL11.glRotated(-90D, 0, 1D, 0);
                break;
            }
            case 5: {
                GL11.glTranslated(0, 0, -off);
                GL11.glRotated(-270D, 0, 1D, 0);
                break;
            }
            default: {
                GL11.glTranslated(0, -off, 0);
                GL11.glRotated(Time.getSecond() * 6, 0, 1D, 0);
                break;
            }
        }
        GL11.glRotated(180, 0, 1D, 0);
        ContainerData condata = te.getContainerData();
        if(condata != null){
            if(condata.getType().getModel() != null){
                TexUtil.bindTexture(condata.getCurrentTexture());
                condata.getType().getModel().render(RENDERDATA.set(condata, te, te.getCapability(Capabilities.RENDERCACHE, null), false));
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
