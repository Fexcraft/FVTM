package net.fexcraft.mod.fvtm.render;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.item.RailGaugeItem;
import net.fexcraft.mod.fvtm.item.RailItemTest;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailData;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.Vec316f;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
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
    
    private ItemStack stack;
    private Vec316f[] vecs;
	//
	public static final RGB MIDDLE_GRAY = new RGB(127, 127, 127);

	@SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){
    	if((stack = event.getPlayer().getHeldItemMainhand()).isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != net.minecraft.util.math.RayTraceResult.Type.BLOCK) return;
    	if(stack.getItem() instanceof RailGaugeItem || stack.getItem() instanceof RailItemTest || isRailVehicleItem(stack)){
    		vecs = stack.getItem() instanceof RailGaugeItem ? ((RailGaugeItem)stack.getItem()).getVectors(stack) : new Vec316f[0];
    		Vec316f vec = new Vec316f(event.getTarget().hitVec, Config.RAIL_PLACING_GRID);
        	//
    		EntityPlayer player = event.getPlayer(); GlStateManager.disableTexture2D();
            double x = player.lastTickPosX + (player.posX - player.lastTickPosX) * event.getPartialTicks();
            double y = player.lastTickPosY + (player.posY - player.lastTickPosY) * event.getPartialTicks();
            double z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * event.getPartialTicks();
    		GL11.glTranslated(-x, -y, -z); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    		GL11.glPushMatrix();
            GL11.glTranslated(vec.vector.xCoord, vec.vector.yCoord, vec.vector.zCoord);
            model1.render(); GL11.glPopMatrix();
            //
            for(Vec316f v : vecs){
        		GL11.glPushMatrix();
                GL11.glTranslated(v.vector.xCoord, v.vector.yCoord, v.vector.zCoord);
                model0.render(); GL11.glPopMatrix();
            }
            //
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0F);
            GlStateManager.depthMask(false);
    		Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            if(vecs.length > 1){
                for(int i = 1; i < vecs.length; i++){
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vecs[i - 1].vector.xCoord, vecs[i - 1].vector.yCoord, vecs[i - 1].vector.zCoord).color(0f, 1f, 0f, 1F).endVertex();
                    bufferbuilder.pos(vecs[i].vector.xCoord, vecs[i].vector.yCoord, vecs[i].vector.zCoord).color(0f, 1f, 0f, 1F).endVertex();
                    tessellator.draw();
                }
            }
            BlockPos pos = event.getTarget().getBlockPos();
            float yy = vec.y == 0 ? 1 : vec.y * 0.0625f;
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ()).color(0f, 1f, 0f, 1F).endVertex();
            bufferbuilder.pos(pos.getX() + (vec.x * 0.0625), pos.getY() + yy + 0.01, pos.getZ() + 1).color(0f, 1f, 0f, 1F).endVertex();
            tessellator.draw();
            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.getX(), pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625)).color(0f, 1f, 0f, 1F).endVertex();
            bufferbuilder.pos(pos.getX() + 1, pos.getY() + yy + 0.01, pos.getZ() + (vec.z * 0.0625)).color(0f, 1f, 0f, 1F).endVertex();
            tessellator.draw();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
            //
            GlStateManager.enableTexture2D();
            GL11.glTranslated(x, y, z);
    	} else return;
    }
    
	private boolean isRailVehicleItem(ItemStack stack){
		return stack.getItem() instanceof VehicleItem && ((VehicleItem)stack.getItem()).getType().getVehicleType().isRailVehicle();
	}

	protected static final ModelRendererTurbo model, model0, model1, junction_core, railentcore;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, 0, 0, 0.4f, 8, 32, 1, 1, ModelRendererTurbo.MR_TOP);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(245, 234, 128));
		model1 = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addSphere(0, 0, 0, 0.5f, 8, 8, 32, 32).setTextured(false).setColor(new RGB(123, 245, 126));
		junction_core = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addCylinder(0, -.5f, 0, 0.9f, 1, 8, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(35, 35, 35));
		railentcore = new ModelRendererTurbo(null, 0, 0, 32, 32)
			.addHollowCylinder(0, -4, 0, 8, 4, 8, 8, 0, 1, 1, ModelRendererTurbo.MR_TOP).setColor(new RGB(128, 128, 128));
	}
	
	private static RailData raildata;
    
    @SubscribeEvent
    public void renderRails(RenderWorldLastEvent event){
	    raildata = (RailData)Minecraft.getMinecraft().world.getCapability(Capabilities.RAILSYSTEM, null);
        //if(raildata.isLoading()) return;
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        ModelBase.bindTexture(Resources.NULL_TEXTURE);
        for(RailRegion reg : raildata.getRegions().values()){
        	//if(reg.READING) continue;
        	Junction[] junctions = reg.getJunctions().values().toArray(new Junction[0]);
        	for(int i = 0; i < junctions.length; i++){
            	GL11.glPushMatrix();
                GlStateManager.disableTexture2D();
            	GL11.glTranslatef(junctions[i].getVec3f().xCoord, junctions[i].getVec3f().yCoord, junctions[i].getVec3f().zCoord);
            	if(junctions[i].tracks.isEmpty()){ RGB.RED.glColorApply(); model.render(); RGB.glColorReset(); }
            	else junction_core.render();
                GlStateManager.enableTexture2D();
            	GL11.glPopMatrix();
        		renderLines(junctions[i]);
        	}
        	/*RailEntity[] entities = reg.getEntities().values().toArray(new RailEntity[0]);
        	for(int i = 0; i < entities.length; i++){
            	GL11.glPushMatrix();
            	GL11.glTranslatef(entities[i].pos.xCoord, entities[i].pos.yCoord, entities[i].pos.zCoord);
            	//
	            GL11.glPushMatrix();
            	Minecraft.getMinecraft().entityRenderer.enableLightmap();
            	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            	GL11.glEnable(GL11.GL_LIGHTING);
            	GL11.glDisable(GL11.GL_BLEND);
            	RenderHelper.enableStandardItemLighting();
    	        int br = getBrightness(entities[i].pos.xCoord, entities[i].pos.yCoord, entities[i].pos.zCoord), j = br % 65536, k = br / 65536;
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
        if(Command.DEBUG){
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
                    bufferbuilder.pos(vec0.xCoord, vec0.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec0.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.xCoord, vec1.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec1.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
                //
                float[] vec = conn.getPosition(conn.length * (Time.getSecond() / 60f));
                if(vec.length == 1){ /*Print.debug(vec[0], conn.length);*/ continue; }
                GL11.glPushMatrix();
                GL11.glTranslatef(vec[0], vec[1] + (conn.isOppositeCopy() ? 0.1f : 0), vec[2]);
                (conn.isOppositeCopy() ? model1 : model0).render();
                GL11.glPopMatrix();
    		}
        }
        else{
        	for(int i = 0; i < value.size(); i++){
        		if(i > 2) GL11.glTranslatef(0, 0.01f, 0);
        		if(value.tracks.get(i).isOppositeCopy()) continue;
        		Track track = value.tracks.get(i); RailGaugeModel model = track.gauge.getModel();
        		if(track.railmodel == null){
        			ModelRendererTurbo turbo = new ModelRendererTurbo(track, 0, 0, 16, 16).setColor(MIDDLE_GRAY);
        			float angle; Vec3f last, vec; ArrayList<Vec3f> path = new ArrayList<>();
        			TexturedVertex vert0, vert1, vert2, vert3; TexturedPolygon poly0;
        			//
        			for(int p = 0; p < model.rails.length; p++){
        				path.clear(); vec = track.getVectorPosition0(0.001f, false);
        				angle = (float)Math.atan2(track.vecpath[0].zCoord - vec.zCoord, track.vecpath[0].xCoord - vec.xCoord);
        				angle += Static.rad90;
        				path.add(track.vecpath[0].add(grv(angle, model.rails[p][0])));
        				path.add(track.vecpath[0].add(grv(angle, model.rails[p][1])));
            			for(int v = 0; v < track.vecpath.length - 1; v++){
            				last = track.vecpath[v]; vec = track.vecpath[v + 1];
            				angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
            				angle += Static.rad90;
            				path.add(vec.add(grv(angle, model.rails[p][0])));
            				path.add(vec.add(grv(angle, model.rails[p][1])));
            			}
            			for(int k = 0; k < track.vecpath.length - 1; k++){
            				vert0 = new TexturedVertex(path.get(k * 2), 0, 0);
            				vert1 = new TexturedVertex(path.get(k * 2 + 1), 0, 0);
            				vert2 = new TexturedVertex(path.get((k + 1) * 2), 0, 0);
            				vert3 = new TexturedVertex(path.get((k + 1) * 2 + 1), 0, 0);
            				poly0 = new TexturedPolygon(new TexturedVertex[]{ vert1, vert0, vert2, vert3 });
            				turbo.copyTo(poly0.getVertices(), new TexturedPolygon[]{ poly0 });
            			}
        			}
        			track.railmodel = turbo;
        			turbo = new ModelRendererTurbo(track, 0, 0, 0, 0);
        			if(track.length >  model.ties_distance){
        				float half = model.ties_distance * .5f, accu = half;
        				while(accu < track.length){
        					last = track.getVectorPosition0(accu - 0.1f, false); vec = track.getVectorPosition0(accu + 0.1f, false);
            				angle = (float)Math.atan2(last.zCoord - vec.zCoord, last.xCoord - vec.xCoord);
            				vec = track.getVectorPosition0(accu, false);;
        					for(ModelRendererTurbo mrt : model.get("ties", false)){
        						for(TexturedPolygon poly : mrt.getFaces()){
            						TexturedVertex[] verts = new TexturedVertex[poly.getVertices().length];
            						for(int m = 0; m < verts.length; m++){
            							TexturedVertex org = poly.getVertices()[m];
            							verts[m] = new TexturedVertex(grv(angle, org.vector), org.textureX, org.textureY);
            							verts[m].vector = verts[m].vector.scale(Static.sixteenth).add(vec);
            						}
            						turbo.copyTo(verts, new TexturedPolygon[]{ new TexturedPolygon(verts) });
        						}
        					} accu += model.ties_distance;
        				}
        			}
        			track.restmodel = turbo;
        		}
        		GlStateManager.disableTexture2D(); track.railmodel.render(1f); GlStateManager.enableTexture2D();
        		ModelBase.bindTexture(track.gauge.getTexture()); track.restmodel.render(1f);
        	}
        }
	}
	
	private static final Vec3f grv(float rad, Vec3f vec){
        double co = Math.cos(rad), si = Math.sin(rad); return new Vec3f(co * vec.xCoord - si * vec.zCoord, vec.yCoord, si * vec.xCoord + co * vec.zCoord);
	}

	public static int getBrightness(Vec3f vec){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(vec.xCoord), 0, MathHelper.floor(vec.zCoord));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(vec.yCoord)); return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        } else { return 0; }
	}

	public static int getBrightness(double x, double y, double z){
        BlockPos.MutableBlockPos mutblk = new BlockPos.MutableBlockPos(MathHelper.floor(x), 0, MathHelper.floor(z));
        if(Minecraft.getMinecraft().world.isBlockLoaded(mutblk)){
            mutblk.setY(MathHelper.floor(y)); return Minecraft.getMinecraft().world.getCombinedLight(mutblk, 0);
        } else { return 0; }
	}

}
