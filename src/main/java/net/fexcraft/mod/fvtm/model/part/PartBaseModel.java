package net.fexcraft.mod.fvtm.model.part;

import org.lwjgl.opengl.GL11;

import com.google.gson.JsonObject;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute;
import net.fexcraft.mod.addons.gep.attributes.ContainerAttribute.ContainerAttributeData;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerPosition;
import net.fexcraft.mod.fvtm.api.Container.ContainerType;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.model.GenericModel;
import net.fexcraft.mod.fvtm.model.TurboList;
import net.fexcraft.mod.fvtm.render.entity.RenderGenericRailed;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.entity.Entity;

public abstract class PartBaseModel extends GenericModel<VehicleData, String> {
	
    protected RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	
	public PartBaseModel(){ super(); }
	
	public PartBaseModel(JsonObject obj){ super(obj); }
	
	@Override
	public void render(){
		//invalid render call for part model
    	render("body"); render("wheels");
	}

    public void def_renderWheelWithRotations(String model, Entity ent, float amount, boolean steering){
    	TurboList list = groups.get(model);
        VehicleEntity vehicle = (VehicleEntity) ent;
        if(amount != list.get(0).rotateAngleZ){
            amount -= list.get(0).rotateAngleZ;
            list.rotate(0, 0, amount, false);
        }
        if(steering){
            for(ModelRendererTurbo sub : list){
                sub.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
            }
        }
        this.render(model);
        if(steering){
            for(ModelRendererTurbo sub : list){
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
        PartData partdata = type.getPart(us); if(partdata == null) return;
        if(Command.DEBUG){
    		ModelBase.bindTexture(Resources.NULL_TEXTURE);
    		ContainerAttribute attr = partdata.getPart().getAttribute(ContainerAttribute.class);
    		attr.getContainerOffset().translate();
            RenderGenericRailed.CUBE.render();
    		attr.getContainerOffset().translateR();
            ModelBase.bindTexture(partdata.getTexture());
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