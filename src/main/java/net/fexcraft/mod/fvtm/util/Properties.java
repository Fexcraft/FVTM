package net.fexcraft.mod.fvtm.util;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.EnumFacing;

public class Properties {
	
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);
    public static final PropertyInteger VARIANTS16 = PropertyInteger.create("variant", 0, 15);
    public static final PropertyInteger VARIANTS15 = PropertyInteger.create("variant", 0, 14);
    public static final PropertyInteger VARIANTS14 = PropertyInteger.create("variant", 0, 13);
    public static final PropertyInteger VARIANTS13 = PropertyInteger.create("variant", 0, 12);
    public static final PropertyInteger VARIANTS12 = PropertyInteger.create("variant", 0, 11);
    public static final PropertyInteger VARIANTS11 = PropertyInteger.create("variant", 0, 10);
    public static final PropertyInteger VARIANTS10 = PropertyInteger.create("variant", 0, 9);
    public static final PropertyInteger VARIANTS9 = PropertyInteger.create("variant", 0, 8);
    public static final PropertyInteger VARIANTS8 = PropertyInteger.create("variant", 0, 7);
    public static final PropertyInteger VARIANTS7 = PropertyInteger.create("variant", 0, 6);
    public static final PropertyInteger VARIANTS6 = PropertyInteger.create("variant", 0, 5);
    public static final PropertyInteger VARIANTS5 = PropertyInteger.create("variant", 0, 4);
    public static final PropertyInteger VARIANTS4 = PropertyInteger.create("variant", 0, 3);
    public static final PropertyInteger VARIANTS3 = PropertyInteger.create("variant", 0, 2);
    public static final PropertyInteger VARIANTS2 = PropertyInteger.create("variant", 0, 1);
    public static final PropertyBool POWERED = PropertyBool.create("powered");

}
