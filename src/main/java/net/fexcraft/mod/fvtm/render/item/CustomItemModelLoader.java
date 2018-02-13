package net.fexcraft.mod.fvtm.render.item;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import org.apache.commons.lang3.tuple.Pair;

import net.fexcraft.mod.fvtm.api.Addon;
import net.fexcraft.mod.fvtm.util.Resources;
import net.fexcraft.mod.fvtm.util.config.Config;
import net.fexcraft.mod.lib.util.common.Print;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

public class CustomItemModelLoader implements ICustomModelLoader {
	
	public static final CustomItemModelLoader INSTANCE = new CustomItemModelLoader();
	
	public CustomItemModelLoader(){
		//
	}

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager){
		//
	}

	@Override
	public boolean accepts(ResourceLocation modelloc){
		if(!Config.RENDER_IN_GUI){
			return false;
		}
		//Till we get a fall-back loader working, disable custom models completely.
		String domain = modelloc.getResourceDomain();
		boolean yes = domain.equals("fvtm") || domain.equals("minecraft");
		if(!yes){
			for(Addon addon : Resources.ADDONS.getValues()){
				if(domain.equals(addon.getRegistryName().getResourcePath())){
					yes = true;
					break;
				}
			}
		}
		ResourceLocation resloc = new ResourceLocation(modelloc.toString().replace("models/item/", ""));
		return yes && (Resources.VEHICLES.containsKey(resloc) || Resources.CONTAINERS.containsKey(resloc));
	}

	@Override
	public IModel loadModel(ResourceLocation modelloc) throws Exception {
		return new IconBasedModel(modelloc);
	}
	
	private static class IconBasedModel implements IModel {
		
		private final ResourceLocation modelLocation;
		
		private IconBasedModel(ResourceLocation modelLocation){
			this.modelLocation = modelLocation;
		}
		
		@Override
		public Collection<ResourceLocation> getDependencies(){
			return Collections.emptyList();
		}

		@Override
		public IModelState getDefaultState(){
			return new OverrideModelState();
		}

		@Override
		public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter){
			return new BakedIconBasedModel(modelLocation, bakedTextureGetter, new OverrideModelState());
		}

		@Override
		public Collection<ResourceLocation> getTextures(){
			return Collections.singleton(modelLocation);
		}

	}
	
	static class BakedIconBasedModel implements IBakedModel {

		private final OverrideModelState state;
		private final ResourceLocation modelLocation;
		private final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter;
		private IBakedModel cache2D = null;

		private BakedIconBasedModel(ResourceLocation modelLocation, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter, OverrideModelState state){
			this.modelLocation = modelLocation;
			this.bakedTextureGetter = bakedTextureGetter;
			this.state = state;
			
		}

		@Override @Nonnull
		public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand){
			return Collections.emptyList();
		}

		@Override @Nonnull
		public ItemCameraTransforms getItemCameraTransforms(){
			return ItemCameraTransforms.DEFAULT;
		}
		
		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType perspective){
			RenderCustomItem renderer = RenderCustomItem.INSTANCE;
			if(perspective == TransformType.GUI && !Config.RENDER_IN_GUI){
				if(cache2D == null){
					try{
						IModel model = ModelLoaderRegistry.getModel(modelLocation);
						cache2D = model.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM, bakedTextureGetter);
					}
					catch(Exception e){
						//e.printStackTrace();
						Print.log(e.getMessage());
					}
				}
				return Pair.of(cache2D == null ? this : cache2D, null);
			}
			else{
				//renderer.renderPerspective(perspective, state.entity, state.stack, state.world);
				renderer.renderItem(perspective, state.stack, state.entity);
			}
			return Pair.of(this, null);
		}

		@Override
		public boolean isBuiltInRenderer(){
			return false;
		}

		@Override @Nonnull
		public TextureAtlasSprite getParticleTexture(){
			return ModelLoader.White.INSTANCE;
		}

		@Override @Nonnull
		public ItemOverrideList getOverrides(){
			return CustomModelOverrideList.INSTANCE;
		}

		@Override
		public boolean isGui3d(){
			return Config.RENDER_IN_GUI;
		}

		@Override
		public boolean isAmbientOcclusion(){
			return false;
		}

		public OverrideModelState getState(){
			return state;
		}
	}
	
	public static class OverrideModelState implements IModelState {
		
		private ItemStack stack;
		private EntityLivingBase entity;

		public void setStack(ItemStack stack){
			this.stack = stack;
		}

		public void setEntity(EntityLivingBase entity){
			this.entity = entity;
		}

		@Override
		public Optional<TRSRTransformation> apply(Optional<? extends IModelPart> part){
			return Optional.empty();
		}
		
	}
	
}