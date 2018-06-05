package net.fexcraft.mod.fvtm.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.fexcraft.mod.fvtm.util.config.Config;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.mod.fvtm.FVTM;
import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.api.Attribute;
import net.fexcraft.mod.fvtm.api.Consumable;
import net.fexcraft.mod.fvtm.api.Container;
import net.fexcraft.mod.fvtm.api.Container.ContainerData;
import net.fexcraft.mod.fvtm.api.Container.ContainerItem;
import net.fexcraft.mod.fvtm.api.Fuel;
import net.fexcraft.mod.fvtm.api.Material;
import net.fexcraft.mod.fvtm.api.Model;
import net.fexcraft.mod.fvtm.api.Part;
import net.fexcraft.mod.fvtm.api.Part.PartData;
import net.fexcraft.mod.fvtm.api.Part.PartItem;
import net.fexcraft.mod.fvtm.api.Vehicle;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleData;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleItem;
import net.fexcraft.mod.fvtm.api.Vehicle.VehicleType;
import net.fexcraft.mod.fvtm.impl.GenericAddon;
import net.fexcraft.mod.fvtm.impl.GenericConsumable;
import net.fexcraft.mod.fvtm.impl.GenericConsumableItem;
import net.fexcraft.mod.fvtm.impl.GenericContainer;
import net.fexcraft.mod.fvtm.impl.GenericContainerItem;
import net.fexcraft.mod.fvtm.impl.GenericCreativeTab;
import net.fexcraft.mod.fvtm.impl.GenericVehicle;
import net.fexcraft.mod.fvtm.impl.GenericVehicleItem;
import net.fexcraft.mod.fvtm.impl.GenericMaterial;
import net.fexcraft.mod.fvtm.impl.GenericMaterialItem;
import net.fexcraft.mod.fvtm.impl.GenericPart;
import net.fexcraft.mod.fvtm.impl.GenericPartItem;
import net.fexcraft.mod.fvtm.impl.HybridAddon;
import net.fexcraft.mod.fvtm.model.EmptyModel;
import net.fexcraft.mod.fvtm.model.container.ContainerBaseModel;
import net.fexcraft.mod.fvtm.model.vehicle.VehicleBaseModel;
import net.fexcraft.mod.lib.FCL;
import net.fexcraft.mod.lib.network.Network;
import net.fexcraft.mod.lib.util.common.Print;
import net.fexcraft.mod.lib.util.common.Static;
import net.fexcraft.mod.lib.util.common.ZipUtil;
import net.fexcraft.mod.lib.util.json.JsonUtil;
import net.fexcraft.mod.lib.util.render.ModelType;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.common.MetadataCollection;
import net.minecraftforge.fml.common.discovery.ContainerType;
import net.minecraftforge.fml.common.discovery.ModCandidate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class Resources {

    public static final String DEFPACKCFGFILENAME = "addonpack.fvtm";
    public static IForgeRegistry<Addon> ADDONS;// = (IForgeRegistry<Addon>)new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
    public static IForgeRegistry<Fuel> FUELS;// = (IForgeRegistry<Fuel>)new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
    public static IForgeRegistry<Material> MATERIALS;// = (IForgeRegistry<Material>)new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
    public static IForgeRegistry<Part> PARTS;// = (IForgeRegistry<Part>)new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
    public static IForgeRegistry<Vehicle> VEHICLES;// = (IForgeRegistry<LandVehicle>)new RegistryBuilder<LandVehicle>().setName(new ResourceLocation("fvtm:landvehicles")).setType(LandVehicle.class).create();
    public static IForgeRegistry<Container> CONTAINERS;
    public static IForgeRegistry<Consumable> CONSUMABLES;
    public static TreeMap<String, Model<?, ?>> MODELS = new TreeMap<String, Model<?, ?>>();
    public static TreeMap<ResourceLocation, SoundEvent> SOUNDS = new TreeMap<ResourceLocation, SoundEvent>();
    public static TreeMap<String, JsonObject> PRESETS = new TreeMap<String, JsonObject>();
    public static IForgeRegistry<Attribute> PARTATTRIBUTES;// = (IForgeRegistry<Attribute>)new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
    public static ResourceLocation NULL_TEXTURE = new ResourceLocation("fvtm:textures/entities/null_texture.png");
    public static ResourceLocation TRANSPARENT_TEXTURE = new ResourceLocation("fvtm:textures/entities/transparent_texture.png");
    private final File configpath, addonconfig;
    private Method method;

    public Resources(){
        configpath = new File(FCL.getInstance().getConfigDirectory().getParentFile(), "/fvtm/");
        if(!configpath.exists()){
            configpath.mkdirs();
        }
        addonconfig = new File(configpath, "/addonpacks.fex");
        //
        ADDONS = (IForgeRegistry<Addon>) new RegistryBuilder<Addon>().setName(new ResourceLocation("fvtm:addons")).setType(Addon.class).create();
        FUELS = (IForgeRegistry<Fuel>) new RegistryBuilder<Fuel>().setName(new ResourceLocation("fvtm:fuels")).setType(Fuel.class).create();
        MATERIALS = (IForgeRegistry<Material>) new RegistryBuilder<Material>().setName(new ResourceLocation("fvtm:materials")).setType(Material.class).create();
        PARTS = (IForgeRegistry<Part>) new RegistryBuilder<Part>().setName(new ResourceLocation("fvtm:parts")).setType(Part.class).create();
        VEHICLES = (IForgeRegistry<Vehicle>) new RegistryBuilder<Vehicle>().setName(new ResourceLocation("fvtm:vehicles")).setType(Vehicle.class).create();
        PARTATTRIBUTES = (IForgeRegistry<Attribute>) new RegistryBuilder<Attribute>().setName(new ResourceLocation("fvtm:attributes")).setType(Attribute.class).create();
        CONTAINERS = (IForgeRegistry<Container>) new RegistryBuilder<Container>().setName(new ResourceLocation("fvtm:containers")).setType(Container.class).create();
        CONSUMABLES = (IForgeRegistry<Consumable>) new RegistryBuilder<Consumable>().setName(new ResourceLocation("fvtm:consumables")).setType(Consumable.class).create();
    }

    public void updateAddonConfig(){
        JsonArray array = new JsonArray();
        for(Addon addon : ADDONS.getValues()){
            JsonObject obj = new JsonObject();
            obj.addProperty("id", addon.getRegistryName().toString());
            obj.addProperty("state", addon.isEnabled());
            array.add(obj);
        }
        JsonUtil.write(addonconfig, array);
    }

    private void queryAddons(){
        try{
            JsonArray array = JsonUtil.read(addonconfig, true, new JsonArray()).getAsJsonArray();
            for(JsonElement elm : array){
                try{
                    Addon addon = ADDONS.getValue(new ResourceLocation(elm.getAsJsonObject().get("id").getAsString()));
                    if(addon != null){
                        addon.setEnabled(elm.getAsJsonObject().get("state").getAsBoolean());
                    }
                }
                catch(Exception e){
                    //
                }
            }
            this.updateAddonConfig();
            for(Addon pack : ADDONS.getValues()){
                for(ResourceLocation id : pack.getDependencies()){
                    if(ADDONS.getValue(id) == null){
                        pack.setMissingDependencies(true);
                        continue;
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void regItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(GenericMaterialItem.INSTANCE);
        event.getRegistry().register(GenericPartItem.INSTANCE);
        event.getRegistry().register(GenericVehicleItem.INSTANCE);
        event.getRegistry().register(GenericContainerItem.INSTANCE);
        event.getRegistry().register(GenericConsumableItem.INSTANCE);
        //
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void regModels(net.minecraftforge.client.event.ModelRegistryEvent event){
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericMaterialItem.INSTANCE, new GenericMaterialItem.ItemMeshDef());
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericPartItem.INSTANCE, new GenericPartItem.ItemMeshDef());
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericVehicleItem.INSTANCE, new GenericVehicleItem.ItemMeshDef());
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericContainerItem.INSTANCE, new GenericContainerItem.ItemMeshDef());
        net.minecraftforge.client.model.ModelLoader.setCustomMeshDefinition(GenericConsumableItem.INSTANCE, new GenericConsumableItem.ItemMeshDef());
    }

    @SubscribeEvent
    public void regAddons(RegistryEvent.Register<Addon> event){
        ClassLoader cl = net.minecraft.server.MinecraftServer.class.getClassLoader();
        try{
            method = (java.net.URLClassLoader.class).getDeclaredMethod("addURL", java.net.URL.class);
            method.setAccessible(true);
        }
        catch(Exception e){
            Print.log("Failed to get class loader. All content loading will now fail.");
            e.printStackTrace();
        }

        File addonfolder = new File(FCL.getInstance().getConfigDirectory().getParentFile().getParentFile(), "/addons/");
        if(!addonfolder.exists()){
            addonfolder.mkdirs();
        }
        for(File file : addonfolder.listFiles()){
            if(Addon.isAddonContainer(file)){
                try{
                    method.invoke(cl, file.toURI().toURL());
                    Addon addon = GenericAddon.isHybrid(file) ? HybridAddon.getClass(file).getConstructor(File.class).newInstance(file) : new GenericAddon(file);
                    event.getRegistry().register(addon);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        for(Addon addon : ADDONS.getValues()){
            if(Static.side().isClient()){
                Print.log("Registering Addonpack into Forge/Minecraft resources...");
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("modid", addon.getRegistryName().getResourcePath());
                map.put("name", "[FVTM]: " + addon.getName());
                map.put("version", addon.getVersion());
                FMLModContainer container = new FMLModContainer("net.fexcraft.mod.fvtm.FVTM", new ModCandidate(addon.getFile(), addon.getFile(), addon.getFile().isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
                container.bindMetadata(MetadataCollection.from(null, ""));
                net.minecraftforge.fml.client.FMLClientHandler.instance().addModAsResource(container);
            }
        }
        if(Static.side().isClient() && ADDONS.getEntries().size() > 0){
            net.minecraft.client.Minecraft.getMinecraft().refreshResources();
        }
        for(Addon addon : ADDONS.getValues()){
            new GenericCreativeTab(addon);
        }
    }

    @SubscribeEvent
    public void regMaterials(RegistryEvent.Register<Material> event){
        this.queryAddons();
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regMaterials(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
            Print.debug(addon.getRegistryName());
            if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
                if(addon.getFile().isDirectory()){
                    File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/");
                    Print.debug(matfol.getPath());
                    if(!matfol.exists()){
                        matfol.mkdirs();
                    }
                    for(File file : matfol.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".material")){
                            GenericMaterial mat = new GenericMaterial(JsonUtil.get(file));
                            event.getRegistry().register(mat);
                            if(Static.side().isClient()){
                                net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
                            }
                            Print.debug(mat.getRegistryName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".material")){
                                    GenericMaterial mat = new GenericMaterial(JsonUtil.get(fl));
                                    event.getRegistry().register(mat);
                                    if(Static.side().isClient()){
                                        net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
                                    }
                                    Print.debug(mat.getRegistryName());
                                }
                            }
                        }
                        Print.debug(file.getPath());
                        //else skip;
                    }
                }
                else{
                    JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/materials/", ".material");
                    for(JsonElement elm : array){
                        GenericMaterial mat = new GenericMaterial(elm.getAsJsonObject());
                        event.getRegistry().register(mat);
                        if(Static.side().isClient()){
                            net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericMaterialItem.INSTANCE, mat.getRegistryName());
                        }
                        Print.debug(mat.getRegistryName());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void regParts(RegistryEvent.Register<Part> event){
        this.queryAddons();
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regParts(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
            Print.debug(addon.getRegistryName());
            if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
                if(addon.getFile().isDirectory()){
                    File partfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/");
                    Print.debug(partfol.getPath());
                    if(!partfol.exists()){
                        partfol.mkdirs();
                    }
                    for(File file : partfol.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".part")){
                            GenericPart part = new GenericPart(JsonUtil.get(file));
                            event.getRegistry().register(part);
                            if(Static.side().isClient()){
                                net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
                            }
                            Print.debug(part.getRegistryName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".part")){
                                    GenericPart part = new GenericPart(JsonUtil.get(fl));
                                    event.getRegistry().register(part);
                                    if(Static.side().isClient()){
                                        net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
                                    }
                                    Print.debug(part.getRegistryName());
                                }
                            }
                        }
                        Print.debug(file.getPath());
                        //else skip;
                    }
                }
                else{
                    JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/parts/", ".part");
                    for(JsonElement elm : array){
                        GenericPart part = new GenericPart(elm.getAsJsonObject());
                        event.getRegistry().register(part);
                        if(Static.side().isClient()){
                            net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericPartItem.INSTANCE, part.getRegistryName());
                        }
                        Print.debug(part.getRegistryName());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void regVehicles(RegistryEvent.Register<Vehicle> event){
        this.queryAddons();
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regVehicles(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
            Print.debug(addon.getRegistryName());
            if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
                if(addon.getFile().isDirectory()){
                    File vehfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/");
                    Print.debug(vehfol.getPath());
                    if(!vehfol.exists()){
                        vehfol.mkdirs();
                    }
                    for(File file : vehfol.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".vehicle")){
                            GenericVehicle veh = new GenericVehicle(JsonUtil.get(file));
                            event.getRegistry().register(veh);
                            if(Static.side().isClient()){
                                if(Config.RENDER_IN_GUI){
                                    net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleBaseModel)veh.getModel());
                                }
                                net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
                            }
                            Print.debug(veh.getRegistryName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".vehicle")){
                                    GenericVehicle veh = new GenericVehicle(JsonUtil.get(fl));
                                    event.getRegistry().register(veh);
                                    if(Static.side().isClient()){
                                        if(Config.RENDER_IN_GUI){
                                            net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleBaseModel)veh.getModel());
                                        }
                                        net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
                                    }
                                }
                            }
                        }
                        Print.debug(file.getPath());
                        //else skip;
                    }
                    //check for presets
                    File presetfolder = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/presets/");
                    Print.debug(presetfolder.getPath());
                    if(!presetfolder.exists()){
                        presetfolder.mkdirs();
                    }
                    for(File file : presetfolder.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".preset")){
                            JsonElement elm = JsonUtil.read(file, false);
                            if(elm != null){
                                PRESETS.put(addon.getRegistryName().toString() + "/" + file.getName().replace(".preset", ""), elm.getAsJsonObject());
                            }
                            Print.debug(file.getName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".preset")){
                                    JsonElement elm = JsonUtil.read(file, false);
                                    if(elm != null){
                                        PRESETS.put(addon.getRegistryName().toString() + "/" + file.getName() + "/" + fl.getName().replace(".preset", ""), elm.getAsJsonObject());
                                    }
                                    Print.debug(file.getName());
                                }
                            }
                        }
                        Print.debug(file.getPath());
                        //else skip;
                    }
                }
                else{
                    JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/vehicles/", ".vehicle");
                    for(JsonElement elm : array){
                        GenericVehicle veh = new GenericVehicle(elm.getAsJsonObject());
                        event.getRegistry().register(veh);
                        if(Static.side().isClient()){
                            if(Config.RENDER_IN_GUI){
                                net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(veh.getRegistryName(), (VehicleBaseModel)veh.getModel());
                            }
                            net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericVehicleItem.INSTANCE, veh.getRegistryName());
                        }
                        Print.debug(veh.getRegistryName());
                    }
                    //check for presets
                    Map<String, JsonObject> arr = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/presets/", ".preset", true);
                    for(Entry<String, JsonObject> entry : arr.entrySet()){
                        PRESETS.put(addon.getRegistryName().toString() + "/" + entry.getKey(), entry.getValue());
                        Print.debug(entry.getKey());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void regPartAttributes(RegistryEvent.Register<Attribute> event){
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regAttributes(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
        }
    }

    @SubscribeEvent
    public void regFuels(RegistryEvent.Register<Fuel> event){
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regFuels(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
        }
    }

    @SubscribeEvent
    public void regSounds(RegistryEvent.Register<SoundEvent> event){
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regSounds(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
        }
        VEHICLES.getValues().forEach((vehicle) -> {
            vehicle.getSounds().forEach((soundloc) -> {
                if(event.getRegistry().containsKey(soundloc)){
                    SOUNDS.put(soundloc, event.getRegistry().getValue(soundloc));
                }
                if(SOUNDS.containsKey(soundloc)){
                    vehicle.setSoundEvent(SOUNDS.get(soundloc));
                }
                else{
                    SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
                    event.getRegistry().register(soundevent);
                    vehicle.setSoundEvent(soundevent);
                    SOUNDS.put(soundloc, soundevent);
                }
            });
        });
        PARTS.getValues().forEach((part) -> {
            part.getSounds().forEach((soundloc) -> {
                if(event.getRegistry().containsKey(soundloc)){
                    SOUNDS.put(soundloc, event.getRegistry().getValue(soundloc));
                }
                if(SOUNDS.containsKey(soundloc)){
                    part.setSoundEvent(SOUNDS.get(soundloc));
                }
                else{
                    SoundEvent soundevent = new SoundEvent(soundloc).setRegistryName(soundloc);
                    event.getRegistry().register(soundevent);
                    part.setSoundEvent(soundevent);
                    SOUNDS.put(soundloc, soundevent);
                }
            });
            //Print.debug(part.getSounds());
        });
        //Print.debug(" - - - - - - ");
        //Print.debug(SOUNDS.values());
        //Static.halt();
    }

    @SubscribeEvent
    public void regContainers(RegistryEvent.Register<Container> event){
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regContainers(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
            Print.debug(addon.getRegistryName());
            if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
                if(addon.getFile().isDirectory()){
                    File confol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/containers/");
                    Print.debug(confol.getPath());
                    if(!confol.exists()){
                        confol.mkdirs();
                    }
                    for(File file : confol.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".container")){
                            GenericContainer con = new GenericContainer(JsonUtil.get(file));
                            event.getRegistry().register(con);
                            if(Static.side().isClient()){
                                if(Config.RENDER_IN_GUI){
                                    net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(con.getRegistryName(), (ContainerBaseModel)con.getModel());
                                }
                                net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
                            }
                            Print.debug(con.getRegistryName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".container")){
                                    GenericContainer con = new GenericContainer(JsonUtil.get(fl));
                                    event.getRegistry().register(con);
                                    if(Static.side().isClient()){
                                        if(Config.RENDER_IN_GUI){
                                            net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(con.getRegistryName(), (ContainerBaseModel)con.getModel());
                                        }
                                        net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
                                    }
                                    Print.debug(con.getRegistryName());
                                }
                            }
                        }
                        Print.debug(file.getPath());
                        //else skip;
                    }
                }
                else{
                    JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/containers/", ".container");
                    for(JsonElement elm : array){
                        GenericContainer con = new GenericContainer(elm.getAsJsonObject());
                        event.getRegistry().register(con);
                        if(Static.side().isClient()){
                            if(Config.RENDER_IN_GUI){
                                net.fexcraft.mod.lib.tmt.util.TMTItemModelLoader.addItemModel(con.getRegistryName(), (ContainerBaseModel)con.getModel());
                            }
                            net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericContainerItem.INSTANCE, con.getRegistryName());
                        }
                        Print.debug(con.getRegistryName());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void regConsumables(RegistryEvent.Register<Consumable> event){
        for(Addon addon : ADDONS.getValues()){
            if(addon instanceof GenericAddon){
                if(((GenericAddon) addon).isHybrid()){
                    ((HybridAddon) addon).regConsumables(event);
                    if(((HybridAddon) addon).skipDefaultRegistryMethods()){
                        continue;
                    }
                }
            }
            else{
                continue;
            }
            Print.debug(addon.getRegistryName());
            if(addon.isEnabled()/* && !addon.hasMissingDependencies()*/){
                if(addon.getFile().isDirectory()){
                    File matfol = new File(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/consumables/");
                    Print.debug(matfol.getPath());
                    if(!matfol.exists()){
                        matfol.mkdirs();
                    }
                    for(File file : matfol.listFiles()){
                        if(!file.isDirectory() && file.getName().endsWith(".consumable")){
                            GenericConsumable con = new GenericConsumable(JsonUtil.get(file));
                            event.getRegistry().register(con);
                            if(Static.side().isClient()){
                                net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
                            }
                            Print.debug(con.getRegistryName());
                        }
                        else if(file.isDirectory()){
                            for(File fl : file.listFiles()){
                                if(fl.getName().endsWith(".consumable")){
                                    GenericConsumable con = new GenericConsumable(JsonUtil.get(fl));
                                    event.getRegistry().register(con);
                                    if(Static.side().isClient()){
                                        net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
                                    }
                                    Print.debug(con.getRegistryName());
                                }
                            }
                        }
                        Print.debug(file.getPath());
                    }
                }
                else{
                    JsonArray array = ZipUtil.getJsonObjectsAt(addon.getFile(), "assets/" + addon.getRegistryName().getResourcePath() + "/config/consumables/", ".consumable");
                    for(JsonElement elm : array){
                        GenericConsumable con = new GenericConsumable(elm.getAsJsonObject());
                        event.getRegistry().register(con);
                        if(Static.side().isClient()){
                            net.minecraft.client.renderer.block.model.ModelBakery.registerItemVariants(GenericConsumableItem.INSTANCE, con.getRegistryName());
                        }
                        Print.debug(con.getRegistryName());
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public static <T, K> Model<T, K> getModel(String name, Class<T> dataclazz, Class<K> keyclazz, Class<? extends Model<T, K>> clazz){
        if(name == null || name.equals("") || name.equals("null")){
            return (Model<T, K>)EmptyModel.INSTANCE;
        }
        if(MODELS.containsKey(name)){
            return (Model<T, K>)MODELS.get(name);
        }
        ModelType type = getModelType(name);
        Model<T, K> model = null;
        try{
            switch(type){
                case JAVA:
                case TMT:
                    Class<?> clasz = Class.forName(name.replace(".class", ""));
                    model = (Model<T, K>)clasz.newInstance();
                    //if(model instanceof GenericModel){ ((GenericModel<T, K>)model).importSubModels(); }
                    break;
                case JTMT:
                    JsonObject obj = JsonUtil.getObjectFromInputStream(net.minecraft.client.Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(name)).getInputStream());
                    model = clazz.getConstructor(JsonObject.class).newInstance(obj);
                    //if(model instanceof GenericModel){ ((GenericModel<T, K>)model).importSubModels(); }
                    break;
                case JSON:
                    //TODO create a wrapper.
                    break;
                case OBJ:
                	//Use MRT's OBJ methods instead / or create a wrapper.
                	break;
                case NONE:
                default: return (Model<T, K>)EmptyModel.INSTANCE;
            }
        }
        catch(Exception e){
        	Print.log("Failed to find/parse model with adress '" + name + "'!");
            e.printStackTrace();
            Static.stop();
        }
        MODELS.put(name, model);
        return model;
    }

    public static ModelType getModelType(String modelname){
        String str = FilenameUtils.getExtension(modelname);
        switch(str){
            case "class":
                return ModelType.TMT;
            case "json":
                return ModelType.JSON;
            case "jtmt":
                return ModelType.JTMT;
            case "obj":
                return ModelType.OBJ;
        }
        return ModelType.NONE;
    }

    public static final VehicleData getVehicleData(NBTTagCompound compound){
        if(compound == null){
            return null;
        }
        if(compound.hasKey(VehicleItem.NBTKEY) || compound.hasKey(VehicleItem.OLDNBTKEY)){
            Vehicle vehicle = VEHICLES.getValue(new ResourceLocation(compound.hasKey(VehicleItem.NBTKEY) ? compound.getString(VehicleItem.NBTKEY) : compound.getString(VehicleItem.OLDNBTKEY)));
            if(vehicle != null){
                try{
                    return vehicle.getDataClass().getConstructor(Vehicle.class).newInstance(vehicle).readFromNBT(compound);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("NBTTagCompound supposed to hold vehicle data, but Vehicle could not be found. Thus will be deleted, here though the data so you can possibly respawn it: ");
                System.out.println(compound.toString());
            }
        }
        return null;
    }

    public static final PartData getPartData(NBTTagCompound compound){
        if(compound == null){
            return null;
        }
        if(compound.hasKey(PartItem.NBTKEY)){
            Part part = PARTS.getValue(new ResourceLocation(compound.getString(PartItem.NBTKEY)));
            if(part != null){
                try{
                    return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(compound);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static final PartData getPartData(ResourceLocation rs){
        Part part = PARTS.getValue(rs);
        if(part != null){
            try{
                return part.getDataClass().getConstructor(Part.class).newInstance(part).readFromNBT(new NBTTagCompound());
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ContainerData getContainerData(NBTTagCompound compound){
        if(compound.hasKey(ContainerItem.NBTKEY)){
            Container con = CONTAINERS.getValue(new ResourceLocation(compound.getString(ContainerItem.NBTKEY)));
            if(con != null){
                try{
                    return con.getDataClass().getConstructor(Container.class).newInstance(con).readFromNBT(compound);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    // UPDATE CHECKS //
    private TreeMap<ResourceLocation, String> updatelist = new TreeMap<ResourceLocation, String>();

    public void checkForUpdates(){
        ADDONS.forEach((addon) -> {
            String str = addon.getUpdateId();
            if(str != null && !str.equals("") && !str.equals(GenericAddon.NONE)){
                JsonObject obj = Network.request("http://fexcraft.net/minecraft/fcl/request", "mode=exists&modid=" + str);
                if(obj != null && obj.has("exists") && obj.get("exists").getAsBoolean()){
                    obj = Network.getModData(str);
                    if(obj != null && obj.has("versions")){
                        JsonArray array = obj.get("versions").getAsJsonArray();
                        for(JsonElement elm : array){
                            JsonObject jsn = elm.getAsJsonObject();
                            if(jsn.get("version").getAsString().equals(FCL.mcv)){
                                String lv = jsn.get("latest_version").getAsString();
                                if(!lv.equals(addon.getVersion())){
                                    //updatelist.add(addon.getRegistryName().toString() + ":" + lv);
                                    //actually, let's also check the FVTM version
                                    //might get removed tho ^ :thinking:
                                    boolean proceed = true;
                                    if(jsn.has("fvtm_version")){
                                        proceed = jsn.get("fvtm_version").getAsString().equals(FVTM.VERSION);
                                    }
                                    if(proceed){
                                        updatelist.put(addon.getRegistryName(), lv);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                else{
                    Print.debug("NEGATIVE RESPONSE FOR '" + str + "' >>:>> " + (obj == null ? "null" : obj));
                }
            }
        });
    }

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent event){
        if(event.player.world.isRemote){
            return;
        }
        for(Entry<ResourceLocation, String> entry : updatelist.entrySet()){
            Addon addon = ADDONS.getValue(entry.getKey());
            Print.chat(event.player, "&0[&9FVTM&0]&7 === === &5=&6=&5=&7 === ===");
            Print.chat(event.player, "&0[&9FVTM&0]&7 Update for Addon &8'&3" + addon.getName() + "&8'&7 found!");
            Print.chat(event.player, "&0[&9FVTM&0]&7 Installed Version: &3" + addon.getVersion());
            Print.chat(event.player, "&0[&9FVTM&0]&7 Latest Version: &3" + entry.getValue());
            Print.link(event.player, "&0[&9FVTM&0]&7 Download ?: &3&o&lCLICK", addon.getURL());
        }
    }

    public static final List<Vehicle> getVehiclesByType(VehicleType type){
        return Resources.VEHICLES.getValues().stream().filter(p -> p.getType() == type).collect(Collectors.toList());
    }

    public static final List<Vehicle> getVehiclesByAddon(Addon addon){
        return Resources.VEHICLES.getValues().stream().filter(p -> p.getAddon().getRegistryName().equals(addon.getRegistryName())).collect(Collectors.toList());
    }

    public final File getConfigPath(){
        return configpath;
    }

    public static NetworkRegistry.TargetPoint getTargetPoint(Entity ent){
        return new NetworkRegistry.TargetPoint(ent.dimension, ent.posX, ent.posY, ent.posZ, Config.VEHICLE_UPDATE_RANGE);
    }

    /*public static final TreeMap<ResourceLocation, Object> OLDREGNAMES = new TreeMap<ResourceLocation, Object>();

	private void initMappings(){
		if(OLDREGNAMES.isEmpty()){
			OLDREGNAMES.put(new ResourceLocation("landvehicle_constructor_controller"), ConstructorController.INSTANCE);
			OLDREGNAMES.put(new ResourceLocation("landvehicle_constructor_center"), ConstructorCenter.INSTANCE);
		}
	}

	@SubscribeEvent
	public void onMissingBlockMappings(RegistryEvent.MissingMappings<Block> event){
		this.initMappings();
		for(Mapping<Block> mapping : event.getMappings()){
			if(OLDREGNAMES.containsKey(mapping.key)){
				mapping.remap((Block)OLDREGNAMES.get(mapping.key));
			}
		}
	}

	@SubscribeEvent
	public void onMissingItemMappings(RegistryEvent.MissingMappings<Item> event){
		this.initMappings();
		for(Mapping<Item> mapping : event.getMappings()){
			if(OLDREGNAMES.containsKey(mapping.key)){
				Object obj = OLDREGNAMES.get(mapping.key);
				if(obj instanceof Item){
					mapping.remap((Item)obj);
				}
				else if(obj instanceof Block){
					mapping.remap(RegistryUtil.getItem(((Block)obj).getRegistryName()));
				}
			}
		}
	}*/
}
