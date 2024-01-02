package net.fexcraft.mod.fvtm.data;

import com.google.gson.JsonObject;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.lib.common.json.JsonUtil;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.ItemTextureable;
import net.fexcraft.mod.fvtm.data.root.TypeCore;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.item.ClothItem;
import net.fexcraft.mod.fvtm.model.ClothModel;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.PartModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.fvtm.util.DataUtil;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.item.ClothMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Cloth extends Content<Cloth> implements ItemTextureable, WithItem {
	
	protected short max_health;
	protected ClothItem item;
	protected String ctab, modelid;
	protected EntityEquipmentSlot eq_slot;
	protected ClothMaterial material;
	protected ClothModel model;
	protected ModelData modeldata;
	protected IDL texture;
	protected IDL itemloc;
	
	public Cloth(){}

	@Override
	public Cloth parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Clothing");
		description = description = ContentConfigUtil.getStringList(map, "Description");
		max_health = (short)map.getInteger("MaxItemDamage", 0);
		eq_slot = EntityEquipmentSlot.fromString(map.getString("EquipmentSlot", "head").toLowerCase());
		if(map.has("ClothMaterial")){
			String mat = map.get("ClothMaterial").string_value().toLowerCase();
			material = ClothMaterial.get(mat.contains(":") ? mat : getAddon().getID().id() + ":" + mat);
		}
		else material = ClothMaterial.get(FvtmRegistry.NONE_CLOTH_MAT);
		//
		texture = IDLManager.getIDLNamed(map.get("Texture", FvtmResources.NULL_TEXTURE.colon()));
		if(EnvInfo.CLIENT){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
        ctab = map.getString("CreativeTab", "default");
        itemloc = ContentConfigUtil.getItemTexture(id, getContentType(), map);
		item = new ClothItem(this);
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.CLOTH;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}
	
	public ClothItem getClothItem(){
		return item;
	}

	public int getMaxDamage(){
		return max_health;
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public EntityEquipmentSlot getEquitmentSlot(){
		return eq_slot;
	}

	public ClothMaterial getMaterial(){
		return material;
	}

	@Override
	public Model getModel(){
		return model;
	}

	public ClothModel getClothModel(){
		return model;
	}
	
	@Override
	public void loadModel(){
		model = (ClothModel)FvtmResources.getModel(modelid, modeldata, ClothModel.class);
	}
	
	public IDL getTexture(){
		return texture;
	}

	@Override
	public IDL getItemTexture(){
		return itemloc;
	}
}
