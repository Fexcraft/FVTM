package net.fexcraft.mod.fvtm.data.block;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public enum BlockType {

    GENERIC_4ROT(4),
    GENERIC_4X4ROT(44),
    GENERIC_8ROT(8),
    GENERIC_16ROT(16),
    GENERIC_SIMPLE(0),
    GENERIC_2VAR(0),
    GENERIC_3VAR(0),
    GENERIC_4VAR(0),
    GENERIC_5VAR(0),
    GENERIC_6VAR(0),
    GENERIC_7VAR(0),
    GENERIC_8VAR(0),
    GENERIC_9VAR(0),
    GENERIC_10VAR(0),
    GENERIC_11VAR(0),
    GENERIC_12VAR(0),
    GENERIC_13VAR(0),
    GENERIC_14VAR(0),
    GENERIC_15VAR(0),
    GENERIC_16VAR(0),
    GENERIC_ROAD(0),
    GENERIC_ROAD_MARKER(0),
    GENERIC_ROAD_MARKER_4ROT(4),
    GENERIC_ROAD_LINES(0),
    MULTIBLOCK_4ROT(4),
    SIGNAL_4ROT(4),
    SIGNAL_16ROT(16),
    FORK2_SWITCH_4ROT(4),
    FORK3_SWITCH_4ROT(4),
    DOUBLE_SWITCH_4ROT(4),
    GENERIC_POST_LIKE(4),
    ;

    public static GetBlockTypeImpl BLOCK_IMPL = null;
    public int rotations;

    BlockType(int rots){
        rotations = rots;
    }

	@FunctionalInterface
    public static interface GetBlockTypeImpl {

        public Class get(BlockType type, boolean functional, boolean plainmodel);

    }

    public double getRotationFor(int state){
        if(rotations == 4){
            switch(state){
                case 2: return 90;
                case 3: return -90;
                case 4: return 180;
                case 5: return 0;
            }
        }
        else if(rotations == 8){
            return state * -45 + 90;
        }
        else if(rotations == 16){
            return state * -22.5 + 90;
        }
        else if(rotations == 44){
            state %= 4;
            switch(state){
                case 0: return 90;
                case 1: return -90;
                case 2: return 180;
                case 3: return 0;
            }
        }
        return 0;
    }
    public double getRelayRotFor(int state){
        if(rotations == 4){
            switch(state){
                case 2: return 90;
                case 3: return -90;
                case 4: return 0;
                case 5: return 180;
            }
        }
        else if(rotations == 8){
            return state * 45 + 90;
        }
        else if(rotations == 16){
            return state * 22.5 + 90;
        }
        else if(rotations == 44){
            state %= 4;
            switch(state){
                case 0: return 90;
                case 1: return -90;
                case 2: return 0;
                case 3: return 180;
            }
        }
        return 0;
    }

    public boolean isGenericRoad(){
        return this == GENERIC_ROAD;
    }

	public boolean isRoadLayer(){
		return this == GENERIC_ROAD_LINES || this == GENERIC_ROAD_MARKER || this == GENERIC_ROAD_MARKER_4ROT;
	}

    public boolean isMultiBlock(){
        return this == MULTIBLOCK_4ROT;
    }

    public boolean isRailBlock(){
        return this == SIGNAL_16ROT || this == SIGNAL_4ROT || this == FORK2_SWITCH_4ROT || this == FORK3_SWITCH_4ROT || this == DOUBLE_SWITCH_4ROT;
    }

    public boolean is4Rot(){
        return rotations == 4;
    }

    public boolean is8Rot(){
        return rotations == 8;
    }

    public boolean is16Rot(){
        return rotations == 16;
    }

    public int getMetaVariants(){
        switch(this){
            case GENERIC_2VAR: return 2;
            case GENERIC_3VAR: return 3;
            case GENERIC_4VAR: return 4;
            case GENERIC_5VAR: return 5;
            case GENERIC_6VAR: return 6;
            case GENERIC_7VAR: return 7;
            case GENERIC_8VAR: return 8;
            case GENERIC_9VAR: return 9;
            case GENERIC_10VAR: return 10;
            case GENERIC_11VAR: return 11;
            case GENERIC_12VAR: return 12;
            case GENERIC_13VAR: return 13;
            case GENERIC_14VAR: return 14;
            case GENERIC_15VAR: return 15;
            case GENERIC_16VAR: return 16;
            case GENERIC_4X4ROT: return 4;
            case GENERIC_ROAD: return 16;
            default: return 0;
        }
    }

    public boolean isVariant(){
        return this == GENERIC_4X4ROT || (this.ordinal() >= GENERIC_2VAR.ordinal() && this.ordinal() <= GENERIC_ROAD.ordinal());
    }

}
