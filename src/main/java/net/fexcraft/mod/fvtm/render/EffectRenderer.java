package net.fexcraft.mod.fvtm.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHoldingEntity;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.root.Attribute;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.DefaultPrograms.LightBeam;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.function.PartSlotsFunction;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.DPIHData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EffectRenderer {
	

	
	public static final ArrayList<LightBeam> LIGHTRAYS = new ArrayList<>();
	public static final ArrayList<VehicleData> LIGHTRAYDATAS = new ArrayList<>();
	public static final ArrayList<VehicleEntity> LIGHTRAYVEHS = new ArrayList<>();
	public static final ArrayList<LightBeam> BLOCK_LIGHTRAYS = new ArrayList<>();
	public static final ArrayList<BlockData> BLOCK_LIGHTRAYDATAS = new ArrayList<>();
	public static final ArrayList<TileEntity> BLOCK_LIGHTRAYTILES = new ArrayList<>();
	public static final HashMap<Integer, Vec3f> RENDER_VEHROT = new HashMap<>();
	public static final HashMap<Integer, Vec3d> RENDER_VEHPOS = new HashMap<>();
	public static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation("fvtm:textures/entity/light_beam.png");
	private static ArrayList<Vec3d> toggpos = new ArrayList<>();
	private static ContainerHolder tempholder;
	public static ResourceLocation last;
	
    @SubscribeEvent
    public void renderLights(RenderWorldLastEvent event){
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ModelBase.bindTexture(LIGHT_TEXTURE);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_ALPHA);
        for(int i = 0; i < LIGHTRAYS.size(); i++){
        	LightBeam light = LIGHTRAYS.get(i);
        	VehicleData data = LIGHTRAYDATAS.get(i);
        	VehicleEntity veh = LIGHTRAYVEHS.get(i);
        	if(light.tex != null){
        		if(last == null || !last.equals(light.tex)){
        			ModelBase.bindTexture(last = light.tex);
        		}
        	}
        	else if(last != null){
        		last = null;
        		ModelBase.bindTexture(LIGHT_TEXTURE);
        	}
        	Vec3d vehpos = RENDER_VEHPOS.get(veh.getEntity().getEntityId());
            GL11.glPushMatrix();
            GL11.glTranslated(vehpos.x, vehpos.y, vehpos.z);
            //
            Vec3f vehrot = RENDER_VEHROT.get(veh.getEntity().getEntityId());
            GL11.glRotatef(vehrot.xCoord, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(vehrot.yCoord, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(vehrot.zCoord, 1.0F, 0.0F, 0.0F);
            GL11.glPushMatrix();
            GL11.glRotatef(180f, 0f, 0f, 1f);
            if(light.swivel == null || light.swivel.equals("vehicle")){
                GL11.glTranslated(light.pos.x, light.pos.y, light.pos.z);
            }
            else{
        		SwivelPoint point = data.getRotationPoint(light.swivel);
        		Vec3d pos = point.getRelativeVector(light.pos, true);
        		GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
        		GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
                GL11.glTranslated(pos.x, pos.y, pos.z);
        		GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
        		GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
            }
            GL11.glColor4f(1, 1, 1, 0.5F);
        	light.shape.render();
            GL11.glColor4f(1, 1, 1, 0.5F);
        	light.shape.render();
            //
            GL11.glPopMatrix();
        	GL11.glPopMatrix();
        }
        if(BLOCK_LIGHTRAYS.size() > 0){
        	last = null;
        	EntityPlayer player = Minecraft.getMinecraft().player;
        	double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
            double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
            double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
    		GL11.glTranslated(-x, -y, -z);
            for(int i = 0; i < BLOCK_LIGHTRAYS.size(); i++){
            	LightBeam light = BLOCK_LIGHTRAYS.get(i);
            	BlockData data = BLOCK_LIGHTRAYDATAS.get(i);
            	TileEntity tile = BLOCK_LIGHTRAYTILES.get(i);
            	if(light.tex != null){
            		if(last == null || !last.equals(light.tex)){
            			ModelBase.bindTexture(last = light.tex);
            		}
            	}
            	else if(last != null){
            		last = null;
            		ModelBase.bindTexture(LIGHT_TEXTURE);
            	}
                GL11.glPushMatrix();
                GL11.glTranslated(tile.getPos().getX() + 0.5, tile.getPos().getY(), tile.getPos().getZ() + 0.5);
                GL11.glRotated(data.getType().getBlockType().getRotationForMeta(tile.getBlockMetadata()), 0.0F, 1.0F, 0.0F);
                GL11.glPushMatrix();
                //GL11.glRotatef(180f, 0f, 0f, 1f);
                GL11.glTranslated(light.pos.x, light.pos.y, light.pos.z);
                GL11.glColor4f(1, 1, 1, 0.5F);
            	light.shape.render();
                GL11.glColor4f(1, 1, 1, 0.5F);
            	light.shape.render();
                //
                GL11.glPopMatrix();
            	GL11.glPopMatrix();
            }
        }
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDepthMask(true);
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_BLEND);
    	GL11.glPopMatrix();
        LIGHTRAYS.clear();
        LIGHTRAYDATAS.clear();
        LIGHTRAYVEHS.clear();
        BLOCK_LIGHTRAYS.clear();
        BLOCK_LIGHTRAYDATAS.clear();
        BLOCK_LIGHTRAYTILES.clear();
        last = null;
    }

	public static void renderHotInstallInfo(GenericVehicle vehicle){
		if(!Command.HOTSWAP){
			if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof PartItem == false) return;
			if(vehicle.getVehicleData().getAttribute("collision_range").getFloatValue() + 1 < vehicle.getDistance(Minecraft.getMinecraft().player)) return;
			//
			PartData part = Minecraft.getMinecraft().player.getHeldItemMainhand().getCapability(Capabilities.VAPDATA, null).getPartData();
			if(part.getType().getInstallationHandlerData() instanceof DPIHData && ((DPIHData)part.getType().getInstallationHandlerData()).hotswap){
				preMeshCalls();
				for(Entry<String, PartData> data : vehicle.getVehicleData().getParts().entrySet()){
					if(!data.getValue().hasFunction("fvtm:part_slots")) continue;
					PartSlotsFunction func = data.getValue().getFunction("fvtm:part_slots");
					for(int i = 0; i < func.getSlotTypes().size(); i++){
						String type = func.getSlotTypes().get(i);
						for(String str : part.getType().getCategories()){
							if(str.equals(type)){
								func.getSlotPositions().get(i).translate();
				            	GL11.glPushMatrix();
				            	float scal = func.getSlotRadius().get(i);
				            	GL11.glScalef(scal, scal, scal);
								DebugModels.HOTINSTALLCUBE.render(1f);
				            	GL11.glPopMatrix();
								func.getSlotPositions().get(i).translateR();
							}
						}
					}
				}
				postMeshCalls();
			}
		}
		else{
			preMeshCalls();
			for(Entry<String, PartData> data : vehicle.getVehicleData().getParts().entrySet()){
				if(!data.getValue().hasFunction("fvtm:part_slots")) continue;
				PartSlotsFunction func = data.getValue().getFunction("fvtm:part_slots");
				for(int i = 0; i < func.getSlotTypes().size(); i++){
					func.getSlotPositions().get(i).translate();
	            	GL11.glPushMatrix();
	            	float scal = func.getSlotRadius().get(i);
	            	GL11.glScalef(scal, scal, scal);
					DebugModels.HOTINSTALLCUBE.render(1f);
	            	GL11.glPopMatrix();
					func.getSlotPositions().get(i).translateR();
				}
			}
			postMeshCalls();
		}
	}

	private static void preMeshCalls(){
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		TexturedPolygon.TRIANGULATED_QUADS = false;
		GL11.glLineWidth(4f);
	}

	private static void postMeshCalls(){
		GL11.glLineWidth(1f);
		TexturedPolygon.TRIANGULATED_QUADS = true;
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void renderToggableInfo(GenericVehicle vehicle){
		if(!Command.TOGGABLE) return;
    	GL11.glPushMatrix();
    	float scal = vehicle.getVehicleData().getAttribute("collision_range").getFloatValue() * 16;
    	GL11.glScalef(scal, scal, scal);
    	GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glLineWidth(2f);
    	DebugModels.CENTERSPHERE.render();
		GL11.glLineWidth(1f);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
    	GL11.glPopMatrix();
    	//
    	GL11.glPushMatrix();
        preMeshCalls();
		for(Attribute<?> attr : vehicle.getVehicleData().getAttributes().values()){
			if(!attr.hasAABBs()) continue;
			for(Map.Entry<String, float[]> box : attr.getAABBs().entrySet()){
				SwivelPoint point = vehicle.getVehicleData().getRotationPoint(attr.getAABBSP(box.getKey()));
				Vec3d temp = point.getRelativeVector(box.getValue()[0] * Static.sixteenth, -box.getValue()[1] * Static.sixteenth, -box.getValue()[2] * Static.sixteenth);
	        	//temp = temp.add(vehicle.getEntity().getPositionVector());
            	GL11.glPushMatrix();
	        	GL11.glTranslated(temp.x, temp.y, temp.z);
            	scal = box.getValue()[3] * Static.sixteenth;
				if(Command.TOGG_LABEL){
					postMeshCalls();
					float by = (consim(temp) * (scal * .5f));
		        	GL11.glTranslatef(0, by, 0);
					drawString(box.getKey(), scal * 2, RGB.WHITE.packed, true);
		        	GL11.glTranslatef(0, -by, 0);
		        	GL11.glTranslatef(0, -(by = scal * .5f), 0);
					drawString(attr.id(), scal * 2, RGB.WHITE.packed, true);
		        	GL11.glTranslatef(0, by, 0);
			        preMeshCalls();
			        toggpos.add(temp);
				}
            	GL11.glScalef(scal, scal, scal);
				DebugModels.ATTRBOXCUBE.render(2f);
            	GL11.glPopMatrix();
			}
			toggpos.clear();
		}
		postMeshCalls();
    	GL11.glPopMatrix();
	}

	private static float consim(Vec3d temp){
		int i = 0;
		for(Vec3d vec : toggpos) if(vec.distanceTo(temp) < 0.01f) i++;
		return i;
	}

	public static void renderContainerInfo(GenericVehicle vehicle, Vec3f rot){
        if((tempholder = vehicle.getCapability(Capabilities.CONTAINER, null)) != null) tempholder.render(0, 0, 0, rot.xCoord, rot.yCoord, rot.zCoord);
		if(!Command.CONTAINER) return;
    	if(tempholder != null) ((ContainerHolderUtil.Implementation)tempholder).renderDebug();
    	ContainerHolder cap = vehicle.getCapability(Capabilities.CONTAINER, null);
    	if(cap != null){
    		ContainerHoldingEntity ent = vehicle;
    		for(String slotid : cap.getContainerSlotIds()){
    			ContainerSlot slot = cap.getContainerSlot(slotid);
    			ContainerType type = ContainerType.values()[Time.getSecond() % 5];
            	for(int i = 0; i < slot.length; i += type.length()){
            		Vec3d vec = ent.getContainerInSlotPosition(slot.id, cap, type, i);
            		vehicle.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, vec.x, vec.y, vec.z, 0, 0, 0);
            	}
    		}
    	}
	}
	
	public static final void drawString(String str, float scale, int color, boolean rot){
        FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
        GlStateManager.pushMatrix();
        GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
        if(true) GlStateManager.disableLighting();
        if(rot) GL11.glRotatef(Minecraft.getMinecraft().player.rotationYawHead, 0, 1, 0);
        GlStateManager.depthMask(false);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(true);
        fontRenderer.drawString(str, -fontRenderer.getStringWidth(str) / 2, 0, color);
        if(true) GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

	public static Vec3f getRotations(GenericVehicle vehicle, float ticks){
        float yaw = (vehicle.getRotPoint().getAxes().getYaw() - vehicle.prevRotationYaw);
        while(yaw > 180f) yaw -= 360f;
        while(yaw <= -180f) yaw += 360f;
        float pitch = (vehicle.getRotPoint().getAxes().getPitch() - vehicle.prevRotationPitch);
        while(pitch > 180f) pitch -= 360f;
        while(pitch <= -180f) pitch += 360f;
        float roll = (vehicle.getRotPoint().getAxes().getRoll() - vehicle.prevRotationRoll);
        while(roll > 180f) roll -= 360f;
        while(roll <= -180f) roll += 360f;
        return new Vec3f(180F - vehicle.prevRotationYaw - yaw * ticks, vehicle.prevRotationPitch + pitch * ticks, vehicle.prevRotationRoll + roll * ticks);
	}

}
