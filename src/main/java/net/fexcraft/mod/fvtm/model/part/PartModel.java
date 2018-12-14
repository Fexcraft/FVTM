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

public class PartModel extends GenericModel<VehicleData, String> {

	public static final PartModel EMPTY = new PartModel();
    protected RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	public static final String[] defval = new String[]{
		"body", "body_colored_primary", "body_colored_secondary", "body_door_open", "body_door_close",
		"body_door_open_colored_primary", "body_door_close_colored_primary", "turret", "steering",
		//
		"wheels", "wheel_front", "wheel_back",
		"wheel_front_left", "wheel_back_left", "wheel_front_right", "wheel_back_right", 
		//
		"track_wheels", "track_wheels_right", "track_wheels_left",
		//
		"lights", "front_lights", "back_lights", "reverse_lights",
		"fog_lights", "turn_signal_left", "turn_signal_right",
		//
		"windows", "windows_door_open", "windows_door_close"
	};
	public static final String[] defval_bogie = new String[]{ "chassis", "axle0", "axle1", "axle2", "axle3" };
	
	////-///---/---///-////
	
	public PartModel(){ super(); }
	
	public PartModel(JsonObject obj){ super(obj); }

	@Override
	public void render(VehicleData data, String key){
		for(TurboList list : groups){
			list.render(null, data, data, key);
		}
	}

	@Override
	public void render(VehicleData data, String key, VehicleEntity ent, int meta){
		for(TurboList list : groups){
			list.render(ent, data, data, key);
		}
	}
	
	////-///---/---///-////

    public void def_renderWheelWithRotations(String model, VehicleEntity vehicle, float amount, boolean steering){
    	TurboList list = groups.get(model);
        if(amount != list.get(0).rotationAngleZ){
            amount -= list.get(0).rotationAngleZ;
            list.rotate(0, 0, amount, false);
        }
        if(steering){
            for(ModelRendererTurbo sub : list){
                sub.rotationAngleY = Static.toDegrees(vehicle.getWheelsYaw() * Static.rad180);
            }
        }
        this.render(vehicle.getVehicleData(), model);
        if(steering){
            for(ModelRendererTurbo sub : list){
                sub.rotationAngleY = 0;
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

    public static void def_renderContainer(VehicleData type, String us, VehicleEntity vehicle){
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