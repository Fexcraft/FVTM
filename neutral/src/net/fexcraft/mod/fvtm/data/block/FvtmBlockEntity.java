package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.math.V3I;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public interface FvtmBlockEntity {

    public BlockData getBlockData();

    public V3I getV3I();

    public int getDim();

    public int getMeta();

}
