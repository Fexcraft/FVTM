package net.fexcraft.mod.fvtm.data.block;

import net.fexcraft.lib.common.math.V3D;

import java.util.function.Supplier;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public abstract class AABB {

    public static Supplier<AABB> SUPPLIER = null;
    //public float x0, y0, z0;
    //public float x1, y1, z1;

    public static AABB create(){
        return SUPPLIER.get().set(0, 0, 0, 1, 1, 1);
    }

    public static AABB create(float sx, float sy, float sz, float ex, float ey, float ez){
        return SUPPLIER.get().set(sx, sy, sz, ex, ey, ez);
    }

    public static AABB create(double sx, double sy, double sz, double ex, double ey, double ez){
        return SUPPLIER.get().set(sx, sy, sz, ex, ey, ez);
    }

    public static AABB create(float[] arr){
        return SUPPLIER.get().set(arr);
    }

    public abstract AABB set(float sx, float sy, float sz, float ex, float ey, float ez);

    public AABB set(double sx, double sy, double sz, double ex, double ey, double ez){
        return set((float)sx, (float)sy, (float)sz, (float)ex, (float)ey, (float)ez);
    }

    public AABB set(float[] arr){
        return set(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
    }

    public abstract <AB> AB local();

    public abstract Object direct();

    public abstract AABB offset(int x, int y, int z);

    public abstract AABB offset(V3D vec);

    @Override
    public String toString(){
        return direct().toString();
    }

    public abstract boolean contains(V3D vec);

    public abstract boolean contains(Object vec);
}
