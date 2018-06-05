package net.fexcraft.mod.fvtm.model;

import net.fexcraft.mod.lib.tmt.EmptyModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;

public class ModelHitbox extends EmptyModelBase {

    private static final ModelHitbox instance = new ModelHitbox();
    public ModelRendererTurbo hitbox;

    public ModelHitbox(){
        hitbox = new ModelRendererTurbo(this, 1, 1, 16, 16);
        //hitbox.addBox(0F, 0F, 0F, 1, 1, 1, 0F); // Box 23
        hitbox.addShapeBox(0F, 0F, 0F, 1, 1, 1, 0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
        hitbox.setRotationPoint(-0.5f, -0.5f, -0.5f);
    }

    @Override
    public void render(){
        hitbox.render();
        return;
    }

    public static ModelHitbox instance(){
        return instance;
    }

}
