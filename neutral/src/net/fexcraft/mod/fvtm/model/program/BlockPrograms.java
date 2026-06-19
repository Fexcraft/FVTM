package net.fexcraft.mod.fvtm.model.program;

import net.fexcraft.lib.frl.Renderer;
import net.fexcraft.mod.fvtm.data.block.FvtmBlockEntity.SignalBE;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import net.fexcraft.mod.fvtm.model.Program;
import org.apache.commons.lang3.math.NumberUtils;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.model.ProgramUtils.FLOAT_SUPP;

/**
 * Dedicated Programs for Block Models
 *
 * @author Ferdinand Calo' (FEX___96)
 */
public class BlockPrograms {

    public static void init(){
        ModelGroup.PROGRAMS.add(new BlockBoolRotator("", true, 0, 0, 0, 0, 0f));
        ModelGroup.PROGRAMS.add(new BlockBoolTranslator("", true, 0, 0, 0, 0));
        ModelGroup.PROGRAMS.add(new BlockBoolVisible("", true));
        ModelGroup.PROGRAMS.add(new Block4x4RotVisible(0));
        ModelGroup.PROGRAMS.add(new BlockVariantVisible(0));
        ModelGroup.PROGRAMS.add(new DefaultPrograms.AlwaysGlow(){
            public boolean shouldGlow(ModelGroup list, ModelRenderData data){
                return data.block_entity != null && ((SignalBE)data.block_entity).getSignalState() == 1;
            }
            public String id(){
                return "fvtm:basic_signal_clear";
            }
        });
        ModelGroup.PROGRAMS.add(new DefaultPrograms.AlwaysGlow(){
            public boolean shouldGlow(ModelGroup list, ModelRenderData data){
                return data.block_entity == null || ((SignalBE)data.block_entity).getSignalState() == 0;
            }
            public String id(){
                return "fvtm:basic_signal_stop";
            }
        });
    }

    public static abstract class BlockBoolBased implements Program {

        protected String key;

        public BlockBoolBased(String key){
            this.key = key;
        }

        @Override
        public void init(ModelGroup list){
            //
        }

    }

    public static class BlockBoolRotator extends BlockBoolBased {

        private String key;
        private float min, max, step = 1;
        private Float current;
        private int axis;
        private boolean equals, override;
        private float defrot;

        public BlockBoolRotator(String key, boolean equals, float mn, float mx, float step, int axis, Float defrot){
            super(key);
            this.equals = equals;
            this.override = true;
            this.min = mn;
            this.max = mx;
            this.step = step;
            this.axis = axis;
            this.defrot = defrot == null ? 0 : defrot;
            if(min == max || (min == 0f && max == 0f)){
                min = -360; max = 360;
            }
        }

        public BlockBoolRotator(String key, boolean equals, float min, float max, float step, int axis, Float defrot, boolean notadditive){
            this(key, equals, min, max, step, axis, defrot);
            this.override = notadditive;
        }

        @Override
        public String id(){
            return "fvtm:block_bool_rotator";
        }

        @Override
        public void pre(ModelGroup list, ModelRenderData data){
            if(data.cache == null || data.block == null) return;
            current = data.cache.get(this, FLOAT_SUPP);
            if(current == null) current = 0f;
            current = data.block.getFunctionBool(key) == equals ? current + step : current - step;
            if(current > max) current = max;
            if(current < min) current = min;
            list.rotate(current + defrot, axis, override);
            data.cache.set(this, current);
        }

        @Override
        public void post(ModelGroup list, ModelRenderData data){
            if(data.cache == null || data.block == null) return;
            list.rotate(override ? defrot : -(current + defrot), axis, override);
            current = 0f;
        }


        @Override
        public Program parse(String[] args){
            String attr = args[0];
            boolean equals = Boolean.parseBoolean(args[1]);
            float min = Float.parseFloat(args[2]);
            float max = Float.parseFloat(args[3]);
            float step = Float.parseFloat(args[4]);
            int axis = Integer.parseInt(args[5]);
            Float defrot = args.length > 6 && NumberUtils.isCreatable(args[6]) ? Float.parseFloat(args[6]) : null;
            return new BlockBoolRotator(attr, equals, min, max, step, axis, defrot, args.length >= 7 && Boolean.parseBoolean(args[7]));
        }

    }

