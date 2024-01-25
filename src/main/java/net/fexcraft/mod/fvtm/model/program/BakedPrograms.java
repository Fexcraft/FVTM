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

    public static void init(){
        ModelGroup.PROGRAMS.add(new TextureSetter("minecraft:textures/blocks/stone.png"));
        ModelGroup.PROGRAMS.add(new ColorSetter(0x32a852));
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

        public ColorSetter(int col){
            color = new RGB(col).toFloatArray();
        }

        public ColorSetter(String col){
            color = new RGB(col).toFloatArray();
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

}
