package net.fexcraft.mod.fvtm.api;

import net.fexcraft.mod.fvtm.api.root.DataHolderObject;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public interface Gauge extends DataHolderObject.Simple<Gauge> {

    @Override
    public default Class<Gauge> getRegistryType(){
        return Gauge.class;
    }

    public static interface GaugeItem {

        public static final String NBTKEY = "FVTM:RailGauge";

        public Gauge getGauge(ItemStack stack);

    }

    public Model<Object, Object> getModel();
    
    public ResourceLocation getTexture();
    
    /** In pixels. */
    public float width();

}
