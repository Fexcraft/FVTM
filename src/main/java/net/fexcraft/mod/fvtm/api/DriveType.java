package net.fexcraft.mod.fvtm.api;

public enum DriveType {

    TRACKS, FWD, RWD, AWD;

    public boolean hasTracks(){
        return this == TRACKS;
    }

    public boolean isFWD(){
        return this == FWD;
    }

    public boolean isRWD(){
        return this == RWD;
    }

    public boolean is4WD(){
        return this == AWD;
    }

    public static DriveType fromString(String string){
        switch(string){
            case "fwd":
            case "front": {
                return FWD;
            }
            case "rwd":
            case "rear": {
                return RWD;
            }
            case "4wd":
            case "four":
            case "awd": {
                return AWD;
            }
            case "tracks":
            case "tank":
            case "catepillar": {
                return TRACKS;
            }
        }
        return FWD;
    }

}
