package net.fexcraft.mod.fvtm.api;

import javax.annotation.Nullable;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** `set` calls set a value, but don't send updates, while `update` calls send an update to the Client*/
public interface ConstructorEntity {
	
	@Nullable
	public VehicleData getVehicleData();

	public void updateVehicleData(VehicleData data);

	public void setVehicleData(VehicleData data);

	public int getSelection();

	public void setSelection(int i);

	public default void updateSelection(int i){ this.updateSelection(i, false); }

	public void updateSelection(int i, boolean b);

	public String getScreenId();

	public default void updateScreenId(String string){
		this.updateScreenId(string, true);
	}

	public void updateScreenId(String string, boolean ressel);

	public void recycleVehicle();

	public default int getRows(){
		return 8;
	}

	public byte getBrush();

	public void setBrush(byte b);

	public default void setBrush(int i){
		if(i > Byte.MAX_VALUE){ i = Byte.MAX_VALUE; }
		if(i < Byte.MIN_VALUE){ i = Byte.MIN_VALUE; }
		this.setBrush((byte)i);
	}

	public void updateColour(String str, RGB rgb);

	public PartData getPartData();

	public void setPartData(PartData part);

	public World getWorld();

	public BlockPos getPos();

	public int getSelPart();

	public void setSelPart(int i);

	public int getScroll();

	public void setScroll(int i);

	public BlockPos getCenterPos();

	public void setCenterPos(BlockPos o);

	public void openInputGui(EntityPlayer player);
}