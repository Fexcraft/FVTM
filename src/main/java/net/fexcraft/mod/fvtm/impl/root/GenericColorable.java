package net.fexcraft.mod.fvtm.impl.root;

import net.fexcraft.mod.fvtm.api.root.Colorable;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.nbt.NBTTagCompound;

public class GenericColorable<T, B> extends GenericLockable<T, B> implements Colorable {
	
	protected RGB primary, secondary;
	
	public GenericColorable(B base){
		super(base);
		this.primary = new RGB(RGB.WHITE);
		this.secondary = new RGB(RGB.WHITE);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		if(this.primary != null){
			/*compound.setByte("PrimaryRed", this.primary.red);
			compound.setByte("PrimaryGreen", this.primary.green);
			compound.setByte("PrimaryBlue", this.primary.blue);*/
			compound.setInteger("PrimaryRGB", this.primary.packed);
		}
		if(this.secondary != null){
			/*compound.setByte("SecondaryRed", this.secondary.red);
			compound.setByte("SecondaryGreen", this.secondary.green);
			compound.setByte("SecondaryBlue", this.secondary.blue);*/
			compound.setInteger("SecondaryRGB", this.secondary.packed);
		}
		return compound;
	}

	@Override
	public T readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		this.primary = compound.hasKey("PrimaryRGB") ? new RGB(compound.getInteger("PrimaryRGB")) : new RGB(((ColorHolder)root).getDefPrimaryColor());
		this.secondary = compound.hasKey("SecondaryRGB") ? new RGB(compound.getInteger("SecondaryRGB")) : new RGB(((ColorHolder)root).getDefSecondaryolor());
		return null;
	}

	@Override
	public RGB getPrimaryColor(){
		return primary;
	}

	@Override
	public RGB getSecondaryColor(){
		return secondary;
	}
	
}