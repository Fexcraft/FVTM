package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.lib.tmt.ModelBase;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class PartBaseModel extends GenericModel<VehicleData, String> {
	
    private RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	
	public PartBaseModel(){ super(); }
	
	public PartBaseModel(JsonObject obj){ super(obj); }
	
	@Override
	public void render(){
		//invalid render call for part model
    	render(submodels.get("body")); render(submodels.get("wheels"));
	}

	@Override
	public void render(VehicleData data, String key){
        //Body/Chassis
        render(submodels.get("body"));
        render(data.doorsOpen() ? submodels.get("body_door_open") : submodels.get("body_door_close"));
        
        //Primary Color
        data.getPrimaryColor().glColorApply();
        render(submodels.get("body_colored_primary"));
        render(data.doorsOpen() ? submodels.get("body_door_open_colored_primary") : submodels.get("body_door_close_colored_primary"));
        RGB.glColorReset();
        
        //Secondary Color
        data.getSecondaryColor().glColorApply();
        render(submodels.get("body_colored_secondary"));
        RGB.glColorReset();

        //Other
        render(submodels.get("turret"));
        render(submodels.get("steering"));

        //Wheels
        render(submodels.get("wheels"));
        render(submodels.get("wheel_front"));
        render(submodels.get("wheel_back"));
        render(submodels.get("wheel_front_right"));
        render(submodels.get("wheel_back_right"));
        render(submodels.get("wheel_front_left"));
        render(submodels.get("wheel_back_left"));
        //
        render(submodels.get("track_wheels"));
        render(submodels.get("track_wheels_right"));
        render(submodels.get("track_wheels_left"));
        //
        render(submodels.get("lights"));
        render(submodels.get("front_lights"));
        render(submodels.get("back_lights"));
        render(submodels.get("reverse_lights"));
        render(submodels.get("fog_lights"));
        //
        if(rq(submodels.get("windows"), submodels.get("windows_door_open"), submodels.get("windows_door_close"))){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render(submodels.get("windows"));
            render(data.doorsOpen() ? submodels.get("windows_door_open") : submodels.get("windows_door_close"));
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

	@Override
	public void render(VehicleData data, String key, Entity ent, int meta){
		VehicleEntity vehicle = (VehicleEntity)ent;
		
        //Body/Chassis
        render(submodels.get("body"));
        render(data.doorsOpen() ? submodels.get("body_door_open") : submodels.get("body_door_close"));

        //Primary Color
        data.getPrimaryColor().glColorApply();
        render(submodels.get("body_colored_primary"));
        render(data.doorsOpen() ? submodels.get("body_door_open_colored_primary") : submodels.get("body_door_close_colored_primary"));
        RGB.glColorReset();
        
        //Secondary Color
        data.getSecondaryColor().glColorApply();
        render(submodels.get("body_colored_secondary"));
        RGB.glColorReset();

        //Render Turret
        render(submodels.get("turret"));

        //Render Steering
        float steerangle = vehicle.getWheelsYaw() * 3.14159265F / 180F * 3F;
        for(ModelRendererTurbo elm : submodels.get("steering")){
        	elm.rotateAngleX = steerangle; elm.render();
        }

        //Render Wheels
        for(ModelRendererTurbo element : submodels.get("wheel_back_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheel_back_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheel_back")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheel_front_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheel_front_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheel_front")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.rotateAngleY = steerangle;
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("wheels")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("track_wheels")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("track_wheels_right")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        for(ModelRendererTurbo element : submodels.get("track_wheels_left")){
            element.rotateAngleZ = vehicle.getWheelsAngle();
            element.render();
        }
        //
        boolean s1 = data.getLightsState() > 0, s3 = data.getLightsState() > 2, sr = vehicle.getThrottle() < -0.01;
        {
            if(rq(submodels.get("lights"), submodels.get("front_lights"))){
                if(s1){ lightOff(ent); }
                render(submodels.get("lights"));
                render(submodels.get("front_lights"));
                //render(back_lights);
                if(s1){ lightOn(ent); }
            }
        }
        {
            if(rq(submodels.get("back_lights"))){
                if(s1 || sr){ lightOff(ent); }
                render(submodels.get("back_lights"));
                if(s1 || sr){ lightOn(ent); }
            }
        }
        {
            if(rq(submodels.get("fog_lights"))){
                if(s3){ lightOff(ent); }
                render(submodels.get("fog_lights"));
                if(s3){ lightOn(ent); }
            }
        }
        {
            if(rq(submodels.get("reverse_lights"))){
                if(sr){ lightOff(ent); }
                //render(back_lights);
                render(submodels.get("reverse_lights"));
                if(sr){ lightOn(ent); }
            }
        }
        //
        if(rq(submodels.get("windows"), submodels.get("windows_door_open"), submodels.get("windows_door_close"))){
            GlStateManager.pushMatrix();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthMask(false);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            windowcolor.glColorApply();
            render(submodels.get("windows"));
            render(data.doorsOpen() ? submodels.get("windows_door_open") : submodels.get("windows_door_close"));
            RGB.glColorReset();
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDepthMask(true);
            GL11.glDisable(GL11.GL_BLEND);
            GlStateManager.popMatrix();
        }
	}

    public static boolean rq(ModelRendererTurbo[]... turbos){
        for(ModelRendererTurbo[] turbo : turbos){
            if(turbo != null && turbo.length > 0){
                return true;
            }
        }
        return false;
    }

    public void rotate(ModelRendererTurbo[] part, float x, float y, float z, boolean mode){
        if(!mode){
            super.rotate(part, x, y, z);
        }
        else{
            for(ModelRendererTurbo model : part){
                model.rotateAngleX = x;
                model.rotateAngleY = y;
                model.rotateAngleZ = z;
            }
        }
    }

    public static void lightOn(Entity ent){
        int i = ent == null ? MapColor.WHITE_STAINED_HARDENED_CLAY.colorValue : ent.getBrightnessForRender(), j = i % 65536, k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    public static void lightOff(Entity ent){
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.depthMask(true);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 238f, 238f);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void def_renderWheels4(VehicleData type, String us){
        switch(us){
            case "left_front_wheel":
                render(submodels.get("wheel_front_left"));
                break;
            case "right_front_wheel":
                render(submodels.get("wheel_front_right"));
                break;
            case "left_back_wheel":
                render(submodels.get("wheel_back_left"));
                break;
            case "right_back_wheel":
                render(submodels.get("wheel_back_right"));
                break;
        }
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh){
        VehicleEntity vehicle = (VehicleEntity) veh;
        switch(us){
            case "left_front_wheel":
                for(ModelRendererTurbo element : submodels.get("wheel_front_left")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "right_front_wheel":
                for(ModelRendererTurbo element : submodels.get("wheel_front_right")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
                    element.render();
                    element.rotateAngleY = 0;
                }
                break;
            case "left_back_wheel":
                for(ModelRendererTurbo element : submodels.get("wheel_back_left")){
                    element.rotateAngleZ = vehicle.getWheelsAngle();
                    element.render();
                }
                break;
            case "right_back_wheel":
                for(ModelRendererTurbo element : submodels.get("wheel_back_right")){
                    element.rotateAngleZ = vehicle.getWheelsYaw();
                    element.render();
                }
                break;
        }
    }

    public void def_renderWheelWithRotations(ModelRendererTurbo[] model, Entity ent, boolean steering){
        VehicleEntity vehicle = (VehicleEntity) ent;
        float f = vehicle.getWheelsAngle();
        if(f != model[0].rotateAngleZ){
            f -= model[0].rotateAngleZ;
            this.rotate(model, 0, 0, f, false);

        }
        if(steering){
            for(ModelRendererTurbo sub : model){
                sub.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
            }
        }
        this.render(model);
        if(steering){
            for(ModelRendererTurbo sub : model){
                sub.rotateAngleY = 0;
            }
        }
    }

    public void def_renderWheels4(VehicleData type, String us, Entity veh, boolean rot){
        if(rot){
            switch(us){
                case "left_front_wheel":
                    this.def_renderWheelWithRotations(submodels.get("wheel_front_left"), veh, true);
                    break;
                case "right_front_wheel":
                    this.def_renderWheelWithRotations(submodels.get("wheel_front_right"), veh, true);
                    break;
                case "left_back_wheel":
                    this.def_renderWheelWithRotations(submodels.get("wheel_back_left"), veh, false);
                    break;
                case "right_back_wheel":
                    this.def_renderWheelWithRotations(submodels.get("wheel_back_right"), veh, false);
                    break;
            }
        }
        else{
            def_renderWheels4(type, us, veh);
        }
    }

    public static void def_renderContainer(VehicleData type, String us){
        PartData partdata = type.getPart(us);
        if(partdata == null){
            return;
        }
        ContainerAttribute conattr;
        if((conattr = partdata.getPart().getAttribute(ContainerAttribute.class)) != null){
            conattr.getContainerOffset().translate();
            if(conattr.getContainerRotation() != 0F){
                GL11.glRotatef(conattr.getContainerRotation(), 0, 1, 0);
            }
            ContainerAttributeData condata = partdata.getAttributeData(ContainerAttributeData.class);
            ContainerData container;
            if(conattr.getContainerType() == ContainerType.LARGE){
                if(condata.getContainer(ContainerPosition.MEDIUM_DUAL2) != null){
                    if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL1)) != null){
                    	GL11.glTranslatef( 3, 0, 0);
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    	GL11.glTranslatef(-3, 0, 0);
                    }
                    //
                    if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL2)) != null){
                    	GL11.glTranslatef(-3, 0, 0);
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    	GL11.glTranslatef( 3, 0, 0);
                    }
                }
                else{
                    if((container = condata.getContainer(ContainerPosition.LARGE_SINGLE)) != null){
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    }
                }
            }
            else if(conattr.getContainerType() == ContainerType.MEDIUM){
                if((container = condata.getContainer(ContainerPosition.MEDIUM_SINGLE)) != null){
                    ModelBase.bindTexture(container.getTexture());
                    container.getContainer().getModel().render(container, type);
                }
            }
            else{
                //No other types supported yet.
            }
            if(conattr.getContainerRotation() != 0F){
                GL11.glRotatef(-conattr.getContainerRotation(), 0, 1, 0);
            }
            conattr.getContainerOffset().translateR();
        }
    }

    public static void def_renderContainer(VehicleData type, String us, Entity ent){
        PartData partdata = type.getPart(us);
        if(partdata == null){
            return;
        }
        ContainerAttribute conattr = partdata.getPart().getAttribute(ContainerAttribute.class);
        if(conattr != null){
            conattr.getContainerOffset().translate();
            if(conattr.getContainerRotation() != 0F){
                GL11.glRotatef(conattr.getContainerRotation(), 0, 1, 0);
            }
            ContainerAttributeData condata = partdata.getAttributeData(ContainerAttributeData.class);
            ContainerData container;
            if(conattr.getContainerType() == ContainerType.LARGE){
                if(condata.getContainer(ContainerPosition.MEDIUM_DUAL2) != null){
                    if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL1)) != null){
                    	GL11.glTranslatef( 3, 0, 0);
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    	GL11.glTranslatef(-3, 0, 0);
                    }
                    //
                    if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL2)) != null){
                    	GL11.glTranslatef(-3, 0, 0);
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    	GL11.glTranslatef( 3, 0, 0);
                    }
                }
                else{
                    if((container = condata.getContainer(ContainerPosition.LARGE_SINGLE)) != null){
                        ModelBase.bindTexture(container.getTexture());
                        container.getContainer().getModel().render(container, type);
                    }
                }
            }
            else if(conattr.getContainerType() == ContainerType.MEDIUM){
                if((container = condata.getContainer(ContainerPosition.MEDIUM_SINGLE)) != null){
                    ModelBase.bindTexture(container.getTexture());
                    container.getContainer().getModel().render(container, type);
                }
            }
            else{
                //No other types supported yet.
            }
            if(conattr.getContainerRotation() != 0F){
                GL11.glRotatef(-conattr.getContainerRotation(), 0, 1, 0);
            }
            conattr.getContainerOffset().translateR();
        }
    }
	
}