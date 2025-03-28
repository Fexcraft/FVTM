package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.Config.RENDER_VEHICLES_SEPARATELY;
import static net.fexcraft.mod.fvtm.model.DefaultModel.RENDERDATA;
import static net.fexcraft.mod.fvtm.util.GLUtils112.translate;
import static net.fexcraft.mod.fvtm.util.GLUtils112.translateR;

import java.util.ArrayList;
import java.util.Map.Entry;

import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.InteractZone;
import net.fexcraft.mod.fvtm.data.part.PartData;
import net.fexcraft.mod.fvtm.model.RenderCache;
import net.fexcraft.mod.fvtm.data.vehicle.SwivelPoint;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleData;
import net.fexcraft.mod.fvtm.model.DebugModels;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class VehicleRenderer {
	
	private static final MutableBlockPos pos =  new BlockPos.MutableBlockPos(0, 0, 0);
	private static final ArrayList<Entity> entities = new ArrayList<>();
	private static AxisAlignedBB box;
	private static float ran;
	private static V3D iz;
	
    public static void renderVehicles(World world, double cx, double cy, double cz, float ticks){
    	if(!RENDER_VEHICLES_SEPARATELY) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
        double x, y, z;
        entities.clear();
        entities.addAll(world.loadedEntityList);
        for(Entity entity : entities){
        	if(entity instanceof RootVehicle == false) continue;
        	RootVehicle vehicle = (RootVehicle)entity;
			if(vehicle.vehicle.data == null) continue;
            x = vehicle.lastTickPosX + (vehicle.posX - vehicle.lastTickPosX) * ticks;
            y = vehicle.lastTickPosY + (vehicle.posY - vehicle.lastTickPosY) * ticks;
            z = vehicle.lastTickPosZ + (vehicle.posZ - vehicle.lastTickPosZ) * ticks;
			if(!inView(vehicle, x, y, z));
        	//
        	SeparateRenderCache.SORTED_VEH_POS.put(vehicle.getEntityId(), new double[]{ x, y, z });
            GL11.glTranslated(x - cx, y - cy, z - cz);
			if(Command.OTHER){
				for(SwivelPoint point : vehicle.vehicle.data.getRotationPoints().values()){
					V3D vec = point.getRelativeVector(0, 0.1f, 0);
					GL11.glTranslated(vec.x, vec.y, vec.z);
					DebugModels.SPHERE_GRY.render(1f);
					GL11.glTranslated(-vec.x, -vec.y, -vec.z);
				}
			}
            GL11.glPushMatrix();
			V3D rot = EffectRenderer.getRotations(vehicle, ticks);
			GL11.glRotated(-rot.x, 0.0F, 1.0F, 0.0F);
			GL11.glRotated(rot.y, 1.0F, 0.0F, 0.0F);
			GL11.glRotated(rot.z, 0.0F, 0.0F, 1.0F);
            SeparateRenderCache.SORTED_VEH_ROT.put(vehicle.getEntityId(), rot);
            //
	        int i = getBrightness(x, y, z), j = i % 65536, k = i / 65536;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            //
            GL11.glPushMatrix();
            RenderCache cache = vehicle.getCapability(Capabilities.RENDERCACHE, null);
            {
	            Model modVehicle = vehicle.vehicle.data.getType().getModel();
	            if(modVehicle != null){
					GL11.glPushMatrix();
	                TexUtil.bindTexture(vehicle.vehicle.data.getCurrentTexture());
	                modVehicle.render(RENDERDATA.set(vehicle.vehicle.data, null/*vehicle*/, cache, false, ticks));
					GL11.glPopMatrix();
	            }
				else {
					TexUtil.bindTexture(vehicle.vehicle.data.getCurrentTexture());
					DebugModels.SPHERE_RED.render(0.5f);
				}
				if(vehicle.vehicle.data.getParts().size() > 0){
					renderPoint(vehicle.vehicle.point, vehicle, vehicle.vehicle.data, cache, ticks);
					/*for(java.util.Map.Entry<String, PartData> entry : vehicle.getVehicleData().getParts().entrySet()){
						TexUtil.bindTexture(entry.getValue().getCurrentTexture());
						if(entry.getValue().isInstalledOnSwivelPoint()){
							GL11.glPushMatrix();
							PartModel.translateAndRotatePartOnSwivelPoint(vehicle.getVehicleData(), entry.getValue(), ticks);
							entry.getValue().getType().getModel().render(RENDERDATA.set(vehicle.getVehicleData(), vehicle, cache, entry.getValue(), entry.getKey(), false));
							GL11.glPopMatrix();
						}
						else{
							entry.getValue().getInstalledPos().translate();
							entry.getValue().getInstalledRot().rotate();
							entry.getValue().getType().getModel().render(RENDERDATA.set(vehicle.getVehicleData(), vehicle, cache, entry.getValue(), entry.getKey(), false));
							entry.getValue().getInstalledRot().rotateR();
							entry.getValue().getInstalledPos().translateR();
						}
					}*/
				}
            }
			EffectRenderer.renderVehicleInfo(vehicle.vehicle, vehicle.vehicle.entity.getPos(), vehicle.vehicle.data);
            GL11.glPopMatrix();
            //
            GL11.glPopMatrix();
            EffectRenderer.renderToggableInfo(vehicle, vehicle.vehicle.data);
            //EffectRenderer.renderContainerInfo(vehicle, rot);
            EffectRenderer.renderSeatsAndInvs(vehicle.vehicle);
            GL11.glTranslated(-x + cx, -y + cy, -z + cz);
        }
		GL11.glPopMatrix();
    }

	private static boolean inView(RootVehicle ent, double x, double y, double z){
		for(InteractZone value : ent.vehicle.data.getInteractZones().values()){
			iz = value.pos(ent.vehicle.data).add(x, y, z);
			ran = value.range;
			box = new AxisAlignedBB(iz.x - ran, iz.y - ran, iz.z - ran, iz.x + ran, iz.y + ran, iz.z + ran);
			if(RenderView.FRUSTUM.isBoundingBoxInFrustum(box)){
				return true;
			}
		}
		return false;
	}

	public static void renderPoint(SwivelPoint point, RootVehicle vehicle, VehicleData data, RenderCache cache, float ticks){
		ArrayList<Entry<String, PartData>> parts = data.sorted_parts.get(point.id);
		if(parts == null) return;
		boolean veh = false;
		GL11.glPushMatrix();
		if(!(veh = point.isVehicle())){
			V3D temp0 = point.getPos();
			V3D temp1 = point.getPrevPos();
			V3D temp2 = new V3D(temp1.x + (temp0.x - temp1.x) * ticks, temp1.y + (temp0.y - temp1.y) * ticks, temp1.z + (temp0.z - temp1.z) * ticks);
			V3D rot = EffectRenderer.getRotations(point, ticks);
			GL11.glTranslated(temp2.x, temp2.y, temp2.z);
			GL11.glRotated(-rot.x, 0, 1, 0);
			GL11.glRotated(-rot.y, 1, 0, 0);
			GL11.glRotated(-rot.z, 0, 0, 1);
		}
		for(Entry<String, PartData> entry : parts){
			TexUtil.bindTexture(entry.getValue().getCurrentTexture());
			translate(entry.getValue().getInstalledPos());
			entry.getValue().getInstalledRot().rotate112();
			entry.getValue().getType().getModel().render(RENDERDATA.set(data, vehicle == null ? null : vehicle.vehicle, cache, entry.getValue(), entry.getKey(), false, ticks));
			entry.getValue().getInstalledRot().rotate112R();
			translateR(entry.getValue().getInstalledPos());
		}
		for(SwivelPoint sub : point.subs) renderPoint(sub, vehicle, data, cache, ticks);
		GL11.glPopMatrix();
	}

	@Deprecated
	public static int getBrightness(double x, double y, double z){
		pos.setPos(x, y, z);
        if(Minecraft.getMinecraft().world.isBlockLoaded(pos)){
           return Minecraft.getMinecraft().world.getCombinedLight(pos, 0);
        }
        else return 0;
	}

}
