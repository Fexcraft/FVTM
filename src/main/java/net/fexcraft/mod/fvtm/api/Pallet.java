package net.fexcraft.mod.fvtm.api;

import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.fexcraft.mod.fvtm.api.root.Saveloadable;
import net.minecraft.item.ItemStack;

public interface Pallet extends DataHolderObject.Extended<Pallet, Pallet.PalletData> {

    @Override
    public default Class<Pallet> getRegistryType(){
        return Pallet.class;
    }
    
    public net.minecraft.block.Block getBlock();

    public Class<? extends PalletData> getDataClass();

    public static interface PalletItem {

        public static final String NBTKEY = "FVTM:Pallet";

        public abstract PalletData getPallet(ItemStack stack);

    }
    
    public static interface PalletData extends Saveloadable<PalletData> {
    	
    	public Pallet getPallet();
    	
    }

}
