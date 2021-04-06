package net.fexcraft.mod.fvtm.render;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailSys;
import net.fexcraft.mod.fvtm.sys.rail.Region;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RailRenderer {
    
	private JunctionGridItem jitem;
    private ItemStack stack;
    private Vec316f[] vecs;
	//
	public static final RGB MIDDLE_GRAY = new RGB(127, 127, 127);
	public static boolean HOLDING;

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){ HOLDING = false;
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
    	if(stack.getItem() instanceof JunctionGridItem && ((JunctionGridItem)stack.getItem()).showJunctionGrid()){
    		Vec316f vec = new Vec316f(event.getPlayer().world, event.getTarget().hitVec, Config.RAIL_PLACING_GRID);
    		jitem = (JunctionGridItem)stack.getItem(); HOLDING = true;
    		if(jitem.offsetVectors()){
        		vecs = new Vec316f[jitem.getVectors(stack).length];
    			float seg = 360f / jitem.getSegments();
    			int con = (int)((((int)event.getPlayer().rotationYaw + 90f) * jitem.getSegments()) / 360f);
    			if(con % seg > seg / 2) con++;
    			for(int i = 0; i < vecs.length; i++){
    				vecs[i] = new Vec316f(VecUtil.rotByRad(seg * con * Static.rad1, jitem.getVectors(stack)[i].vector).add(vec.vector), Config.RAIL_PLACING_GRID);
    			}
				Print.bar(event.getPlayer(), seg + " " + con + " " + (seg * con) + " " + (seg * con * Static.rad1));
    		}
    		else{
    			vecs = jitem.getVectors(stack);
    		}
        	//
    		EntityPlayer player = event.getPlayer();
    		GlStateManager.disableTexture2D();
            double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
            double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
            double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
    		GL11.glTranslated(-x, -y, -z); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPushMatrix();
            GL11.glTranslated(vec.vector.x, vec.vector.y, vec.vector.z);
            model1.render();
            GL11.glPopMatrix();
            //
            for(int v = 0; v < vecs.length; v++){
        		GL11.glPushMatrix();
                GL11.glTranslated(vecs[v].vector.x, vecs[v].vector.y, vecs[v].vector.z);
                model0.render();
                if(jitem.offsetVectors() && (v == 0 || v == vecs.length - 1)) model.render();
                GL11.glPopMatrix();
            }
            //
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.depthMask(false);
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
        	float[][] color =  ((JunctionGridItem)stack.getItem()).getGridColours();
            if(vecs.length > 1){
                for(int i = 1; i < vecs.length; i++){
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vecs[i - 1].vector.x, vecs[i - 1].vector.y + 0.01, vecs[i - 1].vector.z)
                    	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
                    bufferbuilder.pos(vecs[i].vector.x, vecs[i].vector.y + 0.01, vecs[i].vector.z)
                    	.color(color[1][0], color[1][1], color[1][2], color[1][3]).endVertex();
                    tessellator.draw();
                }
            }
            BlockPos pos = event.getTarget().getBlockPos();
            float yy = vec.y == 0 ? 1 : vec.y * 0.0625f;
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ())
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ() + 1)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX(), pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625))
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + 1, pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625))
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            //
            GlStateManager.enableTexture2D();
            GL11.glTranslated(x, y, z);
    	} else return;
    }

	protected static final ModelRendererTurbo model, model0, model1, junction_core, railentcore;
	protected static final ModelRendererTurbo[] all;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, 0, 0, 0.4f, 8, 32, 1, 1, ModelRendererTurbo.MR_TOP).setColor(RGB.RED);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		junction_core = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(120, 120, 120));//35rgb
		railentcore = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addHollowCylinder(0, -4, 0, 8, 4, 8, 8, 0, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(128, 128, 128));
		all = new ModelRendererTurbo[]{ model, model0, model1, junction_core, railentcore };
		for(ModelRendererTurbo turbo : all){
			for(TexturedPolygon poly : turbo.getFaces()){
				poly.setColor(turbo.polygonColor);
			}
		}
	}
	
	private static RailSys raildata;
    private static Frustum fru = new Frustum();
    
    @SubscribeEvent
    public void renderRails(RenderWorldLastEvent event){
    	if(Config.DISABLE_RAILS) return;
	    raildata = Minecraft.getMinecraft().world.getCapability(Capabilities.RAILSYSTEM, null).get();
        //if(raildata.isLoading()) return;
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        fru.setPosition(x, y, z);
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        //ModelBase.bindTexture(Resources.NULL_TEXTURE);
        for(Region reg : raildata.getRegions().values()){
        	//if(reg.READING) continue;
        	Junction[] junctions = reg.getJunctions().values().toArray(new Junction[0]);
        	for(int i = 0; i < junctions.length; i++){
        		if(!fru.isBoundingBoxInFrustum(junctions[i].getAABB())) continue;
            	GL11.glPushMatrix();
            	ModelBase.bindTexture(Resources.NULL_TEXTURE);
            	GL11.glTranslatef(junctions[i].getVec3f().x, junctions[i].getVec3f().y, junctions[i].getVec3f().z);
            	if(junctions[i].tracks.isEmpty() || HOLDING){ model.render(); } else{ junction_core.render(); }
            	GL11.glPopMatrix();
        		renderLines(junctions[i]);
        	}
        	/*RailEntity[] entities = reg.getEntities().values().toArray(new RailEntity[0]);
        	for(int i = 0; i < entities.length; i++){
            	GL11.glPushMatrix();
            	GL11.glTranslatef(entities[i].pos.x, entities[i].pos.y, entities[i].pos.z);
            	//
	            GL11.glPushMatrix();
            	Minecraft.getMinecraft().entityRenderer.enableLightmap();
            	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            	GL11.glEnable(GL11.GL_LIGHTING);
            	GL11.glDisable(GL11.GL_BLEND);
            	RenderHelper.enableStandardItemLighting();
    	        int br = getBrightness(entities[i].pos.x, entities[i].pos.y, entities[i].pos.z), j = br % 65536, k = br / 65536;
    	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
    	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	            {
		            GL11.glRotatef(180f, 0f, 0f, 1f);
		            Model<VehicleData, Object> modVehicle = entities[i].vehdata.getType().getModel();
		            if(modVehicle != null){
		                ModelBase.bindTexture(entities[i].vehdata.getTexture());
		                modVehicle.render(entities[i].vehdata, null);
		                if(entities[i].vehdata.getParts().size() > 0){
		                	for(java.util.Map.Entry<String, PartData> entry : entities[i].vehdata.getParts().entrySet()){
		                    	ModelBase.bindTexture(entry.getValue().getTexture());
		                    	entry.getValue().getInstalledPos().translate();
		                        entry.getValue().getType().getModel().render(entities[i].vehdata, entry.getKey());
		                        entry.getValue().getInstalledPos().translateR();
		                	}
		                }
		            }
	            }
        		Minecraft.getMinecraft().entityRenderer.disableLightmap();
        		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        		GL11.glDisable(GL11.GL_LIGHTING);
	            GL11.glPopMatrix();
            	//
            	GL11.glPopMatrix();
        	}*/
        }
		GL11.glPopMatrix();
    }

	private void renderLines(Junction value){
        /*if(Command.DEBUG){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            Vec3f vec0, vec1; float flfl, glgl;
    		for(int o = 0; o < value.tracks.size(); o++){
    			Track conn = value.tracks.get(o);
    	        flfl = conn.isOppositeCopy() ? 1 : 0;
    	        glgl = conn.isOppositeCopy() ? 0 : 1;
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask(false);
    			for(int j = 0; j < conn.vecpath.length - 1; j++){
    				vec0 = conn.vecpath[j]; vec1 = conn.vecpath[j + 1];
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vec0.x, vec0.y + (conn.isOppositeCopy() ? 0.1f : 0), vec0.z).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.x, vec1.y + (conn.isOppositeCopy() ? 0.1f : 0), vec1.z).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
                //
                float[] vec = conn.getPosition(conn.length * (Time.getSecond() / 60f));
                if(vec.length == 1){ /*Print.debug(vec[0], conn.length);*//* continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.isOppositeCopy() ? 0.1f : 0), vec[2]);
                (conn.isOppositeCopy() ? model1 : model0).render();
                GL11.glPopMatrix();
    		}
        }
        else{*/
        	GL11.glPushMatrix();
        	Minecraft.getMinecraft().entityRenderer.enableLightmap();
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	GL11.glEnable(GL11.GL_LIGHTING);
        	GL11.glDisable(GL11.GL_BLEND);
        	RenderHelper.enableStandardItemLighting();
        	//
        	for(int i = 0; i < value.size(); i++){
        		if(i > 2) GL11.glTranslatef(0, -0.02f, 0);
        		if(value.tracks.get(i).isOppositeCopy()) continue;
        		Track track = value.tracks.get(i); RailGaugeModel model = track.gauge.getModel();
        		if(track.railmodel == null){ generateTrackModel(track, model); }
        		ModelBase.bindTexture(track.gauge.getRailTexture());
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.disableCull();
        		track.railmodel.render();
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.enableCull();
        		ModelBase.bindTexture(track.gauge.getTiesTexture());
        		track.restmodel.render();
        	}
        	if(Command.OTHER){
        		Track track;
        		for(int i = 0; i < value.size(); i++){ track = value.tracks.get(i);
	    			Vec3f pos = track.getVectorPosition(track.length * 0.5f, false); float off = track.isOppositeCopy() ? 0.125f : -0.125f;
	    			float deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90f;
	    			RenderStreetSign.drawString(track.getUnit().section().getUID() + "", pos.x + off, pos.y + 0.5, pos.z, true, true, 0.8f, track.isOppositeCopy() ? 0xb8bc38 : 0x32a852, deg);
	    			//
	    			if(!track.isOppositeCopy() && track.getUnit().getEntities().size() > 0){
	    				RailEntity[] ents = track.getUnit().getEntities().values().toArray(new RailEntity[0]);
	    				String str = ents[0].uid + ""; for(int j = 1; j < ents.length; j++) str += ", " + ents[j].uid;
	        			RenderStreetSign.drawString(str, pos.x, pos.y + 0.75, pos.z, true, true, 0.8f, 0x4287f5, deg);
	    			}
	    			/*if(!track.isOppositeCopy()){
	        			RenderStreetSign.drawString(track.getId().toUnitId(false), pos.x, pos.y + 1, pos.z, true, true, 0.8f, 0xb8bc38, deg);
	    			}*/
        		}
        	}
    		if(value.signal != null && value.size() == 2){
    			if(value.signalpos0 == null){
    				Track track = value.tracks.get(value.signal_dir.getTrackId());
    				Vec3f vec0 = track.start.vector, vec1 = track.getVectorPosition0(0.001f, false);
    				value.signalrot0 = (float)Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.signalrot0 += Static.rad90;
    				value.signalpos0 = vec0.add(VecUtil.rotByRad(value.signalrot0, new Vec3f(track.gauge.getModel().signal_offset, 0, 0)));
    				value.signalrot0 = (float)Math.toDegrees(value.signalrot0);
    			}
    			if(value.signal_dir.isBoth() && value.signalpos1 == null){
					Track track = value.tracks.get(1); Vec3f vec0 = track.start.vector, vec1 = track.getVectorPosition0(0.001f, false);
    				value.signalrot1 = (float)Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.signalrot1 += Static.rad90;
    				value.signalpos1 = vec0.add(VecUtil.rotByRad(value.signalrot1, new Vec3f(track.gauge.getModel().signal_offset, 0, 0)));
    				value.signalrot1 = (float)Math.toDegrees(value.signalrot1);
    			}
    			ModelBase.bindTexture(value.tracks.get(0).gauge.getModelTexture());
    			if(value.signalpos0 != null){
        			GL11.glPushMatrix();
        			GL11.glTranslatef(value.signalpos0.x, value.signalpos0.y, value.signalpos0.z);
        			GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(value.signalrot0, 0, 1, 0);
        			value.tracks.get(value.signal_dir.getTrackId()).gauge.getModel()
        				.renderSignal(value, value.signal_dir.isBoth() ? EntryDirection.BACKWARD : value.signal_dir, value.signal0);
        			GL11.glPopMatrix();
    			}
    			if(value.signalpos1 != null){
        			GL11.glPushMatrix();
        			GL11.glTranslatef(value.signalpos1.x, value.signalpos1.y, value.signalpos1.z);
        			GL11.glRotatef(180, 0, 0, 1); GL11.glRotatef(value.signalrot1, 0, 1, 0);
        			value.tracks.get(1).gauge.getModel().renderSignal(value, EntryDirection.FORWARD, value.signal1);
        			GL11.glPopMatrix();
    			}
    			if(Command.OTHER){
        			float deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90f;
        			long uid = value.tracks.get(value.signal_dir.getTrackId()).getUnit().section().getUID(); Vec3f pos = value.signalpos0;
        			RenderStreetSign.drawString(uid + "/" + value.signal0, pos.x, pos.y + 1, pos.z, true, true, 0.8f, 0xffffff, deg);
    				if(value.signal_dir.isBoth()){
    					uid = value.tracks.get(1).getUnit().section().getUID(); pos = value.signalpos1;
            			RenderStreetSign.drawString(uid + "/" + value.signal1, pos.x, pos.y + 1, pos.z, true, true, 0.8f, 0xffffff, deg);
    				}
    			}
    		}
    		if(value.size() == 1){
    			if(value.bufferrot == null){
    				Track track = value.tracks.get(0); Vec3f vec0 = track.start.vector, vec1 = track.getVectorPosition0(0.001f, false);
    				value.bufferrot = (float)Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.bufferrot += Static.rad90; value.bufferrot = (float)Math.toDegrees(-value.bufferrot);
    			}
    			GL11.glPushMatrix();
    			GL11.glTranslatef(value.getVec3f().x, value.getVec3f().y, value.getVec3f().z);
    			GL11.glRotatef(value.bufferrot, 0, 1, 0);
    			value.tracks.get(0).gauge.getModel().renderBuffer(value);
    			GL11.glPopMatrix();
    		}
        	//
    		Minecraft.getMinecraft().entityRenderer.disableLightmap();
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glDisable(GL11.GL_LIGHTING);
    		GL11.glPopMatrix();
        /*}*/
	}
	
	public static final void generateTrackModel(Track track, RailGaugeModel model){
		TurboArrayPositioned tarp = new TurboArrayPositioned(track, MIDDLE_GRAY);
		float angle, passed = 0; Vec3f last, vec; ArrayList<Vec3f> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3; TexturedPolygon poly0;
		//
		for(int p = 0; p < model.rails.length; p++){
			path.clear(); vec = track.getVectorPosition0(0.001f, false); passed = 0;
			angle = (float)Math.atan2(track.vecpath[0].z - vec.z, track.vecpath[0].x - vec.x);
			angle += Static.rad90;
			path.add(track.vecpath[0].add(VecUtil.rotByRad(angle, model.rails[p][0])));
			path.add(track.vecpath[0].add(VecUtil.rotByRad(angle, model.rails[p][1])));
			for(int v = 0; v < track.vecpath.length - 1; v++){
				last = track.vecpath[v]; vec = track.vecpath[v + 1];
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
				angle += Static.rad90;
				path.add(vec.add(VecUtil.rotByRad(angle, model.rails[p][0])));
				path.add(vec.add(VecUtil.rotByRad(angle, model.rails[p][1])));
			}
			for(int k = 0; k < track.vecpath.length - 1; k++){
				vert0 = new TexturedVertex(path.get(k * 2), 1, 1);
				vert1 = new TexturedVertex(path.get(k * 2 + 1), 0, 1);
				vert2 = new TexturedVertex(path.get((k + 1) * 2), 0, 0);
				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), 1, 0);
				/*Vec3f vac = new Vec3f((int)tarp.positions[pess].x, (int)tarp.positions[pess].y, (int)tarp.positions[pess].z);
				vert0.vector = vert0.vector.subtract(vac);
				vert1.vector = vert1.vector.subtract(vac);
				vert2.vector = vert2.vector.subtract(vac);
				vert3.vector = vert3.vector.subtract(vac);*/
				poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
				int pess = (int)passed; if(pess >= tarp.turbos.length) pess = tarp.turbos.length - 1;
				tarp.turbos[pess].copyTo(new TexturedPolygon[]{ poly0.setColor(MIDDLE_GRAY) });
				passed += track.vecpath[k].dis(track.vecpath[k + 1]);
			}
		}
		track.railmodel = tarp;
		//
		tarp = new TurboArrayPositioned(track, null);
		if(track.length >  model.ties_distance){
			float half = model.ties_distance * .5f, accu = half;
			while(accu < track.length){
				last = track.getVectorPosition0(accu - 0.1f, false); vec = track.getVectorPosition0(accu + 0.1f, false);
				angle = (float)Math.atan2(last.z - vec.z, last.x - vec.x);
				vec = track.getVectorPosition0(accu, false);;
				for(ModelRendererTurbo mrt : model.get("ties", false)){
					for(TexturedPolygon poly : mrt.getFaces()){
						TexturedVertex[] verts = new TexturedVertex[poly.getVertices().length];
						for(int m = 0; m < verts.length; m++){
							TexturedVertex org = poly.getVertices()[m];
							verts[m] = new TexturedVertex(VecUtil.rotByRad(angle, org.vector), org.textureX, org.textureY);
							verts[m].vector = verts[m].vector.scale(Static.sixteenth).add(vec);
						}
						tarp.turbos[(int)accu].copyTo(new TexturedPolygon(verts));
					}
				} accu += model.ties_distance;
			}
		}
		track.restmodel = tarp;
	}

	public static class TurboArrayPositioned {
		
		private ModelRendererTurbo[] turbos;
		private Vec3f[] positions;
		
		public TurboArrayPositioned(Track track, RGB colour){
			int i = (int)track.getLength(null);
			if(track.length % 1f > 0) i++;
			if(i == 0) i = 1;
			turbos = new ModelRendererTurbo[i];
			positions = new Vec3f[i];
			for(int k = 0; k < i; k++){
				turbos[k] = new ModelRendererTurbo(track, 0, 0, 16, 16);
				if(colour != null) turbos[k].setColor(colour);
				positions[k] = track.getVectorPosition(k == 0 ? 0.125f : k == i - 1 ? track.length - 0.125f : k, false);
			}
		}

		public void clearDisplayLists(){
			for(ModelRendererTurbo turbo : turbos) if(turbo != null && turbo.displaylist() != null) GL11.glDeleteLists(turbo.displaylist(), 1);
		}
		
		public void render(){
			for(int m = 0; m < turbos.length; m++){
		        int i = getBrightness(positions[m]), j = i % 65536, k = i / 65536;
		        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); turbos[m].render(1f);
			}
		}
		
		public void renderPlain(){
			for(int m = 0; m < turbos.length; m++){ turbos[m].render(1f); }
		}
		
	}

	@Deprecated
	public static int getBrightness(Vec3f vec){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(vec.x), 0, MathHelper.floor(vec.z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(vec.y)); return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        } else { return 0; }
	}

	@Deprecated
	public static int getBrightness(double x, double y, double z){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(y)); return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        } else { return 0; }
	}

}
