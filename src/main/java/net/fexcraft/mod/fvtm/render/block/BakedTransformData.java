package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Axis3DL;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedTransformData {

    public Axis3DL rot_poly, rot_meta;
    public Axis3DL[] rot_tf;
    public Vec3f translate;
    public Vec3f scale;

}
