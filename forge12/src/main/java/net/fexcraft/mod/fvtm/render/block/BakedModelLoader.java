package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.mc.utils.Axis3DL;
import net.fexcraft.mod.fvtm.data.block.BlockData;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;

public class BakedModelLoader {
	
	public static void register(){
		net.minecraftforge.client.model.ModelLoaderRegistry.registerLoader(net.fexcraft.mod.fvtm.render.block.FvtmBlockModelLoader.getInstance());
	}

	public static ArrayList<ModelGroup> getPolygons(BlockModel model, IBlockState state, EnumFacing side, ModelData data, long rand){
        ArrayList<ModelGroup> list = new ArrayList<>();
		for(ModelGroup group : model.groups){
            if(group.has_pre_prog){
                for(Program program : group.getPrePrograms()) program.pre(group, DefaultModel.RENDERDATA.set(null, null, null, state, false));
            }
            if(!group.visible) continue;
            list.add(group);
        }
		return list;
	}

    public static void reset(BlockModel model, IBlockState state, EnumFacing side, ModelData data, long rand){
        for(ModelGroup group : model.groups){
            if(group.has_pst_prog){
                for(Program program : group.getPstPrograms()) program.post(group, DefaultModel.RENDERDATA.set((BlockData)null, null, null, state, false));
            }
        }
        model.bk = null;
    }

    public static void convertTransforms(BlockModel model, net.fexcraft.mod.fvtm.data.block.Block block, IBlockState state){
        model.bk = new BlockModel.BakedTransformData();
        model.bk.rot_poly = new Axis3DL();
        model.bk.rot_meta = new Axis3DL();
        if(state != null){
            model.bk.rot_meta.setAngles(-(float)block.getBlockType().getRotationFor(state.getBlock().getMetaFromState(state)), 0, 0);
        }
        if(model.transforms.hasRotate()){
            ArrayList<Transforms.TF_Rotate> list = model.transforms.getBakedRotate();
            model.bk.rot_tf = new AxisRotator[list.size()];
            for(int i = 0; i < list.size(); i++){
                Transforms.TF_Rotate rot = list.get(i);
                model.bk.rot_tf[i] = AxisRotator.newDefInstance();
                model.bk.rot_tf[i].setAngles(rot.y * rot.angle, rot.z * rot.angle, rot.x * rot.angle);
            }
        }
        if(model.transforms.hasTranslate()){
            model.bk.translate = model.transforms.getBakedTranslate();
        }
        else model.bk.translate = new Vec3f();
        if(model.transforms.hasScale()){
            model.bk.scale = model.transforms.getBakedScale();
        }
        else model.bk.scale = new Vec3f(1, 1, 1);
        //
        for(ArrayList<BlockModel> val : model.state_models.values()){
            for(BlockModel v : val) convertTransforms(v, block, state);
        }
    }

}
