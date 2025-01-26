package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.ColoredVertex;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.fvtm.FvtmLogger;
import net.fexcraft.mod.fvtm.model.*;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.fvtm.model.program.BakedPrograms;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.*;

public class BakedModelImpl implements IBakedModel {

    protected static TreeMap<String, ResourceLocation> tempres = new TreeMap<>();
    protected static HashMap<String, List<BakedQuad>> quads = new HashMap<>();
    //
    protected final ResourceLocation modelloc;
    protected TextureAtlasSprite deftex;
    protected VertexFormat format;
    protected BlockModel model;
    protected ModelImpl root;
    //
    protected Float normal;
    private static BakedPrograms.ColorSetter colorprog = null;

    public BakedModelImpl(ResourceLocation modellocation, ModelImpl state, VertexFormat vformat, BlockModel blockmodel) {
        modelloc = modellocation;
        format = vformat;
        root = state;
        model = blockmodel;
        deftex = root.tex_sprites.get(root.textures.get(0));
        if(root.block.getModelData().has("StaticNormal")){
            normal = root.block.getModelData().get("StaticNormal").float_value();
        }
    }

    public static void clear(){
        tempres.clear();
        quads.clear();
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand){
        String statekey = getStateKey(state);
        if(quads.containsKey(statekey)) return quads.get(statekey);
        List<BakedQuad> newquads = new ArrayList<>();
        try{
            if(model.rootrender) getQuads(model, newquads, state, side, rand);
            if(model.state_models.size() > 0){
                for(IProperty<?> prop : state.getBlock().getBlockState().getProperties()){
                    String str = prop.getName() + "=" + state.getValue(prop);
                    if(model.state_models.containsKey(str)){
                        ArrayList<BlockModel> list = model.state_models.get(str);
                        for(BlockModel statemodel : list){
                            getQuads(statemodel, newquads, state, side, rand);
                        }
                    }
                }
            }
        }
        catch(Throwable thr){
            FvtmLogger.LOGGER.log("BAKING ERROR: " + model.toString() + " (" + model.name + ") / " + statekey);
            for(Object o: root.tex_sprites.keySet()){
                FvtmLogger.LOGGER.log("tex: " + o);
            }
            FvtmLogger.LOGGER.log(thr.getMessage());
            for(StackTraceElement str : thr.getStackTrace()){
                FvtmLogger.LOGGER.log("    " + str.toString());
            }
        }
        quads.put(statekey, newquads);
        BakedModelLoader.reset(model, state, side, rand);
        return newquads;
    }

