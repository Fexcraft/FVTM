package net.fexcraft.mod.fvtm.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExternalTextureLoader {
	
	private static final Map<String, IDL> map = new HashMap<>();
	public static final String PREFIX = "fvtm:external/";
	
	public static IDL get(String s){
		if(map.containsKey(s)) return map.get(s);
		IDL texture = IDLManager.getIDLNamed(PREFIX + ":" + s);
		ITextureObject object = Minecraft.getMinecraft().renderEngine.getTexture(texture.local());
        if(object == null){
        	SimplerThreadImageDownloader thid = new SimplerThreadImageDownloader(s, texture.local());
        	Minecraft.getMinecraft().renderEngine.loadTexture(texture.local(), (object = thid));
        }
        map.put(s, texture);
        return texture;
	}
	
	@SideOnly(Side.CLIENT)
	public static class SimplerThreadImageDownloader extends SimpleTexture {
		
	    private static final AtomicInteger THRID = new AtomicInteger(0);
	    private final String url;
	    private BufferedImage image;
	    private Thread thread;
	    private boolean uploaded;

	    public SimplerThreadImageDownloader(String imgurl, ResourceLocation resloc) {
	        super(resloc);
	        url = imgurl;
	    }

	    private void checkIfUploaded(){
	    	if(uploaded || image == null) return;
            if(textureLocation != null) deleteGlTexture();
            TextureUtil.uploadTextureImage(super.getGlTextureId(), image);
            uploaded = true;
	    }

	    @Override
	    public int getGlTextureId(){
	        checkIfUploaded();
	        return super.getGlTextureId();
	    }

	    @Override
	    public void loadTexture(IResourceManager resman) throws IOException {
	        if(thread != null) return;
			thread = new Thread(() -> {
				HttpURLConnection conn = null;
				Print.log("Trying to download texture '" + url + "'.");
				try{
					conn = (HttpURLConnection)new URL(url).openConnection(Minecraft.getMinecraft().getProxy());
					conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
					conn.setDoInput(true);
					conn.setDoOutput(false);
					conn.connect();
					if(conn.getResponseCode() == 200){
						image = TextureUtil.readBufferedImage(conn.getInputStream());
						return;
					}
					else{
						Print.log("Received response code '" + conn.getResponseCode() + "'.");
					}
				}
				catch(Exception e) {
					Print.log("Errors during texture download");
					e.printStackTrace();
					return;
				}
				finally{
					if(conn != null) conn.disconnect();
				}
			});
			thread.setName("FVTM External Texture # " + textureLocation.toString());
			thread.setDaemon(true);
			thread.start();
	    }
	    
	}
	
}