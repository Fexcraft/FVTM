package net.fexcraft.mod.fvtm.render.block;

import com.google.common.collect.ImmutableMap;
import net.fexcraft.app.json.JsonHandler;
import net.fexcraft.app.json.JsonMap;
import net.fexcraft.mod.fvtm.FvtmRegistry;
import net.fexcraft.mod.fvtm.FvtmResources;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_LINES;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_MARKER4;
import net.fexcraft.mod.fvtm.block.generated.G_ROAD_PATTERN;
import net.fexcraft.mod.fvtm.data.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.minecraftforge.common.model.IModelState;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;

import static net.fexcraft.lib.common.Static.sixteenth;
import static net.fexcraft.mod.fvtm.block.generated.FvtmProperties.*;
import static net.fexcraft.mod.fvtm.model.block.BakedQuadData.*;
import static net.fexcraft.mod.fvtm.model.block.BakedQuadData.quad;

/**
 * @author Ferdinand Calo' (FEX___96)
 */
public class RoadLinesModelLoader implements ICustomModelLoader {

	public static RoadLinesModelLoader INSTANCE = new RoadLinesModelLoader();
	public static final Map<String, Block> BLOCKS = new HashMap<>();

	@Override
	public void onResourceManagerReload(IResourceManager resman){

	}

	@Override
	public boolean accepts(ResourceLocation loc){
		String str = loc.toString();
		if(!str.contains("/") && !str.endsWith("#inventory")){
			return BLOCKS.containsKey(str.split("#")[0]);
		}
		return BLOCKS.containsKey(str);
	}

	@Override
	public IModel loadModel(ResourceLocation loc) throws Exception{
		return new LineModel(loc);
	}

	public static class BakedModel implements IBakedModel {

		private VertexFormat vertform;
		private LineModel root;

		public BakedModel(LineModel model, VertexFormat format){
			this.vertform = format;
			this.root = model;
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand){
			int hei = state == null ? 0 : state.getValue(HEIGHT);
			boolean hl = state.getBlock() instanceof G_ROAD_LINES;
			double[][] uv = uv_full;
			if(hl){
				int lines = state.getValue(LINE_TYPE);
				int rot = state.getValue(LINE_ROT);
				switch(lines){
					case 0: uv = uv_ls2[rot]; break;
					case 1: uv = uv_lc2[rot]; break;
					case 2: uv = uv_l3[rot]; break;
					case 3: uv = uv_lf; break;
				};
			}
			else if(state.getBlock() instanceof G_ROAD_MARKER4){
				EnumFacing dir = state.getValue(FACING);
				for(int i = 0; i < dir.getHorizontalIndex(); i++) uv = rotateL(uv);
			}
			else if(state.getBlock() instanceof G_ROAD_PATTERN){
				G_ROAD_PATTERN blk = (G_ROAD_PATTERN)state.getBlock();
				int x = state.getValue(blk.prop_x);
				int z = state.getValue(blk.prop_z);
				float us = 16f / blk.texx;
				float vs = 16f / blk.texz;
				uv = new double[][]{
					{ us * x + us,  vs * z },
					{ us * x,  vs * z },
					{ us * x,  vs * z + vs },
					{ us * x + us,  vs * z + vs }
				};
				EnumFacing dir = state.getValue(FACING);
				uv = rotateU(uv);
				for(int i = 0; i < dir.getHorizontalIndex(); i++) uv = rotateL(uv);
			}
			List<BakedQuad> quads = new ArrayList<>();
			UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(vertform);
			builder.setContractUVs(true);
			builder.setQuadOrientation(EnumFacing.UP);
			builder.setTexture(root.sprite);
			putVertexData(builder, quad[0], hei, uv[0][0], uv[0][1]);
			putVertexData(builder, quad[1], hei, uv[1][0], uv[1][1]);
			putVertexData(builder, quad[2], hei, uv[2][0], uv[2][1]);
			putVertexData(builder, quad[3], hei, uv[3][0], uv[3][1]);
			quads.add(builder.build());
			return quads;
		}

		private void putVertexData(UnpackedBakedQuad.Builder builder, double[] vec, int hei, double u, double v){
			for(int e = 0; e < vertform.getElementCount(); e++){
				switch(vertform.getElement(e).getUsage()){
					case POSITION:
						builder.put(e, (float)vec[0], (float)(vec[1] - hei * sixteenth), (float)vec[2]);
						break;
					case COLOR:
					case NORMAL:
						builder.put(e, 1f, 1f, 1f, 1f);
						break;
					case UV:
						builder.put(e, root.sprite.getInterpolatedU(u), root.sprite.getInterpolatedV(v), 0, 1);
						break;
					default:
						builder.put(e);
						break;
				}
			}
		}

		@Override
		public boolean isAmbientOcclusion(){
			return root.ambocl;
		}

		@Override
		public boolean isGui3d(){
			return false;
		}

		@Override
		public boolean isBuiltInRenderer(){
			return false;
		}

		@Override
		public TextureAtlasSprite getParticleTexture(){
			return root.particle;
		}

		@Override
		public ItemOverrideList getOverrides(){
			return OverrideList.INSTANCE;
		}

	}

	public static class LineModel implements IModel {

		protected List<ResourceLocation> texs = new ArrayList<>();
		protected TextureAtlasSprite particle;
		protected TextureAtlasSprite sprite;
		protected ResourceLocation tex, par;
		protected boolean ambocl;

		public LineModel(ResourceLocation rs) throws IOException {
			String bid = rs.toString();
			if(bid.contains("/")) bid = bid.split(":")[0] + ":" + bid.substring(bid.lastIndexOf("/"));
			if(bid.contains("#")) bid = bid.substring(0, bid.indexOf("#"));
			Block block = FvtmRegistry.BLOCKS.get(bid);
			ambocl = block.getModelData().getBoolean("AmbientOcclusion", false);
			Object[] str = FvtmResources.getAssetInputStreamWithFallback(block.getID().space() + ":models/block/" + block.getID().path() + ".json");
			JsonMap map = JsonHandler.parse((InputStream)str[0]).asMap().getMap("textures");
			tex = new ResourceLocation(map.getString("texture", "fvtm:block/asphalt"));
			par = new ResourceLocation(map.getString("particle", "fvtm:block/asphalt"));
			texs.add(tex);
			texs.add(par);
			for(int i = 1; i < str.length; i++) ((InputStream)str[i]).close();
		}

		@Override
		public Collection<ResourceLocation> getDependencies(){
			return Collections.emptyList();
		}

		@Override
		public IModelState getDefaultState(){
			return ModelImpl.default_state;
		}

		@Override
		public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> func) {
			sprite = func.apply(tex);
			particle = func.apply(par);
			return new BakedModel(this, format);
		}

		@Override
		public Collection<ResourceLocation> getTextures(){
			return texs;
		}

		@Override
		public IModel process(ImmutableMap<String, String> data){
			return this;
		}

	}

}
