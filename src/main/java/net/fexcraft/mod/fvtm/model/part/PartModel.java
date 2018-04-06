package net.fexcraft.mod.fvtm.model.part;

import java.util.ArrayList;

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
import net.fexcraft.mod.lib.tmt.JsonToTMT;
import net.fexcraft.mod.lib.tmt.Model;
import net.fexcraft.mod.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.RGB;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class PartModel<T extends VehicleData> extends Model<VehicleData> {
	
	public ModelRendererTurbo body[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyColoredSecondary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpen[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorClose[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorOpenColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo bodyDoorCloseColoredPrimary[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo turret[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo steering[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo wheels[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front_left[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back_left[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_front_right[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo wheel_back_right[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo track_wheels[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo track_wheels_right[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo track_wheels_left[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo lights[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo front_lights[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo back_lights[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo reverse_lights[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo fog_lights[] = new ModelRendererTurbo[0];
	//
	public ModelRendererTurbo windows[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo windowsDoorOpen[] = new ModelRendererTurbo[0];
	public ModelRendererTurbo windowsDoorClose[] = new ModelRendererTurbo[0];
	//
	private RGB windowcolor = new RGB(0x00, 0x72, 0x08, 0.3f);
	//
	public ArrayList<String> creators = new ArrayList<String>();
	
	private int tx, ty;
	
	public PartModel(){}
	
	public PartModel(JsonObject obj){
		if(obj == null){
			return;
		}
		creators = JsonUtil.jsonArrayToStringArray(obj.get("creators").getAsJsonArray());
		tx = obj.get("texture_size_x").getAsInt();
		ty = obj.get("texture_size_y").getAsInt();
		body = JsonToTMT.parse(this, "body", obj, tx, ty);
		bodyColoredPrimary = JsonToTMT.parse(this, "body_colored_primary", obj, tx, ty);
		bodyColoredSecondary= JsonToTMT.parse(this, "body_colored_secondary", obj, tx, ty);
		bodyDoorOpen = JsonToTMT.parse(this, "body_door_open", obj, tx, ty);
		bodyDoorClose = JsonToTMT.parse(this, "body_door_close", obj, tx, ty);
		bodyDoorOpenColoredPrimary = JsonToTMT.parse(this, "body_door_open_colored_primary", obj, tx, ty);
		bodyDoorCloseColoredPrimary = JsonToTMT.parse(this, "body_door_close_colored_primary", obj, tx, ty);
		turret = JsonToTMT.parse(this, "turret", obj, tx, ty);
		//
		steering = JsonToTMT.parse(this, "steering", obj, tx, ty);
		wheels = JsonToTMT.parse(this, "wheels", obj, tx, ty);
		wheel_front = JsonToTMT.parse(this, "wheel_front", obj, tx, ty);
		wheel_back = JsonToTMT.parse(this, "wheel_back", obj, tx, ty);
		wheel_front_left = JsonToTMT.parse(this, "wheel_front_left", obj, tx, ty);
		wheel_back_left = JsonToTMT.parse(this, "wheel_back_left", obj, tx, ty);
		wheel_front_right = JsonToTMT.parse(this, "wheel_front_right", obj, tx, ty);
		wheel_back_right = JsonToTMT.parse(this, "wheel_back_right", obj, tx, ty);
		//
		lights = JsonToTMT.parse(this, "lights", obj, tx, ty);
		front_lights = JsonToTMT.parse(this, "front_lights", obj, tx, ty);
		back_lights = JsonToTMT.parse(this, "back_lights", obj, tx, ty);
		reverse_lights = JsonToTMT.parse(this, "reverse_lights", obj, tx, ty);
		fog_lights = JsonToTMT.parse(this, "fog_lights", obj, tx, ty);
		//
		windows = JsonToTMT.parse(this, "windows", obj, tx, ty);
		windowsDoorOpen = JsonToTMT.parse(this, "windows_door_open", obj, tx, ty);
		windowsDoorClose = JsonToTMT.parse(this, "windows_door_close", obj, tx, ty);
	}
	
	@Override
	public void render(){
		//cannot render without providing vehicledata;
	}

	@Override
	public void render(VehicleData type, Entity ent){
		render(type, "", ent);
	}

	public void render(VehicleData data, String usedAS){
		//TODO if(data.getPart(usedAS).getAttributeData(null))
		
		//Vehicle Body
		render(body);
		render(data.doorsOpen() ? bodyDoorOpen : bodyDoorClose);
		
		//Render Primary Color Things
		if(rq(bodyColoredPrimary, bodyDoorCloseColoredPrimary, bodyDoorOpenColoredPrimary)){
			data.getPrimaryColor().glColorApply();
			render(bodyColoredPrimary);
			render(data.doorsOpen() ? bodyDoorOpenColoredPrimary : bodyDoorCloseColoredPrimary);
			RGB.glColorReset();
		}
		
		//Render Secondary Color Things
		if(rq(bodyColoredSecondary)){
			data.getSecondaryColor().glColorApply();
			render(bodyColoredSecondary);
			RGB.glColorReset();
		}
		
		//Render Other
		render(turret);
		render(steering);
		
		//Render Wheels
		render(wheels);
		render(wheel_front);
		render(wheel_back);
		render(wheel_front_right);
		render(wheel_back_right);
		render(wheel_front_left);
		render(wheel_back_left);
		//
		render(track_wheels);
		render(track_wheels_right);
		render(track_wheels_left);
		//
		render(lights);
		render(front_lights);
		render(back_lights);
		render(reverse_lights);
		render(fog_lights);
		//
		if(rq(windows, windowsDoorOpen, windowsDoorClose)){
			GlStateManager.pushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			windowcolor.glColorApply();
			render(windows);
			render(data.doorsOpen() ? windowsDoorOpen : windowsDoorOpen);
			RGB.glColorReset();
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
			GL11.glDisable(GL11.GL_BLEND);
			GlStateManager.popMatrix();
		}
	}
	
	public void render(VehicleData data, String usedAS, Entity vehicle){
		VehicleEntity ent = (VehicleEntity)vehicle;
		//Vehicle Body
		render(body);
		render(data.doorsOpen() ? bodyDoorOpen : bodyDoorClose);
		
		//Render Primary Color Things
		if(rq(bodyColoredPrimary, bodyDoorCloseColoredPrimary, bodyDoorOpenColoredPrimary)){
			data.getPrimaryColor().glColorApply();
			render(bodyColoredPrimary);
			render(data.doorsOpen() ? bodyDoorOpenColoredPrimary : bodyDoorCloseColoredPrimary);
			RGB.glColorReset();
		}
		
		//Render Secondary Color Things
		if(rq(bodyColoredSecondary)){
			data.getSecondaryColor().glColorApply();
			render(bodyColoredSecondary);
			RGB.glColorReset();
		}
		
		//Render Turret
		render(turret);
		
		//Render Steering
		for(ModelRendererTurbo submodel : steering) {
			submodel.rotateAngleX = ent.getWheelsYaw() * 3.14159265F / 180F * 3F;
			submodel.render();
		}
		
		//Render Wheels
		for(ModelRendererTurbo element : wheel_back_left){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : wheel_back_right){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : wheel_back){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front_left){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.rotateAngleY = ent.getWheelsYaw() * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front_right){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.rotateAngleY = ent.getWheelsYaw() * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheel_front){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.rotateAngleY = ent.getWheelsYaw() * Static.rad180 / 180F * 3F;
			element.render();
		}
		for(ModelRendererTurbo element : wheels){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels_right){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		for(ModelRendererTurbo element : track_wheels_left){
			element.rotateAngleZ = ent.getWheelsAngle();
			element.render();
		}
		//
		boolean s1 = data.getLightsState() > 0, s3 = data.getLightsState() > 2, sr = ent.getThrottle() < -0.01;
		{
			if(rq(lights, front_lights)){
				if(s1){ lightOff(vehicle); }
				render(lights);
				render(front_lights);
				//render(back_lights);
				if(s1){ lightOn(vehicle); }
			}
		}
		{
			if(rq(back_lights)){
				if(s1 || sr){ lightOff(vehicle); }
				render(back_lights);
				if(s1 || sr){ lightOn(vehicle); }
			}
		}
		{
			if(rq(fog_lights)){
				if(s3){ lightOff(vehicle); }
				render(fog_lights);
				if(s3){ lightOn(vehicle); }
			}
		}
		{
			if(rq(reverse_lights)){
				if(sr){ lightOff(vehicle); }
				//render(back_lights);
				render(reverse_lights);
				if(sr){ lightOn(vehicle); }
			}
		}
		//
		if(rq(windows, windowsDoorOpen, windowsDoorClose)){
			GlStateManager.pushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			windowcolor.glColorApply();
			render(windows);
			render(data.doorsOpen() ? windowsDoorOpen : windowsDoorOpen);
			RGB.glColorReset();
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
			GL11.glDisable(GL11.GL_BLEND);
			GlStateManager.popMatrix();
		}
		//
		//Particles
		/*if(vehicle.throttle != 0 && data.parts.get(usedAS).pspawners != null){
			PartType part = data.parts.get(usedAS);
			for(int i = 0; i < part.pspawners.length; i++){
				if(FvmTickHandler.getClientTick() % part.pspawners[i].freq == 0){
					Vec3d vec = calculatePos(vehicle, part.pspawners[i].pos);
					vehicle.world.spawnParticle(part.pspawners[i].type, vec.xCoord, vec.yCoord, vec.zCoord, part.pspawners[i].sx, part.pspawners[i].sy, part.pspawners[i].sz);
				}
			}
		}
		//CargoPos
		if(data.getContainer().getSizeInventory() > 0 && data.parts.get(usedAS).cargopos.size() > 0){
			PartType part = data.parts.get(usedAS);
            net.minecraft.client.Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			for(int i = 0; i < data.container.getSizeInventory(); i++){
				if(i >= part.cargopos.size()){
					break;
				}
				CargoRenderPos pos = part.cargopos.get(i);
				if(!pos.renderAlways && data.parts.containsKey("cargo")){
					continue;
				}
				IBlockState state = getBlockToRender(i, data);
				if(state.getRenderType() != EnumBlockRenderType.INVISIBLE){;
					pos.pos.translate();
		            /*GlStateManager.pushMatrix();
		            if(pos.scale != 1f){
		            	GL11.glScalef(pos.scale, pos.scale, pos.scale);
		            }*//*
		            GlStateManager.pushMatrix();
	            	//GL11.glRotatef( 180, 0, 0, 1);
		            Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(state, vehicle.getBrightness(Minecraft.getMinecraft().getRenderPartialTicks()));
	            	//GL11.glRotatef(-180, 0, 0, 1);
		            GlStateManager.popMatrix();
		            //GlStateManager.popMatrix();
		            pos.pos.translateR();
		        }
			}
            part.bindTexture();
		}*/
	}
	
	public static boolean rq(ModelRendererTurbo[]... turbos){
		for(ModelRendererTurbo[] turbo : turbos){
			if(turbo != null && turbo.length > 0){
				return true;
			}
		}
		return false;
	}

	/*protected static IBlockState getBlockToRender(int index, VehicleData data){
		if(data.container.getStackInSlot(index).isEmpty()){
			return Blocks.AIR.getDefaultState();
		}
		else if(data.container.getStackInSlot(index).getItem() instanceof ItemBlock == false){
			return Blocks.CHEST.getDefaultState();//TODO add crate block
		}
		else if(data.container.getStackInSlot(index).getItem() instanceof fItem){
			return Blocks.BEDROCK.getDefaultState();
		}
		else{
			ItemStack stack = data.container.getStackInSlot(index);
			return ((ItemBlock)stack.getItem()).block.getStateFromMeta(stack.getMetadata());
		}//TODO
	}*/
	
	/*protected static Vec3d calculatePos(com.flansmod.fvm.LandVehicle vehicle, Pos pos){
		com.flansmod.common.vector.Vector3f loc = new com.flansmod.common.vector.Vector3f(pos.to16FloatX(), pos.to16FloatY(), pos.to16FloatZ());
		com.flansmod.common.vector.Vector3f rel = vehicle.axes.findLocalVectorGlobally(loc);
		return new Vec3d(vehicle.posX + rel.x, vehicle.posY + rel.y, vehicle.posZ + rel.z);
	}*/
	
	public static void lightOn(Entity ent){
        int i = ent == null ? MapColor.WHITE_STAINED_HARDENED_CLAY.colorValue : ent.getBrightnessForRender(), j = i % 65536, k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
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


	@Override
	public void rotateAll(float x, float y, float z) {
		rotate(body, x, y, z);
		rotate(bodyColoredPrimary, x, y, z);
		rotate(bodyColoredSecondary, x, y, z);
		rotate(bodyDoorOpen, x, y, z);
		rotate(bodyDoorClose, x, y, z);
		rotate(bodyDoorOpenColoredPrimary, x, y, z);
		rotate(bodyDoorCloseColoredPrimary, x, y, z);
		rotate(turret, x, y, z);
		rotate(steering, x, y, z);
		rotate(wheels, x, y, z);
		rotate(wheel_front, x, y, z);
		rotate(wheel_back, x, y, z);
		rotate(wheel_front_left, x, y, z);
		rotate(wheel_back_left, x, y, z);
		rotate(wheel_front_right, x, y, z);
		rotate(wheel_back_right, x, y, z);
		rotate(track_wheels, x, y, z);
		rotate(track_wheels_right, x, y, z);
		rotate(track_wheels_left, x, y, z);
	}

	public void translateAll(float x, float y, float z){
		translate(body, x, y, z);
		translate(bodyColoredPrimary, x, y, z);
		translate(bodyColoredSecondary, x, y, z);
		translate(bodyDoorOpen, x, y, z);
		translate(bodyDoorClose, x, y, z);
		translate(bodyDoorOpenColoredPrimary, x, y, z);
		translate(bodyDoorCloseColoredPrimary, x, y, z);
		translate(turret, x, y, z);
		translate(steering, x, y, z);
		translate(wheels, x, y, z);
		translate(wheel_front, x, y, z);
		translate(wheel_back, x, y, z);
		translate(wheel_front_left, x, y, z);
		translate(wheel_back_left, x, y, z);
		translate(wheel_front_right, x, y, z);
		translate(wheel_back_right, x, y, z);
		translate(track_wheels, x, y, z);
		translate(track_wheels_right, x, y, z);
		translate(track_wheels_left, x, y, z);
	}
	
	public void flip(ModelRendererTurbo[] model){
		this.fixRotations(model);
	}

	public void flipAll(){
		flip(body);
		flip(bodyColoredPrimary);
		flip(bodyColoredSecondary);
		flip(bodyDoorOpen);
		flip(bodyDoorClose);
		flip(bodyDoorOpenColoredPrimary);
		flip(bodyDoorCloseColoredPrimary);
		flip(turret);
		flip(steering);
		flip(wheels);
		flip(wheel_front);
		flip(wheel_back);
		flip(wheel_front_left);
		flip(wheel_front_right);
		flip(wheel_back_left);
		flip(wheel_back_right);
		flip(track_wheels);
		flip(track_wheels_right);
		flip(track_wheels_left);
	}
	
	public void def_renderWheels4(VehicleData type, String us){
		switch(us){
			case "left_front_wheel":
				render(wheel_front_left);
				break;
			case "right_front_wheel":
				render(wheel_front_right);
				break;
			case "left_back_wheel":
				render(wheel_back_left);
				break;
			case "right_back_wheel":
				render(wheel_back_right);
				break;
		}
	}
	
	public void def_renderWheels4(VehicleData type, String us, Entity veh){
		VehicleEntity vehicle = (VehicleEntity)veh;
		switch(us){
			case "left_front_wheel":
				for(ModelRendererTurbo element : wheel_front_left){
					element.rotateAngleZ = vehicle.getWheelsAngle();
					element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				break;
			case "right_front_wheel":
				for(ModelRendererTurbo element : wheel_front_right){
					element.rotateAngleZ = vehicle.getWheelsAngle();
					element.rotateAngleY = vehicle.getWheelsYaw() * Static.rad180 / 180F * 3F;
					element.render();
					element.rotateAngleY = 0;
				}
				break;
			case "left_back_wheel":
				for(ModelRendererTurbo element : wheel_back_left){
					element.rotateAngleZ = vehicle.getWheelsAngle();
					element.render();
				}
				break;
			case "right_back_wheel":
				for(ModelRendererTurbo element : wheel_back_right){
					element.rotateAngleZ = vehicle.getWheelsYaw();
					element.render();
				}
				break;
		}
	}
	
	public void def_renderWheelWithRotations(ModelRendererTurbo[] model, Entity ent, boolean steering){
		VehicleEntity vehicle = (VehicleEntity)ent;
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
					this.def_renderWheelWithRotations(wheel_front_left, veh, true);
					break;
				case "right_front_wheel":
					this.def_renderWheelWithRotations(wheel_front_right, veh, true);
					break;
				case "left_back_wheel":
					this.def_renderWheelWithRotations(wheel_back_left, veh, false);
					break;
				case "right_back_wheel":
					this.def_renderWheelWithRotations(wheel_back_right, veh, false);
					break;
			}
		}
		else def_renderWheels4(type, us, veh);
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
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_DUAL1);
					}
					//
					if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL2)) != null){
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_DUAL2);
					}
				}
				else{
					if((container = condata.getContainer(ContainerPosition.LARGE_SINGLE)) != null){
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.LARGE_SINGLE);
					}
				}
			}
			else if(conattr.getContainerType() == ContainerType.MEDIUM){
				if((container = condata.getContainer(ContainerPosition.MEDIUM_SINGLE)) != null){
					Model.bindTexture(container.getTexture());
					container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_SINGLE);
				}
			}
			else {
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
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_DUAL1, ent);
					}
					//
					if((container = condata.getContainer(ContainerPosition.MEDIUM_DUAL2)) != null){
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_DUAL2, ent);
					}
				}
				else{
					if((container = condata.getContainer(ContainerPosition.LARGE_SINGLE)) != null){
						Model.bindTexture(container.getTexture());
						container.getContainer().getModel().render(type, us, container, ContainerPosition.LARGE_SINGLE, ent);
					}
				}
			}
			else if(conattr.getContainerType() == ContainerType.MEDIUM){
				if((container = condata.getContainer(ContainerPosition.MEDIUM_SINGLE)) != null){
					Model.bindTexture(container.getTexture());
					container.getContainer().getModel().render(type, us, container, ContainerPosition.MEDIUM_SINGLE, ent);
				}
			}
			else {
				//No other types supported yet.
			}
			if(conattr.getContainerRotation() != 0F){
				GL11.glRotatef(-conattr.getContainerRotation(), 0, 1, 0);
			}
			conattr.getContainerOffset().translateR();
		}
	}
	
}