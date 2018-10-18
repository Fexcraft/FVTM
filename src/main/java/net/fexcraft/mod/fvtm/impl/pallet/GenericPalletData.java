package net.fexcraft.mod.fvtm.impl.pallet;

import net.fexcraft.mod.fvtm.api.Pallet;
import net.fexcraft.mod.fvtm.api.Pallet.PalletData;
import net.fexcraft.mod.fvtm.blocks.Pallet.PalletItem;
import net.minecraft.nbt.NBTTagCompound;

public class GenericPalletData implements PalletData {
	
	private Pallet pallet;
	
	public GenericPalletData(Pallet pallet){
		this.pallet = pallet;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound){
		compound.setString(PalletItem.NBTKEY, pallet.getRegistryName().toString());
		return compound;
	}

	@Override
	public PalletData readFromNBT(NBTTagCompound compound){
		//
		return this;
	}

	@Override
	public Pallet getPallet(){
		return pallet;
	}
	
}