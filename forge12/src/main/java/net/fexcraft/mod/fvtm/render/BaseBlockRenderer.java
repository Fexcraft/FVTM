package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.mc.api.registry.fTESR;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static net.fexcraft.mod.fvtm.Config.RENDER_BLOCKS_SEPARATELY;

@fTESR
public class BaseBlockRenderer extends TileEntitySpecialRenderer<BlockTileEntity> {
	
	private BlockData data = null;
    private BlockModel model = null;

    @Override
    public void render(BlockTileEntity tile, double posX, double posY, double posZ, float partialticks, int destroystage, float f){
        if(RENDER_BLOCKS_SEPARATELY) return;
        if((data = tile.getBlockData()) == null) return;
        model = (BlockModel)data.getType().getModel();
        if(model == null){
            GL11.glPushMatrix();
            GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
            DebugModels.SPHERE_RED.render(0.5f);
            GL11.glPopMatrix();
            return;
        }
        GL11.glPushMatrix();
        GL11.glTranslated(posX + 0.5F, posY, posZ + 0.5F);
        TexUtil.bindTexture(model.bindtex ? data.getCurrentTexture() : FvtmRegistry.WHITE_TEXTURE);
        GL11.glPushMatrix();
        GL11.glRotated(data.getType().getBlockType().getRotationFor(tile.getBlockMetadata()), 0, 1, 0);
        if(model.rootrender) model.render(BlockModel.RENDERDATA.set(data, tile, tile.getCapability(Capabilities.RENDERCACHE, null), null, false));
        if(model.state_models.size() > 0){
            IBlockState state = tile.getWorld().getBlockState(tile.getPos());
            for(IProperty<?> prop : tile.getBlockType().getBlockState().getProperties()){
                String str = prop.getName() + "=" + state.getValue(prop);
                if(model.state_models.containsKey(str)){
                    ArrayList<BlockModel> list = model.state_models.get(str);
                    for(BlockModel statemodel : list){
                        statemodel.render(BlockModel.RENDERDATA);
                    }
                }
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

}
