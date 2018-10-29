package net.fexcraft.mod.fvtm.api.root;

import net.fexcraft.lib.common.math.RGB;

public interface Colorable {

    public RGB getPrimaryColor();

    public RGB getSecondaryColor();

    //
    public static interface ColorHolder {

        public RGB getDefPrimaryColor();

        public RGB getDefSecondaryolor();

    }

}
