package net.fexcraft.mod.fvtm.render.block;

import net.fexcraft.lib.common.math.RGB;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;
import net.fexcraft.lib.frl.ColoredVertex;
import net.fexcraft.lib.frl.Polygon;
import net.fexcraft.lib.frl.Polyhedron;
import net.fexcraft.lib.frl.Vertex;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.lib.mc.utils.Axis3DL;
import net.fexcraft.lib.mc.utils.Print;
import net.fexcraft.lib.mc.utils.Static;
import net.fexcraft.lib.tmt.ModelRendererTurbo;
import net.fexcraft.mod.fvtm.model.*;
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
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.*;

import static net.fexcraft.lib.common.Static.sixteenth;

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
    protected Vec3f translate;
    protected Vec3f scale;
    protected Axis3DL axis0, axis1;
    protected Float normal;

    public BakedModelImpl(ResourceLocation modellocation, ModelImpl state, VertexFormat vformat, BlockModel blockmodel) {
        modelloc = modellocation;
        format = vformat;
        root = state;
        model = blockmodel;
        deftex = root.tex_sprites.values().toArray(new TextureAtlasSprite[0])[0];
        normal = root.block.getModelData().contains("StaticNormal") ? root.block.getModelData().get("StaticNormal") : null;
    }

    public static void clear(){
        tempres.clear();
        quads.clear();
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand) {
        String statekey = getStateKey(state);
        if(quads.containsKey(statekey)) return quads.get(statekey);
        List<BakedQuad> newquads = new ArrayList<>();
        axis0 = new Axis3DL();
        axis1 = new Axis3DL();
        translate = new Vec3f();
        //
        if(model.transforms.hasRotate()){
            Vec3f rot = model.transforms.getBakedRotate();
            axis1.setAngles(rot.y, rot.z, rot.x);
        }
        if(model.transforms.hasTranslate()){
            translate = model.transforms.getBakedTranslate();
        }
        else translate = new Vec3f();
        if(model.transforms.hasScale()){
            scale = model.transforms.getBakedScale();
        }
        else scale = new Vec3f(sixteenth, sixteenth, sixteenth);
        ModelGroupList groups = model.getPolygons(state, side, root.block.getModelData(), rand);
        //
        BakedPrograms.TextureSetter texprog = null;
        try{
            for(ModelGroup group : groups){
                texprog = group.getProgram("fvtm:set_texture");
                TextureAtlasSprite sprite = texprog == null ? deftex : getTex(root, texprog.texture);
                for(Polyhedron<GLObject> poly : group){
                    axis0.setAngles(-poly.rotY, -poly.rotZ, -poly.rotX);
                    for(Polygon poli : poly.polygons){
                        if(poli.vertices.length != 0){
                            continue;//TODO
                        }
                        Vec3f vec0 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[0].vector));
                        Vec3f vec1 = new Vec3f(poli.vertices[1].vector.sub(poli.vertices[2].vector));
                        Vec3f vec2 = vec1.cross(vec0).normalize();
                        vec2 = axis1.getRelativeVector(axis0.getRelativeVector(vec2));
                        UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(format);
                        builder.setContractUVs(true);
                        builder.setQuadOrientation(EnumFacing.getFacingFromVector(vec2.x, vec2.y, vec2.z));
                        builder.setTexture(sprite);
                        putVertexData(builder, poly, poli.vertices[0], vec2, OBJModel.TextureCoordinate.getDefaultUVs()[0], sprite);
                        putVertexData(builder, poly, poli.vertices[1], vec2, OBJModel.TextureCoordinate.getDefaultUVs()[1], sprite);
                        putVertexData(builder, poly, poli.vertices[2], vec2, OBJModel.TextureCoordinate.getDefaultUVs()[2], sprite);
                        putVertexData(builder, poly, poli.vertices[3], vec2, OBJModel.TextureCoordinate.getDefaultUVs()[3], sprite);
                        newquads.add(builder.build());
                    }
                }
            }
        }
        catch(Throwable thr){
            thr.printStackTrace();
        }
        quads.put(statekey, newquads);
        model.reset(state, side, root.block.getModelData(), rand);
        return newquads;
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

    private void putVertexData(UnpackedBakedQuad.Builder builder, Polyhedron<GLObject> poly, Vertex vert, Vec3f norm, OBJModel.TextureCoordinate texcoord, TextureAtlasSprite texture){
        for(int e = 0; e < format.getElementCount(); e++){
            switch(format.getElement(e).getUsage()){
                case POSITION:
                    Vec3f vec = axis0.getRelativeVector(vert.vector);
                    vec = axis1.getRelativeVector(vec.add(poly.posX, poly.posY, poly.posZ));
                    builder.put(e, vec.x * scale.x + translate.x, vec.y * scale.y + translate.y, vec.z * scale.z + translate.z, 1);
                    break;
                case COLOR:
                    if(vert instanceof ColoredVertex){
                        ColoredVertex cvert = (ColoredVertex) vert;
                        builder.put(e, cvert.color().x, cvert.color().y, cvert.color().z, 1f);
                    }
                    else{
                        //float[] arr = RGB.random().toFloatArray();
                        //builder.put(e, arr[0], arr[1], arr[2], arr[3]);
                        builder.put(e, 1, 1, 1, 1);
                    }
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
