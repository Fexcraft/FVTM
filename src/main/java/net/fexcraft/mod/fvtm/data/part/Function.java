package net.fexcraft.mod.fvtm.data.part;

import java.util.List;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * @author Ferdinand Calo' (FEX___96)
 *
 * <br><i>Part Function</i>
 */
public abstract class Function {
	
	public Function(Part part, @Nullable JsonObject obj){}
	
	public abstract Function read(NBTTagCompound compound);
	
	public abstract NBTTagCompound write(NBTTagCompound compound);

	public abstract String getId();
	
	/** Used to crease an use-copy from the "default" function storage in a Part. */
	public abstract Function copy(Part Part);
	
	public static abstract class StaticFunction extends Function {

		public StaticFunction(Part part, JsonObject obj){ super(part, obj); }

		@Override /** Do not read anything. */
		public Function read(NBTTagCompound compound){ return this; }

		@Override /** Do not write anything. */
		public NBTTagCompound write(NBTTagCompound compound){ return null; }

		@Override /** Return self because we don't need copies. */
		public Function copy(Part part){ return this; }
		
	}

    public void addInformation(ItemStack stack, World world, PartData data, List<String> list, ITooltipFlag flag){}

}
