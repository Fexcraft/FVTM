package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class BakedPrograms {

    public static void init(){
        ModelGroup.PROGRAMS.add(new TextureSetter("minecraft:textures/blocks/stone.png"));
    }

    public static class TextureSetter implements Program {

        public final String texture;

        public TextureSetter(String str){
            texture = str;
        }

        @Override
        public String id(){
            return "fvtm:set_texture";
        }


        @Override
        public boolean pre(){
            return false;
        }

        @Override
        public boolean post(){
            return false;
        }

        @Override
        public Program parse(String[] args){
            return new TextureSetter(args[0]);
        }

    }

}
