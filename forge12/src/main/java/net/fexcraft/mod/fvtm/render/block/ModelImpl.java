package net.fexcraft.mod.fvtm.render.block;

import com.google.common.collect.ImmutableMap;
import net.fexcraft.lib.mc.registry.NamedResourceLocation;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.fexcraft.mod.fvtm.model.content.BlockModel;
import net.fexcraft.mod.uni.IDL;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import java.util.*;
import java.util.function.Function;

import static net.fexcraft.mod.fvtm.render.block.FvtmBlockModelLoader.MODELS;

class ModelImpl implements IModel {

    protected final ResourceLocation modelloc;
    protected BlockModel model;
    protected Block block;
    protected boolean ambocl;
    //
    protected HashMap<NamedResourceLocation, TextureAtlasSprite> tex_sprites = new HashMap<>();
    protected ArrayList<NamedResourceLocation> textures;
    protected ArrayList<ResourceLocation> copy;
    protected TextureAtlasSprite particle;
    //
    protected static final IModelState default_state = new IModelState() {
        @Override
        public Optional<TRSRTransformation> apply(Optional<? extends IModelPart> part){
            return Optional.empty();
        }
    };

    public ModelImpl(ResourceLocation rs){
        modelloc = rs;
        MODELS.put(rs, this);
        block = FvtmBlockModelLoader.BLOCKS.get(rs.toString());
        model = (BlockModel)block.getModel();
        ambocl = block.getModelData().getBoolean("AmbientOcclusion", false);
        getTexturesFromBlock();
    }

    private void getTexturesFromBlock(){
        ArrayList<NamedResourceLocation> list = new ArrayList<>();
        for(IDL idl : block.getDefaultTextures()){
            String path = idl.path();
            if(idl.path().startsWith("textures/")){
                path = path.substring("textures/".length());
            }
            if(idl.path().endsWith(".png")){
                path = path.substring(0, path.lastIndexOf("."));
            }
            list.add(new NamedResourceLocation(idl.name(), idl.space(), path));
        }
        if(list.size() == 0){
            String str = modelloc.toString().replace("models/block", "block");
            if(str.contains(".")) str = str.substring(0, str.indexOf("."));
            list.add(new NamedResourceLocation("main;" + str));
        }
        textures = list;
        copy = new ArrayList<>(textures);
    }

    @Override
    public Collection<ResourceLocation> getDependencies(){
        return Collections.emptyList();
    }

    @Override
    public IModelState getDefaultState(){
        return default_state;
    }

    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> func) {
        for(NamedResourceLocation loc : textures){
            tex_sprites.put(loc, func.apply(loc));
            if(loc.getName().equals("particle")) particle = tex_sprites.get(loc);
        }
        return new BakedModelImpl(modelloc, this, format, model);
    }

    @Override
    public Collection<ResourceLocation> getTextures(){
        return copy;
    }

    @Override
    public IModel process(ImmutableMap<String, String> data){
        return this;
    }

}
