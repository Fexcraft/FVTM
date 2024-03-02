package net.fexcraft.mod.fvtm.util;

import static net.fexcraft.mod.fvtm.Config.VEHICLE_SYNC_RATE;
import static net.fexcraft.mod.fvtm.FvtmRegistry.ADDONS;
import static net.fexcraft.mod.fvtm.FvtmRegistry.getAddon;
import static net.fexcraft.mod.fvtm.FvtmRegistry.getFuel;
import static net.fexcraft.mod.fvtm.util.PacketsImpl.UTIL_LISTENER;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import net.fexcraft.lib.mc.crafting.RecipeRegistry;
import net.fexcraft.lib.mc.network.PacketHandler;
import net.fexcraft.lib.mc.network.packet.PacketNBTTagCompound;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.Config;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.InternalAddon;
import net.fexcraft.mod.fvtm.block.ConstCenterBlock;
import net.fexcraft.mod.fvtm.block.ConstructorBlock;
import net.fexcraft.mod.fvtm.block.ContainerEntity;
import net.fexcraft.mod.fvtm.block.DisplayEntity;
import net.fexcraft.mod.fvtm.block.VPInfo;
import net.fexcraft.mod.fvtm.block.generated.BlockTileEntity;
import net.fexcraft.mod.fvtm.block.generated.MultiblockTileEntity;
import net.fexcraft.mod.fvtm.data.*;
import net.fexcraft.mod.fvtm.data.addon.Addon;
import net.fexcraft.mod.fvtm.data.addon.AddonLocation;
import net.fexcraft.mod.fvtm.data.addon.AddonSteeringOverlay;
import net.fexcraft.mod.fvtm.data.attribute.Attribute;
import net.fexcraft.mod.fvtm.data.block.MultiBlock0;
import net.fexcraft.mod.fvtm.data.block.MultiBlockData0;
import net.fexcraft.mod.fvtm.data.container.ContainerHolder.ContainerHolderWrapper;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.vehicle.VehicleEntity;
import net.fexcraft.mod.fvtm.entity.Decoration;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.item.PartItem;
import net.fexcraft.mod.fvtm.item.VehicleItem;
import net.fexcraft.mod.fvtm.sys.rail.RailPlacingUtil;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingCache;
import net.fexcraft.mod.fvtm.sys.road.RoadPlacingUtil;
import net.fexcraft.mod.fvtm.sys.tsign.TrafficSignCapHandler;
import net.fexcraft.mod.fvtm.sys.uni.GenericVehicle;
import net.fexcraft.mod.fvtm.sys.uni.RootVehicle;
import net.fexcraft.mod.fvtm.sys.uni.SystemManager;
import net.fexcraft.mod.fvtm.util.cap.pass.PassengerSerializer;
import net.fexcraft.mod.fvtm.util.caps.ContainerHolderUtil;
import net.fexcraft.mod.fvtm.util.caps.MultiBlockCacheSerializer;
import net.fexcraft.mod.fvtm.util.caps.PlayerDataHandler;
import net.fexcraft.mod.fvtm.util.caps.RenderCacheHandler;
import net.fexcraft.mod.fvtm.util.caps.VAPDataCache;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Resources {

	public static RegistryOld<MultiBlock0> MULTIBLOCKS = new RegistryOld<>();
	private static TreeMap<String, Class<? extends Attribute<?>>> ATTRIBUTE_TYPES = new TreeMap<>();
	private static TreeMap<String, Boolean> LOADED_MODS = new TreeMap<>();
	public static TreeMap<String, Class<? extends AddonSteeringOverlay>> OVERLAYS = new TreeMap<>();
	public static final NamedResourceLocation NULL_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/null.png");
	public static final NamedResourceLocation WHITE_TEXTURE = new NamedResourceLocation("No Texture;fvtm:textures/entity/white.png");
	//
	private static Field respackfile = null;
	
	public Resources(FMLPreInitializationEvent event){
		//registerAttributeTypes();
		//registerModifierImpls();
		//registerFunctions();
		//
		// search in packs for //
		//
		// init model loaders //
	}

	public static MultiBlock0 getMultiBlock(String string){
		return MULTIBLOCKS.get(string);
	}

	public static MultiBlock0 getMultiBlock(ResourceLocation resloc){
		return MULTIBLOCKS.get(resloc);
	}

	/*public static PartData getPartData(NBTTagCompound compound){
		if(!compound.hasKey("Part")) return null;
		Part part = getPart(compound.getString("Part")); if(part == null) return null;
		try{ return ((PartData)part.getDataClass().getConstructor(Part.class).newInstance(part)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	/*public static VehicleData getVehicleData(NBTTagCompound compound){
		if(!compound.hasKey("Vehicle")) return null;
		Vehicle veh = getVehicle(compound.getString("Vehicle")); if(veh == null) return null;
		try{ return ((VehicleData)veh.getDataClass().getConstructor(Vehicle.class).newInstance(veh)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}

	public static VehicleData readVehicleData(NBTTagCompound compound, VehicleData data){
		if(data != null) return data.read(compound);
		if(!compound.hasKey("Vehicle")) return null;
		Vehicle veh = getVehicle(compound.getString("Vehicle")); if(veh == null) return null;
		try{ return ((VehicleData)veh.getDataClass().getConstructor(Vehicle.class).newInstance(veh)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}*/

	/*public static ContainerData getContainerData(NBTTagCompound compound){
		if(!compound.hasKey("Container")) return null;
		Container con = getContainer(compound.getString("Container")); if(con == null) return null;
		try{ return ((ContainerData)con.getDataClass().getConstructor(Container.class).newInstance(con)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}*/

	public static MultiBlockData0 getMultiBlockData(NBTTagCompound compound){
		if(!compound.hasKey("type")) return null;
		MultiBlock0 block = getMultiBlock(compound.getString("type"));
		if(block == null) return null;
		try{ return ((MultiBlockData0)block.getDataClass().getConstructor(MultiBlock0.class).newInstance(block)).read(compound); }
		catch(Throwable e){ e.printStackTrace(); return null; }
	}
	
	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerAttributeType(ResourceLocation regname, Class<? extends Attribute<?>> clazz, boolean override){
		registerAttributeType(regname.toString(), clazz, override);
	}
	
	/** Registers a Attribute class into FVTM Resources.*/
	public static void registerAttributeType(String regname, Class<? extends Attribute<?>> clazz, boolean override){
		if(ATTRIBUTE_TYPES.containsKey(regname) && !override) return;
		ATTRIBUTE_TYPES.put(regname, clazz);
	}
	
	public static Class<? extends Attribute<?>> getAttributeType(ResourceLocation regname){
		return getAttributeType(regname.toString());
	}
	
	public static Class<? extends Attribute<?>> getAttributeType(String id){
		return ATTRIBUTE_TYPES.get(id);
	}

	public static TreeMap<String, Class<? extends Attribute<?>>> getAttributeTypes(){
		return ATTRIBUTE_TYPES;
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

	public static String getFuelName(ResourceLocation id){
		return getFuelName(id.toString());
	}

	public static String getFuelName(String id){
		Fuel fuel = getFuel(id); return fuel == null ? "not-found" : fuel.getName();
	}
	
	@SubscribeEvent
	public void onAttachItemStackCapabilities(AttachCapabilitiesEvent<ItemStack> event){
		if(event.getObject().getItem() instanceof VehicleItem || event.getObject().getItem() instanceof PartItem
			|| event.getObject().getItem() instanceof ContainerItem || event.getObject().getItem() instanceof BlockItem){
			event.addCapability(new ResourceLocation("fvtm:vapdatacache"), new VAPDataCache(event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onAttachWorldCapabilities(AttachCapabilitiesEvent<World> event){
		SystemManager.onAttachWorldCapabilities(event.getObject());
		event.addCapability(new ResourceLocation("fvtm:multiblocks"), new MultiBlockCacheSerializer(event.getObject()));
	}
	
	@SubscribeEvent
	public void onAttachChunkCapabilities(AttachCapabilitiesEvent<Chunk> event){
		event.addCapability(new ResourceLocation("fvtm:trafficsigns"), new TrafficSignCapHandler(event.getObject()));
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
			event.addCapability(new ResourceLocation("fvtm:playerdata"), new PlayerDataHandler(event.getObject()));
			if(event.getObject().world.isRemote){
				event.addCapability(new ResourceLocation("fvtm:rendercache"), new RenderCacheHandler());
			}
		}
		if(event.getObject() instanceof EntityLivingBase){
			event.addCapability(new ResourceLocation("fvtm:passenger"), new PassengerSerializer(event.getObject()));
		}
		if(event.getObject().world.isRemote && event.getObject() instanceof Decoration){
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
		for(World world : Static.getServer().worlds){
			SystemManager.onServerTick(world);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event){
		if(event.phase != Phase.START) return;
		SystemManager.onClientTick(net.minecraft.client.Minecraft.getMinecraft().world);
	}
	
	@SubscribeEvent
	public void onChunkLoad(ChunkEvent.Load event){
		SystemManager.onChunkLoad(event.getWorld(), event.getChunk());
		event.getChunk().getTileEntityMap().values().forEach(tile -> {
			if(tile instanceof MultiblockTileEntity){
				((MultiblockTileEntity)tile).setup();
			}
		});
	}
	
	@SubscribeEvent
	public void onChunkUnload(ChunkEvent.Unload event){
		SystemManager.onChunkUnload(event.getWorld(), event.getChunk());
	}
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldLoad(event.getWorld());
	}
	
	@SubscribeEvent
	public void onWorldUnload(WorldEvent.Unload event){
		if(!event.getWorld().isRemote) return;
		SystemManager.onWorldUnload(event.getWorld());
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
		if(!event.player.world.isRemote) RoadPlacingCache.onLogIn(event.player);
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = true;
	}
	
	@SubscribeEvent
	public void onPlayerOut(PlayerEvent.PlayerLoggedOutEvent event){
		if(!event.player.world.isRemote){
			RailPlacingUtil.CURRENT.remove(event.player.getGameProfile().getId());
			RoadPlacingCache.onLogOut(event.player);
		}
		if(Config.DISMOUNT_ON_LOGOUT && event.player.getRidingEntity() instanceof GenericVehicle){
			event.player.dismountRidingEntity();
		}
		if(!Static.getServer().isSinglePlayer()) return;
		SystemManager.PLAYERON = false;
	}
	
	/*@SubscribeEvent
	public void onEntityDamage(LivingDamageEvent event){
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof SeatEntity){
			event.setCanceled(true);
		}
	}*/
	
	@SubscribeEvent
	public void onEntityAttack(LivingAttackEvent event){
		if(event.getEntity().isRiding() && event.getEntity().getRidingEntity() instanceof GenericVehicle){// && !event.getSource().isProjectile()){
			event.setCanceled(true);
		}
	}
	
	/*@SubscribeEvent
	public void onSpawn(EntityJoinWorldEvent event){
		Print.debug(event.getEntity());
	}*/
	
	public static final boolean isModLoaded(String modid){
		if(LOADED_MODS.containsKey(modid)) return LOADED_MODS.get(modid);
		boolean bool = Loader.isModLoaded(modid);
		LOADED_MODS.put(modid, bool);
		return bool;
	}

	public static void registerDefaultRecipes(){
		String blockcat = "fvtm.recipes.blocks";
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(ConstructorBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK),
			new ItemStack(Items.COMPARATOR, 4),
			new ItemStack(Items.REPEATER, 8),
			new ItemStack(Items.REDSTONE, 16),
			new ItemStack(Items.BOOK, 2),
			new ItemStack(Blocks.LEVER, 8)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(ConstCenterBlock.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK, 2),
			new ItemStack(Items.IRON_INGOT, 8),
			new ItemStack(Items.COMPARATOR, 2),
			new ItemStack(Items.REPEATER, 4),
			new ItemStack(Items.REDSTONE, 4),
			new ItemStack(Items.BOOK, 1),
			new ItemStack(Blocks.LEVER, 2),
			new ItemStack(Blocks.PISTON, 2)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(VPInfo.INSTANCE),
			new ItemStack(Blocks.IRON_BLOCK),
			new ItemStack(Items.BOOK, 16),
			new ItemStack(Items.REDSTONE, 4),
			new ItemStack(Blocks.LEVER, 4),
			new ItemStack(Items.GLASS_BOTTLE, 2)
		);
		String gauge = InternalAddon.STANDARD_GAUGE.toString();
		Item gaugeitem = Item.getByNameOrId(gauge);
		Item gaugeitem16 = Item.getByNameOrId(gauge + ".16_straight");
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(gaugeitem),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".4_straight")),
			new ItemStack(gaugeitem, 4),
			new ItemStack(Items.IRON_INGOT, 2)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".8_straight")),
			new ItemStack(gaugeitem, 8),
			new ItemStack(Items.IRON_INGOT, 3)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".32_straight")),
			new ItemStack(gaugeitem, 32),
			new ItemStack(Items.IRON_INGOT, 8)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")),
			new ItemStack(gaugeitem, 16),
			new ItemStack(Items.IRON_INGOT, 4),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_up")),
			new ItemStack(gaugeitem16),
			new ItemStack(Blocks.PLANKS, 4)
		);
		RecipeRegistry.addBluePrintRecipe(blockcat,
			new ItemStack(Item.getByNameOrId(gauge + ".16_straight_slope_down")),
			new ItemStack(gaugeitem16),
			new ItemStack(Blocks.PLANKS, 4)
		);
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
							//TODO containers holder = CONTAINERS.get(split[1]);
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
