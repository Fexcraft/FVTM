package net.fexcraft.mod.fmt.capabilities;

import javax.annotation.Nullable;

import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.minecraft.util.math.BlockPos;

public interface EditorPlayerDataContainerCapability {
	
	public boolean isEditorActive();
	
	public @Nullable BlockPos getSelectedEditorPosition();
	
	public @Nullable EditorTileEntity geEditorTileEntity();
	
	public void setEditorTileEntity(@Nullable EditorTileEntity tile);

}
