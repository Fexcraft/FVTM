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

public abstract class PartBaseModel extends GenericModel<VehicleData, String> {
	
    protected RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	
	public PartBaseModel(){ super(); }
	
	public PartBaseModel(JsonObject obj){ super(obj); }
	
	@Override
	public void render(){
		//invalid render call for part model
    	render(submodels.get("body")); render(submodels.get("wheels"));
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

    public void def_renderWheelWithRotations(ModelRendererTurbo[] model, Entity ent, float amount, boolean steering){
        VehicleEntity vehicle = (VehicleEntity) ent;
        if(amount != model[0].rotateAngleZ){
            amount -= model[0].rotateAngleZ;
            this.rotate(model, 0, 0, amount, false);

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