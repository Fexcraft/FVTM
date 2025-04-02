package net.fexcraft.mod.fvtm.event;

import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.TextureSupply;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entity.DecorationEntity;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerSerializer;
import net.fexcraft.mod.fvtm.util.caps.*;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.UniChunk;
import net.fexcraft.mod.uni.UniEntity;
import net.fexcraft.mod.uni.world.WrapperHolder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.translation.LanguageMap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.*;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class EventHandler {
	
	@SubscribeEvent
	public void onAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event){
		if(event.getObject().getItem() instanceof VehicleItem || event.getObject().getItem() instanceof PartItem
			|| event.getObject().getItem() instanceof ContainerItem || event.getObject().getItem() instanceof BlockItem){
			event.addCapability(new ResourceLocation("fvtm:vapdatacache"), new VAPDataCache(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		SystemManager.onAttachWorldCapabilities(WrapperHolder.getWorld(event.getObject()));
		event.addCapability(new ResourceLocation("fvtm:multiblocks"), new MultiBlockCacheSerializer(event.getObject()));
	}
	
	@SubscribeEvent
	public void onAttachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event){
		//
	}
	
	@SubscribeEvent
	public void onAttachEntityCapabilities(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject().world == null) return;
		if(event.getObject() instanceof ContainerHolderWrapper){
			event.addCapability(new ResourceLocation("fvtm:container"), new ContainerHolderUtil(event.getObject()));
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof VehicleEntity){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof RootVehicle){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
		if(event.getObject() instanceof EntityPlayer){
			if(event.getObject().world.isRemote){
				event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
			}
		}
		if(event.getObject() instanceof EntityLivingBase){
			event.addCapability(new ResourceLocation("fvtm:passenger"), new PassengerSerializer(event.getObject()));
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof DecorationEntity){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onAttachTileEntityCapabilities(AttachCapabilitiesEvent<TileEntity> event){
		if(Static.side().isClient() && (event.getObject() instanceof DisplayEntity ||
			event.getObject() instanceof BlockTileEntity || event.getObject() instanceof ContainerEntity)){
			event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
		}
	}
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event){
		if(event.phase != Phase.START) return;
		SystemManager.onServerTick();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
		if(event.phase != Phase.START) return;
		SystemManager.onClientTick();
	}
	
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event){
		SystemManager.onChunkLoad(WrapperHolder.getWorld(event.getWorld()), UniChunk.getChunk(event.getChunk()));
		event.getChunk().getTileEntityMap().values().forEach(tile -> {
			if(tile instanceof MultiblockTileEntity){
				((MultiblockTileEntity)tile).setup();
			}
		});
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event){
		SystemManager.onChunkUnload(WrapperHolder.getWorld(event.getWorld()), UniChunk.getChunk(event.getChunk()));
	}
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldLoad(WrapperHolder.getWorld(event.getWorld()));
	}
	
	@SubscribeEvent
	public void onWorldUnload(WorldEvent.Unload event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldUnload(WrapperHolder.getWorld(event.getWorld()));
		WrapperHolder.INSTANCE.reset();
	}

	@SubscribeEvent
	public void regSounds(RegistryEvent.Register<SoundEvent> event){
		FvtmRegistry.VEHICLES.forEach(vehicle -> {
			vehicle.getSounds().values().forEach(sound -> {
				if(event.getRegistry().containsKey(sound.soundid.local())){
					sound.event = event.getRegistry().getValue(sound.soundid.local());
				}
				else{
					SoundEvent soundevent = new SoundEvent(sound.soundid.local()).setRegistryName(sound.soundid.colon());
					event.getRegistry().register((SoundEvent)(sound.event = soundevent));
				}
			});
		});
		FvtmRegistry.PARTS.forEach(part -> {
			part.getSounds().values().forEach(sound -> {
				if(event.getRegistry().containsKey(sound.soundid.local())){
					sound.event = event.getRegistry().getValue(sound.soundid.local());
				}
				else{
					SoundEvent soundevent = new SoundEvent(sound.soundid.local()).setRegistryName(sound.soundid.colon());
					event.getRegistry().register((SoundEvent)(sound.event = soundevent));
				}
			});
		});
	}
	
	@SubscribeEvent
	public void onPlayerIn(PlayerEvent.PlayerLoggedInEvent event){
		if(event.player.world.isRemote){
			RailPlacingUtil.CL_CURRENT = null;
			RoadPlacingUtil.CL_CURRENT = null;
		}
		if(event.player.world != null && !event.player.world.isRemote){
			NBTTagCompound cfgsync = new NBTTagCompound();
			cfgsync.setInteger("u12_sync_rate", VEHICLE_SYNC_RATE);
			cfgsync.setString("task", "config_sync");
			cfgsync.setString("target_listener", UTIL_LISTENER);
			PacketHandler.getInstance().sendTo(new PacketNBTTagCompound(cfgsync), (EntityPlayerMP)event.player);
		}
		if(!event.player.world.isRemote) RoadPlacingCache.onLogIn(event.player.getGameProfile().getId());
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = true;
		SystemManager.syncPlayer(WrapperHolder.getWorld(event.player.world).dimkey(), UniEntity.getEntity(event.player));
	}

	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerChangedDimensionEvent event){
		SystemManager.syncPlayer(WrapperHolder.getWorld(event.player.world).dimkey(), UniEntity.getEntity(event.player));
	}
	
	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent event){
		if(!event.player.world.isRemote){
			RailPlacingUtil.CURRENT.remove(event.player.getGameProfile().getId());
			RoadPlacingCache.onLogOut(event.player.getGameProfile().getId());
		}
		if(Config.DISMOUNT_ON_LOGOUT && event.player.getRidingEntity() instanceof RootVehicle){
			event.player.dismountRidingEntity();
		}
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = false;
	}
	
	@SubscribeEvent
	public void onEntityAttack(LivingAttackEvent event){
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof RootVehicle){// && !event.getSource().isProjectile()){
			event.setCanceled(true);
		}
	}

	public static void linkTextureSuppliers(){
		for(Addon addon : ADDONS){
			if(addon.getTextureSuppliers().isEmpty()) continue;
			for(TextureSupply texsupp : addon.getTextureSuppliers().values()){
				for(String tar : texsupp.targets()){
					String[] split = tar.split(";");
					Textureable.TextureHolder holder = null;
					switch(split[0]){
						case "vehicle":{
							holder = FvtmRegistry.VEHICLES.get(split[1]);
							break;
						}
						case "part":{
							holder = FvtmRegistry.PARTS.get(split[1]);
							break;
						}
						case "container":{
							holder = CONTAINERS.get(split[1]);
							break;
						}
					}
					if(holder == null) continue;
					for(IDL tex : texsupp.textures()){
						holder.getDefaultTextures().add(tex.local());
					}
				}
			}
		}
	}

	private static Field flightdata;
	private static boolean flightdata_failed = false;
	/** do not remember on what this is based **/
	public static void resetFlight(EntityPlayerMP passenger){
		if(flightdata == null && !flightdata_failed){
			try{
				flightdata = ObfuscationReflectionHelper.findField(NetHandlerPlayServer.class, "field_147365_f");
			}
			catch(Exception e){
				Print.log("Failed to get field. [FLIGHTDATA:ERR:0]");
			}
		}
		if(flightdata != null && !flightdata_failed){
			try{
				flightdata.setInt(passenger.connection, 0);
			}
			catch(IllegalArgumentException | IllegalAccessException e){
				if(Static.dev()){
					e.printStackTrace();
				}
				flightdata_failed = true;
			}
		}
		/*passenger.lastTickPosX = passenger.prevPosX;
		passenger.lastTickPosY = passenger.prevPosY;
		passenger.lastTickPosZ = passenger.prevPosZ;*/
	}
	
	private static Field i18n_locale;
	private static Method locale_load_is, locale_check_uni;

	@SideOnly(Side.CLIENT)
	public static void loadLitePackLang() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, FileNotFoundException {
		ArrayList<Addon> lites = new ArrayList<>();
		for(Addon addon : ADDONS){
			if(addon.getLocation() == AddonLocation.CONFIGPACK) lites.add(addon);
		}
		if(lites.size() == 0) return;
		i18n_locale = ObfuscationReflectionHelper.findField(net.minecraft.client.resources.I18n.class, "field_135054_a");
		i18n_locale.setAccessible(true);
		locale_load_is = ObfuscationReflectionHelper.findMethod(net.minecraft.client.resources.Locale.class, "func_135021_a", Void.TYPE, InputStream.class);
		locale_load_is.setAccessible(true);
		locale_check_uni = ObfuscationReflectionHelper.findMethod(net.minecraft.client.resources.Locale.class, "func_135024_b", Void.TYPE);
		locale_check_uni.setAccessible(true);
		String code = net.minecraft.client.Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().toLowerCase();
		boolean nonus = !code.equals("en_us");
		//
		for(Addon addon : lites){
			if(addon.getFile().isDirectory()){
				if(!addon.getFile().isDirectory()) return;
				//
				File folder = new File(addon.getFile(), "assets/" + addon.getID().id() + "/lang/");
				if(!folder.exists()) folder.mkdirs();
				for(File file : folder.listFiles()){
					if(file.getName().toLowerCase().equals("en_us.lang")){
						locale_load_is.invoke(i18n_locale.get(null), new FileInputStream(file));
						LanguageMap.inject(new FileInputStream(file));
					}
					else if(nonus && file.getName().toLowerCase().equals(code + ".lang")){
						locale_load_is.invoke(i18n_locale.get(null), new FileInputStream(file));
						LanguageMap.inject(new FileInputStream(file));
					}
				}
			}
			else{
				String path = "assets/" + addon.getID().id() + "/lang/", extension = ".lang";
				try{
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream stream = new ZipInputStream(new FileInputStream(addon.getFile()));
					while(true){
						ZipEntry entry = stream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(path + "en_us" + extension)){
							locale_load_is.invoke(i18n_locale.get(null), zip.getInputStream(entry));
							LanguageMap.inject(zip.getInputStream(entry));
						}
						if(nonus && entry.getName().equals(path + code + extension)){
							locale_load_is.invoke(i18n_locale.get(null), zip.getInputStream(entry));
							LanguageMap.inject(zip.getInputStream(entry));
						}
					}
					zip.close();
					stream.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		locale_check_uni.invoke(i18n_locale.get(null));
	}

	public static Object[] getInputStream(ResourceLocation resloc){
		Closeable[] close = null;
		InputStream stream = FvtmResources.INSTANCE.getAssetInputStream(IDLManager.getIDL(resloc.toString()), false);
		if(stream != null) return new Object[]{ stream };
		try{
			Addon addon = getAddon(resloc.getNamespace());
			if(addon != null){
				if(addon.getFile().isDirectory()){
					File file = new File(addon.getFile(), "assets/" + resloc.getNamespace() + "/" + resloc.getPath());
					if(file.exists()) stream = new FileInputStream(file);
				}
				else{
					String filename = "assets/" + resloc.getNamespace() + "/" + resloc.getPath();
					ZipFile zip = new ZipFile(addon.getFile());
					ZipInputStream zipstream = new ZipInputStream(new FileInputStream(addon.getFile()));
					close = new Closeable[]{ zip, zipstream };
					while(true){
						ZipEntry entry = zipstream.getNextEntry();
						if(entry == null) break;
						if(entry.getName().equals(filename)){
							stream = zip.getInputStream(entry);
							break;
						}
					}
				}
			}
		}
		catch(Throwable e){
			//e.printStackTrace();
		}
		return close == null ? new Object[]{ stream } : new Object[]{ stream, close };
	}

}
