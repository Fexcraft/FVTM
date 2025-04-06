package net.fexcraft.mod.fvtm.data.root;

import java.util.List;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Saveable;
import net.fexcraft.mod.uni.IDL;
import net.fexcraft.mod.uni.IDLManager;
import net.fexcraft.mod.uni.tag.TagCW;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class Textureable implements Saveable {
	
	private IDL current;
	private String custom = "";
	private boolean external;
	private int selected;
	private TextureHolder holder;
	
	public Textureable(TextureHolder texholder){
		current = (holder = texholder).getDefaultTextures().get(0);
	}
	
	public IDL getTexture(){
		return current;
	}
	
	public int getSelected(){
		return selected;
	}
	
	public boolean isExternal(){
		return external;
	}

	public String getCustom(){
		return custom;
	}
	
	public void setSelectedTexture(int idx, String tex, boolean ext){
		if(idx < 0){
			external = ext;
			selected = -1;
			custom = tex;
			current = ext ? FvtmResources.INSTANCE.getExternalTexture(custom) : IDLManager.getIDLNamed(custom);
		}
		else{
			external = false;
			if(idx > holder.getDefaultTextures().size()){
				current = holder.getDefaultTextures().get(selected = holder.getDefaultTextures().size() - 1);
			}
			else{
				current = holder.getDefaultTextures().get(selected = idx);
			}
		}
	}

	public static interface TextureHolder {

		public List<IDL> getDefaultTextures();

	}
	
	public static interface TextureUser {
		
		public Textureable getTexture();
		
		public TextureHolder getTexHolder();
		
		public default IDL getCurrentTexture(){
			return getTexture().current;
		}
		
		public default int getSelectedTexture(){
			return getTexture().selected;
		}
		
		public default boolean isTextureExternal(){
			return getTexture().external;
		}
		
		public default String getCustomTexture(){
			return getTexture().custom;
		}
		
	}

	@Override
	public void save(TagCW compound){
		compound.set("SelectedTexture", selected);
		compound.set("ExternalTexture", external);
		compound.set("CurrentTexture", external ? custom : current.toString());
	}

	@Override
	public void load(TagCW compound){
		selected = compound.getInteger("SelectedTexture");
		external = compound.getBoolean("ExternalTexture");
		if(selected < 0) selected = -1;
		if(selected >= holder.getDefaultTextures().size()) selected = holder.getDefaultTextures().size() - 1;
		if(!compound.has("CurrentTexture")){
			custom = compound.getString("CustomTexture");
			if(selected < 0) current = external ? FvtmResources.INSTANCE.getExternalTexture(custom) : IDLManager.getIDLNamed(custom);
			else current = holder.getDefaultTextures().get(selected > holder.getDefaultTextures().size() ? 0 : selected);
		}
		else{
			String str = compound.getString("CurrentTexture");
			if(selected < 0){
				current = external ? FvtmResources.INSTANCE.getExternalTexture(str): IDLManager.getIDLNamed(str);
				custom = external ? str : current.toString();
			}
			else{
				current = holder.getDefaultTextures().get(selected);
				custom = "";
			}
		}
	}

	public JsonMap save(){
		JsonMap map = new JsonMap();
		if(selected == 0 && !external) return map;
		map.add("sel", selected);
		if(external) map.add("ext", external);
		if(selected != 0) map.add("tex", external ? custom : current.toString());
		return map;
	}

	public void load(JsonMap map){
		selected = map.getInteger("sel", 0);
		external = map.getBoolean("ext", false);
		String str = map.getString("tex", "");
		if(selected < 0){
			current = external ? FvtmResources.INSTANCE.getExternalTexture(str): IDLManager.getIDLNamed(str);
			custom = external ? str : current.toString();
		}
		else{
			current = holder.getDefaultTextures().get(selected);
			custom = "";
		}
	}

}
