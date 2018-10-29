package net.fexcraft.mod.addons.hcp.models.part;

import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.part.PartModelTMT;
import net.fexcraft.mod.fvtm.util.RenderCache;
import net.minecraft.entity.Entity;

/**
 *
 * @author Ferdinand (FEX___96)
 */
public class TR1Type1 extends PartModelTMT {
    
    private ModelRendererTurbo[] door_left, door_right, door_left_lights, door_right_lights;

    public TR1Type1(){
    	super(); this.addToCreators("FEX___96");
        textureX = 512; textureY = 512;
        body = new ModelRendererTurbo[13];
		body[0] = new ModelRendererTurbo(this, 1, 1, textureX, textureY); // Box 0
		body[1] = new ModelRendererTurbo(this, 1, 57, textureX, textureY); // Box 1
		body[2] = new ModelRendererTurbo(this, 1, 113, textureX, textureY); // Box 2
		body[3] = new ModelRendererTurbo(this, 1, 169, textureX, textureY); // Box 3
		body[4] = new ModelRendererTurbo(this, 265, 1, textureX, textureY); // Box 4
		body[5] = new ModelRendererTurbo(this, 281, 1, textureX, textureY); // Box 5
		body[6] = new ModelRendererTurbo(this, 297, 1, textureX, textureY); // Box 6
		body[7] = new ModelRendererTurbo(this, 313, 1, textureX, textureY); // Box 7
		body[8] = new ModelRendererTurbo(this, 329, 1, textureX, textureY); // Box 8
		body[9] = new ModelRendererTurbo(this, 345, 1, textureX, textureY); // Box 9
		body[10] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 10
		body[11] = new ModelRendererTurbo(this, 1, 225, textureX, textureY); // Box 11
		body[12] = new ModelRendererTurbo(this, 1, 281, textureX, textureY); // Box 12

		body[0].addBox(0F, 0F, 0F, 128, 48, 1, 0F); // Box 0
		body[0].setRotationPoint(-236F, -72F, -26F);

		body[1].addBox(0F, 0F, 0F, 128, 48, 1, 0F); // Box 1
		body[1].setRotationPoint(-108F, -72F, -26F);

		body[2].addBox(0F, 0F, 0F, 128, 48, 1, 0F); // Box 2
		body[2].setRotationPoint(-236F, -72F, 25F);

		body[3].addBox(0F, 0F, 0F, 128, 48, 1, 0F); // Box 3
		body[3].setRotationPoint(-108F, -72F, 25F);

		body[4].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 4
		body[4].setRotationPoint(17F, -72F, -25F);

		body[5].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 5
		body[5].setRotationPoint(-109F, -72F, -25F);

		body[6].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 6
		body[6].setRotationPoint(-235F, -72F, -25F);

		body[7].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 7
		body[7].setRotationPoint(-235F, -72F, 23F);

		body[8].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 8
		body[8].setRotationPoint(-109F, -72F, 23F);

		body[9].addBox(0F, 0F, 0F, 2, 48, 2, 0F); // Box 9
		body[9].setRotationPoint(17F, -72F, 23F);

		body[10].addBox(0F, 0F, 0F, 1, 48, 50, 0F); // Box 10
		body[10].setRotationPoint(19F, -72F, -25F);

		body[11].addBox(0F, 0F, 0F, 128, 2, 52, 0F); // Box 11
		body[11].setRotationPoint(-108F, -74F, -26F);

		body[12].addBox(0F, 0F, 0F, 128, 2, 52, 0F); // Box 12
		body[12].setRotationPoint(-236F, -74F, -26F);


		door_right = new ModelRendererTurbo[8];
		door_right[0] = new ModelRendererTurbo(this, 321, 81, textureX, textureY); // Box 14
		door_right[1] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 15
		door_right[2] = new ModelRendererTurbo(this, 361, 1, textureX, textureY); // Box 23
		door_right[3] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 24
		door_right[4] = new ModelRendererTurbo(this, 425, 1, textureX, textureY); // Box 25
		door_right[5] = new ModelRendererTurbo(this, 441, 1, textureX, textureY); // Box 26
		door_right[6] = new ModelRendererTurbo(this, 457, 1, textureX, textureY); // Box 27
		door_right[7] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 28

		door_right[0].addBox(-0.5F, 0F, -25F, 1, 48, 25, 0F); // Box 14
		door_right[0].setRotationPoint(-235.5F, -72F, 25F);

		door_right[1].addBox(-0.7F, 43F, -9F, 1, 4, 8, 0F); // Box 15
		door_right[1].setRotationPoint(-235.5F, -72F, 25F);

		door_right[2].addBox(-0.7F, 3F, -24F, 1, 1, 1, 0F); // Box 23
		door_right[2].setRotationPoint(-235.5F, -72F, 25F);

		door_right[3].addBox(-0.7F, 11F, -24F, 1, 1, 1, 0F); // Box 24
		door_right[3].setRotationPoint(-235.5F, -72F, 25F);

		door_right[4].addBox(-0.7F, 19F, -24F, 1, 1, 1, 0F); // Box 25
		door_right[4].setRotationPoint(-235.5F, -72F, 25F);

		door_right[5].addBox(-0.7F, 27F, -24F, 1, 1, 1, 0F); // Box 26
		door_right[5].setRotationPoint(-235.5F, -72F, 25F);

		door_right[6].addBox(-0.7F, 36F, -24F, 1, 1, 1, 0F); // Box 27
		door_right[6].setRotationPoint(-235.5F, -72F, 25F);

		door_right[7].addBox(-0.7F, 44F, -24F, 1, 1, 1, 0F); // Box 28
		door_right[7].setRotationPoint(-235.5F, -72F, 25F);


		door_left = new ModelRendererTurbo[8];
		door_left[0] = new ModelRendererTurbo(this, 265, 33, textureX, textureY); // Box 13
		door_left[1] = new ModelRendererTurbo(this, 385, 1, textureX, textureY); // Box 16
		door_left[2] = new ModelRendererTurbo(this, 377, 1, textureX, textureY); // Box 17
		door_left[3] = new ModelRendererTurbo(this, 401, 1, textureX, textureY); // Box 18
		door_left[4] = new ModelRendererTurbo(this, 417, 1, textureX, textureY); // Box 19
		door_left[5] = new ModelRendererTurbo(this, 433, 1, textureX, textureY); // Box 20
		door_left[6] = new ModelRendererTurbo(this, 449, 1, textureX, textureY); // Box 21
		door_left[7] = new ModelRendererTurbo(this, 465, 1, textureX, textureY); // Box 22

		door_left[0].addBox(-0.5F, 0F, 0F, 1, 48, 25, 0F); // Box 13
		door_left[0].setRotationPoint(-235.5F, -72F, -25F);

		door_left[1].addBox(-0.7F, 43F, 1F, 1, 4, 8, 0F); // Box 16
		door_left[1].setRotationPoint(-235.5F, -72F, -25F);

		door_left[2].addBox(-0.7F, 3F, 23F, 1, 1, 3, 0F); // Box 17
		door_left[2].setRotationPoint(-235.5F, -72F, -25F);

		door_left[3].addBox(-0.7F, 11F, 23F, 1, 1, 3, 0F); // Box 18
		door_left[3].setRotationPoint(-235.5F, -72F, -25F);

		door_left[4].addBox(-0.7F, 19F, 23F, 1, 1, 3, 0F); // Box 19
		door_left[4].setRotationPoint(-235.5F, -72F, -25F);

		door_left[5].addBox(-0.7F, 27F, 23F, 1, 1, 3, 0F); // Box 20
		door_left[5].setRotationPoint(-235.5F, -72F, -25F);

		door_left[6].addBox(-0.7F, 36F, 23F, 1, 1, 3, 0F); // Box 21
		door_left[6].setRotationPoint(-235.5F, -72F, -25F);

		door_left[7].addBox(-0.7F, 44F, 23F, 1, 1, 3, 0F); // Box 22
		door_left[7].setRotationPoint(-235.5F, -72F, -25F);


		lights = new ModelRendererTurbo[34];
		lights[0] = new ModelRendererTurbo(this, 497, 9, textureX, textureY); // Box 39
		lights[1] = new ModelRendererTurbo(this, 361, 17, textureX, textureY); // Box 40
		lights[2] = new ModelRendererTurbo(this, 377, 17, textureX, textureY); // Box 41
		lights[3] = new ModelRendererTurbo(this, 393, 17, textureX, textureY); // Box 42
		lights[4] = new ModelRendererTurbo(this, 441, 17, textureX, textureY); // Box 43
		lights[5] = new ModelRendererTurbo(this, 457, 17, textureX, textureY); // Box 44
		lights[6] = new ModelRendererTurbo(this, 473, 17, textureX, textureY); // Box 45
		lights[7] = new ModelRendererTurbo(this, 489, 17, textureX, textureY); // Box 46
		lights[8] = new ModelRendererTurbo(this, 361, 25, textureX, textureY); // Box 47
		lights[9] = new ModelRendererTurbo(this, 377, 25, textureX, textureY); // Box 48
		lights[10] = new ModelRendererTurbo(this, 393, 25, textureX, textureY); // Box 49
		lights[11] = new ModelRendererTurbo(this, 417, 25, textureX, textureY); // Box 50
		lights[12] = new ModelRendererTurbo(this, 433, 25, textureX, textureY); // Box 51
		lights[13] = new ModelRendererTurbo(this, 449, 25, textureX, textureY); // Box 52
		lights[14] = new ModelRendererTurbo(this, 465, 25, textureX, textureY); // Box 53
		lights[15] = new ModelRendererTurbo(this, 481, 25, textureX, textureY); // Box 54
		lights[16] = new ModelRendererTurbo(this, 497, 25, textureX, textureY); // Box 55
		lights[17] = new ModelRendererTurbo(this, 361, 33, textureX, textureY); // Box 56
		lights[18] = new ModelRendererTurbo(this, 377, 33, textureX, textureY); // Box 57
		lights[19] = new ModelRendererTurbo(this, 393, 33, textureX, textureY); // Box 58
		lights[20] = new ModelRendererTurbo(this, 417, 33, textureX, textureY); // Box 59
		lights[21] = new ModelRendererTurbo(this, 433, 33, textureX, textureY); // Box 60
		lights[22] = new ModelRendererTurbo(this, 449, 33, textureX, textureY); // Box 61
		lights[23] = new ModelRendererTurbo(this, 465, 33, textureX, textureY); // Box 62
		lights[24] = new ModelRendererTurbo(this, 481, 33, textureX, textureY); // Box 63
		lights[25] = new ModelRendererTurbo(this, 497, 33, textureX, textureY); // Box 64
		lights[26] = new ModelRendererTurbo(this, 361, 41, textureX, textureY); // Box 65
		lights[27] = new ModelRendererTurbo(this, 377, 41, textureX, textureY); // Box 66
		lights[28] = new ModelRendererTurbo(this, 393, 41, textureX, textureY); // Box 67
		lights[29] = new ModelRendererTurbo(this, 417, 41, textureX, textureY); // Box 68
		lights[30] = new ModelRendererTurbo(this, 433, 41, textureX, textureY); // Box 69
		lights[31] = new ModelRendererTurbo(this, 449, 41, textureX, textureY); // Box 70
		lights[32] = new ModelRendererTurbo(this, 465, 41, textureX, textureY); // Box 71
		lights[33] = new ModelRendererTurbo(this, 481, 41, textureX, textureY); // Box 72

		lights[0].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 39
		lights[0].setRotationPoint(-234F, -73.5F, 25.2F);

		lights[1].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 40
		lights[1].setRotationPoint(-222F, -73.5F, 25.2F);

		lights[2].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 41
		lights[2].setRotationPoint(-206F, -73.5F, 25.2F);

		lights[3].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 42
		lights[3].setRotationPoint(-190F, -73.5F, 25.2F);

		lights[4].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 43
		lights[4].setRotationPoint(-174F, -73.5F, 25.2F);

		lights[5].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 44
		lights[5].setRotationPoint(-158F, -73.5F, 25.2F);

		lights[6].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 45
		lights[6].setRotationPoint(-142F, -73.5F, 25.2F);

		lights[7].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 46
		lights[7].setRotationPoint(-126F, -73.5F, 25.2F);

		lights[8].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 47
		lights[8].setRotationPoint(-110F, -73.5F, 25.2F);

		lights[9].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 48
		lights[9].setRotationPoint(-94F, -73.5F, 25.2F);

		lights[10].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 49
		lights[10].setRotationPoint(-78F, -73.5F, 25.2F);

		lights[11].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 50
		lights[11].setRotationPoint(-62F, -73.5F, 25.2F);

		lights[12].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 51
		lights[12].setRotationPoint(-46F, -73.5F, 25.2F);

		lights[13].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 52
		lights[13].setRotationPoint(-30F, -73.5F, 25.2F);

		lights[14].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 53
		lights[14].setRotationPoint(-14F, -73.5F, 25.2F);

		lights[15].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 54
		lights[15].setRotationPoint(2F, -73.5F, 25.2F);

		lights[16].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 55
		lights[16].setRotationPoint(14F, -73.5F, 25.2F);

		lights[17].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 56
		lights[17].setRotationPoint(-234F, -73.5F, -26.2F);

		lights[18].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 57
		lights[18].setRotationPoint(-222F, -73.5F, -26.2F);

		lights[19].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 58
		lights[19].setRotationPoint(-206F, -73.5F, -26.2F);

		lights[20].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 59
		lights[20].setRotationPoint(-190F, -73.5F, -26.2F);

		lights[21].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 60
		lights[21].setRotationPoint(-174F, -73.5F, -26.2F);

		lights[22].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 61
		lights[22].setRotationPoint(-158F, -73.5F, -26.2F);

		lights[23].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 62
		lights[23].setRotationPoint(-142F, -73.5F, -26.2F);

		lights[24].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 63
		lights[24].setRotationPoint(-126F, -73.5F, -26.2F);

		lights[25].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 64
		lights[25].setRotationPoint(-110F, -73.5F, -26.2F);

		lights[26].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 65
		lights[26].setRotationPoint(-94F, -73.5F, -26.2F);

		lights[27].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 66
		lights[27].setRotationPoint(-78F, -73.5F, -26.2F);

		lights[28].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 67
		lights[28].setRotationPoint(-62F, -73.5F, -26.2F);

		lights[29].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 68
		lights[29].setRotationPoint(-46F, -73.5F, -26.2F);

		lights[30].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 69
		lights[30].setRotationPoint(-30F, -73.5F, -26.2F);

		lights[31].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 70
		lights[31].setRotationPoint(-14F, -73.5F, -26.2F);

		lights[32].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 71
		lights[32].setRotationPoint(2F, -73.5F, -26.2F);

		lights[33].addBox(0F, 0F, 0F, 4, 1, 1, 0F); // Box 72
		lights[33].setRotationPoint(14F, -73.5F, -26.2F);


		door_left_lights = new ModelRendererTurbo[5];
		door_left_lights[0] = new ModelRendererTurbo(this, 473, 1, textureX, textureY); // Box 29
		door_left_lights[1] = new ModelRendererTurbo(this, 433, 9, textureX, textureY); // Box 35
		door_left_lights[2] = new ModelRendererTurbo(this, 441, 9, textureX, textureY); // Box 36
		door_left_lights[3] = new ModelRendererTurbo(this, 449, 9, textureX, textureY); // Box 37
		door_left_lights[4] = new ModelRendererTurbo(this, 457, 9, textureX, textureY); // Box 38

		door_left_lights[0].addBox(-0.7F, 1F, -9F, 1, 1, 8, 0F); // Box 29
		door_left_lights[0].setRotationPoint(-235.5F, -72F, 25F);

		door_left_lights[1].addBox(-0.7F, 6F, -2F, 1, 3, 1, 0F); // Box 35
		door_left_lights[1].setRotationPoint(-235.5F, -72F, 25F);

		door_left_lights[2].addBox(-0.7F, 16F, -2F, 1, 3, 1, 0F); // Box 36
		door_left_lights[2].setRotationPoint(-235.5F, -72F, 25F);

		door_left_lights[3].addBox(-0.7F, 26F, -2F, 1, 3, 1, 0F); // Box 37
		door_left_lights[3].setRotationPoint(-235.5F, -72F, 25F);

		door_left_lights[4].addBox(-0.7F, 36F, -2F, 1, 3, 1, 0F); // Box 38
		door_left_lights[4].setRotationPoint(-235.5F, -72F, 25F);


		door_right_lights = new ModelRendererTurbo[5];
		door_right_lights[0] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 30
		door_right_lights[1] = new ModelRendererTurbo(this, 489, 1, textureX, textureY); // Box 31
		door_right_lights[2] = new ModelRendererTurbo(this, 497, 1, textureX, textureY); // Box 32
		door_right_lights[3] = new ModelRendererTurbo(this, 505, 1, textureX, textureY); // Box 33
		door_right_lights[4] = new ModelRendererTurbo(this, 417, 9, textureX, textureY); // Box 34

		door_right_lights[0].addBox(-0.7F, 1F, 1F, 1, 1, 8, 0F); // Box 30
		door_right_lights[0].setRotationPoint(-235.5F, -72F, -25F);

		door_right_lights[1].addBox(-0.7F, 6F, 1F, 1, 3, 1, 0F); // Box 31
		door_right_lights[1].setRotationPoint(-235.5F, -72F, -25F);

		door_right_lights[2].addBox(-0.7F, 16F, 1F, 1, 3, 1, 0F); // Box 32
		door_right_lights[2].setRotationPoint(-235.5F, -72F, -25F);

		door_right_lights[3].addBox(-0.7F, 26F, 1F, 1, 3, 1, 0F); // Box 33
		door_right_lights[3].setRotationPoint(-235.5F, -72F, -25F);

		door_right_lights[4].addBox(-0.7F, 36F, 1F, 1, 3, 1, 0F); // Box 34
		door_right_lights[4].setRotationPoint(-235.5F, -72F, -25F);
    }
    
