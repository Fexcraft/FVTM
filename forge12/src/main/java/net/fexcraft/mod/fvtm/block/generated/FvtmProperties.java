package net.fexcraft.mod.fvtm.block.generated;

import net.fexcraft.mod.fvtm.data.block.BlockType;
import net.fexcraft.mod.uni.world.StateWrapper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.HashMap;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.lib.common.Static.thirtysecondth;
import static net.fexcraft.mod.uni.world.StateWrapper.PROP_REGISTRY;
import static net.minecraft.block.Block.FULL_BLOCK_AABB;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class FvtmProperties {
	
    public static final PropertyDirection FACING = reg("facing", PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL));
	public static final PropertyInteger ROTATION = reg("rot16", "rotation", PropertyInteger.create("rotation", 0, 15));
    public static final PropertyInteger ROTATION8 = reg("rot8", PropertyInteger.create("rotation", 0, 7));
	public static final PropertyInteger LAYER8 = reg("layer", PropertyInteger.create("layer", 0, 7));
    public static final PropertyInteger VARIANTS16 = reg("variant16", "variant", PropertyInteger.create("variant", 0, 15));
    public static final PropertyInteger VARIANTS15 = reg("variant15", PropertyInteger.create("variant", 0, 14));
    public static final PropertyInteger VARIANTS14 = reg("variant14", PropertyInteger.create("variant", 0, 13));
    public static final PropertyInteger VARIANTS13 = reg("variant13", PropertyInteger.create("variant", 0, 12));
    public static final PropertyInteger VARIANTS12 = reg("variant12", PropertyInteger.create("variant", 0, 11));
    public static final PropertyInteger VARIANTS11 = reg("variant11", PropertyInteger.create("variant", 0, 10));
    public static final PropertyInteger VARIANTS10 = reg("variant10", PropertyInteger.create("variant", 0, 9));
    public static final PropertyInteger VARIANTS9 = reg("variant9", PropertyInteger.create("variant", 0, 8));
    public static final PropertyInteger VARIANTS8 = reg("variant8", PropertyInteger.create("variant", 0, 7));
    public static final PropertyInteger VARIANTS7 = reg("variant7", PropertyInteger.create("variant", 0, 6));
    public static final PropertyInteger VARIANTS6 = reg("variant6", PropertyInteger.create("variant", 0, 5));
    public static final PropertyInteger VARIANTS5 = reg("variant5", PropertyInteger.create("variant", 0, 4));
    public static final PropertyInteger VARIANTS4 = reg("variant4", PropertyInteger.create("variant", 0, 3));
    public static final PropertyInteger VARIANTS3 = reg("variant3", PropertyInteger.create("variant", 0, 2));
    public static final PropertyInteger VARIANTS2 = reg("variant2", PropertyInteger.create("variant", 0, 1));
    public static final PropertyBool POWERED = reg("powered", PropertyBool.create("powered"));
    public static final PropertyBool UP = reg("up", PropertyBool.create("up"));
    public static final PropertyBool DOWN = reg("down", PropertyBool.create("down"));
    public static final PropertyBool BASE = reg("base", PropertyBool.create("base"));
	//
	public static final PropertyInteger HEIGHT = reg("height", PropertyInteger.create("height", 0, 15));
	public static final PropertyInteger LINE_TYPE = reg("line_type", PropertyInteger.create("line_type", 0, 3));
	public static final PropertyInteger LINE_ROT = reg("line_rot", PropertyInteger.create("line_rot", 0, 3));
	public static final PropertyBool PATTERN_ROOT = reg("patter_root", PropertyBool.create("pattern_root"));
	public static final HashMap<Integer, PropertyInteger> PATTERN_X = new HashMap<>();
	public static final HashMap<Integer, PropertyInteger> PATTERN_Z = new HashMap<>();
	static {
		for(int i = 1; i < 8; i++){
			PATTERN_X.put(i, reg("pattern_x" + i, PropertyInteger.create("pattern_x", 0, i)));
			PATTERN_Z.put(i, reg("pattern_z" + i, PropertyInteger.create("pattern_z", 0, i)));
		}
		reg("pattern_x", PATTERN_X.get(7));
		reg("pattern_z", PATTERN_Z.get(7));
	}
	//
	public static final AxisAlignedBB[] ROAD_AABBS = new AxisAlignedBB[16];
	public static AxisAlignedBB[] LOWER_AABBS = new AxisAlignedBB[16];
	static{
		ROAD_AABBS[0] = FULL_BLOCK_AABB;
		for(int i = 1; i < 16; i++){
			ROAD_AABBS[i] = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, i * sixteenth, 1.0D);
		}
		LOWER_AABBS[0] = new AxisAlignedBB(0.0, 0.0, 0.0, 1, thirtysecondth, 1);
		for(int i = 1; i < 16; i++){
			LOWER_AABBS[i] = new AxisAlignedBB(0, -1 + i * sixteenth, 0, 1, -1 + i * sixteenth + thirtysecondth, 1);
		}
	}

	private static <V extends IProperty<?>> V reg(String regid, V prop){
		PROP_REGISTRY.put(regid, prop);
		return prop;
	}

	private static <V extends IProperty<?>> V reg(String regid, String alt, V prop){
		PROP_REGISTRY.put(regid, prop);
		PROP_REGISTRY.put(alt, prop);
		return prop;
	}

    public static PropertyInteger getIntProperty(BlockType type){
        switch(type){
            case GENERIC_2VAR: return FvtmProperties.VARIANTS2;
            case GENERIC_3VAR: return FvtmProperties.VARIANTS3;
            case GENERIC_4VAR:
            case GENERIC_4X4ROT: return FvtmProperties.VARIANTS4;
            case GENERIC_5VAR: return FvtmProperties.VARIANTS5;
            case GENERIC_6VAR: return FvtmProperties.VARIANTS6;
            case GENERIC_7VAR: return FvtmProperties.VARIANTS7;
            case GENERIC_8VAR: return FvtmProperties.VARIANTS8;
            case GENERIC_9VAR: return FvtmProperties.VARIANTS9;
            case GENERIC_10VAR: return FvtmProperties.VARIANTS10;
            case GENERIC_11VAR: return FvtmProperties.VARIANTS11;
            case GENERIC_12VAR: return FvtmProperties.VARIANTS12;
            case GENERIC_13VAR: return FvtmProperties.VARIANTS13;
            case GENERIC_14VAR: return FvtmProperties.VARIANTS14;
            case GENERIC_15VAR: return FvtmProperties.VARIANTS15;
            case GENERIC_16VAR: return FvtmProperties.VARIANTS16;
            default: break;
        }
        return FvtmProperties.VARIANTS16;
    }

}
