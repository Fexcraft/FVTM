package net.fexcraft.mod.fvtm.data.container;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.data.InventoryType;
import net.fexcraft.mod.fvtm.data.root.Colorable;
import net.fexcraft.mod.fvtm.data.root.DataType;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Lockable;
import net.fexcraft.mod.fvtm.data.root.Model;
import net.fexcraft.mod.fvtm.data.root.Model.ModelData;
import net.fexcraft.mod.fvtm.data.root.Tabbed;
import net.fexcraft.mod.fvtm.data.root.Textureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.event.TypeEvents;
import net.fexcraft.mod.fvtm.item.ContainerItem;
import net.fexcraft.mod.fvtm.model.ContainerModel;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.handler.ContentFilter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * 
 * 
 * @author Ferdinand Calo' (FEX___96)
 */
public class Container extends TypeCore<Container> implements Textureable.TextureHolder, Colorable.ColorHolder, Tabbed, ItemTextureable {

	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected List<NamedResourceLocation> textures;
	protected Model model;
	protected ModelData modeldata;
	protected ResourceLocation keytype;
	protected ContentFilter filter;
	protected InventoryType invtype;
	protected ContainerType type;
	protected ContainerItem item;
	protected String modelid, ctab;
	protected int capacity;
	protected Fluid fluid;
	protected ResourceLocation itemloc;
	protected boolean no3ditem;

	@Override
	public Container setRegistryName(ResourceLocation name){
		this.registryname = name; return this;
	}

	@Override
	public ResourceLocation getRegistryName(){
		return registryname;
	}

	@Override
	public Class<Container> getRegistryType(){
		return Container.class;
	}

	@Override
	public List<NamedResourceLocation> getDefaultTextures(){
		return textures;
	}

	@Override
	public Container parse(JsonObject obj){
		this.registryname = DataUtil.getRegistryName(obj);
		if(registryname == null) return null;
		this.pack = DataUtil.getAddon(obj);
		if(pack == null) return null;
		//
		this.name = JsonUtil.getIfExists(obj, "Name", "Unnamed Vehicle");
		this.description = DataUtil.getStringArray(obj, "Description", true, true);
		this.type = ContainerType.valueOf(JsonUtil.getIfExists(obj, "ContainerType", "MEDIUM").toUpperCase());
		this.textures = DataUtil.getTextures(obj);
		channels.put("primary", DataUtil.getColor(obj, "Primary", false));
		channels.put("secondary", DataUtil.getColor(obj, "Secondary", false));
		if(obj.has("Colors")){
			for(Entry<String, JsonElement> entry : obj.get("Colors").getAsJsonObject().entrySet()){
				channels.put(entry.getKey(), new RGB(entry.getValue().getAsString()));
			}
		}
		this.keytype = obj.has("KeyType") ? new ResourceLocation(obj.get("KeyType").getAsString()) : Lockable.DEFAULT_KEY;
		this.invtype = InventoryType.valueOf(JsonUtil.getIfExists(obj, "InventoryType", "ITEM").toUpperCase());
		this.capacity = JsonUtil.getIfExists(obj, "InventorySize", invtype == InventoryType.ITEM ? 8 : 16000).intValue();
        if(obj.has("FluidType")){
            fluid = FluidRegistry.getFluid(obj.get("FluidType").getAsString());
        }
        if(obj.has("ContentFilter")){
        	this.filter = ContentFilter.FILTER_REGISTRY.get(obj.get("ContentFilter").getAsString());
        }
		//
		if(Static.isClient()){
			modelid = obj.has("Model") ? obj.get("Model").getAsString() : null;
			modeldata = DataUtil.getModelData(obj);
		}
        this.ctab = JsonUtil.getIfExists(obj, "CreativeTab", "default");
        this.itemloc = DataUtil.getItemTexture(registryname, getDataType(), obj);
        this.no3ditem = JsonUtil.getIfExists(obj, "DisableItem3DModel", false);
		this.item = new ContainerItem(this);
		MinecraftForge.EVENT_BUS.post(new TypeEvents.ContainerCreated(this, obj));
		return this;
	}

	@Override
	public DataType getDataType(){
		return DataType.CONTAINER;
	}

	@Override
	public Class<?> getDataClass(){
		return ContainerData.class;
	}
	
	@Override
	public void loadModel(){
		this.model = Resources.getModel(modelid, modeldata, ContainerModel.class);
	}
	
	public ContainerItem getVehicleItem(){
		return item;
	}
	
	@Override
	public Item getItem(){
		return item;
	}
	
	public ItemStack newItemStack(){
		return new ItemStack(item, 1);
	}
	
	public Model getModel(){
		return model;
	}

	public ContainerType getContainerType(){
		return type;
	}

	public InventoryType getInventoryType(){
		return invtype;
	}

	public int getInventorySize(){
		return capacity;
	}

	public int getCapacity(){
		return capacity;
	}

	public Fluid getFluidType(){
		return fluid;
	}

	public ContentFilter getContentFilter(){
		return filter;
	}

	@Override
	public RGB getDefaultColorChannel(String channel){
		return channels.get(channel);
	}

	@Override
	public TreeMap<String, RGB> getDefaultColorChannels(){
		return channels;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}
	
	public ResourceLocation getKeyType(){
		return keytype;
	}

	@Override
	public ResourceLocation getItemTexture(){
		return itemloc;
	}
	
	@Override
	public boolean no3DItemModel(){
		return no3ditem;
	}

}
