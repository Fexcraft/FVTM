package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

import java.util.ArrayList;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.GLObject;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.EntryDirection;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailEntity;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil.NewTrack;
import net.fexcraft.mod.fvtm.sys.rail.RailSystem;
import net.fexcraft.mod.fvtm.sys.rail.Region;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager.Systems;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.QV3D;
import net.fexcraft.mod.fvtm.util.TexUtil;
import net.fexcraft.mod.fvtm.util.VecUtil;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class RailRenderer {
    
	private JunctionGridItem jitem;
    private ItemStack stack;
    private QV3D[] vecs;
	//
	public static final RGB MIDDLE_GRAY = new RGB(127, 127, 127);
	public static boolean HOLDING;

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){ HOLDING = false;
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
    	if(stack.getItem() instanceof JunctionGridItem && ((JunctionGridItem)stack.getItem()).showJunctionGrid()){
    		jitem = (JunctionGridItem)stack.getItem(); HOLDING = true;
    		QV3D vec = new QV3D(event.getTarget().hitVec.x, event.getTarget().hitVec.y, event.getTarget().hitVec.z, jitem.getPlacingGrid());
    		if(jitem.offsetVectors()){
        		vecs = new QV3D[jitem.getVectors(stack).length];
    			double seg = 360f / jitem.getSegments();
    			int con = (int)((((int)event.getPlayer().rotationYaw + 90f) * jitem.getSegments()) / 360f);
    			if(con % seg > seg / 2) con++;
    			for(int i = 0; i < vecs.length; i++){
    				vecs[i] = new QV3D(VecUtil.rotByRad(seg * con * Static.rad1, jitem.getVectors(stack)[i].vec).add(vec.vec), jitem.getPlacingGrid());
    			}
				if(Static.dev()) Print.bar(event.getPlayer(), seg + " " + con + " " + (seg * con) + " " + (seg * con * Static.rad1));
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
    		//GL11.glTranslated(-x, -y, -z);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPushMatrix();
            GL11.glTranslated(vec.vec.x - x, vec.vec.y - y, vec.vec.z - z);
            model1.render();
            GL11.glPopMatrix();
            //
            for(int v = 0; v < vecs.length; v++){
        		GL11.glPushMatrix();
                GL11.glTranslated(vecs[v].vec.x - x, vecs[v].vec.y - y, vecs[v].vec.z - z);
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
                    bufferbuilder.pos(vecs[i - 1].vec.x - x, vecs[i - 1].vec.y + 0.01 - y, vecs[i - 1].vec.z - z)
                    	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
                    bufferbuilder.pos(vecs[i].vec.x - x, vecs[i].vec.y + 0.01 - y, vecs[i].vec.z - z)
                    	.color(color[1][0], color[1][1], color[1][2], color[1][3]).endVertex();
                    tessellator.draw();
                }
            }
            BlockPos pos = event.getTarget().getBlockPos();
            double yy = vec.y == 0 ? 1 : vec.y * 0.0625f;
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625) - x, pos.getY() + yy + 0.01 - y, pos.getZ()- z)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625) - x, pos.getY() + yy + 0.01 - y, pos.getZ() + 1 - z)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() - x, pos.getY() + yy + 0.01 - y, pos.getZ() + (vec.z * 0.0625) - z)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            bufferbuilder.pos(pos.getX() + 1 - x, pos.getY() + yy + 0.01 - y, pos.getZ() + (vec.z * 0.0625) - z)
            	.color(color[0][0], color[0][1], color[0][2], color[0][3]).endVertex();
            tessellator.draw();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            //
            GlStateManager.enableTexture2D();
            //GL11.glTranslated(x, y, z);
    	} else return;
    }

	protected static final ModelRendererTurbo model, model0, model1, junction_core, railentcore;
	public static final ModelRendererTurbo junction_signal;
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
		junction_signal = new ModelRendererTurbo(null, 0, 0, 32, 32).setRotationAngle(0, 0, 0)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 3, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(35, 35, 35));
		railentcore = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addHollowCylinder(0, -4, 0, 8, 4, 8, 8, 0, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(128, 128, 128));
		all = new ModelRendererTurbo[]{ model, model0, model1, junction_core, railentcore };
		for(ModelRendererTurbo turbo : all){
			for(TexturedPolygon poly : turbo.getFaces()){
				poly.setColor(turbo.polygonColor);
			}
		}
	}
	
	public static final ResourceLocation WOOLTEX = new ResourceLocation("minecraft:textures/blocks/wool_colored_white.png");
	private static RailSystem raildata;
    
    //@SubscribeEvent
    public static void renderRails(World world, double cx, double cy, double cz, float partialticks){//RenderWorldLastEvent event){
    	if(DISABLE_RAILS) return;
	    raildata = SystemManager.get(Systems.RAIL, WrapperHolder.getWorld(world), RailSystem.class);
	    if(raildata == null || raildata.getRegions() == null) return;
        //if(raildata.isLoading()) return;
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //GL11.glTranslated(-cx, -cy, -cz);
        //TexUtil.bindTexture(Resources.NULL_TEXTURE);
        for(Region reg : raildata.getRegions().values()){
        	//if(reg.READING) continue;
        	Junction[] junctions = reg.getJunctions().values().toArray(new Junction[0]);
        	for(int i = 0; i < junctions.length; i++){
        		if(!RenderView.FRUSTUM.isBoundingBoxInFrustum(junctions[i].getAABB().local())) continue;
            	GL11.glPushMatrix();
            	TexUtil.bindTexture(WOOLTEX);
            	GL11.glTranslated(junctions[i].getV3D().x - cx, junctions[i].getV3D().y - cy, junctions[i].getV3D().z - cz);
            	if(junctions[i].tracks.isEmpty() || HOLDING){ model.render(); } else{ junction_core.render(); }
            	GL11.glPopMatrix();
        		renderLines(junctions[i], cx, cy, cz);
        	}
        }
        if(RailPlacingUtil.CL_CURRENT != null && RailPlacingUtil.CL_CURRENT.points.size() > 1){
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
			V3D vec0, vec1;
			NewTrack conn = RailPlacingUtil.CL_CURRENT;
			if(conn.preview == null) conn.genpreview();
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(4.0F);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask(false);
			for(int j = 0; j < conn.track.vecpath.length - 1; j++){
				vec0 = conn.track.vecpath[j].sub(cx, cy, cz);
				vec1 = conn.track.vecpath[j + 1].sub(cx, cy, cz);
                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                bufferbuilder.pos(vec0.x, vec0.y + 0.1, vec0.z).color(0, 0, 1, 1F).endVertex();
                bufferbuilder.pos(vec1.x, vec1.y + 0.1, vec1.z).color(0, 0, 1, 1F).endVertex();
                tessellator.draw();
			}
			if(RailPlacingUtil.CL_CURRENT.points.size() > 2){
				int size = RailPlacingUtil.CL_CURRENT.points.size();
				double[] arr = null;
				for(int i = 1; i < size - 1; i++){
					arr = conn.track.getPosition((conn.track.length / (size - 1)) * i);
					vec1 = RailPlacingUtil.CL_CURRENT.points.get(i).vec.sub(cx, cy, cz);
	                bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
	                bufferbuilder.pos(arr[0] - cx, arr[1] + 0.05 - cy, arr[2] - cz).color(0, 1, 1, 1F).endVertex();
	                bufferbuilder.pos(vec1.x, vec1.y + 0.05, vec1.z).color(0, 1, 1, 1F).endVertex();
	                tessellator.draw();
				}
			}
			for(ArrayList<V3D> l : conn.preview){
				for(int j = 0; j < l.size() - 1; j++){
					bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
					bufferbuilder.pos((vec0 = l.get(j).sub(cx, cy, cz)).x, vec0.y + conn.gauge.getHeight() + .05, vec0.z).color(1, 0.75f, 0, 1F).endVertex();
					bufferbuilder.pos((vec1 = l.get(j + 1).sub(cx, cy, cz)).x, vec1.y + conn.gauge.getHeight() + .05, vec1.z).color(1, 0.75f, 0, 1F).endVertex();
					tessellator.draw();
				}
			}
			//
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
        }
		GL11.glPopMatrix();
    }

	private static void renderLines(Junction value, double cx, double cy, double cz){
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
        	//Minecraft.getMinecraft().entityRenderer.enableLightmap();
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	//GL11.glEnable(GL11.GL_LIGHTING);
        	//GL11.glDisable(GL11.GL_BLEND);
        	//RenderHelper.enableStandardItemLighting();
        	//
        	for(int i = 0; i < value.size(); i++){
        		if(i > 2) GL11.glTranslatef(0, -0.02f, 0);
        		if(value.tracks.get(i).isOppositeCopy()) continue;
				GL11.glPushMatrix();
        		Track track = value.tracks.get(i);
				GL11.glTranslated(track.vecpath[0].x - cx, track.vecpath[0].y - cy, track.vecpath[0].z - cz);
				RailGaugeModel model = track.gauge.getModel();
        		if(track.railmodel == null){ generateTrackModel(track, model); }
        		TexUtil.bindTexture(track.gauge.getRailTexture());
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.disableCull();
				((TurboArrayPositioned)track.railmodel).render();
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.enableCull();
        		TexUtil.bindTexture(track.gauge.getTiesTexture());
				((TurboArrayPositioned)track.restmodel).render();
				GL11.glPopMatrix();
        	}
        	if(Command.OTHER){
        		Track track;
        		for(int i = 0; i < value.size(); i++){
        			track = value.tracks.get(i);
					V3D pos = track.getVectorPosition(track.length * 0.5f, false);
	    			double off = track.isOppositeCopy() ? 0.125f : -0.125f;
	    			double deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90f;
	    			RenderStreetSign.drawString(track.getUnit().section().getUID() + "", pos.x + off, pos.y + 0.5, pos.z, true, true, 0.8f, track.isOppositeCopy() ? 0xb8bc38 : 0x32a852, deg);
	    			//
	    			if(!track.isOppositeCopy() && track.getUnit().getEntities().size() > 0){
	    				RailEntity[] ents = track.getUnit().getEntities().toArray(new RailEntity[0]);
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
					V3D vec0 = track.start.vec, vec1 = track.getVectorPosition0(0.001f, false);
    				value.signalrot0 = Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.signalrot0 += Static.rad90;
    				value.signalpos0 = vec0.add(VecUtil.rotByRad(value.signalrot0, new V3D(track.gauge.getModel().signal_offset, 0, 0)));
    				value.signalrot0 = Math.toDegrees(value.signalrot0);
    			}
    			if(value.signal_dir.isBoth() && value.signalpos1 == null){
					Track track = value.tracks.get(1);
					V3D vec0 = track.start.vec, vec1 = track.getVectorPosition0(0.001f, false);
    				value.signalrot1 = Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.signalrot1 += Static.rad90;
    				value.signalpos1 = vec0.add(VecUtil.rotByRad(value.signalrot1, new V3D(track.gauge.getModel().signal_offset, 0, 0)));
    				value.signalrot1 = Math.toDegrees(value.signalrot1);
    			}
    			TexUtil.bindTexture(value.tracks.get(0).gauge.getModelTexture());
    			if(value.signalpos0 != null){
        			GL11.glPushMatrix();
        			GL11.glTranslated(value.signalpos0.x - cx, value.signalpos0.y - cy, value.signalpos0.z - cz);
        			GL11.glRotatef(180, 0, 0, 1);
					GL11.glRotated(value.signalrot0, 0, 1, 0);
        			value.tracks.get(value.signal_dir.getTrackId()).gauge.getModel()
        				.renderSignal(value, value.signal_dir.isBoth() ? EntryDirection.BACKWARD : value.signal_dir, value.signal0);
        			GL11.glPopMatrix();
    			}
    			if(value.signalpos1 != null){
        			GL11.glPushMatrix();
        			GL11.glTranslated(value.signalpos1.x - cx, value.signalpos1.y - cy, value.signalpos1.z - cz);
        			GL11.glRotatef(180, 0, 0, 1);
					GL11.glRotated(value.signalrot1, 0, 1, 0);
        			value.tracks.get(1).gauge.getModel().renderSignal(value, EntryDirection.FORWARD, value.signal1);
        			GL11.glPopMatrix();
    			}
    			if(Command.OTHER){
        			double deg = Minecraft.getMinecraft().player.getHorizontalFacing().getHorizontalIndex() * 90f;
        			long uid = value.tracks.get(value.signal_dir.getTrackId()).getUnit().section().getUID();
					V3D pos = value.signalpos0;
        			RenderStreetSign.drawString(uid + "/" + value.signal0, pos.x, pos.y + 1, pos.z, true, true, 0.8f, 0xffffff, deg);
    				if(value.signal_dir.isBoth()){
    					uid = value.tracks.get(1).getUnit().section().getUID();
						pos = value.signalpos1;
            			RenderStreetSign.drawString(uid + "/" + value.signal1, pos.x, pos.y + 1, pos.z, true, true, 0.8f, 0xffffff, deg);
    				}
    			}
    		}
    		if(value.size() == 1){
    			if(value.bufferrot == null){
    				Track track = value.tracks.get(0);
					V3D vec0 = track.start.vec, vec1 = track.getVectorPosition0(0.001f, false);
    				value.bufferrot = Math.atan2(vec0.z - vec1.z, vec0.x - vec1.x);
    				value.bufferrot += Static.rad90;
					value.bufferrot = Math.toDegrees(-value.bufferrot);
    			}
    			GL11.glPushMatrix();
    			GL11.glTranslated(value.getV3D().x - cx, value.getV3D().y - cy, value.getV3D().z - cz);
    			GL11.glRotated(value.bufferrot, 0, 1, 0);
    			value.tracks.get(0).gauge.getModel().renderBuffer(value);
    			GL11.glPopMatrix();
    		}
        	//
    		//Minecraft.getMinecraft().entityRenderer.disableLightmap();
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		//GL11.glDisable(GL11.GL_LIGHTING);
    		GL11.glPopMatrix();
        /*}*/
	}
	
	public static void generateTrackModel(Track track, RailGaugeModel model){
		double angle, passed = 0;
		V3D last, vec, cen = track.vecpath[0];
		ArrayList<V3D> path = new ArrayList<>();
		TexturedVertex vert0, vert1, vert2, vert3;
		TexturedPolygon poly0;
		//
		TurboArrayPositioned tarp = new TurboArrayPositioned(track, MIDDLE_GRAY);
		for(int p = 0; p < model.rail_model.size(); p++){
			path.clear();
			passed = 0;
			vec = track.getVectorPosition0(0.001f, false);
			angle = Math.atan2(track.vecpath[0].z - vec.z, track.vecpath[0].x - vec.x);
			angle += Static.rad90;
			path.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[0]));
			path.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[1]));
			for(int v = 0; v < track.vecpath.length - 1; v++){
				last = track.vecpath[v]; vec = track.vecpath[v + 1];
				angle = Math.atan2(last.z - vec.z, last.x - vec.x);
				angle += Static.rad90;
				path.add(vec.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[0])).sub(cen));
				path.add(vec.add(VecUtil.rotByRad(angle, model.rail_model.get(p)[1])).sub(cen));
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
			double half = model.ties_distance * .5, accu = half;
			while(accu < track.length){
				last = track.getVectorPosition0(accu - 0.1, false);
				vec = track.getVectorPosition0(accu + 0.1, false);
				angle = Math.atan2(last.z - vec.z, last.x - vec.x);
				vec = track.getVectorPosition0(accu, false);
				for(Polyhedron<GLObject> hedron : model.get("ties")){
					for(Polygon poly : hedron.polygons){
						TexturedVertex[] verts = new TexturedVertex[poly.vertices.length];
						for(int m = 0; m < verts.length; m++){
							Vertex org = poly.vertices[m];
							verts[m] = new TexturedVertex(VecUtil.rotByRad(angle, org.vector.x, org.vector.y, org.vector.z), org.u, org.v);
							double dx = (verts[m].vector.x * Static.sixteenth) + vec.x - cen.x;
							double dy = (verts[m].vector.y * Static.sixteenth) + vec.y - cen.y;
							double dz = (verts[m].vector.z * Static.sixteenth) + vec.z - cen.z;
							verts[m].vector = new Vec3f(dx, dy, dz);
						}
						tarp.turbos[(int)accu].copyTo(new TexturedPolygon(verts));
					}
				}
				accu += model.ties_distance;
			}
		}
		track.restmodel = tarp;
	}

	//@Deprecated
	public static int getBrightness(V3D vec){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(vec.x), 0, MathHelper.floor(vec.z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(vec.y));
            return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        }
        return 0;
	}

	//@Deprecated
	public static int getBrightness(double x, double y, double z){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(y));
            return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        }
        return 0;
	}

}
