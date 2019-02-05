package net.fexcraft.mod.fvtm.render;

import net.fexcraft.mod.fvtm.api.Block.BlockData;
import net.fexcraft.mod.fvtm.api.Block.BlockItem;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.lib.common.math.Time;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Pos;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelBase;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.blocks.UniversalTileEntity;
import net.fexcraft.mod.fvtm.model.RailGaugeModel;
import net.fexcraft.mod.fvtm.model.block.BlockModel;
import net.fexcraft.mod.fvtm.prototype.WorldRailData;
import net.fexcraft.mod.fvtm.prototype.WorldRailDataSerializer;
import net.fexcraft.mod.fvtm.sys.rail.Junction;
import net.fexcraft.mod.fvtm.sys.rail.RailRegion;
import net.fexcraft.mod.fvtm.sys.rail.Track;
import net.fexcraft.mod.fvtm.util.Command;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.minecraft.client.Minecraft;

import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Renderer {

    public static void drawString(String str, double x, double y, double z, float viewerYaw, float viewerPitch, float viewerRoll, boolean glow, float scale, int color){
        //FontRenderer fontRenderer = Minecraft.getMinecraft().getRenderManager().getFontRenderer();
        GlStateManager.pushMatrix();
        GlStateManager.translate(x, y, z);
        //GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-viewerYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(viewerPitch, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(viewerRoll, 0.0F, 0.0F, 1.0F);
        GlStateManager.scale(-0.025F, -0.025F, 0.025F);
        if(scale != 1f){ GL11.glScalef(scale, scale, scale); }
        if(glow){
            GlStateManager.disableLighting();
        }
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(true);
        SIGN_FONT_RENDERER.drawString(str, -SIGN_FONT_RENDERER.getStringWidth(str) / 2, 0, color);
        if(glow){
            GlStateManager.enableLighting();
        }
        GlStateManager.disableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();
    }

    /**
     * got this from <b>ebf</b>
     */
    public static void drawTextOutlined(FontRenderer font, String string, int x, int y, int color){
    	font.drawString(string, x - 1, y + 1, 0);
    	font.drawString(string, x    , y + 1, 0);
    	font.drawString(string, x + 1, y + 1, 0);
    	font.drawString(string, x - 1, y    , 0);
    	font.drawString(string, x + 1, y    , 0);
    	font.drawString(string, x - 1, y - 1, 0);
    	font.drawString(string, x    , y - 1, 0);
    	font.drawString(string, x + 1, y - 1, 0);
    	font.drawString(string, x    , y    , color);
    }
    
    public static FontRenderer SIGN_FONT_RENDERER;
    
    public static void initFontRenderer(){
    	Minecraft mc = Minecraft.getMinecraft();
    	SIGN_FONT_RENDERER = new FontRenderer2(mc.gameSettings, new ResourceLocation("fvtm", "textures/font/sign_ascii.png"), mc.getTextureManager());
    }
    
    private static class FontRenderer2 extends FontRenderer {

		public FontRenderer2(GameSettings settings, ResourceLocation location, TextureManager tm){
			super(settings, location, tm, false);
			this.readFontTexture();
		}
		
		@Override
	    protected float renderUnicodeChar(char ch, boolean italic){
	        if(ch < 256){
	        	return this.renderDefaultChar(ch, italic);
	        }
	        else{
	        	return super.renderUnicodeChar(ch, italic);
	        }
	    }
		
		private void readFontTexture(){
	        IResource iresource = null;
	        BufferedImage bufferedimage;
	        try{
	            iresource = getResource(this.locationFontTexture);
	            bufferedimage = TextureUtil.readBufferedImage(iresource.getInputStream());
	        }
	        catch(IOException ioexception){ throw new RuntimeException(ioexception); }
	        finally{ IOUtils.closeQuietly((Closeable)iresource); }
	        int i = bufferedimage.getWidth(), j = bufferedimage.getHeight();
	        int[] ai = new int[i * j];
	        bufferedimage.getRGB(0, 0, i, j, ai, 0, i);
	        int k = j / 16, l = i / 16;
	        float f = 8.0F / (float)l;
	        for(int m = 0; m < 256; ++m){
	            int j1 = m % 16;
	            int k1 = m / 16;
	            if(m == 32){ this.charWidth[m] = 4; }
	            int l1;
	            for(l1 = l - 1; l1 >= 0; --l1){
	                int i2 = j1 * l + l1;
	                boolean flag1 = true;
	                for(int j2 = 0; j2 < k && flag1; ++j2){
	                    int k2 = (k1 * l + j2) * i;
	                    if((ai[i2 + k2] >> 24 & 255) != 0){
	                        flag1 = false;
	                    }
	                }
	                if(!flag1){
	                    break;
	                }
	            }
	            ++l1;
	            this.charWidth[m] = (int)(0.5D + (double)((float)l1 * f)) + 1;
	        }
	    }
    	
    }
    
    private static ItemStack stack;
    
    @SubscribeEvent
    public void preview(DrawBlockHighlightEvent event){
    	stack = event.getPlayer().getHeldItemMainhand();
    	if(stack.isEmpty()) return;
    	else if(event.getTarget() == null || event.getTarget().typeOfHit != RayTraceResult.Type.BLOCK) return;
    	else if(stack.getItem() instanceof VehicleItem && Config.RENDER_VEHICLE_PREVIEW){
            VehicleData data = ((VehicleItem)stack.getItem()).getVehicle(stack);
            if(data == null || !data.readyToSpawn()) return;
        	render(event.getPlayer(), data, event.getTarget().getBlockPos());
    	}
    	else if(stack.getItem() instanceof ContainerItem){
    		ContainerData data = ((ContainerItem)stack.getItem()).getContainer(stack);
    		if(data == null || data.isLocked()) return;
    		render(event.getPlayer(), data, event.getTarget().getBlockPos());
    	}
    	else if(stack.getItem() instanceof BlockItem && Config.RENDER_BLOCK_PREVIEW){
    		BlockData data = ((BlockItem)stack.getItem()).getBlock(stack);
    		if(data == null || data.isLocked()) return;
    		//if(bteq(data, event.getTarget().sideHit, event.getTarget().getBlockPos(), event.getPlayer().world)) return;
    		render(event.getPlayer(), data, event.getTarget().getBlockPos());
    	}
    }
    
	protected static final ModelRendererTurbo model, model0;
	static{
		model = new ModelRendererTurbo(null, 0, 0, 32, 32);
		model.addCylinder(0, 0, 0, 2, 16, 32, 1, 1, ModelRendererTurbo.MR_TOP);
		model.setRotationPoint(0, -8, 0);
		model0 = new ModelRendererTurbo(null, 0, 0, 32, 32);
		model0.addCylinder(-12, 0, 0, 4, 16, 6, 1.2f, 1, ModelRendererTurbo.MR_TOP);
		model0.setRotationPoint(0, 0, 0);
	}
	
	private static WorldRailData raildata;
    
    @SuppressWarnings("unchecked") @SubscribeEvent
    public void renderRails(RenderWorldLastEvent event){
	    raildata = Static.getServer().getEntityWorld().getCapability(WorldRailDataSerializer.CAPABILITY, null);
        Entity camera = Minecraft.getMinecraft().getRenderViewEntity();
        double x = camera.lastTickPosX + (camera.posX - camera.lastTickPosX) * event.getPartialTicks();
        double y = camera.lastTickPosY + (camera.posY - camera.lastTickPosY) * event.getPartialTicks();
        double z = camera.lastTickPosZ + (camera.posZ - camera.lastTickPosZ) * event.getPartialTicks();
        //
        GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslated(-x, -y, -z);
        ModelBase.bindTexture(Resources.NULL_TEXTURE);
        for(RailRegion reg : raildata.getLoadedRegions()){
        	if(reg.READING) continue;
        	for(int i = 0; i < reg.getJunctions().size(); i++){
        		Entry<BlockPos, Junction> str = (Entry<BlockPos, Junction>)reg.getJunctions().entrySet().toArray()[i];
        		/*GL11.glPushMatrix();
        		GL11.glTranslatef(str.getKey().getX() + 0.5f, str.getKey().getY() + 0.5f, str.getKey().getZ() + 0.5f);
        		RGB.RED.glColorApply();
        		model.render();
        		RGB.glColorReset();
        		GL11.glPopMatrix();*/
        		renderLines(str.getValue());
        	}
        }
		GL11.glPopMatrix();
    }

	private void renderLines(Junction value){
		Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        Vec3f vec0, vec1; float flfl, glgl;
        //
        if(Command.DEBUG){
    		for(Track conn : value.tracks){
    	        flfl = conn.isOppositeCopy() ? 1 : 0;
    	        glgl = conn.isOppositeCopy() ? 0 : 1;
                GL11.glPushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth(2.0F);
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask(false);
    			for(int j = 0; j < conn.vectors.length - 1; j++){
    				vec0 = conn.vectors[j];//.subtract(pos);
    				vec1 = conn.vectors[j + 1];//.subtract(pos);
                    bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
                    bufferbuilder.pos(vec0.xCoord, vec0.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec0.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    bufferbuilder.pos(vec1.xCoord, vec1.yCoord + (conn.isOppositeCopy() ? 0.1f : 0), vec1.zCoord).color(0f, glgl, flfl, 1F).endVertex();
                    tessellator.draw();
    			}
                GlStateManager.depthMask(true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                GL11.glPopMatrix();
    		}
        }
        else{
    		for(Track conn : value.tracks){
    			if(conn.isOppositeCopy()) continue;
    			ModelBase.bindTexture(conn.getGauge().getTexture());
    			boolean b = false;
    			for(int k = 0; k < conn.vectors.length - 1; k++){
    				vec0 = conn.vectors[k];//.subtract(pos);
    				vec1 = conn.vectors[k + 1];//.subtract(pos);//TODO replace with translate
    				double dis = vec1.distanceTo(vec0);
    				/* renderpiece(vec1, vec, dis); while(dis > 0.5){ dis -= 0.5; renderpiece(vec1, vec, dis); } if(dis > 0) renderpiece(vec1, vec, dis); */
    				if(b = !b) GL11.glTranslated(0, -0.01, 0);
    				GL11.glTranslatef(0, -0.5f, 0);
    				while(dis > 0){ RailGaugeModel.renderpiece(((RailGaugeModel)conn.getGauge().getModel()).base, vec0, vec1, dis); dis -= 0.5; }
    				GL11.glTranslatef(0,  0.5f, 0);
    				if(b) GL11.glTranslated(0, 0.01, 0);
    			}
    		}
        }
	}

	@SuppressWarnings("unused")
	private static boolean bteq(BlockData data, EnumFacing facing, BlockPos pos, World world){
		if(facing == EnumFacing.DOWN) return true; if(facing != EnumFacing.UP) return false;
		TileEntity tile = world.getTileEntity(pos);
		return tile != null && tile instanceof UniversalTileEntity
			&& ((UniversalTileEntity)tile).getBlockData().getBlock().getRegistryName().equals(data.getBlock().getRegistryName());
	}

	private static void render(EntityPlayer player, BlockData data, BlockPos bpos){
        GL11.glPushMatrix();
        GlStateManager.disableBlend(); GlStateManager.enableAlpha();
        float off = player.world.getBlockState(bpos).getBlock().isReplaceable(player.world, bpos) ? 0 : 1;
        GL11.glTranslated((bpos.getX() + 0.5) - player.posX, bpos.getY() - player.posY + off, (bpos.getZ() + 0.5) - player.posZ);
        Minecraft.getMinecraft().renderEngine.bindTexture(data.getTexture());
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        switch(player.getHorizontalFacing().getIndex()){
        	case 2: GL11.glRotated(180, 0, 1D, 0); break;
        	case 3: GL11.glRotated(  0, 0, 1D, 0); break;
        	case 4: GL11.glRotated( 90, 0, 1D, 0); break;
        	case 5: GL11.glRotated(270, 0, 1D, 0); break;
        }
        BlockModel.PREVIEW = true;
        data.getBlock().getModel().render(data, null, null, player.getHorizontalFacing().getIndex());
        //
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

	private static void render(EntityPlayer player, VehicleData data, BlockPos bpos){
        GL11.glPushMatrix();
        GlStateManager.disableBlend(); GlStateManager.enableAlpha();
        GL11.glTranslated((bpos.getX() + 0.5) - player.posX, bpos.getY() - data.getWheelPos().get(0).to16FloatY() - player.posY, (bpos.getZ() + 0.5) - player.posZ);
        float yaw = (player.rotationYaw - player.prevRotationYaw); for(; yaw > 180F; yaw -= 360F); for(; yaw <= -180F; yaw += 360F);
        GL11.glRotatef(180F - player.prevRotationYaw - yaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180f, 0f, 0f, 1f); GL11.glRotatef(90f, 0f, 1f, 0f);
        GL11.glPushMatrix();
        Model<VehicleData, Object> modVehicle = data.getVehicle().getModel();
        if(modVehicle != null){
            ModelBase.bindTexture(data.getTexture());
            modVehicle.render(data, null);
            if(data.getParts().size() > 0){
                data.getParts().forEach((key, partdata) -> {
                    ModelBase.bindTexture(partdata.getTexture());
                    Pos pos = partdata.getPart().getOffsetFor(data.getVehicle().getRegistryName());
                    pos.translate();
                    partdata.getPart().getModel().render(data, key);
                    partdata.getPart().getAttributes().forEach(attr -> { if(attr.hasRenderData()){ attr.render(null, partdata, key); } });
                    pos.translateR();
                });
            }
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
	
	private double offset;

	private void render(EntityPlayer player, ContainerData data, BlockPos bpos){
		if(data.getContainer().getModel() == null) return;
        GL11.glPushMatrix();
        float off = player.world.getBlockState(bpos).getBlock().isReplaceable(player.world, bpos) ? 0 : 1;
        GL11.glTranslated((bpos.getX() + 0.5) - player.posX, bpos.getY() - player.posY + off, (bpos.getZ() + 0.5) - player.posZ);
        GlStateManager.disableBlend(); GlStateManager.enableAlpha();
        GL11.glPushMatrix(); offset = data.getContainer().getType().evenLength() ? 0.5 : 0; 
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        switch(player.getHorizontalFacing().getIndex()){
            case 2: {
                GL11.glTranslated(offset, 0, 0);
                GL11.glRotated(0, 0, 1D, 0);
                break;
            }
            case 3: {
                GL11.glTranslated(offset, 0, 0);
                GL11.glRotated(180D, 0, 1D, 0);
                break;
            }
            case 4: {
                GL11.glTranslated(0, 0, -offset);
                GL11.glRotated(-90D, 0, 1D, 0);
                break;
            }
            case 5: {
                GL11.glTranslated(0, 0, -offset);
                GL11.glRotated(-270D, 0, 1D, 0);
                break;
            }
            default: {
                GL11.glTranslated(0, -offset, 0);
                GL11.glRotated(Time.getSecond() * 6, 0, 1D, 0);
                break;
            }
        }
        GL11.glRotated(180, 0, 1D, 0);
        ModelBase.bindTexture(data.getTexture());
        data.getContainer().getModel().render(data, null);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

}
