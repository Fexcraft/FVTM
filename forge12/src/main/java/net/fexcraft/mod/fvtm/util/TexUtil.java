package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.FvtmRegistry.getAddon;

import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class TexUtil {
	
	public static final HashMap<ResourceLocation, Object> litex = new HashMap<>(); 
	public static final Minecraft mc = Minecraft.getMinecraft();
	//private static int curr;

	public static void bindTexture(IDL idl){
		bindTexture((ResourceLocation)idl);
	}
	
	public static void bindTexture(ResourceLocation loc){
		//curr = GL11.glGetInteger(GL11.GL_TEXTURE_2D);
		ITextureObject obj = mc.getTextureManager().getTexture(loc);
		if(obj == null){
			Object res = litex.get(loc);
			boolean success = false;
			if(res != null){
				obj = new SimplerTexture(loc);
				success = mc.getTextureManager().loadTexture(loc, obj);
			}
			if(!success){
	            obj = new SimpleTexture(loc);
	            mc.getTextureManager().loadTexture(loc, obj);
			}
		}
		//if(curr == obj.getGlTextureId()) return;
		GlStateManager.bindTexture(obj.getGlTextureId());
	}

	public static void searchIn(Addon addon, File texfolder, String sub){
		if(!texfolder.exists()) return;
		sub = sub == null ? "textures/" : sub;
		for(File file : texfolder.listFiles()){
			if(file.isDirectory()){
				searchIn(addon, file, sub + file.getName() + "/");
			}
			else if(file.getName().endsWith(".png")){
				litex.put(new ResourceLocation(addon.getID().id(), sub + file.getName()), file);
			}
		}
	}

	public static void searchInZip(Addon addon){
		String path = "assets/" + addon.getID().id() + "/textures/", suffix = ".png";
		try{
			ZipInputStream stream = new ZipInputStream(new FileInputStream(addon.getFile()));
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null) break;
				if(entry.getName().startsWith(path) && entry.getName().endsWith(suffix)){
					String name = entry.getName();
					litex.put(new ResourceLocation(addon.getID().id(), name.substring(name.indexOf("textures/"))), name);
				}
			}
			stream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static class SimplerTexture extends AbstractTexture {

	    private final ResourceLocation resloc;

	    public SimplerTexture(ResourceLocation textureResourceLocation){
	        this.resloc = textureResourceLocation;
	    }

	    public void loadTexture(IResourceManager resman){
	        this.deleteGlTexture();
	        IResource iresource = null;
	        Object obj = litex.get(resloc);
	        try{
	            Object[] is = obj instanceof File ? new Object[]{ new FileInputStream((File)obj)} : getZipIS(resloc.getNamespace(), (String)obj);
	            BufferedImage bufferedimage = TextureUtil.readBufferedImage((InputStream)is[0]);
	            if(is.length > 1) ((Closeable)is[1]).close();
	            TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), bufferedimage, false, false);
	            IOUtils.closeQuietly((Closeable)iresource);
	        }
	        catch(IOException e){
	        	e.printStackTrace();
	        }
	    }
	    
	}

	public static Object[] getZipIS(String addonid, String path){
		try{
			Addon addon = getAddon(addonid);
			ZipFile zip = new ZipFile(addon.getFile());
			ZipInputStream stream = new ZipInputStream(new FileInputStream(addon.getFile()));
			InputStream is = null;
			while(true){
				ZipEntry entry = stream.getNextEntry();
				if(entry == null) break;
				if(entry.getName().equals(path)){
					is = zip.getInputStream(entry);
					break;
				}
			}
			stream.close();
			if(is != null){
				return new Object[]{ is, zip };
			}
			else zip.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isMissing(ResourceLocation resloc){
		if(TexUtil.litex.containsKey(resloc)) return false;
		try{
			IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resloc);
			return res == null;
		}
		catch(IOException e){
			//e.printStackTrace();
			return true;
		}
	}

}
