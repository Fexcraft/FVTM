package net.fexcraft.mod.fvtm.render.block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class TESRBase<T extends TileEntity> extends TileEntitySpecialRenderer<T> {

	@Override
    public boolean isGlobalRenderer(T te){
        return true;
    }
    
}