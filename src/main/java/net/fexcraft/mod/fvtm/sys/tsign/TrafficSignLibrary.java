package net.fexcraft.mod.fvtm.sys.tsign;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.TrafficSignModel;
import net.fexcraft.mod.fvtm.sys.uni.DetachedSystem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TrafficSignLibrary extends DetachedSystem {

	public static HashMap<String, Object> PRESETS = new LinkedHashMap<>();
	public static HashMap<String, String> BACKGROUNDS = new LinkedHashMap<>();
	public static HashMap<String, String> COMPONENTS = new LinkedHashMap<>();
	public static HashMap<String, String> FONTS = new LinkedHashMap<>();
	public static HashMap<String, Library> LIBRARIES = new LinkedHashMap<>();
	
	public static final HashMap<String, TrafficSignModel> MODELS = new HashMap<>();
	private static boolean initload = false;
	private static Side side;
	public static File CACHE;

	public static void initialize(Side side, File config_folder){
		CACHE = new File(config_folder, "/fvtm/cache/traffic_signs/");
		if(!CACHE.exists()) CACHE.mkdirs();
		TrafficSignLibrary.side = side;
		load(false);
	}

	public static void load(boolean reload){
		if(!initload && reload) return;
		new Thread("TrafficSign-Loader"){
			@Override
			public void run(){
				Print.log("Starting TrafficSign Loader Thread");
				LIBRARIES.values().removeIf(lib -> lib.external);
				for(String str : Config.DEFAULT_TRAFFIC_SIGN_LIBRARIES){
					String[] split = str.split(";");
					if(split.length < 2) continue;
					LIBRARIES.put(split[0], new Library(split[0], split[1], true));
				}
				PRESETS.clear();
				BACKGROUNDS.clear();
				COMPONENTS.clear();
				FONTS.clear();
				for(Library lib : LIBRARIES.values()) lib.load();
				if(reload && side.isClient()){
					loadModels();
				}
				Print.log("Stopping TrafficSign Loader Thread");
			}
		}.start();
	}
	
	@SideOnly(Side.CLIENT)
	public static void loadModels(){
		for(Entry<String, String> entry : BACKGROUNDS.entrySet()){
			TrafficSignModel model = (TrafficSignModel) FvtmResources.getModel(entry.getValue(), new ModelData(), TrafficSignModel.class);
			if(model != null && model != TrafficSignModel.EMPTY) MODELS.put(entry.getValue(), model);
		}
		for(Entry<String, String> entry : COMPONENTS.entrySet()){
			TrafficSignModel model = (TrafficSignModel)FvtmResources.getModel(entry.getValue(), new ModelData(), TrafficSignModel.class);
			if(model != null && model != TrafficSignModel.EMPTY) MODELS.put(entry.getValue(), model);
		}
		for(Entry<String, String> entry : FONTS.entrySet()){
			TrafficSignModel model = (TrafficSignModel)FvtmResources.getModel(entry.getValue(), new ModelData(), TrafficSignModel.class);
			if(model != null && model != TrafficSignModel.EMPTY) MODELS.put(entry.getValue(), model);
		}
		initload = true;
	}

	public static class Library {
		
		public HashMap<String, JsonMap> presets = new LinkedHashMap<>();
		public HashMap<String, String> backgrounds = new LinkedHashMap<>();
		public HashMap<String, String> components = new LinkedHashMap<>();
		public HashMap<String, String> fonts = new LinkedHashMap<>();
		
		public final String id, adress;
		public final boolean external;

		public Library(String id, String adress, boolean external){
			this.id = id;
			this.adress = adress;
			this.external = external;
		}

		public void load(){
			//
		}
		
	}
	
	public static class AddonLib extends Library {

		public AddonLib(String id){
			super(id, null, false);
		}
		
		@Override
		public void load(){
			for(Entry<String, JsonMap> entry : presets.entrySet()) PRESETS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, String> entry : backgrounds.entrySet()) BACKGROUNDS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, String> entry : components.entrySet()) COMPONENTS.put(id + ":" + entry.getKey(), entry.getValue());
			for(Entry<String, String> entry : fonts.entrySet()) FONTS.put(id + ":" + entry.getKey(), entry.getValue());
		}
		
	}
	
	// Detached-System Implementation //
	
	public static ConcurrentLinkedQueue<Chunk> CHUNKS = new ConcurrentLinkedQueue<>();
	
	public TrafficSignLibrary(World world){
		super(world);
	}

	@Override
	public boolean hasTimer(){
		return false;
	}

	@Override
	public void unload(){
		CHUNKS.clear();
	}

	@Override
	public void onChunkLoad(Chunk chunk){
		CHUNKS.add(chunk);
		if(side.isClient()){
			NBTTagCompound compound = new NBTTagCompound();
			compound.setString("target_listener", "fvtm:utils");
			compound.setString("task", "ts_ck_sync");
			compound.setInteger("x", chunk.x);
			compound.setInteger("z", chunk.z);
			PacketHandler.getInstance().sendToServer(new PacketNBTTagCompound(compound));
		}
	}

	@Override
	public void onChunkUnload(Chunk chunk){
		CHUNKS.remove(chunk);
	}

	@Override
	public void onServerTick(World world){
		//
	}

	@Override
	public void onClientTick(World world){
		//
	}

}
