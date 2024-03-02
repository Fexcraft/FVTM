package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.math.*;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.attribute.AttrBox;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.container.ContainerSlot;
import net.fexcraft.mod.fvtm.data.container.ContainerType;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler.DPIHData;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.item.MultiBlockItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.MRWrapper;
import net.fexcraft.mod.fvtm.model.SortedModelGroup.SeparateSortedModelGroup;
import net.fexcraft.mod.fvtm.model.program.DefaultPrograms.LightBeam;
import net.fexcraft.mod.fvtm.sys.uni.*;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.GLUtils112;
import net.fexcraft.mod.fvtm.util.ResizeUtil;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
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

import java.util.ArrayList;
import java.util.Map.Entry;

import static net.fexcraft.mod.fvtm.data.Capabilities.RENDERCACHE;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.SeparateRenderCache.*;
import static net.fexcraft.mod.fvtm.util.MathUtils.valDeg;

public class EffectRenderer {

	public static final ResourceLocation LIGHT_TEXTURE = new ResourceLocation("fvtm:textures/entity/light_beam.png");
	private static ArrayList<V3D> toggpos = new ArrayList<>();
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
                V3D vehrot = SORTED_VEH_ROT.get(veh.getEntity().getEntityId());
                GL11.glRotated(vehrot.x, 0, 1, 0);
                GL11.glRotated(vehrot.y, 0, 0, 1);
                GL11.glRotated(vehrot.z, 1, 0, 0);
                GL11.glRotatef(180f, 0f, 0f, 1f);
				sroup.render(RENDERDATA.set(SORTED_VEH_DATA.get(i), veh.getEntity(), veh.getEntity().getCapability(RENDERCACHE, null), null, null, false, event.getPartialTicks()).sep());
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
                GL11.glRotated(data.getType().getBlockType().getRotationFor(tile.getBlockMetadata()), 0.0F, 1.0F, 0.0F);
                //GL11.glRotatef(180f, 0f, 0f, 1f);
                sgroup.render(RENDERDATA.set(data, tile, tile.getCapability(Capabilities.RENDERCACHE, null), null, false).sep());
            	GL11.glPopMatrix();
            }
            GL11.glPopMatrix();
        }
		SeparateRenderCache.clear();
        LightBeam.last = null;
    }

	public static void renderHotInstallInfo(Entity vehicle, VehicleData data){
		//Vec3d temp = null;
		SwivelPoint point;
		if(!Command.HOTSWAP){
			if(Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof PartItem == false) return;
			if(data.getAttribute("collision_range").asFloat() + 1 < vehicle.getDistance(Minecraft.getMinecraft().player)) return;
			//
			PartData part = Minecraft.getMinecraft().player.getHeldItemMainhand().getCapability(Capabilities.VAPDATA, null).getPartData();
			if(part.getType().getInstallHandlerData() instanceof DPIHData == false) return;
			preMeshCalls();
			for(Entry<String, PartSlots> ps : data.getPartSlotProviders().entrySet()){
				V3D pos = ps.getKey().equals("vehicle") ? V3D.NULL : data.getPart(ps.getKey()).getInstalledPos();
				point = data.getRotationPointOfPart(ps.getKey());
				for(PartSlot value : ps.getValue().values()){
					if(data.hasPart(value.type)){
						Part epart = data.getPart(value.type).getType();
						if(!(epart.getInstallHandlerData() instanceof DPIHData) || !((DPIHData)epart.getInstallHandlerData()).swappable) continue;
					}
					String type = value.type;
					for(String str : part.getType().getCategories()){
						if(str.equals(type)){
							V3D pes = pos.add(value.pos);
							if(point.isVehicle()){
								GL11.glTranslated(pes.x, pes.y, pes.z);
							}
							else{
								GL11.glPushMatrix();
								V3D vec = point.getRelativeVector(pes);
								GL11.glTranslated(vec.x, vec.y, vec.z);
								GL11.glRotatef(point.getPivot().deg_yaw(), 0, 1, 0);
								GL11.glRotatef(point.getPivot().deg_pitch(), 1, 0, 0);
								GL11.glRotatef(point.getPivot().deg_roll(), 0, 0, 1);
							}
							GL11.glPushMatrix();
							GL11.glScalef(value.radius, value.radius, value.radius);
							DebugModels.HOTINSTALLCUBE.render(1f);
							GL11.glPopMatrix();
							if(!point.isVehicle()) GL11.glPopMatrix();
							else GL11.glTranslated(-pes.x, -pes.y, -pes.z);
						}
					}
				}
			}
			postMeshCalls();
		}
		else{
			preMeshCalls();
			for(Entry<String, PartSlots> ps : data.getPartSlotProviders().entrySet()){
				V3D pos = ps.getKey().equals("vehicle") ? V3D.NULL : data.getPart(ps.getKey()).getInstalledPos();
				point = data.getRotationPointOfPart(ps.getKey());
				for(PartSlot value : ps.getValue().values()){
					V3D pes = pos.add(value.pos);
					if(point.isVehicle()){
						GL11.glTranslated(pes.x, pes.y, pes.z);
					}
					else{
						GL11.glPushMatrix();
						V3D vec = point.getRelativeVector(pes);
						GL11.glTranslated(vec.x, vec.y, vec.z);
						GL11.glRotatef(point.getPivot().deg_yaw(), 0, 1, 0);
						GL11.glRotatef(point.getPivot().deg_pitch(), 1, 0, 0);
						GL11.glRotatef(point.getPivot().deg_roll(), 0, 0, 1);
					}
					GL11.glPushMatrix();
					GL11.glScalef(value.radius, value.radius, value.radius);
					DebugModels.HOTINSTALLCUBE.render(1f);
					GL11.glPopMatrix();
					if(!point.isVehicle()) GL11.glPopMatrix();
					else GL11.glTranslated(-pes.x, -pes.y, -pes.z);
				}
			}
			postMeshCalls();
			if(Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
				for(Entry<String, PartSlots> ps : data.getPartSlotProviders().entrySet()){
					V3D pos = ps.getKey().equals("vehicle") ? V3D.NULL : data.getPart(ps.getKey()).getInstalledPos();
					point = data.getRotationPointOfPart(ps.getKey());
					for(Entry<String, PartSlot> entry : ps.getValue().entrySet()){
						V3D pes = pos.add(entry.getValue().pos);
						if(point.isVehicle()){
							GL11.glTranslated(pes.x, pes.y, pes.z);
						}
						else{
							GL11.glPushMatrix();
							V3D vec = point.getRelativeVector(pes);
							GL11.glTranslated(vec.x, vec.y, vec.z);
							GL11.glRotatef(point.getPivot().deg_yaw(), 0, 1, 0);
							GL11.glRotatef(point.getPivot().deg_pitch(), 1, 0, 0);
							GL11.glRotatef(point.getPivot().deg_roll(), 0, 0, 1);
						}
						RenderStreetSign.drawString(entry.getKey(), 0, entry.getValue().radius + 0.1f, 0, true, true, 0.5f, 0xffffff, null);
						if(!point.isVehicle()) GL11.glPopMatrix();
						else GL11.glTranslated(-pes.x, -pes.y, -pes.z);
					}
				}
			}
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

	public static void renderToggableInfo(Entity vehicle, VehicleData data){
		if(!Command.TOGGABLE) return;
    	GL11.glPushMatrix();
    	float scal = data.getAttribute("collision_range").asFloat() * 16;
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
		for(Attribute<?> attr : data.getAttributes().values()){
			if(!attr.hasBoxes()) continue;
			for(AttrBox box : attr.actboxes.values()){
				SwivelPoint point = data.getRotationPoint(box.swivel_point);
				V3D temp = point.getRelativeVector(box.pos.x, -box.pos.y, -box.pos.z);
	        	//temp = temp.add(vehicle.getEntity().getPositionVector());
				boolean depth = temp.add(vehicle.posX, vehicle.posY, vehicle.posZ).dis(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY, Minecraft.getMinecraft().player.posZ) < 4;
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
					drawString(attr.id, scal * 2, RGB.WHITE.packed, false, true, depth);
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

	private static float consim(V3D temp){
		int i = 0;
		for(V3D vec : toggpos) if(vec.dis(temp) < 0.01f) i++;
		return i;
	}

	public static void renderContainerInfo(Entity entity, V3D rot){
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
			V3D pos = seat.getFreshPosition().sub(vehicle.posX, vehicle.posY, vehicle.posZ);
			GL11.glTranslated(pos.x, pos.y, pos.z);
			(seat.passenger() != null ? DebugModels.SEAT_CUBE_OCCUPIED : seat.seatdata.sitting ? DebugModels.SEAT_CUBE_SITTING : DebugModels.SEAT_CUBE_STANDING).render(0.5f * seat.seatdata.scale());
			GL11.glTranslated(-pos.x, -pos.y, -pos.z);
		}
    	GL11.glPopMatrix();
		postMeshCalls();
		RGB.glColorReset();
	}

	public static void renderSeats(VehicleInstance vehicle){
		if(!Command.HOTSWAP && !Command.TOGGABLE && !Command.OTHER) return;
		preMeshCalls();
		GL11.glPushMatrix();
		for(SeatInstance seat : vehicle.seats){
			if(seat.point.isVehicle()){
				GLUtils112.translate(seat.seat.pos);
			}
			else{
				GL11.glPushMatrix();
				GLUtils112.translate(seat.point.getRelativeVector(seat.seat.pos));
				GL11.glRotatef(seat.point.getPivot().deg_yaw(), 0, 1, 0);
				GL11.glRotatef(seat.point.getPivot().deg_pitch(), 1, 0, 0);
				GL11.glRotatef(seat.point.getPivot().deg_roll(), 0, 0, 1);
			}
			(seat.passenger() != null ? DebugModels.SEAT_CUBE_OCCUPIED : seat.seat.sitting ? DebugModels.SEAT_CUBE_SITTING : DebugModels.SEAT_CUBE_STANDING).render(0.5f * seat.seat.scale());
			if(!seat.point.isVehicle()) GL11.glPopMatrix();
			else GLUtils112.translateR(seat.seat.pos);
		}
		GL11.glPopMatrix();
		postMeshCalls();
		if(Minecraft.getMinecraft().getRenderManager().isDebugBoundingBox()){
			for(SeatInstance seat : vehicle.seats){
				if(seat.point.isVehicle()){
					GLUtils112.translate(seat.seat.pos);
				}
				else{
					GL11.glPushMatrix();
					GLUtils112.translate(seat.point.getRelativeVector(seat.seat.pos));
					GL11.glRotatef(seat.point.getPivot().deg_yaw(), 0, 1, 0);
					GL11.glRotatef(seat.point.getPivot().deg_pitch(), 1, 0, 0);
					GL11.glRotatef(seat.point.getPivot().deg_roll(), 0, 0, 1);
				}
				RenderStreetSign.drawString(seat.seat.name, 0, 0.5f, 0, true, true, 0.5f, 0xffffff, null);
				if(!seat.point.isVehicle()) GL11.glPopMatrix();
				else GLUtils112.translateR(seat.seat.pos);
			}
		}
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

	public static V3D getRotations(RootVehicle veh, float ticks){
		double yaw = valDeg(veh.vehicle.pivot().deg_yaw() - veh.prevRotationYaw);
		double pitch = valDeg(veh.vehicle.pivot().deg_pitch() - veh.prevRotationPitch);
		double roll = valDeg(veh.vehicle.pivot().deg_roll() - veh.prevRotationRoll);
		return new V3D(veh.prevRotationYaw + yaw * ticks, veh.prevRotationPitch + pitch * ticks, veh.prevRotationRoll + roll * ticks);
	}
	
	public static V3D getRotations(SwivelPoint point, float ticks){
		double yaw = valDeg(point.getPivot().deg_yaw() - point.getPrevPivot().deg_yaw());
		double pitch = valDeg(point.getPivot().deg_pitch() - point.getPrevPivot().deg_pitch());
		double roll = valDeg(point.getPivot().deg_roll() - point.getPrevPivot().deg_roll());
		return new V3D(point.getPrevPivot().deg_yaw() + yaw * ticks, point.getPrevPivot().deg_pitch() + pitch * ticks, point.getPrevPivot().deg_roll() + roll * ticks);
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
    			for(String key : item.getContent().getClothModel().getClothGroups().keySet()){
    				wrapper = getWrapper(model, event.getRenderer(), key);
    				if(wrapper == null) continue;
    				wrapper.set(player, item, item.getContent().getClothModel().getClothGroups().get(key), key);
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
    			for(String key : item.getContent().getClothModel().getClothGroups().keySet()){
    				wrapper = getWrapper(model, event.getRenderer(), key);
    				if(wrapper == null) continue;
    				wrapper.set(entity, item, item.getContent().getClothModel().getClothGroups().get(key), key);
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
        ArrayList<V3I> poslist = item.getContent().getPositions(new V3I(pos.getX(), pos.getY(), pos.getZ()), WrapperHolder.getSide(event.getPlayer().getHorizontalFacing()));
        //
		EntityPlayer player = event.getPlayer();
		GlStateManager.disableTexture2D();
        double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
        double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
        double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
		GL11.glPushMatrix();
		GL11.glTranslated(-x, -y, -z);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		TexUtil.bindTexture(FvtmRegistry.WHITE_TEXTURE);
		for(V3I vec : poslist){
			GL11.glPushMatrix();
	        GL11.glTranslated(vec.x, vec.y, vec.z);
	        blkpreview.render();
	        GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
    }

}
