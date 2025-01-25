package net.fexcraft.mod.fvtm.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmGetters;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.part.Part;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.data.part.PartSlot;
import net.fexcraft.mod.fvtm.data.part.PartSlots;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.data.vehicle.WheelSlot;
import net.fexcraft.mod.fvtm.entity.RootVehicle;
import net.fexcraft.mod.fvtm.handler.DefaultPartInstallHandler;
import net.fexcraft.mod.fvtm.handler.WheelInstallationHandler;
import net.fexcraft.mod.fvtm.item.MaterialItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.ToolboxItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.sys.uni.SeatInstance;
import net.fexcraft.mod.fvtm.sys.uni.VehicleInstance;
import net.fexcraft.mod.fvtm.util.DebugUtils;
import net.fexcraft.mod.fvtm.util.PartItemApp;
import net.fexcraft.mod.fvtm.util.Rot;
import net.fexcraft.mod.uni.inv.UniStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.Map;

import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.render.Renderer120.*;
import static net.fexcraft.mod.fvtm.util.DebugUtils.*;
import static net.fexcraft.mod.fvtm.util.MathUtils.valDeg;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RVRenderer extends EntityRenderer<RootVehicle> {

	public RVRenderer(EntityRendererProvider.Context context){
		super(context);
		shadowRadius = 0.25F;
	}

	@Override
	public void render(RootVehicle veh, float yaw, float tick, PoseStack pose, MultiBufferSource buffer, int light){
		if(veh.vehicle == null || veh.vehicle.data == null) return;
		pose.pushPose();
		//pose.translate(0, 0, 0);
		V3D rot = getRotations(veh, tick);
		pose.mulPose(new Quaternionf()
			.rotateAxis((float)Static.toRadians(-rot.x), AY)
			.rotateAxis((float)Static.toRadians(rot.y), AX)
			.rotateAxis((float)Static.toRadians(rot.z), AZ)
		);
		Renderer120.set(pose, buffer, light);
		//
		pose.pushPose();
		Model vehmod = veh.vehicle.data.getType().getModel();
		FvtmRenderTypes.setCutout(veh.vehicle.data.getCurrentTexture());
		RenderCache cache = FvtmGetters.getRenderCache(veh);
		if(vehmod != null){
			pose.pushPose();
			vehmod.render(RENDERDATA.set(veh.vehicle.data, veh.vehicle, cache, false, tick));
			pose.popPose();
		}
		else{
			FvtmLogger.LOGGER.info("NO MODEL " + veh.getId() + " " + veh.vehicle.data.getType().getID());
			//TODO render "missing model" model
		}
		if(veh.vehicle.data.getParts().size() > 0){
			renderPoint(pose, veh.vehicle.point, veh, veh.vehicle.data, cache, tick);
		}
		V3D vp = veh.vehicle.getV3D();
		if(isInRange(pose, vp, veh.vehicle.data)){
			renderVehicleInfo(pose, vp, veh.vehicle.data);
			//renderInstallInfo(pose, vp, veh.vehicle.data);
			//renderWheelInstallInfo(pose, veh.vehicle.data);
			//renderRemovalInfo(pose, veh.vehicle.data);
		}
		pose.popPose();
		//
		//TODO toggle info
		//TODO containers
		if(DebugUtils.ACTIVE){
			/*Renderer120.set(RenderType.lines());
			pose.pushPose();
			float scale = veh.vehicle.data.getAttribute("collision_range").asFloat();
			pose.scale(scale, scale, scale);
			Renderer120.setColor(RGB.BLUE);
			DebugUtils.SPHERE.render();
			Renderer120.resetColor();
			pose.popPose();*/
			//
			renderSeats(pose, veh.vehicle);
		}
		pose.popPose();
	}

	private void renderSeats(PoseStack pose, VehicleInstance vehicle){
		if(vehicle.seats.isEmpty()) return;
		pose.pushPose();
		FvtmRenderTypes.setLines();
		float scale;
		for(SeatInstance seat : vehicle.seats){
			pose.pushPose();
			scale = seat.seat.scale() * 0.5f;
			V3D pos = seat.seat.pos;
			if(!seat.point.isVehicle()){
				pos = seat.point.getRelativeVector(pos);
			}
			pose.translate(pos.x, pos.y, pos.z);
			Renderer120.pose.scale(scale, scale, scale);
			Renderer120.setColor(SEATCOLOR);
			CUBE.render();
			pose.popPose();
		}
		Renderer120.resetColor();
		pose.popPose();
	}

	public static boolean isInRange(PoseStack pose, V3D vehpos, VehicleData data){
		FvtmRenderTypes.setLineStrip();
		V3D ply = new V3D(Minecraft.getInstance().player.position().x, Minecraft.getInstance().player.position().y, Minecraft.getInstance().player.position().z);
		boolean inrange = false;
		for(InteractZone zone : data.getInteractZones().values()){
			if(zone.inRange(data, vehpos, ply)){
				inrange = true;
				break;
			}
			if(DebugUtils.ACTIVE){
				pose.pushPose();
				Renderer120.setColor(zone.inRange(data, vehpos, ply) ? GRNCOLOR : GRYCOLOR);
				pose.scale(zone.range, zone.range, zone.range);
				DebugUtils.SPHERE.render();
				Renderer120.resetColor();
				pose.popPose();
			}
		}
		return inrange;
	}

	public static void renderVehicleInfo(PoseStack pose, V3D vehpos, VehicleData data){
		PartData part = isNormalPart();
		boolean red;
		SwivelPoint point = null;
		FvtmRenderTypes.setLines();
		if(part != null){
			for(Map.Entry<String, PartSlots> ps : data.getPartSlotProviders().entrySet()){
				V3D pos = ps.getKey().equals("vehicle") ? V3D.NULL : data.getPart(ps.getKey()).getInstalledPos();
				point = data.getRotationPointOfPart(ps.getKey());
				red = false;
				for(PartSlot value : ps.getValue().values()){
					if(data.hasPart(value.type)){
						Part epart = data.getPart(value.type).getType();
						if(!(epart.getInstallHandlerData() instanceof DefaultPartInstallHandler.DPIHData)) continue;
						red = !((DefaultPartInstallHandler.DPIHData)epart.getInstallHandlerData()).swappable;
					}
					String type = value.type;
					for(String str : part.getType().getCategories()){
						if(str.equals(type)){
							V3D pes = pos.add(value.pos);
							if(point.isVehicle()){
								pose.translate(pes.x, pes.y, pes.z);
							}
							else{
								pose.pushPose();
								V3D vec = point.getRelativeVector(pes);
								pose.translate(vec.x, vec.y, vec.z);
								rotateRad(point.getPivot().yaw(), AY);
								rotateRad(point.getPivot().pitch(), AX);
								rotateRad(point.getPivot().roll(), AZ);
							}
							pose.pushPose();
							pose.scale(value.radius, value.radius, value.radius);
							Renderer120.setColor(red ? REDCOLOR : CYNCOLOR);
							CUBE.render();
							pose.popPose();
							if(!point.isVehicle()) pose.popPose();
							else pose.translate(-pes.x, -pes.y, -pes.z);
						}
					}
				}
			}
		}
		//

		int tool = isImpact();
		if(tool > -1){
			red = data.getType().getImpactWrenchLevel() > tool ;
			for(WheelSlot slot : data.getWheelSlots().values()){
				pose.pushPose();
				pose.translate(slot.position.x, slot.position.y, slot.position.z);
				pose.scale(slot.max_radius, slot.max_radius, slot.max_radius);
				Renderer120.setColor(red ? REDCOLOR : CYNCOLOR);
				CUBE.render();
				pose.popPose();
			}
		}
		part = isWheelOrTire();
		if(part != null){
			WheelSlot slot;
			boolean wheel = part.hasFunction("fvtm:wheel");
			//boolean tire = part.hasFunction("fvtm:tire");
			boolean green;
			for(Map.Entry<String, WheelSlot> entry : data.getWheelSlots().entrySet()){
				green = part.getType().getInstallHandler().validInstall(FvtmLogger.NONE, part, entry.getKey(), data, true);
				if(wheel){
					red = data.hasPart(entry.getKey());
				}
				else{
					red = data.hasPart(entry.getKey()) && ((WheelInstallationHandler.WheelData)data.getPart(entry.getKey()).getType().getInstallHandlerData()).hasTire();
					if(!red) red = data.hasPart(entry.getKey() + ":tire");
				}
				slot = entry.getValue();
				pose.pushPose();
				pose.translate(slot.position.x, slot.position.y, slot.position.z);
				pose.scale(slot.max_radius, slot.max_radius, slot.max_radius);
				Renderer120.setColor(red ? REDCOLOR : green ? GRNCOLOR : CYNCOLOR);
				CUBE.render();
				pose.popPose();
			}
		}
		//
		tool = isToolbox();
		if(tool > 0){
			Renderer120.setColor(ORGCOLOR);
			CUBE.render();
		}
		if(tool > -1 && tool < 2){
			V3D pos;
			for(Map.Entry<String, PartData> entry : data.getParts().entrySet()){
				if(tool == 0 && entry.getValue().getType().getInstallHandlerData() instanceof DefaultPartInstallHandler.DPIHData == false) continue;
				red = tool != 0 || ((DefaultPartInstallHandler.DPIHData)entry.getValue().getType().getInstallHandlerData()).removable;
				point = data.getRotationPointOfPart(entry.getKey());
				pos = entry.getValue().getInstalledPos();
				if(point.isVehicle()){
					pose.translate(pos.x, pos.y, pos.z);
				}
				else{
					pose.pushPose();
					pos = point.getRelativeVector(pos);
					pose.translate(pos.x, pos.y, pos.z);
					rotateDeg(pose, point.getPivot().deg_yaw(), AY);
					rotateDeg(pose, point.getPivot().deg_pitch(), AX);
					rotateDeg(pose, point.getPivot().deg_roll(), AZ);
				}
				pose.pushPose();
				if(red){
					pose.scale(.25f, .25f, .25f);
					Renderer120.setColor(YLWCOLOR);
				}
				else{
					pose.scale(.125f, .125f, .125f);
					Renderer120.setColor(REDCOLOR);
				}
				CUBE.render();
				pose.popPose();
				if(!point.isVehicle()) pose.popPose();
				else pose.translate(-pos.x, -pos.y, -pos.z);
			}
		}
		Renderer120.resetColor();
	}

	private static int isImpact(){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof MaterialItem == false) return -1;
		return ((MaterialItem)Minecraft.getInstance().player.getMainHandItem().getItem()).getContent().getImpactLevel();
	}

	public static int isToolbox(){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof ToolboxItem == false) return -1;
		return ((ToolboxItem)Minecraft.getInstance().player.getMainHandItem().getItem()).var;
	}

	private static PartData isNormalPart(){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof PartItem == false) return null;
		PartData data = UniStack.getApp(Minecraft.getInstance().player.getMainHandItem(), PartItemApp.class).data;
		return data.getType().getInstallHandlerData() instanceof DefaultPartInstallHandler.DPIHData ? data : null;
	}

	private static PartData isWheelOrTire(){
		if(Minecraft.getInstance().player.getMainHandItem().getItem() instanceof PartItem == false) return null;
		PartData data = UniStack.getApp(Minecraft.getInstance().player.getMainHandItem(), PartItemApp.class).data;
		return data.hasFunction("fvtm:wheel") || data.hasFunction("fvtm:tire") ? data : null;
	}

	private V3D getRotations(RootVehicle veh, float ticks){
		double yaw = valDeg(veh.vehicle.pivot().deg_yaw() - veh.yRotO);
		double pitch = valDeg(veh.vehicle.pivot().deg_pitch() - veh.xRotO);
		double roll = valDeg(veh.vehicle.pivot().deg_roll() - veh.protZ);
		return new V3D(veh.yRotO + yaw * ticks, veh.xRotO + pitch * ticks, veh.protZ + roll * ticks);
	}

	public static V3D getRotations(SwivelPoint point, float ticks){
		double yaw = valDeg(point.getPivot().deg_yaw() - point.getPrevPivot().deg_yaw());
		double pitch = valDeg(point.getPivot().deg_pitch() - point.getPrevPivot().deg_pitch());
		double roll = valDeg(point.getPivot().deg_roll() - point.getPrevPivot().deg_roll());
		return new V3D(point.getPrevPivot().deg_yaw() + yaw * ticks, point.getPrevPivot().deg_pitch() + pitch * ticks, point.getPrevPivot().deg_roll() + roll * ticks);
	}

	public static void renderPoint(PoseStack pose, SwivelPoint point, RootVehicle vehicle, VehicleData data, RenderCache cache, float ticks){
		ArrayList<Map.Entry<String, PartData>> parts = data.sorted_parts.get(point.id);
		if(parts == null) return;
		pose.pushPose();
		if(!point.isVehicle()){
			V3D temp0 = point.getPos();
			V3D temp1 = point.getPrevPos();
			V3D temp2 = new V3D(temp1.x + (temp0.x - temp1.x) * ticks, temp1.y + (temp0.y - temp1.y) * ticks, temp1.z + (temp0.z - temp1.z) * ticks);
			V3D rot = getRotations(point, ticks);
			pose.translate(temp2.x, temp2.y, temp2.z);
			pose.mulPose(new Quaternionf()
				.rotateAxis((float)Static.toRadians(-rot.x), AY)
				.rotateAxis((float)Static.toRadians(-rot.y), AX)
				.rotateAxis((float)Static.toRadians(-rot.z), AZ)
			);
		}
		for(Map.Entry<String, PartData> entry : parts){
			if(entry.getValue().getType().getModel() == null) continue;
			pose.pushPose();
			FvtmRenderTypes.setCutout(entry.getValue().getCurrentTexture());
			translate(pose, entry.getValue().getInstalledPos());
			rotate(pose, entry.getValue().getInstalledRot());
			entry.getValue().getType().getModel().render(RENDERDATA.set(data, vehicle == null ? null : vehicle.vehicle, cache, entry.getValue(), entry.getKey(), false, ticks));
			pose.popPose();
		}
		for(SwivelPoint sub : point.subs) renderPoint(pose, sub, vehicle, data, cache, ticks);
		pose.popPose();
	}

	private static void translate(PoseStack pose, V3D pos){
		pose.translate(pos.x, pos.y, pos.z);
	}

	private static void rotate(PoseStack pose, Rot rot){
		rot.rotate112();
		Quaternionf q = new Quaternionf();
		if(rot.vec().y != 0f) q.rotateAxis((float)Static.toRadians(rot.vec().y), AY);
		if(rot.vec().x != 0f) q.rotateAxis((float)Static.toRadians(rot.vec().x), AX);
		if(rot.vec().z != 0f) q.rotateAxis((float)Static.toRadians(rot.vec().z), AZ);
		pose.mulPose(q);
	}

	@Override
	public ResourceLocation getTextureLocation(RootVehicle entity){
		return FvtmRegistry.WHITE_TEXTURE.local();
	}

}