    @Override
    public void render(VehicleData data, String us){
        render(body);
        render(lights);
        render(door_left);
        render(door_right);
        render(door_left_lights);
        render(door_right_lights);
    }

    @Override
    public void render(VehicleData data, String us, Entity ent, int meta){
    	render(body);
    	float doortoggle = RenderCache.getData(ent, "tr1_type1_door", 0) + (data.doorsOpen() ? 1 : -1);
    	RenderCache.updateData(ent, "tr1_type1_door", doortoggle = doortoggle > 100 ? 100 : doortoggle < 0 ? 0 : doortoggle);
    	rotate(door_left, 0, Static.rad1 * -doortoggle, 0);
        render(door_left);
    	rotate(door_left, 0, Static.rad1 * doortoggle, 0);
    	rotate(door_right, 0, Static.rad1 * doortoggle, 0);
        render(door_right);
    	rotate(door_right, 0, Static.rad1 * -doortoggle, 0);
    	boolean ls = data.getLightsState() > 0;
    	if(ls){
            lightOff(ent);
        }
        render(lights);
    	rotate(door_left_lights, 0, Static.rad1 * doortoggle, 0);
        render(door_left_lights);
    	rotate(door_left_lights, 0, Static.rad1 * -doortoggle, 0);
    	rotate(door_right_lights, 0, Static.rad1 * -doortoggle, 0);
        render(door_right_lights);
    	rotate(door_right_lights, 0, Static.rad1 * doortoggle, 0);
        if(ls){
            lightOn(ent);
        }
    }

}