    private void getQuads(BlockModel model, List<BakedQuad> newquads, IBlockState state, EnumFacing side, long rand){
        ArrayList<ModelGroup> groups = BakedModelLoader.getPolygons(model, state, side, rand);
        BakedModelLoader.convertTransforms(model, root.block, state);
        TextureAtlasSprite sprite = null;
        for(ModelGroup group : groups){
            colorprog = group.getProgram("fvtm:set_color");
            if(model.grouptexname){
                sprite = getTex(root, group.name);
            }
            if(model.tg != null){
                if(model.tg.containsKey(group.name)) sprite = getTex(root, model.tg.get(group.name));
                if(state != null){
                    TextureAtlasSprite nsprite;
                    String str = null;
                    for(IProperty<?> prop : state.getBlock().getBlockState().getProperties()){
                        str = prop.getName() + "=" + state.getValue(prop) + "," + group.name;
                        if(!model.tg.containsKey(str)) continue;
                        nsprite = getTex(root, model.tg.get(str));
                        if(nsprite != null){
                            sprite = nsprite;
                            break;
                        }
                    }
                }
            }
            if(sprite == null) sprite = deftex;
            for(Polyhedron<GLObject> poly : group){
                model.bk.rot_poly.setAngles(-poly.rotY, -poly.rotZ, -poly.rotX);
                for(Polygon poli : poly.polygons){
                    boolean tri = poli.vertices.length == 3;
                    Vec3f vec0 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[0].vector));
                    Vec3f vec1 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[2].vector));
                    Vec3f vec2 = vec1.cross(vec0).normalize();
                    vec2 = model.bk.rot_poly.getRelativeVector(vec2);
                    if(model.defrot) vec2 = model.bk.rot_meta.getRelativeVector(vec2);
                    if(model.bk.rot_tf != null) for(AxisRotator rot : model.bk.rot_tf) vec2 = rot.getRelativeVector(vec2);
                    UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(format);
                    builder.setContractUVs(true);
                    builder.setQuadOrientation(EnumFacing.getFacingFromVector(vec2.x, vec2.y, vec2.z));
                    builder.setTexture(sprite);
                    putVertexData(model, builder, poly, poli.vertices[0], vec2, sprite, colorprog);
                    putVertexData(model, builder, poly, poli.vertices[1], vec2, sprite, colorprog);
                    putVertexData(model, builder, poly, poli.vertices[2], vec2, sprite, colorprog);
                    if(tri) putVertexData(model, builder, poly, poli.vertices[2], vec2, sprite, colorprog);
                    else putVertexData(model, builder, poly, poli.vertices[3], vec2, sprite, colorprog);
                    newquads.add(builder.build());
                }
            }
        }
    }

    public static final String getStateKey(IBlockState state){
        String key = state.getBlock().getRegistryName().toString();
        if(state.getPropertyKeys().size() > 0) key += ",";
        Iterator<IProperty<?>> it = state.getPropertyKeys().iterator();
        while(it.hasNext()){
            IProperty<?> prop = it.next();
            key += prop.getName() + "=" + state.getValue(prop);
            if (it.hasNext()) key += ",";
        }
        if(state instanceof IExtendedBlockState){
            IExtendedBlockState ext = (IExtendedBlockState) state;
            if(key.length() > 0 && ext.getUnlistedNames().size() > 0) key += ",";
            Iterator<IUnlistedProperty<?>> ite = ext.getUnlistedNames().iterator();
            while(ite.hasNext()){
                IUnlistedProperty<?> prop = ite.next();
                key += prop.getName() + "=" + ext.getValue(prop);
                if (ite.hasNext()) key += ",";
            }
        }
        return key;
    }

    private TextureAtlasSprite getTex(ModelImpl root, String name){
        for(NamedResourceLocation resloc : root.textures){
            if(resloc.getName().equals(name)) return root.tex_sprites.get(resloc);
        }
        if(!tempres.containsKey(name)){
            tempres.put(name, new ResourceLocation(name));
        }
        return root.tex_sprites.get(tempres.get(name));
    }

    private void putVertexData(BlockModel model, UnpackedBakedQuad.Builder builder, Polyhedron<GLObject> poly, Vertex vert, Vec3f norm, TextureAtlasSprite texture, BakedPrograms.ColorSetter colorprog){
        for(int e = 0; e < format.getElementCount(); e++){
            switch(format.getElement(e).getUsage()){
                case POSITION:
                    Vec3f vec = model.bk.rot_poly.getRelativeVector(vert.vector).add(poly.posX, poly.posY, poly.posZ);
                    if(model.defrot) vec = model.bk.rot_meta.getRelativeVector(vec);
                    if(model.bk.rot_tf != null) for(AxisRotator rot : model.bk.rot_tf) vec = rot.getRelativeVector(vec);
                    builder.put(e,
                            vec.x * model.bk.scale.x + model.bk.translate.x + 0.5f,
                            vec.y * model.bk.scale.y + model.bk.translate.y,
                            vec.z * model.bk.scale.z + model.bk.translate.z + 0.5f, 1);
                    break;
                case COLOR:
                    boolean set = false;
                    if(vert instanceof ColoredVertex){
                        Vec3f color = vert.color();
                        if(color.x != 1f || color.y != 1f || color.z != 1f){
                            builder.put(e, color.x, color.y, color.z, 1f);
                            set = true;
                        }
                    }
                    if(!set && colorprog != null){
                        float[] arr = colorprog.color;
                        builder.put(e, arr[0], arr[1], arr[2], 1f);
                        set = true;
                    }
                    /*if(!set && EnvInfo.DEV){
                        float[] arr = RGB.random().toFloatArray();
                        builder.put(e, arr[0], arr[1], arr[2], 1f);
                        set = true;
                    }*/
                    if(!set) builder.put(e, 1, 1, 1, 1);
                    break;
                case UV:
                    if(!poly.glObj.textured){
                        builder.put(e, texture.getInterpolatedU(0), texture.getInterpolatedV(0), 0, 1);
                    }
                    else{
                        builder.put(e, texture.getInterpolatedU(vert.u * 16), texture.getInterpolatedV(vert.v * 16), 0, 1);
                    }
                    break;
                case NORMAL:
                    if(normal != null){
                        builder.put(e, normal, normal, normal, 0);
                    }
                    else builder.put(e, norm.x, norm.y, norm.z, 0);
                    break;
                default:
                    builder.put(e);
                    break;
            }
        }
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms(){
        return ItemCameraTransforms.DEFAULT;
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType perspective){
        return Pair.of(this, null);
    }

    @Override
    public boolean isBuiltInRenderer(){
        return true;
    }

    @Override
    @Nonnull
    public TextureAtlasSprite getParticleTexture(){
        return root.particle == null ? deftex : root.particle;
    }

    @Override
    @Nonnull
    public ItemOverrideList getOverrides(){
        return OverrideList.INSTANCE;
    }

    @Override
    public boolean isGui3d(){
        return true;
    }

    @Override
    public boolean isAmbientOcclusion(){
        return root.ambocl;
    }

}
