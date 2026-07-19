package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.Program;

/**
 * Dedicated Programs for Baked Block Models
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedPrograms {

    public static UVLock UVLOCK;
    public static UVLock UVLOCK_FULL;

    public static void init(){
        ModelGroup.PROGRAMS.add(new TextureSetter("minecraft:textures/blocks/stone.png"));
        ModelGroup.PROGRAMS.add(new ColorSetter(0x32a852));
        ModelGroup.PROGRAMS.add(UVLOCK = new UVLock(false));
        ModelGroup.PROGRAMS.add(UVLOCK_FULL = new UVLock(true));
    }

    public static abstract class BakedProgram implements Program {

        @Override
        public boolean pre(){
            return false;
        }

        @Override
        public boolean post(){
            return false;
        }

    }

    public static class TextureSetter extends BakedProgram {

        public final String texture;

        public TextureSetter(String str){
            texture = str;
        }

        @Override
        public String id(){
            return "fvtm:set_texture";
        }

        @Override
        public Program parse(String[] args){
            return new TextureSetter(args[0]);
        }

    }

    public static class ColorSetter extends BakedProgram {

        public final float[] color;
        public final int int_color;

        public ColorSetter(int col){
            color = new RGB(int_color = col).toFloatArray();
        }

        public ColorSetter(String col){
            RGB rgb = new RGB(col);
            int_color = rgb.packed;
            color = rgb.toFloatArray();
        }

        @Override
        public String id(){
            return "fvtm:set_color";
        }

        @Override
        public Program parse(String[] args){
            return new ColorSetter(args[0]);
        }

    }

    public static class UVLock extends BakedProgram {

        public boolean full;

        public UVLock(boolean bool){
            full = bool;
        }

        @Override
        public String id(){
            return "fvtm:baked_uv_lock";
        }

        @Override
        public Program parse(String[] args){
            return args.length == 0 || !Boolean.parseBoolean(args[0]) ? UVLOCK : UVLOCK_FULL;
        }
    }

    public static float[] rotateUV(float u, float v, int rot){
        switch(rot){
            case 1: return new float[]{ v, 1 - u };
            case -1: return new float[]{ 1 - v, u };
            case 2: return new float[]{ 1 - u, 1 - v };
            case 0:
            default: return new float[]{ u, v };
        }
    }

}
