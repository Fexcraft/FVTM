package net.fexcraft.mod.fvtm.render;

import static net.fexcraft.mod.fvtm.Config.DISABLE_RAILS;

import java.util.ArrayList;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.JunctionGridItem;
import net.fexcraft.mod.fvtm.model.content.RailGaugeModel;
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
import net.fexcraft.mod.uni.item.StackWrapper;
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
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class RailRenderer {
    
	private JunctionGridItem jitem;
    private ItemStack stack;
    //private QV3D[] vecs;
	//
	public static final RGB MIDDLE_GRAY = new RGB(127, 127, 127);
	public static boolean HOLDING;

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){ HOLDING = false;
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
		//StackWrapper wrapper = StackWrapper.wrap(stack);
    	if(stack.getItem() instanceof JunctionGridItem && ((JunctionGridItem)stack.getItem()).showJunctionGrid()){
    		jitem = (JunctionGridItem)stack.getItem(); HOLDING = true;
    		QV3D vec = new QV3D(event.getTarget().hitVec.x, event.getTarget().hitVec.y, event.getTarget().hitVec.z);
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
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.depthMask(false);
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
        	float[][] color =  ((JunctionGridItem)stack.getItem()).getGridColours();
            BlockPos pos = event.getTarget().getBlockPos();
            double yy = vec.y == 0 ? 1 : vec.y * 0.0625f;
			for(int i = 0; i < 4; i++){
				bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
				bufferbuilder.pos(pos.getX() + (i * 0.25 + 0.125) - x, pos.getY() + yy + 0.01 - y, pos.getZ() - z)
					.color(1, 1, 1, 1f).endVertex();
				bufferbuilder.pos(pos.getX() + (i * 0.25 + 0.125) - x, pos.getY() + yy + 0.01 - y, pos.getZ() + 1 - z)
					.color(1, 1, 1, 1f).endVertex();
				tessellator.draw();
				bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
				bufferbuilder.pos(pos.getX() - x, pos.getY() + yy + 0.01 - y, pos.getZ() + (i * 0.25 + 0.125) - z)
					.color(1, 1, 1, 1f).endVertex();
				bufferbuilder.pos(pos.getX() + 1 - x, pos.getY() + yy + 0.01 - y, pos.getZ() + (i * 0.25 + 0.125) - z)
					.color(1, 1, 1, 1f).endVertex();
				tessellator.draw();
			}
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625) - x, pos.getY() + yy + 0.01 - y, pos.getZ() - z)
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
        		if(track.railmodel == null) PathModelGenerator.generateTrackModel(track, model);
        		TexUtil.bindTexture(track.gauge.getRailTexture());
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.disableCull();
				track.railmodel.render();
        		if(track.getGauge().getModel().rail_tempcull) GlStateManager.enableCull();
        		TexUtil.bindTexture(track.gauge.getTiesTexture());
				track.restmodel.render();
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
    				value.signalrot0 = Math.atan2(vec0.x - vec1.x, vec0.z - vec1.z);
    				value.signalpos0 = vec0.add(VecUtil.rotByRad(value.signalrot0, new V3D(track.gauge.getModel().signal_offset, 0, 0)));
    				value.signalrot0 = Math.toDegrees(value.signalrot0);
    			}
    			if(value.signal_dir.isBoth() && value.signalpos1 == null){
					Track track = value.tracks.get(1);
					V3D vec0 = track.start.vec, vec1 = track.getVectorPosition0(0.001f, false);
    				value.signalrot1 = Math.atan2(vec0.x - vec1.x, vec0.z - vec1.z);
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
    		/*if(value.size() == 1){
    			if(value.bufferrot == null){
    				Track track = value.tracks.get(0);
					V3D vec0 = track.start.vec, vec1 = track.getVectorPosition0(0.001f, false);
    				value.bufferrot = Math.atan2(vec0.x - vec1.x, vec0.z - vec1.z);
					value.bufferrot = Math.toDegrees(-value.bufferrot);
    			}
    			GL11.glPushMatrix();
    			GL11.glTranslated(value.getV3D().x - cx, value.getV3D().y - cy, value.getV3D().z - cz);
    			GL11.glRotated(value.bufferrot, 0, 1, 0);
    			value.tracks.get(0).gauge.getModel().renderBuffer(value);
    			GL11.glPopMatrix();
    		}*/
        	//
    		//Minecraft.getMinecraft().entityRenderer.disableLightmap();
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		//GL11.glDisable(GL11.GL_LIGHTING);
    		GL11.glPopMatrix();
        /*}*/
	}

}
