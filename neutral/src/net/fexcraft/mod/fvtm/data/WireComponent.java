package net.fexcraft.mod.fvtm.data;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.V3D;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.root.WithItem;
import net.fexcraft.mod.fvtm.model.Model;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.content.WireModel;
import net.fexcraft.mod.fvtm.util.ContentConfigUtil;
import net.fexcraft.mod.uni.EnvInfo;
import net.fexcraft.mod.uni.IDL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class WireComponent extends Content<WireComponent> implements WithItem {

	protected String type;
	protected IDL texture;
	protected Model model;
	protected ModelData modeldata;
	protected String modelid;
	protected String ctab;
	protected List<String> accepts;
	protected List<SubRelay> subrelays = new ArrayList<>();

	public WireComponent(){}

	@Override
	public WireComponent parse(JsonMap map){
		if((pack = ContentConfigUtil.getAddon(map)) == null) return null;
		if((id = ContentConfigUtil.getID(pack, map)) == null) return null;
		//
		name = map.getString("Name", "Unnamed Wire Decoration");
		description = ContentConfigUtil.getStringList(map, "Description");
		type = map.getString("Type", "relay");
		if(map.has("SubRelay")){
			JsonValue elm = map.get("SubRelay");
			if(elm.isMap()){
				subrelays.add(new SubRelay(elm.asMap()));
			}
			else subrelays.add(new SubRelay(elm.float_value()));
		}
		if(map.has("SubRelays")){
			for(JsonValue<?> val : map.getArray("SubRelays").value){
				subrelays.add(new SubRelay(val.asMap()));
			}
		}
		texture = ContentConfigUtil.getTextures(map).get(0);
		accepts = ContentConfigUtil.getStringList(map, "Accepts");
		if(accepts.isEmpty()) accepts.add("universal");
		if(EnvInfo.CLIENT || EnvInfo.is121()){
			modelid = map.getString("Model", null);
			modeldata = new ModelData(map);
		}
		ctab = map.getString("CreativeTab", "default");
		return this;
	}

	@Override
	public ContentType getContentType(){
		return ContentType.WIRE_COMPONENT;
	}

	@Override
	public Class<?> getDataClass(){
		return null;
	}

	@Override
	public void loadModel(){
		model = FvtmResources.getModel(modelid, modeldata, WireModel.class);
	}

	@Override
	public WireModel getModel(){
		return (WireModel)model;
	}

	public String getType(){
		return type;
	}

	public IDL getTexture(){
		return texture;
	}

	public boolean accepts(String wiretype){
		return accepts.contains(wiretype);
	}

	@Override
	public String getItemContainer(){
		return null;
	}

	@Override
	public String getCreativeTab(){
		return ctab;
	}

	public List<String> getCompatible(){
		return accepts;
	}

	public boolean isRelayType(){
		return type.equals("relay");
	}

	public List<SubRelay> getSubRelays(){
		return subrelays;
	}

	public static class SubRelay {

		public float distance;
		public V3D offset;
		public boolean slack;

		public SubRelay(float dis){
			distance = dis;
			offset = new V3D();
			slack = true;
		}

		public SubRelay(JsonMap map){
			distance = map.getFloat("distance", 1);
			offset = map.has("offset") ? ContentConfigUtil.getVector(map.getArray("offset")) : new V3D();
			slack = map.getBoolean("slack", true);
		}

	}

}
