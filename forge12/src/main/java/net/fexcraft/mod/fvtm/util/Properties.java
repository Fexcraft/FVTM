package net.fexcraft.mod.fvtm.util;

import net.fexcraft.mod.fvtm.block.Asphalt;
import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.EnumFacing;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Properties {
	
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);
    public static final PropertyInteger ROTATION8 = PropertyInteger.create("rotation", 0, 7);
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
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    public static final PropertyBool BASE = PropertyBool.create("base");

    public static PropertyInteger getIntProperty(BlockType type){
        switch(type){
            case GENERIC_2VAR: return Properties.VARIANTS2;
            case GENERIC_3VAR: return Properties.VARIANTS3;
            case GENERIC_4VAR:
            case GENERIC_4X4ROT: return Properties.VARIANTS4;
            case GENERIC_5VAR: return Properties.VARIANTS5;
            case GENERIC_6VAR: return Properties.VARIANTS6;
            case GENERIC_7VAR: return Properties.VARIANTS7;
            case GENERIC_8VAR: return Properties.VARIANTS8;
            case GENERIC_9VAR: return Properties.VARIANTS9;
            case GENERIC_10VAR: return Properties.VARIANTS10;
            case GENERIC_11VAR: return Properties.VARIANTS11;
            case GENERIC_12VAR: return Properties.VARIANTS12;
            case GENERIC_13VAR: return Properties.VARIANTS13;
            case GENERIC_14VAR: return Properties.VARIANTS14;
            case GENERIC_15VAR: return Properties.VARIANTS15;
            case GENERIC_16VAR: return Properties.VARIANTS16;
            default: break;
        }
        return Properties.VARIANTS16;
    }

    public static IProperty<?> getProperty(BlockType type){
        switch(type){
            case GENERIC_4ROT:
            case GENERIC_4X4ROT:
            case MULTIBLOCK_4ROT:
            case SIGNAL_4ROT:
            case FORK2_SWITCH_4ROT:
            case FORK3_SWITCH_4ROT:
            case DOUBLE_SWITCH_4ROT:
                return Properties.FACING;
            case GENERIC_8ROT:
                return Properties.ROTATION8;
            case GENERIC_16ROT:
            case SIGNAL_16ROT:
                return Properties.ROTATION;
            case GENERIC_SIMPLE:
                return null;
            case GENERIC_2VAR:
                return Properties.VARIANTS2;
            case GENERIC_3VAR:
                return Properties.VARIANTS3;
            case GENERIC_4VAR:
                return Properties.VARIANTS4;
            case GENERIC_5VAR:
                return Properties.VARIANTS5;
            case GENERIC_6VAR:
                return Properties.VARIANTS6;
            case GENERIC_7VAR:
                return Properties.VARIANTS7;
            case GENERIC_8VAR:
                return Properties.VARIANTS8;
            case GENERIC_9VAR:
                return Properties.VARIANTS9;
            case GENERIC_10VAR:
                return Properties.VARIANTS10;
            case GENERIC_11VAR:
                return Properties.VARIANTS11;
            case GENERIC_12VAR:
                return Properties.VARIANTS12;
            case GENERIC_13VAR:
                return Properties.VARIANTS13;
            case GENERIC_14VAR:
                return Properties.VARIANTS14;
            case GENERIC_15VAR:
                return Properties.VARIANTS15;
            case GENERIC_16VAR:
                return Properties.VARIANTS16;
            case GENERIC_ROAD:
                return Asphalt.HEIGHT;
        }
        return null;
    }

}
