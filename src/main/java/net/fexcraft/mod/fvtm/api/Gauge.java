package net.fexcraft.mod.fvtm.api;

import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.fexcraft.mod.fvtm.blocks.rail.Connection;
import net.fexcraft.mod.fvtm.blocks.rail.TrackTileEntity;
import net.minecraft.item.ItemStack;

public interface Gauge extends DataHolderObject.Simple<Gauge> {

    @Override
    public default Class<Gauge> getRegistryType(){
        return Gauge.class;
    }

    public static interface GaugeItem {

        public static final String NBTKEY = "FVTM:RailGauge";

        public Gauge getGauge(ItemStack stack);

    }

    public Model<TrackTileEntity, Connection> getModel();
    
    /** In pixels. */
    public float width();

}
