package net.fexcraft.mod.fvtm.model.content;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import net.fexcraft.app.json.JsonValue;
import net.fexcraft.mod.fvtm.model.DefaultModel;
import net.fexcraft.mod.fvtm.model.ModelData;
import net.fexcraft.mod.fvtm.model.ModelGroup;
import net.fexcraft.mod.fvtm.model.ModelRenderData;
import org.lwjgl.opengl.GL11;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class ClothModel extends DefaultModel {

	public static final ClothModel EMPTY = new ClothModel();
	protected TreeMap<String, ArrayList<String>> cloth_groups = new TreeMap<>();
	
	@Override
	public ClothModel parse(ModelData data){
		super.parse(data);
		if(data.has("SetGroupAs")){
			JsonValue sga = data.get("SetGroupAs");
			List<String> list = null;
			if(sga.isArray()){
				list = sga.asArray().toStringList();
			}
			else{
				list = new ArrayList<>();
				list.add(sga.string_value());
			}
			for(String string : list){
				String[] args = string.trim().split(" ");
				if(!groups.contains(args[0])) continue;
				try{
					String group = args[0];
					String model = args[1];
					float x = args.length > 2 ? Float.parseFloat(args[2]) : 0;
					float y = args.length > 3 ? Float.parseFloat(args[3]) : 0;
					float z = args.length > 4 ? Float.parseFloat(args[4]) : 0;
					setGroupAs(group, model, x, y, z);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return this;
	}
	
	public void setGroupAs(String group, String playermodelpart, float x, float y, float z){
		if(!groups.contains(group)) return;
		setGroupAs(groups.get(group), playermodelpart, x, y, z);
	}
	
	public void setGroupAs(ModelGroup group, String playermodelpart, float x, float y, float z){
		if(cloth_groups.containsKey(playermodelpart)){
			cloth_groups.get(playermodelpart).add(group.name);
		}
		else{
			ArrayList<String> arrlist = new ArrayList<>();
			arrlist.add(group.name);
			cloth_groups.put(playermodelpart, arrlist);
		}
		if(x == 0f && y == 0f && z == 0f) return;
		group.translate(x, y, z, false);
	}

	@Override
	public void render(ModelRenderData data){
		transforms.apply();
		GL11.glShadeModel(smooth_shading ? GL11.GL_FLAT : GL11.GL_SMOOTH);
		for(ModelGroup list : groups){
			if(!data.cloth_groups.contains(list.name)) continue;
			list.render(data);
		}
		transforms.deapply();
	}

	public TreeMap<String, ArrayList<String>> getClothGroups(){
		return cloth_groups;
	}
	
}