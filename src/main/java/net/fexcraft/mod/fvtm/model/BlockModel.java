package net.fexcraft.mod.fvtm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.fexcraft.app.json.JsonArray;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Axis3DL;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.render.block.BakedTransformData;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class BlockModel extends DefaultModel {

	public static final BlockModel EMPTY = new BlockModel();
    public HashMap<String, ArrayList<BlockModel>> state_models = new HashMap<>();
	
    public float gui_translate_x = 0;
    public float gui_translate_y = -.25f;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.75f;
    public float gui_scale_y = 0.75f;
    public float gui_scale_z = 0.75f;
    public boolean bindtex = true;
    public boolean nodefrot;
    public BakedTransformData bk;
    public HashMap<String, String> tg;
    public boolean grouptexname;
	
	public BlockModel(){
		super();
	}
	
	@Override
	public BlockModel parse(ModelData data){
		super.parse(data);
		if(data.has("ItemScale")){
            float scale = data.getFloat("ItemScale", gui_scale_x);
            gui_scale_x = scale;
            gui_scale_y = scale;
            gui_scale_z = scale;
		}
		if(data.has("ItemTranslate")){
            JsonValue<?> trs = data.get("ItemTranslate");
            if(trs.isValue()){
                float translate = data.getFloat("ItemTranslate", 0);
                gui_translate_x = translate;
                gui_translate_y = translate;
                gui_translate_z = translate;
            }
            else if(trs.isArray()){
                gui_translate_x = trs.asArray().get(0).float_value();
                gui_translate_y = trs.asArray().get(1).float_value();
                gui_translate_z = trs.asArray().get(2).float_value();
            }
		}
        bindtex = data.getBoolean("DefaultTextureBinding", true);
        if(data.has("States")){
            JsonMap states = data.getMap("States");
            for(Map.Entry<String, JsonValue<?>> entry : states.entries()){
                if(entry.getValue().isMap()){
                    ArrayList<BlockModel> list = new ArrayList();
                    for(Map.Entry<String, JsonValue<?>> e : entry.getValue().asMap().entries()){
                        Model model = FvtmResources.getModel(e.getKey(), new ModelData(e.getValue().asMap()), BlockModel.class);
                        if(model != null) list.add((BlockModel)model);
                    }
                    if(list.size() > 0) state_models.put(entry.getKey(), list);
                }
                else{
                    Model model = FvtmResources.getModel(entry.getValue().string_value(), new ModelData(), BlockModel.class);
                    if(model != null){
                        if(!state_models.containsKey(entry.getKey())) state_models.put(entry.getKey(), new ArrayList<>());
                        state_models.get(entry.getKey()).add((BlockModel)model);
                    }
                }
            }
        }
        if(data.has("RotateY")){
            transforms.add(new Transforms.TF_Rotate(0, 1, 0, data.getFloat("RotateY", 0)));
        }
        if(data.has("RotateZ")){
            transforms.add(new Transforms.TF_Rotate(0, 0, 1, data.getFloat("RotateZ", 0)));
        }
        if(data.has("RotateX")){
            transforms.add(new Transforms.TF_Rotate(1, 0, 0, data.getFloat("RotateX", 0)));
        }
        if(data.has("Translate")){
            JsonArray array = data.getArray("Translate");
            transforms.add(new Transforms.TF_Translate(array.get(0).float_value(), array.get(1).float_value(), array.get(2).float_value()));
        }
        nodefrot = data.getBoolean("NoDefaultRotation", false);
        if(data.has("GroupTextures")){
            tg = new HashMap<>();
            JsonMap tex = data.getMap("GroupTextures");
            tex.entries().forEach(entry -> {
                String[] k = entry.getKey().contains(",") ? entry.getKey().split(",") : new String[]{ entry.getKey() };
                String key = k[0];
                String pre = k.length > 1 ? k[1] + "," : "";
                if(entry.getValue().isArray()){
                    for(JsonValue<?> val : entry.getValue().asArray().value){
                        tg.put(pre + val.string_value(), key);
                    }
                }
                else tg.put(pre + entry.getValue().string_value(), key);
            });
        }
        grouptexname = data.getBoolean("GroupEqualsTexture", false);
		return this;
	}

	public ArrayList<ModelGroup> getPolygons(IBlockState state, EnumFacing side, ModelData data, long rand){
        ArrayList<ModelGroup> list = new ArrayList<>();
		for(ModelGroup group : groups){
            if(group.has_pre_prog){
                for(Program program : group.pre_programs) program.pre(group, RENDERDATA.set((BlockData)null, null, null, state, false));
            }
            if(!group.visible) continue;
            list.add(group);
        }
		return list;
	}

    public void reset(IBlockState state, EnumFacing side, ModelData data, long rand){
        for(ModelGroup group : groups){
            if(group.has_pst_prog){
                for(Program program : group.pst_programs) program.post(group, RENDERDATA.set((BlockData)null, null, null, state, false));
            }
        }
        bk = null;
    }

    public void convertTransforms(net.fexcraft.mod.fvtm.data.block.Block block, IBlockState state){
        bk = new BakedTransformData();
        bk.rot_poly = new Axis3DL();
        bk.rot_meta = new Axis3DL();
        if(state != null){
            bk.rot_meta.setAngles(-(float)block.getBlockType().getRotationFor(state.getBlock().getMetaFromState(state)), 0, 0);
        }
        if(transforms.hasRotate()){
            ArrayList<Transforms.TF_Rotate> list = transforms.getBakedRotate();
            bk.rot_tf = new Axis3DL[list.size()];
            for(int i = 0; i < list.size(); i++){
                Transforms.TF_Rotate rot = list.get(i);
                bk.rot_tf[i] = new Axis3DL();
                bk.rot_tf[i].setAngles(rot.y * rot.angle, rot.z * rot.angle, rot.x * rot.angle);
            }
        }
        if(transforms.hasTranslate()){
            bk.translate = transforms.getBakedTranslate();
        }
        else bk.translate = new Vec3f();
        if(transforms.hasScale()){
            bk.scale = transforms.getBakedScale();
        }
        else bk.scale = new Vec3f(1, 1, 1);
        //
        for(ArrayList<BlockModel> val : state_models.values()){
            for(BlockModel v : val) v.convertTransforms(block, state);
        }
    }

}