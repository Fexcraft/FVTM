package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.data.Capabilities.RENDERCACHE;
import static net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots.VEHPARTSLOTS;
import static net.fexcraft.mod.fvtm.model.GenericModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.*;
import static net.fexcraft.mod.fvtm.util.AnotherUtil.toV3;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.mod.uni.Pos;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.SwivelPoint;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.attribute.AttributeBB;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.item.MultiBlockItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.BlockModel;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.DefaultPrograms.LightBeam;
import net.fexcraft.mod.fvtm.model.MRWrapper;
import net.fexcraft.mod.fvtm.model.SortedModelGroup.SeparateSortedModelGroup;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SeatCache;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.ResizeUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.handler.DefaultPartInstallHandler.DPIHData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class EffectRenderer {

	public static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation("fvtm:textures/entity/light_beam.png");
	private static ArrayList<Vec3d> toggpos = new ArrayList<>();
	private static ContainerHolder tempholder;
	
    @SubscribeEvent
    public void renderLights(RenderWorldLastEvent event){
    	if(SORTED_VEH_QUEUE.size() == 0 && SORTED_BLK_QUEUE.size() == 0) return;
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double cx = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double cy = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double cz = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if(SORTED_VEH_QUEUE.size() > 0){
            GL11.glPushMatrix();
            GL11.glTranslated(-cx, -cy, -cz);
            for(int i = 0; i < SORTED_VEH_QUEUE.size(); i++){
            	SeparateSortedModelGroup sroup = SORTED_VEH_QUEUE.get(i);
            	VehicleEntity veh = SORTED_VEH_ENTITY.get(i);
            	double[] vehpos = SORTED_VEH_POS.get(veh.getEntity().getEntityId());
            	if(vehpos == null) continue;
                GL11.glPushMatrix();
                GL11.glTranslated(vehpos[0], vehpos[1], vehpos[2]);
                //
                Vec3f vehrot = SORTED_VEH_ROT.get(veh.getEntity().getEntityId());
                GL11.glRotatef(vehrot.x, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(vehrot.y, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(vehrot.z, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(180f, 0f, 0f, 1f);
				sroup.render(RENDERDATA.set(SORTED_VEH_DATA.get(i), veh.getEntity(), veh.getEntity().getCapability(RENDERCACHE, null), null, null, false).sep());
            	GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
        }
        if(SORTED_BLK_QUEUE.size() > 0){
            GL11.glPushMatrix();
            GL11.glTranslated(-cx, -cy, -cz);
            for(int i = 0; i < SORTED_BLK_QUEUE.size(); i++){
            	SeparateSortedModelGroup sgroup = SORTED_BLK_QUEUE.get(i);
            	BlockData data = SORTED_BLK_DATA.get(i);
            	TileEntity tile = SORTED_BLK_ENTITY.get(i);
                GL11.glPushMatrix();
                GL11.glTranslated(tile.getPos().getX() + 0.5, tile.getPos().getY(), tile.getPos().getZ() + 0.5);
                GL11.glRotated(data.getType().getBlockType().getRotationForMeta(tile.getBlockMetadata()), 0.0F, 1.0F, 0.0F);
                //GL11.glRotatef(180f, 0f, 0f, 1f);
                sgroup.render(BlockModel.RENDERDATA.set(data, tile, tile.getCapability(Capabilities.RENDERCACHE, null), null, false).sep());
            	GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
        }
		SeparateRenderCache.clear();
        LightBeam.last = null;
    }

	public static void renderHotInstallInfo(GenericVehicle vehicle){
		Vec3d temp = null;
		SwivelPoint point;
		if(!Command.HOTSWAP){
			if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof PartItem == false) return;
			if(vehicle.getVehicleData().getAttribute("collision_range").float_value() + 1 < vehicle.getDistance(Minecraft.getMinecraft().player)) return;
			//
			PartData part = Minecraft.getMinecraft().player.getHeldItemMainhand().getCapability(Capabilities.VAPDATA, null).getPartData();
			if(part.getType().getInstallationHandlerData() instanceof DPIHData && ((DPIHData)part.getType().getInstallationHandlerData()).hotswap){
				preMeshCalls();
				for(Entry<String, PartSlots> ps : vehicle.getVehicleData().getPartSlotProviders().entrySet()){
					Pos pos = ps.getKey().equals(VEHPARTSLOTS) ? Pos.NULL : vehicle.getVehicleData().getPart(ps.getKey()).getInstalledPos();
					point = vehicle.getVehicleData().getRotationPointOfPart(ps.getKey());
					for(int i = 0; i < ps.getValue().size(); i++){
						String type = ps.getValue().get(i).type;
						for(String str : part.getType().getCategories()){
							if(str.equals(type)){
								Pos pes = pos.add(ps.getValue().get(i).pos);
								if(point.isVehicle()){
									temp = toV3(pes);
					            	GL11.glTranslated(temp.x, temp.y, temp.z);
								}
								else{
									GL11.glPushMatrix();
									Vec3d vec = point.getRelativeVector(toV3(pes), true);
									GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
									GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
									GL11.glTranslated(vec.x, vec.y, vec.z);
									GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
									GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
									GL11.glRotatef(point.getAxes().deg_yaw(), 0.0F, 1.0F, 0.0F);
									GL11.glRotatef(point.getAxes().deg_pitch(), 0.0F, 0.0F, 1.0F);
									GL11.glRotatef(point.getAxes().deg_roll(), 1.0F, 0.0F, 0.0F);
								}
				            	GL11.glPushMatrix();
				            	float scal = ps.getValue().get(i).radius;
				            	GL11.glScalef(scal, scal, scal);
								DebugModels.HOTINSTALLCUBE.render(1f);
				            	GL11.glPopMatrix();
				            	if(!point.isVehicle()) GL11.glPopMatrix();
				            	else GL11.glTranslated(-temp.x, -temp.y, -temp.z);
							}
						}
					}
				}
				postMeshCalls();
			}
		}
		else{
			preMeshCalls();
			for(Entry<String, PartSlots> ps : vehicle.getVehicleData().getPartSlotProviders().entrySet()){
				Pos pos = ps.getKey().equals(VEHPARTSLOTS) ? Pos.NULL : vehicle.getVehicleData().getPart(ps.getKey()).getInstalledPos();
				point = vehicle.getVehicleData().getRotationPointOfPart(ps.getKey());
				for(int i = 0; i < ps.getValue().size(); i++){
					Pos pes = pos.add(ps.getValue().get(i).pos);
					if(point.isVehicle()){
						temp = toV3(pes);
		            	GL11.glTranslated(temp.x, temp.y, temp.z);
					}
					else{
						GL11.glPushMatrix();
						Vec3d vec = point.getRelativeVector(toV3(pes), true);
						GL11.glRotated(-180f, 0.0F, 1.0F, 0.0F);
						GL11.glRotated(-180f, 0.0F, 0.0F, 1.0F);
						GL11.glTranslated(vec.x, vec.y, vec.z);
						GL11.glRotated(180f, 0.0F, 1.0F, 0.0F);
						GL11.glRotated(180f, 0.0F, 0.0F, 1.0F);
						GL11.glRotatef(point.getAxes().deg_yaw(), 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(point.getAxes().deg_pitch(), 0.0F, 0.0F, 1.0F);
						GL11.glRotatef(point.getAxes().deg_roll(), 1.0F, 0.0F, 0.0F);
					}
	            	GL11.glPushMatrix();
	            	float scal = ps.getValue().get(i).radius;
	            	GL11.glScalef(scal, scal, scal);
					DebugModels.HOTINSTALLCUBE.render(1f);
	            	GL11.glPopMatrix();
	            	if(!point.isVehicle()) GL11.glPopMatrix();
	            	else GL11.glTranslated(-temp.x, -temp.y, -temp.z);
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
    	float scal = vehicle.getVehicleData().getAttribute("collision_range").float_value() * 16;
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
        GlStateManager.disableLighting();
		for(Attribute<?> attr : vehicle.getVehicleData().getAttributes().values()){
			if(!attr.hasBBs()) continue;
			for(AttributeBB box : attr.getBBs().values()){
				SwivelPoint point = vehicle.getVehicleData().getRotationPoint(box.swivel_point);
				Vec3d temp = point.getRelativeVector(box.pos.x16, -box.pos.y16, -box.pos.z16);
	        	//temp = temp.add(vehicle.getEntity().getPositionVector());
				boolean depth = temp.add(vehicle.getEntity().getPositionVector()).distanceTo(Minecraft.getMinecraft().player.getPositionVector()) < 4;
	        	GL11.glTranslated(temp.x, temp.y, temp.z);
            	scal = box.size;
            	GL11.glPushMatrix();
            	GL11.glScalef(scal, scal, scal);
				DebugModels.ATTRBOXCUBE.render(2f);
            	GL11.glPopMatrix();
				if(Command.TOGG_LABEL){
					postMeshCalls();
					float by = (consim(temp) * (scal * .5f));
		        	GL11.glTranslatef(0, by, 0);
					drawString(box.id, scal * 2, RGB.WHITE.packed, false, true, depth);
		        	GL11.glTranslatef(0, -by, 0);
		        	GL11.glTranslatef(0, -(by = scal * .5f), 0);
					drawString(attr.id(), scal * 2, RGB.WHITE.packed, false, true, depth);
		        	GL11.glTranslatef(0, by, 0);
			        preMeshCalls();
			        toggpos.add(temp);
				}
	        	GL11.glTranslated(-temp.x, -temp.y, -temp.z);
			}
			toggpos.clear();
		}
		postMeshCalls();
        GlStateManager.enableLighting();
    	GL11.glPopMatrix();
	}

	private static float consim(Vec3d temp){
		int i = 0;
		for(Vec3d vec : toggpos) if(vec.distanceTo(temp) < 0.01f) i++;
		return i;
	}

	public static void renderContainerInfo(Entity entity, Vec3f rot){
        if((tempholder = entity.getCapability(Capabilities.CONTAINER, null)) != null) tempholder.render(0, 0, 0, rot.x, rot.y, rot.z);
        if(!Command.CONTAINER) return;
    	//if(tempholder != null) ((ContainerHolderUtil.Implementation)tempholder).renderDebug(0, 0, 0, rot.x, rot.y, rot.z);
    	if(tempholder != null){
    		ContainerHolderWrapper ent = tempholder.getWrapper();
    		for(String slotid : tempholder.getContainerSlotIds()){
    			ContainerSlot slot = tempholder.getContainerSlot(slotid);
    			ContainerType type = ContainerType.values()[Time.getSecond() % 5];
            	for(int i = 0; i < slot.length; i += type.length()){
            		Vec3d vec = ent.getContainerInSlotPosition(slot.id, tempholder, type, i);
            		entity.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, vec.x, vec.y, vec.z, 0, 0, 0);
            	}
    		}
    	}
	}

	/** Method version for cases where wrapper and holder isn't the same entity (e.g. compat mods). */
	public static void renderContainerInfo(World world, ContainerHolderWrapper entity, ContainerHolder holder, Vec3f rot){
        if((tempholder = holder) != null) tempholder.render(0, 0, 0, rot.x, rot.y, rot.z);
        if(!Command.CONTAINER) return;
    	//if(tempholder != null) ((ContainerHolderUtil.Implementation)tempholder).renderDebug(0, 0, 0, rot.x, rot.y, rot.z);
    	if(tempholder != null){
    		for(String slotid : tempholder.getContainerSlotIds()){
    			ContainerSlot slot = tempholder.getContainerSlot(slotid);
    			ContainerType type = ContainerType.values()[Time.getSecond() % 5];
            	for(int i = 0; i < slot.length; i += type.length()){
            		Vec3d vec = entity.getContainerInSlotPosition(slot.id, tempholder, type, i);
            		world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, vec.x, vec.y, vec.z, 0, 0, 0);
            	}
    		}
    	}
	}
	
	public static void renderSeats(GenericVehicle vehicle){
		if(!Command.HOTSWAP && !Command.TOGGABLE && !Command.OTHER) return;
		preMeshCalls();
    	GL11.glPushMatrix();
		for(SeatCache seat : vehicle.seats){
			Vec3d pos = seat.getFreshPosition().subtract(vehicle.posX, vehicle.posY, vehicle.posZ);
			GL11.glTranslated(pos.x, pos.y, pos.z);
			(seat.passenger() != null ? DebugModels.SEAT_CUBE_OCCUPIED : seat.seatdata.sitting ? DebugModels.SEAT_CUBE_SITTING : DebugModels.SEAT_CUBE_STANDING).render(0.5f * seat.seatdata.scale());
			GL11.glTranslated(-pos.x, -pos.y, -pos.z);
		}
    	GL11.glPopMatrix();
		postMeshCalls();
		RGB.glColorReset();
	}
	
	public static final void drawString(String str, float scale, int color, boolean light, boolean rot, boolean depth){
        FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
        GlStateManager.pushMatrix();
        RGB.WHITE.glColorApply();
        GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
        if(light) GlStateManager.disableLighting();
        if(rot) GL11.glRotatef(Minecraft.getMinecraft().player.rotationYawHead, 0, 1, 0);
        GlStateManager.depthMask(false);
        if(depth) GL11.glDisable(GL11.GL_DEPTH_TEST);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        fontRenderer.drawString(str, -fontRenderer.getStringWidth(str) / 2, 0, color);
        if(depth) GL11.glEnable(GL11.GL_DEPTH_TEST);
        GlStateManager.depthMask(true);
        if(light) GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

	public static Vec3f getRotations(GenericVehicle vehicle, float ticks){
        float yaw = (vehicle.getRotPoint().getAxes().deg_yaw() - vehicle.prevRotationYaw);
        while(yaw > 180f) yaw -= 360f;
        while(yaw <= -180f) yaw += 360f;
        float pitch = (vehicle.getRotPoint().getAxes().deg_pitch() - vehicle.prevRotationPitch);
        while(pitch > 180f) pitch -= 360f;
        while(pitch <= -180f) pitch += 360f;
        float roll = (vehicle.getRotPoint().getAxes().deg_roll() - vehicle.prevRotationRoll);
        while(roll > 180f) roll -= 360f;
        while(roll <= -180f) roll += 360f;
        return new Vec3f(180F - vehicle.prevRotationYaw - yaw * ticks, vehicle.prevRotationPitch + pitch * ticks, vehicle.prevRotationRoll + roll * ticks);
	}
	
	public static Vec3f getRotations(SwivelPoint point, float ticks){
        float yaw = (point.getAxes().deg_yaw() - point.getPrevAxes().deg_yaw());
        while(yaw > 180f) yaw -= 360f;
        while(yaw <= -180f) yaw += 360f;
        float pitch = (point.getAxes().deg_pitch() - point.getPrevAxes().deg_pitch());
        while(pitch > 180f) pitch -= 360f;
        while(pitch <= -180f) pitch += 360f;
        float roll = (point.getAxes().deg_roll() - point.getPrevAxes().deg_roll());
        while(roll > 180f) roll -= 360f;
        while(roll <= -180f) roll += 360f;
        return new Vec3f(point.getPrevAxes().deg_yaw() - yaw * ticks, point.getPrevAxes().deg_pitch() + pitch * ticks, point.getPrevAxes().deg_roll() + roll * ticks);
	}
	
	//

	@SubscribeEvent
    public void onRender(RenderPlayerEvent.Pre event) throws Exception {
		if(event.getEntity().getRidingEntity() instanceof GenericVehicle){
			((GenericVehicle)event.getEntity().getRidingEntity()).updateSittingState(event.getEntity());
		}
		float scale = ResizeUtil.getScale(event.getEntityPlayer());
		GlStateManager.pushMatrix();
		if(scale != 1){
			EntityPlayer player = event.getEntityPlayer();
	    	float width = player.width, height = player.height;
			float hw = width * 0.5f;
			player.setEntityBoundingBox(new AxisAlignedBB(player.posX - hw, player.posY + ResizeUtil.SITH, player.posZ - hw, player.posX + hw, player.posY + height + ResizeUtil.SITH, player.posZ + hw));
			scale = height * scale / height;
			GlStateManager.translate(event.getX(), event.getY() + ResizeUtil.SITH, event.getZ());
			GlStateManager.scale(scale, scale, scale);
			GlStateManager.translate(-event.getX(), -event.getY(), -event.getZ());
		}
		//
    	EntityPlayer player = event.getEntityPlayer();
    	ModelPlayer model = event.getRenderer().getMainModel();
    	MRWrapper wrapper;
    	for(int idx = 2; idx < EntityEquipmentSlot.values().length; idx++){
    		if(player.inventory.armorInventory.get(idx - 2).getItem() instanceof ClothItem){
    			ClothItem item = (ClothItem)player.inventory.armorInventory.get(idx - 2).getItem();
    			for(String key : item.getType().getModel().getClothGroups().keySet()){
    				wrapper = getWrapper(model, event.getRenderer(), key);
    				if(wrapper == null) continue;
    				wrapper.set(player, item, item.getType().getModel().getClothGroups().get(key), key);
    			}
    		}
    	}
    }
    
    private MRWrapper getWrapper(ModelBiped model, RenderLivingBase<?> renderer, String key){
		switch(key){
			case "head": return MRWrapper.get(model, model.bipedHead, renderer, key);
			case "body": return MRWrapper.get(model, model.bipedBody, renderer, key);
			case "left_arm": case "arm_left": return MRWrapper.get(model, model.bipedLeftArm, renderer, key);
			case "right_arm": case "arm_right": return MRWrapper.get(model, model.bipedRightArm, renderer, key);
			case "left_leg": case "leg_left": return MRWrapper.get(model, model.bipedLeftLeg, renderer, key);
			case "right_leg": case "leg_right": return MRWrapper.get(model, model.bipedRightLeg, renderer, key);
			case "skirt_front":{
				if(model.bipedLeftLeg.rotateAngleX < model.bipedRightLeg.rotateAngleX){
					return MRWrapper.get(model, model.bipedLeftLeg, renderer, "left_leg");
				}
				else return MRWrapper.get(model, model.bipedRightLeg, renderer, "right_leg");
			}
			case "skirt_back": case "skirt_rear": {
				if(model.bipedLeftLeg.rotateAngleX >= model.bipedRightLeg.rotateAngleX){
					return MRWrapper.get(model, model.bipedLeftLeg, renderer, "left_leg");
				}
				else return MRWrapper.get(model, model.bipedRightLeg, renderer, "right_leg");
			}
		}
		return null;
	}

	@SubscribeEvent
    public void onRender(RenderPlayerEvent.Post event) throws Exception {
		GlStateManager.popMatrix();
    }

	@SubscribeEvent
    public void onRender(RenderLivingEvent.Pre<EntityLivingBase> event) throws Exception {
		if(event.getEntity() instanceof EntityPlayer) return; 
		if(event.getEntity().getRidingEntity() instanceof GenericVehicle){
			((GenericVehicle)event.getEntity().getRidingEntity()).updateSittingState(event.getEntity());
		}
		float scale = ResizeUtil.getScale(event.getEntity());
		GlStateManager.pushMatrix();
		if(scale != 1){
			Entity entity = event.getEntity();
	    	float height = entity.height * scale;
			float hw = entity.width * scale * 0.5f;
			entity.setEntityBoundingBox(new AxisAlignedBB(entity.posX - hw, entity.posY, entity.posZ - hw, entity.posX + hw, entity.posY + height, entity.posZ + hw));
	    	scale = height * scale / height;
			GlStateManager.translate(event.getX(), event.getY(), event.getZ());
			GlStateManager.scale(scale, scale, scale);
			GlStateManager.translate(-event.getX(), -event.getY(), -event.getZ());
		}
		//
		if(event.getRenderer().getMainModel() instanceof ModelBiped == false) return;
    	EntityLivingBase entity = event.getEntity();
    	ModelBiped model = (ModelBiped)event.getRenderer().getMainModel();
    	MRWrapper wrapper;
		for(ItemStack stack : entity.getArmorInventoryList()){
			if(stack.getItem() instanceof ClothItem){
    			ClothItem item = (ClothItem)stack.getItem();
    			for(String key : item.getType().getModel().getClothGroups().keySet()){
    				wrapper = getWrapper(model, event.getRenderer(), key);
    				if(wrapper == null) continue;
    				wrapper.set(entity, item, item.getType().getModel().getClothGroups().get(key), key);
    			}
			}
		}
    }
    
    @SubscribeEvent
    public void onRender(RenderLivingEvent.Post<EntityLivingBase> event) throws Exception {
		if(event.getEntity() instanceof EntityPlayer) return;
		GlStateManager.popMatrix();
    }
    
    private static final ModelRendererTurbo blkpreview = new ModelRendererTurbo(null).addBox(0, 0, 0, 14, 14, 14);
    private static ItemStack stack;

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){
		if(!Command.OTHER) return;
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty() || stack.getItem() instanceof MultiBlockItem == false) return;
    	if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
		if(event.getTarget().sideHit != EnumFacing.UP) return;
    	MultiBlockItem item = (MultiBlockItem)stack.getItem();
    	BlockPos pos = event.getTarget().getBlockPos().add(0, 1, 0);
        pos = event.getPlayer().world.getBlockState(pos).getBlock().isReplaceable(event.getPlayer().world, pos) ? pos : pos.add(0, 1, 0);
        ArrayList<BlockPos> poslist = item.getType().getPositions(pos, event.getPlayer().getHorizontalFacing());
        //
		EntityPlayer player = event.getPlayer();
		GlStateManager.disableTexture2D();
        double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
        double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
        double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
		GL11.glPushMatrix();
		GL11.glTranslated(-x, -y, -z);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		TexUtil.bindTexture(Resources.WHITE_TEXTURE);
		for(BlockPos blkpos : poslist){
			GL11.glPushMatrix();
	        GL11.glTranslated(blkpos.getX(), blkpos.getY(), blkpos.getZ());
	        blkpreview.render();
	        GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
    }

}