    public static class BlockBoolTranslator extends BlockBoolBased {

        private boolean bool;
        private float min, max, step;
        private Float current;
        private int axis;

        public BlockBoolTranslator(String key, boolean equals, float min, float max, float step, int axis){
            super(key);
            this.bool = equals;
            this.axis = axis;
            this.step = step;
            this.min = min;
            this.max = max;
        }

        @Override
        public String id(){
            return "fvtm:block_bool_translator";
        }

        @Override
        public void pre(ModelGroup list, ModelRenderData data){
            if(data.cache == null || data.block == null) return;
            current = data.cache.get(this, FLOAT_SUPP);
            if(current == null) current = 0f;
            current = data.block.getFunctionBool(key) == bool ? current + step : current - step;
            if(current > max) current = max; if(current < min) current = min;
            //GL11.glPushMatrix();
            Renderer.RENDERER.translate(
                axis == 0 ? current * sixteenth : 0,
                axis == 1 ? current * sixteenth : 0,
                axis == 2 ? current * sixteenth : 0);
            data.cache.set(this, current);
        }

        @Override
        public void post(ModelGroup list, ModelRenderData data){
            if(data.cache == null || data.block == null) return;
            Renderer.RENDERER.translate(
                    axis == 0 ? current * -sixteenth : 0,
                    axis == 1 ? current * -sixteenth : 0,
                    axis == 2 ? current * -sixteenth : 0);
            //GL11.glPopMatrix();
        }

        @Override
        public Program parse(String[] args){
            String attr = args[0];
            boolean equals = Boolean.parseBoolean(args[1]);
            float min = Float.parseFloat(args[2]);
            float max = Float.parseFloat(args[3]);
            float step = Float.parseFloat(args[4]);
            int axis = Integer.parseInt(args[5]);
            return new BlockBoolTranslator(attr, equals, min, max, step, axis);
        }

    }

    public static class BlockBoolVisible implements Program {

        private String key;
        private boolean equals;

        public BlockBoolVisible(String key, boolean equals){
            this.key = key;
            this.equals = equals;
        }

        @Override
        public String id(){
            return "fvtm:block_bool_visible";
        }

        @Override
        public void pre(ModelGroup list, ModelRenderData data){
            if(data.block == null) return;
            if(data.block.getFunctionBool(key) != equals) list.visible = false;
        }

        @Override
        public void post(ModelGroup list, ModelRenderData data){
            list.visible = true;
        }

        @Override
        public Program parse(String[] args){
            return new BlockBoolVisible(args[0], args.length < 2 || Boolean.parseBoolean(args[1]));
        }

    }

    public static class Block4x4RotVisible implements Program {

        private int equals;

        public Block4x4RotVisible(int var){
            this.equals = var;
        }

        @Override
        public String id(){
            return "fvtm:block_4x4rot_visible";
        }

        @Override
        public void pre(ModelGroup list, ModelRenderData data){
            if(data.block_entity == null) return;
            list.visible = data.block_entity.getMeta() / 4 == equals;
        }

        @Override
        public void post(ModelGroup list, ModelRenderData data){
            list.visible = true;
        }

        @Override
        public Program parse(String[] args){
            return new Block4x4RotVisible(Integer.parseInt(args[0]));
        }

    }

    public static class BlockVariantVisible implements Program {

        private int equals;

        public BlockVariantVisible(int var){
            this.equals = var;
        }

        @Override
        public String id(){
            return "fvtm:block_variant_visible";
        }

        @Override
        public void pre(ModelGroup list, ModelRenderData data){
            if(data.block_entity == null) return;
            list.visible = data.block_entity.getMeta() == equals;
        }

        @Override
        public void post(ModelGroup list, ModelRenderData data){
            list.visible = true;
        }

        @Override
        public Program parse(String[] args){
            return new BlockVariantVisible(Integer.parseInt(args[0]));
        }

    }

}
