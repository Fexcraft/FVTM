package net.fexcraft.mod.fvtm.model;

import static net.fexcraft.mod.fvtm.util.TexUtil.bindTexture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.fexcraft.app.json.JsonMap;
import net.fexcraft.app.json.JsonValue;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.render.FCLItemModel;
import net.fexcraft.lib.mc.utils.Axis3DL;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.data.Capabilities;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.item.BlockItem;
import net.fexcraft.mod.fvtm.render.block.BakedTransformData;
import net.fexcraft.mod.fvtm.util.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;

public class BlockModel extends DefaultModel implements FCLItemModel {

	public static final BlockModel EMPTY = new BlockModel();
    public HashMap<String, ArrayList<BlockModel>> state_models = new HashMap<>();
	
    public float gui_translate_x = 0;
    public float gui_translate_y = -.25f;
    public float gui_translate_z = 0;
    public float gui_scale_x = 0.75f;
    public float gui_scale_y = 0.75f;
    public float gui_scale_z = 0.75f;
    public boolean bindtex = true;
    public BakedTransformData bk;
	
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
		return this;
	}
	
	@Override
	public void renderItem(TransformType type, ItemStack item, EntityLivingBase entity){
		if(item.getItem() instanceof BlockItem == false){ Print.debug("wrong_instance"); return; }
        BlockData data = item.getCapability(Capabilities.VAPDATA, null).getBlockData(); if(data == null){ Print.debug("no_data"); return; }
        BlockModel model = (BlockModel)data.getType().getModel();
        if(model == null){ Print.debug("no_model"); return; }
        float[] scal = new float[]{ model.gui_scale_x, model.gui_scale_y, model.gui_scale_z };
        //
        GL11.glPushMatrix();
        {
            switch(type){
                case GROUND: {
                    GL11.glTranslatef(-0.45F, -0.05F, 0);
                    break;
                }
                case FIXED: {
                    //GL11.glRotatef(0, 0, 0, 0);
                    break;
                }
                case THIRD_PERSON_RIGHT_HAND:
                case THIRD_PERSON_LEFT_HAND: {
                    GL11.glRotatef(90F, 0F, 1F, 0F);
                    GL11.glTranslatef(0F, 0, 0F);
                    GL11.glTranslatef(0, 0, 0);
                    break;
                }
                case FIRST_PERSON_LEFT_HAND: {
                    GL11.glRotatef(60f, 0F, 1F, 0F);
                    break;
                }
                case FIRST_PERSON_RIGHT_HAND: {
                    GL11.glRotatef(120f, 0F, 1F, 0F);
                    break;
                }
                case GUI: {
                    GL11.glTranslatef(model.gui_translate_x, model.gui_translate_y, model.gui_translate_z);
                    GL11.glRotatef(-135, 0, 1, 0);
                    GL11.glRotatef(-30, 1, 0, 0);
                    GL11.glRotatef(-30, 0, 0, 1);
                    break;
                }
                case HEAD: {
                    //TODO
                    break;
                }
                default:
                    break;
            }
            //if(PREVIEW){ scal[0] *= 0.5f; scal[1] *= 0.5f; scal[2] *= 0.5f; PREVIEW = false; }
            GL11.glPushMatrix();
            GL11.glScalef(scal[0], scal[1], scal[2]);
            bindTexture(model.bindtex ? data.getCurrentTexture().local() : Resources.WHITE_TEXTURE);
            model.render(RENDERDATA.set(data, null, null, null, true));
            Block block = ((ItemBlock)item.getItem()).getBlock();
            for(IProperty<?> property : block.getBlockState().getProperties()){
                ArrayList<BlockModel> models = state_models.get(property.getName() + "=" + block.getStateFromMeta(item.getMetadata()).getValue(property));
                for(BlockModel mod : models) mod.render(RENDERDATA);
            }
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
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
            bk.rot_meta.setAngles((float)block.getBlockType().getRotationFor(state.getBlock().getMetaFromState(state)), 0, 0);
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