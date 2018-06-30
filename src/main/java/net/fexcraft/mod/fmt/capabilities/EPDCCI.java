package net.fexcraft.mod.fmt.capabilities;

import net.fexcraft.mod.fmt.block.EditorTileEntity;
import net.minecraft.util.math.BlockPos;

public class EPDCCI implements EditorPlayerDataContainerCapability {
	
	private EditorTileEntity tile;

	@Override
	public boolean isEditorActive(){
		return tile != null;
	}

	@Override
	public BlockPos getSelectedEditorPosition(){
		return tile == null ? null : tile.getPos();
	}

	@Override
	public EditorTileEntity geEditorTileEntity(){
		return tile;
	}

	@Override
	public void setEditorTileEntity(EditorTileEntity tile){
		if(this.tile != null && tile != null && this.tile.getPos().equals(tile.getPos())){
			this.tile = null; return;
		}
		this.tile = tile;
	}
	
}