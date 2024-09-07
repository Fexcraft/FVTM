package net.fexcraft.mod.fvtm.data.container;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Content;
import net.fexcraft.mod.fvtm.data.ContentType;
import net.fexcraft.mod.fvtm.data.inv.InvHandler;
import net.fexcraft.mod.fvtm.data.inv.InvHandlerInit;
import net.fexcraft.mod.fvtm.data.inv.InvType;
import net.fexcraft.mod.fvtm.data.root.Colorable.ColorHolder;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.Textureable.TextureHolder;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Container extends Content<Container> implements TextureHolder, ColorHolder, WithItem, ItemTextureable {

	protected TreeMap<String, RGB> channels = new TreeMap<>();
	protected List<IDL> textures;
	protected Model model;
	protected ModelData modeldata;
	protected IDL keytype;
	protected InvHandler invtype;
	protected ContainerType type;
	protected String modelid, ctab;
	protected IDL itemtexloc;
	protected boolean no3ditem;
	@Override
	public Container parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Material");
		description = ContentConfigUtil.getStringList(map, "Description");
		type = ContainerType.valueOf(map.getString("ContainerType", "MEDIUM").toUpperCase());
		textures = ContentConfigUtil.getTextures(map);
		if(map.has("ColorChannels")){
			for(Entry<String, JsonValue<?>> entry : map.get("ColorChannels").asMap().entries()){
				channels.put(entry.getKey(), new RGB(entry.getValue().string_value()));
			}
		}
		if(channels.isEmpty()){
			channels.put("primary", RGB.WHITE.copy());
			channels.put("secondary", RGB.WHITE.copy());
		}
		keytype = map.has("KeyType") ? IDLManager.getIDLCached(map.getString("KeyType", null)) : null;
		invtype = new InvHandlerInit(InvType.parse(map.getString("InventoryType", "item"), false));
		invtype.setCapacity(map.getInteger("InventorySize", invtype.type.isItem() ? 8 : 16000));
        if(invtype.type.isFluid() && map.has("FluidType")) invtype.setArg(map.get("FluidType").string_value());
        if(invtype.type.isItem() &&  map.has("ContentFilter")) invtype.setArg(map.get("ContentFilter").string_value());
		//
		if(EnvInfo.CLIENT){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		ctab = map.getString("CreativeTab", "default");
		itemtexloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		no3ditem = map.getBoolean("Disable3DItemModel", false);
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.CONTAINER;
	}

	@Override
	public List<IDL> getDefaultTextures(){
		return textures;
	}

	@Override
	public Class<?> getDataClass(){
		return ContainerData.class;
	}
	
	@Override
	public void loadModel(){
		this.model = FvtmResources.getModel(modelid, modeldata, DefaultModel.class);
	}
	
	public Model getModel(){
		return model;
	}

	public ContainerType getContainerType(){
		return type;
	}

	public InvType getInventoryType(){
		return invtype.type;
	}

	public int getCapacity(){
		return invtype.capacity();
	}

	public String getFluidType(){
		return invtype.getFluid();
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
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public IDL getKeyType(){
		return keytype;
	}

	@Override
	public IDL getItemTexture(){
		return itemtexloc;
	}
	
	@Override
	public boolean noCustomItemModel(){
		return no3ditem;
	}

}
